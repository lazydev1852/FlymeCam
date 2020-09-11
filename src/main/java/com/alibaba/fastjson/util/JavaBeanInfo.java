package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        if (jSONType != null) {
            String typeName2 = jSONType.typeName();
            if (typeName2.length() != 0) {
                this.typeName = typeName2;
            } else {
                this.typeName = cls.getName();
            }
        } else {
            this.typeName = cls.getName();
        }
        this.fields = new FieldInfo[list.size()];
        list.toArray(this.fields);
        FieldInfo[] fieldInfoArr = new FieldInfo[this.fields.length];
        int i = 0;
        System.arraycopy(this.fields, 0, fieldInfoArr, 0, this.fields.length);
        Arrays.sort(fieldInfoArr);
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr) ? this.fields : fieldInfoArr;
        this.defaultConstructorParameterSize = constructor != null ? constructor.getParameterTypes().length : i;
    }

    private static FieldInfo getField(List<FieldInfo> list, String str) {
        for (FieldInfo next : list) {
            if (next.name.equals(str)) {
                return next;
            }
        }
        return null;
    }

    static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        FieldInfo fieldInfo2;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            fieldInfo2 = list.get(size);
            if (!fieldInfo2.name.equals(fieldInfo.name) || (fieldInfo2.getOnly && !fieldInfo.getOnly)) {
                size--;
            }
        }
        if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
            list.remove(size);
        } else if (fieldInfo2.compareTo(fieldInfo) >= 0) {
            return false;
        } else {
            list.remove(size);
        }
        list.add(fieldInfo);
        return true;
    }

    /* JADX WARNING: type inference failed for: r1v53, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0555, code lost:
        if ((java.util.Map.class.isAssignableFrom(r0) || java.util.Collection.class.isAssignableFrom(r0) || java.util.concurrent.atomic.AtomicLong.class.equals(r0) || java.util.concurrent.atomic.AtomicInteger.class.equals(r0) || java.util.concurrent.atomic.AtomicBoolean.class.equals(r0)) == false) goto L_0x051b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x04df  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0511  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x05f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.fastjson.util.JavaBeanInfo build(java.lang.Class<?> r40, java.lang.reflect.Type r41, com.alibaba.fastjson.PropertyNamingStrategy r42) {
        /*
            r12 = r40
            r13 = r42
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r0 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r0 = r12.getAnnotation(r0)
            r14 = r0
            com.alibaba.fastjson.annotation.JSONType r14 = (com.alibaba.fastjson.annotation.JSONType) r14
            java.lang.Class r15 = getBuilderClass(r14)
            java.lang.reflect.Field[] r11 = r40.getDeclaredFields()
            java.lang.reflect.Method[] r10 = r40.getMethods()
            if (r15 != 0) goto L_0x001d
            r0 = r12
            goto L_0x001e
        L_0x001d:
            r0 = r15
        L_0x001e:
            java.lang.reflect.Constructor r16 = getDefaultConstructor(r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r17 = 0
            r8 = 0
            if (r16 != 0) goto L_0x0162
            boolean r0 = r40.isInterface()
            if (r0 != 0) goto L_0x0162
            int r0 = r40.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isAbstract(r0)
            if (r0 != 0) goto L_0x0162
            java.lang.reflect.Constructor r13 = getCreatorConstructor(r40)
            if (r13 == 0) goto L_0x00c5
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r13)
            java.lang.Class[] r10 = r13.getParameterTypes()
            int r0 = r10.length
            if (r0 <= 0) goto L_0x00b5
            java.lang.annotation.Annotation[][] r16 = r13.getParameterAnnotations()
            r7 = 0
        L_0x0051:
            int r0 = r10.length
            if (r7 >= r0) goto L_0x00b5
            r0 = r16[r7]
            int r1 = r0.length
            r2 = 0
        L_0x0058:
            if (r2 >= r1) goto L_0x0067
            r3 = r0[r2]
            boolean r4 = r3 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r4 == 0) goto L_0x0064
            r0 = r3
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            goto L_0x0069
        L_0x0064:
            int r2 = r2 + 1
            goto L_0x0058
        L_0x0067:
            r0 = r17
        L_0x0069:
            if (r0 == 0) goto L_0x00ad
            r3 = r10[r7]
            java.lang.reflect.Type[] r1 = r13.getGenericParameterTypes()
            r4 = r1[r7]
            java.lang.String r1 = r0.name()
            java.lang.reflect.Field r5 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r1, r11)
            int r6 = r0.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r0.serialzeFeatures()
            int r18 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r1)
            com.alibaba.fastjson.parser.Feature[] r1 = r0.parseFeatures()
            int r19 = com.alibaba.fastjson.parser.Feature.m395of(r1)
            com.alibaba.fastjson.util.FieldInfo r2 = new com.alibaba.fastjson.util.FieldInfo
            java.lang.String r1 = r0.name()
            r0 = r2
            r20 = r10
            r10 = r2
            r2 = r40
            r21 = r7
            r7 = r18
            r8 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r9, r10)
            int r7 = r21 + 1
            r10 = r20
            r8 = 0
            goto L_0x0051
        L_0x00ad:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "illegal json creator"
            r0.<init>(r1)
            throw r0
        L_0x00b5:
            com.alibaba.fastjson.util.JavaBeanInfo r10 = new com.alibaba.fastjson.util.JavaBeanInfo
            r3 = 0
            r5 = 0
            r6 = 0
            r0 = r10
            r1 = r40
            r2 = r15
            r4 = r13
            r7 = r14
            r8 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r10
        L_0x00c5:
            java.lang.reflect.Method r10 = getFactoryMethod(r12, r10)
            if (r10 == 0) goto L_0x014b
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r10)
            java.lang.Class[] r13 = r10.getParameterTypes()
            int r0 = r13.length
            if (r0 <= 0) goto L_0x013b
            java.lang.annotation.Annotation[][] r16 = r10.getParameterAnnotations()
            r8 = 0
        L_0x00da:
            int r0 = r13.length
            if (r8 >= r0) goto L_0x013b
            r0 = r16[r8]
            int r1 = r0.length
            r2 = 0
        L_0x00e1:
            if (r2 >= r1) goto L_0x00f0
            r3 = r0[r2]
            boolean r4 = r3 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r4 == 0) goto L_0x00ed
            r0 = r3
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            goto L_0x00f2
        L_0x00ed:
            int r2 = r2 + 1
            goto L_0x00e1
        L_0x00f0:
            r0 = r17
        L_0x00f2:
            if (r0 == 0) goto L_0x0133
            r3 = r13[r8]
            java.lang.reflect.Type[] r1 = r10.getGenericParameterTypes()
            r4 = r1[r8]
            java.lang.String r1 = r0.name()
            java.lang.reflect.Field r5 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r1, r11)
            int r6 = r0.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r0.serialzeFeatures()
            int r7 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r1)
            com.alibaba.fastjson.parser.Feature[] r1 = r0.parseFeatures()
            int r18 = com.alibaba.fastjson.parser.Feature.m395of(r1)
            com.alibaba.fastjson.util.FieldInfo r2 = new com.alibaba.fastjson.util.FieldInfo
            java.lang.String r1 = r0.name()
            r0 = r2
            r23 = r11
            r11 = r2
            r2 = r40
            r19 = r8
            r8 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r9, r11)
            int r8 = r19 + 1
            r11 = r23
            goto L_0x00da
        L_0x0133:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "illegal json creator"
            r0.<init>(r1)
            throw r0
        L_0x013b:
            com.alibaba.fastjson.util.JavaBeanInfo r11 = new com.alibaba.fastjson.util.JavaBeanInfo
            r3 = 0
            r4 = 0
            r6 = 0
            r0 = r11
            r1 = r40
            r2 = r15
            r5 = r10
            r7 = r14
            r8 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r11
        L_0x014b:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "default constructor not found. "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0162:
            r23 = r11
            if (r16 == 0) goto L_0x0169
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r16)
        L_0x0169:
            if (r15 == 0) goto L_0x030e
            java.lang.Class<com.alibaba.fastjson.annotation.JSONPOJOBuilder> r0 = com.alibaba.fastjson.annotation.JSONPOJOBuilder.class
            java.lang.annotation.Annotation r0 = r15.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONPOJOBuilder r0 = (com.alibaba.fastjson.annotation.JSONPOJOBuilder) r0
            if (r0 == 0) goto L_0x017a
            java.lang.String r0 = r0.withPrefix()
            goto L_0x017c
        L_0x017a:
            r0 = r17
        L_0x017c:
            if (r0 == 0) goto L_0x0187
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0185
            goto L_0x0187
        L_0x0185:
            r11 = r0
            goto L_0x018a
        L_0x0187:
            java.lang.String r0 = "with"
            goto L_0x0185
        L_0x018a:
            java.lang.reflect.Method[] r8 = r15.getMethods()
            int r7 = r8.length
            r6 = 0
        L_0x0190:
            if (r6 >= r7) goto L_0x02c2
            r2 = r8[r6]
            int r0 = r2.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 == 0) goto L_0x01af
        L_0x019e:
            r27 = r6
            r28 = r7
            r29 = r8
            r13 = r9
            r31 = r10
            r34 = r11
            r32 = r14
            r14 = r23
            goto L_0x02af
        L_0x01af:
            java.lang.Class r0 = r2.getReturnType()
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x01ba
            goto L_0x019e
        L_0x01ba:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r0 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            if (r0 != 0) goto L_0x01c8
            com.alibaba.fastjson.annotation.JSONField r0 = com.alibaba.fastjson.util.TypeUtils.getSuperMethodAnnotation(r12, r2)
        L_0x01c8:
            r18 = r0
            if (r18 == 0) goto L_0x023e
            boolean r0 = r18.deserialize()
            if (r0 != 0) goto L_0x01d3
            goto L_0x019e
        L_0x01d3:
            int r19 = r18.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r18.serialzeFeatures()
            int r20 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r18.parseFeatures()
            int r21 = com.alibaba.fastjson.parser.Feature.m395of(r0)
            java.lang.String r0 = r18.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x0229
            java.lang.String r1 = r18.name()
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r24 = 0
            r25 = 0
            r0 = r5
            r4 = r40
            r26 = r5
            r5 = r41
            r27 = r6
            r6 = r19
            r28 = r7
            r7 = r20
            r29 = r8
            r8 = r21
            r30 = r9
            r9 = r18
            r31 = r10
            r10 = r24
            r13 = r11
            r32 = r14
            r14 = r23
            r11 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r26
            r11 = r30
            add(r11, r0)
            goto L_0x0259
        L_0x0229:
            r27 = r6
            r28 = r7
            r29 = r8
            r31 = r10
            r13 = r11
            r32 = r14
            r14 = r23
            r11 = r9
            r6 = r19
            r7 = r20
            r8 = r21
            goto L_0x024f
        L_0x023e:
            r27 = r6
            r28 = r7
            r29 = r8
            r31 = r10
            r13 = r11
            r32 = r14
            r14 = r23
            r11 = r9
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x024f:
            java.lang.String r0 = r2.getName()
            boolean r1 = r0.startsWith(r13)
            if (r1 != 0) goto L_0x025d
        L_0x0259:
            r34 = r13
            r13 = r11
            goto L_0x02af
        L_0x025d:
            int r1 = r0.length()
            int r3 = r13.length()
            if (r1 > r3) goto L_0x0268
            goto L_0x0259
        L_0x0268:
            int r1 = r13.length()
            char r1 = r0.charAt(r1)
            boolean r3 = java.lang.Character.isUpperCase(r1)
            if (r3 != 0) goto L_0x0277
            goto L_0x0259
        L_0x0277:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r4 = r13.length()
            java.lang.String r0 = r0.substring(r4)
            r3.<init>(r0)
            char r0 = java.lang.Character.toLowerCase(r1)
            r10 = 0
            r3.setCharAt(r10, r0)
            java.lang.String r1 = r3.toString()
            com.alibaba.fastjson.util.FieldInfo r9 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r19 = 0
            r20 = 0
            r0 = r9
            r4 = r40
            r5 = r41
            r33 = r9
            r9 = r18
            r10 = r19
            r34 = r13
            r13 = r11
            r11 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r33
            add(r13, r0)
        L_0x02af:
            int r6 = r27 + 1
            r9 = r13
            r23 = r14
            r7 = r28
            r8 = r29
            r10 = r31
            r14 = r32
            r11 = r34
            r13 = r42
            goto L_0x0190
        L_0x02c2:
            r13 = r9
            r31 = r10
            r32 = r14
            r14 = r23
            if (r15 == 0) goto L_0x0315
            java.lang.Class<com.alibaba.fastjson.annotation.JSONPOJOBuilder> r0 = com.alibaba.fastjson.annotation.JSONPOJOBuilder.class
            java.lang.annotation.Annotation r0 = r15.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONPOJOBuilder r0 = (com.alibaba.fastjson.annotation.JSONPOJOBuilder) r0
            if (r0 == 0) goto L_0x02da
            java.lang.String r0 = r0.buildMethod()
            goto L_0x02dc
        L_0x02da:
            r0 = r17
        L_0x02dc:
            if (r0 == 0) goto L_0x02e7
            int r1 = r0.length()
            if (r1 != 0) goto L_0x02e5
            goto L_0x02e7
        L_0x02e5:
            r11 = 0
            goto L_0x02ea
        L_0x02e7:
            java.lang.String r0 = "build"
            goto L_0x02e5
        L_0x02ea:
            java.lang.Class[] r1 = new java.lang.Class[r11]     // Catch:{ NoSuchMethodException | SecurityException -> 0x02f1 }
            java.lang.reflect.Method r0 = r15.getMethod(r0, r1)     // Catch:{ NoSuchMethodException | SecurityException -> 0x02f1 }
            goto L_0x02f3
        L_0x02f1:
            r0 = r17
        L_0x02f3:
            if (r0 != 0) goto L_0x02fe
            java.lang.String r1 = "create"
            java.lang.Class[] r2 = new java.lang.Class[r11]     // Catch:{ NoSuchMethodException | SecurityException -> 0x02fe }
            java.lang.reflect.Method r1 = r15.getMethod(r1, r2)     // Catch:{ NoSuchMethodException | SecurityException -> 0x02fe }
            r0 = r1
        L_0x02fe:
            if (r0 == 0) goto L_0x0306
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r0)
            r18 = r0
            goto L_0x0318
        L_0x0306:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "buildMethod not found."
            r0.<init>(r1)
            throw r0
        L_0x030e:
            r13 = r9
            r31 = r10
            r32 = r14
            r14 = r23
        L_0x0315:
            r11 = 0
            r18 = r17
        L_0x0318:
            r10 = r31
            int r9 = r10.length
            r8 = 0
        L_0x031c:
            r7 = 4
            r6 = 3
            r5 = 1
            if (r8 >= r9) goto L_0x0505
            r2 = r10[r8]
            java.lang.String r0 = r2.getName()
            int r1 = r0.length()
            if (r1 >= r7) goto L_0x0339
        L_0x032d:
            r25 = r8
            r26 = r9
            r27 = r10
            r36 = r15
        L_0x0335:
            r15 = r42
            goto L_0x04f8
        L_0x0339:
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x0344
            goto L_0x032d
        L_0x0344:
            java.lang.Class r1 = r2.getReturnType()
            java.lang.Class r3 = java.lang.Void.TYPE
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x035f
            java.lang.Class r1 = r2.getReturnType()
            java.lang.Class r3 = r2.getDeclaringClass()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x035f
            goto L_0x032d
        L_0x035f:
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r3 = r1.length
            if (r3 == r5) goto L_0x0367
            goto L_0x032d
        L_0x0367:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r3 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r3 = r2.getAnnotation(r3)
            com.alibaba.fastjson.annotation.JSONField r3 = (com.alibaba.fastjson.annotation.JSONField) r3
            if (r3 != 0) goto L_0x0375
            com.alibaba.fastjson.annotation.JSONField r3 = com.alibaba.fastjson.util.TypeUtils.getSuperMethodAnnotation(r12, r2)
        L_0x0375:
            r19 = r3
            if (r19 == 0) goto L_0x03d9
            boolean r3 = r19.deserialize()
            if (r3 != 0) goto L_0x0380
            goto L_0x032d
        L_0x0380:
            int r20 = r19.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r3 = r19.serialzeFeatures()
            int r21 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r3)
            com.alibaba.fastjson.parser.Feature[] r3 = r19.parseFeatures()
            int r22 = com.alibaba.fastjson.parser.Feature.m395of(r3)
            java.lang.String r3 = r19.name()
            int r3 = r3.length()
            if (r3 == 0) goto L_0x03cf
            java.lang.String r1 = r19.name()
            com.alibaba.fastjson.util.FieldInfo r7 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r23 = 0
            r24 = 0
            r0 = r7
            r4 = r40
            r5 = r41
            r6 = r20
            r35 = r7
            r7 = r21
            r25 = r8
            r8 = r22
            r26 = r9
            r9 = r19
            r27 = r10
            r10 = r23
            r36 = r15
            r15 = 0
            r11 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r35
            add(r13, r0)
            goto L_0x0335
        L_0x03cf:
            r25 = r8
            r26 = r9
            r27 = r10
            r36 = r15
            r15 = 0
            goto L_0x03e8
        L_0x03d9:
            r25 = r8
            r26 = r9
            r27 = r10
            r36 = r15
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
        L_0x03e8:
            java.lang.String r3 = "set"
            boolean r3 = r0.startsWith(r3)
            if (r3 != 0) goto L_0x03f2
        L_0x03f0:
            goto L_0x0335
        L_0x03f2:
            char r3 = r0.charAt(r6)
            boolean r4 = java.lang.Character.isUpperCase(r3)
            if (r4 != 0) goto L_0x042d
            r4 = 512(0x200, float:7.175E-43)
            if (r3 <= r4) goto L_0x0401
            goto L_0x042d
        L_0x0401:
            r4 = 95
            if (r3 != r4) goto L_0x040a
            java.lang.String r0 = r0.substring(r7)
            goto L_0x0455
        L_0x040a:
            r4 = 102(0x66, float:1.43E-43)
            if (r3 != r4) goto L_0x0413
            java.lang.String r0 = r0.substring(r6)
            goto L_0x0455
        L_0x0413:
            int r3 = r0.length()
            r4 = 5
            if (r3 < r4) goto L_0x0335
            char r3 = r0.charAt(r7)
            boolean r3 = java.lang.Character.isUpperCase(r3)
            if (r3 == 0) goto L_0x0335
            java.lang.String r0 = r0.substring(r6)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
            goto L_0x0455
        L_0x042d:
            boolean r3 = com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean
            if (r3 == 0) goto L_0x043a
            java.lang.String r0 = r0.substring(r6)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
            goto L_0x0455
        L_0x043a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            char r4 = r0.charAt(r6)
            char r4 = java.lang.Character.toLowerCase(r4)
            r3.append(r4)
            java.lang.String r0 = r0.substring(r7)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L_0x0455:
            java.lang.reflect.Field r3 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r0, r14)
            if (r3 != 0) goto L_0x0486
            r1 = r1[r15]
            java.lang.Class r4 = java.lang.Boolean.TYPE
            if (r1 != r4) goto L_0x0486
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "is"
            r1.append(r3)
            char r3 = r0.charAt(r15)
            char r3 = java.lang.Character.toUpperCase(r3)
            r1.append(r3)
            java.lang.String r3 = r0.substring(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r1, r14)
            r3 = r1
        L_0x0486:
            if (r3 == 0) goto L_0x04d3
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
            r10 = r1
            com.alibaba.fastjson.annotation.JSONField r10 = (com.alibaba.fastjson.annotation.JSONField) r10
            if (r10 == 0) goto L_0x04d5
            boolean r1 = r10.deserialize()
            if (r1 != 0) goto L_0x049b
            goto L_0x03f0
        L_0x049b:
            int r6 = r10.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r10.serialzeFeatures()
            int r7 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r1)
            com.alibaba.fastjson.parser.Feature[] r1 = r10.parseFeatures()
            int r8 = com.alibaba.fastjson.parser.Feature.m395of(r1)
            java.lang.String r1 = r10.name()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x04db
            java.lang.String r1 = r10.name()
            com.alibaba.fastjson.util.FieldInfo r11 = new com.alibaba.fastjson.util.FieldInfo
            r20 = 0
            r0 = r11
            r4 = r40
            r5 = r41
            r9 = r19
            r15 = r11
            r11 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            add(r13, r15)
            goto L_0x0335
        L_0x04d3:
            r10 = r17
        L_0x04d5:
            r6 = r20
            r7 = r21
            r8 = r22
        L_0x04db:
            r15 = r42
            if (r15 == 0) goto L_0x04e3
            java.lang.String r0 = r15.translate(r0)
        L_0x04e3:
            r1 = r0
            com.alibaba.fastjson.util.FieldInfo r11 = new com.alibaba.fastjson.util.FieldInfo
            r20 = 0
            r0 = r11
            r4 = r40
            r5 = r41
            r9 = r19
            r12 = r11
            r11 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            add(r13, r12)
        L_0x04f8:
            int r8 = r25 + 1
            r9 = r26
            r10 = r27
            r15 = r36
            r11 = 0
            r12 = r40
            goto L_0x031c
        L_0x0505:
            r36 = r15
            r15 = r42
            java.lang.reflect.Field[] r12 = r40.getFields()
            int r14 = r12.length
            r11 = 0
        L_0x050f:
            if (r11 >= r14) goto L_0x05ed
            r3 = r12[r11]
            int r0 = r3.getModifiers()
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0521
        L_0x051b:
            r17 = r11
            r21 = 1
            goto L_0x05e6
        L_0x0521:
            r0 = r0 & 16
            if (r0 == 0) goto L_0x0558
            java.lang.Class r0 = r3.getType()
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            boolean r1 = r1.isAssignableFrom(r0)
            if (r1 != 0) goto L_0x0554
            java.lang.Class<java.util.Collection> r1 = java.util.Collection.class
            boolean r1 = r1.isAssignableFrom(r0)
            if (r1 != 0) goto L_0x0554
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r1 = java.util.concurrent.atomic.AtomicLong.class
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0554
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r1 = java.util.concurrent.atomic.AtomicInteger.class
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0554
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r1 = java.util.concurrent.atomic.AtomicBoolean.class
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0552
            goto L_0x0554
        L_0x0552:
            r0 = 0
            goto L_0x0555
        L_0x0554:
            r0 = 1
        L_0x0555:
            if (r0 != 0) goto L_0x0558
            goto L_0x051b
        L_0x0558:
            java.util.Iterator r0 = r13.iterator()
        L_0x055c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0576
            java.lang.Object r1 = r0.next()
            com.alibaba.fastjson.util.FieldInfo r1 = (com.alibaba.fastjson.util.FieldInfo) r1
            java.lang.String r1 = r1.name
            java.lang.String r2 = r3.getName()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x055c
            r0 = 1
            goto L_0x0577
        L_0x0576:
            r0 = 0
        L_0x0577:
            if (r0 == 0) goto L_0x057a
            goto L_0x051b
        L_0x057a:
            java.lang.String r0 = r3.getName()
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
            r10 = r1
            com.alibaba.fastjson.annotation.JSONField r10 = (com.alibaba.fastjson.annotation.JSONField) r10
            if (r10 == 0) goto L_0x05b7
            boolean r1 = r10.deserialize()
            if (r1 != 0) goto L_0x0590
            goto L_0x051b
        L_0x0590:
            int r1 = r10.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r2 = r10.serialzeFeatures()
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r2)
            com.alibaba.fastjson.parser.Feature[] r4 = r10.parseFeatures()
            int r4 = com.alibaba.fastjson.parser.Feature.m395of(r4)
            java.lang.String r8 = r10.name()
            int r8 = r8.length()
            if (r8 == 0) goto L_0x05b2
            java.lang.String r0 = r10.name()
        L_0x05b2:
            r8 = r1
            r9 = r2
            r17 = r4
            goto L_0x05bb
        L_0x05b7:
            r8 = 0
            r9 = 0
            r17 = 0
        L_0x05bb:
            if (r15 == 0) goto L_0x05c1
            java.lang.String r0 = r15.translate(r0)
        L_0x05c1:
            r1 = r0
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r2 = 0
            r19 = 0
            r20 = 0
            r0 = r4
            r38 = r4
            r4 = r40
            r21 = 1
            r5 = r41
            r6 = r8
            r8 = 4
            r7 = r9
            r9 = 4
            r8 = r17
            r9 = r19
            r17 = r11
            r11 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r38
            add(r13, r0)
        L_0x05e6:
            int r11 = r17 + 1
            r5 = 1
            r6 = 3
            r7 = 4
            goto L_0x050f
        L_0x05ed:
            java.lang.reflect.Method[] r12 = r40.getMethods()
            int r14 = r12.length
            r11 = 0
        L_0x05f3:
            if (r11 >= r14) goto L_0x06da
            r2 = r12[r11]
            java.lang.String r0 = r2.getName()
            int r1 = r0.length()
            r10 = 4
            if (r1 >= r10) goto L_0x060a
        L_0x0602:
            r37 = r11
            r17 = 4
            r19 = 3
            goto L_0x06d6
        L_0x060a:
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x0615
            goto L_0x0602
        L_0x0615:
            java.lang.String r1 = "get"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0602
            r9 = 3
            char r1 = r0.charAt(r9)
            boolean r1 = java.lang.Character.isUpperCase(r1)
            if (r1 == 0) goto L_0x0602
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r1 = r1.length
            if (r1 == 0) goto L_0x0630
            goto L_0x0602
        L_0x0630:
            java.lang.Class<java.util.Collection> r1 = java.util.Collection.class
            java.lang.Class r3 = r2.getReturnType()
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 != 0) goto L_0x0660
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            java.lang.Class r3 = r2.getReturnType()
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 != 0) goto L_0x0660
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r1 = java.util.concurrent.atomic.AtomicBoolean.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 == r3) goto L_0x0660
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r1 = java.util.concurrent.atomic.AtomicInteger.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 == r3) goto L_0x0660
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r1 = java.util.concurrent.atomic.AtomicLong.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 != r3) goto L_0x0602
        L_0x0660:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = r2.getAnnotation(r1)
            r17 = r1
            com.alibaba.fastjson.annotation.JSONField r17 = (com.alibaba.fastjson.annotation.JSONField) r17
            if (r17 == 0) goto L_0x0673
            boolean r1 = r17.deserialize()
            if (r1 == 0) goto L_0x0673
            goto L_0x0602
        L_0x0673:
            if (r17 == 0) goto L_0x0684
            java.lang.String r1 = r17.name()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0684
            java.lang.String r0 = r17.name()
            goto L_0x069f
        L_0x0684:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char r3 = r0.charAt(r9)
            char r3 = java.lang.Character.toLowerCase(r3)
            r1.append(r3)
            java.lang.String r0 = r0.substring(r10)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x069f:
            com.alibaba.fastjson.util.FieldInfo r1 = getField(r13, r0)
            if (r1 == 0) goto L_0x06a7
            goto L_0x0602
        L_0x06a7:
            if (r15 == 0) goto L_0x06ad
            java.lang.String r0 = r15.translate(r0)
        L_0x06ad:
            r1 = r0
            com.alibaba.fastjson.util.FieldInfo r8 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r6 = 0
            r7 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r0 = r8
            r4 = r40
            r5 = r41
            r39 = r8
            r8 = r19
            r19 = 3
            r9 = r17
            r17 = 4
            r10 = r20
            r37 = r11
            r11 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r39
            add(r13, r0)
        L_0x06d6:
            int r11 = r37 + 1
            goto L_0x05f3
        L_0x06da:
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r4 = 0
            r5 = 0
            r0 = r9
            r1 = r40
            r2 = r36
            r3 = r16
            r6 = r18
            r7 = r32
            r8 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.JavaBeanInfo.build(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy):com.alibaba.fastjson.util.JavaBeanInfo");
    }

    static Constructor<?> getDefaultConstructor(Class<?> cls) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Constructor<?> constructor2 = declaredConstructors[i];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i++;
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : declaredConstructors) {
            Class[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    public static Constructor<?> getCreatorConstructor(Class<?> cls) {
        Constructor<?> constructor = null;
        for (Constructor<?> constructor2 : cls.getDeclaredConstructors()) {
            if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                if (constructor == null) {
                    constructor = constructor2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        return constructor;
    }

    private static Method getFactoryMethod(Class<?> cls, Method[] methodArr) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((JSONCreator) method2.getAnnotation(JSONCreator.class)) != null) {
                if (method == null) {
                    method = method2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        return method;
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        Class<?> builder;
        if (jSONType == null || (builder = jSONType.builder()) == Void.class) {
            return null;
        }
        return builder;
    }
}
