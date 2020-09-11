package kotlin.jvm.p108b;

import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.jvm.p107a.C3414b;
import kotlin.jvm.p107a.C3415c;
import kotlin.jvm.p107a.C3416d;
import kotlin.jvm.p107a.C3417e;
import kotlin.jvm.p107a.C3418f;
import kotlin.jvm.p107a.C3419g;
import kotlin.jvm.p107a.C3420h;
import kotlin.jvm.p107a.C3421i;
import kotlin.jvm.p107a.C3422j;
import kotlin.jvm.p107a.C3423k;
import kotlin.jvm.p107a.C3424l;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p107a.C3426n;
import kotlin.jvm.p107a.C3427o;
import kotlin.jvm.p107a.C3428p;
import kotlin.jvm.p107a.C3429q;
import kotlin.jvm.p107a.C3430r;
import kotlin.jvm.p107a.C3431s;
import kotlin.jvm.p107a.C3432t;
import kotlin.jvm.p107a.C3433u;
import kotlin.jvm.p107a.C3434v;
import kotlin.jvm.p107a.C3435w;
import kotlin.jvm.p107a.Functions;
import kotlin.jvm.p108b.p109a.C3438d;
import kotlin.jvm.p108b.p109a.C3439e;
import kotlin.jvm.p108b.p109a.KMarkers;

/* renamed from: kotlin.jvm.b.r */
public class TypeIntrinsics {
    /* renamed from: a */
    private static <T extends Throwable> T m21177a(T t) {
        return C3443i.m21150a(t, TypeIntrinsics.class.getName());
    }

    /* renamed from: a */
    public static void m21179a(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        m21180a(name + " cannot be cast to " + str);
    }

    /* renamed from: a */
    public static void m21180a(String str) {
        throw m21176a(new ClassCastException(str));
    }

    /* renamed from: a */
    public static ClassCastException m21176a(ClassCastException classCastException) {
        throw ((ClassCastException) m21177a(classCastException));
    }

    /* renamed from: a */
    public static List m21178a(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof C3438d)) {
            m21179a(obj, "kotlin.collections.MutableList");
        }
        return m21183b(obj);
    }

    /* renamed from: b */
    public static List m21183b(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw m21176a(e);
        }
    }

    /* renamed from: c */
    public static Map m21184c(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof C3439e)) {
            m21179a(obj, "kotlin.collections.MutableMap");
        }
        return m21185d(obj);
    }

    /* renamed from: d */
    public static Map m21185d(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw m21176a(e);
        }
    }

    /* renamed from: e */
    public static int m21186e(Object obj) {
        if (obj instanceof FunctionBase) {
            return ((FunctionBase) obj).mo27447g();
        }
        if (obj instanceof Functions) {
            return 0;
        }
        if (obj instanceof C3414b) {
            return 1;
        }
        if (obj instanceof C3425m) {
            return 2;
        }
        if (obj instanceof C3429q) {
            return 3;
        }
        if (obj instanceof C3430r) {
            return 4;
        }
        if (obj instanceof C3431s) {
            return 5;
        }
        if (obj instanceof C3432t) {
            return 6;
        }
        if (obj instanceof C3433u) {
            return 7;
        }
        if (obj instanceof C3434v) {
            return 8;
        }
        if (obj instanceof C3435w) {
            return 9;
        }
        if (obj instanceof C3415c) {
            return 10;
        }
        if (obj instanceof C3416d) {
            return 11;
        }
        if (obj instanceof C3417e) {
            return 12;
        }
        if (obj instanceof C3418f) {
            return 13;
        }
        if (obj instanceof C3419g) {
            return 14;
        }
        if (obj instanceof C3420h) {
            return 15;
        }
        if (obj instanceof C3421i) {
            return 16;
        }
        if (obj instanceof C3422j) {
            return 17;
        }
        if (obj instanceof C3423k) {
            return 18;
        }
        if (obj instanceof C3424l) {
            return 19;
        }
        if (obj instanceof C3426n) {
            return 20;
        }
        if (obj instanceof C3427o) {
            return 21;
        }
        return obj instanceof C3428p ? 22 : -1;
    }

    /* renamed from: a */
    public static boolean m21181a(Object obj, int i) {
        return (obj instanceof Function) && m21186e(obj) == i;
    }

    /* renamed from: b */
    public static Object m21182b(Object obj, int i) {
        if (obj != null && !m21181a(obj, i)) {
            m21179a(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }
}
