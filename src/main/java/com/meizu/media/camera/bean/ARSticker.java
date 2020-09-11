package com.meizu.media.camera.bean;

import android.graphics.Bitmap;
import com.meizu.savior.ChangeQuickRedirect;

public class ARSticker {

    /* renamed from: a */
    private int f8184a;

    /* renamed from: b */
    private String f8185b;

    /* renamed from: c */
    private Bitmap f8186c;

    /* renamed from: d */
    private String f8187d;

    /* renamed from: e */
    private Bitmap f8188e;

    /* renamed from: f */
    private String f8189f;

    /* renamed from: g */
    private String f8190g;

    /* renamed from: h */
    private boolean f8191h;

    /* renamed from: i */
    private boolean f8192i;

    /* renamed from: j */
    private String f8193j;

    /* renamed from: k */
    private String f8194k;

    /* renamed from: l */
    private boolean f8195l;

    /* renamed from: m */
    private boolean f8196m;

    /* renamed from: n */
    private DownloadState f8197n;

    public enum DownloadState {
        NOT_DOWNLOAD,
        DOWNLOADING,
        DOWNLOADED,
        DOWNLOAD_FAILED,
        REFRESHING;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    /* renamed from: a */
    public int mo19315a() {
        return this.f8184a;
    }

    /* renamed from: a */
    public void mo19316a(int i) {
        this.f8184a = i;
    }

    /* renamed from: b */
    public String mo19321b() {
        return this.f8185b;
    }

    /* renamed from: a */
    public void mo19319a(String str) {
        this.f8185b = str;
    }

    /* renamed from: c */
    public String mo19325c() {
        return this.f8187d;
    }

    /* renamed from: b */
    public void mo19323b(String str) {
        this.f8187d = str;
    }

    /* renamed from: c */
    public void mo19326c(String str) {
        this.f8194k = str;
    }

    /* renamed from: d */
    public String mo19328d() {
        return this.f8194k;
    }

    /* renamed from: a */
    public void mo19320a(boolean z) {
        this.f8192i = z;
    }

    /* renamed from: e */
    public boolean mo19332e() {
        return this.f8192i;
    }

    /* renamed from: f */
    public String mo19333f() {
        return this.f8193j;
    }

    /* renamed from: d */
    public void mo19329d(String str) {
        this.f8193j = str;
    }

    /* renamed from: g */
    public String mo19335g() {
        return this.f8189f;
    }

    /* renamed from: e */
    public void mo19331e(String str) {
        this.f8189f = str;
    }

    /* renamed from: h */
    public Bitmap mo19336h() {
        return this.f8186c;
    }

    /* renamed from: a */
    public void mo19317a(Bitmap bitmap) {
        this.f8186c = bitmap;
    }

    /* renamed from: i */
    public Bitmap mo19337i() {
        return this.f8188e;
    }

    /* renamed from: b */
    public void mo19322b(Bitmap bitmap) {
        this.f8188e = bitmap;
    }

    /* renamed from: a */
    public void mo19318a(DownloadState downloadState) {
        this.f8197n = downloadState;
    }

    /* renamed from: j */
    public DownloadState mo19338j() {
        return this.f8197n;
    }

    /* renamed from: f */
    public void mo19334f(String str) {
        this.f8190g = str;
    }

    /* renamed from: k */
    public String mo19339k() {
        return this.f8190g;
    }

    /* renamed from: b */
    public void mo19324b(boolean z) {
        this.f8191h = z;
    }

    /* renamed from: l */
    public boolean mo19340l() {
        return this.f8191h;
    }

    /* renamed from: m */
    public boolean mo19341m() {
        return this.f8195l;
    }

    /* renamed from: c */
    public void mo19327c(boolean z) {
        this.f8195l = z;
    }

    /* renamed from: d */
    public void mo19330d(boolean z) {
        this.f8196m = z;
    }
}
