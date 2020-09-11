package flyme.support.p093v7.app;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.ActionMode;
import flyme.support.p093v7.widget.MzActionBarTabContainer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: flyme.support.v7.app.ActionBar */
public abstract class ActionBar {

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: flyme.support.v7.app.ActionBar$DisplayOptions */
    public @interface DisplayOptions {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: flyme.support.v7.app.ActionBar$NavigationMode */
    public @interface NavigationMode {
    }

    /* renamed from: flyme.support.v7.app.ActionBar$a */
    public interface C3071a {
    }

    /* renamed from: flyme.support.v7.app.ActionBar$b */
    public interface C3072b {
        /* renamed from: a */
        void mo25062a(int i, C3071a aVar);
    }

    /* renamed from: flyme.support.v7.app.ActionBar$c */
    public interface C3073c {
        /* renamed from: a */
        void mo25063a();

        /* renamed from: b */
        void mo25064b();

        /* renamed from: c */
        void mo25065c();

        /* renamed from: d */
        void mo25066d();
    }

    /* renamed from: flyme.support.v7.app.ActionBar$e */
    public interface C3075e {
        /* renamed from: a */
        void mo25067a(boolean z);
    }

    /* renamed from: flyme.support.v7.app.ActionBar$f */
    public interface C3076f {
        /* renamed from: a */
        void mo25068a(boolean z);

        /* renamed from: b */
        void mo25069b(boolean z);
    }

    /* renamed from: flyme.support.v7.app.ActionBar$g */
    public static abstract class C3077g {
        /* renamed from: a */
        public abstract int mo25070a();

        /* renamed from: a */
        public abstract void mo25071a(int i);

        /* renamed from: a */
        public abstract void mo25072a(int i, int i2);

        /* renamed from: a */
        public abstract void mo25073a(boolean z);

        /* renamed from: b */
        public abstract Drawable mo25074b();

        /* renamed from: c */
        public abstract CharSequence mo25075c();

        /* renamed from: d */
        public abstract ColorStateList mo25076d();

        /* renamed from: e */
        public abstract View mo25077e();

        /* renamed from: f */
        public abstract void mo25078f();

        /* renamed from: g */
        public abstract CharSequence mo25079g();

        /* renamed from: h */
        public abstract boolean mo25080h();

        /* renamed from: i */
        public abstract int mo25081i();

        /* renamed from: j */
        public abstract int mo25082j();

        /* renamed from: k */
        public abstract int mo25083k();
    }

    /* renamed from: a */
    public abstract int mo25034a();

    /* renamed from: a */
    public ActionMode mo25035a(ActionMode.C3152b bVar) {
        return null;
    }

    /* renamed from: a */
    public abstract void mo25037a(@StringRes int i);

    /* renamed from: a */
    public void mo25038a(Configuration configuration) {
    }

    /* renamed from: a */
    public abstract void mo25039a(@Nullable Drawable drawable);

    /* renamed from: a */
    public abstract void mo25040a(CharSequence charSequence);

    /* renamed from: a */
    public abstract void mo25041a(boolean z);

    /* renamed from: a */
    public boolean mo25042a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: b */
    public Context mo25043b() {
        return null;
    }

    /* renamed from: b */
    public ActionMode mo25044b(ActionMode.C3152b bVar) {
        return null;
    }

    /* renamed from: b */
    public abstract void mo25045b(int i);

    /* renamed from: b */
    public void mo25046b(Drawable drawable) {
    }

    /* renamed from: b */
    public void mo25047b(CharSequence charSequence) {
    }

    /* renamed from: b */
    public void mo25048b(boolean z) {
    }

    /* renamed from: c */
    public int mo25049c() {
        return 0;
    }

    /* renamed from: c */
    public void mo25050c(@DrawableRes int i) {
    }

    /* renamed from: c */
    public void mo25051c(@Nullable Drawable drawable) {
    }

    /* renamed from: d */
    public void mo25053d(@StringRes int i) {
    }

    /* renamed from: d */
    public void mo25054d(boolean z) {
    }

    /* renamed from: d */
    public boolean mo25055d() {
        return false;
    }

    /* renamed from: e */
    public void mo25056e(int i) {
    }

    /* renamed from: e */
    public void mo25057e(boolean z) {
    }

    /* renamed from: e */
    public boolean mo25058e() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo25059f() {
    }

    /* renamed from: f */
    public void mo25060f(boolean z) {
    }

    /* renamed from: g */
    public MzActionBarTabContainer mo25061g() {
        return null;
    }

    /* renamed from: c */
    public void mo25052c(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    /* renamed from: a */
    public void mo25036a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* renamed from: flyme.support.v7.app.ActionBar$d */
    public static class C3074d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f16596a;

        public C3074d(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f16596a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f16596a = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C3074d(int i, int i2) {
            super(i, i2);
            this.f16596a = 0;
            this.f16596a = 8388627;
        }

        public C3074d(C3074d dVar) {
            super(dVar);
            this.f16596a = 0;
            this.f16596a = dVar.f16596a;
        }

        public C3074d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f16596a = 0;
        }
    }
}
