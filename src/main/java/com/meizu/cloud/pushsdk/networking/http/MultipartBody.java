package com.meizu.cloud.pushsdk.networking.http;

import com.meizu.cloud.pushsdk.networking.okio.BufferedSink;
import com.meizu.cloud.pushsdk.networking.okio.ByteString;
import com.meizu.statsapp.p081v3.lib.plugin.net.multipart.HTTP;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final ByteString boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.boundary = byteString;
        this.originalType = mediaType;
        this.contentType = MediaType.parse(mediaType + "; boundary=" + byteString.utf8());
        this.parts = Util.immutableList(list);
    }

    public MediaType type() {
        return this.originalType;
    }

    public String boundary() {
        return this.boundary.utf8();
    }

    public int size() {
        return this.parts.size();
    }

    public List<Part> parts() {
        return this.parts;
    }

    public Part part(int i) {
        return this.parts.get(i);
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public long contentLength() throws IOException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long writeOrCountBytes = writeOrCountBytes((BufferedSink) null, true);
        this.contentLength = writeOrCountBytes;
        return writeOrCountBytes;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: com.meizu.cloud.pushsdk.networking.okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.meizu.cloud.pushsdk.networking.okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.meizu.cloud.pushsdk.networking.okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: com.meizu.cloud.pushsdk.networking.okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.meizu.cloud.pushsdk.networking.okio.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long writeOrCountBytes(com.meizu.cloud.pushsdk.networking.okio.BufferedSink r13, boolean r14) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            com.meizu.cloud.pushsdk.networking.okio.Buffer r13 = new com.meizu.cloud.pushsdk.networking.okio.Buffer
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<com.meizu.cloud.pushsdk.networking.http.MultipartBody$Part> r1 = r12.parts
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r4 = r3
            r3 = 0
        L_0x0015:
            if (r3 >= r1) goto L_0x00ab
            java.util.List<com.meizu.cloud.pushsdk.networking.http.MultipartBody$Part> r6 = r12.parts
            java.lang.Object r6 = r6.get(r3)
            com.meizu.cloud.pushsdk.networking.http.MultipartBody$Part r6 = (com.meizu.cloud.pushsdk.networking.http.MultipartBody.Part) r6
            com.meizu.cloud.pushsdk.networking.http.Headers r7 = r6.headers
            com.meizu.cloud.pushsdk.networking.http.RequestBody r6 = r6.body
            byte[] r8 = DASHDASH
            r13.write((byte[]) r8)
            com.meizu.cloud.pushsdk.networking.okio.ByteString r8 = r12.boundary
            r13.write((com.meizu.cloud.pushsdk.networking.okio.ByteString) r8)
            byte[] r8 = CRLF
            r13.write((byte[]) r8)
            if (r7 == 0) goto L_0x005d
            int r8 = r7.size()
            r9 = 0
        L_0x003d:
            if (r9 >= r8) goto L_0x005d
            java.lang.String r10 = r7.name(r9)
            com.meizu.cloud.pushsdk.networking.okio.BufferedSink r10 = r13.writeUtf8(r10)
            byte[] r11 = COLONSPACE
            com.meizu.cloud.pushsdk.networking.okio.BufferedSink r10 = r10.write((byte[]) r11)
            java.lang.String r11 = r7.value(r9)
            com.meizu.cloud.pushsdk.networking.okio.BufferedSink r10 = r10.writeUtf8(r11)
            byte[] r11 = CRLF
            r10.write((byte[]) r11)
            int r9 = r9 + 1
            goto L_0x003d
        L_0x005d:
            com.meizu.cloud.pushsdk.networking.http.MediaType r7 = r6.contentType()
            if (r7 == 0) goto L_0x0076
            java.lang.String r8 = "Content-Type: "
            com.meizu.cloud.pushsdk.networking.okio.BufferedSink r8 = r13.writeUtf8(r8)
            java.lang.String r7 = r7.toString()
            com.meizu.cloud.pushsdk.networking.okio.BufferedSink r7 = r8.writeUtf8(r7)
            byte[] r8 = CRLF
            r7.write((byte[]) r8)
        L_0x0076:
            long r7 = r6.contentLength()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0090
            java.lang.String r9 = "Content-Length: "
            com.meizu.cloud.pushsdk.networking.okio.BufferedSink r9 = r13.writeUtf8(r9)
            com.meizu.cloud.pushsdk.networking.okio.BufferedSink r9 = r9.writeDecimalLong(r7)
            byte[] r10 = CRLF
            r9.write((byte[]) r10)
            goto L_0x0096
        L_0x0090:
            if (r14 == 0) goto L_0x0096
            r0.clear()
            return r9
        L_0x0096:
            byte[] r9 = CRLF
            r13.write((byte[]) r9)
            if (r14 == 0) goto L_0x009f
            long r4 = r4 + r7
            goto L_0x00a2
        L_0x009f:
            r6.writeTo(r13)
        L_0x00a2:
            byte[] r6 = CRLF
            r13.write((byte[]) r6)
            int r3 = r3 + 1
            goto L_0x0015
        L_0x00ab:
            byte[] r1 = DASHDASH
            r13.write((byte[]) r1)
            com.meizu.cloud.pushsdk.networking.okio.ByteString r1 = r12.boundary
            r13.write((com.meizu.cloud.pushsdk.networking.okio.ByteString) r1)
            byte[] r1 = DASHDASH
            r13.write((byte[]) r1)
            byte[] r1 = CRLF
            r13.write((byte[]) r1)
            if (r14 == 0) goto L_0x00c9
            long r13 = r0.size()
            long r4 = r4 + r13
            r0.clear()
        L_0x00c9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.networking.http.MultipartBody.writeOrCountBytes(com.meizu.cloud.pushsdk.networking.okio.BufferedSink, boolean):long");
    }

    static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 10) {
                sb.append("%0A");
            } else if (charAt == 13) {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }

    public static final class Part {
        /* access modifiers changed from: private */
        public final RequestBody body;
        /* access modifiers changed from: private */
        public final Headers headers;

        public static Part create(RequestBody requestBody) {
            return create((Headers) null, requestBody);
        }

        public static Part create(Headers headers2, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            } else if (headers2 != null && headers2.get(HTTP.CONTENT_TYPE) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (headers2 == null || headers2.get(HTTP.CONTENT_LEN) == null) {
                return new Part(headers2, requestBody);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, (String) null, RequestBody.create((MediaType) null, str2));
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                MultipartBody.appendQuotedString(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    MultipartBody.appendQuotedString(sb, str2);
                }
                return create(Headers.m4851of("Content-Disposition", sb.toString()), requestBody);
            }
            throw new NullPointerException("name == null");
        }

        private Part(Headers headers2, RequestBody requestBody) {
            this.headers = headers2;
            this.body = requestBody;
        }
    }

    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = ByteString.encodeUtf8(str);
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            } else if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            } else {
                throw new IllegalArgumentException("multipart != " + mediaType);
            }
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(Part part) {
            if (part != null) {
                this.parts.add(part);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, this.parts);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }
}
