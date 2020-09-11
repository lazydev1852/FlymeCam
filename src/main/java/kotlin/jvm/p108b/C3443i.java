package kotlin.jvm.p108b;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* renamed from: kotlin.jvm.b.i */
/* compiled from: Intrinsics */
public class C3443i {
    /* renamed from: a */
    public static int m21148a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private C3443i() {
    }

    /* renamed from: a */
    public static void m21151a() {
        throw ((KotlinNullPointerException) m21149a(new KotlinNullPointerException()));
    }

    /* renamed from: a */
    public static void m21153a(String str) {
        throw ((UninitializedPropertyAccessException) m21149a(new UninitializedPropertyAccessException(str)));
    }

    /* renamed from: b */
    public static void m21156b(String str) {
        m21153a("lateinit property " + str + " has not been initialized");
    }

    /* renamed from: a */
    public static void m21152a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m21149a(new IllegalStateException(str + " must not be null")));
        }
    }

    /* renamed from: b */
    public static void m21155b(Object obj, String str) {
        if (obj == null) {
            m21157c(str);
        }
    }

    /* renamed from: c */
    private static void m21157c(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        throw ((IllegalArgumentException) m21149a(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str)));
    }

    /* renamed from: a */
    public static boolean m21154a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: a */
    private static <T extends Throwable> T m21149a(T t) {
        return m21150a(t, C3443i.class.getName());
    }

    /* renamed from: a */
    static <T extends Throwable> T m21150a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
