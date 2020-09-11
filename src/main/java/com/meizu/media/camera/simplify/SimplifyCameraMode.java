package com.meizu.media.camera.simplify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Surface;
import com.meizu.media.camera.CameraSimplifyActivity;
import com.meizu.media.camera.MzSimplifyCamModule;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.List;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.simplify.m */
public abstract class SimplifyCameraMode {

    /* renamed from: a */
    private static final LogUtil.C2630a f12100a = new LogUtil.C2630a("CameraMode");

    /* renamed from: b */
    public static ChangeQuickRedirect f12101b;

    /* renamed from: c */
    protected CameraSimplifyActivity f12102c;

    /* renamed from: d */
    protected MzSimplifyUIController f12103d;

    /* renamed from: e */
    protected CameraModeType.ModeType f12104e;

    /* renamed from: f */
    private final MzSimplifyCamModule f12105f;

    /* renamed from: g */
    private final MzSimplifyCamParamsManager f12106g;

    /* renamed from: A */
    public void mo21369A() {
    }

    /* renamed from: C */
    public void mo21370C() {
    }

    /* renamed from: E */
    public void mo21372E() {
    }

    /* renamed from: G */
    public boolean mo21374G() {
        return true;
    }

    /* renamed from: H */
    public void mo21375H() {
    }

    /* renamed from: I */
    public boolean mo21376I() {
        return false;
    }

    /* renamed from: J */
    public boolean mo21377J() {
        return false;
    }

    /* renamed from: K */
    public void mo21378K() {
    }

    /* renamed from: L */
    public void mo21379L() {
    }

    /* renamed from: M */
    public boolean mo21380M() {
        return true;
    }

    /* renamed from: N */
    public boolean mo21381N() {
        return true;
    }

    /* renamed from: O */
    public boolean mo21382O() {
        return false;
    }

    /* renamed from: P */
    public void mo21383P() {
    }

    /* renamed from: Q */
    public void mo21384Q() {
    }

    /* renamed from: S */
    public boolean mo21386S() {
        return false;
    }

    /* renamed from: T */
    public void mo21387T() {
    }

    /* renamed from: U */
    public List<Surface> mo21388U() {
        return null;
    }

    /* renamed from: V */
    public void mo21389V() {
    }

    /* renamed from: a */
    public Bitmap mo21390a(Bitmap bitmap, Point[] pointArr) {
        return null;
    }

    /* renamed from: a */
    public void mo21391a(float f) {
    }

    /* renamed from: a */
    public void mo21347a(int i) {
    }

    /* renamed from: a */
    public void mo21392a(int i, int i2, Intent intent) {
    }

    /* renamed from: a */
    public void mo21393a(Bundle bundle) {
    }

    /* renamed from: a */
    public void mo21394a(boolean z) {
    }

    /* renamed from: a */
    public void mo21395a(CameraController.C1880f[] fVarArr, int i, boolean z, Rect rect) {
    }

    /* renamed from: a */
    public abstract boolean mo21349a(UUID uuid);

    /* renamed from: b */
    public void mo21350b() {
    }

    /* renamed from: b */
    public void mo21398b(int i) {
    }

    /* renamed from: b */
    public void mo21399b(Bundle bundle) {
    }

    /* renamed from: c */
    public abstract void mo21351c();

    /* renamed from: c */
    public void mo21400c(int i) {
    }

    /* renamed from: d */
    public abstract CameraModeType.ModeType mo21352d();

    /* renamed from: e */
    public abstract void mo21353e();

    /* renamed from: f */
    public abstract void mo21354f();

    /* renamed from: g */
    public void mo21355g() {
    }

    /* renamed from: h */
    public abstract boolean mo21356h();

    /* renamed from: i */
    public abstract boolean mo21357i();

    /* renamed from: j */
    public abstract boolean mo21358j();

    /* renamed from: k */
    public abstract boolean mo21359k();

    /* renamed from: l */
    public abstract boolean mo21360l();

    /* renamed from: m */
    public abstract String mo21361m();

    /* renamed from: n */
    public abstract CameraController.FocusMode mo21362n();

    /* renamed from: o */
    public abstract int mo21363o();

    /* renamed from: p */
    public void mo21364p() {
    }

    /* renamed from: q */
    public void mo21365q() {
    }

    /* renamed from: r */
    public void mo21366r() {
    }

    /* renamed from: s */
    public void mo21367s() {
    }

    /* renamed from: t */
    public void mo21368t() {
    }

    /* renamed from: z */
    public void mo21406z() {
    }

    public SimplifyCameraMode(CameraSimplifyActivity cameraSimplifyActivity, MzSimplifyCamParamsManager cVar, MzSimplifyUIController jVar, MzSimplifyCamModule mzSimplifyCamModule, CameraModeType.ModeType modeType) {
        this.f12103d = jVar;
        this.f12102c = cameraSimplifyActivity;
        this.f12105f = mzSimplifyCamModule;
        this.f12106g = cVar;
        this.f12104e = modeType;
    }

    /* renamed from: a */
    public void mo21348a(MzSimplifyUIController jVar) {
        this.f12103d = jVar;
    }

    /* renamed from: u */
    public final MzSimplifyCamModule mo21401u() {
        return this.f12105f;
    }

    /* renamed from: v */
    public final CameraSimplifyActivity mo21402v() {
        return this.f12102c;
    }

    /* renamed from: w */
    public final MzSimplifyCamParamsManager mo21403w() {
        return this.f12106g;
    }

    /* renamed from: x */
    public final MzSimplifyUIController mo21404x() {
        return this.f12103d;
    }

    /* renamed from: y */
    public int mo21405y() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12101b, false, 6128, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        return CameraModeType.m10962e(mo21352d());
    }

    /* renamed from: a */
    public boolean mo21396a(CameraModeType.ModeType modeType) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType}, this, f12101b, false, 6129, new Class[]{CameraModeType.ModeType.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return mo21352d().equals(modeType);
    }

    /* renamed from: D */
    public void mo21371D() {
        if (!PatchProxy.proxy(new Object[0], this, f12101b, false, 6130, new Class[0], Void.TYPE).isSupported) {
            this.f12103d.mo20904az();
        }
    }

    /* renamed from: F */
    public void mo21373F() {
        if (!PatchProxy.proxy(new Object[0], this, f12101b, false, 6131, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f12100a;
            LogUtil.m15952c(aVar, "onModeReady(" + mo21352d() + ")");
        }
    }

    /* renamed from: R */
    public void mo21385R() {
        this.f12102c = null;
    }

    /* renamed from: a */
    public Point[] mo21397a(Bitmap bitmap) {
        return new Point[0];
    }
}
