package com.meizu.update.display;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.meizu.update.util.Loger;

public class KeyguardHelperActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Loger.m17942c("KeyguardHelperActivity create");
        super.onCreate(bundle);
        Window window = getWindow();
        window.addFlags(4194304);
        window.addFlags(524288);
        window.addFlags(2097152);
        finish();
    }
}
