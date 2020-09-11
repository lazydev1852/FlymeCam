package com.meizu.statsrpk;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.savior.Constants;
import java.util.Map;

public class RpkEvent implements Parcelable {
    public static final Parcelable.Creator<RpkEvent> CREATOR = new Parcelable.Creator<RpkEvent>() {
        /* renamed from: a */
        public RpkEvent createFromParcel(Parcel parcel) {
            return new RpkEvent(parcel);
        }

        /* renamed from: a */
        public RpkEvent[] newArray(int i) {
            return new RpkEvent[i];
        }
    };

    /* renamed from: a */
    public String f16003a;

    /* renamed from: b */
    public String f16004b;

    /* renamed from: c */
    public String f16005c;

    /* renamed from: d */
    public Map f16006d;

    /* renamed from: e */
    public String f16007e;

    public int describeContents() {
        return 0;
    }

    public RpkEvent() {
    }

    protected RpkEvent(Parcel parcel) {
        this.f16003a = parcel.readString();
        this.f16004b = parcel.readString();
        this.f16005c = parcel.readString();
        this.f16006d = parcel.readHashMap(String.class.getClassLoader());
        this.f16007e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16003a);
        parcel.writeString(this.f16004b);
        parcel.writeString(this.f16005c);
        parcel.writeMap(this.f16006d);
        parcel.writeString(this.f16007e);
    }

    public String toString() {
        return Constants.ARRAY_TYPE + this.f16003a + SystemInfoUtil.COMMA + this.f16004b + SystemInfoUtil.COMMA + this.f16005c + SystemInfoUtil.COMMA + this.f16006d + SystemInfoUtil.COMMA + this.f16007e + "]";
    }
}
