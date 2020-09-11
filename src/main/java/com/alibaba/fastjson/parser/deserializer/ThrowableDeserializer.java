package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;

public class ThrowableDeserializer extends JavaBeanDeserializer {
    public int getFastMatchToken() {
        return 12;
    }

    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r13) != false) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r12, java.lang.reflect.Type r13, java.lang.Object r14) {
        /*
            r11 = this;
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer
            int r0 = r14.token()
            r1 = 8
            r2 = 0
            if (r0 != r1) goto L_0x000f
            r14.nextToken()
            return r2
        L_0x000f:
            int r0 = r12.getResolveStatus()
            r3 = 2
            if (r0 != r3) goto L_0x001b
            r0 = 0
            r12.setResolveStatus(r0)
            goto L_0x0023
        L_0x001b:
            int r0 = r14.token()
            r3 = 12
            if (r0 != r3) goto L_0x010e
        L_0x0023:
            if (r13 == 0) goto L_0x0034
            boolean r0 = r13 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0034
            java.lang.Class r13 = (java.lang.Class) r13
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            boolean r0 = r0.isAssignableFrom(r13)
            if (r0 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r13 = r2
        L_0x0035:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r3 = r13
            r13 = r2
            r4 = r13
            r5 = r4
        L_0x003e:
            com.alibaba.fastjson.parser.SymbolTable r6 = r12.getSymbolTable()
            java.lang.String r6 = r14.scanSymbol(r6)
            r7 = 13
            r8 = 16
            if (r6 != 0) goto L_0x0066
            int r9 = r14.token()
            if (r9 != r7) goto L_0x0057
            r14.nextToken(r8)
            goto L_0x00ec
        L_0x0057:
            int r9 = r14.token()
            if (r9 != r8) goto L_0x0066
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas
            boolean r9 = r14.isEnabled((com.alibaba.fastjson.parser.Feature) r9)
            if (r9 == 0) goto L_0x0066
            goto L_0x003e
        L_0x0066:
            r9 = 4
            r14.nextTokenWithColon(r9)
            java.lang.String r10 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0094
            int r3 = r14.token()
            if (r3 != r9) goto L_0x008c
            java.lang.String r3 = r14.stringVal()
            com.alibaba.fastjson.parser.ParserConfig r6 = r12.getConfig()
            java.lang.ClassLoader r6 = r6.getDefaultClassLoader()
            java.lang.Class r3 = com.alibaba.fastjson.util.TypeUtils.loadClass(r3, r6)
            r14.nextToken(r8)
            goto L_0x00e3
        L_0x008c:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            java.lang.String r13 = "syntax error"
            r12.<init>(r13)
            throw r12
        L_0x0094:
            java.lang.String r10 = "message"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x00ba
            int r4 = r14.token()
            if (r4 != r1) goto L_0x00a4
            r4 = r2
            goto L_0x00ae
        L_0x00a4:
            int r4 = r14.token()
            if (r4 != r9) goto L_0x00b2
            java.lang.String r4 = r14.stringVal()
        L_0x00ae:
            r14.nextToken()
            goto L_0x00e3
        L_0x00b2:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            java.lang.String r13 = "syntax error"
            r12.<init>(r13)
            throw r12
        L_0x00ba:
            java.lang.String r9 = "cause"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x00cb
            java.lang.String r13 = "cause"
            java.lang.Object r13 = r11.deserialze(r12, r2, r13)
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            goto L_0x00e3
        L_0x00cb:
            java.lang.String r9 = "stackTrace"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x00dc
            java.lang.Class<java.lang.StackTraceElement[]> r5 = java.lang.StackTraceElement[].class
            java.lang.Object r5 = r12.parseObject(r5)
            java.lang.StackTraceElement[] r5 = (java.lang.StackTraceElement[]) r5
            goto L_0x00e3
        L_0x00dc:
            java.lang.Object r9 = r12.parse()
            r0.put(r6, r9)
        L_0x00e3:
            int r6 = r14.token()
            if (r6 != r7) goto L_0x003e
            r14.nextToken(r8)
        L_0x00ec:
            if (r3 != 0) goto L_0x00f4
            java.lang.Exception r12 = new java.lang.Exception
            r12.<init>(r4, r13)
            goto L_0x00ff
        L_0x00f4:
            java.lang.Throwable r12 = r11.createException(r4, r13, r3)     // Catch:{ Exception -> 0x0105 }
            if (r12 != 0) goto L_0x00ff
            java.lang.Exception r12 = new java.lang.Exception     // Catch:{ Exception -> 0x0105 }
            r12.<init>(r4, r13)     // Catch:{ Exception -> 0x0105 }
        L_0x00ff:
            if (r5 == 0) goto L_0x0104
            r12.setStackTrace(r5)
        L_0x0104:
            return r12
        L_0x0105:
            r12 = move-exception
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            java.lang.String r14 = "create instance error"
            r13.<init>(r14, r12)
            throw r13
        L_0x010e:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            java.lang.String r13 = "syntax error"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor constructor = null;
        Constructor constructor2 = null;
        Constructor constructor3 = null;
        for (Constructor constructor4 : cls.getConstructors()) {
            Class<Throwable>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(new Object[]{str, th});
        } else if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(new Object[]{str});
        } else if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        } else {
            return null;
        }
    }
}
