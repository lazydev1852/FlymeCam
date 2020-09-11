package com.meizu.media.camera.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.annotation.FloatRange;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.meizu.media.camera.animation.q */
/* compiled from: Util */
public class C1825q {

    /* renamed from: a */
    public static ChangeQuickRedirect f7897a;

    /* renamed from: b */
    private static final AtomicReference<RenderScript> f7898b = new AtomicReference<>();

    /* renamed from: a */
    public static float m8249a(float f, float f2) {
        Object[] objArr = {new Float(f), new Float(f2)};
        ChangeQuickRedirect changeQuickRedirect = f7897a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 2480, new Class[]{Float.TYPE, Float.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        if (f2 != 1.0f) {
            return (float) (1.0d - Math.pow((double) (1.0f - f), (double) (f2 * 2.0f)));
        }
        float f3 = 1.0f - f;
        return 1.0f - (f3 * f3);
    }

    /* renamed from: a */
    public static String m8253a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f7897a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 2481, new Class[]{Long.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        long j2 = j / 1000;
        long j3 = j2 / 60;
        long j4 = j2 - (60 * j3);
        StringBuilder sb = new StringBuilder();
        if (j3 >= 1) {
            sb.append(j2);
        } else {
            if (j4 < 10) {
                sb.append('0');
            }
            sb.append(j4);
        }
        sb.append(".");
        long j5 = (j - (j2 * 1000)) / 10;
        if (j5 < 10) {
            sb.append('0');
        }
        sb.append(j5);
        return sb.toString();
    }

    /* renamed from: a */
    public static Bitmap m8252a(Bitmap bitmap, int i, boolean z) {
        int[] iArr;
        Bitmap bitmap2 = bitmap;
        int i2 = i;
        boolean z2 = z;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap2, new Integer(i2), new Byte(z2 ? (byte) 1 : 0)}, (Object) null, f7897a, true, 2482, new Class[]{Bitmap.class, Integer.TYPE, Boolean.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap2 == null || bitmap.isRecycled()) {
            return null;
        }
        if (!z2) {
            bitmap2 = bitmap2.copy(bitmap.getConfig(), true);
        }
        if (i2 < 1) {
            return null;
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, new int[]{i6, 3});
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap3 = bitmap2;
            int i15 = -i2;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i15 <= i2) {
                int i25 = height;
                int i26 = i5;
                int i27 = iArr2[i13 + Math.min(i4, Math.max(i15, 0))];
                int[] iArr9 = iArr8[i15 + i2];
                iArr9[0] = (i27 & 16711680) >> 16;
                iArr9[1] = (i27 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i27 & 255;
                int abs = i11 - Math.abs(i15);
                i16 += iArr9[0] * abs;
                i17 += iArr9[1] * abs;
                i18 += iArr9[2] * abs;
                if (i15 > 0) {
                    i19 += iArr9[0];
                    i20 += iArr9[1];
                    i21 += iArr9[2];
                } else {
                    i22 += iArr9[0];
                    i23 += iArr9[1];
                    i24 += iArr9[2];
                }
                i15++;
                height = i25;
                i5 = i26;
            }
            int i28 = height;
            int i29 = i5;
            int i30 = i2;
            int i31 = 0;
            while (i31 < width) {
                iArr3[i13] = iArr7[i16];
                iArr4[i13] = iArr7[i17];
                iArr5[i13] = iArr7[i18];
                int i32 = i16 - i22;
                int i33 = i17 - i23;
                int i34 = i18 - i24;
                int[] iArr10 = iArr8[((i30 - i2) + i6) % i6];
                int i35 = i22 - iArr10[0];
                int i36 = i23 - iArr10[1];
                int i37 = i24 - iArr10[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr6[i31] = Math.min(i31 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i38 = iArr2[i14 + iArr6[i31]];
                iArr10[0] = (i38 & 16711680) >> 16;
                iArr10[1] = (i38 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i38 & 255;
                int i39 = i19 + iArr10[0];
                int i40 = i20 + iArr10[1];
                int i41 = i21 + iArr10[2];
                i16 = i32 + i39;
                i17 = i33 + i40;
                i18 = i34 + i41;
                i30 = (i30 + 1) % i6;
                int[] iArr11 = iArr8[i30 % i6];
                i22 = i35 + iArr11[0];
                i23 = i36 + iArr11[1];
                i24 = i37 + iArr11[2];
                i19 = i39 - iArr11[0];
                i20 = i40 - iArr11[1];
                i21 = i41 - iArr11[2];
                i13++;
                i31++;
                iArr7 = iArr;
            }
            int[] iArr12 = iArr7;
            i14 += width;
            i12++;
            bitmap2 = bitmap3;
            height = i28;
            i5 = i29;
        }
        Bitmap bitmap4 = bitmap2;
        int i42 = height;
        int i43 = i5;
        int[] iArr13 = iArr7;
        int i44 = 0;
        while (i44 < width) {
            int i45 = -i2;
            int i46 = i45 * width;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            while (i45 <= i2) {
                int[] iArr14 = iArr6;
                int max = Math.max(0, i46) + i44;
                int[] iArr15 = iArr8[i45 + i2];
                iArr15[0] = iArr3[max];
                iArr15[1] = iArr4[max];
                iArr15[2] = iArr5[max];
                int abs2 = i11 - Math.abs(i45);
                i47 += iArr3[max] * abs2;
                i48 += iArr4[max] * abs2;
                i49 += iArr5[max] * abs2;
                if (i45 > 0) {
                    i50 += iArr15[0];
                    i51 += iArr15[1];
                    i52 += iArr15[2];
                } else {
                    i53 += iArr15[0];
                    i54 += iArr15[1];
                    i55 += iArr15[2];
                }
                int i56 = i43;
                if (i45 < i56) {
                    i46 += width;
                }
                i45++;
                i43 = i56;
                iArr6 = iArr14;
            }
            int[] iArr16 = iArr6;
            int i57 = i43;
            int i58 = i51;
            int i59 = i52;
            int i60 = i42;
            int i61 = 0;
            int i62 = i2;
            int i63 = i50;
            int i64 = i49;
            int i65 = i48;
            int i66 = i47;
            int i67 = i44;
            while (i61 < i60) {
                iArr2[i67] = (iArr2[i67] & ViewCompat.MEASURED_STATE_MASK) | (iArr13[i66] << 16) | (iArr13[i65] << 8) | iArr13[i64];
                int i68 = i66 - i53;
                int i69 = i65 - i54;
                int i70 = i64 - i55;
                int[] iArr17 = iArr8[((i62 - i2) + i6) % i6];
                int i71 = i53 - iArr17[0];
                int i72 = i54 - iArr17[1];
                int i73 = i55 - iArr17[2];
                if (i44 == 0) {
                    iArr16[i61] = Math.min(i61 + i11, i57) * width;
                }
                int i74 = iArr16[i61] + i44;
                iArr17[0] = iArr3[i74];
                iArr17[1] = iArr4[i74];
                iArr17[2] = iArr5[i74];
                int i75 = i63 + iArr17[0];
                int i76 = i58 + iArr17[1];
                int i77 = i59 + iArr17[2];
                i66 = i68 + i75;
                i65 = i69 + i76;
                i64 = i70 + i77;
                i62 = (i62 + 1) % i6;
                int[] iArr18 = iArr8[i62];
                i53 = i71 + iArr18[0];
                i54 = i72 + iArr18[1];
                i55 = i73 + iArr18[2];
                i63 = i75 - iArr18[0];
                i58 = i76 - iArr18[1];
                i59 = i77 - iArr18[2];
                i67 += width;
                i61++;
                i2 = i;
            }
            i44++;
            i42 = i60;
            i43 = i57;
            iArr6 = iArr16;
            i2 = i;
        }
        bitmap4.setPixels(iArr2, 0, width, 0, 0, width, i42);
        return bitmap4;
    }

    /* renamed from: a */
    public static Bitmap m8250a(Context context, Bitmap bitmap, float f, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, bitmap, new Float(f), new Byte(z ? (byte) 1 : 0)}, (Object) null, f7897a, true, 2483, new Class[]{Context.class, Bitmap.class, Float.TYPE, Boolean.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (DeviceHelper.f14040j) {
            return m8251a(context, bitmap, f, false, z);
        }
        return m8252a(bitmap, (int) f, false);
    }

    /* renamed from: a */
    public static Bitmap m8251a(Context context, Bitmap bitmap, @FloatRange(from = 0.0d, mo103to = 25.0d) float f, boolean z, boolean z2) {
        Bitmap bitmap2;
        Bitmap bitmap3;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, bitmap, new Float(f), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, (Object) null, f7897a, true, 2486, new Class[]{Context.class, Bitmap.class, Float.TYPE, Boolean.TYPE, Boolean.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        RenderScript renderScript = f7898b.get();
        if (renderScript == null) {
            AtomicReference<RenderScript> atomicReference = f7898b;
            RenderScript create = RenderScript.create(context);
            if (atomicReference.compareAndSet((Object) null, create) || create == null) {
                renderScript = f7898b.get();
            } else {
                create.destroy();
                renderScript = create;
            }
        }
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        }
        if (z) {
            bitmap3 = bitmap;
        } else {
            bitmap3 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap2);
        Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        create2.setRadius(f);
        create2.setInput(createFromBitmap);
        create2.forEach(createTyped);
        if (z2 && !z) {
            bitmap.recycle();
        }
        createTyped.copyTo(bitmap3);
        createFromBitmap.destroy();
        createTyped.destroy();
        create2.destroy();
        return bitmap3;
    }
}
