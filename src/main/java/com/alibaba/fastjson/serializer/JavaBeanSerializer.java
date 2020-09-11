package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    protected final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, (PropertyNamingStrategy) null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        for (int i = 0; i < this.sortedGetters.length; i++) {
            this.sortedGetters[i] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
        }
        if (serializeBeanInfo.fields == serializeBeanInfo.sortedFields) {
            this.getters = this.sortedGetters;
            return;
        }
        this.getters = new FieldSerializer[serializeBeanInfo.fields.length];
        for (int i2 = 0; i2 < this.getters.length; i2++) {
            this.getters[i2] = getFieldSerializer(serializeBeanInfo.fields[i2].name);
        }
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c4, code lost:
        if (r1.fieldTransient != false) goto L_0x00d3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x02c6 A[SYNTHETIC, Splitter:B:220:0x02c6] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x02e7 A[Catch:{ all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0301 A[Catch:{ all -> 0x031f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r26, java.lang.Object r27, java.lang.Object r28, java.lang.reflect.Type r29, int r30) throws java.io.IOException {
        /*
            r25 = this;
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r28
            r0 = r29
            r11 = r30
            com.alibaba.fastjson.serializer.SerializeWriter r12 = r8.out
            if (r9 != 0) goto L_0x0014
            r12.writeNull()
            return
        L_0x0014:
            boolean r1 = r7.writeReference(r8, r9, r11)
            if (r1 == 0) goto L_0x001b
            return
        L_0x001b:
            boolean r1 = r12.sortField
            if (r1 == 0) goto L_0x0023
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = r7.sortedGetters
        L_0x0021:
            r13 = r1
            goto L_0x0026
        L_0x0023:
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = r7.getters
            goto L_0x0021
        L_0x0026:
            com.alibaba.fastjson.serializer.SerialContext r14 = r8.context
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r7.beanInfo
            int r5 = r1.features
            r1 = r26
            r2 = r14
            r3 = r27
            r4 = r28
            r6 = r30
            r1.setContext(r2, r3, r4, r5, r6)
            boolean r11 = r7.isWriteAsArray(r8, r11)
            if (r11 == 0) goto L_0x0041
            r1 = 91
            goto L_0x0043
        L_0x0041:
            r1 = 123(0x7b, float:1.72E-43)
        L_0x0043:
            if (r11 == 0) goto L_0x004a
            r2 = 93
            r15 = 93
            goto L_0x004e
        L_0x004a:
            r2 = 125(0x7d, float:1.75E-43)
            r15 = 125(0x7d, float:1.75E-43)
        L_0x004e:
            r12.append((char) r1)     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            int r1 = r13.length     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            if (r1 <= 0) goto L_0x0062
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            boolean r1 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            if (r1 == 0) goto L_0x0062
            r26.incrementIndent()     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            r26.println()     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
        L_0x0062:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r1 = r7.beanInfo     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            int r1 = r1.features     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            int r2 = r2.mask     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            r1 = r1 & r2
            r6 = 1
            if (r1 != 0) goto L_0x0074
            boolean r1 = r8.isWriteClassName(r0, r9)     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            if (r1 == 0) goto L_0x007f
        L_0x0074:
            java.lang.Class r1 = r27.getClass()     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            if (r1 == r0) goto L_0x007f
            r25.writeClassName(r26, r27)     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            r0 = 1
            goto L_0x0080
        L_0x007f:
            r0 = 0
        L_0x0080:
            r4 = 44
            if (r0 == 0) goto L_0x0087
            r0 = 44
            goto L_0x0088
        L_0x0087:
            r0 = 0
        L_0x0088:
            boolean r1 = r12.quoteFieldNames     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            if (r1 == 0) goto L_0x0093
            boolean r1 = r12.useSingleQuotes     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            if (r1 != 0) goto L_0x0093
            r16 = 1
            goto L_0x0095
        L_0x0093:
            r16 = 0
        L_0x0095:
            char r0 = r7.writeBefore(r8, r9, r0)     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            if (r0 != r4) goto L_0x009d
            r0 = 1
            goto L_0x009e
        L_0x009d:
            r0 = 0
        L_0x009e:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            boolean r17 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreNonFieldGetter     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            boolean r18 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            r19 = r0
            r3 = 0
        L_0x00ad:
            int r0 = r13.length     // Catch:{ Exception -> 0x02bf, all -> 0x02bb }
            if (r3 >= r0) goto L_0x0281
            r2 = r13[r3]     // Catch:{ Exception -> 0x027c, all -> 0x0276 }
            com.alibaba.fastjson.util.FieldInfo r0 = r2.fieldInfo     // Catch:{ Exception -> 0x027c, all -> 0x0276 }
            java.lang.reflect.Field r0 = r0.field     // Catch:{ Exception -> 0x027c, all -> 0x0276 }
            com.alibaba.fastjson.util.FieldInfo r1 = r2.fieldInfo     // Catch:{ Exception -> 0x027c, all -> 0x0276 }
            java.lang.String r10 = r1.name     // Catch:{ Exception -> 0x027c, all -> 0x0276 }
            r20 = r14
            java.lang.Class<?> r14 = r1.fieldClass     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r17 == 0) goto L_0x00cf
            if (r0 == 0) goto L_0x00cf
            boolean r4 = r1.fieldTransient     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            if (r4 == 0) goto L_0x00cf
            goto L_0x00d3
        L_0x00c7:
            r0 = move-exception
            r1 = r7
            goto L_0x02b4
        L_0x00cb:
            r0 = move-exception
            r1 = r7
            goto L_0x02b8
        L_0x00cf:
            if (r18 == 0) goto L_0x00df
            if (r0 != 0) goto L_0x00df
        L_0x00d3:
            r23 = r3
            r22 = r13
            r21 = r15
            r3 = 1
            r4 = 0
            r7 = 44
            goto L_0x025c
        L_0x00df:
            java.lang.String r0 = r1.name     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            boolean r0 = r7.applyName(r8, r9, r0)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r0 == 0) goto L_0x00d3
            java.lang.String r0 = r1.label     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            boolean r0 = r7.applyLabel(r8, r0)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r0 != 0) goto L_0x00f0
            goto L_0x00d3
        L_0x00f0:
            java.lang.Object r0 = r2.getPropertyValueDirect(r9)     // Catch:{ InvocationTargetException -> 0x00f5 }
            goto L_0x0100
        L_0x00f5:
            r0 = move-exception
            r4 = r0
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            boolean r0 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r0 == 0) goto L_0x025b
            r0 = 0
        L_0x0100:
            boolean r4 = r7.apply(r8, r9, r10, r0)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r4 != 0) goto L_0x0107
            goto L_0x00d3
        L_0x0107:
            java.lang.String r4 = r7.processKey(r8, r9, r10, r0)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            com.alibaba.fastjson.serializer.BeanContext r5 = r2.fieldContext     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            r21 = r15
            r15 = r1
            r1 = r25
            r22 = r13
            r13 = r2
            r2 = r26
            r23 = r3
            r3 = r5
            r5 = r4
            r7 = 44
            r4 = r27
            r24 = r5
            r5 = r10
            r6 = r0
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r1 != 0) goto L_0x013b
            if (r11 != 0) goto L_0x013b
            boolean r2 = r13.writeNull     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 != 0) goto L_0x013b
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            boolean r2 = r12.isEnabled((int) r2)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 != 0) goto L_0x013b
        L_0x0137:
            r3 = 1
            r4 = 0
            goto L_0x025c
        L_0x013b:
            if (r1 == 0) goto L_0x01ce
            boolean r2 = r12.notWriteDefaultValue     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 == 0) goto L_0x01ce
            java.lang.Class<?> r2 = r15.fieldClass     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            java.lang.Class r3 = java.lang.Byte.TYPE     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 != r3) goto L_0x0155
            boolean r3 = r1 instanceof java.lang.Byte     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r3 == 0) goto L_0x0155
            r3 = r1
            java.lang.Byte r3 = (java.lang.Byte) r3     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            byte r3 = r3.byteValue()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r3 != 0) goto L_0x0155
            goto L_0x0137
        L_0x0155:
            java.lang.Class r3 = java.lang.Short.TYPE     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 != r3) goto L_0x0167
            boolean r3 = r1 instanceof java.lang.Short     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r3 == 0) goto L_0x0167
            r3 = r1
            java.lang.Short r3 = (java.lang.Short) r3     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            short r3 = r3.shortValue()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r3 != 0) goto L_0x0167
            goto L_0x0137
        L_0x0167:
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 != r3) goto L_0x0179
            boolean r3 = r1 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r3 == 0) goto L_0x0179
            r3 = r1
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r3 != 0) goto L_0x0179
            goto L_0x0137
        L_0x0179:
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 != r3) goto L_0x018f
            boolean r3 = r1 instanceof java.lang.Long     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r3 == 0) goto L_0x018f
            r3 = r1
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            long r3 = r3.longValue()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x018f
            goto L_0x0137
        L_0x018f:
            java.lang.Class r3 = java.lang.Float.TYPE     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 != r3) goto L_0x01a4
            boolean r3 = r1 instanceof java.lang.Float     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r3 == 0) goto L_0x01a4
            r3 = r1
            java.lang.Float r3 = (java.lang.Float) r3     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            float r3 = r3.floatValue()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x01a4
            goto L_0x0137
        L_0x01a4:
            java.lang.Class r3 = java.lang.Double.TYPE     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 != r3) goto L_0x01bb
            boolean r3 = r1 instanceof java.lang.Double     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r3 == 0) goto L_0x01bb
            r3 = r1
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            double r3 = r3.doubleValue()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x01bb
            goto L_0x0137
        L_0x01bb:
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 != r3) goto L_0x01ce
            boolean r2 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 == 0) goto L_0x01ce
            r2 = r1
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 != 0) goto L_0x01ce
            goto L_0x0137
        L_0x01ce:
            if (r19 == 0) goto L_0x01de
            r12.write((int) r7)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            boolean r2 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r2)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r2 == 0) goto L_0x01de
            r26.println()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
        L_0x01de:
            r2 = r24
            if (r2 == r10) goto L_0x01f0
            if (r11 != 0) goto L_0x01e9
            r3 = 1
            r12.writeFieldName(r2, r3)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            goto L_0x01ea
        L_0x01e9:
            r3 = 1
        L_0x01ea:
            r8.write((java.lang.Object) r1)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
        L_0x01ed:
            r4 = 0
            goto L_0x0258
        L_0x01f0:
            r3 = 1
            if (r0 == r1) goto L_0x01fc
            if (r11 != 0) goto L_0x01f8
            r13.writePrefix(r8)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
        L_0x01f8:
            r8.write((java.lang.Object) r1)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            goto L_0x01ed
        L_0x01fc:
            if (r11 != 0) goto L_0x020f
            if (r16 == 0) goto L_0x020a
            char[] r0 = r15.name_chars     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            char[] r2 = r15.name_chars     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            int r2 = r2.length     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            r4 = 0
            r12.write((char[]) r0, (int) r4, (int) r2)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            goto L_0x0210
        L_0x020a:
            r4 = 0
            r13.writePrefix(r8)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            goto L_0x0210
        L_0x020f:
            r4 = 0
        L_0x0210:
            if (r11 != 0) goto L_0x0255
            com.alibaba.fastjson.annotation.JSONField r0 = r15.getAnnotation()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            if (r14 != r2) goto L_0x0251
            if (r0 == 0) goto L_0x0224
            java.lang.Class r0 = r0.serializeUsing()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            java.lang.Class<java.lang.Void> r2 = java.lang.Void.class
            if (r0 != r2) goto L_0x0251
        L_0x0224:
            if (r1 != 0) goto L_0x0243
            int r0 = r12.features     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            int r1 = r1.mask     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            r0 = r0 & r1
            if (r0 != 0) goto L_0x023d
            int r0 = r13.features     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            int r1 = r1.mask     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0239
            goto L_0x023d
        L_0x0239:
            r12.writeNull()     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            goto L_0x0258
        L_0x023d:
            java.lang.String r0 = ""
            r12.writeString(r0)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            goto L_0x0258
        L_0x0243:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            boolean r0 = r12.useSingleQuotes     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            if (r0 == 0) goto L_0x024d
            r12.writeStringWithSingleQuote(r1)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            goto L_0x0258
        L_0x024d:
            r12.writeStringWithDoubleQuote(r1, r4)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            goto L_0x0258
        L_0x0251:
            r13.writeValue(r8, r1)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
            goto L_0x0258
        L_0x0255:
            r13.writeValue(r8, r1)     // Catch:{ Exception -> 0x0272, all -> 0x026e }
        L_0x0258:
            r19 = 1
            goto L_0x025c
        L_0x025b:
            throw r4     // Catch:{ Exception -> 0x0272, all -> 0x026e }
        L_0x025c:
            int r0 = r23 + 1
            r3 = r0
            r14 = r20
            r15 = r21
            r13 = r22
            r4 = 44
            r6 = 1
            r7 = r25
            r10 = r28
            goto L_0x00ad
        L_0x026e:
            r0 = move-exception
            r2 = r20
            goto L_0x0278
        L_0x0272:
            r0 = move-exception
            r2 = r20
            goto L_0x027e
        L_0x0276:
            r0 = move-exception
            r2 = r14
        L_0x0278:
            r1 = r25
            goto L_0x0320
        L_0x027c:
            r0 = move-exception
            r2 = r14
        L_0x027e:
            r1 = r25
            goto L_0x02c2
        L_0x0281:
            r22 = r13
            r20 = r14
            r21 = r15
            r4 = 0
            r7 = 44
            if (r19 == 0) goto L_0x0291
            r1 = r25
            r4 = 44
            goto L_0x0293
        L_0x0291:
            r1 = r25
        L_0x0293:
            r1.writeAfter(r8, r9, r4)     // Catch:{ Exception -> 0x02b7, all -> 0x02b3 }
            r2 = r22
            int r0 = r2.length     // Catch:{ Exception -> 0x02b7, all -> 0x02b3 }
            if (r0 <= 0) goto L_0x02a9
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x02b7, all -> 0x02b3 }
            boolean r0 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)     // Catch:{ Exception -> 0x02b7, all -> 0x02b3 }
            if (r0 == 0) goto L_0x02a9
            r26.decrementIdent()     // Catch:{ Exception -> 0x02b7, all -> 0x02b3 }
            r26.println()     // Catch:{ Exception -> 0x02b7, all -> 0x02b3 }
        L_0x02a9:
            r2 = r21
            r12.append((char) r2)     // Catch:{ Exception -> 0x02b7, all -> 0x02b3 }
            r2 = r20
            r8.context = r2
            return
        L_0x02b3:
            r0 = move-exception
        L_0x02b4:
            r2 = r20
            goto L_0x0320
        L_0x02b7:
            r0 = move-exception
        L_0x02b8:
            r2 = r20
            goto L_0x02c2
        L_0x02bb:
            r0 = move-exception
            r1 = r7
            r2 = r14
            goto L_0x0320
        L_0x02bf:
            r0 = move-exception
            r1 = r7
            r2 = r14
        L_0x02c2:
            java.lang.String r3 = "write javaBean error"
            if (r9 == 0) goto L_0x02e2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x031f }
            r4.<init>()     // Catch:{ all -> 0x031f }
            r4.append(r3)     // Catch:{ all -> 0x031f }
            java.lang.String r3 = ", class "
            r4.append(r3)     // Catch:{ all -> 0x031f }
            java.lang.Class r3 = r27.getClass()     // Catch:{ all -> 0x031f }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x031f }
            r4.append(r3)     // Catch:{ all -> 0x031f }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x031f }
        L_0x02e2:
            r4 = r3
            r3 = r28
            if (r3 == 0) goto L_0x02fb
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x031f }
            r5.<init>()     // Catch:{ all -> 0x031f }
            r5.append(r4)     // Catch:{ all -> 0x031f }
            java.lang.String r4 = ", fieldName : "
            r5.append(r4)     // Catch:{ all -> 0x031f }
            r5.append(r3)     // Catch:{ all -> 0x031f }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x031f }
        L_0x02fb:
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x031f }
            if (r3 == 0) goto L_0x0319
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x031f }
            r3.<init>()     // Catch:{ all -> 0x031f }
            r3.append(r4)     // Catch:{ all -> 0x031f }
            java.lang.String r4 = ", "
            r3.append(r4)     // Catch:{ all -> 0x031f }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x031f }
            r3.append(r4)     // Catch:{ all -> 0x031f }
            java.lang.String r4 = r3.toString()     // Catch:{ all -> 0x031f }
        L_0x0319:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x031f }
            r3.<init>(r4, r0)     // Catch:{ all -> 0x031f }
            throw r3     // Catch:{ all -> 0x031f }
        L_0x031f:
            r0 = move-exception
        L_0x0320:
            r8.context = r2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int):void");
    }

    /* access modifiers changed from: protected */
    public void writeClassName(JSONSerializer jSONSerializer, Object obj) {
        jSONSerializer.out.writeFieldName(jSONSerializer.config.typeKey, false);
        String str = this.beanInfo.typeName;
        if (str == null) {
            Class cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str = cls.getName();
        }
        jSONSerializer.write(str);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i2) != 0 || (i & i2) != 0 || jSONSerializer.references == null || !jSONSerializer.references.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    /* access modifiers changed from: protected */
    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (InvocationTargetException e) {
                throw new JSONException("getFieldValue error." + str, e);
            } catch (IllegalAccessException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            }
        } else {
            throw new JSONException("field not found. " + str);
        }
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedGetters.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.sortedGetters[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer propertyValue : this.sortedGetters) {
            arrayList.add(propertyValue.getPropertyValue(obj));
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer propertyValueDirect : this.sortedGetters) {
            if (propertyValueDirect.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: protected */
    public BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    /* access modifiers changed from: protected */
    public Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    /* access modifiers changed from: protected */
    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.beforeFilters != null) {
            for (BeforeFilter writeBefore : jSONSerializer.beforeFilters) {
                c = writeBefore.writeBefore(jSONSerializer, obj, c);
            }
        }
        if (this.beforeFilters != null) {
            for (BeforeFilter writeBefore2 : this.beforeFilters) {
                c = writeBefore2.writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.afterFilters != null) {
            for (AfterFilter writeAfter : jSONSerializer.afterFilters) {
                c = writeAfter.writeAfter(jSONSerializer, obj, c);
            }
        }
        if (this.afterFilters != null) {
            for (AfterFilter writeAfter2 : this.afterFilters) {
                c = writeAfter2.writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        if (jSONSerializer.labelFilters != null) {
            for (LabelFilter apply : jSONSerializer.labelFilters) {
                if (!apply.apply(str)) {
                    return false;
                }
            }
        }
        if (this.labelFilters == null) {
            return true;
        }
        for (LabelFilter apply2 : this.labelFilters) {
            if (!apply2.apply(str)) {
                return false;
            }
        }
        return true;
    }
}
