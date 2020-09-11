package kotlin.p103f;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.p107a.C3414b;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.p109a.KMarkers;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J3\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003\"\u0004\b\u0002\u0010\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000b0\u0006H\u0000¢\u0006\u0002\b\fJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo27294d2 = {"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", "E", "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.f.i */
/* compiled from: Sequences.kt */
public final class C3408i<T, R> implements Sequence<R> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Sequence<T> f18708a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C3414b<T, R> f18709b;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, mo27294d2 = {"kotlin/sequences/TransformingSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
    /* renamed from: kotlin.f.i$a */
    /* compiled from: Sequences.kt */
    public static final class C3409a implements Iterator<R>, KMarkers {

        /* renamed from: a */
        final /* synthetic */ C3408i f18710a;
        @NotNull

        /* renamed from: b */
        private final Iterator<T> f18711b;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C3409a(C3408i iVar) {
            this.f18710a = iVar;
            this.f18711b = iVar.f18708a.mo27469a();
        }

        public R next() {
            return this.f18710a.f18709b.mo27487a(this.f18711b.next());
        }

        public boolean hasNext() {
            return this.f18711b.hasNext();
        }
    }

    public C3408i(@NotNull Sequence<? extends T> bVar, @NotNull C3414b<? super T, ? extends R> bVar2) {
        C3443i.m21155b(bVar, "sequence");
        C3443i.m21155b(bVar2, "transformer");
        this.f18708a = bVar;
        this.f18709b = bVar2;
    }

    @NotNull
    /* renamed from: a */
    public Iterator<R> mo27469a() {
        return new C3409a(this);
    }
}
