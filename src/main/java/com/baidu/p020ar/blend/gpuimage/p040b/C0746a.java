package com.baidu.p020ar.blend.gpuimage.p040b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.baidu.p020ar.blend.gpuimage.graphics.C0749a;
import com.baidu.p020ar.blend.gpuimage.p039a.C0712g;

/* renamed from: com.baidu.ar.blend.gpuimage.b.a */
public class C0746a extends C0712g {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f1600a = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int[] f1601l;

    /* renamed from: m */
    private int[] f1602m;

    /* renamed from: n */
    private int f1603n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Bitmap[] f1604o;

    public C0746a(String[] strArr, String str) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", str);
        if (strArr != null) {
            this.f1600a = strArr.length;
            this.f1604o = new Bitmap[this.f1600a];
            this.f1601l = new int[this.f1600a];
            this.f1602m = new int[this.f1600a];
            for (int i = 0; i < this.f1600a; i++) {
                this.f1604o[i] = BitmapFactory.decodeFile(strArr[i]);
            }
            return;
        }
        this.f1600a = 0;
    }

    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        for (int i = 0; i < this.f1600a; i++) {
            int[] iArr = this.f1602m;
            int j = mo10012j();
            iArr[i] = GLES20.glGetUniformLocation(j, "inputImageTexture" + (i + 2));
        }
        this.f1603n = GLES20.glGetUniformLocation(mo10012j(), "strength");
    }

    /* renamed from: b */
    public void mo9982b() {
        super.mo9982b();
        mo9989a(this.f1603n, 1.0f);
        mo9992a((Runnable) new Runnable() {
            public void run() {
                for (int i = 0; i < C0746a.this.f1600a; i++) {
                    C0746a.this.f1601l[i] = C0749a.m1936a(C0746a.this.f1604o[i], -1, false);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo10007e() {
        super.mo10007e();
        GLES20.glDeleteTextures(this.f1601l.length, this.f1601l, 0);
        for (int i = 0; i < this.f1600a; i++) {
            this.f1601l[i] = -1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo10008f() {
        int i = 0;
        while (i < this.f1600a && this.f1601l[i] != -1) {
            int i2 = i + 3;
            GLES20.glActiveTexture(33984 + i2);
            GLES20.glBindTexture(3553, this.f1601l[i]);
            GLES20.glUniform1i(this.f1602m[i], i2);
            i++;
        }
    }
}
