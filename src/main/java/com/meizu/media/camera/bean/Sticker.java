package com.meizu.media.camera.bean;

import android.graphics.Bitmap;
import com.meizu.savior.ChangeQuickRedirect;

public class Sticker {

    /* renamed from: a */
    private int f8198a;

    /* renamed from: b */
    private String f8199b;

    /* renamed from: c */
    private Bitmap f8200c;

    /* renamed from: d */
    private String f8201d;

    /* renamed from: e */
    private int f8202e;

    /* renamed from: f */
    private boolean f8203f;

    /* renamed from: g */
    private boolean f8204g;

    /* renamed from: h */
    private String f8205h;

    /* renamed from: i */
    private DownloadState f8206i;

    public enum DownloadState {
        NOT_DOWNLOAD,
        DOWNLOADING,
        DOWNLOADED,
        DOWNLOAD_FAILED,
        REFRESHING;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    /* renamed from: a */
    public int mo19342a() {
        return this.f8198a;
    }

    /* renamed from: a */
    public void mo19343a(int i) {
        this.f8198a = i;
    }

    /* renamed from: b */
    public String mo19348b() {
        return this.f8199b;
    }

    /* renamed from: a */
    public void mo19346a(String str) {
        this.f8199b = str;
    }

    /* renamed from: c */
    public String mo19352c() {
        return this.f8201d;
    }

    /* renamed from: b */
    public void mo19350b(String str) {
        this.f8201d = str;
    }

    /* renamed from: d */
    public int mo19354d() {
        return this.f8202e;
    }

    /* renamed from: b */
    public void mo19349b(int i) {
        this.f8202e = i;
    }

    /* renamed from: e */
    public boolean mo19355e() {
        return this.f8203f;
    }

    /* renamed from: a */
    public void mo19347a(boolean z) {
        this.f8203f = z;
    }

    /* renamed from: f */
    public String mo19356f() {
        return this.f8205h;
    }

    /* renamed from: b */
    public void mo19351b(boolean z) {
        this.f8204g = z;
    }

    /* renamed from: g */
    public boolean mo19357g() {
        return this.f8204g;
    }

    /* renamed from: c */
    public void mo19353c(String str) {
        this.f8205h = str;
    }

    /* renamed from: h */
    public Bitmap mo19358h() {
        return this.f8200c;
    }

    /* renamed from: a */
    public void mo19344a(Bitmap bitmap) {
        this.f8200c = bitmap;
    }

    /* renamed from: a */
    public void mo19345a(DownloadState downloadState) {
        this.f8206i = downloadState;
    }

    /* renamed from: i */
    public DownloadState mo19359i() {
        return this.f8206i;
    }
}
