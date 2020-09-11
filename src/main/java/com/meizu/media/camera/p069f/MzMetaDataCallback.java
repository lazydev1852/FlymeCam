package com.meizu.media.camera.p069f;

import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/MzMetaDataCallback;", "Lcom/meizu/camera/MeizuCamera$MeizuMetaDataCallback;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "(Lcom/meizu/media/camera/MzCamModule;)V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "onMeizuMetaDataNotify", "", "type", "", "value", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.k */
public final class MzMetaDataCallback implements MeizuCamera.MeizuMetaDataCallback {

    /* renamed from: a */
    public static ChangeQuickRedirect f10008a;

    /* renamed from: b */
    private final LogUtil.C2630a f10009b = new LogUtil.C2630a("MzMetaDataCallback");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MzCamModule f10010c;

    public MzMetaDataCallback(@NotNull MzCamModule mzCamModule) {
        C3443i.m21155b(mzCamModule, "mCamModule");
        this.f10010c = mzCamModule;
    }

    public void onMeizuMetaDataNotify(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f10008a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4457, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f10009b;
            LogUtil.m15944a(aVar, "onMeizuMetaDataNotify: type = " + i + ", value = " + i2, true);
            CameraActivity aO = this.f10010c.mo18030aO();
            if (aO == null) {
                C3443i.m21151a();
            }
            aO.runOnUiThread(new C2062a(this, i, i2));
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.k$a */
    /* compiled from: MzMetaDataCallback.kt */
    static final class C2062a implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10011a;

        /* renamed from: b */
        final /* synthetic */ MzMetaDataCallback f10012b;

        /* renamed from: c */
        final /* synthetic */ int f10013c;

        /* renamed from: d */
        final /* synthetic */ int f10014d;

        C2062a(MzMetaDataCallback kVar, int i, int i2) {
            this.f10012b = kVar;
            this.f10013c = i;
            this.f10014d = i2;
        }

        public final void run() {
            MzUIController aU;
            if (!PatchProxy.proxy(new Object[0], this, f10011a, false, 4458, new Class[0], Void.TYPE).isSupported && (aU = this.f10012b.f10010c.mo18036aU()) != null) {
                aU.mo21507a(this.f10013c, this.f10014d);
            }
        }
    }
}
