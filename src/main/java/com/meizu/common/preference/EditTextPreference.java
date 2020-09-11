package com.meizu.common.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.preference.Preference;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.meizu.common.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class EditTextPreference extends Preference implements TextWatcher, View.OnFocusChangeListener {

    /* renamed from: a */
    private static String f4288a = "EditTextPreference";

    /* renamed from: d */
    private static Method f4289d;

    /* renamed from: p */
    private static Field f4290p;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f4291b;

    /* renamed from: c */
    private String f4292c;

    /* renamed from: e */
    private float f4293e;

    /* renamed from: f */
    private int f4294f;

    /* renamed from: g */
    private TextWatcher f4295g;

    /* renamed from: h */
    private InputFilter[] f4296h;

    /* renamed from: i */
    private int f4297i;

    /* renamed from: j */
    private int f4298j;

    /* renamed from: k */
    private int f4299k;

    /* renamed from: l */
    private int f4300l;

    /* renamed from: m */
    private boolean f4301m;

    /* renamed from: n */
    private boolean f4302n;

    /* renamed from: o */
    private String f4303o;

    /* renamed from: a */
    private static boolean m4971a(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4292c = "";
        this.f4293e = 16.0f;
        this.f4294f = 0;
        this.f4296h = new InputFilter[0];
        this.f4301m = false;
        this.f4302n = true;
        this.f4303o = "";
        setLayoutResource(R.layout.mz_preference_edittext);
        mo15874a(true);
        setPersistent(false);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.f4291b = (EditText) view.findViewById(16908291);
        m4969a(this.f4291b);
        mo15873a(this.f4292c);
    }

    /* renamed from: a */
    private void m4969a(EditText editText) {
        TextWatcher textWatcher = (TextWatcher) editText.getTag();
        if (textWatcher != null) {
            editText.removeTextChangedListener(textWatcher);
        }
        editText.clearFocus();
        editText.removeTextChangedListener(this);
        editText.setTextSize(this.f4293e);
        if (this.f4301m) {
            editText.setPadding(this.f4297i, this.f4299k, this.f4298j, this.f4300l);
        }
        if (!m4971a(this.f4294f)) {
            editText.setSingleLine(this.f4302n);
        }
        if (!this.f4303o.trim().equals("")) {
            editText.setHint(this.f4303o);
        } else if (editText.getHint() != null && !editText.getHint().toString().trim().equals("")) {
            editText.setHint("");
        }
        editText.setFilters(this.f4296h);
        if (this.f4294f != 0) {
            editText.setInputType(this.f4294f);
        }
        editText.setOnFocusChangeListener(this);
        editText.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1 || EditTextPreference.this.m4970a() || EditTextPreference.this.f4291b.hasSelection()) {
                    return false;
                }
                EditTextPreference.this.f4291b.clearFocus();
                return false;
            }
        });
    }

    public void onFocusChange(View view, boolean z) {
        if (this.f4291b == null) {
            return;
        }
        if (z) {
            this.f4291b.addTextChangedListener(this);
            if (this.f4295g != null) {
                this.f4291b.addTextChangedListener(this.f4295g);
            }
            this.f4291b.setTag(this);
            return;
        }
        this.f4291b.setTag((Object) null);
        this.f4291b.removeTextChangedListener(this);
        if (this.f4295g != null) {
            this.f4291b.removeTextChangedListener(this.f4295g);
        }
        String obj = this.f4291b.getText().toString();
        if (callChangeListener(obj)) {
            mo15873a(obj);
        }
    }

    public void setSummary(int i) {
        setSummary((CharSequence) getContext().getString(i));
    }

    public void setSummary(CharSequence charSequence) {
        mo15873a((String) charSequence);
    }

    /* renamed from: a */
    public void mo15873a(String str) {
        boolean shouldDisableDependents = shouldDisableDependents();
        this.f4292c = str;
        persistString(str);
        if (!(this.f4291b == null || str == null || str.equals(this.f4291b.getText().toString()))) {
            this.f4291b.setText(str);
            if (this.f4291b.getText().length() > 0) {
                this.f4291b.setSelection(this.f4291b.getText().length());
            }
        }
        boolean shouldDisableDependents2 = shouldDisableDependents();
        if (shouldDisableDependents2 != shouldDisableDependents) {
            notifyDependencyChange(shouldDisableDependents2);
        }
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(boolean z, Object obj) {
        mo15873a(z ? getPersistedString(this.f4292c) : (String) obj);
    }

    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.f4292c) || super.shouldDisableDependents();
    }

    public void onDependencyChanged(Preference preference, boolean z) {
        InputMethodManager inputMethodManager;
        super.onDependencyChanged(preference, z);
        if (this.f4291b != null) {
            this.f4291b.setFocusableInTouchMode(!z);
            if (z && (inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method")) != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f4291b.getWindowToken(), 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4970a() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f4291b.getContext().getSystemService("input_method");
            if (f4289d == null) {
                f4289d = Class.forName("android.view.inputmethod.InputMethodManager").getMethod("isSoftInputShown", new Class[0]);
            }
            return ((Boolean) f4289d.invoke(inputMethodManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            Log.e(f4288a, "isSoftInputShown fail to be invoked");
            return false;
        }
    }

    public void afterTextChanged(Editable editable) {
        mo15873a(editable.toString());
    }

    /* renamed from: a */
    public void mo15874a(boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                setRecycleEnabled(z);
                return;
            }
            if (f4290p == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    f4290p = Preference.class.getDeclaredField("mCanRecycleLayout");
                } else {
                    f4290p = Preference.class.getDeclaredField("mHasSpecifiedLayout");
                }
                f4290p.setAccessible(true);
            }
            f4290p.set(this, Boolean.valueOf(z));
            notifyChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
