package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class ShutterButton extends AppCompatImageView {

    /* renamed from: a */
    public static ChangeQuickRedirect f15041a;

    /* renamed from: b */
    private C2727a f15042b;

    /* renamed from: c */
    private boolean f15043c;

    /* renamed from: d */
    private int f15044d;

    /* renamed from: e */
    private int f15045e;

    /* renamed from: f */
    private boolean f15046f;

    /* renamed from: g */
    private Runnable f15047g;

    /* renamed from: h */
    private boolean f15048h = false;

    /* renamed from: com.meizu.media.camera.views.ShutterButton$a */
    public interface C2727a {
        /* renamed from: af */
        void mo18047af(boolean z);

        /* renamed from: ag */
        void mo18048ag(boolean z);

        /* renamed from: dl */
        void mo18214dl();

        /* renamed from: dm */
        void mo18215dm();

        /* renamed from: dn */
        void mo18216dn();

        /* renamed from: do */
        void mo18217do();

        /* renamed from: dp */
        void mo18218dp();
    }

    public ShutterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLongClickable(false);
        this.f15047g = new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f15049a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f15049a, false, 8835, new Class[0], Void.TYPE).isSupported) {
                    ShutterButton.this.m16616a();
                }
            }
        };
    }

    public void setOnShutterButtonListener(C2727a aVar) {
        this.f15042b = aVar;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f15041a, false, 8830, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.f15044d = x;
                this.f15045e = y;
                this.f15046f = false;
                if (CameraModeType.m10971h()) {
                    postDelayed(this.f15047g, 500);
                    break;
                }
                break;
            case 1:
                if (CameraModeType.m10971h()) {
                    removeCallbacks(this.f15047g);
                    break;
                }
                break;
            case 2:
                if (!this.f15046f && (Math.abs(this.f15044d - x) > 100 || Math.abs(this.f15045e - y) > 100)) {
                    this.f15046f = true;
                    if (CameraModeType.m10971h()) {
                        removeCallbacks(this.f15047g);
                        break;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void drawableStateChanged() {
        if (!PatchProxy.proxy(new Object[0], this, f15041a, false, 8831, new Class[0], Void.TYPE).isSupported) {
            super.drawableStateChanged();
            final boolean isPressed = isPressed();
            if (isPressed != this.f15043c) {
                if (!isPressed) {
                    post(new Runnable() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f15051a;

                        public void run() {
                            if (!PatchProxy.proxy(new Object[0], this, f15051a, false, 8836, new Class[0], Void.TYPE).isSupported) {
                                ShutterButton.this.m16619a(isPressed);
                            }
                        }
                    });
                } else {
                    m16619a(isPressed);
                }
                this.f15043c = isPressed;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16619a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15041a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8832, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f15042b != null && isInTouchMode()) {
            this.f15042b.mo18048ag(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16616a() {
        if (!PatchProxy.proxy(new Object[0], this, f15041a, false, 8833, new Class[0], Void.TYPE).isSupported && isInTouchMode()) {
            this.f15048h = true;
            if (this.f15042b != null) {
                this.f15042b.mo18216dn();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f15041a, false, 8834, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (motionEvent.getAction() == 1) {
            if (this.f15048h) {
                if (this.f15042b != null) {
                    this.f15042b.mo18217do();
                }
                this.f15048h = false;
            } else if (this.f15042b != null) {
                this.f15042b.mo18218dp();
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.f15042b != null) {
                UsageStatsHelper.m16044a(0);
                this.f15042b.mo18047af(false);
            }
        } else if (motionEvent.getAction() == 3 && this.f15042b != null) {
            this.f15042b.mo18214dl();
        }
        return super.onTouchEvent(motionEvent);
    }
}
