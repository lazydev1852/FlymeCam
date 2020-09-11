package kotlin.p102e;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.C3365w;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, mo27294d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlin.e.b */
public final class ProgressionIterators extends C3365w {

    /* renamed from: a */
    private final int f18699a;

    /* renamed from: b */
    private boolean f18700b;

    /* renamed from: c */
    private int f18701c;

    /* renamed from: d */
    private final int f18702d;

    public ProgressionIterators(int i, int i2, int i3) {
        this.f18702d = i3;
        this.f18699a = i2;
        boolean z = false;
        if (this.f18702d <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.f18700b = z;
        this.f18701c = !this.f18700b ? this.f18699a : i;
    }

    public boolean hasNext() {
        return this.f18700b;
    }

    /* renamed from: b */
    public int mo27408b() {
        int i = this.f18701c;
        if (i != this.f18699a) {
            this.f18701c += this.f18702d;
        } else if (this.f18700b) {
            this.f18700b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
