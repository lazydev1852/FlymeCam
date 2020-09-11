package com.meizu.statsapp.p081v3.lib.plugin.net.multipart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.multipart.Part */
public abstract class Part {
    protected static final String BOUNDARY = "----------------314159265358979323846";
    public static final byte[] BOUNDARY_BYTES = EncodingUtils.getAsciiBytes(BOUNDARY);
    protected static final String CHARSET = "; charset=";
    protected static final byte[] CHARSET_BYTES = EncodingUtils.getAsciiBytes("; charset=");
    protected static final String CONTENT_DISPOSITION = "Content-Disposition: form-data; name=";
    protected static final byte[] CONTENT_DISPOSITION_BYTES = EncodingUtils.getAsciiBytes(CONTENT_DISPOSITION);
    protected static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding: ";
    protected static final byte[] CONTENT_TRANSFER_ENCODING_BYTES = EncodingUtils.getAsciiBytes(CONTENT_TRANSFER_ENCODING);
    protected static final String CONTENT_TYPE = "Content-Type: ";
    protected static final byte[] CONTENT_TYPE_BYTES = EncodingUtils.getAsciiBytes(CONTENT_TYPE);
    protected static final String CRLF = "\r\n";
    protected static final byte[] CRLF_BYTES = EncodingUtils.getAsciiBytes("\r\n");
    private static final byte[] DEFAULT_BOUNDARY_BYTES = BOUNDARY_BYTES;
    protected static final String EXTRA = "--";
    protected static final byte[] EXTRA_BYTES = EncodingUtils.getAsciiBytes(EXTRA);
    protected static final String QUOTE = "\"";
    protected static final byte[] QUOTE_BYTES = EncodingUtils.getAsciiBytes(QUOTE);
    private byte[] boundaryBytes;

    public static String getBoundary() {
        return BOUNDARY;
    }

    public abstract String getCharSet();

    public abstract String getContentType();

    public abstract String getName();

    public abstract String getTransferEncoding();

    public boolean isRepeatable() {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract long lengthOfData() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void sendData(OutputStream outputStream) throws IOException;

    /* access modifiers changed from: protected */
    public byte[] getPartBoundary() {
        if (this.boundaryBytes == null) {
            return DEFAULT_BOUNDARY_BYTES;
        }
        return this.boundaryBytes;
    }

    /* access modifiers changed from: package-private */
    public void setPartBoundary(byte[] bArr) {
        this.boundaryBytes = bArr;
    }

    /* access modifiers changed from: protected */
    public void sendStart(OutputStream outputStream) throws IOException {
        outputStream.write(EXTRA_BYTES);
        outputStream.write(getPartBoundary());
        outputStream.write(CRLF_BYTES);
    }

    /* access modifiers changed from: protected */
    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        outputStream.write(CONTENT_DISPOSITION_BYTES);
        outputStream.write(QUOTE_BYTES);
        outputStream.write(EncodingUtils.getAsciiBytes(getName()));
        outputStream.write(QUOTE_BYTES);
    }

    /* access modifiers changed from: protected */
    public void sendContentTypeHeader(OutputStream outputStream) throws IOException {
        String contentType = getContentType();
        if (contentType != null) {
            outputStream.write(CRLF_BYTES);
            outputStream.write(CONTENT_TYPE_BYTES);
            outputStream.write(EncodingUtils.getAsciiBytes(contentType));
            String charSet = getCharSet();
            if (charSet != null) {
                outputStream.write(CHARSET_BYTES);
                outputStream.write(EncodingUtils.getAsciiBytes(charSet));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void sendTransferEncodingHeader(OutputStream outputStream) throws IOException {
        String transferEncoding = getTransferEncoding();
        if (transferEncoding != null) {
            outputStream.write(CRLF_BYTES);
            outputStream.write(CONTENT_TRANSFER_ENCODING_BYTES);
            outputStream.write(EncodingUtils.getAsciiBytes(transferEncoding));
        }
    }

    /* access modifiers changed from: protected */
    public void sendEndOfHeader(OutputStream outputStream) throws IOException {
        outputStream.write(CRLF_BYTES);
        outputStream.write(CRLF_BYTES);
    }

    /* access modifiers changed from: protected */
    public void sendEnd(OutputStream outputStream) throws IOException {
        outputStream.write(CRLF_BYTES);
    }

    public void send(OutputStream outputStream) throws IOException {
        sendStart(outputStream);
        sendDispositionHeader(outputStream);
        sendContentTypeHeader(outputStream);
        sendTransferEncodingHeader(outputStream);
        sendEndOfHeader(outputStream);
        sendData(outputStream);
        sendEnd(outputStream);
    }

    public long length() throws IOException {
        if (lengthOfData() < 0) {
            return -1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sendStart(byteArrayOutputStream);
        sendDispositionHeader(byteArrayOutputStream);
        sendContentTypeHeader(byteArrayOutputStream);
        sendTransferEncodingHeader(byteArrayOutputStream);
        sendEndOfHeader(byteArrayOutputStream);
        sendEnd(byteArrayOutputStream);
        return ((long) byteArrayOutputStream.size()) + lengthOfData();
    }

    public String toString() {
        return getName();
    }

    public static void sendParts(OutputStream outputStream, Part[] partArr) throws IOException {
        sendParts(outputStream, partArr, DEFAULT_BOUNDARY_BYTES);
    }

    public static void sendParts(OutputStream outputStream, Part[] partArr, byte[] bArr) throws IOException {
        if (partArr == null) {
            throw new IllegalArgumentException("Parts may not be null");
        } else if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("partBoundary may not be empty");
        } else {
            for (int i = 0; i < partArr.length; i++) {
                partArr[i].setPartBoundary(bArr);
                partArr[i].send(outputStream);
            }
            outputStream.write(EXTRA_BYTES);
            outputStream.write(bArr);
            outputStream.write(EXTRA_BYTES);
            outputStream.write(CRLF_BYTES);
        }
    }

    public static long getLengthOfParts(Part[] partArr) throws IOException {
        return getLengthOfParts(partArr, DEFAULT_BOUNDARY_BYTES);
    }

    public static long getLengthOfParts(Part[] partArr, byte[] bArr) throws IOException {
        if (partArr != null) {
            long j = 0;
            for (int i = 0; i < partArr.length; i++) {
                partArr[i].setPartBoundary(bArr);
                long length = partArr[i].length();
                if (length < 0) {
                    return -1;
                }
                j += length;
            }
            return j + ((long) EXTRA_BYTES.length) + ((long) bArr.length) + ((long) EXTRA_BYTES.length) + ((long) CRLF_BYTES.length);
        }
        throw new IllegalArgumentException("Parts may not be null");
    }
}
