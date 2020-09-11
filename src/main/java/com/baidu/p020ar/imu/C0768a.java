package com.baidu.p020ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.p020ar.arplay.representation.Quaternion;

/* renamed from: com.baidu.ar.imu.a */
public class C0768a extends C0777f {

    /* renamed from: k */
    private final Quaternion f1707k = new Quaternion();

    /* renamed from: l */
    private long f1708l;

    /* renamed from: m */
    private int f1709m = 0;

    /* renamed from: n */
    private double f1710n = 0.0d;

    public C0768a(SensorManager sensorManager) {
        super(sensorManager);
        this.f1753d.add(sensorManager.getDefaultSensor(4));
    }

    /* renamed from: a */
    private void m2007a() {
        if (!this.f1756g) {
            System.arraycopy(this.f1754e.matrix, 0, this.f1757h.matrix, 0, this.f1757h.matrix.length);
            Matrix.setIdentityM(this.f1759j.matrix, 0);
            this.f1756g = true;
            return;
        }
        m2041a(this.f1759j.matrix, this.f1754e.matrix, this.f1757h.matrix);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
            if (this.f1708l != 0) {
                float f = ((float) (sensorEvent.timestamp - this.f1708l)) * 1.0E-9f;
                float f2 = sensorEvent.values[0];
                float f3 = sensorEvent.values[1];
                float f4 = sensorEvent.values[2];
                this.f1710n = Math.sqrt((double) ((f2 * f2) + (f3 * f3) + (f4 * f4)));
                if (this.f1710n > 0.10000000149011612d) {
                    f2 = (float) (((double) f2) / this.f1710n);
                    f3 = (float) (((double) f3) / this.f1710n);
                    f4 = (float) (((double) f4) / this.f1710n);
                }
                double d = (this.f1710n * ((double) f)) / 2.0d;
                double sin = Math.sin(d);
                double cos = Math.cos(d);
                this.f1707k.setX((float) (((double) f2) * sin));
                this.f1707k.setY((float) (((double) f3) * sin));
                this.f1707k.setZ((float) (sin * ((double) f4)));
                this.f1707k.setW(-((float) cos));
                synchronized (this.f1752c) {
                    this.f1707k.multiplyByQuat(this.f1755f, this.f1755f);
                }
                Quaternion clone = this.f1755f.clone();
                clone.mo9391w(-clone.mo9390w());
                synchronized (this.f1752c) {
                    SensorManager.getRotationMatrixFromVector(this.f1754e.matrix, clone.toArray());
                }
            }
            this.f1708l = sensorEvent.timestamp;
            this.f1709m++;
            if (this.f1709m > 20) {
                m2007a();
                setChanged();
                notifyObservers();
            }
        }
    }
}
