package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DistrictItem[i];
        }
    };

    /* renamed from: a */
    private String f139a = "";

    /* renamed from: b */
    private String f140b = null;

    /* renamed from: c */
    private String f141c = null;

    /* renamed from: d */
    private List<DPoint> f142d = null;

    public DistrictItem() {
    }

    protected DistrictItem(Parcel parcel) {
        this.f139a = parcel.readString();
        this.f140b = parcel.readString();
        this.f141c = parcel.readString();
        this.f142d = parcel.createTypedArrayList(DPoint.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f139a);
        parcel.writeString(this.f140b);
        parcel.writeString(this.f141c);
        parcel.writeTypedList(this.f142d);
    }
}
