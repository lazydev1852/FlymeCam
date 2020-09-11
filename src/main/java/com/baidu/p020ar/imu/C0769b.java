package com.baidu.p020ar.imu;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import com.baidu.p020ar.arplay.representation.Matrix;
import com.baidu.p020ar.util.ARLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.baidu.ar.imu.b */
public class C0769b implements Observer {

    /* renamed from: k */
    public static float f1711k;

    /* renamed from: a */
    C0777f f1712a;

    /* renamed from: b */
    Context f1713b;

    /* renamed from: c */
    float[] f1714c = new float[16];

    /* renamed from: d */
    float[] f1715d = new float[4];

    /* renamed from: e */
    float[] f1716e = new float[16];

    /* renamed from: f */
    float[] f1717f = {0.0f, 0.0f, -1.0f, 0.0f};

    /* renamed from: g */
    float f1718g = 10000.0f;

    /* renamed from: h */
    float f1719h = -1.0f;

    /* renamed from: i */
    float[] f1720i = new float[16];

    /* renamed from: j */
    float[] f1721j = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: l */
    private float[] f1722l = new float[16];

    /* renamed from: m */
    private boolean f1723m = false;

    /* renamed from: n */
    private boolean f1724n = true;

    /* renamed from: o */
    private boolean f1725o = false;

    /* renamed from: p */
    private C0770a f1726p;

    /* renamed from: q */
    private int f1727q = 1;

    /* renamed from: r */
    private int f1728r = 0;

    /* renamed from: s */
    private List<C0771b> f1729s = new ArrayList();

    /* renamed from: com.baidu.ar.imu.b$a */
    public interface C0770a {
        /* renamed from: a */
        void mo10133a(float f);
    }

    /* renamed from: com.baidu.ar.imu.b$b */
    public interface C0771b {
        /* renamed from: a */
        void mo10134a(float[] fArr);
    }

    public C0769b(Context context) {
        this.f1713b = context;
        Matrix.setIdentityM(this.f1714c, 0);
        Matrix.setIdentityM(this.f1722l, 0);
    }

    /* renamed from: b */
    private float m2008b(float[] fArr) {
        float f = -fArr[0];
        float f2 = -fArr[1];
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i == 0 && f < 0.0f) {
            return 0.0f;
        }
        if (i == 0 && f > 0.0f) {
            return 180.0f;
        }
        int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i2 == 0 && f2 < 0.0f) {
            return 90.0f;
        }
        if (i2 == 0 && i > 0) {
            return 270.0f;
        }
        float atan = (float) ((Math.atan((double) (Math.abs(f2) / Math.abs(f))) / 3.141592653589793d) * 180.0d);
        if (i2 > 0 && f2 < 0.0f) {
            atan = 180.0f - atan;
        }
        if (i2 > 0 && i > 0) {
            atan += 180.0f;
        }
        return (f >= 0.0f || i <= 0) ? atan : 360.0f - atan;
    }

    /* renamed from: c */
    private float m2009c(float[] fArr) {
        Matrix.multiplyMV(this.f1715d, 0, fArr, 0, this.f1717f, 0);
        if (this.f1715d[2] > 0.0f) {
            return -1.0f;
        }
        return 90.0f - ((float) ((Math.atan((double) (Math.abs(this.f1715d[2]) / ((float) Math.sqrt((double) ((this.f1715d[0] * this.f1715d[0]) + (this.f1715d[1] * this.f1715d[1])))))) / 3.141592653589793d) * 180.0d));
    }

    /* renamed from: e */
    private void m2010e() {
        if (this.f1712a != null) {
            this.f1712a.mo10143d();
            this.f1712a = null;
        }
    }

    /* renamed from: a */
    public int mo10124a() {
        return this.f1728r;
    }

    /* renamed from: a */
    public void mo10125a(Bundle bundle) {
        if (bundle != null) {
            this.f1727q = bundle.getInt("type");
            this.f1728r = bundle.getInt("init_pos");
            boolean z = false;
            if (bundle.getInt("resume_original_position", 0) == 1) {
                z = true;
            }
            if (this.f1727q == 1) {
                if (!z) {
                    this.f1724n = true;
                }
                this.f1723m = z;
            }
        }
    }

    /* renamed from: a */
    public void mo10126a(C0771b bVar) {
        try {
            this.f1729s.add(bVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public boolean mo10127a(int i) {
        C0777f cVar;
        try {
            this.f1727q = i;
            if (this.f1712a == null) {
                SensorManager sensorManager = (SensorManager) this.f1713b.getSystemService("sensor");
                if (i != 1) {
                    cVar = new C0772c(sensorManager);
                } else if (this.f1723m) {
                    this.f1712a = new C0773d(sensorManager);
                    if (!this.f1724n) {
                        this.f1712a.f1756g = true;
                        this.f1712a.f1757h.matrix = this.f1722l;
                    }
                    this.f1724n = false;
                    this.f1712a.addObserver(this);
                } else {
                    cVar = new C0768a(sensorManager);
                }
                this.f1712a = cVar;
                this.f1712a.addObserver(this);
            }
            if (!this.f1712a.mo10141b()) {
                return false;
            }
            this.f1712a.mo10142c();
            return true;
        } catch (Throwable th) {
            ARLog.m2696e("IMUController start: " + th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public float[] mo10128a(float[] fArr) {
        Matrix.invertM(this.f1716e, 0, fArr, 0);
        Matrix.multiplyMM(this.f1720i, 0, this.f1721j, 0, this.f1716e, 0);
        this.f1719h = m2009c(this.f1720i);
        if (this.f1719h > 0.0f) {
            this.f1718g = (float) (Math.pow(1.13d, (double) this.f1719h) + 600.0d);
            if (this.f1718g > 15000.0f) {
                this.f1718g = 15000.0f;
            }
        }
        Matrix.multiplyMV(this.f1715d, 0, this.f1720i, 0, new float[]{0.0f, 0.0f, -this.f1718g, 1.0f}, 0);
        this.f1720i[12] = -this.f1715d[0];
        this.f1720i[13] = -this.f1715d[1];
        this.f1720i[14] = -this.f1715d[2];
        Matrix.invertM(this.f1716e, 0, this.f1720i, 0);
        f1711k = m2008b(this.f1715d);
        Matrix.rotateM(this.f1716e, 0, f1711k, 0.0f, 0.0f, 1.0f);
        return this.f1716e;
    }

    /* renamed from: b */
    public void mo10129b() {
        try {
            if (this.f1712a != null && this.f1727q == 1 && !this.f1725o && this.f1723m) {
                this.f1722l = this.f1712a.f1757h.matrix;
                this.f1725o = true;
            }
            m2010e();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public void mo10130c() {
        if (this.f1729s != null) {
            this.f1729s.clear();
        }
        m2010e();
        if (this.f1726p != null) {
            this.f1726p = null;
        }
    }

    /* renamed from: d */
    public float[] mo10131d() {
        if (this.f1712a != null) {
            return this.f1712a.mo10144e().matrix;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        return fArr;
    }

    public void update(Observable observable, Object obj) {
        try {
            float[] fArr = this.f1712a.mo10144e().matrix;
            this.f1714c = mo10128a(fArr);
            if (this.f1726p != null) {
                this.f1726p.mo10133a(this.f1719h);
            }
            for (C0771b a : this.f1729s) {
                a.mo10134a(fArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
