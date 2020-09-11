package flyme.support.p093v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.view.menu.FMenu;
import flyme.support.p093v7.view.menu.FMenuItem;

/* renamed from: flyme.support.v7.app.AppCompatDialog */
public class AppCompatDialog extends Dialog implements AppCompatCallback {

    /* renamed from: a */
    private AppCompatDelegate f16819a;

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
        return false;
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

    public AppCompatDialog(Context context) {
        this(context, 0);
    }

    public AppCompatDialog(Context context, int i) {
        super(context, m18446a(context, i));
        mo25248a().mo25181a((Bundle) null);
        mo25248a().mo25198i();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        mo25248a().mo25197h();
        super.onCreate(bundle);
        mo25248a().mo25181a(bundle);
    }

    public void setContentView(@LayoutRes int i) {
        mo25248a().mo25186b(i);
    }

    public void setContentView(View view) {
        mo25248a().mo25182a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo25248a().mo25183a(view, layoutParams);
    }

    @Nullable
    public View findViewById(@IdRes int i) {
        return mo25248a().mo25178a(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        mo25248a().mo25184a(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        mo25248a().mo25184a((CharSequence) getContext().getString(i));
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo25248a().mo25188b(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        mo25248a().mo25189c();
    }

    /* renamed from: b */
    public boolean mo25250b(int i) {
        return mo25248a().mo25191c(i);
    }

    public void invalidateOptionsMenu() {
        mo25248a().mo25194e();
    }

    /* renamed from: a */
    public AppCompatDelegate mo25248a() {
        if (this.f16819a == null) {
            this.f16819a = AppCompatDelegate.m18288a((Dialog) this, (AppCompatCallback) this);
        }
        return this.f16819a;
    }

    /* renamed from: a */
    private static int m18446a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }
}
