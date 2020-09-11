package com.meizu.safe.engine.url;

/* renamed from: com.meizu.safe.engine.url.b */
public class MzUrlChkResultForShow {

    /* renamed from: a */
    public int f15648a = -1;

    /* renamed from: b */
    public String f15649b;

    /* renamed from: c */
    public String f15650c;

    /* renamed from: d */
    public String f15651d;

    /* renamed from: e */
    public volatile boolean f15652e = true;

    /* renamed from: f */
    public int f15653f = 0;

    /* renamed from: g */
    public int f15654g = 0;

    /* renamed from: h */
    public int f15655h = 0;

    public String toString() {
        return this.f15653f + "|" + this.f15654g + "|" + this.f15655h + " --> " + this.f15649b + "|" + this.f15648a + "|" + this.f15650c + "|" + this.f15651d + "|" + this.f15652e;
    }

    /* renamed from: a */
    public static MzUrlChkResultForShow m16974a(MzUrlCheckResult mzUrlCheckResult, int i, String str) {
        MzUrlChkResultForShow bVar = new MzUrlChkResultForShow();
        if (mzUrlCheckResult == null) {
            return bVar;
        }
        bVar.f15648a = -1;
        if (mzUrlCheckResult.f15641b == 3) {
            bVar.f15648a = 3;
        } else if (mzUrlCheckResult.f15641b == 2) {
            bVar.f15648a = 2;
        } else if (mzUrlCheckResult.f15641b == 0) {
            bVar.f15648a = 0;
        }
        bVar.f15650c = UrlChkUtils.m16978a(mzUrlCheckResult);
        bVar.f15651d = UrlChkUtils.m16979b(mzUrlCheckResult);
        bVar.f15649b = str;
        bVar.f15652e = mzUrlCheckResult.f15646g;
        bVar.f15653f = mzUrlCheckResult.f15641b;
        bVar.f15654g = mzUrlCheckResult.f15642c;
        bVar.f15655h = mzUrlCheckResult.f15643d;
        return bVar;
    }
}
