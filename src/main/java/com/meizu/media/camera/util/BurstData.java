package com.meizu.media.camera.util;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001a\u001a\u00020\u0003H\u0002R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, mo27294d2 = {"Lcom/meizu/media/camera/util/BurstData;", "", "data", "", "isCacheFile", "", "fileName", "", "size", "", "([BZLjava/lang/String;I)V", "getData", "()[B", "setData", "([B)V", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "()Z", "setCacheFile", "(Z)V", "getSize", "()I", "setSize", "(I)V", "getFileData", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.util.h */
public final class BurstData {

    /* renamed from: a */
    public static ChangeQuickRedirect f14241a;
    @Nullable

    /* renamed from: b */
    private byte[] f14242b;

    /* renamed from: c */
    private boolean f14243c;
    @Nullable

    /* renamed from: d */
    private String f14244d;

    /* renamed from: e */
    private int f14245e;

    public BurstData(@Nullable byte[] bArr, boolean z, @Nullable String str, int i) {
        this.f14243c = z;
        this.f14244d = str;
        this.f14245e = i;
        this.f14242b = bArr;
    }

    /* renamed from: b */
    public final boolean mo22729b() {
        return this.f14243c;
    }

    @Nullable
    /* renamed from: c */
    public final String mo22730c() {
        return this.f14244d;
    }

    @Nullable
    /* renamed from: a */
    public final byte[] mo22728a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14241a, false, 7795, new Class[0], byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        if (this.f14243c) {
            return m16149d();
        }
        return this.f14242b;
    }

    /* renamed from: d */
    private final byte[] m16149d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14241a, false, 7796, new Class[0], byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        C2649i a = C2649i.m16153a(this.f14245e);
        C3443i.m21152a((Object) a, "ByteArrayPool.getInstance(size)");
        byte[] c = a.mo22733c();
        C3443i.m21152a((Object) c, "ByteArrayPool.getInstance(size).bufForLocalFile");
        if (this.f14244d != null) {
            String str = this.f14244d;
            if (str == null) {
                C3443i.m21151a();
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            fileInputStream.read(c);
            fileInputStream.close();
            String str2 = this.f14244d;
            if (str2 == null) {
                C3443i.m21151a();
            }
            new File(str2).delete();
        }
        return c;
    }
}
