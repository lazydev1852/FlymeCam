package com.mediatek.mmsdk;

import android.os.Parcel;
import android.os.Parcelable;

public class EffectHalVersion implements Parcelable {
    public static final Parcelable.Creator<EffectHalVersion> CREATOR = new Parcelable.Creator<EffectHalVersion>() {
        public EffectHalVersion createFromParcel(Parcel parcel) {
            return new EffectHalVersion(parcel);
        }

        public EffectHalVersion[] newArray(int i) {
            return new EffectHalVersion[i];
        }
    };
    private int mMajor;
    private int mMinor;
    private String mName;

    public int describeContents() {
        return 0;
    }

    public EffectHalVersion() {
        this.mName = "Null";
        this.mMajor = 0;
        this.mMinor = 0;
    }

    public EffectHalVersion(String str, int i, int i2) {
        this.mName = str;
        this.mMajor = i;
        this.mMinor = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeInt(this.mMajor);
        parcel.writeInt(this.mMinor);
    }

    public void readFromParcel(Parcel parcel) {
        this.mName = parcel.readString();
        this.mMajor = parcel.readInt();
        this.mMinor = parcel.readInt();
    }

    private EffectHalVersion(Parcel parcel) {
        this.mName = parcel.readString();
        this.mMajor = parcel.readInt();
        this.mMinor = parcel.readInt();
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setMajor(int i) {
        this.mMajor = i;
    }

    public int getMajor() {
        return this.mMajor;
    }

    public void setMinor(int i) {
        this.mMinor = i;
    }

    public int getMinor() {
        return this.mMinor;
    }
}
