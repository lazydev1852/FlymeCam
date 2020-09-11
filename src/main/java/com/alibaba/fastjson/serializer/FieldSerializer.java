package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import com.baidu.p020ar.util.SystemInfoUtil;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class FieldSerializer implements Comparable<FieldSerializer> {
    private final String double_quoted_fieldPrefix;
    protected int features;
    protected BeanContext fieldContext;
    public final FieldInfo fieldInfo;
    private String format;
    private RuntimeSerializerInfo runtimeInfo;
    protected boolean serializeUsing = false;
    private String single_quoted_fieldPrefix;
    private String un_quoted_fieldPrefix;
    protected boolean writeEnumUsingName = false;
    protected boolean writeEnumUsingToString = false;
    protected final boolean writeNull;

    public FieldSerializer(Class<?> cls, FieldInfo fieldInfo2) {
        boolean z;
        this.fieldInfo = fieldInfo2;
        this.fieldContext = new BeanContext(cls, fieldInfo2);
        fieldInfo2.setAccessible();
        this.double_quoted_fieldPrefix = '\"' + fieldInfo2.name + "\":";
        JSONField annotation = fieldInfo2.getAnnotation();
        if (annotation != null) {
            SerializerFeature[] serialzeFeatures = annotation.serialzeFeatures();
            int length = serialzeFeatures.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if ((serialzeFeatures[i].getMask() & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            this.format = annotation.format();
            if (this.format.trim().length() == 0) {
                this.format = null;
            }
            for (SerializerFeature serializerFeature : annotation.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                }
            }
            this.features = SerializerFeature.m396of(annotation.serialzeFeatures());
        } else {
            z = false;
        }
        this.writeNull = z;
    }

    public void writePrefix(JSONSerializer jSONSerializer) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (!serializeWriter.quoteFieldNames) {
            if (this.un_quoted_fieldPrefix == null) {
                this.un_quoted_fieldPrefix = this.fieldInfo.name + SystemInfoUtil.COLON;
            }
            serializeWriter.write(this.un_quoted_fieldPrefix);
        } else if (serializeWriter.useSingleQuotes) {
            if (this.single_quoted_fieldPrefix == null) {
                this.single_quoted_fieldPrefix = '\'' + this.fieldInfo.name + "':";
            }
            serializeWriter.write(this.single_quoted_fieldPrefix);
        } else {
            serializeWriter.write(this.double_quoted_fieldPrefix);
        }
    }

    public Object getPropertyValueDirect(Object obj) throws InvocationTargetException, IllegalAccessException {
        return this.fieldInfo.get(obj);
    }

    public Object getPropertyValue(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object obj2 = this.fieldInfo.get(obj);
        if (this.format == null || obj2 == null || this.fieldInfo.fieldClass != Date.class) {
            return obj2;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.format);
        simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
        return simpleDateFormat.format(obj2);
    }

    public int compareTo(FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }

    public void writeValue(JSONSerializer jSONSerializer, Object obj) throws Exception {
        ObjectSerializer objectSerializer;
        Class<?> cls;
        if (this.runtimeInfo == null) {
            if (obj == null) {
                cls = this.fieldInfo.fieldClass;
            } else {
                cls = obj.getClass();
            }
            ObjectSerializer objectSerializer2 = null;
            JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation == null || annotation.serializeUsing() == Void.class) {
                if (this.format != null) {
                    if (cls == Double.TYPE || cls == Double.class) {
                        objectSerializer2 = new DoubleSerializer(this.format);
                    } else if (cls == Float.TYPE || cls == Float.class) {
                        objectSerializer2 = new FloatCodec(this.format);
                    }
                }
                if (objectSerializer2 == null) {
                    objectSerializer2 = jSONSerializer.getObjectWriter(cls);
                }
            } else {
                objectSerializer2 = (ObjectSerializer) annotation.serializeUsing().newInstance();
                this.serializeUsing = true;
            }
            this.runtimeInfo = new RuntimeSerializerInfo(objectSerializer2, cls);
        }
        RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
        int i = this.fieldInfo.serialzeFeatures;
        if (obj == null) {
            Class<?> cls2 = runtimeSerializerInfo.runtimeFieldClass;
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (Number.class.isAssignableFrom(cls2)) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullNumberAsZero.mask);
            } else if (String.class == cls2) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullStringAsEmpty.mask);
            } else if (Boolean.class == cls2) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullBooleanAsFalse.mask);
            } else if (Collection.class.isAssignableFrom(cls2)) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullListAsEmpty.mask);
            } else {
                ObjectSerializer objectSerializer3 = runtimeSerializerInfo.fieldSerializer;
                if (!serializeWriter.isEnabled(SerializerFeature.WRITE_MAP_NULL_FEATURES) || !(objectSerializer3 instanceof JavaBeanSerializer)) {
                    objectSerializer3.write(jSONSerializer, (Object) null, this.fieldInfo.name, this.fieldInfo.fieldType, i);
                    return;
                }
                serializeWriter.writeNull();
            }
        } else {
            if (this.fieldInfo.isEnum) {
                if (this.writeEnumUsingName) {
                    jSONSerializer.out.writeString(((Enum) obj).name());
                    return;
                } else if (this.writeEnumUsingToString) {
                    jSONSerializer.out.writeString(((Enum) obj).toString());
                    return;
                }
            }
            Class<?> cls3 = obj.getClass();
            if (cls3 == runtimeSerializerInfo.runtimeFieldClass || this.serializeUsing) {
                objectSerializer = runtimeSerializerInfo.fieldSerializer;
            } else {
                objectSerializer = jSONSerializer.getObjectWriter(cls3);
            }
            ObjectSerializer objectSerializer4 = objectSerializer;
            if (this.format == null || (objectSerializer4 instanceof DoubleSerializer) || (objectSerializer4 instanceof FloatCodec)) {
                objectSerializer4.write(jSONSerializer, obj, this.fieldInfo.name, this.fieldInfo.fieldType, i);
            } else if (objectSerializer4 instanceof ContextObjectSerializer) {
                ((ContextObjectSerializer) objectSerializer4).write(jSONSerializer, obj, this.fieldContext);
            } else {
                jSONSerializer.writeWithFormat(obj, this.format);
            }
        }
    }

    static class RuntimeSerializerInfo {
        ObjectSerializer fieldSerializer;
        Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer objectSerializer, Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }
}
