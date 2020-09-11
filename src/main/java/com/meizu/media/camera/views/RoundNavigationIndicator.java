package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class RoundNavigationIndicator extends LinearLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f15031a;

    /* renamed from: b */
    private LinearLayout f15032b;

    /* renamed from: c */
    private int f15033c = 0;

    /* renamed from: d */
    private int f15034d = 0;

    /* renamed from: e */
    private Context f15035e;

    public RoundNavigationIndicator(Context context) {
        super(context);
        this.f15035e = context;
        m16613a(context);
    }

    public RoundNavigationIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15035e = context;
        m16613a(context);
    }

    /* renamed from: a */
    private void m16613a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f15031a, false, 8823, new Class[]{Context.class}, Void.TYPE).isSupported) {
            LayoutInflater.from(context).inflate(R.layout.image_navigation_indicaor_layout, this);
            setOrientation(0);
            setGravity(16);
            this.f15032b = (LinearLayout) findViewById(R.id.indicator);
        }
    }

    public void setLength(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15031a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8824, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15033c = i;
            this.f15032b.removeAllViews();
            m16612a();
        }
    }

    public void setSelected(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15031a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8825, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            Log.d("test", "setSelected selected:" + i);
            View childAt = this.f15032b.getChildAt(this.f15034d);
            if (childAt != null && (childAt instanceof ImageView)) {
                ((ImageView) childAt).setImageResource(R.drawable.watch_indicator_unfocused);
            }
            this.f15034d = i;
            View childAt2 = this.f15032b.getChildAt(this.f15034d);
            if (childAt2 != null && (childAt2 instanceof ImageView)) {
                ((ImageView) childAt2).setImageResource(R.drawable.watch_indicator_focused);
            }
        }
    }

    /* renamed from: a */
    private void m16612a() {
        if (!PatchProxy.proxy(new Object[0], this, f15031a, false, 8826, new Class[0], Void.TYPE).isSupported) {
            for (int i = 0; i < this.f15033c; i++) {
                ImageView imageView = new ImageView(this.f15035e);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(17, 17));
                imageView.setPadding(4, 4, 4, 4);
                imageView.setImageResource(R.drawable.watch_indicator_unfocused);
                this.f15032b.addView(imageView);
            }
        }
    }
}
