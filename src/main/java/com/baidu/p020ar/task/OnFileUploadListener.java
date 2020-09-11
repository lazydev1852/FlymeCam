package com.baidu.p020ar.task;

/* renamed from: com.baidu.ar.task.OnFileUploadListener */
public interface OnFileUploadListener {
    void onFailure(int i, String str);

    void onProgressUpdate(int i);

    void onStartUpload();

    void onSuccess(int i, String str);
}
