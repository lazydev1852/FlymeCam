package com.meizu.statsapp.p081v3.lib.plugin.net.multipart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.multipart.FilePartSource */
public class FilePartSource implements PartSource {
    private File file;
    private String fileName;

    public FilePartSource(File file2) throws FileNotFoundException {
        this.file = null;
        this.fileName = null;
        this.file = file2;
        if (file2 == null) {
            return;
        }
        if (!file2.isFile()) {
            throw new FileNotFoundException("File is not a normal file.");
        } else if (file2.canRead()) {
            this.fileName = file2.getName();
        } else {
            throw new FileNotFoundException("File is not readable.");
        }
    }

    public FilePartSource(String str, File file2) throws FileNotFoundException {
        this(file2);
        if (str != null) {
            this.fileName = str;
        }
    }

    public long getLength() {
        if (this.file != null) {
            return this.file.length();
        }
        return 0;
    }

    public String getFileName() {
        return this.fileName == null ? "noname" : this.fileName;
    }

    public InputStream createInputStream() throws IOException {
        if (this.file != null) {
            return new FileInputStream(this.file);
        }
        return new ByteArrayInputStream(new byte[0]);
    }
}
