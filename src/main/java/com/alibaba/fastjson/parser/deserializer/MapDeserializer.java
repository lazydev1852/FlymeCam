package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    public int getFastMatchToken() {
        return 12;
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == JSONObject.class && defaultJSONParser.getFieldTypeResolver() == null) {
            return defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        Map<Object, Object> createMap = createMap(type);
        ParseContext context = defaultJSONParser.getContext();
        try {
            defaultJSONParser.setContext(context, createMap, obj);
            return deserialze(defaultJSONParser, type, obj, createMap);
        } finally {
            defaultJSONParser.setContext(context);
        }
    }

    /* access modifiers changed from: protected */
    public Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map) {
        if (!(type instanceof ParameterizedType)) {
            return defaultJSONParser.parseObject(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = parameterizedType.getActualTypeArguments()[1];
        if (String.class == type2) {
            return parseMap(defaultJSONParser, map, type3, obj);
        }
        return parseMap(defaultJSONParser, map, type2, type3, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r9 = r8.getConfig().getDeserializer((java.lang.reflect.Type) r3);
        r0.nextToken(16);
        r8.setResolveStatus(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0123, code lost:
        if (r1 == null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0127, code lost:
        if ((r11 instanceof java.lang.Integer) != false) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0129, code lost:
        r8.popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012c, code lost:
        r9 = (java.util.Map) r9.deserialze(r8, r3, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0132, code lost:
        r8.setContext(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0135, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map parseMap(com.alibaba.fastjson.parser.DefaultJSONParser r8, java.util.Map<java.lang.String, java.lang.Object> r9, java.lang.reflect.Type r10, java.lang.Object r11) {
        /*
            com.alibaba.fastjson.parser.JSONLexer r0 = r8.lexer
            int r1 = r0.token()
            r2 = 12
            if (r1 != r2) goto L_0x01a9
            com.alibaba.fastjson.parser.ParseContext r1 = r8.getContext()
            r2 = 0
        L_0x000f:
            r0.skipWhitespace()     // Catch:{ all -> 0x01a4 }
            char r3 = r0.getCurrent()     // Catch:{ all -> 0x01a4 }
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x01a4 }
            boolean r4 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r4)     // Catch:{ all -> 0x01a4 }
            if (r4 == 0) goto L_0x002d
        L_0x001e:
            r4 = 44
            if (r3 != r4) goto L_0x002d
            r0.next()     // Catch:{ all -> 0x01a4 }
            r0.skipWhitespace()     // Catch:{ all -> 0x01a4 }
            char r3 = r0.getCurrent()     // Catch:{ all -> 0x01a4 }
            goto L_0x001e
        L_0x002d:
            r4 = 58
            r5 = 34
            r6 = 16
            if (r3 != r5) goto L_0x0063
            com.alibaba.fastjson.parser.SymbolTable r3 = r8.getSymbolTable()     // Catch:{ all -> 0x01a4 }
            java.lang.String r3 = r0.scanSymbol(r3, r5)     // Catch:{ all -> 0x01a4 }
            r0.skipWhitespace()     // Catch:{ all -> 0x01a4 }
            char r7 = r0.getCurrent()     // Catch:{ all -> 0x01a4 }
            if (r7 != r4) goto L_0x0048
            goto L_0x00ce
        L_0x0048:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x01a4 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a4 }
            r10.<init>()     // Catch:{ all -> 0x01a4 }
            java.lang.String r11 = "expect ':' at "
            r10.append(r11)     // Catch:{ all -> 0x01a4 }
            int r11 = r0.pos()     // Catch:{ all -> 0x01a4 }
            r10.append(r11)     // Catch:{ all -> 0x01a4 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01a4 }
            r9.<init>(r10)     // Catch:{ all -> 0x01a4 }
            throw r9     // Catch:{ all -> 0x01a4 }
        L_0x0063:
            r7 = 125(0x7d, float:1.75E-43)
            if (r3 != r7) goto L_0x0074
            r0.next()     // Catch:{ all -> 0x01a4 }
            r0.resetStringPosition()     // Catch:{ all -> 0x01a4 }
            r0.nextToken(r6)     // Catch:{ all -> 0x01a4 }
            r8.setContext(r1)
            return r9
        L_0x0074:
            r7 = 39
            if (r3 != r7) goto L_0x00b5
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x01a4 }
            boolean r3 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r3)     // Catch:{ all -> 0x01a4 }
            if (r3 == 0) goto L_0x00ad
            com.alibaba.fastjson.parser.SymbolTable r3 = r8.getSymbolTable()     // Catch:{ all -> 0x01a4 }
            java.lang.String r3 = r0.scanSymbol(r3, r7)     // Catch:{ all -> 0x01a4 }
            r0.skipWhitespace()     // Catch:{ all -> 0x01a4 }
            char r7 = r0.getCurrent()     // Catch:{ all -> 0x01a4 }
            if (r7 != r4) goto L_0x0092
            goto L_0x00ce
        L_0x0092:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x01a4 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a4 }
            r10.<init>()     // Catch:{ all -> 0x01a4 }
            java.lang.String r11 = "expect ':' at "
            r10.append(r11)     // Catch:{ all -> 0x01a4 }
            int r11 = r0.pos()     // Catch:{ all -> 0x01a4 }
            r10.append(r11)     // Catch:{ all -> 0x01a4 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01a4 }
            r9.<init>(r10)     // Catch:{ all -> 0x01a4 }
            throw r9     // Catch:{ all -> 0x01a4 }
        L_0x00ad:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x01a4 }
            java.lang.String r10 = "syntax error"
            r9.<init>(r10)     // Catch:{ all -> 0x01a4 }
            throw r9     // Catch:{ all -> 0x01a4 }
        L_0x00b5:
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x01a4 }
            boolean r3 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r3)     // Catch:{ all -> 0x01a4 }
            if (r3 == 0) goto L_0x019c
            com.alibaba.fastjson.parser.SymbolTable r3 = r8.getSymbolTable()     // Catch:{ all -> 0x01a4 }
            java.lang.String r3 = r0.scanSymbolUnQuoted(r3)     // Catch:{ all -> 0x01a4 }
            r0.skipWhitespace()     // Catch:{ all -> 0x01a4 }
            char r7 = r0.getCurrent()     // Catch:{ all -> 0x01a4 }
            if (r7 != r4) goto L_0x0179
        L_0x00ce:
            r0.next()     // Catch:{ all -> 0x01a4 }
            r0.skipWhitespace()     // Catch:{ all -> 0x01a4 }
            r0.getCurrent()     // Catch:{ all -> 0x01a4 }
            r0.resetStringPosition()     // Catch:{ all -> 0x01a4 }
            java.lang.String r4 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x01a4 }
            r7 = 13
            if (r3 != r4) goto L_0x0136
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x01a4 }
            boolean r4 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r4)     // Catch:{ all -> 0x01a4 }
            if (r4 != 0) goto L_0x0136
            com.alibaba.fastjson.parser.SymbolTable r3 = r8.getSymbolTable()     // Catch:{ all -> 0x01a4 }
            java.lang.String r3 = r0.scanSymbol(r3, r5)     // Catch:{ all -> 0x01a4 }
            com.alibaba.fastjson.parser.ParserConfig r4 = r8.getConfig()     // Catch:{ all -> 0x01a4 }
            java.lang.ClassLoader r4 = r4.getDefaultClassLoader()     // Catch:{ all -> 0x01a4 }
            java.lang.Class r3 = com.alibaba.fastjson.util.TypeUtils.loadClass(r3, r4)     // Catch:{ all -> 0x01a4 }
            java.lang.Class<java.util.Map> r4 = java.util.Map.class
            boolean r4 = r4.isAssignableFrom(r3)     // Catch:{ all -> 0x01a4 }
            if (r4 == 0) goto L_0x0114
            r0.nextToken(r6)     // Catch:{ all -> 0x01a4 }
            int r3 = r0.token()     // Catch:{ all -> 0x01a4 }
            if (r3 != r7) goto L_0x0171
            r0.nextToken(r6)     // Catch:{ all -> 0x01a4 }
            r8.setContext(r1)
            return r9
        L_0x0114:
            com.alibaba.fastjson.parser.ParserConfig r9 = r8.getConfig()     // Catch:{ all -> 0x01a4 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r9 = r9.getDeserializer((java.lang.reflect.Type) r3)     // Catch:{ all -> 0x01a4 }
            r0.nextToken(r6)     // Catch:{ all -> 0x01a4 }
            r10 = 2
            r8.setResolveStatus(r10)     // Catch:{ all -> 0x01a4 }
            if (r1 == 0) goto L_0x012c
            boolean r10 = r11 instanceof java.lang.Integer     // Catch:{ all -> 0x01a4 }
            if (r10 != 0) goto L_0x012c
            r8.popContext()     // Catch:{ all -> 0x01a4 }
        L_0x012c:
            java.lang.Object r9 = r9.deserialze(r8, r3, r11)     // Catch:{ all -> 0x01a4 }
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ all -> 0x01a4 }
            r8.setContext(r1)
            return r9
        L_0x0136:
            r0.nextToken()     // Catch:{ all -> 0x01a4 }
            if (r2 == 0) goto L_0x013e
            r8.setContext(r1)     // Catch:{ all -> 0x01a4 }
        L_0x013e:
            int r4 = r0.token()     // Catch:{ all -> 0x01a4 }
            r5 = 8
            if (r4 != r5) goto L_0x014b
            r4 = 0
            r0.nextToken()     // Catch:{ all -> 0x01a4 }
            goto L_0x014f
        L_0x014b:
            java.lang.Object r4 = r8.parseObject((java.lang.reflect.Type) r10, (java.lang.Object) r3)     // Catch:{ all -> 0x01a4 }
        L_0x014f:
            r9.put(r3, r4)     // Catch:{ all -> 0x01a4 }
            r8.checkMapResolve(r9, r3)     // Catch:{ all -> 0x01a4 }
            r8.setContext(r1, r4, r3)     // Catch:{ all -> 0x01a4 }
            r8.setContext(r1)     // Catch:{ all -> 0x01a4 }
            int r3 = r0.token()     // Catch:{ all -> 0x01a4 }
            r4 = 20
            if (r3 == r4) goto L_0x0175
            r4 = 15
            if (r3 != r4) goto L_0x0168
            goto L_0x0175
        L_0x0168:
            if (r3 != r7) goto L_0x0171
            r0.nextToken()     // Catch:{ all -> 0x01a4 }
            r8.setContext(r1)
            return r9
        L_0x0171:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0175:
            r8.setContext(r1)
            return r9
        L_0x0179:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x01a4 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a4 }
            r10.<init>()     // Catch:{ all -> 0x01a4 }
            java.lang.String r11 = "expect ':' at "
            r10.append(r11)     // Catch:{ all -> 0x01a4 }
            int r11 = r0.pos()     // Catch:{ all -> 0x01a4 }
            r10.append(r11)     // Catch:{ all -> 0x01a4 }
            java.lang.String r11 = ", actual "
            r10.append(r11)     // Catch:{ all -> 0x01a4 }
            r10.append(r7)     // Catch:{ all -> 0x01a4 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01a4 }
            r9.<init>(r10)     // Catch:{ all -> 0x01a4 }
            throw r9     // Catch:{ all -> 0x01a4 }
        L_0x019c:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x01a4 }
            java.lang.String r10 = "syntax error"
            r9.<init>(r10)     // Catch:{ all -> 0x01a4 }
            throw r9     // Catch:{ all -> 0x01a4 }
        L_0x01a4:
            r9 = move-exception
            r8.setContext(r1)
            throw r9
        L_0x01a9:
            com.alibaba.fastjson.JSONException r8 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "syntax error, expect {, actual "
            r9.append(r10)
            int r10 = r0.token()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.MapDeserializer.parseMap(com.alibaba.fastjson.parser.DefaultJSONParser, java.util.Map, java.lang.reflect.Type, java.lang.Object):java.util.Map");
    }

    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
            ObjectDeserializer deserializer = defaultJSONParser.getConfig().getDeserializer(type);
            ObjectDeserializer deserializer2 = defaultJSONParser.getConfig().getDeserializer(type2);
            jSONLexer.nextToken(deserializer.getFastMatchToken());
            ParseContext context = defaultJSONParser.getContext();
            while (jSONLexer.token() != 13) {
                try {
                    Object obj2 = null;
                    if (jSONLexer.token() != 4 || !jSONLexer.isRef() || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                        if (map.size() == 0 && jSONLexer.token() == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                            jSONLexer.nextTokenWithColon(4);
                            jSONLexer.nextToken(16);
                            if (jSONLexer.token() == 13) {
                                jSONLexer.nextToken();
                                return map;
                            }
                            jSONLexer.nextToken(deserializer.getFastMatchToken());
                        }
                        Object deserialze = deserializer.deserialze(defaultJSONParser, type, (Object) null);
                        if (jSONLexer.token() == 17) {
                            jSONLexer.nextToken(deserializer2.getFastMatchToken());
                            Object deserialze2 = deserializer2.deserialze(defaultJSONParser, type2, deserialze);
                            defaultJSONParser.checkMapResolve(map, deserialze);
                            map.put(deserialze, deserialze2);
                            if (jSONLexer.token() == 16) {
                                jSONLexer.nextToken(deserializer.getFastMatchToken());
                            }
                        } else {
                            throw new JSONException("syntax error, expect :, actual " + jSONLexer.token());
                        }
                    } else {
                        jSONLexer.nextTokenWithColon(4);
                        if (jSONLexer.token() == 4) {
                            String stringVal = jSONLexer.stringVal();
                            if ("..".equals(stringVal)) {
                                obj2 = context.parent.object;
                            } else if ("$".equals(stringVal)) {
                                ParseContext parseContext = context;
                                while (parseContext.parent != null) {
                                    parseContext = parseContext.parent;
                                }
                                obj2 = parseContext.object;
                            } else {
                                defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(context, stringVal));
                                defaultJSONParser.setResolveStatus(1);
                            }
                            jSONLexer.nextToken(13);
                            if (jSONLexer.token() == 13) {
                                jSONLexer.nextToken(16);
                                defaultJSONParser.setContext(context);
                                return obj2;
                            }
                            throw new JSONException("illegal ref");
                        }
                        throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                    }
                } finally {
                    defaultJSONParser.setContext(context);
                }
            }
            jSONLexer.nextToken(16);
            defaultJSONParser.setContext(context);
            return map;
        }
        throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName());
    }

    /* access modifiers changed from: protected */
    public Map<Object, Object> createMap(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (EnumMap.class.equals(rawType)) {
                return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
            }
            return createMap(rawType);
        }
        Class cls = (Class) type;
        if (!cls.isInterface()) {
            try {
                return (Map) cls.newInstance();
            } catch (Exception e) {
                throw new JSONException("unsupport type " + type, e);
            }
        } else {
            throw new JSONException("unsupport type " + type);
        }
    }
}
