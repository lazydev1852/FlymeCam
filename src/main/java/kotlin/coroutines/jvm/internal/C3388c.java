package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo27294d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@SinceKotlin(version = "1.3")
/* renamed from: kotlin.coroutines.jvm.internal.c */
/* compiled from: ContinuationImpl.kt */
public abstract class C3388c extends ContinuationImpl {

    /* renamed from: a */
    private transient Continuation<Object> f18680a;

    /* renamed from: b */
    private final CoroutineContext f18681b;

    public C3388c(@Nullable Continuation<Object> dVar, @Nullable CoroutineContext gVar) {
        super(dVar);
        this.f18681b = gVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C3388c(@Nullable Continuation<Object> dVar) {
        this(dVar, dVar != null ? dVar.mo27423a() : null);
    }

    @NotNull
    /* renamed from: a */
    public CoroutineContext mo27423a() {
        CoroutineContext gVar = this.f18681b;
        if (gVar == null) {
            C3443i.m21151a();
        }
        return gVar;
    }

    @NotNull
    /* renamed from: f */
    public final Continuation<Object> mo27445f() {
        Continuation<Object> dVar = this.f18680a;
        if (dVar == null) {
            ContinuationInterceptor eVar = (ContinuationInterceptor) mo27423a().mo27412a(ContinuationInterceptor.f18658a);
            if (eVar == null || (dVar = eVar.mo27425a(this)) == null) {
                dVar = this;
            }
            this.f18680a = dVar;
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27439b() {
        Continuation<Object> dVar = this.f18680a;
        if (!(dVar == null || dVar == this)) {
            CoroutineContext.C3378b a = mo27423a().mo27412a(ContinuationInterceptor.f18658a);
            if (a == null) {
                C3443i.m21151a();
            }
            ((ContinuationInterceptor) a).mo27426b(dVar);
        }
        this.f18680a = C3387b.f18679a;
    }
}
