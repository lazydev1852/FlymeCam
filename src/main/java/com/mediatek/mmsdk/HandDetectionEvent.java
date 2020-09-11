package com.mediatek.mmsdk;

import android.os.Parcel;
import android.os.Parcelable;

public class HandDetectionEvent implements Parcelable {
    public static final Parcelable.Creator<HandDetectionEvent> CREATOR = new Parcelable.Creator<HandDetectionEvent>() {
        public HandDetectionEvent createFromParcel(Parcel parcel) {
            return new HandDetectionEvent(parcel);
        }

        public HandDetectionEvent[] newArray(int i) {
            return new HandDetectionEvent[i];
        }
    };
    private Parcelable boundBox;
    private float confidence;

    /* renamed from: id */
    private int f3452id;
    private int pose;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.boundBox, i);
        parcel.writeFloat(this.confidence);
        parcel.writeInt(this.f3452id);
        parcel.writeInt(this.pose);
    }

    public void readFromParcel(Parcel parcel) {
        this.boundBox = parcel.readParcelable((ClassLoader) null);
        this.confidence = parcel.readFloat();
        this.f3452id = parcel.readInt();
        this.pose = parcel.readInt();
    }

    private HandDetectionEvent(Parcel parcel) {
        this.boundBox = parcel.readParcelable((ClassLoader) null);
        this.confidence = parcel.readFloat();
        this.f3452id = parcel.readInt();
        this.pose = parcel.readInt();
    }
}
