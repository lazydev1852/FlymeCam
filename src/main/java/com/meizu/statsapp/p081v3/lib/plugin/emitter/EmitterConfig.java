package com.meizu.statsapp.p081v3.lib.plugin.emitter;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.EmitterConfig */
public class EmitterConfig implements Parcelable {
    public static final Parcelable.Creator<EmitterConfig> CREATOR = new Parcelable.Creator<EmitterConfig>() {
        public EmitterConfig createFromParcel(Parcel parcel) {
            return new EmitterConfig(parcel);
        }

        public EmitterConfig[] newArray(int i) {
            return new EmitterConfig[i];
        }
    };
    boolean active = true;
    int flushCacheLimit = 50;
    long flushDelayInterval = 1800000;
    long flushMobileTrafficLimit = 2097152;
    boolean flushOnCharge = true;
    boolean flushOnReconnect = true;
    boolean flushOnStart = true;
    int neartimeInterval = 10;
    private String pkgKey;
    boolean sampling;

    public int describeContents() {
        return 0;
    }

    public EmitterConfig(String str) {
        this.pkgKey = str;
    }

    public String getPkgKey() {
        return this.pkgKey;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isFlushOnStart() {
        return this.flushOnStart;
    }

    public boolean isFlushOnCharge() {
        return this.flushOnCharge;
    }

    public boolean isFlushOnReconnect() {
        return this.flushOnReconnect;
    }

    public long getFlushDelayInterval() {
        return this.flushDelayInterval;
    }

    public int getFlushCacheLimit() {
        return this.flushCacheLimit;
    }

    public long getFlushMobileTrafficLimit() {
        return this.flushMobileTrafficLimit;
    }

    public int getNeartimeInterval() {
        return this.neartimeInterval;
    }

    public String toString() {
        return "EmitterConfig{active=" + this.active + ", flushOnStart=" + this.flushOnStart + ", flushOnCharge=" + this.flushOnCharge + ", flushOnReconnect=" + this.flushOnReconnect + ", flushDelayInterval=" + this.flushDelayInterval + ", flushCacheLimit=" + this.flushCacheLimit + ", flushMobileTrafficLimit=" + this.flushMobileTrafficLimit + ", neartimeInterval=" + this.neartimeInterval + ", pkgKey='" + this.pkgKey + '\'' + '}';
    }

    protected EmitterConfig(Parcel parcel) {
        boolean z = true;
        this.sampling = parcel.readByte() != 0;
        this.active = parcel.readByte() != 0;
        this.flushOnStart = parcel.readByte() != 0;
        this.flushOnCharge = parcel.readByte() != 0;
        this.flushOnReconnect = parcel.readByte() == 0 ? false : z;
        this.flushDelayInterval = parcel.readLong();
        this.flushCacheLimit = parcel.readInt();
        this.flushMobileTrafficLimit = parcel.readLong();
        this.pkgKey = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.sampling ? (byte) 1 : 0);
        parcel.writeByte(this.active ? (byte) 1 : 0);
        parcel.writeByte(this.flushOnStart ? (byte) 1 : 0);
        parcel.writeByte(this.flushOnCharge ? (byte) 1 : 0);
        parcel.writeByte(this.flushOnReconnect ? (byte) 1 : 0);
        parcel.writeLong(this.flushDelayInterval);
        parcel.writeInt(this.flushCacheLimit);
        parcel.writeLong(this.flushMobileTrafficLimit);
        parcel.writeString(this.pkgKey);
    }
}
