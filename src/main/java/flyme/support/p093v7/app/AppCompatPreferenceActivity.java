package flyme.support.p093v7.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.view.menu.FMenu;
import flyme.support.p093v7.view.menu.FMenuItem;

/* renamed from: flyme.support.v7.app.AppCompatPreferenceActivity */
public class AppCompatPreferenceActivity extends PreferenceActivity implements ActionBarDrawerToggle.DelegateProvider, TaskStackBuilder.SupportParentable, AppCompatCallback {

    /* renamed from: a */
    private AppCompatDelegate f16820a;

    @Nullable
    /* renamed from: a */
    public ActionMode mo25148a(ActionMode.C3152b bVar) {
        return null;
    }

    /* renamed from: a */
    public void mo25151a(ActionMode bVar) {
    }

    /* renamed from: a */
    public boolean mo25152a(int i, FMenuItem fMenuItem) {
        return false;
    }

    /* renamed from: a */
    public boolean mo25154a(FMenuItem fMenuItem) {
        return false;
    }

    /* renamed from: a */
    public boolean mo25155a(FMenu dVar) {
        return true;
    }

    /* renamed from: b */
    public void mo25263b(TaskStackBuilder taskStackBuilder) {
    }

    /* renamed from: b */
    public void mo25159b(ActionMode bVar) {
    }

    /* renamed from: b */
    public void mo25160b(FMenu dVar) {
    }

    /* renamed from: h */
    public void mo25168h() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        mo25265c().mo25197h();
        mo25265c().mo25181a(bundle);
        super.onCreate(bundle);
        if ((getWindow().getAttributes().flags & 67108864) != 0) {
            m18457d();
        }
    }

    public boolean onIsHidingHeaders() {
        try {
            return super.onIsHidingHeaders();
        } catch (RuntimeException e) {
            if (e.getCause() instanceof ClassNotFoundException) {
                Log.e("AppCompat", e.getMessage());
                return false;
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        mo25265c().mo25187b(bundle);
    }

    /* renamed from: a */
    public ActionBar mo25258a() {
        return mo25265c().mo25179a();
    }

    public MenuInflater getMenuInflater() {
        return mo25265c().mo25185b();
    }

    public void setContentView(@LayoutRes int i) {
        mo25265c().mo25186b(i);
    }

    public void setContentView(View view) {
        mo25265c().mo25182a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo25265c().mo25183a(view, layoutParams);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo25265c().mo25188b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mo25265c().mo25180a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        mo25265c().mo25189c();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        mo25265c().mo25192d();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar a = mo25258a();
        if (menuItem.getItemId() != 16908332 || a == null || (a.mo25034a() & 4) == 0) {
            return false;
        }
        return mo25264b();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        mo25265c().mo25195f();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        mo25265c().mo25184a(charSequence);
    }

    public void invalidateOptionsMenu() {
        mo25265c().mo25194e();
    }

    /* renamed from: a */
    public void mo25259a(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack((Activity) this);
    }

    /* renamed from: b */
    public boolean mo25264b() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (mo25260a(supportParentActivityIntent)) {
            TaskStackBuilder create = TaskStackBuilder.create(this);
            mo25259a(create);
            mo25263b(create);
            create.startActivities();
            try {
                ActivityCompat.finishAffinity(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            mo25262b(supportParentActivityIntent);
            return true;
        }
    }

    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    /* renamed from: a */
    public boolean mo25260a(Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }

    /* renamed from: b */
    public void mo25262b(Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }

    @Nullable
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return mo25265c().mo25196g();
    }

    /* renamed from: c */
    public AppCompatDelegate mo25265c() {
        if (this.f16820a == null) {
            this.f16820a = AppCompatDelegate.m18287a((Activity) this, (AppCompatCallback) this);
        }
        return this.f16820a;
    }

    /* renamed from: d */
    private void m18457d() {
        ListView listView;
        try {
            listView = getListView();
        } catch (Exception unused) {
            listView = null;
        }
        if (listView != null) {
            listView.setFitsSystemWindows(true);
            listView.setClipToPadding(false);
            listView.setScrollBarStyle(0);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
