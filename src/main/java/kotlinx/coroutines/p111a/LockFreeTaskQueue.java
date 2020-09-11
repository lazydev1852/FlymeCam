package kotlinx.coroutines.p111a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0001\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u0013\u0010\u001b\u001a\u00020\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, mo27294d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.a.h */
public class LockFreeTaskQueue<E> {

    /* renamed from: b */
    private static final AtomicReferenceFieldUpdater f18798b = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "a");

    /* renamed from: a */
    private volatile Object f18799a;

    public LockFreeTaskQueue(boolean z) {
        this.f18799a = new C3482i(8, z);
    }

    /* renamed from: a */
    public final int mo27592a() {
        return ((C3482i) this.f18799a).mo27598b();
    }

    /* renamed from: b */
    public final void mo27594b() {
        while (true) {
            C3482i iVar = (C3482i) this.f18799a;
            if (!iVar.mo27599c()) {
                f18798b.compareAndSet(this, iVar, iVar.mo27601e());
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final boolean mo27593a(@NotNull E e) {
        while (true) {
            C3482i iVar = (C3482i) this.f18799a;
            switch (iVar.mo27596a(e)) {
                case 0:
                    return true;
                case 1:
                    f18798b.compareAndSet(this, iVar, iVar.mo27601e());
                    break;
                case 2:
                    return false;
            }
        }
    }

    @Nullable
    /* renamed from: c */
    public final E mo27595c() {
        while (true) {
            C3482i iVar = (C3482i) this.f18799a;
            E d = iVar.mo27600d();
            if (d != C3482i.f18800a) {
                return d;
            }
            f18798b.compareAndSet(this, iVar, iVar.mo27601e());
        }
    }
}
