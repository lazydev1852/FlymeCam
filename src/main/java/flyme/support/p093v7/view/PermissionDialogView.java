package flyme.support.p093v7.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import flyme.support.p093v7.p095b.PermissionGroup;
import java.util.List;

/* renamed from: flyme.support.v7.view.PermissionDialogView */
public class PermissionDialogView extends RelativeLayout {

    /* renamed from: a */
    private PermissionViewHandler f17089a;

    public PermissionDialogView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PermissionDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PermissionDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f17089a = new PermissionViewHandlerImpl23(context);
        } else {
            this.f17089a = new PermissionViewHandlerImpl(context);
        }
        addView(this.f17089a.mo25427a((ViewGroup) this));
    }

    public void setPermissionDialogBuild(C3150a aVar) {
        this.f17089a.mo25429a(aVar);
    }

    public CheckBox getCheckBox() {
        return this.f17089a.mo25428a();
    }

    public CheckBox getTermsCheckBox() {
        return this.f17089a.mo25430b();
    }

    public List<PermissionGroup> getPermissions() {
        return this.f17089a.mo25431c();
    }

    /* renamed from: flyme.support.v7.view.PermissionDialogView$a */
    public static class C3150a {

        /* renamed from: a */
        String f17090a;

        /* renamed from: b */
        boolean f17091b;

        /* renamed from: c */
        String[] f17092c;

        /* renamed from: d */
        String[] f17093d;

        /* renamed from: e */
        int[] f17094e;

        /* renamed from: f */
        String f17095f;

        /* renamed from: g */
        boolean f17096g;

        /* renamed from: h */
        boolean f17097h = true;

        /* renamed from: i */
        List<Pair<String, String>> f17098i;

        /* renamed from: j */
        boolean f17099j;

        /* renamed from: a */
        public C3150a mo25403a(@NonNull String str) {
            this.f17090a = str;
            return this;
        }

        /* renamed from: a */
        public C3150a mo25405a(boolean z) {
            this.f17091b = z;
            return this;
        }

        /* renamed from: a */
        public C3150a mo25406a(@NonNull String[] strArr, String[] strArr2, int[] iArr) {
            this.f17092c = strArr;
            this.f17093d = strArr2;
            this.f17094e = iArr;
            return this;
        }

        /* renamed from: b */
        public C3150a mo25408b(String str) {
            this.f17095f = str;
            return this;
        }

        /* renamed from: b */
        public C3150a mo25409b(boolean z) {
            this.f17096g = z;
            return this;
        }

        /* renamed from: c */
        public C3150a mo25410c(boolean z) {
            this.f17097h = z;
            return this;
        }

        /* renamed from: a */
        public C3150a mo25404a(List<Pair<String, String>> list) {
            this.f17098i = list;
            return this;
        }

        /* renamed from: d */
        public C3150a mo25411d(boolean z) {
            this.f17099j = z;
            return this;
        }

        /* renamed from: a */
        public void mo25407a(PermissionDialogView permissionDialogView) {
            permissionDialogView.setPermissionDialogBuild(this);
        }
    }
}
