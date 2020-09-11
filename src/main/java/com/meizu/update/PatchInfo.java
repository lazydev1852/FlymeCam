package com.meizu.update;

import android.os.Parcel;
import android.os.Parcelable;

public class PatchInfo implements Parcelable {
    public static final Parcelable.Creator<PatchInfo> CREATOR = new Parcelable.Creator<PatchInfo>() {
        /* renamed from: a */
        public PatchInfo createFromParcel(Parcel parcel) {
            return new PatchInfo(parcel);
        }

        /* renamed from: a */
        public PatchInfo[] newArray(int i) {
            return new PatchInfo[i];
        }
    };
    public String patchDigest;
    public String patchFileSize;
    public long patchFileSizeByte;
    public String patchSlaveUrl;
    public String patchUrl;
    public int patchVerifyMode;
    public String sourceDigest;
    public long sourceFileSizeByte;
    public int sourceVerifyMode;
    public int sourceVersionCode;
    public String sourceVersionName;

    public int describeContents() {
        return 0;
    }

    public PatchInfo() {
    }

    private PatchInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sourceVersionName);
        parcel.writeInt(this.sourceVersionCode);
        parcel.writeString(this.sourceDigest);
        parcel.writeLong(this.sourceFileSizeByte);
        parcel.writeString(this.patchUrl);
        parcel.writeString(this.patchSlaveUrl);
        parcel.writeString(this.patchFileSize);
        parcel.writeLong(this.patchFileSizeByte);
        parcel.writeString(this.patchDigest);
        parcel.writeInt(this.patchVerifyMode);
        parcel.writeInt(this.sourceVerifyMode);
    }

    private void readFromParcel(Parcel parcel) {
        this.sourceVersionName = parcel.readString();
        this.sourceVersionCode = parcel.readInt();
        this.sourceDigest = parcel.readString();
        this.sourceFileSizeByte = parcel.readLong();
        this.patchUrl = parcel.readString();
        this.patchSlaveUrl = parcel.readString();
        this.patchFileSize = parcel.readString();
        this.patchFileSizeByte = parcel.readLong();
        this.patchDigest = parcel.readString();
        this.patchVerifyMode = parcel.readInt();
        this.sourceVerifyMode = parcel.readInt();
    }
}
