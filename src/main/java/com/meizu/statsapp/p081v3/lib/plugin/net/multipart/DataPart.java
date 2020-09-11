package com.meizu.statsapp.p081v3.lib.plugin.net.multipart;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.multipart.DataPart */
public class DataPart extends PartBase {
    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    protected static final String FILE_NAME = "; filename=";
    private static final byte[] FILE_NAME_BYTES = EncodingUtils.getAsciiBytes(FILE_NAME);
    private String filename;
    private byte[] source;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataPart(String str, String str2, byte[] bArr, String str3, String str4) {
        super(str, str3 == null ? "application/octet-stream" : str3, str4 == null ? "ISO-8859-1" : str4, "binary");
        if (bArr != null) {
            this.filename = str2;
            this.source = bArr;
            return;
        }
        throw new IllegalArgumentException("Source may not be null");
    }

    public DataPart(String str, String str2, byte[] bArr) {
        this(str, str2, bArr, (String) null, (String) null);
    }

    public DataPart(String str, byte[] bArr) {
        this(str, str, bArr, (String) null, (String) null);
    }

    /* access modifiers changed from: protected */
    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        super.sendDispositionHeader(outputStream);
        if (this.filename != null) {
            outputStream.write(FILE_NAME_BYTES);
            outputStream.write(QUOTE_BYTES);
            outputStream.write(EncodingUtils.getAsciiBytes(this.filename));
            outputStream.write(QUOTE_BYTES);
        }
    }

    /* access modifiers changed from: protected */
    public void sendData(OutputStream outputStream) throws IOException {
        if (lengthOfData() != 0) {
            byte[] bArr = new byte[4096];
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.source);
            while (true) {
                try {
                    int read = byteArrayInputStream.read(bArr);
                    if (read >= 0) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                } finally {
                    byteArrayInputStream.close();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public long lengthOfData() {
        return (long) this.source.length;
    }
}
