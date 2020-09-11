package com.meizu.privacy.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class UpdatePrivateResult implements Parcelable {
    public static final Parcelable.Creator<UpdatePrivateResult> CREATOR = new Parcelable.Creator<UpdatePrivateResult>() {
        /* renamed from: a */
        public UpdatePrivateResult[] newArray(int i) {
            return new UpdatePrivateResult[i];
        }

        /* renamed from: a */
        public UpdatePrivateResult createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            return new UpdatePrivateResult(readString, z);
        }
    };

    /* renamed from: a */
    public String f15636a;

    /* renamed from: b */
    public boolean f15637b;

    public int describeContents() {
        return 0;
    }

    public UpdatePrivateResult(String str, boolean z) {
        this.f15636a = str;
        this.f15637b = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15636a);
        parcel.writeInt(this.f15637b ? 1 : 0);
    }
}
