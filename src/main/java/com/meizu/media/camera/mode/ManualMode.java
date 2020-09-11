package com.meizu.media.camera.mode;

import android.content.Context;
import android.graphics.Point;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.meizu.cloud.pushsdk.platform.pushstrategy.Strategy;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzManualUI;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceSizeTable;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.mode.m */
public class ManualMode extends CameraMode implements MzManualUI.C2589b {

    /* renamed from: a */
    public static ChangeQuickRedirect f10867a;

    /* renamed from: b */
    public static long f10868b = 1000;

    /* renamed from: c */
    public static String f10869c = "shutter-value-supported";

    /* renamed from: d */
    public static String f10870d;

    /* renamed from: e */
    public static String f10871e = "exposure";

    /* renamed from: f */
    public static String f10872f = "mf-pos";

    /* renamed from: g */
    public static String f10873g = "whitebalance-values";

    /* renamed from: l */
    public static String f10874l = "scene-mode-values";

    /* renamed from: m */
    public static String f10875m = "camera-id-values";
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static final LogUtil.C2630a f10876n = new LogUtil.C2630a("ManualMode");
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static HashMap<String, String> f10877u;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Context f10878o;

    /* renamed from: p */
    private MzCamParamsManager f10879p;

    /* renamed from: q */
    private MzManualUI f10880q;

    /* renamed from: r */
    private HashMap<String, C2189a> f10881r;

    /* renamed from: s */
    private boolean f10882s = false;

    /* renamed from: t */
    private boolean f10883t = false;

    /* renamed from: v */
    private boolean f10884v = false;

    /* renamed from: w */
    private int f10885w = -1;

    /* renamed from: x */
    private CameraModeListener f10886x;

    /* renamed from: y */
    private int f10887y = -1;

    /* renamed from: z */
    private boolean f10888z = false;

    /* renamed from: j_ */
    public void mo20406j_() {
    }

    /* renamed from: t */
    public boolean mo20417t() {
        return false;
    }

    /* renamed from: u */
    public boolean mo20418u() {
        return false;
    }

    /* renamed from: v */
    public boolean mo20419v() {
        return true;
    }

    /* renamed from: w */
    public boolean mo20420w() {
        return false;
    }

    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    static {
        f10870d = "iso-speed-values";
        if (DeviceHelper.f13840T) {
            f10870d = "iso-values";
        }
    }

    public ManualMode(CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar, CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
        boolean z = false;
        LogUtil.m15952c(f10876n, "ManualMode init");
        this.f10878o = cameraActivity.getApplicationContext();
        this.f10879p = lVar;
        this.f10884v = false;
        if (f10877u == null) {
            f10877u = new HashMap<>();
            f10877u.put("125", "1/8000s");
            f10877u.put("200", "1/5000s");
            f10877u.put("250", "1/4000s");
            f10877u.put("500", "1/2000s");
            f10877u.put("1000", "1/1000s");
            f10877u.put("2000", "1/500s");
            f10877u.put("5000", "1/200s");
            f10877u.put("10000", "1/100s");
            f10877u.put(Strategy.DEVICE_ERROR_CODE, "1/50s");
            f10877u.put("50000", "1/20s");
            f10877u.put("100000", "1/10s");
            f10877u.put("200000", "1/5s");
        }
        z = hVar.mo18211di() == 1 ? true : z;
        if (this.f10881r == null) {
            m11624e(z);
        }
        if (this.f10880q == null) {
            this.f10880q = mo20539R().mo18267u().mo22063Z();
            this.f10880q.mo22484a((MzManualUI.C2589b) this);
            this.f10880q.mo22483a(uVar);
            this.f10880q.mo22486a(this.f10881r, z, true);
            this.f10880q.mo22482a(hVar);
        }
        this.f10886x = hVar;
    }

    /* renamed from: a */
    public static boolean m11620a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f10867a, true, 4882, new Class[]{String.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : "meizu.intent.action.shortcut.BACK_MANUAL".equals(str);
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4883, new Class[0], Void.TYPE).isSupported) {
            m11613M();
            if (CameraController.m8868g().mo19522k() != null) {
                this.f10885w = CameraController.m8868g().mo19526m();
            } else {
                this.f10885w = ARPMessageType.MSG_TYPE_VIDEO_PAUSE;
            }
            this.f10880q.mo22490b();
            if (!this.f10788j.mo21590f()) {
                this.f10788j.mo21645x(false);
            }
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10867a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4884, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z && this.f10788j != null && (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2))) {
                m11613M();
            }
            if (!z2) {
                this.f10880q.mo22487a(!z);
            }
        }
    }

    /* renamed from: M */
    private void m11613M() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4885, new Class[0], Void.TYPE).isSupported) {
            if (CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 1) {
                mo20542U().mo21592g(MzUIController.f12297s);
                mo20542U().mo21506a(12);
            } else if ((DeviceHelper.f13894au || DeviceHelper.f13895av || DeviceHelper.f13896aw) && m11622ak()) {
                mo20542U().mo21592g(MzUIController.f12296r);
                mo20542U().mo21506a(269);
            } else {
                mo20542U().mo21506a(13);
                mo20542U().mo21592g(MzUIController.f12295q);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.mode.m$a */
    /* compiled from: ManualMode */
    public class C2189a {

        /* renamed from: a */
        public static ChangeQuickRedirect f10889a;

        /* renamed from: c */
        private String f10891c;

        /* renamed from: d */
        private ArrayList<String> f10892d;

        /* renamed from: e */
        private ArrayList<Integer> f10893e;

        /* renamed from: f */
        private ArrayList<Integer> f10894f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public ArrayList<String> f10895g;

        /* renamed from: h */
        private ArrayList<Integer> f10896h;

        /* renamed from: i */
        private String f10897i;

        /* renamed from: j */
        private int f10898j;

        /* renamed from: k */
        private String f10899k;

        /* renamed from: l */
        private String f10900l;

        /* renamed from: m */
        private int f10901m;

        /* renamed from: n */
        private int f10902n;

        /* renamed from: o */
        private int f10903o;

        /* renamed from: p */
        private boolean f10904p = true;

        /* renamed from: q */
        private boolean f10905q = true;

        public C2189a(String str, boolean z) {
            this.f10891c = str;
            int i = 0;
            if (ManualMode.f10870d.equals(str)) {
                String a = CameraController.m8868g().mo19451a(2, new boolean[0]);
                this.f10895g = CameraUtil.m15836a(a);
                this.f10899k = ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_iso_title);
                if (this.f10895g != null) {
                    if (!DeviceHelper.f13840T || DeviceHelper.f13910bJ != CameraController.CameraApi.API1) {
                        this.f10892d = CameraUtil.m15836a(a);
                        if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                            this.f10896h = CameraUtil.m15837a(this.f10895g, ManualMode.this.f10878o.getResources().getStringArray(R.array.mz_camera2_iso_entry));
                            this.f10896h.add(0, 0);
                        }
                    } else {
                        this.f10892d = new ArrayList<>();
                        this.f10892d.addAll(Arrays.asList(ManualMode.this.f10878o.getResources().getStringArray(R.array.mz_qualcomm_iso_entry)));
                        this.f10895g.remove("ISO_HJR");
                    }
                    if (this.f10892d != null) {
                        this.f10892d.set(0, ManualMode.this.f10878o.getResources().getString(R.string.auto));
                    }
                    if (DeviceHelper.f13929bc) {
                        this.f10901m = R.drawable.mz_manual_iso_on_two;
                        this.f10902n = R.drawable.mz_manual_iso_off_two;
                    } else {
                        this.f10901m = R.drawable.mz_manual_iso_on;
                        this.f10902n = R.drawable.mz_manual_iso_off;
                    }
                    this.f10903o = 0;
                }
                this.f10897i = ManualMode.this.f10878o.getResources().getString(R.string.auto);
            } else if (ManualMode.f10869c.equals(str) && DeviceHelper.f14037g != DeviceHelper.SHUTTER_SPEED.SPUNKNOW) {
                this.f10895g = CameraUtil.m15836a(CameraController.m8868g().mo19451a(1, new boolean[0]));
                if (DeviceHelper.f14037g != DeviceHelper.SHUTTER_SPEED.SP10S) {
                    if (DeviceHelper.f14037g == DeviceHelper.SHUTTER_SPEED.SP20S) {
                        String[] stringArray = ManualMode.this.f10878o.getResources().getStringArray(R.array.mz_20s_shutter_speed_filter_values);
                        if (DeviceHelper.f14051u || DeviceHelper.f14050t || DeviceHelper.f14049s) {
                            stringArray[1] = "2000";
                        }
                        if (DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                            this.f10896h = CameraUtil.m15837a(this.f10895g, ManualMode.this.f10878o.getResources().getStringArray(R.array.mz_camera2__shutter_speed_filter_values));
                        }
                    } else if (DeviceHelper.f14037g != DeviceHelper.SHUTTER_SPEED.SP120S) {
                        DeviceHelper.SHUTTER_SPEED shutter_speed = DeviceHelper.f14037g;
                        DeviceHelper.SHUTTER_SPEED shutter_speed2 = DeviceHelper.SHUTTER_SPEED.SP420S;
                    }
                }
                this.f10897i = "0";
                this.f10892d = m11666a(this.f10895g, ManualMode.f10877u);
                this.f10899k = ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_shutter_speed_title);
                if (this.f10895g != null) {
                    if (this.f10892d != null) {
                        this.f10892d.set(0, ManualMode.this.f10878o.getResources().getString(R.string.auto));
                    }
                    if (DeviceHelper.f13929bc) {
                        this.f10901m = R.drawable.mz_manual_shutter_speed_on_two;
                        this.f10902n = R.drawable.mz_manual_shutter_speed_off_two;
                    } else {
                        this.f10901m = R.drawable.mz_manual_shutter_speed_on;
                        this.f10902n = R.drawable.mz_manual_shutter_speed_off;
                    }
                    this.f10903o = 0;
                }
            } else if (ManualMode.f10871e.equals(str)) {
                this.f10899k = ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_exposure_title);
                int b = CameraController.m8868g().mo19487b();
                int c = CameraController.m8868g().mo19498c();
                float d = CameraController.m8868g().mo19504d();
                if (d != 0.0f && b > 0 && c < 0) {
                    this.f10892d = new ArrayList<>();
                    this.f10895g = new ArrayList<>();
                    if (DeviceHelper.f13937bk == DeviceHelper.EXPOSURE_STEP.STEP_POINT_ONE) {
                        if (!DeviceHelper.f13840T) {
                            b = b > 4 ? 4 : b;
                            if (c < -4) {
                                c = -4;
                            }
                        }
                        if (d < 0.4f) {
                            d *= 10.0f;
                            b *= 10;
                            c *= 10;
                        }
                        if (b > 0 && c < 0) {
                            float f = ((float) (b - c)) / d;
                            while (true) {
                                float f2 = (float) i;
                                if (f2 >= f) {
                                    break;
                                }
                                float f3 = (((float) c) + (f2 * d)) / 10.0f;
                                this.f10892d.add(m11664a(f3));
                                ArrayList<String> arrayList = this.f10895g;
                                arrayList.add("" + f3);
                                i++;
                            }
                            float f4 = ((float) b) / 10.0f;
                            this.f10892d.add(m11664a(f4));
                            ArrayList<String> arrayList2 = this.f10895g;
                            arrayList2.add("" + f4);
                            this.f10896h = CameraUtil.m15837a(this.f10895g, ManualMode.this.f10878o.getResources().getStringArray(R.array.mz_m80_exposure_filter_values));
                        }
                    } else if (DeviceHelper.f13937bk == DeviceHelper.EXPOSURE_STEP.STEP_NORMAL) {
                        if (!DeviceHelper.f13840T) {
                            b = b > 4 ? 4 : b;
                            if (c < -4) {
                                c = -4;
                            }
                        }
                        d = d <= 0.5f ? 1.0f : d;
                        if (b > 0 && c < 0) {
                            int i2 = (int) d;
                            int i3 = (b - c) / i2;
                            while (i < i3) {
                                int i4 = (i * i2) + c;
                                this.f10892d.add(m11664a((float) i4));
                                ArrayList<String> arrayList3 = this.f10895g;
                                arrayList3.add("" + i4);
                                i++;
                            }
                            this.f10892d.add(m11664a((float) b));
                            ArrayList<String> arrayList4 = this.f10895g;
                            arrayList4.add("" + b);
                        }
                        if (DeviceHelper.f14048r) {
                            this.f10896h = CameraUtil.m15837a(this.f10895g, ManualMode.this.f10878o.getResources().getStringArray(R.array.mz_m1721_exposure_filter_values));
                        }
                    } else {
                        LogUtil.C2630a L = ManualMode.f10876n;
                        LogUtil.m15942a(L, "step:" + d + "  max:" + b + "  min:" + c);
                        float floatValue = new BigDecimal(Integer.toString(b)).multiply(new BigDecimal(Float.toString(d))).setScale(2, 4).floatValue();
                        float floatValue2 = new BigDecimal(Integer.toString(c)).multiply(new BigDecimal(Float.toString(d))).setScale(2, 4).floatValue();
                        if (floatValue > 0.0f && floatValue2 < 0.0f) {
                            int intValue = new BigDecimal((double) (floatValue - floatValue2)).divide(new BigDecimal(Float.toString(d)), 0, 4).intValue() + 1;
                            for (int i5 = 0; i5 < intValue; i5++) {
                                float floatValue3 = new BigDecimal(Float.toString(floatValue2)).add(new BigDecimal(Integer.toString(i5)).multiply(new BigDecimal(Float.toString(d)))).setScale(2, 4).floatValue();
                                this.f10892d.add(m11664a(floatValue3));
                                this.f10895g.add(String.valueOf(floatValue3));
                            }
                            this.f10896h = new ArrayList<>();
                            while (i < this.f10895g.size()) {
                                float parseFloat = Float.parseFloat(this.f10895g.get(i));
                                if (parseFloat - ((float) ((int) parseFloat)) == 0.0f) {
                                    this.f10896h.add(Integer.valueOf(i));
                                }
                                i++;
                            }
                        }
                    }
                }
                this.f10897i = "0";
                if (DeviceHelper.f13929bc) {
                    this.f10901m = R.drawable.mz_manual_exposure_on_two;
                    this.f10902n = R.drawable.mz_manual_exposure_off_two;
                    this.f10903o = R.drawable.mz_manual_exposure_disable_two;
                    return;
                }
                this.f10901m = R.drawable.mz_manual_exposure_on;
                this.f10902n = R.drawable.mz_manual_exposure_off;
                this.f10903o = R.drawable.mz_manual_exposure_disable;
            } else if (ManualMode.f10872f.equals(str)) {
                if (DeviceHelper.f13929bc) {
                    this.f10901m = R.drawable.mz_manual_focus_on_two;
                    this.f10902n = R.drawable.mz_manual_focus_off_two;
                    this.f10903o = R.drawable.mz_manual_focus_disable_two;
                } else {
                    this.f10901m = R.drawable.mz_manual_focus_on;
                    this.f10902n = R.drawable.mz_manual_focus_off;
                    this.f10903o = R.drawable.mz_manual_focus_disable;
                }
                this.f10899k = ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_focus_title);
                this.f10892d = new ArrayList<>();
                this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.auto));
                this.f10895g = new ArrayList<>();
                this.f10895g.add("-1");
                for (int i6 = 10; i6 <= 100; i6 += 10) {
                    ArrayList<String> arrayList5 = this.f10892d;
                    arrayList5.add("" + i6);
                    ArrayList<String> arrayList6 = this.f10895g;
                    arrayList6.add("" + i6);
                }
                this.f10897i = "-1";
            } else if (ManualMode.f10873g.equals(str)) {
                if (DeviceHelper.f13929bc) {
                    this.f10901m = R.drawable.mz_manual_wb_on_two;
                    this.f10902n = R.drawable.mz_manual_wb_off_two;
                } else {
                    this.f10901m = R.drawable.mz_manual_wb_on;
                    this.f10902n = R.drawable.mz_manual_wb_off;
                }
                this.f10903o = 0;
                this.f10897i = "auto";
                this.f10899k = ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_wb_title);
                ArrayList<String> a2 = CameraUtil.m15836a(CameraController.m8868g().mo19451a(5, new boolean[0]));
                if (a2 != null) {
                    this.f10892d = new ArrayList<>();
                    this.f10895g = new ArrayList<>();
                    this.f10893e = new ArrayList<>();
                    this.f10894f = new ArrayList<>();
                    while (i < a2.size()) {
                        if (a2.get(i).equals("auto")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.auto));
                            this.f10893e.add(-1);
                            this.f10894f.add(-1);
                            this.f10895g.add("auto");
                        } else if (a2.get(i).equals("daylight")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_whitebalance_label_daylight));
                            this.f10893e.add(Integer.valueOf(R.drawable.ic_manual_sun));
                            this.f10894f.add(Integer.valueOf(R.drawable.ic_manual_sun_selected));
                            this.f10895g.add("daylight");
                        } else if (a2.get(i).equals("cloudy-daylight")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_whitebalance_label_cloudy));
                            this.f10893e.add(Integer.valueOf(R.drawable.ic_manual_lcloudy));
                            this.f10894f.add(Integer.valueOf(R.drawable.ic_manual_lcloudy_selected));
                            this.f10895g.add("cloudy-daylight");
                        } else if (a2.get(i).equals("incandescent")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_whitebalance_label_incandescent));
                            this.f10893e.add(Integer.valueOf(R.drawable.ic_manual_ltungstenlamp));
                            this.f10894f.add(Integer.valueOf(R.drawable.ic_manual_ltungstenlamp_selected));
                            this.f10895g.add("incandescent");
                        } else if (a2.get(i).equals("fluorescent")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_whitebalance_label_fluorescent));
                            this.f10893e.add(Integer.valueOf(R.drawable.ic_manual_ledlamp));
                            this.f10894f.add(Integer.valueOf(R.drawable.ic_manual_ledlamp_selected));
                            this.f10895g.add("fluorescent");
                        }
                        i++;
                    }
                }
            } else if (ManualMode.f10875m.equals(str)) {
                this.f10901m = R.drawable.mz_manual_camera_id_on_two;
                this.f10902n = R.drawable.mz_manual_camera_id_off_two;
                this.f10903o = R.drawable.mz_manual_camera_id_disable_two;
                this.f10899k = ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_camera_id_title);
                this.f10892d = new ArrayList<>();
                String[] stringArray2 = ManualMode.this.f10878o.getResources().getStringArray(R.array.mz_manual_camera_id_key_hint);
                int i7 = 0;
                while (i7 < stringArray2.length && (i7 != stringArray2.length - 1 || DeviceHelper.f14031dw)) {
                    this.f10892d.add(stringArray2[i7]);
                    i7++;
                }
                this.f10895g = new ArrayList<>();
                this.f10895g.add(String.valueOf(DeviceHelper.f14029du));
                this.f10895g.add(String.valueOf(0));
                if (DeviceHelper.f14031dw) {
                    this.f10895g.add(String.valueOf(DeviceHelper.f13949bw));
                }
                this.f10897i = "26mm";
            } else if (ManualMode.f10874l.equals(str)) {
                this.f10901m = R.drawable.mz_manual_scene_on;
                this.f10902n = R.drawable.mz_manual_scene_off;
                this.f10903o = 0;
                this.f10899k = ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_scene_title);
                this.f10897i = "auto";
                ArrayList<String> a3 = CameraUtil.m15836a(CameraController.m8868g().mo19451a(6, new boolean[0]));
                if (a3 != null) {
                    this.f10892d = new ArrayList<>();
                    this.f10895g = new ArrayList<>();
                    while (i < a3.size()) {
                        if (a3.get(i).equals("auto")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.auto));
                            this.f10895g.add("auto");
                        } else if (a3.get(i).equals("portrait")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_scenemode_label_portrait));
                            this.f10895g.add("portrait");
                        } else if (a3.get(i).equals("landscape")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_scenemode_label_landscape));
                            this.f10895g.add("landscape");
                        } else if (a3.get(i).equals("sports")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_scenemode_label_action));
                            this.f10895g.add("sports");
                        } else if (a3.get(i).equals("night")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_scenemode_label_night));
                            this.f10895g.add("night");
                        } else if (a3.get(i).equals("sunset")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_scenemode_label_sunset));
                            this.f10895g.add("sunset");
                        } else if (a3.get(i).equals("normal")) {
                            this.f10892d.add(ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_scenemode_label_normal));
                            this.f10895g.add("normal");
                        }
                        i++;
                    }
                }
            }
        }

        /* renamed from: a */
        private String m11664a(float f) {
            Object[] objArr = {new Float(f)};
            ChangeQuickRedirect changeQuickRedirect = f10889a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4923, new Class[]{Float.TYPE}, String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            String str = "";
            if (f > 0.0f) {
                str = "+";
            }
            int i = (int) f;
            if (f - ((float) i) == 0.0f) {
                return str + String.valueOf(i);
            }
            return str + String.valueOf(f);
        }

        /* renamed from: a */
        public void mo20585a(boolean z) {
            Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
            ChangeQuickRedirect changeQuickRedirect = f10889a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4924, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                this.f10905q = z;
                if (this.f10905q) {
                    return;
                }
                if (this.f10891c.equals(ManualMode.f10871e)) {
                    this.f10900l = "0";
                } else if (ManualMode.f10875m.equals(this.f10891c)) {
                    this.f10900l = ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_camera_id_normal);
                } else {
                    this.f10900l = ManualMode.this.f10878o.getResources().getString(R.string.auto);
                }
            }
        }

        /* renamed from: a */
        public boolean mo20586a() {
            return this.f10905q;
        }

        /* renamed from: b */
        public String mo20587b() {
            return this.f10891c;
        }

        /* renamed from: c */
        public String mo20588c() {
            return this.f10899k;
        }

        /* renamed from: d */
        public ArrayList<Integer> mo20589d() {
            return this.f10896h;
        }

        /* renamed from: a */
        public void mo20584a(int i) {
            if (i < 0) {
                i = 0;
            }
            if (this.f10898j != i) {
                this.f10898j = i;
                this.f10904p = true;
                return;
            }
            this.f10904p = false;
        }

        /* renamed from: e */
        public int mo20590e() {
            return this.f10898j;
        }

        /* renamed from: f */
        public String mo20591f() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10889a, false, 4926, new Class[0], String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            if (!this.f10905q || this.f10895g == null) {
                return this.f10900l;
            }
            if (ManualMode.f10872f.equals(this.f10891c)) {
                if (this.f10898j >= 1023) {
                    return "-1";
                }
                return this.f10898j + "";
            } else if (this.f10898j >= this.f10895g.size() || this.f10898j <= -1) {
                return mo20594i();
            } else {
                return this.f10895g.get(this.f10898j);
            }
        }

        /* renamed from: g */
        public String mo20592g() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10889a, false, 4927, new Class[0], String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            if (!this.f10905q || this.f10895g == null || this.f10892d == null) {
                LogUtil.C2630a L = ManualMode.f10876n;
                LogUtil.m15942a(L, "key: " + this.f10891c + " is Disabled or null");
                return this.f10900l;
            }
            if (ManualMode.f10872f.equals(this.f10891c)) {
                float f = ((float) (1023 - this.f10898j)) / 1023.0f;
                if (this.f10898j == 1023) {
                    return this.f10892d.get(0);
                }
                if (f > 0.0f && ((double) f) <= 0.4d) {
                    return ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_focus_marco);
                }
                double d = (double) f;
                if (d > 0.4d && d <= 0.8d) {
                    return ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_focus_standard);
                }
                if (d > 0.8d && f <= 1.0f) {
                    return ManualMode.this.f10878o.getResources().getString(R.string.mz_manual_focus_infinite);
                }
            }
            if (this.f10898j >= this.f10895g.size() || this.f10898j <= -1) {
                return mo20593h();
            }
            return this.f10892d.get(this.f10898j);
        }

        /* renamed from: h */
        public String mo20593h() {
            int i = 0;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10889a, false, 4928, new Class[0], String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            if (!this.f10905q || this.f10892d == null) {
                return this.f10900l;
            }
            int indexOf = this.f10892d.indexOf(this.f10897i);
            if (indexOf != -1) {
                i = indexOf;
            }
            if (ManualMode.f10872f.equals(this.f10891c)) {
                i = ARPMessageType.MSG_TYPE_VIDEO_PAUSE;
            }
            this.f10898j = i;
            return mo20592g();
        }

        /* renamed from: i */
        public String mo20594i() {
            int i = 0;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10889a, false, 4929, new Class[0], String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            if (!this.f10905q || this.f10895g == null) {
                return this.f10900l;
            }
            int indexOf = this.f10895g.indexOf(this.f10897i);
            if (indexOf != -1) {
                i = indexOf;
            }
            this.f10898j = i;
            return mo20591f();
        }

        /* renamed from: j */
        public int mo20595j() {
            return this.f10901m;
        }

        /* renamed from: k */
        public int mo20596k() {
            return this.f10902n;
        }

        /* renamed from: l */
        public int mo20597l() {
            return this.f10903o;
        }

        /* renamed from: m */
        public String[] mo20598m() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10889a, false, 4930, new Class[0], String[].class);
            return proxy.isSupported ? (String[]) proxy.result : (String[]) this.f10892d.toArray(new String[this.f10892d.size()]);
        }

        /* renamed from: n */
        public ArrayList<Integer> mo20599n() {
            return this.f10893e;
        }

        /* renamed from: o */
        public ArrayList<Integer> mo20600o() {
            return this.f10894f;
        }

        /* renamed from: a */
        private ArrayList<String> m11666a(ArrayList<String> arrayList, HashMap<String, String> hashMap) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{arrayList, hashMap}, this, f10889a, false, 4931, new Class[]{ArrayList.class, HashMap.class}, ArrayList.class);
            if (proxy.isSupported) {
                return (ArrayList) proxy.result;
            }
            if (arrayList == null || hashMap == null) {
                return null;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String str = hashMap.get(next);
                if (str == null) {
                    try {
                        float floatValue = Float.valueOf(next).floatValue() / 1000000.0f;
                        if (((double) floatValue) <= 0.3d) {
                            arrayList2.add(String.format("%d/%d", new Object[]{1, Integer.valueOf((int) ((1.0f / floatValue) + 0.5f))}) + NotifyType.SOUND);
                        } else {
                            int i = (int) floatValue;
                            if (((float) i) < floatValue) {
                                arrayList2.add(((((float) Math.round(floatValue * 10.0f)) * 1.0f) / 10.0f) + NotifyType.SOUND);
                            } else {
                                arrayList2.add(i + NotifyType.SOUND);
                            }
                        }
                    } catch (Exception unused) {
                        arrayList2.add(next);
                    }
                } else {
                    arrayList2.add(str);
                }
            }
            return arrayList2;
        }

        /* renamed from: p */
        public void mo20601p() {
            if (!PatchProxy.proxy(new Object[0], this, f10889a, false, 4932, new Class[0], Void.TYPE).isSupported && ManualMode.f10872f.equals(this.f10891c)) {
                int b = ManualMode.this.m11621aj();
                if (b == -1 || this.f10898j == 1023) {
                    this.f10898j = ARPMessageType.MSG_TYPE_VIDEO_PAUSE;
                } else if (b >= 1023) {
                    this.f10898j = ARPMessageType.MSG_TYPE_VIDEO_PLAY_RES;
                } else {
                    this.f10898j = ManualMode.this.m11621aj();
                }
            }
        }

        /* renamed from: q */
        public boolean mo20602q() {
            return this.f10904p;
        }
    }

    /* renamed from: b */
    public void mo20577b(String str) {
        if (PatchProxy.proxy(new Object[]{str}, this, f10867a, false, 4886, new Class[]{String.class}, Void.TYPE).isSupported || !this.f10881r.containsKey(str) || !this.f10881r.get(str).mo20586a()) {
            return;
        }
        if (f10869c.equals(str)) {
            m11615O();
            m11619a("mz_pref_shutterspeed_key", f10869c);
        } else if (f10870d.equals(str)) {
            m11619a("mz_pref_iso_key", f10870d);
        } else if (f10871e.equals(str)) {
            m11619a("pref_camera_exposure_key", f10871e);
        } else if (f10872f.equals(str) && DeviceHelper.f14037g != DeviceHelper.SHUTTER_SPEED.SPUNKNOW) {
            mo20580d(this.f10881r.get(str).mo20591f());
        } else if (f10873g.equals(str)) {
            m11619a("pref_camera_whitebalance_key", f10873g);
        } else if (f10874l.equals(str)) {
            m11619a("pref_camera_scenemode_key", f10874l);
        } else if (f10875m.equals(str)) {
            m11619a("pref_manual_camera_id_key", f10875m);
        }
    }

    /* renamed from: c */
    public void mo20579c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10867a, false, 4887, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f10886x.mo17936d(Integer.parseInt(this.f10881r.get(str).mo20591f()));
        }
    }

    /* renamed from: a */
    public void mo20576a(boolean z) {
        this.f10883t = z;
    }

    /* renamed from: c */
    public void mo20578c() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4888, new Class[0], Void.TYPE).isSupported && mo20541T() != null) {
            mo20541T().mo20317a(4, new boolean[0]);
        }
    }

    /* renamed from: a */
    private void m11619a(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f10867a, false, 4889, clsArr, Void.TYPE).isSupported && mo20539R() != null && this.f10881r != null && this.f10881r.containsKey(str2)) {
            CameraSettings.m9781a(mo20539R().mo17902aE(), str, this.f10881r.get(str2).mo20591f());
            LogUtil.C2630a aVar = LogUtil.f14072b;
            LogUtil.m15942a(aVar, "ManualMode pkey:" + str + "  value:" + this.f10881r.get(str2).mo20591f());
        }
    }

    /* renamed from: N */
    private void m11614N() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4890, new Class[0], Void.TYPE).isSupported && mo20539R() != null) {
            mo20539R().mo17902aE().edit().remove("pref_camera_exposure_key").remove("pref_camera_whitebalance_key").remove("mz_pref_shutterspeed_key").remove("mz_pref_iso_key").remove("mz_pref_saturation").remove("mz_pref_contrast").remove("pref_camera_scenemode_key").apply();
        }
    }

    /* renamed from: O */
    private void m11615O() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4891, new Class[0], Void.TYPE).isSupported && this.f10881r != null && this.f10881r.get(f10869c) != null) {
            if (this.f10881r.get(f10869c).mo20590e() != 0) {
                mo20542U().mo21571c();
            } else {
                mo20542U().mo21578d();
            }
        }
    }

    /* renamed from: m */
    public boolean mo20410m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10867a, false, 4892, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f10880q.mo22503i()) {
            return false;
        }
        this.f10880q.mo22498e(false);
        return true;
    }

    /* renamed from: e */
    private void m11624e(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f10867a, false, 4893, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f10876n;
            LogUtil.m15942a(aVar, "initManualData isFront " + z);
            if (this.f10881r == null) {
                this.f10881r = new HashMap<>();
            }
            this.f10881r.clear();
            this.f10888z = false;
            try {
                if (DeviceHelper.f13838R) {
                    C2189a aVar2 = new C2189a(f10871e, z);
                    if (aVar2.f10895g != null) {
                        this.f10881r.put(f10871e, aVar2);
                    } else {
                        this.f10881r.put(f10871e, aVar2);
                        aVar2.mo20585a(false);
                    }
                    C2189a aVar3 = new C2189a(f10872f, z);
                    if (aVar3.f10895g != null) {
                        this.f10881r.put(f10872f, aVar3);
                    } else {
                        this.f10881r.put(f10872f, aVar3);
                        aVar3.mo20585a(false);
                    }
                    C2189a aVar4 = new C2189a(f10870d, z);
                    if (aVar4.f10895g != null) {
                        this.f10881r.put(f10870d, aVar4);
                    } else {
                        this.f10881r.put(f10870d, aVar4);
                        aVar4.mo20585a(false);
                    }
                    C2189a aVar5 = new C2189a(f10869c, z);
                    if (aVar5.f10895g != null) {
                        this.f10881r.put(f10869c, aVar5);
                    } else {
                        this.f10881r.put(f10869c, aVar5);
                        aVar5.mo20585a(false);
                    }
                    C2189a aVar6 = new C2189a(f10873g, z);
                    if (aVar6.f10895g != null) {
                        this.f10881r.put(f10873g, aVar6);
                    } else {
                        this.f10881r.put(f10873g, aVar6);
                        aVar6.mo20585a(false);
                    }
                    C2189a aVar7 = new C2189a(f10875m, z);
                    if (aVar7.f10895g != null) {
                        this.f10881r.put(f10875m, aVar7);
                    } else {
                        this.f10881r.put(f10875m, aVar7);
                        aVar7.mo20585a(false);
                    }
                    if (ApiHelper.f14208i) {
                        C2189a aVar8 = new C2189a(f10874l, z);
                        if (aVar8.f10895g != null) {
                            this.f10881r.put(f10874l, aVar8);
                            return;
                        }
                        return;
                    }
                    return;
                }
                C2189a aVar9 = new C2189a(f10871e, z);
                if (aVar9.f10895g != null) {
                    this.f10881r.put(f10871e, aVar9);
                } else {
                    this.f10881r.put(f10871e, aVar9);
                    aVar9.mo20585a(false);
                }
                C2189a aVar10 = new C2189a(f10873g, z);
                if (aVar10.f10895g != null) {
                    this.f10881r.put(f10873g, aVar10);
                    return;
                }
                this.f10881r.put(f10873g, aVar10);
                aVar10.mo20585a(false);
            } catch (CameraController.C1881g e) {
                LogUtil.m15949b(f10876n, e.toString());
                this.f10888z = true;
            }
        }
    }

    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.MANUAL;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4894, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f10876n, "release");
            this.f10884v = true;
            m11614N();
            mo20578c();
            this.f10880q.mo22493c();
            this.f10885w = -1;
            this.f10887y = -1;
            if (!DeviceHelper.f13840T) {
                mo20580d("-1");
            }
            this.f10788j.mo21487J();
            this.f10788j.mo21512a(0);
            if (DeviceHelper.f13895av || DeviceHelper.f13896aw) {
                this.f10879p.mo20337d(false);
            }
            this.f10788j.mo21533a(false, false, false);
        }
    }

    /* renamed from: P */
    private void m11616P() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4897, new Class[0], Void.TYPE).isSupported && this.f10881r != null && !this.f10888z) {
            mo20577b(f10869c);
            mo20577b(f10870d);
            mo20577b(f10871e);
            mo20577b(f10873g);
            mo20577b(f10872f);
            mo20577b(f10875m);
        }
    }

    /* renamed from: i_ */
    public void mo20405i_() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4898, new Class[0], Void.TYPE).isSupported) {
            mo20381E();
            mo20542U().mo21512a(0);
            this.f10880q.mo22504j();
        }
    }

    /* renamed from: n */
    public boolean mo20411n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10867a, false, 4899, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f10880q.mo22496d(true);
        return false;
    }

    /* renamed from: l_ */
    public boolean mo20409l_() {
        return this.f10882s;
    }

    /* renamed from: a */
    public boolean mo20394a(UUID uuid) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f10867a, false, 4900, new Class[]{UUID.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f10880q.mo22500f(false);
        long j = 0;
        if (DeviceHelper.f14037g != DeviceHelper.SHUTTER_SPEED.SPUNKNOW && this.f10881r != null && this.f10881r.containsKey(f10869c) && this.f10881r.get(f10869c).mo20586a()) {
            j = DeviceHelper.f13910bJ == CameraController.CameraApi.API1 ? Long.valueOf(this.f10881r.get(f10869c).mo20591f()).longValue() / 1000 : (long) (Double.valueOf(this.f10881r.get(f10869c).mo20591f()).doubleValue() / 1000.0d);
        }
        if (j > f10868b) {
            mo20542U().mo21581d(132, false);
            mo20542U().mo21574c(132, false);
            mo20542U().mo21506a(0);
            this.f10886x.mo18267u().mo22086a(false, 0);
            this.f10882s = true;
            this.f10880q.mo22492b(true);
        }
        return false;
    }

    /* renamed from: W */
    public void mo20544W() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4901, new Class[0], Void.TYPE).isSupported) {
            long B = mo20575B();
            mo20542U().mo21512a(B);
            if (B > f10868b) {
                this.f10880q.mo22494c(true);
            }
        }
    }

    /* renamed from: x */
    public boolean mo20421x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10867a, false, 4902, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f10880q.mo22503i()) {
            return false;
        }
        this.f10880q.mo22498e(false);
        return true;
    }

    /* renamed from: C */
    public void mo20379C() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4903, new Class[0], Void.TYPE).isSupported) {
            if (this.f10880q != null) {
                this.f10880q.mo22498e(this.f10883t);
            }
            m11614N();
        }
    }

    /* renamed from: m_ */
    public void mo20492m_() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4904, new Class[0], Void.TYPE).isSupported) {
            CameraProxy k = CameraController.m8868g().mo19522k();
            if (!(k == null || this.f10880q == null || this.f10887y == this.f10886x.mo18211di())) {
                this.f10887y = k.mo19733b();
                boolean z = true;
                if (this.f10887y != 1) {
                    z = false;
                }
                if (!this.f10883t) {
                    mo20581d(z);
                }
                m11617Q();
                if (this.f10883t) {
                    this.f10881r.remove(f10869c);
                    C2189a aVar = new C2189a(f10869c, z);
                    if (aVar.f10895g != null) {
                        this.f10881r.put(f10869c, aVar);
                    } else {
                        this.f10881r.put(f10869c, aVar);
                        aVar.mo20585a(false);
                    }
                    this.f10880q.mo22485a(this.f10881r, z);
                }
                this.f10883t = false;
            }
            if (this.f10788j.mo21608k()) {
                this.f10881r.get(f10875m).mo20585a(false);
                this.f10880q.mo22502h();
            }
        }
    }

    /* renamed from: Q */
    private void m11617Q() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4905, new Class[0], Void.TYPE).isSupported) {
            if (DeviceHelper.f14027ds && this.f10886x.mo18211di() == DeviceHelper.f14029du) {
                List<CameraController.FocusMode> Z = CameraController.m8868g().mo19448Z();
                if (Z.size() == 1 && Z.get(0) == CameraController.FocusMode.FIXED) {
                    this.f10881r.get(f10872f).mo20585a(false);
                } else if (!this.f10881r.get(f10872f).mo20586a()) {
                    this.f10881r.get(f10872f).mo20585a(true);
                }
            } else if (!this.f10881r.get(f10872f).mo20586a()) {
                this.f10881r.get(f10872f).mo20585a(true);
            }
        }
    }

    /* renamed from: a */
    public void mo20386a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f10867a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4906, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.mo20386a(i);
            LogUtil.m15952c(f10876n, "onCameraOpened entry");
            if (this.f10888z) {
                LogUtil.m15952c(f10876n, "bad ManualData,need to be updated");
                mo20582q();
            }
        }
    }

    /* renamed from: q */
    public void mo20582q() {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4907, new Class[0], Void.TYPE).isSupported) {
            CameraProxy k = CameraController.m8868g().mo19522k();
            LogUtil.C2630a aVar = f10876n;
            LogUtil.m15952c(aVar, "refreshManualData:deviceProxy=" + k + " mManualUI" + this.f10880q);
            if (k != null && this.f10880q != null) {
                LogUtil.m15952c(f10876n, "refreshManualData begin");
                this.f10887y = k.mo19733b();
                if (this.f10887y == 1) {
                    z = true;
                }
                mo20581d(z);
            }
        }
    }

    /* renamed from: d */
    public void mo20581d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10867a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4908, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            m11624e(z);
            this.f10880q.mo22486a(this.f10881r, z, this.f10883t);
            this.f10880q.mo22481a(this.f10885w);
        }
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4909, new Class[0], Void.TYPE).isSupported) {
            m11613M();
            mo20402f_();
            m11616P();
            mo20578c();
            m11615O();
        }
    }

    /* renamed from: Z */
    public void mo20451Z() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4910, new Class[0], Void.TYPE).isSupported) {
            super.mo20451Z();
            if (this.f10880q != null) {
                this.f10880q.mo22497e();
            }
            this.f10788j.mo21645x(false);
            this.f10788j.mo21583e();
        }
    }

    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10867a, false, 4911, new Class[0], CameraController.FocusMode.class);
        if (proxy.isSupported) {
            return (CameraController.FocusMode) proxy.result;
        }
        if ((DeviceHelper.f13839S || DeviceHelper.f13840T || DeviceHelper.f13826F || DeviceHelper.f14047q || DeviceHelper.f13832L) && this.f10881r != null && this.f10881r.containsKey(f10872f) && !"-1".equals(this.f10881r.get(f10872f).mo20591f())) {
            return CameraController.m8868g().mo19509e();
        }
        return CameraController.FocusMode.CONTINUOUS_PICTURE;
    }

    /* renamed from: a */
    public void mo20496a() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4912, new Class[0], Void.TYPE).isSupported) {
            this.f10880q.mo22492b(false);
            this.f10880q.mo22494c(false);
            mo20542U().mo21581d(132, true);
            mo20542U().mo21574c(132, true);
            mo20542U().mo21510a(-1, true);
            if ((DeviceHelper.f13894au || DeviceHelper.f13895av || DeviceHelper.f13896aw) && m11622ak()) {
                mo20542U().mo21506a(269);
            } else {
                mo20542U().mo21506a(13);
            }
            m11615O();
        }
    }

    /* renamed from: D */
    public void mo20380D() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4913, new Class[0], Void.TYPE).isSupported) {
            this.f10880q.mo22500f(true);
            if (!mo20542U().mo21477A()) {
                this.f10880q.mo22496d(false);
            }
            if (this.f10882s) {
                mo20542U().mo21581d(132, true);
                mo20542U().mo21574c(132, true);
            }
            if (!this.f10880q.mo22503i() && this.f10886x.mo17873V()) {
                this.f10886x.mo18267u().mo22086a(true, 1);
            }
            this.f10882s = false;
            this.f10880q.mo22492b(false);
            this.f10880q.mo22494c(false);
            if (CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 1) {
                mo20542U().mo21506a(12);
            } else if ((DeviceHelper.f13894au || DeviceHelper.f13895av || DeviceHelper.f13896aw) && m11622ak()) {
                mo20542U().mo21506a(269);
            } else {
                mo20542U().mo21506a(13);
            }
            m11615O();
        }
    }

    /* renamed from: E */
    public void mo20381E() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4914, new Class[0], Void.TYPE).isSupported) {
            this.f10880q.mo22500f(true);
            if (!mo20542U().mo21477A()) {
                this.f10880q.mo22496d(false);
            }
            if (this.f10882s) {
                mo20542U().mo21581d(132, true);
                mo20542U().mo21574c(132, true);
                mo20542U().mo21597h(4);
            }
            if (!this.f10880q.mo22503i() && this.f10886x.mo17873V()) {
                this.f10886x.mo18267u().mo22086a(true, 1);
            }
            this.f10882s = false;
            this.f10880q.mo22492b(false);
            this.f10880q.mo22494c(false);
            if (CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 1) {
                mo20542U().mo21506a(12);
            } else if ((DeviceHelper.f13894au || DeviceHelper.f13895av || DeviceHelper.f13896aw) && m11622ak()) {
                mo20542U().mo21506a(269);
            } else {
                mo20542U().mo21506a(13);
            }
            m11615O();
        }
    }

    /* renamed from: r */
    public void mo20583r() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4915, new Class[0], Void.TYPE).isSupported && this.f10880q != null && this.f10881r != null) {
            this.f10881r.get(f10872f).mo20601p();
            this.f10880q.mo22499f();
        }
    }

    /* renamed from: d */
    public void mo20580d(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f10867a, false, 4916, new Class[]{String.class}, Void.TYPE).isSupported) {
            CameraController.m8868g().mo19471a(f10872f, this.f10884v ? "-1" : str, new boolean[0]);
            if (str != null && !str.equals("-1") && this.f10886x.mo17914ak() != null) {
                this.f10886x.mo17914ak().mo20223g();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aj */
    public int m11621aj() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10867a, false, 4917, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        return CameraController.m8868g().mo19522k() != null ? CameraController.m8868g().mo19526m() : ARPMessageType.MSG_TYPE_VIDEO_PAUSE;
    }

    /* renamed from: ak */
    private boolean m11622ak() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10867a, false, 4918, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        Point j = CameraController.m8868g().mo19520j();
        if (j != null && ((double) Math.abs((((float) j.x) / ((float) j.y)) - 1.3333334f)) < 0.01d) {
            return true;
        }
        return false;
    }

    /* renamed from: A */
    public int mo20377A() {
        return DeviceHelper.f13897ax ? 1 : 0;
    }

    /* renamed from: aa */
    public void mo20548aa() {
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4919, new Class[0], Void.TYPE).isSupported && DeviceHelper.f13841U) {
            CameraController.m8868g().mo19471a(f10872f, "-1", new boolean[0]);
        }
    }

    /* renamed from: b */
    public void mo20516b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10867a, false, 4920, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && i != 0 && this.f10881r.get(f10869c) != null && this.f10881r.get(f10869c).mo20586a()) {
            this.f10881r.get(f10869c).mo20584a(0);
            mo20577b(f10869c);
            this.f10880q.mo22501g();
        }
    }

    /* renamed from: B */
    public long mo20575B() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10867a, false, 4921, new Class[0], Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        if (DeviceHelper.f14037g == DeviceHelper.SHUTTER_SPEED.SPUNKNOW || this.f10881r == null || !this.f10881r.containsKey(f10869c) || !this.f10881r.get(f10869c).mo20586a()) {
            return 0;
        }
        if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
            return Long.valueOf(this.f10881r.get(f10869c).mo20591f()).longValue() / 1000;
        }
        return (long) (Double.valueOf(this.f10881r.get(f10869c).mo20591f()).doubleValue() / 1000.0d);
    }

    /* renamed from: I */
    public void mo20384I() {
        String str;
        FocusOverlayManager ak;
        CameraController.FocusMode h;
        if (!PatchProxy.proxy(new Object[0], this, f10867a, false, 4922, new Class[0], Void.TYPE).isSupported) {
            Map<String, String> a = UsageStatsHelper.m16042a(this.f10878o).mo22688a(new String[]{"mode", "count_down", "location", "capture_type", "voice", "meshline", "level", "time_mark", "sd_card"});
            if (this.f10881r.get(f10869c) != null) {
                a.put("manual_shutter", this.f10881r.get(f10869c).mo20591f());
            }
            if (this.f10881r.get(f10871e) != null) {
                a.put("manual_exposure", this.f10881r.get(f10871e).mo20591f());
            }
            if (this.f10881r.get(f10870d) != null) {
                a.put("manual_iso", this.f10881r.get(f10870d).mo20591f());
            }
            if (this.f10881r.get(f10873g) != null) {
                a.put("manual_white_balance", this.f10881r.get(f10873g).mo20591f());
            }
            if (this.f10881r.get(f10872f) != null) {
                a.put("manual_focus", this.f10881r.get(f10872f).mo20591f());
            }
            a.put("zoom", Integer.toString(this.f10886x.mo18267u().mo22199w()));
            a.put("capture_time", Long.toString(this.f10886x.mo18186dJ()));
            a.put("flash", CameraController.m8868g().mo19534q().key);
            if (DeviceHelper.f13896aw) {
                a.put("64M", mo20542U().mo21608k() ? "1" : "0");
            } else if (DeviceHelper.f13895av) {
                a.put("48M", mo20542U().mo21608k() ? "1" : "0");
            } else {
                a.put("20M", mo20542U().mo21608k() ? "1" : "0");
            }
            Point j = CameraController.m8868g().mo19520j();
            if (j == null) {
                str = "error size";
            } else {
                str = DeviceSizeTable.m16186a(j.x + "x" + j.y);
            }
            a.put("picture_ratio", str);
            String str2 = "error mode";
            if (!(this.f10886x.mo17914ak() == null || (ak = this.f10886x.mo17914ak()) == null || (h = ak.mo20225h()) == null)) {
                str2 = h.getKey();
            }
            a.put("focus_mode", str2);
            if (!(!DeviceHelper.f13879af || CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() == 1) || (DeviceHelper.f13882ai && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19522k().mo19733b() == 1)) {
                a.put("device_mark", UsageStatsHelper.m16051e());
            }
            if (DeviceHelper.f14027ds) {
                a.put("wide_angle", CameraController.m8868g().mo19522k().mo19733b() == DeviceHelper.f14029du ? "1" : "0");
            }
            if (DeviceHelper.f14031dw) {
                a.put("telephoto_lens", CameraController.m8868g().mo19522k().mo19733b() == DeviceHelper.f13949bw ? "1" : "0");
            }
            UsageStatsHelper.m16042a(this.f10878o).mo22693a("capture_info", a);
        }
    }
}
