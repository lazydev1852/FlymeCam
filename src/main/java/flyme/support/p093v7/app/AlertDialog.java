package flyme.support.p093v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import flyme.support.p093v7.app.AlertController;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.app.AlertDialog */
public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: a */
    final AlertController f16717a;

    protected AlertDialog(@NonNull Context context) {
        this(context, 0);
    }

    protected AlertDialog(@NonNull Context context, @StyleRes int i) {
        super(context, m18238a(context, i));
        this.f16717a = m18239a(getContext(), this, getWindow());
    }

    /* renamed from: a */
    public static final AlertController m18239a(Context context, AppCompatDialog appCompatDialog, Window window) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        int i = obtainStyledAttributes.getInt(R.styleable.AlertDialog_controllerType, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        obtainStyledAttributes.recycle();
        if (resourceId == R.layout.mz_alert_dialog_appcompat) {
            i = 1;
        }
        if (i != 1) {
            return new AlertController(context, appCompatDialog, window);
        }
        return new FlymeAlertController(context, appCompatDialog, window);
    }

    /* renamed from: a */
    static int m18238a(@NonNull Context context, @StyleRes int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: a */
    public Button mo25117a(int i) {
        return this.f16717a.mo25098d(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f16717a.mo25090a(charSequence);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16717a.mo25084a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f16717a.mo25091a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f16717a.mo25095b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* renamed from: flyme.support.v7.app.AlertDialog$Builder */
    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final AlertController.C3083a f16718a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final int f16719b;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* renamed from: flyme.support.v7.app.AlertDialog$Builder$a */
        public interface C3092a<T extends AlertDialog> {
            /* renamed from: a */
            T mo25147a(@NonNull Context context, @StyleRes int i);
        }

        public Builder(@NonNull Context context) {
            this(context, AlertDialog.m18238a(context, 0));
        }

        public Builder(@NonNull Context context, @StyleRes int i) {
            this.f16718a = new AlertController.C3083a(new ContextThemeWrapper(context, AlertDialog.m18238a(context, i)));
            this.f16719b = i;
        }

        @NonNull
        /* renamed from: a */
        public Context mo25123a() {
            return this.f16718a.f16678a;
        }

        /* renamed from: a */
        public Builder mo25124a(@StringRes int i) {
            this.f16718a.f16683f = this.f16718a.f16678a.getText(i);
            return this;
        }

        /* renamed from: a */
        public Builder mo25131a(@Nullable CharSequence charSequence) {
            this.f16718a.f16683f = charSequence;
            return this;
        }

        /* renamed from: a */
        public Builder mo25129a(@Nullable View view) {
            this.f16718a.f16684g = view;
            return this;
        }

        /* renamed from: b */
        public Builder mo25136b(@StringRes int i) {
            this.f16718a.f16685h = this.f16718a.f16678a.getText(i);
            return this;
        }

        /* renamed from: b */
        public Builder mo25139b(@Nullable CharSequence charSequence) {
            this.f16718a.f16685h = charSequence;
            return this;
        }

        /* renamed from: c */
        public Builder mo25142c(@DrawableRes int i) {
            this.f16718a.f16680c = i;
            return this;
        }

        /* renamed from: a */
        public Builder mo25128a(@Nullable Drawable drawable) {
            this.f16718a.f16681d = drawable;
            return this;
        }

        /* renamed from: d */
        public Builder mo25145d(@AttrRes int i) {
            TypedValue typedValue = new TypedValue();
            this.f16718a.f16678a.getTheme().resolveAttribute(i, typedValue, true);
            this.f16718a.f16680c = typedValue.resourceId;
            return this;
        }

        /* renamed from: a */
        public Builder mo25125a(@StringRes int i, DialogInterface.OnClickListener onClickListener) {
            this.f16718a.f16686i = this.f16718a.f16678a.getText(i);
            this.f16718a.f16688k = onClickListener;
            return this;
        }

        /* renamed from: a */
        public Builder mo25132a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f16718a.f16686i = charSequence;
            this.f16718a.f16688k = onClickListener;
            return this;
        }

        /* renamed from: b */
        public Builder mo25137b(@StringRes int i, DialogInterface.OnClickListener onClickListener) {
            this.f16718a.f16689l = this.f16718a.f16678a.getText(i);
            this.f16718a.f16691n = onClickListener;
            return this;
        }

        /* renamed from: b */
        public Builder mo25140b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f16718a.f16689l = charSequence;
            this.f16718a.f16691n = onClickListener;
            return this;
        }

        /* renamed from: c */
        public Builder mo25143c(@StringRes int i, DialogInterface.OnClickListener onClickListener) {
            this.f16718a.f16692o = this.f16718a.f16678a.getText(i);
            this.f16718a.f16694q = onClickListener;
            return this;
        }

        /* renamed from: c */
        public Builder mo25144c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f16718a.f16692o = charSequence;
            this.f16718a.f16694q = onClickListener;
            return this;
        }

        /* renamed from: a */
        public Builder mo25133a(boolean z) {
            this.f16718a.f16695r = z;
            return this;
        }

        /* renamed from: a */
        public Builder mo25126a(DialogInterface.OnCancelListener onCancelListener) {
            this.f16718a.f16696s = onCancelListener;
            return this;
        }

        /* renamed from: a */
        public Builder mo25127a(DialogInterface.OnKeyListener onKeyListener) {
            this.f16718a.f16698u = onKeyListener;
            return this;
        }

        /* renamed from: a */
        public Builder mo25130a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f16718a.f16700w = listAdapter;
            this.f16718a.f16701x = onClickListener;
            return this;
        }

        /* renamed from: a */
        public Builder mo25134a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.f16718a.f16699v = charSequenceArr;
            this.f16718a.f16701x = onClickListener;
            this.f16718a.f16665I = i;
            this.f16718a.f16664H = true;
            return this;
        }

        /* renamed from: b */
        public Builder mo25138b(View view) {
            this.f16718a.f16703z = view;
            this.f16718a.f16702y = 0;
            this.f16718a.f16661E = false;
            return this;
        }

        /* renamed from: b */
        public AlertDialog mo25141b() {
            return mo25135a(new C3092a<AlertDialog>() {
                /* renamed from: a */
                public AlertDialog mo25147a(@NonNull Context context, int i) {
                    return new AlertDialog(Builder.this.f16718a.f16678a, Builder.this.f16719b);
                }
            });
        }

        /* renamed from: e */
        public Builder mo25146e(int i) {
            this.f16718a.f16676T = i;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* renamed from: a */
        public <T extends AlertDialog> T mo25135a(C3092a<T> aVar) {
            T a = aVar.mo25147a(this.f16718a.f16678a, this.f16719b);
            this.f16718a.mo25107a(a.f16717a);
            a.setCancelable(this.f16718a.f16695r);
            if (this.f16718a.f16695r) {
                a.setCanceledOnTouchOutside(true);
            }
            a.setOnCancelListener(this.f16718a.f16696s);
            a.setOnDismissListener(this.f16718a.f16697t);
            if (this.f16718a.f16698u != null) {
                a.setOnKeyListener(this.f16718a.f16698u);
            }
            return a;
        }
    }

    /* renamed from: a */
    public void mo25118a(int i, int i2, int i3, int i4) {
        this.f16717a.mo25086a(i, i2, i3, i4);
    }
}
