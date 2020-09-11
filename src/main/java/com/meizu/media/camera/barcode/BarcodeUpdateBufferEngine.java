package com.meizu.media.camera.barcode;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.mediatek.util.MtkPatterns;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0012R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo27294d2 = {"Lcom/meizu/media/camera/barcode/BarcodeUpdateBufferEngine;", "", "mListener", "Lcom/meizu/media/camera/barcode/BarcodeUpdateBufferEngine$UpdateBufferListener;", "(Lcom/meizu/media/camera/barcode/BarcodeUpdateBufferEngine$UpdateBufferListener;)V", "<set-?>", "", "isEngineStarted", "()Z", "mCancelTaskMode", "Lcom/meizu/media/camera/mode/CameraModeType$ModeType;", "mHandler", "Landroid/os/Handler;", "mHandlerThread", "Landroid/os/HandlerThread;", "mSyncObject", "mThreadInitiated", "cancel", "", "currentMode", "initThread", "quit", "release", "start", "Companion", "UpdateBufferListener", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.barcode.a */
public final class BarcodeUpdateBufferEngine {

    /* renamed from: a */
    public static ChangeQuickRedirect f8031a;

    /* renamed from: b */
    public static final C1843a f8032b = new C1843a((DefaultConstructorMarker) null);

    /* renamed from: j */
    private static final LogUtil.C2630a f8033j = new LogUtil.C2630a("BarcodeBufferEngine");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f8034c;

    /* renamed from: d */
    private HandlerThread f8035d;

    /* renamed from: e */
    private final Object f8036e = new Object();

    /* renamed from: f */
    private CameraModeType.ModeType f8037f;

    /* renamed from: g */
    private boolean f8038g;

    /* renamed from: h */
    private boolean f8039h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C1844b f8040i;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo27294d2 = {"Lcom/meizu/media/camera/barcode/BarcodeUpdateBufferEngine$UpdateBufferListener;", "", "cancelUpdate", "", "updateBuffer", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.barcode.a$b */
    /* compiled from: BarcodeUpdateBufferEngine.kt */
    public interface C1844b {
        /* renamed from: a */
        void mo19075a();

        /* renamed from: b */
        void mo19076b();
    }

    public BarcodeUpdateBufferEngine(@NotNull C1844b bVar) {
        C3443i.m21155b(bVar, "mListener");
        this.f8040i = bVar;
    }

    /* renamed from: a */
    public final boolean mo19071a() {
        return this.f8038g;
    }

    /* renamed from: b */
    public final void mo19072b() {
        if (!PatchProxy.proxy(new Object[0], this, f8031a, false, 2564, new Class[0], Void.TYPE).isSupported && !this.f8039h) {
            LogUtil.m15942a(f8033j, "initThread");
            this.f8035d = new HandlerThread("barcode in auto");
            HandlerThread handlerThread = this.f8035d;
            if (handlerThread == null) {
                C3443i.m21151a();
            }
            handlerThread.start();
            HandlerThread handlerThread2 = this.f8035d;
            if (handlerThread2 == null) {
                C3443i.m21151a();
            }
            this.f8034c = new C1845c(this, handlerThread2.getLooper());
            this.f8039h = true;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo27294d2 = {"com/meizu/media/camera/barcode/BarcodeUpdateBufferEngine$initThread$1", "Landroid/os/Handler;", "dispatchMessage", "", "msg", "Landroid/os/Message;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.barcode.a$c */
    /* compiled from: BarcodeUpdateBufferEngine.kt */
    public static final class C1845c extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f8041a;

        /* renamed from: b */
        final /* synthetic */ BarcodeUpdateBufferEngine f8042b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1845c(BarcodeUpdateBufferEngine aVar, Looper looper) {
            super(looper);
            this.f8042b = aVar;
        }

        public void dispatchMessage(@NotNull Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f8041a, false, 2569, new Class[]{Message.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(message, NotificationCompat.CATEGORY_MESSAGE);
                switch (message.what) {
                    case 0:
                        this.f8042b.f8040i.mo19075a();
                        if (this.f8042b.f8034c != null) {
                            Handler b = this.f8042b.f8034c;
                            if (b == null) {
                                C3443i.m21151a();
                            }
                            b.removeMessages(0);
                            Handler b2 = this.f8042b.f8034c;
                            if (b2 == null) {
                                C3443i.m21151a();
                            }
                            b2.sendEmptyMessageDelayed(0, (long) 500);
                            return;
                        }
                        return;
                    case 1:
                        this.f8042b.f8040i.mo19076b();
                        if (this.f8042b.f8034c != null) {
                            Handler b3 = this.f8042b.f8034c;
                            if (b3 == null) {
                                C3443i.m21151a();
                            }
                            b3.removeMessages(0);
                            return;
                        }
                        return;
                    case 2:
                        if (this.f8042b.f8034c != null) {
                            Handler b4 = this.f8042b.f8034c;
                            if (b4 == null) {
                                C3443i.m21151a();
                            }
                            b4.removeMessages(0);
                        }
                        this.f8042b.m8516e();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: c */
    public final void mo19073c() {
        if (!PatchProxy.proxy(new Object[0], this, f8031a, false, 2565, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f8033j, MtkPatterns.KEY_URLDATA_START);
            synchronized (this.f8036e) {
                if (CameraModeType.ModeType.PANORAMA == this.f8037f) {
                    Handler handler = this.f8034c;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(0, 3000);
                    }
                } else {
                    Handler handler2 = this.f8034c;
                    if (handler2 != null) {
                        handler2.sendEmptyMessage(0);
                    }
                }
                this.f8038g = true;
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: a */
    public final void mo19070a(@NotNull CameraModeType.ModeType modeType) {
        if (!PatchProxy.proxy(new Object[]{modeType}, this, f8031a, false, 2566, new Class[]{CameraModeType.ModeType.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(modeType, "currentMode");
            LogUtil.C2630a aVar = f8033j;
            LogUtil.m15942a(aVar, "cancel, " + modeType);
            synchronized (this.f8036e) {
                this.f8037f = modeType;
                Handler handler = this.f8034c;
                if (handler != null) {
                    handler.sendEmptyMessage(1);
                }
                this.f8038g = false;
                Unit tVar = Unit.f18749a;
            }
        }
    }

    /* renamed from: d */
    public final void mo19074d() {
        Handler handler;
        if (!PatchProxy.proxy(new Object[0], this, f8031a, false, 2567, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f8033j, "release");
            if (this.f8039h) {
                this.f8037f = null;
                this.f8039h = false;
                if (this.f8034c != null && (handler = this.f8034c) != null) {
                    handler.sendEmptyMessage(2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m8516e() {
        if (!PatchProxy.proxy(new Object[0], this, f8031a, false, 2568, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f8033j, "quit");
            synchronized (this.f8036e) {
                this.f8037f = null;
                this.f8038g = false;
                this.f8040i.mo19076b();
                HandlerThread handlerThread = this.f8035d;
                if (handlerThread == null) {
                    C3443i.m21151a();
                }
                if (handlerThread.getLooper() != null) {
                    HandlerThread handlerThread2 = this.f8035d;
                    if (handlerThread2 == null) {
                        C3443i.m21151a();
                    }
                    handlerThread2.getLooper().quit();
                    this.f8034c = null;
                }
                Unit tVar = Unit.f18749a;
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo27294d2 = {"Lcom/meizu/media/camera/barcode/BarcodeUpdateBufferEngine$Companion;", "", "()V", "MSG_CANCEL", "", "MSG_QUIT", "MSG_UPDATE_BUFFER", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "UPDATE_BUFFER_INTERVAL", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.barcode.a$a */
    /* compiled from: BarcodeUpdateBufferEngine.kt */
    public static final class C1843a {
        private C1843a() {
        }

        public /* synthetic */ C1843a(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
