package flyme.support.p093v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import flyme.support.p093v7.view.menu.MenuView;

/* renamed from: flyme.support.v7.view.menu.MenuItemImpl */
public final class MenuItemImpl implements SupportMenuItem, FMenuItem {

    /* renamed from: F */
    private static String f17263F;

    /* renamed from: G */
    private static String f17264G;

    /* renamed from: H */
    private static String f17265H;

    /* renamed from: I */
    private static String f17266I;

    /* renamed from: A */
    private View f17267A;

    /* renamed from: B */
    private ActionProvider f17268B;

    /* renamed from: C */
    private MenuItem.OnActionExpandListener f17269C;

    /* renamed from: D */
    private boolean f17270D = false;

    /* renamed from: E */
    private ContextMenu.ContextMenuInfo f17271E;

    /* renamed from: J */
    private ColorStateList f17272J;

    /* renamed from: K */
    private boolean f17273K = true;

    /* renamed from: L */
    private boolean f17274L;

    /* renamed from: M */
    private boolean f17275M;

    /* renamed from: a */
    MenuBuilder f17276a;

    /* renamed from: b */
    private final int f17277b;

    /* renamed from: c */
    private final int f17278c;

    /* renamed from: d */
    private final int f17279d;

    /* renamed from: e */
    private final int f17280e;

    /* renamed from: f */
    private CharSequence f17281f;

    /* renamed from: g */
    private CharSequence f17282g;

    /* renamed from: h */
    private Intent f17283h;

    /* renamed from: i */
    private char f17284i;

    /* renamed from: j */
    private int f17285j = 4096;

    /* renamed from: k */
    private char f17286k;

    /* renamed from: l */
    private int f17287l = 4096;

    /* renamed from: m */
    private Drawable f17288m;

    /* renamed from: n */
    private int f17289n = 0;

    /* renamed from: o */
    private SubMenuBuilder f17290o;

    /* renamed from: p */
    private Runnable f17291p;

    /* renamed from: q */
    private MenuItem.OnMenuItemClickListener f17292q;

    /* renamed from: r */
    private CharSequence f17293r;

    /* renamed from: s */
    private CharSequence f17294s;

    /* renamed from: t */
    private ColorStateList f17295t = null;

    /* renamed from: u */
    private PorterDuff.Mode f17296u = null;

    /* renamed from: v */
    private boolean f17297v = false;

    /* renamed from: w */
    private boolean f17298w = false;

    /* renamed from: x */
    private boolean f17299x = false;

    /* renamed from: y */
    private int f17300y = 16;

    /* renamed from: z */
    private int f17301z = 0;

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f17276a = menuBuilder;
        this.f17277b = i2;
        this.f17278c = i;
        this.f17279d = i3;
        this.f17280e = i4;
        this.f17281f = charSequence;
        this.f17301z = i5;
    }

    /* renamed from: a */
    public boolean mo25612a() {
        if ((this.f17292q != null && this.f17292q.onMenuItemClick(this)) || this.f17276a.mo25553a(this.f17276a, (MenuItem) this)) {
            return true;
        }
        if (this.f17291p != null) {
            this.f17291p.run();
            return true;
        }
        if (this.f17283h != null) {
            try {
                this.f17276a.mo25578e().startActivity(this.f17283h);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f17268B == null || !this.f17268B.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f17300y & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f17300y |= 16;
        } else {
            this.f17300y &= -17;
        }
        this.f17276a.mo25567b(false);
        return this;
    }

    public int getGroupId() {
        return this.f17278c;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f17277b;
    }

    public int getOrder() {
        return this.f17279d;
    }

    /* renamed from: b */
    public int mo25613b() {
        return this.f17280e;
    }

    public Intent getIntent() {
        return this.f17283h;
    }

    public MenuItem setIntent(Intent intent) {
        this.f17283h = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f17286k;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f17286k == c) {
            return this;
        }
        this.f17286k = Character.toLowerCase(c);
        this.f17276a.mo25567b(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f17286k == c && this.f17287l == i) {
            return this;
        }
        this.f17286k = Character.toLowerCase(c);
        this.f17287l = KeyEvent.normalizeMetaState(i);
        this.f17276a.mo25567b(false);
        return this;
    }

    public int getAlphabeticModifiers() {
        return this.f17287l;
    }

    public char getNumericShortcut() {
        return this.f17284i;
    }

    public int getNumericModifiers() {
        return this.f17285j;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f17284i == c) {
            return this;
        }
        this.f17284i = c;
        this.f17276a.mo25567b(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f17284i == c && this.f17285j == i) {
            return this;
        }
        this.f17284i = c;
        this.f17285j = KeyEvent.normalizeMetaState(i);
        this.f17276a.mo25567b(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f17284i = c;
        this.f17286k = Character.toLowerCase(c2);
        this.f17276a.mo25567b(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f17284i = c;
        this.f17285j = KeyEvent.normalizeMetaState(i);
        this.f17286k = Character.toLowerCase(c2);
        this.f17287l = KeyEvent.normalizeMetaState(i2);
        this.f17276a.mo25567b(false);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public char mo25616c() {
        return this.f17276a.mo25568b() ? this.f17286k : this.f17284i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo25618d() {
        char c = mo25616c();
        if (c == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(f17263F);
        if (c == 8) {
            sb.append(f17265H);
        } else if (c == 10) {
            sb.append(f17264G);
        } else if (c != ' ') {
            sb.append(c);
        } else {
            sb.append(f17266I);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo25621e() {
        return this.f17276a.mo25571c() && mo25616c() != 0;
    }

    public SubMenu getSubMenu() {
        return this.f17290o;
    }

    public boolean hasSubMenu() {
        return this.f17290o != null;
    }

    /* renamed from: a */
    public void mo25610a(SubMenuBuilder subMenuBuilder) {
        this.f17290o = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f17281f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CharSequence mo25608a(MenuView.C3168a aVar) {
        if (aVar == null || !aVar.mo25498a()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f17281f = charSequence;
        this.f17276a.mo25567b(false);
        if (this.f17290o != null) {
            this.f17290o.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle((CharSequence) this.f17276a.mo25578e().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f17282g != null ? this.f17282g : this.f17281f;
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f17282g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f17281f;
        }
        this.f17276a.mo25567b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f17288m != null) {
            return m18943a(this.f17288m);
        }
        if (this.f17289n == 0) {
            return null;
        }
        Drawable drawable = AppCompatDrawableManager.get().getDrawable(this.f17276a.mo25578e(), this.f17289n);
        this.f17289n = 0;
        this.f17288m = drawable;
        return m18943a(drawable);
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f17289n = 0;
        this.f17288m = drawable;
        this.f17299x = true;
        this.f17276a.mo25567b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f17288m = null;
        this.f17289n = i;
        this.f17299x = true;
        this.f17276a.mo25567b(false);
        return this;
    }

    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f17295t = colorStateList;
        this.f17297v = true;
        this.f17299x = true;
        this.f17276a.mo25567b(false);
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f17295t;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f17296u = mode;
        this.f17298w = true;
        this.f17299x = true;
        this.f17276a.mo25567b(false);
        return this;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f17296u;
    }

    /* renamed from: a */
    private Drawable m18943a(Drawable drawable) {
        if (drawable != null && this.f17299x && (this.f17297v || this.f17298w)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.f17297v) {
                DrawableCompat.setTintList(drawable, this.f17295t);
            }
            if (this.f17298w) {
                DrawableCompat.setTintMode(drawable, this.f17296u);
            }
            this.f17299x = false;
        }
        return drawable;
    }

    public boolean isCheckable() {
        return (this.f17300y & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f17300y;
        this.f17300y = z | (this.f17300y & true) ? 1 : 0;
        if (i != this.f17300y) {
            this.f17276a.mo25567b(false);
        }
        return this;
    }

    /* renamed from: a */
    public void mo25611a(boolean z) {
        this.f17300y = (z ? 4 : 0) | (this.f17300y & -5);
    }

    /* renamed from: f */
    public boolean mo25622f() {
        return (this.f17300y & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f17300y & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f17300y & 4) != 0) {
            this.f17276a.mo25544a((MenuItem) this);
        } else {
            mo25615b(z);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25615b(boolean z) {
        int i = this.f17300y;
        this.f17300y = (z ? 2 : 0) | (this.f17300y & -3);
        if (i != this.f17300y) {
            this.f17276a.mo25567b(false);
        }
    }

    public boolean isVisible() {
        if (this.f17268B == null || !this.f17268B.overridesItemVisibility()) {
            if ((this.f17300y & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.f17300y & 8) != 0 || !this.f17268B.isVisible()) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo25617c(boolean z) {
        int i = this.f17300y;
        this.f17300y = (z ? 0 : 8) | (this.f17300y & -9);
        if (i != this.f17300y) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (mo25617c(z)) {
            this.f17276a.mo25546a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f17292q = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        if (this.f17281f != null) {
            return this.f17281f.toString();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25609a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f17271E = contextMenuInfo;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f17271E;
    }

    /* renamed from: g */
    public void mo25623g() {
        this.f17276a.mo25565b(this);
    }

    /* renamed from: h */
    public boolean mo25636h() {
        return this.f17276a.mo25596q();
    }

    /* renamed from: i */
    public boolean mo25638i() {
        return (this.f17300y & 32) == 32;
    }

    /* renamed from: j */
    public boolean mo25643j() {
        return (this.f17301z & 1) == 1;
    }

    /* renamed from: k */
    public boolean mo25644k() {
        return (this.f17301z & 2) == 2;
    }

    /* renamed from: d */
    public void mo25619d(boolean z) {
        if (z) {
            this.f17300y |= 32;
        } else {
            this.f17300y &= -33;
        }
    }

    /* renamed from: l */
    public boolean mo25645l() {
        return (this.f17301z & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f17301z = i;
                this.f17276a.mo25565b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    /* renamed from: a */
    public SupportMenuItem setActionView(View view) {
        this.f17267A = view;
        this.f17268B = null;
        if (view != null && view.getId() == -1 && this.f17277b > 0) {
            view.setId(this.f17277b);
        }
        this.f17276a.mo25565b(this);
        return this;
    }

    /* renamed from: a */
    public SupportMenuItem setActionView(int i) {
        Context e = this.f17276a.mo25578e();
        setActionView(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public View getActionView() {
        if (this.f17267A != null) {
            return this.f17267A;
        }
        if (this.f17268B == null) {
            return null;
        }
        this.f17267A = this.f17268B.onCreateActionView(this);
        return this.f17267A;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public ActionProvider getSupportActionProvider() {
        return this.f17268B;
    }

    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.f17268B != null) {
            this.f17268B.reset();
        }
        this.f17267A = null;
        this.f17268B = actionProvider;
        this.f17276a.mo25567b(true);
        if (this.f17268B != null) {
            this.f17268B.setVisibilityListener(new ActionProvider.VisibilityListener() {
                public void onActionProviderVisibilityChanged(boolean z) {
                    MenuItemImpl.this.f17276a.mo25546a(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    /* renamed from: b */
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!mo25646m()) {
            return false;
        }
        if (this.f17269C == null || this.f17269C.onMenuItemActionExpand(this)) {
            return this.f17276a.mo25572c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f17301z & 8) == 0) {
            return false;
        }
        if (this.f17267A == null) {
            return true;
        }
        if (this.f17269C == null || this.f17269C.onMenuItemActionCollapse(this)) {
            return this.f17276a.mo25577d(this);
        }
        return false;
    }

    /* renamed from: m */
    public boolean mo25646m() {
        if ((this.f17301z & 8) == 0) {
            return false;
        }
        if (this.f17267A == null && this.f17268B != null) {
            this.f17267A = this.f17268B.onCreateActionView(this);
        }
        if (this.f17267A != null) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public void mo25620e(boolean z) {
        this.f17270D = z;
        this.f17276a.mo25567b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f17270D;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f17269C = onActionExpandListener;
        return this;
    }

    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f17293r = charSequence;
        this.f17276a.mo25567b(false);
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f17293r;
    }

    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f17294s = charSequence;
        this.f17276a.mo25567b(false);
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f17294s;
    }

    /* renamed from: n */
    public ColorStateList mo25647n() {
        return this.f17272J;
    }

    /* renamed from: a */
    public MenuItem mo25605a(ColorStateList colorStateList) {
        this.f17272J = colorStateList;
        this.f17276a.mo25567b(false);
        return this;
    }

    /* renamed from: o */
    public boolean mo25648o() {
        return this.f17274L;
    }

    /* renamed from: p */
    public boolean mo25649p() {
        return (this.f17300y & 64) != 0;
    }

    /* renamed from: q */
    public boolean mo25650q() {
        return this.f17275M;
    }
}
