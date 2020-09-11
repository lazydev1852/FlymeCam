package com.meizu.cloud.pushsdk.networking.http;

import com.meizu.cloud.pushsdk.networking.okio.BufferedSink;
import com.meizu.cloud.pushsdk.networking.okio.ByteString;
import com.meizu.cloud.pushsdk.networking.okio.Okio;
import com.meizu.cloud.pushsdk.networking.okio.Source;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class RequestBody {
    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public byte[] content() {
        return new byte[0];
    }

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() {
            public MediaType contentType() {
                return mediaType;
            }

            public long contentLength() throws IOException {
                return (long) byteString.size();
            }

            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(byteString);
            }

            public byte[] content() {
                return byteString.toByteArray();
            }
        };
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new RequestBody() {
                public MediaType contentType() {
                    return mediaType;
                }

                public long contentLength() {
                    return (long) i2;
                }

                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(bArr, i, i2);
                }

                public byte[] content() {
                    return bArr;
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                public MediaType contentType() {
                    return mediaType;
                }

                public long contentLength() {
                    return file.length();
                }

                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    Source source = null;
                    try {
                        Source source2 = Okio.source(file);
                        try {
                            bufferedSink.writeAll(source2);
                            Util.closeQuietly((Closeable) source2);
                        } catch (Throwable th) {
                            th = th;
                            source = source2;
                            Util.closeQuietly((Closeable) source);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Util.closeQuietly((Closeable) source);
                        throw th;
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
