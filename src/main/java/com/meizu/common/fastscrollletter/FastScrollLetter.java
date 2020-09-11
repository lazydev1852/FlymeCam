package com.meizu.common.fastscrollletter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.meizu.common.fastscrollletter.FastScrollLetterListViewAdapter;
import java.util.ArrayList;

public class FastScrollLetter extends RelativeLayout {

    /* renamed from: a */
    private Context f4211a;

    /* renamed from: b */
    private IFastScrollLetterListView f4212b;

    /* renamed from: c */
    private FastScrollLetterListViewAdapter f4213c;

    /* renamed from: d */
    private NavigationLayout f4214d;

    /* renamed from: e */
    private ArrayList<String> f4215e;

    /* renamed from: f */
    private ArrayList<String> f4216f;

    /* renamed from: g */
    private boolean f4217g;

    /* renamed from: h */
    private C1301a f4218h;

    /* renamed from: com.meizu.common.fastscrollletter.FastScrollLetter$a */
    public interface C1301a {
    }

    @Deprecated
    public void setHideNavigationBitmap(Bitmap bitmap) {
    }

    public FastScrollLetter(Context context) {
        super(context);
        this.f4211a = context;
        m4890a((AttributeSet) null);
    }

    public FastScrollLetter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4211a = context;
        m4890a(attributeSet);
    }

    public FastScrollLetter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4211a = context;
        m4890a(attributeSet);
    }

    /* renamed from: a */
    private void m4890a(AttributeSet attributeSet) {
        this.f4214d = new NavigationLayout(this.f4211a);
        addView(this.f4214d);
        this.f4214d.mo15785a(attributeSet);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4214d.getLayoutParams();
        layoutParams.addRule(11);
        layoutParams.height = -1;
        layoutParams.width = -2;
        this.f4214d.setLayoutParams(layoutParams);
    }

    public void setHideNavigationLetter(String... strArr) {
        this.f4214d.setHideNavigationLetter(strArr);
    }

    public void setHideNavigationLetter(String str, Bitmap bitmap, Bitmap bitmap2) {
        this.f4214d.setHideNavigationLetter(str, bitmap, bitmap2);
    }

    public void setOverlayLetters(ArrayList<String> arrayList) {
        this.f4215e = arrayList;
        this.f4214d.setOverlayLetters(arrayList);
    }

    public void setNavigationLetters(ArrayList<String> arrayList) {
        this.f4216f = arrayList;
        this.f4214d.setNavigationLetters(arrayList);
    }

    public void setHideTopPassCount(int i) {
        this.f4214d.setHideTopPassCount(i);
    }

    public void setHideBottomPassCount(int i) {
        this.f4214d.setHideBottomPassCount(i);
    }

    public void setIntervalHide(int i) {
        this.f4214d.setIntervalHide(i);
    }

    public void setAutoHideLetter(boolean z) {
        this.f4214d.setAutoHideLetter(z);
    }

    public void setNeedSetNormativeRightPaddingForItem(boolean z) {
        this.f4217g = z;
        if (this.f4213c != null) {
            this.f4213c.mo15862b(this.f4217g);
        }
    }

    public void setListView(IFastScrollLetterListView bVar) {
        this.f4212b = bVar;
    }

    public IFastScrollLetterListView getListView() {
        return this.f4212b;
    }

    public NavigationLayout getNavigationLayout() {
        return this.f4214d;
    }

    public void setCallBack(FastScrollLetterListViewAdapter.C1307a aVar) {
        this.f4213c.mo15860a(aVar);
    }

    public void setOffsetCallBack(C1301a aVar) {
        this.f4218h = aVar;
    }
}
