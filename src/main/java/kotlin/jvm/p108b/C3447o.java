package kotlin.jvm.p108b;

import kotlin.SinceKotlin;
import kotlin.reflect.C3456f;
import kotlin.reflect.KClass;

/* renamed from: kotlin.jvm.b.o */
/* compiled from: Reflection */
public class C3447o {

    /* renamed from: a */
    private static final ReflectionFactory f18736a;

    /* renamed from: b */
    private static final KClass[] f18737b = new KClass[0];

    static {
        ReflectionFactory pVar = null;
        try {
            pVar = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (pVar == null) {
            pVar = new ReflectionFactory();
        }
        f18736a = pVar;
    }

    /* renamed from: a */
    public static KClass m21170a(Class cls) {
        return f18736a.mo27515a(cls);
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: a */
    public static String m21169a(Lambda jVar) {
        return f18736a.mo27514a(jVar);
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: a */
    public static String m21168a(FunctionBase hVar) {
        return f18736a.mo27513a(hVar);
    }

    /* renamed from: a */
    public static C3456f m21171a(PropertyReference1 lVar) {
        return f18736a.mo27516a(lVar);
    }
}
