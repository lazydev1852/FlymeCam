package com.mediatek.mmsdk;

import android.os.Parcel;
import android.os.Parcelable;

public class TrasformOptions implements Parcelable {
    public static final Parcelable.Creator<TrasformOptions> CREATOR = new Parcelable.Creator<TrasformOptions>() {
        public TrasformOptions createFromParcel(Parcel parcel) {
            return new TrasformOptions(parcel);
        }

        public TrasformOptions[] newArray(int i) {
            return new TrasformOptions[i];
        }
    };
    private int encQuality;
    private int isDither;
    private Parcelable rect;
    private int sharpnessLevel;
    private int transform;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.rect, i);
        parcel.writeInt(this.transform);
        parcel.writeInt(this.encQuality);
        parcel.writeInt(this.isDither);
        parcel.writeInt(this.sharpnessLevel);
    }

    public void readFromParcel(Parcel parcel) {
        this.rect = parcel.readParcelable((ClassLoader) null);
        this.transform = parcel.readInt();
        this.encQuality = parcel.readInt();
        this.isDither = parcel.readInt();
        this.sharpnessLevel = parcel.readInt();
    }

    private TrasformOptions(Parcel parcel) {
        this.rect = parcel.readParcelable((ClassLoader) null);
        this.transform = parcel.readInt();
        this.encQuality = parcel.readInt();
        this.isDither = parcel.readInt();
        this.sharpnessLevel = parcel.readInt();
    }
}
