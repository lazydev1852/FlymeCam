package com.meizu.cloud.pushsdk.networking.internal;

import com.meizu.cloud.pushsdk.networking.common.ANRequest;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import com.meizu.cloud.pushsdk.networking.http.Headers;
import com.meizu.cloud.pushsdk.networking.http.HttpURLConnectionCall;
import com.meizu.cloud.pushsdk.networking.http.Request;
import com.meizu.cloud.pushsdk.networking.http.Response;
import com.meizu.cloud.pushsdk.networking.utils.C1259Utils;
import java.io.File;
import java.io.IOException;

public final class InternalNetworking {
    public static String sUserAgent;

    private InternalNetworking() {
    }

    public static Response performSimpleRequest(ANRequest aNRequest) throws ANError {
        try {
            Request.Builder url = new Request.Builder().url(aNRequest.getUrl());
            addHeadersToRequestBuilder(url, aNRequest);
            switch (aNRequest.getMethod()) {
                case 0:
                    url = url.get();
                    break;
                case 1:
                    url = url.post(aNRequest.getRequestBody());
                    break;
                case 2:
                    url = url.put(aNRequest.getRequestBody());
                    break;
                case 3:
                    url = url.delete(aNRequest.getRequestBody());
                    break;
                case 4:
                    url = url.head();
                    break;
                case 5:
                    url = url.patch(aNRequest.getRequestBody());
                    break;
            }
            Request build = url.build();
            aNRequest.setCall(new HttpURLConnectionCall());
            return aNRequest.getCall().execute(build);
        } catch (IOException e) {
            throw new ANError((Throwable) e);
        }
    }

    public static Response performDownloadRequest(ANRequest aNRequest) throws ANError {
        try {
            Request.Builder url = new Request.Builder().url(aNRequest.getUrl());
            addHeadersToRequestBuilder(url, aNRequest);
            Request build = url.get().build();
            aNRequest.setCall(new HttpURLConnectionCall());
            Response execute = aNRequest.getCall().execute(build);
            C1259Utils.saveFile(execute, aNRequest.getDirPath(), aNRequest.getFileName());
            return execute;
        } catch (IOException e) {
            try {
                File file = new File(aNRequest.getDirPath() + File.separator + aNRequest.getFileName());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw new ANError((Throwable) e);
        }
    }

    public static Response performUploadRequest(ANRequest aNRequest) throws ANError {
        try {
            Request.Builder url = new Request.Builder().url(aNRequest.getUrl());
            addHeadersToRequestBuilder(url, aNRequest);
            Request build = url.post(new RequestProgressBody(aNRequest.getMultiPartRequestBody(), aNRequest.getUploadProgressListener())).build();
            aNRequest.setCall(new HttpURLConnectionCall());
            return aNRequest.getCall().execute(build);
        } catch (IOException e) {
            throw new ANError((Throwable) e);
        }
    }

    public static void addHeadersToRequestBuilder(Request.Builder builder, ANRequest aNRequest) {
        if (aNRequest.getUserAgent() != null) {
            builder.addHeader("User-Agent", aNRequest.getUserAgent());
        } else if (sUserAgent != null) {
            aNRequest.setUserAgent(sUserAgent);
            builder.addHeader("User-Agent", sUserAgent);
        }
        Headers headers = aNRequest.getHeaders();
        if (headers != null) {
            builder.headers(headers);
            if (aNRequest.getUserAgent() != null && !headers.names().contains("User-Agent")) {
                builder.addHeader("User-Agent", aNRequest.getUserAgent());
            }
        }
    }

    public static void setUserAgent(String str) {
        sUserAgent = str;
    }
}
