package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.loc.CoreUtil;

public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator<AMapLocationClientOption>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AMapLocationClientOption[i];
        }
    };

    /* renamed from: a */
    static String f202a = "";

    /* renamed from: b */
    public static boolean f203b = true;

    /* renamed from: c */
    public static long f204c = 30000;

    /* renamed from: l */
    private static AMapLocationProtocol f205l = AMapLocationProtocol.HTTP;

    /* renamed from: w */
    private static boolean f206w = true;

    /* renamed from: d */
    private long f207d;

    /* renamed from: e */
    private long f208e;

    /* renamed from: f */
    private boolean f209f;

    /* renamed from: g */
    private boolean f210g;

    /* renamed from: h */
    private boolean f211h;

    /* renamed from: i */
    private boolean f212i;

    /* renamed from: j */
    private boolean f213j;

    /* renamed from: k */
    private AMapLocationMode f214k;

    /* renamed from: m */
    private boolean f215m;

    /* renamed from: n */
    private boolean f216n;

    /* renamed from: o */
    private boolean f217o;

    /* renamed from: p */
    private boolean f218p;

    /* renamed from: q */
    private boolean f219q;

    /* renamed from: r */
    private boolean f220r;

    /* renamed from: s */
    private boolean f221s;

    /* renamed from: t */
    private long f222t;

    /* renamed from: u */
    private long f223u;

    /* renamed from: v */
    private GeoLanguage f224v;

    /* renamed from: x */
    private float f225x;

    /* renamed from: y */
    private AMapLocationPurpose f226y;

    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);
        

        /* renamed from: a */
        private int f229a;

        private AMapLocationProtocol(int i) {
            this.f229a = i;
        }

        public final int getValue() {
            return this.f229a;
        }
    }

    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public AMapLocationClientOption() {
        this.f207d = 2000;
        this.f208e = (long) CoreUtil.f2982f;
        this.f209f = false;
        this.f210g = true;
        this.f211h = true;
        this.f212i = true;
        this.f213j = true;
        this.f214k = AMapLocationMode.Hight_Accuracy;
        this.f215m = false;
        this.f216n = false;
        this.f217o = true;
        this.f218p = true;
        this.f219q = false;
        this.f220r = false;
        this.f221s = true;
        this.f222t = 30000;
        this.f223u = 30000;
        this.f224v = GeoLanguage.DEFAULT;
        this.f225x = 0.0f;
        this.f226y = null;
    }

    protected AMapLocationClientOption(Parcel parcel) {
        this.f207d = 2000;
        this.f208e = (long) CoreUtil.f2982f;
        boolean z = false;
        this.f209f = false;
        this.f210g = true;
        this.f211h = true;
        this.f212i = true;
        this.f213j = true;
        this.f214k = AMapLocationMode.Hight_Accuracy;
        this.f215m = false;
        this.f216n = false;
        this.f217o = true;
        this.f218p = true;
        this.f219q = false;
        this.f220r = false;
        this.f221s = true;
        this.f222t = 30000;
        this.f223u = 30000;
        this.f224v = GeoLanguage.DEFAULT;
        this.f225x = 0.0f;
        AMapLocationPurpose aMapLocationPurpose = null;
        this.f226y = null;
        this.f207d = parcel.readLong();
        this.f208e = parcel.readLong();
        this.f209f = parcel.readByte() != 0;
        this.f210g = parcel.readByte() != 0;
        this.f211h = parcel.readByte() != 0;
        this.f212i = parcel.readByte() != 0;
        this.f213j = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.f214k = readInt == -1 ? AMapLocationMode.Hight_Accuracy : AMapLocationMode.values()[readInt];
        this.f215m = parcel.readByte() != 0;
        this.f216n = parcel.readByte() != 0;
        this.f217o = parcel.readByte() != 0;
        this.f218p = parcel.readByte() != 0;
        this.f219q = parcel.readByte() != 0;
        this.f220r = parcel.readByte() != 0;
        this.f221s = parcel.readByte() != 0;
        this.f222t = parcel.readLong();
        int readInt2 = parcel.readInt();
        f205l = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.f224v = readInt3 == -1 ? GeoLanguage.DEFAULT : GeoLanguage.values()[readInt3];
        f206w = parcel.readByte() != 0;
        this.f225x = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.f226y = readInt4 != -1 ? AMapLocationPurpose.values()[readInt4] : aMapLocationPurpose;
        f203b = parcel.readByte() != 0 ? true : z;
        this.f223u = parcel.readLong();
    }

    /* renamed from: a */
    public static String m479a() {
        return f202a;
    }

    /* renamed from: a */
    public static void m480a(AMapLocationProtocol aMapLocationProtocol) {
        f205l = aMapLocationProtocol;
    }

    /* renamed from: c */
    public static void m481c(long j) {
        f204c = j;
    }

    /* renamed from: d */
    public static void m482d(boolean z) {
        f206w = z;
    }

    /* renamed from: e */
    public static void m483e(boolean z) {
        f203b = z;
    }

    /* renamed from: u */
    public static boolean m484u() {
        return f206w;
    }

    /* renamed from: w */
    public static boolean m485w() {
        return f203b;
    }

    /* renamed from: a */
    public AMapLocationClientOption mo8545a(long j) {
        if (j <= 800) {
            j = 800;
        }
        this.f207d = j;
        return this;
    }

    /* renamed from: a */
    public AMapLocationClientOption mo8546a(AMapLocationMode aMapLocationMode) {
        this.f214k = aMapLocationMode;
        return this;
    }

    /* renamed from: a */
    public AMapLocationClientOption mo8547a(boolean z) {
        this.f209f = z;
        return this;
    }

    /* renamed from: b */
    public AMapLocationClientOption mo8548b(long j) {
        this.f208e = j;
        return this;
    }

    /* renamed from: b */
    public AMapLocationClientOption mo8549b(boolean z) {
        this.f221s = z;
        this.f212i = this.f221s ? this.f213j : false;
        return this;
    }

    /* renamed from: b */
    public boolean mo8550b() {
        return this.f210g;
    }

    /* renamed from: c */
    public long mo8551c() {
        return this.f207d;
    }

    /* renamed from: c */
    public AMapLocationClientOption mo8552c(boolean z) {
        this.f216n = z;
        return this;
    }

    /* renamed from: d */
    public boolean mo8554d() {
        return this.f209f;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public boolean mo8556e() {
        return this.f211h;
    }

    /* renamed from: f */
    public boolean mo8557f() {
        return this.f212i;
    }

    /* renamed from: g */
    public boolean mo8558g() {
        return this.f221s;
    }

    /* renamed from: h */
    public AMapLocationMode mo8559h() {
        return this.f214k;
    }

    /* renamed from: i */
    public AMapLocationProtocol mo8560i() {
        return f205l;
    }

    /* renamed from: j */
    public boolean mo8561j() {
        return this.f215m;
    }

    /* renamed from: k */
    public boolean mo8562k() {
        return this.f216n;
    }

    /* renamed from: l */
    public long mo8563l() {
        return this.f223u;
    }

    /* renamed from: m */
    public AMapLocationClientOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.f207d = this.f207d;
        aMapLocationClientOption.f209f = this.f209f;
        aMapLocationClientOption.f214k = this.f214k;
        aMapLocationClientOption.f210g = this.f210g;
        aMapLocationClientOption.f215m = this.f215m;
        aMapLocationClientOption.f216n = this.f216n;
        aMapLocationClientOption.f211h = this.f211h;
        aMapLocationClientOption.f212i = this.f212i;
        aMapLocationClientOption.f208e = this.f208e;
        aMapLocationClientOption.f217o = this.f217o;
        aMapLocationClientOption.f218p = this.f218p;
        aMapLocationClientOption.f219q = this.f219q;
        aMapLocationClientOption.f220r = mo8569r();
        aMapLocationClientOption.f221s = mo8558g();
        aMapLocationClientOption.f222t = this.f222t;
        m480a(mo8560i());
        aMapLocationClientOption.f224v = this.f224v;
        m482d(m484u());
        aMapLocationClientOption.f225x = this.f225x;
        aMapLocationClientOption.f226y = this.f226y;
        m483e(m485w());
        m481c(mo8575x());
        aMapLocationClientOption.f223u = this.f223u;
        return aMapLocationClientOption;
    }

    /* renamed from: n */
    public long mo8565n() {
        return this.f208e;
    }

    /* renamed from: o */
    public boolean mo8566o() {
        return this.f217o;
    }

    /* renamed from: p */
    public boolean mo8567p() {
        return this.f218p;
    }

    /* renamed from: q */
    public boolean mo8568q() {
        return this.f219q;
    }

    /* renamed from: r */
    public boolean mo8569r() {
        return this.f220r;
    }

    /* renamed from: s */
    public long mo8570s() {
        return this.f222t;
    }

    /* renamed from: t */
    public GeoLanguage mo8571t() {
        return this.f224v;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.f207d) + "#" + "isOnceLocation:" + String.valueOf(this.f209f) + "#" + "locationMode:" + String.valueOf(this.f214k) + "#" + "locationProtocol:" + String.valueOf(f205l) + "#" + "isMockEnable:" + String.valueOf(this.f210g) + "#" + "isKillProcess:" + String.valueOf(this.f215m) + "#" + "isGpsFirst:" + String.valueOf(this.f216n) + "#" + "isNeedAddress:" + String.valueOf(this.f211h) + "#" + "isWifiActiveScan:" + String.valueOf(this.f212i) + "#" + "wifiScan:" + String.valueOf(this.f221s) + "#" + "httpTimeOut:" + String.valueOf(this.f208e) + "#" + "isLocationCacheEnable:" + String.valueOf(this.f218p) + "#" + "isOnceLocationLatest:" + String.valueOf(this.f219q) + "#" + "sensorEnable:" + String.valueOf(this.f220r) + "#" + "geoLanguage:" + String.valueOf(this.f224v) + "#" + "locationPurpose:" + String.valueOf(this.f226y) + "#";
    }

    /* renamed from: v */
    public float mo8573v() {
        return this.f225x;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f207d);
        parcel.writeLong(this.f208e);
        parcel.writeByte(this.f209f ? (byte) 1 : 0);
        parcel.writeByte(this.f210g ? (byte) 1 : 0);
        parcel.writeByte(this.f211h ? (byte) 1 : 0);
        parcel.writeByte(this.f212i ? (byte) 1 : 0);
        parcel.writeByte(this.f213j ? (byte) 1 : 0);
        int i2 = -1;
        parcel.writeInt(this.f214k == null ? -1 : this.f214k.ordinal());
        parcel.writeByte(this.f215m ? (byte) 1 : 0);
        parcel.writeByte(this.f216n ? (byte) 1 : 0);
        parcel.writeByte(this.f217o ? (byte) 1 : 0);
        parcel.writeByte(this.f218p ? (byte) 1 : 0);
        parcel.writeByte(this.f219q ? (byte) 1 : 0);
        parcel.writeByte(this.f220r ? (byte) 1 : 0);
        parcel.writeByte(this.f221s ? (byte) 1 : 0);
        parcel.writeLong(this.f222t);
        parcel.writeInt(f205l == null ? -1 : mo8560i().ordinal());
        parcel.writeInt(this.f224v == null ? -1 : this.f224v.ordinal());
        parcel.writeByte(f206w ? (byte) 1 : 0);
        parcel.writeFloat(this.f225x);
        if (this.f226y != null) {
            i2 = this.f226y.ordinal();
        }
        parcel.writeInt(i2);
        parcel.writeInt(f203b ? 1 : 0);
        parcel.writeLong(this.f223u);
    }

    /* renamed from: x */
    public long mo8575x() {
        return f204c;
    }
}
