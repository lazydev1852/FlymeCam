package kotlinx.coroutines;

import kotlin.Exceptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.p108b.C3443i;
import kotlinx.coroutines.scheduling.C3556h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\b\u0013J\u001f\u0010\u0014\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u001aJ\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo27294d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelResult", "", "state", "", "cause", "", "cancelResult$kotlinx_coroutines_core", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, mo27295k = 1, mo27296mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.ah */
public abstract class DispatchedTask<T> extends C3556h {
    @JvmField

    /* renamed from: e */
    public int f18849e;

    /* renamed from: a */
    public <T> T mo27637a(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: a */
    public void mo27638a(@Nullable Object obj, @NotNull Throwable th) {
    }

    @Nullable
    /* renamed from: e */
    public abstract Object mo27633e();

    @NotNull
    /* renamed from: h */
    public abstract Continuation<T> mo27635h();

    public DispatchedTask(int i) {
        this.f18849e = i;
    }

    @Nullable
    /* renamed from: c */
    public final Throwable mo27640c(@Nullable Object obj) {
        if (!(obj instanceof C3542l)) {
            obj = null;
        }
        C3542l lVar = (C3542l) obj;
        if (lVar != null) {
            return lVar.f18930a;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ce, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cf, code lost:
        r3 = kotlin.Result.f18741a;
        r0 = kotlin.Result.m21195d(kotlin.C3450n.m21198a(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f2, code lost:
        r2 = kotlin.Result.f18741a;
        r0 = kotlin.Result.m21195d(kotlin.C3450n.m21198a(r0));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:39:0x00bf, B:46:0x00e2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            kotlinx.coroutines.scheduling.i r0 = r9.f18980g
            r1 = 0
            r2 = r1
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            kotlin.coroutines.d r3 = r9.mo27635h()     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            if (r3 == 0) goto L_0x00b6
            kotlinx.coroutines.af r3 = (kotlinx.coroutines.DispatchedContinuation) r3     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            kotlin.coroutines.d<T> r4 = r3.f18844d     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            kotlin.coroutines.g r5 = r4.mo27423a()     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            java.lang.Object r6 = r9.mo27633e()     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            java.lang.Object r3 = r3.f18842b     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            java.lang.Object r3 = kotlinx.coroutines.p111a.ThreadContext.m21375a(r5, r3)     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            java.lang.Throwable r7 = r9.mo27640c(r6)     // Catch:{ all -> 0x00b1 }
            int r8 = r9.f18849e     // Catch:{ all -> 0x00b1 }
            boolean r8 = kotlinx.coroutines.C3498ai.m21437a((int) r8)     // Catch:{ all -> 0x00b1 }
            if (r8 == 0) goto L_0x0034
            kotlinx.coroutines.ay$b r1 = kotlinx.coroutines.C3512ay.f18878b     // Catch:{ all -> 0x00b1 }
            kotlin.coroutines.g$c r1 = (kotlin.coroutines.CoroutineContext.C3380c) r1     // Catch:{ all -> 0x00b1 }
            kotlin.coroutines.g$b r1 = r5.mo27412a(r1)     // Catch:{ all -> 0x00b1 }
            kotlinx.coroutines.ay r1 = (kotlinx.coroutines.C3512ay) r1     // Catch:{ all -> 0x00b1 }
        L_0x0034:
            if (r7 != 0) goto L_0x006d
            if (r1 == 0) goto L_0x006d
            boolean r8 = r1.mo27559c()     // Catch:{ all -> 0x00b1 }
            if (r8 != 0) goto L_0x006d
            java.util.concurrent.CancellationException r1 = r1.mo27672i()     // Catch:{ all -> 0x00b1 }
            r7 = r1
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00b1 }
            r9.mo27638a((java.lang.Object) r6, (java.lang.Throwable) r7)     // Catch:{ all -> 0x00b1 }
            kotlin.m$a r6 = kotlin.Result.f18741a     // Catch:{ all -> 0x00b1 }
            boolean r6 = kotlinx.coroutines.Debug.m21408c()     // Catch:{ all -> 0x00b1 }
            if (r6 == 0) goto L_0x005f
            boolean r6 = r4 instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame     // Catch:{ all -> 0x00b1 }
            if (r6 != 0) goto L_0x0055
            goto L_0x005f
        L_0x0055:
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00b1 }
            r6 = r4
            kotlin.coroutines.jvm.internal.d r6 = (kotlin.coroutines.jvm.internal.CoroutineStackFrame) r6     // Catch:{ all -> 0x00b1 }
            java.lang.Throwable r1 = kotlinx.coroutines.p111a.StackTraceRecovery.m21358b(r1, r6)     // Catch:{ all -> 0x00b1 }
            goto L_0x0061
        L_0x005f:
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00b1 }
        L_0x0061:
            java.lang.Object r1 = kotlin.C3450n.m21198a((java.lang.Throwable) r1)     // Catch:{ all -> 0x00b1 }
            java.lang.Object r1 = kotlin.Result.m21195d(r1)     // Catch:{ all -> 0x00b1 }
            r4.mo27424b(r1)     // Catch:{ all -> 0x00b1 }
            goto L_0x008a
        L_0x006d:
            if (r7 == 0) goto L_0x007d
            kotlin.m$a r1 = kotlin.Result.f18741a     // Catch:{ all -> 0x00b1 }
            java.lang.Object r1 = kotlin.C3450n.m21198a((java.lang.Throwable) r7)     // Catch:{ all -> 0x00b1 }
            java.lang.Object r1 = kotlin.Result.m21195d(r1)     // Catch:{ all -> 0x00b1 }
            r4.mo27424b(r1)     // Catch:{ all -> 0x00b1 }
            goto L_0x008a
        L_0x007d:
            java.lang.Object r1 = r9.mo27637a(r6)     // Catch:{ all -> 0x00b1 }
            kotlin.m$a r6 = kotlin.Result.f18741a     // Catch:{ all -> 0x00b1 }
            java.lang.Object r1 = kotlin.Result.m21195d(r1)     // Catch:{ all -> 0x00b1 }
            r4.mo27424b(r1)     // Catch:{ all -> 0x00b1 }
        L_0x008a:
            kotlin.t r1 = kotlin.Unit.f18749a     // Catch:{ all -> 0x00b1 }
            kotlinx.coroutines.p111a.ThreadContext.m21376b(r5, r3)     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            kotlin.m$a r1 = kotlin.Result.f18741a     // Catch:{ Throwable -> 0x009e }
            r1 = r9
            kotlinx.coroutines.ah r1 = (kotlinx.coroutines.DispatchedTask) r1     // Catch:{ Throwable -> 0x009e }
            r0.mo27766b()     // Catch:{ Throwable -> 0x009e }
            kotlin.t r0 = kotlin.Unit.f18749a     // Catch:{ Throwable -> 0x009e }
            java.lang.Object r0 = kotlin.Result.m21195d(r0)     // Catch:{ Throwable -> 0x009e }
            goto L_0x00a9
        L_0x009e:
            r0 = move-exception
            kotlin.m$a r1 = kotlin.Result.f18741a
            java.lang.Object r0 = kotlin.C3450n.m21198a((java.lang.Throwable) r0)
            java.lang.Object r0 = kotlin.Result.m21195d(r0)
        L_0x00a9:
            java.lang.Throwable r0 = kotlin.Result.m21193b(r0)
            r9.mo27639a((java.lang.Throwable) r2, (java.lang.Throwable) r0)
            goto L_0x0103
        L_0x00b1:
            r1 = move-exception
            kotlinx.coroutines.p111a.ThreadContext.m21376b(r5, r3)     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            throw r1     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
        L_0x00b6:
            kotlin.q r1 = new kotlin.q     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>"
            r1.<init>(r3)     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
            throw r1     // Catch:{ Throwable -> 0x00e1, all -> 0x00be }
        L_0x00be:
            r1 = move-exception
            kotlin.m$a r3 = kotlin.Result.f18741a     // Catch:{ Throwable -> 0x00ce }
            r3 = r9
            kotlinx.coroutines.ah r3 = (kotlinx.coroutines.DispatchedTask) r3     // Catch:{ Throwable -> 0x00ce }
            r0.mo27766b()     // Catch:{ Throwable -> 0x00ce }
            kotlin.t r0 = kotlin.Unit.f18749a     // Catch:{ Throwable -> 0x00ce }
            java.lang.Object r0 = kotlin.Result.m21195d(r0)     // Catch:{ Throwable -> 0x00ce }
            goto L_0x00d9
        L_0x00ce:
            r0 = move-exception
            kotlin.m$a r3 = kotlin.Result.f18741a
            java.lang.Object r0 = kotlin.C3450n.m21198a((java.lang.Throwable) r0)
            java.lang.Object r0 = kotlin.Result.m21195d(r0)
        L_0x00d9:
            java.lang.Throwable r0 = kotlin.Result.m21193b(r0)
            r9.mo27639a((java.lang.Throwable) r2, (java.lang.Throwable) r0)
            throw r1
        L_0x00e1:
            r1 = move-exception
            kotlin.m$a r2 = kotlin.Result.f18741a     // Catch:{ Throwable -> 0x00f1 }
            r2 = r9
            kotlinx.coroutines.ah r2 = (kotlinx.coroutines.DispatchedTask) r2     // Catch:{ Throwable -> 0x00f1 }
            r0.mo27766b()     // Catch:{ Throwable -> 0x00f1 }
            kotlin.t r0 = kotlin.Unit.f18749a     // Catch:{ Throwable -> 0x00f1 }
            java.lang.Object r0 = kotlin.Result.m21195d(r0)     // Catch:{ Throwable -> 0x00f1 }
            goto L_0x00fc
        L_0x00f1:
            r0 = move-exception
            kotlin.m$a r2 = kotlin.Result.f18741a
            java.lang.Object r0 = kotlin.C3450n.m21198a((java.lang.Throwable) r0)
            java.lang.Object r0 = kotlin.Result.m21195d(r0)
        L_0x00fc:
            java.lang.Throwable r0 = kotlin.Result.m21193b(r0)
            r9.mo27639a((java.lang.Throwable) r1, (java.lang.Throwable) r0)
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DispatchedTask.run():void");
    }

    /* renamed from: a */
    public final void mo27639a(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                Exceptions.m20931a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            String str = "Fatal exception in coroutines machinery for " + this + ". " + "Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
            if (th == null) {
                C3443i.m21151a();
            }
            C3564w.m21759a(mo27635h().mo27423a(), (Throwable) new C3496ab(str, th));
        }
    }
}
