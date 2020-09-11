package com.meizu.textinputlayout;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

public class EditTextWithClearIcon extends EditText {

    /* renamed from: a */
    Drawable f16046a;

    /* renamed from: b */
    boolean f16047b;

    public EditTextWithClearIcon(Context context) {
        super(context);
        m17420a(context);
    }

    public EditTextWithClearIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17420a(context);
    }

    public EditTextWithClearIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17420a(context);
    }

    /* renamed from: a */
    private void m17420a(Context context) {
        this.f16046a = context.getResources().getDrawable(R.drawable.mz_text_input_layout_ic_clear_normal);
        boolean z = true;
        if (context.getResources().getConfiguration().getLayoutDirection() != 1) {
            z = false;
        }
        this.f16047b = z;
        addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                EditTextWithClearIcon.this.m17419a();
            }
        });
        m17419a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17419a() {
        if (length() <= 0) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (this.f16047b) {
            setCompoundDrawablesWithIntrinsicBounds(this.f16046a, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f16046a, (Drawable) null);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        if (this.f16047b) {
            drawable = getCompoundDrawables()[0];
        } else {
            drawable = getCompoundDrawables()[2];
        }
        if (motionEvent.getAction() == 1 && drawable != null) {
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            int intrinsicHeight = ((rect.bottom - rect.top) - drawable.getIntrinsicHeight()) / 2;
            if (this.f16047b) {
                rect.right = rect.left + drawable.getIntrinsicWidth();
            } else {
                rect.left = rect.right - drawable.getIntrinsicWidth();
            }
            rect.top += intrinsicHeight;
            rect.bottom -= intrinsicHeight;
            if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                setText("");
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
