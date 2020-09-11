package com.meizu.cloud.pushsdk.networking.http;

import com.meizu.cloud.pushsdk.networking.http.Headers;
import com.meizu.cloud.pushsdk.networking.okio.Buffer;
import com.meizu.cloud.pushsdk.networking.okio.BufferedSource;
import java.io.IOException;
import java.util.List;

public class Response {
    /* access modifiers changed from: private */
    public final ResponseBody body;
    /* access modifiers changed from: private */
    public Response cacheResponse;
    /* access modifiers changed from: private */
    public final int code;
    /* access modifiers changed from: private */
    public final Headers headers;
    /* access modifiers changed from: private */
    public final String message;
    /* access modifiers changed from: private */
    public Response networkResponse;
    /* access modifiers changed from: private */
    public final Response priorResponse;
    /* access modifiers changed from: private */
    public final Request request;

    private Response(Builder builder) {
        this.request = builder.request;
        this.code = builder.code;
        this.message = builder.message;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.networkResponse = builder.networkResponse;
        this.cacheResponse = builder.cacheResponse;
        this.priorResponse = builder.priorResponse;
    }

    public Request request() {
        return this.request;
    }

    public int code() {
        return this.code;
    }

    public boolean isSuccessful() {
        return this.code >= 200 && this.code < 300;
    }

    public String message() {
        return this.message;
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    public String header(String str) {
        return header(str, (String) null);
    }

    public String header(String str, String str2) {
        String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    public Headers headers() {
        return this.headers;
    }

    public ResponseBody peekBody(long j) throws IOException {
        BufferedSource source = this.body.source();
        source.request(j);
        Buffer clone = source.buffer().clone();
        if (clone.size() > j) {
            Buffer buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
            clone = buffer;
        }
        return ResponseBody.create(this.body.contentType(), clone.size(), clone);
    }

    public ResponseBody body() {
        return this.body;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public Response networkResponse() {
        return this.networkResponse;
    }

    public Response cacheResponse() {
        return this.cacheResponse;
    }

    public Response priorResponse() {
        return this.priorResponse;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ResponseBody body;
        /* access modifiers changed from: private */
        public Response cacheResponse;
        /* access modifiers changed from: private */
        public int code;
        /* access modifiers changed from: private */
        public Headers.Builder headers;
        /* access modifiers changed from: private */
        public String message;
        /* access modifiers changed from: private */
        public Response networkResponse;
        /* access modifiers changed from: private */
        public Response priorResponse;
        /* access modifiers changed from: private */
        public Request request;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private Builder(Response response) {
            this.code = -1;
            this.request = response.request;
            this.code = response.code;
            this.message = response.message;
            this.headers = response.headers.newBuilder();
            this.body = response.body;
            this.networkResponse = response.networkResponse;
            this.cacheResponse = response.cacheResponse;
            this.priorResponse = response.priorResponse;
        }

        public Builder request(Request request2) {
            this.request = request2;
            return this;
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2.newBuilder();
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Builder networkResponse(Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public Builder cacheResponse(Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        private void checkSupportResponse(String str, Response response) {
            if (response.body != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.networkResponse != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.cacheResponse != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.priorResponse != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder priorResponse(Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        private void checkPriorResponse(Response response) {
            if (response.body != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public Response build() {
            if (this.request == null) {
                throw new IllegalStateException("request == null");
            } else if (this.code >= 0) {
                return new Response(this);
            } else {
                throw new IllegalStateException("code < 0: " + this.code);
            }
        }
    }
}
