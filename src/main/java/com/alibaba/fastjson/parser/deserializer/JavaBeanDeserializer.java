package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JavaBeanDeserializer implements ObjectDeserializer {
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    public int getFastMatchToken() {
        return 12;
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy));
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        this.sortedFieldDeserializers = new FieldDeserializer[javaBeanInfo.sortedFields.length];
        int length = javaBeanInfo.sortedFields.length;
        for (int i = 0; i < length; i++) {
            this.sortedFieldDeserializers[i] = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, javaBeanInfo.sortedFields[i]);
        }
        this.fieldDeserializers = new FieldDeserializer[javaBeanInfo.fields.length];
        int length2 = javaBeanInfo.fields.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedFieldDeserializers.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.sortedFieldDeserializers[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object obj;
        String name;
        char[] cArr;
        String sb;
        DefaultJSONParser defaultJSONParser2 = defaultJSONParser;
        Type type2 = type;
        if ((type2 instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type2}, new JSONObject());
        } else if (this.beanInfo.defaultConstructor == null) {
            return null;
        } else {
            try {
                Constructor<?> constructor = this.beanInfo.defaultConstructor;
                if (this.beanInfo.defaultConstructorParameterSize == 0) {
                    obj = constructor.newInstance(new Object[0]);
                } else {
                    ParseContext context = defaultJSONParser.getContext();
                    name = context.object.getClass().getName();
                    String str = "";
                    if (type2 instanceof Class) {
                        str = ((Class) type2).getName();
                    }
                    if (name.length() != str.lastIndexOf(36) - 1) {
                        char[] charArray = str.toCharArray();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(name);
                        sb2.append("$");
                        HashMap hashMap = new HashMap();
                        hashMap.put(name, context.object);
                        int length = name.length() + 1;
                        for (char c = '$'; length <= str.lastIndexOf(c); c = '$') {
                            char c2 = charArray[length];
                            if (c2 == c) {
                                sb = sb2.toString();
                                Object obj2 = hashMap.get(name);
                                Class<?> cls = Class.forName(name);
                                if (obj2 != null) {
                                    cArr = charArray;
                                    Constructor<?> declaredConstructor = Class.forName(sb).getDeclaredConstructor(new Class[]{cls});
                                    if (!declaredConstructor.isAccessible()) {
                                        declaredConstructor.setAccessible(true);
                                    }
                                    hashMap.put(sb, declaredConstructor.newInstance(new Object[]{obj2}));
                                } else {
                                    cArr = charArray;
                                    sb = name;
                                }
                                name = sb;
                            } else {
                                cArr = charArray;
                            }
                            sb2.append(c2);
                            length++;
                            charArray = cArr;
                        }
                        obj = constructor.newInstance(new Object[]{hashMap.get(name)});
                    } else {
                        obj = constructor.newInstance(new Object[]{context.object});
                    }
                }
                if (defaultJSONParser2 != null && defaultJSONParser2.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            try {
                                fieldInfo.set(obj, "");
                            } catch (Exception e) {
                                throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                            }
                        }
                    }
                }
                return obj;
            } catch (ClassNotFoundException unused) {
                throw new JSONException("unable to find class " + name);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException unused2) {
                throw new RuntimeException("can not instantiate " + sb);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException(e4);
            } catch (Exception e5) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e5);
            }
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return deserialze(defaultJSONParser, type, obj, (Object) null, i);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum<?> enumR;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            T createInstance = createInstance(defaultJSONParser, type);
            int i = 0;
            int length = this.sortedFieldDeserializers.length;
            while (true) {
                int i2 = 16;
                if (i < length) {
                    char c = i == length + -1 ? ']' : ',';
                    FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
                    Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                    if (cls == Integer.TYPE) {
                        fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanInt(c));
                    } else if (cls == String.class) {
                        fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanString(c));
                    } else if (cls == Long.TYPE) {
                        fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanLong(c));
                    } else if (cls.isEnum()) {
                        char current = jSONLexer.getCurrent();
                        if (current == '\"' || current == 'n') {
                            enumR = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c);
                        } else if (current < '0' || current > '9') {
                            enumR = scanEnum(jSONLexer, c);
                        } else {
                            enumR = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c));
                        }
                        fieldDeserializer.setValue((Object) createInstance, (Object) enumR);
                    } else if (cls == Boolean.TYPE) {
                        fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanBoolean(c));
                    } else if (cls == Float.TYPE) {
                        fieldDeserializer.setValue((Object) createInstance, (Object) Float.valueOf(jSONLexer.scanFloat(c)));
                    } else if (cls == Double.TYPE) {
                        fieldDeserializer.setValue((Object) createInstance, (Object) Double.valueOf(jSONLexer.scanDouble(c)));
                    } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                        fieldDeserializer.setValue((Object) createInstance, (Object) new Date(jSONLexer.scanLong(c)));
                    } else {
                        jSONLexer.nextToken(14);
                        fieldDeserializer.setValue((Object) createInstance, defaultJSONParser.parseObject(fieldDeserializer.fieldInfo.fieldType));
                        if (c == ']') {
                            i2 = 15;
                        }
                        check(jSONLexer, i2);
                    }
                    i++;
                } else {
                    jSONLexer.nextToken(16);
                    return createInstance;
                }
            }
        } else {
            throw new JSONException("error");
        }
    }

    /* access modifiers changed from: protected */
    public void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    /* access modifiers changed from: protected */
    public Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: ?} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x022b, code lost:
        if (r10.matchStat == -2) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0269, code lost:
        r10.nextTokenWithColon(4);
        r0 = r10.token();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0271, code lost:
        if (r0 != 4) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0273, code lost:
        r0 = r10.stringVal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x027d, code lost:
        if ("@".equals(r0) == false) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x027f, code lost:
        r0 = r13.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0281, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0289, code lost:
        if ("..".equals(r0) == false) goto L_0x02a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x028b, code lost:
        r3 = r13.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x028f, code lost:
        if (r3.object == null) goto L_0x0294;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0291, code lost:
        r0 = r3.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0294, code lost:
        r8.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r3, r0));
        r8.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x029f, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x02a7, code lost:
        if ("$".equals(r0) == false) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x02a9, code lost:
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x02ac, code lost:
        if (r3.parent == null) goto L_0x02b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x02ae, code lost:
        r3 = r3.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x02b3, code lost:
        if (r3.object == null) goto L_0x02b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x02b5, code lost:
        r0 = r3.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x02b8, code lost:
        r8.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r3, r0));
        r8.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x02c4, code lost:
        r8.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r13, r0));
        r8.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x02cf, code lost:
        r10.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x02d8, code lost:
        if (r10.token() != 13) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x02da, code lost:
        r10.nextToken(16);
        r8.setContext(r13, r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x02e2, code lost:
        if (r2 == null) goto L_0x02e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x02e4, code lost:
        r2.object = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x02e6, code lost:
        r8.setContext(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x02e9, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x02f1, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x030c, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x033a, code lost:
        r11 = r1;
        r12 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x04d3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x04f2, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r7.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x0503, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0522, code lost:
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r7.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x0540, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x0548, code lost:
        throw new com.alibaba.fastjson.JSONException("build object error", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:400:0x0549, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x054a, code lost:
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x0589, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r10.token()));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:329:0x0451, B:368:0x04c9, B:377:0x04f9, B:390:0x0532] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0237 A[Catch:{ all -> 0x0597 }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0396 A[Catch:{ all -> 0x0597 }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x03a0 A[ADDED_TO_REGION, Catch:{ all -> 0x0597 }] */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x043e A[Catch:{ all -> 0x0592 }] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0440 A[Catch:{ all -> 0x0592 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x05a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r24, java.lang.reflect.Type r25, java.lang.Object r26, java.lang.Object r27, int r28) {
        /*
            r23 = this;
            r7 = r23
            r8 = r24
            r0 = r25
            r9 = r26
            java.lang.Class<com.alibaba.fastjson.JSON> r2 = com.alibaba.fastjson.JSON.class
            if (r0 == r2) goto L_0x05a6
            java.lang.Class<com.alibaba.fastjson.JSONObject> r2 = com.alibaba.fastjson.JSONObject.class
            if (r0 != r2) goto L_0x0012
            goto L_0x05a6
        L_0x0012:
            com.alibaba.fastjson.parser.JSONLexer r2 = r8.lexer
            r10 = r2
            com.alibaba.fastjson.parser.JSONLexerBase r10 = (com.alibaba.fastjson.parser.JSONLexerBase) r10
            int r2 = r10.token()
            r3 = 8
            r11 = 16
            r12 = 0
            if (r2 != r3) goto L_0x0026
            r10.nextToken(r11)
            return r12
        L_0x0026:
            com.alibaba.fastjson.parser.ParseContext r3 = r24.getContext()
            if (r27 == 0) goto L_0x0030
            if (r3 == 0) goto L_0x0030
            com.alibaba.fastjson.parser.ParseContext r3 = r3.parent
        L_0x0030:
            r13 = r3
            r14 = 13
            if (r2 != r14) goto L_0x004b
            r10.nextToken(r11)     // Catch:{ all -> 0x0045 }
            if (r27 != 0) goto L_0x003f
            java.lang.Object r0 = r23.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r24, (java.lang.reflect.Type) r25)     // Catch:{ all -> 0x0045 }
            goto L_0x0041
        L_0x003f:
            r0 = r27
        L_0x0041:
            r8.setContext(r13)
            return r0
        L_0x0045:
            r0 = move-exception
            r1 = r27
            r2 = r12
            goto L_0x059e
        L_0x004b:
            r3 = 14
            r15 = 0
            if (r2 != r3) goto L_0x0075
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean     // Catch:{ all -> 0x0045 }
            int r4 = r4.mask     // Catch:{ all -> 0x0045 }
            com.alibaba.fastjson.util.JavaBeanInfo r5 = r7.beanInfo     // Catch:{ all -> 0x0045 }
            int r5 = r5.parserFeatures     // Catch:{ all -> 0x0045 }
            r5 = r5 & r4
            if (r5 != 0) goto L_0x006a
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean     // Catch:{ all -> 0x0045 }
            boolean r5 = r10.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ all -> 0x0045 }
            if (r5 != 0) goto L_0x006a
            r4 = r28 & r4
            if (r4 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r4 = 0
            goto L_0x006b
        L_0x006a:
            r4 = 1
        L_0x006b:
            if (r4 == 0) goto L_0x0075
            java.lang.Object r0 = r23.deserialzeArrayMapping(r24, r25, r26, r27)     // Catch:{ all -> 0x0045 }
            r8.setContext(r13)
            return r0
        L_0x0075:
            r4 = 12
            r5 = 4
            if (r2 == r4) goto L_0x00e0
            if (r2 == r11) goto L_0x00e0
            boolean r0 = r10.isBlankInput()     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0086
            r8.setContext(r13)
            return r12
        L_0x0086:
            if (r2 != r5) goto L_0x0099
            java.lang.String r0 = r10.stringVal()     // Catch:{ all -> 0x0045 }
            int r0 = r0.length()     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0099
            r10.nextToken()     // Catch:{ all -> 0x0045 }
            r8.setContext(r13)
            return r12
        L_0x0099:
            if (r2 != r3) goto L_0x00ad
            char r0 = r10.getCurrent()     // Catch:{ all -> 0x0045 }
            r2 = 93
            if (r0 != r2) goto L_0x00ad
            r10.next()     // Catch:{ all -> 0x0045 }
            r10.nextToken()     // Catch:{ all -> 0x0045 }
            r8.setContext(r13)
            return r12
        L_0x00ad:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x0045 }
            r0.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = "syntax error, expect {, actual "
            r0.append(r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = r10.tokenName()     // Catch:{ all -> 0x0045 }
            r0.append(r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = ", pos "
            r0.append(r2)     // Catch:{ all -> 0x0045 }
            int r2 = r10.pos()     // Catch:{ all -> 0x0045 }
            r0.append(r2)     // Catch:{ all -> 0x0045 }
            boolean r2 = r9 instanceof java.lang.String     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x00d6
            java.lang.String r2 = ", fieldName "
            r0.append(r2)     // Catch:{ all -> 0x0045 }
            r0.append(r9)     // Catch:{ all -> 0x0045 }
        L_0x00d6:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0045 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0045 }
            r2.<init>(r0)     // Catch:{ all -> 0x0045 }
            throw r2     // Catch:{ all -> 0x0045 }
        L_0x00e0:
            int r2 = r8.resolveStatus     // Catch:{ all -> 0x0599 }
            r3 = 2
            if (r2 != r3) goto L_0x00e7
            r8.resolveStatus = r15     // Catch:{ all -> 0x0045 }
        L_0x00e7:
            r1 = r27
            r2 = r12
            r3 = r2
            r4 = 0
        L_0x00ec:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r12 = r7.sortedFieldDeserializers     // Catch:{ all -> 0x0597 }
            int r12 = r12.length     // Catch:{ all -> 0x0597 }
            if (r4 >= r12) goto L_0x00fe
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r12 = r7.sortedFieldDeserializers     // Catch:{ all -> 0x0597 }
            r12 = r12[r4]     // Catch:{ all -> 0x0597 }
            com.alibaba.fastjson.util.FieldInfo r15 = r12.fieldInfo     // Catch:{ all -> 0x0597 }
            java.lang.Class<?> r6 = r15.fieldClass     // Catch:{ all -> 0x0597 }
            com.alibaba.fastjson.annotation.JSONField r17 = r15.getAnnotation()     // Catch:{ all -> 0x0597 }
            goto L_0x0103
        L_0x00fe:
            r6 = 0
            r12 = 0
            r15 = 0
            r17 = 0
        L_0x0103:
            if (r12 == 0) goto L_0x0232
            char[] r5 = r15.name_chars     // Catch:{ all -> 0x0597 }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0597 }
            r14 = -2
            if (r6 == r11) goto L_0x0219
            java.lang.Class<java.lang.Integer> r11 = java.lang.Integer.class
            if (r6 != r11) goto L_0x0112
            goto L_0x0219
        L_0x0112:
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0597 }
            if (r6 == r11) goto L_0x0206
            java.lang.Class<java.lang.Long> r11 = java.lang.Long.class
            if (r6 != r11) goto L_0x011c
            goto L_0x0206
        L_0x011c:
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            if (r6 != r11) goto L_0x0130
            java.lang.String r5 = r10.scanFieldString(r5)     // Catch:{ all -> 0x0597 }
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 <= 0) goto L_0x012a
            goto L_0x0225
        L_0x012a:
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 != r14) goto L_0x0233
            goto L_0x022d
        L_0x0130:
            java.lang.Class r11 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0597 }
            if (r6 == r11) goto L_0x01f3
            java.lang.Class<java.lang.Boolean> r11 = java.lang.Boolean.class
            if (r6 != r11) goto L_0x013a
            goto L_0x01f3
        L_0x013a:
            java.lang.Class r11 = java.lang.Float.TYPE     // Catch:{ all -> 0x0597 }
            if (r6 == r11) goto L_0x01e0
            java.lang.Class<java.lang.Float> r11 = java.lang.Float.class
            if (r6 != r11) goto L_0x0144
            goto L_0x01e0
        L_0x0144:
            java.lang.Class r11 = java.lang.Double.TYPE     // Catch:{ all -> 0x0597 }
            if (r6 == r11) goto L_0x01cd
            java.lang.Class<java.lang.Double> r11 = java.lang.Double.class
            if (r6 != r11) goto L_0x014e
            goto L_0x01cd
        L_0x014e:
            boolean r11 = r6.isEnum()     // Catch:{ all -> 0x0597 }
            if (r11 == 0) goto L_0x0184
            com.alibaba.fastjson.parser.ParserConfig r11 = r24.getConfig()     // Catch:{ all -> 0x0597 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r11 = r11.getDeserializer((java.lang.reflect.Type) r6)     // Catch:{ all -> 0x0597 }
            boolean r11 = r11 instanceof com.alibaba.fastjson.parser.deserializer.EnumDeserializer     // Catch:{ all -> 0x0597 }
            if (r11 == 0) goto L_0x0184
            if (r17 == 0) goto L_0x016a
            java.lang.Class r11 = r17.deserializeUsing()     // Catch:{ all -> 0x0597 }
            java.lang.Class<java.lang.Void> r14 = java.lang.Void.class
            if (r11 != r14) goto L_0x0184
        L_0x016a:
            boolean r11 = r12 instanceof com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer     // Catch:{ all -> 0x0597 }
            if (r11 == 0) goto L_0x0232
            r11 = r12
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r11 = (com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer) r11     // Catch:{ all -> 0x0597 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r11 = r11.fieldValueDeserilizer     // Catch:{ all -> 0x0597 }
            java.lang.Enum r5 = r7.scanEnum(r10, r5, r11)     // Catch:{ all -> 0x0597 }
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 <= 0) goto L_0x017d
            goto L_0x0225
        L_0x017d:
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            r14 = -2
            if (r11 != r14) goto L_0x0233
            goto L_0x022d
        L_0x0184:
            java.lang.Class<int[]> r11 = int[].class
            if (r6 != r11) goto L_0x0199
            int[] r5 = r10.scanFieldIntArray(r5)     // Catch:{ all -> 0x0597 }
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 <= 0) goto L_0x0192
            goto L_0x0225
        L_0x0192:
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            r14 = -2
            if (r11 != r14) goto L_0x0233
            goto L_0x022d
        L_0x0199:
            java.lang.Class<float[]> r11 = float[].class
            if (r6 != r11) goto L_0x01ae
            float[] r5 = r10.scanFieldFloatArray(r5)     // Catch:{ all -> 0x0597 }
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 <= 0) goto L_0x01a7
            goto L_0x0225
        L_0x01a7:
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            r14 = -2
            if (r11 != r14) goto L_0x0233
            goto L_0x022d
        L_0x01ae:
            java.lang.Class<float[][]> r11 = float[][].class
            if (r6 != r11) goto L_0x01c3
            float[][] r5 = r10.scanFieldFloatArray2(r5)     // Catch:{ all -> 0x0597 }
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 <= 0) goto L_0x01bc
            goto L_0x0225
        L_0x01bc:
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            r14 = -2
            if (r11 != r14) goto L_0x0233
            goto L_0x022d
        L_0x01c3:
            boolean r5 = r10.matchField(r5)     // Catch:{ all -> 0x0597 }
            if (r5 == 0) goto L_0x022d
            r5 = 0
            r11 = 1
            goto L_0x0234
        L_0x01cd:
            double r18 = r10.scanFieldDouble(r5)     // Catch:{ all -> 0x0597 }
            java.lang.Double r5 = java.lang.Double.valueOf(r18)     // Catch:{ all -> 0x0597 }
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 <= 0) goto L_0x01da
            goto L_0x0225
        L_0x01da:
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            r14 = -2
            if (r11 != r14) goto L_0x0233
            goto L_0x022d
        L_0x01e0:
            float r5 = r10.scanFieldFloat(r5)     // Catch:{ all -> 0x0597 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ all -> 0x0597 }
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 <= 0) goto L_0x01ed
            goto L_0x0225
        L_0x01ed:
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            r14 = -2
            if (r11 != r14) goto L_0x0233
            goto L_0x022d
        L_0x01f3:
            boolean r5 = r10.scanFieldBoolean(r5)     // Catch:{ all -> 0x0597 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0597 }
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 <= 0) goto L_0x0200
            goto L_0x0225
        L_0x0200:
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            r14 = -2
            if (r11 != r14) goto L_0x0233
            goto L_0x022d
        L_0x0206:
            long r18 = r10.scanFieldLong(r5)     // Catch:{ all -> 0x0597 }
            java.lang.Long r5 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x0597 }
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 <= 0) goto L_0x0213
            goto L_0x0225
        L_0x0213:
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            r14 = -2
            if (r11 != r14) goto L_0x0233
            goto L_0x022d
        L_0x0219:
            int r5 = r10.scanFieldInt(r5)     // Catch:{ all -> 0x0597 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0597 }
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            if (r11 <= 0) goto L_0x0228
        L_0x0225:
            r11 = 1
            r14 = 1
            goto L_0x0235
        L_0x0228:
            int r11 = r10.matchStat     // Catch:{ all -> 0x0597 }
            r14 = -2
            if (r11 != r14) goto L_0x0233
        L_0x022d:
            r20 = r4
        L_0x022f:
            r6 = 1
            goto L_0x033e
        L_0x0232:
            r5 = 0
        L_0x0233:
            r11 = 0
        L_0x0234:
            r14 = 0
        L_0x0235:
            if (r11 != 0) goto L_0x0396
            r20 = r4
            com.alibaba.fastjson.parser.SymbolTable r4 = r8.symbolTable     // Catch:{ all -> 0x0597 }
            java.lang.String r4 = r10.scanSymbol(r4)     // Catch:{ all -> 0x0597 }
            if (r4 != 0) goto L_0x0261
            r21 = r6
            int r6 = r10.token()     // Catch:{ all -> 0x0597 }
            r22 = r5
            r5 = 13
            if (r6 != r5) goto L_0x0254
            r5 = 16
            r10.nextToken(r5)     // Catch:{ all -> 0x0597 }
            goto L_0x033a
        L_0x0254:
            r5 = 16
            if (r6 != r5) goto L_0x0265
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x0597 }
            boolean r5 = r10.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ all -> 0x0597 }
            if (r5 == 0) goto L_0x0265
            goto L_0x022f
        L_0x0261:
            r22 = r5
            r21 = r6
        L_0x0265:
            java.lang.String r5 = "$ref"
            if (r5 != r4) goto L_0x030d
            r5 = 4
            r10.nextTokenWithColon(r5)     // Catch:{ all -> 0x0597 }
            int r0 = r10.token()     // Catch:{ all -> 0x0597 }
            if (r0 != r5) goto L_0x02f2
            java.lang.String r0 = r10.stringVal()     // Catch:{ all -> 0x0597 }
            java.lang.String r3 = "@"
            boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x0597 }
            if (r3 == 0) goto L_0x0283
            java.lang.Object r0 = r13.object     // Catch:{ all -> 0x0597 }
        L_0x0281:
            r1 = r0
            goto L_0x02cf
        L_0x0283:
            java.lang.String r3 = ".."
            boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x0597 }
            if (r3 == 0) goto L_0x02a1
            com.alibaba.fastjson.parser.ParseContext r3 = r13.parent     // Catch:{ all -> 0x0597 }
            java.lang.Object r4 = r3.object     // Catch:{ all -> 0x0597 }
            if (r4 == 0) goto L_0x0294
            java.lang.Object r0 = r3.object     // Catch:{ all -> 0x0597 }
            goto L_0x0281
        L_0x0294:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r4 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0597 }
            r4.<init>(r3, r0)     // Catch:{ all -> 0x0597 }
            r8.addResolveTask(r4)     // Catch:{ all -> 0x0597 }
            r0 = 1
            r8.resolveStatus = r0     // Catch:{ all -> 0x0597 }
        L_0x029f:
            r0 = r1
            goto L_0x0281
        L_0x02a1:
            java.lang.String r3 = "$"
            boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x0597 }
            if (r3 == 0) goto L_0x02c4
            r3 = r13
        L_0x02aa:
            com.alibaba.fastjson.parser.ParseContext r4 = r3.parent     // Catch:{ all -> 0x0597 }
            if (r4 == 0) goto L_0x02b1
            com.alibaba.fastjson.parser.ParseContext r3 = r3.parent     // Catch:{ all -> 0x0597 }
            goto L_0x02aa
        L_0x02b1:
            java.lang.Object r4 = r3.object     // Catch:{ all -> 0x0597 }
            if (r4 == 0) goto L_0x02b8
            java.lang.Object r0 = r3.object     // Catch:{ all -> 0x0597 }
            goto L_0x0281
        L_0x02b8:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r4 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0597 }
            r4.<init>(r3, r0)     // Catch:{ all -> 0x0597 }
            r8.addResolveTask(r4)     // Catch:{ all -> 0x0597 }
            r0 = 1
            r8.resolveStatus = r0     // Catch:{ all -> 0x0597 }
            goto L_0x029f
        L_0x02c4:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r3 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0597 }
            r3.<init>(r13, r0)     // Catch:{ all -> 0x0597 }
            r8.addResolveTask(r3)     // Catch:{ all -> 0x0597 }
            r6 = 1
            r8.resolveStatus = r6     // Catch:{ all -> 0x0597 }
        L_0x02cf:
            r0 = 13
            r10.nextToken(r0)     // Catch:{ all -> 0x0597 }
            int r3 = r10.token()     // Catch:{ all -> 0x0597 }
            if (r3 != r0) goto L_0x02ea
            r0 = 16
            r10.nextToken(r0)     // Catch:{ all -> 0x0597 }
            r8.setContext(r13, r1, r9)     // Catch:{ all -> 0x0597 }
            if (r2 == 0) goto L_0x02e6
            r2.object = r1
        L_0x02e6:
            r8.setContext(r13)
            return r1
        L_0x02ea:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0597 }
            java.lang.String r3 = "illegal ref"
            r0.<init>(r3)     // Catch:{ all -> 0x0597 }
            throw r0     // Catch:{ all -> 0x0597 }
        L_0x02f2:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0597 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0597 }
            r4.<init>()     // Catch:{ all -> 0x0597 }
            java.lang.String r5 = "illegal ref, "
            r4.append(r5)     // Catch:{ all -> 0x0597 }
            java.lang.String r0 = com.alibaba.fastjson.parser.JSONToken.name(r0)     // Catch:{ all -> 0x0597 }
            r4.append(r0)     // Catch:{ all -> 0x0597 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0597 }
            r3.<init>(r0)     // Catch:{ all -> 0x0597 }
            throw r3     // Catch:{ all -> 0x0597 }
        L_0x030d:
            r6 = 1
            java.lang.String r5 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0597 }
            if (r5 != r4) goto L_0x039e
            r5 = 4
            r10.nextTokenWithColon(r5)     // Catch:{ all -> 0x0597 }
            int r4 = r10.token()     // Catch:{ all -> 0x0597 }
            if (r4 != r5) goto L_0x038e
            java.lang.String r4 = r10.stringVal()     // Catch:{ all -> 0x0597 }
            r5 = 16
            r10.nextToken(r5)     // Catch:{ all -> 0x0597 }
            com.alibaba.fastjson.util.JavaBeanInfo r5 = r7.beanInfo     // Catch:{ all -> 0x0597 }
            java.lang.String r5 = r5.typeName     // Catch:{ all -> 0x0597 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x0597 }
            if (r5 == 0) goto L_0x034d
            int r4 = r10.token()     // Catch:{ all -> 0x0597 }
            r5 = 13
            if (r4 != r5) goto L_0x033e
            r10.nextToken()     // Catch:{ all -> 0x0597 }
        L_0x033a:
            r11 = r1
            r12 = r3
            goto L_0x044d
        L_0x033e:
            r11 = r1
            r16 = r2
            r12 = r3
            r15 = r20
            r1 = 0
            r2 = 16
            r3 = 13
            r4 = 0
            r14 = 1
            goto L_0x055c
        L_0x034d:
            com.alibaba.fastjson.parser.ParserConfig r3 = r24.getConfig()     // Catch:{ all -> 0x0597 }
            com.alibaba.fastjson.util.JavaBeanInfo r5 = r7.beanInfo     // Catch:{ all -> 0x0597 }
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r7.getSeeAlso(r3, r5, r4)     // Catch:{ all -> 0x0597 }
            if (r5 != 0) goto L_0x0381
            java.lang.ClassLoader r3 = r3.getDefaultClassLoader()     // Catch:{ all -> 0x0597 }
            java.lang.Class r12 = com.alibaba.fastjson.util.TypeUtils.loadClass(r4, r3)     // Catch:{ all -> 0x0597 }
            java.lang.Class r0 = com.alibaba.fastjson.util.TypeUtils.getClass(r25)     // Catch:{ all -> 0x0597 }
            if (r0 == 0) goto L_0x0378
            if (r12 == 0) goto L_0x0370
            boolean r0 = r0.isAssignableFrom(r12)     // Catch:{ all -> 0x0597 }
            if (r0 == 0) goto L_0x0370
            goto L_0x0378
        L_0x0370:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0597 }
            java.lang.String r3 = "type not match"
            r0.<init>(r3)     // Catch:{ all -> 0x0597 }
            throw r0     // Catch:{ all -> 0x0597 }
        L_0x0378:
            com.alibaba.fastjson.parser.ParserConfig r0 = r24.getConfig()     // Catch:{ all -> 0x0597 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r5 = r0.getDeserializer((java.lang.reflect.Type) r12)     // Catch:{ all -> 0x0597 }
            goto L_0x0382
        L_0x0381:
            r12 = 0
        L_0x0382:
            java.lang.Object r0 = r5.deserialze(r8, r12, r9)     // Catch:{ all -> 0x0597 }
            if (r2 == 0) goto L_0x038a
            r2.object = r1
        L_0x038a:
            r8.setContext(r13)
            return r0
        L_0x038e:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0597 }
            java.lang.String r3 = "syntax error"
            r0.<init>(r3)     // Catch:{ all -> 0x0597 }
            throw r0     // Catch:{ all -> 0x0597 }
        L_0x0396:
            r20 = r4
            r22 = r5
            r21 = r6
            r6 = 1
            r4 = 0
        L_0x039e:
            if (r1 != 0) goto L_0x03bc
            if (r3 != 0) goto L_0x03bc
            java.lang.Object r5 = r23.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r24, (java.lang.reflect.Type) r25)     // Catch:{ all -> 0x0597 }
            if (r5 != 0) goto L_0x03b5
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x03b1 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r1 = r7.fieldDeserializers     // Catch:{ all -> 0x03b1 }
            int r1 = r1.length     // Catch:{ all -> 0x03b1 }
            r3.<init>(r1)     // Catch:{ all -> 0x03b1 }
            goto L_0x03b5
        L_0x03b1:
            r0 = move-exception
            r1 = r5
            goto L_0x059e
        L_0x03b5:
            com.alibaba.fastjson.parser.ParseContext r1 = r8.setContext(r13, r5, r9)     // Catch:{ all -> 0x03b1 }
            r16 = r1
            goto L_0x03bf
        L_0x03bc:
            r5 = r1
            r16 = r2
        L_0x03bf:
            if (r11 == 0) goto L_0x0404
            if (r14 != 0) goto L_0x03d1
            r12.parseField(r8, r5, r0, r3)     // Catch:{ all -> 0x03cd }
        L_0x03c6:
            r12 = r3
            r11 = r5
            r15 = r20
            r14 = 1
            goto L_0x0436
        L_0x03cd:
            r0 = move-exception
            r1 = r5
            goto L_0x0594
        L_0x03d1:
            if (r5 != 0) goto L_0x03db
            java.lang.String r1 = r15.name     // Catch:{ all -> 0x03cd }
            r2 = r22
            r3.put(r1, r2)     // Catch:{ all -> 0x03cd }
            goto L_0x03fc
        L_0x03db:
            r2 = r22
            if (r2 != 0) goto L_0x03f9
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ all -> 0x03cd }
            r4 = r21
            if (r4 == r1) goto L_0x03fc
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x03cd }
            if (r4 == r1) goto L_0x03fc
            java.lang.Class r1 = java.lang.Float.TYPE     // Catch:{ all -> 0x03cd }
            if (r4 == r1) goto L_0x03fc
            java.lang.Class r1 = java.lang.Double.TYPE     // Catch:{ all -> 0x03cd }
            if (r4 == r1) goto L_0x03fc
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x03cd }
            if (r4 == r1) goto L_0x03fc
            r12.setValue((java.lang.Object) r5, (java.lang.Object) r2)     // Catch:{ all -> 0x03cd }
            goto L_0x03fc
        L_0x03f9:
            r12.setValue((java.lang.Object) r5, (java.lang.Object) r2)     // Catch:{ all -> 0x03cd }
        L_0x03fc:
            int r1 = r10.matchStat     // Catch:{ all -> 0x03cd }
            r11 = 4
            if (r1 != r11) goto L_0x03c6
            r12 = r3
            r11 = r5
            goto L_0x044b
        L_0x0404:
            r11 = 4
            r1 = r23
            r2 = r24
            r12 = r3
            r3 = r4
            r15 = r20
            r4 = r5
            r11 = r5
            r14 = 4
            r5 = r25
            r14 = 1
            r6 = r12
            boolean r1 = r1.parseField(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0592 }
            if (r1 != 0) goto L_0x042e
            int r1 = r10.token()     // Catch:{ all -> 0x0592 }
            r2 = 13
            if (r1 != r2) goto L_0x0426
            r10.nextToken()     // Catch:{ all -> 0x0592 }
            goto L_0x044b
        L_0x0426:
            r1 = 0
            r2 = 16
        L_0x0429:
            r3 = 13
            r4 = 0
            goto L_0x055c
        L_0x042e:
            int r1 = r10.token()     // Catch:{ all -> 0x0592 }
            r2 = 17
            if (r1 == r2) goto L_0x058a
        L_0x0436:
            int r1 = r10.token()     // Catch:{ all -> 0x0592 }
            r2 = 16
            if (r1 != r2) goto L_0x0440
            r1 = 0
            goto L_0x0429
        L_0x0440:
            int r1 = r10.token()     // Catch:{ all -> 0x0592 }
            r3 = 13
            if (r1 != r3) goto L_0x054c
            r10.nextToken(r2)     // Catch:{ all -> 0x0592 }
        L_0x044b:
            r2 = r16
        L_0x044d:
            if (r11 != 0) goto L_0x0523
            if (r12 != 0) goto L_0x0465
            java.lang.Object r1 = r23.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r24, (java.lang.reflect.Type) r25)     // Catch:{ all -> 0x0549 }
            if (r2 != 0) goto L_0x045c
            com.alibaba.fastjson.parser.ParseContext r0 = r8.setContext(r13, r1, r9)     // Catch:{ all -> 0x0597 }
            goto L_0x045d
        L_0x045c:
            r0 = r2
        L_0x045d:
            if (r0 == 0) goto L_0x0461
            r0.object = r1
        L_0x0461:
            r8.setContext(r13)
            return r1
        L_0x0465:
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r7.beanInfo     // Catch:{ all -> 0x0549 }
            com.alibaba.fastjson.util.FieldInfo[] r0 = r0.fields     // Catch:{ all -> 0x0549 }
            int r1 = r0.length     // Catch:{ all -> 0x0549 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0549 }
            r4 = 0
        L_0x046d:
            if (r4 >= r1) goto L_0x04c3
            r5 = r0[r4]     // Catch:{ all -> 0x0549 }
            java.lang.String r6 = r5.name     // Catch:{ all -> 0x0549 }
            java.lang.Object r6 = r12.get(r6)     // Catch:{ all -> 0x0549 }
            if (r6 != 0) goto L_0x04be
            java.lang.reflect.Type r5 = r5.fieldType     // Catch:{ all -> 0x0549 }
            java.lang.Class r9 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0549 }
            if (r5 != r9) goto L_0x0485
            r9 = 0
            java.lang.Byte r6 = java.lang.Byte.valueOf(r9)     // Catch:{ all -> 0x0549 }
            goto L_0x04be
        L_0x0485:
            r9 = 0
            java.lang.Class r10 = java.lang.Short.TYPE     // Catch:{ all -> 0x0549 }
            if (r5 != r10) goto L_0x048f
            java.lang.Short r6 = java.lang.Short.valueOf(r9)     // Catch:{ all -> 0x0549 }
            goto L_0x04be
        L_0x048f:
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0549 }
            if (r5 != r10) goto L_0x0498
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0549 }
            goto L_0x04be
        L_0x0498:
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ all -> 0x0549 }
            if (r5 != r9) goto L_0x04a3
            r5 = 0
            java.lang.Long r6 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0549 }
            goto L_0x04be
        L_0x04a3:
            java.lang.Class r9 = java.lang.Float.TYPE     // Catch:{ all -> 0x0549 }
            if (r5 != r9) goto L_0x04ad
            r5 = 0
            java.lang.Float r6 = java.lang.Float.valueOf(r5)     // Catch:{ all -> 0x0549 }
            goto L_0x04be
        L_0x04ad:
            java.lang.Class r9 = java.lang.Double.TYPE     // Catch:{ all -> 0x0549 }
            if (r5 != r9) goto L_0x04b8
            r5 = 0
            java.lang.Double r6 = java.lang.Double.valueOf(r5)     // Catch:{ all -> 0x0549 }
            goto L_0x04be
        L_0x04b8:
            java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0549 }
            if (r5 != r9) goto L_0x04be
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0549 }
        L_0x04be:
            r3[r4] = r6     // Catch:{ all -> 0x0549 }
            int r4 = r4 + 1
            goto L_0x046d
        L_0x04c3:
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r7.beanInfo     // Catch:{ all -> 0x0549 }
            java.lang.reflect.Constructor<?> r0 = r0.creatorConstructor     // Catch:{ all -> 0x0549 }
            if (r0 == 0) goto L_0x04f3
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r7.beanInfo     // Catch:{ Exception -> 0x04d3 }
            java.lang.reflect.Constructor<?> r0 = r0.creatorConstructor     // Catch:{ Exception -> 0x04d3 }
            java.lang.Object r0 = r0.newInstance(r3)     // Catch:{ Exception -> 0x04d3 }
        L_0x04d1:
            r11 = r0
            goto L_0x0523
        L_0x04d3:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0549 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0549 }
            r3.<init>()     // Catch:{ all -> 0x0549 }
            java.lang.String r4 = "create instance error, "
            r3.append(r4)     // Catch:{ all -> 0x0549 }
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r7.beanInfo     // Catch:{ all -> 0x0549 }
            java.lang.reflect.Constructor<?> r4 = r4.creatorConstructor     // Catch:{ all -> 0x0549 }
            java.lang.String r4 = r4.toGenericString()     // Catch:{ all -> 0x0549 }
            r3.append(r4)     // Catch:{ all -> 0x0549 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0549 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0549 }
            throw r1     // Catch:{ all -> 0x0549 }
        L_0x04f3:
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r7.beanInfo     // Catch:{ all -> 0x0549 }
            java.lang.reflect.Method r0 = r0.factoryMethod     // Catch:{ all -> 0x0549 }
            if (r0 == 0) goto L_0x0523
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r7.beanInfo     // Catch:{ Exception -> 0x0503 }
            java.lang.reflect.Method r0 = r0.factoryMethod     // Catch:{ Exception -> 0x0503 }
            r4 = 0
            java.lang.Object r0 = r0.invoke(r4, r3)     // Catch:{ Exception -> 0x0503 }
            goto L_0x04d1
        L_0x0503:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0549 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0549 }
            r3.<init>()     // Catch:{ all -> 0x0549 }
            java.lang.String r4 = "create factory method error, "
            r3.append(r4)     // Catch:{ all -> 0x0549 }
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r7.beanInfo     // Catch:{ all -> 0x0549 }
            java.lang.reflect.Method r4 = r4.factoryMethod     // Catch:{ all -> 0x0549 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0549 }
            r3.append(r4)     // Catch:{ all -> 0x0549 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0549 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0549 }
            throw r1     // Catch:{ all -> 0x0549 }
        L_0x0523:
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r7.beanInfo     // Catch:{ all -> 0x0549 }
            java.lang.reflect.Method r0 = r0.buildMethod     // Catch:{ all -> 0x0549 }
            if (r0 != 0) goto L_0x0531
            if (r2 == 0) goto L_0x052d
            r2.object = r11
        L_0x052d:
            r8.setContext(r13)
            return r11
        L_0x0531:
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0540 }
            java.lang.Object r0 = r0.invoke(r11, r1)     // Catch:{ Exception -> 0x0540 }
            if (r2 == 0) goto L_0x053c
            r2.object = r11
        L_0x053c:
            r8.setContext(r13)
            return r0
        L_0x0540:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0549 }
            java.lang.String r3 = "build object error"
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0549 }
            throw r1     // Catch:{ all -> 0x0549 }
        L_0x0549:
            r0 = move-exception
            r1 = r11
            goto L_0x059e
        L_0x054c:
            r1 = 0
            r4 = 0
            int r5 = r10.token()     // Catch:{ all -> 0x0592 }
            r6 = 18
            if (r5 == r6) goto L_0x056b
            int r5 = r10.token()     // Catch:{ all -> 0x0592 }
            if (r5 == r14) goto L_0x056b
        L_0x055c:
            int r5 = r15 + 1
            r4 = r5
            r1 = r11
            r3 = r12
            r2 = r16
            r5 = 4
            r11 = 16
            r14 = 13
            r15 = 0
            goto L_0x00ec
        L_0x056b:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0592 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0592 }
            r1.<init>()     // Catch:{ all -> 0x0592 }
            java.lang.String r2 = "syntax error, unexpect token "
            r1.append(r2)     // Catch:{ all -> 0x0592 }
            int r2 = r10.token()     // Catch:{ all -> 0x0592 }
            java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.name(r2)     // Catch:{ all -> 0x0592 }
            r1.append(r2)     // Catch:{ all -> 0x0592 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0592 }
            r0.<init>(r1)     // Catch:{ all -> 0x0592 }
            throw r0     // Catch:{ all -> 0x0592 }
        L_0x058a:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0592 }
            java.lang.String r1 = "syntax error, unexpect token ':'"
            r0.<init>(r1)     // Catch:{ all -> 0x0592 }
            throw r0     // Catch:{ all -> 0x0592 }
        L_0x0592:
            r0 = move-exception
            r1 = r11
        L_0x0594:
            r2 = r16
            goto L_0x059e
        L_0x0597:
            r0 = move-exception
            goto L_0x059e
        L_0x0599:
            r0 = move-exception
            r4 = r12
            r1 = r27
            r2 = r4
        L_0x059e:
            if (r2 == 0) goto L_0x05a2
            r2.object = r1
        L_0x05a2:
            r8.setContext(r13)
            throw r0
        L_0x05a6:
            java.lang.Object r0 = r24.parse()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanFieldSymbol = jSONLexerBase.scanFieldSymbol(cArr);
        if (jSONLexerBase.matchStat > 0) {
            return enumDeserializer.getEnumByHashCode(scanFieldSymbol);
        }
        return null;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        DefaultJSONParser defaultJSONParser2 = defaultJSONParser;
        String str2 = str;
        Object obj2 = obj;
        JSONLexer jSONLexer = defaultJSONParser2.lexer;
        FieldDeserializer smartMatch = smartMatch(str2);
        int i = Feature.SupportNonPublicField.mask;
        if (smartMatch == null && (defaultJSONParser2.lexer.isEnabled(i) || (i & this.beanInfo.parserFeatures) != 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Field field : this.clazz.getDeclaredFields()) {
                    String name = field.getName();
                    if (getFieldDeserializer(name) == null) {
                        int modifiers = field.getModifiers();
                        if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                            concurrentHashMap.put(name, field);
                        }
                    }
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj3 = this.extraFieldDeserializers.get(str2);
            if (obj3 != null) {
                if (obj3 instanceof FieldDeserializer) {
                    smartMatch = (FieldDeserializer) obj3;
                } else {
                    Field field2 = (Field) obj3;
                    field2.setAccessible(true);
                    FieldInfo fieldInfo = r2;
                    FieldInfo fieldInfo2 = new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0, 0);
                    smartMatch = new DefaultFieldDeserializer(defaultJSONParser.getConfig(), this.clazz, fieldInfo);
                    this.extraFieldDeserializers.put(str2, smartMatch);
                }
            }
        }
        if (smartMatch != null) {
            jSONLexer.nextTokenWithColon(smartMatch.getFastMatchToken());
            smartMatch.parseField(defaultJSONParser2, obj2, type, map);
            return true;
        } else if (jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
            defaultJSONParser2.parseExtra(obj2, str2);
            return false;
        } else {
            throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str2);
        }
    }

    public FieldDeserializer smartMatch(String str) {
        boolean z;
        FieldDeserializer fieldDeserializer;
        String str2 = null;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer2 = getFieldDeserializer(str);
        if (fieldDeserializer2 == null) {
            boolean startsWith = str.startsWith("is");
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            int length = fieldDeserializerArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                fieldDeserializer = fieldDeserializerArr[i];
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls = fieldInfo.fieldClass;
                String str3 = fieldInfo.name;
                if (!str3.equalsIgnoreCase(str) && (!startsWith || (!(cls == Boolean.TYPE || cls == Boolean.class) || !str3.equalsIgnoreCase(str.substring(2))))) {
                    i++;
                }
            }
            fieldDeserializer2 = fieldDeserializer;
        }
        if (fieldDeserializer2 == null) {
            int i2 = 0;
            while (true) {
                z = true;
                if (i2 >= str.length()) {
                    z = false;
                    break;
                }
                char charAt = str.charAt(i2);
                if (charAt == '_') {
                    str2 = str.replaceAll("_", "");
                    break;
                } else if (charAt == '-') {
                    str2 = str.replaceAll("-", "");
                    break;
                } else {
                    i2++;
                }
            }
            if (z && (fieldDeserializer2 = getFieldDeserializer(str2)) == null) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                int length2 = fieldDeserializerArr2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        break;
                    }
                    FieldDeserializer fieldDeserializer3 = fieldDeserializerArr2[i3];
                    if (fieldDeserializer3.fieldInfo.name.equalsIgnoreCase(str2)) {
                        fieldDeserializer2 = fieldDeserializer3;
                        break;
                    }
                    i3++;
                }
            }
        }
        if (fieldDeserializer2 != null) {
            return fieldDeserializer2;
        }
        for (FieldDeserializer fieldDeserializer4 : this.sortedFieldDeserializers) {
            if (fieldDeserializer4.fieldInfo.alternateName(str)) {
                return fieldDeserializer4;
            }
        }
        return fieldDeserializer2;
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        if (this.beanInfo.creatorConstructor == null && this.beanInfo.factoryMethod == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, (Type) this.clazz);
            for (Map.Entry next : map.entrySet()) {
                Object value = next.getValue();
                FieldDeserializer smartMatch = smartMatch((String) next.getKey());
                if (smartMatch != null) {
                    smartMatch.setValue(createInstance, TypeUtils.cast(value, smartMatch.fieldInfo.fieldType, parserConfig));
                }
            }
            if (this.beanInfo.buildMethod == null) {
                return createInstance;
            }
            try {
                return this.beanInfo.buildMethod.invoke(createInstance, new Object[0]);
            } catch (Exception e) {
                throw new JSONException("build object error", e);
            }
        } else {
            FieldInfo[] fieldInfoArr = this.beanInfo.fields;
            int length = fieldInfoArr.length;
            Object[] objArr = new Object[length];
            for (int i = 0; i < length; i++) {
                objArr[i] = map.get(fieldInfoArr[i].name);
            }
            if (this.beanInfo.creatorConstructor != null) {
                try {
                    return this.beanInfo.creatorConstructor.newInstance(objArr);
                } catch (Exception e2) {
                    throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e2);
                }
            } else if (this.beanInfo.factoryMethod == null) {
                return null;
            } else {
                try {
                    return this.beanInfo.factoryMethod.invoke((Object) null, objArr);
                } catch (Exception e3) {
                    throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e3);
                }
            }
        }
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    /* access modifiers changed from: protected */
    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return deserialze(defaultJSONParser, type, obj, obj2, i);
    }

    /* access modifiers changed from: protected */
    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        if (javaBeanInfo.jsonType == null) {
            return null;
        }
        for (Class deserializer : javaBeanInfo.jsonType.seeAlso()) {
            ObjectDeserializer deserializer2 = parserConfig.getDeserializer((Type) deserializer);
            if (deserializer2 instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer2;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    protected static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i = jSONLexerBase.token();
        if (i == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i != 14) {
            defaultJSONParser.throwException(i);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i2 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i2)));
            i2++;
            if (jSONLexerBase.token() != 16) {
                break;
            } else if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i3 = jSONLexerBase.token();
        if (i3 != 15) {
            defaultJSONParser.throwException(i3);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
            return;
        }
        jSONLexerBase.nextToken(16);
    }
}
