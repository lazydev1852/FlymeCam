package com.meizu.common.preference;

import android.annotation.TargetApi;
import android.content.Context;
import android.preference.Preference;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import com.meizu.common.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ListPreference extends android.preference.ListPreference implements ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener {

    /* renamed from: j */
    private static Field f4350j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static Method f4351k;

    /* renamed from: a */
    private C1321a f4352a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f4353b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f4354c;

    /* renamed from: d */
    private int f4355d;

    /* renamed from: e */
    private int f4356e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f4357f;

    /* renamed from: g */
    private ViewTreeObserver f4358g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f4359h;

    /* renamed from: i */
    private ListAdapter f4360i;

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        super.onBindView(view);
        this.f4359h = view;
    }

    /* access modifiers changed from: protected */
    public void onClick() {
        try {
            if (f4350j == null) {
                f4350j = Preference.class.getDeclaredField("mPreferenceView");
            }
            Object obj = f4350j.get(this);
            if (obj instanceof View) {
                this.f4359h = (View) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f4356e = getContext().getResources().getConfiguration().orientation;
        if (this.f4352a == null) {
            this.f4352a = new C1321a(getContext());
        }
        this.f4359h.setActivated(true);
        this.f4358g = this.f4359h.getViewTreeObserver();
        if (this.f4358g != null) {
            this.f4358g.addOnGlobalLayoutListener(this);
        }
        this.f4352a.setAnchorView(this.f4359h);
        if (this.f4360i != null) {
            this.f4352a.setAdapter(this.f4360i);
        } else {
            this.f4352a.setAdapter(new ArrayAdapter(getContext(), this.f4355d, R.id.text1, getEntries()));
        }
        this.f4352a.show();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15920a() {
        CharSequence[] entryValues = getEntryValues();
        if (this.f4357f >= 0 && entryValues != null) {
            String charSequence = entryValues[this.f4357f].toString();
            if (callChangeListener(charSequence)) {
                setValue(charSequence);
            }
        }
    }

    /* renamed from: com.meizu.common.preference.ListPreference$a */
    private class C1321a extends ListPopupWindow {

        /* renamed from: b */
        private ListAdapter f4362b;

        public C1321a(Context context) {
            super(context);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AdapterView.OnItemClickListener(ListPreference.this) {
                public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    int unused = ListPreference.this.f4357f = i;
                    C1321a.this.setSelection(ListPreference.this.f4357f);
                    C1321a.this.dismiss();
                }
            });
        }

        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.f4362b = listAdapter;
        }

        public void show() {
            int paddingLeft = ListPreference.this.f4359h.getPaddingLeft();
            int paddingRight = ListPreference.this.f4359h.getPaddingRight();
            int width = ListPreference.this.f4359h.getWidth();
            if (ListPreference.this.f4353b <= 0 || ListPreference.this.f4353b > (width - paddingLeft) - paddingRight) {
                int unused = ListPreference.this.f4353b = (width - paddingLeft) - paddingRight;
            }
            setContentWidth(ListPreference.this.f4353b);
            int i = 0;
            try {
                if (ListPreference.f4351k == null) {
                    Method unused2 = ListPreference.f4351k = getClass().getMethod("setLayoutMode", new Class[]{Integer.TYPE});
                }
                ListPreference.f4351k.invoke(this, new Object[]{4});
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ListPreference.this.f4354c > 0) {
                if (this.f4362b != null && this.f4362b.getCount() > 0) {
                    int i2 = 0;
                    int i3 = 0;
                    do {
                        View view = this.f4362b.getView(i2, (View) null, getListView());
                        if (view != null) {
                            view.measure(0, 0);
                            i3 += view.getMeasuredHeight();
                        }
                        i2++;
                    } while (i2 < this.f4362b.getCount());
                    i = i3;
                }
                if (i > ListPreference.this.f4354c) {
                    setHeight(ListPreference.this.f4354c);
                }
            }
            int unused3 = ListPreference.this.f4357f = ListPreference.this.findIndexOfValue(ListPreference.this.getValue());
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(1);
            setSelection(ListPreference.this.f4357f);
            setOnDismissListener(ListPreference.this);
        }
    }

    @TargetApi(16)
    public void onDismiss() {
        mo15920a();
        this.f4359h.setActivated(false);
        ViewTreeObserver viewTreeObserver = this.f4359h.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    public void onGlobalLayout() {
        if (!this.f4352a.isShowing()) {
            return;
        }
        if (this.f4359h == null || !this.f4359h.isShown() || this.f4356e != getContext().getResources().getConfiguration().orientation) {
            this.f4352a.dismiss();
        } else if (this.f4352a.isShowing() && this.f4359h != this.f4352a.getAnchorView()) {
            this.f4352a.setAnchorView(this.f4359h);
            this.f4352a.show();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z && this.f4352a != null && this.f4352a.isShowing()) {
            this.f4352a.dismiss();
        }
    }
}
