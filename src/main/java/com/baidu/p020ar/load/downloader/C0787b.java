package com.baidu.p020ar.load.downloader;

import com.baidu.p020ar.task.ActionResponseListener;

/* renamed from: com.baidu.ar.load.downloader.b */
public class C0787b implements ActionResponseListener<String> {

    /* renamed from: a */
    DownloadController f1822a;

    C0787b(DownloadController downloadController) {
        this.f1822a = downloadController;
    }

    /* renamed from: a */
    public void onResponse(String str) {
        try {
            this.f1822a.mo10208c(str);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void onErrorResponse(String str) {
    }

    public void onProgress(int i) {
        try {
            this.f1822a.mo10204b(i);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void onUpdate(boolean z, float f) {
    }
}
