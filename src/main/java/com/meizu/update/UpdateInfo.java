package com.meizu.update;

import android.os.Parcel;
import android.os.Parcelable;

public class UpdateInfo implements Parcelable {
    public static final Parcelable.Creator<UpdateInfo> CREATOR = new Parcelable.Creator<UpdateInfo>() {
        /* renamed from: a */
        public UpdateInfo createFromParcel(Parcel parcel) {
            return new UpdateInfo(parcel);
        }

        /* renamed from: a */
        public UpdateInfo[] newArray(int i) {
            return new UpdateInfo[i];
        }
    };
    public int mAdvancedOptions;
    public boolean mAllowDownload;
    public String mDigest;
    public boolean mExistsUpdate;
    public boolean mIsPatch;
    public boolean mNeedUpdate;
    public boolean mNoteNetWork;
    public String mPackageName;
    public int mSilentUpgrade;
    public String mSize;
    public long mSizeByte;
    public long mSourceFileSize;
    public String mSourceMsgDigest;
    public String mSourceVersionName;
    public long mTargetFileSize;
    public String mTargetMsgDigest;
    public String mUpdateUrl;
    public String mUpdateUrl2;
    public int mUpgradeCondition;
    public int mVerifyMode;
    public int mVersionCode;
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

    protected UpdateInfo() {
        this.mSilentUpgrade = 0;
        this.mAdvancedOptions = 0;
        this.mUpgradeCondition = 0;
        this.mVersionCode = -1;
        this.mAllowDownload = true;
    }

    public static UpdateInfo generateNoUpdateInfo() {
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.mNeedUpdate = false;
        updateInfo.mExistsUpdate = false;
        updateInfo.mSilentUpgrade = 0;
        return updateInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(boolean2int(this.mNeedUpdate));
        parcel.writeInt(boolean2int(this.mExistsUpdate));
        parcel.writeString(this.mUpdateUrl);
        parcel.writeString(this.mVersionDesc);
        parcel.writeString(this.mVersionName);
        parcel.writeString(this.mSize);
        parcel.writeString(this.mVersionDate);
        parcel.writeString(this.mDigest);
        parcel.writeInt(this.mVerifyMode);
        parcel.writeLong(this.mSizeByte);
        parcel.writeString(this.mUpdateUrl2);
        parcel.writeInt(boolean2int(this.mNoteNetWork));
        parcel.writeInt(this.mVersionCode);
        parcel.writeString(this.mPackageName);
        parcel.writeInt(boolean2int(this.mAllowDownload));
        parcel.writeInt(boolean2int(this.mIsPatch));
        parcel.writeInt(this.mSilentUpgrade);
        parcel.writeInt(this.mUpgradeCondition);
        parcel.writeInt(this.mAdvancedOptions);
        parcel.writeString(this.mSourceVersionName);
        parcel.writeString(this.mSourceMsgDigest);
        parcel.writeLong(this.mSourceFileSize);
        parcel.writeLong(this.mTargetFileSize);
        parcel.writeString(this.mTargetMsgDigest);
    }

    private void readFromParcel(Parcel parcel) {
        this.mNeedUpdate = int2boolean(parcel.readInt());
        this.mExistsUpdate = int2boolean(parcel.readInt());
        this.mUpdateUrl = parcel.readString();
        this.mVersionDesc = parcel.readString();
        this.mVersionName = parcel.readString();
        this.mSize = parcel.readString();
        this.mVersionDate = parcel.readString();
        this.mDigest = parcel.readString();
        this.mVerifyMode = parcel.readInt();
        this.mSizeByte = parcel.readLong();
        this.mUpdateUrl2 = parcel.readString();
        this.mNoteNetWork = int2boolean(parcel.readInt());
        this.mVersionCode = parcel.readInt();
        this.mPackageName = parcel.readString();
        this.mAllowDownload = int2boolean(parcel.readInt());
        this.mIsPatch = int2boolean(parcel.readInt());
        this.mSilentUpgrade = parcel.readInt();
        this.mUpgradeCondition = parcel.readInt();
        this.mAdvancedOptions = parcel.readInt();
        this.mSourceVersionName = parcel.readString();
        this.mSourceMsgDigest = parcel.readString();
        this.mSourceFileSize = parcel.readLong();
        this.mTargetFileSize = parcel.readLong();
        this.mTargetMsgDigest = parcel.readString();
    }

    private UpdateInfo(Parcel parcel) {
        this.mSilentUpgrade = 0;
        this.mAdvancedOptions = 0;
        this.mUpgradeCondition = 0;
        this.mVersionCode = -1;
        this.mAllowDownload = true;
        readFromParcel(parcel);
    }
}
