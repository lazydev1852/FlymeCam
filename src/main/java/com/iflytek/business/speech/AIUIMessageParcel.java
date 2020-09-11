package com.iflytek.business.speech;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class AIUIMessageParcel extends AIUIMessage implements Parcelable {
    public static Parcelable.Creator<AIUIMessageParcel> CREATOR = new Parcelable.Creator<AIUIMessageParcel>() {
        /* renamed from: a */
        public AIUIMessageParcel createFromParcel(Parcel parcel) {
            return new AIUIMessageParcel(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readBundle());
        }

        /* renamed from: a */
        public AIUIMessageParcel[] newArray(int i) {
            return new AIUIMessageParcel[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public AIUIMessageParcel(int i, int i2, int i3, Bundle bundle) {
        super(i, i2, i3, bundle);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2466a);
        parcel.writeInt(this.f2467b);
        parcel.writeInt(this.f2468c);
        parcel.writeBundle(this.f2469d);
    }
}
