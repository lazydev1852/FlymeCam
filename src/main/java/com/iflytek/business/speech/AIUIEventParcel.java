package com.iflytek.business.speech;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class AIUIEventParcel extends AIUIEvent implements Parcelable {
    public static Parcelable.Creator<AIUIEventParcel> CREATOR = new Parcelable.Creator<AIUIEventParcel>() {
        /* renamed from: a */
        public AIUIEventParcel createFromParcel(Parcel parcel) {
            return new AIUIEventParcel(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readBundle());
        }

        /* renamed from: a */
        public AIUIEventParcel[] newArray(int i) {
            return new AIUIEventParcel[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public AIUIEventParcel() {
    }

    public AIUIEventParcel(int i, int i2, int i3, Bundle bundle) {
        super(i, i2, i3, bundle);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2462a);
        parcel.writeInt(this.f2463b);
        parcel.writeInt(this.f2464c);
        parcel.writeBundle(this.f2465d);
    }
}
