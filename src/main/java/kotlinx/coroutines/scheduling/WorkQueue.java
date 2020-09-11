package kotlinx.coroutines.scheduling;

import com.loc.C1108h;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.Debug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020*B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\r*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u0006)"}, mo27294d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.scheduling.m */
public final class WorkQueue {

    /* renamed from: c */
    private static final AtomicReferenceFieldUpdater f18988c = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "b");

    /* renamed from: e */
    private static final AtomicIntegerFieldUpdater f18989e = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "d");

    /* renamed from: g */
    private static final AtomicIntegerFieldUpdater f18990g = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, C1108h.f3354h);

    /* renamed from: i */
    private static final AtomicIntegerFieldUpdater f18991i = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, C1108h.f3352f);

    /* renamed from: a */
    private final AtomicReferenceArray<C3556h> f18992a = new AtomicReferenceArray<>(128);

    /* renamed from: b */
    private volatile Object f18993b = null;

    /* renamed from: d */
    private volatile int f18994d = 0;

    /* renamed from: f */
    private volatile int f18995f = 0;

    /* renamed from: h */
    private volatile int f18996h = 0;

    /* renamed from: a */
    public final int mo27773a() {
        return this.f18994d - this.f18995f;
    }

    /* renamed from: b */
    public final int mo27777b() {
        return this.f18993b != null ? mo27773a() + 1 : mo27773a();
    }

    @Nullable
    /* renamed from: c */
    public final C3556h mo27779c() {
        C3556h hVar = (C3556h) f18988c.getAndSet(this, (Object) null);
        return hVar != null ? hVar : m21740d();
    }

    /* renamed from: a */
    public static /* synthetic */ C3556h m21737a(WorkQueue mVar, C3556h hVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return mVar.mo27775a(hVar, z);
    }

    @Nullable
    /* renamed from: a */
    public final C3556h mo27775a(@NotNull C3556h hVar, boolean z) {
        if (z) {
            return m21736a(hVar);
        }
        C3556h hVar2 = (C3556h) f18988c.getAndSet(this, hVar);
        if (hVar2 != null) {
            return m21736a(hVar2);
        }
        return null;
    }

    /* renamed from: a */
    public final long mo27774a(@NotNull WorkQueue mVar) {
        boolean z = true;
        if (Debug.m21406a()) {
            if (!(mo27773a() == 0)) {
                throw new AssertionError();
            }
        }
        C3556h d = mVar.m21740d();
        if (d == null) {
            return m21735a(mVar, false);
        }
        C3556h a = m21737a(this, d, false, 2, (Object) null);
        if (!Debug.m21406a()) {
            return -1;
        }
        if (a != null) {
            z = false;
        }
        if (z) {
            return -1;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public final long mo27778b(@NotNull WorkQueue mVar) {
        if (Debug.m21406a()) {
            if (!(mo27773a() == 0)) {
                throw new AssertionError();
            }
        }
        int i = mVar.f18994d;
        AtomicReferenceArray<C3556h> atomicReferenceArray = mVar.f18992a;
        for (int i2 = mVar.f18995f; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (mVar.f18996h == 0) {
                break;
            }
            C3556h hVar = atomicReferenceArray.get(i3);
            if (hVar != null) {
                if ((hVar.f18980g.mo27767c() == 1) && atomicReferenceArray.compareAndSet(i3, hVar, (Object) null)) {
                    f18991i.decrementAndGet(mVar);
                    m21737a(this, hVar, false, 2, (Object) null);
                    return -1;
                }
            }
        }
        return m21735a(mVar, true);
    }

    /* renamed from: a */
    public final void mo27776a(@NotNull Tasks dVar) {
        C3556h hVar = (C3556h) f18988c.getAndSet(this, (Object) null);
        if (hVar != null) {
            dVar.mo27593a(hVar);
        }
        do {
        } while (m21739b(dVar));
    }

    /* renamed from: a */
    private final long m21735a(WorkQueue mVar, boolean z) {
        C3556h hVar;
        do {
            hVar = (C3556h) mVar.f18993b;
            if (hVar == null) {
                return -2;
            }
            if (z) {
                boolean z2 = true;
                if (hVar.f18980g.mo27767c() != 1) {
                    z2 = false;
                }
                if (!z2) {
                    return -2;
                }
            }
            long a = C3559k.f18987f.mo27770a() - hVar.f18979f;
            if (a < C3559k.f18982a) {
                return C3559k.f18982a - a;
            }
        } while (!f18988c.compareAndSet(mVar, hVar, (Object) null));
        m21737a(this, hVar, false, 2, (Object) null);
        return -1;
    }

    /* renamed from: b */
    private final boolean m21739b(Tasks dVar) {
        C3556h d = m21740d();
        if (d == null) {
            return false;
        }
        dVar.mo27593a(d);
        return true;
    }

    /* renamed from: d */
    private final C3556h m21740d() {
        C3556h andSet;
        while (true) {
            int i = this.f18995f;
            if (i - this.f18994d == 0) {
                return null;
            }
            int i2 = i & 127;
            if (f18990g.compareAndSet(this, i, i + 1) && (andSet = this.f18992a.getAndSet(i2, (Object) null)) != null) {
                m21738b(andSet);
                return andSet;
            }
        }
    }

    /* renamed from: a */
    private final C3556h m21736a(C3556h hVar) {
        boolean z = true;
        if (hVar.f18980g.mo27767c() != 1) {
            z = false;
        }
        if (z) {
            f18991i.incrementAndGet(this);
        }
        if (mo27773a() == 127) {
            return hVar;
        }
        int i = this.f18994d & 127;
        while (this.f18992a.get(i) != null) {
            Thread.yield();
        }
        this.f18992a.lazySet(i, hVar);
        f18989e.incrementAndGet(this);
        return null;
    }

    /* renamed from: b */
    private final void m21738b(@Nullable C3556h hVar) {
        if (hVar != null) {
            boolean z = false;
            if (hVar.f18980g.mo27767c() == 1) {
                int decrementAndGet = f18991i.decrementAndGet(this);
                if (Debug.m21406a()) {
                    if (decrementAndGet >= 0) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }
}
