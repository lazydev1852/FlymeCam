package com.meizu.media.camera;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.iflytek.business.speech.RecognitionListener;
import com.iflytek.business.speech.RecognizerResult;
import com.iflytek.business.speech.SpeechServiceUtil;
import com.mediatek.camcorder.CamcorderProfileEx;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.ac */
public class VoiceAssist {

    /* renamed from: a */
    public static ChangeQuickRedirect f7506a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final LogUtil.C2630a f7507c = new LogUtil.C2630a("VoiceAssist");

    /* renamed from: b */
    Handler f7508b = new Handler() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7526a;

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f7526a, false, 2246, new Class[]{Message.class}, Void.TYPE).isSupported) {
                switch (message.what) {
                    case 0:
                        boolean unused = VoiceAssist.this.f7517l = true;
                        return;
                    case 1:
                        VoiceAssist.this.f7519n.mo18235ef();
                        boolean unused2 = VoiceAssist.this.f7518m = false;
                        VoiceAssist.this.mo18764a(50);
                        return;
                    case 2:
                        LogUtil.C2630a c = VoiceAssist.f7507c;
                        LogUtil.m15952c(c, "error code = " + message.arg1);
                        boolean unused3 = VoiceAssist.this.f7518m = false;
                        VoiceAssist.this.mo18764a(300);
                        return;
                    case 3:
                        if (!VoiceAssist.this.f7517l) {
                            VoiceAssist.this.f7508b.sendEmptyMessageDelayed(3, 50);
                            return;
                        } else {
                            VoiceAssist.this.m7951d();
                            return;
                        }
                    case 4:
                        VoiceAssist.this.m7953e();
                        return;
                    default:
                        return;
                }
            }
        }
    };

    /* renamed from: d */
    private final int f7509d = 0;

    /* renamed from: e */
    private final int f7510e = 1;

    /* renamed from: f */
    private final int f7511f = 2;

    /* renamed from: g */
    private final int f7512g = 3;

    /* renamed from: h */
    private final int f7513h = 4;

    /* renamed from: i */
    private String f7514i = "ivw/voice_shutter.jet";
    /* access modifiers changed from: private */

    /* renamed from: j */
    public SpeechServiceUtil f7515j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Intent f7516k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f7517l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f7518m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C1790a f7519n;

    /* renamed from: o */
    private SpeechServiceUtil.C1035a f7520o = new SpeechServiceUtil.C1035a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7522a;

        /* renamed from: a */
        public void mo12940a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f7522a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, CamcorderProfileEx.SLOW_MOTION_HD_120FPS, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                LogUtil.C2630a c = VoiceAssist.f7507c;
                LogUtil.m15942a(c, "onSpeechInit " + i);
                try {
                    VoiceAssist.this.f7515j.mo12934a((RecognitionListener) VoiceAssist.this.f7521p, VoiceAssist.this.f7516k);
                } catch (IllegalArgumentException unused) {
                    LogUtil.m15949b(VoiceAssist.f7507c, "Speech service initialization failed...");
                }
            }
        }

        /* renamed from: a */
        public void mo12939a() {
            if (!PatchProxy.proxy(new Object[0], this, f7522a, false, CamcorderProfileEx.SLOW_MOTION_HD_180FPS, new Class[0], Void.TYPE).isSupported) {
                if (VoiceAssist.this.f7515j == null) {
                    LogUtil.m15949b(VoiceAssist.f7507c, "mService is null, but camera received this callback, something was wrong!");
                    return;
                }
                VoiceAssist.this.m7955f();
                VoiceAssist.this.f7515j.mo12935b();
                SpeechServiceUtil unused = VoiceAssist.this.f7515j = null;
                C1790a unused2 = VoiceAssist.this.f7519n = null;
                boolean unused3 = VoiceAssist.this.f7517l = false;
                LogUtil.m15949b(VoiceAssist.f7507c, "onSpeechUninit()");
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RecognitionListener.C1030a f7521p = new RecognitionListener.C1030a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7524a;

        /* renamed from: a */
        public void mo12915a() throws RemoteException {
        }

        /* renamed from: a */
        public void mo12917a(int i, int i2, int i3, Bundle bundle) throws RemoteException {
        }

        /* renamed from: a */
        public void mo12918a(int i, String str, int i2) throws RemoteException {
        }

        /* renamed from: a */
        public void mo12919a(Intent intent) throws RemoteException {
        }

        /* renamed from: a */
        public void mo12921a(byte[] bArr) throws RemoteException {
        }

        /* renamed from: b */
        public void mo12922b() throws RemoteException {
        }

        /* renamed from: b */
        public void mo12923b(int i) throws RemoteException {
        }

        /* renamed from: b */
        public void mo12924b(RecognizerResult recognizerResult) throws RemoteException {
        }

        /* renamed from: c */
        public void mo12925c() throws RemoteException {
        }

        /* renamed from: d */
        public void mo12927d() throws RemoteException {
        }

        /* renamed from: a */
        public void mo12916a(int i) throws RemoteException {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f7524a, false, 2243, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                LogUtil.C2630a c = VoiceAssist.f7507c;
                LogUtil.m15942a(c, "onInit, resultCode = " + i);
                VoiceAssist.this.f7508b.sendEmptyMessage(0);
            }
        }

        /* renamed from: c */
        public void mo12926c(int i) throws RemoteException {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f7524a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2244, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                LogUtil.m15942a(VoiceAssist.f7507c, "onError");
                Message.obtain(VoiceAssist.this.f7508b, 2, i, -1).sendToTarget();
            }
        }

        /* renamed from: a */
        public void mo12920a(RecognizerResult recognizerResult) throws RemoteException {
            if (!PatchProxy.proxy(new Object[]{recognizerResult}, this, f7524a, false, 2245, new Class[]{RecognizerResult.class}, Void.TYPE).isSupported) {
                LogUtil.C2630a c = VoiceAssist.f7507c;
                LogUtil.m15942a(c, "onResult=" + recognizerResult);
                VoiceAssist.this.f7508b.sendEmptyMessageDelayed(1, 200);
            }
        }
    };

    /* renamed from: com.meizu.media.camera.ac$a */
    /* compiled from: VoiceAssist */
    public interface C1790a {
        /* renamed from: ef */
        void mo18235ef();
    }

    public VoiceAssist(Context context, C1790a aVar) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        String[] strArr = {this.f7514i};
        bundle.putInt("engine_res_type", 259);
        bundle.putStringArray("ivw_files", strArr);
        intent.putExtra("engine_wake", bundle);
        intent.putExtra("service_log_enable", true);
        intent.putExtra("grammars_flush", true);
        this.f7516k = intent;
        this.f7515j = new SpeechServiceUtil(context, this.f7520o, intent);
        this.f7519n = aVar;
    }

    /* renamed from: a */
    public void mo18764a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f7506a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2235, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f7507c, "start listen");
            if (!this.f7518m && this.f7508b != null) {
                this.f7518m = true;
                this.f7508b.sendEmptyMessageDelayed(3, j);
            }
        }
    }

    /* renamed from: a */
    public void mo18763a() {
        if (!PatchProxy.proxy(new Object[0], this, f7506a, false, 2236, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f7507c, "stop listen");
            if (this.f7508b != null) {
                this.f7508b.removeMessages(3);
                this.f7508b.removeMessages(1);
                if (this.f7517l && this.f7518m) {
                    this.f7508b.sendEmptyMessage(4);
                    this.f7518m = false;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7951d() {
        if (!PatchProxy.proxy(new Object[0], this, f7506a, false, 2237, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f7507c, "start recognize");
            int[] iArr = {DeviceHelper.f13946bt};
            Intent intent = new Intent();
            intent.putExtra("ivw_cm", iArr);
            intent.putExtra("ivw_word_id", new int[]{0, 1});
            intent.putExtra("yudian_engine_type", 256);
            intent.putExtra("params", "record_force_stop=true");
            intent.putExtra("params", "audio_source=6");
            try {
                this.f7515j.mo12932a(intent);
            } catch (IllegalArgumentException unused) {
                LogUtil.m15949b(f7507c, "Speech service start recognize failed...");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7953e() {
        if (!PatchProxy.proxy(new Object[0], this, f7506a, false, 2238, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f7507c, "stop recognize");
            try {
                this.f7515j.mo12931a();
            } catch (IllegalArgumentException unused) {
                LogUtil.m15949b(f7507c, "Speech service stop recognize failed...");
            }
        }
    }

    /* renamed from: b */
    public void mo18765b() {
        if (!PatchProxy.proxy(new Object[0], this, f7506a, false, 2239, new Class[0], Void.TYPE).isSupported && this.f7515j != null) {
            m7955f();
            m7953e();
            this.f7515j.mo12935b();
            this.f7515j = null;
            this.f7519n = null;
            this.f7517l = false;
            LogUtil.m15942a(f7507c, "destroy");
        }
    }

    /* renamed from: com.meizu.media.camera.ac$b */
    /* compiled from: VoiceAssist */
    public static class C1791b implements C1790a {

        /* renamed from: a */
        public static ChangeQuickRedirect f7528a;

        /* renamed from: b */
        public MzCamModule f7529b;

        /* renamed from: ef */
        public void mo18235ef() {
            if (PatchProxy.proxy(new Object[0], this, f7528a, false, 2247, new Class[0], Void.TYPE).isSupported || this.f7529b.mo18036aU().mo21477A() || this.f7529b.mo18036aU().mo21590f()) {
                return;
            }
            if ((this.f7529b.mo18029aN() == null || CameraModeType.m10966f(this.f7529b.mo18029aN().mo20543V())) && !this.f7529b.mo18032aQ() && this.f7529b.mo18114bv() != -1 && !this.f7529b.mo18159ck()) {
                this.f7529b.mo18030aO().onUserInteraction();
                UsageStatsHelper.m16044a(2);
                this.f7529b.mo18263s(true);
                LogUtil.m15942a(LogUtil.f14072b, "onVoiceRecognizeSuccess");
                this.f7529b.mo17971K(true);
                this.f7529b.mo18048ag(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m7955f() {
        if (!PatchProxy.proxy(new Object[0], this, f7506a, false, CamcorderProfileEx.SLOW_MOTION_HD_60FPS, new Class[0], Void.TYPE).isSupported && this.f7508b != null) {
            this.f7508b.removeCallbacksAndMessages((Object) null);
            this.f7508b = null;
        }
    }
}
