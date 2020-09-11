package com.baidu.p020ar.task;

/* renamed from: com.baidu.ar.task.ActionResponseListener */
public interface ActionResponseListener<T> extends HttpResponseListener<T> {
    void onProgress(int i);

    void onUpdate(boolean z, float f);
}
