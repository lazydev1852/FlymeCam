package com.baidu.p020ar.arplay.p032a;

import android.content.Context;
import android.view.OrientationEventListener;
import com.baidu.p020ar.arplay.core.ARPEngine;

/* renamed from: com.baidu.ar.arplay.a.c */
public class C0535c extends OrientationEventListener {

    /* renamed from: a */
    private ARPEngine.TouchOrientation f697a;

    /* renamed from: b */
    private ARPEngine.TouchOrientation f698b;

    /* renamed from: c */
    private boolean f699c = false;

    /* renamed from: d */
    private int f700d;

    public C0535c(Context context) {
        super(context);
    }

    /* renamed from: d */
    private int m1006d() {
        if (this.f697a == ARPEngine.TouchOrientation.SCREEN_ORIENTATION_LANDSCAPE) {
            return 90;
        }
        if (this.f697a == ARPEngine.TouchOrientation.SCREEN_ORIENTATION_REVERSE_LANDSCAPE) {
            return -90;
        }
        return this.f697a == ARPEngine.TouchOrientation.SCREEN_ORIENTATION_REVERSE_PORTRAIT ? 180 : 0;
    }

    /* renamed from: a */
    public void mo9051a() {
        enable();
    }

    /* renamed from: b */
    public void mo9052b() {
        this.f700d = m1006d();
    }

    /* renamed from: c */
    public void mo9053c() {
        disable();
    }

    public void onOrientationChanged(int i) {
        ARPEngine.TouchOrientation touchOrientation;
        ARPEngine.TouchOrientation touchOrientation2;
        if (i < 0) {
            touchOrientation = ARPEngine.TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
        } else {
            if (ARPEngine.getInstance().getImuType() == 1) {
                int i2 = ((i + 360) + this.f700d) % 360;
                if (i2 <= 45 || i2 > 315) {
                    touchOrientation2 = ARPEngine.TouchOrientation.SCREEN_ORIENTATION_PORTRAIT;
                } else if (i2 > 45 && i2 <= 135) {
                    touchOrientation2 = ARPEngine.TouchOrientation.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                } else if (i2 <= 135 || i2 > 225) {
                    if (i2 > 225 && i2 <= 315) {
                        touchOrientation2 = ARPEngine.TouchOrientation.SCREEN_ORIENTATION_LANDSCAPE;
                    }
                    if (!this.f699c && ARPEngine.getInstance().getImuType() == 1) {
                        this.f699c = true;
                        this.f697a = this.f698b;
                        mo9052b();
                    }
                } else {
                    touchOrientation2 = ARPEngine.TouchOrientation.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                }
                this.f698b = touchOrientation2;
                this.f699c = true;
                this.f697a = this.f698b;
                mo9052b();
            } else if (ARPEngine.getInstance().getImuType() == 0) {
                if (i <= 45 || i > 315) {
                    touchOrientation = ARPEngine.TouchOrientation.SCREEN_ORIENTATION_PORTRAIT;
                } else if (i > 45 && i <= 135) {
                    touchOrientation = ARPEngine.TouchOrientation.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                } else if (i > 135 && i <= 225) {
                    touchOrientation = ARPEngine.TouchOrientation.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                } else if (i > 225 && i <= 315) {
                    touchOrientation = ARPEngine.TouchOrientation.SCREEN_ORIENTATION_LANDSCAPE;
                }
            }
            ARPEngine.getInstance().setTouchOrientation(this.f698b);
        }
        this.f698b = touchOrientation;
        ARPEngine.getInstance().setTouchOrientation(this.f698b);
    }
}
