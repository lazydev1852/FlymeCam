package com.loc;

/* renamed from: com.loc.cx */
public final class AMapCoreException extends Exception {

    /* renamed from: a */
    private String f3172a;

    /* renamed from: b */
    private String f3173b;

    /* renamed from: c */
    private String f3174c;

    /* renamed from: d */
    private String f3175d;

    /* renamed from: e */
    private int f3176e;

    public AMapCoreException(String str) {
        super(str);
        this.f3172a = "未知的错误";
        this.f3173b = "";
        this.f3174c = "1900";
        this.f3175d = "UnknownError";
        this.f3176e = -1;
        this.f3172a = str;
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f3176e = 21;
            this.f3174c = "1902";
            this.f3175d = "IOException";
        } else if ("socket 连接异常 - SocketException".equals(str)) {
            this.f3176e = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f3176e = 23;
            this.f3174c = "1802";
            this.f3175d = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f3176e = 24;
            this.f3174c = "1901";
            this.f3175d = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f3176e = 25;
            this.f3174c = "1903";
            this.f3175d = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f3176e = 26;
            this.f3174c = "1803";
            this.f3175d = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f3176e = 27;
            this.f3174c = "1804";
            this.f3175d = "UnknownHostException";
        } else if ("服务器连接失败 - UnknownServiceException".equals(str)) {
            this.f3176e = 28;
            this.f3174c = "1805";
            this.f3175d = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f3176e = 29;
            this.f3174c = "1801";
            this.f3175d = "ProtocolException";
        } else if ("http连接失败 - ConnectionException".equals(str)) {
            this.f3176e = 30;
            this.f3174c = "1806";
            this.f3175d = "ConnectionException";
        } else if ("未知的错误".equals(str)) {
            this.f3176e = 31;
        } else if ("key鉴权失败".equals(str)) {
            this.f3176e = 32;
        } else if ("requeust is null".equals(str)) {
            this.f3176e = 1;
        } else if ("request url is empty".equals(str)) {
            this.f3176e = 2;
        } else if ("response is null".equals(str)) {
            this.f3176e = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f3176e = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f3176e = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f3176e = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f3176e = 7;
        } else if ("线程池为空".equals(str)) {
            this.f3176e = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f3176e = 101;
        } else {
            this.f3176e = -1;
        }
    }

    public AMapCoreException(String str, String str2) {
        this(str);
        this.f3173b = str2;
    }

    /* renamed from: a */
    public final String mo13248a() {
        return this.f3172a;
    }

    /* renamed from: a */
    public final void mo13249a(int i) {
        this.f3176e = i;
    }

    /* renamed from: b */
    public final String mo13250b() {
        return this.f3174c;
    }

    /* renamed from: c */
    public final String mo13251c() {
        return this.f3175d;
    }

    /* renamed from: d */
    public final String mo13252d() {
        return this.f3173b;
    }

    /* renamed from: e */
    public final int mo13253e() {
        return this.f3176e;
    }
}
