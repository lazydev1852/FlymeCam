package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import flyme.support.p093v7.widget.ToolbarWidgetWrapper;

/* renamed from: flyme.support.v7.widget.e */
public class ControlTitleBarController {

    /* renamed from: a */
    private ControlTitleBar f18457a;

    /* renamed from: b */
    private View.OnClickListener f18458b;

    /* renamed from: c */
    private View.OnClickListener f18459c;

    /* renamed from: d */
    private ToolbarWidgetWrapper.C3349a f18460d;

    /* renamed from: e */
    private ToolbarWidgetWrapper.C3349a f18461e;

    /* renamed from: f */
    private boolean f18462f = false;

    /* renamed from: g */
    private CharSequence f18463g;

    /* renamed from: a */
    public ControlTitleBar mo27107a(Context context) {
        if (this.f18457a == null) {
            this.f18457a = new ControlTitleBar(context);
        }
        return this.f18457a;
    }

    /* renamed from: a */
    public void mo27109a(int i, ToolbarWidgetWrapper.C3349a aVar, View.OnClickListener onClickListener) {
        aVar.mo27264a(this);
        if (i == 1) {
            this.f18460d = aVar;
            this.f18458b = onClickListener;
            return;
        }
        this.f18461e = aVar;
        this.f18459c = onClickListener;
    }

    /* renamed from: a */
    public void mo27108a() {
        Drawable drawable;
        String str;
        int i;
        Drawable drawable2;
        if (!this.f18462f) {
            this.f18457a.setTitle(this.f18463g);
            int i2 = -1;
            String str2 = null;
            if (this.f18460d != null) {
                i = this.f18460d.mo27266b();
                str = this.f18460d.mo27261a();
                drawable = this.f18460d.mo27267c();
            } else {
                str = null;
                drawable = null;
                i = -1;
            }
            if (this.f18461e != null) {
                i2 = this.f18461e.mo27266b();
                str2 = this.f18461e.mo27261a();
                drawable2 = this.f18461e.mo27267c();
            } else {
                drawable2 = null;
            }
            this.f18457a.setButton(0, str2, drawable2, this.f18459c);
            this.f18457a.setButton(1, str, drawable, this.f18458b);
            View positiveItemView = this.f18457a.getPositiveItemView();
            positiveItemView.setEnabled(this.f18460d.mo27268d());
            positiveItemView.setId(i);
            if (!this.f18460d.mo27269e() || (this.f18460d.mo27267c() == null && TextUtils.isEmpty(this.f18460d.mo27261a()))) {
                positiveItemView.setVisibility(8);
            } else {
                positiveItemView.setVisibility(0);
            }
            View negativeItemView = this.f18457a.getNegativeItemView();
            negativeItemView.setEnabled(this.f18461e.mo27268d());
            negativeItemView.setId(i2);
            if (!this.f18461e.mo27269e() || (this.f18461e.mo27267c() == null && TextUtils.isEmpty(this.f18461e.mo27261a()))) {
                negativeItemView.setVisibility(8);
            } else {
                negativeItemView.setVisibility(0);
            }
        }
    }

    /* renamed from: b */
    public void mo27111b() {
        if (!this.f18462f) {
            this.f18462f = true;
        }
    }

    /* renamed from: c */
    public void mo27112c() {
        this.f18462f = false;
        mo27108a();
    }

    /* renamed from: a */
    public void mo27110a(CharSequence charSequence) {
        this.f18463g = charSequence;
        if (this.f18457a != null) {
            this.f18457a.setTitle(this.f18463g);
        }
    }
}
