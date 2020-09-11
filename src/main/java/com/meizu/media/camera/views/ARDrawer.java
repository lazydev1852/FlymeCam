package com.meizu.media.camera.views;

import android.opengl.GLES20;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* renamed from: com.meizu.media.camera.views.a */
public class ARDrawer {

    /* renamed from: a */
    public static ChangeQuickRedirect f15211a;

    /* renamed from: l */
    private static float[] f15212l = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* renamed from: m */
    private static float[] f15213m = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: b */
    private final String f15214b = "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;}";

    /* renamed from: c */
    private final String f15215c = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}";

    /* renamed from: d */
    private FloatBuffer f15216d;

    /* renamed from: e */
    private FloatBuffer f15217e;

    /* renamed from: f */
    private ShortBuffer f15218f;

    /* renamed from: g */
    private final int f15219g;

    /* renamed from: h */
    private int f15220h;

    /* renamed from: i */
    private int f15221i;

    /* renamed from: j */
    private short[] f15222j = {0, 1, 2, 0, 2, 3};

    /* renamed from: k */
    private final int f15223k = 8;

    /* renamed from: n */
    private int f15224n;

    /* renamed from: o */
    private int f15225o;

    public ARDrawer(int i, int i2, boolean z) {
        this.f15224n = i;
        this.f15225o = i2;
        mo23307a(z);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(f15212l.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f15216d = allocateDirect.asFloatBuffer();
        this.f15216d.put(f15212l);
        this.f15216d.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.f15222j.length * 2);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.f15218f = allocateDirect2.asShortBuffer();
        this.f15218f.put(this.f15222j);
        this.f15218f.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(f15213m.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        this.f15217e = allocateDirect3.asFloatBuffer();
        this.f15217e.put(f15213m);
        this.f15217e.position(0);
        int a = m16689a(35633, "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;}");
        int a2 = m16689a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}");
        this.f15219g = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.f15219g, a);
        GLES20.glAttachShader(this.f15219g, a2);
        GLES20.glLinkProgram(this.f15219g);
    }

    /* renamed from: a */
    public void mo23308a(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f15211a, false, 8278, new Class[]{float[].class}, Void.TYPE).isSupported) {
            GLES20.glUseProgram(this.f15219g);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.f15225o, this.f15224n);
            this.f15220h = GLES20.glGetAttribLocation(this.f15219g, "vPosition");
            GLES20.glEnableVertexAttribArray(this.f15220h);
            GLES20.glVertexAttribPointer(this.f15220h, 2, 5126, false, 8, this.f15216d);
            this.f15221i = GLES20.glGetAttribLocation(this.f15219g, "inputTextureCoordinate");
            GLES20.glEnableVertexAttribArray(this.f15221i);
            GLES20.glVertexAttribPointer(this.f15221i, 2, 5126, false, 8, this.f15217e);
            GLES20.glDrawElements(4, this.f15222j.length, 5123, this.f15218f);
            GLES20.glDisableVertexAttribArray(this.f15220h);
            GLES20.glDisableVertexAttribArray(this.f15221i);
        }
    }

    /* renamed from: a */
    private int m16689a(int i, String str) {
        Object[] objArr = {new Integer(i), str};
        ChangeQuickRedirect changeQuickRedirect = f15211a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8279, new Class[]{Integer.TYPE, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    /* renamed from: a */
    public void mo23307a(boolean z) {
        if (z) {
            f15212l = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
        } else {
            f15212l = new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        }
    }
}
