package com.meizu.cloud.pushsdk.networking.internal;

import com.meizu.cloud.pushsdk.networking.common.ANLog;
import com.meizu.cloud.pushsdk.networking.common.ANRequest;
import com.meizu.cloud.pushsdk.networking.common.ANResponse;
import com.meizu.cloud.pushsdk.networking.common.Priority;
import com.meizu.cloud.pushsdk.networking.common.ResponseType;
import com.meizu.cloud.pushsdk.networking.core.Core;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import com.meizu.cloud.pushsdk.networking.http.Response;
import com.meizu.cloud.pushsdk.networking.utils.C1259Utils;
import com.meizu.cloud.pushsdk.networking.utils.SourceCloseUtil;

public class InternalRunnable implements Runnable {
    private final Priority priority;
    public final ANRequest request;
    public final int sequence;

    public InternalRunnable(ANRequest aNRequest) {
        this.request = aNRequest;
        this.sequence = aNRequest.getSequenceNumber();
        this.priority = aNRequest.getPriority();
    }

    public void run() {
        ANLog.m4846d("execution started : " + this.request.toString());
        switch (this.request.getRequestType()) {
            case 0:
                executeSimpleRequest();
                break;
            case 1:
                executeDownloadRequest();
                break;
            case 2:
                executeUploadRequest();
                break;
        }
        ANLog.m4846d("execution done : " + this.request.toString());
    }

    private void executeSimpleRequest() {
        Response response;
        Exception e;
        try {
            response = InternalNetworking.performSimpleRequest(this.request);
            if (response == null) {
                try {
                    deliverError(this.request, C1259Utils.getErrorForConnection(new ANError()));
                    SourceCloseUtil.close(response, this.request);
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (this.request.getResponseAs() == ResponseType.OK_HTTP_RESPONSE) {
                this.request.deliverOkHttpResponse(response);
                SourceCloseUtil.close(response, this.request);
            } else if (response.code() >= 400) {
                deliverError(this.request, C1259Utils.getErrorForServerResponse(new ANError(response), this.request, response.code()));
                SourceCloseUtil.close(response, this.request);
            } else {
                ANResponse parseResponse = this.request.parseResponse(response);
                if (!parseResponse.isSuccess()) {
                    deliverError(this.request, parseResponse.getError());
                    SourceCloseUtil.close(response, this.request);
                    return;
                }
                parseResponse.setOkHttpResponse(response);
                this.request.deliverResponse(parseResponse);
                SourceCloseUtil.close(response, this.request);
            }
        } catch (Exception e3) {
            Exception exc = e3;
            response = null;
            e = exc;
            try {
                deliverError(this.request, C1259Utils.getErrorForConnection(new ANError((Throwable) e)));
                SourceCloseUtil.close(response, this.request);
            } catch (Throwable th) {
                th = th;
                SourceCloseUtil.close(response, this.request);
                throw th;
            }
        } catch (Throwable th2) {
            Throwable th3 = th2;
            response = null;
            th = th3;
            SourceCloseUtil.close(response, this.request);
            throw th;
        }
    }

    private void executeDownloadRequest() {
        try {
            Response performDownloadRequest = InternalNetworking.performDownloadRequest(this.request);
            if (performDownloadRequest == null) {
                deliverError(this.request, C1259Utils.getErrorForConnection(new ANError()));
            } else if (performDownloadRequest.code() >= 400) {
                deliverError(this.request, C1259Utils.getErrorForServerResponse(new ANError(performDownloadRequest), this.request, performDownloadRequest.code()));
            } else {
                this.request.updateDownloadCompletion();
            }
        } catch (Exception e) {
            deliverError(this.request, C1259Utils.getErrorForConnection(new ANError((Throwable) e)));
        }
    }

    private void executeUploadRequest() {
        Response response;
        Exception e;
        try {
            response = InternalNetworking.performUploadRequest(this.request);
            if (response == null) {
                try {
                    deliverError(this.request, C1259Utils.getErrorForConnection(new ANError()));
                    SourceCloseUtil.close(response, this.request);
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (this.request.getResponseAs() == ResponseType.OK_HTTP_RESPONSE) {
                this.request.deliverOkHttpResponse(response);
                SourceCloseUtil.close(response, this.request);
            } else if (response.code() >= 400) {
                deliverError(this.request, C1259Utils.getErrorForServerResponse(new ANError(response), this.request, response.code()));
                SourceCloseUtil.close(response, this.request);
            } else {
                ANResponse parseResponse = this.request.parseResponse(response);
                if (!parseResponse.isSuccess()) {
                    deliverError(this.request, parseResponse.getError());
                    SourceCloseUtil.close(response, this.request);
                    return;
                }
                parseResponse.setOkHttpResponse(response);
                this.request.deliverResponse(parseResponse);
                SourceCloseUtil.close(response, this.request);
            }
        } catch (Exception e3) {
            Exception exc = e3;
            response = null;
            e = exc;
            try {
                deliverError(this.request, C1259Utils.getErrorForConnection(new ANError((Throwable) e)));
                SourceCloseUtil.close(response, this.request);
            } catch (Throwable th) {
                th = th;
                SourceCloseUtil.close(response, this.request);
                throw th;
            }
        } catch (Throwable th2) {
            Throwable th3 = th2;
            response = null;
            th = th3;
            SourceCloseUtil.close(response, this.request);
            throw th;
        }
    }

    public Priority getPriority() {
        return this.priority;
    }

    private void deliverError(final ANRequest aNRequest, final ANError aNError) {
        Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() {
            public void run() {
                aNRequest.deliverError(aNError);
                aNRequest.finish();
            }
        });
    }
}
