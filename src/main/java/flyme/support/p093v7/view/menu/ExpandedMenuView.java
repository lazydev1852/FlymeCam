package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.TintTypedArray;
import flyme.support.p093v7.view.menu.MenuBuilder;

/* renamed from: flyme.support.v7.view.menu.ExpandedMenuView */
public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, MenuBuilder.C3160b, MenuView {

    /* renamed from: a */
    private static final int[] f17220a = {16842964, 16843049};

    /* renamed from: b */
    private MenuBuilder f17221b;

    /* renamed from: c */
    private int f17222c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, f17220a, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            setDivider(obtainStyledAttributes.getDrawable(1));
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public void mo25522a(MenuBuilder menuBuilder) {
        this.f17221b = menuBuilder;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    /* renamed from: a */
    public boolean mo25523a(MenuItemImpl menuItemImpl) {
        return this.f17221b.mo25551a((MenuItem) menuItemImpl, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo25523a((MenuItemImpl) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f17222c;
    }
}
