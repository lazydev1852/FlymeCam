package com.meizu.privacy.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class PrivateItem implements Parcelable {
    public static final Parcelable.Creator<PrivateItem> CREATOR = new Parcelable.Creator<PrivateItem>() {
        /* renamed from: a */
        public PrivateItem[] newArray(int i) {
            return new PrivateItem[i];
        }

        /* renamed from: a */
        public PrivateItem createFromParcel(Parcel parcel) {
            return new PrivateItem(parcel.readLong(), parcel.readString(), parcel.readInt());
        }
    };

    /* renamed from: a */
    public long f15633a;

    /* renamed from: b */
    public String f15634b;

    /* renamed from: c */
    public int f15635c;

    public int describeContents() {
        return 0;
    }

    public PrivateItem(long j, String str, int i) {
        this.f15633a = j;
        this.f15634b = str;
        this.f15635c = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f15633a);
        parcel.writeString(this.f15634b);
        parcel.writeInt(this.f15635c);
    }
}
