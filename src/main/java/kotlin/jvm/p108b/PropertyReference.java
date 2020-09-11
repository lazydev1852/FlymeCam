package kotlin.jvm.p108b;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* renamed from: kotlin.jvm.b.k */
public abstract class PropertyReference extends CallableReference implements KProperty {
    /* access modifiers changed from: protected */
    @SinceKotlin(version = "1.1")
    /* renamed from: h */
    public KProperty mo27495d() {
        return (KProperty) super.mo27495d();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference kVar = (PropertyReference) obj;
            if (!mo27496e().equals(kVar.mo27496e()) || !mo27497f().equals(kVar.mo27497f()) || !mo27498g().equals(kVar.mo27498g()) || !C3443i.m21154a(mo27493b(), kVar.mo27493b())) {
                return false;
            }
            return true;
        } else if (obj instanceof KProperty) {
            return obj.equals(mo27494c());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((mo27496e().hashCode() * 31) + mo27497f().hashCode()) * 31) + mo27498g().hashCode();
    }

    public String toString() {
        KCallable c = mo27494c();
        if (c != this) {
            return c.toString();
        }
        return "property " + mo27497f() + " (Kotlin reflection is not available)";
    }
}
