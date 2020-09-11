package com.baidu.p020ar.recg;

/* renamed from: com.baidu.ar.recg.ImageRecognitionCallback */
public interface ImageRecognitionCallback {
    void onFeatureDBInit(boolean z);

    void onFeatureDownloadStart();

    void onRecognizeResult(boolean z, String str, String str2);

    void onResourceDownload(boolean z);

    void onResourceRequest(boolean z, int i, String str);

    void onSoLoadDownloadStart();

    void onSoLoadState(boolean z);
}
