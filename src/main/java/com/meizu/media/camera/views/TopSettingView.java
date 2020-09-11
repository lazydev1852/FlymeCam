package com.meizu.media.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.meizu.media.camera.R;
import com.meizu.media.camera.p077ui.MzTopSettingUI;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

public class TopSettingView extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f15147a;

    /* renamed from: b */
    private List<TextIconCheckableView> f15148b = new ArrayList();

    /* renamed from: c */
    private List<MzTopSettingUI.C2429a> f15149c = new ArrayList();

    /* renamed from: d */
    private C2732a f15150d;

    /* renamed from: com.meizu.media.camera.views.TopSettingView$a */
    public interface C2732a {
        /* renamed from: a */
        void mo21799a(String str, View view, int i);

        /* renamed from: b */
        void mo21805b(String str, View view, int i);
    }

    public TopSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        if (!PatchProxy.proxy(new Object[0], this, f15147a, false, 8917, new Class[0], Void.TYPE).isSupported) {
            super.onFinishInflate();
            m16648a(R.id.mz_setting_item0);
            m16648a(R.id.mz_setting_item1);
            m16648a(R.id.mz_setting_item2);
            m16648a(R.id.mz_setting_item3);
            m16648a(R.id.mz_setting_item4);
        }
    }

    /* renamed from: a */
    private void m16648a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15147a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8918, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            TextIconCheckableView textIconCheckableView = (TextIconCheckableView) findViewById(i);
            textIconCheckableView.setOnClickListener(this);
            textIconCheckableView.setOnLongClickListener(this);
            this.f15148b.add(textIconCheckableView);
        }
    }

    public void setOnItemChooseListener(C2732a aVar) {
        this.f15150d = aVar;
    }

    /* renamed from: a */
    private void m16647a() {
        if (!PatchProxy.proxy(new Object[0], this, f15147a, false, 8919, new Class[0], Void.TYPE).isSupported) {
            for (int i = 0; i < this.f15148b.size(); i++) {
                TextIconCheckableView textIconCheckableView = this.f15148b.get(i);
                textIconCheckableView.setVisibility(8);
                textIconCheckableView.setText("");
                textIconCheckableView.setChecked(false);
            }
        }
    }

    /* renamed from: b */
    private void m16649b() {
        if (!PatchProxy.proxy(new Object[0], this, f15147a, false, 8920, new Class[0], Void.TYPE).isSupported) {
            for (int i = 0; i < this.f15148b.size(); i++) {
                this.f15148b.get(i).setChecked(false);
            }
        }
    }

    public void setAdapter(List<MzTopSettingUI.C2429a> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f15147a, false, 8921, new Class[]{List.class}, Void.TYPE).isSupported && list != null) {
            this.f15149c.clear();
            this.f15149c.addAll(list);
            m16647a();
            for (int i = 0; i < this.f15149c.size(); i++) {
                MzTopSettingUI.C2429a aVar = this.f15149c.get(i);
                TextIconCheckableView textIconCheckableView = this.f15148b.get(i);
                textIconCheckableView.setDrawableId(aVar.f12680b, aVar.f12681c);
                textIconCheckableView.setLeftDrawable(aVar.f12680b);
                textIconCheckableView.setVisibility(0);
            }
        }
    }

    public void setItemChecked(int i, boolean z) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15147a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8922, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && i >= 0 && i < this.f15148b.size()) {
            m16649b();
            TextIconCheckableView textIconCheckableView = this.f15148b.get(i);
            textIconCheckableView.setVisibility(0);
            textIconCheckableView.setChecked(z);
        }
    }

    public void onClick(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f15147a, false, 8923, new Class[]{View.class}, Void.TYPE).isSupported) {
            int indexOf = this.f15148b.indexOf(view);
            setCheckedIndex(indexOf);
            if (this.f15150d != null) {
                this.f15150d.mo21799a(this.f15149c.get(indexOf).f12679a, view, indexOf);
            }
        }
    }

    public boolean onLongClick(View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, this, f15147a, false, 8924, new Class[]{View.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int indexOf = this.f15148b.indexOf(view);
        setCheckedIndex(indexOf);
        if (this.f15150d != null) {
            this.f15150d.mo21805b(this.f15149c.get(indexOf).f12679a, view, indexOf);
        }
        return true;
    }

    public void setCheckedIndex(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15147a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8925, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            setItemChecked(i, true);
        }
    }
}
