package com.meizu.common.preference;

import android.content.Context;
import android.os.Build;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.common.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CheckBoxPreferenceMz extends CheckBoxPreference {

    /* renamed from: g */
    private static Field f4279g;

    /* renamed from: h */
    private static Method f4280h;

    /* renamed from: a */
    private View f4281a;

    /* renamed from: b */
    private View f4282b;

    /* renamed from: c */
    private boolean f4283c = true;

    /* renamed from: d */
    private boolean f4284d = true;

    /* renamed from: e */
    private View.OnClickListener f4285e;

    /* renamed from: f */
    private View.OnLongClickListener f4286f;

    public CheckBoxPreferenceMz(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(R.layout.mz_preference_checkbox);
        m4968b();
    }

    public CheckBoxPreferenceMz(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.layout.mz_preference_checkbox);
        m4968b();
    }

    /* access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        this.f4281a = onCreateView.findViewById(R.id.mz_preference_text_layout);
        if (this.f4285e != null) {
            this.f4281a.setOnClickListener(this.f4285e);
        }
        if (this.f4286f != null) {
            this.f4281a.setOnLongClickListener(this.f4286f);
        }
        this.f4282b = onCreateView.findViewById(16908312);
        this.f4282b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CheckBoxPreferenceMz.this.m4965a();
            }
        });
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        String str;
        super.onBindView(view);
        if (isEnabled() && !this.f4283c) {
            m4966a(this.f4281a, this.f4283c);
        }
        if (isEnabled() && !this.f4284d) {
            m4966a(this.f4282b, this.f4284d);
        }
        View findViewById = view.findViewById(16908289);
        if (findViewById != null && (findViewById instanceof Checkable)) {
            if (findViewById instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) findViewById;
                if (isChecked()) {
                    str = getContext().getResources().getString(R.string.mc_value_checked);
                } else {
                    str = getContext().getResources().getString(R.string.mc_value_not_checked);
                }
                String str2 = new String();
                if (getTitle() != null) {
                    str2 = str2 + getTitle() + SystemInfoUtil.COMMA;
                }
                if (getSummary() != null) {
                    str2 = str2 + getSummary() + SystemInfoUtil.COMMA;
                }
                if (this.f4281a != null) {
                    this.f4281a.setContentDescription(str2 + str);
                }
                checkBox.setContentDescription(str2);
            }
            ((Checkable) findViewById).setChecked(isChecked());
        }
    }

    /* renamed from: a */
    private void m4966a(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                m4966a(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4965a() {
        try {
            if (f4280h == null) {
                f4280h = CheckBoxPreference.class.getMethod("performClick", new Class[]{PreferenceScreen.class});
                f4280h.setAccessible(true);
            }
            f4280h.invoke(this, new Object[]{null});
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private void m4968b() {
        try {
            boolean z = true;
            if (f4279g == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    f4279g = Preference.class.getDeclaredField("mCanRecycleLayout");
                } else {
                    f4279g = Preference.class.getDeclaredField("mHasSpecifiedLayout");
                }
                f4279g.setAccessible(true);
            }
            Field field = f4279g;
            if (Build.VERSION.SDK_INT < 19) {
                z = false;
            }
            field.set(this, Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
