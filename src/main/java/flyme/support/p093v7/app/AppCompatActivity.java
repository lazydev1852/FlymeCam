package flyme.support.p093v7.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.FragmentActivity;
import flyme.support.p093v7.util.C3149b;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.view.menu.FMenu;
import flyme.support.p093v7.view.menu.FMenuItem;

/* renamed from: flyme.support.v7.app.AppCompatActivity */
public class AppCompatActivity extends FragmentActivity implements ActionBarDrawerToggle.DelegateProvider, TaskStackBuilder.SupportParentable, AppCompatCallback {

    /* renamed from: a */
    private AppCompatDelegate f16721a;

    /* renamed from: b */
    private int f16722b = 0;

    /* renamed from: c */
    private Resources f16723c;

    /* renamed from: d */
    private boolean f16724d;

    @Nullable
    /* renamed from: a */
    public ActionMode mo25148a(@NonNull ActionMode.C3152b bVar) {
        return null;
    }

    @CallSuper
    /* renamed from: a */
    public void mo25151a(@NonNull ActionMode bVar) {
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
        return false;
    }

    /* renamed from: b */
    public void mo25158b(@NonNull TaskStackBuilder taskStackBuilder) {
    }

    @CallSuper
    /* renamed from: b */
    public void mo25159b(@NonNull ActionMode bVar) {
    }

    /* renamed from: b */
    public void mo25160b(FMenu dVar) {
    }

    @Deprecated
    /* renamed from: f */
    public void mo25163f() {
    }

    /* renamed from: h */
    public void mo25168h() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AppCompatDelegate g = mo25165g();
        g.mo25197h();
        g.mo25181a(bundle);
        if (g.mo25198i() && this.f16722b != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f16722b, false);
            } else {
                setTheme(this.f16722b);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(@StyleRes int i) {
        super.setTheme(i);
        this.f16722b = i;
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        mo25165g().mo25187b(bundle);
    }

    @Nullable
    /* renamed from: d */
    public ActionBar mo25161d() {
        return mo25165g().mo25179a();
    }

    public MenuInflater getMenuInflater() {
        return mo25165g().mo25185b();
    }

    public void setContentView(@LayoutRes int i) {
        mo25165g().mo25186b(i);
    }

    public void setContentView(View view) {
        mo25165g().mo25182a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo25165g().mo25183a(view, layoutParams);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo25165g().mo25188b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mo25165g().mo25180a(configuration);
        if (this.f16723c != null) {
            this.f16723c.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        mo25165g().mo25189c();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        mo25165g().mo25192d();
    }

    @Nullable
    public View findViewById(@IdRes int i) {
        return mo25165g().mo25178a(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar d = mo25161d();
        if (menuItem.getItemId() != 16908332 || d == null || (d.mo25034a() & 4) == 0) {
            return false;
        }
        return mo25162e();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        mo25165g().mo25195f();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        mo25165g().mo25184a(charSequence);
    }

    public void supportInvalidateOptionsMenu() {
        mo25165g().mo25194e();
    }

    public void invalidateOptionsMenu() {
        mo25165g().mo25194e();
    }

    /* renamed from: a */
    public void mo25150a(@NonNull TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack((Activity) this);
    }

    /* renamed from: e */
    public boolean mo25162e() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (mo25153a(supportParentActivityIntent)) {
            TaskStackBuilder create = TaskStackBuilder.create(this);
            mo25150a(create);
            mo25158b(create);
            create.startActivities();
            try {
                ActivityCompat.finishAffinity(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            mo25157b(supportParentActivityIntent);
            return true;
        }
    }

    @Nullable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    /* renamed from: a */
    public boolean mo25153a(@NonNull Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }

    /* renamed from: b */
    public void mo25157b(@NonNull Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }

    public void onContentChanged() {
        mo25163f();
    }

    @Nullable
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return mo25165g().mo25196g();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        mo25165g().mo25190c(bundle);
        this.f16724d = true;
    }

    @NonNull
    /* renamed from: g */
    public AppCompatDelegate mo25165g() {
        if (this.f16721a == null) {
            this.f16721a = AppCompatDelegate.m18287a((Activity) this, (AppCompatCallback) this);
        }
        return this.f16721a;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.f16723c == null && VectorEnabledTintResources.shouldBeUsed()) {
            this.f16723c = new VectorEnabledTintResources(this, super.getResources());
        }
        return this.f16723c == null ? super.getResources() : this.f16723c;
    }

    /* renamed from: a */
    public void mo25149a(int i) {
        mo25165g().mo25193d(i);
    }

    public void supportFinishAfterTransition() {
        if (!getFragmentManager().popBackStackImmediate()) {
            super.supportFinishAfterTransition();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f16724d = false;
    }

    public void onBackPressed() {
        if (this.f16724d) {
            Log.d("AppCompatActivity", "onBackPressed after onSaveInstanceState: mStateSaved = " + C3149b.m18746a(getSupportFragmentManager()));
            C3149b.m18747a(getSupportFragmentManager(), false);
            C3149b.m18747a(getFragmentManager(), false);
        }
        super.onBackPressed();
    }
}
