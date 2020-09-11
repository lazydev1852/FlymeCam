package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.List;

public class GeoFence implements Parcelable {
    public static final Parcelable.Creator<GeoFence> CREATOR = new Parcelable.Creator<GeoFence>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GeoFence(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeoFence[i];
        }
    };

    /* renamed from: a */
    private String f143a;

    /* renamed from: b */
    private String f144b;

    /* renamed from: c */
    private String f145c;

    /* renamed from: d */
    private PendingIntent f146d;

    /* renamed from: e */
    private int f147e;

    /* renamed from: f */
    private PoiItem f148f;

    /* renamed from: g */
    private List<DistrictItem> f149g;

    /* renamed from: h */
    private List<List<DPoint>> f150h;

    /* renamed from: i */
    private float f151i;

    /* renamed from: j */
    private long f152j;

    /* renamed from: k */
    private int f153k;

    /* renamed from: l */
    private float f154l;

    /* renamed from: m */
    private float f155m;

    /* renamed from: n */
    private DPoint f156n;

    /* renamed from: o */
    private int f157o;

    /* renamed from: p */
    private long f158p;

    /* renamed from: q */
    private boolean f159q;

    /* renamed from: r */
    private AMapLocation f160r;

    public GeoFence() {
        this.f146d = null;
        this.f147e = 0;
        this.f148f = null;
        this.f149g = null;
        this.f151i = 0.0f;
        this.f152j = -1;
        this.f153k = 1;
        this.f154l = 0.0f;
        this.f155m = 0.0f;
        this.f156n = null;
        this.f157o = 0;
        this.f158p = -1;
        this.f159q = true;
        this.f160r = null;
    }

    protected GeoFence(Parcel parcel) {
        this.f146d = null;
        boolean z = false;
        this.f147e = 0;
        this.f148f = null;
        this.f149g = null;
        this.f151i = 0.0f;
        this.f152j = -1;
        this.f153k = 1;
        this.f154l = 0.0f;
        this.f155m = 0.0f;
        this.f156n = null;
        this.f157o = 0;
        this.f158p = -1;
        this.f159q = true;
        this.f160r = null;
        this.f143a = parcel.readString();
        this.f144b = parcel.readString();
        this.f145c = parcel.readString();
        this.f146d = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.f147e = parcel.readInt();
        this.f148f = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        this.f149g = parcel.createTypedArrayList(DistrictItem.CREATOR);
        this.f151i = parcel.readFloat();
        this.f152j = parcel.readLong();
        this.f153k = parcel.readInt();
        this.f154l = parcel.readFloat();
        this.f155m = parcel.readFloat();
        this.f156n = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        this.f157o = parcel.readInt();
        this.f158p = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt != 0) {
            this.f150h = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                this.f150h.add(parcel.createTypedArrayList(DPoint.CREATOR));
            }
        }
        this.f159q = parcel.readByte() != 0 ? true : z;
        this.f160r = (AMapLocation) parcel.readParcelable(AMapLocation.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoFence)) {
            return false;
        }
        GeoFence geoFence = (GeoFence) obj;
        if (TextUtils.isEmpty(this.f144b)) {
            if (!TextUtils.isEmpty(geoFence.f144b)) {
                return false;
            }
        } else if (!this.f144b.equals(geoFence.f144b)) {
            return false;
        }
        if (this.f156n == null) {
            if (geoFence.f156n != null) {
                return false;
            }
        } else if (!this.f156n.equals(geoFence.f156n)) {
            return false;
        }
        if (this.f151i != geoFence.f151i) {
            return false;
        }
        return this.f150h == null ? geoFence.f150h == null : this.f150h.equals(geoFence.f150h);
    }

    public int hashCode() {
        return this.f144b.hashCode() + this.f150h.hashCode() + this.f156n.hashCode() + ((int) (this.f151i * 100.0f));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f143a);
        parcel.writeString(this.f144b);
        parcel.writeString(this.f145c);
        parcel.writeParcelable(this.f146d, i);
        parcel.writeInt(this.f147e);
        parcel.writeParcelable(this.f148f, i);
        parcel.writeTypedList(this.f149g);
        parcel.writeFloat(this.f151i);
        parcel.writeLong(this.f152j);
        parcel.writeInt(this.f153k);
        parcel.writeFloat(this.f154l);
        parcel.writeFloat(this.f155m);
        parcel.writeParcelable(this.f156n, i);
        parcel.writeInt(this.f157o);
        parcel.writeLong(this.f158p);
        if (this.f150h != null && !this.f150h.isEmpty()) {
            parcel.writeInt(this.f150h.size());
            for (List<DPoint> writeTypedList : this.f150h) {
                parcel.writeTypedList(writeTypedList);
            }
        }
        parcel.writeByte(this.f159q ? (byte) 1 : 0);
        parcel.writeParcelable(this.f160r, i);
    }
}
