package com.meizu.cloud.pushsdk.networking.internal;

import com.meizu.cloud.pushsdk.networking.http.MediaType;
import com.meizu.cloud.pushsdk.networking.http.RequestBody;
import com.meizu.cloud.pushsdk.networking.interfaces.UploadProgressListener;
import com.meizu.cloud.pushsdk.networking.model.Progress;
import com.meizu.cloud.pushsdk.networking.okio.Buffer;
import com.meizu.cloud.pushsdk.networking.okio.BufferedSink;
import com.meizu.cloud.pushsdk.networking.okio.ForwardingSink;
import com.meizu.cloud.pushsdk.networking.okio.Okio;
import com.meizu.cloud.pushsdk.networking.okio.Sink;
import java.io.IOException;

public class RequestProgressBody extends RequestBody {
    private BufferedSink bufferedSink;
    private final RequestBody requestBody;
    /* access modifiers changed from: private */
    public UploadProgressHandler uploadProgressHandler;

    public RequestProgressBody(RequestBody requestBody2, UploadProgressListener uploadProgressListener) {
        this.requestBody = requestBody2;
        if (uploadProgressListener != null) {
            this.uploadProgressHandler = new UploadProgressHandler(uploadProgressListener);
        }
    }

    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    public void writeTo(BufferedSink bufferedSink2) throws IOException {
        if (this.bufferedSink == null) {
            this.bufferedSink = Okio.buffer(sink(bufferedSink2));
        }
        this.requestBody.writeTo(this.bufferedSink);
        this.bufferedSink.flush();
    }

    private Sink sink(Sink sink) {
        return new ForwardingSink(sink) {
            long bytesWritten = 0;
            long contentLength = 0;

            public void write(Buffer buffer, long j) throws IOException {
                super.write(buffer, j);
                if (this.contentLength == 0) {
                    this.contentLength = RequestProgressBody.this.contentLength();
                }
                this.bytesWritten += j;
                if (RequestProgressBody.this.uploadProgressHandler != null) {
                    RequestProgressBody.this.uploadProgressHandler.obtainMessage(1, new Progress(this.bytesWritten, this.contentLength)).sendToTarget();
                }
            }
        };
    }
}
