package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meizu.common.util.CommonUtils;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.widget.TabView */
public class TabView extends RelativeLayout implements CustomTabView {

    /* renamed from: a */
    private TextView f18326a;

    /* renamed from: b */
    private TitleBarBadgeView f18327b;

    /* renamed from: c */
    private View f18328c;

    public TabView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setIsTitleBar(boolean z) {
        if (z) {
            this.f18328c = LayoutInflater.from(getContext()).inflate(CommonUtils.m5121b() ? R.layout.mz_title_bar_badge_layout_full_screen : R.layout.mz_title_bar_badge_layout, this);
        } else {
            this.f18328c = LayoutInflater.from(getContext()).inflate(R.layout.mz_tab_bar_badge_layout, this);
        }
        if (this.f18328c == null) {
            Log.w("TabView", "can not inflate the view");
            return;
        }
        this.f18326a = (TextView) this.f18328c.findViewById(R.id.tab_text);
        this.f18327b = (TitleBarBadgeView) this.f18328c.findViewById(R.id.tab_badge);
    }

    public void setTabText(String str) {
        this.f18326a.setText(str);
    }

    public String getTabText() {
        return (String) this.f18326a.getText();
    }

    public void setTabTextColor(ColorStateList colorStateList) {
        this.f18326a.setTextColor(colorStateList);
    }

    public void setShowBadge(boolean z) {
        this.f18327b.setShow(z);
    }

    public void setRadius(int i) {
        this.f18327b.setBadgeRadius(i);
    }

    public int getRadius() {
        return this.f18327b.getBadgeRadius();
    }

    public TextView getTabTextView() {
        return this.f18326a;
    }

    public TitleBarBadgeView getTitleBarBadgeView() {
        return this.f18327b;
    }
}
