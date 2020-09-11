package com.meizu.statsrpk;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.savior.Constants;

public class RpkInfo implements Parcelable {
    public static final Parcelable.Creator<RpkInfo> CREATOR = new Parcelable.Creator<RpkInfo>() {
        /* renamed from: a */
        public RpkInfo createFromParcel(Parcel parcel) {
            return new RpkInfo(parcel);
        }

        /* renamed from: a */
        public RpkInfo[] newArray(int i) {
            return new RpkInfo[i];
        }
    };

    /* renamed from: a */
    public String f16008a;

    /* renamed from: b */
    public String f16009b;

    /* renamed from: c */
    public int f16010c;

    /* renamed from: d */
    public String f16011d;

    /* renamed from: e */
    public String f16012e;

    public int describeContents() {
        return 0;
    }

    public RpkInfo() {
    }

    protected RpkInfo(Parcel parcel) {
        this.f16008a = parcel.readString();
        this.f16009b = parcel.readString();
        this.f16010c = parcel.readInt();
        this.f16011d = parcel.readString();
        this.f16012e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16008a);
        parcel.writeString(this.f16009b);
        parcel.writeInt(this.f16010c);
        parcel.writeString(this.f16011d);
        parcel.writeString(this.f16012e);
    }

    public String toString() {
        return Constants.ARRAY_TYPE + this.f16008a + SystemInfoUtil.COMMA + this.f16009b + SystemInfoUtil.COMMA + this.f16010c + SystemInfoUtil.COMMA + this.f16011d + SystemInfoUtil.COMMA + this.f16012e + "]";
    }
}
