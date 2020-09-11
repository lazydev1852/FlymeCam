package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;

public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new Parcelable.Creator<DPoint>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DPoint(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DPoint[i];
        }
    };

    /* renamed from: a */
    private double f239a = 0.0d;

    /* renamed from: b */
    private double f240b = 0.0d;

    public DPoint() {
    }

    public DPoint(double d, double d2) {
        d2 = d2 > 180.0d ? 180.0d : d2;
        d2 = d2 < -180.0d ? -180.0d : d2;
        d = d > 90.0d ? 90.0d : d;
        d = d < -90.0d ? -90.0d : d;
        this.f239a = d2;
        this.f240b = d;
    }

    protected DPoint(Parcel parcel) {
        this.f239a = parcel.readDouble();
        this.f240b = parcel.readDouble();
    }

    /* renamed from: a */
    public double mo8584a() {
        return this.f239a;
    }

    /* renamed from: b */
    public double mo8585b() {
        return this.f240b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return this.f240b == dPoint.f240b && this.f239a == dPoint.f239a;
    }

    public int hashCode() {
        return Double.valueOf((this.f240b + this.f239a) * 1000000.0d).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f239a);
        parcel.writeDouble(this.f240b);
    }
}
