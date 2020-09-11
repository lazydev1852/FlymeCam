package com.amap.api.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.loc.C1079cp;
import com.loc.CoreUtil;
import com.meizu.cloud.pushsdk.networking.common.ANConstants;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import org.json.JSONObject;

public class AMapLocation extends Location implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocation> CREATOR = new Parcelable.Creator<AMapLocation>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AMapLocation aMapLocation = new AMapLocation((Location) Location.CREATOR.createFromParcel(parcel));
            String unused = aMapLocation.f183h = parcel.readString();
            String unused2 = aMapLocation.f184i = parcel.readString();
            String unused3 = aMapLocation.f198w = parcel.readString();
            aMapLocation.f176a = parcel.readString();
            String unused4 = aMapLocation.f180e = parcel.readString();
            String unused5 = aMapLocation.f182g = parcel.readString();
            String unused6 = aMapLocation.f186k = parcel.readString();
            String unused7 = aMapLocation.f181f = parcel.readString();
            int unused8 = aMapLocation.f191p = parcel.readInt();
            String unused9 = aMapLocation.f192q = parcel.readString();
            aMapLocation.f177b = parcel.readString();
            boolean z = false;
            boolean unused10 = aMapLocation.f172A = parcel.readInt() != 0;
            boolean unused11 = aMapLocation.f190o = parcel.readInt() != 0;
            double unused12 = aMapLocation.f195t = parcel.readDouble();
            String unused13 = aMapLocation.f193r = parcel.readString();
            int unused14 = aMapLocation.f194s = parcel.readInt();
            double unused15 = aMapLocation.f196u = parcel.readDouble();
            if (parcel.readInt() != 0) {
                z = true;
            }
            boolean unused16 = aMapLocation.f200y = z;
            String unused17 = aMapLocation.f189n = parcel.readString();
            String unused18 = aMapLocation.f185j = parcel.readString();
            String unused19 = aMapLocation.f179d = parcel.readString();
            String unused20 = aMapLocation.f187l = parcel.readString();
            int unused21 = aMapLocation.f197v = parcel.readInt();
            int unused22 = aMapLocation.f199x = parcel.readInt();
            String unused23 = aMapLocation.f188m = parcel.readString();
            String unused24 = aMapLocation.f201z = parcel.readString();
            String unused25 = aMapLocation.f173B = parcel.readString();
            int unused26 = aMapLocation.f174C = parcel.readInt();
            int unused27 = aMapLocation.f175D = parcel.readInt();
            return aMapLocation;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AMapLocation[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f172A = false;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public String f173B = "GCJ02";
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f174C = 1;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f175D;

    /* renamed from: a */
    protected String f176a = "";

    /* renamed from: b */
    protected String f177b = "";

    /* renamed from: c */
    AMapLocationQualityReport f178c = new AMapLocationQualityReport();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f179d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f180e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f181f = "";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f182g = "";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f183h = "";
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f184i = "";
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f185j = "";
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f186k = "";
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f187l = "";
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f188m = "";
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f189n = "";
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f190o = true;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f191p = 0;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public String f192q = ANConstants.SUCCESS;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public String f193r = "";
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f194s = 0;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public double f195t = 0.0d;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public double f196u = 0.0d;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f197v = 0;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public String f198w = "";
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f199x = -1;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f200y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public String f201z = "";

    public AMapLocation(Location location) {
        super(location);
        this.f195t = location.getLatitude();
        this.f196u = location.getLongitude();
    }

    public AMapLocation(String str) {
        super(str);
    }

    /* renamed from: a */
    public int mo8475a() {
        return this.f194s;
    }

    /* renamed from: a */
    public void mo8476a(int i) {
        this.f199x = i;
    }

    /* renamed from: a */
    public void mo8477a(AMapLocationQualityReport cVar) {
        if (cVar != null) {
            this.f178c = cVar;
        }
    }

    /* renamed from: a */
    public void mo8478a(String str) {
        this.f193r = str;
    }

    /* renamed from: a */
    public void mo8479a(boolean z) {
        this.f190o = z;
    }

    /* renamed from: b */
    public String mo8480b() {
        return this.f193r;
    }

    /* renamed from: b */
    public void mo8481b(int i) {
        this.f194s = i;
    }

    /* renamed from: b */
    public void mo8482b(String str) {
        this.f192q = str;
    }

    /* renamed from: b */
    public void mo8483b(boolean z) {
        this.f172A = z;
    }

    /* renamed from: c */
    public int mo8484c() {
        return this.f191p;
    }

    /* renamed from: c */
    public void mo8485c(int i) {
        if (this.f191p == 0) {
            this.f192q = C1079cp.m3519b(i);
            this.f191p = i;
        }
    }

    /* renamed from: c */
    public void mo8486c(String str) {
        this.f186k = str;
    }

    /* renamed from: c */
    public void mo8487c(boolean z) {
        this.f200y = z;
    }

    /* renamed from: d */
    public String mo8489d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f192q);
        if (this.f191p != 0) {
            sb.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            sb.append(",错误详细信息:" + this.f193r);
        }
        return sb.toString();
    }

    /* renamed from: d */
    public void mo8490d(int i) {
        this.f197v = i;
    }

    /* renamed from: d */
    public void mo8491d(String str) {
        this.f187l = str;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String mo8493e() {
        return this.f186k;
    }

    /* renamed from: e */
    public String mo8494e(int i) {
        JSONObject jSONObject;
        try {
            jSONObject = mo8497f(i);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    /* renamed from: e */
    public void mo8495e(String str) {
        this.f184i = str;
    }

    /* renamed from: f */
    public String mo8496f() {
        return this.f187l;
    }

    /* renamed from: f */
    public JSONObject mo8497f(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            switch (i) {
                case 1:
                    try {
                        jSONObject.put("altitude", getAltitude());
                        jSONObject.put(Parameters.SPEED, (double) getSpeed());
                        jSONObject.put("bearing", (double) getBearing());
                    } catch (Throwable unused) {
                    }
                    jSONObject.put("citycode", this.f182g);
                    jSONObject.put("adcode", this.f183h);
                    jSONObject.put(com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters.COUNTRY, this.f186k);
                    jSONObject.put("province", this.f179d);
                    jSONObject.put("city", this.f180e);
                    jSONObject.put("district", this.f181f);
                    jSONObject.put("road", this.f187l);
                    jSONObject.put("street", this.f188m);
                    jSONObject.put("number", this.f189n);
                    jSONObject.put("poiname", this.f185j);
                    jSONObject.put("errorCode", this.f191p);
                    jSONObject.put("errorInfo", this.f192q);
                    jSONObject.put("locationType", this.f194s);
                    jSONObject.put("locationDetail", this.f193r);
                    jSONObject.put("aoiname", this.f198w);
                    jSONObject.put("address", this.f184i);
                    jSONObject.put("poiid", this.f176a);
                    jSONObject.put("floor", this.f177b);
                    jSONObject.put("description", this.f201z);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    return jSONObject;
            }
            jSONObject.put("time", getTime());
            jSONObject.put("provider", getProvider());
            jSONObject.put("lon", getLongitude());
            jSONObject.put("lat", getLatitude());
            jSONObject.put("accuracy", (double) getAccuracy());
            jSONObject.put("isOffset", this.f190o);
            jSONObject.put("isFixLastLocation", this.f172A);
            jSONObject.put("coordType", this.f173B);
            return jSONObject;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    /* renamed from: f */
    public void mo8498f(String str) {
        this.f179d = str;
    }

    /* renamed from: g */
    public String mo8499g() {
        return this.f184i;
    }

    /* renamed from: g */
    public void mo8500g(int i) {
        this.f174C = i;
    }

    /* renamed from: g */
    public void mo8501g(String str) {
        this.f180e = str;
    }

    public float getAccuracy() {
        return super.getAccuracy();
    }

    public double getAltitude() {
        return super.getAltitude();
    }

    public float getBearing() {
        return super.getBearing();
    }

    public double getLatitude() {
        return this.f195t;
    }

    public double getLongitude() {
        return this.f196u;
    }

    public String getProvider() {
        return super.getProvider();
    }

    public float getSpeed() {
        return super.getSpeed();
    }

    /* renamed from: h */
    public String mo8509h() {
        return this.f179d;
    }

    /* renamed from: h */
    public void mo8510h(int i) {
        this.f175D = i;
    }

    /* renamed from: h */
    public void mo8511h(String str) {
        this.f181f = str;
    }

    /* renamed from: i */
    public String mo8512i() {
        return this.f180e;
    }

    /* renamed from: i */
    public void mo8513i(String str) {
        this.f182g = str;
    }

    /* renamed from: j */
    public String mo8514j() {
        return this.f181f;
    }

    /* renamed from: j */
    public void mo8515j(String str) {
        this.f183h = str;
    }

    /* renamed from: k */
    public String mo8516k() {
        return this.f182g;
    }

    /* renamed from: k */
    public void mo8517k(String str) {
        this.f185j = str;
    }

    /* renamed from: l */
    public String mo8518l() {
        return this.f183h;
    }

    /* renamed from: l */
    public void mo8519l(String str) {
        this.f188m = str;
    }

    /* renamed from: m */
    public String mo8520m() {
        return this.f185j;
    }

    /* renamed from: m */
    public void mo8521m(String str) {
        this.f189n = str;
    }

    /* renamed from: n */
    public String mo8522n() {
        return this.f188m;
    }

    /* renamed from: n */
    public void mo8523n(String str) {
        this.f198w = str;
    }

    /* renamed from: o */
    public String mo8524o() {
        return this.f189n;
    }

    /* renamed from: o */
    public void mo8525o(String str) {
        this.f176a = str;
    }

    /* renamed from: p */
    public void mo8526p(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.f177b = str;
    }

    /* renamed from: p */
    public boolean mo8527p() {
        return this.f190o;
    }

    /* renamed from: q */
    public String mo8528q() {
        return this.f198w;
    }

    /* renamed from: q */
    public void mo8529q(String str) {
        this.f201z = str;
    }

    /* renamed from: r */
    public String mo8530r() {
        return this.f176a;
    }

    /* renamed from: r */
    public void mo8531r(String str) {
        this.f173B = str;
    }

    /* renamed from: s */
    public String mo8532s() {
        return this.f177b;
    }

    public void setLatitude(double d) {
        this.f195t = d;
    }

    public void setLongitude(double d) {
        this.f196u = d;
    }

    /* renamed from: t */
    public boolean mo8535t() {
        return this.f172A;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.f195t + "#");
            stringBuffer.append("longitude=" + this.f196u + "#");
            stringBuffer.append("province=" + this.f179d + "#");
            stringBuffer.append("coordType=" + this.f173B + "#");
            stringBuffer.append("city=" + this.f180e + "#");
            stringBuffer.append("district=" + this.f181f + "#");
            stringBuffer.append("cityCode=" + this.f182g + "#");
            stringBuffer.append("adCode=" + this.f183h + "#");
            stringBuffer.append("address=" + this.f184i + "#");
            stringBuffer.append("country=" + this.f186k + "#");
            stringBuffer.append("road=" + this.f187l + "#");
            stringBuffer.append("poiName=" + this.f185j + "#");
            stringBuffer.append("street=" + this.f188m + "#");
            stringBuffer.append("streetNum=" + this.f189n + "#");
            stringBuffer.append("aoiName=" + this.f198w + "#");
            stringBuffer.append("poiid=" + this.f176a + "#");
            stringBuffer.append("floor=" + this.f177b + "#");
            stringBuffer.append("errorCode=" + this.f191p + "#");
            stringBuffer.append("errorInfo=" + this.f192q + "#");
            stringBuffer.append("locationDetail=" + this.f193r + "#");
            stringBuffer.append("description=" + this.f201z + "#");
            stringBuffer.append("locationType=" + this.f194s + "#");
            StringBuilder sb = new StringBuilder("conScenario=");
            sb.append(this.f175D);
            stringBuffer.append(sb.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    /* renamed from: u */
    public boolean mo8537u() {
        return this.f200y;
    }

    /* renamed from: v */
    public String mo8538v() {
        return this.f201z;
    }

    /* renamed from: w */
    public String mo8539w() {
        return mo8494e(1);
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f183h);
            parcel.writeString(this.f184i);
            parcel.writeString(this.f198w);
            parcel.writeString(this.f176a);
            parcel.writeString(this.f180e);
            parcel.writeString(this.f182g);
            parcel.writeString(this.f186k);
            parcel.writeString(this.f181f);
            parcel.writeInt(this.f191p);
            parcel.writeString(this.f192q);
            parcel.writeString(this.f177b);
            parcel.writeInt(this.f172A ? 1 : 0);
            parcel.writeInt(this.f190o ? 1 : 0);
            parcel.writeDouble(this.f195t);
            parcel.writeString(this.f193r);
            parcel.writeInt(this.f194s);
            parcel.writeDouble(this.f196u);
            parcel.writeInt(this.f200y ? 1 : 0);
            parcel.writeString(this.f189n);
            parcel.writeString(this.f185j);
            parcel.writeString(this.f179d);
            parcel.writeString(this.f187l);
            parcel.writeInt(this.f197v);
            parcel.writeInt(this.f199x);
            parcel.writeString(this.f188m);
            parcel.writeString(this.f201z);
            parcel.writeString(this.f173B);
            parcel.writeInt(this.f174C);
            parcel.writeInt(this.f175D);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AMapLocation", "writeToParcel");
        }
    }

    /* renamed from: x */
    public AMapLocation clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        AMapLocation aMapLocation = new AMapLocation((Location) this);
        try {
            aMapLocation.setLatitude(this.f195t);
            aMapLocation.setLongitude(this.f196u);
            aMapLocation.mo8515j(this.f183h);
            aMapLocation.mo8495e(this.f184i);
            aMapLocation.mo8523n(this.f198w);
            aMapLocation.mo8525o(this.f176a);
            aMapLocation.mo8501g(this.f180e);
            aMapLocation.mo8513i(this.f182g);
            aMapLocation.mo8486c(this.f186k);
            aMapLocation.mo8511h(this.f181f);
            aMapLocation.mo8485c(this.f191p);
            aMapLocation.mo8482b(this.f192q);
            aMapLocation.mo8526p(this.f177b);
            aMapLocation.mo8483b(this.f172A);
            aMapLocation.mo8479a(this.f190o);
            aMapLocation.mo8478a(this.f193r);
            aMapLocation.mo8481b(this.f194s);
            aMapLocation.mo8487c(this.f200y);
            aMapLocation.mo8521m(this.f189n);
            aMapLocation.mo8517k(this.f185j);
            aMapLocation.mo8498f(this.f179d);
            aMapLocation.mo8491d(this.f187l);
            aMapLocation.mo8490d(this.f197v);
            aMapLocation.mo8476a(this.f199x);
            aMapLocation.mo8519l(this.f188m);
            aMapLocation.mo8529q(this.f201z);
            aMapLocation.setExtras(getExtras());
            if (this.f178c != null) {
                aMapLocation.mo8477a(this.f178c.clone());
            }
            aMapLocation.mo8531r(this.f173B);
            aMapLocation.mo8500g(this.f174C);
            aMapLocation.mo8510h(this.f175D);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "AMapLocation", "clone");
        }
        return aMapLocation;
    }

    /* renamed from: y */
    public String mo8542y() {
        return this.f173B;
    }
}
