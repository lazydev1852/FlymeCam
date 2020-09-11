package com.meizu.media.camera.mode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Surface;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.List;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.f */
public abstract class CameraMode {

    /* renamed from: a */
    private static final LogUtil.C2630a f10782a = new LogUtil.C2630a("CameraMode");

    /* renamed from: h */
    public static ChangeQuickRedirect f10783h;

    /* renamed from: b */
    private final CameraModeListener f10784b;

    /* renamed from: c */
    private final MzCamParamsManager f10785c;

    /* renamed from: d */
    private boolean f10786d = false;

    /* renamed from: i */
    protected CameraActivity f10787i;

    /* renamed from: j */
    protected MzUIController f10788j;

    /* renamed from: k */
    protected CameraModeType.ModeType f10789k;

    /* renamed from: A */
    public abstract int mo20377A();

    /* renamed from: C */
    public void mo20379C() {
    }

    /* renamed from: D */
    public void mo20380D() {
    }

    /* renamed from: E */
    public void mo20381E() {
    }

    /* renamed from: F */
    public void mo20382F() {
    }

    /* renamed from: H */
    public void mo20383H() {
    }

    /* renamed from: I */
    public void mo20384I() {
    }

    /* renamed from: J */
    public void mo20385J() {
    }

    /* renamed from: W */
    public void mo20544W() {
    }

    /* renamed from: X */
    public void mo20449X() {
    }

    /* renamed from: Y */
    public void mo20450Y() {
    }

    /* renamed from: a */
    public Bitmap mo17987a(Bitmap bitmap, Point[] pointArr) {
        return null;
    }

    /* renamed from: a */
    public void mo20496a() {
    }

    /* renamed from: a */
    public void mo20452a(float f) {
    }

    /* renamed from: a */
    public void mo20386a(int i) {
    }

    /* renamed from: a */
    public void mo20511a(int i, int i2, Intent intent) {
    }

    /* renamed from: a */
    public void mo20545a(Bundle bundle) {
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
    }

    /* renamed from: a */
    public void mo20546a(CameraController.C1880f[] fVarArr, int i, boolean z, Rect rect) {
    }

    /* renamed from: a */
    public abstract boolean mo20394a(UUID uuid);

    /* renamed from: aa */
    public void mo20548aa() {
    }

    /* renamed from: ac */
    public boolean mo20549ac() {
        return true;
    }

    /* renamed from: ad */
    public void mo20550ad() {
    }

    /* renamed from: ae */
    public boolean mo20458ae() {
        return true;
    }

    /* renamed from: af */
    public boolean mo20551af() {
        return false;
    }

    /* renamed from: ag */
    public void mo20552ag() {
    }

    /* renamed from: ai */
    public List<Surface> mo20554ai() {
        return null;
    }

    /* renamed from: b */
    public void mo20516b(int i) {
    }

    /* renamed from: b */
    public void mo20555b(Bundle bundle) {
    }

    /* renamed from: b */
    public void mo20517b(boolean z) {
    }

    /* renamed from: c */
    public void mo20519c(int i) {
    }

    /* renamed from: c */
    public void mo20463c(boolean z) {
    }

    /* renamed from: c_ */
    public boolean mo20464c_() {
        return true;
    }

    /* renamed from: d_ */
    public void mo20490d_() {
    }

    /* renamed from: e */
    public List<Surface> mo20401e() {
        return null;
    }

    /* renamed from: e */
    public void mo20556e(int i) {
    }

    /* renamed from: f_ */
    public void mo20402f_() {
    }

    /* renamed from: g_ */
    public abstract CameraModeType.ModeType mo20403g_();

    /* renamed from: h_ */
    public abstract void mo20404h_();

    /* renamed from: i_ */
    public abstract void mo20405i_();

    /* renamed from: j_ */
    public abstract void mo20406j_();

    /* renamed from: k_ */
    public void mo20407k_() {
    }

    /* renamed from: l */
    public void mo20408l() {
    }

    /* renamed from: l_ */
    public boolean mo20409l_() {
        return false;
    }

    /* renamed from: m */
    public boolean mo20410m() {
        return false;
    }

    /* renamed from: m_ */
    public void mo20492m_() {
    }

    /* renamed from: n */
    public abstract boolean mo20411n();

    /* renamed from: o */
    public void mo20412o() {
    }

    /* renamed from: p */
    public boolean mo20413p() {
        return false;
    }

    /* renamed from: t */
    public abstract boolean mo20417t();

    /* renamed from: u */
    public abstract boolean mo20418u();

    /* renamed from: v */
    public abstract boolean mo20419v();

    /* renamed from: w */
    public abstract boolean mo20420w();

    /* renamed from: x */
    public abstract boolean mo20421x();

    /* renamed from: y */
    public abstract String mo20422y();

    /* renamed from: z */
    public abstract CameraController.FocusMode mo20423z();

    public CameraMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        this.f10788j = uVar;
        this.f10787i = cameraActivity;
        this.f10784b = hVar;
        this.f10788j = uVar;
        this.f10785c = lVar;
        this.f10789k = modeType;
    }

    /* renamed from: a */
    public void mo20387a(MzUIController uVar) {
        this.f10788j = uVar;
    }

    /* renamed from: R */
    public final CameraModeListener mo20539R() {
        return this.f10784b;
    }

    /* renamed from: S */
    public final CameraActivity mo20540S() {
        return this.f10787i;
    }

    /* renamed from: T */
    public final MzCamParamsManager mo20541T() {
        return this.f10785c;
    }

    /* renamed from: U */
    public final MzUIController mo20542U() {
        return this.f10788j;
    }

    /* renamed from: V */
    public int mo20543V() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10783h, false, 4691, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        return CameraModeType.m10962e(mo20403g_());
    }

    /* renamed from: a */
    public boolean mo20547a(CameraModeType.ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, this, f10783h, false, 4692, new Class[]{CameraModeType.ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return mo20403g_().equals(modeType);
    }

    /* renamed from: Z */
    public void mo20451Z() {
        if (!PatchProxy.proxy(new Object[0], this, f10783h, false, 4693, new Class[0], Void.TYPE).isSupported) {
            this.f10788j.mo21502Y();
        }
    }

    /* renamed from: ab */
    public void mo20457ab() {
        if (!PatchProxy.proxy(new Object[0], this, f10783h, false, 4694, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10782a;
            LogUtil.m15952c(aVar, "onModeReady(" + mo20403g_() + ")");
        }
    }

    /* renamed from: ah */
    public void mo20553ah() {
        this.f10787i = null;
    }

    /* renamed from: a */
    public Point[] mo18021a(Bitmap bitmap) {
        return new Point[0];
    }
}
