package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import flyme.support.p093v7.app.ActionBar;
import flyme.support.p093v7.appcompat.R;
import java.util.ArrayList;

/* renamed from: flyme.support.v7.widget.AloneTabContainer */
public class AloneTabContainer extends LinearLayout {

    /* renamed from: a */
    ScrollingTabContainerView f17545a;

    /* renamed from: b */
    private Context f17546b;

    /* renamed from: c */
    private ArrayList<Object> f17547c;

    /* renamed from: d */
    private int f17548d;

    /* renamed from: e */
    private int f17549e;

    /* renamed from: f */
    private int f17550f;

    public AloneTabContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public AloneTabContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AloneTabContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17547c = new ArrayList<>();
        this.f17548d = -1;
        this.f17549e = -1;
        this.f17550f = -1;
        this.f17546b = context;
        setTabView(new ScrollingTabContainerView(context));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_margin_left);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    public void setIndicatorDrawable(Drawable drawable) {
        if (this.f17545a != null) {
            this.f17545a.setIndicatorDrawable(drawable);
        }
    }

    public void setTabScrolled(int i, float f, int i2) {
        if (this.f17545a != null) {
            this.f17545a.setScrollPosition(i, f, true);
        }
    }

    private void setTabView(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f17545a != scrollingTabContainerView || this.f17545a.getParent() != this) {
            if (this.f17545a != null) {
                removeView(this.f17545a);
            }
            this.f17545a = scrollingTabContainerView;
            if (scrollingTabContainerView != null) {
                this.f17545a.setIsAloneTabContainer(true);
                addView(scrollingTabContainerView, new LinearLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void setupTabStyle(ActionBar.C3077g gVar) {
        gVar.mo25071a(this.f17550f);
        gVar.mo25072a(this.f17548d, this.f17549e);
    }

    public void setIsEmbeddedTabs(boolean z) {
        this.f17545a.mo26803a(z);
    }
}
