package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TypeCastException;
import kotlin.jvm.p107a.C3425m;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.p109a.KMarkers;
import kotlin.p102e.C3401d;
import kotlin.p102e.Ranges;
import kotlin.p103f.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo27294d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.text.d */
public final class Strings implements Sequence<Ranges> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final CharSequence f18752a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f18753b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f18754c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C3425m<CharSequence, Integer, Tuples<Integer, Integer>> f18755d;

    public Strings(@NotNull CharSequence charSequence, int i, int i2, @NotNull C3425m<? super CharSequence, ? super Integer, Tuples<Integer, Integer>> mVar) {
        C3443i.m21155b(charSequence, "input");
        C3443i.m21155b(mVar, "getNextMatch");
        this.f18752a = charSequence;
        this.f18753b = i;
        this.f18754c = i2;
        this.f18755d = mVar;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, mo27294d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.text.d$a */
    /* compiled from: Strings.kt */
    public static final class C3463a implements Iterator<Ranges>, KMarkers {

        /* renamed from: a */
        final /* synthetic */ Strings f18756a;

        /* renamed from: b */
        private int f18757b = -1;

        /* renamed from: c */
        private int f18758c;

        /* renamed from: d */
        private int f18759d;
        @Nullable

        /* renamed from: e */
        private Ranges f18760e;

        /* renamed from: f */
        private int f18761f;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C3463a(Strings dVar) {
            this.f18756a = dVar;
            this.f18758c = C3401d.m21095a(dVar.f18753b, 0, dVar.f18752a.length());
            this.f18759d = this.f18758c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
            if (r6.f18761f < kotlin.text.Strings.m21213a(r6.f18756a)) goto L_0x0027;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void m21218b() {
            /*
                r6 = this;
                int r0 = r6.f18759d
                r1 = 0
                if (r0 >= 0) goto L_0x000e
                r6.f18757b = r1
                r0 = 0
                kotlin.e.c r0 = (kotlin.p102e.Ranges) r0
                r6.f18760e = r0
                goto L_0x00a4
            L_0x000e:
                kotlin.text.d r0 = r6.f18756a
                int r0 = r0.f18754c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0027
                int r0 = r6.f18761f
                int r0 = r0 + r3
                r6.f18761f = r0
                int r0 = r6.f18761f
                kotlin.text.d r4 = r6.f18756a
                int r4 = r4.f18754c
                if (r0 >= r4) goto L_0x0035
            L_0x0027:
                int r0 = r6.f18759d
                kotlin.text.d r4 = r6.f18756a
                java.lang.CharSequence r4 = r4.f18752a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x004b
            L_0x0035:
                int r0 = r6.f18758c
                kotlin.e.c r1 = new kotlin.e.c
                kotlin.text.d r4 = r6.f18756a
                java.lang.CharSequence r4 = r4.f18752a
                int r4 = kotlin.text.C3467f.m21235a(r4)
                r1.<init>(r0, r4)
                r6.f18760e = r1
                r6.f18759d = r2
                goto L_0x00a2
            L_0x004b:
                kotlin.text.d r0 = r6.f18756a
                kotlin.jvm.a.m r0 = r0.f18755d
                kotlin.text.d r4 = r6.f18756a
                java.lang.CharSequence r4 = r4.f18752a
                int r5 = r6.f18759d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.mo19191a(r4, r5)
                kotlin.l r0 = (kotlin.Tuples) r0
                if (r0 != 0) goto L_0x007b
                int r0 = r6.f18758c
                kotlin.e.c r1 = new kotlin.e.c
                kotlin.text.d r4 = r6.f18756a
                java.lang.CharSequence r4 = r4.f18752a
                int r4 = kotlin.text.C3467f.m21235a(r4)
                r1.<init>(r0, r4)
                r6.f18760e = r1
                r6.f18759d = r2
                goto L_0x00a2
            L_0x007b:
                java.lang.Object r2 = r0.mo27519c()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.mo27520d()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f18758c
                kotlin.e.c r4 = kotlin.p102e.C3401d.m21099b((int) r4, (int) r2)
                r6.f18760e = r4
                int r2 = r2 + r0
                r6.f18758c = r2
                int r2 = r6.f18758c
                if (r0 != 0) goto L_0x009f
                r1 = 1
            L_0x009f:
                int r2 = r2 + r1
                r6.f18759d = r2
            L_0x00a2:
                r6.f18757b = r3
            L_0x00a4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Strings.C3463a.m21218b():void");
        }

        @NotNull
        /* renamed from: a */
        public Ranges next() {
            if (this.f18757b == -1) {
                m21218b();
            }
            if (this.f18757b != 0) {
                Ranges cVar = this.f18760e;
                if (cVar != null) {
                    this.f18760e = null;
                    this.f18757b = -1;
                    return cVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f18757b == -1) {
                m21218b();
            }
            return this.f18757b == 1;
        }
    }

    @NotNull
    /* renamed from: a */
    public Iterator<Ranges> mo27469a() {
        return new C3463a(this);
    }
}
