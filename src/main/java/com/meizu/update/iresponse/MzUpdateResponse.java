package com.meizu.update.iresponse;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.meizu.update.iresponse.IMzUpdateResponse;

public class MzUpdateResponse implements Parcelable {
    public static final Parcelable.Creator<MzUpdateResponse> CREATOR = new Parcelable.Creator<MzUpdateResponse>() {
        /* renamed from: a */
        public MzUpdateResponse createFromParcel(Parcel parcel) {
            return new MzUpdateResponse(parcel);
        }

        /* renamed from: a */
        public MzUpdateResponse[] newArray(int i) {
            return new MzUpdateResponse[i];
        }
    };

    /* renamed from: a */
    private IMzUpdateResponse f16300a;

    /* renamed from: b */
    private int f16301b = 0;

    public int describeContents() {
        return 0;
    }

    public MzUpdateResponse(IMzUpdateResponse aVar) {
        this.f16300a = aVar;
    }

    protected MzUpdateResponse(Parcel parcel) {
        this.f16300a = IMzUpdateResponse.C3024a.m17800a(parcel.readStrongBinder());
        this.f16301b = parcel.readInt();
    }

    /* renamed from: a */
    public void mo24801a(String str) {
        Bundle bundle = new Bundle();
        if (this.f16301b == 0) {
            bundle.putString("apk_path", str);
        } else {
            bundle.putString("plugin_path", str);
        }
        m17789a(0, bundle);
    }

    /* renamed from: a */
    public void mo24800a() {
        m17789a(2, (Bundle) null);
    }

    /* renamed from: b */
    public void mo24802b() {
        m17789a(1, (Bundle) null);
    }

    /* renamed from: a */
    private void m17789a(int i, Bundle bundle) {
        try {
            this.f16300a.mo24785b(i, bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void mo24803c() {
        m17788a(0);
    }

    /* renamed from: d */
    public void mo24804d() {
        m17788a(2);
    }

    /* renamed from: e */
    public void mo24806e() {
        m17788a(3);
    }

    /* renamed from: a */
    private void m17788a(int i) {
        try {
            this.f16300a.mo24784a(i, (Bundle) null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f16300a.asBinder());
        parcel.writeInt(this.f16301b);
    }
}
