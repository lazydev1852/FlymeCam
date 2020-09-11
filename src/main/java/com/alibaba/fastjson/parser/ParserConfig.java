package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.AwtCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.ServiceLoader;
import com.baidu.p020ar.util.SystemInfoUtil;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

public class ParserConfig {
    public static final String[] DENYS = readSystemDenyPropety();
    public static final String DENY_PROPERTY = "fastjson.parser.deny";
    private static boolean awtError = false;
    public static ParserConfig global = new ParserConfig();
    private static boolean jdk8Error = false;
    private boolean asmEnable;
    protected ASMDeserializerFactory asmFactory;
    protected ClassLoader defaultClassLoader;
    private String[] denyList;
    private final IdentityHashMap<Type, ObjectDeserializer> derializers;
    public PropertyNamingStrategy propertyNamingStrategy;
    public final SymbolTable symbolTable;

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public ParserConfig() {
        this((ASMDeserializerFactory) null, (ClassLoader) null);
    }

    public ParserConfig(ClassLoader classLoader) {
        this((ASMDeserializerFactory) null, classLoader);
    }

    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory) {
        this(aSMDeserializerFactory, (ClassLoader) null);
    }

    private ParserConfig(ASMDeserializerFactory aSMDeserializerFactory, ClassLoader classLoader) {
        this.derializers = new IdentityHashMap<>();
        this.asmEnable = !ASMUtils.IS_ANDROID;
        this.symbolTable = new SymbolTable(4096);
        this.denyList = new String[]{"java.lang.Thread"};
        if (aSMDeserializerFactory == null && !ASMUtils.IS_ANDROID) {
            if (classLoader == null) {
                try {
                    aSMDeserializerFactory = new ASMDeserializerFactory(new ASMClassLoader());
                } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
                }
            } else {
                aSMDeserializerFactory = new ASMDeserializerFactory(classLoader);
            }
        }
        this.asmFactory = aSMDeserializerFactory;
        if (aSMDeserializerFactory == null) {
            this.asmEnable = false;
        }
        this.derializers.put(SimpleDateFormat.class, MiscCodec.instance);
        this.derializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
        this.derializers.put(Date.class, SqlDateDeserializer.instance);
        this.derializers.put(Time.class, TimeDeserializer.instance);
        this.derializers.put(java.util.Date.class, DateCodec.instance);
        this.derializers.put(Calendar.class, CalendarCodec.instance);
        this.derializers.put(XMLGregorianCalendar.class, CalendarCodec.instance);
        this.derializers.put(JSONObject.class, MapDeserializer.instance);
        this.derializers.put(JSONArray.class, CollectionCodec.instance);
        this.derializers.put(Map.class, MapDeserializer.instance);
        this.derializers.put(HashMap.class, MapDeserializer.instance);
        this.derializers.put(LinkedHashMap.class, MapDeserializer.instance);
        this.derializers.put(TreeMap.class, MapDeserializer.instance);
        this.derializers.put(ConcurrentMap.class, MapDeserializer.instance);
        this.derializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
        this.derializers.put(Collection.class, CollectionCodec.instance);
        this.derializers.put(List.class, CollectionCodec.instance);
        this.derializers.put(ArrayList.class, CollectionCodec.instance);
        this.derializers.put(Object.class, JavaObjectDeserializer.instance);
        this.derializers.put(String.class, StringCodec.instance);
        this.derializers.put(StringBuffer.class, StringCodec.instance);
        this.derializers.put(StringBuilder.class, StringCodec.instance);
        this.derializers.put(Character.TYPE, CharacterCodec.instance);
        this.derializers.put(Character.class, CharacterCodec.instance);
        this.derializers.put(Byte.TYPE, NumberDeserializer.instance);
        this.derializers.put(Byte.class, NumberDeserializer.instance);
        this.derializers.put(Short.TYPE, NumberDeserializer.instance);
        this.derializers.put(Short.class, NumberDeserializer.instance);
        this.derializers.put(Integer.TYPE, IntegerCodec.instance);
        this.derializers.put(Integer.class, IntegerCodec.instance);
        this.derializers.put(Long.TYPE, LongCodec.instance);
        this.derializers.put(Long.class, LongCodec.instance);
        this.derializers.put(BigInteger.class, BigIntegerCodec.instance);
        this.derializers.put(BigDecimal.class, BigDecimalCodec.instance);
        this.derializers.put(Float.TYPE, FloatCodec.instance);
        this.derializers.put(Float.class, FloatCodec.instance);
        this.derializers.put(Double.TYPE, NumberDeserializer.instance);
        this.derializers.put(Double.class, NumberDeserializer.instance);
        this.derializers.put(Boolean.TYPE, BooleanCodec.instance);
        this.derializers.put(Boolean.class, BooleanCodec.instance);
        this.derializers.put(Class.class, MiscCodec.instance);
        this.derializers.put(char[].class, new CharArrayCodec());
        this.derializers.put(AtomicBoolean.class, BooleanCodec.instance);
        this.derializers.put(AtomicInteger.class, IntegerCodec.instance);
        this.derializers.put(AtomicLong.class, LongCodec.instance);
        this.derializers.put(AtomicReference.class, ReferenceCodec.instance);
        this.derializers.put(WeakReference.class, ReferenceCodec.instance);
        this.derializers.put(SoftReference.class, ReferenceCodec.instance);
        this.derializers.put(UUID.class, MiscCodec.instance);
        this.derializers.put(TimeZone.class, MiscCodec.instance);
        this.derializers.put(Locale.class, MiscCodec.instance);
        this.derializers.put(Currency.class, MiscCodec.instance);
        this.derializers.put(InetAddress.class, MiscCodec.instance);
        this.derializers.put(Inet4Address.class, MiscCodec.instance);
        this.derializers.put(Inet6Address.class, MiscCodec.instance);
        this.derializers.put(InetSocketAddress.class, MiscCodec.instance);
        this.derializers.put(File.class, MiscCodec.instance);
        this.derializers.put(URI.class, MiscCodec.instance);
        this.derializers.put(URL.class, MiscCodec.instance);
        this.derializers.put(Pattern.class, MiscCodec.instance);
        this.derializers.put(Charset.class, MiscCodec.instance);
        this.derializers.put(JSONPath.class, MiscCodec.instance);
        this.derializers.put(Number.class, NumberDeserializer.instance);
        this.derializers.put(AtomicIntegerArray.class, AtomicCodec.instance);
        this.derializers.put(AtomicLongArray.class, AtomicCodec.instance);
        this.derializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
        this.derializers.put(Serializable.class, JavaObjectDeserializer.instance);
        this.derializers.put(Cloneable.class, JavaObjectDeserializer.instance);
        this.derializers.put(Comparable.class, JavaObjectDeserializer.instance);
        this.derializers.put(Closeable.class, JavaObjectDeserializer.instance);
        addDeny("java.lang.Thread");
        addItemsToDeny(DENYS);
    }

    private static String[] splitItemsFormProperty(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(SystemInfoUtil.COMMA);
    }

    public void configFromPropety(Properties properties) {
        addItemsToDeny(splitItemsFormProperty(properties.getProperty(DENY_PROPERTY)));
    }

    private void addItemsToDeny(String[] strArr) {
        if (strArr != null) {
            for (String addDeny : strArr) {
                addDeny(addDeny);
            }
        }
    }

    public static String[] readSystemDenyPropety() {
        return splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY));
    }

    public boolean isAsmEnable() {
        return this.asmEnable;
    }

    public void setAsmEnable(boolean z) {
        this.asmEnable = z;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDerializers() {
        return this.derializers;
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = this.derializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof Class) {
            return getDeserializer((Class) type, type);
        }
        if (!(type instanceof ParameterizedType)) {
            return JavaObjectDeserializer.instance;
        }
        Type rawType = ((ParameterizedType) type).getRawType();
        if (rawType instanceof Class) {
            return getDeserializer((Class) rawType, type);
        }
        return getDeserializer(rawType);
    }

    public ObjectDeserializer getDeserializer(Class<?> cls, Type type) {
        ObjectDeserializer objectDeserializer;
        ObjectDeserializer objectDeserializer2;
        Class<?> mappingTo;
        ObjectDeserializer objectDeserializer3 = this.derializers.get(type);
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        if (type == null) {
            type = cls;
        }
        ObjectDeserializer objectDeserializer4 = this.derializers.get(type);
        if (objectDeserializer4 != null) {
            return objectDeserializer4;
        }
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType != null && (mappingTo = jSONType.mappingTo()) != Void.class) {
            return getDeserializer(mappingTo, mappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            objectDeserializer4 = this.derializers.get(cls);
        }
        if (objectDeserializer4 != null) {
            return objectDeserializer4;
        }
        String replace = cls.getName().replace('$', '.');
        int i = 0;
        while (i < this.denyList.length) {
            if (!replace.startsWith(this.denyList[i])) {
                i++;
            } else {
                throw new JSONException("parser deny : " + replace);
            }
        }
        if (replace.startsWith("java.awt.") && AwtCodec.support(cls) && !awtError) {
            try {
                this.derializers.put(Class.forName("java.awt.Point"), AwtCodec.instance);
                this.derializers.put(Class.forName("java.awt.Font"), AwtCodec.instance);
                this.derializers.put(Class.forName("java.awt.Rectangle"), AwtCodec.instance);
                this.derializers.put(Class.forName("java.awt.Color"), AwtCodec.instance);
            } catch (Throwable unused) {
                awtError = true;
            }
            objectDeserializer4 = AwtCodec.instance;
        }
        if (!jdk8Error) {
            try {
                if (replace.startsWith("java.time.")) {
                    this.derializers.put(Class.forName("java.time.LocalDateTime"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.LocalDate"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.LocalTime"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.ZonedDateTime"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.OffsetDateTime"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.OffsetTime"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.ZoneOffset"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.ZoneRegion"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.ZoneId"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.Period"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.Duration"), Jdk8DateCodec.instance);
                    this.derializers.put(Class.forName("java.time.Instant"), Jdk8DateCodec.instance);
                    objectDeserializer2 = this.derializers.get(cls);
                } else if (replace.startsWith("java.util.Optional")) {
                    this.derializers.put(Class.forName("java.util.Optional"), OptionalCodec.instance);
                    this.derializers.put(Class.forName("java.util.OptionalDouble"), OptionalCodec.instance);
                    this.derializers.put(Class.forName("java.util.OptionalInt"), OptionalCodec.instance);
                    this.derializers.put(Class.forName("java.util.OptionalLong"), OptionalCodec.instance);
                    objectDeserializer2 = this.derializers.get(cls);
                }
                objectDeserializer4 = objectDeserializer2;
            } catch (Throwable unused2) {
                jdk8Error = true;
            }
        }
        if (replace.equals("java.nio.file.Path")) {
            this.derializers.put(cls, MiscCodec.instance);
        }
        if (cls == Map.Entry.class) {
            this.derializers.put(cls, MiscCodec.instance);
        }
        try {
            for (AutowiredObjectDeserializer next : ServiceLoader.load(AutowiredObjectDeserializer.class, Thread.currentThread().getContextClassLoader())) {
                for (Type put : next.getAutowiredFor()) {
                    this.derializers.put(put, next);
                }
            }
        } catch (Exception unused3) {
        }
        if (objectDeserializer4 == null) {
            objectDeserializer4 = this.derializers.get(type);
        }
        if (objectDeserializer4 != null) {
            return objectDeserializer4;
        }
        if (cls.isEnum()) {
            objectDeserializer = new EnumDeserializer(cls);
        } else if (cls.isArray()) {
            objectDeserializer = ObjectArrayCodec.instance;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class) {
            objectDeserializer = CollectionCodec.instance;
        } else if (Collection.class.isAssignableFrom(cls)) {
            objectDeserializer = CollectionCodec.instance;
        } else if (Map.class.isAssignableFrom(cls)) {
            objectDeserializer = MapDeserializer.instance;
        } else if (Throwable.class.isAssignableFrom(cls)) {
            objectDeserializer = new ThrowableDeserializer(this, cls);
        } else {
            objectDeserializer = createJavaBeanDeserializer(cls, type);
        }
        putDeserializer(type, objectDeserializer);
        return objectDeserializer;
    }

    public ObjectDeserializer createJavaBeanDeserializer(Class<?> cls, Type type) {
        JSONField annotation;
        boolean z = this.asmEnable;
        if (z) {
            JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
            if (jSONType != null) {
                Class<?> deserializer = jSONType.deserializer();
                if (deserializer != Void.class) {
                    try {
                        Object newInstance = deserializer.newInstance();
                        if (newInstance instanceof ObjectDeserializer) {
                            return (ObjectDeserializer) newInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                z = jSONType.asm();
            }
            if (z) {
                Class<?> builderClass = JavaBeanInfo.getBuilderClass(jSONType);
                if (builderClass == null) {
                    builderClass = cls;
                }
                while (true) {
                    if (Modifier.isPublic(builderClass.getModifiers())) {
                        builderClass = builderClass.getSuperclass();
                        if (builderClass != Object.class) {
                            if (builderClass == null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
        }
        if (cls.getTypeParameters().length != 0) {
            z = false;
        }
        if (z && this.asmFactory != null && this.asmFactory.classLoader.isExternalClass(cls)) {
            z = false;
        }
        if (z) {
            z = ASMUtils.checkName(cls.getSimpleName());
        }
        if (z) {
            if (cls.isInterface()) {
                z = false;
            }
            JavaBeanInfo build = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
            if (z && build.fields.length > 200) {
                z = false;
            }
            Constructor<?> constructor = build.defaultConstructor;
            if (z && constructor == null && !cls.isInterface()) {
                z = false;
            }
            FieldInfo[] fieldInfoArr = build.fields;
            int length = fieldInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                FieldInfo fieldInfo = fieldInfoArr[i];
                if (!fieldInfo.getOnly) {
                    Class<?> cls2 = fieldInfo.fieldClass;
                    if (!Modifier.isPublic(cls2.getModifiers()) || ((cls2.isMemberClass() && !Modifier.isStatic(cls2.getModifiers())) || ((fieldInfo.getMember() != null && !ASMUtils.checkName(fieldInfo.getMember().getName())) || (((annotation = fieldInfo.getAnnotation()) != null && (!ASMUtils.checkName(annotation.name()) || annotation.format().length() != 0 || annotation.deserializeUsing() != Void.class)) || (cls2.isEnum() && !(getDeserializer((Type) cls2) instanceof EnumDeserializer)))))) {
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            z = false;
        }
        if (z && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            z = false;
        }
        if (!z) {
            return new JavaBeanDeserializer(this, cls, type);
        }
        JavaBeanInfo build2 = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
        try {
            return this.asmFactory.createJavaBeanDeserializer(this, build2);
        } catch (NoSuchMethodException unused2) {
            return new JavaBeanDeserializer(this, cls, type);
        } catch (JSONException unused3) {
            return new JavaBeanDeserializer(this, build2);
        } catch (Exception e) {
            throw new JSONException("create asm deserializer error, " + cls.getName(), e);
        }
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, FieldInfo fieldInfo) {
        Class<?> deserializeUsing;
        Class<?> cls = javaBeanInfo.clazz;
        Class<?> cls2 = fieldInfo.fieldClass;
        JSONField annotation = fieldInfo.getAnnotation();
        Class<?> cls3 = null;
        if (!(annotation == null || (deserializeUsing = annotation.deserializeUsing()) == Void.class)) {
            cls3 = deserializeUsing;
        }
        if (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) {
            return new ArrayListTypeFieldDeserializer(parserConfig, cls, fieldInfo);
        }
        return new DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        this.derializers.put(type, objectDeserializer);
    }

    public ObjectDeserializer getDeserializer(FieldInfo fieldInfo) {
        return getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
    }

    public static boolean isPrimitive(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls == Date.class || cls == Time.class || cls == Timestamp.class || cls.isEnum();
    }

    public static void parserAllFieldToCache(Class<?> cls, Map<String, Field> map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
            parserAllFieldToCache(cls.getSuperclass(), map);
        }
    }

    public static Field getFieldFromCache(String str, Map<String, Field> map) {
        Field field = map.get(str);
        if (field == null) {
            field = map.get("_" + str);
        }
        if (field != null) {
            return field;
        }
        return map.get("m_" + str);
    }

    public ClassLoader getDefaultClassLoader() {
        return this.defaultClassLoader;
    }

    public void setDefaultClassLoader(ClassLoader classLoader) {
        this.defaultClassLoader = classLoader;
    }

    public void addDeny(String str) {
        if (str != null && str.length() != 0) {
            String[] strArr = new String[(this.denyList.length + 1)];
            System.arraycopy(this.denyList, 0, strArr, 0, this.denyList.length);
            strArr[strArr.length - 1] = str;
            this.denyList = strArr;
        }
    }
}
