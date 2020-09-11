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

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/MzModuleCoveredDetectionCallback;", "Lcom/meizu/camera/MeizuCamera$MeizuModuleCoveredDetectionCallback;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "(Lcom/meizu/media/camera/MzCamModule;)V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "onModuleCoveredDetection", "", "msgType", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.l */
public final class MzModuleCoveredDetectionCallback implements MeizuCamera.MeizuModuleCoveredDetectionCallback {

    /* renamed from: a */
    public static ChangeQuickRedirect f10015a;

    /* renamed from: b */
    private final LogUtil.C2630a f10016b = new LogUtil.C2630a("CoveredDetectionCallback");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MzCamModule f10017c;

    public MzModuleCoveredDetectionCallback(@NotNull MzCamModule mzCamModule) {
        C3443i.m21155b(mzCamModule, "mCamModule");
        this.f10017c = mzCamModule;
    }

    public void onModuleCoveredDetection(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10015a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4459, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f10016b;
            LogUtil.m15942a(aVar, "onModuleCoveredDetection:" + i + ", mActivity = " + this.f10017c.mo18030aO());
            if (this.f10017c.mo18030aO() != null) {
                CameraActivity aO = this.f10017c.mo18030aO();
                if (aO == null) {
                    C3443i.m21151a();
                }
                aO.runOnUiThread(new C2063a(this, i));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.l$a */
    /* compiled from: MzModuleCoveredDetectionCallback.kt */
    static final class C2063a implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10018a;

        /* renamed from: b */
        final /* synthetic */ MzModuleCoveredDetectionCallback f10019b;

        /* renamed from: c */
        final /* synthetic */ int f10020c;

        C2063a(MzModuleCoveredDetectionCallback lVar, int i) {
            this.f10019b = lVar;
            this.f10020c = i;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f10018a, false, 4460, new Class[0], Void.TYPE).isSupported && this.f10019b.f10017c.mo18036aU() != null && this.f10019b.f10017c.mo17898aA()) {
                MzUIController aU = this.f10019b.f10017c.mo18036aU();
                if (aU == null) {
                    C3443i.m21151a();
                }
                aU.mo21572c(this.f10020c);
            }
        }
    }
}
