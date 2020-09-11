package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.widget.Switch;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class SwitchItemView extends LinearLayout implements View.OnTouchListener, Checkable {

    /* renamed from: a */
    public static ChangeQuickRedirect f15114a;

    /* renamed from: b */
    private boolean f15115b;

    /* renamed from: c */
    private boolean f15116c;

    /* renamed from: d */
    private Switch f15117d;

    /* renamed from: e */
    private TextView f15118e;

    /* renamed from: f */
    private TextView f15119f;

    public SwitchItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SwitchItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void setEnabled(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f15114a, false, 8892, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && z != isEnabled()) {
            if (z) {
                if (this.f15118e != null) {
                    this.f15118e.setTextColor(getResources().getColor(R.color.mz_setting_label_title));
                }
                if (this.f15119f != null) {
                    this.f15119f.setTextColor(getResources().getColor(R.color.mz_setting_label_detail));
                }
                if (this.f15117d != null) {
                    this.f15117d.setEnabled(true);
                }
            } else {
                if (this.f15118e != null) {
                    this.f15118e.setTextColor(getResources().getColor(R.color.mz_filter_item_text));
                }
                if (this.f15119f != null) {
                    this.f15119f.setTextColor(getResources().getColor(R.color.mz_filter_item_text));
                }
                if (this.f15117d != null) {
                    this.f15117d.setEnabled(false);
                    this.f15117d.setChecked(false);
                }
                this.f15115b = false;
            }
            super.setEnabled(z);
        }
    }

    public void onFinishInflate() {
        if (!PatchProxy.proxy(new Object[0], this, f15114a, false, 8893, new Class[0], Void.TYPE).isSupported) {
            super.onFinishInflate();
            this.f15117d = (Switch) findViewById(R.id.mz_item_switcher);
            this.f15117d.setOnTouchListener(this);
            this.f15118e = (TextView) findViewById(R.id.mz_item_title);
            this.f15119f = (TextView) findViewById(R.id.mz_item_detail);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f15114a, false, 8894, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!isEnabled()) {
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.f15116c = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view, motionEvent}, this, f15114a, false, 8895, new Class[]{View.class, MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!isEnabled()) {
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.f15116c = true;
        }
        return false;
    }

    public void setChecked(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f15114a, false, 8896, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && isEnabled() && this.f15115b != z) {
            this.f15115b = z;
            if (this.f15116c) {
                this.f15117d.setCheckedWithHapticFeedback(z, true);
            } else {
                this.f15117d.setChecked(z, false);
            }
            this.f15116c = false;
        }
    }

    public boolean isChecked() {
        return this.f15115b;
    }

    public void toggle() {
        if (!PatchProxy.proxy(new Object[0], this, f15114a, false, 8897, new Class[0], Void.TYPE).isSupported) {
            setChecked(!this.f15115b);
        }
    }
}
