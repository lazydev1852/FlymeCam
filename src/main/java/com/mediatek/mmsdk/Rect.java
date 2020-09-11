package com.mediatek.mmsdk;

import android.os.Parcel;
import android.os.Parcelable;

public class Rect implements Parcelable {
    public static final Parcelable.Creator<Rect> CREATOR = new Parcelable.Creator<Rect>() {
        public Rect createFromParcel(Parcel parcel) {
            return new Rect(parcel);
        }

        public Rect[] newArray(int i) {
            return new Rect[i];
        }
    };
    private int bottom;
    private int left;
    private int right;
    private int top;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.left);
        parcel.writeInt(this.top);
        parcel.writeInt(this.right);
        parcel.writeInt(this.bottom);
    }

    public void readFromParcel(Parcel parcel) {
        this.left = parcel.readInt();
        this.top = parcel.readInt();
        this.right = parcel.readInt();
        this.bottom = parcel.readInt();
    }

    private Rect(Parcel parcel) {
        this.left = parcel.readInt();
        this.top = parcel.readInt();
        this.right = parcel.readInt();
        this.bottom = parcel.readInt();
    }
}
