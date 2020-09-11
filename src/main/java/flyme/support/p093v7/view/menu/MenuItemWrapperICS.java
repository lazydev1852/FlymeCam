package flyme.support.p093v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenuItem;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@TargetApi(14)
/* renamed from: flyme.support.v7.view.menu.MenuItemWrapperICS */
public class MenuItemWrapperICS extends BaseMenuWrapper<SupportMenuItem> implements MenuItem {

    /* renamed from: c */
    private Method f17303c;

    MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    public int getItemId() {
        return ((SupportMenuItem) this.f17326b).getItemId();
    }

    public int getGroupId() {
        return ((SupportMenuItem) this.f17326b).getGroupId();
    }

    public int getOrder() {
        return ((SupportMenuItem) this.f17326b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.f17326b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((SupportMenuItem) this.f17326b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((SupportMenuItem) this.f17326b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.f17326b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.f17326b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.f17326b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((SupportMenuItem) this.f17326b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((SupportMenuItem) this.f17326b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.f17326b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((SupportMenuItem) this.f17326b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((SupportMenuItem) this.f17326b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((SupportMenuItem) this.f17326b).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((SupportMenuItem) this.f17326b).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((SupportMenuItem) this.f17326b).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.f17326b).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((SupportMenuItem) this.f17326b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((SupportMenuItem) this.f17326b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((SupportMenuItem) this.f17326b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((SupportMenuItem) this.f17326b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((SupportMenuItem) this.f17326b).setVisible(z);
    }

    public boolean isVisible() {
        return ((SupportMenuItem) this.f17326b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((SupportMenuItem) this.f17326b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((SupportMenuItem) this.f17326b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.f17326b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return mo25744a(((SupportMenuItem) this.f17326b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.f17326b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C3163b(onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.f17326b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((SupportMenuItem) this.f17326b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.f17326b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        ((SupportMenuItem) this.f17326b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((SupportMenuItem) this.f17326b).setActionView(i);
        View actionView = ((SupportMenuItem) this.f17326b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((SupportMenuItem) this.f17326b).setActionView((View) new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((SupportMenuItem) this.f17326b).getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? ((CollapsibleActionViewWrapper) actionView).getWrappedView() : actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((SupportMenuItem) this.f17326b).setSupportActionProvider(actionProvider != null ? mo25668a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider supportActionProvider = ((SupportMenuItem) this.f17326b).getSupportActionProvider();
        if (supportActionProvider instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) supportActionProvider).f17304a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((SupportMenuItem) this.f17326b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((SupportMenuItem) this.f17326b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.f17326b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.f17326b).setOnActionExpandListener(onActionExpandListener != null ? new C3162a(onActionExpandListener) : null);
        return this;
    }

    /* renamed from: a */
    public void mo25669a(boolean z) {
        try {
            if (this.f17303c == null) {
                this.f17303c = ((SupportMenuItem) this.f17326b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f17303c.invoke(this.f17326b, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ActionProviderWrapper mo25668a(ActionProvider actionProvider) {
        return new ActionProviderWrapper(this.f17323a, actionProvider);
    }

    /* renamed from: flyme.support.v7.view.menu.MenuItemWrapperICS$b */
    private class C3163b extends BaseWrapper<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        C3163b(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f17326b).onMenuItemClick(MenuItemWrapperICS.this.mo25743a(menuItem));
        }
    }

    /* renamed from: flyme.support.v7.view.menu.MenuItemWrapperICS$a */
    private class C3162a extends BaseWrapper<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        C3162a(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f17326b).onMenuItemActionExpand(MenuItemWrapperICS.this.mo25743a(menuItem));
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f17326b).onMenuItemActionCollapse(MenuItemWrapperICS.this.mo25743a(menuItem));
        }
    }

    /* renamed from: flyme.support.v7.view.menu.MenuItemWrapperICS$ActionProviderWrapper */
    class ActionProviderWrapper extends androidx.core.view.ActionProvider {

        /* renamed from: a */
        final ActionProvider f17304a;

        public ActionProviderWrapper(Context context, ActionProvider actionProvider) {
            super(context);
            this.f17304a = actionProvider;
        }

        public View onCreateActionView() {
            return this.f17304a.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.f17304a.onPerformDefaultAction();
        }

        public boolean hasSubMenu() {
            return this.f17304a.hasSubMenu();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f17304a.onPrepareSubMenu(MenuItemWrapperICS.this.mo25744a(subMenu));
        }
    }

    /* renamed from: flyme.support.v7.view.menu.MenuItemWrapperICS$CollapsibleActionViewWrapper */
    static class CollapsibleActionViewWrapper extends FrameLayout implements androidx.appcompat.view.CollapsibleActionView {

        /* renamed from: a */
        final CollapsibleActionView f17306a;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f17306a = (CollapsibleActionView) view;
            addView(view);
        }

        public void onActionViewExpanded() {
            this.f17306a.onActionViewExpanded();
        }

        public void onActionViewCollapsed() {
            this.f17306a.onActionViewCollapsed();
        }

        /* access modifiers changed from: package-private */
        public View getWrappedView() {
            return (View) this.f17306a;
        }
    }
}
