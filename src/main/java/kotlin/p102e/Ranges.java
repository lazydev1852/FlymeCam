package kotlin.p102e;

import kotlin.Metadata;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, mo27294d2 = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.e.c */
public final class Ranges extends Progressions {

    /* renamed from: b */
    public static final C3400a f18703b = new C3400a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c */
    public static final Ranges f18704c = new Ranges(1, 0);

    public Ranges(int i, int i2) {
        super(i, i2, 1);
    }

    @NotNull
    /* renamed from: f */
    public Integer mo27466f() {
        return Integer.valueOf(mo27455a());
    }

    @NotNull
    /* renamed from: g */
    public Integer mo27467g() {
        return Integer.valueOf(mo27456b());
    }

    /* renamed from: e */
    public boolean mo27459e() {
        return mo27455a() > mo27456b();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Ranges) {
            if (!mo27459e() || !((Ranges) obj).mo27459e()) {
                Ranges cVar = (Ranges) obj;
                if (!(mo27455a() == cVar.mo27455a() && mo27456b() == cVar.mo27456b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo27459e()) {
            return -1;
        }
        return (mo27455a() * 31) + mo27456b();
    }

    @NotNull
    public String toString() {
        return mo27455a() + ".." + mo27456b();
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo27294d2 = {"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.e.c$a */
    /* compiled from: Ranges.kt */
    public static final class C3400a {
        private C3400a() {
        }

        public /* synthetic */ C3400a(DefaultConstructorMarker gVar) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final Ranges mo27468a() {
            return Ranges.f18704c;
        }
    }
}
