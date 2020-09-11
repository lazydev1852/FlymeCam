package com.loc;

/* renamed from: com.loc.e */
public final class HashCodeBuilder {

    /* renamed from: a */
    private final int f3341a;

    /* renamed from: b */
    private int f3342b;

    public HashCodeBuilder() {
        this.f3342b = 0;
        this.f3341a = 37;
        this.f3342b = 17;
    }

    /* renamed from: a */
    private HashCodeBuilder m3839a(long j) {
        this.f3342b = (this.f3342b * this.f3341a) + ((int) (j ^ (j >> 32)));
        return this;
    }

    /* renamed from: a */
    public final int mo13284a() {
        return this.f3342b;
    }

    /* renamed from: a */
    public final HashCodeBuilder mo13285a(Object obj) {
        if (obj != null) {
            if (obj.getClass().isArray()) {
                int i = 0;
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    if (jArr != null) {
                        while (i < jArr.length) {
                            m3839a(jArr[i]);
                            i++;
                        }
                    }
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    if (iArr != null) {
                        while (i < iArr.length) {
                            this.f3342b = (this.f3342b * this.f3341a) + iArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    if (sArr != null) {
                        while (i < sArr.length) {
                            this.f3342b = (this.f3342b * this.f3341a) + sArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    if (cArr != null) {
                        while (i < cArr.length) {
                            this.f3342b = (this.f3342b * this.f3341a) + cArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    if (bArr != null) {
                        while (i < bArr.length) {
                            this.f3342b = (this.f3342b * this.f3341a) + bArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    if (dArr != null) {
                        while (i < dArr.length) {
                            m3839a(Double.doubleToLongBits(dArr[i]));
                            i++;
                        }
                    }
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    if (fArr != null) {
                        while (i < fArr.length) {
                            this.f3342b = (this.f3342b * this.f3341a) + Float.floatToIntBits(fArr[i]);
                            i++;
                        }
                    }
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    if (zArr != null) {
                        while (i < zArr.length) {
                            this.f3342b = (this.f3342b * this.f3341a) + (zArr[i] ^ true ? 1 : 0);
                            i++;
                        }
                    }
                } else {
                    mo13286a((Object[]) obj);
                }
            } else {
                this.f3342b = (this.f3342b * this.f3341a) + obj.hashCode();
            }
            return this;
        }
        this.f3342b *= this.f3341a;
        return this;
    }

    /* renamed from: a */
    public final HashCodeBuilder mo13286a(Object[] objArr) {
        if (objArr == null) {
            this.f3342b *= this.f3341a;
        } else {
            for (Object a : objArr) {
                mo13285a(a);
            }
        }
        return this;
    }

    public final int hashCode() {
        return this.f3342b;
    }
}
