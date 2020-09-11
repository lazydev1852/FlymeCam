package flyme.support.p093v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import flyme.support.p093v7.view.menu.MenuItemWrapperICS;

@TargetApi(16)
/* renamed from: flyme.support.v7.view.menu.MenuItemWrapperJB */
public class MenuItemWrapperJB extends MenuItemWrapperICS {
    MenuItemWrapperJB(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public MenuItemWrapperICS.ActionProviderWrapper mo25668a(ActionProvider actionProvider) {
        return new ActionProviderWrapperJB(this.f17323a, actionProvider);
    }

    /* renamed from: flyme.support.v7.view.menu.MenuItemWrapperJB$ActionProviderWrapperJB */
    class ActionProviderWrapperJB extends MenuItemWrapperICS.ActionProviderWrapper implements ActionProvider.VisibilityListener {

        /* renamed from: c */
        ActionProvider.VisibilityListener f17309c;

        public ActionProviderWrapperJB(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.f17304a.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.f17304a.overridesItemVisibility();
        }

        public boolean isVisible() {
            return this.f17304a.isVisible();
        }

        public void refreshVisibility() {
            this.f17304a.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            this.f17309c = visibilityListener;
            this.f17304a.setVisibilityListener(visibilityListener != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f17309c != null) {
                this.f17309c.onActionProviderVisibilityChanged(z);
            }
        }
    }
}
