package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.meizu.common.R;
import java.util.Locale;

public class PasswordInputView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f5845a;

    /* renamed from: b */
    private CompoundButton f5846b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LinearLayout f5847c;

    /* renamed from: d */
    private ImageView f5848d;

    public PasswordInputView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PasswordInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PasswordInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5944a();
    }

    /* renamed from: a */
    private void m5944a() {
        inflate(getContext(), getInflateLayoutResource(), this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof EditText) {
                    this.f5845a = (EditText) childAt;
                } else if (childAt instanceof LinearLayout) {
                    this.f5846b = (CompoundButton) childAt.findViewById(R.id.mz_password_btn);
                    this.f5847c = (LinearLayout) childAt.findViewById(R.id.mz_input_clear_layout);
                    this.f5848d = (ImageView) childAt.findViewById(R.id.mz_icon_input_clear);
                }
            }
        }
        if (this.f5846b != null) {
            this.f5846b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PasswordInputView.this.mo17036a(compoundButton, z);
                }
            });
        }
        if (this.f5845a != null) {
            this.f5845a.setInputType(129);
            this.f5845a.setTypeface(Typeface.DEFAULT);
            this.f5845a.setSelection(this.f5845a.getText().length());
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                this.f5845a.setGravity(5);
            }
            this.f5845a.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    if (PasswordInputView.this.f5845a.length() > 0) {
                        PasswordInputView.this.f5847c.setVisibility(0);
                    } else {
                        PasswordInputView.this.f5847c.setVisibility(8);
                    }
                }
            });
            this.f5848d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PasswordInputView.this.f5845a.setText("");
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo17036a(CompoundButton compoundButton, boolean z) {
        if (this.f5845a != null) {
            if (z) {
                this.f5845a.setInputType(145);
                this.f5845a.setTypeface(Typeface.DEFAULT);
                this.f5845a.setSelection(this.f5845a.getText().length());
                return;
            }
            this.f5845a.setInputType(129);
            this.f5845a.setTypeface(Typeface.DEFAULT);
            this.f5845a.setSelection(this.f5845a.getText().length());
        }
    }

    public EditText getEditText() {
        return this.f5845a;
    }

    public int getInflateLayoutResource() {
        return R.layout.mc_layout_password_input;
    }
}
