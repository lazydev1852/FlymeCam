package com.baidu.p020ar.p041c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.p020ar.util.ARLog;
import java.util.LinkedList;

/* renamed from: com.baidu.ar.c.a */
public class C0750a implements SensorEventListener {

    /* renamed from: a */
    private SensorManager f1639a;

    /* renamed from: b */
    private Sensor f1640b;

    /* renamed from: c */
    private C0751a f1641c;

    /* renamed from: d */
    private Context f1642d;

    /* renamed from: e */
    private boolean f1643e = true;

    /* renamed from: f */
    private LinkedList<Double> f1644f = new LinkedList<>();

    /* renamed from: g */
    private LinkedList<Float> f1645g = new LinkedList<>();

    /* renamed from: h */
    private LinkedList<Float> f1646h = new LinkedList<>();

    /* renamed from: i */
    private LinkedList<Float> f1647i = new LinkedList<>();

    /* renamed from: j */
    private int f1648j = 10;

    /* renamed from: k */
    private double f1649k = 0.0d;

    /* renamed from: l */
    private boolean f1650l = true;

    /* renamed from: m */
    private boolean f1651m = false;

    /* renamed from: com.baidu.ar.c.a$a */
    public interface C0751a {
        /* renamed from: a */
        void mo10081a();

        /* renamed from: a */
        void mo10082a(float f, float f2, float f3, float f4);
    }

    public C0750a(Context context) {
        this.f1642d = context;
    }

    /* renamed from: a */
    public void mo10072a() {
        this.f1639a = (SensorManager) this.f1642d.getSystemService("sensor");
        if (this.f1639a != null) {
            this.f1640b = this.f1639a.getDefaultSensor(10);
            if (this.f1640b == null) {
                this.f1640b = this.f1639a.getDefaultSensor(1);
                this.f1651m = true;
            }
        }
        if (this.f1640b != null) {
            this.f1639a.registerListener(this, this.f1640b, 1);
        }
    }

    /* renamed from: a */
    public void mo10073a(float f, float f2, float f3) {
        double sqrt = Math.sqrt((double) ((f * f) + (f2 * f2) + (f3 * f3)));
        if (sqrt > this.f1649k) {
            this.f1649k = sqrt;
        }
        ARLog.m2695d("max acc is : " + this.f1649k);
        mo10075a((LinkedList) this.f1644f, sqrt);
        mo10076a((LinkedList) this.f1645g, Math.abs(f));
        mo10076a((LinkedList) this.f1646h, Math.abs(f2));
        mo10076a((LinkedList) this.f1647i, Math.abs(f3));
        if (this.f1644f.size() == this.f1648j) {
            double d = 0.0d;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            for (int i = 0; i < this.f1644f.size(); i++) {
                d += this.f1644f.get(i).doubleValue();
                f4 += this.f1645g.get(i).floatValue();
                f5 += this.f1646h.get(i).floatValue();
                f6 += this.f1647i.get(i).floatValue();
            }
            double d2 = d / ((double) this.f1648j);
            float f7 = f4 / ((float) this.f1648j);
            float f8 = f5 / ((float) this.f1648j);
            float f9 = f6 / ((float) this.f1648j);
            if (this.f1651m) {
                if (this.f1650l) {
                    if (d2 <= 10.0d) {
                        return;
                    }
                } else if (d2 < 10.0d) {
                    this.f1650l = true;
                    if (this.f1641c == null) {
                        return;
                    }
                    this.f1641c.mo10082a(f7, f8, f9, (float) this.f1649k);
                    this.f1649k = 0.0d;
                    return;
                } else {
                    return;
                }
            } else if (this.f1650l) {
                if (d2 <= 5.0d) {
                    return;
                }
            } else if (d2 < 5.0d) {
                this.f1650l = true;
                if (this.f1641c == null) {
                    return;
                }
                this.f1641c.mo10082a(f7, f8, f9, (float) this.f1649k);
                this.f1649k = 0.0d;
                return;
            } else {
                return;
            }
            this.f1650l = false;
        }
    }

    /* renamed from: a */
    public void mo10074a(C0751a aVar) {
        this.f1641c = aVar;
    }

    /* renamed from: a */
    public void mo10075a(LinkedList linkedList, double d) {
        if (linkedList.size() >= this.f1648j) {
            linkedList.poll();
        }
        linkedList.offer(Double.valueOf(d));
    }

    /* renamed from: a */
    public void mo10076a(LinkedList linkedList, float f) {
        if (linkedList.size() >= this.f1648j) {
            linkedList.poll();
        }
        linkedList.offer(Float.valueOf(f));
    }

    /* renamed from: a */
    public void mo10077a(boolean z) {
        this.f1643e = z;
    }

    /* renamed from: b */
    public void mo10078b() {
        if (this.f1641c != null) {
            this.f1641c.mo10081a();
            this.f1641c = null;
        }
        if (this.f1639a != null) {
            this.f1639a.unregisterListener(this);
            this.f1639a = null;
        }
        this.f1651m = false;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f1643e) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            mo10073a(f, f2, f3);
            ARLog.m2695d("acc  x : " + f + " , y : " + f2 + ", z : " + f3);
        }
    }
}
