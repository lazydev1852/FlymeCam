package com.baidu.p020ar.load.downloader;

import com.baidu.p020ar.task.ActionResponseListener;

/* renamed from: com.baidu.ar.load.downloader.c */
public class C0788c implements ActionResponseListener<String> {

    /* renamed from: a */
    DownloadController f1823a;

    C0788c(DownloadController downloadController) {
        this.f1823a = downloadController;
    }

    /* renamed from: a */
    public void onResponse(String str) {
        try {
            this.f1823a.mo10200a(str);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void onErrorResponse(String str) {
    }

    public void onProgress(int i) {
    }

    public void onUpdate(boolean z, float f) {
    }
}
