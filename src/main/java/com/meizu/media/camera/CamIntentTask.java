package com.meizu.media.camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.p020ar.audio.AudioParams;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.p064a.ParamData;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.TimingLoggerUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.meizu.media.camera.a */
public abstract class CamIntentTask {

    /* renamed from: a */
    public static ChangeQuickRedirect f7405a;

    /* renamed from: b */
    public static final Executor f7406b = new C1779e();

    /* renamed from: c */
    public static final Executor f7407c = new ThreadPoolExecutor(f7418v, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1, TimeUnit.SECONDS, f7420x, f7419w);

    /* renamed from: h */
    protected static int f7408h = 1;

    /* renamed from: i */
    protected static C1778d f7409i;

    /* renamed from: k */
    protected static final CopyOnWriteArrayList<C1777c> f7410k = new CopyOnWriteArrayList<>();

    /* renamed from: l */
    protected static final CopyOnWriteArrayList<UUID> f7411l = new CopyOnWriteArrayList<>();

    /* renamed from: m */
    protected static final CopyOnWriteArrayList<C1775a> f7412m = new CopyOnWriteArrayList<>();

    /* renamed from: n */
    protected static CamIntentTask f7413n;

    /* renamed from: r */
    public static final Object f7414r = new Object();

    /* renamed from: s */
    public static final Object f7415s = new Object();
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static final LogUtil.C2630a f7416t = new LogUtil.C2630a("CamIntentTask");

    /* renamed from: u */
    private static final int f7417u = Runtime.getRuntime().availableProcessors();

    /* renamed from: v */
    private static final int f7418v = (f7417u + 1);

    /* renamed from: w */
    private static final ThreadFactory f7419w = new ThreadFactory() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7433a;

        /* renamed from: b */
        private final AtomicInteger f7434b = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{runnable}, this, f7433a, false, 639, new Class[]{Runnable.class}, Thread.class);
            if (proxy.isSupported) {
                return (Thread) proxy.result;
            }
            return new Thread(runnable, "CamIntentTask #" + this.f7434b.getAndIncrement());
        }
    };

    /* renamed from: x */
    private static final BlockingQueue<Runnable> f7420x = new LinkedBlockingQueue(128);

    /* renamed from: A */
    private volatile Looper f7421A;

    /* renamed from: B */
    private volatile Looper f7422B;

    /* renamed from: d */
    protected volatile Handler f7423d;

    /* renamed from: e */
    protected volatile C1776b f7424e;

    /* renamed from: f */
    protected volatile List<Runnable> f7425f;

    /* renamed from: g */
    protected volatile List<Runnable> f7426g;

    /* renamed from: j */
    protected Deque<C1778d> f7427j = new LinkedBlockingDeque();

    /* renamed from: o */
    protected Context f7428o;

    /* renamed from: p */
    protected volatile boolean f7429p;

    /* renamed from: q */
    protected volatile boolean f7430q;

    /* renamed from: y */
    private volatile Looper f7431y;

    /* renamed from: z */
    private volatile C1781f f7432z;

    /* renamed from: com.meizu.media.camera.a$a */
    /* compiled from: CamIntentTask */
    public interface C1775a {
        /* renamed from: a */
        void mo18339a(int i);
    }

    /* renamed from: com.meizu.media.camera.a$c */
    /* compiled from: CamIntentTask */
    public interface C1777c {
        /* renamed from: a */
        Bitmap mo17987a(Bitmap bitmap, Point[] pointArr);

        /* renamed from: a */
        List<Surface> mo17988a(boolean z);

        /* renamed from: a */
        void mo18006a(ParamData fVar);

        /* renamed from: a */
        void mo18014a(Contants.CameraService.RequestCode requestCode, Contants.CameraService.ResultCode resultCode, Object... objArr);

        /* renamed from: a */
        Point[] mo18021a(Bitmap bitmap);

        /* renamed from: b */
        UUID mo18056b();

        /* renamed from: c */
        SurfaceTexture mo18119c();

        /* renamed from: d */
        boolean mo18176d();

        /* renamed from: e */
        List<Surface> mo18229e();

        /* renamed from: f */
        SurfaceTexture mo18236f();

        /* renamed from: g */
        boolean mo18237g();

        /* renamed from: h */
        int mo18238h();

        /* renamed from: i */
        boolean mo18240i();

        /* renamed from: j */
        void mo18241j();

        /* renamed from: k */
        void mo18243k();
    }

    @WorkerThread
    /* renamed from: c */
    public abstract void mo18696c();

    /* renamed from: i */
    public boolean mo18702i() {
        return false;
    }

    /* renamed from: com.meizu.media.camera.a$e */
    /* compiled from: CamIntentTask */
    private static class C1779e implements Executor {

        /* renamed from: a */
        public static ChangeQuickRedirect f7439a;

        /* renamed from: b */
        final ArrayDeque<Runnable> f7440b;

        /* renamed from: c */
        Runnable f7441c;

        private C1779e() {
            this.f7440b = new ArrayDeque<>();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void execute(final java.lang.Runnable r9) {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0032 }
                r2 = 0
                r1[r2] = r9     // Catch:{ all -> 0x0032 }
                com.meizu.savior.ChangeQuickRedirect r3 = f7439a     // Catch:{ all -> 0x0032 }
                r4 = 0
                r5 = 641(0x281, float:8.98E-43)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0032 }
                java.lang.Class<java.lang.Runnable> r0 = java.lang.Runnable.class
                r6[r2] = r0     // Catch:{ all -> 0x0032 }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0032 }
                r2 = r8
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0032 }
                boolean r0 = r0.isSupported     // Catch:{ all -> 0x0032 }
                if (r0 == 0) goto L_0x001f
                monitor-exit(r8)
                return
            L_0x001f:
                java.util.ArrayDeque<java.lang.Runnable> r0 = r8.f7440b     // Catch:{ all -> 0x0032 }
                com.meizu.media.camera.a$e$1 r1 = new com.meizu.media.camera.a$e$1     // Catch:{ all -> 0x0032 }
                r1.<init>(r9)     // Catch:{ all -> 0x0032 }
                r0.offer(r1)     // Catch:{ all -> 0x0032 }
                java.lang.Runnable r9 = r8.f7441c     // Catch:{ all -> 0x0032 }
                if (r9 != 0) goto L_0x0030
                r8.mo18705a()     // Catch:{ all -> 0x0032 }
            L_0x0030:
                monitor-exit(r8)
                return
            L_0x0032:
                r9 = move-exception
                monitor-exit(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CamIntentTask.C1779e.execute(java.lang.Runnable):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo18705a() {
            /*
                r8 = this;
                monitor-enter(r8)
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x002d }
                com.meizu.savior.ChangeQuickRedirect r3 = f7439a     // Catch:{ all -> 0x002d }
                r4 = 0
                r5 = 642(0x282, float:9.0E-43)
                java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x002d }
                java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x002d }
                r2 = r8
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002d }
                boolean r0 = r0.isSupported     // Catch:{ all -> 0x002d }
                if (r0 == 0) goto L_0x0018
                monitor-exit(r8)
                return
            L_0x0018:
                java.util.ArrayDeque<java.lang.Runnable> r0 = r8.f7440b     // Catch:{ all -> 0x002d }
                java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x002d }
                java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x002d }
                r8.f7441c = r0     // Catch:{ all -> 0x002d }
                if (r0 == 0) goto L_0x002b
                java.util.concurrent.Executor r0 = com.meizu.media.camera.CamIntentTask.f7407c     // Catch:{ all -> 0x002d }
                java.lang.Runnable r1 = r8.f7441c     // Catch:{ all -> 0x002d }
                r0.execute(r1)     // Catch:{ all -> 0x002d }
            L_0x002b:
                monitor-exit(r8)
                return
            L_0x002d:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.CamIntentTask.C1779e.mo18705a():void");
        }
    }

    /* renamed from: com.meizu.media.camera.a$d */
    /* compiled from: CamIntentTask */
    public class C1778d {

        /* renamed from: a */
        public Intent f7436a;

        /* renamed from: b */
        public boolean f7437b;

        public C1778d() {
        }
    }

    /* renamed from: com.meizu.media.camera.a$f */
    /* compiled from: CamIntentTask */
    private final class C1781f extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f7445a;

        public C1781f(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f7445a, false, 644, new Class[]{Message.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(CamIntentTask.f7416t, "handleMessage start");
                while (CamIntentTask.this.f7427j.size() > 0) {
                    CamIntentTask.f7409i = CamIntentTask.this.f7427j.peek();
                    CamIntentTask.this.mo18696c();
                    CamIntentTask.f7409i = null;
                }
                LogUtil.m15942a(CamIntentTask.f7416t, "handleMessage");
            }
        }
    }

    public CamIntentTask(Context context) {
        this.f7428o = context;
        mo18691a();
    }

    /* renamed from: a */
    public final void mo18691a() {
        if (!PatchProxy.proxy(new Object[0], this, f7405a, false, 615, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f7416t;
            LogUtil.m15942a(aVar, "onCreate this:" + this + "  version:" + "8.7.17");
            StringBuilder sb = new StringBuilder();
            sb.append("CamIntentTask[");
            sb.append(System.currentTimeMillis());
            sb.append("]");
            HandlerThread handlerThread = new HandlerThread(sb.toString());
            handlerThread.start();
            this.f7431y = handlerThread.getLooper();
            this.f7432z = new C1781f(this.f7431y);
            HandlerThread handlerThread2 = new HandlerThread("BackgroundThread");
            handlerThread2.start();
            this.f7421A = handlerThread2.getLooper();
            this.f7423d = new Handler(this.f7421A);
            HandlerThread handlerThread3 = new HandlerThread("DeliverCallbackThread");
            handlerThread3.start();
            this.f7422B = handlerThread3.getLooper();
            this.f7424e = new C1776b(this.f7422B);
            this.f7425f = new ArrayList();
            this.f7426g = new ArrayList();
        }
    }

    /* renamed from: a */
    public void mo18692a(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f7405a, false, 616, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f7416t, UxipConstants.RESPONSE_KEY_UPLOADPOLICY_ONSTART);
            C1778d dVar = new C1778d();
            dVar.f7436a = intent;
            String action = intent.getAction();
            UUID uuid = (UUID) intent.getSerializableExtra("uuid");
            if (Contants.CameraService.Action.ACTION_RESUME_CAMERA.name().equals(action)) {
                if (f7411l.contains(uuid)) {
                    f7411l.remove(uuid);
                }
            } else if (Contants.CameraService.Action.ACTION_CLOSE_CAMERA.name().equals(action)) {
                if (!f7411l.contains(uuid)) {
                    f7411l.add(uuid);
                }
            } else if (f7411l.contains(uuid)) {
                LogUtil.C2630a aVar = f7416t;
                LogUtil.m15952c(aVar, "Action will be abandon after ACTION_CLOSE_CAMERA action:" + action + "  uuid:" + uuid);
                return;
            }
            C1777c a = mo18690a(uuid);
            LogUtil.C2630a aVar2 = f7416t;
            LogUtil.m15942a(aVar2, "listener:" + a);
            if (a != null || Contants.CameraService.Action.ACTION_CLOSE_CAMERA.name().equals(action) || Contants.CameraService.Action.ACTION_RESUME_CAMERA.name().equals(action) || Contants.CameraService.Action.ACTION_OPEN_CAMERA.name().equals(action)) {
                String stringExtra = intent.getStringExtra("from");
                if (m7846m() && Contants.CameraService.Action.ACTION_RESUME_CAMERA.name().equals(action) && !"android.media.action.STILL_IMAGE_CAMERA".equals(stringExtra) && !"android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(stringExtra) && this.f7427j.size() > 0) {
                    C1778d last = this.f7427j.getLast();
                    String action2 = (last == null || last.f7436a == null) ? "null" : last.f7436a.getAction();
                    UUID uuid2 = (last == null || last.f7436a == null) ? null : (UUID) last.f7436a.getSerializableExtra("uuid");
                    LogUtil.C2630a aVar3 = f7416t;
                    LogUtil.m15942a(aVar3, "last action:" + action2);
                    if (last != null && Contants.CameraService.Action.ACTION_CLOSE_CAMERA.name().equals(action2) && uuid.equals(uuid2)) {
                        last.f7437b = true;
                        LogUtil.m15942a(f7416t, "Skip restarting camera during capturing");
                        return;
                    }
                }
                this.f7427j.add(dVar);
                if (intent.getAction().equals(Contants.CameraService.Action.ACTION_CLOSE_CAMERA.name())) {
                    synchronized (f7414r) {
                        f7414r.notify();
                        LogUtil.m15942a(f7416t, "onStart notify");
                    }
                }
                LogUtil.C2630a aVar4 = f7416t;
                LogUtil.m15942a(aVar4, "action:" + intent.getAction() + "  uuid:" + uuid);
                this.f7432z.sendEmptyMessage(f7408h);
                return;
            }
            LogUtil.C2630a aVar5 = f7416t;
            LogUtil.m15952c(aVar5, "Listener may be unregistered, skip action:" + action + "  uuid:" + uuid);
        }
    }

    /* renamed from: b */
    public void mo18695b() {
        if (!PatchProxy.proxy(new Object[0], this, f7405a, false, 617, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f7416t, "release");
            this.f7431y.quit();
            this.f7421A.quit();
            this.f7422B.quit();
            f7413n = null;
            this.f7429p = true;
            f7409i = null;
            if (this.f7425f != null) {
                this.f7425f.clear();
                this.f7425f = null;
            }
            if (this.f7426g != null) {
                this.f7426g.clear();
                this.f7426g = null;
            }
            TimingLoggerUtil.m16030a();
        }
    }

    /* renamed from: d */
    public boolean mo18697d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7405a, false, 618, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo18694a(false);
    }

    /* renamed from: a */
    public boolean mo18694a(boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f7405a, false, 619, new Class[]{Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C1778d peek = this.f7427j.peek();
        if (peek == null) {
            return false;
        }
        return Contants.CameraService.Action.ACTION_CLOSE_CAMERA.name().equals(peek.f7436a.getAction()) && peek.f7436a.getBooleanExtra("EXTRA_IS_WATCH_CAMERA_INTENT", false) == z && !peek.f7437b;
    }

    /* renamed from: e */
    public boolean mo18698e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7405a, false, 620, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C1778d peek = this.f7427j.peek();
        if (peek == null) {
            LogUtil.m15952c(f7416t, "isNextTaskSwitchCamera no task");
            return false;
        }
        LogUtil.C2630a aVar = f7416t;
        LogUtil.m15952c(aVar, "isNextTaskSwitchCamera  action:" + peek.f7436a.getAction());
        if (!Contants.CameraService.Action.ACTION_SWITCH_CAMERA.name().equals(peek.f7436a.getAction()) || peek.f7437b) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public boolean mo18699f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7405a, false, 621, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C1778d peek = this.f7427j.peek();
        if (peek == null) {
            LogUtil.m15952c(f7416t, "isNextTaskStopPreview no task");
            return false;
        }
        LogUtil.C2630a aVar = f7416t;
        LogUtil.m15952c(aVar, "isNextTaskStopPreview  action:" + peek.f7436a.getAction());
        if (!Contants.CameraService.Action.ACTION_STOP_PREVIEW.name().equals(peek.f7436a.getAction()) || peek.f7437b) {
            return false;
        }
        return true;
    }

    /* renamed from: g */
    public boolean mo18700g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7405a, false, 622, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C1778d peek = this.f7427j.peek();
        if (peek == null) {
            LogUtil.m15952c(f7416t, "isNextTaskStartPreview no task");
            return false;
        }
        LogUtil.C2630a aVar = f7416t;
        LogUtil.m15952c(aVar, "isNextTaskStartPreview  action:" + peek.f7436a.getAction());
        if (!Contants.CameraService.Action.ACTION_START_PREVIEW.name().equals(peek.f7436a.getAction()) || peek.f7437b) {
            return false;
        }
        return true;
    }

    /* renamed from: h */
    public boolean mo18701h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7405a, false, 623, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C1778d peek = this.f7427j.peek();
        if (peek == null) {
            LogUtil.m15952c(f7416t, "isNextTaskEndBurst no task");
            return false;
        }
        LogUtil.C2630a aVar = f7416t;
        LogUtil.m15952c(aVar, "isNextTaskEndBurst  action:" + peek.f7436a.getAction());
        if (Contants.CameraService.Action.ACTION_STOP_BURST.name().equals(peek.f7436a.getAction())) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public static void m7843j() {
        if (f7409i != null) {
            f7409i.f7437b = true;
        }
    }

    /* renamed from: k */
    public static boolean m7844k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7405a, true, 625, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (f7409i == null) {
            return false;
        }
        try {
            String action = f7409i.f7436a.getAction();
            if (f7409i == null || f7409i.f7437b || action == null) {
                return false;
            }
            if (action.equals(Contants.CameraService.Action.ACTION_TAKE_BURST_PICTURE.name()) || action.equals(Contants.CameraService.Action.ACTION_TAKE_PICTURE.name()) || action.equals(Contants.CameraService.Action.ACTION_TAKE_STEREO_PICTURE.name())) {
                return true;
            }
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    /* renamed from: l */
    public static boolean m7845l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7405a, true, 626, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (f7409i == null) {
            return false;
        }
        try {
            String action = f7409i.f7436a.getAction();
            if (f7409i == null || f7409i.f7437b || action == null || !action.equals(Contants.CameraService.Action.ACTION_CLOSE_CAMERA.name())) {
                return false;
            }
            return true;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    /* renamed from: m */
    public static boolean m7846m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7405a, true, 627, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8857N();
    }

    /* renamed from: n */
    public static boolean m7847n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7405a, true, 628, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8853J();
    }

    /* renamed from: o */
    public static boolean m7848o() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7405a, true, 629, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8854K();
    }

    /* renamed from: p */
    public static boolean m7849p() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7405a, true, 630, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8852I();
    }

    /* renamed from: q */
    public static boolean m7850q() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7405a, true, 631, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8855L();
    }

    /* renamed from: r */
    public static boolean m7851r() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7405a, true, 632, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : CameraController.m8856M();
    }

    /* renamed from: a */
    public C1777c mo18690a(UUID uuid) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f7405a, false, 633, new Class[]{UUID.class}, C1777c.class);
        if (proxy.isSupported) {
            return (C1777c) proxy.result;
        }
        Iterator<C1777c> it = f7410k.iterator();
        while (it.hasNext()) {
            C1777c next = it.next();
            if (next.mo18056b().equals(uuid)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m7840a(C1777c cVar) {
        if (!PatchProxy.proxy(new Object[]{cVar}, (Object) null, f7405a, true, 634, new Class[]{C1777c.class}, Void.TYPE).isSupported) {
            synchronized (f7410k) {
                if (!f7410k.contains(cVar)) {
                    f7410k.add(0, cVar);
                    LogUtil.C2630a aVar = f7416t;
                    LogUtil.m15952c(aVar, "registerListener uuid:" + cVar.mo18056b() + " size=" + f7410k.size());
                }
            }
        }
    }

    /* renamed from: b */
    public static void m7842b(C1777c cVar) {
        if (!PatchProxy.proxy(new Object[]{cVar}, (Object) null, f7405a, true, 635, new Class[]{C1777c.class}, Void.TYPE).isSupported) {
            synchronized (f7410k) {
                if (f7410k.contains(cVar)) {
                    f7410k.remove(cVar);
                    LogUtil.C2630a aVar = f7416t;
                    LogUtil.m15952c(aVar, "unregisterListener uuid:" + cVar.mo18056b() + " size=" + f7410k.size());
                }
            }
        }
    }

    /* renamed from: a */
    public static void m7839a(C1775a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, (Object) null, f7405a, true, 636, new Class[]{C1775a.class}, Void.TYPE).isSupported) {
            synchronized (f7412m) {
                if (!f7412m.contains(aVar)) {
                    f7412m.add(0, aVar);
                    LogUtil.C2630a aVar2 = f7416t;
                    LogUtil.m15952c(aVar2, "registerCaptureCallback:" + aVar);
                }
            }
        }
    }

    /* renamed from: b */
    public static void m7841b(C1775a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, (Object) null, f7405a, true, 637, new Class[]{C1775a.class}, Void.TYPE).isSupported) {
            synchronized (f7412m) {
                if (f7412m.contains(aVar)) {
                    f7412m.remove(aVar);
                    LogUtil.C2630a aVar2 = f7416t;
                    LogUtil.m15952c(aVar2, "unregisterCaptureCallback:" + aVar);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo18693a(UUID uuid, Contants.CameraService.RequestCode requestCode, Contants.CameraService.ResultCode resultCode, Object... objArr) {
        boolean z = false;
        Class[] clsArr = {UUID.class, Contants.CameraService.RequestCode.class, Contants.CameraService.ResultCode.class, Object[].class};
        if (!PatchProxy.proxy(new Object[]{uuid, requestCode, resultCode, objArr}, this, f7405a, false, 638, clsArr, Void.TYPE).isSupported) {
            synchronized (f7410k) {
                Iterator<C1777c> it = f7410k.iterator();
                while (it.hasNext()) {
                    C1777c next = it.next();
                    if (next.mo18056b().equals(uuid)) {
                        next.mo18014a(requestCode, resultCode, objArr);
                        z = true;
                    }
                }
                if (!z) {
                    LogUtil.C2630a aVar = f7416t;
                    LogUtil.m15952c(aVar, "not find " + uuid + "Listener,  resultCode:  " + requestCode + ", " + resultCode);
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.a$b */
    /* compiled from: CamIntentTask */
    public static class C1776b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f7435a;

        public C1776b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f7435a, false, AudioParams.DEFAULT_FRAME_SIZE, new Class[]{Message.class}, Void.TYPE).isSupported) {
                super.handleMessage(message);
                if (message.what == 1) {
                    CameraOptTask.m8418v();
                }
            }
        }
    }
}
