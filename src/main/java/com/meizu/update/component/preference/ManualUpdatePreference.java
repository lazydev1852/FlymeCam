package com.meizu.update.component.preference;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.CheckListener;
import com.meizu.update.component.MzUpdatePlatform;
import com.meizu.update.component.R;
import com.meizu.update.component.StateListener;
import com.meizu.update.util.Utility;
import java.lang.ref.WeakReference;

public class ManualUpdatePreference extends Preference implements CheckListener, StateListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WeakReference<Activity> f16209a = null;

    /* renamed from: b */
    private Handler f16210b = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f16211c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f16212d = 0;

    /* renamed from: e */
    private Runnable f16213e = new Runnable() {
        public void run() {
            if (ManualUpdatePreference.this.getContext() != null) {
                ManualUpdatePreference manualUpdatePreference = ManualUpdatePreference.this;
                String string = ManualUpdatePreference.this.getContext().getString(R.string.mzuc_manual_downloading);
                manualUpdatePreference.setSummary(String.format(string, new Object[]{ManualUpdatePreference.this.f16212d + ""}));
            }
        }
    };

    public ManualUpdatePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWidgetLayoutResource(R.layout.manual_update_preference_widget_layout);
        setTitle(R.string.mzuc_manual_update_title);
    }

    public ManualUpdatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWidgetLayoutResource(R.layout.manual_update_preference_widget_layout);
        setTitle(R.string.mzuc_manual_update_title);
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.indicator);
        if (imageView == null) {
            return;
        }
        if (this.f16211c == 3 || this.f16211c == 5 || this.f16211c == 10 || this.f16211c == 6 || this.f16211c == 7) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo17726a(int i, final UpdateInfo updateInfo) {
        if (this.f16209a != null && this.f16209a.get() != null) {
            switch (i) {
                case 0:
                    if (updateInfo.mExistsUpdate) {
                        this.f16210b.post(new Runnable() {
                            public void run() {
                                if (ManualUpdatePreference.this.f16209a != null && ManualUpdatePreference.this.f16209a.get() != null) {
                                    MzUpdatePlatform.m17668b((Activity) ManualUpdatePreference.this.f16209a.get(), updateInfo);
                                }
                            }
                        });
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m17674a(Runnable runnable) {
        this.f16210b.post(runnable);
    }

    /* renamed from: a */
    public void mo24754a(int i, final boolean z) {
        this.f16211c = i;
        m17674a((Runnable) new Runnable() {
            public void run() {
                ManualUpdatePreference.this.m17676b(ManualUpdatePreference.this.f16211c, z);
            }
        });
    }

    /* renamed from: a */
    public void mo24753a(int i) {
        this.f16212d = i;
        if (this.f16211c == 4) {
            m17674a(this.f16213e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17676b(int i, boolean z) {
        if (getContext() != null) {
            switch (i) {
                case 0:
                    setSummary(String.format(getContext().getString(R.string.mzuc_manual_current_version), new Object[]{Utility.m17970b(getContext(), getContext().getPackageName())}));
                    return;
                case 1:
                    setSummary(getContext().getString(R.string.mzuc_manual_checking_update));
                    return;
                case 2:
                    if (z) {
                        setSummary(String.format(getContext().getString(R.string.mzuc_manual_current_version), new Object[]{Utility.m17970b(getContext(), getContext().getPackageName())}));
                        return;
                    }
                    setSummary(getContext().getString(R.string.mzuc_manual_latest_version));
                    return;
                case 3:
                    setSummary(getContext().getString(R.string.mzuc_manual_found_new_version));
                    return;
                case 4:
                    String string = getContext().getString(R.string.mzuc_manual_downloading);
                    setSummary(String.format(string, new Object[]{this.f16212d + ""}));
                    return;
                case 5:
                    setSummary(getContext().getResources().getString(R.string.mzuc_manual_install_new_version));
                    return;
                case 6:
                    if (!z) {
                        setSummary(getContext().getResources().getString(R.string.mzuc_manual_download_fail));
                        return;
                    } else {
                        setSummary(getContext().getString(R.string.mzuc_manual_found_new_version));
                        return;
                    }
                case 7:
                    if (!z) {
                        setSummary(getContext().getResources().getString(R.string.mzuc_manual_download_cancel));
                        return;
                    } else {
                        setSummary(getContext().getString(R.string.mzuc_manual_found_new_version));
                        return;
                    }
                case 8:
                    setSummary(getContext().getResources().getString(R.string.mzuc_manual_installing));
                    return;
                case 9:
                    if (!z) {
                        setSummary(getContext().getResources().getString(R.string.mzuc_manual_install_fail));
                        return;
                    } else {
                        setSummary(getContext().getString(R.string.mzuc_manual_install_new_version));
                        return;
                    }
                case 10:
                    setSummary(getContext().getString(R.string.mzuc_manual_install_new_version));
                    return;
                default:
                    return;
            }
        }
    }
}
