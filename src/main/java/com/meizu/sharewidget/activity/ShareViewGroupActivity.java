package com.meizu.sharewidget.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.meizu.sharewidget.R;
import com.meizu.sharewidget.ResolveFilter;
import com.meizu.sharewidget.p080a.C2865c;
import com.meizu.sharewidget.p080a.C2866d;
import com.meizu.sharewidget.widget.ShareViewGroup;

public class ShareViewGroupActivity extends Activity implements ResolveFilter, ShareViewGroup.C2890a {

    /* renamed from: a */
    protected ShareViewGroup f15908a;

    /* renamed from: b */
    private Intent f15909b = null;

    /* renamed from: c */
    private ThemeModeReceiver f15910c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f15911d = false;

    /* renamed from: a */
    public void mo24077a(Intent intent, ResolveInfo resolveInfo, View view, int i, long j) {
    }

    /* renamed from: a */
    public boolean mo24078a(ResolveInfo resolveInfo) {
        return true;
    }

    public int mzNightModeUseOf() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.f15909b = getIntent();
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 17) {
            this.f15911d = Settings.Global.getInt(getContentResolver(), "flymelab_flyme_night_mode", 0) == 1;
        }
        if (!this.f15911d && !this.f15909b.getBooleanExtra("IS_NIGHT_MOD", false)) {
            z = false;
        }
        this.f15911d = z;
        m17295b();
        m17299d();
        m17297c();
        super.onCreate(bundle);
        setContentView(R.layout.app_common_layout);
        m17291a();
        m17300e();
        if (this.f15911d) {
            this.f15908a.mo24101a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m17301f();
        if (this.f15908a != null) {
            this.f15908a.mo24107c();
        }
    }

    @SuppressLint({"StringFormatMatches"})
    /* renamed from: a */
    private void m17291a() {
        this.f15908a = (ShareViewGroup) findViewById(R.id.activity_share_widget);
        this.f15908a.setTitleVisibility(true);
        if (!this.f15909b.getBooleanExtra("IS_HIDE_SUMMARY", false)) {
            if (!TextUtils.isEmpty(this.f15909b.getStringExtra("SUMMARY_STRING"))) {
                this.f15908a.setSummary(this.f15909b.getStringExtra("SUMMARY_STRING"));
            } else {
                int intExtra = this.f15909b.getIntExtra("FILE_COUNT", -1);
                int intExtra2 = this.f15909b.getIntExtra("FILE_SIZE", -1);
                if (intExtra >= 0 && intExtra2 >= 0) {
                    this.f15908a.setSummary(String.format(getResources().getString(R.string.file_selected_number), new Object[]{Integer.valueOf(intExtra), Integer.valueOf(intExtra2)}));
                }
            }
        }
        if (this.f15909b.getBooleanExtra("IS_SHOW_CHECKBOX_VIEW", false)) {
            this.f15908a.setCheckBoxVisibility(true);
        }
        ShareViewGroupActivity shareViewGroupActivity = null;
        this.f15908a.setOnShareClickListener(this.f15909b.getBooleanExtra("CUSTOM_SHARE_CLICK", false) ? this : null);
        ShareViewGroup shareViewGroup = this.f15908a;
        if (this.f15909b.getBooleanExtra("CUSTOM_SHARE_FILTER", false)) {
            shareViewGroupActivity = this;
        }
        shareViewGroup.setResolveFilter(shareViewGroupActivity);
        if (this.f15909b.getBooleanExtra("FORWARD_RESULT_FROM_NEXT_ACTIVITY", false)) {
            this.f15908a.setForwardResult(true);
        }
        this.f15908a.setIntent(this.f15909b);
        findViewById(R.id.activity_share_transparent_area).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ShareViewGroupActivity.this.finish();
            }
        });
    }

    /* renamed from: b */
    private void m17295b() {
        if ((getResources().getConfiguration().orientation == 2 && this.f15909b.getBooleanExtra("NEED_HIDE_STATUS_BAR_ON_LANDSCAPE", false)) || (getResources().getConfiguration().orientation == 1 && this.f15909b.getBooleanExtra("NEED_HIDE_STATUS_BAR_ON_PORTRAIT", false))) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17297c() {
        Resources resources;
        int i;
        if (getResources().getConfiguration().orientation != 2) {
            if (this.f15911d) {
                resources = getResources();
                i = R.color.colorNight;
            } else {
                resources = getResources();
                i = R.color.colorWhite;
            }
            int color = resources.getColor(i);
            C2865c.m17249a(getWindow(), m17292a(color), true);
            C2865c.m17247a(getWindow(), color);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m17299d() {
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
            try {
                C2866d.C2874g a = C2866d.m17250a((Class<?>) WindowManager.LayoutParams.class).mo24064a("statusBarColor");
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                a.mo24066a(attributes, Integer.valueOf(this.f15911d ? -1 : ViewCompat.MEASURED_STATE_MASK));
                getWindow().setAttributes(attributes);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private boolean m17292a(@ColorInt int i) {
        return Color.alpha(i) > 200 && Color.red(i) > 200 && Color.green(i) > 200 && Color.blue(i) > 200;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* renamed from: e */
    private void m17300e() {
        if (this.f15910c == null && !this.f15909b.getBooleanExtra("IS_FORCE_KEEP", false)) {
            this.f15910c = new ThemeModeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ACTION_CHANGE_THEME");
            registerReceiver(this.f15910c, intentFilter);
        }
    }

    /* renamed from: f */
    private void m17301f() {
        if (this.f15910c != null && !this.f15909b.getBooleanExtra("IS_FORCE_KEEP", false)) {
            unregisterReceiver(this.f15910c);
            this.f15910c = null;
        }
    }

    private class ThemeModeReceiver extends BroadcastReceiver {
        private ThemeModeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("ACTION_CHANGE_THEME".equals(intent.getAction())) {
                boolean unused = ShareViewGroupActivity.this.f15911d = intent.getBooleanExtra("IS_NIGHT_MOD", false);
                if (ShareViewGroupActivity.this.f15911d) {
                    ShareViewGroupActivity.this.setTheme(R.style.Theme_Flyme_Share_Night);
                    ShareViewGroupActivity.this.f15908a.mo24101a();
                } else {
                    ShareViewGroupActivity.this.setTheme(R.style.Theme_Flyme_Share_Day);
                    ShareViewGroupActivity.this.f15908a.mo24106b();
                }
                ShareViewGroupActivity.this.m17299d();
                ShareViewGroupActivity.this.m17297c();
            }
        }
    }
}
