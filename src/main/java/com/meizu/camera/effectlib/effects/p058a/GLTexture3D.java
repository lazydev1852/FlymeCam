package com.meizu.camera.effectlib.effects.p058a;

import android.graphics.Bitmap;
import android.opengl.GLES30;
import com.alibaba.fastjson.asm.Opcodes;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;

/* renamed from: com.meizu.camera.effectlib.effects.a.d */
public class GLTexture3D {

    /* renamed from: a */
    public static ChangeQuickRedirect f3481a;

    /* renamed from: b */
    protected int f3482b = m4045d();

    /* renamed from: c */
    protected int f3483c = 0;

    /* renamed from: d */
    protected int f3484d = 0;

    /* renamed from: e */
    protected int f3485e = 0;

    /* renamed from: b */
    public int mo14034b() {
        return 32879;
    }

    /* renamed from: a */
    public static GLTexture3D m4042a(int i, int i2, int i3, Bitmap bitmap) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3), bitmap};
        ChangeQuickRedirect changeQuickRedirect = f3481a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 124, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Bitmap.class}, GLTexture3D.class);
        if (proxy.isSupported) {
            return (GLTexture3D) proxy.result;
        }
        if (i <= 0 || i2 <= 0 || i3 <= 0 || bitmap == null) {
            return null;
        }
        GLTexture3D dVar = new GLTexture3D();
        dVar.mo14035b(i, i2, i3, bitmap);
        return dVar;
    }

    /* renamed from: b */
    public void mo14035b(int i, int i2, int i3, Bitmap bitmap) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        Bitmap bitmap2 = bitmap;
        Object[] objArr = {new Integer(i4), new Integer(i5), new Integer(i6), bitmap2};
        ChangeQuickRedirect changeQuickRedirect = f3481a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 125, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Bitmap.class}, Void.TYPE).isSupported && i4 > 0 && i5 > 0 && i6 > 0 && bitmap2 != null) {
            this.f3483c = i4;
            this.f3484d = i5;
            this.f3485e = i6;
            GLES30.glBindTexture(32879, this.f3482b);
            m4044a("glBindTexture");
            ByteBuffer allocate = ByteBuffer.allocate(this.f3483c * this.f3484d * this.f3485e * 4);
            bitmap2.copyPixelsToBuffer(allocate);
            allocate.position(0);
            GLES30.glTexImage3D(32879, 0, 6408, this.f3483c, this.f3484d, this.f3485e, 0, 6408, 5121, allocate);
            m4044a("glTexImage3D");
            GLES30.glTexParameteri(32879, 10241, 9729);
            GLES30.glTexParameteri(32879, PackUtils.FIXED_BUFFER_SIZE, 9729);
            GLES30.glTexParameteri(32879, 10242, 33071);
            GLES30.glTexParameteri(32879, 10243, 33071);
            GLES30.glTexParameteri(32879, 32882, 33071);
            m4044a("glTexParameteri");
            GLES30.glBindTexture(32879, 0);
            m4044a("glBindTexture");
        }
    }

    /* renamed from: a */
    public int mo14033a() {
        return this.f3482b;
    }

    /* renamed from: c */
    public void mo14036c() {
        if (!PatchProxy.proxy(new Object[0], this, f3481a, false, Opcodes.IAND, new Class[0], Void.TYPE).isSupported && this.f3482b != 0) {
            m4043a(this.f3482b);
            this.f3482b = 0;
        }
    }

    /* renamed from: d */
    public static int m4045d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f3481a, true, 127, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int[] iArr = new int[1];
        GLES30.glGenTextures(iArr.length, iArr, 0);
        m4044a("createTextureId");
        return iArr[0];
    }

    /* renamed from: a */
    public static void m4043a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f3481a, true, 128, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            int[] iArr = {i};
            GLES30.glDeleteTextures(iArr.length, iArr, 0);
            m4044a("glDeleteTextures");
        }
    }

    /* renamed from: a */
    public static void m4044a(String str) {
        int glGetError;
        if (!PatchProxy.proxy(new Object[]{str}, (Object) null, f3481a, true, 129, new Class[]{String.class}, Void.TYPE).isSupported && (glGetError = GLES30.glGetError()) != 0) {
            throw new IllegalStateException(str + ": glError " + glGetError);
        }
    }
}
