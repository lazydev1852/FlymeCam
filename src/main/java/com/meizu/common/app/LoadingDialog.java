package com.meizu.common.app;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.meizu.common.R;
import com.meizu.common.util.ReflectUtils;
import com.meizu.common.widget.SwimmingAnimationView;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;

public class LoadingDialog extends Dialog {

    /* renamed from: a */
    private Context f4126a;

    /* renamed from: b */
    private Window f4127b;

    /* renamed from: c */
    private boolean f4128c;

    /* renamed from: d */
    private CharSequence f4129d;
    @ColorInt

    /* renamed from: e */
    private int f4130e;

    /* renamed from: f */
    private float f4131f;

    /* renamed from: g */
    private Drawable f4132g;

    /* renamed from: h */
    private LinearLayout f4133h;

    /* renamed from: i */
    private SwimmingAnimationView f4134i;

    /* renamed from: j */
    private TextView f4135j;

    /* renamed from: k */
    private int f4136k;

    public LoadingDialog(Context context) {
        this(context, R.style.LoadingDialogTheme);
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
        this.f4128c = true;
        this.f4130e = -1;
        this.f4131f = 0.7f;
        this.f4136k = 0;
        this.f4126a = getContext();
        this.f4132g = this.f4126a.getResources().getDrawable(R.drawable.mc_loading_alert);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4127b = getWindow();
        if (this.f4127b != null) {
            this.f4127b.requestFeature(1);
            this.f4127b.setDimAmount(this.f4131f);
            this.f4127b.setBackgroundDrawable(this.f4132g);
            this.f4127b.getDecorView().setSystemUiVisibility(8192);
            try {
                WindowManager.LayoutParams attributes = this.f4127b.getAttributes();
                ReflectUtils.m5142a((Object) attributes).mo16007a("statusBarColor").mo16010a(attributes, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
                this.f4127b.setAttributes(attributes);
            } catch (Exception e) {
                Log.w("LoadingDialog", "statusBarColor set failed, " + e.getMessage());
            }
        }
        setContentView(R.layout.loading_alert_dialog);
        m4858a();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Log.d("LoadingDialog", UxipConstants.RESPONSE_KEY_UPLOADPOLICY_ONSTART);
        this.f4134i.mo17437a();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        Log.d("LoadingDialog", "onStop");
        this.f4134i.mo17438b();
    }

    /* renamed from: a */
    private void m4858a() {
        this.f4133h = (LinearLayout) findViewById(R.id.rootLayout);
        this.f4134i = (SwimmingAnimationView) findViewById(R.id.applyAnimView);
        this.f4135j = (TextView) findViewById(R.id.applyAnimTitle);
        m4859b();
        m4860c();
    }

    /* renamed from: b */
    private void m4859b() {
        if (this.f4135j != null) {
            if (TextUtils.isEmpty(this.f4129d)) {
                this.f4135j.setVisibility(8);
                return;
            }
            this.f4135j.setVisibility(0);
            this.f4135j.setText(this.f4129d);
            this.f4135j.setTextColor(this.f4130e);
        }
    }

    /* renamed from: c */
    private void m4860c() {
        if (this.f4134i != null) {
            this.f4134i.setVisibility(this.f4136k);
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.f4128c = z;
    }
}
