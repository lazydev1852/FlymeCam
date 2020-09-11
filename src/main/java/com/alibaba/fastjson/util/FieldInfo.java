package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class FieldInfo implements Comparable<FieldInfo> {
    private final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final boolean jsonDirect;
    public final String label;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final char[] name_chars;
    private int ordinal = 0;
    public final int parserFeatures;
    public final int serialzeFeatures;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field2, int i, int i2, int i3) {
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field2;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.parserFeatures = 0;
        this.isEnum = cls2.isEnum();
        if (field2 != null) {
            int modifiers = field2.getModifiers();
            this.fieldAccess = (modifiers & 1) != 0 || this.method == null;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldTransient = false;
            this.fieldAccess = false;
        }
        this.name_chars = genFieldNameChars();
        if (field2 != null) {
            TypeUtils.setAccessible(field2);
        }
        this.label = "";
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        this.getOnly = false;
        this.jsonDirect = false;
        this.format = null;
        this.alternateNames = new String[0];
    }

    public FieldInfo(String str, Method method2, Field field2, Class<?> cls, Type type, int i, int i2, int i3, JSONField jSONField, JSONField jSONField2, String str2) {
        boolean z;
        Type type2;
        Class<?> cls2;
        boolean z2;
        Type type3;
        Type inheritGenericType;
        if (field2 != null) {
            String name2 = field2.getName();
            if (name2.equals(str)) {
                str = name2;
            }
        }
        this.name = str;
        this.method = method2;
        this.field = field2;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.parserFeatures = i3;
        this.fieldAnnotation = jSONField;
        this.methodAnnotation = jSONField2;
        boolean z3 = true;
        if (field2 != null) {
            int modifiers = field2.getModifiers();
            this.fieldAccess = (modifiers & 1) != 0 || method2 == null;
            this.fieldTransient = Modifier.isTransient(modifiers) || TypeUtils.isTransient(method2);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        if (str2 == null || str2.length() <= 0) {
            this.label = "";
        } else {
            this.label = str2;
        }
        JSONField annotation = getAnnotation();
        String str3 = null;
        if (annotation != null) {
            String format2 = annotation.format();
            str3 = format2.trim().length() != 0 ? format2 : str3;
            z = annotation.jsonDirect();
            this.alternateNames = annotation.alternateNames();
        } else {
            this.alternateNames = new String[0];
            z = false;
        }
        this.format = str3;
        this.name_chars = genFieldNameChars();
        if (method2 != null) {
            TypeUtils.setAccessible(method2);
        }
        if (field2 != null) {
            TypeUtils.setAccessible(field2);
        }
        if (method2 != null) {
            Class<?>[] parameterTypes = method2.getParameterTypes();
            if (parameterTypes.length == 1) {
                Class<?> cls3 = parameterTypes[0];
                type2 = method2.getGenericParameterTypes()[0];
                cls2 = cls3;
                z2 = false;
            } else {
                Class<?> returnType = method2.getReturnType();
                type2 = method2.getGenericReturnType();
                cls2 = returnType;
                z2 = true;
            }
            this.declaringClass = method2.getDeclaringClass();
        } else {
            cls2 = field2.getType();
            type2 = field2.getGenericType();
            this.declaringClass = field2.getDeclaringClass();
            z2 = Modifier.isFinal(field2.getModifiers());
        }
        this.getOnly = z2;
        this.jsonDirect = (!z || cls2 != String.class) ? false : z3;
        if (cls == null || cls2 != Object.class || !(type2 instanceof TypeVariable) || (inheritGenericType = getInheritGenericType(cls, (TypeVariable) type2)) == null) {
            if (!(type2 instanceof Class)) {
                type3 = getFieldType(cls, type == null ? cls : type, type2);
                if (type3 != type2) {
                    if (type3 instanceof ParameterizedType) {
                        cls2 = TypeUtils.getClass(type3);
                    } else if (type3 instanceof Class) {
                        cls2 = TypeUtils.getClass(type3);
                    }
                }
            } else {
                type3 = type2;
            }
            this.fieldType = type3;
            this.fieldClass = cls2;
            this.isEnum = cls2.isEnum();
            return;
        }
        this.fieldClass = TypeUtils.getClass(inheritGenericType);
        this.fieldType = inheritGenericType;
        this.isEnum = cls2.isEnum();
    }

    /* access modifiers changed from: protected */
    public char[] genFieldNameChars() {
        int length = this.name.length();
        char[] cArr = new char[(length + 3)];
        this.name.getChars(0, this.name.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    public <T extends Annotation> T getAnnation(Class<T> cls) {
        if (cls == JSONField.class) {
            return getAnnotation();
        }
        T t = null;
        if (this.method != null) {
            t = this.method.getAnnotation(cls);
        }
        return (t != null || this.field == null) ? t : this.field.getAnnotation(cls);
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        ParameterizedType parameterizedType;
        TypeVariable[] typeVariableArr;
        if (cls == null || type == null) {
            return type2;
        }
        if (type2 instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
            Type fieldType2 = getFieldType(cls, type, genericComponentType);
            return genericComponentType != fieldType2 ? Array.newInstance(TypeUtils.getClass(fieldType2), 0).getClass() : type2;
        } else if (!TypeUtils.isGenericParamType(type)) {
            return type2;
        } else {
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.getGenericParamType(type);
                TypeVariable typeVariable = (TypeVariable) type2;
                TypeVariable[] typeParameters = TypeUtils.getClass(parameterizedType2).getTypeParameters();
                for (int i = 0; i < typeParameters.length; i++) {
                    if (typeParameters[i].getName().equals(typeVariable.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i];
                    }
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                if (type instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) type;
                    typeVariableArr = cls.getTypeParameters();
                } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                    typeVariableArr = cls.getSuperclass().getTypeParameters();
                } else {
                    typeVariableArr = null;
                    parameterizedType = null;
                }
                Type[] typeArr = null;
                boolean z = false;
                for (int i2 = 0; i2 < actualTypeArguments.length && parameterizedType != null; i2++) {
                    Type type3 = actualTypeArguments[i2];
                    if (type3 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type3;
                        Type[] typeArr2 = typeArr;
                        boolean z2 = z;
                        for (int i3 = 0; i3 < typeVariableArr.length; i3++) {
                            if (typeVariableArr[i3].getName().equals(typeVariable2.getName())) {
                                if (typeArr2 == null) {
                                    typeArr2 = parameterizedType.getActualTypeArguments();
                                }
                                actualTypeArguments[i2] = typeArr2[i3];
                                z2 = true;
                            }
                        }
                        z = z2;
                        typeArr = typeArr2;
                    }
                }
                if (z) {
                    return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                }
            }
            return type2;
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.reflect.TypeVariable, java.lang.reflect.TypeVariable<?>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type getInheritGenericType(java.lang.Class<?> r6, java.lang.reflect.TypeVariable<?> r7) {
        /*
            java.lang.reflect.GenericDeclaration r0 = r7.getGenericDeclaration()
            r6.getGenericSuperclass()
        L_0x0007:
            java.lang.reflect.Type r6 = r6.getGenericSuperclass()
            r1 = 0
            if (r6 != 0) goto L_0x000f
            return r1
        L_0x000f:
            boolean r2 = r6 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x0054
            r2 = r6
            java.lang.reflect.ParameterizedType r2 = (java.lang.reflect.ParameterizedType) r2
            java.lang.reflect.Type r3 = r2.getRawType()
            boolean r4 = r0.equals(r3)
            r5 = 0
            if (r4 != 0) goto L_0x0037
            boolean r4 = r0 instanceof java.lang.Class
            if (r4 == 0) goto L_0x0035
            boolean r4 = r3 instanceof java.lang.Class
            if (r4 == 0) goto L_0x0035
            r4 = r0
            java.lang.Class r4 = (java.lang.Class) r4
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r3 = r4.isAssignableFrom(r3)
            if (r3 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r3 = 0
            goto L_0x0038
        L_0x0037:
            r3 = 1
        L_0x0038:
            if (r3 == 0) goto L_0x0054
            java.lang.reflect.TypeVariable[] r6 = r0.getTypeParameters()
            java.lang.reflect.Type[] r0 = r2.getActualTypeArguments()
        L_0x0042:
            int r2 = r6.length
            if (r5 >= r2) goto L_0x0053
            r2 = r6[r5]
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0050
            r6 = r0[r5]
            return r6
        L_0x0050:
            int r5 = r5 + 1
            goto L_0x0042
        L_0x0053:
            return r1
        L_0x0054:
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r6)
            if (r6 != 0) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r2
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.FieldInfo.getInheritGenericType(java.lang.Class, java.lang.reflect.TypeVariable):java.lang.reflect.Type");
    }

    public String toString() {
        return this.name;
    }

    public Member getMember() {
        if (this.method != null) {
            return this.method;
        }
        return this.field;
    }

    /* access modifiers changed from: protected */
    public Class<?> getDeclaredClass() {
        if (this.method != null) {
            return this.method.getDeclaringClass();
        }
        if (this.field != null) {
            return this.field.getDeclaringClass();
        }
        return null;
    }

    public int compareTo(FieldInfo fieldInfo) {
        if (this.ordinal < fieldInfo.ordinal) {
            return -1;
        }
        if (this.ordinal > fieldInfo.ordinal) {
            return 1;
        }
        int compareTo = this.name.compareTo(fieldInfo.name);
        if (compareTo != 0) {
            return compareTo;
        }
        Class<?> declaredClass = getDeclaredClass();
        Class<?> declaredClass2 = fieldInfo.getDeclaredClass();
        if (!(declaredClass == null || declaredClass2 == null || declaredClass == declaredClass2)) {
            if (declaredClass.isAssignableFrom(declaredClass2)) {
                return -1;
            }
            if (declaredClass2.isAssignableFrom(declaredClass)) {
                return 1;
            }
        }
        boolean z = false;
        boolean z2 = this.field != null && this.field.getType() == this.fieldClass;
        if (fieldInfo.field != null && fieldInfo.field.getType() == fieldInfo.fieldClass) {
            z = true;
        }
        if (z2 && !z) {
            return 1;
        }
        if (z && !z2) {
            return -1;
        }
        if (fieldInfo.fieldClass.isPrimitive() && !this.fieldClass.isPrimitive()) {
            return 1;
        }
        if (this.fieldClass.isPrimitive() && !fieldInfo.fieldClass.isPrimitive()) {
            return -1;
        }
        if (fieldInfo.fieldClass.getName().startsWith("java.") && !this.fieldClass.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.fieldClass.getName().startsWith("java.") || fieldInfo.fieldClass.getName().startsWith("java.")) {
            return this.fieldClass.getName().compareTo(fieldInfo.fieldClass.getName());
        }
        return -1;
    }

    public JSONField getAnnotation() {
        if (this.fieldAnnotation != null) {
            return this.fieldAnnotation;
        }
        return this.methodAnnotation;
    }

    public String getFormat() {
        return this.format;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        if (this.method != null) {
            return this.method.invoke(obj, new Object[0]);
        }
        return this.field.get(obj);
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        if (this.method != null) {
            this.method.invoke(obj, new Object[]{obj2});
            return;
        }
        this.field.set(obj, obj2);
    }

    public void setAccessible() throws SecurityException {
        if (this.method != null) {
            TypeUtils.setAccessible(this.method);
        } else {
            TypeUtils.setAccessible(this.field);
        }
    }

    public boolean alternateName(String str) {
        for (String equals : this.alternateNames) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
