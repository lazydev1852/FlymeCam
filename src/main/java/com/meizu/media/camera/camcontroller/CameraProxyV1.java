package com.meizu.media.camera.camcontroller;

import android.hardware.Camera;
import android.os.Handler;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.TimingLoggerUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.camcontroller.e */
public class CameraProxyV1 extends CameraProxy<Camera> {

    /* renamed from: f */
    public static ChangeQuickRedirect f9126f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final LogUtil.C2630a f9127h = new LogUtil.C2630a("CameraProxyV1");

    /* renamed from: k */
    private static int f9128k = -1;

    /* renamed from: g */
    public final Object f9129g = new Object();

    /* renamed from: i */
    private Camera.Parameters f9130i;

    /* renamed from: j */
    private MeizuCamera f9131j;

    /* renamed from: l */
    private int f9132l = f9128k;

    /* renamed from: com.meizu.media.camera.camcontroller.e$a */
    /* compiled from: CameraProxyV1 */
    public interface C2017a {
        /* renamed from: a */
        void mo17710a(int i);
    }

    /* renamed from: com.meizu.media.camera.camcontroller.e$b */
    /* compiled from: CameraProxyV1 */
    public interface C2018b {
        /* renamed from: a */
        void mo19715a(byte[] bArr, CameraProxy dVar);
    }

    /* renamed from: com.meizu.media.camera.camcontroller.e$c */
    /* compiled from: CameraProxyV1 */
    public interface C2019c {
        /* renamed from: a */
        void mo19721a(CameraProxy dVar);
    }

    static {
        f9121e = Camera.getNumberOfCameras();
    }

    /* renamed from: com.meizu.media.camera.camcontroller.e$e */
    /* compiled from: CameraProxyV1 */
    private static class C2022e implements Camera.ShutterCallback {

        /* renamed from: a */
        public static ChangeQuickRedirect f9155a;

        /* renamed from: b */
        private final Handler f9156b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final C2019c f9157c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final CameraProxy f9158d;

        public C2022e(Handler handler, CameraProxy dVar, C2019c cVar) {
            this.f9156b = handler;
            this.f9158d = dVar;
            this.f9157c = cVar;
        }

        public void onShutter() {
            if (!PatchProxy.proxy(new Object[0], this, f9155a, false, 3240, new Class[0], Void.TYPE).isSupported && this.f9157c != null) {
                this.f9156b.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f9159a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f9159a, false, 3241, new Class[0], Void.TYPE).isSupported) {
                            C2022e.this.f9157c.mo19721a(C2022e.this.f9158d);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.meizu.media.camera.camcontroller.e$d */
    /* compiled from: CameraProxyV1 */
    private class C2020d implements Camera.PictureCallback {

        /* renamed from: a */
        public static ChangeQuickRedirect f9147a;

        /* renamed from: c */
        private final Handler f9149c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C2018b f9150d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final CameraProxy f9151e;

        public C2020d(Handler handler, CameraProxy dVar, C2018b bVar) {
            this.f9149c = handler;
            this.f9151e = dVar;
            this.f9150d = bVar;
            LogUtil.C2630a k = CameraProxyV1.f9127h;
            LogUtil.m15942a(k, "new PictureCallbackForward this:" + this);
        }

        public void onPictureTaken(final byte[] bArr, Camera camera) {
            Class[] clsArr = {byte[].class, Camera.class};
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f9147a, false, 3238, clsArr, Void.TYPE).isSupported) {
                this.f9149c.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f9152a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f9152a, false, 3239, new Class[0], Void.TYPE).isSupported) {
                            C2020d.this.f9150d.mo19715a(bArr, C2020d.this.f9151e);
                        }
                    }
                });
            }
        }
    }

    public CameraProxyV1(int i, Camera camera) {
        super(i, camera);
        if (DeviceHelper.f13838R && camera != null) {
            this.f9131j = MeizuCamera.open(i);
        }
        TimingLoggerUtil.m16032a("startUp", "openCameraFinish");
        LogUtil.C2630a aVar = f9127h;
        LogUtil.m15952c(aVar, "open camera :" + i + "  success");
    }

    /* renamed from: e */
    public void mo19739e() {
        if (!PatchProxy.proxy(new Object[0], this, f9126f, false, 3229, new Class[0], Void.TYPE).isSupported && mo19730a() != null) {
            synchronized (this.f9129g) {
                try {
                    this.f9130i = ((Camera) mo19730a()).getParameters();
                } catch (RuntimeException e) {
                    DeviceUtil.m16195a(e);
                }
            }
        }
    }

    /* renamed from: f */
    public Camera.Parameters mo19740f() {
        return this.f9130i;
    }

    /* renamed from: g */
    public MeizuCamera mo19741g() {
        return this.f9131j;
    }

    /* renamed from: h */
    public void mo19742h() {
        if (!PatchProxy.proxy(new Object[0], this, f9126f, false, 3230, new Class[0], Void.TYPE).isSupported && mo19730a() != null) {
            synchronized (this.f9129g) {
                ((Camera) mo19730a()).setParameters(this.f9130i);
                try {
                    this.f9130i = ((Camera) mo19730a()).getParameters();
                } catch (RuntimeException e) {
                    DeviceUtil.m16195a(e);
                }
            }
        }
    }

    /* renamed from: i */
    public void mo19743i() {
        if (!PatchProxy.proxy(new Object[0], this, f9126f, false, 3231, new Class[0], Void.TYPE).isSupported && mo19730a() != null) {
            ((Camera) mo19730a()).unlock();
        }
    }

    /* renamed from: j */
    public void mo19744j() {
        if (!PatchProxy.proxy(new Object[0], this, f9126f, false, 3232, new Class[0], Void.TYPE).isSupported && mo19730a() != null) {
            ((Camera) mo19730a()).lock();
        }
    }

    /* renamed from: a */
    public void mo19738a(Handler handler, C2019c cVar, C2018b bVar, C2018b bVar2, C2018b bVar3) {
        if (!PatchProxy.proxy(new Object[]{handler, cVar, bVar, bVar2, bVar3}, this, f9126f, false, 3233, new Class[]{Handler.class, C2019c.class, C2018b.class, C2018b.class, C2018b.class}, Void.TYPE).isSupported) {
            CameraController<T>.e i = CameraController.m8868g().mo19518i();
            final Handler handler2 = handler;
            final C2019c cVar2 = cVar;
            final C2018b bVar4 = bVar;
            final C2018b bVar5 = bVar2;
            final C2018b bVar6 = bVar3;
            i.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f9133a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f9133a, false, 3236, new Class[0], Void.TYPE).isSupported && CameraProxyV1.this.f9124c != null) {
                        try {
                            ((Camera) CameraProxyV1.this.f9124c).takePicture(new C2022e(handler2, CameraProxyV1.this, cVar2), new C2020d(handler2, CameraProxyV1.this, bVar4), new C2020d(handler2, CameraProxyV1.this, bVar5), new C2020d(handler2, CameraProxyV1.this, bVar6));
                        } catch (RuntimeException e) {
                            DeviceUtil.m16195a(e);
                        }
                    }
                }
            });
            i.mo19553a();
        }
    }

    /* renamed from: a */
    public void mo19737a(Handler handler, C2019c cVar, C2018b bVar, C2018b bVar2, Camera.PictureCallback pictureCallback) {
        if (!PatchProxy.proxy(new Object[]{handler, cVar, bVar, bVar2, pictureCallback}, this, f9126f, false, 3234, new Class[]{Handler.class, C2019c.class, C2018b.class, C2018b.class, Camera.PictureCallback.class}, Void.TYPE).isSupported) {
            CameraController<T>.e i = CameraController.m8868g().mo19518i();
            final Handler handler2 = handler;
            final C2019c cVar2 = cVar;
            final C2018b bVar3 = bVar;
            final C2018b bVar4 = bVar2;
            final Camera.PictureCallback pictureCallback2 = pictureCallback;
            i.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f9140a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f9140a, false, 3237, new Class[0], Void.TYPE).isSupported && CameraProxyV1.this.f9124c != null) {
                        try {
                            ((Camera) CameraProxyV1.this.f9124c).takePicture(new C2022e(handler2, CameraProxyV1.this, cVar2), new C2020d(handler2, CameraProxyV1.this, bVar3), new C2020d(handler2, CameraProxyV1.this, bVar4), pictureCallback2);
                        } catch (RuntimeException e) {
                            DeviceUtil.m16195a(e);
                        }
                    }
                }
            });
            i.mo19553a();
        }
    }

    /* renamed from: a */
    public void mo19736a(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2, Camera.PictureCallback pictureCallback3, MeizuCamera.MeizuCameraContinuousCallback meizuCameraContinuousCallback) throws RuntimeException {
        if (!PatchProxy.proxy(new Object[]{shutterCallback, pictureCallback, pictureCallback2, pictureCallback3, meizuCameraContinuousCallback}, this, f9126f, false, 3235, new Class[]{Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class, MeizuCamera.MeizuCameraContinuousCallback.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f9127h, "takeBurstPictureEx");
            if (CameraController.m8868g().mo19518i().getLooper().getThread() != Thread.currentThread()) {
                LogUtil.m15949b(f9127h, "take burst picture failed.");
                throw new IllegalThreadStateException("take burst picture need to work in MzCamera-Thread.");
            } else if (this.f9131j != null && this.f9124c != null) {
                this.f9131j.setMeizuCameraContinuousCallback(meizuCameraContinuousCallback);
                try {
                    ((Camera) this.f9124c).takePicture(shutterCallback, pictureCallback, pictureCallback2, pictureCallback3);
                } catch (RuntimeException e) {
                    LogUtil.m15949b(f9127h, "take burst picture failed.");
                    throw e;
                }
            }
        }
    }
}
