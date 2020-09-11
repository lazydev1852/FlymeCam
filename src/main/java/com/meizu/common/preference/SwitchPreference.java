package com.meizu.common.preference;

import android.content.Context;
import android.os.Build;
import android.preference.Preference;
import android.preference.TwoStatePreference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.common.R;
import com.meizu.common.widget.Switch;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SwitchPreference extends TwoStatePreference {

    /* renamed from: e */
    private static Field f4367e;

    /* renamed from: f */
    private static Method f4368f;

    /* renamed from: a */
    boolean f4369a;

    /* renamed from: b */
    boolean f4370b;

    /* renamed from: c */
    private final C1324a f4371c;

    /* renamed from: d */
    private boolean f4372d;

    /* renamed from: g */
    private TextView f4373g;

    /* renamed from: com.meizu.common.preference.SwitchPreference$a */
    private class C1324a implements CompoundButton.OnCheckedChangeListener {
        private C1324a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreference.this.callChangeListener(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
                return;
            }
            SwitchPreference.this.setChecked(z);
            SwitchPreference.this.m5016a();
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4371c = new C1324a();
        boolean z = true;
        this.f4369a = true;
        this.f4370b = false;
        this.f4372d = true;
        try {
            if (f4367e == null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    f4367e = Preference.class.getDeclaredField("mRecycleEnabled");
                } else if (Build.VERSION.SDK_INT >= 19) {
                    f4367e = Preference.class.getDeclaredField("mCanRecycleLayout");
                } else {
                    f4367e = Preference.class.getDeclaredField("mHasSpecifiedLayout");
                }
                f4367e.setAccessible(true);
            }
            Field field = f4367e;
            if (Build.VERSION.SDK_INT < 19) {
                z = false;
            }
            field.set(this, Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
        }
        context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreference, i, 0).recycle();
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_SwitchPreferenceStyle);
    }

    public SwitchPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        super.onBindView(view);
        View findViewById = view.findViewById(R.id.switchWidget);
        if (findViewById != null && (findViewById instanceof Checkable)) {
            boolean z = findViewById instanceof Switch;
            if (z) {
                Switch switchR = (Switch) findViewById;
                switchR.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                View findViewById2 = view.findViewById(16908312);
                if (findViewById2 != null) {
                    findViewById2.setContentDescription(isChecked() ? switchR.f6262a : switchR.f6263b);
                }
                String str = new String();
                if (getTitle() != null) {
                    str = str + getTitle() + SystemInfoUtil.COMMA;
                }
                if (getSummary() != null) {
                    str = str + getSummary() + SystemInfoUtil.COMMA;
                }
                switchR.setContentDescription(str);
            }
            if (z) {
                Switch switchR2 = (Switch) findViewById;
                if (!this.f4369a || !this.f4370b) {
                    switchR2.setChecked(isChecked(), this.f4369a);
                } else {
                    switchR2.setCheckedWithHapticFeedback(isChecked());
                }
                this.f4369a = true;
                this.f4370b = false;
                switchR2.setOnCheckedChangeListener(this.f4371c);
            } else {
                ((Checkable) findViewById).setChecked(isChecked());
            }
        }
        this.f4373g = (TextView) view.findViewById(16908310);
        if (this.f4373g != null) {
            this.f4373g.setSingleLine(this.f4372d);
        }
        mo15931a(view);
    }

    /* access modifiers changed from: protected */
    public void onClick() {
        this.f4370b = true;
        super.onClick();
    }

    public void setChecked(boolean z) {
        mo15932a(z, true);
    }

    /* renamed from: a */
    public void mo15932a(boolean z, boolean z2) {
        super.setChecked(z);
        this.f4369a = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo15931a(View view) {
        TextView textView = (TextView) view.findViewById(16908304);
        if (textView != null) {
            boolean z = true;
            CharSequence summary = getSummary();
            if (!TextUtils.isEmpty(summary)) {
                textView.setText(summary);
                z = false;
            }
            int i = 8;
            if (!z) {
                i = 0;
            }
            if (i != textView.getVisibility()) {
                textView.setVisibility(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m5016a() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.reflect.Method r0 = f4368f     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r1 = 0
            if (r0 != 0) goto L_0x0018
            java.lang.Class<com.meizu.common.preference.SwitchPreference> r0 = com.meizu.common.preference.SwitchPreference.class
            java.lang.String r2 = "onPreferenceChange"
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            f4368f = r0     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            java.lang.reflect.Method r0 = f4368f     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r2 = 1
            r0.setAccessible(r2)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
        L_0x0018:
            java.lang.reflect.Method r0 = f4368f     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r0.invoke(r4, r1)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            goto L_0x0023
        L_0x0020:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x0023:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.preference.SwitchPreference.m5016a():void");
    }
}
