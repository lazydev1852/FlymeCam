package com.android.p012ex.camera2.portability;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.MediaRecorder;
import android.util.Range;
import android.util.Rational;
import com.android.p012ex.camera2.portability.CameraCapabilities;
import com.android.p012ex.camera2.portability.p014a.Log;
import java.util.Arrays;

/* renamed from: com.android.ex.camera2.portability.a */
public class AndroidCamera2Capabilities extends CameraCapabilities {

    /* renamed from: s */
    private static Log.C0440a f278s = new Log.C0440a("AndCam2Capabs");

    AndroidCamera2Capabilities(CameraCharacteristics cameraCharacteristics) {
        super(new CameraCapabilities.C0439a());
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        for (Range range : (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES)) {
            this.f258a.add(new int[]{((Integer) range.getLower()).intValue(), ((Integer) range.getUpper()).intValue()});
        }
        this.f259b.addAll(Size.m563a(Arrays.asList(streamConfigurationMap.getOutputSizes(SurfaceTexture.class))));
        for (int valueOf : streamConfigurationMap.getOutputFormats()) {
            this.f260c.add(Integer.valueOf(valueOf));
        }
        this.f261d.addAll(Size.m563a(Arrays.asList(streamConfigurationMap.getOutputSizes(MediaRecorder.class))));
        this.f262e.addAll(Size.m563a(Arrays.asList(streamConfigurationMap.getOutputSizes(256))));
        this.f263f.addAll(this.f260c);
        m549a(cameraCharacteristics);
        m551b(cameraCharacteristics);
        m553c(cameraCharacteristics);
        m554d(cameraCharacteristics);
        Range range2 = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        this.f269l = ((Integer) range2.getLower()).intValue();
        this.f270m = ((Integer) range2.getUpper()).intValue();
        Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        this.f271n = ((float) rational.getNumerator()) / ((float) rational.getDenominator());
        this.f272o = ((Integer) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue();
        this.f274q = ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue();
        this.f275r = ((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        if (mo8620a(CameraCapabilities.FocusMode.AUTO)) {
            this.f273p = ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
            if (this.f273p > 0) {
                this.f268k.add(CameraCapabilities.Feature.FOCUS_AREA);
            }
        }
        if (this.f274q > 0) {
            this.f268k.add(CameraCapabilities.Feature.METERING_AREA);
        }
        if (this.f275r > 1.0f) {
            this.f268k.add(CameraCapabilities.Feature.ZOOM);
        }
    }

    /* renamed from: a */
    private void m549a(CameraCharacteristics cameraCharacteristics) {
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES);
        if (iArr != null) {
            for (int b : iArr) {
                CameraCapabilities.SceneMode b2 = m550b(b);
                if (b2 != null) {
                    this.f264g.add(b2);
                }
            }
        }
    }

    /* renamed from: b */
    private void m551b(CameraCharacteristics cameraCharacteristics) {
        this.f265h.add(CameraCapabilities.FlashMode.OFF);
        if (((Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue()) {
            this.f265h.add(CameraCapabilities.FlashMode.AUTO);
            this.f265h.add(CameraCapabilities.FlashMode.ON);
            this.f265h.add(CameraCapabilities.FlashMode.TORCH);
            for (int i : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) {
                if (i == 4) {
                    this.f265h.add(CameraCapabilities.FlashMode.RED_EYE);
                }
            }
        }
    }

    /* renamed from: c */
    private void m553c(CameraCharacteristics cameraCharacteristics) {
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr != null) {
            for (int a : iArr) {
                CameraCapabilities.FocusMode a2 = m548a(a);
                if (a2 != null) {
                    this.f266i.add(a2);
                }
            }
        }
    }

    /* renamed from: d */
    private void m554d(CameraCharacteristics cameraCharacteristics) {
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr != null) {
            for (int c : iArr) {
                CameraCapabilities.WhiteBalance c2 = m552c(c);
                if (c2 != null) {
                    this.f267j.add(c2);
                }
            }
        }
    }

    /* renamed from: a */
    public static CameraCapabilities.FocusMode m548a(int i) {
        switch (i) {
            case 0:
                return CameraCapabilities.FocusMode.FIXED;
            case 1:
                return CameraCapabilities.FocusMode.AUTO;
            case 2:
                return CameraCapabilities.FocusMode.MACRO;
            case 3:
                return CameraCapabilities.FocusMode.CONTINUOUS_VIDEO;
            case 4:
                return CameraCapabilities.FocusMode.CONTINUOUS_PICTURE;
            case 5:
                return CameraCapabilities.FocusMode.EXTENDED_DOF;
            default:
                Log.C0440a aVar = f278s;
                Log.m559b(aVar, "Unable to convert from API 2 focus mode: " + i);
                return null;
        }
    }

    /* renamed from: b */
    public static CameraCapabilities.SceneMode m550b(int i) {
        switch (i) {
            case 0:
                return CameraCapabilities.SceneMode.AUTO;
            case 2:
                return CameraCapabilities.SceneMode.ACTION;
            case 3:
                return CameraCapabilities.SceneMode.PORTRAIT;
            case 4:
                return CameraCapabilities.SceneMode.LANDSCAPE;
            case 5:
                return CameraCapabilities.SceneMode.NIGHT;
            case 7:
                return CameraCapabilities.SceneMode.THEATRE;
            case 8:
                return CameraCapabilities.SceneMode.BEACH;
            case 9:
                return CameraCapabilities.SceneMode.SNOW;
            case 10:
                return CameraCapabilities.SceneMode.SUNSET;
            case 11:
                return CameraCapabilities.SceneMode.STEADYPHOTO;
            case 12:
                return CameraCapabilities.SceneMode.FIREWORKS;
            case 13:
                return CameraCapabilities.SceneMode.SPORTS;
            case 14:
                return CameraCapabilities.SceneMode.PARTY;
            case 15:
                return CameraCapabilities.SceneMode.CANDLELIGHT;
            case 16:
                return CameraCapabilities.SceneMode.BARCODE;
            case 18:
                return CameraCapabilities.SceneMode.HDR;
            default:
                Log.C0440a aVar = f278s;
                Log.m559b(aVar, "Unable to convert from API 2 scene mode: " + i);
                return null;
        }
    }

    /* renamed from: c */
    public static CameraCapabilities.WhiteBalance m552c(int i) {
        switch (i) {
            case 1:
                return CameraCapabilities.WhiteBalance.AUTO;
            case 2:
                return CameraCapabilities.WhiteBalance.INCANDESCENT;
            case 3:
                return CameraCapabilities.WhiteBalance.FLUORESCENT;
            case 4:
                return CameraCapabilities.WhiteBalance.WARM_FLUORESCENT;
            case 5:
                return CameraCapabilities.WhiteBalance.DAYLIGHT;
            case 6:
                return CameraCapabilities.WhiteBalance.CLOUDY_DAYLIGHT;
            case 7:
                return CameraCapabilities.WhiteBalance.TWILIGHT;
            case 8:
                return CameraCapabilities.WhiteBalance.SHADE;
            default:
                Log.C0440a aVar = f278s;
                Log.m559b(aVar, "Unable to convert from API 2 white balance: " + i);
                return null;
        }
    }
}
