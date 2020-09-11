package com.baidu.p020ar.task;

/* renamed from: com.baidu.ar.task.HttpResponseListener */
public interface HttpResponseListener<T> {
    void onErrorResponse(String str);

    void onResponse(T t);
}
