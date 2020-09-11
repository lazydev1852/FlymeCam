package com.meizu.safe.engine.url;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.ActivityChooserView;

public class MzUrlCheckResult implements Parcelable {
    public static final Parcelable.Creator<MzUrlCheckResult> CREATOR = new Parcelable.Creator<MzUrlCheckResult>() {
        /* renamed from: a */
        public MzUrlCheckResult createFromParcel(Parcel parcel) {
            return new MzUrlCheckResult(parcel);
        }

        /* renamed from: a */
        public MzUrlCheckResult[] newArray(int i) {
            return new MzUrlCheckResult[i];
        }
    };

    /* renamed from: a */
    public String f15640a;

    /* renamed from: b */
    public int f15641b;

    /* renamed from: c */
    public int f15642c;

    /* renamed from: d */
    public int f15643d;

    /* renamed from: e */
    public volatile long f15644e;

    /* renamed from: f */
    public volatile int f15645f;

    /* renamed from: g */
    volatile boolean f15646g;

    public int describeContents() {
        return 0;
    }

    public MzUrlCheckResult() {
        this.f15640a = "";
        this.f15641b = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f15642c = 0;
        this.f15643d = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f15644e = 0;
        this.f15645f = 0;
        this.f15646g = true;
    }

    protected MzUrlCheckResult(Parcel parcel) {
        this.f15640a = "";
        this.f15641b = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f15642c = 0;
        this.f15643d = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f15644e = 0;
        this.f15645f = 0;
        boolean z = true;
        this.f15646g = true;
        this.f15640a = parcel.readString();
        this.f15641b = parcel.readInt();
        this.f15642c = parcel.readInt();
        this.f15643d = parcel.readInt();
        this.f15644e = parcel.readLong();
        this.f15645f = parcel.readInt();
        this.f15646g = parcel.readByte() == 0 ? false : z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15640a);
        parcel.writeInt(this.f15641b);
        parcel.writeInt(this.f15642c);
        parcel.writeInt(this.f15643d);
        parcel.writeLong(this.f15644e);
        parcel.writeInt(this.f15645f);
        parcel.writeByte(this.f15646g ? (byte) 1 : 0);
    }

    public String toString() {
        return this.f15640a + "|" + this.f15641b + "|" + this.f15642c + "|" + this.f15643d + "|" + this.f15644e + "|" + this.f15645f + "|" + this.f15646g + "|";
    }
}
