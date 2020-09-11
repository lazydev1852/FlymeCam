package com.iflytek.business.speech;

import android.os.Parcel;
import android.os.Parcelable;

public class VerifierResult implements Parcelable {
    public static final Parcelable.Creator<VerifierResult> CREATOR = new Parcelable.Creator<VerifierResult>() {
        /* renamed from: a */
        public VerifierResult createFromParcel(Parcel parcel) {
            return new VerifierResult(parcel);
        }

        /* renamed from: a */
        public VerifierResult[] newArray(int i) {
            return new VerifierResult[i];
        }
    };

    /* renamed from: a */
    public boolean f2454a = false;

    /* renamed from: b */
    public String f2455b = "";

    /* renamed from: c */
    public String f2456c = "";

    /* renamed from: d */
    public int f2457d = 0;

    /* renamed from: e */
    public int f2458e = 0;

    /* renamed from: f */
    public String f2459f = "";

    /* renamed from: g */
    public String f2460g = "";

    /* renamed from: h */
    private String f2461h = "";

    public int describeContents() {
        return 0;
    }

    public VerifierResult(Parcel parcel) {
        this.f2461h = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2461h);
    }
}
