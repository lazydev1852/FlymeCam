package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;

public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PoiItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PoiItem[i];
        }
    };

    /* renamed from: a */
    private String f161a = "";

    /* renamed from: b */
    private String f162b = "";

    /* renamed from: c */
    private String f163c = "";

    /* renamed from: d */
    private String f164d = "";

    /* renamed from: e */
    private String f165e = "";

    /* renamed from: f */
    private double f166f = 0.0d;

    /* renamed from: g */
    private double f167g = 0.0d;

    /* renamed from: h */
    private String f168h = "";

    /* renamed from: i */
    private String f169i = "";

    /* renamed from: j */
    private String f170j = "";

    /* renamed from: k */
    private String f171k = "";

    public PoiItem() {
    }

    protected PoiItem(Parcel parcel) {
        this.f161a = parcel.readString();
        this.f162b = parcel.readString();
        this.f163c = parcel.readString();
        this.f164d = parcel.readString();
        this.f165e = parcel.readString();
        this.f166f = parcel.readDouble();
        this.f167g = parcel.readDouble();
        this.f168h = parcel.readString();
        this.f169i = parcel.readString();
        this.f170j = parcel.readString();
        this.f171k = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f161a);
        parcel.writeString(this.f162b);
        parcel.writeString(this.f163c);
        parcel.writeString(this.f164d);
        parcel.writeString(this.f165e);
        parcel.writeDouble(this.f166f);
        parcel.writeDouble(this.f167g);
        parcel.writeString(this.f168h);
        parcel.writeString(this.f169i);
        parcel.writeString(this.f170j);
        parcel.writeString(this.f171k);
    }
}
