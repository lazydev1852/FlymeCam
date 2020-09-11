package com.meizu.cloud.pushsdk.base;

public interface ICacheLog {
    /* renamed from: d */
    void mo14451d(String str, String str2);

    /* renamed from: e */
    void mo14452e(String str, String str2);

    /* renamed from: e */
    void mo14453e(String str, String str2, Throwable th);

    void flush(boolean z);

    /* renamed from: i */
    void mo14455i(String str, String str2);

    boolean isDebugMode();

    void setCacheCount(int i);

    void setCacheDuration(long j);

    void setDebugMode(boolean z);

    void setFilePath(String str);

    /* renamed from: w */
    void mo14461w(String str, String str2);
}
