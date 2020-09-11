package com.meizu.statsapp.p081v3.lib.plugin.net.multipart;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.multipart.StringPart */
public class StringPart extends PartBase {
    public static final String DEFAULT_CHARSET = "US-ASCII";
    public static final String DEFAULT_CONTENT_TYPE = "text/plain";
    public static final String DEFAULT_TRANSFER_ENCODING = "8bit";
    private byte[] content;
    private String value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringPart(String str, String str2, String str3) {
        super(str, "text/plain", str3 == null ? "US-ASCII" : str3, DEFAULT_TRANSFER_ENCODING);
        str2 = str2 == null ? "" : str2;
        if (str2.indexOf(0) == -1) {
            this.value = str2;
            return;
        }
        throw new IllegalArgumentException("NULs may not be present in string parts");
    }

    public StringPart(String str, String str2) {
        this(str, str2, (String) null);
    }

    private byte[] getContent() {
        if (this.content == null) {
            this.content = EncodingUtils.getBytes(this.value, getCharSet());
        }
        return this.content;
    }

    /* access modifiers changed from: protected */
    public void sendData(OutputStream outputStream) throws IOException {
        outputStream.write(getContent());
    }

    /* access modifiers changed from: protected */
    public long lengthOfData() {
        return (long) getContent().length;
    }

    public void setCharSet(String str) {
        super.setCharSet(str);
        this.content = null;
    }
}
