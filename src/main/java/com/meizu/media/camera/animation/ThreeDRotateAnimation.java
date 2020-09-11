package com.meizu.media.camera.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.view.animation.Transformation;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.animation.m */
public class ThreeDRotateAnimation extends Animation {

    /* renamed from: a */
    public static ChangeQuickRedirect f7830a;

    /* renamed from: b */
    private final float f7831b;

    /* renamed from: c */
    private final float f7832c;

    /* renamed from: d */
    private final float f7833d;

    /* renamed from: e */
    private final float f7834e;

    /* renamed from: f */
    private final float f7835f;

    /* renamed from: g */
    private final boolean f7836g;

    /* renamed from: h */
    private Camera f7837h;

    /* renamed from: i */
    private final float f7838i = 1.0f;

    /* renamed from: j */
    private final float f7839j = 0.8f;

    /* renamed from: k */
    private float f7840k = 1.0f;

    public ThreeDRotateAnimation(float f, float f2, float f3, float f4, float f5, boolean z, PathInterpolator pathInterpolator) {
        this.f7831b = f;
        this.f7832c = f2;
        this.f7833d = f3;
        this.f7834e = f4;
        this.f7835f = f5;
        this.f7836g = z;
        setInterpolator(pathInterpolator);
    }

    public void initialize(int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f7830a, false, 2453, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.initialize(i, i2, i3, i4);
            this.f7837h = new Camera();
        }
    }

    public void applyTransformation(float f, Transformation transformation) {
        Object[] objArr = {new Float(f), transformation};
        ChangeQuickRedirect changeQuickRedirect = f7830a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2454, new Class[]{Float.TYPE, Transformation.class}, Void.TYPE).isSupported) {
            float f2 = this.f7831b;
            float f3 = f2 + ((this.f7832c - f2) * f);
            float f4 = this.f7833d;
            float f5 = this.f7834e;
            Camera camera = this.f7837h;
            Matrix matrix = transformation.getMatrix();
            camera.save();
            if (this.f7836g) {
                camera.translate(0.0f, 0.0f, this.f7835f * f);
                this.f7840k = 1.0f - (f * 0.19999999f);
            } else {
                camera.translate(0.0f, 0.0f, this.f7835f * (1.0f - f));
                this.f7840k = (f * 0.19999999f) + 0.8f;
            }
            camera.setLocation(0.0f, 0.0f, -40.0f);
            camera.rotateX(f3);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.postScale(this.f7840k, this.f7840k);
            matrix.preTranslate(-f4, -f5);
            matrix.postTranslate(f4, f5);
        }
    }
}
