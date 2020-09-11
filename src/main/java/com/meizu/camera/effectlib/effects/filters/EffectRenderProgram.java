package com.meizu.camera.effectlib.effects.filters;

import android.opengl.GLES20;
import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* renamed from: com.meizu.camera.effectlib.effects.filters.a */
public class EffectRenderProgram {

    /* renamed from: a */
    public static ChangeQuickRedirect f3637a;

    /* renamed from: j */
    private static final float[] f3638j = {1.0f, 1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f};

    /* renamed from: b */
    private FloatBuffer f3639b;

    /* renamed from: c */
    private FloatBuffer f3640c;

    /* renamed from: d */
    private ShortBuffer f3641d;

    /* renamed from: e */
    private int f3642e = -1;

    /* renamed from: f */
    private int f3643f = -1;

    /* renamed from: g */
    private int f3644g = -1;

    /* renamed from: h */
    private int f3645h = -1;

    /* renamed from: i */
    private int f3646i = -1;

    /* renamed from: k */
    private short[] f3647k = {0, 1, 2, 2, 1, 3};

    /* renamed from: l */
    private final float[] f3648l = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: m */
    private final float[] f3649m = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: a */
    public void mo14085a() {
        if (!PatchProxy.proxy(new Object[0], this, f3637a, false, 45, new Class[0], Void.TYPE).isSupported) {
            this.f3642e = mo14084a(35633, "attribute vec4 aPosition;\nattribute vec4 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main()\n{\n  vTextureCoord = aTextureCoordinate.xy;\n  gl_Position = uMVPMatrix * aPosition;\n}\n");
            this.f3643f = mo14084a(35632, "#extension GL_OES_texture_3D : enable\nprecision mediump float;\nuniform sampler2D textureY;\nuniform sampler2D textureUV;\nuniform mediump sampler3D lut_tab;\nvarying vec2 vTextureCoord;\nuniform float u_IsSceneRender;\nvoid main() \n{\n  float r, g, b, y, u, v;\n  float y2, u2, v2;\n  y = texture2D(textureY, vTextureCoord).r;\n  u = texture2D(textureUV, vTextureCoord).a - 0.5;\n  v = texture2D(textureUV, vTextureCoord).r - 0.5;\n  r = y + 1.402*v;\n  g = y - 0.34414*u - 0.71414*v;\n  b = y + 1.772*u;\n  r = clamp(r, 0.0, 1.0);\n  g = clamp(g, 0.0, 1.0);\n  b = clamp(b, 0.0, 1.0);\nif (u_IsSceneRender >= 1.0) {\n  vec4 temprgb = texture3D(lut_tab, vec3(r, g, b));\n  y2 = 0.299*temprgb.r + 0.587*temprgb.g + 0.114*temprgb.b;\n  u2 = - 0.1687*temprgb.r - 0.3313*temprgb.g + 0.5*temprgb.b+0.5;\n  v2 = 0.5*temprgb.r - 0.4187*temprgb.g - 0.0813*temprgb.b+0.5;\n  gl_FragColor =vec4(y2,u2,v2,1.0);\n} else {\n  vec4 temprgb = texture3D(lut_tab, vec3(b, g, r));\n  y2 = 0.299*temprgb.r + 0.587*temprgb.g + 0.114*temprgb.b;\n  u2 = - 0.1687*temprgb.r - 0.3313*temprgb.g + 0.5*temprgb.b+0.5;\n  v2 = 0.5*temprgb.r - 0.4187*temprgb.g - 0.0813*temprgb.b+0.5;\n  gl_FragColor =vec4(y2,u2,v2,1.0);\n}\n}\n");
            this.f3644g = mo14083a(this.f3642e, this.f3643f);
        }
    }

    /* renamed from: b */
    public void mo14086b() {
        if (!PatchProxy.proxy(new Object[0], this, f3637a, false, 46, new Class[0], Void.TYPE).isSupported) {
            this.f3639b = ByteBuffer.allocateDirect(this.f3648l.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f3639b.put(this.f3648l).position(0);
            this.f3640c = ByteBuffer.allocateDirect(this.f3649m.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f3640c.put(this.f3649m).position(0);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f3647k.length * 2);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.f3641d = allocateDirect.asShortBuffer();
            this.f3641d.put(this.f3647k);
            this.f3641d.position(0);
        }
    }

    /* renamed from: a */
    public int mo14084a(int i, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), str}, this, f3637a, false, 47, new Class[]{Integer.TYPE, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return glCreateShader;
            }
            int[] iArr2 = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35716, iArr2, 0);
            if (iArr2[0] <= 1) {
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            Log.i("EffectRenderProgram", "Error Compiling shader" + glGetShaderInfoLog);
            throw new IllegalStateException("Error Compiling shader" + GLES20.glGetError());
        }
        throw new IllegalStateException("Create Shader Failed!" + GLES20.glGetError());
    }

    /* renamed from: a */
    public int mo14083a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f3637a, false, 48, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i);
            GLES20.glAttachShader(glCreateProgram, i2);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                int[] iArr2 = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35716, iArr2, 0);
                if (iArr2[0] > 1) {
                    String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                    Log.i("EffectRenderProgram", "Error linking program: " + glGetProgramInfoLog);
                }
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
            GLES20.glUseProgram(glCreateProgram);
            return glCreateProgram;
        }
        throw new IllegalArgumentException("Create Program Failed: " + GLES20.glGetError());
    }

    /* renamed from: c */
    public int mo14087c() {
        return this.f3644g;
    }

    /* renamed from: d */
    public FloatBuffer mo14088d() {
        return this.f3639b;
    }

    /* renamed from: e */
    public FloatBuffer mo14089e() {
        return this.f3640c;
    }

    /* renamed from: f */
    public ShortBuffer mo14090f() {
        return this.f3641d;
    }
}
