package com.android.volley;

import android.text.TextUtils;

/* renamed from: com.android.volley.g */
public final class Header {

    /* renamed from: a */
    private final String f318a;

    /* renamed from: b */
    private final String f319b;

    public Header(String str, String str2) {
        this.f318a = str;
        this.f319b = str2;
    }

    /* renamed from: a */
    public final String mo8694a() {
        return this.f318a;
    }

    /* renamed from: b */
    public final String mo8695b() {
        return this.f319b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Header gVar = (Header) obj;
        if (!TextUtils.equals(this.f318a, gVar.f318a) || !TextUtils.equals(this.f319b, gVar.f319b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f318a.hashCode() * 31) + this.f319b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f318a + ",value=" + this.f319b + "]";
    }
}
