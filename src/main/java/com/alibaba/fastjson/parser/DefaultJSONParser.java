package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    protected transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    static {
        primitiveClasses.add(Boolean.TYPE);
        primitiveClasses.add(Byte.TYPE);
        primitiveClasses.add(Short.TYPE);
        primitiveClasses.add(Integer.TYPE);
        primitiveClasses.add(Long.TYPE);
        primitiveClasses.add(Float.TYPE);
        primitiveClasses.add(Double.TYPE);
        primitiveClasses.add(Boolean.class);
        primitiveClasses.add(Byte.class);
        primitiveClasses.add(Short.class);
        primitiveClasses.add(Integer.class);
        primitiveClasses.add(Long.class);
        primitiveClasses.add(Float.class);
        primitiveClasses.add(Double.class);
        primitiveClasses.add(BigInteger.class);
        primitiveClasses.add(BigDecimal.class);
        primitiveClasses.add(String.class);
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            this.dateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setDateFomrat(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this((Object) str, (JSONLexer) new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this((Object) str, (JSONLexer) new JSONScanner(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this((Object) cArr, (JSONLexer) new JSONScanner(cArr, i, i2), parserConfig);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public String getInput() {
        if (this.input instanceof char[]) {
            return new String((char[]) this.input);
        }
        return this.input.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v29, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v40, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v43, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v44, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v45, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v46, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v47, resolved type: java.util.Date} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x021c, code lost:
        r3.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0227, code lost:
        if (r3.token() != 13) goto L_0x026b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0229, code lost:
        r3.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        r0 = r1.config.getDeserializer((java.lang.reflect.Type) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0234, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0236, code lost:
        r16 = ((com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0).createInstance(r1, (java.lang.reflect.Type) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x023f, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0241, code lost:
        if (r16 != null) goto L_0x025e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0245, code lost:
        if (r6 != java.lang.Cloneable.class) goto L_0x024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0247, code lost:
        r16 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0253, code lost:
        if ("java.util.Collections$EmptyMap".equals(r5) == false) goto L_0x025a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0255, code lost:
        r16 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x025a, code lost:
        r16 = r6.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x025e, code lost:
        setContext(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0261, code lost:
        return r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x026b, code lost:
        setResolveStatus(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0270, code lost:
        if (r1.context == null) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0274, code lost:
        if ((r2 instanceof java.lang.Integer) != false) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0276, code lost:
        popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x027d, code lost:
        if (r19.size() <= 0) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x027f, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r0, r6, r1.config);
        parseObject((java.lang.Object) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0288, code lost:
        setContext(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x028b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        r0 = r1.config.getDeserializer((java.lang.reflect.Type) r6).deserialze(r1, r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0296, code lost:
        setContext(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0299, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02a6, code lost:
        r3.nextToken(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02af, code lost:
        if (r3.token() != 4) goto L_0x0340;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02b1, code lost:
        r0 = r3.stringVal();
        r3.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02c0, code lost:
        if ("@".equals(r0) == false) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02c4, code lost:
        if (r1.context == null) goto L_0x0326;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02c6, code lost:
        r0 = r1.context;
        r5 = r0.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02cc, code lost:
        if ((r5 instanceof java.lang.Object[]) != false) goto L_0x0327;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02d0, code lost:
        if ((r5 instanceof java.util.Collection) == false) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02d5, code lost:
        if (r0.parent == null) goto L_0x0326;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02d7, code lost:
        r5 = r0.parent.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02e2, code lost:
        if ("..".equals(r0) == false) goto L_0x02f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02e6, code lost:
        if (r9.object == null) goto L_0x02eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02e8, code lost:
        r5 = r9.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02eb, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r9, r0));
        setResolveStatus(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02fd, code lost:
        if ("$".equals(r0) == false) goto L_0x031b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02ff, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0302, code lost:
        if (r2.parent == null) goto L_0x0307;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0304, code lost:
        r2 = r2.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0309, code lost:
        if (r2.object == null) goto L_0x030f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x030b, code lost:
        r5 = r2.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x030f, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r0));
        setResolveStatus(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x031b, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r9, r0));
        setResolveStatus(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0326, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x032d, code lost:
        if (r3.token() != 13) goto L_0x0338;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x032f, code lost:
        r3.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0334, code lost:
        setContext(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0337, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x033f, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x035e, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r3.token()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x03f1, code lost:
        if (r7 != '}') goto L_0x0403;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x03f3, code lost:
        r3.next();
        r3.resetStringPosition();
        r3.nextToken();
        setContext(r6, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x03ff, code lost:
        setContext(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0402, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0425, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, position at " + r3.pos() + ", name " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e5, code lost:
        if (r9 == null) goto L_0x00df;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x04be A[Catch:{ Exception -> 0x0262, NumberFormatException -> 0x0171, all -> 0x058b }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x04d7 A[Catch:{ Exception -> 0x0262, NumberFormatException -> 0x0171, all -> 0x058b }] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x04df A[Catch:{ Exception -> 0x0262, NumberFormatException -> 0x0171, all -> 0x058b }] */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x04e4 A[Catch:{ Exception -> 0x0262, NumberFormatException -> 0x0171, all -> 0x058b }] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x04f9 A[SYNTHETIC, Splitter:B:289:0x04f9] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x04ef A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e3 A[Catch:{ Exception -> 0x0262, NumberFormatException -> 0x0171, all -> 0x058b }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01fc A[Catch:{ Exception -> 0x0262, NumberFormatException -> 0x0171, all -> 0x058b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object parseObject(java.util.Map r19, java.lang.Object r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            com.alibaba.fastjson.parser.JSONLexer r3 = r1.lexer
            int r4 = r3.token()
            r5 = 0
            r6 = 8
            if (r4 != r6) goto L_0x0015
            r3.nextToken()
            return r5
        L_0x0015:
            int r4 = r3.token()
            r6 = 13
            if (r4 != r6) goto L_0x0021
            r3.nextToken()
            return r0
        L_0x0021:
            int r4 = r3.token()
            r7 = 12
            r8 = 16
            if (r4 == r7) goto L_0x0059
            int r4 = r3.token()
            if (r4 != r8) goto L_0x0032
            goto L_0x0059
        L_0x0032:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "syntax error, expect {, actual "
            r2.append(r4)
            java.lang.String r4 = r3.tokenName()
            r2.append(r4)
            java.lang.String r4 = ", "
            r2.append(r4)
            java.lang.String r3 = r3.info()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0059:
            com.alibaba.fastjson.parser.ParseContext r4 = r1.context
            r9 = r4
            r4 = 0
        L_0x005d:
            r3.skipWhitespace()     // Catch:{ all -> 0x058b }
            char r10 = r3.getCurrent()     // Catch:{ all -> 0x058b }
            com.alibaba.fastjson.parser.Feature r11 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x058b }
            boolean r11 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r11)     // Catch:{ all -> 0x058b }
            r12 = 44
            if (r11 == 0) goto L_0x007b
        L_0x006e:
            if (r10 != r12) goto L_0x007b
            r3.next()     // Catch:{ all -> 0x058b }
            r3.skipWhitespace()     // Catch:{ all -> 0x058b }
            char r10 = r3.getCurrent()     // Catch:{ all -> 0x058b }
            goto L_0x006e
        L_0x007b:
            r13 = 45
            r14 = 57
            r15 = 48
            r5 = 125(0x7d, float:1.75E-43)
            r7 = 2
            r6 = 58
            r8 = 34
            r11 = 1
            if (r10 != r8) goto L_0x00c0
            com.alibaba.fastjson.parser.SymbolTable r10 = r1.symbolTable     // Catch:{ all -> 0x058b }
            java.lang.String r10 = r3.scanSymbol(r10, r8)     // Catch:{ all -> 0x058b }
            r3.skipWhitespace()     // Catch:{ all -> 0x058b }
            char r8 = r3.getCurrent()     // Catch:{ all -> 0x058b }
            if (r8 != r6) goto L_0x009d
        L_0x009a:
            r6 = 0
            goto L_0x01e1
        L_0x009d:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x058b }
            r2.<init>()     // Catch:{ all -> 0x058b }
            java.lang.String r4 = "expect ':' at "
            r2.append(r4)     // Catch:{ all -> 0x058b }
            int r3 = r3.pos()     // Catch:{ all -> 0x058b }
            r2.append(r3)     // Catch:{ all -> 0x058b }
            java.lang.String r3 = ", name "
            r2.append(r3)     // Catch:{ all -> 0x058b }
            r2.append(r10)     // Catch:{ all -> 0x058b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x058b }
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x00c0:
            if (r10 != r5) goto L_0x00ec
            r3.next()     // Catch:{ all -> 0x058b }
            r3.resetStringPosition()     // Catch:{ all -> 0x058b }
            r3.nextToken()     // Catch:{ all -> 0x058b }
            if (r4 != 0) goto L_0x00e8
            com.alibaba.fastjson.parser.ParseContext r3 = r1.context     // Catch:{ all -> 0x058b }
            if (r3 == 0) goto L_0x00e1
            com.alibaba.fastjson.parser.ParseContext r3 = r1.context     // Catch:{ all -> 0x058b }
            java.lang.Object r3 = r3.fieldName     // Catch:{ all -> 0x058b }
            if (r2 != r3) goto L_0x00e1
            com.alibaba.fastjson.parser.ParseContext r3 = r1.context     // Catch:{ all -> 0x058b }
            java.lang.Object r3 = r3.object     // Catch:{ all -> 0x058b }
            if (r0 != r3) goto L_0x00e1
            com.alibaba.fastjson.parser.ParseContext r2 = r1.context     // Catch:{ all -> 0x058b }
        L_0x00df:
            r9 = r2
            goto L_0x00e8
        L_0x00e1:
            com.alibaba.fastjson.parser.ParseContext r2 = r18.setContext(r19, r20)     // Catch:{ all -> 0x058b }
            if (r9 != 0) goto L_0x00e8
            goto L_0x00df
        L_0x00e8:
            r1.setContext(r9)
            return r0
        L_0x00ec:
            r8 = 39
            if (r10 != r8) goto L_0x012b
            com.alibaba.fastjson.parser.Feature r10 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x058b }
            boolean r10 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r10)     // Catch:{ all -> 0x058b }
            if (r10 == 0) goto L_0x0123
            com.alibaba.fastjson.parser.SymbolTable r10 = r1.symbolTable     // Catch:{ all -> 0x058b }
            java.lang.String r10 = r3.scanSymbol(r10, r8)     // Catch:{ all -> 0x058b }
            r3.skipWhitespace()     // Catch:{ all -> 0x058b }
            char r8 = r3.getCurrent()     // Catch:{ all -> 0x058b }
            if (r8 != r6) goto L_0x0108
            goto L_0x009a
        L_0x0108:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x058b }
            r2.<init>()     // Catch:{ all -> 0x058b }
            java.lang.String r4 = "expect ':' at "
            r2.append(r4)     // Catch:{ all -> 0x058b }
            int r3 = r3.pos()     // Catch:{ all -> 0x058b }
            r2.append(r3)     // Catch:{ all -> 0x058b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x058b }
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x0123:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.String r2 = "syntax error"
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x012b:
            r8 = 26
            if (r10 == r8) goto L_0x0583
            if (r10 == r12) goto L_0x057b
            if (r10 < r15) goto L_0x0135
            if (r10 <= r14) goto L_0x0137
        L_0x0135:
            if (r10 != r13) goto L_0x018c
        L_0x0137:
            r3.resetStringPosition()     // Catch:{ all -> 0x058b }
            r3.scanNumber()     // Catch:{ all -> 0x058b }
            int r8 = r3.token()     // Catch:{ NumberFormatException -> 0x0171 }
            if (r8 != r7) goto L_0x0149
            java.lang.Number r8 = r3.integerValue()     // Catch:{ NumberFormatException -> 0x0171 }
        L_0x0147:
            r10 = r8
            goto L_0x014e
        L_0x0149:
            java.lang.Number r8 = r3.decimalValue(r11)     // Catch:{ NumberFormatException -> 0x0171 }
            goto L_0x0147
        L_0x014e:
            char r8 = r3.getCurrent()     // Catch:{ all -> 0x058b }
            if (r8 != r6) goto L_0x0156
            goto L_0x009a
        L_0x0156:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x058b }
            r2.<init>()     // Catch:{ all -> 0x058b }
            java.lang.String r4 = "parse number key error"
            r2.append(r4)     // Catch:{ all -> 0x058b }
            java.lang.String r3 = r3.info()     // Catch:{ all -> 0x058b }
            r2.append(r3)     // Catch:{ all -> 0x058b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x058b }
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x0171:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x058b }
            r2.<init>()     // Catch:{ all -> 0x058b }
            java.lang.String r4 = "parse number key error"
            r2.append(r4)     // Catch:{ all -> 0x058b }
            java.lang.String r3 = r3.info()     // Catch:{ all -> 0x058b }
            r2.append(r3)     // Catch:{ all -> 0x058b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x058b }
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x018c:
            r8 = 123(0x7b, float:1.72E-43)
            if (r10 == r8) goto L_0x01d9
            r8 = 91
            if (r10 != r8) goto L_0x0195
            goto L_0x01d9
        L_0x0195:
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x058b }
            boolean r8 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x058b }
            if (r8 == 0) goto L_0x01d1
            com.alibaba.fastjson.parser.SymbolTable r8 = r1.symbolTable     // Catch:{ all -> 0x058b }
            java.lang.String r10 = r3.scanSymbolUnQuoted(r8)     // Catch:{ all -> 0x058b }
            r3.skipWhitespace()     // Catch:{ all -> 0x058b }
            char r8 = r3.getCurrent()     // Catch:{ all -> 0x058b }
            if (r8 != r6) goto L_0x01ae
            goto L_0x009a
        L_0x01ae:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x058b }
            r2.<init>()     // Catch:{ all -> 0x058b }
            java.lang.String r4 = "expect ':' at "
            r2.append(r4)     // Catch:{ all -> 0x058b }
            int r3 = r3.pos()     // Catch:{ all -> 0x058b }
            r2.append(r3)     // Catch:{ all -> 0x058b }
            java.lang.String r3 = ", actual "
            r2.append(r3)     // Catch:{ all -> 0x058b }
            r2.append(r8)     // Catch:{ all -> 0x058b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x058b }
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x01d1:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.String r2 = "syntax error"
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x01d9:
            r3.nextToken()     // Catch:{ all -> 0x058b }
            java.lang.Object r10 = r18.parse()     // Catch:{ all -> 0x058b }
            r6 = 1
        L_0x01e1:
            if (r6 != 0) goto L_0x01e9
            r3.next()     // Catch:{ all -> 0x058b }
            r3.skipWhitespace()     // Catch:{ all -> 0x058b }
        L_0x01e9:
            char r6 = r3.getCurrent()     // Catch:{ all -> 0x058b }
            r3.resetStringPosition()     // Catch:{ all -> 0x058b }
            java.lang.String r8 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x058b }
            if (r10 != r8) goto L_0x029a
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x058b }
            boolean r8 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x058b }
            if (r8 != 0) goto L_0x029a
            com.alibaba.fastjson.parser.SymbolTable r5 = r1.symbolTable     // Catch:{ all -> 0x058b }
            r6 = 34
            java.lang.String r5 = r3.scanSymbol(r5, r6)     // Catch:{ all -> 0x058b }
            com.alibaba.fastjson.parser.ParserConfig r6 = r1.config     // Catch:{ all -> 0x058b }
            java.lang.ClassLoader r6 = r6.getDefaultClassLoader()     // Catch:{ all -> 0x058b }
            java.lang.Class r6 = com.alibaba.fastjson.util.TypeUtils.loadClass(r5, r6)     // Catch:{ all -> 0x058b }
            if (r6 != 0) goto L_0x021c
            java.lang.String r6 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x058b }
            r0.put(r6, r5)     // Catch:{ all -> 0x058b }
            r5 = 0
            r6 = 13
        L_0x0218:
            r8 = 16
            goto L_0x005d
        L_0x021c:
            r4 = 16
            r3.nextToken(r4)     // Catch:{ all -> 0x058b }
            int r8 = r3.token()     // Catch:{ all -> 0x058b }
            r10 = 13
            if (r8 != r10) goto L_0x026b
            r3.nextToken(r4)     // Catch:{ all -> 0x058b }
            com.alibaba.fastjson.parser.ParserConfig r0 = r1.config     // Catch:{ Exception -> 0x0262 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer((java.lang.reflect.Type) r6)     // Catch:{ Exception -> 0x0262 }
            boolean r2 = r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer     // Catch:{ Exception -> 0x0262 }
            if (r2 == 0) goto L_0x023f
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r0 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0     // Catch:{ Exception -> 0x0262 }
            java.lang.Object r0 = r0.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r1, (java.lang.reflect.Type) r6)     // Catch:{ Exception -> 0x0262 }
            r16 = r0
            goto L_0x0241
        L_0x023f:
            r16 = 0
        L_0x0241:
            if (r16 != 0) goto L_0x025e
            java.lang.Class<java.lang.Cloneable> r0 = java.lang.Cloneable.class
            if (r6 != r0) goto L_0x024d
            java.util.HashMap r16 = new java.util.HashMap     // Catch:{ Exception -> 0x0262 }
            r16.<init>()     // Catch:{ Exception -> 0x0262 }
            goto L_0x025e
        L_0x024d:
            java.lang.String r0 = "java.util.Collections$EmptyMap"
            boolean r0 = r0.equals(r5)     // Catch:{ Exception -> 0x0262 }
            if (r0 == 0) goto L_0x025a
            java.util.Map r16 = java.util.Collections.emptyMap()     // Catch:{ Exception -> 0x0262 }
            goto L_0x025e
        L_0x025a:
            java.lang.Object r16 = r6.newInstance()     // Catch:{ Exception -> 0x0262 }
        L_0x025e:
            r1.setContext(r9)
            return r16
        L_0x0262:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.String r3 = "create instance error"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x058b }
            throw r2     // Catch:{ all -> 0x058b }
        L_0x026b:
            r1.setResolveStatus(r7)     // Catch:{ all -> 0x058b }
            com.alibaba.fastjson.parser.ParseContext r3 = r1.context     // Catch:{ all -> 0x058b }
            if (r3 == 0) goto L_0x0279
            boolean r3 = r2 instanceof java.lang.Integer     // Catch:{ all -> 0x058b }
            if (r3 != 0) goto L_0x0279
            r18.popContext()     // Catch:{ all -> 0x058b }
        L_0x0279:
            int r3 = r19.size()     // Catch:{ all -> 0x058b }
            if (r3 <= 0) goto L_0x028c
            com.alibaba.fastjson.parser.ParserConfig r2 = r1.config     // Catch:{ all -> 0x058b }
            java.lang.Object r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r0, r6, (com.alibaba.fastjson.parser.ParserConfig) r2)     // Catch:{ all -> 0x058b }
            r1.parseObject((java.lang.Object) r0)     // Catch:{ all -> 0x058b }
            r1.setContext(r9)
            return r0
        L_0x028c:
            com.alibaba.fastjson.parser.ParserConfig r0 = r1.config     // Catch:{ all -> 0x058b }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer((java.lang.reflect.Type) r6)     // Catch:{ all -> 0x058b }
            java.lang.Object r0 = r0.deserialze(r1, r6, r2)     // Catch:{ all -> 0x058b }
            r1.setContext(r9)
            return r0
        L_0x029a:
            java.lang.String r8 = "$ref"
            if (r10 != r8) goto L_0x035f
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x058b }
            boolean r8 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x058b }
            if (r8 != 0) goto L_0x035f
            r0 = 4
            r3.nextToken(r0)     // Catch:{ all -> 0x058b }
            int r0 = r3.token()     // Catch:{ all -> 0x058b }
            r2 = 4
            if (r0 != r2) goto L_0x0340
            java.lang.String r0 = r3.stringVal()     // Catch:{ all -> 0x058b }
            r2 = 13
            r3.nextToken(r2)     // Catch:{ all -> 0x058b }
            java.lang.String r2 = "@"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x058b }
            if (r2 == 0) goto L_0x02dc
            com.alibaba.fastjson.parser.ParseContext r0 = r1.context     // Catch:{ all -> 0x058b }
            if (r0 == 0) goto L_0x0326
            com.alibaba.fastjson.parser.ParseContext r0 = r1.context     // Catch:{ all -> 0x058b }
            java.lang.Object r5 = r0.object     // Catch:{ all -> 0x058b }
            boolean r2 = r5 instanceof java.lang.Object[]     // Catch:{ all -> 0x058b }
            if (r2 != 0) goto L_0x0327
            boolean r2 = r5 instanceof java.util.Collection     // Catch:{ all -> 0x058b }
            if (r2 == 0) goto L_0x02d3
            goto L_0x0327
        L_0x02d3:
            com.alibaba.fastjson.parser.ParseContext r2 = r0.parent     // Catch:{ all -> 0x058b }
            if (r2 == 0) goto L_0x0326
            com.alibaba.fastjson.parser.ParseContext r0 = r0.parent     // Catch:{ all -> 0x058b }
            java.lang.Object r5 = r0.object     // Catch:{ all -> 0x058b }
            goto L_0x0327
        L_0x02dc:
            java.lang.String r2 = ".."
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x058b }
            if (r2 == 0) goto L_0x02f7
            java.lang.Object r2 = r9.object     // Catch:{ all -> 0x058b }
            if (r2 == 0) goto L_0x02eb
            java.lang.Object r5 = r9.object     // Catch:{ all -> 0x058b }
            goto L_0x0327
        L_0x02eb:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x058b }
            r2.<init>(r9, r0)     // Catch:{ all -> 0x058b }
            r1.addResolveTask(r2)     // Catch:{ all -> 0x058b }
            r1.setResolveStatus(r11)     // Catch:{ all -> 0x058b }
            goto L_0x0326
        L_0x02f7:
            java.lang.String r2 = "$"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x058b }
            if (r2 == 0) goto L_0x031b
            r2 = r9
        L_0x0300:
            com.alibaba.fastjson.parser.ParseContext r4 = r2.parent     // Catch:{ all -> 0x058b }
            if (r4 == 0) goto L_0x0307
            com.alibaba.fastjson.parser.ParseContext r2 = r2.parent     // Catch:{ all -> 0x058b }
            goto L_0x0300
        L_0x0307:
            java.lang.Object r4 = r2.object     // Catch:{ all -> 0x058b }
            if (r4 == 0) goto L_0x030f
            java.lang.Object r0 = r2.object     // Catch:{ all -> 0x058b }
            r5 = r0
            goto L_0x0327
        L_0x030f:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r4 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x058b }
            r4.<init>(r2, r0)     // Catch:{ all -> 0x058b }
            r1.addResolveTask(r4)     // Catch:{ all -> 0x058b }
            r1.setResolveStatus(r11)     // Catch:{ all -> 0x058b }
            goto L_0x0326
        L_0x031b:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x058b }
            r2.<init>(r9, r0)     // Catch:{ all -> 0x058b }
            r1.addResolveTask(r2)     // Catch:{ all -> 0x058b }
            r1.setResolveStatus(r11)     // Catch:{ all -> 0x058b }
        L_0x0326:
            r5 = 0
        L_0x0327:
            int r0 = r3.token()     // Catch:{ all -> 0x058b }
            r2 = 13
            if (r0 != r2) goto L_0x0338
            r0 = 16
            r3.nextToken(r0)     // Catch:{ all -> 0x058b }
            r1.setContext(r9)
            return r5
        L_0x0338:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.String r2 = "syntax error"
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x0340:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x058b }
            r2.<init>()     // Catch:{ all -> 0x058b }
            java.lang.String r4 = "illegal ref, "
            r2.append(r4)     // Catch:{ all -> 0x058b }
            int r3 = r3.token()     // Catch:{ all -> 0x058b }
            java.lang.String r3 = com.alibaba.fastjson.parser.JSONToken.name(r3)     // Catch:{ all -> 0x058b }
            r2.append(r3)     // Catch:{ all -> 0x058b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x058b }
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x035f:
            if (r4 != 0) goto L_0x037f
            com.alibaba.fastjson.parser.ParseContext r8 = r1.context     // Catch:{ all -> 0x058b }
            if (r8 == 0) goto L_0x0375
            com.alibaba.fastjson.parser.ParseContext r8 = r1.context     // Catch:{ all -> 0x058b }
            java.lang.Object r8 = r8.fieldName     // Catch:{ all -> 0x058b }
            if (r2 != r8) goto L_0x0375
            com.alibaba.fastjson.parser.ParseContext r8 = r1.context     // Catch:{ all -> 0x058b }
            java.lang.Object r8 = r8.object     // Catch:{ all -> 0x058b }
            if (r0 != r8) goto L_0x0375
            com.alibaba.fastjson.parser.ParseContext r8 = r1.context     // Catch:{ all -> 0x058b }
            r9 = r8
            goto L_0x037f
        L_0x0375:
            com.alibaba.fastjson.parser.ParseContext r4 = r18.setContext(r19, r20)     // Catch:{ all -> 0x058b }
            if (r9 != 0) goto L_0x037c
            goto L_0x037d
        L_0x037c:
            r4 = r9
        L_0x037d:
            r9 = r4
            r4 = 1
        L_0x037f:
            java.lang.Class r8 = r19.getClass()     // Catch:{ all -> 0x058b }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r11 = com.alibaba.fastjson.JSONObject.class
            if (r8 != r11) goto L_0x0391
            if (r10 != 0) goto L_0x038c
            java.lang.String r8 = "null"
            goto L_0x0390
        L_0x038c:
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x058b }
        L_0x0390:
            r10 = r8
        L_0x0391:
            r8 = 34
            if (r6 != r8) goto L_0x03be
            r3.scanString()     // Catch:{ all -> 0x058b }
            java.lang.String r6 = r3.stringVal()     // Catch:{ all -> 0x058b }
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x058b }
            boolean r7 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r7)     // Catch:{ all -> 0x058b }
            if (r7 == 0) goto L_0x03ba
            com.alibaba.fastjson.parser.JSONScanner r7 = new com.alibaba.fastjson.parser.JSONScanner     // Catch:{ all -> 0x058b }
            r7.<init>(r6)     // Catch:{ all -> 0x058b }
            boolean r8 = r7.scanISO8601DateIfMatch()     // Catch:{ all -> 0x058b }
            if (r8 == 0) goto L_0x03b7
            java.util.Calendar r6 = r7.getCalendar()     // Catch:{ all -> 0x058b }
            java.util.Date r6 = r6.getTime()     // Catch:{ all -> 0x058b }
        L_0x03b7:
            r7.close()     // Catch:{ all -> 0x058b }
        L_0x03ba:
            r0.put(r10, r6)     // Catch:{ all -> 0x058b }
            goto L_0x03df
        L_0x03be:
            if (r6 < r15) goto L_0x03c2
            if (r6 <= r14) goto L_0x03c4
        L_0x03c2:
            if (r6 != r13) goto L_0x0426
        L_0x03c4:
            r3.scanNumber()     // Catch:{ all -> 0x058b }
            int r6 = r3.token()     // Catch:{ all -> 0x058b }
            if (r6 != r7) goto L_0x03d2
            java.lang.Number r6 = r3.integerValue()     // Catch:{ all -> 0x058b }
            goto L_0x03dc
        L_0x03d2:
            com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x058b }
            boolean r6 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r6)     // Catch:{ all -> 0x058b }
            java.lang.Number r6 = r3.decimalValue(r6)     // Catch:{ all -> 0x058b }
        L_0x03dc:
            r0.put(r10, r6)     // Catch:{ all -> 0x058b }
        L_0x03df:
            r3.skipWhitespace()     // Catch:{ all -> 0x058b }
            char r7 = r3.getCurrent()     // Catch:{ all -> 0x058b }
            if (r7 != r12) goto L_0x03f1
            r3.next()     // Catch:{ all -> 0x058b }
        L_0x03eb:
            r6 = 13
            r7 = 16
            goto L_0x0555
        L_0x03f1:
            if (r7 != r5) goto L_0x0403
            r3.next()     // Catch:{ all -> 0x058b }
            r3.resetStringPosition()     // Catch:{ all -> 0x058b }
            r3.nextToken()     // Catch:{ all -> 0x058b }
            r1.setContext(r6, r10)     // Catch:{ all -> 0x058b }
            r1.setContext(r9)
            return r0
        L_0x0403:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x058b }
            r2.<init>()     // Catch:{ all -> 0x058b }
            java.lang.String r4 = "syntax error, position at "
            r2.append(r4)     // Catch:{ all -> 0x058b }
            int r3 = r3.pos()     // Catch:{ all -> 0x058b }
            r2.append(r3)     // Catch:{ all -> 0x058b }
            java.lang.String r3 = ", name "
            r2.append(r3)     // Catch:{ all -> 0x058b }
            r2.append(r10)     // Catch:{ all -> 0x058b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x058b }
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x0426:
            r5 = 91
            if (r6 != r5) goto L_0x0471
            r3.nextToken()     // Catch:{ all -> 0x058b }
            com.alibaba.fastjson.JSONArray r5 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x058b }
            r5.<init>()     // Catch:{ all -> 0x058b }
            if (r2 == 0) goto L_0x043a
            java.lang.Class r6 = r20.getClass()     // Catch:{ all -> 0x058b }
            java.lang.Class<java.lang.Integer> r7 = java.lang.Integer.class
        L_0x043a:
            if (r2 != 0) goto L_0x043f
            r1.setContext(r9)     // Catch:{ all -> 0x058b }
        L_0x043f:
            r1.parseArray((java.util.Collection) r5, (java.lang.Object) r10)     // Catch:{ all -> 0x058b }
            com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.UseObjectArray     // Catch:{ all -> 0x058b }
            boolean r6 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r6)     // Catch:{ all -> 0x058b }
            if (r6 == 0) goto L_0x044e
            java.lang.Object[] r5 = r5.toArray()     // Catch:{ all -> 0x058b }
        L_0x044e:
            r0.put(r10, r5)     // Catch:{ all -> 0x058b }
            int r5 = r3.token()     // Catch:{ all -> 0x058b }
            r6 = 13
            if (r5 != r6) goto L_0x0460
            r3.nextToken()     // Catch:{ all -> 0x058b }
            r1.setContext(r9)
            return r0
        L_0x0460:
            int r5 = r3.token()     // Catch:{ all -> 0x058b }
            r6 = 16
            if (r5 != r6) goto L_0x0469
            goto L_0x03eb
        L_0x0469:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.String r2 = "syntax error"
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x0471:
            r5 = 123(0x7b, float:1.72E-43)
            if (r6 != r5) goto L_0x0528
            r3.nextToken()     // Catch:{ all -> 0x058b }
            if (r2 == 0) goto L_0x0484
            java.lang.Class r5 = r20.getClass()     // Catch:{ all -> 0x058b }
            java.lang.Class<java.lang.Integer> r6 = java.lang.Integer.class
            if (r5 != r6) goto L_0x0484
            r5 = 1
            goto L_0x0485
        L_0x0484:
            r5 = 0
        L_0x0485:
            com.alibaba.fastjson.JSONObject r6 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x058b }
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x058b }
            boolean r7 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r7)     // Catch:{ all -> 0x058b }
            r6.<init>((boolean) r7)     // Catch:{ all -> 0x058b }
            if (r5 != 0) goto L_0x0497
            com.alibaba.fastjson.parser.ParseContext r7 = r1.setContext(r9, r6, r10)     // Catch:{ all -> 0x058b }
            goto L_0x0498
        L_0x0497:
            r7 = 0
        L_0x0498:
            com.alibaba.fastjson.parser.deserializer.FieldTypeResolver r8 = r1.fieldTypeResolver     // Catch:{ all -> 0x058b }
            if (r8 == 0) goto L_0x04b9
            if (r10 == 0) goto L_0x04a3
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x058b }
            goto L_0x04a4
        L_0x04a3:
            r8 = 0
        L_0x04a4:
            com.alibaba.fastjson.parser.deserializer.FieldTypeResolver r11 = r1.fieldTypeResolver     // Catch:{ all -> 0x058b }
            java.lang.reflect.Type r8 = r11.resolve(r0, r8)     // Catch:{ all -> 0x058b }
            if (r8 == 0) goto L_0x04b9
            com.alibaba.fastjson.parser.ParserConfig r11 = r1.config     // Catch:{ all -> 0x058b }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r11 = r11.getDeserializer((java.lang.reflect.Type) r8)     // Catch:{ all -> 0x058b }
            java.lang.Object r8 = r11.deserialze(r1, r8, r10)     // Catch:{ all -> 0x058b }
            r17 = 1
            goto L_0x04bc
        L_0x04b9:
            r8 = 0
            r17 = 0
        L_0x04bc:
            if (r17 != 0) goto L_0x04c2
            java.lang.Object r8 = r1.parseObject((java.util.Map) r6, (java.lang.Object) r10)     // Catch:{ all -> 0x058b }
        L_0x04c2:
            if (r7 == 0) goto L_0x04c8
            if (r6 == r8) goto L_0x04c8
            r7.object = r0     // Catch:{ all -> 0x058b }
        L_0x04c8:
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x058b }
            r1.checkMapResolve(r0, r6)     // Catch:{ all -> 0x058b }
            java.lang.Class r6 = r19.getClass()     // Catch:{ all -> 0x058b }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r7 = com.alibaba.fastjson.JSONObject.class
            if (r6 != r7) goto L_0x04df
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x058b }
            r0.put(r6, r8)     // Catch:{ all -> 0x058b }
            goto L_0x04e2
        L_0x04df:
            r0.put(r10, r8)     // Catch:{ all -> 0x058b }
        L_0x04e2:
            if (r5 == 0) goto L_0x04e7
            r1.setContext(r8, r10)     // Catch:{ all -> 0x058b }
        L_0x04e7:
            int r6 = r3.token()     // Catch:{ all -> 0x058b }
            r7 = 13
            if (r6 != r7) goto L_0x04f9
            r3.nextToken()     // Catch:{ all -> 0x058b }
            r1.setContext(r9)     // Catch:{ all -> 0x058b }
            r1.setContext(r9)
            return r0
        L_0x04f9:
            int r6 = r3.token()     // Catch:{ all -> 0x058b }
            r7 = 16
            if (r6 != r7) goto L_0x050d
            if (r5 == 0) goto L_0x0508
            r18.popContext()     // Catch:{ all -> 0x058b }
            goto L_0x03eb
        L_0x0508:
            r1.setContext(r9)     // Catch:{ all -> 0x058b }
            goto L_0x03eb
        L_0x050d:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x058b }
            r2.<init>()     // Catch:{ all -> 0x058b }
            java.lang.String r4 = "syntax error, "
            r2.append(r4)     // Catch:{ all -> 0x058b }
            java.lang.String r3 = r3.tokenName()     // Catch:{ all -> 0x058b }
            r2.append(r3)     // Catch:{ all -> 0x058b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x058b }
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x0528:
            r3.nextToken()     // Catch:{ all -> 0x058b }
            java.lang.Object r5 = r18.parse()     // Catch:{ all -> 0x058b }
            java.lang.Class r6 = r19.getClass()     // Catch:{ all -> 0x058b }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r7 = com.alibaba.fastjson.JSONObject.class
            if (r6 != r7) goto L_0x053b
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x058b }
        L_0x053b:
            r0.put(r10, r5)     // Catch:{ all -> 0x058b }
            int r5 = r3.token()     // Catch:{ all -> 0x058b }
            r6 = 13
            if (r5 != r6) goto L_0x054d
            r3.nextToken()     // Catch:{ all -> 0x058b }
            r1.setContext(r9)
            return r0
        L_0x054d:
            int r5 = r3.token()     // Catch:{ all -> 0x058b }
            r7 = 16
            if (r5 != r7) goto L_0x0558
        L_0x0555:
            r5 = 0
            goto L_0x0218
        L_0x0558:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x058b }
            r2.<init>()     // Catch:{ all -> 0x058b }
            java.lang.String r4 = "syntax error, position at "
            r2.append(r4)     // Catch:{ all -> 0x058b }
            int r3 = r3.pos()     // Catch:{ all -> 0x058b }
            r2.append(r3)     // Catch:{ all -> 0x058b }
            java.lang.String r3 = ", name "
            r2.append(r3)     // Catch:{ all -> 0x058b }
            r2.append(r10)     // Catch:{ all -> 0x058b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x058b }
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x057b:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.String r2 = "syntax error"
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x0583:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x058b }
            java.lang.String r2 = "syntax error"
            r0.<init>(r2)     // Catch:{ all -> 0x058b }
            throw r0     // Catch:{ all -> 0x058b }
        L_0x058b:
            r0 = move-exception
            r1.setContext(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public <T> T parseObject(Class<T> cls) {
        return parseObject((Type) cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                Object bytesValue = this.lexer.bytesValue();
                this.lexer.nextToken();
                return bytesValue;
            } else if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return stringVal.toCharArray();
            }
        }
        try {
            return this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer objectDeserializer;
        if (this.lexer.token() == 21 || this.lexer.token() == 22) {
            this.lexer.nextToken();
        }
        if (this.lexer.token() == 14) {
            if (Integer.TYPE == type) {
                objectDeserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            } else if (String.class == type) {
                objectDeserializer = StringCodec.instance;
                this.lexer.nextToken(4);
            } else {
                objectDeserializer = this.config.getDeserializer(type);
                this.lexer.nextToken(objectDeserializer.getFastMatchToken());
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.instance.deserialze(this, (Type) null, (Object) null));
                    } else if (String.class == type) {
                        if (this.lexer.token() == 4) {
                            obj2 = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object parse = parse();
                            if (parse != null) {
                                obj2 = parse.toString();
                            }
                        }
                        collection.add(obj2);
                    } else {
                        if (this.lexer.token() == 8) {
                            this.lexer.nextToken();
                        } else {
                            obj2 = objectDeserializer.deserialze(this, type, Integer.valueOf(i));
                        }
                        collection.add(obj2);
                        checkListResolve(collection);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(objectDeserializer.getFastMatchToken());
                    }
                    i++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token()) + ", " + this.lexer.info());
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object obj;
        boolean z;
        Class<?> cls;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        } else if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i = 0;
            while (i < typeArr.length) {
                if (this.lexer.token() == 8) {
                    this.lexer.nextToken(16);
                    obj = null;
                } else {
                    Class<String> cls2 = typeArr[i];
                    if (cls2 == Integer.TYPE || cls2 == Integer.class) {
                        if (this.lexer.token() == 2) {
                            obj = Integer.valueOf(this.lexer.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            obj = TypeUtils.cast(parse(), (Type) cls2, this.config);
                        }
                    } else if (cls2 != String.class) {
                        if (i != typeArr.length - 1 || !(cls2 instanceof Class)) {
                            cls = null;
                            z = false;
                        } else {
                            Class cls3 = cls2;
                            z = cls3.isArray();
                            cls = cls3.getComponentType();
                        }
                        if (!z || this.lexer.token() == 14) {
                            obj = this.config.getDeserializer((Type) cls2).deserialze(this, cls2, (Object) null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer((Type) cls);
                            int fastMatchToken = deserializer.getFastMatchToken();
                            if (this.lexer.token() != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, cls2, (Object) null));
                                    if (this.lexer.token() != 16) {
                                        break;
                                    }
                                    this.lexer.nextToken(fastMatchToken);
                                }
                                if (this.lexer.token() != 15) {
                                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                }
                            }
                            obj = TypeUtils.cast((Object) arrayList, (Type) cls2, this.config);
                        }
                    } else if (this.lexer.token() == 4) {
                        obj = this.lexer.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        obj = TypeUtils.cast(parse(), (Type) cls2, this.config);
                    }
                }
                objArr[i] = obj;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() == 16) {
                    if (i == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i++;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        } else {
            throw new JSONException("syntax error : " + this.lexer.tokenName());
        }
    }

    public void parseObject(Object obj) {
        Object obj2;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer((Type) cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() == 12 || this.lexer.token() == 16) {
            while (true) {
                String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
                if (scanSymbol == null) {
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return;
                    } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    }
                }
                FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
                if (fieldDeserializer != null) {
                    Class<?> cls2 = fieldDeserializer.fieldInfo.fieldClass;
                    Type type = fieldDeserializer.fieldInfo.fieldType;
                    if (cls2 == Integer.TYPE) {
                        this.lexer.nextTokenWithColon(2);
                        obj2 = IntegerCodec.instance.deserialze(this, type, (Object) null);
                    } else if (cls2 == String.class) {
                        this.lexer.nextTokenWithColon(4);
                        obj2 = StringCodec.deserialze(this);
                    } else if (cls2 == Long.TYPE) {
                        this.lexer.nextTokenWithColon(2);
                        obj2 = LongCodec.instance.deserialze(this, type, (Object) null);
                    } else {
                        ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                        this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                        obj2 = deserializer2.deserialze(this, type, (Object) null);
                    }
                    fieldDeserializer.setValue(obj, obj2);
                    if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return;
                    }
                } else if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class<?>) (Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (!Object.class.equals(type3)) {
                    ArrayList arrayList2 = new ArrayList();
                    parseArray((Class<?>) (Class) type3, (Collection) arrayList2);
                    return arrayList2;
                } else if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                } else {
                    throw new JSONException("not support type : " + type);
                }
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class<?>) (Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((Type) (ParameterizedType) type2, (Collection) arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        } else {
            throw new JSONException("not support type " + type);
        }
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        } else if (str.equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken();
            }
        } else {
            throw new JSONException("type not match error");
        }
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus != 1) {
            return;
        }
        if (collection instanceof List) {
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
            return;
        }
        ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.context;
        setResolveStatus(0);
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v22, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void parseArray(java.util.Collection r9, java.lang.Object r10) {
        /*
            r8 = this;
            com.alibaba.fastjson.parser.JSONLexer r0 = r8.lexer
            int r1 = r0.token()
            r2 = 21
            if (r1 == r2) goto L_0x0012
            int r1 = r0.token()
            r2 = 22
            if (r1 != r2) goto L_0x0015
        L_0x0012:
            r0.nextToken()
        L_0x0015:
            int r1 = r0.token()
            r2 = 14
            if (r1 != r2) goto L_0x00f9
            r1 = 4
            r0.nextToken(r1)
            com.alibaba.fastjson.parser.ParseContext r2 = r8.context
            r8.setContext(r9, r10)
            r10 = 0
            r3 = 0
        L_0x0028:
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x00f4 }
            boolean r4 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r4)     // Catch:{ all -> 0x00f4 }
            r5 = 16
            if (r4 == 0) goto L_0x003c
        L_0x0032:
            int r4 = r0.token()     // Catch:{ all -> 0x00f4 }
            if (r4 != r5) goto L_0x003c
            r0.nextToken()     // Catch:{ all -> 0x00f4 }
            goto L_0x0032
        L_0x003c:
            int r4 = r0.token()     // Catch:{ all -> 0x00f4 }
            r6 = 0
            switch(r4) {
                case 2: goto L_0x00da;
                case 3: goto L_0x00c2;
                case 4: goto L_0x009c;
                case 6: goto L_0x0096;
                case 7: goto L_0x0090;
                case 8: goto L_0x008c;
                case 12: goto L_0x0078;
                case 14: goto L_0x005e;
                case 15: goto L_0x0057;
                case 20: goto L_0x004f;
                case 23: goto L_0x004a;
                default: goto L_0x0044;
            }     // Catch:{ all -> 0x00f4 }
        L_0x0044:
            java.lang.Object r6 = r8.parse()     // Catch:{ all -> 0x00f4 }
            goto L_0x00e1
        L_0x004a:
            r0.nextToken(r1)     // Catch:{ all -> 0x00f4 }
            goto L_0x00e1
        L_0x004f:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = "unclosed jsonArray"
            r9.<init>(r10)     // Catch:{ all -> 0x00f4 }
            throw r9     // Catch:{ all -> 0x00f4 }
        L_0x0057:
            r0.nextToken(r5)     // Catch:{ all -> 0x00f4 }
            r8.setContext(r2)
            return
        L_0x005e:
            com.alibaba.fastjson.JSONArray r6 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x00f4 }
            r6.<init>()     // Catch:{ all -> 0x00f4 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00f4 }
            r8.parseArray((java.util.Collection) r6, (java.lang.Object) r4)     // Catch:{ all -> 0x00f4 }
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.UseObjectArray     // Catch:{ all -> 0x00f4 }
            boolean r4 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r4)     // Catch:{ all -> 0x00f4 }
            if (r4 == 0) goto L_0x00e1
            java.lang.Object[] r6 = r6.toArray()     // Catch:{ all -> 0x00f4 }
            goto L_0x00e1
        L_0x0078:
            com.alibaba.fastjson.JSONObject r4 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x00f4 }
            com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x00f4 }
            boolean r6 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r6)     // Catch:{ all -> 0x00f4 }
            r4.<init>((boolean) r6)     // Catch:{ all -> 0x00f4 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00f4 }
            java.lang.Object r6 = r8.parseObject((java.util.Map) r4, (java.lang.Object) r6)     // Catch:{ all -> 0x00f4 }
            goto L_0x00e1
        L_0x008c:
            r0.nextToken(r1)     // Catch:{ all -> 0x00f4 }
            goto L_0x00e1
        L_0x0090:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00f4 }
            r0.nextToken(r5)     // Catch:{ all -> 0x00f4 }
            goto L_0x00e1
        L_0x0096:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00f4 }
            r0.nextToken(r5)     // Catch:{ all -> 0x00f4 }
            goto L_0x00e1
        L_0x009c:
            java.lang.String r6 = r0.stringVal()     // Catch:{ all -> 0x00f4 }
            r0.nextToken(r5)     // Catch:{ all -> 0x00f4 }
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x00f4 }
            boolean r4 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r4)     // Catch:{ all -> 0x00f4 }
            if (r4 == 0) goto L_0x00e1
            com.alibaba.fastjson.parser.JSONScanner r4 = new com.alibaba.fastjson.parser.JSONScanner     // Catch:{ all -> 0x00f4 }
            r4.<init>(r6)     // Catch:{ all -> 0x00f4 }
            boolean r7 = r4.scanISO8601DateIfMatch()     // Catch:{ all -> 0x00f4 }
            if (r7 == 0) goto L_0x00be
            java.util.Calendar r6 = r4.getCalendar()     // Catch:{ all -> 0x00f4 }
            java.util.Date r6 = r6.getTime()     // Catch:{ all -> 0x00f4 }
        L_0x00be:
            r4.close()     // Catch:{ all -> 0x00f4 }
            goto L_0x00e1
        L_0x00c2:
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x00f4 }
            boolean r4 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r4)     // Catch:{ all -> 0x00f4 }
            if (r4 == 0) goto L_0x00d1
            r4 = 1
            java.lang.Number r4 = r0.decimalValue(r4)     // Catch:{ all -> 0x00f4 }
        L_0x00cf:
            r6 = r4
            goto L_0x00d6
        L_0x00d1:
            java.lang.Number r4 = r0.decimalValue(r10)     // Catch:{ all -> 0x00f4 }
            goto L_0x00cf
        L_0x00d6:
            r0.nextToken(r5)     // Catch:{ all -> 0x00f4 }
            goto L_0x00e1
        L_0x00da:
            java.lang.Number r6 = r0.integerValue()     // Catch:{ all -> 0x00f4 }
            r0.nextToken(r5)     // Catch:{ all -> 0x00f4 }
        L_0x00e1:
            r9.add(r6)     // Catch:{ all -> 0x00f4 }
            r8.checkListResolve(r9)     // Catch:{ all -> 0x00f4 }
            int r4 = r0.token()     // Catch:{ all -> 0x00f4 }
            if (r4 != r5) goto L_0x00f0
            r0.nextToken(r1)     // Catch:{ all -> 0x00f4 }
        L_0x00f0:
            int r3 = r3 + 1
            goto L_0x0028
        L_0x00f4:
            r9 = move-exception
            r8.setContext(r2)
            throw r9
        L_0x00f9:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "syntax error, expect [, actual "
            r10.append(r1)
            int r1 = r0.token()
            java.lang.String r1 = com.alibaba.fastjson.parser.JSONToken.name(r1)
            r10.append(r1)
            java.lang.String r1 = ", pos "
            r10.append(r1)
            int r0 = r0.pos()
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(java.util.Collection, java.lang.Object):void");
    }

    public ParseContext getContext() {
        return this.context;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(this.resolveTaskList.size() - 1);
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver2) {
        this.fieldTypeResolver = fieldTypeResolver2;
    }

    public void setContext(ParseContext parseContext) {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = parseContext;
        }
    }

    public void popContext() {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = this.context.parent;
            this.contextArray[this.contextArrayIndex - 1] = null;
            this.contextArrayIndex--;
        }
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        this.context = new ParseContext(parseContext, obj, obj2);
        addContext(this.context);
        return this.context;
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        if (this.contextArray == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= this.contextArray.length) {
            ParseContext[] parseContextArr = new ParseContext[((this.contextArray.length * 3) / 2)];
            System.arraycopy(this.contextArray, 0, parseContextArr, 0, this.contextArray.length);
            this.contextArray = parseContextArr;
        }
        this.contextArray[i] = parseContext;
    }

    public Object parse() {
        return parse((Object) null);
    }

    public Object parseKey() {
        if (this.lexer.token() != 18) {
            return parse((Object) null);
        }
        String stringVal = this.lexer.stringVal();
        this.lexer.nextToken(16);
        return stringVal;
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        switch (jSONLexer.token()) {
            case 2:
                Number integerValue = jSONLexer.integerValue();
                jSONLexer.nextToken();
                return integerValue;
            case 3:
                Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
                jSONLexer.nextToken();
                return decimalValue;
            case 4:
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                    JSONScanner jSONScanner = new JSONScanner(stringVal);
                    try {
                        if (jSONScanner.scanISO8601DateIfMatch()) {
                            return jSONScanner.getCalendar().getTime();
                        }
                        jSONScanner.close();
                    } finally {
                        jSONScanner.close();
                    }
                }
                return stringVal;
            case 6:
                jSONLexer.nextToken();
                return Boolean.TRUE;
            case 7:
                jSONLexer.nextToken();
                return Boolean.FALSE;
            case 8:
                jSONLexer.nextToken();
                return null;
            case 9:
                jSONLexer.nextToken(18);
                if (jSONLexer.token() == 18) {
                    jSONLexer.nextToken(10);
                    accept(10);
                    long longValue = jSONLexer.integerValue().longValue();
                    accept(2);
                    accept(11);
                    return new Date(longValue);
                }
                throw new JSONException("syntax error");
            case 12:
                return parseObject((Map) new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
            case 14:
                JSONArray jSONArray = new JSONArray();
                parseArray((Collection) jSONArray, obj);
                return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
            case 20:
                if (jSONLexer.isBlankInput()) {
                    return null;
                }
                throw new JSONException("unterminated json string, " + jSONLexer.info());
            case 21:
                jSONLexer.nextToken();
                HashSet hashSet = new HashSet();
                parseArray((Collection) hashSet, obj);
                return hashSet;
            case 22:
                jSONLexer.nextToken();
                TreeSet treeSet = new TreeSet();
                parseArray((Collection) treeSet, obj);
                return treeSet;
            case 23:
                jSONLexer.nextToken();
                return null;
            default:
                throw new JSONException("syntax error, " + jSONLexer.info());
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource)) {
                if (jSONLexer.token() != 20) {
                    throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
                }
            }
        } finally {
            jSONLexer.close();
        }
    }

    public void handleResovleTask(Object obj) {
        if (this.resolveTaskList != null) {
            int size = this.resolveTaskList.size();
            for (int i = 0; i < size; i++) {
                ResolveTask resolveTask = this.resolveTaskList.get(i);
                String str = resolveTask.referenceValue;
                Object obj2 = null;
                if (resolveTask.ownerContext != null) {
                    obj2 = resolveTask.ownerContext.object;
                }
                Object object = str.startsWith("$") ? getObject(str) : resolveTask.context.object;
                FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
                if (fieldDeserializer != null) {
                    fieldDeserializer.setValue(obj2, object);
                }
            }
        }
    }

    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public void parseExtra(Object obj, String str) {
        Object obj2;
        this.lexer.nextTokenWithColon();
        Type type = null;
        if (this.extraTypeProviders != null) {
            for (ExtraTypeProvider extraType : this.extraTypeProviders) {
                type = extraType.getExtraType(obj, str);
            }
        }
        if (type == null) {
            obj2 = parse();
        } else {
            obj2 = parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, obj2);
        } else if (this.extraProcessors != null) {
            for (ExtraProcessor processExtra : this.extraProcessors) {
                processExtra.processExtra(obj, str, obj2);
            }
        }
    }
}
