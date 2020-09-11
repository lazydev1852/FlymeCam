package com.meizu.update.p085c;

import android.util.Pair;
import com.meizu.update.p085c.p088c.IFileChecker;
import com.meizu.update.util.Loger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.meizu.update.c.b */
public class Downloader implements IDownloader {

    /* renamed from: a */
    private String f16152a;

    /* renamed from: b */
    private String f16153b;

    /* renamed from: c */
    private List<Pair<String, String>> f16154c;

    /* renamed from: d */
    private List<Pair<String, String>> f16155d;

    /* renamed from: e */
    private boolean f16156e;

    /* renamed from: f */
    private C2981a f16157f = null;

    /* renamed from: g */
    private IFileChecker f16158g;

    /* renamed from: h */
    private long f16159h = 200;

    /* renamed from: com.meizu.update.c.b$a */
    /* compiled from: Downloader */
    public interface C2981a {
        /* renamed from: a */
        void mo24717a(int i, long j);
    }

    /* renamed from: a */
    public void mo24715a(List<Pair<String, String>> list) {
        if (this.f16155d != null) {
            for (Pair next : list) {
                Iterator<Pair<String, String>> it = this.f16155d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair next2 = it.next();
                    if (((String) next.first).equals(next2.first)) {
                        this.f16155d.remove(next2);
                        break;
                    }
                }
            }
        } else {
            this.f16155d = new ArrayList();
        }
        this.f16155d.addAll(list);
    }

    /* renamed from: a */
    public void mo24714a(String str) {
        this.f16152a = str;
    }

    /* renamed from: a */
    public void mo24713a(IFileChecker dVar) {
        this.f16158g = dVar;
    }

    public Downloader(String str, String str2, List<Pair<String, String>> list, List<Pair<String, String>> list2) {
        this.f16152a = str;
        this.f16153b = str2;
        this.f16154c = list;
        this.f16155d = list2;
        this.f16156e = false;
    }

    /* renamed from: a */
    public void mo24712a(C2981a aVar) {
        this.f16157f = aVar;
    }

    /* renamed from: a */
    public void mo24711a() {
        this.f16156e = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x025e A[Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0401 A[SYNTHETIC, Splitter:B:263:0x0401] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x040a A[Catch:{ Exception -> 0x0405 }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x040f A[Catch:{ Exception -> 0x0405 }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0414 A[Catch:{ Exception -> 0x0405 }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0425 A[SYNTHETIC, Splitter:B:277:0x0425] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x042e A[Catch:{ Exception -> 0x0429 }] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0433 A[Catch:{ Exception -> 0x0429 }] */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0438 A[Catch:{ Exception -> 0x0429 }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0273 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0156 A[Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0159 A[Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo24716a(boolean r32) throws com.meizu.update.p085c.CancelException, com.meizu.update.p085c.LoadException, com.meizu.update.p085c.RelocationException, com.meizu.update.p085c.FileIllegalException, com.meizu.update.p085c.LocalHttpException {
        /*
            r31 = this;
            r1 = r31
            r31.m17577c()
            r2 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x03f5, a -> 0x03e4, e -> 0x03db, g -> 0x03d2, c -> 0x03c9, Exception -> 0x03b4, all -> 0x03ab }
            java.lang.String r5 = r1.f16152a     // Catch:{ IOException -> 0x03f5, a -> 0x03e4, e -> 0x03db, g -> 0x03d2, c -> 0x03c9, Exception -> 0x03b4, all -> 0x03ab }
            r4.<init>(r5)     // Catch:{ IOException -> 0x03f5, a -> 0x03e4, e -> 0x03db, g -> 0x03d2, c -> 0x03c9, Exception -> 0x03b4, all -> 0x03ab }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x03f5, a -> 0x03e4, e -> 0x03db, g -> 0x03d2, c -> 0x03c9, Exception -> 0x03b4, all -> 0x03ab }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x03f5, a -> 0x03e4, e -> 0x03db, g -> 0x03d2, c -> 0x03c9, Exception -> 0x03b4, all -> 0x03ab }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x03f5, a -> 0x03e4, e -> 0x03db, g -> 0x03d2, c -> 0x03c9, Exception -> 0x03b4, all -> 0x03ab }
            java.lang.String r5 = "User-Agent"
            java.lang.String r6 = "MEIZU"
            r4.setRequestProperty(r5, r6)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r5 = 20000(0x4e20, float:2.8026E-41)
            r4.setConnectTimeout(r5)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r4.setReadTimeout(r5)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r5 = r32
            r4.setInstanceFollowRedirects(r5)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r5 = 1
            r4.setDoInput(r5)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r6 = r1.f16155d     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            if (r6 == 0) goto L_0x0057
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r6 = r1.f16155d     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            int r6 = r6.size()     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            if (r6 <= 0) goto L_0x0057
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r6 = r1.f16155d     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
        L_0x003f:
            boolean r7 = r6.hasNext()     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            if (r7 == 0) goto L_0x0057
            java.lang.Object r7 = r6.next()     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            android.util.Pair r7 = (android.util.Pair) r7     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.lang.Object r8 = r7.first     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.lang.Object r7 = r7.second     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r4.setRequestProperty(r8, r7)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            goto L_0x003f
        L_0x0057:
            java.lang.String r6 = r1.f16153b     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            long r6 = r1.m17575b(r6)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0092
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r11.<init>()     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.lang.String r12 = "Set download pos : "
            r11.append(r12)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r11.append(r6)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r1.m17579d(r11)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.lang.String r11 = "Range"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r12.<init>()     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.lang.String r13 = "bytes="
            r12.append(r13)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r12.append(r6)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.lang.String r13 = "-"
            r12.append(r13)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r4.setRequestProperty(r11, r12)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
        L_0x0092:
            java.lang.String r11 = "Start connect..."
            r1.m17580e(r11)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r11 = r1.f16154c     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            if (r11 == 0) goto L_0x00c1
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r11 = r1.f16154c     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            int r11 = r11.size()     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            if (r11 <= 0) goto L_0x00c1
            java.lang.String r11 = "POST"
            r4.setRequestMethod(r11)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r4.setUseCaches(r2)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r4.setDoOutput(r5)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.io.OutputStream r11 = r4.getOutputStream()     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r12 = r1.f16154c     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.String r13 = "UTF-8"
            byte[] r12 = com.meizu.update.util.UrlRequest.m17954a(r12, r13)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r11.write(r12)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r11.flush()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            goto L_0x00c7
        L_0x00c1:
            java.lang.String r11 = "GET"
            r4.setRequestMethod(r11)     // Catch:{ IOException -> 0x03a7, a -> 0x03a3, e -> 0x039f, g -> 0x039b, c -> 0x0397, Exception -> 0x0393, all -> 0x0390 }
            r11 = 0
        L_0x00c7:
            int r12 = r4.getResponseCode()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r13.<init>()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.String r14 = "responseCode:"
            r13.append(r14)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r13.append(r12)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r1.m17579d(r13)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.String r13 = r4.getContentType()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            int r14 = r4.getContentLength()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            long r14 = (long) r14     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r3.<init>()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.String r5 = "content length:"
            r3.append(r5)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r3.append(r14)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r1.m17580e(r3)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r3.<init>()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.String r5 = "contentType:"
            r3.append(r5)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r3.append(r13)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r1.m17580e(r3)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r3 = 200(0xc8, float:2.8E-43)
            if (r12 == r3) goto L_0x0167
            r3 = 206(0xce, float:2.89E-43)
            if (r12 == r3) goto L_0x0167
            r3 = 301(0x12d, float:4.22E-43)
            if (r12 == r3) goto L_0x0130
            r3 = 302(0x12e, float:4.23E-43)
            if (r12 != r3) goto L_0x0121
            goto L_0x0130
        L_0x0121:
            r3 = 416(0x1a0, float:5.83E-43)
            if (r12 != r3) goto L_0x014f
            java.lang.String r3 = "request over range, error!"
            r1.m17579d(r3)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.String r3 = r1.f16153b     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r1.m17578c(r3)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            goto L_0x014f
        L_0x0130:
            java.lang.String r3 = "Location"
            java.lang.String r3 = r4.getHeaderField(r3)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            if (r3 == 0) goto L_0x014a
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            if (r5 == 0) goto L_0x0144
            java.lang.String r3 = "relocate url is empty!"
            r1.m17579d(r3)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            goto L_0x014f
        L_0x0144:
            com.meizu.update.c.g r5 = new com.meizu.update.c.g     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r5.<init>(r12, r3)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            throw r5     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
        L_0x014a:
            java.lang.String r3 = "relocate no location header!"
            r1.m17579d(r3)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
        L_0x014f:
            r5 = 1048576(0x100000, double:5.180654E-318)
            int r3 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0159
            java.lang.String r3 = "Content to large to parse!"
            goto L_0x0161
        L_0x0159:
            java.lang.Object r3 = r4.getContent()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
        L_0x0161:
            com.meizu.update.c.e r5 = new com.meizu.update.c.e     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            r5.<init>(r12, r3)     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            throw r5     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
        L_0x0167:
            java.io.InputStream r3 = r4.getInputStream()     // Catch:{ IOException -> 0x038b, a -> 0x0386, e -> 0x0381, g -> 0x037c, c -> 0x0377, Exception -> 0x0372, all -> 0x036e }
            int r5 = r4.getContentLength()     // Catch:{ IOException -> 0x0368, a -> 0x035f, e -> 0x0356, g -> 0x034d, c -> 0x0344, Exception -> 0x033b, all -> 0x0332 }
            long r13 = (long) r5     // Catch:{ IOException -> 0x0368, a -> 0x035f, e -> 0x0356, g -> 0x034d, c -> 0x0344, Exception -> 0x033b, all -> 0x0332 }
            com.meizu.update.c.c.d r5 = r1.f16158g     // Catch:{ IOException -> 0x0368, a -> 0x035f, e -> 0x0356, g -> 0x034d, c -> 0x0344, Exception -> 0x033b, all -> 0x0332 }
            if (r5 == 0) goto L_0x01c0
            com.meizu.update.c.c.d r5 = r1.f16158g     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
            com.meizu.update.c.c.c r5 = r5.mo24726a(r6, r13)     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
            boolean r15 = r5.mo24742b()     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
            if (r15 != 0) goto L_0x01c0
            if (r10 <= 0) goto L_0x018f
            java.lang.String r5 = r1.f16153b     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
            r1.m17578c(r5)     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
            com.meizu.update.c.f r5 = new com.meizu.update.c.f     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
            java.lang.String r6 = "Break point download size not match."
            r5.<init>(r6)     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
            throw r5     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
        L_0x018f:
            com.meizu.update.c.c r6 = new com.meizu.update.c.c     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
            java.lang.String r5 = r5.mo24743c()     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
            r6.<init>(r12, r5)     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
            throw r6     // Catch:{ IOException -> 0x01bd, a -> 0x01b7, e -> 0x01b1, g -> 0x01ab, c -> 0x01a5, Exception -> 0x019f, all -> 0x0199 }
        L_0x0199:
            r0 = move-exception
            r2 = r0
            r16 = r3
            goto L_0x0338
        L_0x019f:
            r0 = move-exception
            r2 = r0
            r21 = r3
            goto L_0x033f
        L_0x01a5:
            r0 = move-exception
            r2 = r0
            r21 = r3
            goto L_0x0348
        L_0x01ab:
            r0 = move-exception
            r2 = r0
            r21 = r3
            goto L_0x0351
        L_0x01b1:
            r0 = move-exception
            r2 = r0
            r21 = r3
            goto L_0x035a
        L_0x01b7:
            r0 = move-exception
            r2 = r0
            r21 = r3
            goto L_0x0363
        L_0x01bd:
            r0 = move-exception
            goto L_0x036b
        L_0x01c0:
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0368, a -> 0x035f, e -> 0x0356, g -> 0x034d, c -> 0x0344, Exception -> 0x033b, all -> 0x0332 }
            java.io.FileOutputStream r15 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0368, a -> 0x035f, e -> 0x0356, g -> 0x034d, c -> 0x0344, Exception -> 0x033b, all -> 0x0332 }
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x0368, a -> 0x035f, e -> 0x0356, g -> 0x034d, c -> 0x0344, Exception -> 0x033b, all -> 0x0332 }
            java.lang.String r9 = r1.f16153b     // Catch:{ IOException -> 0x0368, a -> 0x035f, e -> 0x0356, g -> 0x034d, c -> 0x0344, Exception -> 0x033b, all -> 0x0332 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x0368, a -> 0x035f, e -> 0x0356, g -> 0x034d, c -> 0x0344, Exception -> 0x033b, all -> 0x0332 }
            if (r10 <= 0) goto L_0x01d1
            r9 = 1
            goto L_0x01d2
        L_0x01d1:
            r9 = 0
        L_0x01d2:
            r15.<init>(r8, r9)     // Catch:{ IOException -> 0x0368, a -> 0x035f, e -> 0x0356, g -> 0x034d, c -> 0x0344, Exception -> 0x033b, all -> 0x0332 }
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x032a, a -> 0x0321, e -> 0x0318, g -> 0x030f, c -> 0x0306, Exception -> 0x02fd, all -> 0x02f7 }
            r17 = 0
            r19 = 0
        L_0x01dd:
            r31.m17576b()     // Catch:{ IOException -> 0x032a, a -> 0x0321, e -> 0x0318, g -> 0x030f, c -> 0x0306, Exception -> 0x02fd, all -> 0x02f7 }
            int r10 = r3.read(r5)     // Catch:{ IOException -> 0x032a, a -> 0x0321, e -> 0x0318, g -> 0x030f, c -> 0x0306, Exception -> 0x02fd, all -> 0x02f7 }
            if (r10 <= 0) goto L_0x0253
            r15.write(r5, r2, r10)     // Catch:{ IOException -> 0x032a, a -> 0x0321, e -> 0x0318, g -> 0x030f, c -> 0x0306, Exception -> 0x02fd, all -> 0x02f7 }
            r15.flush()     // Catch:{ IOException -> 0x032a, a -> 0x0321, e -> 0x0318, g -> 0x030f, c -> 0x0306, Exception -> 0x02fd, all -> 0x02f7 }
            r21 = r3
            long r2 = (long) r10
            long r17 = r17 + r2
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r16 = 0
            long r2 = r2 - r8
            r22 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r22
            r22 = 1
            int r16 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r16 >= 0) goto L_0x0204
            r2 = r22
        L_0x0204:
            long r2 = r17 / r2
            r16 = 0
            long r22 = r17 + r6
            r24 = 100
            long r22 = r22 * r24
            long r24 = r13 + r6
            r28 = r5
            r26 = r6
            long r5 = r22 / r24
            int r5 = (int) r5     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r16 = 0
            long r22 = r6 - r19
            r29 = r6
            long r6 = r1.f16159h     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            int r6 = (r22 > r6 ? 1 : (r22 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x022b
            r6 = 100
            if (r5 != r6) goto L_0x0259
        L_0x022b:
            com.meizu.update.c.b$a r6 = r1.f16157f     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            if (r6 == 0) goto L_0x0234
            com.meizu.update.c.b$a r6 = r1.f16157f     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r6.mo24717a(r5, r2)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
        L_0x0234:
            r2 = r17
            r19 = r29
            goto L_0x025b
        L_0x0239:
            r0 = move-exception
            goto L_0x02fa
        L_0x023c:
            r0 = move-exception
            goto L_0x0300
        L_0x023f:
            r0 = move-exception
            goto L_0x0309
        L_0x0242:
            r0 = move-exception
            goto L_0x0312
        L_0x0245:
            r0 = move-exception
            goto L_0x031b
        L_0x0248:
            r0 = move-exception
            goto L_0x0324
        L_0x024b:
            r0 = move-exception
            r2 = r0
            r16 = r15
            r3 = r21
            goto L_0x03fc
        L_0x0253:
            r21 = r3
            r28 = r5
            r26 = r6
        L_0x0259:
            r2 = r17
        L_0x025b:
            r5 = -1
            if (r10 == r5) goto L_0x0273
            r5 = 0
            int r7 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0268
            int r7 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r7 >= 0) goto L_0x0275
        L_0x0268:
            r17 = r2
            r3 = r21
            r6 = r26
            r5 = r28
            r2 = 0
            goto L_0x01dd
        L_0x0273:
            r5 = 0
        L_0x0275:
            int r5 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x02b9
            int r5 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r5 < 0) goto L_0x027e
            goto L_0x02b9
        L_0x027e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r5.<init>()     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            java.lang.String r6 = "Download length not math: download length = "
            r5.append(r6)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r5.append(r2)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            java.lang.String r6 = " , in stream length = "
            r5.append(r6)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r5.append(r13)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r1.m17579d(r5)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            com.meizu.update.c.f r5 = new com.meizu.update.c.f     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r6.<init>()     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            java.lang.String r7 = "Download length not math: download length = "
            r6.append(r7)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r6.append(r2)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            java.lang.String r2 = " , in stream length = "
            r6.append(r2)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r6.append(r13)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            java.lang.String r2 = r6.toString()     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r5.<init>(r2)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            throw r5     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
        L_0x02b9:
            com.meizu.update.c.c.d r2 = r1.f16158g     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            if (r2 == 0) goto L_0x02db
            com.meizu.update.c.c.d r2 = r1.f16158g     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            java.lang.String r3 = r1.f16153b     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            com.meizu.update.c.c.c r2 = r2.mo24727a((java.lang.String) r3)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            boolean r3 = r2.mo24742b()     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            if (r3 == 0) goto L_0x02cc
            goto L_0x02db
        L_0x02cc:
            java.lang.String r3 = r1.f16153b     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r1.m17578c(r3)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            com.meizu.update.c.c r3 = new com.meizu.update.c.c     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            java.lang.String r2 = r2.mo24743c()     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            r3.<init>(r12, r2)     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
            throw r3     // Catch:{ IOException -> 0x024b, a -> 0x0248, e -> 0x0245, g -> 0x0242, c -> 0x023f, Exception -> 0x023c, all -> 0x0239 }
        L_0x02db:
            if (r21 == 0) goto L_0x02e4
            r21.close()     // Catch:{ Exception -> 0x02e1 }
            goto L_0x02e4
        L_0x02e1:
            r0 = move-exception
            r2 = r0
            goto L_0x02f2
        L_0x02e4:
            r15.close()     // Catch:{ Exception -> 0x02e1 }
            if (r11 == 0) goto L_0x02ec
            r11.close()     // Catch:{ Exception -> 0x02e1 }
        L_0x02ec:
            if (r4 == 0) goto L_0x02f5
            r4.disconnect()     // Catch:{ Exception -> 0x02e1 }
            goto L_0x02f5
        L_0x02f2:
            r2.printStackTrace()
        L_0x02f5:
            r2 = 1
            return r2
        L_0x02f7:
            r0 = move-exception
            r21 = r3
        L_0x02fa:
            r2 = r0
            goto L_0x03f2
        L_0x02fd:
            r0 = move-exception
            r21 = r3
        L_0x0300:
            r2 = r0
            r3 = r4
            r16 = r15
            goto L_0x03bc
        L_0x0306:
            r0 = move-exception
            r21 = r3
        L_0x0309:
            r2 = r0
            r3 = r4
            r16 = r15
            goto L_0x03d1
        L_0x030f:
            r0 = move-exception
            r21 = r3
        L_0x0312:
            r2 = r0
            r3 = r4
            r16 = r15
            goto L_0x03da
        L_0x0318:
            r0 = move-exception
            r21 = r3
        L_0x031b:
            r2 = r0
            r3 = r4
            r16 = r15
            goto L_0x03e3
        L_0x0321:
            r0 = move-exception
            r21 = r3
        L_0x0324:
            r2 = r0
            r3 = r4
            r16 = r15
            goto L_0x03ec
        L_0x032a:
            r0 = move-exception
            r21 = r3
            r2 = r0
            r16 = r15
            goto L_0x03fc
        L_0x0332:
            r0 = move-exception
            r21 = r3
            r2 = r0
            r16 = r21
        L_0x0338:
            r15 = 0
            goto L_0x0423
        L_0x033b:
            r0 = move-exception
            r21 = r3
            r2 = r0
        L_0x033f:
            r3 = r4
            r16 = 0
            goto L_0x03bc
        L_0x0344:
            r0 = move-exception
            r21 = r3
            r2 = r0
        L_0x0348:
            r3 = r4
            r16 = 0
            goto L_0x03d1
        L_0x034d:
            r0 = move-exception
            r21 = r3
            r2 = r0
        L_0x0351:
            r3 = r4
            r16 = 0
            goto L_0x03da
        L_0x0356:
            r0 = move-exception
            r21 = r3
            r2 = r0
        L_0x035a:
            r3 = r4
            r16 = 0
            goto L_0x03e3
        L_0x035f:
            r0 = move-exception
            r21 = r3
            r2 = r0
        L_0x0363:
            r3 = r4
            r16 = 0
            goto L_0x03ec
        L_0x0368:
            r0 = move-exception
            r21 = r3
        L_0x036b:
            r2 = r0
            goto L_0x03fa
        L_0x036e:
            r0 = move-exception
            r2 = r0
            goto L_0x03af
        L_0x0372:
            r0 = move-exception
            r2 = r0
            r3 = r4
            goto L_0x03b8
        L_0x0377:
            r0 = move-exception
            r2 = r0
            r3 = r4
            goto L_0x03cd
        L_0x037c:
            r0 = move-exception
            r2 = r0
            r3 = r4
            goto L_0x03d6
        L_0x0381:
            r0 = move-exception
            r2 = r0
            r3 = r4
            goto L_0x03df
        L_0x0386:
            r0 = move-exception
            r2 = r0
            r3 = r4
            goto L_0x03e8
        L_0x038b:
            r0 = move-exception
            r2 = r0
            r3 = 0
            goto L_0x03fa
        L_0x0390:
            r0 = move-exception
            r2 = r0
            goto L_0x03ae
        L_0x0393:
            r0 = move-exception
            r2 = r0
            r3 = r4
            goto L_0x03b7
        L_0x0397:
            r0 = move-exception
            r2 = r0
            r3 = r4
            goto L_0x03cc
        L_0x039b:
            r0 = move-exception
            r2 = r0
            r3 = r4
            goto L_0x03d5
        L_0x039f:
            r0 = move-exception
            r2 = r0
            r3 = r4
            goto L_0x03de
        L_0x03a3:
            r0 = move-exception
            r2 = r0
            r3 = r4
            goto L_0x03e7
        L_0x03a7:
            r0 = move-exception
            r2 = r0
            r3 = 0
            goto L_0x03f9
        L_0x03ab:
            r0 = move-exception
            r2 = r0
            r4 = 0
        L_0x03ae:
            r11 = 0
        L_0x03af:
            r15 = 0
            r16 = 0
            goto L_0x0423
        L_0x03b4:
            r0 = move-exception
            r2 = r0
            r3 = 0
        L_0x03b7:
            r11 = 0
        L_0x03b8:
            r16 = 0
            r21 = 0
        L_0x03bc:
            r2.printStackTrace()     // Catch:{ all -> 0x03ed }
            com.meizu.update.c.f r4 = new com.meizu.update.c.f     // Catch:{ all -> 0x03ed }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x03ed }
            r4.<init>(r2)     // Catch:{ all -> 0x03ed }
            throw r4     // Catch:{ all -> 0x03ed }
        L_0x03c9:
            r0 = move-exception
            r2 = r0
            r3 = 0
        L_0x03cc:
            r11 = 0
        L_0x03cd:
            r16 = 0
            r21 = 0
        L_0x03d1:
            throw r2     // Catch:{ all -> 0x03ed }
        L_0x03d2:
            r0 = move-exception
            r2 = r0
            r3 = 0
        L_0x03d5:
            r11 = 0
        L_0x03d6:
            r16 = 0
            r21 = 0
        L_0x03da:
            throw r2     // Catch:{ all -> 0x03ed }
        L_0x03db:
            r0 = move-exception
            r2 = r0
            r3 = 0
        L_0x03de:
            r11 = 0
        L_0x03df:
            r16 = 0
            r21 = 0
        L_0x03e3:
            throw r2     // Catch:{ all -> 0x03ed }
        L_0x03e4:
            r0 = move-exception
            r2 = r0
            r3 = 0
        L_0x03e7:
            r11 = 0
        L_0x03e8:
            r16 = 0
            r21 = 0
        L_0x03ec:
            throw r2     // Catch:{ all -> 0x03ed }
        L_0x03ed:
            r0 = move-exception
            r2 = r0
            r4 = r3
            r15 = r16
        L_0x03f2:
            r16 = r21
            goto L_0x0423
        L_0x03f5:
            r0 = move-exception
            r2 = r0
            r3 = 0
            r4 = 0
        L_0x03f9:
            r11 = 0
        L_0x03fa:
            r16 = 0
        L_0x03fc:
            r2.printStackTrace()     // Catch:{ all -> 0x041d }
            if (r3 == 0) goto L_0x0408
            r3.close()     // Catch:{ Exception -> 0x0405 }
            goto L_0x0408
        L_0x0405:
            r0 = move-exception
            r2 = r0
            goto L_0x0418
        L_0x0408:
            if (r16 == 0) goto L_0x040d
            r16.close()     // Catch:{ Exception -> 0x0405 }
        L_0x040d:
            if (r11 == 0) goto L_0x0412
            r11.close()     // Catch:{ Exception -> 0x0405 }
        L_0x0412:
            if (r4 == 0) goto L_0x041b
            r4.disconnect()     // Catch:{ Exception -> 0x0405 }
            goto L_0x041b
        L_0x0418:
            r2.printStackTrace()
        L_0x041b:
            r2 = 0
            return r2
        L_0x041d:
            r0 = move-exception
            r2 = r0
            r15 = r16
            r16 = r3
        L_0x0423:
            if (r16 == 0) goto L_0x042c
            r16.close()     // Catch:{ Exception -> 0x0429 }
            goto L_0x042c
        L_0x0429:
            r0 = move-exception
            r3 = r0
            goto L_0x043c
        L_0x042c:
            if (r15 == 0) goto L_0x0431
            r15.close()     // Catch:{ Exception -> 0x0429 }
        L_0x0431:
            if (r11 == 0) goto L_0x0436
            r11.close()     // Catch:{ Exception -> 0x0429 }
        L_0x0436:
            if (r4 == 0) goto L_0x043f
            r4.disconnect()     // Catch:{ Exception -> 0x0429 }
            goto L_0x043f
        L_0x043c:
            r3.printStackTrace()
        L_0x043f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.p085c.Downloader.mo24716a(boolean):boolean");
    }

    /* renamed from: b */
    private void m17576b() throws CancelException {
        if (this.f16156e) {
            throw new CancelException();
        }
    }

    /* renamed from: c */
    private void m17577c() {
        File file = new File(this.f16153b);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
    }

    /* renamed from: b */
    private long m17575b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return 0;
    }

    /* renamed from: c */
    private void m17578c(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: d */
    private void m17579d(String str) {
        Loger.m17943d(str);
    }

    /* renamed from: e */
    private void m17580e(String str) {
        Loger.m17942c(str);
    }
}
