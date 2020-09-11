package kotlin.p102e;

import kotlin.Metadata;
import kotlin.collections.C3365w;
import kotlin.internal.progressionUtil;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import kotlin.jvm.p108b.p109a.KMarkers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo27294d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.e.a */
public class Progressions implements Iterable<Integer>, KMarkers {

    /* renamed from: a */
    public static final C3399a f18695a = new C3399a((DefaultConstructorMarker) null);

    /* renamed from: b */
    private final int f18696b;

    /* renamed from: c */
    private final int f18697c;

    /* renamed from: d */
    private final int f18698d;

    public Progressions(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.f18696b = i;
            this.f18697c = progressionUtil.m21125a(i, i2, i3);
            this.f18698d = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final int mo27455a() {
        return this.f18696b;
    }

    /* renamed from: b */
    public final int mo27456b() {
        return this.f18697c;
    }

    /* renamed from: c */
    public final int mo27457c() {
        return this.f18698d;
    }

    @NotNull
    /* renamed from: d */
    public C3365w iterator() {
        return new ProgressionIterators(this.f18696b, this.f18697c, this.f18698d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000c A[RETURN, SYNTHETIC] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo27459e() {
        /*
            r4 = this;
            int r0 = r4.f18698d
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x000e
            int r0 = r4.f18696b
            int r3 = r4.f18697c
            if (r0 <= r3) goto L_0x0015
        L_0x000c:
            r1 = 1
            goto L_0x0015
        L_0x000e:
            int r0 = r4.f18696b
            int r3 = r4.f18697c
            if (r0 >= r3) goto L_0x0015
            goto L_0x000c
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p102e.Progressions.mo27459e():boolean");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Progressions) {
            if (!mo27459e() || !((Progressions) obj).mo27459e()) {
                Progressions aVar = (Progressions) obj;
                if (!(this.f18696b == aVar.f18696b && this.f18697c == aVar.f18697c && this.f18698d == aVar.f18698d)) {
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
        return (((this.f18696b * 31) + this.f18697c) * 31) + this.f18698d;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f18698d > 0) {
            sb = new StringBuilder();
            sb.append(this.f18696b);
            sb.append("..");
            sb.append(this.f18697c);
            sb.append(" step ");
            i = this.f18698d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f18696b);
            sb.append(" downTo ");
            sb.append(this.f18697c);
            sb.append(" step ");
            i = -this.f18698d;
        }
        sb.append(i);
        return sb.toString();
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, mo27294d2 = {"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.e.a$a */
    /* compiled from: Progressions.kt */
    public static final class C3399a {
        private C3399a() {
        }

        public /* synthetic */ C3399a(DefaultConstructorMarker gVar) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final Progressions mo27464a(int i, int i2, int i3) {
            return new Progressions(i, i2, i3);
        }
    }
}
