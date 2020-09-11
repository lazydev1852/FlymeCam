package com.loc;

/* renamed from: com.loc.ak */
public final class DownloadManager {

    /* renamed from: a */
    private HttpUrlUtil f2567a;

    /* renamed from: b */
    private Request f2568b;

    /* renamed from: com.loc.ak$a */
    /* compiled from: DownloadManager */
    public interface C1050a {
        /* renamed from: a */
        void mo13006a(byte[] bArr, long j);

        /* renamed from: c */
        void mo13007c();

        /* renamed from: d */
        void mo13008d();

        /* renamed from: e */
        void mo13009e();
    }

    public DownloadManager(Request amVar) {
        this(amVar, (byte) 0);
    }

    private DownloadManager(Request amVar, byte b) {
        this(amVar, 0);
    }

    private DownloadManager(Request amVar, char c) {
        this.f2568b = amVar;
        this.f2567a = new HttpUrlUtil(this.f2568b.f2584c, this.f2568b.f2585d, amVar.f2586e == null ? null : amVar.f2586e, false);
        this.f2567a.mo13013b();
        this.f2567a.mo13011a();
    }

    /* renamed from: a */
    public final void mo13005a(C1050a aVar) {
        this.f2567a.mo13012a(this.f2568b.mo12967c(), this.f2568b.mo13025l(), this.f2568b.mo13024k(), this.f2568b.mo12965a(), this.f2568b.mo12966b(), this.f2568b.mo12997d(), aVar);
    }
}
