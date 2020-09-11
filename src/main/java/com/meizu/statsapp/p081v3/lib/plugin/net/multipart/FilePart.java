package com.meizu.statsapp.p081v3.lib.plugin.net.multipart;

import com.meizu.statsapp.p081v3.utils.CommonUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.multipart.FilePart */
public class FilePart extends PartBase {
    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    protected static final String FILE_NAME = "; filename=";
    private static final byte[] FILE_NAME_BYTES = EncodingUtils.getAsciiBytes(FILE_NAME);
    private PartSource source;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilePart(String str, PartSource partSource, String str2, String str3) {
        super(str, str2 == null ? "application/octet-stream" : str2, str3 == null ? "ISO-8859-1" : str3, "binary");
        if (partSource != null) {
            this.source = partSource;
            return;
        }
        throw new IllegalArgumentException("Source may not be null");
    }

    public FilePart(String str, PartSource partSource) {
        this(str, partSource, (String) null, (String) null);
    }

    public FilePart(String str, File file) throws FileNotFoundException {
        this(str, (PartSource) new FilePartSource(file), (String) null, (String) null);
    }

    public FilePart(String str, File file, String str2, String str3) throws FileNotFoundException {
        this(str, (PartSource) new FilePartSource(file), str2, str3);
    }

    public FilePart(String str, String str2, File file) throws FileNotFoundException {
        this(str, (PartSource) new FilePartSource(str2, file), (String) null, (String) null);
    }

    public FilePart(String str, String str2, File file, String str3, String str4) throws FileNotFoundException {
        this(str, (PartSource) new FilePartSource(str2, file), str3, str4);
    }

    /* access modifiers changed from: protected */
    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        super.sendDispositionHeader(outputStream);
        String fileName = this.source.getFileName();
        if (fileName != null) {
            outputStream.write(FILE_NAME_BYTES);
            outputStream.write(QUOTE_BYTES);
            outputStream.write(EncodingUtils.getAsciiBytes(fileName));
            outputStream.write(QUOTE_BYTES);
        }
    }

    /* access modifiers changed from: protected */
    public void sendData(OutputStream outputStream) throws IOException {
        if (lengthOfData() != 0) {
            byte[] bArr = new byte[4096];
            InputStream createInputStream = this.source.createInputStream();
            while (true) {
                try {
                    int read = createInputStream.read(bArr);
                    if (read >= 0) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                } finally {
                    CommonUtils.closeQuietly(createInputStream);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public PartSource getSource() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    public long lengthOfData() {
        return this.source.getLength();
    }
}
