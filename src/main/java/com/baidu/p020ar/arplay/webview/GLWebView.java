package com.baidu.p020ar.arplay.webview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.baidu.p020ar.arplay.core.ARPEngine;

/* renamed from: com.baidu.ar.arplay.webview.GLWebView */
public class GLWebView extends WebView {

    /* renamed from: a */
    private C0586a f911a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f912b = false;

    /* renamed from: com.baidu.ar.arplay.webview.GLWebView$a */
    public static class C0586a {

        /* renamed from: a */
        public int f915a;

        /* renamed from: b */
        public boolean f916b;

        /* renamed from: c */
        public String f917c;

        /* renamed from: d */
        public String f918d;

        /* renamed from: e */
        public int f919e;

        /* renamed from: f */
        public int f920f;
    }

    public GLWebView(Context context) {
        super(context);
    }

    public GLWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GLWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void draw(Canvas canvas) {
        if (this.f911a != null && canvas != null && this.f912b) {
            final C0596a a = C0597b.m1195a().mo9429a(this.f911a.f915a);
            if (a == null) {
                Log.e("GLWebView", "HtmlTextureHolder is null: mTextureId: " + this.f911a.f915a);
                return;
            }
            Canvas b = a.mo9426b();
            if (b != null) {
                float width = ((float) b.getWidth()) / ((float) canvas.getWidth());
                b.scale(width, width);
                b.translate((float) (-getScrollX()), (float) (-getScrollY()));
                b.drawColor(0, PorterDuff.Mode.CLEAR);
                super.draw(b);
            }
            a.mo9427c();
            ARPEngine.getInstance().executeOnGLThread(new Runnable() {
                public void run() {
                    a.mo9424a();
                    boolean unused = GLWebView.this.f912b = false;
                }
            });
        }
    }

    public C0586a getWebViewData() {
        return this.f911a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setIsNeedRender(boolean z) {
        this.f912b = z;
    }

    public void setWebViewData(C0586a aVar) {
        this.f911a = aVar;
    }
}
