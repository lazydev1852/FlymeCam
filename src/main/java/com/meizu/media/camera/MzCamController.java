package com.meizu.media.camera;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.filter.MzDynamicFilterManager;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.media.camera.views.ShutterButton;
import com.meizu.savior.ChangeQuickRedirect;

public interface MzCamController extends ShutterButton.C2727a {

    public enum ModuleState {
        IDLE,
        SWITCHING_MODE,
        SWITCHING_CAMERA;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    /* renamed from: A */
    void mo17852A();

    /* renamed from: B */
    void mo17853B();

    /* renamed from: C */
    void mo17854C();

    /* renamed from: D */
    void mo17855D();

    /* renamed from: E */
    void mo17856E();

    /* renamed from: F */
    void mo17857F();

    /* renamed from: G */
    void mo17858G();

    /* renamed from: H */
    boolean mo17859H();

    /* renamed from: I */
    boolean mo17860I();

    /* renamed from: J */
    void mo17861J();

    /* renamed from: K */
    boolean mo17862K();

    /* renamed from: L */
    boolean mo17863L();

    /* renamed from: M */
    boolean mo17864M();

    /* renamed from: N */
    boolean mo17865N();

    /* renamed from: O */
    void mo17866O();

    /* renamed from: P */
    void mo17867P();

    /* renamed from: Q */
    void mo17868Q();

    /* renamed from: R */
    void mo17869R();

    /* renamed from: S */
    void mo17870S();

    /* renamed from: T */
    int mo17871T();

    /* renamed from: U */
    boolean mo17872U();

    /* renamed from: V */
    boolean mo17873V();

    /* renamed from: W */
    boolean mo17874W();

    /* renamed from: X */
    ModuleState mo17875X();

    /* renamed from: Y */
    void mo17876Y();

    /* renamed from: Z */
    boolean mo17877Z();

    /* renamed from: a */
    void mo17878a(int i);

    /* renamed from: a */
    void mo17879a(int i, int i2, int i3, RectF rectF, boolean z);

    /* renamed from: a */
    void mo17880a(int i, boolean z, boolean z2);

    /* renamed from: a */
    void mo17881a(long j);

    /* renamed from: a */
    void mo17882a(Rect rect);

    /* renamed from: a */
    void mo17883a(MotionEvent motionEvent);

    /* renamed from: a */
    void mo17884a(View view, int i, int i2);

    /* renamed from: a */
    void mo17885a(View view, int i, int i2, boolean z);

    /* renamed from: a */
    void mo17886a(CameraController.FlashMode flashMode);

    /* renamed from: a */
    void mo17887a(CameraController.FlashMode flashMode, boolean z);

    /* renamed from: a */
    void mo17888a(CameraController.HdrMode hdrMode);

    /* renamed from: a */
    void mo17889a(RenderOverlay renderOverlay, PreviewGestures yVar);

    /* renamed from: a */
    void mo17890a(String str);

    /* renamed from: a */
    void mo17891a(boolean z, int i);

    /* renamed from: a */
    void mo17892a(boolean z, int i, float f, PathInterpolator pathInterpolator);

    /* renamed from: a */
    void mo17893a(boolean z, AnimatorListenerAdapter animatorListenerAdapter);

    /* renamed from: a */
    void mo17894a(boolean z, boolean z2);

    /* renamed from: a */
    void mo17895a(byte[] bArr);

    /* renamed from: a */
    void mo17896a(CameraController.C1880f[] fVarArr);

    /* renamed from: a */
    boolean mo17897a(int i, int i2);

    /* renamed from: aA */
    boolean mo17898aA();

    /* renamed from: aB */
    void mo17899aB();

    /* renamed from: aC */
    boolean mo17900aC();

    /* renamed from: aD */
    boolean mo17901aD();

    /* renamed from: aE */
    ComboPreferences mo17902aE();

    /* renamed from: aF */
    MzDynamicFilterManager mo17903aF();

    /* renamed from: aa */
    boolean mo17904aa();

    /* renamed from: ab */
    void mo17905ab();

    /* renamed from: ac */
    void mo17906ac();

    /* renamed from: ad */
    boolean mo17907ad();

    /* renamed from: ae */
    boolean mo17908ae();

    /* renamed from: af */
    void mo17909af();

    /* renamed from: ag */
    boolean mo17910ag();

    /* renamed from: ah */
    void mo17911ah();

    /* renamed from: ai */
    void mo17912ai();

    /* renamed from: aj */
    boolean mo17913aj();

    /* renamed from: ak */
    FocusOverlayManager mo17914ak();

    /* renamed from: al */
    boolean mo17915al();

    /* renamed from: am */
    boolean mo17916am();

    /* renamed from: an */
    void mo17917an();

    /* renamed from: ao */
    void mo17918ao();

    /* renamed from: ap */
    void mo17919ap();

    /* renamed from: aq */
    long mo17920aq();

    /* renamed from: ar */
    boolean mo17921ar();

    /* renamed from: as */
    boolean mo17922as();

    /* renamed from: at */
    void mo17923at();

    /* renamed from: au */
    boolean mo17924au();

    /* renamed from: av */
    boolean mo17925av();

    /* renamed from: aw */
    boolean mo17926aw();

    /* renamed from: ax */
    boolean mo17927ax();

    /* renamed from: ay */
    boolean mo17928ay();

    /* renamed from: az */
    void mo17929az();

    /* renamed from: b */
    int mo17930b(int i);

    /* renamed from: b */
    void mo17931b(boolean z, int i);

    /* renamed from: b */
    void mo17932b(boolean z, boolean z2);

    /* renamed from: b */
    void mo17933b(boolean... zArr);

    /* renamed from: c */
    void mo17934c(int i);

    /* renamed from: c */
    void mo17935c(boolean z);

    /* renamed from: d */
    void mo17936d(int i);

    /* renamed from: d */
    void mo17937d(boolean z);

    /* renamed from: e */
    void mo17938e(int i);

    /* renamed from: e */
    void mo17939e(boolean z);

    /* renamed from: f */
    void mo17940f(int i);

    /* renamed from: f */
    void mo17941f(boolean z);

    /* renamed from: g */
    void mo17942g(int i);

    /* renamed from: g */
    void mo17943g(boolean z);

    /* renamed from: h */
    void mo17944h(int i);

    /* renamed from: h */
    void mo17945h(boolean z);

    /* renamed from: i */
    void mo17946i(boolean z);

    /* renamed from: j */
    void mo17947j(boolean z);

    /* renamed from: k */
    void mo17948k(boolean z);

    /* renamed from: l */
    void mo17949l(boolean z);

    /* renamed from: m */
    void mo17950m(boolean z);

    /* renamed from: n */
    void mo17951n(boolean z);

    /* renamed from: o */
    void mo17952o(boolean z);

    /* renamed from: p */
    void mo17953p(boolean z);

    /* renamed from: q */
    void mo17954q(boolean z);

    /* renamed from: r */
    void mo17955r(boolean z);

    /* renamed from: s */
    CameraController.FlashMode mo17956s();

    /* renamed from: w */
    void mo17957w();

    /* renamed from: x */
    boolean mo17958x();

    /* renamed from: y */
    boolean mo17959y();

    /* renamed from: z */
    void mo17960z();
}
