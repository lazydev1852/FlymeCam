package com.meizu.common.preference;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.meizu.common.R;
import java.lang.reflect.Field;

@SuppressLint({"NewApi"})
public class ExpandableListPreference extends Preference {

    /* renamed from: a */
    public boolean f4305a;

    /* renamed from: b */
    private ListView f4306b;

    /* renamed from: c */
    private LinearLayout f4307c;

    /* renamed from: d */
    private C1312a f4308d;

    /* renamed from: e */
    private int f4309e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CharSequence[] f4310f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CharSequence[] f4311g;

    /* renamed from: h */
    private String f4312h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1319b f4313i;

    /* renamed from: j */
    private boolean f4314j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public TextView f4315k;

    /* renamed from: l */
    private ImageView f4316l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Handler f4317m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f4318n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Runnable f4319o;

    public ExpandableListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4305a = false;
        this.f4309e = 400;
        this.f4317m = new Handler();
        this.f4318n = false;
        this.f4319o = new Runnable() {
            public void run() {
                ExpandableListPreference.this.mo15888a();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableListPreference, 0, 0);
        this.f4310f = obtainStyledAttributes.getTextArray(R.styleable.ExpandableListPreference_mcEntries);
        this.f4311g = obtainStyledAttributes.getTextArray(R.styleable.ExpandableListPreference_mcEntryValues);
        obtainStyledAttributes.recycle();
        setLayoutResource(R.layout.mc_expandable_preference_layout);
        this.f4308d = new C1312a();
        this.f4308d.mo15899a(-context.getResources().getDimensionPixelSize(R.dimen.mc_expandable_preference_inner_list_margin));
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        super.onBindView(view);
        this.f4306b = (ListView) view.findViewById(R.id.expand_listview);
        this.f4313i = new C1319b(getContext(), this.f4310f);
        this.f4315k = (TextView) view.findViewById(16908304);
        this.f4316l = (ImageView) view.findViewById(R.id.pull_icon);
        if (this.f4310f != null && this.f4310f.length > 0) {
            int c = m4981c() != -1 ? m4981c() : 0;
            setSummary(this.f4310f[c]);
            this.f4315k.setText(this.f4310f[c]);
            this.f4313i.mo15914a(c);
            this.f4313i.notifyDataSetChanged();
            if (this.f4305a) {
                this.f4315k.setVisibility(4);
            } else {
                this.f4315k.setVisibility(0);
            }
            this.f4306b.setAdapter(this.f4313i);
            this.f4313i.mo15915a(this.f4306b);
            this.f4306b.setChoiceMode(1);
            this.f4306b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!ExpandableListPreference.this.mo15891b() && !ExpandableListPreference.this.f4318n) {
                        ExpandableListPreference.this.f4313i.mo15914a(i);
                        ExpandableListPreference.this.f4313i.notifyDataSetChanged();
                        if (ExpandableListPreference.this.f4311g != null) {
                            String charSequence = ExpandableListPreference.this.f4311g[i].toString();
                            ExpandableListPreference.this.f4315k.setText(ExpandableListPreference.this.f4310f[i]);
                            ExpandableListPreference.this.m4977a(ExpandableListPreference.this.f4310f[i]);
                            if (ExpandableListPreference.this.callChangeListener(charSequence)) {
                                ExpandableListPreference.this.mo15889a(charSequence);
                            }
                        }
                        ExpandableListPreference.this.f4317m.postDelayed(ExpandableListPreference.this.f4319o, 200);
                    }
                }
            });
        }
        this.f4307c = (LinearLayout) view.findViewById(R.id.container);
        this.f4307c.measure(0, 0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4307c.getLayoutParams();
        if (this.f4310f != null && this.f4310f.length > 0) {
            layoutParams.height = this.f4307c.getMeasuredHeight() * this.f4310f.length;
        }
        if (this.f4305a) {
            this.f4307c.setVisibility(0);
            this.f4307c.setFocusable(false);
            return;
        }
        this.f4307c.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onClick() {
        if (!mo15891b() && !this.f4318n) {
            if (this.f4305a) {
                this.f4308d.mo15900a(this.f4307c, this.f4316l, this.f4315k, 1, (long) this.f4309e);
                this.f4308d.mo15898a();
                this.f4305a = false;
                return;
            }
            this.f4308d.mo15900a(this.f4307c, this.f4316l, this.f4315k, 0, (long) this.f4309e);
            this.f4308d.mo15898a();
            this.f4305a = true;
        }
    }

    /* renamed from: a */
    public void mo15888a() {
        if (this.f4305a) {
            this.f4308d.mo15900a(this.f4307c, this.f4316l, this.f4315k, 1, (long) this.f4309e);
            this.f4308d.mo15898a();
            this.f4305a = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(boolean z, Object obj) {
        mo15889a(z ? getPersistedString(this.f4312h) : (String) obj);
    }

    /* renamed from: a */
    public void mo15889a(String str) {
        boolean z = !TextUtils.equals(this.f4312h, str);
        if (z || !this.f4314j) {
            this.f4312h = str;
            this.f4314j = true;
            persistString(str);
            if (z) {
                notifyChanged();
            }
        }
    }

    /* renamed from: b */
    public int mo15890b(String str) {
        if (str == null || this.f4311g == null) {
            return -1;
        }
        for (int length = this.f4311g.length - 1; length >= 0; length--) {
            if (this.f4311g[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    /* renamed from: c */
    private int m4981c() {
        return mo15890b(this.f4312h);
    }

    /* renamed from: com.meizu.common.preference.ExpandableListPreference$b */
    private class C1319b extends BaseAdapter {

        /* renamed from: b */
        private CharSequence[] f4344b;

        /* renamed from: c */
        private Context f4345c;

        /* renamed from: d */
        private int f4346d = -1;

        /* renamed from: e */
        private ListView f4347e;

        public long getItemId(int i) {
            return (long) i;
        }

        public C1319b(Context context, CharSequence[] charSequenceArr) {
            this.f4345c = context;
            this.f4344b = charSequenceArr;
        }

        public int getCount() {
            return this.f4344b.length;
        }

        public Object getItem(int i) {
            return this.f4344b[i];
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C1320a aVar;
            if (view == null) {
                aVar = new C1320a();
                view2 = ((LayoutInflater) this.f4345c.getSystemService("layout_inflater")).inflate(R.layout.mc_expandable_preference_list_item, (ViewGroup) null);
                aVar.f4348a = (CheckedTextView) view2;
                view2.setLayoutParams(new AbsListView.LayoutParams(-1, this.f4345c.getResources().getDimensionPixelOffset(R.dimen.mc_expandable_preference_list_item_height)));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (C1320a) view.getTag();
            }
            aVar.f4348a.setText(this.f4344b[i]);
            if (i == this.f4346d) {
                this.f4347e.setItemChecked(i, true);
            }
            return view2;
        }

        /* renamed from: com.meizu.common.preference.ExpandableListPreference$b$a */
        private class C1320a {

            /* renamed from: a */
            public CheckedTextView f4348a;

            private C1320a() {
            }
        }

        /* renamed from: a */
        public void mo15914a(int i) {
            this.f4346d = i;
        }

        /* renamed from: a */
        public void mo15915a(ListView listView) {
            this.f4347e = listView;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: com.meizu.common.preference.ExpandableListPreference$a */
    public class C1312a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public View f4323b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public View f4324c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public View f4325d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int f4326e;

        /* renamed from: f */
        private long f4327f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public LinearLayout.LayoutParams f4328g;

        /* renamed from: h */
        private int f4329h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public int f4330i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public int f4331j;

        /* renamed from: k */
        private float f4332k;

        /* renamed from: l */
        private float f4333l;

        /* renamed from: m */
        private int f4334m = 0;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public boolean f4335n = false;

        public C1312a() {
        }

        /* renamed from: a */
        public void mo15900a(View view, View view2, View view3, int i, long j) {
            this.f4323b = view;
            this.f4324c = view3;
            this.f4325d = view2;
            this.f4326e = i;
            this.f4327f = j;
            this.f4328g = (LinearLayout.LayoutParams) this.f4323b.getLayoutParams();
            this.f4329h = this.f4328g.height;
            if (this.f4326e == 0) {
                this.f4328g.bottomMargin = -this.f4329h;
            } else {
                this.f4328g.bottomMargin = 0;
            }
            this.f4323b.setVisibility(0);
            float f = 1.0f;
            this.f4323b.setAlpha(this.f4326e == 0 ? 0.0f : 1.0f);
            this.f4324c.setVisibility(0);
            View view4 = this.f4324c;
            if (this.f4326e != 0) {
                f = 0.0f;
            }
            view4.setAlpha(f);
        }

        /* renamed from: a */
        public void mo15898a() {
            if (this.f4326e == 0) {
                this.f4330i = (-this.f4329h) + this.f4334m;
                this.f4331j = 0;
                this.f4332k = 0.0f;
                this.f4333l = 1.0f;
            } else if (this.f4326e == 1) {
                this.f4330i = 0;
                this.f4331j = (-this.f4329h) + this.f4334m;
                this.f4332k = 1.0f;
                this.f4333l = 0.0f;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f4333l, this.f4332k});
            ofFloat.setDuration((long) ((int) (((double) this.f4327f) * 0.4d)));
            if (this.f4326e == 1) {
                ofFloat.setStartDelay((long) ((int) (((double) this.f4327f) * 0.6d)));
            }
            ofFloat.setInterpolator(m4995c());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    C1312a.this.f4324c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (C1312a.this.f4326e == 1) {
                        C1312a.this.f4324c.setVisibility(0);
                    } else {
                        C1312a.this.f4324c.setVisibility(4);
                    }
                }
            });
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{this.f4332k, this.f4333l});
            ofFloat2.setDuration((long) ((int) (((double) this.f4327f) * 0.5d)));
            if (this.f4326e == 0) {
                ofFloat2.setStartDelay((long) ((int) (((double) this.f4327f) * 0.4d)));
            }
            ofFloat2.setInterpolator(m4995c());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    C1312a.this.f4323b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            final ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f4330i, this.f4331j});
            ofInt.setInterpolator(m4995c());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float abs = ((float) Math.abs(((Integer) valueAnimator.getAnimatedValue()).intValue() - C1312a.this.f4330i)) / ((float) Math.abs(C1312a.this.f4330i - C1312a.this.f4331j));
                    if (C1312a.this.f4326e == 0) {
                        C1312a.this.f4325d.setRotation(abs * 180.0f);
                    } else {
                        C1312a.this.f4325d.setRotation((1.0f - abs) * 180.0f);
                    }
                    C1312a.this.f4328g.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (!C1312a.this.f4323b.isInLayout()) {
                        C1312a.this.f4323b.requestLayout();
                    }
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    C1312a.this.f4323b.setVisibility(0);
                    boolean unused = C1312a.this.f4335n = true;
                }

                public void onAnimationEnd(Animator animator) {
                    animator.removeAllListeners();
                    ofInt.removeAllUpdateListeners();
                    ofInt.removeAllListeners();
                    if (C1312a.this.f4326e == 1) {
                        C1312a.this.f4323b.setVisibility(4);
                    }
                    boolean unused = C1312a.this.f4335n = false;
                }
            });
            ofInt.setDuration(this.f4327f);
            animatorSet.playTogether(new Animator[]{ofInt, ofFloat2, ofFloat});
            animatorSet.start();
        }

        /* renamed from: a */
        public void mo15899a(int i) {
            this.f4334m = i;
        }

        /* renamed from: c */
        private Interpolator m4995c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return new PathInterpolator(0.33f, 0.0f, 0.1f, 1.0f);
            }
            return new C1318a();
        }

        /* renamed from: com.meizu.common.preference.ExpandableListPreference$a$a */
        private class C1318a implements Interpolator {
            private C1318a() {
            }

            public float getInterpolation(float f) {
                return (float) (1.0d - Math.pow((double) (1.0f - f), 3.0d));
            }
        }

        /* renamed from: b */
        public boolean mo15901b() {
            return this.f4335n;
        }
    }

    /* renamed from: b */
    public boolean mo15891b() {
        if (this.f4308d != null) {
            return this.f4308d.mo15901b();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4977a(CharSequence charSequence) {
        try {
            Field declaredField = Preference.class.getDeclaredField("mSummary");
            declaredField.setAccessible(true);
            declaredField.set(this, charSequence);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        }
    }
}
