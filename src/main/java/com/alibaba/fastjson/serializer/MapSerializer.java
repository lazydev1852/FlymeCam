package com.alibaba.fastjson.serializer;

public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b6, code lost:
        if (applyName(r8, r0, (java.lang.String) r1) == false) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x022d A[Catch:{ all -> 0x0308 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0276 A[Catch:{ all -> 0x0308 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x028d A[Catch:{ all -> 0x0308 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x02bd A[Catch:{ all -> 0x0308 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x02c6 A[Catch:{ all -> 0x0308 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077 A[Catch:{ all -> 0x0308 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r21, java.lang.Object r22, java.lang.Object r23, java.lang.reflect.Type r24, int r25) throws java.io.IOException {
        /*
            r20 = this;
            r7 = r20
            r8 = r21
            r0 = r22
            com.alibaba.fastjson.serializer.SerializeWriter r9 = r8.out
            if (r0 != 0) goto L_0x000e
            r9.writeNull()
            return
        L_0x000e:
            r10 = r0
            java.util.Map r10 = (java.util.Map) r10
            boolean r1 = r21.containsReference(r22)
            if (r1 == 0) goto L_0x001b
            r21.writeReference(r22)
            return
        L_0x001b:
            com.alibaba.fastjson.serializer.SerialContext r11 = r8.context
            r12 = 0
            r1 = r23
            r8.setContext(r11, r0, r1, r12)
            r1 = 123(0x7b, float:1.72E-43)
            r9.write((int) r1)     // Catch:{ all -> 0x0308 }
            r21.incrementIndent()     // Catch:{ all -> 0x0308 }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ all -> 0x0308 }
            boolean r1 = r9.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x0308 }
            r13 = 1
            if (r1 == 0) goto L_0x0063
            com.alibaba.fastjson.serializer.SerializeConfig r1 = r8.config     // Catch:{ all -> 0x0308 }
            java.lang.String r1 = r1.typeKey     // Catch:{ all -> 0x0308 }
            java.lang.Class r2 = r10.getClass()     // Catch:{ all -> 0x0308 }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r3 = com.alibaba.fastjson.JSONObject.class
            if (r2 == r3) goto L_0x0048
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            if (r2 == r3) goto L_0x0048
            java.lang.Class<java.util.LinkedHashMap> r3 = java.util.LinkedHashMap.class
            if (r2 != r3) goto L_0x0050
        L_0x0048:
            boolean r2 = r10.containsKey(r1)     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x0050
            r2 = 1
            goto L_0x0051
        L_0x0050:
            r2 = 0
        L_0x0051:
            if (r2 != 0) goto L_0x0063
            r9.writeFieldName(r1)     // Catch:{ all -> 0x0308 }
            java.lang.Class r1 = r22.getClass()     // Catch:{ all -> 0x0308 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0308 }
            r9.writeString(r1)     // Catch:{ all -> 0x0308 }
            r1 = 0
            goto L_0x0064
        L_0x0063:
            r1 = 1
        L_0x0064:
            java.util.Set r2 = r10.entrySet()     // Catch:{ all -> 0x0308 }
            java.util.Iterator r14 = r2.iterator()     // Catch:{ all -> 0x0308 }
            r2 = 0
            r15 = r1
            r6 = r2
            r16 = r6
        L_0x0071:
            boolean r1 = r14.hasNext()     // Catch:{ all -> 0x0308 }
            if (r1 == 0) goto L_0x02ec
            java.lang.Object r1 = r14.next()     // Catch:{ all -> 0x0308 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0308 }
            java.lang.Object r5 = r1.getValue()     // Catch:{ all -> 0x0308 }
            java.lang.Object r1 = r1.getKey()     // Catch:{ all -> 0x0308 }
            java.util.List r2 = r8.propertyPreFilters     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x00bc
            int r2 = r2.size()     // Catch:{ all -> 0x0308 }
            if (r2 <= 0) goto L_0x00bc
            if (r1 == 0) goto L_0x00af
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x0096
            goto L_0x00af
        L_0x0096:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0308 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x00a4
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x00bc
        L_0x00a4:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0308 }
            boolean r2 = r7.applyName(r8, r0, r2)     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x00bc
            goto L_0x00b8
        L_0x00af:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0308 }
            boolean r2 = r7.applyName(r8, r0, r2)     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x00bc
        L_0x00b8:
            r19 = r6
            goto L_0x026b
        L_0x00bc:
            java.util.List r2 = r7.propertyPreFilters     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x00f0
            int r2 = r2.size()     // Catch:{ all -> 0x0308 }
            if (r2 <= 0) goto L_0x00f0
            if (r1 == 0) goto L_0x00e6
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x00cd
            goto L_0x00e6
        L_0x00cd:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0308 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x00db
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x00f0
        L_0x00db:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0308 }
            boolean r2 = r7.applyName(r8, r0, r2)     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x00f0
            goto L_0x00b8
        L_0x00e6:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0308 }
            boolean r2 = r7.applyName(r8, r0, r2)     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x00f0
            goto L_0x00b8
        L_0x00f0:
            java.util.List r2 = r8.propertyFilters     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x0124
            int r2 = r2.size()     // Catch:{ all -> 0x0308 }
            if (r2 <= 0) goto L_0x0124
            if (r1 == 0) goto L_0x011a
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x0101
            goto L_0x011a
        L_0x0101:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0308 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x010f
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x0124
        L_0x010f:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0308 }
            boolean r2 = r7.apply(r8, r0, r2, r5)     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x0124
            goto L_0x00b8
        L_0x011a:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0308 }
            boolean r2 = r7.apply(r8, r0, r2, r5)     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x0124
            goto L_0x00b8
        L_0x0124:
            java.util.List r2 = r7.propertyFilters     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x015a
            int r2 = r2.size()     // Catch:{ all -> 0x0308 }
            if (r2 <= 0) goto L_0x015a
            if (r1 == 0) goto L_0x014f
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x0135
            goto L_0x014f
        L_0x0135:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0308 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x0143
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x015a
        L_0x0143:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0308 }
            boolean r2 = r7.apply(r8, r0, r2, r5)     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x015a
            goto L_0x00b8
        L_0x014f:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0308 }
            boolean r2 = r7.apply(r8, r0, r2, r5)     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x015a
            goto L_0x00b8
        L_0x015a:
            java.util.List r2 = r8.nameFilters     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x0188
            int r2 = r2.size()     // Catch:{ all -> 0x0308 }
            if (r2 <= 0) goto L_0x0188
            if (r1 == 0) goto L_0x0182
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x016b
            goto L_0x0182
        L_0x016b:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0308 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x0179
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x0188
        L_0x0179:
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0308 }
            java.lang.String r1 = r7.processKey(r8, r0, r1, r5)     // Catch:{ all -> 0x0308 }
            goto L_0x0188
        L_0x0182:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0308 }
            java.lang.String r1 = r7.processKey(r8, r0, r1, r5)     // Catch:{ all -> 0x0308 }
        L_0x0188:
            java.util.List r2 = r7.nameFilters     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x01b6
            int r2 = r2.size()     // Catch:{ all -> 0x0308 }
            if (r2 <= 0) goto L_0x01b6
            if (r1 == 0) goto L_0x01b0
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x0199
            goto L_0x01b0
        L_0x0199:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0308 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0308 }
            if (r2 != 0) goto L_0x01a7
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0308 }
            if (r2 == 0) goto L_0x01b6
        L_0x01a7:
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0308 }
            java.lang.String r1 = r7.processKey(r8, r0, r1, r5)     // Catch:{ all -> 0x0308 }
            goto L_0x01b6
        L_0x01b0:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0308 }
            java.lang.String r1 = r7.processKey(r8, r0, r1, r5)     // Catch:{ all -> 0x0308 }
        L_0x01b6:
            r4 = r1
            java.util.List r1 = r8.valueFilters     // Catch:{ all -> 0x0308 }
            java.util.List r2 = r7.contextValueFilters     // Catch:{ all -> 0x0308 }
            if (r1 == 0) goto L_0x01c3
            int r1 = r1.size()     // Catch:{ all -> 0x0308 }
            if (r1 > 0) goto L_0x01cb
        L_0x01c3:
            if (r2 == 0) goto L_0x0210
            int r1 = r2.size()     // Catch:{ all -> 0x0308 }
            if (r1 <= 0) goto L_0x0210
        L_0x01cb:
            if (r4 == 0) goto L_0x01f9
            boolean r1 = r4 instanceof java.lang.String     // Catch:{ all -> 0x0308 }
            if (r1 == 0) goto L_0x01d2
            goto L_0x01f9
        L_0x01d2:
            java.lang.Class r1 = r4.getClass()     // Catch:{ all -> 0x0308 }
            boolean r1 = r1.isPrimitive()     // Catch:{ all -> 0x0308 }
            if (r1 != 0) goto L_0x01e0
            boolean r1 = r4 instanceof java.lang.Number     // Catch:{ all -> 0x0308 }
            if (r1 == 0) goto L_0x0210
        L_0x01e0:
            java.lang.String r17 = com.alibaba.fastjson.JSON.toJSONString(r4)     // Catch:{ all -> 0x0308 }
            r3 = 0
            r1 = r20
            r2 = r21
            r12 = r4
            r4 = r22
            r18 = r5
            r5 = r17
            r19 = r6
            r6 = r18
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0308 }
            goto L_0x020e
        L_0x01f9:
            r12 = r4
            r18 = r5
            r19 = r6
            r3 = 0
            r5 = r12
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0308 }
            r1 = r20
            r2 = r21
            r4 = r22
            r6 = r18
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0308 }
        L_0x020e:
            r6 = r1
            goto L_0x0217
        L_0x0210:
            r12 = r4
            r18 = r5
            r19 = r6
            r6 = r18
        L_0x0217:
            java.util.List r1 = r7.valueFilters     // Catch:{ all -> 0x0308 }
            java.util.List r2 = r7.contextValueFilters     // Catch:{ all -> 0x0308 }
            if (r1 == 0) goto L_0x0223
            int r1 = r1.size()     // Catch:{ all -> 0x0308 }
            if (r1 > 0) goto L_0x022b
        L_0x0223:
            if (r2 == 0) goto L_0x0260
            int r1 = r2.size()     // Catch:{ all -> 0x0308 }
            if (r1 <= 0) goto L_0x0260
        L_0x022b:
            if (r12 == 0) goto L_0x0250
            boolean r1 = r12 instanceof java.lang.String     // Catch:{ all -> 0x0308 }
            if (r1 == 0) goto L_0x0232
            goto L_0x0250
        L_0x0232:
            java.lang.Class r1 = r12.getClass()     // Catch:{ all -> 0x0308 }
            boolean r1 = r1.isPrimitive()     // Catch:{ all -> 0x0308 }
            if (r1 != 0) goto L_0x0240
            boolean r1 = r12 instanceof java.lang.Number     // Catch:{ all -> 0x0308 }
            if (r1 == 0) goto L_0x0260
        L_0x0240:
            java.lang.String r5 = com.alibaba.fastjson.JSON.toJSONString(r12)     // Catch:{ all -> 0x0308 }
            r3 = 0
            r1 = r20
            r2 = r21
            r4 = r22
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0308 }
            goto L_0x025e
        L_0x0250:
            r3 = 0
            r5 = r12
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0308 }
            r1 = r20
            r2 = r21
            r4 = r22
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0308 }
        L_0x025e:
            r3 = r1
            goto L_0x0261
        L_0x0260:
            r3 = r6
        L_0x0261:
            if (r3 != 0) goto L_0x0270
            int r1 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES     // Catch:{ all -> 0x0308 }
            boolean r1 = r9.isEnabled((int) r1)     // Catch:{ all -> 0x0308 }
            if (r1 != 0) goto L_0x0270
        L_0x026b:
            r6 = r19
            r12 = 0
            goto L_0x0071
        L_0x0270:
            boolean r1 = r12 instanceof java.lang.String     // Catch:{ all -> 0x0308 }
            r2 = 44
            if (r1 == 0) goto L_0x028d
            r4 = r12
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0308 }
            if (r15 != 0) goto L_0x027e
            r9.write((int) r2)     // Catch:{ all -> 0x0308 }
        L_0x027e:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ all -> 0x0308 }
            boolean r1 = r9.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x0308 }
            if (r1 == 0) goto L_0x0289
            r21.println()     // Catch:{ all -> 0x0308 }
        L_0x0289:
            r9.writeFieldName(r4, r13)     // Catch:{ all -> 0x0308 }
            goto L_0x02bb
        L_0x028d:
            if (r15 != 0) goto L_0x0292
            r9.write((int) r2)     // Catch:{ all -> 0x0308 }
        L_0x0292:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible     // Catch:{ all -> 0x0308 }
            boolean r1 = r9.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x0308 }
            if (r1 != 0) goto L_0x02af
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringKeyAsString     // Catch:{ all -> 0x0308 }
            boolean r1 = r9.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x0308 }
            if (r1 != 0) goto L_0x02af
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure     // Catch:{ all -> 0x0308 }
            boolean r1 = r9.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x0308 }
            if (r1 == 0) goto L_0x02ab
            goto L_0x02af
        L_0x02ab:
            r8.write((java.lang.Object) r12)     // Catch:{ all -> 0x0308 }
            goto L_0x02b6
        L_0x02af:
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r12)     // Catch:{ all -> 0x0308 }
            r8.write((java.lang.String) r1)     // Catch:{ all -> 0x0308 }
        L_0x02b6:
            r1 = 58
            r9.write((int) r1)     // Catch:{ all -> 0x0308 }
        L_0x02bb:
            if (r3 != 0) goto L_0x02c6
            r9.writeNull()     // Catch:{ all -> 0x0308 }
        L_0x02c0:
            r6 = r19
        L_0x02c2:
            r12 = 0
            r15 = 0
            goto L_0x0071
        L_0x02c6:
            java.lang.Class r15 = r3.getClass()     // Catch:{ all -> 0x0308 }
            r6 = r19
            if (r15 != r6) goto L_0x02dc
            r5 = 0
            r15 = 0
            r1 = r16
            r2 = r21
            r4 = r12
            r19 = r6
            r6 = r15
            r1.write(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0308 }
            goto L_0x02c0
        L_0x02dc:
            com.alibaba.fastjson.serializer.ObjectSerializer r16 = r8.getObjectWriter(r15)     // Catch:{ all -> 0x0308 }
            r5 = 0
            r6 = 0
            r1 = r16
            r2 = r21
            r4 = r12
            r1.write(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0308 }
            r6 = r15
            goto L_0x02c2
        L_0x02ec:
            r8.context = r11
            r21.decrementIdent()
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat
            boolean r0 = r9.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)
            if (r0 == 0) goto L_0x0302
            int r0 = r10.size()
            if (r0 <= 0) goto L_0x0302
            r21.println()
        L_0x0302:
            r0 = 125(0x7d, float:1.75E-43)
            r9.write((int) r0)
            return
        L_0x0308:
            r0 = move-exception
            r8.context = r11
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int):void");
    }
}
