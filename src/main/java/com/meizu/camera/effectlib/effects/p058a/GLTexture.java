package com.meizu.camera.effectlib.effects.p058a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.util.Log;
import com.arcsoft.livebroadcast.ArcSpotlightFaceAlignment;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.Buffer;
import java.nio.ByteBuffer;

/* renamed from: com.meizu.camera.effectlib.effects.a.c */
public class GLTexture {

    /* renamed from: a */
    public static ChangeQuickRedirect f3476a;

    /* renamed from: b */
    protected int f3477b;

    /* renamed from: c */
    protected int f3478c;

    /* renamed from: d */
    protected int f3479d = 0;

    /* renamed from: e */
    protected int f3480e = 0;

    public GLTexture(int i, int i2) {
        this.f3477b = i;
        this.f3478c = i2;
    }

    /* renamed from: a */
    public static GLTexture m4033a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f3476a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 113, new Class[]{Integer.TYPE, Integer.TYPE}, GLTexture.class);
        if (proxy.isSupported) {
            return (GLTexture) proxy.result;
        }
        Log.d("GLTexture", "createTexture");
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        GLTexture cVar = new GLTexture(m4036d(), 3553);
        cVar.mo14030b(i, i2);
        return cVar;
    }

    /* renamed from: a */
    public static GLTexture m4034a(Bitmap bitmap, int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, new Integer(i), new Integer(i2)}, (Object) null, f3476a, true, 115, new Class[]{Bitmap.class, Integer.TYPE, Integer.TYPE}, GLTexture.class);
        if (proxy.isSupported) {
            return (GLTexture) proxy.result;
        }
        Log.d("GLTexture", "createTextureFromBitmap");
        if (bitmap == null) {
            return null;
        }
        GLTexture cVar = new GLTexture(m4036d(), 3553);
        cVar.mo14031b(bitmap, i, i2);
        return cVar;
    }

    /* renamed from: b */
    public void mo14030b(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        Object[] objArr = {new Integer(i3), new Integer(i4)};
        if (!PatchProxy.proxy(objArr, this, f3476a, false, 117, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && i3 > 0 && i4 > 0) {
            this.f3479d = i3;
            this.f3480e = i4;
            GLES20.glBindTexture(this.f3478c, this.f3477b);
            GLES20Utils.m4017a("glBindTexture");
            GLES20.glTexParameteri(this.f3478c, PackUtils.FIXED_BUFFER_SIZE, 9729);
            GLES20.glTexParameteri(this.f3478c, 10241, 9729);
            GLES20.glTexParameteri(this.f3478c, 10242, 33071);
            GLES20.glTexParameteri(this.f3478c, 10243, 33071);
            GLES20Utils.m4017a("glTexParameteri");
            GLES20.glTexImage2D(this.f3478c, 0, 6408, i, i2, 0, 6408, 5121, (Buffer) null);
            GLES20Utils.m4017a("glTexImage2D");
            GLES20.glBindTexture(this.f3478c, 0);
            GLES20Utils.m4017a("glBindTexture");
        }
    }

    /* renamed from: b */
    public void mo14031b(Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2 = bitmap;
        int i3 = i;
        int i4 = i2;
        Object[] objArr = {bitmap2, new Integer(i3), new Integer(i4)};
        if (!PatchProxy.proxy(objArr, this, f3476a, false, 119, new Class[]{Bitmap.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && bitmap2 != null) {
            this.f3479d = i3;
            this.f3480e = i4;
            GLES20.glBindTexture(this.f3478c, this.f3477b);
            GLES20Utils.m4017a("glBindTexture");
            ByteBuffer allocate = ByteBuffer.allocate(this.f3479d * this.f3480e * 4);
            bitmap2.copyPixelsToBuffer(allocate);
            allocate.position(0);
            GLES20.glTexImage2D(3553, 0, 6408, this.f3479d, this.f3480e, 0, 6408, 5121, allocate);
            GLES20Utils.m4017a("glTexImage2D");
            GLES20.glTexParameteri(this.f3478c, PackUtils.FIXED_BUFFER_SIZE, 9729);
            GLES20.glTexParameteri(this.f3478c, 10241, 9729);
            GLES20.glTexParameteri(this.f3478c, 10242, 33071);
            GLES20.glTexParameteri(this.f3478c, 10243, 33071);
            GLES20Utils.m4017a("glTexParameteri");
            GLES20.glBindTexture(this.f3478c, 0);
        }
    }

    /* renamed from: a */
    public int mo14028a() {
        return this.f3477b;
    }

    /* renamed from: b */
    public int mo14029b() {
        return this.f3478c;
    }

    /* renamed from: c */
    public void mo14032c() {
        if (!PatchProxy.proxy(new Object[0], this, f3476a, false, 121, new Class[0], Void.TYPE).isSupported && this.f3477b != 0) {
            Log.e("GLTexture", "recycle Texture id " + this.f3477b);
            m4035a(this.f3477b);
            this.f3477b = 0;
        }
    }

    /* renamed from: d */
    public static int m4036d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f3476a, true, ArcSpotlightFaceAlignment.ASL_OUTLINE_POINT_COUNT, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(iArr.length, iArr, 0);
        GLES20Utils.m4017a("createTextureId");
        Log.e("GLTexture", "createTextureID    1             texture:" + iArr[0]);
        return iArr[0];
    }

    /* renamed from: a */
    public static void m4035a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f3476a, true, 123, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            Log.e("GLTexture", "deleteTextureID                 texture:" + i);
            int[] iArr = {i};
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            GLES20Utils.m4019b("glDeleteTextures");
        }
    }
}
