package com.meizu.media.camera.util;

import android.content.Context;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.UsageStatsProxy3;
import java.util.Map;

/* renamed from: com.meizu.media.camera.util.at */
public final class UsageStatsHelper {

    /* renamed from: A */
    private static String f14150A = "false";

    /* renamed from: B */
    private static String f14151B = Contants.AsdSceneType.AUTO.getTitle();

    /* renamed from: C */
    private static String f14152C = "false";

    /* renamed from: D */
    private static String f14153D = "0";

    /* renamed from: E */
    private static String f14154E = "1";

    /* renamed from: F */
    private static long f14155F = 0;

    /* renamed from: a */
    public static ChangeQuickRedirect f14156a;

    /* renamed from: b */
    public static String f14157b = "page_main_camera";

    /* renamed from: c */
    public static String f14158c = "";

    /* renamed from: d */
    private static final LogUtil.C2630a f14159d = new LogUtil.C2630a("UsageStatsHelper");

    /* renamed from: e */
    private static UsageStatsHelper f14160e = null;

    /* renamed from: f */
    private static boolean f14161f = true;

    /* renamed from: g */
    private static int f14162g = 0;

    /* renamed from: h */
    private static String f14163h = "AUTO";

    /* renamed from: i */
    private static String f14164i = "0";

    /* renamed from: j */
    private static String f14165j = "0";

    /* renamed from: k */
    private static String f14166k = "none";

    /* renamed from: l */
    private static String f14167l = "1";

    /* renamed from: m */
    private static String f14168m = "0";

    /* renamed from: n */
    private static String f14169n = "false";

    /* renamed from: o */
    private static String f14170o = "0";

    /* renamed from: p */
    private static String f14171p = "false";

    /* renamed from: q */
    private static String f14172q = "false";

    /* renamed from: r */
    private static String f14173r = "false";

    /* renamed from: s */
    private static String f14174s = "false";

    /* renamed from: t */
    private static String f14175t = "false";

    /* renamed from: u */
    private static String f14176u = "false";

    /* renamed from: v */
    private static String f14177v = "false";

    /* renamed from: w */
    private static String f14178w = "false";

    /* renamed from: x */
    private static String f14179x = "false";

    /* renamed from: y */
    private static String f14180y = "false";

    /* renamed from: z */
    private static String f14181z = "false";

    /* renamed from: G */
    private Context f14182G;

    /* renamed from: H */
    private UsageStatsProxy3 f14183H = null;

    /* renamed from: a */
    public static UsageStatsHelper m16042a(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f14156a, true, 8230, new Class[]{Context.class}, UsageStatsHelper.class);
        if (proxy.isSupported) {
            return (UsageStatsHelper) proxy.result;
        }
        if (f14160e == null) {
            f14160e = new UsageStatsHelper(context);
            if (f14160e.f14183H == null) {
                f14160e.f14182G = context;
                m16053j();
            }
        } else if (f14160e.f14183H == null) {
            f14160e.f14182G = context;
            m16053j();
        }
        return f14160e;
    }

    /* renamed from: a */
    public static void m16047a(boolean z, boolean z2, boolean z3) {
        if (z) {
            f14157b = "page_watch_camera";
        } else if (z2) {
            f14157b = "page_image_capture";
        } else if (z3) {
            f14157b = "page_video_capture";
        } else {
            f14157b = "page_main_camera";
        }
    }

    /* renamed from: a */
    public static void m16045a(String str) {
        f14157b = str;
    }

    /* renamed from: a */
    public static void m16046a(boolean z) {
        f14161f = z;
    }

    /* renamed from: a */
    public static void m16044a(int i) {
        f14162g = i;
    }

    /* renamed from: b */
    public static void m16049b(boolean z) {
        f14180y = z ? "true" : "false";
    }

    /* renamed from: a */
    public static String m16043a() {
        return f14165j;
    }

    private UsageStatsHelper(Context context) {
        this.f14182G = context;
        m16053j();
    }

    /* renamed from: j */
    private static void m16053j() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f14156a, true, 8231, new Class[0], Void.TYPE).isSupported) {
            try {
                f14160e.f14183H = UsageStatsProxy3.getInstance();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    private void m16048b(String str, Map<String, String> map) {
        Class[] clsArr = {String.class, Map.class};
        if (!PatchProxy.proxy(new Object[]{str, map}, this, f14156a, false, 8232, clsArr, Void.TYPE).isSupported && !"camera_start_up_time".equals(str)) {
            StringBuilder sb = new StringBuilder(str + " | ");
            for (String next : map.keySet()) {
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
                sb.append(" | ");
            }
            LogUtil.C2630a aVar = f14159d;
            LogUtil.m15942a(aVar, "---eventName:" + sb);
        }
    }

    /* renamed from: b */
    public void mo22695b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f14156a, false, 8233, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (m16057z(str) != null) {
                Map<String, String> a = mo22688a(m16057z(str));
                m16048b(str, a);
                mo22692a(str, f14157b, a);
                return;
            }
            LogUtil.C2630a aVar = f14159d;
            LogUtil.m15942a(aVar, "---eventName:" + str);
            mo22692a(str, f14157b, (Map<String, String>) null);
        }
    }

    /* renamed from: a */
    public void mo22691a(String str, String str2, String str3) {
        Class[] clsArr = {String.class, String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2, str3}, this, f14156a, false, 8234, clsArr, Void.TYPE).isSupported) {
            Map<String, String> a = mo22688a(m16057z(str));
            if (str2 != null) {
                a.put(str2, str3);
            }
            m16048b(str, a);
            mo22692a(str, f14157b, a);
        }
    }

    /* renamed from: a */
    public void mo22693a(String str, Map<String, String> map) {
        Class[] clsArr = {String.class, Map.class};
        if (!PatchProxy.proxy(new Object[]{str, map}, this, f14156a, false, 8235, clsArr, Void.TYPE).isSupported) {
            if (str.equals("capture_info")) {
                f14158c = map.get("capture_time");
            }
            m16048b(str, map);
            mo22692a(str, f14157b, map);
        }
    }

    /* renamed from: a */
    public void mo22692a(String str, String str2, Map<String, String> map) {
        Class[] clsArr = {String.class, String.class, Map.class};
        if (!PatchProxy.proxy(new Object[]{str, str2, map}, this, f14156a, false, 8236, clsArr, Void.TYPE).isSupported && this.f14183H != null && f14161f) {
            this.f14183H.onEvent(str, str2, map);
        }
    }

    /* renamed from: b */
    public void mo22694b() {
        if (!PatchProxy.proxy(new Object[0], this, f14156a, false, 8237, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f14159d;
            LogUtil.m15942a(aVar, "startRecordUsageStats: " + f14157b);
            m16055l();
        }
    }

    /* renamed from: c */
    public void mo22697c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f14156a, false, 8238, new Class[]{String.class}, Void.TYPE).isSupported && this.f14182G != null && !DeviceUtil.m16197a(this.f14182G) && this.f14183H != null) {
            this.f14183H.onPageStart(str);
        }
    }

    /* renamed from: c */
    public void mo22696c() {
        if (!PatchProxy.proxy(new Object[0], this, f14156a, false, 8239, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f14159d;
            LogUtil.m15942a(aVar, "stopRecordUsageStats: " + f14157b);
            f14158c = "";
            m16054k();
        }
    }

    /* renamed from: d */
    public void mo22699d(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f14156a, false, 8240, new Class[]{String.class}, Void.TYPE).isSupported && this.f14183H != null) {
            this.f14183H.onPageStop(str);
        }
    }

    /* renamed from: k */
    private void m16054k() {
        if (!PatchProxy.proxy(new Object[0], this, f14156a, false, 8241, new Class[0], Void.TYPE).isSupported && this.f14183H != null) {
            this.f14183H.onPageStop(f14157b);
        }
    }

    /* renamed from: l */
    private boolean m16055l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14156a, false, 8242, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f14182G == null || this.f14183H == null) {
            return true;
        }
        this.f14183H.onPageStart(f14157b);
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.String> mo22688a(java.lang.String[] r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f14156a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String[]> r2 = java.lang.String[].class
            r6[r8] = r2
            java.lang.Class<java.util.Map> r7 = java.util.Map.class
            r4 = 0
            r5 = 8243(0x2033, float:1.1551E-41)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x0021
            java.lang.Object r10 = r1.result
            java.util.Map r10 = (java.util.Map) r10
            return r10
        L_0x0021:
            if (r10 != 0) goto L_0x0029
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            return r10
        L_0x0029:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            int r2 = r10.length
            r3 = 0
        L_0x0030:
            if (r3 >= r2) goto L_0x0276
            r4 = r10[r3]
            r5 = -1
            int r6 = r4.hashCode()
            switch(r6) {
                case -1816574486: goto L_0x014f;
                case -1543100650: goto L_0x0144;
                case -1470534235: goto L_0x0139;
                case -1073910849: goto L_0x012e;
                case -1035608622: goto L_0x0123;
                case -889919583: goto L_0x0119;
                case -865465158: goto L_0x010e;
                case -471922847: goto L_0x0103;
                case 96882: goto L_0x00f8;
                case 100431: goto L_0x00ec;
                case 103158: goto L_0x00e0;
                case 3357091: goto L_0x00d5;
                case 36447487: goto L_0x00ca;
                case 99119839: goto L_0x00be;
                case 102865796: goto L_0x00b2;
                case 112386354: goto L_0x00a6;
                case 311190512: goto L_0x009a;
                case 767090726: goto L_0x008e;
                case 767106195: goto L_0x0083;
                case 1151251944: goto L_0x0078;
                case 1243655778: goto L_0x006c;
                case 1261320785: goto L_0x0061;
                case 1740280767: goto L_0x0055;
                case 1901043637: goto L_0x0049;
                case 1937403966: goto L_0x003e;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x0159
        L_0x003e:
            java.lang.String r6 = "sd_card"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 2
            goto L_0x015a
        L_0x0049:
            java.lang.String r6 = "location"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 12
            goto L_0x015a
        L_0x0055:
            java.lang.String r6 = "watch_projection"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 18
            goto L_0x015a
        L_0x0061:
            java.lang.String r6 = "num_filter"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 6
            goto L_0x015a
        L_0x006c:
            java.lang.String r6 = "funny_mark"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 16
            goto L_0x015a
        L_0x0078:
            java.lang.String r6 = "is_back_camera"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 1
            goto L_0x015a
        L_0x0083:
            java.lang.String r6 = "capture_type"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 3
            goto L_0x015a
        L_0x008e:
            java.lang.String r6 = "capture_time"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 20
            goto L_0x015a
        L_0x009a:
            java.lang.String r6 = "asd_enable"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 22
            goto L_0x015a
        L_0x00a6:
            java.lang.String r6 = "voice"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 8
            goto L_0x015a
        L_0x00b2:
            java.lang.String r6 = "level"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 10
            goto L_0x015a
        L_0x00be:
            java.lang.String r6 = "hd_fb"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 17
            goto L_0x015a
        L_0x00ca:
            java.lang.String r6 = "time_mark"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 7
            goto L_0x015a
        L_0x00d5:
            java.lang.String r6 = "mode"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 0
            goto L_0x015a
        L_0x00e0:
            java.lang.String r6 = "hdr"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 11
            goto L_0x015a
        L_0x00ec:
            java.lang.String r6 = "eis"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 24
            goto L_0x015a
        L_0x00f8:
            java.lang.String r6 = "asd"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 21
            goto L_0x015a
        L_0x0103:
            java.lang.String r6 = "meshline"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 9
            goto L_0x015a
        L_0x010e:
            java.lang.String r6 = "tripod"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 23
            goto L_0x015a
        L_0x0119:
            java.lang.String r6 = "filter_type"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 5
            goto L_0x015a
        L_0x0123:
            java.lang.String r6 = "count_down"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 14
            goto L_0x015a
        L_0x012e:
            java.lang.String r6 = "mirror"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 13
            goto L_0x015a
        L_0x0139:
            java.lang.String r6 = "night_scene"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 19
            goto L_0x015a
        L_0x0144:
            java.lang.String r6 = "device_mark"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 15
            goto L_0x015a
        L_0x014f:
            java.lang.String r6 = "filter_value"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0159
            r4 = 4
            goto L_0x015a
        L_0x0159:
            r4 = -1
        L_0x015a:
            switch(r4) {
                case 0: goto L_0x026b;
                case 1: goto L_0x0256;
                case 2: goto L_0x024a;
                case 3: goto L_0x023e;
                case 4: goto L_0x0236;
                case 5: goto L_0x022e;
                case 6: goto L_0x0226;
                case 7: goto L_0x021e;
                case 8: goto L_0x0216;
                case 9: goto L_0x020e;
                case 10: goto L_0x0206;
                case 11: goto L_0x01fd;
                case 12: goto L_0x01f4;
                case 13: goto L_0x01e1;
                case 14: goto L_0x01d8;
                case 15: goto L_0x01cf;
                case 16: goto L_0x01c6;
                case 17: goto L_0x01a5;
                case 18: goto L_0x0272;
                case 19: goto L_0x0198;
                case 20: goto L_0x018f;
                case 21: goto L_0x017e;
                case 22: goto L_0x0171;
                case 23: goto L_0x0168;
                case 24: goto L_0x015f;
                default: goto L_0x015d;
            }
        L_0x015d:
            goto L_0x0272
        L_0x015f:
            java.lang.String r4 = "eis"
            java.lang.String r5 = f14154E
            r1.put(r4, r5)
            goto L_0x0272
        L_0x0168:
            java.lang.String r4 = "tripod"
            java.lang.String r5 = f14153D
            r1.put(r4, r5)
            goto L_0x0272
        L_0x0171:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13877ad
            if (r4 == 0) goto L_0x0272
            java.lang.String r4 = "asd_enable"
            java.lang.String r5 = f14152C
            r1.put(r4, r5)
            goto L_0x0272
        L_0x017e:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13877ad
            if (r4 == 0) goto L_0x0272
            java.lang.String r4 = f14151B
            if (r4 == 0) goto L_0x0272
            java.lang.String r4 = "asd"
            java.lang.String r5 = f14151B
            r1.put(r4, r5)
            goto L_0x0272
        L_0x018f:
            java.lang.String r4 = "capture_time"
            java.lang.String r5 = f14158c
            r1.put(r4, r5)
            goto L_0x0272
        L_0x0198:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13850aC
            if (r4 == 0) goto L_0x0272
            java.lang.String r4 = "night_scene"
            java.lang.String r5 = f14150A
            r1.put(r4, r5)
            goto L_0x0272
        L_0x01a5:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13884ak
            if (r4 == 0) goto L_0x0272
            java.lang.String r4 = "0"
            java.lang.String r5 = f14165j
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0272
            java.lang.String r4 = "1"
            java.lang.String r5 = f14164i
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0272
            java.lang.String r4 = "hd_fb"
            java.lang.String r5 = f14181z
            r1.put(r4, r5)
            goto L_0x0272
        L_0x01c6:
            java.lang.String r4 = "funny_mark"
            java.lang.String r5 = f14176u
            r1.put(r4, r5)
            goto L_0x0272
        L_0x01cf:
            java.lang.String r4 = "device_mark"
            java.lang.String r5 = f14175t
            r1.put(r4, r5)
            goto L_0x0272
        L_0x01d8:
            java.lang.String r4 = "count_down"
            java.lang.String r5 = f14170o
            r1.put(r4, r5)
            goto L_0x0272
        L_0x01e1:
            java.lang.String r4 = "1"
            java.lang.String r5 = f14164i
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0272
            java.lang.String r4 = "mirror"
            java.lang.String r5 = f14177v
            r1.put(r4, r5)
            goto L_0x0272
        L_0x01f4:
            java.lang.String r4 = "location"
            java.lang.String r5 = f14173r
            r1.put(r4, r5)
            goto L_0x0272
        L_0x01fd:
            java.lang.String r4 = "hdr"
            java.lang.String r5 = f14169n
            r1.put(r4, r5)
            goto L_0x0272
        L_0x0206:
            java.lang.String r4 = "level"
            java.lang.String r5 = f14172q
            r1.put(r4, r5)
            goto L_0x0272
        L_0x020e:
            java.lang.String r4 = "meshline"
            java.lang.String r5 = f14171p
            r1.put(r4, r5)
            goto L_0x0272
        L_0x0216:
            java.lang.String r4 = "voice"
            java.lang.String r5 = f14178w
            r1.put(r4, r5)
            goto L_0x0272
        L_0x021e:
            java.lang.String r4 = "time_mark"
            java.lang.String r5 = f14174s
            r1.put(r4, r5)
            goto L_0x0272
        L_0x0226:
            java.lang.String r4 = "num_filter"
            java.lang.String r5 = f14168m
            r1.put(r4, r5)
            goto L_0x0272
        L_0x022e:
            java.lang.String r4 = "filter_type"
            java.lang.String r5 = f14167l
            r1.put(r4, r5)
            goto L_0x0272
        L_0x0236:
            java.lang.String r4 = "filter_value"
            java.lang.String r5 = f14166k
            r1.put(r4, r5)
            goto L_0x0272
        L_0x023e:
            java.lang.String r4 = "capture_type"
            int r5 = f14162g
            java.lang.String r5 = java.lang.Integer.toString(r5)
            r1.put(r4, r5)
            goto L_0x0272
        L_0x024a:
            boolean r4 = com.meizu.media.camera.util.DeviceHelper.f13936bj
            if (r4 == 0) goto L_0x0272
            java.lang.String r4 = "sd_card"
            java.lang.String r5 = f14180y
            r1.put(r4, r5)
            goto L_0x0272
        L_0x0256:
            java.lang.String r4 = "is_back_camera"
            java.lang.String r5 = "1"
            java.lang.String r6 = f14164i
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0265
            java.lang.String r5 = "0"
            goto L_0x0267
        L_0x0265:
            java.lang.String r5 = "1"
        L_0x0267:
            r1.put(r4, r5)
            goto L_0x0272
        L_0x026b:
            java.lang.String r4 = "mode"
            java.lang.String r5 = f14163h
            r1.put(r4, r5)
        L_0x0272:
            int r3 = r3 + 1
            goto L_0x0030
        L_0x0276:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.UsageStatsHelper.mo22688a(java.lang.String[]):java.util.Map");
    }

    /* renamed from: e */
    public void mo22700e(String str) {
        f14163h = str;
    }

    /* renamed from: d */
    public static String m16050d() {
        return f14163h;
    }

    /* renamed from: e */
    public static String m16051e() {
        return f14175t;
    }

    /* renamed from: f */
    public void mo22701f(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f14156a, false, 8244, new Class[]{String.class}, Void.TYPE).isSupported) {
            f14155F = System.currentTimeMillis();
            f14164i = str;
        }
    }

    /* renamed from: g */
    public void mo22703g(String str) {
        f14165j = str;
    }

    /* renamed from: h */
    public void mo22705h(String str) {
        f14173r = str;
    }

    /* renamed from: i */
    public void mo22707i(String str) {
        f14178w = str;
    }

    /* renamed from: j */
    public void mo22708j(String str) {
        f14171p = str;
    }

    /* renamed from: k */
    public void mo22709k(String str) {
        f14174s = str;
    }

    /* renamed from: a */
    public void mo22689a(CameraController.HdrMode hdrMode, boolean z) {
        if (hdrMode == CameraController.HdrMode.ON) {
            f14169n = "true";
        } else if (hdrMode == CameraController.HdrMode.OFF) {
            f14169n = "false";
        } else if (hdrMode == CameraController.HdrMode.AUTO) {
            f14169n = z ? "autoOn" : "autoOff";
        }
    }

    /* renamed from: l */
    public void mo22710l(String str) {
        f14150A = str;
    }

    /* renamed from: m */
    public void mo22711m(String str) {
        f14172q = str;
    }

    /* renamed from: n */
    public void mo22712n(String str) {
        f14177v = str;
    }

    /* renamed from: o */
    public void mo22713o(String str) {
        f14152C = str;
    }

    /* renamed from: f */
    public static String m16052f() {
        return f14152C;
    }

    /* renamed from: p */
    public void mo22714p(String str) {
        f14153D = str;
    }

    /* renamed from: q */
    public void mo22715q(String str) {
        f14154E = str;
    }

    /* renamed from: r */
    public void mo22716r(String str) {
        f14170o = str;
    }

    /* renamed from: s */
    public void mo22717s(String str) {
        f14175t = str;
    }

    /* renamed from: t */
    public void mo22718t(String str) {
        f14176u = str;
    }

    /* renamed from: u */
    public void mo22719u(String str) {
        f14181z = str;
    }

    /* renamed from: v */
    public void mo22720v(String str) {
        f14167l = str;
    }

    /* renamed from: w */
    public void mo22721w(String str) {
        f14168m = str;
    }

    /* renamed from: x */
    public void mo22722x(String str) {
        f14166k = str;
    }

    /* renamed from: g */
    public String mo22702g() {
        return f14167l;
    }

    /* renamed from: h */
    public String mo22704h() {
        return f14168m;
    }

    /* renamed from: i */
    public String mo22706i() {
        return f14166k;
    }

    /* renamed from: c */
    public void mo22698c(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14156a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8246, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && f14155F != 0) {
            long currentTimeMillis = System.currentTimeMillis() - f14155F;
            if (currentTimeMillis >= 1000) {
                mo22691a("mode_utility_time", "time", Long.toString(currentTimeMillis));
            }
            if (z) {
                f14155F = 0;
            }
        }
    }

    /* renamed from: a */
    public void mo22690a(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f14156a, false, 8247, clsArr, Void.TYPE).isSupported && str != null) {
            LogUtil.C2630a aVar = f14159d;
            LogUtil.m15942a(aVar, "key: " + str + " value: " + str2);
            if ("click_filter".equals(str)) {
                f14166k = str2;
            } else if ("mz_pref_fb_key".equals(str)) {
                f14165j = str2;
            } else if ("mz_pref_meizu_mark_key".equals(str)) {
                f14176u = str2;
            } else if ("mz_pref_time_mark_key".equals(str)) {
                f14174s = str2;
            } else if ("mz_pref_voice_action_key".equals(str)) {
                f14178w = str2;
            } else if ("mz_pref_meshline_key".equals(str)) {
                f14171p = str2;
            } else if ("mz_pref_level_key".equals(str)) {
                f14172q = str2;
            } else if ("mz_pref_gps_key".equals(str)) {
                f14173r = str2;
            } else if ("mz_pref_mirror".equals(str)) {
                f14177v = str2;
            } else if ("pref_camera_timer_key".equals(str)) {
                f14170o = str2;
            } else if ("mz_pref_device_mark_key".equals(str)) {
                if (!DeviceHelper.f13881ah) {
                    f14175t = str2;
                } else if (Contants.DeviceMarkType.DEVICE_MARK_CLOSE.getOption().equals(str2)) {
                    f14175t = Contants.DeviceMarkType.DEVICE_MARK_CLOSE.getValue();
                } else if (Contants.DeviceMarkType.DEVICE_MARK_DEFAULT.getOption().equals(str2)) {
                    f14175t = Contants.DeviceMarkType.DEVICE_MARK_DEFAULT.getValue();
                } else {
                    f14175t = Contants.DeviceMarkType.DEVICE_MARK_CUSTOM.getValue();
                }
            } else if ("mz_pref_storage_key".equals(str)) {
                f14180y = str2;
            } else if ("mz_pref_fb_high_picturesize_key".equals(str)) {
                f14181z = str2;
            } else if (DeviceHelper.f13877ad && "mz_pref_asd_enable_key".equals(str)) {
                f14152C = str2;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (r9.equals("mz_pref_voice_action_key") != false) goto L_0x0115;
     */
    /* renamed from: y */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m16056y(java.lang.String r9) {
        /*
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r9
            com.meizu.savior.ChangeQuickRedirect r3 = f14156a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r6[r8] = r2
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r2 = 0
            r4 = 1
            r5 = 8248(0x2038, float:1.1558E-41)
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r2 = r1.isSupported
            if (r2 == 0) goto L_0x0021
            java.lang.Object r9 = r1.result
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L_0x0021:
            r1 = -1
            int r2 = r9.hashCode()
            switch(r2) {
                case -2091224709: goto L_0x010a;
                case -1952867573: goto L_0x0100;
                case -1846791981: goto L_0x00f5;
                case -1667988795: goto L_0x00ea;
                case -1326854699: goto L_0x00e0;
                case -1040973103: goto L_0x00d5;
                case -1037552827: goto L_0x00ca;
                case -912878302: goto L_0x00bf;
                case -715740570: goto L_0x00b4;
                case -664255270: goto L_0x00aa;
                case -508298807: goto L_0x009f;
                case -409281526: goto L_0x0094;
                case 178591468: goto L_0x0089;
                case 490825831: goto L_0x007d;
                case 715746189: goto L_0x0073;
                case 966487743: goto L_0x0067;
                case 1136339148: goto L_0x005b;
                case 1328780891: goto L_0x004f;
                case 1563460814: goto L_0x0043;
                case 1664771684: goto L_0x0037;
                case 1976199861: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0114
        L_0x002b:
            java.lang.String r0 = "pref_camera_flashmode_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 11
            goto L_0x0115
        L_0x0037:
            java.lang.String r0 = "mz_pref_tripod_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 19
            goto L_0x0115
        L_0x0043:
            java.lang.String r0 = "mz_pref_eis_switch_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 20
            goto L_0x0115
        L_0x004f:
            java.lang.String r0 = "mz_pref_fb_high_picturesize_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 18
            goto L_0x0115
        L_0x005b:
            java.lang.String r0 = "mz_pref_hdr_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 9
            goto L_0x0115
        L_0x0067:
            java.lang.String r0 = "mz_pref_48m_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 15
            goto L_0x0115
        L_0x0073:
            java.lang.String r2 = "mz_pref_voice_action_key"
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x0114
            goto L_0x0115
        L_0x007d:
            java.lang.String r0 = "pref_camera_timer_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 10
            goto L_0x0115
        L_0x0089:
            java.lang.String r0 = "mz_pref_device_mark_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 5
            goto L_0x0115
        L_0x0094:
            java.lang.String r0 = "mz_pref_meizu_mark_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 6
            goto L_0x0115
        L_0x009f:
            java.lang.String r0 = "mz_pref_mirror"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 0
            goto L_0x0115
        L_0x00aa:
            java.lang.String r0 = "mz_pref_level_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 3
            goto L_0x0115
        L_0x00b4:
            java.lang.String r0 = "mz_pref_fb_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 13
            goto L_0x0115
        L_0x00bf:
            java.lang.String r0 = "pref_camera_timelapse_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 17
            goto L_0x0115
        L_0x00ca:
            java.lang.String r0 = "mz_pref_20m_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 14
            goto L_0x0115
        L_0x00d5:
            java.lang.String r0 = "mz_pref_storage_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 8
            goto L_0x0115
        L_0x00e0:
            java.lang.String r0 = "mz_pref_time_mark_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 4
            goto L_0x0115
        L_0x00ea:
            java.lang.String r0 = "mz_pref_64m_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 16
            goto L_0x0115
        L_0x00f5:
            java.lang.String r0 = "pref_video_flashmode_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 12
            goto L_0x0115
        L_0x0100:
            java.lang.String r0 = "mz_pref_meshline_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 2
            goto L_0x0115
        L_0x010a:
            java.lang.String r0 = "mz_pref_funny_hd_key"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0114
            r0 = 7
            goto L_0x0115
        L_0x0114:
            r0 = -1
        L_0x0115:
            switch(r0) {
                case 0: goto L_0x0155;
                case 1: goto L_0x0152;
                case 2: goto L_0x014f;
                case 3: goto L_0x014c;
                case 4: goto L_0x0149;
                case 5: goto L_0x0146;
                case 6: goto L_0x0143;
                case 7: goto L_0x0140;
                case 8: goto L_0x013d;
                case 9: goto L_0x013a;
                case 10: goto L_0x0137;
                case 11: goto L_0x0134;
                case 12: goto L_0x0131;
                case 13: goto L_0x012e;
                case 14: goto L_0x012b;
                case 15: goto L_0x0128;
                case 16: goto L_0x0125;
                case 17: goto L_0x0122;
                case 18: goto L_0x011f;
                case 19: goto L_0x011c;
                case 20: goto L_0x0119;
                default: goto L_0x0118;
            }
        L_0x0118:
            return r9
        L_0x0119:
            java.lang.String r9 = "click_eis"
            return r9
        L_0x011c:
            java.lang.String r9 = "click_tripod"
            return r9
        L_0x011f:
            java.lang.String r9 = "click_hd_fb"
            return r9
        L_0x0122:
            java.lang.String r9 = "click_time_lapse"
            return r9
        L_0x0125:
            java.lang.String r9 = "click_64m"
            return r9
        L_0x0128:
            java.lang.String r9 = "click_48m"
            return r9
        L_0x012b:
            java.lang.String r9 = "click_20m"
            return r9
        L_0x012e:
            java.lang.String r9 = "click_face_beauty"
            return r9
        L_0x0131:
            java.lang.String r9 = "click_torch_flash"
            return r9
        L_0x0134:
            java.lang.String r9 = "click_flash"
            return r9
        L_0x0137:
            java.lang.String r9 = "click_timer"
            return r9
        L_0x013a:
            java.lang.String r9 = "click_hdr"
            return r9
        L_0x013d:
            java.lang.String r9 = "click_sdcard"
            return r9
        L_0x0140:
            java.lang.String r9 = "click_funny_hd"
            return r9
        L_0x0143:
            java.lang.String r9 = "click_funny_mark"
            return r9
        L_0x0146:
            java.lang.String r9 = "click_device_mark"
            return r9
        L_0x0149:
            java.lang.String r9 = "click_time_mark"
            return r9
        L_0x014c:
            java.lang.String r9 = "click_level"
            return r9
        L_0x014f:
            java.lang.String r9 = "click_meshline"
            return r9
        L_0x0152:
            java.lang.String r9 = "click_voice_action"
            return r9
        L_0x0155:
            java.lang.String r9 = "click_mirror"
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.UsageStatsHelper.m16056y(java.lang.String):java.lang.String");
    }

    /* renamed from: z */
    public static String[] m16057z(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14156a, true, 8249, new Class[]{String.class}, String[].class);
        if (proxy.isSupported) {
            return (String[]) proxy.result;
        }
        if (str == null) {
            return null;
        }
        if (str.equals("click_mirror") || str.equals("click_flash") || str.equals("click_torch_flash") || str.equals("click_zoom_icon")) {
            return new String[]{"mode"};
        }
        if (str.equals("mode_start") || str.equals("click_hdr") || str.equals("click_switch_camera") || str.equals("click_voice_action") || str.equals("click_meshline") || str.equals("click_level") || str.equals("click_time_mark") || str.equals("click_device_mark") || str.equals("click_setting") || str.equals("click_picture_size") || str.equals("open_filter") || str.equals("close_filter") || str.equals("click_pause_recording") || str.equals("take_picture_in_recording") || str.equals("click_resume_recording") || str.equals("click_timer") || str.equals("watch_projection") || str.equals("save_info") || str.equals("click_sdcard") || str.equals("mode_utility_time") || str.equals("click_shutter_btn")) {
            return new String[]{"mode", "is_back_camera"};
        }
        if (str.equals("click_funny_mark") || str.equals("open_sticker_window") || str.equals("close_sticker_window") || str.equals("download_sticker") || str.equals("clean_sticker") || str.equals("click_face_beauty") || str.equals("click_video_size") || str.equals("select_sticker") || str.equals("download_faceu")) {
            return new String[]{"is_back_camera"};
        }
        if (str.equals("click_thumbnail")) {
            return new String[]{"mode", "is_back_camera", "capture_time"};
        }
        if (str.equals("click_wide_angle")) {
            return new String[]{"mode", "value"};
        }
        if (str.equals("click_filter")) {
            return new String[]{"type", "filter_value", "is_back_camera", "mode"};
        }
        return null;
    }
}
