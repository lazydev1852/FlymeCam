package com.baidu.p020ar.recg.fea;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.baidu.ar.recg.fea.FeatureResource */
public class FeatureResource implements Parcelable {
    public static final Parcelable.Creator<FeatureResource> CREATOR = new Parcelable.Creator<FeatureResource>() {
        /* renamed from: a */
        public FeatureResource createFromParcel(Parcel parcel) {
            FeatureResource featureResource = new FeatureResource();
            String unused = featureResource.f1978a = (String) parcel.readValue(String.class.getClassLoader());
            String unused2 = featureResource.f1979b = (String) parcel.readValue(String.class.getClassLoader());
            String unused3 = featureResource.f1980c = (String) parcel.readValue(String.class.getClassLoader());
            String unused4 = featureResource.f1981d = (String) parcel.readValue(String.class.getClassLoader());
            String unused5 = featureResource.f1982e = (String) parcel.readValue(String.class.getClassLoader());
            String unused6 = featureResource.f1983f = (String) parcel.readValue(String.class.getClassLoader());
            String unused7 = featureResource.f1984g = (String) parcel.readValue(String.class.getClassLoader());
            String unused8 = featureResource.f1985h = (String) parcel.readValue(String.class.getClassLoader());
            String unused9 = featureResource.f1986i = (String) parcel.readValue(String.class.getClassLoader());
            String unused10 = featureResource.f1987j = (String) parcel.readValue(String.class.getClassLoader());
            String unused11 = featureResource.f1988k = (String) parcel.readValue(String.class.getClassLoader());
            String unused12 = featureResource.f1989l = (String) parcel.readValue(String.class.getClassLoader());
            String unused13 = featureResource.f1990m = (String) parcel.readValue(String.class.getClassLoader());
            String unused14 = featureResource.f1991n = (String) parcel.readValue(String.class.getClassLoader());
            String unused15 = featureResource.f1992o = (String) parcel.readValue(String.class.getClassLoader());
            return featureResource;
        }

        /* renamed from: a */
        public FeatureResource[] newArray(int i) {
            return new FeatureResource[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f1978a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f1979b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f1980c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f1981d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f1982e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f1983f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f1984g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f1985h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f1986i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f1987j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f1988k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f1989l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f1990m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f1991n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f1992o;

    /* renamed from: a */
    public String mo10347a() {
        return this.f1978a;
    }

    /* renamed from: a */
    public void mo10348a(String str) {
        this.f1978a = str;
    }

    /* renamed from: b */
    public String mo10349b() {
        return this.f1979b;
    }

    /* renamed from: b */
    public void mo10350b(String str) {
        this.f1979b = str;
    }

    /* renamed from: c */
    public String mo10351c() {
        return this.f1980c;
    }

    /* renamed from: c */
    public void mo10352c(String str) {
        this.f1980c = str;
    }

    /* renamed from: d */
    public void mo10353d(String str) {
        this.f1981d = str;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void mo10355e(String str) {
        this.f1982e = str;
    }

    /* renamed from: f */
    public void mo10356f(String str) {
        this.f1983f = str;
    }

    /* renamed from: g */
    public void mo10357g(String str) {
        this.f1984g = str;
    }

    /* renamed from: h */
    public void mo10358h(String str) {
        this.f1985h = str;
    }

    /* renamed from: i */
    public void mo10359i(String str) {
        this.f1986i = str;
    }

    /* renamed from: j */
    public void mo10360j(String str) {
        this.f1987j = str;
    }

    /* renamed from: k */
    public void mo10361k(String str) {
        this.f1988k = str;
    }

    /* renamed from: l */
    public void mo10362l(String str) {
        this.f1989l = str;
    }

    /* renamed from: m */
    public void mo10363m(String str) {
        this.f1990m = str;
    }

    /* renamed from: n */
    public void mo10364n(String str) {
        this.f1991n = str;
    }

    /* renamed from: o */
    public void mo10365o(String str) {
        this.f1992o = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f1978a);
        parcel.writeValue(this.f1979b);
        parcel.writeValue(this.f1980c);
        parcel.writeValue(this.f1981d);
        parcel.writeValue(this.f1982e);
        parcel.writeValue(this.f1983f);
        parcel.writeValue(this.f1984g);
        parcel.writeValue(this.f1985h);
        parcel.writeValue(this.f1986i);
        parcel.writeValue(this.f1987j);
        parcel.writeValue(this.f1988k);
        parcel.writeValue(this.f1989l);
        parcel.writeValue(this.f1990m);
        parcel.writeValue(this.f1991n);
        parcel.writeValue(this.f1992o);
    }
}
