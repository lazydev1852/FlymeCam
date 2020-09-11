package flyme.support.p093v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import flyme.support.p093v7.appcompat.R;
import java.lang.reflect.Field;

/* renamed from: flyme.support.v7.widget.ListPopupWindow */
public class ListPopupWindow extends androidx.appcompat.widget.ListPopupWindow {

    /* renamed from: b */
    private static Field f17671b;

    /* renamed from: a */
    PopupWindow f17672a;

    static {
        try {
            f17671b = androidx.appcompat.widget.ListPopupWindow.class.getDeclaredField("mPopup");
        } catch (NoSuchFieldException unused) {
        }
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        try {
            this.f17672a = (PopupWindow) f17671b.get(this);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void mo26123a(boolean z) {
        if (this.f17672a != null) {
            this.f17672a.setClippingEnabled(z);
        }
    }
}
