package com.baidu.p020ar.base;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.p020ar.TakePictureCallback;
import com.baidu.p020ar.TakePictureCallback2;
import com.baidu.p020ar.blend.blender.C0654c;
import com.baidu.p020ar.util.C0919Utils;

/* renamed from: com.baidu.ar.base.e */
public class C0620e implements C0654c.C0669d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f1042a = "e";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f1043b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f1044c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TakePictureCallback f1045d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Bitmap f1046e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TakePictureCallback2 f1047f;

    public C0620e(int i, TakePictureCallback2 takePictureCallback2) {
        this.f1047f = takePictureCallback2;
        this.f1044c = i;
    }

    public C0620e(String str, int i, TakePictureCallback takePictureCallback) {
        this.f1043b = str;
        this.f1044c = i;
        this.f1045d = takePictureCallback;
    }

    /* renamed from: a */
    public void mo9550a(final int[] iArr, final int i, final int i2) {
        new Thread(new Runnable() {
            public void run() {
                Bitmap createBitmapFromColors = C0919Utils.createBitmapFromColors(iArr, i, i2);
                if (createBitmapFromColors == null) {
                    if (C0620e.this.f1045d != null) {
                        C0620e.this.f1045d.onPictureTake(false, (String) null);
                    }
                    Log.e(C0620e.f1042a, "onScreenshot Exception");
                    return;
                }
                Bitmap rotateBitmap = C0919Utils.rotateBitmap(C0919Utils.scaleBitmap(createBitmapFromColors), (C0620e.this.f1044c + 180) % 360);
                if (C0620e.this.f1047f != null) {
                    Bitmap unused = C0620e.this.f1046e = rotateBitmap;
                    C0620e.this.f1047f.onPictureTake(true, C0620e.this.f1046e);
                    return;
                }
                C0919Utils.saveBitmap(C0620e.this.f1043b, rotateBitmap, 100);
                if (rotateBitmap != null) {
                    rotateBitmap.recycle();
                }
                if (C0620e.this.f1045d != null) {
                    C0620e.this.f1045d.onPictureTake(!TextUtils.isEmpty(C0620e.this.f1043b), C0620e.this.f1043b);
                }
            }
        }).start();
    }
}
