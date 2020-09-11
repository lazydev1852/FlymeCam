package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

public class SerializeConfig {
    private static boolean awtError = false;
    public static final SerializeConfig globalInstance = new SerializeConfig();
    private static boolean guavaError = false;
    private static boolean jdk8Error = false;
    private static boolean oracleJdbcError = false;
    private static boolean springfoxError = false;
    private boolean asm;
    private ASMSerializerFactory asmFactory;
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<Type, ObjectSerializer> serializers;
    protected String typeKey;

    public String getTypeKey() {
        return this.typeKey;
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }

    private final JavaBeanSerializer createASMSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        JavaBeanSerializer createJavaBeanSerializer = this.asmFactory.createJavaBeanSerializer(serializeBeanInfo);
        for (FieldSerializer fieldSerializer : createJavaBeanSerializer.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (cls.isEnum() && !(getObjectWriter(cls) instanceof EnumSerializer)) {
                createJavaBeanSerializer.writeDirect = false;
            }
        }
        return createJavaBeanSerializer;
    }

    private final ObjectSerializer createJavaBeanSerializer(Class<?> cls) {
        SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, (Map<String, String>) null, this.propertyNamingStrategy);
        if (buildBeanInfo.fields.length != 0 || !Iterable.class.isAssignableFrom(cls)) {
            return createJavaBeanSerializer(buildBeanInfo);
        }
        return MiscCodec.instance;
    }

    public ObjectSerializer createJavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        JSONType jSONType = serializeBeanInfo.jsonType;
        boolean z = false;
        if (jSONType != null) {
            Class<?> serializer = jSONType.serializer();
            if (serializer != Void.class) {
                try {
                    Object newInstance = serializer.newInstance();
                    if (newInstance instanceof ObjectSerializer) {
                        return (ObjectSerializer) newInstance;
                    }
                } catch (Throwable unused) {
                }
            }
            if (!jSONType.asm()) {
                this.asm = false;
            }
        }
        Class<?> cls = serializeBeanInfo.beanType;
        if (!Modifier.isPublic(serializeBeanInfo.beanType.getModifiers())) {
            return new JavaBeanSerializer(serializeBeanInfo);
        }
        boolean z2 = this.asm;
        if ((z2 && this.asmFactory.classLoader.isExternalClass(cls)) || cls == Serializable.class || cls == Object.class) {
            z2 = false;
        }
        if (z2 && !ASMUtils.checkName(cls.getSimpleName())) {
            z2 = false;
        }
        if (z2) {
            FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
            int length = fieldInfoArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    JSONField annotation = fieldInfoArr[i].getAnnotation();
                    if (annotation != null && (!ASMUtils.checkName(annotation.name()) || annotation.format().length() != 0 || annotation.jsonDirect() || annotation.serializeUsing() != Void.class)) {
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        z = z2;
        if (z) {
            try {
                JavaBeanSerializer createASMSerializer = createASMSerializer(serializeBeanInfo);
                if (createASMSerializer != null) {
                    return createASMSerializer;
                }
            } catch (ClassCastException | ClassFormatError unused2) {
            } catch (Throwable th) {
                throw new JSONException("create asm serializer error, class " + cls, th);
            }
        }
        return new JavaBeanSerializer(serializeBeanInfo);
    }

    public boolean isAsmEnable() {
        return this.asm;
    }

    public void setAsmEnable(boolean z) {
        if (!ASMUtils.IS_ANDROID) {
            this.asm = z;
        }
    }

    public static SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    public SerializeConfig() {
        this(1024);
    }

    public SerializeConfig(int i) {
        this.asm = !ASMUtils.IS_ANDROID;
        this.typeKey = JSON.DEFAULT_TYPE_KEY;
        this.serializers = new IdentityHashMap<>(1024);
        try {
            if (this.asm) {
                this.asmFactory = new ASMSerializerFactory();
            }
        } catch (NoClassDefFoundError unused) {
            this.asm = false;
        } catch (ExceptionInInitializerError unused2) {
            this.asm = false;
        }
        put((Type) Boolean.class, (ObjectSerializer) BooleanCodec.instance);
        put((Type) Character.class, (ObjectSerializer) CharacterCodec.instance);
        put((Type) Byte.class, (ObjectSerializer) IntegerCodec.instance);
        put((Type) Short.class, (ObjectSerializer) IntegerCodec.instance);
        put((Type) Integer.class, (ObjectSerializer) IntegerCodec.instance);
        put((Type) Long.class, (ObjectSerializer) LongCodec.instance);
        put((Type) Float.class, (ObjectSerializer) FloatCodec.instance);
        put((Type) Double.class, (ObjectSerializer) DoubleSerializer.instance);
        put((Type) BigDecimal.class, (ObjectSerializer) BigDecimalCodec.instance);
        put((Type) BigInteger.class, (ObjectSerializer) BigIntegerCodec.instance);
        put((Type) String.class, (ObjectSerializer) StringCodec.instance);
        put((Type) byte[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) short[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) int[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) long[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) float[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) double[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) boolean[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) char[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) Object[].class, (ObjectSerializer) ObjectArrayCodec.instance);
        put((Type) Class.class, (ObjectSerializer) MiscCodec.instance);
        put((Type) SimpleDateFormat.class, (ObjectSerializer) MiscCodec.instance);
        put((Type) Currency.class, (ObjectSerializer) new MiscCodec());
        put((Type) TimeZone.class, (ObjectSerializer) MiscCodec.instance);
        put((Type) InetAddress.class, (ObjectSerializer) MiscCodec.instance);
        put((Type) Inet4Address.class, (ObjectSerializer) MiscCodec.instance);
        put((Type) Inet6Address.class, (ObjectSerializer) MiscCodec.instance);
        put((Type) InetSocketAddress.class, (ObjectSerializer) MiscCodec.instance);
        put((Type) File.class, (ObjectSerializer) MiscCodec.instance);
        put((Type) Appendable.class, (ObjectSerializer) AppendableSerializer.instance);
        put((Type) StringBuffer.class, (ObjectSerializer) AppendableSerializer.instance);
        put((Type) StringBuilder.class, (ObjectSerializer) AppendableSerializer.instance);
        put((Type) Charset.class, (ObjectSerializer) ToStringSerializer.instance);
        put((Type) Pattern.class, (ObjectSerializer) ToStringSerializer.instance);
        put((Type) Locale.class, (ObjectSerializer) ToStringSerializer.instance);
        put((Type) URI.class, (ObjectSerializer) ToStringSerializer.instance);
        put((Type) URL.class, (ObjectSerializer) ToStringSerializer.instance);
        put((Type) UUID.class, (ObjectSerializer) ToStringSerializer.instance);
        put((Type) AtomicBoolean.class, (ObjectSerializer) AtomicCodec.instance);
        put((Type) AtomicInteger.class, (ObjectSerializer) AtomicCodec.instance);
        put((Type) AtomicLong.class, (ObjectSerializer) AtomicCodec.instance);
        put((Type) AtomicReference.class, (ObjectSerializer) ReferenceCodec.instance);
        put((Type) AtomicIntegerArray.class, (ObjectSerializer) AtomicCodec.instance);
        put((Type) AtomicLongArray.class, (ObjectSerializer) AtomicCodec.instance);
        put((Type) WeakReference.class, (ObjectSerializer) ReferenceCodec.instance);
        put((Type) SoftReference.class, (ObjectSerializer) ReferenceCodec.instance);
    }

    public void addFilter(Class<?> cls, SerializeFilter serializeFilter) {
        ObjectSerializer objectWriter = getObjectWriter(cls);
        if (objectWriter instanceof SerializeFilterable) {
            SerializeFilterable serializeFilterable = (SerializeFilterable) objectWriter;
            if (this == globalInstance || serializeFilterable != MapSerializer.instance) {
                serializeFilterable.addFilter(serializeFilter);
                return;
            }
            MapSerializer mapSerializer = new MapSerializer();
            put((Type) cls, (ObjectSerializer) mapSerializer);
            mapSerializer.addFilter(serializeFilter);
        }
    }

    public void config(Class<?> cls, SerializerFeature serializerFeature, boolean z) {
        ObjectSerializer objectWriter = getObjectWriter(cls, false);
        if (objectWriter == null) {
            SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, (Map<String, String>) null, this.propertyNamingStrategy);
            if (z) {
                buildBeanInfo.features = serializerFeature.mask | buildBeanInfo.features;
            } else {
                buildBeanInfo.features = (~serializerFeature.mask) & buildBeanInfo.features;
            }
            put((Type) cls, createJavaBeanSerializer(buildBeanInfo));
        } else if (objectWriter instanceof JavaBeanSerializer) {
            SerializeBeanInfo serializeBeanInfo = ((JavaBeanSerializer) objectWriter).beanInfo;
            int i = serializeBeanInfo.features;
            if (z) {
                serializeBeanInfo.features = serializerFeature.mask | serializeBeanInfo.features;
            } else {
                serializeBeanInfo.features = (~serializerFeature.mask) & serializeBeanInfo.features;
            }
            if (i != serializeBeanInfo.features && objectWriter.getClass() != JavaBeanSerializer.class) {
                put((Type) cls, createJavaBeanSerializer(serializeBeanInfo));
            }
        }
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        return getObjectWriter(cls, true);
    }

    private ObjectSerializer getObjectWriter(Class<?> cls, boolean z) {
        ClassLoader classLoader;
        ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer == null) {
            try {
                for (AutowiredObjectSerializer next : ServiceLoader.load(AutowiredObjectSerializer.class, Thread.currentThread().getContextClassLoader())) {
                    if (next instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowiredObjectSerializer = next;
                        for (Type put : autowiredObjectSerializer.getAutowiredFor()) {
                            put(put, (ObjectSerializer) autowiredObjectSerializer);
                        }
                    }
                }
            } catch (ClassCastException unused) {
            }
            objectSerializer = this.serializers.get(cls);
        }
        if (objectSerializer == null && (classLoader = JSON.class.getClassLoader()) != Thread.currentThread().getContextClassLoader()) {
            try {
                for (AutowiredObjectSerializer next2 : ServiceLoader.load(AutowiredObjectSerializer.class, classLoader)) {
                    if (next2 instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowiredObjectSerializer2 = next2;
                        for (Type put2 : autowiredObjectSerializer2.getAutowiredFor()) {
                            put(put2, (ObjectSerializer) autowiredObjectSerializer2);
                        }
                    }
                }
            } catch (ClassCastException unused2) {
            }
            objectSerializer = this.serializers.get(cls);
        }
        if (objectSerializer != null) {
            return objectSerializer;
        }
        if (Map.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) MapSerializer.instance);
        } else if (List.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) ListSerializer.instance);
        } else if (Collection.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) CollectionCodec.instance);
        } else if (Date.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) DateCodec.instance);
        } else if (JSONAware.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) JSONAwareSerializer.instance);
        } else if (JSONSerializable.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) JSONSerializableSerializer.instance);
        } else if (JSONStreamAware.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) MiscCodec.instance);
        } else if (cls.isEnum() || (cls.getSuperclass() != null && cls.getSuperclass().isEnum())) {
            JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
            if (jSONType == null || !jSONType.serializeEnumAsJavaBean()) {
                put((Type) cls, (ObjectSerializer) EnumSerializer.instance);
            } else {
                put((Type) cls, createJavaBeanSerializer(cls));
            }
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            put((Type) cls, (ObjectSerializer) new ArraySerializer(componentType, getObjectWriter(componentType)));
        } else if (Throwable.class.isAssignableFrom(cls)) {
            SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, (Map<String, String>) null, this.propertyNamingStrategy);
            buildBeanInfo.features |= SerializerFeature.WriteClassName.mask;
            put((Type) cls, (ObjectSerializer) new JavaBeanSerializer(buildBeanInfo));
        } else if (TimeZone.class.isAssignableFrom(cls) || Map.Entry.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) MiscCodec.instance);
        } else if (Appendable.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) AppendableSerializer.instance);
        } else if (Charset.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) ToStringSerializer.instance);
        } else if (Enumeration.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) EnumerationSerializer.instance);
        } else if (Calendar.class.isAssignableFrom(cls) || XMLGregorianCalendar.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) CalendarCodec.instance);
        } else if (Clob.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) ClobSeriliazer.instance);
        } else if (TypeUtils.isPath(cls)) {
            put((Type) cls, (ObjectSerializer) ToStringSerializer.instance);
        } else if (Iterator.class.isAssignableFrom(cls)) {
            put((Type) cls, (ObjectSerializer) MiscCodec.instance);
        } else {
            String name = cls.getName();
            if (!name.startsWith("java.awt.") || !AwtCodec.support(cls)) {
                if (!jdk8Error && (name.startsWith("java.time.") || name.startsWith("java.util.Optional"))) {
                    try {
                        put((Type) Class.forName("java.time.LocalDateTime"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.time.LocalDate"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.time.LocalTime"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.time.ZonedDateTime"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.time.OffsetDateTime"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.time.OffsetTime"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.time.ZoneOffset"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.time.ZoneRegion"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.time.Period"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.time.Duration"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.time.Instant"), (ObjectSerializer) Jdk8DateCodec.instance);
                        put((Type) Class.forName("java.util.Optional"), (ObjectSerializer) OptionalCodec.instance);
                        put((Type) Class.forName("java.util.OptionalDouble"), (ObjectSerializer) OptionalCodec.instance);
                        put((Type) Class.forName("java.util.OptionalInt"), (ObjectSerializer) OptionalCodec.instance);
                        put((Type) Class.forName("java.util.OptionalLong"), (ObjectSerializer) OptionalCodec.instance);
                        ObjectSerializer objectSerializer2 = this.serializers.get(cls);
                        if (objectSerializer2 != null) {
                            return objectSerializer2;
                        }
                    } catch (Throwable unused3) {
                        jdk8Error = true;
                    }
                }
                if (!oracleJdbcError && name.startsWith("oracle.sql.")) {
                    try {
                        put((Type) Class.forName("oracle.sql.DATE"), (ObjectSerializer) DateCodec.instance);
                        put((Type) Class.forName("oracle.sql.TIMESTAMP"), (ObjectSerializer) DateCodec.instance);
                        ObjectSerializer objectSerializer3 = this.serializers.get(cls);
                        if (objectSerializer3 != null) {
                            return objectSerializer3;
                        }
                    } catch (Throwable unused4) {
                        oracleJdbcError = true;
                    }
                }
                if (!springfoxError && name.equals("springfox.documentation.spring.web.json.Json")) {
                    try {
                        put((Type) Class.forName("springfox.documentation.spring.web.json.Json"), (ObjectSerializer) SwaggerJsonSerializer.instance);
                        ObjectSerializer objectSerializer4 = this.serializers.get(cls);
                        if (objectSerializer4 != null) {
                            return objectSerializer4;
                        }
                    } catch (ClassNotFoundException unused5) {
                        springfoxError = true;
                    }
                }
                if (!guavaError && name.startsWith("com.google.common.collect.")) {
                    try {
                        put((Type) Class.forName("com.google.common.collect.HashMultimap"), (ObjectSerializer) GuavaCodec.instance);
                        put((Type) Class.forName("com.google.common.collect.LinkedListMultimap"), (ObjectSerializer) GuavaCodec.instance);
                        put((Type) Class.forName("com.google.common.collect.ArrayListMultimap"), (ObjectSerializer) GuavaCodec.instance);
                        put((Type) Class.forName("com.google.common.collect.TreeMultimap"), (ObjectSerializer) GuavaCodec.instance);
                        ObjectSerializer objectSerializer5 = this.serializers.get(cls);
                        if (objectSerializer5 != null) {
                            return objectSerializer5;
                        }
                    } catch (ClassNotFoundException unused6) {
                        guavaError = true;
                    }
                }
                if (name.equals("net.sf.json.JSONNull")) {
                    try {
                        put((Type) Class.forName("net.sf.json.JSONNull"), (ObjectSerializer) MiscCodec.instance);
                    } catch (ClassNotFoundException unused7) {
                    }
                    ObjectSerializer objectSerializer6 = this.serializers.get(cls);
                    if (objectSerializer6 != null) {
                        return objectSerializer6;
                    }
                }
                if (TypeUtils.isProxy(cls)) {
                    ObjectSerializer objectWriter = getObjectWriter(cls.getSuperclass());
                    put((Type) cls, objectWriter);
                    return objectWriter;
                } else if (z) {
                    put((Type) cls, createJavaBeanSerializer(cls));
                }
            } else {
                if (!awtError) {
                    try {
                        put((Type) Class.forName("java.awt.Color"), (ObjectSerializer) AwtCodec.instance);
                        put((Type) Class.forName("java.awt.Font"), (ObjectSerializer) AwtCodec.instance);
                        put((Type) Class.forName("java.awt.Point"), (ObjectSerializer) AwtCodec.instance);
                        put((Type) Class.forName("java.awt.Rectangle"), (ObjectSerializer) AwtCodec.instance);
                    } catch (Throwable unused8) {
                        awtError = true;
                    }
                }
                return AwtCodec.instance;
            }
        }
        return this.serializers.get(cls);
    }

    public final ObjectSerializer get(Type type) {
        return this.serializers.get(type);
    }

    public boolean put(Object obj, Object obj2) {
        return put((Type) obj, (ObjectSerializer) obj2);
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        return this.serializers.put(type, objectSerializer);
    }

    public void configEnumAsJavaBean(Class<? extends Enum>... clsArr) {
        for (Class<? extends Enum> cls : clsArr) {
            put((Type) cls, createJavaBeanSerializer((Class<?>) cls));
        }
    }
}
