package com.meizu.media.camera.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Icon;
import android.hardware.Camera;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.utils.reflect.SystemProperties;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CameraUtil {

    /* renamed from: A */
    private static int[] f13774A = new int[2];

    /* renamed from: B */
    private static Paint f13775B;

    /* renamed from: C */
    private static PorterDuffXfermode f13776C = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    /* renamed from: a */
    public static ChangeQuickRedirect f13777a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f13778b = new LogUtil.C2630a("CameraUtil");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static AlertDialog f13779c;

    /* renamed from: d */
    private static AlertDialog f13780d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static AlertDialog f13781e;

    /* renamed from: f */
    private static int f13782f;

    /* renamed from: g */
    private static int f13783g;

    /* renamed from: h */
    private static volatile boolean f13784h;

    /* renamed from: i */
    private static final float[] f13785i = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: j */
    private static final float[] f13786j = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: k */
    private static float f13787k = 1.0f;

    /* renamed from: l */
    private static int f13788l;

    /* renamed from: m */
    private static int f13789m;

    /* renamed from: n */
    private static int f13790n;

    /* renamed from: o */
    private static int f13791o;

    /* renamed from: p */
    private static int f13792p;

    /* renamed from: q */
    private static int f13793q;

    /* renamed from: r */
    private static int f13794r;

    /* renamed from: s */
    private static int f13795s;

    /* renamed from: t */
    private static int f13796t;

    /* renamed from: u */
    private static C2626a f13797u;

    /* renamed from: v */
    private static Map<Long, String> f13798v = new HashMap();

    /* renamed from: w */
    private static boolean f13799w;

    /* renamed from: x */
    private static int f13800x;

    /* renamed from: y */
    private static int f13801y;

    /* renamed from: z */
    private static int f13802z;

    public enum ScreeAspectRatio {
        Ratio_18X_9_FullScreen,
        Ratio_18_9,
        Ratio_16_9,
        Ratio_4_3,
        Ratio_3_2,
        Ratio_Unknow;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    /* renamed from: a */
    public static int m15812a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: a */
    public static boolean m15855a(float f, float f2) {
        return ((double) ((f2 / f) - 1.3333334f)) < 1.0E-6d;
    }

    /* renamed from: a */
    public static boolean m15861a(CameraController.FocusMode focusMode, List<CameraController.FocusMode> list) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{focusMode, list}, (Object) null, f13777a, true, 7832, new Class[]{CameraController.FocusMode.class, List.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return list != null && list.indexOf(focusMode) >= 0;
    }

    /* renamed from: a */
    public static boolean m15864a(String str, List<String> list) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, list}, (Object) null, f13777a, true, 7833, new Class[]{String.class, List.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return list != null && list.indexOf(str) >= 0;
    }

    /* renamed from: a */
    public static boolean m15863a(String str, ArrayList<String> arrayList) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, arrayList}, (Object) null, f13777a, true, 7834, new Class[]{String.class, ArrayList.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (arrayList == null) {
            return false;
        }
        return arrayList.contains(str);
    }

    /* renamed from: a */
    public static boolean m15858a(Camera.Parameters parameters) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{parameters}, (Object) null, f13777a, true, 7835, new Class[]{Camera.Parameters.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : "true".equals(parameters.get("auto-exposure-lock-supported"));
    }

    /* renamed from: b */
    public static boolean m15880b(Camera.Parameters parameters) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{parameters}, (Object) null, f13777a, true, 7836, new Class[]{Camera.Parameters.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : "true".equals(parameters.get("auto-whitebalance-lock-supported"));
    }

    /* renamed from: c */
    public static boolean m15887c(Camera.Parameters parameters) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{parameters}, (Object) null, f13777a, true, 7839, new Class[]{Camera.Parameters.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return parameters.getMaxNumMeteringAreas() > 0;
    }

    /* renamed from: d */
    public static boolean m15892d(Camera.Parameters parameters) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{parameters}, (Object) null, f13777a, true, 7840, new Class[]{Camera.Parameters.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return parameters.getMaxNumFocusAreas() > 0 && m15864a(CameraController.FocusMode.AUTO.getKey(), parameters.getSupportedFocusModes());
    }

    /* renamed from: a */
    public static void m15843a(Context context) {
        int i;
        if (!PatchProxy.proxy(new Object[]{context}, (Object) null, f13777a, true, 7841, new Class[]{Context.class}, Void.TYPE).isSupported) {
            if (m15900g(context) && m15808A()) {
                m15902h(context);
            }
            Context a = ContextBuilder.m6349a(context, true, true);
            NavigationBarUtils.m15974b(context);
            f13795s = NavigationBarUtils.m15968a(a);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            f13787k = displayMetrics.density;
            f13788l = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels);
            f13789m = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
            LogUtil.C2630a aVar = f13778b;
            LogUtil.m15952c(aVar, "initialize start:" + f13788l + "x" + f13789m);
            if (DeviceHelper.f13874aa) {
                f13799w = m15915u();
            }
            if (NavigationBarUtils.m15973a(context.getResources()) || m15916v()) {
                if (!DeviceHelper.f13874aa) {
                    f13789m = (f13788l * 16) / 9;
                } else if (m15916v()) {
                    f13789m = f13788l * 2;
                }
            }
            if (DeviceHelper.f13874aa) {
                float f = ((float) f13789m) / ((float) f13788l);
                if (2.0444443f <= f && f <= 2.1111112f) {
                    f13792p = a.getResources().getDimensionPixelSize(R.dimen.mz_smartbar_height_18x_9);
                } else if (2.0f <= f && f < 2.0444443f) {
                    f13792p = (f13789m - ((int) (((float) f13788l) * 1.3333334f))) - a.getResources().getDimensionPixelSize(R.dimen.mz_bottom_bar_height_18_9);
                } else if (2.1111112f < f) {
                    f13792p = a.getResources().getDimensionPixelSize(R.dimen.mz_smartbar_height_19x_9);
                } else {
                    f13792p = a.getResources().getDimensionPixelSize(R.dimen.mz_smartbar_height_18_9);
                }
            } else {
                f13792p = a.getResources().getDimensionPixelSize(R.dimen.mz_smartbar_height);
            }
            f13794r = a.getResources().getDimensionPixelSize(R.dimen.mz_square_margin_top);
            if (!NavigationBarUtils.m15972a()) {
                f13791o = a.getResources().getDimensionPixelSize(R.dimen.mz_bottom_bar_height);
                f13796t = 0;
                f13790n = (f13789m - f13792p) - f13791o;
            } else if (DeviceHelper.f13874aa) {
                f13790n = (int) (((float) f13788l) * 1.3333334f);
                f13791o = (f13789m - f13792p) - f13790n;
            } else {
                f13791o = a.getResources().getDimensionPixelSize(R.dimen.mz_bottom_bar_height_navigation_bar);
                f13790n = f13789m - f13791o;
            }
            int i2 = (f13789m - f13791o) - f13788l;
            if (DeviceHelper.f13928bb) {
                i = a.getResources().getDimensionPixelSize(R.dimen.mz_zoom_click_out_margin_bottom);
            } else {
                i = a.getResources().getDimensionPixelSize(R.dimen.mz_zoom_slider_height);
            }
            f13794r = i2 - i;
            f13796t = f13791o - a.getResources().getDimensionPixelSize(R.dimen.mz_bottom_bar_height);
            f13797u = new C2626a(context.getString(R.string.image_file_name_format), context.getString(R.string.mz_burst_folder_name_format));
            f13793q = a.getResources().getDimensionPixelOffset(R.dimen.mz_thumbnail_width);
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                f13801y = context.getResources().getDimensionPixelSize(identifier);
            } else {
                f13801y = context.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
            }
            f13802z = context.getResources().getDimensionPixelSize(R.dimen.mz_action_bar_default_height_appcompat);
            if (!CameraOptTask.m7846m()) {
                f13798v.clear();
            }
            LogUtil.C2630a aVar2 = f13778b;
            LogUtil.m15952c(aVar2, "initialize end:" + f13788l + "x" + f13789m + ", sSmartbarHeight:" + f13792p + ", sControlbarHeight:" + f13791o);
        }
    }

    /* renamed from: a */
    public static int m15809a() {
        return f13788l;
    }

    /* renamed from: b */
    public static int m15865b() {
        return f13789m;
    }

    /* renamed from: c */
    public static int m15881c() {
        return f13790n;
    }

    /* renamed from: d */
    public static int m15888d() {
        return f13790n + f13792p;
    }

    /* renamed from: e */
    public static int m15893e() {
        return f13791o + f13792p;
    }

    /* renamed from: a */
    public static int m15810a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f13777a, true, 7842, new Class[]{Integer.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : Math.round(f13787k * ((float) i));
    }

    /* renamed from: f */
    public static int m15897f() {
        return f13791o;
    }

    /* renamed from: g */
    public static int m15899g() {
        return f13796t;
    }

    /* renamed from: h */
    public static int m15901h() {
        return f13792p;
    }

    /* renamed from: i */
    public static int m15903i() {
        return f13793q;
    }

    /* renamed from: j */
    public static int m15904j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f13777a, true, 7843, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (DeviceHelper.f13874aa) {
            return f13794r;
        }
        return CameraModeType.m10946a().equals(CameraModeType.ModeType.SQUARE) ? ((f13789m - f13788l) - f13791o) - f13792p : f13794r;
    }

    /* renamed from: k */
    public static int m15905k() {
        return f13800x;
    }

    /* renamed from: b */
    public static int m15868b(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f13777a, true, 7844, new Class[]{Context.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (((double) ((((float) f13789m) / ((float) f13788l)) - 2.1222222f)) >= 0.001d) {
            return (int) (((float) context.getResources().getDimensionPixelOffset(R.dimen.mz_control_bar_margin_bottom_18_9_base_offSet)) * ((((float) f13789m) / ((float) f13788l)) - 2.1222222f) * 90.0f);
        }
        return 0;
    }

    /* renamed from: a */
    public static Bitmap m15822a(Bitmap bitmap, boolean z, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, new Byte(z ? (byte) 1 : 0), new Integer(i)}, (Object) null, f13777a, true, 7845, new Class[]{Bitmap.class, Boolean.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        float f = (float) height;
        float f2 = (float) width;
        float f3 = f / f2;
        if (width > height) {
            f3 = f2 / f;
        }
        float f4 = ((float) f13789m) / ((float) f13788l);
        float f5 = (float) (((f13789m - f13788l) - f13791o) - f13792p);
        if (DeviceHelper.f13874aa) {
            f5 = (float) (m15904j() - f13792p);
        }
        if (Math.abs(f4 - f3) > 0.1f && !NavigationBarUtils.m15972a()) {
            f5 -= (float) f13792p;
        }
        if (width > height) {
            int i6 = (int) ((f2 * f5) / ((float) (CameraModeType.m10985n(CameraModeType.ModeType.SQUARE) ? f13790n : f13789m)));
            if (z) {
                if (i == 0) {
                    i5 = (width - min) - i6;
                }
                i3 = i6;
                i2 = 0;
            } else {
                if (i == 180) {
                    i5 = (width - min) - i6;
                }
                i3 = i6;
                i2 = 0;
            }
            i3 = i5;
            i2 = 0;
        } else {
            int i7 = (int) ((f * f5) / ((float) (CameraModeType.m10985n(CameraModeType.ModeType.SQUARE) ? f13790n : f13789m)));
            if (z) {
                if (i == 90) {
                    i4 = (height - min) - i7;
                }
                i2 = i7;
                i3 = 0;
            } else {
                if (i == 270) {
                    i4 = (height - min) - i7;
                }
                i2 = i7;
                i3 = 0;
            }
            i2 = i4;
            i3 = 0;
        }
        return Bitmap.createBitmap(bitmap, i3, i2, min, min, (Matrix) null, false);
    }

    /* renamed from: l */
    public static int m15906l() {
        return f13802z;
    }

    /* renamed from: m */
    public static int m15907m() {
        return f13801y;
    }

    /* renamed from: a */
    public static Bitmap m15819a(Bitmap bitmap, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, new Integer(i)}, (Object) null, f13777a, true, 7846, new Class[]{Bitmap.class, Integer.TYPE}, Bitmap.class);
        return proxy.isSupported ? (Bitmap) proxy.result : m15820a(bitmap, i, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap m15820a(android.graphics.Bitmap r8, int r9, boolean r10) {
        /*
            r0 = 3
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r8
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r9)
            r4 = 1
            r1[r4] = r3
            java.lang.Byte r3 = new java.lang.Byte
            r3.<init>(r10)
            r5 = 2
            r1[r5] = r3
            com.meizu.savior.ChangeQuickRedirect r3 = f13777a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.graphics.Bitmap> r0 = android.graphics.Bitmap.class
            r6[r2] = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            r6[r4] = r0
            java.lang.Class r0 = java.lang.Boolean.TYPE
            r6[r5] = r0
            java.lang.Class<android.graphics.Bitmap> r7 = android.graphics.Bitmap.class
            r2 = 0
            r5 = 7847(0x1ea7, float:1.0996E-41)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0038
            java.lang.Object r8 = r0.result
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            return r8
        L_0x0038:
            r0 = 0
            if (r9 != 0) goto L_0x003d
            if (r10 == 0) goto L_0x00af
        L_0x003d:
            if (r8 == 0) goto L_0x00af
            android.graphics.Matrix r6 = new android.graphics.Matrix
            r6.<init>()
            if (r10 == 0) goto L_0x008a
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = 1065353216(0x3f800000, float:1.0)
            r6.postScale(r10, r1)
            int r9 = r9 + 360
            int r9 = r9 % 360
            r10 = 0
            if (r9 == 0) goto L_0x0082
            r1 = 180(0xb4, float:2.52E-43)
            if (r9 != r1) goto L_0x0059
            goto L_0x0082
        L_0x0059:
            r1 = 90
            if (r9 == r1) goto L_0x0079
            r1 = 270(0x10e, float:3.78E-43)
            if (r9 != r1) goto L_0x0062
            goto L_0x0079
        L_0x0062:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Invalid degrees="
            r10.append(r0)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L_0x0079:
            int r1 = r8.getHeight()
            float r1 = (float) r1
            r6.postTranslate(r1, r10)
            goto L_0x008a
        L_0x0082:
            int r1 = r8.getWidth()
            float r1 = (float) r1
            r6.postTranslate(r1, r10)
        L_0x008a:
            if (r9 == 0) goto L_0x009e
            float r9 = (float) r9
            int r10 = r8.getWidth()
            float r10 = (float) r10
            r1 = 1073741824(0x40000000, float:2.0)
            float r10 = r10 / r1
            int r2 = r8.getHeight()
            float r2 = (float) r2
            float r2 = r2 / r1
            r6.postRotate(r9, r10, r2)
        L_0x009e:
            r2 = 0
            r3 = 0
            int r4 = r8.getWidth()     // Catch:{ OutOfMemoryError -> 0x00af }
            int r5 = r8.getHeight()     // Catch:{ OutOfMemoryError -> 0x00af }
            r7 = 1
            r1 = r8
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ OutOfMemoryError -> 0x00af }
            goto L_0x00b0
        L_0x00af:
            r9 = r0
        L_0x00b0:
            if (r9 != 0) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r8 = r9
        L_0x00b4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.CameraUtil.m15820a(android.graphics.Bitmap, int, boolean):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bc  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap m15872b(android.graphics.Bitmap r9, int r10, boolean r11) {
        /*
            r0 = 3
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r9
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r10)
            r3 = 1
            r1[r3] = r2
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r11)
            r4 = 2
            r1[r4] = r2
            com.meizu.savior.ChangeQuickRedirect r5 = f13777a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.graphics.Bitmap> r0 = android.graphics.Bitmap.class
            r6[r8] = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            r6[r3] = r0
            java.lang.Class r0 = java.lang.Boolean.TYPE
            r6[r4] = r0
            java.lang.Class<android.graphics.Bitmap> r7 = android.graphics.Bitmap.class
            r2 = 0
            r4 = 1
            r0 = 7848(0x1ea8, float:1.0997E-41)
            r3 = r5
            r5 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x003b
            java.lang.Object r9 = r0.result
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            return r9
        L_0x003b:
            r0 = 0
            if (r10 != 0) goto L_0x0040
            if (r11 == 0) goto L_0x00b2
        L_0x0040:
            if (r9 == 0) goto L_0x00b2
            android.graphics.Matrix r6 = new android.graphics.Matrix
            r6.<init>()
            if (r11 == 0) goto L_0x008d
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = 1065353216(0x3f800000, float:1.0)
            r6.postScale(r11, r1)
            int r10 = r10 + 360
            int r10 = r10 % 360
            r11 = 0
            if (r10 == 0) goto L_0x0085
            r1 = 180(0xb4, float:2.52E-43)
            if (r10 != r1) goto L_0x005c
            goto L_0x0085
        L_0x005c:
            r1 = 90
            if (r10 == r1) goto L_0x007c
            r1 = 270(0x10e, float:3.78E-43)
            if (r10 != r1) goto L_0x0065
            goto L_0x007c
        L_0x0065:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Invalid degrees="
            r11.append(r0)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L_0x007c:
            int r1 = r9.getHeight()
            float r1 = (float) r1
            r6.postTranslate(r1, r11)
            goto L_0x008d
        L_0x0085:
            int r1 = r9.getWidth()
            float r1 = (float) r1
            r6.postTranslate(r1, r11)
        L_0x008d:
            if (r10 == 0) goto L_0x00a1
            float r10 = (float) r10
            int r11 = r9.getWidth()
            float r11 = (float) r11
            r1 = 1073741824(0x40000000, float:2.0)
            float r11 = r11 / r1
            int r2 = r9.getHeight()
            float r2 = (float) r2
            float r2 = r2 / r1
            r6.postRotate(r10, r11, r2)
        L_0x00a1:
            r2 = 0
            r3 = 0
            int r4 = r9.getWidth()     // Catch:{ OutOfMemoryError -> 0x00b2 }
            int r5 = r9.getHeight()     // Catch:{ OutOfMemoryError -> 0x00b2 }
            r7 = 1
            r1 = r9
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ OutOfMemoryError -> 0x00b2 }
            goto L_0x00b3
        L_0x00b2:
            r10 = r0
        L_0x00b3:
            if (r10 == 0) goto L_0x00bc
            boolean[] r9 = new boolean[r8]
            android.graphics.Bitmap r9 = m15823a((android.graphics.Bitmap) r10, (boolean[]) r9)
            return r9
        L_0x00bc:
            boolean[] r10 = new boolean[r8]
            android.graphics.Bitmap r9 = m15823a((android.graphics.Bitmap) r9, (boolean[]) r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.CameraUtil.m15872b(android.graphics.Bitmap, int, boolean):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static int m15814a(BitmapFactory.Options options, int i, int i2) {
        int i3 = 1;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{options, new Integer(i), new Integer(i2)}, (Object) null, f13777a, true, 7849, new Class[]{BitmapFactory.Options.class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int b = m15869b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    /* renamed from: b */
    private static int m15869b(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{options, new Integer(i), new Integer(i2)}, (Object) null, f13777a, true, 7850, new Class[]{BitmapFactory.Options.class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        if (i2 < 0) {
            i3 = 1;
        } else {
            i3 = (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        }
        if (i < 0) {
            i4 = 128;
        } else {
            double d3 = (double) i;
            i4 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (i4 < i3) {
            return i3;
        }
        if (i2 >= 0 || i >= 0) {
            return i < 0 ? i3 : i4;
        }
        return 1;
    }

    /* renamed from: a */
    public static Bitmap m15821a(Bitmap bitmap, Matrix matrix) {
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, matrix}, (Object) null, changeQuickRedirect, true, 7851, new Class[]{Bitmap.class, Matrix.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap == null) {
            return null;
        }
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        } catch (OutOfMemoryError e) {
            LogUtil.m15950b(f13778b, "Got oom exception ", e);
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m15825a(byte[] bArr, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, new Integer(i)}, (Object) null, f13777a, true, 7852, new Class[]{byte[].class, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (!options.mCancel && options.outWidth != -1) {
                if (options.outHeight != -1) {
                    options.inSampleSize = m15814a(options, -1, i);
                    options.inJustDecodeBounds = false;
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                }
            }
            return null;
        } catch (OutOfMemoryError e) {
            LogUtil.m15950b(f13778b, "Got oom exception ", e);
            return null;
        }
    }

    /* renamed from: a */
    public static void m15853a(Closeable closeable) {
        if (!PatchProxy.proxy(new Object[]{closeable}, (Object) null, f13777a, true, 7853, new Class[]{Closeable.class}, Void.TYPE).isSupported && closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m15840a(final Activity activity, int i) {
        if (!PatchProxy.proxy(new Object[]{activity, new Integer(i)}, (Object) null, f13777a, true, 7857, new Class[]{Activity.class, Integer.TYPE}, Void.TYPE).isSupported) {
            C26221 r0 = new DialogInterface.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13803a;

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f13803a, false, 7945, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                        AlertDialog unused = CameraUtil.f13779c = null;
                        LogUtil.m15949b(CameraUtil.f13778b, "ErrorAndFinish");
                        if (ActivityManager.isUserAMonkey()) {
                            Process.killProcess(Process.myPid());
                        } else {
                            activity.finish();
                        }
                    }
                }
            };
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(R.style.Theme_CameraBase, typedValue, true);
            if (!activity.isDestroyed() && !activity.isFinishing()) {
                f13779c = new AlertDialog.Builder(activity).setCancelable(false).setMessage(i).setNeutralButton(R.string.dialog_ok, r0).setIcon(typedValue.resourceId).create();
                f13779c.setOwnerActivity(activity);
                f13779c.show();
                LogUtil.m15952c(f13778b, "showErrorAndFinish");
            }
        }
    }

    /* renamed from: a */
    public static void m15839a(Activity activity) {
        if (!PatchProxy.proxy(new Object[]{activity}, (Object) null, f13777a, true, 7858, new Class[]{Activity.class}, Void.TYPE).isSupported && f13779c != null && f13779c.getOwnerActivity() == activity) {
            f13779c.cancel();
            f13779c = null;
        }
    }

    /* renamed from: a */
    public static void m15841a(final Activity activity, int i, boolean z) {
        Object[] objArr = {activity, new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 7859, new Class[]{Activity.class, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (f13780d == null || !f13780d.isShowing() || f13782f != i) {
                m15908n();
                C26232 r0 = new DialogInterface.OnClickListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13805a;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f13805a, false, 7946, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                            activity.finish();
                        }
                    }
                };
                TypedValue typedValue = new TypedValue();
                activity.getTheme().resolveAttribute(R.style.Theme_CameraBase, typedValue, true);
                if (!activity.isDestroyed() && !activity.isFinishing()) {
                    f13782f = i;
                    AlertDialog.Builder message = new AlertDialog.Builder(activity).setCancelable(false).setMessage(i);
                    if (!z) {
                        r0 = null;
                    }
                    f13780d = message.setNeutralButton(R.string.dialog_ok, r0).setIcon(typedValue.resourceId).create();
                    f13780d.show();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m15842a(final Activity activity, int i, boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{activity, new Integer(i), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, (Object) null, f13777a, true, 7860, new Class[]{Activity.class, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (f13780d == null || !f13780d.isShowing() || f13782f != i) {
                m15908n();
                C26243 r0 = new DialogInterface.OnClickListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13807a;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f13807a, false, 7947, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                            activity.finish();
                        }
                    }
                };
                TypedValue typedValue = new TypedValue();
                activity.getTheme().resolveAttribute(R.style.Theme_CameraBase, typedValue, true);
                if (!activity.isDestroyed() && !activity.isFinishing()) {
                    f13782f = i;
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setCancelable(false);
                    builder.setMessage(i);
                    builder.setIcon(typedValue.resourceId);
                    int i2 = z ? R.string.mz_temperature_exit_dialog_btn : R.string.mz_temperature_dialog_know;
                    if (!z) {
                        r0 = null;
                    }
                    builder.setNeutralButton(i2, r0);
                    if (z2) {
                        builder.setNegativeButton(17039360, $$Lambda$CameraUtil$hfj7Zciz8xoDpqBXDX_o_CZ4VXI.INSTANCE);
                    }
                    f13780d = builder.create();
                    f13780d.show();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15848a(DialogInterface dialogInterface, int i) {
        if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, (Object) null, f13777a, true, 7944, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported && f13780d != null && f13780d.isShowing()) {
            f13780d.cancel();
        }
    }

    /* renamed from: n */
    public static void m15908n() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f13777a, true, 7861, new Class[0], Void.TYPE).isSupported && f13780d != null) {
            if (f13780d.isShowing()) {
                f13780d.cancel();
            }
            f13780d = null;
            f13782f = 0;
        }
    }

    /* renamed from: b */
    public static void m15877b(Activity activity, int i) {
        if (!PatchProxy.proxy(new Object[]{activity, new Integer(i)}, (Object) null, f13777a, true, 7862, new Class[]{Activity.class, Integer.TYPE}, Void.TYPE).isSupported) {
            C26254 r0 = new DialogInterface.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13809a;

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f13809a, false, 7948, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported && CameraUtil.f13781e != null && CameraUtil.f13781e.isShowing()) {
                        CameraUtil.f13781e.cancel();
                        AlertDialog unused = CameraUtil.f13781e = null;
                    }
                }
            };
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(R.style.Theme_CameraBase, typedValue, true);
            if (!activity.isDestroyed() && !activity.isFinishing()) {
                f13781e = new AlertDialog.Builder(activity).setCancelable(false).setMessage(i).setNeutralButton(R.string.dialog_ok, r0).setIcon(typedValue.resourceId).create();
                f13781e.show();
            }
        }
    }

    /* renamed from: o */
    public static void m15909o() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f13777a, true, 7863, new Class[0], Void.TYPE).isSupported && f13781e != null && f13781e.isShowing()) {
            f13781e.cancel();
            f13781e = null;
        }
    }

    /* renamed from: a */
    public static <T> T m15830a(T t) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{t}, (Object) null, f13777a, true, 7864, new Class[]{Object.class}, Object.class);
        if (proxy.isSupported) {
            return (Object) proxy.result;
        }
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("current object is null!!");
    }

    /* renamed from: a */
    public static boolean m15862a(Object obj, Object obj2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, obj2}, (Object) null, f13777a, true, 7865, new Class[]{Object.class, Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: b */
    public static int m15867b(Activity activity) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{activity}, (Object) null, f13777a, true, 7867, new Class[]{Activity.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                return 0;
        }
    }

    /* renamed from: c */
    public static boolean m15886c(Activity activity) {
        int i;
        int i2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{activity}, (Object) null, f13777a, true, 7868, new Class[]{Activity.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int rotation = defaultDisplay.getRotation();
        if (rotation == 0 || rotation == 2) {
            i = point.x;
            i2 = point.y;
        } else {
            i = point.y;
            i2 = point.x;
        }
        if (i < i2) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static int m15811a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7869, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int d = CameraController.m8868g().mo19505d(i2);
        if (i2 == 1) {
            return (360 - ((d + i) % 360)) % 360;
        }
        return ((d - i) + 360) % 360;
    }

    /* renamed from: b */
    public static int m15866b(int i, int i2) {
        boolean z = true;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, (Object) null, f13777a, true, 7871, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (i2 != -1) {
            int abs = Math.abs(i - i2);
            if (Math.min(abs, 360 - abs) < 65) {
                z = false;
            }
        }
        return z ? (((i + 30) / 90) * 90) % 360 : i2;
    }

    /* renamed from: a */
    private static Point m15826a(Activity activity, Point point) {
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{activity, point}, (Object) null, changeQuickRedirect, true, 7872, new Class[]{Activity.class, Point.class}, Point.class);
        if (proxy.isSupported) {
            return (Point) proxy.result;
        }
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        return point;
    }

    /* renamed from: a */
    public static String m15834a(Activity activity, List<Point> list, double d) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{activity, list, new Double(d)}, (Object) null, f13777a, true, 7873, new Class[]{Activity.class, List.class, Double.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        int a = m15813a(activity, (Point[]) list.toArray(new Point[list.size()]), d, true);
        if (a == -1) {
            return null;
        }
        Point point = list.get(a);
        return point.x + "x" + point.y;
    }

    /* renamed from: a */
    public static String m15835a(Activity activity, List<Point> list, double d, int i, int i2) {
        List<Point> list2 = list;
        double d2 = d;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{activity, list2, new Double(d2), new Integer(i), new Integer(i2)}, (Object) null, f13777a, true, 7874, new Class[]{Activity.class, List.class, Double.TYPE, Integer.TYPE, Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        Point[] pointArr = (Point[]) list2.toArray(new Point[list.size()]);
        int min = Math.min(i, i2);
        int i3 = -1;
        double d3 = Double.MAX_VALUE;
        for (int i4 = 0; i4 < pointArr.length; i4++) {
            Point point = pointArr[i4];
            if (Math.abs((((double) point.x) / ((double) point.y)) - d2) <= 0.02d && ((double) Math.abs(point.y - min)) < d3) {
                d3 = (double) Math.abs(point.y - min);
                i3 = i4;
            }
        }
        if (i3 == -1) {
            LogUtil.m15956e(f13778b, "No picture size match the aspect ratio");
            double d4 = Double.MAX_VALUE;
            for (int i5 = 0; i5 < pointArr.length; i5++) {
                Point point2 = pointArr[i5];
                if (((double) Math.abs(point2.y - min)) < d4) {
                    d4 = (double) Math.abs(point2.y - min);
                    i3 = i5;
                }
            }
        }
        return list2.get(i3).x + "x" + list2.get(i3).y;
    }

    /* renamed from: a */
    public static Point m15827a(Activity activity, List<Point> list, double d, boolean z, boolean z2) {
        int i;
        Activity activity2 = activity;
        List<Point> list2 = list;
        boolean z3 = z;
        boolean z4 = z2;
        double d2 = d;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{activity2, list2, new Double(d2), new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0)}, (Object) null, f13777a, true, 7875, new Class[]{Activity.class, List.class, Double.TYPE, Boolean.TYPE, Boolean.TYPE}, Point.class);
        if (proxy.isSupported) {
            return (Point) proxy.result;
        }
        Point[] pointArr = (Point[]) list2.toArray(new Point[list.size()]);
        if (CameraModeType.m10946a().equals(CameraModeType.ModeType.BARCODE)) {
            d2 = ((double) f13789m) / ((double) f13788l);
        }
        if (CameraModeType.m10946a().equals(CameraModeType.ModeType.GIF)) {
            i = m15870b(pointArr);
        } else if (CameraModeType.m10946a().equals(CameraModeType.ModeType.AR)) {
            Point point = list2.get(0);
            point.x = 1280;
            point.y = 720;
            return point;
        } else if ((CameraModeType.m10946a().equals(CameraModeType.ModeType.PORTRAIT) || CameraModeType.m10946a().equals(CameraModeType.ModeType.AUTO)) && DeviceHelper.f13826F) {
            Point point2 = list2.get(0);
            if (d2 - 1.3333333730697632d < 0.03d || CameraModeType.m10946a().equals(CameraModeType.ModeType.PORTRAIT)) {
                point2.x = 1440;
                point2.y = 1080;
            } else {
                point2.x = 1920;
                point2.y = 1080;
            }
            return point2;
        } else if (CameraModeType.m10946a().equals(CameraModeType.ModeType.PORTRAIT) && DeviceHelper.f14052v) {
            Point point3 = list2.get(0);
            point3.x = 1280;
            point3.y = 720;
            return point3;
        } else if (CameraModeType.m10946a().equals(CameraModeType.ModeType.FUNNY_SNAP)) {
            i = m15817a(pointArr, d2);
        } else if (CameraModeType.m10946a().equals(CameraModeType.ModeType.PANORAMA)) {
            i = m15816a(pointArr);
        } else if (DeviceHelper.f13840T && CameraModeType.m10946a().equals(CameraModeType.ModeType.SLOWMOTION)) {
            Point point4 = list2.get(0);
            point4.x = 1280;
            point4.y = 720;
            return point4;
        } else if (DeviceHelper.f13831K && (CameraModeType.m10946a().equals(CameraModeType.ModeType.MAKEUP) || z3)) {
            Point point5 = list2.get(0);
            if (d2 - 1.3333333730697632d < 0.03d) {
                point5.x = 1440;
                point5.y = 1080;
            } else {
                point5.x = 1920;
                point5.y = 1080;
            }
            return point5;
        } else if (!CameraModeType.m10946a().equals(CameraModeType.ModeType.MAKEUP) || !DeviceHelper.f13839S) {
            i = m15813a(activity2, pointArr, d2, z4);
        } else {
            Point point6 = list2.get(0);
            if (d2 - 1.3333333730697632d < 0.03d) {
                point6.x = 960;
                point6.y = 720;
            } else {
                point6.x = 1280;
                point6.y = 720;
            }
            return point6;
        }
        if (i == -1) {
            return null;
        }
        return list2.get(i);
    }

    /* renamed from: a */
    private static int m15816a(Point[] pointArr) {
        double d;
        int i;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{pointArr}, (Object) null, f13777a, true, 7876, new Class[]{Point[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (pointArr == null) {
            return -1;
        }
        if (!DeviceHelper.f13874aa) {
            d = 1.7777777910232544d;
        } else if (DeviceHelper.f13883aj) {
            d = (double) (((float) m15865b()) / ((float) m15809a()));
        } else {
            d = 2.0d;
        }
        if (pointArr[0].y < pointArr[pointArr.length - 1].y) {
            i = 0;
        } else {
            i = pointArr.length - 1;
        }
        int i2 = i;
        for (int i3 = 0; i3 < pointArr.length; i3++) {
            if (Math.abs(((double) Math.abs(((float) pointArr[i3].x) / ((float) pointArr[i3].y))) - d) <= 0.05d && pointArr[i3].x <= 3200 && pointArr[i3].y <= 2400 && pointArr[i3].x <= DeviceHelper.f13926bZ && pointArr[i3].y <= DeviceHelper.f13980ca && pointArr[i3].x * pointArr[i3].y > pointArr[i2].x * pointArr[i2].y) {
                i2 = i3;
            }
        }
        if (Math.abs(((double) (((float) pointArr[i2].x) / ((float) pointArr[i2].y))) - d) > 0.05d) {
            for (int i4 = 0; i4 < pointArr.length; i4++) {
                if ((((double) Math.abs((((float) pointArr[i4].x) / ((float) pointArr[i4].y)) - 1.7777778f)) <= 0.05d || ((double) Math.abs((((float) pointArr[i4].x) / ((float) pointArr[i4].y)) - 2.0f)) <= 0.05d) && (pointArr[i4].x * pointArr[i4].y > pointArr[i2].x * pointArr[i2].y || (((double) Math.abs((((float) pointArr[i2].x) / ((float) pointArr[i2].y)) - 1.7777778f)) > 0.05d && ((double) Math.abs((((float) pointArr[i2].x) / ((float) pointArr[i2].y)) - 2.0f)) > 0.05d && pointArr[i4].x <= 3200 && pointArr[i4].y <= 2400))) {
                    i2 = i4;
                }
            }
        }
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m15817a(android.graphics.Point[] r20, double r21) {
        /*
            r0 = r20
            r1 = r21
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r11 = 0
            r4[r11] = r0
            java.lang.Double r5 = new java.lang.Double
            r5.<init>(r1)
            r6 = 1
            r4[r6] = r5
            com.meizu.savior.ChangeQuickRedirect r7 = f13777a
            java.lang.Class[] r9 = new java.lang.Class[r3]
            java.lang.Class<android.graphics.Point[]> r3 = android.graphics.Point[].class
            r9[r11] = r3
            java.lang.Class r3 = java.lang.Double.TYPE
            r9[r6] = r3
            java.lang.Class r10 = java.lang.Integer.TYPE
            r5 = 0
            r3 = 1
            r8 = 7877(0x1ec5, float:1.1038E-41)
            r6 = r7
            r7 = r3
            com.meizu.savior.PatchProxyResult r3 = com.meizu.savior.PatchProxy.proxy(r4, r5, r6, r7, r8, r9, r10)
            boolean r4 = r3.isSupported
            if (r4 == 0) goto L_0x0037
            java.lang.Object r0 = r3.result
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        L_0x0037:
            r3 = -1
            if (r0 != 0) goto L_0x003b
            return r3
        L_0x003b:
            r4 = 4608683618854764544(0x3ff5555560000000, double:1.3333333730697632)
            double r4 = r1 - r4
            r6 = 4584304132692975288(0x3f9eb851eb851eb8, double:0.03)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x004e
            r4 = 960(0x3c0, float:1.345E-42)
            goto L_0x005e
        L_0x004e:
            r4 = 4610685218569846784(0x3ffc71c720000000, double:1.7777777910232544)
            double r4 = r1 - r4
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x005c
            r4 = 1280(0x500, float:1.794E-42)
            goto L_0x005e
        L_0x005c:
            r4 = 1440(0x5a0, float:2.018E-42)
        L_0x005e:
            r5 = 720(0x2d0, float:1.009E-42)
            int r4 = java.lang.Math.min(r4, r5)
            r5 = 0
            r10 = -1
            r12 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L_0x006b:
            int r14 = r0.length
            if (r5 >= r14) goto L_0x00a0
            r14 = r0[r5]
            int r15 = r14.x
            double r8 = (double) r15
            int r15 = r14.y
            r18 = r12
            double r11 = (double) r15
            double r8 = r8 / r11
            double r8 = r8 - r1
            double r8 = java.lang.Math.abs(r8)
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0083
            goto L_0x009a
        L_0x0083:
            int r8 = r14.y
            int r8 = r8 - r4
            int r8 = java.lang.Math.abs(r8)
            double r8 = (double) r8
            int r8 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r8 >= 0) goto L_0x009a
            int r8 = r14.y
            int r8 = r8 - r4
            int r8 = java.lang.Math.abs(r8)
            double r8 = (double) r8
            r10 = r5
            r12 = r8
            goto L_0x009c
        L_0x009a:
            r12 = r18
        L_0x009c:
            int r5 = r5 + 1
            r11 = 0
            goto L_0x006b
        L_0x00a0:
            if (r10 != r3) goto L_0x00ce
            com.meizu.media.camera.util.ac$a r1 = f13778b
            java.lang.String r2 = "No preview size match the aspect ratio for funnySnap"
            com.meizu.media.camera.util.LogUtil.m15956e(r1, r2)
            r1 = 0
            r16 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L_0x00af:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x00ce
            r2 = r0[r1]
            int r3 = r2.y
            int r3 = r3 - r4
            int r3 = java.lang.Math.abs(r3)
            double r5 = (double) r3
            int r3 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x00cb
            int r2 = r2.y
            int r2 = r2 - r4
            int r2 = java.lang.Math.abs(r2)
            double r2 = (double) r2
            r10 = r1
            r16 = r2
        L_0x00cb:
            int r1 = r1 + 1
            goto L_0x00af
        L_0x00ce:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.CameraUtil.m15817a(android.graphics.Point[], double):int");
    }

    /* renamed from: b */
    private static int m15870b(Point[] pointArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{pointArr}, (Object) null, f13777a, true, 7878, new Class[]{Point[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (pointArr == null) {
            return -1;
        }
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = 0;
        for (int i3 = 0; i3 < pointArr.length; i3++) {
            int abs = Math.abs((pointArr[i3].x * pointArr[i3].y) - 480000);
            if (abs == i) {
                return i3;
            }
            if (abs < i) {
                i = abs;
                i2 = i3;
            }
        }
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m15813a(android.app.Activity r18, android.graphics.Point[] r19, double r20, boolean r22) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            r4 = r22
            r5 = 4
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r13 = 0
            r6[r13] = r0
            r7 = 1
            r6[r7] = r1
            java.lang.Double r8 = new java.lang.Double
            r8.<init>(r2)
            r9 = 2
            r6[r9] = r8
            java.lang.Byte r8 = new java.lang.Byte
            r8.<init>(r4)
            r10 = 3
            r6[r10] = r8
            com.meizu.savior.ChangeQuickRedirect r8 = f13777a
            java.lang.Class[] r11 = new java.lang.Class[r5]
            java.lang.Class<android.app.Activity> r5 = android.app.Activity.class
            r11[r13] = r5
            java.lang.Class<android.graphics.Point[]> r5 = android.graphics.Point[].class
            r11[r7] = r5
            java.lang.Class r5 = java.lang.Double.TYPE
            r11[r9] = r5
            java.lang.Class r5 = java.lang.Boolean.TYPE
            r11[r10] = r5
            java.lang.Class r12 = java.lang.Integer.TYPE
            r7 = 0
            r9 = 1
            r10 = 7879(0x1ec7, float:1.1041E-41)
            com.meizu.savior.PatchProxyResult r5 = com.meizu.savior.PatchProxy.proxy(r6, r7, r8, r9, r10, r11, r12)
            boolean r6 = r5.isSupported
            if (r6 == 0) goto L_0x004c
            java.lang.Object r0 = r5.result
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        L_0x004c:
            r5 = -1
            if (r1 != 0) goto L_0x0050
            return r5
        L_0x0050:
            android.graphics.Point r6 = new android.graphics.Point
            r6.<init>()
            android.graphics.Point r0 = m15826a((android.app.Activity) r0, (android.graphics.Point) r6)
            int r6 = r0.x
            int r0 = r0.y
            int r0 = java.lang.Math.min(r6, r0)
            r8 = 0
            r9 = -1
            r10 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L_0x0068:
            int r12 = r1.length
            if (r8 >= r12) goto L_0x00ab
            r12 = r1[r8]
            int r14 = r12.x
            double r14 = (double) r14
            int r6 = r12.y
            double r6 = (double) r6
            double r14 = r14 / r6
            double r14 = r14 - r2
            double r6 = java.lang.Math.abs(r14)
            r14 = 4584304132692975288(0x3f9eb851eb851eb8, double:0.03)
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x0083
            goto L_0x00a8
        L_0x0083:
            if (r4 == 0) goto L_0x0092
            int r6 = r12.x
            int r6 = r6 % 16
            if (r6 != 0) goto L_0x00a8
            int r6 = r12.y
            int r6 = r6 % 16
            if (r6 == 0) goto L_0x0092
            goto L_0x00a8
        L_0x0092:
            int r6 = r12.y
            int r6 = r6 - r0
            int r6 = java.lang.Math.abs(r6)
            double r6 = (double) r6
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 >= 0) goto L_0x00a8
            int r6 = r12.y
            int r6 = r6 - r0
            int r6 = java.lang.Math.abs(r6)
            double r6 = (double) r6
            r10 = r6
            r9 = r8
        L_0x00a8:
            int r8 = r8 + 1
            goto L_0x0068
        L_0x00ab:
            if (r9 != r5) goto L_0x00d8
            com.meizu.media.camera.util.ac$a r2 = f13778b
            java.lang.String r3 = "No preview size match the aspect ratio"
            com.meizu.media.camera.util.LogUtil.m15956e(r2, r3)
            r16 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L_0x00b9:
            int r2 = r1.length
            if (r13 >= r2) goto L_0x00d8
            r2 = r1[r13]
            int r3 = r2.y
            int r3 = r3 - r0
            int r3 = java.lang.Math.abs(r3)
            double r3 = (double) r3
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x00d5
            int r2 = r2.y
            int r2 = r2 - r0
            int r2 = java.lang.Math.abs(r2)
            double r2 = (double) r2
            r16 = r2
            r9 = r13
        L_0x00d5:
            int r13 = r13 + 1
            goto L_0x00b9
        L_0x00d8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.CameraUtil.m15813a(android.app.Activity, android.graphics.Point[], double, boolean):int");
    }

    /* renamed from: a */
    public static Camera.Size m15828a(List<Camera.Size> list, double d) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{list, new Double(d)}, (Object) null, f13777a, true, 7881, new Class[]{List.class, Double.TYPE}, Camera.Size.class);
        if (proxy.isSupported) {
            return (Camera.Size) proxy.result;
        }
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        for (Camera.Size next : list) {
            if (next.width == m15903i()) {
                size = next;
            }
        }
        if (size == null) {
            for (Camera.Size next2 : list) {
                if (!(next2.width == 0 && next2.height == 0) && Math.abs((((double) next2.width) / ((double) next2.height)) - d) <= 0.15d) {
                    if (size == null || next2.width > size.width) {
                        size = next2;
                    }
                }
            }
        }
        return size;
    }

    /* renamed from: a */
    public static boolean m15856a(float f, float f2, View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f), new Float(f2), view}, (Object) null, f13777a, true, 7885, new Class[]{Float.TYPE, Float.TYPE, View.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        view.getLocationInWindow(f13774A);
        if (f < ((float) f13774A[0]) || f >= ((float) (f13774A[0] + view.getWidth())) || f2 < ((float) f13774A[1]) || f2 >= ((float) (f13774A[1] + view.getHeight()))) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m15859a(Uri uri, ContentResolver contentResolver) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uri, contentResolver}, (Object) null, f13777a, true, 7887, new Class[]{Uri.class, ContentResolver.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (uri == null) {
            return false;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            if (openFileDescriptor == null) {
                LogUtil.C2630a aVar = f13778b;
                LogUtil.m15949b(aVar, "Fail to open URI. pfd is null, URI=" + uri);
                return false;
            }
            openFileDescriptor.close();
            return true;
        } catch (IOException unused) {
            LogUtil.C2630a aVar2 = f13778b;
            LogUtil.m15949b(aVar2, "Fail to open URI. IOException, URI=" + uri);
            return false;
        } catch (NullPointerException e) {
            LogUtil.C2630a aVar3 = f13778b;
            LogUtil.m15950b(aVar3, "Fail to check URI. URI=" + uri, e);
            return false;
        } catch (IllegalStateException e2) {
            LogUtil.C2630a aVar4 = f13778b;
            LogUtil.m15950b(aVar4, "IllegalStateException during check URI=" + uri, e2);
            return false;
        }
    }

    /* renamed from: a */
    public static void m15850a(RectF rectF, Rect rect) {
        Class[] clsArr = {RectF.class, Rect.class};
        if (!PatchProxy.proxy(new Object[]{rectF, rect}, (Object) null, f13777a, true, 7889, clsArr, Void.TYPE).isSupported && rect != null && rectF != null) {
            rect.left = Math.round(rectF.left);
            rect.top = Math.round(rectF.top);
            rect.right = Math.round(rectF.right);
            rect.bottom = Math.round(rectF.bottom);
        }
    }

    /* renamed from: a */
    public static void m15849a(Matrix matrix, boolean z, boolean z2, int i, int i2, int i3) {
        if (!PatchProxy.proxy(new Object[]{matrix, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3)}, (Object) null, f13777a, true, 7890, new Class[]{Matrix.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            float f = 1.0f;
            float f2 = z ? -1.0f : 1.0f;
            if (z2) {
                f = -1.0f;
            }
            matrix.setScale(f2, f);
            matrix.postRotate((float) i);
            float f3 = (float) i2;
            float f4 = (float) i3;
            matrix.postScale(f3 / 2000.0f, f4 / 2000.0f);
            matrix.postTranslate(f3 / 2.0f, f4 / 2.0f);
        }
    }

    /* renamed from: a */
    public static String m15831a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7891, new Class[]{Long.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        synchronized (f13797u) {
            if (f13798v.containsKey(Long.valueOf(j))) {
                String str = f13798v.get(Long.valueOf(j));
                return str;
            }
            String b = f13797u.mo22632b(j);
            f13798v.put(Long.valueOf(j), b);
            return b;
        }
    }

    /* renamed from: b */
    public static String m15874b(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7892, new Class[]{Long.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        synchronized (f13797u) {
            if (f13798v.containsKey(Long.valueOf(j))) {
                String str = f13798v.get(Long.valueOf(j));
                return str;
            }
            String a = f13797u.mo22630a(j);
            f13798v.put(Long.valueOf(j), a);
            return a;
        }
    }

    /* renamed from: a */
    public static String m15832a(long j, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j), new Integer(i)}, (Object) null, f13777a, true, 7893, new Class[]{Long.TYPE, Integer.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : f13797u.mo22631a(j, i);
    }

    /* renamed from: c */
    public static String m15883c(long j) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j)}, (Object) null, f13777a, true, 7894, new Class[]{Long.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : f13797u.mo22633c(j);
    }

    /* renamed from: b */
    public static String m15875b(long j, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j), new Integer(i)}, (Object) null, f13777a, true, 7895, new Class[]{Long.TYPE, Integer.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : f13797u.mo22631a(j, i);
    }

    /* renamed from: d */
    public static String m15890d(long j) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j)}, (Object) null, f13777a, true, 7896, new Class[]{Long.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : f13797u.mo22633c(j);
    }

    /* renamed from: c */
    public static String m15884c(long j, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j), new Integer(i)}, (Object) null, f13777a, true, 7897, new Class[]{Long.TYPE, Integer.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : f13797u.mo22631a(j, i - 1);
    }

    /* renamed from: a */
    public static void m15844a(Context context, Uri uri) {
        Class[] clsArr = {Context.class, Uri.class};
        if (!PatchProxy.proxy(new Object[]{context, uri}, (Object) null, f13777a, true, 7898, clsArr, Void.TYPE).isSupported) {
            context.sendBroadcast(new Intent("android.hardware.action.NEW_PICTURE", uri));
            context.sendBroadcast(new Intent("com.android.camera.NEW_PICTURE", uri));
        }
    }

    /* renamed from: b */
    public static void m15878b(Context context, Uri uri) {
        Class[] clsArr = {Context.class, Uri.class};
        if (!PatchProxy.proxy(new Object[]{context, uri}, (Object) null, f13777a, true, 7899, clsArr, Void.TYPE).isSupported && uri != null && context != null) {
            Intent intent = new Intent("com.meizu.media.gallery.saveImage");
            intent.setPackage("com.meizu.media.gallery");
            intent.putExtra("imageUri", uri.toString());
            context.sendBroadcast(intent);
            LogUtil.C2630a aVar = f13778b;
            LogUtil.m15942a(aVar, "sendBroadcastGallery uri:" + uri.toString());
        }
    }

    /* renamed from: a */
    public static void m15845a(Context context, String str) {
        Class[] clsArr = {Context.class, String.class};
        if (!PatchProxy.proxy(new Object[]{context, str}, (Object) null, f13777a, true, 7901, clsArr, Void.TYPE).isSupported && context != null) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(str)));
            intent.setPackage("com.meizu.media.gallery");
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: a */
    public static void m15851a(View view, float f, float f2, long j) {
        Object[] objArr = {view, new Float(f), new Float(f2), new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 7902, new Class[]{View.class, Float.TYPE, Float.TYPE, Long.TYPE}, Void.TYPE).isSupported && view.getVisibility() != 0) {
            view.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
            alphaAnimation.setDuration(j);
            view.startAnimation(alphaAnimation);
        }
    }

    /* renamed from: a */
    public static void m15852a(View view, int i) {
        if (!PatchProxy.proxy(new Object[]{view, new Integer(i)}, (Object) null, f13777a, true, 7903, new Class[]{View.class, Integer.TYPE}, Void.TYPE).isSupported) {
            m15851a(view, 0.0f, 1.0f, (long) i);
            view.setEnabled(true);
        }
    }

    /* renamed from: b */
    public static void m15879b(View view, int i) {
        Object[] objArr = {view, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 7904, new Class[]{View.class, Integer.TYPE}, Void.TYPE).isSupported && view.getVisibility() == 0) {
            view.setEnabled(false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration((long) i);
            view.startAnimation(alphaAnimation);
            view.setVisibility(8);
        }
    }

    /* renamed from: c */
    public static int m15882c(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7905, new Class[]{Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (i2 == -1) {
            return 0;
        }
        if (CameraController.m8868g().mo19481a(i)) {
            return ((CameraController.m8868g().mo19505d(i) - i2) + 360) % 360;
        }
        return (CameraController.m8868g().mo19505d(i) + i2) % 360;
    }

    /* renamed from: b */
    public static Bitmap m15873b(byte[] bArr, int i) {
        Object[] objArr = {bArr, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7906, new Class[]{byte[].class, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (OutOfMemoryError e) {
            LogUtil.m15950b(f13778b, "Got oom exception ", e);
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m15824a(byte[] bArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr}, (Object) null, f13777a, true, 7907, new Class[]{byte[].class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (!options.mCancel && options.outWidth != -1) {
                if (options.outHeight != -1) {
                    options.inSampleSize = m15814a(options, -1, f13788l * f13789m);
                    options.inJustDecodeBounds = false;
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                }
            }
            return null;
        } catch (OutOfMemoryError e) {
            LogUtil.m15950b(f13778b, "Got oom exception ", e);
            return null;
        }
    }

    /* renamed from: p */
    public static int[] m15910p() {
        CameraProxy k;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f13777a, true, 7909, new Class[0], int[].class);
        if (proxy.isSupported) {
            return (int[]) proxy.result;
        }
        List<int[]> list = null;
        int[] iArr = new int[2];
        if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && (k = CameraController.m8868g().mo19522k()) != null) {
            list = ((CameraProxyV1) k).mo19740f().getSupportedPreviewFpsRange();
        }
        if (list == null || list.size() == 0) {
            LogUtil.m15949b(f13778b, "No suppoted frame rates returned!");
            return iArr;
        }
        int i = 400000;
        for (int[] next : list) {
            int i2 = next[0];
            if (next[1] >= 30000 && i2 <= 30000 && i2 < i) {
                i = i2;
            }
        }
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            int[] iArr2 = list.get(i5);
            int i6 = iArr2[0];
            int i7 = iArr2[1];
            if (i6 == i && i4 < i7) {
                i3 = i5;
                i4 = i7;
            }
        }
        if (i3 >= 0) {
            return list.get(i3);
        }
        LogUtil.m15949b(f13778b, "Can't find an appropiate frame rate range!");
        return iArr;
    }

    /* renamed from: q */
    public static String m15911q() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f13777a, true, 7911, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        String value = DeviceHelper.f14038h.getValue();
        List<HashMap<Integer, Size>> G = CameraController.m8868g().mo19443G();
        if (G != null) {
            for (HashMap<Integer, Size> containsKey : G) {
                if (containsKey.containsKey(240)) {
                    value = "240";
                }
            }
        }
        return value;
    }

    /* renamed from: com.meizu.media.camera.util.CameraUtil$a */
    private static class C2626a {

        /* renamed from: a */
        public static ChangeQuickRedirect f13810a;

        /* renamed from: b */
        private final SimpleDateFormat f13811b;

        /* renamed from: c */
        private SimpleDateFormat f13812c;

        /* renamed from: d */
        private long f13813d;

        /* renamed from: e */
        private int f13814e;

        public C2626a(String str, String str2) {
            this.f13811b = new SimpleDateFormat(str, Locale.ENGLISH);
            this.f13812c = new SimpleDateFormat(str2, Locale.ENGLISH);
        }

        /* renamed from: a */
        public String mo22630a(long j) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j)}, this, f13810a, false, 7949, new Class[]{Long.TYPE}, String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            String format = this.f13811b.format(new Date(j));
            this.f13813d = j;
            this.f13814e = 0;
            if (TextUtils.isEmpty(format) || format.indexOf("P") < 0) {
                return format;
            }
            String substring = format.substring(0, 1);
            String substring2 = format.substring(4, format.length());
            return substring + substring2;
        }

        /* renamed from: b */
        public String mo22632b(long j) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j)}, this, f13810a, false, 7950, new Class[]{Long.TYPE}, String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            String format = this.f13811b.format(new Date(j));
            if (j / 1000 == this.f13813d / 1000) {
                this.f13814e++;
                format = format + "_" + this.f13814e;
            } else {
                this.f13813d = j;
                this.f13814e = 0;
            }
            if (TextUtils.isEmpty(format) || format.indexOf("P") < 0) {
                return format;
            }
            return format.substring(0, 1) + format.substring(4, format.length());
        }

        /* renamed from: a */
        public String mo22631a(long j, int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j), new Integer(i)}, this, f13810a, false, 7951, new Class[]{Long.TYPE, Integer.TYPE}, String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            String format = this.f13811b.format(new Date(j));
            if (!TextUtils.isEmpty(format) && format.indexOf("P") >= 0) {
                format = format.substring(0, 1) + format.substring(4, format.length());
            }
            if (i < 10) {
                return format + "-0" + i;
            }
            return format + "-" + i;
        }

        /* renamed from: c */
        public String mo22633c(long j) {
            Object[] objArr = {new Long(j)};
            ChangeQuickRedirect changeQuickRedirect = f13810a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 7952, new Class[]{Long.TYPE}, String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            return this.f13812c.format(new Date(j));
        }
    }

    /* renamed from: a */
    public static Bitmap m15823a(Bitmap bitmap, boolean... zArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, zArr}, (Object) null, f13777a, true, 7917, new Class[]{Bitmap.class, boolean[].class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(bitmap, f13793q, f13793q);
        Bitmap createBitmap = Bitmap.createBitmap(extractThumbnail.getWidth(), extractThumbnail.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (f13775B == null) {
            f13775B = new Paint();
            f13775B.setAntiAlias(true);
        }
        Rect rect = new Rect(0, 0, extractThumbnail.getWidth(), extractThumbnail.getHeight());
        canvas.drawARGB(0, 0, 0, 0);
        f13775B.setXfermode((Xfermode) null);
        canvas.drawCircle((float) (extractThumbnail.getWidth() / 2), (float) (extractThumbnail.getHeight() / 2), (float) (extractThumbnail.getWidth() / 2), f13775B);
        f13775B.setXfermode(f13776C);
        canvas.drawBitmap(extractThumbnail, rect, rect, f13775B);
        return createBitmap;
    }

    /* renamed from: a */
    public static ArrayList<String> m15836a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f13777a, true, 7918, new Class[]{String.class}, ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        if (str == null) {
            LogUtil.m15942a(f13778b, "split null");
            return null;
        }
        TextUtils.SimpleStringSplitter<String> simpleStringSplitter = new TextUtils.SimpleStringSplitter<>(',');
        simpleStringSplitter.setString(str);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String add : simpleStringSplitter) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static ArrayList<Integer> m15837a(ArrayList<String> arrayList, String[] strArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{arrayList, strArr}, (Object) null, f13777a, true, 7919, new Class[]{ArrayList.class, String[].class}, ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        if (arrayList == null) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (String indexOf : strArr) {
            int indexOf2 = arrayList.indexOf(indexOf);
            if (indexOf2 != -1) {
                arrayList2.add(Integer.valueOf(indexOf2));
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    public static void m15846a(Context context, String str, String str2, boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{context, str, str2, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, (Object) null, f13777a, true, 7922, new Class[]{Context.class, String.class, String.class, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if ("pref_camera_flashmode_key".equals(str)) {
                if (String.valueOf(CameraController.FlashMode.FLASH_MODE_OFF.getIndex(false, z2)).equals(str2)) {
                    str2 = CameraController.FlashMode.FLASH_MODE_OFF.key;
                } else {
                    if (String.valueOf(CameraController.FlashMode.FLASH_MODE_ON.getIndex(false, z2)).equals(str2)) {
                        str2 = CameraController.FlashMode.FLASH_MODE_AUTO.key;
                    } else {
                        if (String.valueOf(CameraController.FlashMode.FLASH_MODE_AUTO.getIndex(false, z2)).equals(str2)) {
                            str2 = CameraController.FlashMode.FLASH_MODE_ON.key;
                        } else {
                            if (String.valueOf(CameraController.FlashMode.FLASH_MODE_TORCH.getIndex(false, z2)).equals(str2)) {
                                str2 = CameraController.FlashMode.FLASH_MODE_TORCH.key;
                            }
                        }
                    }
                }
            }
            if ("pref_camera_timer_key".equals(str)) {
                if ("1".equals(str2)) {
                    str2 = ExifInterface.GPS_MEASUREMENT_3D;
                } else if ("2".equals(str2)) {
                    str2 = "10";
                }
            }
            UsageStatsHelper.m16042a(context).mo22690a(str, str2);
            if (z) {
                String y = UsageStatsHelper.m16056y(str);
                Map<String, String> a = UsageStatsHelper.m16042a(context).mo22688a(UsageStatsHelper.m16057z(y));
                if (str2 != null) {
                    a.put("value", str2);
                }
                UsageStatsHelper.m16042a(context).mo22693a(y, a);
            }
        }
    }

    /* renamed from: a */
    public static void m15847a(Context context, String str, boolean z) {
        if (!PatchProxy.proxy(new Object[]{context, str, new Byte(z ? (byte) 1 : 0)}, (Object) null, f13777a, true, 7923, new Class[]{Context.class, String.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            UsageStatsHelper.m16042a(context).mo22690a(str, Boolean.toString(z));
            String y = UsageStatsHelper.m16056y(str);
            Map<String, String> a = UsageStatsHelper.m16042a(context).mo22688a(UsageStatsHelper.m16057z(y));
            a.put("enable", z ? "1" : "0");
            UsageStatsHelper.m16042a(context).mo22693a(y, a);
        }
    }

    /* renamed from: r */
    public static int m15912r() {
        return f13795s;
    }

    /* renamed from: b */
    public static void m15876b(int i) {
        f13783g = i;
    }

    /* renamed from: s */
    public static int m15913s() {
        return f13783g;
    }

    /* renamed from: t */
    public static boolean m15914t() {
        return f13784h;
    }

    /* renamed from: a */
    public static void m15854a(boolean z) {
        f13784h = z;
    }

    /* renamed from: a */
    public static ScreeAspectRatio m15829a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7924, new Class[]{Float.TYPE}, ScreeAspectRatio.class);
        if (proxy.isSupported) {
            return (ScreeAspectRatio) proxy.result;
        }
        if (((double) Math.abs(f - 2.0f)) < 0.1d) {
            return ScreeAspectRatio.Ratio_18_9;
        }
        if (((double) Math.abs(f - 1.7777778f)) < 0.1d) {
            return ScreeAspectRatio.Ratio_16_9;
        }
        if (((double) Math.abs(f - 1.3333334f)) < 0.1d) {
            return ScreeAspectRatio.Ratio_4_3;
        }
        if (((double) Math.abs(f - 1.5f)) < 0.1d) {
            return ScreeAspectRatio.Ratio_3_2;
        }
        if (!DeviceHelper.f13874aa || !DeviceHelper.f13883aj || ((double) Math.abs(f - (((float) m15865b()) / ((float) m15809a())))) >= 0.1d) {
            return ScreeAspectRatio.Ratio_Unknow;
        }
        return ScreeAspectRatio.Ratio_18X_9_FullScreen;
    }

    /* renamed from: d */
    public static FrameLayout m15889d(Activity activity) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{activity}, (Object) null, f13777a, true, 7926, new Class[]{Activity.class}, FrameLayout.class);
        return proxy.isSupported ? (FrameLayout) proxy.result : (FrameLayout) activity.getWindow().getDecorView().findViewById(16908290);
    }

    /* renamed from: a */
    public static boolean m15860a(ViewGroup viewGroup, Object obj) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, obj}, (Object) null, f13777a, true, 7927, new Class[]{ViewGroup.class, Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (viewGroup.findViewWithTag(obj) == null) {
            return false;
        }
        viewGroup.removeView(viewGroup.findViewWithTag(obj));
        return true;
    }

    /* renamed from: a */
    public static boolean m15857a(Context context, String str, int i) {
        Object[] objArr = {context, str, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7928, new Class[]{Context.class, String.class, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        try {
            int i2 = context.getPackageManager().getPackageInfo(str, 0).versionCode;
            LogUtil.C2630a aVar = f13778b;
            LogUtil.m15942a(aVar, str + " 's version code: " + i2);
            if (i2 >= i) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static int m15815a(float[] fArr, float[] fArr2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fArr, fArr2}, (Object) null, f13777a, true, 7929, new Class[]{float[].class, float[].class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i = 0; i < 3; i++) {
            f += fArr[i] * fArr2[i];
            f2 += fArr[i] * fArr[i];
            f3 += fArr2[i] * fArr2[i];
        }
        return (int) ((float) Math.toDegrees(Math.acos((double) (f / (((float) Math.sqrt((double) f2)) * ((float) Math.sqrt((double) f3)))))));
    }

    /* renamed from: u */
    public static boolean m15915u() {
        boolean z = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f13777a, true, 7930, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (f13788l * 2 < f13789m && !DeviceHelper.f13883aj) {
            z = true;
            f13800x = f13789m - (f13788l * 2);
        }
        LogUtil.C2630a aVar = f13778b;
        LogUtil.m15942a(aVar, "init Device isNotchDisplay:" + z + ", sNotchMarginTop:" + f13800x);
        return z;
    }

    /* renamed from: v */
    public static boolean m15916v() {
        return f13799w;
    }

    /* renamed from: e */
    public static void m15895e(Activity activity) {
        if (!PatchProxy.proxy(new Object[]{activity}, (Object) null, f13777a, true, 7931, new Class[]{Activity.class}, Void.TYPE).isSupported) {
            Resources resources = activity.getResources();
            Configuration configuration = activity.getResources().getConfiguration();
            configuration.fontScale = 1.0f;
            configuration.densityDpi = SystemProperties.getInt("persist.sys.density", SystemProperties.getInt("ro.sf.lcd_density", 480).intValue()).intValue();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x007a A[SYNTHETIC, Splitter:B:38:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f A[Catch:{ IOException -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c A[SYNTHETIC, Splitter:B:47:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0094 A[Catch:{ IOException -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f A[SYNTHETIC, Splitter:B:57:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a7 A[Catch:{ IOException -> 0x00a3 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0075=Splitter:B:35:0x0075, B:44:0x0087=Splitter:B:44:0x0087} */
    /* renamed from: w */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m15917w() {
        /*
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f13777a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Long.TYPE
            r2 = 0
            r4 = 1
            r5 = 7932(0x1efc, float:1.1115E-41)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x001e
            java.lang.Object r0 = r0.result
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            return r0
        L_0x001e:
            r0 = -1
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x0071, all -> 0x006d }
            java.lang.String r4 = "/proc/meminfo"
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x0071, all -> 0x006d }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0063, all -> 0x0060 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0063, all -> 0x0060 }
            java.lang.String r2 = r4.readLine()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c }
            if (r2 == 0) goto L_0x0050
            java.lang.String r5 = "\\s+"
            java.lang.String[] r2 = r2.split(r5)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c }
            r5 = 1
            r2 = r2[r5]     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c }
            long r5 = r2.longValue()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005c }
            r3.close()     // Catch:{ IOException -> 0x004b }
            r4.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004f:
            return r5
        L_0x0050:
            r3.close()     // Catch:{ IOException -> 0x0057 }
            r4.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r2 = move-exception
            r2.printStackTrace()
        L_0x005b:
            return r0
        L_0x005c:
            r2 = move-exception
            goto L_0x0075
        L_0x005e:
            r2 = move-exception
            goto L_0x0087
        L_0x0060:
            r0 = move-exception
            r4 = r2
            goto L_0x009d
        L_0x0063:
            r4 = move-exception
            r8 = r4
            r4 = r2
            r2 = r8
            goto L_0x0075
        L_0x0068:
            r4 = move-exception
            r8 = r4
            r4 = r2
            r2 = r8
            goto L_0x0087
        L_0x006d:
            r0 = move-exception
            r3 = r2
            r4 = r3
            goto L_0x009d
        L_0x0071:
            r3 = move-exception
            r4 = r2
            r2 = r3
            r3 = r4
        L_0x0075:
            r2.printStackTrace()     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x007d
            r3.close()     // Catch:{ IOException -> 0x0090 }
        L_0x007d:
            if (r4 == 0) goto L_0x009b
            r4.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x009b
        L_0x0083:
            r3 = move-exception
            r4 = r2
            r2 = r3
            r3 = r4
        L_0x0087:
            r2.printStackTrace()     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x0092
            r3.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0092
        L_0x0090:
            r2 = move-exception
            goto L_0x0098
        L_0x0092:
            if (r4 == 0) goto L_0x009b
            r4.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x009b
        L_0x0098:
            r2.printStackTrace()
        L_0x009b:
            return r0
        L_0x009c:
            r0 = move-exception
        L_0x009d:
            if (r3 == 0) goto L_0x00a5
            r3.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a5
        L_0x00a3:
            r1 = move-exception
            goto L_0x00ab
        L_0x00a5:
            if (r4 == 0) goto L_0x00ae
            r4.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00ae
        L_0x00ab:
            r1.printStackTrace()
        L_0x00ae:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.CameraUtil.m15917w():long");
    }

    /* renamed from: a */
    public static String m15833a(long j, boolean z) {
        long j2 = j;
        boolean z2 = z;
        Object[] objArr = {new Long(j2), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7933, new Class[]{Long.TYPE, Boolean.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        long j3 = j2 / 1000;
        long j4 = j3 / 60;
        long j5 = j4 / 60;
        long j6 = j4 - (j5 * 60);
        long j7 = j3 - (j4 * 60);
        StringBuilder sb = new StringBuilder();
        int i = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i > 0) {
            if (j5 < 10) {
                sb.append('0');
            }
            sb.append(j5);
            sb.append(SystemInfoUtil.COLON);
        } else if (i == 0) {
            sb.append("00");
            sb.append(SystemInfoUtil.COLON);
        }
        if (j6 < 10) {
            sb.append('0');
        }
        sb.append(j6);
        sb.append(SystemInfoUtil.COLON);
        if (j7 < 10) {
            sb.append('0');
        }
        sb.append(j7);
        if (z2) {
            sb.append('.');
            long j8 = (j2 - (j3 * 1000)) / 10;
            if (j8 < 10) {
                sb.append('0');
            }
            sb.append(j8);
        }
        return sb.toString();
    }

    /* renamed from: e */
    public static String m15894e(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7934, new Class[]{Long.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        long j2 = j / 1000;
        long j3 = j2 / 60;
        StringBuilder sb = new StringBuilder();
        if (j3 < 10) {
            sb.append('0');
        }
        sb.append(j3);
        sb.append(SystemInfoUtil.COLON);
        long j4 = j2 - (j3 * 60);
        if (j4 < 10) {
            sb.append('0');
        }
        sb.append(j4);
        return sb.toString();
    }

    /* renamed from: a */
    public static List<Point> m15838a(List<Point> list, List<Point> list2) {
        ChangeQuickRedirect changeQuickRedirect = f13777a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{list, list2}, (Object) null, changeQuickRedirect, true, 7935, new Class[]{List.class, List.class}, List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (!(list == null || list2 == null)) {
            list.clear();
            for (Point next : list2) {
                list.add(new Point(next.x, next.y));
            }
        }
        return list;
    }

    /* renamed from: x */
    public static String m15918x() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f13777a, true, 7936, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (CameraModeType.m10983m(CameraModeType.ModeType.SUPER_NIGHT)) {
            return "processing_supernight";
        }
        if (CameraModeType.m10983m(CameraModeType.ModeType.PORTRAIT)) {
            return "processing_portrait";
        }
        return CameraModeType.m10983m(CameraModeType.ModeType.BACK_LIGHTING) ? "processing_back_lighting" : "processing_normal";
    }

    /* renamed from: c */
    public static void m15885c(Context context) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{context}, (Object) null, f13777a, true, 7937, new Class[]{Context.class}, Void.TYPE).isSupported) {
            if (PreferenceUtil.m15985e(context, CameraModeType.ModeType.AUTO.toString(), (String) null) == null) {
                while (i < CameraModeType.f10558c.length) {
                    CameraModeType.f10558c[i].setSortDeterminer(i);
                    i++;
                }
                return;
            }
            CameraModeType.ModeType[] modeTypeArr = CameraModeType.f10557b;
            int length = modeTypeArr.length;
            while (i < length) {
                CameraModeType.ModeType modeType = modeTypeArr[i];
                String e = PreferenceUtil.m15985e(context, modeType.toString(), (String) null);
                if (e != null && !TextUtils.isEmpty(e)) {
                    modeType.setSortDeterminer(Integer.valueOf(e).intValue());
                }
                i++;
            }
        }
    }

    /* renamed from: d */
    public static void m15891d(Context context) {
        ShortcutManager shortcutManager;
        if (!PatchProxy.proxy(new Object[]{context}, (Object) null, f13777a, true, 7938, new Class[]{Context.class}, Void.TYPE).isSupported && Build.VERSION.SDK_INT >= 25 && (shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class)) != null && shortcutManager.getDynamicShortcuts().size() <= 1) {
            shortcutManager.addDynamicShortcuts(m15898f(context));
        }
    }

    /* renamed from: e */
    public static void m15896e(Context context) {
        ShortcutManager shortcutManager;
        if (!PatchProxy.proxy(new Object[]{context}, (Object) null, f13777a, true, 7939, new Class[]{Context.class}, Void.TYPE).isSupported && Build.VERSION.SDK_INT >= 25 && (shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class)) != null) {
            shortcutManager.updateShortcuts(m15898f(context));
        }
    }

    @RequiresApi(api = 25)
    @NonNull
    /* renamed from: f */
    private static List<ShortcutInfo> m15898f(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f13777a, true, 7940, new Class[]{Context.class}, List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        ArrayList arrayList = new ArrayList();
        if (DeviceHelper.f13836P) {
            String string = context.getString(R.string.mz_cam_mode_super_night);
            Intent intent = new Intent("meizu.intent.action.shortcut.SUPER_NIGHT");
            intent.addFlags(32768);
            intent.setClassName("com.meizu.media.camera", "com.meizu.media.camera.CameraActivity");
            arrayList.add(new ShortcutInfo.Builder(context, "supernight").setShortLabel(string).setLongLabel(string).setIcon(Icon.createWithResource(context, R.drawable.ic_shortcut_supernight)).setIntent(intent).build());
            String string2 = context.getString(R.string.mz_cam_mode_portrait);
            Intent intent2 = new Intent("meizu.intent.action.shortcut.BACK_PORTRAIT");
            intent2.addFlags(32768);
            intent2.setClassName("com.meizu.media.camera", "com.meizu.media.camera.CameraActivity");
            arrayList.add(new ShortcutInfo.Builder(context, "portrait").setShortLabel(string2).setLongLabel(string2).setIcon(Icon.createWithResource(context, R.drawable.ic_shortcut_portrait)).setIntent(intent2).build());
        } else if (DeviceHelper.f13837Q) {
            String string3 = context.getString(R.string.mz_cam_mode_super_night);
            Intent intent3 = new Intent("meizu.intent.action.shortcut.SUPER_NIGHT");
            intent3.setClassName("com.meizu.media.camera", "com.meizu.media.camera.CameraActivity");
            intent3.addFlags(32768);
            arrayList.add(new ShortcutInfo.Builder(context, "supernight").setShortLabel(string3).setLongLabel(string3).setIcon(Icon.createWithResource(context, R.drawable.ic_shortcut_supernight)).setIntent(intent3).build());
            String string4 = context.getString(R.string.mz_cam_mode_portrait);
            Intent intent4 = new Intent("meizu.intent.action.shortcut.TOF");
            intent4.addFlags(32768);
            intent4.setClassName("com.meizu.media.camera", "com.meizu.media.camera.CameraActivity");
            arrayList.add(new ShortcutInfo.Builder(context, "portrait").setShortLabel(string4).setLongLabel(string4).setIcon(Icon.createWithResource(context, R.drawable.ic_shortcut_portrait)).setIntent(intent4).build());
        }
        return arrayList;
    }

    /* renamed from: A */
    private static boolean m15808A() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f13777a, true, 7941, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int f = CameraController.m8868g().mo19512f();
        LogUtil.C2630a aVar = f13778b;
        LogUtil.m15952c(aVar, "numOfCamera: " + f);
        for (int i = 0; i < f; i++) {
            if (CameraController.m8868g().mo19481a(i)) {
                LogUtil.C2630a aVar2 = f13778b;
                LogUtil.m15952c(aVar2, "back camera found: " + i);
                return true;
            }
        }
        LogUtil.m15952c(f13778b, "no back camera");
        return false;
    }

    /* renamed from: g */
    private static boolean m15900g(Context context) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, (Object) null, f13777a, true, 7942, new Class[]{Context.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, "com.meizu.media.camera.CameraLauncher")) == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    private static void m15902h(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, (Object) null, f13777a, true, 7943, new Class[]{Context.class}, Void.TYPE).isSupported) {
            ComponentName componentName = new ComponentName(context, "com.meizu.media.camera.CameraLauncher");
            PackageManager packageManager = context.getPackageManager();
            LogUtil.m15942a(f13778b, "enableComponent cause camera is enable now!");
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }
}
