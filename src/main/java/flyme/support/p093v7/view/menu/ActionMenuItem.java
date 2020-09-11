package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: flyme.support.v7.view.menu.ActionMenuItem */
public class ActionMenuItem implements SupportMenuItem {

    /* renamed from: a */
    private final int f17174a;

    /* renamed from: b */
    private final int f17175b;

    /* renamed from: c */
    private final int f17176c;

    /* renamed from: d */
    private final int f17177d;

    /* renamed from: e */
    private CharSequence f17178e;

    /* renamed from: f */
    private CharSequence f17179f;

    /* renamed from: g */
    private Intent f17180g;

    /* renamed from: h */
    private char f17181h;

    /* renamed from: i */
    private int f17182i = 4096;

    /* renamed from: j */
    private char f17183j;

    /* renamed from: k */
    private int f17184k = 4096;

    /* renamed from: l */
    private Drawable f17185l;

    /* renamed from: m */
    private int f17186m = 0;

    /* renamed from: n */
    private Context f17187n;

    /* renamed from: o */
    private MenuItem.OnMenuItemClickListener f17188o;

    /* renamed from: p */
    private CharSequence f17189p;

    /* renamed from: q */
    private CharSequence f17190q;

    /* renamed from: r */
    private ColorStateList f17191r = null;

    /* renamed from: s */
    private PorterDuff.Mode f17192s = null;

    /* renamed from: t */
    private boolean f17193t = false;

    /* renamed from: u */
    private boolean f17194u = false;

    /* renamed from: v */
    private int f17195v = 16;

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public View getActionView() {
        return null;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public ActionProvider getSupportActionProvider() {
        return null;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public void setShowAsAction(int i) {
    }

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f17187n = context;
        this.f17174a = i2;
        this.f17175b = i;
        this.f17176c = i3;
        this.f17177d = i4;
        this.f17178e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f17183j;
    }

    public int getAlphabeticModifiers() {
        return this.f17184k;
    }

    public int getGroupId() {
        return this.f17175b;
    }

    public Drawable getIcon() {
        return this.f17185l;
    }

    public Intent getIntent() {
        return this.f17180g;
    }

    public int getItemId() {
        return this.f17174a;
    }

    public char getNumericShortcut() {
        return this.f17181h;
    }

    public int getNumericModifiers() {
        return this.f17182i;
    }

    public int getOrder() {
        return this.f17177d;
    }

    public CharSequence getTitle() {
        return this.f17178e;
    }

    public CharSequence getTitleCondensed() {
        return this.f17179f != null ? this.f17179f : this.f17178e;
    }

    public boolean isCheckable() {
        return (this.f17195v & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f17195v & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f17195v & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f17195v & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f17183j = Character.toLowerCase(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f17183j = Character.toLowerCase(c);
        this.f17184k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f17195v = z | (this.f17195v & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f17195v = (z ? 2 : 0) | (this.f17195v & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f17195v = (z ? 16 : 0) | (this.f17195v & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f17185l = drawable;
        this.f17186m = 0;
        m18861a();
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f17186m = i;
        this.f17185l = ContextCompat.getDrawable(this.f17187n, i);
        m18861a();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f17180g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f17181h = c;
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f17181h = c;
        this.f17182i = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f17188o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f17181h = c;
        this.f17183j = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f17181h = c;
        this.f17182i = KeyEvent.normalizeMetaState(i);
        this.f17183j = Character.toLowerCase(c2);
        this.f17184k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f17178e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f17178e = this.f17187n.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f17179f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.f17195v & 8;
        if (z) {
            i = 0;
        }
        this.f17195v = i2 | i;
        return this;
    }

    /* renamed from: a */
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public SupportMenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f17189p = charSequence;
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f17189p;
    }

    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f17190q = charSequence;
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f17190q;
    }

    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f17191r = colorStateList;
        this.f17193t = true;
        m18861a();
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f17191r;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f17192s = mode;
        this.f17194u = true;
        m18861a();
        return this;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f17192s;
    }

    /* renamed from: a */
    private void m18861a() {
        if (this.f17185l == null) {
            return;
        }
        if (this.f17193t || this.f17194u) {
            this.f17185l = DrawableCompat.wrap(this.f17185l);
            this.f17185l = this.f17185l.mutate();
            if (this.f17193t) {
                DrawableCompat.setTintList(this.f17185l, this.f17191r);
            }
            if (this.f17194u) {
                DrawableCompat.setTintMode(this.f17185l, this.f17192s);
            }
        }
    }
}
