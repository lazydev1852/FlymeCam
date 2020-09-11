package com.baidu.p020ar.blend.gpuimage.p039a;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.p020ar.blend.gpuimage.graphics.C0749a;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.savior.Constants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* renamed from: com.baidu.ar.blend.gpuimage.a.m */
public class C0730m extends C0712g {

    /* renamed from: r */
    private static final float[] f1548r = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: a */
    int f1549a = -1;

    /* renamed from: l */
    int f1550l = -1;

    /* renamed from: m */
    public ByteBuffer[] f1551m = null;

    /* renamed from: n */
    private FloatBuffer f1552n = C0749a.m1939a(f1548r);

    /* renamed from: o */
    private int[] f1553o = {-1, -1};

    /* renamed from: p */
    private int f1554p = -1;

    /* renamed from: q */
    private int f1555q = -1;

    public C0730m() {
        super("uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = uMVPMatrix * position;    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;}", "#ifdef GL_ES\nprecision highp float;\n#endif\nvarying vec2 textureCoordinate;\nuniform sampler2D luminanceTexture;\nuniform sampler2D chrominanceTexture;\nvoid main (void){\n   float r, g, b, y, u, v;\n   y = texture2D(luminanceTexture, textureCoordinate).r;\n   u = texture2D(chrominanceTexture, textureCoordinate).a - 0.5;\n   v = texture2D(chrominanceTexture, textureCoordinate).r - 0.5;\n   r = y + 1.13983*v;\n   g = y - 0.39465*u - 0.58060*v;\n   b = y + 2.03211*u;\n   gl_FragColor = vec4(r, g, b, 1.0);\n}\n");
    }

    /* renamed from: a */
    private void m1859a(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        ByteBuffer byteBuffer;
        GLES20.glUseProgram(mo10012j());
        C0749a.m1941a("glUseProgram");
        GLES20.glUniformMatrix4fv(this.f1487d, 1, false, this.f1490g, 0);
        GLES20.glUniformMatrix4fv(this.f1488e, 1, false, this.f1491h, 0);
        GLES20.glEnableVertexAttribArray(mo10013k());
        GLES20.glVertexAttribPointer(mo10013k(), 2, 5126, false, 8, this.f1485b.mo10069a());
        C0749a.m1941a("glVertexAttribPointer mPosLocationHandle");
        GLES20.glEnableVertexAttribArray(mo10014l());
        GLES20.glVertexAttribPointer(mo10014l(), 2, 5126, false, 8, this.f1552n);
        C0749a.m1941a("glVertexAttribPointer mTexLocationHandle");
        int length = this.f1553o.length;
        int i7 = 0;
        while (i7 < length) {
            int i8 = i7 == 0 ? this.f1554p : this.f1554p / 2;
            int i9 = i7 == 0 ? this.f1555q : this.f1555q / 2;
            GLES20.glActiveTexture(33984 + i7);
            C0749a.m1941a("glActiveTexture");
            GLES20.glBindTexture(3553, this.f1553o[i7]);
            C0749a.m1941a("glBindTexture");
            if (z) {
                if (i7 == 0) {
                    i = 3553;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 6409;
                    i6 = 5121;
                    byteBuffer = this.f1551m[i7];
                } else {
                    i = 3553;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 6410;
                    i6 = 5121;
                    byteBuffer = this.f1551m[i7];
                }
                GLES20.glTexSubImage2D(i, i2, i3, i4, i8, i9, i5, i6, byteBuffer);
            }
            int i10 = -1;
            switch (i7) {
                case 0:
                    i10 = this.f1549a;
                    break;
                case 1:
                    i10 = this.f1550l;
                    break;
            }
            if (m1860a(i10, "handle num = " + i7)) {
                GLES20.glUniform1i(i10, i7);
                C0749a.m1941a("glUniform1i handle(" + i7 + ")");
            }
            i7++;
        }
        GLES20.glDrawArrays(5, 0, 4);
        C0749a.m1941a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(mo10013k());
        C0749a.m1941a("glDisableVertexAttribArray mPosLocationHandle");
        GLES20.glDisableVertexAttribArray(mo10014l());
        C0749a.m1941a("glDisableVertexAttribArray mTexLocationHandle");
        GLES20.glUseProgram(0);
        m1863n();
    }

    /* renamed from: a */
    private boolean m1860a(int i, String str) {
        if (i >= 0) {
            return true;
        }
        if (str == null) {
            return false;
        }
        Log.e("GPUImageNV212RGBAFilter", Constants.ARRAY_TYPE + getClass().getCanonicalName() + "] Trying to set " + str + " without a valid handle.");
        return false;
    }

    /* renamed from: c */
    private void m1861c(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Buffer buffer;
        int i10 = i;
        int i11 = i2;
        int i12 = 1;
        boolean z = (i10 == this.f1554p && i11 == this.f1555q) ? false : true;
        if (z) {
            this.f1554p = i10;
            this.f1555q = i11;
            Log.d("GPUImageNV212RGBAFilter", "buildTextures videoSizeChanged: w=" + this.f1554p + " h=" + this.f1555q);
        }
        int length = this.f1553o.length;
        int i13 = 0;
        while (i13 < length) {
            if (this.f1553o[i13] < 0 || z) {
                if (this.f1553o[i13] >= 0) {
                    Log.d("GPUImageNV212RGBAFilter", "glDeleteTextures id");
                    int[] iArr = new int[i12];
                    iArr[0] = this.f1553o[i13];
                    GLES20.glDeleteTextures(i12, iArr, 0);
                    C0749a.m1941a("glDeleteTextures");
                }
                int i14 = i13 == 0 ? this.f1554p : this.f1554p / 2;
                int i15 = i13 == 0 ? this.f1555q : this.f1555q / 2;
                int[] iArr2 = new int[i12];
                GLES20.glGenTextures(i12, iArr2, 0);
                C0749a.m1941a("glGenTextures");
                this.f1553o[i13] = iArr2[0];
                Log.d("GPUImageNV212RGBAFilter", "glGenTextures id = " + this.f1553o[i13]);
                Log.d("rendayun", "glGenTextures id = " + this.f1553o[i13] + ", textures[0] = " + iArr2[0]);
                C0749a.m1941a("glActiveTexture");
                GLES20.glBindTexture(3553, this.f1553o[i13]);
                C0749a.m1941a("glBindTexture");
                if (i13 == 0) {
                    i4 = 3553;
                    i5 = 0;
                    i6 = 6409;
                    i7 = 0;
                    i8 = 6409;
                    i9 = 5121;
                    i3 = 3553;
                    buffer = null;
                } else {
                    i3 = 3553;
                    i4 = 3553;
                    i5 = 0;
                    i6 = 6410;
                    i7 = 0;
                    i8 = 6410;
                    i9 = 5121;
                    buffer = null;
                }
                GLES20.glTexImage2D(i4, i5, i6, i14, i15, i7, i8, i9, buffer);
                C0749a.m1941a("glTexImage2D");
                GLES20.glTexParameterf(i3, 10241, 9729.0f);
                GLES20.glTexParameterf(i3, PackUtils.FIXED_BUFFER_SIZE, 9729.0f);
                GLES20.glTexParameteri(i3, 10242, 33071);
                GLES20.glTexParameteri(i3, 10243, 33071);
                GLES20.glBindTexture(i3, 0);
            }
            i13++;
            i12 = 1;
        }
    }

    /* renamed from: m */
    private void m1862m() {
        m1861c(this.f1554p, this.f1555q);
        m1859a(true);
    }

    /* renamed from: n */
    private void m1863n() {
        int length = this.f1553o.length;
        for (int i = 0; i < length; i++) {
            GLES20.glBindTexture(3553, 0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9980a() {
        super.mo9980a();
        this.f1549a = GLES20.glGetUniformLocation(mo10012j(), "luminanceTexture");
        C0749a.m1945b(this.f1549a, "luminanceTexture");
        this.f1550l = GLES20.glGetUniformLocation(mo10012j(), "chrominanceTexture");
        C0749a.m1945b(this.f1550l, "chrominanceTexture");
    }

    /* renamed from: a */
    public void mo9990a(int i, int i2) {
        if (this.f1492i != i || this.f1493j != i2) {
            super.mo9990a(i, i2);
        }
    }

    /* renamed from: a */
    public void mo10043a(int i, int i2, byte[] bArr) {
        if (bArr != null && i > 0 && i2 > 0) {
            Log.d("GPUImageNV212RGBAFilter", "data.size = " + bArr.length);
            int i3 = i * i2;
            if (this.f1551m == null) {
                this.f1551m = new ByteBuffer[2];
            }
            if (this.f1551m[0] == null || this.f1551m[0].capacity() != i3) {
                this.f1551m[0] = ByteBuffer.allocateDirect(i3);
            }
            if (this.f1551m[1] == null || this.f1551m[1].capacity() != i3 / 2) {
                this.f1551m[1] = ByteBuffer.allocateDirect(i3 / 2);
            }
            Log.d("GPUImageNV212RGBAFilter", "data size = " + bArr.length + ", yuvPlane[0] size = " + this.f1551m[0].capacity());
            this.f1551m[0].put(bArr, 0, i3);
            this.f1551m[1].put(bArr, i3, i3 / 2);
            this.f1551m[0].position(0);
            this.f1551m[1].position(0);
            this.f1554p = i;
            this.f1555q = i2;
        }
    }

    /* renamed from: a */
    public void mo10044a(boolean z, float f) {
        float[] fArr = new float[f1548r.length];
        System.arraycopy(f1548r, 0, fArr, 0, f1548r.length);
        if (z) {
            fArr[0] = f;
            float f2 = 1.0f - f;
            fArr[2] = f2;
            fArr[4] = f;
            fArr[6] = f2;
        } else {
            fArr[1] = f;
            fArr[3] = f;
            float f3 = 1.0f - f;
            fArr[5] = f3;
            fArr[7] = f3;
        }
        this.f1552n.position(0);
        this.f1552n.put(fArr, 0, fArr.length);
        this.f1552n.position(0);
    }

    /* renamed from: b */
    public void mo9997b(int i, int i2) {
        if (this.f1490g == null) {
            this.f1490g = (float[]) C0749a.f1635a.clone();
        }
        if (this.f1491h == null) {
            this.f1491h = (float[]) C0749a.f1635a.clone();
        }
        C0749a.m1941a("draw start");
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glViewport(0, 0, this.f1492i, this.f1493j);
        m1862m();
    }

    /* renamed from: e */
    public void mo10007e() {
        super.mo10007e();
        this.f1554p = 0;
        this.f1555q = 0;
        int length = this.f1553o.length;
        for (int i = 0; i < length; i++) {
            if (this.f1553o[i] >= 0) {
                Log.d("GPUImageNV212RGBAFilter", "glDeleteTextures id");
                GLES20.glDeleteTextures(1, new int[]{this.f1553o[i]}, 0);
                C0749a.m1941a("glDeleteTextures");
            }
            this.f1553o[i] = -1;
        }
    }
}
