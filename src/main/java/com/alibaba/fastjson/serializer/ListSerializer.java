package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    /* JADX INFO: finally extract failed */
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        int i2;
        Object obj3;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj4 = obj;
        boolean isEnabled = jSONSerializer2.out.isEnabled(SerializerFeature.WriteClassName);
        SerializeWriter serializeWriter = jSONSerializer2.out;
        Type collectionItemType = isEnabled ? TypeUtils.getCollectionItemType(type) : null;
        if (obj4 == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj4;
        if (list.size() == 0) {
            serializeWriter.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext = jSONSerializer2.context;
        jSONSerializer2.setContext(serialContext, obj4, obj2, 0);
        try {
            char c = ',';
            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                serializeWriter.append('[');
                jSONSerializer.incrementIndent();
                int i3 = 0;
                for (Object next : list) {
                    if (i3 != 0) {
                        serializeWriter.append(c);
                    }
                    jSONSerializer.println();
                    if (next == null) {
                        jSONSerializer2.out.writeNull();
                    } else if (jSONSerializer2.containsReference(next)) {
                        jSONSerializer2.writeReference(next);
                    } else {
                        ObjectSerializer objectWriter = jSONSerializer2.getObjectWriter(next.getClass());
                        SerialContext serialContext2 = r1;
                        SerialContext serialContext3 = new SerialContext(serialContext, obj, obj2, 0, 0);
                        jSONSerializer2.context = serialContext2;
                        objectWriter.write(jSONSerializer, next, Integer.valueOf(i3), collectionItemType, 0);
                    }
                    i3++;
                    c = ',';
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.append(']');
                jSONSerializer2.context = serialContext;
                return;
            }
            serializeWriter.append('[');
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj5 = list.get(i4);
                if (i4 != 0) {
                    serializeWriter.append(',');
                }
                if (obj5 == null) {
                    serializeWriter.append((CharSequence) "null");
                } else {
                    Class<?> cls = obj5.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) obj5).intValue());
                    } else if (cls == Long.class) {
                        long longValue = ((Long) obj5).longValue();
                        if (isEnabled) {
                            serializeWriter.writeLong(longValue);
                            serializeWriter.write(76);
                        } else {
                            serializeWriter.writeLong(longValue);
                        }
                    } else {
                        if (!serializeWriter.disableCircularReferenceDetect) {
                            SerialContext serialContext4 = r1;
                            obj3 = obj5;
                            i2 = i4;
                            SerialContext serialContext5 = new SerialContext(serialContext, obj, obj2, 0, 0);
                            jSONSerializer2.context = serialContext4;
                        } else {
                            obj3 = obj5;
                            i2 = i4;
                        }
                        if (jSONSerializer2.containsReference(obj3)) {
                            jSONSerializer2.writeReference(obj3);
                        } else {
                            jSONSerializer2.getObjectWriter(obj3.getClass()).write(jSONSerializer, obj3, Integer.valueOf(i2), collectionItemType, 0);
                        }
                        i4 = i2 + 1;
                        Object obj6 = obj;
                    }
                }
                i2 = i4;
                i4 = i2 + 1;
                Object obj62 = obj;
            }
            serializeWriter.append(']');
            jSONSerializer2.context = serialContext;
        } catch (Throwable th) {
            jSONSerializer2.context = serialContext;
            throw th;
        }
    }
}
