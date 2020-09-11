package com.meizu.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class SearchEditText extends EditText {
    public SearchEditText(Context context) {
        super(context);
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public void mo17270a(boolean z) {
        if (z) {
            requestFocus();
            m6100a();
            return;
        }
        clearFocus();
        m6101b();
    }

    /* renamed from: a */
    private void m6100a() {
        if (getContext() != null) {
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
        }
    }

    /* renamed from: b */
    private void m6101b() {
        if (getContext() != null && getWindowToken() != null) {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 2);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SearchEditText.class.getName());
    }
}
