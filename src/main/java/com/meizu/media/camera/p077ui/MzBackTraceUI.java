package com.meizu.media.camera.p077ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.databinding.CameraBinding;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzFunnySnapNoFaceBinding;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.ui.f */
public class MzBackTraceUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f12896a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LinearLayout f12897b;

    /* renamed from: c */
    private boolean f12898c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f12899d;

    /* renamed from: e */
    private boolean f12900e = true;

    /* renamed from: f */
    private Handler f12901f = new Handler() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12903a;

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f12903a, false, 6421, new Class[]{Message.class}, Void.TYPE).isSupported) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        MzBackTraceUI.this.f12897b.setVisibility(0);
                        return;
                    case 2:
                        MzBackTraceUI.this.f12897b.setVisibility(8);
                        return;
                    default:
                        return;
                }
            }
        }
    };

    /* renamed from: g */
    private Runnable f12902g = new Runnable() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12905a;

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f12905a, false, 6422, new Class[0], Void.TYPE).isSupported && MzBackTraceUI.this.f12899d != null) {
                MzBackTraceUI.this.f12899d.setVisibility(8);
            }
        }
    };

    /* renamed from: a */
    public void mo21988a() {
    }

    /* renamed from: a */
    public void mo21990a(CameraController.C1880f[] fVarArr) {
    }

    public MzBackTraceUI(Context context, CameraBinding cameraBinding, MzCamUI iVar) {
        MzFunnySnapNoFaceBinding mzFunnySnapNoFaceBinding;
        DelayInflateTwoBinding delayInflateTwoBinding = (DelayInflateTwoBinding) cameraBinding.f9509h.getBinding();
        if (delayInflateTwoBinding.f9578i.getViewStub() != null) {
            mzFunnySnapNoFaceBinding = (MzFunnySnapNoFaceBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9578i.getViewStub().inflate());
        } else {
            mzFunnySnapNoFaceBinding = (MzFunnySnapNoFaceBinding) delayInflateTwoBinding.f9578i.getBinding();
        }
        this.f12897b = mzFunnySnapNoFaceBinding.f9735a;
        this.f12897b.setVisibility(8);
        this.f12899d = cameraBinding.f9522u.f9700n;
        this.f12900e = true;
    }

    /* renamed from: b */
    public void mo21991b() {
        if (!PatchProxy.proxy(new Object[0], this, f12896a, false, 6417, new Class[0], Void.TYPE).isSupported && this.f12899d != null && this.f12900e) {
            this.f12899d.setText(R.string.mz_refocus_hint_effect_better);
            this.f12899d.setVisibility(0);
            this.f12899d.postDelayed(this.f12902g, 5000);
            this.f12900e = false;
        }
    }

    /* renamed from: c */
    public void mo21992c() {
        if (!PatchProxy.proxy(new Object[0], this, f12896a, false, 6418, new Class[0], Void.TYPE).isSupported && this.f12899d != null && !this.f12900e) {
            this.f12899d.removeCallbacks(this.f12902g);
            this.f12899d.setVisibility(8);
            this.f12900e = false;
        }
    }

    /* renamed from: a */
    public void mo21989a(boolean z) {
        this.f12898c = z;
    }

    /* renamed from: d */
    public void mo21993d() {
        if (!PatchProxy.proxy(new Object[0], this, f12896a, false, 6419, new Class[0], Void.TYPE).isSupported && this.f12899d != null && this.f12899d.getVisibility() == 0) {
            this.f12899d.removeCallbacks(this.f12902g);
            this.f12899d.setVisibility(8);
            this.f12900e = false;
        }
    }

    /* renamed from: e */
    public void mo21994e() {
        if (!PatchProxy.proxy(new Object[0], this, f12896a, false, 6420, new Class[0], Void.TYPE).isSupported) {
            this.f12900e = true;
            this.f12897b.setVisibility(8);
            this.f12899d.removeCallbacks(this.f12902g);
            this.f12899d.setVisibility(8);
        }
    }
}
