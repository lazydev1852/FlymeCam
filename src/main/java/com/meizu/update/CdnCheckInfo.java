package com.meizu.update;

import android.os.Parcel;
import android.os.Parcelable;

public class CdnCheckInfo implements Parcelable {
    public static final Parcelable.Creator<CdnCheckInfo> CREATOR = new Parcelable.Creator<CdnCheckInfo>() {
        /* renamed from: a */
        public CdnCheckInfo createFromParcel(Parcel parcel) {
            return new CdnCheckInfo(parcel);
        }

        /* renamed from: a */
        public CdnCheckInfo[] newArray(int i) {
            return new CdnCheckInfo[i];
        }
    };
    public String[] mAllowPackages;
    public double mAllowRate;
    public boolean mDelay;
    public int mDelaySecond;
    public String mStrategy;

    private int boolean2int(boolean z) {
        return z ? 1 : 0;
    }

    private boolean int2boolean(int i) {
        return i != 0;
    }

    public int describeContents() {
        return 0;
    }

    public CdnCheckInfo() {
    }

    private CdnCheckInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(boolean2int(this.mDelay));
        parcel.writeStringArray(this.mAllowPackages);
        parcel.writeString(this.mStrategy);
        parcel.writeDouble(this.mAllowRate);
        parcel.writeInt(this.mDelaySecond);
    }

    private void readFromParcel(Parcel parcel) {
        this.mDelay = int2boolean(parcel.readInt());
        this.mAllowPackages = parcel.createStringArray();
        this.mStrategy = parcel.readString();
        this.mAllowRate = parcel.readDouble();
        this.mDelaySecond = parcel.readInt();
    }
}
