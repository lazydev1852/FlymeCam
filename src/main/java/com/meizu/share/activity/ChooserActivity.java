package com.meizu.share.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.meizu.share.IntentModifier;
import com.meizu.share.OnTargetClickHandler;
import com.meizu.share.ShareClickHandler;
import com.meizu.share.ShareFinder;
import com.meizu.share.ShareIntentModifier;
import com.meizu.share.activity.ChooserContract;
import com.meizu.share.utils.ShareWidgetUsageCollector;
import com.meizu.share.utils.ShareWidgetUsageSharedPreferences;
import com.meizu.sharewidget.R;

public class ChooserActivity extends BaseChooserActivity {
    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: a */
    public ChooserContract.C2820a mo23950a() {
        return new SharePresenter(this, new ShareFinder(this));
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: b */
    public OnTargetClickHandler mo23955b() {
        return new ShareClickHandler();
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: c */
    public IntentModifier mo23957c() {
        return new ShareIntentModifier();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23953a(TextView textView) {
        String b = this.f15690a.mo23988b();
        if (TextUtils.isEmpty(b)) {
            b = getResources().getString(R.string.mz_share_view_title);
        }
        textView.setText(b);
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: d */
    public Intent mo23958d() {
        return this.f15690a.mo23987a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23952a(CheckBox checkBox) {
        checkBox.setVisibility(this.f15690a.mo23992f() ? 0 : 8);
        checkBox.setChecked(this.f15690a.mo23993g());
        String h = this.f15690a.mo23994h();
        if (!TextUtils.isEmpty(h)) {
            checkBox.setText(h);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23956b(TextView textView) {
        textView.setVisibility(8);
    }

    /* renamed from: e */
    public void mo23959e() {
        super.mo23959e();
        ShareWidgetUsageCollector.m17204a(getApplicationContext(), getPackageName());
    }

    /* renamed from: a */
    public void mo23951a(Intent intent, ResolveInfo resolveInfo, boolean z) {
        super.mo23951a(intent, resolveInfo, z);
        ShareWidgetUsageSharedPreferences.m17206a((Context) this).mo24030a(resolveInfo);
        ShareWidgetUsageCollector.m17205b(getApplicationContext(), (resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo).name);
        if (z) {
            ShareWidgetUsageCollector.m17203a(getApplicationContext());
        }
    }
}
