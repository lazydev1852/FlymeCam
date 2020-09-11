package com.meizu.common.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;

public class LoadingAlertDialog extends AlertDialog {

    /* renamed from: a */
    private LinearLayout f5556a;

    /* renamed from: b */
    private LoadingAnimationView f5557b;

    /* renamed from: c */
    private TextView f5558c;

    public LoadingAlertDialog(Context context) {
        super(context);
        create();
    }

    public LoadingAlertDialog(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.7f;
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.mc_loading_alert));
        setContentView(R.layout.loading_alert_dialog);
        this.f5556a = (LinearLayout) findViewById(R.id.rootLayout);
        this.f5557b = (LoadingAnimationView) findViewById(R.id.applyAnimView);
        this.f5558c = (TextView) findViewById(R.id.applyAnimTitle);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    public void setMessage(CharSequence charSequence) {
        if (this.f5558c != null) {
            this.f5558c.setText(charSequence);
        }
    }
}
