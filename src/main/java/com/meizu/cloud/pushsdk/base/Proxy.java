package com.meizu.cloud.pushsdk.base;

public class Proxy<T> {
    protected T mInnerImpl;
    protected T mOuterImpl;

    protected Proxy(T t) {
        if (t != null) {
            this.mInnerImpl = t;
            return;
        }
        throw new RuntimeException("proxy must be has a default implementation");
    }

    public void setImpl(T t) {
        this.mOuterImpl = t;
    }

    /* access modifiers changed from: protected */
    public T getImpl() {
        if (this.mOuterImpl != null) {
            return this.mOuterImpl;
        }
        return this.mInnerImpl;
    }
}
