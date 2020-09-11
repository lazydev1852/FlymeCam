package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

public class ObjectArrayCodec implements ObjectDeserializer, ObjectSerializer {
    public static final ObjectArrayCodec instance = new ObjectArrayCodec();

    public int getFastMatchToken() {
        return 14;
    }

    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj3 = obj;
        SerializeWriter serializeWriter = jSONSerializer2.out;
        Object[] objArr = (Object[]) obj3;
        if (obj3 == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i2 = length - 1;
        if (i2 == -1) {
            serializeWriter.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext = jSONSerializer2.context;
        jSONSerializer2.setContext(serialContext, obj3, obj2, 0);
        try {
            serializeWriter.append('[');
            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
                for (int i3 = 0; i3 < length; i3++) {
                    if (i3 != 0) {
                        serializeWriter.write(44);
                        jSONSerializer.println();
                    }
                    jSONSerializer2.write(objArr[i3]);
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.write(93);
                return;
            }
            Class<?> cls = null;
            ObjectSerializer objectSerializer = null;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj4 = objArr[i4];
                if (obj4 == null) {
                    serializeWriter.append((CharSequence) "null,");
                } else {
                    if (jSONSerializer2.containsReference(obj4)) {
                        jSONSerializer2.writeReference(obj4);
                    } else {
                        Class<?> cls2 = obj4.getClass();
                        if (cls2 == cls) {
                            objectSerializer.write(jSONSerializer, obj4, (Object) null, (Type) null, 0);
                        } else {
                            ObjectSerializer objectWriter = jSONSerializer2.getObjectWriter(cls2);
                            objectWriter.write(jSONSerializer, obj4, (Object) null, (Type) null, 0);
                            objectSerializer = objectWriter;
                            cls = cls2;
                        }
                    }
                    serializeWriter.append(',');
                }
            }
            Object obj5 = objArr[i2];
            if (obj5 == null) {
                serializeWriter.append((CharSequence) "null]");
            } else {
                if (jSONSerializer2.containsReference(obj5)) {
                    jSONSerializer2.writeReference(obj5);
                } else {
                    jSONSerializer2.writeWithFieldName(obj5, Integer.valueOf(i2));
                }
                serializeWriter.append(']');
            }
            jSONSerializer2.context = serialContext;
        } finally {
            jSONSerializer2.context = serialContext;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.Class} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r7, java.lang.reflect.Type r8, java.lang.Object r9) {
        /*
            r6 = this;
            com.alibaba.fastjson.parser.JSONLexer r0 = r7.lexer
            int r1 = r0.token()
            r2 = 0
            r3 = 16
            r4 = 8
            if (r1 != r4) goto L_0x0011
            r0.nextToken(r3)
            return r2
        L_0x0011:
            int r1 = r0.token()
            r4 = 4
            if (r1 != r4) goto L_0x0020
            byte[] r7 = r0.bytesValue()
            r0.nextToken(r3)
            return r7
        L_0x0020:
            boolean r0 = r8 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x0081
            java.lang.reflect.GenericArrayType r8 = (java.lang.reflect.GenericArrayType) r8
            java.lang.reflect.Type r8 = r8.getGenericComponentType()
            boolean r0 = r8 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x007c
            java.lang.reflect.TypeVariable r8 = (java.lang.reflect.TypeVariable) r8
            com.alibaba.fastjson.parser.ParseContext r0 = r7.getContext()
            java.lang.reflect.Type r0 = r0.type
            boolean r1 = r0 instanceof java.lang.reflect.ParameterizedType
            r3 = 0
            if (r1 == 0) goto L_0x0071
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type r1 = r0.getRawType()
            boolean r4 = r1 instanceof java.lang.Class
            if (r4 == 0) goto L_0x0067
            java.lang.Class r1 = (java.lang.Class) r1
            java.lang.reflect.TypeVariable[] r1 = r1.getTypeParameters()
        L_0x004b:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0067
            r4 = r1[r3]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = r8.getName()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0064
            java.lang.reflect.Type[] r2 = r0.getActualTypeArguments()
            r2 = r2[r3]
        L_0x0064:
            int r3 = r3 + 1
            goto L_0x004b
        L_0x0067:
            boolean r8 = r2 instanceof java.lang.Class
            if (r8 == 0) goto L_0x006e
            java.lang.Class r2 = (java.lang.Class) r2
            goto L_0x0087
        L_0x006e:
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            goto L_0x0087
        L_0x0071:
            java.lang.reflect.Type[] r8 = r8.getBounds()
            r8 = r8[r3]
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r8)
            goto L_0x0087
        L_0x007c:
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r8)
            goto L_0x0087
        L_0x0081:
            java.lang.Class r8 = (java.lang.Class) r8
            java.lang.Class r2 = r8.getComponentType()
        L_0x0087:
            com.alibaba.fastjson.JSONArray r8 = new com.alibaba.fastjson.JSONArray
            r8.<init>()
            r7.parseArray(r2, r8, r9)
            java.lang.Object r7 = r6.toObjectArray(r7, r2, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ObjectArrayCodec.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r13v0, types: [java.lang.reflect.Type, java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T toObjectArray(com.alibaba.fastjson.parser.DefaultJSONParser r12, java.lang.Class<?> r13, com.alibaba.fastjson.JSONArray r14) {
        /*
            r11 = this;
            r0 = 0
            if (r14 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r14.size()
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r13, r1)
            r3 = 0
            r4 = 0
        L_0x000e:
            if (r4 >= r1) goto L_0x0065
            java.lang.Object r5 = r14.get(r4)
            if (r5 != r14) goto L_0x001a
            java.lang.reflect.Array.set(r2, r4, r2)
            goto L_0x0062
        L_0x001a:
            boolean r6 = r13.isArray()
            if (r6 == 0) goto L_0x0031
            boolean r6 = r13.isInstance(r5)
            if (r6 == 0) goto L_0x0027
            goto L_0x002d
        L_0x0027:
            com.alibaba.fastjson.JSONArray r5 = (com.alibaba.fastjson.JSONArray) r5
            java.lang.Object r5 = r11.toObjectArray(r12, r13, r5)
        L_0x002d:
            java.lang.reflect.Array.set(r2, r4, r5)
            goto L_0x0062
        L_0x0031:
            boolean r6 = r5 instanceof com.alibaba.fastjson.JSONArray
            if (r6 == 0) goto L_0x0054
            r6 = r5
            com.alibaba.fastjson.JSONArray r6 = (com.alibaba.fastjson.JSONArray) r6
            int r7 = r6.size()
            r8 = 0
            r9 = 0
        L_0x003e:
            if (r8 >= r7) goto L_0x004d
            java.lang.Object r10 = r6.get(r8)
            if (r10 != r14) goto L_0x004a
            r6.set(r4, r2)
            r9 = 1
        L_0x004a:
            int r8 = r8 + 1
            goto L_0x003e
        L_0x004d:
            if (r9 == 0) goto L_0x0054
            java.lang.Object[] r6 = r6.toArray()
            goto L_0x0055
        L_0x0054:
            r6 = r0
        L_0x0055:
            if (r6 != 0) goto L_0x005f
            com.alibaba.fastjson.parser.ParserConfig r6 = r12.getConfig()
            java.lang.Object r6 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r5, r13, (com.alibaba.fastjson.parser.ParserConfig) r6)
        L_0x005f:
            java.lang.reflect.Array.set(r2, r4, r6)
        L_0x0062:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x0065:
            r14.setRelatedArray(r2)
            r14.setComponentType(r13)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ObjectArrayCodec.toObjectArray(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.Class, com.alibaba.fastjson.JSONArray):java.lang.Object");
    }
}
