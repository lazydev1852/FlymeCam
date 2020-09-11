package com.loc;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.appcompat.widget.ActivityChooserView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.constants.HttpConstants;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.loc.cl */
public final class ReportUtil {

    /* renamed from: g */
    static AMapLocation f3004g = null;

    /* renamed from: h */
    static boolean f3005h = false;

    /* renamed from: i */
    private static List<StatisticsEntity> f3006i = new ArrayList();

    /* renamed from: j */
    private static JSONArray f3007j = null;

    /* renamed from: a */
    public SparseArray<Long> f3008a = new SparseArray<>();

    /* renamed from: b */
    public int f3009b = -1;

    /* renamed from: c */
    public long f3010c = 0;

    /* renamed from: d */
    String[] f3011d = {"ol", "cl", "gl", "ha", NotificationStyle.BASE_STYLE, "ds"};

    /* renamed from: e */
    public int f3012e = -1;

    /* renamed from: f */
    public long f3013f = -1;

    /* renamed from: a */
    public static void m3424a(long j, long j2) {
        try {
            if (!f3005h) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("gpsTime:");
                stringBuffer.append(C1079cp.m3502a(j, "yyyy-MM-dd HH:mm:ss.SSS"));
                stringBuffer.append(SystemInfoUtil.COMMA);
                stringBuffer.append("sysTime:");
                stringBuffer.append(C1079cp.m3502a(j2, "yyyy-MM-dd HH:mm:ss.SSS"));
                stringBuffer.append(SystemInfoUtil.COMMA);
                long G = AuthUtil.m3340G();
                String str = "0";
                int i = (0 > G ? 1 : (0 == G ? 0 : -1));
                if (i != 0) {
                    str = C1079cp.m3502a(G, "yyyy-MM-dd HH:mm:ss.SSS");
                }
                stringBuffer.append("serverTime:");
                stringBuffer.append(str);
                m3436a("checkgpstime", stringBuffer.toString());
                if (i != 0 && Math.abs(j - G) < 31536000000L) {
                    stringBuffer.append(", correctError");
                    m3436a("checkgpstimeerror", stringBuffer.toString());
                }
                stringBuffer.delete(0, stringBuffer.length());
                f3005h = true;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m3425a(Context context) {
        if (context != null) {
            try {
                if (AuthUtil.m3364i()) {
                    if (f3006i != null && f3006i.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(f3006i);
                        StatisticsManager.m3068a((List<StatisticsEntity>) arrayList, context);
                        f3006i.clear();
                    }
                    m3443f(context);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ReportUtil", "destroy");
            }
        }
    }

    /* renamed from: a */
    public static void m3426a(Context context, int i, int i2, long j, long j2) {
        if (i != -1 && i2 != -1 && context != null) {
            try {
                if (AuthUtil.m3364i()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i);
                    jSONObject.put("param_int_second", i2);
                    jSONObject.put("param_long_first", j);
                    jSONObject.put("param_long_second", j2);
                    m3433a(context, "O012", jSONObject);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ReportUtil", "reportServiceAliveTime");
            }
        }
    }

    /* renamed from: a */
    public static void m3427a(Context context, long j, boolean z) {
        if (context != null) {
            try {
                if (AuthUtil.m3364i()) {
                    int intValue = Long.valueOf(j).intValue();
                    String str = "domestic";
                    if (!z) {
                        str = "abroad";
                    }
                    m3432a(context, "O015", str, (String) null, intValue, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    /* renamed from: a */
    public static void m3428a(Context context, AMapLocation aMapLocation) {
        int i;
        String str;
        String str2;
        String str3;
        if (aMapLocation != null) {
            try {
                if ("gps".equalsIgnoreCase(aMapLocation.getProvider())) {
                    return;
                }
                if (aMapLocation.mo8475a() != 1) {
                    String str4 = "domestic";
                    if (m3440a(aMapLocation)) {
                        str4 = "abroad";
                    }
                    String str5 = str4;
                    if (aMapLocation.mo8484c() != 0) {
                        int c = aMapLocation.mo8484c();
                        if (c != 11) {
                            switch (c) {
                                case 4:
                                case 5:
                                case 6:
                                    break;
                                default:
                                    str3 = "cache";
                                    break;
                            }
                        }
                        str3 = "net";
                        str = str3;
                        i = 0;
                    } else {
                        switch (aMapLocation.mo8475a()) {
                            case 5:
                            case 6:
                                str2 = "net";
                                break;
                            default:
                                str2 = "cache";
                                break;
                        }
                        str = str2;
                        i = 1;
                    }
                    m3432a(context, "O016", str, str5, i, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ReportUtil", "reportBatting");
            }
        }
    }

    /* renamed from: a */
    public static void m3429a(Context context, ReportEntity ckVar) {
        String str;
        if (context != null) {
            try {
                if (AuthUtil.m3364i()) {
                    AMapLocationServer c = ckVar.mo13179c();
                    if (!C1079cp.m3509a(c) || "gps".equalsIgnoreCase(c.getProvider())) {
                        return;
                    }
                    if (c.mo8475a() != 1) {
                        int intValue = Long.valueOf(ckVar.mo13177b() - ckVar.mo13174a()).intValue();
                        boolean z = false;
                        int intValue2 = Long.valueOf(c.mo8803J()).intValue();
                        switch (c.mo8475a()) {
                            case 5:
                            case 6:
                                str = "net";
                                break;
                            default:
                                str = "cache";
                                z = true;
                                break;
                        }
                        String str2 = m3440a((AMapLocation) c) ? "abroad" : "domestic";
                        if (!z) {
                            m3432a(context, "O014", str2, (String) null, intValue2, intValue);
                        }
                        m3432a(context, "O013", str, str2, intValue, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ReportUtil", "reportLBSLocUseTime");
            }
        }
    }

    /* renamed from: a */
    public static void m3430a(Context context, String str, int i) {
        try {
            m3431a(context, "O009", i, str);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ReportUtil", "reportDexLoadDexClass");
        }
    }

    /* renamed from: a */
    private static void m3431a(Context context, String str, int i, String str2) {
        if (context != null) {
            try {
                if (AuthUtil.m3364i()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (i != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i);
                    }
                    m3433a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    /* renamed from: a */
    private static void m3432a(Context context, String str, String str2, String str3, int i, int i2) {
        if (context != null) {
            try {
                if (AuthUtil.m3364i()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i2);
                    }
                    m3433a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    /* renamed from: a */
    private static void m3433a(Context context, String str, JSONObject jSONObject) {
        if (context != null) {
            try {
                if (AuthUtil.m3364i()) {
                    StatisticsEntity avVar = new StatisticsEntity(context, "loc", "4.7.2", str);
                    avVar.mo13034a(jSONObject.toString());
                    f3006i.add(avVar);
                    if (f3006i.size() >= 100) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(f3006i);
                        StatisticsManager.m3068a((List<StatisticsEntity>) arrayList, context);
                        f3006i.clear();
                    }
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ReportUtil", "applyStatistics");
            }
        }
    }

    /* renamed from: a */
    public static void m3434a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (f3004g == null) {
                if (!C1079cp.m3508a(aMapLocation)) {
                    f3004g = aMapLocation2;
                    return;
                }
                f3004g = aMapLocation.clone();
            }
            if (C1079cp.m3508a(f3004g) && C1079cp.m3508a(aMapLocation2)) {
                AMapLocation x = aMapLocation2.clone();
                if (!(f3004g.mo8475a() == 1 || f3004g.mo8475a() == 9 || "gps".equalsIgnoreCase(f3004g.getProvider()) || f3004g.mo8475a() == 7 || x.mo8475a() == 1 || x.mo8475a() == 9 || "gps".equalsIgnoreCase(x.getProvider()) || x.mo8475a() == 7)) {
                    long abs = Math.abs(x.getTime() - f3004g.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800) {
                        float a = C1079cp.m3497a(f3004g, x);
                        float f = a / ((float) abs);
                        if (a > 30000.0f && f > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(f3004g.getLatitude());
                            sb.append(SystemInfoUtil.COMMA);
                            sb.append(f3004g.getLongitude());
                            sb.append(SystemInfoUtil.COMMA);
                            sb.append(f3004g.getAccuracy());
                            sb.append(SystemInfoUtil.COMMA);
                            sb.append(f3004g.mo8475a());
                            sb.append(SystemInfoUtil.COMMA);
                            if (aMapLocation.getTime() != 0) {
                                sb.append(C1079cp.m3502a(f3004g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(f3004g.getTime());
                            }
                            sb.append("#");
                            sb.append(x.getLatitude());
                            sb.append(SystemInfoUtil.COMMA);
                            sb.append(x.getLongitude());
                            sb.append(SystemInfoUtil.COMMA);
                            sb.append(x.getAccuracy());
                            sb.append(SystemInfoUtil.COMMA);
                            sb.append(x.mo8475a());
                            sb.append(SystemInfoUtil.COMMA);
                            if (x.getTime() != 0) {
                                sb.append(C1079cp.m3502a(x.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(x.getTime());
                            }
                            m3436a("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                f3004g = x;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m3435a(String str, int i) {
        String valueOf = String.valueOf(i);
        String str2 = "";
        switch (i) {
            case 2011:
                str2 = "ContextIsNull";
                break;
            case 2021:
                str2 = "OnlyMainWifi";
                break;
            case 2022:
                str2 = "OnlyOneWifiButNotMain";
                break;
            case 2031:
                str2 = "CreateApsReqException";
                break;
            case 2041:
                str2 = "ResponseResultIsNull";
                break;
            case 2051:
                str2 = "NeedLoginNetWork\t";
                break;
            case 2052:
                str2 = "MaybeIntercepted";
                break;
            case 2053:
                str2 = "DecryptResponseException";
                break;
            case 2054:
                str2 = "ParserDataException";
                break;
            case 2061:
                str2 = "ServerRetypeError";
                break;
            case 2062:
                str2 = "ServerLocFail";
                break;
            case 2081:
                str2 = "LocalLocException";
                break;
            case 2091:
                str2 = "InitException";
                break;
            case MsgField.IMSG_MODE_SHOWING:
                str2 = "BindAPSServiceException";
                break;
            case 2102:
                str2 = "AuthClientScodeFail";
                break;
            case 2103:
                str2 = "NotConfigAPSService";
                break;
            case 2111:
                str2 = "ErrorCgiInfo";
                break;
            case 2121:
                str2 = "NotLocPermission";
                break;
            case 2131:
                str2 = "NoCgiOAndWifiInfo";
                break;
            case 2132:
                str2 = "AirPlaneModeAndWifiOff";
                break;
            case 2133:
                str2 = "NoCgiAndWifiOff";
                break;
            case 2141:
                str2 = "NoEnoughStatellites";
                break;
            case 2151:
                str2 = "MaybeMockNetLoc";
                break;
            case 2152:
                str2 = "MaybeMockGPSLoc";
                break;
        }
        m3437a(str, valueOf, str2);
    }

    /* renamed from: a */
    public static void m3436a(String str, String str2) {
        try {
            SDKLogHandler.m3866b(CoreUtil.m3392b(), str2, str);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ReportUtil", "reportLog");
        }
    }

    /* renamed from: a */
    public static void m3437a(String str, String str2, String str3) {
        try {
            SDKLogHandler.m3864a(CoreUtil.m3392b(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m3438a(String str, Throwable th) {
        try {
            if (th instanceof AMapCoreException) {
                SDKLogHandler.m3863a(CoreUtil.m3392b(), str, (AMapCoreException) th);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static boolean m3439a(Context context, SDKInfo diVar) {
        try {
            return InstanceFactory.m3974b(context, diVar);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m3440a(AMapLocation aMapLocation) {
        return C1079cp.m3508a(aMapLocation) ? !CoreUtil.m3390a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(CoreUtil.f2977a);
    }

    /* renamed from: b */
    public static void m3441b(Context context, AMapLocation aMapLocation) {
        int i;
        try {
            if (C1079cp.m3508a(aMapLocation)) {
                boolean z = false;
                switch (aMapLocation.mo8475a()) {
                    case 1:
                        i = 0;
                        break;
                    case 2:
                    case 4:
                        i = 1;
                        break;
                    case 8:
                        i = 3;
                        break;
                    case 9:
                        i = 2;
                        break;
                    default:
                        i = 0;
                        break;
                }
                z = true;
                if (z) {
                    if (f3007j == null) {
                        f3007j = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("lon", C1079cp.m3528c(aMapLocation.getLongitude()));
                    jSONObject.put("lat", C1079cp.m3528c(aMapLocation.getLatitude()));
                    jSONObject.put("type", i);
                    jSONObject.put(HttpConstants.TIMESTAMP, C1079cp.m3518b());
                    if (aMapLocation.mo8542y().equalsIgnoreCase("WGS84")) {
                        jSONObject.put("coordType", 1);
                    } else {
                        jSONObject.put("coordType", 2);
                    }
                    if (i == 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("accuracy", C1079cp.m3517b((double) aMapLocation.getAccuracy()));
                        jSONObject2.put("altitude", C1079cp.m3517b(aMapLocation.getAltitude()));
                        jSONObject2.put("bearing", C1079cp.m3517b((double) aMapLocation.getBearing()));
                        jSONObject2.put(Parameters.SPEED, C1079cp.m3517b((double) aMapLocation.getSpeed()));
                        jSONObject.put("extension", jSONObject2);
                    }
                    JSONArray put = f3007j.put(jSONObject);
                    f3007j = put;
                    if (put.length() >= AuthUtil.m3365j()) {
                        m3443f(context);
                    }
                }
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ReportUtil", "recordOfflineLocLog");
        }
    }

    /* renamed from: b */
    public static void m3442b(Context context, String str, int i) {
        try {
            m3431a(context, "O010", i, str);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ReportUtil", "reportDexFunction");
        }
    }

    /* renamed from: f */
    private static void m3443f(Context context) {
        try {
            if (f3007j != null && f3007j.length() > 0) {
                OfflineLocManager.m3060a(new OfflineLocEntity(context, CoreUtil.m3392b(), f3007j.toString()), context);
                f3007j = null;
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    /* renamed from: a */
    public final void mo13180a(Context context, int i) {
        try {
            if (this.f3009b != i) {
                if (!(this.f3009b == -1 || this.f3009b == i)) {
                    this.f3008a.append(this.f3009b, Long.valueOf((C1079cp.m3529c() - this.f3010c) + this.f3008a.get(this.f3009b, 0L).longValue()));
                }
                this.f3010c = C1079cp.m3529c() - SpUtil.m3491b(context, "pref", this.f3011d[i], 0);
                this.f3009b = i;
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ReportUtil", "setLocationType");
        }
    }

    /* renamed from: a */
    public final void mo13181a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        int i;
        try {
            switch (aMapLocationClientOption.mo8559h()) {
                case Battery_Saving:
                    i = 4;
                    break;
                case Device_Sensors:
                    i = 5;
                    break;
                case Hight_Accuracy:
                    i = 3;
                    break;
                default:
                    i = -1;
                    break;
            }
            if (this.f3012e != i) {
                if (!(this.f3012e == -1 || this.f3012e == i)) {
                    this.f3008a.append(this.f3012e, Long.valueOf((C1079cp.m3529c() - this.f3013f) + this.f3008a.get(this.f3012e, 0L).longValue()));
                }
                this.f3013f = C1079cp.m3529c() - SpUtil.m3491b(context, "pref", this.f3011d[i], 0);
                this.f3012e = i;
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ReportUtil", "setLocationMode");
        }
    }

    /* renamed from: b */
    public final void mo13182b(Context context) {
        try {
            long c = C1079cp.m3529c() - this.f3010c;
            if (this.f3009b != -1) {
                this.f3008a.append(this.f3009b, Long.valueOf(c + this.f3008a.get(this.f3009b, 0L).longValue()));
            }
            long c2 = C1079cp.m3529c() - this.f3013f;
            if (this.f3012e != -1) {
                this.f3008a.append(this.f3012e, Long.valueOf(c2 + this.f3008a.get(this.f3012e, 0L).longValue()));
            }
            for (int i = 0; i < this.f3011d.length; i++) {
                long longValue = this.f3008a.get(i, 0L).longValue();
                if (longValue > 0 && longValue > SpUtil.m3491b(context, "pref", this.f3011d[i], 0)) {
                    SpUtil.m3486a(context, "pref", this.f3011d[i], longValue);
                }
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    /* renamed from: c */
    public final int mo13183c(Context context) {
        try {
            long b = SpUtil.m3491b(context, "pref", this.f3011d[2], 0);
            long b2 = SpUtil.m3491b(context, "pref", this.f3011d[0], 0);
            long b3 = SpUtil.m3491b(context, "pref", this.f3011d[1], 0);
            if (b == 0 && b2 == 0 && b3 == 0) {
                return -1;
            }
            long j = b2 - b;
            long j2 = b3 - b;
            return b > j ? b > j2 ? 2 : 1 : j > j2 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: d */
    public final int mo13184d(Context context) {
        try {
            long b = SpUtil.m3491b(context, "pref", this.f3011d[3], 0);
            long b2 = SpUtil.m3491b(context, "pref", this.f3011d[4], 0);
            long b3 = SpUtil.m3491b(context, "pref", this.f3011d[5], 0);
            if (b == 0 && b2 == 0 && b3 == 0) {
                return -1;
            }
            return b > b2 ? b > b3 ? 3 : 5 : b2 > b3 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: e */
    public final void mo13185e(Context context) {
        int i = 0;
        while (i < this.f3011d.length) {
            try {
                SpUtil.m3486a(context, "pref", this.f3011d[i], 0);
                i++;
            } catch (Throwable unused) {
                return;
            }
        }
    }
}
