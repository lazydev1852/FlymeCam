package com.meizu.cloud.pushsdk.networking.internal;

import com.meizu.cloud.pushsdk.networking.common.ANConstants;
import com.meizu.cloud.pushsdk.networking.common.ANRequest;
import com.meizu.cloud.pushsdk.networking.common.ANResponse;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import com.meizu.cloud.pushsdk.networking.http.Response;
import com.meizu.cloud.pushsdk.networking.utils.C1259Utils;

public final class SynchronousCall {
    private SynchronousCall() {
    }

    public static <T> ANResponse<T> execute(ANRequest aNRequest) {
        switch (aNRequest.getRequestType()) {
            case 0:
                return executeSimpleRequest(aNRequest);
            case 1:
                return executeDownloadRequest(aNRequest);
            case 2:
                return executeUploadRequest(aNRequest);
            default:
                return new ANResponse<>(new ANError());
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0066=Splitter:B:30:0x0066, B:36:0x0077=Splitter:B:36:0x0077} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.meizu.cloud.pushsdk.networking.common.ANResponse<T> executeSimpleRequest(com.meizu.cloud.pushsdk.networking.common.ANRequest r5) {
        /*
            r0 = 0
            com.meizu.cloud.pushsdk.networking.http.Response r1 = com.meizu.cloud.pushsdk.networking.internal.InternalNetworking.performSimpleRequest(r5)     // Catch:{ ANError -> 0x0073, Exception -> 0x0062, all -> 0x005d }
            if (r1 != 0) goto L_0x001d
            com.meizu.cloud.pushsdk.networking.common.ANResponse r0 = new com.meizu.cloud.pushsdk.networking.common.ANResponse     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.error.ANError r2 = new com.meizu.cloud.pushsdk.networking.error.ANError     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r2.<init>()     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.error.ANError r2 = com.meizu.cloud.pushsdk.networking.utils.C1259Utils.getErrorForConnection(r2)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.<init>((com.meizu.cloud.pushsdk.networking.error.ANError) r2)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r0
        L_0x0019:
            r0 = move-exception
            goto L_0x0066
        L_0x001b:
            r0 = move-exception
            goto L_0x0077
        L_0x001d:
            com.meizu.cloud.pushsdk.networking.common.ResponseType r0 = r5.getResponseAs()     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.common.ResponseType r2 = com.meizu.cloud.pushsdk.networking.common.ResponseType.OK_HTTP_RESPONSE     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            if (r0 != r2) goto L_0x0031
            com.meizu.cloud.pushsdk.networking.common.ANResponse r0 = new com.meizu.cloud.pushsdk.networking.common.ANResponse     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.<init>(r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.setOkHttpResponse(r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r0
        L_0x0031:
            int r0 = r1.code()     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r2 = 400(0x190, float:5.6E-43)
            if (r0 < r2) goto L_0x0052
            com.meizu.cloud.pushsdk.networking.common.ANResponse r0 = new com.meizu.cloud.pushsdk.networking.common.ANResponse     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.error.ANError r2 = new com.meizu.cloud.pushsdk.networking.error.ANError     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r2.<init>((com.meizu.cloud.pushsdk.networking.http.Response) r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            int r3 = r1.code()     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.error.ANError r2 = com.meizu.cloud.pushsdk.networking.utils.C1259Utils.getErrorForServerResponse(r2, r5, r3)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.<init>((com.meizu.cloud.pushsdk.networking.error.ANError) r2)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.setOkHttpResponse(r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r0
        L_0x0052:
            com.meizu.cloud.pushsdk.networking.common.ANResponse r0 = r5.parseResponse(r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.setOkHttpResponse(r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r0
        L_0x005d:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x008a
        L_0x0062:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0066:
            com.meizu.cloud.pushsdk.networking.common.ANResponse r2 = new com.meizu.cloud.pushsdk.networking.common.ANResponse     // Catch:{ all -> 0x0089 }
            com.meizu.cloud.pushsdk.networking.error.ANError r0 = com.meizu.cloud.pushsdk.networking.utils.C1259Utils.getErrorForNetworkOnMainThreadOrConnection(r0)     // Catch:{ all -> 0x0089 }
            r2.<init>((com.meizu.cloud.pushsdk.networking.error.ANError) r0)     // Catch:{ all -> 0x0089 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r2
        L_0x0073:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0077:
            com.meizu.cloud.pushsdk.networking.common.ANResponse r2 = new com.meizu.cloud.pushsdk.networking.common.ANResponse     // Catch:{ all -> 0x0089 }
            com.meizu.cloud.pushsdk.networking.error.ANError r3 = new com.meizu.cloud.pushsdk.networking.error.ANError     // Catch:{ all -> 0x0089 }
            r3.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x0089 }
            com.meizu.cloud.pushsdk.networking.error.ANError r0 = com.meizu.cloud.pushsdk.networking.utils.C1259Utils.getErrorForConnection(r3)     // Catch:{ all -> 0x0089 }
            r2.<init>((com.meizu.cloud.pushsdk.networking.error.ANError) r0)     // Catch:{ all -> 0x0089 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r2
        L_0x0089:
            r0 = move-exception
        L_0x008a:
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.networking.internal.SynchronousCall.executeSimpleRequest(com.meizu.cloud.pushsdk.networking.common.ANRequest):com.meizu.cloud.pushsdk.networking.common.ANResponse");
    }

    private static <T> ANResponse<T> executeDownloadRequest(ANRequest aNRequest) {
        try {
            Response performDownloadRequest = InternalNetworking.performDownloadRequest(aNRequest);
            if (performDownloadRequest == null) {
                return new ANResponse<>(C1259Utils.getErrorForConnection(new ANError()));
            }
            if (performDownloadRequest.code() >= 400) {
                ANResponse<T> aNResponse = new ANResponse<>(C1259Utils.getErrorForServerResponse(new ANError(performDownloadRequest), aNRequest, performDownloadRequest.code()));
                aNResponse.setOkHttpResponse(performDownloadRequest);
                return aNResponse;
            }
            ANResponse<T> aNResponse2 = new ANResponse<>(ANConstants.SUCCESS);
            aNResponse2.setOkHttpResponse(performDownloadRequest);
            return aNResponse2;
        } catch (ANError e) {
            return new ANResponse<>(C1259Utils.getErrorForConnection(new ANError((Throwable) e)));
        } catch (Exception e2) {
            return new ANResponse<>(C1259Utils.getErrorForNetworkOnMainThreadOrConnection(e2));
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0066=Splitter:B:30:0x0066, B:36:0x0077=Splitter:B:36:0x0077} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.meizu.cloud.pushsdk.networking.common.ANResponse<T> executeUploadRequest(com.meizu.cloud.pushsdk.networking.common.ANRequest r5) {
        /*
            r0 = 0
            com.meizu.cloud.pushsdk.networking.http.Response r1 = com.meizu.cloud.pushsdk.networking.internal.InternalNetworking.performUploadRequest(r5)     // Catch:{ ANError -> 0x0073, Exception -> 0x0062, all -> 0x005d }
            if (r1 != 0) goto L_0x001d
            com.meizu.cloud.pushsdk.networking.common.ANResponse r0 = new com.meizu.cloud.pushsdk.networking.common.ANResponse     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.error.ANError r2 = new com.meizu.cloud.pushsdk.networking.error.ANError     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r2.<init>()     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.error.ANError r2 = com.meizu.cloud.pushsdk.networking.utils.C1259Utils.getErrorForConnection(r2)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.<init>((com.meizu.cloud.pushsdk.networking.error.ANError) r2)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r0
        L_0x0019:
            r0 = move-exception
            goto L_0x0066
        L_0x001b:
            r0 = move-exception
            goto L_0x0077
        L_0x001d:
            com.meizu.cloud.pushsdk.networking.common.ResponseType r0 = r5.getResponseAs()     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.common.ResponseType r2 = com.meizu.cloud.pushsdk.networking.common.ResponseType.OK_HTTP_RESPONSE     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            if (r0 != r2) goto L_0x0031
            com.meizu.cloud.pushsdk.networking.common.ANResponse r0 = new com.meizu.cloud.pushsdk.networking.common.ANResponse     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.<init>(r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.setOkHttpResponse(r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r0
        L_0x0031:
            int r0 = r1.code()     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r2 = 400(0x190, float:5.6E-43)
            if (r0 < r2) goto L_0x0052
            com.meizu.cloud.pushsdk.networking.common.ANResponse r0 = new com.meizu.cloud.pushsdk.networking.common.ANResponse     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.error.ANError r2 = new com.meizu.cloud.pushsdk.networking.error.ANError     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r2.<init>((com.meizu.cloud.pushsdk.networking.http.Response) r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            int r3 = r1.code()     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.error.ANError r2 = com.meizu.cloud.pushsdk.networking.utils.C1259Utils.getErrorForServerResponse(r2, r5, r3)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.<init>((com.meizu.cloud.pushsdk.networking.error.ANError) r2)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.setOkHttpResponse(r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r0
        L_0x0052:
            com.meizu.cloud.pushsdk.networking.common.ANResponse r0 = r5.parseResponse(r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            r0.setOkHttpResponse(r1)     // Catch:{ ANError -> 0x001b, Exception -> 0x0019 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r0
        L_0x005d:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0085
        L_0x0062:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0066:
            com.meizu.cloud.pushsdk.networking.common.ANResponse r2 = new com.meizu.cloud.pushsdk.networking.common.ANResponse     // Catch:{ all -> 0x0084 }
            com.meizu.cloud.pushsdk.networking.error.ANError r0 = com.meizu.cloud.pushsdk.networking.utils.C1259Utils.getErrorForNetworkOnMainThreadOrConnection(r0)     // Catch:{ all -> 0x0084 }
            r2.<init>((com.meizu.cloud.pushsdk.networking.error.ANError) r0)     // Catch:{ all -> 0x0084 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r2
        L_0x0073:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0077:
            com.meizu.cloud.pushsdk.networking.common.ANResponse r2 = new com.meizu.cloud.pushsdk.networking.common.ANResponse     // Catch:{ all -> 0x0084 }
            com.meizu.cloud.pushsdk.networking.error.ANError r0 = com.meizu.cloud.pushsdk.networking.utils.C1259Utils.getErrorForConnection(r0)     // Catch:{ all -> 0x0084 }
            r2.<init>((com.meizu.cloud.pushsdk.networking.error.ANError) r0)     // Catch:{ all -> 0x0084 }
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            return r2
        L_0x0084:
            r0 = move-exception
        L_0x0085:
            com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil.close(r1, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.networking.internal.SynchronousCall.executeUploadRequest(com.meizu.cloud.pushsdk.networking.common.ANRequest):com.meizu.cloud.pushsdk.networking.common.ANResponse");
    }
}
