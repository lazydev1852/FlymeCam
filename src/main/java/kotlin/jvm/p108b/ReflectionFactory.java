package kotlin.jvm.p108b;

import kotlin.SinceKotlin;
import kotlin.reflect.C3456f;
import kotlin.reflect.KClass;

/* renamed from: kotlin.jvm.b.p */
public class ReflectionFactory {
    /* renamed from: a */
    public C3456f mo27516a(PropertyReference1 lVar) {
        return lVar;
    }

    /* renamed from: a */
    public KClass mo27515a(Class cls) {
        return new ClassReference(cls);
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: a */
    public String mo27514a(Lambda jVar) {
        return mo27513a((FunctionBase) jVar);
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: a */
    public String mo27513a(FunctionBase hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring("kotlin.jvm.functions.".length()) : obj;
    }
}
