package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.p102e.C3401d;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\r\u0010\u001c\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001dJ\u001c\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\n\u0010!\u001a\u00060\u0002j\u0002`\u0003H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u001aH\u0016J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0004R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00108TX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, mo27294d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "_thread$annotations", "debugStatus", "isShutdownRequested", "", "()Z", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "notifyStartup", "run", "shutdown", "timeout", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.ae */
public final class DefaultExecutor extends C3500an implements Runnable {

    /* renamed from: b */
    public static final DefaultExecutor f18836b;

    /* renamed from: d */
    private static final long f18837d;

    /* renamed from: e */
    private static volatile Thread f18838e;

    /* renamed from: f */
    private static volatile int f18839f;

    static {
        Long l;
        DefaultExecutor aeVar = new DefaultExecutor();
        f18836b = aeVar;
        C3499am.m21443a(aeVar, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f18837d = timeUnit.toNanos(l.longValue());
    }

    private DefaultExecutor() {
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: b */
    public Thread mo27630b() {
        Thread thread = f18838e;
        return thread != null ? thread : m21414m();
    }

    /* renamed from: l */
    private final boolean m21413l() {
        int i = f18839f;
        return i == 2 || i == 3;
    }

    public void run() {
        C3530bl.f18906a.mo27716a(this);
        TimeSource a = C3531bn.m21630a();
        if (a != null) {
            a.mo27724d();
        }
        try {
            if (m21415n()) {
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long c = mo27649c();
                    if (c == Long.MAX_VALUE) {
                        int i = (j > Long.MAX_VALUE ? 1 : (j == Long.MAX_VALUE ? 0 : -1));
                        if (i == 0) {
                            TimeSource a2 = C3531bn.m21630a();
                            long a3 = a2 != null ? a2.mo27718a() : System.nanoTime();
                            if (i == 0) {
                                j = f18837d + a3;
                            }
                            long j2 = j - a3;
                            if (j2 <= 0) {
                                f18838e = null;
                                m21416o();
                                TimeSource a4 = C3531bn.m21630a();
                                if (a4 != null) {
                                    a4.mo27725e();
                                }
                                if (!mo27650d()) {
                                    mo27630b();
                                    return;
                                }
                                return;
                            }
                            c = C3401d.m21098b(c, j2);
                        } else {
                            c = C3401d.m21098b(c, f18837d);
                        }
                    }
                    if (c > 0) {
                        if (m21413l()) {
                            f18838e = null;
                            m21416o();
                            TimeSource a5 = C3531bn.m21630a();
                            if (a5 != null) {
                                a5.mo27725e();
                            }
                            if (!mo27650d()) {
                                mo27630b();
                                return;
                            }
                            return;
                        }
                        TimeSource a6 = C3531bn.m21630a();
                        if (a6 != null) {
                            a6.mo27720a(this, c);
                        } else {
                            LockSupport.parkNanos(this, c);
                        }
                    }
                }
            }
        } finally {
            f18838e = null;
            m21416o();
            TimeSource a7 = C3531bn.m21630a();
            if (a7 != null) {
                a7.mo27725e();
            }
            if (!mo27650d()) {
                mo27630b();
            }
        }
    }

    /* renamed from: m */
    private final synchronized Thread m21414m() {
        Thread thread;
        thread = f18838e;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            f18838e = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* renamed from: n */
    private final synchronized boolean m21415n() {
        if (m21413l()) {
            return false;
        }
        f18839f = 1;
        notifyAll();
        return true;
    }

    /* renamed from: o */
    private final synchronized void m21416o() {
        if (m21413l()) {
            f18839f = 3;
            mo27659j();
            notifyAll();
        }
    }
}
