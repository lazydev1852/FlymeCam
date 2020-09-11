package com.meizu.media.camera.stereobokeh;

import android.content.Context;
import android.view.Surface;
import com.mediatek.mmsdk.BaseParameters;
import com.mediatek.mmsdk.CameraEffectHalException;
import com.mediatek.mmsdk.callback.MmsdkCallbackClient;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.stereobokeh.b */
public class MmsdkCallbackImpl {

    /* renamed from: a */
    public static ChangeQuickRedirect f12223a;

    /* renamed from: b */
    private static final LogUtil.C2630a f12224b = new LogUtil.C2630a("MmsdkCallbackImpl");

    /* renamed from: c */
    private MmsdkCallbackClient f12225c;

    /* renamed from: d */
    private BaseParameters f12226d;

    /* renamed from: e */
    private String f12227e;

    public MmsdkCallbackImpl(Context context) {
        LogUtil.C2630a aVar = f12224b;
        LogUtil.m15942a(aVar, "MmsdkCallbackImpl constructor" + this);
        this.f12225c = new MmsdkCallbackClient(context);
    }

    /* renamed from: a */
    public void mo21454a() {
        if (!PatchProxy.proxy(new Object[0], this, f12223a, false, 6235, new Class[0], Void.TYPE).isSupported) {
            try {
                this.f12225c.start();
            } catch (CameraEffectHalException e) {
                LogUtil.C2630a aVar = f12224b;
                LogUtil.m15949b(aVar, "start exception :" + e);
            }
        }
    }

    /* renamed from: b */
    public void mo21456b() {
        if (!PatchProxy.proxy(new Object[0], this, f12223a, false, 6236, new Class[0], Void.TYPE).isSupported) {
            try {
                this.f12225c.stop();
            } catch (CameraEffectHalException e) {
                LogUtil.C2630a aVar = f12224b;
                LogUtil.m15949b(aVar, "stop exception :" + e);
            }
        }
    }

    /* renamed from: a */
    public void mo21455a(List<Surface> list, String str) {
        Class[] clsArr = {List.class, String.class};
        if (!PatchProxy.proxy(new Object[]{list, str}, this, f12223a, false, 6237, clsArr, Void.TYPE).isSupported) {
            try {
                this.f12227e = str;
                this.f12225c.setOutputSurfaces(list, m13587c());
            } catch (CameraEffectHalException e) {
                LogUtil.C2630a aVar = f12224b;
                LogUtil.m15949b(aVar, "config surface exception :" + e);
            }
        }
    }

    /* renamed from: c */
    private List<BaseParameters> m13587c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12223a, false, 6238, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f12227e.contains("ci")) {
            this.f12226d = new BaseParameters();
            this.f12226d.set(BaseParameters.KEY_CALLBACK_MSG_TYPE, 21);
            arrayList.add(this.f12226d);
        }
        if (this.f12227e.contains(NotificationStyle.BANNER_IMAGE_URL)) {
            this.f12226d = new BaseParameters();
            this.f12226d.set(BaseParameters.KEY_CALLBACK_MSG_TYPE, 256);
            arrayList.add(this.f12226d);
        }
        if (this.f12227e.contains("mbd")) {
            this.f12226d = new BaseParameters();
            this.f12226d.set(BaseParameters.KEY_CALLBACK_MSG_TYPE, 20);
            arrayList.add(this.f12226d);
        }
        if (this.f12227e.contains("mdb")) {
            this.f12226d = new BaseParameters();
            this.f12226d.set(BaseParameters.KEY_CALLBACK_MSG_TYPE, 25);
            arrayList.add(this.f12226d);
        }
        if (this.f12227e.contains("mbm")) {
            this.f12226d = new BaseParameters();
            this.f12226d.set(BaseParameters.KEY_CALLBACK_MSG_TYPE, 18);
            arrayList.add(this.f12226d);
        }
        if (this.f12227e.contains("mdw")) {
            this.f12226d = new BaseParameters();
            this.f12226d.set(BaseParameters.KEY_CALLBACK_MSG_TYPE, 32);
            arrayList.add(this.f12226d);
        }
        if (this.f12227e.contains("ldc")) {
            this.f12226d = new BaseParameters();
            this.f12226d.set(BaseParameters.KEY_CALLBACK_MSG_TYPE, 22);
            arrayList.add(this.f12226d);
        }
        return arrayList;
    }
}
