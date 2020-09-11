package com.meizu.media.camera.app;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.app.d */
public class HeadingSensor implements SensorEventListener {

    /* renamed from: a */
    private static final LogUtil.C2630a f7927a = new LogUtil.C2630a("HeadingSensor");

    /* renamed from: c */
    public static ChangeQuickRedirect f7928c;

    /* renamed from: b */
    private int f7929b = -1;

    /* renamed from: d */
    private final SensorManager f7930d;

    /* renamed from: e */
    private final Sensor f7931e;

    /* renamed from: f */
    private final Sensor f7932f;

    /* renamed from: g */
    private final Sensor f7933g;

    /* renamed from: h */
    private final float[] f7934h = new float[3];

    /* renamed from: i */
    private final float[] f7935i = new float[3];

    /* renamed from: j */
    private final float[] f7936j = new float[16];

    /* renamed from: k */
    private final float[] f7937k = new float[3];

    /* renamed from: a */
    public void mo18320a(int i, SensorEvent sensorEvent) {
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public HeadingSensor(SensorManager sensorManager) {
        this.f7930d = sensorManager;
        this.f7931e = this.f7930d.getDefaultSensor(1);
        this.f7932f = this.f7930d.getDefaultSensor(2);
        this.f7933g = this.f7930d.getDefaultSensor(4);
    }

    /* renamed from: a */
    public int mo19011a() {
        return this.f7929b;
    }

    /* renamed from: b */
    public void mo19012b() {
        if (!PatchProxy.proxy(new Object[0], this, f7928c, false, 2517, new Class[0], Void.TYPE).isSupported) {
            if (this.f7931e != null) {
                this.f7930d.registerListener(this, this.f7931e, 3);
            }
            if (this.f7932f != null) {
                this.f7930d.registerListener(this, this.f7932f, 3);
            }
            if (this.f7933g != null) {
                this.f7930d.registerListener(this, this.f7933g, 3);
            }
        }
    }

    /* renamed from: c */
    public void mo19013c() {
        if (!PatchProxy.proxy(new Object[0], this, f7928c, false, 2518, new Class[0], Void.TYPE).isSupported) {
            if (this.f7931e != null) {
                this.f7930d.unregisterListener(this, this.f7931e);
            }
            if (this.f7932f != null) {
                this.f7930d.unregisterListener(this, this.f7932f);
            }
            if (this.f7933g != null) {
                this.f7930d.unregisterListener(this, this.f7933g);
            }
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        if (!PatchProxy.proxy(new Object[]{sensorEvent}, this, f7928c, false, 2519, new Class[]{SensorEvent.class}, Void.TYPE).isSupported) {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                fArr = this.f7934h;
                mo18320a(type, sensorEvent);
            } else if (type == 2) {
                fArr = this.f7935i;
                mo18320a(type, sensorEvent);
            } else if (type == 4) {
                mo18320a(type, sensorEvent);
                return;
            } else {
                LogUtil.m15956e(f7927a, String.format("Unexpected sensor type %s", new Object[]{sensorEvent.sensor.getName()}));
                return;
            }
            System.arraycopy(sensorEvent.values, 0, fArr, 0, 3);
            SensorManager.getRotationMatrix(this.f7936j, (float[]) null, this.f7934h, this.f7935i);
            SensorManager.getOrientation(this.f7936j, this.f7937k);
            this.f7929b = ((int) (((double) (this.f7937k[0] * 180.0f)) / 3.141592653589793d)) % 360;
            if (this.f7929b < 0) {
                this.f7929b += 360;
            }
        }
    }

    /* renamed from: d */
    public float[] mo19014d() {
        return this.f7937k;
    }
}
