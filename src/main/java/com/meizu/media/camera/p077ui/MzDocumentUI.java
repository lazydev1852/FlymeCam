package com.meizu.media.camera.p077ui;

import android.content.Context;
import android.graphics.Point;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.databinding.CameraBinding;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzDocBinding;
import com.meizu.media.camera.views.DocScannerView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.ui.l */
public class MzDocumentUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13276a;

    /* renamed from: b */
    private DocScannerView f13277b;

    /* renamed from: c */
    private TextView f13278c;

    /* renamed from: d */
    private MzUIController f13279d;

    public MzDocumentUI(CameraBinding cameraBinding, Context context) {
        MzDocBinding mzDocBinding;
        DelayInflateTwoBinding delayInflateTwoBinding = (DelayInflateTwoBinding) cameraBinding.f9509h.getBinding();
        if (delayInflateTwoBinding.f9576g.getViewStub() != null) {
            mzDocBinding = (MzDocBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9576g.getViewStub().inflate());
        } else {
            mzDocBinding = (MzDocBinding) delayInflateTwoBinding.f9576g.getBinding();
        }
        LinearLayout linearLayout = mzDocBinding.f9710b;
        this.f13277b = mzDocBinding.f9709a;
        this.f13278c = cameraBinding.f9522u.f9700n;
    }

    /* renamed from: a */
    public void mo22291a(MzUIController uVar) {
        this.f13279d = uVar;
    }

    /* renamed from: a */
    public void mo22288a() {
        if (!PatchProxy.proxy(new Object[0], this, f13276a, false, 7128, new Class[0], Void.TYPE).isSupported) {
            this.f13277b.mo22828b();
        }
    }

    /* renamed from: b */
    public void mo22294b() {
        if (!PatchProxy.proxy(new Object[0], this, f13276a, false, 7129, new Class[0], Void.TYPE).isSupported) {
            this.f13277b.mo22826a();
            mo22296d();
        }
    }

    /* renamed from: c */
    public void mo22295c() {
        if (!PatchProxy.proxy(new Object[0], this, f13276a, false, 7130, new Class[0], Void.TYPE).isSupported && this.f13278c != null) {
            this.f13278c.setText(R.string.mz_document_hint);
            this.f13278c.setVisibility(0);
        }
    }

    /* renamed from: d */
    public void mo22296d() {
        if (!PatchProxy.proxy(new Object[0], this, f13276a, false, 7131, new Class[0], Void.TYPE).isSupported && this.f13278c != null) {
            this.f13278c.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo22293a(Point[] pointArr) {
        if (!PatchProxy.proxy(new Object[]{pointArr}, this, f13276a, false, 7132, new Class[]{Point[].class}, Void.TYPE).isSupported) {
            if (this.f13279d == null || !this.f13279d.mo21590f()) {
                this.f13277b.setPoint(pointArr);
            }
        }
    }

    /* renamed from: a */
    public void mo22290a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f13276a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7133, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f13277b.mo22827a(i, i2);
        }
    }

    /* renamed from: a */
    public void mo22289a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13276a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7134, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f13277b.setOrientation(i);
        }
    }

    /* renamed from: e */
    public void mo22297e() {
        if (!PatchProxy.proxy(new Object[0], this, f13276a, false, 7135, new Class[0], Void.TYPE).isSupported) {
            this.f13277b.mo22829c();
        }
    }

    /* renamed from: a */
    public void mo22292a(boolean z) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13276a, false, 7136, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13277b.mo22829c();
            if (this.f13278c != null) {
                TextView textView = this.f13278c;
                if (!z) {
                    i = 8;
                }
                textView.setVisibility(i);
            }
        }
    }
}
