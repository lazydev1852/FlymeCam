package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class LableItemView extends RelativeLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f14684a;

    /* renamed from: b */
    private TextView f14685b;

    /* renamed from: c */
    private TextView f14686c;

    public LableItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LableItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LableItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void setEnabled(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14684a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8451, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && z != isEnabled()) {
            if (z) {
                this.f14685b.setTextColor(getResources().getColor(R.color.mz_setting_label_title));
                this.f14686c.setTextColor(getResources().getColor(R.color.mz_setting_label_detail));
            } else {
                this.f14685b.setTextColor(getResources().getColor(R.color.mz_filter_item_text));
                this.f14686c.setTextColor(getResources().getColor(R.color.mz_filter_item_text));
            }
            super.setEnabled(z);
        }
    }

    public void onFinishInflate() {
        if (!PatchProxy.proxy(new Object[0], this, f14684a, false, 8452, new Class[0], Void.TYPE).isSupported) {
            super.onFinishInflate();
            this.f14685b = (TextView) findViewById(R.id.mz_item_title);
            this.f14686c = (TextView) findViewById(R.id.mz_item_detail);
        }
    }
}
