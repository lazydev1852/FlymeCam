package com.meizu.media.camera.views;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ZoomView extends MzImageView {

    /* renamed from: b */
    public static ChangeQuickRedirect f15204b;

    /* renamed from: c */
    private static final LogUtil.C2630a f15205c = new LogUtil.C2630a("ZoomView");
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f15206d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f15207e = 0;

    /* renamed from: f */
    private Uri f15208f;

    public ZoomView(Context context) {
        super(context);
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f15209a;

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                int i9 = i;
                int i10 = i2;
                int i11 = i3;
                int i12 = i4;
                Object[] objArr = {view, new Integer(i9), new Integer(i10), new Integer(i11), new Integer(i12), new Integer(i5), new Integer(i6), new Integer(i7), new Integer(i8)};
                ChangeQuickRedirect changeQuickRedirect = f15209a;
                Class[] clsArr = {View.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE};
                if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8972, clsArr, Void.TYPE).isSupported) {
                    int i13 = i11 - i9;
                    int i14 = i12 - i10;
                    if (ZoomView.this.f15207e != i14 || ZoomView.this.f15206d != i13) {
                        int unused = ZoomView.this.f15206d = i13;
                        int unused2 = ZoomView.this.f15207e = i14;
                    }
                }
            }
        });
    }

    private InputStream getInputStream() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f15204b, false, 8970, new Class[0], InputStream.class);
        if (proxy.isSupported) {
            return (InputStream) proxy.result;
        }
        try {
            return getContext().getContentResolver().openInputStream(this.f15208f);
        } catch (FileNotFoundException unused) {
            LogUtil.C2630a aVar = f15205c;
            LogUtil.m15949b(aVar, "File not found at: " + this.f15208f);
            return null;
        }
    }
}
