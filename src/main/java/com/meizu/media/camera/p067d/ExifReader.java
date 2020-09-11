package com.meizu.media.camera.p067d;

import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.meizu.media.camera.d.g */
public class ExifReader {

    /* renamed from: a */
    public static ChangeQuickRedirect f9460a;

    /* renamed from: b */
    private final ExifInterface f9461b;

    ExifReader(ExifInterface cVar) {
        this.f9461b = cVar;
    }

    /* renamed from: a */
    public ExifData mo19906a(InputStream inputStream) throws ExifInvalidFormatException, IOException {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{inputStream}, this, f9460a, false, 3969, new Class[]{InputStream.class}, ExifData.class);
        if (proxy.isSupported) {
            return (ExifData) proxy.result;
        }
        ExifParser a = ExifParser.m9885a(inputStream, this.f9461b);
        ExifData bVar = new ExifData(a.mo19905m());
        for (int a2 = a.mo19888a(); a2 != 5; a2 = a.mo19888a()) {
            switch (a2) {
                case 0:
                    bVar.mo19828a(new IfdData(a.mo19896d()));
                    break;
                case 1:
                    ExifTag c = a.mo19895c();
                    if (c.mo19931f()) {
                        bVar.mo19832b(c.mo19907a()).mo19941a(c);
                        break;
                    } else {
                        a.mo19892a(c);
                        break;
                    }
                case 2:
                    ExifTag c2 = a.mo19895c();
                    if (c2.mo19923c() == 7) {
                        a.mo19894b(c2);
                    }
                    bVar.mo19832b(c2.mo19907a()).mo19941a(c2);
                    break;
                case 3:
                    byte[] bArr = new byte[a.mo19899g()];
                    if (bArr.length != a.mo19889a(bArr)) {
                        Log.w("ExifReader", "Failed to read the compressed thumbnail");
                        break;
                    } else {
                        bVar.mo19829a(bArr);
                        break;
                    }
                case 4:
                    byte[] bArr2 = new byte[a.mo19898f()];
                    if (bArr2.length != a.mo19889a(bArr2)) {
                        Log.w("ExifReader", "Failed to read the strip bytes");
                        break;
                    } else {
                        bVar.mo19827a(a.mo19897e(), bArr2);
                        break;
                    }
            }
        }
        return bVar;
    }
}
