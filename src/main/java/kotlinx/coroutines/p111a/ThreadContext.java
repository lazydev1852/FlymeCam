package kotlinx.coroutines.p111a;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.Lambda;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo27294d2 = {"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, mo27295k = 2, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.a.q */
public final class ThreadContext {

    /* renamed from: a */
    private static final Symbol f18816a = new Symbol("ZERO");

    /* renamed from: b */
    private static final C3425m<Object, CoroutineContext.C3378b, Object> f18817b = C3489a.f18821a;

    /* renamed from: c */
    private static final C3425m<ThreadContextElement<?>, CoroutineContext.C3378b, ThreadContextElement<?>> f18818c = C3490b.f18822a;

    /* renamed from: d */
    private static final C3425m<C3494t, CoroutineContext.C3378b, C3494t> f18819d = C3492d.f18824a;

    /* renamed from: e */
    private static final C3425m<C3494t, CoroutineContext.C3378b, C3494t> f18820e = C3491c.f18823a;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<no name provided>", "", "countOrElement", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.q$a */
    /* compiled from: ThreadContext.kt */
    static final class C3489a extends Lambda implements C3425m<Object, CoroutineContext.C3378b, Object> {

        /* renamed from: a */
        public static final C3489a f18821a = new C3489a();

        C3489a() {
            super(2);
        }

        @Nullable
        /* renamed from: a */
        public final Object mo19191a(@Nullable Object obj, @NotNull CoroutineContext.C3378b bVar) {
            if (!(bVar instanceof ThreadContextElement)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<no name provided>", "Lkotlinx/coroutines/ThreadContextElement;", "found", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.q$b */
    /* compiled from: ThreadContext.kt */
    static final class C3490b extends Lambda implements C3425m<ThreadContextElement<?>, CoroutineContext.C3378b, ThreadContextElement<?>> {

        /* renamed from: a */
        public static final C3490b f18822a = new C3490b();

        C3490b() {
            super(2);
        }

        @Nullable
        /* renamed from: a */
        public final ThreadContextElement<?> mo19191a(@Nullable ThreadContextElement<?> bkVar, @NotNull CoroutineContext.C3378b bVar) {
            if (bkVar != null) {
                return bkVar;
            }
            if (!(bVar instanceof ThreadContextElement)) {
                bVar = null;
            }
            return (ThreadContextElement) bVar;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.q$d */
    /* compiled from: ThreadContext.kt */
    static final class C3492d extends Lambda implements C3425m<C3494t, CoroutineContext.C3378b, C3494t> {

        /* renamed from: a */
        public static final C3492d f18824a = new C3492d();

        C3492d() {
            super(2);
        }

        @NotNull
        /* renamed from: a */
        public final C3494t mo19191a(@NotNull C3494t tVar, @NotNull CoroutineContext.C3378b bVar) {
            if (bVar instanceof ThreadContextElement) {
                tVar.mo27627a(((ThreadContextElement) bVar).mo27714c(tVar.mo27629c()));
            }
            return tVar;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlinx.coroutines.a.q$c */
    /* compiled from: ThreadContext.kt */
    static final class C3491c extends Lambda implements C3425m<C3494t, CoroutineContext.C3378b, C3494t> {

        /* renamed from: a */
        public static final C3491c f18823a = new C3491c();

        C3491c() {
            super(2);
        }

        @NotNull
        /* renamed from: a */
        public final C3494t mo19191a(@NotNull C3494t tVar, @NotNull CoroutineContext.C3378b bVar) {
            if (bVar instanceof ThreadContextElement) {
                ((ThreadContextElement) bVar).mo27713a(tVar.mo27629c(), tVar.mo27626a());
            }
            return tVar;
        }
    }

    @NotNull
    /* renamed from: a */
    public static final Object m21374a(@NotNull CoroutineContext gVar) {
        Object a = gVar.mo27411a(0, f18817b);
        if (a == null) {
            C3443i.m21151a();
        }
        return a;
    }

    @Nullable
    /* renamed from: a */
    public static final Object m21375a(@NotNull CoroutineContext gVar, @Nullable Object obj) {
        if (obj == null) {
            obj = m21374a(gVar);
        }
        if (obj == 0) {
            return f18816a;
        }
        if (obj instanceof Integer) {
            return gVar.mo27411a(new C3494t(gVar, ((Number) obj).intValue()), f18819d);
        }
        if (obj != null) {
            return ((ThreadContextElement) obj).mo27714c(gVar);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }

    /* renamed from: b */
    public static final void m21376b(@NotNull CoroutineContext gVar, @Nullable Object obj) {
        if (obj != f18816a) {
            if (obj instanceof C3494t) {
                ((C3494t) obj).mo27628b();
                gVar.mo27411a(obj, f18820e);
                return;
            }
            Object a = gVar.mo27411a(null, f18818c);
            if (a != null) {
                ((ThreadContextElement) a).mo27713a(gVar, obj);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }
}
