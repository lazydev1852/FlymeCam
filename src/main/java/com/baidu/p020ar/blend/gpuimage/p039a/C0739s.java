package com.baidu.p020ar.blend.gpuimage.p039a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.baidu.p020ar.blend.gpuimage.graphics.C0749a;
import com.baidu.p020ar.blend.gpuimage.graphics.Drawable2d;
import java.nio.FloatBuffer;

/* renamed from: com.baidu.ar.blend.gpuimage.a.s */
public class C0739s extends C0712g {

    /* renamed from: a */
    protected Bitmap f1581a;

    /* renamed from: l */
    protected volatile boolean f1582l;

    /* renamed from: m */
    private int f1583m;

    /* renamed from: n */
    private int f1584n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f1585o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public FloatBuffer f1586p;

    public C0739s(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", str);
    }

    public C0739s(String str, String str2) {
        super(str, str2);
        this.f1585o = -1;
        this.f1582l = false;
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        this.f1582l = false;
        this.f1586p = Drawable2d.f1608c;
        this.f1583m = GLES20.glGetAttribLocation(mo10012j(), "inputTextureCoordinate2");
        this.f1584n = GLES20.glGetUniformLocation(mo10012j(), "inputImageTexture2");
    }

    /* renamed from: a */
    public void mo10040a(final Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f1581a = bitmap;
            mo9992a((Runnable) new Runnable() {
                public void run() {
                    C0739s sVar;
                    int a;
                    if (C0739s.this.f1581a != null && !C0739s.this.f1581a.isRecycled()) {
                        FloatBuffer unused = C0739s.this.f1586p = Drawable2d.f1609d;
                        GLES20.glActiveTexture(33986);
                        if (C0739s.this.f1582l || C0739s.this.f1585o == -1) {
                            if (C0739s.this.f1585o != -1) {
                                GLES20.glDeleteTextures(1, new int[]{C0739s.this.f1585o}, 0);
                            }
                            sVar = C0739s.this;
                            a = C0749a.m1936a(bitmap, -1, false);
                        } else {
                            sVar = C0739s.this;
                            a = C0749a.m1936a(bitmap, C0739s.this.f1585o, false);
                        }
                        int unused2 = sVar.f1585o = a;
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public void mo9982b() {
        if (this.f1581a != null && !this.f1581a.isRecycled()) {
            mo10040a(this.f1581a);
        }
    }

    /* renamed from: b */
    public void mo10060b(final int i) {
        this.f1586p = Drawable2d.f1608c;
        mo9992a((Runnable) new Runnable() {
            public void run() {
                int unused = C0739s.this.f1585o = i;
            }
        });
    }

    /* renamed from: e */
    public void mo10007e() {
        super.mo10007e();
        if (this.f1585o != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.f1585o}, 0);
            this.f1585o = -1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo10008f() {
        super.mo10008f();
        if (this.f1585o != -1) {
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, this.f1585o);
            GLES20.glUniform1i(this.f1584n, 2);
        }
        if (this.f1586p != null && this.f1583m >= 0) {
            GLES20.glEnableVertexAttribArray(this.f1583m);
            GLES20.glVertexAttribPointer(this.f1583m, 2, 5126, false, 0, this.f1586p);
        }
    }
}
