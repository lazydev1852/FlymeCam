package kotlin.coroutines.intrinsics;

import kotlin.C3450n;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.C3381h;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.C3388c;
import kotlin.coroutines.jvm.internal.C3392h;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.p107a.C3414b;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\b¢\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, mo27294d2 = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, mo27295k = 5, mo27296mv = {1, 1, 16}, mo27298xi = 1, mo27299xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* renamed from: kotlin.coroutines.intrinsics.b */
public class IntrinsicsJvm {
    @NotNull
    @SinceKotlin(version = "1.3")
    /* renamed from: a */
    public static final <T> Continuation<Unit> m21030a(@NotNull C3414b<? super Continuation<? super T>, ? extends Object> bVar, @NotNull Continuation<? super T> dVar) {
        C3443i.m21155b(bVar, "$this$createCoroutineUnintercepted");
        C3443i.m21155b(dVar, "completion");
        Continuation<? super T> a = DebugProbes.m21064a(dVar);
        if (bVar instanceof ContinuationImpl) {
            return ((ContinuationImpl) bVar).mo27438a((Continuation<?>) a);
        }
        CoroutineContext a2 = a.mo27423a();
        if (a2 == C3381h.f18661a) {
            if (a != null) {
                return new C3383a(a, a, bVar);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        } else if (a != null) {
            return new C3384b(a, a2, a, a2, bVar);
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    /* renamed from: a */
    public static final <R, T> Continuation<Unit> m21031a(@NotNull C3425m<? super R, ? super Continuation<? super T>, ? extends Object> mVar, R r, @NotNull Continuation<? super T> dVar) {
        C3443i.m21155b(mVar, "$this$createCoroutineUnintercepted");
        C3443i.m21155b(dVar, "completion");
        Continuation<? super T> a = DebugProbes.m21064a(dVar);
        if (mVar instanceof ContinuationImpl) {
            return ((ContinuationImpl) mVar).mo19192a(r, a);
        }
        CoroutineContext a2 = a.mo27423a();
        if (a2 == C3381h.f18661a) {
            if (a != null) {
                return new C3385c(a, a, mVar, r);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        } else if (a != null) {
            return new C3386d(a, a2, a, a2, mVar, r);
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    /* renamed from: a */
    public static final <T> Continuation<T> m21029a(@NotNull Continuation<? super T> dVar) {
        Continuation<Object> f;
        C3443i.m21155b(dVar, "$this$intercepted");
        C3388c cVar = (C3388c) (!(dVar instanceof C3388c) ? null : dVar);
        return (cVar == null || (f = cVar.mo27445f()) == null) ? dVar : f;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, mo27294d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.intrinsics.b$a */
    /* compiled from: IntrinsicsJvm.kt */
    public static final class C3383a extends C3392h {

        /* renamed from: a */
        final /* synthetic */ Continuation f18662a;

        /* renamed from: b */
        final /* synthetic */ C3414b f18663b;

        /* renamed from: c */
        private int f18664c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3383a(Continuation dVar, Continuation dVar2, C3414b bVar) {
            super(dVar2);
            this.f18662a = dVar;
            this.f18663b = bVar;
        }

        /* access modifiers changed from: protected */
        @Nullable
        /* renamed from: a */
        public Object mo19190a(@NotNull Object obj) {
            switch (this.f18664c) {
                case 0:
                    this.f18664c = 1;
                    C3450n.m21199a(obj);
                    Continuation dVar = this;
                    C3414b bVar = this.f18663b;
                    if (bVar != null) {
                        return ((C3414b) TypeIntrinsics.m21182b(bVar, 1)).mo27487a(dVar);
                    }
                    throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                case 1:
                    this.f18664c = 2;
                    C3450n.m21199a(obj);
                    return obj;
                default:
                    throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, mo27294d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.intrinsics.b$c */
    /* compiled from: IntrinsicsJvm.kt */
    public static final class C3385c extends C3392h {

        /* renamed from: a */
        final /* synthetic */ Continuation f18669a;

        /* renamed from: b */
        final /* synthetic */ C3425m f18670b;

        /* renamed from: c */
        final /* synthetic */ Object f18671c;

        /* renamed from: d */
        private int f18672d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3385c(Continuation dVar, Continuation dVar2, C3425m mVar, Object obj) {
            super(dVar2);
            this.f18669a = dVar;
            this.f18670b = mVar;
            this.f18671c = obj;
        }

        /* access modifiers changed from: protected */
        @Nullable
        /* renamed from: a */
        public Object mo19190a(@NotNull Object obj) {
            switch (this.f18672d) {
                case 0:
                    this.f18672d = 1;
                    C3450n.m21199a(obj);
                    Continuation dVar = this;
                    C3425m mVar = this.f18670b;
                    if (mVar != null) {
                        return ((C3425m) TypeIntrinsics.m21182b(mVar, 2)).mo19191a(this.f18671c, dVar);
                    }
                    throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                case 1:
                    this.f18672d = 2;
                    C3450n.m21199a(obj);
                    return obj;
                default:
                    throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, mo27294d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.intrinsics.b$b */
    /* compiled from: IntrinsicsJvm.kt */
    public static final class C3384b extends C3388c {

        /* renamed from: a */
        final /* synthetic */ Continuation f18665a;

        /* renamed from: b */
        final /* synthetic */ CoroutineContext f18666b;

        /* renamed from: c */
        final /* synthetic */ C3414b f18667c;

        /* renamed from: d */
        private int f18668d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3384b(Continuation dVar, CoroutineContext gVar, Continuation dVar2, CoroutineContext gVar2, C3414b bVar) {
            super(dVar2, gVar2);
            this.f18665a = dVar;
            this.f18666b = gVar;
            this.f18667c = bVar;
        }

        /* access modifiers changed from: protected */
        @Nullable
        /* renamed from: a */
        public Object mo19190a(@NotNull Object obj) {
            switch (this.f18668d) {
                case 0:
                    this.f18668d = 1;
                    C3450n.m21199a(obj);
                    Continuation dVar = this;
                    C3414b bVar = this.f18667c;
                    if (bVar != null) {
                        return ((C3414b) TypeIntrinsics.m21182b(bVar, 1)).mo27487a(dVar);
                    }
                    throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                case 1:
                    this.f18668d = 2;
                    C3450n.m21199a(obj);
                    return obj;
                default:
                    throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, mo27294d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.intrinsics.b$d */
    /* compiled from: IntrinsicsJvm.kt */
    public static final class C3386d extends C3388c {

        /* renamed from: a */
        final /* synthetic */ Continuation f18673a;

        /* renamed from: b */
        final /* synthetic */ CoroutineContext f18674b;

        /* renamed from: c */
        final /* synthetic */ C3425m f18675c;

        /* renamed from: d */
        final /* synthetic */ Object f18676d;

        /* renamed from: e */
        private int f18677e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3386d(Continuation dVar, CoroutineContext gVar, Continuation dVar2, CoroutineContext gVar2, C3425m mVar, Object obj) {
            super(dVar2, gVar2);
            this.f18673a = dVar;
            this.f18674b = gVar;
            this.f18675c = mVar;
            this.f18676d = obj;
        }

        /* access modifiers changed from: protected */
        @Nullable
        /* renamed from: a */
        public Object mo19190a(@NotNull Object obj) {
            switch (this.f18677e) {
                case 0:
                    this.f18677e = 1;
                    C3450n.m21199a(obj);
                    Continuation dVar = this;
                    C3425m mVar = this.f18675c;
                    if (mVar != null) {
                        return ((C3425m) TypeIntrinsics.m21182b(mVar, 2)).mo19191a(this.f18676d, dVar);
                    }
                    throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                case 1:
                    this.f18677e = 2;
                    C3450n.m21199a(obj);
                    return obj;
                default:
                    throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }
}
