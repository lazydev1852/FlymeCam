package com.baidu.p020ar.imu;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.p020ar.arplay.representation.Matrix;
import com.baidu.p020ar.arplay.representation.Matrixf4x4;
import com.baidu.p020ar.arplay.representation.Quaternion;
import com.baidu.p020ar.util.ARLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/* renamed from: com.baidu.ar.imu.f */
public abstract class C0777f extends Observable implements SensorEventListener {

    /* renamed from: a */
    protected Object f1750a = new Object();

    /* renamed from: b */
    protected Boolean f1751b = true;

    /* renamed from: c */
    protected final Object f1752c = new Object();

    /* renamed from: d */
    protected List<Sensor> f1753d = new ArrayList();

    /* renamed from: e */
    protected final Matrixf4x4 f1754e;

    /* renamed from: f */
    protected final Quaternion f1755f;

    /* renamed from: g */
    boolean f1756g = false;

    /* renamed from: h */
    protected final Matrixf4x4 f1757h;

    /* renamed from: i */
    protected final Matrixf4x4 f1758i;

    /* renamed from: j */
    protected final Matrixf4x4 f1759j;

    /* renamed from: k */
    private SensorManager f1760k;

    public C0777f(SensorManager sensorManager) {
        this.f1760k = sensorManager;
        this.f1754e = new Matrixf4x4();
        this.f1755f = new Quaternion();
        this.f1757h = new Matrixf4x4();
        this.f1758i = new Matrixf4x4();
        this.f1759j = new Matrixf4x4();
        ARLog.m2695d("sensorList size " + String.valueOf(this.f1753d.size()));
        if (this.f1753d.size() > 120) {
            this.f1753d.clear();
        }
    }

    /* renamed from: a */
    public static void m2041a(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        Matrix.invertM(fArr4, 0, fArr3, 0);
        Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr4, 0);
    }

    /* renamed from: b */
    public static boolean m2042b(float[] fArr, float[] fArr2) {
        float f;
        float f2;
        float atan;
        float[] fArr3 = new float[4];
        float[] fArr4 = {1.0f, 0.0f, 0.0f, 0.0f};
        Matrix.multiplyMV(fArr3, fArr2, fArr4);
        if (Float.compare(fArr3[0], fArr4[0]) == 0 && Float.compare(fArr3[1], fArr4[1]) == 0 && Float.compare(fArr3[2], fArr4[2]) == 0) {
            return false;
        }
        int compare = Float.compare(fArr3[0], 0.0f);
        int compare2 = Float.compare(fArr3[1], 0.0f);
        if (compare != 0) {
            double d = (double) (fArr3[1] / fArr3[0]);
            if (compare > 0 && compare2 >= 0) {
                atan = (float) ((Math.atan(d) * 180.0d) / 3.141592653589793d);
            } else if (compare <= 0 || compare2 >= 0) {
                atan = ((float) ((Math.atan(d) * 180.0d) / 3.141592653589793d)) + 180.0f;
            } else {
                f2 = ((float) ((Math.atan(d) * 180.0d) / 3.141592653589793d)) + 360.0f;
                f = f2;
            }
            f2 = atan;
            f = f2;
        } else {
            f = (Float.compare(fArr3[1], 1.0f) != 0 && Float.compare(fArr3[1], -1.0f) == 0) ? 180.0f : 0.0f;
        }
        ARLog.m2695d("orientation: outputV[0] = " + fArr3[0] + ", outputV[1] = " + fArr3[1] + ", angleZ = " + f);
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        return true;
    }

    /* renamed from: c */
    public static void m2043c(float[] fArr, float[] fArr2) {
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
    }

    /* renamed from: b */
    public boolean mo10141b() {
        for (Sensor sensor : this.f1753d) {
            if (sensor == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public void mo10142c() {
        for (Sensor registerListener : this.f1753d) {
            this.f1760k.registerListener(this, registerListener, 1);
        }
    }

    /* renamed from: d */
    public void mo10143d() {
        deleteObservers();
        for (Sensor unregisterListener : this.f1753d) {
            this.f1760k.unregisterListener(this, unregisterListener);
        }
        this.f1753d.clear();
    }

    /* renamed from: e */
    public Matrixf4x4 mo10144e() {
        return this.f1759j;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
