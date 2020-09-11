package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.savior.Constants;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TypeUtils {
    public static boolean compatibleWithFieldName = false;
    public static boolean compatibleWithJavaBean = false;
    private static ConcurrentMap<String, Class<?>> mappings = new ConcurrentHashMap();
    private static Class<?> optionalClass = null;
    private static boolean optionalClassInited = false;
    private static Method oracleDateMethod = null;
    private static boolean oracleDateMethodInited = false;
    private static Method oracleTimestampMethod = null;
    private static boolean oracleTimestampMethodInited = false;
    private static Class<?> pathClass = null;
    private static boolean pathClass_error = false;
    private static boolean setAccessibleEnable = true;
    private static Class<? extends Annotation> transientClass = null;
    private static boolean transientClassInited = false;

    public static String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new JSONException("can not cast to char, value : " + obj);
        }
        throw new JSONException("can not cast to char, value : " + obj);
    }

    public static Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static BigInteger castToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != 0) {
                obj2 = obj2.replaceAll(SystemInfoUtil.COMMA, "");
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new JSONException("can not cast to float, value : " + obj);
    }

    public static Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != 0) {
                obj2 = obj2.replaceAll(SystemInfoUtil.COMMA, "");
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new JSONException("can not cast to double, value : " + obj);
    }

    public static Date castToDate(Object obj) {
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        long j = -1;
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            JSONScanner jSONScanner = new JSONScanner(str2);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    return jSONScanner.getCalendar().getTime();
                }
                jSONScanner.close();
                if (str2.startsWith("/Date(") && str2.endsWith(")/")) {
                    str2 = str2.substring(6, str2.length() - 2);
                }
                if (str2.indexOf(45) != -1) {
                    if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
                        str = JSON.DEFFAULT_DATE_FORMAT;
                    } else if (str2.length() == 10) {
                        str = "yyyy-MM-dd";
                    } else {
                        str = str2.length() == "yyyy-MM-dd HH:mm:ss".length() ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss.SSS";
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                    simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(str2);
                    } catch (ParseException unused) {
                        throw new JSONException("can not cast to Date, value : " + str2);
                    }
                } else if (str2.length() == 0) {
                    return null;
                } else {
                    j = Long.parseLong(str2);
                }
            } finally {
                jSONScanner.close();
            }
        }
        if (j >= 0) {
            return new Date(j);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                try {
                    oracleTimestampMethod = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused2) {
                } catch (Throwable th) {
                    oracleTimestampMethodInited = true;
                    throw th;
                }
                oracleTimestampMethodInited = true;
            }
            try {
                return (Date) oracleTimestampMethod.invoke(obj, new Object[0]);
            } catch (Exception e) {
                throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e);
            }
        } else if ("oracle.sql.DATE".equals(cls.getName())) {
            if (oracleDateMethod == null && !oracleDateMethodInited) {
                try {
                    oracleDateMethod = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused3) {
                } catch (Throwable th2) {
                    oracleDateMethodInited = true;
                    throw th2;
                }
                oracleDateMethodInited = true;
            }
            try {
                return (Date) oracleDateMethod.invoke(obj, new Object[0]);
            } catch (Exception e2) {
                throw new JSONException("can not cast oracle.sql.DATE to Date", e2);
            }
        } else {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
    }

    public static java.sql.Date castToSqlDate(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            longValue = Long.parseLong(str);
        }
        if (longValue > 0) {
            return new java.sql.Date(longValue);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static Timestamp castToTimestamp(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            longValue = Long.parseLong(str);
        }
        if (longValue > 0) {
            return new Timestamp(longValue);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static Long castToLong(Object obj) {
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != 0) {
                str = str.replaceAll(SystemInfoUtil.COMMA, "");
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    calendar = jSONScanner.getCalendar();
                }
                jSONScanner.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != 0) {
                str = str.replaceAll(SystemInfoUtil.COMMA, "");
            }
            return Integer.valueOf(Integer.parseInt(str));
        } else if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else {
            throw new JSONException("can not cast to int, value : " + obj);
        }
    }

    public static byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return IOUtils.decodeBase64((String) obj);
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            boolean z = true;
            if (((Number) obj).intValue() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to boolean, value : " + obj);
    }

    public static <T> T castToJavaBean(Object obj, Class<T> cls) {
        return cast(obj, cls, ParserConfig.getGlobalInstance());
    }

    public static <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        T t;
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        int i = 0;
                        T newInstance = Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object cast : collection) {
                            Array.set(newInstance, i, cast(cast, cls.getComponentType(), parserConfig));
                            i++;
                        }
                        return newInstance;
                    } else if (cls == byte[].class) {
                        return castToBytes(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return castToBoolean(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return castToByte(obj);
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return castToShort(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return castToInt(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return castToLong(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return castToFloat(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return castToDouble(obj);
                }
                if (cls == String.class) {
                    return castToString(obj);
                }
                if (cls == BigDecimal.class) {
                    return castToBigDecimal(obj);
                }
                if (cls == BigInteger.class) {
                    return castToBigInteger(obj);
                }
                if (cls == Date.class) {
                    return castToDate(obj);
                }
                if (cls == java.sql.Date.class) {
                    return castToSqlDate(obj);
                }
                if (cls == Timestamp.class) {
                    return castToTimestamp(obj);
                }
                if (cls.isEnum()) {
                    return castToEnum(obj, cls, parserConfig);
                }
                if (Calendar.class.isAssignableFrom(cls)) {
                    Date castToDate = castToDate(obj);
                    if (cls == Calendar.class) {
                        t = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    } else {
                        try {
                            t = (Calendar) cls.newInstance();
                        } catch (Exception e) {
                            throw new JSONException("can not cast to : " + cls.getName(), e);
                        }
                    }
                    t.setTime(castToDate);
                    return t;
                }
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                        return null;
                    }
                    if (cls == Currency.class) {
                        return Currency.getInstance(str);
                    }
                }
                throw new JSONException("can not cast to : " + cls.getName());
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) {
                    return castToJavaBean(map, cls, parserConfig);
                }
                return obj;
            }
        }
    }

    public static <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    public static <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == null) {
            return null;
        }
        if (type instanceof Class) {
            return cast(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    public static <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        T t;
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType == Set.class || rawType == HashSet.class) {
                    t = new HashSet();
                } else if (rawType == TreeSet.class) {
                    t = new TreeSet();
                } else {
                    t = new ArrayList();
                }
                for (Object cast : (Iterable) obj) {
                    t.add(cast(cast, type, parserConfig));
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                T hashMap = new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    hashMap.put(cast(entry.getKey(), type2, parserConfig), cast(entry.getValue(), type3, parserConfig));
                }
                return hashMap;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return cast(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [com.alibaba.fastjson.parser.deserializer.ObjectDeserializer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T castToJavaBean(java.util.Map<java.lang.String, java.lang.Object> r3, java.lang.Class<T> r4, com.alibaba.fastjson.parser.ParserConfig r5) {
        /*
            java.lang.Class<java.lang.StackTraceElement> r0 = java.lang.StackTraceElement.class
            r1 = 0
            if (r4 != r0) goto L_0x0032
            java.lang.String r4 = "className"
            java.lang.Object r4 = r3.get(r4)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00ac }
            java.lang.String r5 = "methodName"
            java.lang.Object r5 = r3.get(r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00ac }
            java.lang.String r0 = "fileName"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00ac }
            java.lang.String r2 = "lineNumber"
            java.lang.Object r3 = r3.get(r2)     // Catch:{ Exception -> 0x00ac }
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ Exception -> 0x00ac }
            if (r3 != 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            int r1 = r3.intValue()     // Catch:{ Exception -> 0x00ac }
        L_0x002c:
            java.lang.StackTraceElement r3 = new java.lang.StackTraceElement     // Catch:{ Exception -> 0x00ac }
            r3.<init>(r4, r5, r0, r1)     // Catch:{ Exception -> 0x00ac }
            return r3
        L_0x0032:
            java.lang.String r0 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ Exception -> 0x00ac }
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x00ac }
            boolean r2 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x00ac }
            if (r2 == 0) goto L_0x0066
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00ac }
            java.lang.Class r2 = loadClass(r0)     // Catch:{ Exception -> 0x00ac }
            if (r2 == 0) goto L_0x004f
            boolean r0 = r2.equals(r4)     // Catch:{ Exception -> 0x00ac }
            if (r0 != 0) goto L_0x0066
            java.lang.Object r3 = castToJavaBean(r3, r2, r5)     // Catch:{ Exception -> 0x00ac }
            return r3
        L_0x004f:
            java.lang.ClassNotFoundException r3 = new java.lang.ClassNotFoundException     // Catch:{ Exception -> 0x00ac }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ac }
            r4.<init>()     // Catch:{ Exception -> 0x00ac }
            r4.append(r0)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r5 = " not found"
            r4.append(r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00ac }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00ac }
            throw r3     // Catch:{ Exception -> 0x00ac }
        L_0x0066:
            boolean r0 = r4.isInterface()     // Catch:{ Exception -> 0x00ac }
            if (r0 == 0) goto L_0x008b
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x00ac }
            if (r5 == 0) goto L_0x0073
            com.alibaba.fastjson.JSONObject r3 = (com.alibaba.fastjson.JSONObject) r3     // Catch:{ Exception -> 0x00ac }
            goto L_0x0079
        L_0x0073:
            com.alibaba.fastjson.JSONObject r5 = new com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x00ac }
            r5.<init>((java.util.Map<java.lang.String, java.lang.Object>) r3)     // Catch:{ Exception -> 0x00ac }
            r3 = r5
        L_0x0079:
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x00ac }
            java.lang.ClassLoader r5 = r5.getContextClassLoader()     // Catch:{ Exception -> 0x00ac }
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x00ac }
            r0[r1] = r4     // Catch:{ Exception -> 0x00ac }
            java.lang.Object r3 = java.lang.reflect.Proxy.newProxyInstance(r5, r0, r3)     // Catch:{ Exception -> 0x00ac }
            return r3
        L_0x008b:
            if (r5 != 0) goto L_0x0091
            com.alibaba.fastjson.parser.ParserConfig r5 = com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance()     // Catch:{ Exception -> 0x00ac }
        L_0x0091:
            r0 = 0
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r5.getDeserializer((java.lang.reflect.Type) r4)     // Catch:{ Exception -> 0x00ac }
            boolean r1 = r4 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer     // Catch:{ Exception -> 0x00ac }
            if (r1 == 0) goto L_0x009d
            r0 = r4
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r0 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0     // Catch:{ Exception -> 0x00ac }
        L_0x009d:
            if (r0 == 0) goto L_0x00a4
            java.lang.Object r3 = r0.createInstance((java.util.Map<java.lang.String, java.lang.Object>) r3, (com.alibaba.fastjson.parser.ParserConfig) r5)     // Catch:{ Exception -> 0x00ac }
            return r3
        L_0x00a4:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "can not get javaBeanDeserializer"
            r3.<init>(r4)     // Catch:{ Exception -> 0x00ac }
            throw r3     // Catch:{ Exception -> 0x00ac }
        L_0x00ac:
            r3 = move-exception
            com.alibaba.fastjson.JSONException r4 = new com.alibaba.fastjson.JSONException
            java.lang.String r5 = r3.getMessage()
            r4.<init>(r5, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.castToJavaBean(java.util.Map, java.lang.Class, com.alibaba.fastjson.parser.ParserConfig):java.lang.Object");
    }

    static {
        addBaseClassMappings();
    }

    private static void addBaseClassMappings() {
        mappings.put(Constants.BYTE, Byte.TYPE);
        mappings.put(Constants.SHORT, Short.TYPE);
        mappings.put(Constants.INT, Integer.TYPE);
        mappings.put(Constants.LONG, Long.TYPE);
        mappings.put(Constants.FLOAT, Float.TYPE);
        mappings.put(Constants.DOUBLE, Double.TYPE);
        mappings.put(Constants.BOOLEAN, Boolean.TYPE);
        mappings.put(Constants.CHAR, Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        mappings.put(HashMap.class.getName(), HashMap.class);
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    public static Class<?> loadClass(String str) {
        return loadClass(str, (ClassLoader) null);
    }

    public static boolean isPath(Class<?> cls) {
        if (pathClass == null && !pathClass_error) {
            try {
                pathClass = Class.forName("java.nio.file.Path");
            } catch (Throwable unused) {
                pathClass_error = true;
            }
        }
        if (pathClass != null) {
            return pathClass.isAssignableFrom(cls);
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:22|25|27|28|(0)|36|37|38|39|40) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x007a */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f A[Catch:{ Throwable -> 0x007a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> loadClass(java.lang.String r6, java.lang.ClassLoader r7) {
        /*
            if (r6 == 0) goto L_0x0086
            int r0 = r6.length()
            if (r0 != 0) goto L_0x000a
            goto L_0x0086
        L_0x000a:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r0 = mappings
            java.lang.Object r0 = r0.get(r6)
            java.lang.Class r0 = (java.lang.Class) r0
            if (r0 == 0) goto L_0x0015
            return r0
        L_0x0015:
            r1 = 0
            char r2 = r6.charAt(r1)
            r3 = 91
            r4 = 1
            if (r2 != r3) goto L_0x0030
            java.lang.String r6 = r6.substring(r4)
            java.lang.Class r6 = loadClass(r6, r7)
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r6, r1)
            java.lang.Class r6 = r6.getClass()
            return r6
        L_0x0030:
            java.lang.String r1 = "L"
            boolean r1 = r6.startsWith(r1)
            if (r1 == 0) goto L_0x004e
            java.lang.String r1 = ";"
            boolean r1 = r6.endsWith(r1)
            if (r1 == 0) goto L_0x004e
            int r0 = r6.length()
            int r0 = r0 - r4
            java.lang.String r6 = r6.substring(r4, r0)
            java.lang.Class r6 = loadClass(r6, r7)
            return r6
        L_0x004e:
            if (r7 == 0) goto L_0x0064
            java.lang.Class r7 = r7.loadClass(r6)     // Catch:{ Throwable -> 0x005c }
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r0 = mappings     // Catch:{ Throwable -> 0x005a }
            r0.put(r6, r7)     // Catch:{ Throwable -> 0x005a }
            return r7
        L_0x005a:
            r0 = move-exception
            goto L_0x0060
        L_0x005c:
            r7 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L_0x0060:
            r0.printStackTrace()
            goto L_0x0065
        L_0x0064:
            r7 = r0
        L_0x0065:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Throwable -> 0x007a }
            java.lang.ClassLoader r0 = r0.getContextClassLoader()     // Catch:{ Throwable -> 0x007a }
            if (r0 == 0) goto L_0x007a
            java.lang.Class r0 = r0.loadClass(r6)     // Catch:{ Throwable -> 0x007a }
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r7 = mappings     // Catch:{ Throwable -> 0x0079 }
            r7.put(r6, r0)     // Catch:{ Throwable -> 0x0079 }
            return r0
        L_0x0079:
            r7 = r0
        L_0x007a:
            java.lang.Class r0 = java.lang.Class.forName(r6)     // Catch:{ Throwable -> 0x0084 }
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r7 = mappings     // Catch:{ Throwable -> 0x0085 }
            r7.put(r6, r0)     // Catch:{ Throwable -> 0x0085 }
            return r0
        L_0x0084:
            r0 = r7
        L_0x0085:
            return r0
        L_0x0086:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.loadClass(java.lang.String, java.lang.ClassLoader):java.lang.Class");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.String[]} */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.fastjson.serializer.SerializeBeanInfo buildBeanInfo(java.lang.Class<?> r11, java.util.Map<java.lang.String, java.lang.String> r12, com.alibaba.fastjson.PropertyNamingStrategy r13) {
        /*
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r0 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r0 = r11.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONType r0 = (com.alibaba.fastjson.annotation.JSONType) r0
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            com.alibaba.fastjson.parser.ParserConfig.parserAllFieldToCache(r11, r7)
            r5 = 0
            r1 = r11
            r2 = r0
            r3 = r12
            r4 = r7
            r6 = r13
            java.util.List r1 = computeGetters(r1, r2, r3, r4, r5, r6)
            int r2 = r1.size()
            com.alibaba.fastjson.util.FieldInfo[] r8 = new com.alibaba.fastjson.util.FieldInfo[r2]
            r1.toArray(r8)
            r2 = 0
            if (r0 == 0) goto L_0x0042
            java.lang.String[] r3 = r0.orders()
            java.lang.String r4 = r0.typeName()
            int r5 = r4.length()
            if (r5 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r2 = r4
        L_0x0036:
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r0.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r4)
            r9 = r2
            r2 = r3
            r10 = r4
            goto L_0x0045
        L_0x0042:
            r3 = 0
            r9 = r2
            r10 = 0
        L_0x0045:
            if (r2 == 0) goto L_0x0055
            int r2 = r2.length
            if (r2 == 0) goto L_0x0055
            r5 = 1
            r1 = r11
            r2 = r0
            r3 = r12
            r4 = r7
            r6 = r13
            java.util.List r12 = computeGetters(r1, r2, r3, r4, r5, r6)
            goto L_0x005d
        L_0x0055:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>(r1)
            java.util.Collections.sort(r12)
        L_0x005d:
            int r13 = r12.size()
            com.alibaba.fastjson.util.FieldInfo[] r13 = new com.alibaba.fastjson.util.FieldInfo[r13]
            r12.toArray(r13)
            boolean r12 = java.util.Arrays.equals(r13, r8)
            if (r12 == 0) goto L_0x006e
            r7 = r8
            goto L_0x006f
        L_0x006e:
            r7 = r13
        L_0x006f:
            com.alibaba.fastjson.serializer.SerializeBeanInfo r12 = new com.alibaba.fastjson.serializer.SerializeBeanInfo
            r1 = r12
            r2 = r11
            r3 = r0
            r4 = r9
            r5 = r10
            r6 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.buildBeanInfo(java.lang.Class, java.util.Map, com.alibaba.fastjson.PropertyNamingStrategy):com.alibaba.fastjson.serializer.SerializeBeanInfo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0336, code lost:
        if (r0 == null) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x020c, code lost:
        if (r0 == null) goto L_0x0122;
     */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0373  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x04a2  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x04b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> r34, com.alibaba.fastjson.annotation.JSONType r35, java.util.Map<java.lang.String, java.lang.String> r36, java.util.Map<java.lang.String, java.lang.reflect.Field> r37, boolean r38, com.alibaba.fastjson.PropertyNamingStrategy r39) {
        /*
            r12 = r34
            r13 = r36
            r14 = r37
            r15 = r39
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>()
            java.lang.reflect.Method[] r10 = r34.getMethods()
            int r9 = r10.length
            r16 = 0
            r8 = 0
        L_0x0015:
            r17 = 0
            r7 = 1
            if (r8 >= r9) goto L_0x03ad
            r6 = r10[r8]
            java.lang.String r5 = r6.getName()
            r18 = 0
            int r0 = r6.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 == 0) goto L_0x0037
        L_0x002c:
            r26 = r8
            r27 = r9
            r28 = r10
            r14 = r11
            r12 = r13
            r13 = r15
            goto L_0x039e
        L_0x0037:
            java.lang.Class r0 = r6.getReturnType()
            java.lang.Class r1 = java.lang.Void.TYPE
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0044
            goto L_0x002c
        L_0x0044:
            java.lang.Class[] r0 = r6.getParameterTypes()
            int r0 = r0.length
            if (r0 == 0) goto L_0x004c
            goto L_0x002c
        L_0x004c:
            java.lang.Class r0 = r6.getReturnType()
            java.lang.Class<java.lang.ClassLoader> r1 = java.lang.ClassLoader.class
            if (r0 != r1) goto L_0x0055
            goto L_0x002c
        L_0x0055:
            java.lang.String r0 = r6.getName()
            java.lang.String r1 = "getMetaClass"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            java.lang.Class r0 = r6.getReturnType()
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "groovy.lang.MetaClass"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            goto L_0x002c
        L_0x0072:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r0 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r0 = r6.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            if (r0 != 0) goto L_0x0080
            com.alibaba.fastjson.annotation.JSONField r0 = getSuperMethodAnnotation(r12, r6)
        L_0x0080:
            r19 = r0
            if (r19 == 0) goto L_0x0101
            boolean r0 = r19.serialize()
            if (r0 != 0) goto L_0x008b
            goto L_0x002c
        L_0x008b:
            int r20 = r19.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r19.serialzeFeatures()
            int r21 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r19.parseFeatures()
            int r22 = com.alibaba.fastjson.parser.Feature.m395of(r0)
            java.lang.String r0 = r19.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x00eb
            java.lang.String r0 = r19.name()
            if (r13 == 0) goto L_0x00b9
            java.lang.Object r0 = r13.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x00b9
            goto L_0x002c
        L_0x00b9:
            r7 = r0
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r17 = 0
            r23 = 0
            r0 = r5
            r1 = r7
            r2 = r6
            r4 = r34
            r6 = r5
            r5 = r17
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r21
            r26 = r8
            r8 = r22
            r27 = r9
            r9 = r19
            r28 = r10
            r10 = r23
            r15 = r11
            r11 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r24
            r1 = r25
            r15.put(r1, r0)
            goto L_0x0122
        L_0x00eb:
            r26 = r8
            r27 = r9
            r28 = r10
            r15 = r11
            java.lang.String r0 = r19.label()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x010e
            java.lang.String r18 = r19.label()
            goto L_0x010e
        L_0x0101:
            r26 = r8
            r27 = r9
            r28 = r10
            r15 = r11
            r20 = 0
            r21 = 0
            r22 = 0
        L_0x010e:
            java.lang.String r0 = "get"
            boolean r0 = r5.startsWith(r0)
            r11 = 102(0x66, float:1.43E-43)
            r10 = 95
            r9 = 3
            if (r0 == 0) goto L_0x027c
            int r0 = r5.length()
            r1 = 4
            if (r0 >= r1) goto L_0x0126
        L_0x0122:
            r12 = r13
            r14 = r15
            goto L_0x039c
        L_0x0126:
            java.lang.String r0 = "getClass"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x012f
            goto L_0x0122
        L_0x012f:
            java.lang.String r0 = "getDeclaringClass"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x013e
            boolean r0 = r34.isEnum()
            if (r0 == 0) goto L_0x013e
            goto L_0x0122
        L_0x013e:
            char r0 = r5.charAt(r9)
            boolean r2 = java.lang.Character.isUpperCase(r0)
            if (r2 != 0) goto L_0x0175
            r2 = 512(0x200, float:7.175E-43)
            if (r0 <= r2) goto L_0x014d
            goto L_0x0175
        L_0x014d:
            if (r0 != r10) goto L_0x0154
            java.lang.String r0 = r5.substring(r1)
            goto L_0x01a1
        L_0x0154:
            if (r0 != r11) goto L_0x015b
            java.lang.String r0 = r5.substring(r9)
            goto L_0x01a1
        L_0x015b:
            int r0 = r5.length()
            r2 = 5
            if (r0 < r2) goto L_0x0122
            char r0 = r5.charAt(r1)
            boolean r0 = java.lang.Character.isUpperCase(r0)
            if (r0 == 0) goto L_0x0122
            java.lang.String r0 = r5.substring(r9)
            java.lang.String r0 = decapitalize(r0)
            goto L_0x01a1
        L_0x0175:
            boolean r0 = compatibleWithJavaBean
            if (r0 == 0) goto L_0x0182
            java.lang.String r0 = r5.substring(r9)
            java.lang.String r0 = decapitalize(r0)
            goto L_0x019d
        L_0x0182:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r2 = r5.charAt(r9)
            char r2 = java.lang.Character.toLowerCase(r2)
            r0.append(r2)
            java.lang.String r1 = r5.substring(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x019d:
            java.lang.String r0 = getPropertyNameByCompatibleFieldName(r14, r5, r0, r9)
        L_0x01a1:
            boolean r1 = isJSONTypeIgnore(r12, r0)
            if (r1 == 0) goto L_0x01a9
            goto L_0x0122
        L_0x01a9:
            java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r0, r14)
            if (r1 != 0) goto L_0x01cd
            int r2 = r0.length()
            if (r2 <= r7) goto L_0x01cd
            char r2 = r0.charAt(r7)
            r3 = 65
            if (r2 < r3) goto L_0x01cd
            r3 = 90
            if (r2 > r3) goto L_0x01cd
            java.lang.String r1 = r5.substring(r9)
            java.lang.String r1 = decapitalize(r1)
            java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r1, r14)
        L_0x01cd:
            r3 = r1
            if (r3 == 0) goto L_0x0234
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            if (r1 == 0) goto L_0x022f
            boolean r2 = r1.serialize()
            if (r2 != 0) goto L_0x01e2
            goto L_0x0122
        L_0x01e2:
            int r2 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r1.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r4)
            com.alibaba.fastjson.parser.Feature[] r7 = r1.parseFeatures()
            int r7 = com.alibaba.fastjson.parser.Feature.m395of(r7)
            java.lang.String r8 = r1.name()
            int r8 = r8.length()
            if (r8 == 0) goto L_0x0210
            java.lang.String r0 = r1.name()
            if (r13 == 0) goto L_0x0210
            java.lang.Object r0 = r13.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0210
            goto L_0x0122
        L_0x0210:
            java.lang.String r8 = r1.label()
            int r8 = r8.length()
            if (r8 == 0) goto L_0x0229
            java.lang.String r8 = r1.label()
            r18 = r1
            r20 = r2
            r21 = r4
            r22 = r7
            r23 = r8
            goto L_0x0238
        L_0x0229:
            r20 = r2
            r21 = r4
            r22 = r7
        L_0x022f:
            r23 = r18
            r18 = r1
            goto L_0x0238
        L_0x0234:
            r23 = r18
            r18 = r17
        L_0x0238:
            if (r13 == 0) goto L_0x0244
            java.lang.Object r0 = r13.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0244
            goto L_0x0122
        L_0x0244:
            r8 = r15
            r15 = r39
            if (r15 == 0) goto L_0x024d
            java.lang.String r0 = r15.translate(r0)
        L_0x024d:
            r7 = r0
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r24 = 0
            r0 = r4
            r1 = r7
            r2 = r6
            r12 = r4
            r4 = r34
            r15 = r5
            r5 = r24
            r24 = r6
            r6 = r20
            r29 = r7
            r7 = r21
            r30 = r8
            r8 = r22
            r9 = r19
            r10 = r18
            r13 = 102(0x66, float:1.43E-43)
            r11 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r29
            r11 = r30
            r11.put(r0, r12)
            r18 = r23
            goto L_0x0282
        L_0x027c:
            r24 = r6
            r11 = r15
            r13 = 102(0x66, float:1.43E-43)
            r15 = r5
        L_0x0282:
            java.lang.String r0 = "is"
            boolean r0 = r15.startsWith(r0)
            if (r0 == 0) goto L_0x0399
            int r0 = r15.length()
            r1 = 3
            if (r0 >= r1) goto L_0x0293
            goto L_0x0399
        L_0x0293:
            java.lang.Class r0 = r24.getReturnType()
            java.lang.Class r2 = java.lang.Boolean.TYPE
            if (r0 == r2) goto L_0x02a5
            java.lang.Class r0 = r24.getReturnType()
            java.lang.Class<java.lang.Boolean> r2 = java.lang.Boolean.class
            if (r0 == r2) goto L_0x02a5
        L_0x02a3:
            goto L_0x0399
        L_0x02a5:
            r0 = 2
            char r2 = r15.charAt(r0)
            boolean r3 = java.lang.Character.isUpperCase(r2)
            if (r3 == 0) goto L_0x02dd
            boolean r2 = compatibleWithJavaBean
            if (r2 == 0) goto L_0x02bd
            java.lang.String r1 = r15.substring(r0)
            java.lang.String r1 = decapitalize(r1)
            goto L_0x02d8
        L_0x02bd:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            char r3 = r15.charAt(r0)
            char r3 = java.lang.Character.toLowerCase(r3)
            r2.append(r3)
            java.lang.String r1 = r15.substring(r1)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L_0x02d8:
            java.lang.String r0 = getPropertyNameByCompatibleFieldName(r14, r15, r1, r0)
            goto L_0x02ec
        L_0x02dd:
            r3 = 95
            if (r2 != r3) goto L_0x02e6
            java.lang.String r0 = r15.substring(r1)
            goto L_0x02ec
        L_0x02e6:
            if (r2 != r13) goto L_0x0399
            java.lang.String r0 = r15.substring(r0)
        L_0x02ec:
            java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r0, r14)
            if (r1 != 0) goto L_0x02f6
            java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.getFieldFromCache(r15, r14)
        L_0x02f6:
            r3 = r1
            if (r3 == 0) goto L_0x0359
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            if (r1 == 0) goto L_0x0355
            boolean r2 = r1.serialize()
            if (r2 != 0) goto L_0x030a
            goto L_0x02a3
        L_0x030a:
            int r2 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r1.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r4)
            com.alibaba.fastjson.parser.Feature[] r5 = r1.parseFeatures()
            int r5 = com.alibaba.fastjson.parser.Feature.m395of(r5)
            java.lang.String r6 = r1.name()
            int r6 = r6.length()
            if (r6 == 0) goto L_0x0339
            java.lang.String r0 = r1.name()
            r12 = r36
            if (r12 == 0) goto L_0x033b
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x033b
            goto L_0x036d
        L_0x0339:
            r12 = r36
        L_0x033b:
            java.lang.String r6 = r1.label()
            int r6 = r6.length()
            if (r6 == 0) goto L_0x0350
            java.lang.String r6 = r1.label()
            r10 = r1
            r7 = r4
            r8 = r5
            r18 = r6
            r6 = r2
            goto L_0x0363
        L_0x0350:
            r10 = r1
            r6 = r2
            r7 = r4
            r8 = r5
            goto L_0x0363
        L_0x0355:
            r12 = r36
            r10 = r1
            goto L_0x035d
        L_0x0359:
            r12 = r36
            r10 = r17
        L_0x035d:
            r6 = r20
            r7 = r21
            r8 = r22
        L_0x0363:
            if (r12 == 0) goto L_0x036f
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x036f
        L_0x036d:
            r14 = r11
            goto L_0x039c
        L_0x036f:
            r13 = r39
            if (r13 == 0) goto L_0x0377
            java.lang.String r0 = r13.translate(r0)
        L_0x0377:
            r15 = r0
            boolean r0 = r11.containsKey(r15)
            if (r0 == 0) goto L_0x0380
            r14 = r11
            goto L_0x039e
        L_0x0380:
            com.alibaba.fastjson.util.FieldInfo r9 = new com.alibaba.fastjson.util.FieldInfo
            r5 = 0
            r0 = r9
            r1 = r15
            r2 = r24
            r4 = r34
            r31 = r9
            r9 = r19
            r14 = r11
            r11 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r31
            r14.put(r15, r0)
            goto L_0x039e
        L_0x0399:
            r14 = r11
            r12 = r36
        L_0x039c:
            r13 = r39
        L_0x039e:
            int r8 = r26 + 1
            r15 = r13
            r11 = r14
            r9 = r27
            r10 = r28
            r14 = r37
            r13 = r12
            r12 = r34
            goto L_0x0015
        L_0x03ad:
            r14 = r11
            r12 = r13
            r13 = r15
            java.lang.reflect.Field[] r15 = r34.getFields()
            int r11 = r15.length
            r10 = 0
        L_0x03b6:
            if (r10 >= r11) goto L_0x046c
            r3 = r15[r10]
            int r0 = r3.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 == 0) goto L_0x03cc
        L_0x03c4:
            r21 = r10
            r18 = r11
            r20 = 1
            goto L_0x0465
        L_0x03cc:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r0 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r0 = r3.getAnnotation(r0)
            r18 = r0
            com.alibaba.fastjson.annotation.JSONField r18 = (com.alibaba.fastjson.annotation.JSONField) r18
            java.lang.String r0 = r3.getName()
            if (r18 == 0) goto L_0x041f
            boolean r1 = r18.serialize()
            if (r1 != 0) goto L_0x03e3
            goto L_0x03c4
        L_0x03e3:
            int r1 = r18.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r2 = r18.serialzeFeatures()
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.m396of(r2)
            com.alibaba.fastjson.parser.Feature[] r4 = r18.parseFeatures()
            int r4 = com.alibaba.fastjson.parser.Feature.m395of(r4)
            java.lang.String r5 = r18.name()
            int r5 = r5.length()
            if (r5 == 0) goto L_0x0405
            java.lang.String r0 = r18.name()
        L_0x0405:
            java.lang.String r5 = r18.label()
            int r5 = r5.length()
            if (r5 == 0) goto L_0x0419
            java.lang.String r5 = r18.label()
            r6 = r1
            r8 = r2
            r9 = r4
            r19 = r5
            goto L_0x0424
        L_0x0419:
            r6 = r1
            r8 = r2
            r9 = r4
            r19 = r17
            goto L_0x0424
        L_0x041f:
            r19 = r17
            r6 = 0
            r8 = 0
            r9 = 0
        L_0x0424:
            if (r12 == 0) goto L_0x042f
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x042f
            goto L_0x03c4
        L_0x042f:
            if (r13 == 0) goto L_0x0435
            java.lang.String r0 = r13.translate(r0)
        L_0x0435:
            r5 = r0
            boolean r0 = r14.containsKey(r5)
            if (r0 != 0) goto L_0x03c4
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r2 = 0
            r20 = 0
            r21 = 0
            r0 = r4
            r1 = r5
            r32 = r4
            r4 = r34
            r33 = r5
            r5 = r20
            r20 = 1
            r7 = r8
            r8 = r9
            r9 = r21
            r21 = r10
            r10 = r18
            r18 = r11
            r11 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = r32
            r0 = r33
            r14.put(r0, r1)
        L_0x0465:
            int r10 = r21 + 1
            r11 = r18
            r7 = 1
            goto L_0x03b6
        L_0x046c:
            r20 = 1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r1 = com.alibaba.fastjson.annotation.JSONType.class
            r2 = r34
            java.lang.annotation.Annotation r1 = r2.getAnnotation(r1)
            com.alibaba.fastjson.annotation.JSONType r1 = (com.alibaba.fastjson.annotation.JSONType) r1
            if (r1 == 0) goto L_0x049c
            java.lang.String[] r1 = r1.orders()
            if (r1 == 0) goto L_0x049e
            int r2 = r1.length
            int r3 = r14.size()
            if (r2 != r3) goto L_0x049e
            int r2 = r1.length
            r3 = 0
        L_0x048e:
            if (r3 >= r2) goto L_0x04a0
            r4 = r1[r3]
            boolean r4 = r14.containsKey(r4)
            if (r4 != 0) goto L_0x0499
            goto L_0x049e
        L_0x0499:
            int r3 = r3 + 1
            goto L_0x048e
        L_0x049c:
            r1 = r17
        L_0x049e:
            r20 = 0
        L_0x04a0:
            if (r20 == 0) goto L_0x04b4
            int r2 = r1.length
            r3 = 0
        L_0x04a4:
            if (r3 >= r2) goto L_0x04d1
            r4 = r1[r3]
            java.lang.Object r4 = r14.get(r4)
            com.alibaba.fastjson.util.FieldInfo r4 = (com.alibaba.fastjson.util.FieldInfo) r4
            r0.add(r4)
            int r3 = r3 + 1
            goto L_0x04a4
        L_0x04b4:
            java.util.Collection r1 = r14.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x04bc:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x04cc
            java.lang.Object r2 = r1.next()
            com.alibaba.fastjson.util.FieldInfo r2 = (com.alibaba.fastjson.util.FieldInfo) r2
            r0.add(r2)
            goto L_0x04bc
        L_0x04cc:
            if (r38 == 0) goto L_0x04d1
            java.util.Collections.sort(r0)
        L_0x04d1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.computeGetters(java.lang.Class, com.alibaba.fastjson.annotation.JSONType, java.util.Map, java.util.Map, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    private static String getPropertyNameByCompatibleFieldName(Map<String, Field> map, String str, String str2, int i) {
        if (!compatibleWithFieldName || map.containsKey(str2)) {
            return str2;
        }
        String substring = str.substring(i);
        return map.containsKey(substring) ? substring : str2;
    }

    public static JSONField getSuperMethodAnnotation(Class<?> cls, Method method) {
        boolean z;
        JSONField jSONField;
        boolean z2;
        JSONField jSONField2;
        Class[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class[] parameterTypes = method.getParameterTypes();
            for (Class methods : interfaces) {
                for (Method method2 : methods.getMethods()) {
                    Class[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            } else if (!parameterTypes2[i].equals(parameterTypes[i])) {
                                z2 = false;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (z2 && (jSONField2 = (JSONField) method2.getAnnotation(JSONField.class)) != null) {
                            return jSONField2;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes3.length) {
                            z = true;
                            break;
                        } else if (!parameterTypes4[i2].equals(parameterTypes3[i2])) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (jSONField = (JSONField) method3.getAnnotation(JSONField.class)) != null) {
                        return jSONField;
                    }
                }
            }
        }
        return null;
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, String str) {
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType != null) {
            String[] includes = jSONType.includes();
            if (includes.length > 0) {
                for (String equals : includes) {
                    if (str.equals(equals)) {
                        return false;
                    }
                }
                return true;
            }
            String[] ignores = jSONType.ignores();
            for (String equals2 : ignores) {
                if (str.equals(equals2)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || !isJSONTypeIgnore(cls.getSuperclass(), str)) ? false : true;
    }

    public static boolean isGenericParamType(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class) || (genericSuperclass = ((Class) type).getGenericSuperclass()) == Object.class) {
            return false;
        }
        return isGenericParamType(genericSuperclass);
    }

    public static Type getGenericParamType(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static Type unwrapOptional(Type type) {
        if (!optionalClassInited) {
            try {
                optionalClass = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } catch (Throwable th) {
                optionalClassInited = true;
                throw th;
            }
            optionalClassInited = true;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType.getRawType() == optionalClass) {
                return parameterizedType.getActualTypeArguments()[0];
            }
        }
        return type;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        return Object.class;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        for (Field field : fieldArr) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return getField(superclass, str, superclass.getDeclaredFields());
    }

    public static int getSerializeFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return SerializerFeature.m396of(jSONType.serialzeFeatures());
    }

    public static int getParserFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return Feature.m395of(jSONType.parseFeatures());
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    static void setAccessible(AccessibleObject accessibleObject) {
        if (setAccessibleEnable && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
    }

    public static Type getCollectionItemType(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = getCollectionItemType(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        return type2 == null ? Object.class : type2;
    }

    public static Class<?> getCollectionItemClass(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (type2 instanceof Class) {
            Class<?> cls = (Class) type2;
            if (Modifier.isPublic(cls.getModifiers())) {
                return cls;
            }
            throw new JSONException("can not create ASMParser");
        }
        throw new JSONException("can not create ASMParser");
    }

    public static Collection createCollection(Type type) {
        Type type2;
        Class<?> rawClass = getRawClass(type);
        if (rawClass == AbstractCollection.class || rawClass == Collection.class) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (rawClass.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (rawClass.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (rawClass.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(EnumSet.class)) {
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type2 = Object.class;
            }
            return EnumSet.noneOf((Class) type2);
        }
        try {
            return (Collection) rawClass.newInstance();
        } catch (Exception unused) {
            throw new JSONException("create instance error, class " + rawClass.getName());
        }
    }

    public static Class<?> getRawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getRawClass(((ParameterizedType) type).getRawType());
        }
        throw new JSONException("TODO");
    }

    public static boolean isProxy(Class<?> cls) {
        for (Class name : cls.getInterfaces()) {
            String name2 = name.getName();
            if (name2.equals("net.sf.cglib.proxy.Factory") || name2.equals("org.springframework.cglib.proxy.Factory") || name2.equals("javassist.util.proxy.ProxyObject") || name2.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTransient(Method method) {
        if (method == null) {
            return false;
        }
        if (!transientClassInited) {
            try {
                transientClass = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } catch (Throwable th) {
                transientClassInited = true;
                throw th;
            }
            transientClassInited = true;
        }
        if (transientClass == null || method.getAnnotation(transientClass) == null) {
            return false;
        }
        return true;
    }
}
