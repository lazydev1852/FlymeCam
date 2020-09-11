package com.baidu.p020ar.recorder;

/* renamed from: com.baidu.ar.recorder.MovieRecorderCallback */
public interface MovieRecorderCallback {
    void onRecorderComplete(boolean z, String str);

    void onRecorderError(int i);

    void onRecorderProcess(int i);

    void onRecorderStart(boolean z);
}
