package com.meizu.media.camera.mode;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.view.Surface;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.app.LocationManager;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.p077ui.MzCamUI;

/* renamed from: com.meizu.media.camera.mode.h */
public interface CameraModeListener {
    /* renamed from: H */
    boolean mo17859H();

    /* renamed from: V */
    boolean mo17873V();

    /* renamed from: a */
    void mo17997a(Bitmap bitmap, int i, int i2);

    /* renamed from: a */
    void mo18017a(byte[] bArr, int i, int i2, int i3);

    /* renamed from: aE */
    ComboPreferences mo17902aE();

    /* renamed from: ag */
    boolean mo17910ag();

    /* renamed from: aj */
    void mo18051aj(boolean z);

    /* renamed from: ak */
    FocusOverlayManager mo17914ak();

    /* renamed from: ak */
    void mo18052ak(boolean z);

    /* renamed from: al */
    void mo18053al(boolean z);

    /* renamed from: am */
    void mo18054am(boolean z);

    /* renamed from: an */
    void mo18055an(boolean z);

    /* renamed from: aw */
    boolean mo17926aw();

    /* renamed from: b */
    void mo18060b(int i, Intent intent);

    /* renamed from: b */
    void mo18064b(Surface surface);

    /* renamed from: c */
    SurfaceTexture mo18119c();

    /* renamed from: c */
    void mo18122c(boolean... zArr);

    /* renamed from: d */
    void mo17936d(int i);

    /* renamed from: d */
    void mo18175d(long j);

    /* renamed from: d */
    boolean mo18176d();

    /* renamed from: dF */
    void mo18182dF();

    /* renamed from: dG */
    void mo18183dG();

    /* renamed from: dH */
    AudioManager mo18184dH();

    /* renamed from: dI */
    boolean mo18185dI();

    /* renamed from: dJ */
    long mo18186dJ();

    /* renamed from: dK */
    ContentResolver mo18187dK();

    /* renamed from: dL */
    Handler mo18188dL();

    /* renamed from: dM */
    CameraController.HdrMode mo18189dM();

    /* renamed from: dN */
    boolean mo18190dN();

    /* renamed from: dO */
    boolean mo18191dO();

    /* renamed from: dP */
    LocationManager mo18192dP();

    /* renamed from: dQ */
    MediaSaveService.C1639d mo18193dQ();

    /* renamed from: dR */
    int mo18194dR();

    /* renamed from: dS */
    MzCamParamsManager mo18195dS();

    /* renamed from: dT */
    boolean mo18196dT();

    /* renamed from: dU */
    long mo18197dU();

    /* renamed from: dV */
    int mo18198dV();

    /* renamed from: dW */
    boolean mo18199dW();

    /* renamed from: dX */
    boolean mo18200dX();

    /* renamed from: dY */
    boolean mo18201dY();

    /* renamed from: dZ */
    void mo18202dZ();

    /* renamed from: di */
    int mo18211di();

    /* renamed from: dj */
    int mo18212dj();

    /* renamed from: dk */
    void mo18213dk();

    /* renamed from: ea */
    void mo18230ea();

    /* renamed from: eb */
    void mo18231eb();

    /* renamed from: ec */
    void mo18232ec();

    /* renamed from: ed */
    void mo18233ed();

    /* renamed from: ee */
    void mo18234ee();

    /* renamed from: f */
    SurfaceTexture mo18236f();

    /* renamed from: o */
    void mo18251o();

    /* renamed from: p */
    void mo18256p();

    /* renamed from: u */
    MzCamUI mo18267u();

    /* renamed from: x */
    void mo18275x(int i);

    /* renamed from: y */
    void mo18277y(int i);
}
