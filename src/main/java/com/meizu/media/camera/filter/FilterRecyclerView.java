package com.meizu.media.camera.filter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.widget.MzRecyclerView;

public class FilterRecyclerView extends MzRecyclerView {

    /* renamed from: a */
    public static ChangeQuickRedirect f10027a;

    /* renamed from: aj */
    private GestureDetector.SimpleOnGestureListener f10028aj = new GestureDetector.SimpleOnGestureListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f10035a;

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent, motionEvent2, new Float(f), new Float(f2)}, this, f10035a, false, 4072, new Class[]{MotionEvent.class, MotionEvent.class, Float.TYPE, Float.TYPE}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (FilterRecyclerView.this.f10032an == null) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            FilterRecyclerView.this.f10032an.mo20063a(motionEvent, motionEvent2, f, f2);
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f10035a, false, 4073, new Class[]{MotionEvent.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (FilterRecyclerView.this.f10032an == null) {
                return super.onDown(motionEvent);
            }
            FilterRecyclerView.this.f10032an.mo20062a(motionEvent);
            return true;
        }
    };

    /* renamed from: ak */
    private boolean f10029ak = true;

    /* renamed from: al */
    private boolean f10030al = false;

    /* renamed from: am */
    private final float f10031am = 0.9f;
    /* access modifiers changed from: private */

    /* renamed from: an */
    public C2066b f10032an;

    /* renamed from: ao */
    private C2065a f10033ao;

    /* renamed from: ap */
    private GestureDetector f10034ap = new GestureDetector(this.f10028aj);

    /* renamed from: com.meizu.media.camera.filter.FilterRecyclerView$a */
    public interface C2065a {
        /* renamed from: a */
        void mo20061a(boolean z, int i, int i2, int i3, int i4);
    }

    /* renamed from: com.meizu.media.camera.filter.FilterRecyclerView$b */
    public interface C2066b {
        /* renamed from: a */
        void mo20062a(MotionEvent motionEvent);

        /* renamed from: a */
        void mo20063a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);
    }

    public FilterRecyclerView(Context context) {
        super(context);
    }

    public FilterRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FilterRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f10027a, false, 4067, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f10029ak) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10027a, false, 4068, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f10029ak || super.performClick();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f10027a, false, 4069, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f10029ak) {
            this.f10034ap.onTouchEvent(motionEvent);
        }
        if (this.f10029ak || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setShouldIntercept(boolean z) {
        this.f10029ak = z;
    }

    public void setDisableMoveHead(boolean z) {
        this.f10030al = z;
    }

    /* renamed from: a */
    public boolean mo20050a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f10027a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4070, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int i3 = (int) (((float) i) * 0.9f);
        if (!(getLayoutManager() instanceof CenterLockLayoutManager)) {
            return super.mo20050a(i3, i2);
        }
        if (DeviceUtil.m16209i()) {
            int a = ((CenterLockLayoutManager) getLayoutManager()).mo20064a(-i3, i2);
            if (this.f10030al && a == 0) {
                a = 1;
            }
            super.mo26403g(a);
        } else {
            int a2 = ((CenterLockLayoutManager) getLayoutManager()).mo20064a(i3, i2);
            if (this.f10030al && a2 == 0) {
                a2 = 1;
            }
            super.mo26403g(a2);
        }
        return true;
    }

    public void setScrollListener(C2066b bVar) {
        this.f10032an = bVar;
    }

    public void setLayoutListener(C2065a aVar) {
        this.f10033ao = aVar;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f10027a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4071, new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f10033ao != null) {
                this.f10033ao.mo20061a(z, i, i2, i3, i4);
            }
        }
    }
}
