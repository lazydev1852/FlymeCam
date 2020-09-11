package kotlin.coroutines;

import com.meizu.savior.Constants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.jvm.p108b.Lambda;
import kotlin.jvm.p108b.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo27294d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
@SinceKotlin(version = "1.3")
/* renamed from: kotlin.coroutines.c */
/* compiled from: CoroutineContextImpl.kt */
public final class C3368c implements Serializable, CoroutineContext {

    /* renamed from: a */
    private final CoroutineContext f18651a;

    /* renamed from: b */
    private final CoroutineContext.C3378b f18652b;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo27294d2 = {"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.c$c */
    /* compiled from: CoroutineContextImpl.kt */
    static final class C3372c extends Lambda implements C3425m<Unit, CoroutineContext.C3378b, Unit> {

        /* renamed from: a */
        final /* synthetic */ CoroutineContext[] f18656a;

        /* renamed from: b */
        final /* synthetic */ Ref.C3445b f18657b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C3372c(CoroutineContext[] gVarArr, Ref.C3445b bVar) {
            super(2);
            this.f18656a = gVarArr;
            this.f18657b = bVar;
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ Object mo19191a(Object obj, Object obj2) {
            mo27422a((Unit) obj, (CoroutineContext.C3378b) obj2);
            return Unit.f18749a;
        }

        /* renamed from: a */
        public final void mo27422a(@NotNull Unit tVar, @NotNull CoroutineContext.C3378b bVar) {
            C3443i.m21155b(tVar, "<anonymous parameter 0>");
            C3443i.m21155b(bVar, "element");
            CoroutineContext[] gVarArr = this.f18656a;
            Ref.C3445b bVar2 = this.f18657b;
            int i = bVar2.f18734a;
            bVar2.f18734a = i + 1;
            gVarArr[i] = bVar;
        }
    }

    public C3368c(@NotNull CoroutineContext gVar, @NotNull CoroutineContext.C3378b bVar) {
        C3443i.m21155b(gVar, "left");
        C3443i.m21155b(bVar, "element");
        this.f18651a = gVar;
        this.f18652b = bVar;
    }

    @NotNull
    /* renamed from: a */
    public CoroutineContext mo27413a(@NotNull CoroutineContext gVar) {
        C3443i.m21155b(gVar, "context");
        return CoroutineContext.C3376a.m21016a(this, gVar);
    }

    @Nullable
    /* renamed from: a */
    public <E extends CoroutineContext.C3378b> E mo27412a(@NotNull CoroutineContext.C3380c<E> cVar) {
        C3443i.m21155b(cVar, "key");
        CoroutineContext gVar = this;
        while (true) {
            C3368c cVar2 = (C3368c) gVar;
            E a = cVar2.f18652b.mo27412a(cVar);
            if (a != null) {
                return a;
            }
            gVar = cVar2.f18651a;
            if (!(gVar instanceof C3368c)) {
                return gVar.mo27412a(cVar);
            }
        }
    }

    /* renamed from: a */
    public <R> R mo27411a(R r, @NotNull C3425m<? super R, ? super CoroutineContext.C3378b, ? extends R> mVar) {
        C3443i.m21155b(mVar, "operation");
        return mVar.mo19191a(this.f18651a.mo27411a(r, mVar), this.f18652b);
    }

    @NotNull
    /* renamed from: b */
    public CoroutineContext mo27414b(@NotNull CoroutineContext.C3380c<?> cVar) {
        C3443i.m21155b(cVar, "key");
        if (this.f18652b.mo27412a(cVar) != null) {
            return this.f18651a;
        }
        CoroutineContext b = this.f18651a.mo27414b(cVar);
        if (b == this.f18651a) {
            return this;
        }
        if (b == C3381h.f18661a) {
            return this.f18652b;
        }
        return new C3368c(b, this.f18652b);
    }

    /* renamed from: a */
    private final int m20993a() {
        C3368c cVar = this;
        int i = 2;
        while (true) {
            CoroutineContext gVar = cVar.f18651a;
            if (!(gVar instanceof C3368c)) {
                gVar = null;
            }
            cVar = (C3368c) gVar;
            if (cVar == null) {
                return i;
            }
            i++;
        }
    }

    /* renamed from: a */
    private final boolean m20995a(CoroutineContext.C3378b bVar) {
        return C3443i.m21154a((Object) mo27412a(bVar.mo27415o_()), (Object) bVar);
    }

    /* renamed from: a */
    private final boolean m20994a(C3368c cVar) {
        while (m20995a(cVar.f18652b)) {
            CoroutineContext gVar = cVar.f18651a;
            if (gVar instanceof C3368c) {
                cVar = (C3368c) gVar;
            } else if (gVar != null) {
                return m20995a((CoroutineContext.C3378b) gVar);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof C3368c) {
                C3368c cVar = (C3368c) obj;
                if (cVar.m20993a() != m20993a() || !cVar.m20994a(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f18651a.hashCode() + this.f18652b.hashCode();
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo27294d2 = {"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, mo27295k = 3, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.c$b */
    /* compiled from: CoroutineContextImpl.kt */
    static final class C3371b extends Lambda implements C3425m<String, CoroutineContext.C3378b, String> {

        /* renamed from: a */
        public static final C3371b f18655a = new C3371b();

        C3371b() {
            super(2);
        }

        @NotNull
        /* renamed from: a */
        public final String mo19191a(@NotNull String str, @NotNull CoroutineContext.C3378b bVar) {
            C3443i.m21155b(str, "acc");
            C3443i.m21155b(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    @NotNull
    public String toString() {
        return Constants.ARRAY_TYPE + ((String) mo27411a("", C3371b.f18655a)) + "]";
    }

    private final Object writeReplace() {
        int a = m20993a();
        CoroutineContext[] gVarArr = new CoroutineContext[a];
        Ref.C3445b bVar = new Ref.C3445b();
        boolean z = false;
        bVar.f18734a = 0;
        mo27411a(Unit.f18749a, new C3372c(gVarArr, bVar));
        if (bVar.f18734a == a) {
            z = true;
        }
        if (z) {
            return new C3369a(gVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, mo27294d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.coroutines.c$a */
    /* compiled from: CoroutineContextImpl.kt */
    private static final class C3369a implements Serializable {

        /* renamed from: a */
        public static final C3370a f18653a = new C3370a((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 0;
        @NotNull

        /* renamed from: b */
        private final CoroutineContext[] f18654b;

        @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo27294d2 = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
        /* renamed from: kotlin.coroutines.c$a$a */
        /* compiled from: CoroutineContextImpl.kt */
        public static final class C3370a {
            private C3370a() {
            }

            public /* synthetic */ C3370a(DefaultConstructorMarker gVar) {
                this();
            }
        }

        public C3369a(@NotNull CoroutineContext[] gVarArr) {
            C3443i.m21155b(gVarArr, "elements");
            this.f18654b = gVarArr;
        }

        private final Object readResolve() {
            CoroutineContext[] gVarArr = this.f18654b;
            CoroutineContext gVar = C3381h.f18661a;
            for (CoroutineContext a : gVarArr) {
                gVar = gVar.mo27413a(a);
            }
            return gVar;
        }
    }
}
