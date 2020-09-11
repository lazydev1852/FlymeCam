package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.MotionEventHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import org.greenrobot.eventbus.EventBus;

public class MzInterceptFrameLayout extends FrameLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f14847a;

    /* renamed from: b */
    public static final LogUtil.C2630a f14848b = new LogUtil.C2630a("MzInterceptFrameLayout");

    /* renamed from: c */
    private boolean f14849c = true;

    /* renamed from: d */
    private boolean f14850d = false;

    /* renamed from: e */
    private long f14851e;

    /* renamed from: f */
    private C2714b f14852f;

    /* renamed from: g */
    private C2713a f14853g;

    /* renamed from: com.meizu.media.camera.views.MzInterceptFrameLayout$a */
    public interface C2713a {
        /* renamed from: a */
        void mo21720a(MotionEvent motionEvent);
    }

    /* renamed from: com.meizu.media.camera.views.MzInterceptFrameLayout$b */
    public interface C2714b {
        /* renamed from: a */
        void mo20990a(MotionEvent motionEvent);
    }

    public MzInterceptFrameLayout(Context context) {
        super(context);
    }

    public MzInterceptFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MzInterceptFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setListener(C2714b bVar) {
        this.f14852f = bVar;
    }

    public void setDragTouchListener(C2713a aVar) {
        this.f14853g = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14847a, false, 8620, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f14849c && !this.f14850d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        LogUtil.C2630a aVar = f14848b;
        LogUtil.m15952c(aVar, "intercept touch event:mIsAllowDispatch=" + this.f14849c + " mIntercept=" + this.f14850d);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14847a, false, 8621, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f14852f != null && motionEvent.getAction() == 0) {
            this.f14852f.mo20990a(motionEvent);
        }
        if (this.f14853g != null) {
            this.f14853g.mo21720a(motionEvent);
        }
        this.f14849c = MotionEventHelper.m15964a(motionEvent);
        if (!this.f14849c || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14847a, false, 8622, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f14849c) {
            this.f14849c = true;
            return true;
        }
        if (motionEvent.getActionMasked() == 0) {
            EventBus.m21789a().mo27980d(19);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    public void mo23087a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14847a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8623, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14850d = z;
            this.f14851e = System.currentTimeMillis();
            LogUtil.C2630a aVar = f14848b;
            LogUtil.m15942a(aVar, "doIntercept:" + z);
        }
    }

    public long getLastInterceptSetTime() {
        return this.f14851e;
    }
}
