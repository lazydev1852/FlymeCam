package com.meizu.media.camera.p077ui;

import android.content.Context;
import com.baidu.p020ar.ARController;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/MzARController;", "", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "<set-?>", "Lcom/baidu/ar/ARController;", "mARController", "getMARController", "()Lcom/baidu/ar/ARController;", "getARController", "initARController", "", "context", "Landroid/content/Context;", "releaseARController", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.ui.c */
public final class MzARController {

    /* renamed from: a */
    public static ChangeQuickRedirect f12802a;

    /* renamed from: b */
    public static final MzARController f12803b = new MzARController();

    /* renamed from: c */
    private static final LogUtil.C2630a f12804c = new LogUtil.C2630a("MzARController");
    @Nullable

    /* renamed from: d */
    private static ARController f12805d;

    private MzARController() {
    }

    @Nullable
    /* renamed from: a */
    public final ARController mo21932a() {
        return f12805d;
    }

    /* renamed from: a */
    public final synchronized void mo21933a(@NotNull Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f12802a, false, 6306, new Class[]{Context.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(context, "context");
            LogUtil.m15952c(f12804c, "initARController");
            if (f12805d != null) {
                LogUtil.m15952c(f12804c, "release");
                ARController aRController = f12805d;
                if (aRController == null) {
                    C3443i.m21151a();
                }
                aRController.release();
                f12805d = null;
            }
            f12805d = new ARController(context);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo21934b() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0034 }
            com.meizu.savior.ChangeQuickRedirect r3 = f12802a     // Catch:{ all -> 0x0034 }
            r4 = 0
            r5 = 6307(0x18a3, float:8.838E-42)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0034 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0034 }
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0034 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0018
            monitor-exit(r8)
            return
        L_0x0018:
            com.baidu.ar.ARController r0 = f12805d     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0032
            com.meizu.media.camera.util.ac$a r0 = f12804c     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "release ARController"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)     // Catch:{ all -> 0x0034 }
            com.baidu.ar.ARController r0 = f12805d     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x002a
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x0034 }
        L_0x002a:
            r0.release()     // Catch:{ all -> 0x0034 }
            r0 = 0
            com.baidu.ar.ARController r0 = (com.baidu.p020ar.ARController) r0     // Catch:{ all -> 0x0034 }
            f12805d = r0     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r8)
            return
        L_0x0034:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p077ui.MzARController.mo21934b():void");
    }
}
