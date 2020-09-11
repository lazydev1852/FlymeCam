package flyme.support.p093v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: flyme.support.v7.app.AppCompatDelegate */
public abstract class AppCompatDelegate {

    /* renamed from: a */
    private static int f16725a = -1;

    /* renamed from: b */
    private static boolean f16726b = false;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: flyme.support.v7.app.AppCompatDelegate$NightMode */
    public @interface NightMode {
    }

    @Nullable
    /* renamed from: a */
    public abstract View mo25178a(@IdRes int i);

    @Nullable
    /* renamed from: a */
    public abstract ActionBar mo25179a();

    /* renamed from: a */
    public abstract void mo25180a(Configuration configuration);

    /* renamed from: a */
    public abstract void mo25181a(Bundle bundle);

    /* renamed from: a */
    public abstract void mo25182a(View view);

    /* renamed from: a */
    public abstract void mo25183a(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: a */
    public abstract void mo25184a(@Nullable CharSequence charSequence);

    /* renamed from: b */
    public abstract MenuInflater mo25185b();

    /* renamed from: b */
    public abstract void mo25186b(@LayoutRes int i);

    /* renamed from: b */
    public abstract void mo25187b(Bundle bundle);

    /* renamed from: b */
    public abstract void mo25188b(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: c */
    public abstract void mo25189c();

    /* renamed from: c */
    public abstract void mo25190c(Bundle bundle);

    /* renamed from: c */
    public abstract boolean mo25191c(int i);

    /* renamed from: d */
    public abstract void mo25192d();

    /* renamed from: d */
    public abstract void mo25193d(int i);

    /* renamed from: e */
    public abstract void mo25194e();

    /* renamed from: f */
    public abstract void mo25195f();

    @Nullable
    /* renamed from: g */
    public abstract ActionBarDrawerToggle.Delegate mo25196g();

    /* renamed from: h */
    public abstract void mo25197h();

    /* renamed from: i */
    public abstract boolean mo25198i();

    /* renamed from: a */
    public static AppCompatDelegate m18287a(Activity activity, AppCompatCallback aVar) {
        return m18289a(activity, activity.getWindow(), aVar);
    }

    /* renamed from: a */
    public static AppCompatDelegate m18288a(Dialog dialog, AppCompatCallback aVar) {
        return m18289a(dialog.getContext(), dialog.getWindow(), aVar);
    }

    /* renamed from: a */
    private static AppCompatDelegate m18289a(Context context, Window window, AppCompatCallback aVar) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return new AppCompatDelegateImplV23(context, window, aVar);
        }
        if (i >= 14) {
            return new AppCompatDelegateImplV14(context, window, aVar);
        }
        if (i >= 11) {
            return new AppCompatDelegateImplV11(context, window, aVar);
        }
        return new AppCompatDelegateImplV7(context, window, aVar);
    }

    AppCompatDelegate() {
    }

    /* renamed from: j */
    public static int m18290j() {
        return f16725a;
    }
}
