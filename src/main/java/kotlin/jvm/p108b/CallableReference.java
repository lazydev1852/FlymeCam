package kotlin.jvm.p108b;

import java.io.ObjectStreamException;
import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;

/* renamed from: kotlin.jvm.b.c */
public abstract class CallableReference implements Serializable, KCallable {
    @SinceKotlin(version = "1.1")

    /* renamed from: b */
    public static final Object f18717b = C3441a.f18720a;
    @SinceKotlin(version = "1.1")

    /* renamed from: a */
    protected final Object f18718a;

    /* renamed from: c */
    private transient KCallable f18719c;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract KCallable mo27492a();

    @SinceKotlin(version = "1.2")
    /* renamed from: kotlin.jvm.b.c$a */
    /* compiled from: CallableReference */
    private static class C3441a implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C3441a f18720a = new C3441a();

        private C3441a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f18720a;
        }
    }

    public CallableReference() {
        this(f18717b);
    }

    @SinceKotlin(version = "1.1")
    protected CallableReference(Object obj) {
        this.f18718a = obj;
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: b */
    public Object mo27493b() {
        return this.f18718a;
    }

    @SinceKotlin(version = "1.1")
    /* renamed from: c */
    public KCallable mo27494c() {
        KCallable aVar = this.f18719c;
        if (aVar != null) {
            return aVar;
        }
        KCallable a = mo27492a();
        this.f18719c = a;
        return a;
    }

    /* access modifiers changed from: protected */
    @SinceKotlin(version = "1.1")
    /* renamed from: d */
    public KCallable mo27495d() {
        KCallable c = mo27494c();
        if (c != this) {
            return c;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    /* renamed from: e */
    public KDeclarationContainer mo27496e() {
        throw new AbstractMethodError();
    }

    /* renamed from: f */
    public String mo27497f() {
        throw new AbstractMethodError();
    }

    /* renamed from: g */
    public String mo27498g() {
        throw new AbstractMethodError();
    }

    /* renamed from: a */
    public Object mo27491a(Object... objArr) {
        return mo27495d().mo27491a(objArr);
    }
}
