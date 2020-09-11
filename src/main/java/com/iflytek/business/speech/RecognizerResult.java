package com.iflytek.business.speech;

import android.os.Parcel;
import android.os.Parcelable;

public class RecognizerResult implements Parcelable {
    public static final Parcelable.Creator<RecognizerResult> CREATOR = new Parcelable.Creator<RecognizerResult>() {
        /* renamed from: a */
        public RecognizerResult createFromParcel(Parcel parcel) {
            return new RecognizerResult(parcel);
        }

        /* renamed from: a */
        public RecognizerResult[] newArray(int i) {
            return new RecognizerResult[i];
        }
    };

    /* renamed from: a */
    public final String f2447a;

    /* renamed from: b */
    public final int f2448b;

    /* renamed from: c */
    public final int f2449c;

    /* renamed from: d */
    public final String f2450d;

    /* renamed from: e */
    public String f2451e;

    /* renamed from: f */
    public final String f2452f;

    public int describeContents() {
        return 0;
    }

    public RecognizerResult(Parcel parcel) {
        this.f2447a = parcel.readString();
        this.f2448b = parcel.readInt();
        this.f2449c = parcel.readInt();
        this.f2450d = parcel.readString();
        this.f2451e = parcel.readString();
        this.f2452f = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2447a);
        parcel.writeInt(this.f2448b);
        parcel.writeInt(this.f2449c);
        parcel.writeString(this.f2450d);
        parcel.writeString(this.f2451e);
        parcel.writeString(this.f2452f);
    }

    public String toString() {
        return "Ver=" + this.f2447a + " Confidence=" + this.f2449c + " Engine=" + this.f2448b + " Focus=" + this.f2450d + " Content=" + this.f2451e + " XML=" + this.f2452f;
    }
}
