package com.meizu.update.util;

import android.os.Parcel;
import android.os.Parcelable;

public class PluginUpdateInfo implements Parcelable {
    public static final Parcelable.Creator<PluginUpdateInfo> CREATOR = new Parcelable.Creator<PluginUpdateInfo>() {
        /* renamed from: a */
        public PluginUpdateInfo createFromParcel(Parcel parcel) {
            return new PluginUpdateInfo(parcel);
        }

        /* renamed from: a */
        public PluginUpdateInfo[] newArray(int i) {
            return new PluginUpdateInfo[i];
        }
    };
    public String mDigest;
    public boolean mExistsUpdate;
    public String mPluginName;
    public String mPluginPackageName;
    public int mPluginType;
    public String mSize;
    public long mSizeByte;
    public String mTargetAppName;
    public String mUpdateUrl;
    public String mUpdateUrl2;
    public int mVerifyMode;
    public String mVersionDate;
    public String mVersionDesc;
    public String mVersionName;

    private int boolean2int(boolean z) {
        return z ? 1 : 0;
    }

    private boolean int2boolean(int i) {
        return i != 0;
    }

    public int describeContents() {
        return 0;
    }

    public PluginUpdateInfo() {
    }

    public static PluginUpdateInfo generateNoUpdateInfo() {
        PluginUpdateInfo pluginUpdateInfo = new PluginUpdateInfo();
        pluginUpdateInfo.mExistsUpdate = false;
        return pluginUpdateInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(boolean2int(this.mExistsUpdate));
        parcel.writeString(this.mUpdateUrl);
        parcel.writeString(this.mUpdateUrl2);
        parcel.writeString(this.mVersionDesc);
        parcel.writeString(this.mVersionName);
        parcel.writeString(this.mSize);
        parcel.writeString(this.mVersionDate);
        parcel.writeString(this.mDigest);
        parcel.writeInt(this.mVerifyMode);
        parcel.writeLong(this.mSizeByte);
        parcel.writeInt(this.mPluginType);
        parcel.writeString(this.mTargetAppName);
        parcel.writeString(this.mPluginName);
        parcel.writeString(this.mPluginPackageName);
    }

    private void readFromParcel(Parcel parcel) {
        this.mExistsUpdate = int2boolean(parcel.readInt());
        this.mUpdateUrl = parcel.readString();
        this.mUpdateUrl2 = parcel.readString();
        this.mVersionDesc = parcel.readString();
        this.mVersionName = parcel.readString();
        this.mSize = parcel.readString();
        this.mVersionDate = parcel.readString();
        this.mDigest = parcel.readString();
        this.mVerifyMode = parcel.readInt();
        this.mSizeByte = parcel.readLong();
        this.mPluginType = parcel.readInt();
        this.mTargetAppName = parcel.readString();
        this.mPluginName = parcel.readString();
        this.mPluginPackageName = parcel.readString();
    }

    private PluginUpdateInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
