package kotlin;

import java.io.Serializable;
import kotlin.jvm.p107a.Functions;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, mo27294d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.o */
/* compiled from: LazyJVM.kt */
public final class C3451o<T> implements Serializable, C3403f<T> {

    /* renamed from: a */
    private Functions<? extends T> f18744a;

    /* renamed from: b */
    private volatile Object f18745b;

    /* renamed from: c */
    private final Object f18746c;

    public C3451o(@NotNull Functions<? extends T> aVar, @Nullable Object obj) {
        C3443i.m21155b(aVar, "initializer");
        this.f18744a = aVar;
        this.f18745b = C3453r.f18747a;
        this.f18746c = obj == null ? this : obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C3451o(Functions aVar, Object obj, int i, DefaultConstructorMarker gVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }

    /* renamed from: a */
    public T mo27448a() {
        T t;
        T t2 = this.f18745b;
        if (t2 != C3453r.f18747a) {
            return t2;
        }
        synchronized (this.f18746c) {
            t = this.f18745b;
            if (t == C3453r.f18747a) {
                Functions aVar = this.f18744a;
                if (aVar == null) {
                    C3443i.m21151a();
                }
                t = aVar.mo18337a();
                this.f18745b = t;
                this.f18744a = null;
            }
        }
        return t;
    }

    /* renamed from: b */
    public boolean mo27531b() {
        return this.f18745b != C3453r.f18747a;
    }

    @NotNull
    public String toString() {
        return mo27531b() ? String.valueOf(mo27448a()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new Lazy(mo27448a());
    }
}
