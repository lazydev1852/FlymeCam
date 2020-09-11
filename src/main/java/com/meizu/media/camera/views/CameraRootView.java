package com.meizu.media.camera.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.meizu.media.camera.util.ApiHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

@SuppressLint({"NewApi"})
public class CameraRootView extends FrameLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f14461a;

    /* renamed from: b */
    private Object f14462b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C2681a f14463c;

    /* renamed from: com.meizu.media.camera.views.CameraRootView$a */
    public interface C2681a {
        /* renamed from: x */
        void mo21223x();
    }

    public CameraRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16374a();
    }

    /* renamed from: a */
    private void m16374a() {
        if (!PatchProxy.proxy(new Object[0], this, f14461a, false, 8307, new Class[0], Void.TYPE).isSupported && ApiHelper.f14206g) {
            this.f14462b = new DisplayManager.DisplayListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14464a;

                public void onDisplayAdded(int i) {
                }

                public void onDisplayRemoved(int i) {
                }

                public void onDisplayChanged(int i) {
                    if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14464a, false, 8310, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && CameraRootView.this.f14463c != null) {
                        CameraRootView.this.f14463c.mo21223x();
                    }
                }
            };
        }
    }

    public void setDisplayChangeListener(C2681a aVar) {
        this.f14463c = aVar;
    }

    public void onAttachedToWindow() {
        if (!PatchProxy.proxy(new Object[0], this, f14461a, false, 8308, new Class[0], Void.TYPE).isSupported) {
            super.onAttachedToWindow();
            if (ApiHelper.f14206g) {
                ((DisplayManager) getContext().getSystemService("display")).registerDisplayListener((DisplayManager.DisplayListener) this.f14462b, (Handler) null);
            }
        }
    }

    public void onDetachedFromWindow() {
        if (!PatchProxy.proxy(new Object[0], this, f14461a, false, 8309, new Class[0], Void.TYPE).isSupported) {
            super.onDetachedFromWindow();
            if (ApiHelper.f14206g) {
                ((DisplayManager) getContext().getSystemService("display")).unregisterDisplayListener((DisplayManager.DisplayListener) this.f14462b);
            }
        }
    }
}
