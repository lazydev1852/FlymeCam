package com.baidu.p020ar.load.downloader;

import com.baidu.p020ar.task.ActionResponseListener;

/* renamed from: com.baidu.ar.load.downloader.a */
public class C0786a implements ActionResponseListener<String> {

    /* renamed from: a */
    DownloadController f1821a;

    C0786a(DownloadController downloadController) {
        this.f1821a = downloadController;
    }

    /* renamed from: a */
    public void onResponse(String str) {
        try {
            this.f1821a.mo10206b(str);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void onErrorResponse(String str) {
    }

    public void onProgress(int i) {
        try {
            this.f1821a.mo10197a(i);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void onUpdate(boolean z, float f) {
    }
}
