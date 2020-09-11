package com.meizu.media.camera.stereobokeh;

import android.hardware.Camera;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.mediatek.mmsdk.BaseParameters;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.utils.reflect.SystemProperties;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.meizu.media.camera.stereobokeh.a */
public class MmsdkCallbackData {

    /* renamed from: a */
    public static ChangeQuickRedirect f12195a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f12196b = new LogUtil.C2630a("MmsdkCallbackData");

    /* renamed from: c */
    private static int f12197c = SystemProperties.getInt("camera.callback.enable", 0).intValue();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Queue<Camera.PictureCallback> f12198d = new LinkedBlockingQueue();

    /* renamed from: e */
    private HashMap<String, String> f12199e;

    /* renamed from: f */
    private ImageReader f12200f;

    /* renamed from: g */
    private ImageReader f12201g;

    /* renamed from: h */
    private ImageReader f12202h;

    /* renamed from: i */
    private ImageReader f12203i;

    /* renamed from: j */
    private ImageReader f12204j;

    /* renamed from: k */
    private ImageReader f12205k;

    /* renamed from: l */
    private ImageReader f12206l;

    /* renamed from: m */
    private HandlerThread f12207m;

    /* renamed from: n */
    private ImageReader.OnImageAvailableListener f12208n = new ImageReader.OnImageAvailableListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12215a;

        public void onImageAvailable(ImageReader imageReader) {
            byte[] a;
            Camera.PictureCallback pictureCallback;
            if (!PatchProxy.proxy(new Object[]{imageReader}, this, f12215a, false, 6233, new Class[]{ImageReader.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a b = MmsdkCallbackData.f12196b;
                LogUtil.m15942a(b, "mBokehListener imageAvailable reader = " + imageReader);
                if (imageReader != null && (a = MmsdkCallbackData.this.m13580a(imageReader.acquireNextImage())) != null && (pictureCallback = (Camera.PictureCallback) MmsdkCallbackData.this.f12198d.poll()) != null) {
                    pictureCallback.onPictureTaken(a, (Camera) null);
                }
            }
        }
    };

    /* renamed from: o */
    private ImageReader.OnImageAvailableListener f12209o = new ImageReader.OnImageAvailableListener() {
        public void onImageAvailable(ImageReader imageReader) {
        }
    };

    /* renamed from: p */
    private ImageReader.OnImageAvailableListener f12210p = new ImageReader.OnImageAvailableListener() {
        public void onImageAvailable(ImageReader imageReader) {
        }
    };

    /* renamed from: q */
    private ImageReader.OnImageAvailableListener f12211q = new ImageReader.OnImageAvailableListener() {
        public void onImageAvailable(ImageReader imageReader) {
        }
    };

    /* renamed from: r */
    private ImageReader.OnImageAvailableListener f12212r = new ImageReader.OnImageAvailableListener() {
        public void onImageAvailable(ImageReader imageReader) {
        }
    };

    /* renamed from: s */
    private ImageReader.OnImageAvailableListener f12213s = new ImageReader.OnImageAvailableListener() {
        public void onImageAvailable(ImageReader imageReader) {
        }
    };

    /* renamed from: t */
    private ImageReader.OnImageAvailableListener f12214t = new ImageReader.OnImageAvailableListener() {
        public void onImageAvailable(ImageReader imageReader) {
        }
    };

    /* renamed from: a */
    public void mo21446a(Camera.PictureCallback pictureCallback) {
        if (!PatchProxy.proxy(new Object[]{pictureCallback}, this, f12195a, false, 6228, new Class[]{Camera.PictureCallback.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f12196b;
            LogUtil.m15942a(aVar, "setJpegListener " + pictureCallback);
            this.f12198d.add(pictureCallback);
        }
    }

    /* renamed from: a */
    public void mo21445a() {
        if (!PatchProxy.proxy(new Object[0], this, f12195a, false, 6229, new Class[0], Void.TYPE).isSupported) {
            m13583c();
            if (this.f12198d != null) {
                this.f12198d.clear();
            }
            if (this.f12207m != null && this.f12207m.isAlive()) {
                this.f12207m.quit();
                this.f12207m = null;
            }
        }
    }

    /* renamed from: a */
    public List<Surface> mo21444a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str) {
        ChangeQuickRedirect changeQuickRedirect = f12195a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{hashMap, hashMap2, str}, this, changeQuickRedirect, false, 6230, new Class[]{HashMap.class, HashMap.class, String.class}, List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        this.f12199e = hashMap2;
        ArrayList arrayList = new ArrayList();
        int parseInt = Integer.parseInt(hashMap.get(BaseParameters.KEY_PICTURE_SIZE));
        m13583c();
        if (this.f12207m == null) {
            this.f12207m = new HandlerThread("ImageBufferListener");
            this.f12207m.start();
        }
        Looper looper = this.f12207m.getLooper();
        if (looper != null) {
            Handler handler = new Handler(looper);
            if (str.contains("ci")) {
                this.f12201g = ImageReader.newInstance(parseInt, 1, 256, 1);
                this.f12201g.setOnImageAvailableListener(this.f12214t, handler);
                arrayList.add(this.f12201g.getSurface());
            }
            if (str.contains(NotificationStyle.BANNER_IMAGE_URL)) {
                this.f12200f = ImageReader.newInstance(parseInt, 1, 256, 1);
                this.f12200f.setOnImageAvailableListener(this.f12208n, handler);
                arrayList.add(this.f12200f.getSurface());
            }
            if (str.contains("mbd")) {
                this.f12205k = ImageReader.newInstance(Integer.parseInt(hashMap.get("stereo-depth-size")), 1, 256, 1);
                this.f12205k.setOnImageAvailableListener(this.f12212r, handler);
                arrayList.add(this.f12205k.getSurface());
            }
            if (str.contains("mdb")) {
                this.f12204j = ImageReader.newInstance(Integer.parseInt(hashMap.get("stereo-n3d-size")), 1, 256, 1);
                this.f12204j.setOnImageAvailableListener(this.f12211q, handler);
                arrayList.add(this.f12204j.getSurface());
            }
            if (str.contains("mbm")) {
                this.f12202h = ImageReader.newInstance(Integer.parseInt(hashMap.get("stereo-extra-size")), 1, 256, 1);
                this.f12202h.setOnImageAvailableListener(this.f12209o, handler);
                arrayList.add(this.f12202h.getSurface());
            }
            if (str.contains("mdw")) {
                this.f12206l = ImageReader.newInstance(Integer.parseInt(hashMap.get("stereo-depth-size")), 1, 256, 1);
                this.f12206l.setOnImageAvailableListener(this.f12213s, handler);
                arrayList.add(this.f12206l.getSurface());
            }
            if (str.contains("ldc")) {
                this.f12203i = ImageReader.newInstance(Integer.parseInt(hashMap.get("stereo-ldc-size")), 1, 256, 1);
                this.f12203i.setOnImageAvailableListener(this.f12210p, handler);
                arrayList.add(this.f12203i.getSurface());
            }
            LogUtil.C2630a aVar = f12196b;
            LogUtil.m15942a(aVar, "config surfaces, surfaces size = " + arrayList.size());
            return arrayList;
        }
        throw new IllegalArgumentException("why looper is null?");
    }

    /* renamed from: c */
    private void m13583c() {
        if (!PatchProxy.proxy(new Object[0], this, f12195a, false, 6231, new Class[0], Void.TYPE).isSupported) {
            if (this.f12200f != null) {
                this.f12200f.close();
                this.f12200f = null;
            }
            if (this.f12201g != null) {
                this.f12201g.close();
                this.f12201g = null;
            }
            if (this.f12202h != null) {
                this.f12202h.close();
                this.f12202h = null;
            }
            if (this.f12203i != null) {
                this.f12203i.close();
                this.f12203i = null;
            }
            if (this.f12204j != null) {
                this.f12204j.close();
                this.f12204j = null;
            }
            if (this.f12205k != null) {
                this.f12205k.close();
                this.f12205k = null;
            }
            if (this.f12206l != null) {
                this.f12206l.close();
                this.f12206l = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public byte[] m13580a(Image image) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{image}, this, f12195a, false, 6232, new Class[]{Image.class}, byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        buffer.rewind();
        image.close();
        return bArr;
    }
}
