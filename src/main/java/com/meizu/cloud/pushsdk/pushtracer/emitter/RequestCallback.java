package com.meizu.cloud.pushsdk.pushtracer.emitter;

public interface RequestCallback {
    void isEmpty(boolean z);

    void onFailure(int i, int i2);

    void onSuccess(int i);
}
