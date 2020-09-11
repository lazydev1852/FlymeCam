package com.meizu.media.camera.views;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class PackagePreference extends Preference {

    /* renamed from: a */
    public static ChangeQuickRedirect f14956a;

    public PackagePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(R.layout.package_reference_layout);
    }

    public void onBindView(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f14956a, false, 8773, new Class[]{View.class}, Void.TYPE).isSupported) {
            super.onBindView(view);
            TextView textView = (TextView) view.findViewById(R.id.app_version);
            Context context = getContext();
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                textView.setText(String.format(context.getString(R.string.mz_online_version), new Object[]{packageInfo.versionName}));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }
}
