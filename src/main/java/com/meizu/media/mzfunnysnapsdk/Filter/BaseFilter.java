package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.SparseArray;
import com.meizu.media.mzfunnysnapsdk.Utils.MatrixUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

public abstract class BaseFilter {
    public static boolean DEBUG = true;

    /* renamed from: OM */
    public static final float[] f15599OM = MatrixUtils.getOriginalMatrix();
    private static final String TAG = "Filter";
    public static ChangeQuickRedirect changeQuickRedirect;
    private float[] coord = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public boolean is_Sticker = false;
    private SparseArray<boolean[]> mBools;
    protected int mFlag = 0;
    private SparseArray<float[]> mFloats;
    protected int mHCoord;
    protected int mHMatrix;
    protected int mHPosition;
    protected int mHTexture;
    private SparseArray<int[]> mInts;
    protected int mProgram;
    protected Resources mRes;
    protected FloatBuffer mTexBuffer;
    protected FloatBuffer mVerBuffer;
    private float[] matrix = Arrays.copyOf(f15599OM, 16);
    protected ShortBuffer mindexBuffer;
    public float[] pos = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
    private int textureId = 0;
    private int textureType = 0;

    public int getOutputTexture() {
        return -1;
    }

    public abstract void onCreate();

    public abstract void onSizeChanged(int i, int i2);

    public BaseFilter(Resources resources, boolean z) {
        this.mRes = resources;
        this.is_Sticker = z;
        initBuffer();
    }

    public BaseFilter(Resources resources) {
        this.mRes = resources;
        initBuffer();
    }

    public final void create() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9058, new Class[0], Void.TYPE).isSupported) {
            onCreate();
        }
    }

    public final void setSize(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9059, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            onSizeChanged(i, i2);
        }
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9060, new Class[0], Void.TYPE).isSupported) {
            onClear();
            onUseProgram();
            onSetExpandData();
            onBindTexture();
            onDraw();
        }
    }

    public void pre_draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9061, new Class[0], Void.TYPE).isSupported) {
            onClear();
            onUseProgram();
            onSetExpandData();
            onBindTexture();
        }
    }

    public void post_draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9062, new Class[0], Void.TYPE).isSupported) {
            onDraw();
        }
    }

    public void setMatrix(float[] fArr) {
        this.matrix = fArr;
    }

    public void resetMatrix() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9063, new Class[0], Void.TYPE).isSupported) {
            this.matrix = Arrays.copyOf(f15599OM, 16);
        }
    }

    public float[] getMatrix() {
        return this.matrix;
    }

    public final void setTextureType(int i) {
        this.textureType = i;
    }

    public final int getTextureType() {
        return this.textureType;
    }

    public final int getTextureId() {
        return this.textureId;
    }

    public final void setTextureId(int i) {
        this.textureId = i;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    public int getFlag() {
        return this.mFlag;
    }

    public void setFloat(int i, float... fArr) {
        Object[] objArr = {new Integer(i), fArr};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9064, new Class[]{Integer.TYPE, float[].class}, Void.TYPE).isSupported) {
            if (this.mFloats == null) {
                this.mFloats = new SparseArray<>();
            }
            this.mFloats.put(i, fArr);
        }
    }

    public void setInt(int i, int... iArr) {
        Object[] objArr = {new Integer(i), iArr};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9065, new Class[]{Integer.TYPE, int[].class}, Void.TYPE).isSupported) {
            if (this.mInts == null) {
                this.mInts = new SparseArray<>();
            }
            this.mInts.put(i, iArr);
        }
    }

    public void setBool(int i, boolean... zArr) {
        Object[] objArr = {new Integer(i), zArr};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9066, new Class[]{Integer.TYPE, boolean[].class}, Void.TYPE).isSupported) {
            if (this.mBools == null) {
                this.mBools = new SparseArray<>();
            }
            this.mBools.put(i, zArr);
        }
    }

    public boolean getBool(int i, int i2) {
        boolean[] zArr;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, changeQuickRedirect, false, 9067, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.mBools != null && (zArr = this.mBools.get(i)) != null && zArr.length > i2 && zArr[i2]) {
            return true;
        }
        return false;
    }

    public int getInt(int i, int i2) {
        int[] iArr;
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect3, false, 9068, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.mInts == null || (iArr = this.mInts.get(i)) == null || iArr.length <= i2) {
            return 0;
        }
        return iArr[i2];
    }

    public float getFloat(int i, int i2) {
        float[] fArr;
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect3, false, 9069, new Class[]{Integer.TYPE, Integer.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        if (this.mFloats == null || (fArr = this.mFloats.get(i)) == null || fArr.length <= i2) {
            return 0.0f;
        }
        return fArr[i2];
    }

    public final void createProgram(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, changeQuickRedirect, false, 9070, clsArr, Void.TYPE).isSupported) {
            this.mProgram = uCreateGlProgram(str, str2);
            this.mHPosition = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
            this.mHCoord = GLES20.glGetAttribLocation(this.mProgram, "vCoord");
            this.mHMatrix = GLES20.glGetUniformLocation(this.mProgram, "vMatrix");
            this.mHTexture = GLES20.glGetUniformLocation(this.mProgram, "vTexture");
        }
    }

    public final void createProgramByAssetsFile(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, changeQuickRedirect, false, 9071, clsArr, Void.TYPE).isSupported) {
            createProgram(uRes(this.mRes, str), uRes(this.mRes, str2));
        }
    }

    public void initBuffer() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9072, new Class[0], Void.TYPE).isSupported) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.mVerBuffer = allocateDirect.asFloatBuffer();
            this.mVerBuffer.put(this.pos);
            this.mVerBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
            allocateDirect2.order(ByteOrder.nativeOrder());
            this.mTexBuffer = allocateDirect2.asFloatBuffer();
            this.mTexBuffer.put(this.coord);
            this.mTexBuffer.position(0);
        }
    }

    public void onUseProgram() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9073, new Class[0], Void.TYPE).isSupported) {
            GLES20.glUseProgram(this.mProgram);
        }
    }

    public void onDraw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9074, new Class[0], Void.TYPE).isSupported) {
            GLES20.glEnableVertexAttribArray(this.mHPosition);
            GLES20.glVertexAttribPointer(this.mHPosition, 2, 5126, false, 0, this.mVerBuffer);
            GLES20.glEnableVertexAttribArray(this.mHCoord);
            GLES20.glVertexAttribPointer(this.mHCoord, 2, 5126, false, 0, this.mTexBuffer);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.mHPosition);
            GLES20.glDisableVertexAttribArray(this.mHCoord);
        }
    }

    public void onClear() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9075, new Class[0], Void.TYPE).isSupported) {
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glClear(16640);
        }
    }

    public void onSetExpandData() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9076, new Class[0], Void.TYPE).isSupported) {
            GLES20.glUniformMatrix4fv(this.mHMatrix, 1, false, this.matrix, 0);
        }
    }

    public void onBindTexture() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9077, new Class[0], Void.TYPE).isSupported) {
            GLES20.glActiveTexture(this.textureType + 33984);
            GLES20.glBindTexture(3553, getTextureId());
            GLES20.glUniform1i(this.mHTexture, this.textureType);
        }
    }

    public static void glError(int i, Object obj) {
        boolean z = DEBUG;
    }

    public static String uRes(Resources resources, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{resources, str}, (Object) null, changeQuickRedirect, true, 9078, new Class[]{Resources.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        StringBuilder sb = new StringBuilder();
        try {
            InputStream open = resources.getAssets().open(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (-1 == read) {
                    return sb.toString().replaceAll("\\r\\n", "\n");
                }
                sb.append(new String(bArr, 0, read));
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static int uCreateGlProgram(String str, String str2) {
        int uLoadShader;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, (Object) null, changeQuickRedirect, true, 9079, new Class[]{String.class, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int uLoadShader2 = uLoadShader(35633, str);
        if (uLoadShader2 == 0 || (uLoadShader = uLoadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            return glCreateProgram;
        }
        GLES20.glAttachShader(glCreateProgram, uLoadShader2);
        GLES20.glAttachShader(glCreateProgram, uLoadShader);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        glError(1, "Could not link program:" + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public static int uLoadShader(int i, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), str}, (Object) null, changeQuickRedirect, true, 9080, new Class[]{Integer.TYPE, String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        glError(1, "Could not compile shader:" + i);
        glError(1, "GLES20 Error:" + GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }
}
