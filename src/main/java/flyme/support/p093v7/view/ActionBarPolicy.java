package flyme.support.p093v7.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.meizu.common.util.CommonUtils;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.view.a */
public class ActionBarPolicy {

    /* renamed from: a */
    private Context f17100a;

    /* renamed from: b */
    public boolean mo25413b() {
        return true;
    }

    /* renamed from: a */
    public static ActionBarPolicy m18758a(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.f17100a = context;
    }

    /* renamed from: a */
    public int mo25412a() {
        return this.f17100a.getResources().getInteger(R.integer.abc_max_action_buttons);
    }

    /* renamed from: c */
    public int mo25414c() {
        return this.f17100a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: d */
    public boolean mo25415d() {
        if (this.f17100a.getApplicationInfo().targetSdkVersion >= 16) {
            return this.f17100a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
        }
        return this.f17100a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs_pre_jb);
    }

    /* renamed from: e */
    public int mo25416e() {
        return this.f17100a.getResources().getDimensionPixelSize(R.dimen.mz_action_bar_stacked_max_height);
    }

    /* renamed from: f */
    public boolean mo25417f() {
        return this.f17100a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* renamed from: g */
    public int mo25418g() {
        return this.f17100a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    /* renamed from: h */
    public int mo25419h() {
        TypedArray obtainStyledAttributes = this.f17100a.obtainStyledAttributes((AttributeSet) null, R.styleable.Toolbar, CommonUtils.m5121b() ? R.attr.mzToolbarStyleFullScreen : R.attr.toolbarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.Toolbar_maxButtonHeight, this.f17100a.getResources().getDimensionPixelSize(R.dimen.mz_action_button_min_height_appcompat));
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* renamed from: i */
    public int mo25420i() {
        return this.f17100a.getResources().getDimensionPixelSize(R.dimen.mz_action_mode_split_padding);
    }
}
