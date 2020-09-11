package com.meizu.common.fastscrollletter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.meizu.common.R;
import com.meizu.common.fastscrollletter.NavigationView;
import com.meizu.flyme.sdk.ContextBuilder;
import java.util.ArrayList;
import java.util.HashMap;

public class NavigationLayout extends RelativeLayout {

    /* renamed from: a */
    private static final int[] f4219a = {R.color.mc_fast_scroll_letter_color_one, R.color.mc_fast_scroll_letter_color_two, R.color.mc_fast_scroll_letter_color_three, R.color.mc_fast_scroll_letter_color_four, R.color.mc_fast_scroll_letter_color_five, R.color.mc_fast_scroll_letter_color_six, R.color.mc_fast_scroll_letter_color_seven};

    /* renamed from: b */
    private Context f4220b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f4221c;

    /* renamed from: d */
    private ShapeDrawable f4222d;

    /* renamed from: e */
    private HashMap<String, Integer> f4223e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public NavigationView f4224f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f4225g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayList<String> f4226h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ArrayList<String> f4227i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<Integer> f4228j;

    /* renamed from: k */
    private int f4229k;

    /* renamed from: l */
    private int f4230l;

    /* renamed from: m */
    private int f4231m;

    /* renamed from: n */
    private int f4232n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f4233o;

    /* renamed from: p */
    private int f4234p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public C1304a f4235q;

    /* renamed from: com.meizu.common.fastscrollletter.NavigationLayout$a */
    public interface C1304a {
        /* renamed from: a */
        void mo15823a();

        /* renamed from: a */
        void mo15824a(String str);

        /* renamed from: b */
        void mo15825b();

        /* renamed from: c */
        void mo15826c();

        /* renamed from: d */
        int mo15827d();

        /* renamed from: e */
        int mo15828e();

        /* renamed from: f */
        int mo15829f();

        /* renamed from: g */
        int mo15830g();
    }

    public NavigationLayout(Context context) {
        super(context);
        this.f4220b = ContextBuilder.m6349a(context, true, true);
        m4894a();
    }

    /* renamed from: a */
    private void m4894a() {
        this.f4221c = -1;
        this.f4226h = new ArrayList<>();
        this.f4228j = new ArrayList<>();
        this.f4223e = new HashMap<>();
        String[] strArr = NavigationView.f4238a;
        for (int i = 0; i < strArr.length; i++) {
            this.f4226h.add(strArr[i]);
            this.f4227i.add(strArr[i]);
        }
        setOverlayLetterBackgroundColors(f4219a);
        m4897a(this.f4226h);
        this.f4229k = m4898b(R.color.mc_fastscroll_letter_overlay_text_color);
        this.f4230l = m4891a(R.dimen.mc_fastscroll_letter_overlay_text_size);
        this.f4231m = m4891a(R.dimen.mc_fastscroll_letter_overlay_two_text_size);
        this.f4232n = m4891a(R.dimen.mc_fastscroll_letter_overlay_three_text_size);
        this.f4233o = m4891a(R.dimen.mc_fastscroll_letter_overlay_layout_width);
        this.f4234p = m4891a(R.dimen.mc_fastscroll_letter_overlay_layout_margin_right);
    }

    @SuppressLint({"ResourceType"})
    /* renamed from: a */
    public void mo15785a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f4220b.obtainStyledAttributes(attributeSet, R.styleable.FastScrollLetter, R.attr.MeizuCommon_FastScrollLetter, 0);
        this.f4229k = obtainStyledAttributes.getColor(R.styleable.FastScrollLetter_mcOverlayLetterTextColor, this.f4229k);
        this.f4230l = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcOverlayLetterOneTextSize, (float) this.f4230l);
        this.f4231m = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcOverlayLetterTwoTextSize, (float) this.f4231m);
        this.f4232n = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcOverlayLetterThreeTextSize, (float) this.f4232n);
        this.f4233o = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcOverlayLetterSize, (float) this.f4233o);
        this.f4234p = (int) obtainStyledAttributes.getDimension(R.styleable.FastScrollLetter_mcOverlayLetterRightMargin, (float) this.f4234p);
        this.f4224f = new NavigationView(this.f4220b);
        addView(this.f4224f);
        this.f4224f.setId(10086);
        this.f4224f.mo15833a(attributeSet);
        m4900b();
        this.f4225g = new TextView(this.f4220b);
        addView(this.f4225g);
        this.f4225g.setTextColor(this.f4229k);
        this.f4225g.setIncludeFontPadding(false);
        this.f4225g.setGravity(17);
        this.f4225g.setVisibility(8);
        m4902c();
        m4904d();
    }

    /* renamed from: b */
    private void m4900b() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4224f.getLayoutParams();
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        this.f4224f.setLayoutParams(layoutParams);
    }

    /* renamed from: c */
    private void m4902c() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4225g.getLayoutParams();
        layoutParams.addRule(6, this.f4224f.getId());
        layoutParams.addRule(0, this.f4224f.getId());
        layoutParams.rightMargin = this.f4234p;
        layoutParams.width = this.f4233o;
        layoutParams.height = this.f4233o;
        this.f4225g.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private int m4891a(int i) {
        return this.f4220b.getResources().getDimensionPixelSize(i);
    }

    /* renamed from: b */
    private int m4898b(int i) {
        return this.f4220b.getResources().getColor(i);
    }

    /* renamed from: d */
    private void m4904d() {
        this.f4224f.setCallBack(new NavigationView.C1306a() {
            /* renamed from: a */
            public void mo15813a() {
                int unused = NavigationLayout.this.f4221c = -1;
                NavigationLayout.this.f4235q.mo15823a();
            }

            @RequiresApi(api = 16)
            /* renamed from: a */
            public void mo15815a(String str, int i) {
                if (NavigationLayout.this.f4221c != i || NavigationLayout.this.f4221c == -1) {
                    String str2 = str;
                    String str3 = str2;
                    int i2 = i;
                    int i3 = i2;
                    while (true) {
                        if (i2 < 0 && i3 >= NavigationLayout.this.f4227i.size()) {
                            return;
                        }
                        if (NavigationLayout.this.f4226h.contains(str2)) {
                            int unused = NavigationLayout.this.f4221c = i;
                            NavigationLayout.this.m4896a(str2);
                            NavigationLayout.this.f4235q.mo15824a(str2);
                            return;
                        } else if (NavigationLayout.this.f4226h.contains(str3)) {
                            int unused2 = NavigationLayout.this.f4221c = i;
                            NavigationLayout.this.m4896a(str3);
                            NavigationLayout.this.f4235q.mo15824a(str3);
                            return;
                        } else {
                            if (i2 >= 0 && i2 < NavigationLayout.this.f4227i.size()) {
                                str2 = (String) NavigationLayout.this.f4227i.get(i2);
                            }
                            if (i3 >= 0 && i3 < NavigationLayout.this.f4227i.size()) {
                                str3 = (String) NavigationLayout.this.f4227i.get(i3);
                            }
                            i2--;
                            i3++;
                        }
                    }
                }
            }

            /* renamed from: a */
            public void mo15814a(float f) {
                if (f - ((float) (NavigationLayout.this.f4233o / 2)) < 0.0f) {
                    NavigationLayout.this.f4225g.setTranslationY(0.0f);
                } else if (f - ((float) (NavigationLayout.this.f4233o / 2)) > ((float) (NavigationLayout.this.f4224f.getHeight() - NavigationLayout.this.f4233o))) {
                    NavigationLayout.this.f4225g.setTranslationY((float) (NavigationLayout.this.f4224f.getHeight() - NavigationLayout.this.f4233o));
                } else {
                    NavigationLayout.this.f4225g.setTranslationY(f - ((float) (NavigationLayout.this.f4233o / 2)));
                }
            }

            /* renamed from: b */
            public void mo15816b() {
                NavigationLayout.this.f4225g.setVisibility(0);
                NavigationLayout.this.f4235q.mo15825b();
            }

            /* renamed from: c */
            public void mo15817c() {
                Handler handler = NavigationLayout.this.getHandler();
                if (handler != null) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            NavigationLayout.this.f4225g.setVisibility(8);
                            NavigationLayout.this.f4235q.mo15826c();
                        }
                    }, 50);
                }
            }

            /* renamed from: d */
            public int mo15818d() {
                return NavigationLayout.this.f4235q.mo15827d();
            }

            /* renamed from: e */
            public int mo15819e() {
                return NavigationLayout.this.f4235q.mo15828e();
            }

            /* renamed from: f */
            public int mo15820f() {
                return NavigationLayout.this.f4235q.mo15829f();
            }

            /* renamed from: g */
            public int mo15821g() {
                return NavigationLayout.this.f4235q.mo15830g();
            }
        });
    }

    public void setOverlayLetters(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.f4226h = arrayList;
            m4897a(arrayList);
        }
    }

    public void setHideNavigationLetter(String... strArr) {
        this.f4224f.setHideNavigationLetter(strArr);
    }

    public void setHideNavigationLetter(String str, Bitmap bitmap, Bitmap bitmap2) {
        this.f4224f.setHideNavigationLetter(str, bitmap, bitmap2);
    }

    public void setNavigationLetters(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.f4227i = arrayList;
            this.f4224f.setNavigationLetters(arrayList);
        }
    }

    public void setOverlayLetterBackgroundColors(String str) {
        if (str.equals("colorful")) {
            setOverlayLetterBackgroundColors(f4219a);
            return;
        }
        setOverlayLetterBackgroundColors(R.color.mc_fast_scroll_letter_color_gray);
    }

    public void setOverlayLetterBackgroundColors(int... iArr) {
        this.f4228j.clear();
        for (int valueOf : iArr) {
            this.f4228j.add(Integer.valueOf(valueOf));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4896a(String str) {
        if (str.length() == 1) {
            this.f4225g.setTextSize(0, (float) this.f4230l);
        } else if (str.length() == 2) {
            this.f4225g.setTextSize(0, (float) this.f4231m);
        } else if (str.length() == 3) {
            this.f4225g.setTextSize(0, (float) this.f4232n);
        } else {
            this.f4225g.setTextSize(0, (float) this.f4230l);
        }
        this.f4225g.setText(str);
        this.f4222d = new ShapeDrawable(new OvalShape());
        this.f4222d.getPaint().setColor(getResources().getColor(this.f4223e.get(str).intValue()));
        this.f4225g.setBackground(this.f4222d);
    }

    /* renamed from: a */
    private void m4897a(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.f4223e.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                this.f4223e.put(arrayList.get(i), this.f4228j.get(i % this.f4228j.size()));
            }
        }
    }

    public ArrayList<Integer> getOverlayLetterBackgroundColors() {
        return this.f4228j;
    }

    public HashMap<String, Integer> getOverlayLetterColors() {
        return this.f4223e;
    }

    public void setOverlayLetterTextColor(int i) {
        this.f4229k = i;
        if (this.f4225g != null) {
            this.f4225g.setTextColor(i);
        }
    }

    public void setOverlayLetterOneTextSize(int i) {
        this.f4230l = i;
    }

    public void setOverlayLetterTwoTextSize(int i) {
        this.f4231m = i;
    }

    public void setOverlayLetterThreeTextSize(int i) {
        this.f4232n = i;
    }

    public void setOverlayLetterSize(int i) {
        this.f4233o = i;
        m4902c();
    }

    public void setOverlayLetterRightMargin(int i) {
        this.f4234p = i;
        m4902c();
    }

    public void setNavigationLetterNormalBackgroundColor(int i) {
        this.f4224f.setNavigationLetterNormalBackgroundColor(i);
    }

    public void setNavigationLetterActiveBackgroundColor(int i) {
        this.f4224f.setNavigationLetterActiveBackgroundColor(i);
    }

    public void setNavigationLetterNormalTextColor(int i) {
        this.f4224f.setNavigationLetterNormalTextColor(i);
    }

    public void setNavigationLetterActiveTextColor(int i) {
        this.f4224f.setNavigationLetterActiveTextColor(i);
    }

    public void setNavigationLetterTextSize(int i) {
        this.f4224f.setNavigationLetterTextSize(i);
    }

    public void setNavigationLetterVerticalSpace(int i) {
        this.f4224f.setNavigationLetterVerticalSpace(i);
    }

    public void setNavigationLetterRightMargin(int i) {
        this.f4224f.setNavigationLetterRightMargin(i);
    }

    public void setNavigationLetterWidth(int i) {
        this.f4224f.setNavigationLetterWidth(i);
    }

    public void setHideTopPassCount(int i) {
        this.f4224f.setHideTopPassCount(i);
    }

    public void setHideBottomPassCount(int i) {
        this.f4224f.setHideBottomPassCount(i);
    }

    public void setIntervalHide(int i) {
        this.f4224f.setIntervalHide(i);
    }

    public void setAutoHideLetter(boolean z) {
        this.f4224f.setAutoHideLetter(z);
    }

    public void setCallBack(C1304a aVar) {
        this.f4235q = aVar;
    }
}
