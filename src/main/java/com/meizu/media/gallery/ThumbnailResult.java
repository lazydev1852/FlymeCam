package com.meizu.media.gallery;

import android.os.Parcel;
import android.os.Parcelable;

public class ThumbnailResult implements Parcelable {
    public static final Parcelable.Creator<ThumbnailResult> CREATOR = new Parcelable.Creator<ThumbnailResult>() {
        /* renamed from: a */
        public ThumbnailResult createFromParcel(Parcel parcel) {
            return new ThumbnailResult(parcel);
        }

        /* renamed from: a */
        public ThumbnailResult[] newArray(int i) {
            return new ThumbnailResult[i];
        }
    };

    /* renamed from: a */
    private boolean f15593a;

    /* renamed from: b */
    private int f15594b;

    /* renamed from: c */
    private int f15595c;

    public int describeContents() {
        return 0;
    }

    public ThumbnailResult(Parcel parcel) {
        this.f15593a = parcel.readInt() != 1 ? false : true;
        this.f15594b = parcel.readInt();
        this.f15595c = parcel.readInt();
    }

    /* renamed from: a */
    public boolean mo23485a() {
        return this.f15593a;
    }

    /* renamed from: b */
    public int mo23486b() {
        return this.f15594b;
    }

    /* renamed from: c */
    public int mo23487c() {
        return this.f15595c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15593a ? 1 : 0);
        parcel.writeInt(this.f15594b);
        parcel.writeInt(this.f15595c);
    }

    public String toString() {
        return super.toString() + " mIsShowAnimation=" + this.f15593a + " rotation=" + this.f15594b + " mResultCode=" + this.f15595c;
    }
}
