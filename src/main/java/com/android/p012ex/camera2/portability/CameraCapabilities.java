package com.android.p012ex.camera2.portability;

import com.android.p012ex.camera2.portability.p014a.Log;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.TreeSet;

/* renamed from: com.android.ex.camera2.portability.CameraCapabilities */
public class CameraCapabilities {

    /* renamed from: s */
    private static Log.C0440a f257s = new Log.C0440a("CamCapabs");

    /* renamed from: a */
    protected final ArrayList<int[]> f258a = new ArrayList<>();

    /* renamed from: b */
    protected final ArrayList<Size> f259b = new ArrayList<>();

    /* renamed from: c */
    protected final TreeSet<Integer> f260c = new TreeSet<>();

    /* renamed from: d */
    protected final ArrayList<Size> f261d = new ArrayList<>();

    /* renamed from: e */
    protected final ArrayList<Size> f262e = new ArrayList<>();

    /* renamed from: f */
    protected final TreeSet<Integer> f263f = new TreeSet<>();

    /* renamed from: g */
    protected final EnumSet<SceneMode> f264g = EnumSet.noneOf(SceneMode.class);

    /* renamed from: h */
    protected final EnumSet<FlashMode> f265h = EnumSet.noneOf(FlashMode.class);

    /* renamed from: i */
    protected final EnumSet<FocusMode> f266i = EnumSet.noneOf(FocusMode.class);

    /* renamed from: j */
    protected final EnumSet<WhiteBalance> f267j = EnumSet.noneOf(WhiteBalance.class);

    /* renamed from: k */
    protected final EnumSet<Feature> f268k = EnumSet.noneOf(Feature.class);

    /* renamed from: l */
    protected int f269l;

    /* renamed from: m */
    protected int f270m;

    /* renamed from: n */
    protected float f271n;

    /* renamed from: o */
    protected int f272o;

    /* renamed from: p */
    protected int f273p;

    /* renamed from: q */
    protected int f274q;

    /* renamed from: r */
    protected float f275r;

    /* renamed from: t */
    private final C0439a f276t;

    /* renamed from: com.android.ex.camera2.portability.CameraCapabilities$Feature */
    public enum Feature {
        ZOOM,
        VIDEO_SNAPSHOT,
        FOCUS_AREA,
        METERING_AREA,
        AUTO_EXPOSURE_LOCK,
        AUTO_WHITE_BALANCE_LOCK,
        VIDEO_STABILIZATION
    }

    /* renamed from: com.android.ex.camera2.portability.CameraCapabilities$FlashMode */
    public enum FlashMode {
        NO_FLASH,
        AUTO,
        OFF,
        ON,
        TORCH,
        RED_EYE
    }

    /* renamed from: com.android.ex.camera2.portability.CameraCapabilities$FocusMode */
    public enum FocusMode {
        AUTO,
        CONTINUOUS_PICTURE,
        CONTINUOUS_VIDEO,
        EXTENDED_DOF,
        FIXED,
        INFINITY,
        MACRO
    }

    /* renamed from: com.android.ex.camera2.portability.CameraCapabilities$SceneMode */
    public enum SceneMode {
        NO_SCENE_MODE,
        AUTO,
        ACTION,
        BARCODE,
        BEACH,
        CANDLELIGHT,
        FIREWORKS,
        HDR,
        LANDSCAPE,
        NIGHT,
        NIGHT_PORTRAIT,
        PARTY,
        PORTRAIT,
        SNOW,
        SPORTS,
        STEADYPHOTO,
        SUNSET,
        THEATRE
    }

    /* renamed from: com.android.ex.camera2.portability.CameraCapabilities$WhiteBalance */
    public enum WhiteBalance {
        AUTO,
        CLOUDY_DAYLIGHT,
        DAYLIGHT,
        FLUORESCENT,
        INCANDESCENT,
        SHADE,
        TWILIGHT,
        WARM_FLUORESCENT
    }

    /* renamed from: com.android.ex.camera2.portability.CameraCapabilities$a */
    public static class C0439a {
    }

    CameraCapabilities(C0439a aVar) {
        this.f276t = aVar;
    }

    /* renamed from: a */
    public final boolean mo8620a(FocusMode focusMode) {
        return focusMode != null && this.f266i.contains(focusMode);
    }

    /* renamed from: a */
    public boolean mo8619a(Feature feature) {
        return feature != null && this.f268k.contains(feature);
    }

    /* renamed from: a */
    public final int mo8618a() {
        return this.f272o;
    }
}
