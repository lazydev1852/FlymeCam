package com.meizu.statsapp.p081v3.lib.plugin.net.multipart;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.multipart.PartSource */
public interface PartSource {
    InputStream createInputStream() throws IOException;

    String getFileName();

    long getLength();
}
