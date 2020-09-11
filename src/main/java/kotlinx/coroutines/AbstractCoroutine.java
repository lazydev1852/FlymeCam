package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.p107a.C3425m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0015\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u0019H\u0010¢\u0006\u0002\b!J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\tH\u0014J\u0015\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010'J\u0012\u0010(\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0004J\b\u0010)\u001a\u00020\u0015H\u0014J\r\u0010*\u001a\u00020\u0015H\u0000¢\u0006\u0002\b+J\u001c\u0010,\u001a\u00020\u00152\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000.ø\u0001\u0000¢\u0006\u0002\u0010'JM\u0010/\u001a\u00020\u0015\"\u0004\b\u0001\u001002\u0006\u0010/\u001a\u0002012\u0006\u00102\u001a\u0002H02'\u00103\u001a#\b\u0001\u0012\u0004\u0012\u0002H0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001704¢\u0006\u0002\b5ø\u0001\u0000¢\u0006\u0002\u00106J4\u0010/\u001a\u00020\u00152\u0006\u0010/\u001a\u0002012\u001c\u00103\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001707ø\u0001\u0000¢\u0006\u0002\u00108R\u0017\u0010\u000b\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0006\u001a\u00020\u00078\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00069"}, mo27294d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@InternalCoroutinesApi
/* renamed from: kotlinx.coroutines.a */
public abstract class AbstractCoroutine<T> extends C3519bc implements Continuation<T>, C3512ay, C3568z {
    @NotNull
    @JvmField

    /* renamed from: a */
    protected final CoroutineContext f18770a;
    @NotNull

    /* renamed from: c */
    private final CoroutineContext f18771c = this.f18770a.mo27413a((CoroutineContext) this);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27553a(T t) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27555a(@NotNull Throwable th, boolean z) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo27562e() {
    }

    public AbstractCoroutine(@NotNull CoroutineContext gVar, boolean z) {
        super(z);
        this.f18770a = gVar;
    }

    @NotNull
    /* renamed from: a */
    public final CoroutineContext mo27423a() {
        return this.f18771c;
    }

    @NotNull
    /* renamed from: b */
    public CoroutineContext mo27557b() {
        return this.f18771c;
    }

    /* renamed from: c */
    public boolean mo27559c() {
        return super.mo27559c();
    }

    /* renamed from: d */
    public final void mo27560d() {
        mo27681a((C3512ay) this.f18770a.mo27412a(C3512ay.f18878b));
    }

    /* renamed from: f */
    public final void mo27563f() {
        mo27562e();
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: g */
    public String mo27564g() {
        return DebugStrings.m21412b(this) + " was cancelled";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo27558c(@Nullable Object obj) {
        if (obj instanceof C3542l) {
            C3542l lVar = (C3542l) obj;
            mo27555a(lVar.f18930a, lVar.mo27738b());
            return;
        }
        mo27553a(obj);
    }

    /* renamed from: b */
    public final void mo27424b(@NotNull Object obj) {
        Object f = mo27689f(C3543m.m21672a(obj));
        if (f != C3523bd.f18897a) {
            mo27561d(f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo27561d(@Nullable Object obj) {
        mo27690g(obj);
    }

    /* renamed from: a */
    public final void mo27554a(@NotNull Throwable th) {
        C3564w.m21759a(this.f18771c, th);
    }

    @NotNull
    /* renamed from: h */
    public String mo27565h() {
        String a = C3548s.m21676a(this.f18771c);
        if (a == null) {
            return super.mo27565h();
        }
        return '\"' + a + "\":" + super.mo27565h();
    }

    /* renamed from: a */
    public final <R> void mo27556a(@NotNull CoroutineStart coroutineStart, R r, @NotNull C3425m<? super R, ? super Continuation<? super T>, ? extends Object> mVar) {
        mo27560d();
        coroutineStart.invoke(mVar, r, this);
    }
}
