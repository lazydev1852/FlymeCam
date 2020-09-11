package com.meizu.sharewidget.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.meizu.sharewidget.OnResolveClickListener;
import com.meizu.sharewidget.PackageMonitor;
import com.meizu.sharewidget.R;
import com.meizu.sharewidget.ResolveFilter;
import com.meizu.sharewidget.ResolveFinder;
import com.meizu.sharewidget.adapter.GridViewAdapter;
import com.meizu.sharewidget.adapter.ViewPagerAdapter;
import com.meizu.sharewidget.p080a.C2858a;
import com.meizu.sharewidget.p080a.C2877h;
import flyme.support.p092v4.view.ViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class IntentChooserView extends FrameLayout {

    /* renamed from: a */
    protected final Context f15936a;

    /* renamed from: b */
    protected final Activity f15937b;

    /* renamed from: c */
    protected Intent f15938c;

    /* renamed from: d */
    protected final ResolveFinder f15939d;

    /* renamed from: e */
    protected final OnResolveClickListener f15940e;

    /* renamed from: f */
    private final Context f15941f;

    /* renamed from: g */
    private final LayoutInflater f15942g;

    /* renamed from: h */
    private ViewGroup f15943h;

    /* renamed from: i */
    private ViewGroup f15944i;

    /* renamed from: j */
    private TextView f15945j;

    /* renamed from: k */
    private TextView f15946k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CheckBox f15947l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ViewPager f15948m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public PageIndicator f15949n;
    @ColorInt

    /* renamed from: o */
    private int f15950o;
    @DrawableRes

    /* renamed from: p */
    private int f15951p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public List<C2858a> f15952q;

    /* renamed from: r */
    private ThreadPoolExecutor f15953r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f15954s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f15955t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f15956u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f15957v;

    /* renamed from: w */
    private ResolveFilter f15958w;

    /* renamed from: x */
    private ComponentName[] f15959x;

    /* renamed from: y */
    private PackageMonitor f15960y;

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: a */
    public abstract ResolveFinder mo24100a(Context context);

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: b */
    public abstract OnResolveClickListener mo24105b(Context context);

    public IntentChooserView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IntentChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IntentChooserView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15955t = true;
        this.f15956u = 5;
        this.f15957v = 2;
        this.f15960y = new PackageMonitor() {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public void mo24050b() {
                if (IntentChooserView.this.f15938c != null) {
                    IntentChooserView.this.mo24103a(IntentChooserView.this.f15938c);
                }
            }
        };
        if (context instanceof Activity) {
            this.f15936a = context;
            this.f15937b = (Activity) context;
            this.f15941f = context.getApplicationContext();
            this.f15942g = (LayoutInflater) context.getSystemService("layout_inflater");
            this.f15953r = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                public Thread newThread(@NonNull Runnable runnable) {
                    Thread thread = new Thread(runnable, "icon-loader-thread");
                    if (thread.isDaemon()) {
                        thread.setDaemon(false);
                    }
                    if (thread.getPriority() != 5) {
                        thread.setPriority(5);
                    }
                    return thread;
                }
            });
            this.f15953r.allowCoreThreadTimeOut(true);
            m17347e();
            this.f15939d = mo24100a(this.f15936a);
            this.f15940e = mo24105b(this.f15936a);
            m17337a(attributeSet);
            C2877h.m17276a(this.f15941f, this.f15936a.getPackageName());
            return;
        }
        throw new IllegalStateException("context should be instance of activity, but now is: " + context);
    }

    /* renamed from: a */
    private void m17337a(AttributeSet attributeSet) {
        this.f15942g.inflate(R.layout.share_view, this, true);
        this.f15943h = (ViewGroup) findViewById(R.id.share_view_container);
        this.f15944i = (ViewGroup) findViewById(R.id.share_view_header);
        this.f15945j = (TextView) findViewById(R.id.share_view_title);
        this.f15946k = (TextView) findViewById(R.id.share_view_summary);
        this.f15947l = (CheckBox) findViewById(R.id.share_view_checkbox);
        this.f15948m = (ViewPager) findViewById(R.id.share_view_pager);
        this.f15948m.getLayoutParams().height = this.f15936a.getResources().getDimensionPixelOffset(R.dimen.intent_chooser_view_item_height) * 2;
        this.f15949n = (PageIndicator) findViewById(R.id.share_view_indicator);
        this.f15945j.setVisibility(8);
        this.f15946k.setVisibility(8);
        this.f15947l.setVisibility(8);
        mo24106b();
        m17345d();
    }

    /* renamed from: d */
    private void m17345d() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f15944i.getLayoutParams();
        if (m17339a((View) this.f15945j) || m17339a((View) this.f15946k) || m17339a((View) this.f15947l)) {
            marginLayoutParams.bottomMargin = this.f15936a.getResources().getDimensionPixelOffset(R.dimen.intent_chooser_view_header_padding_bottom);
        } else {
            marginLayoutParams.bottomMargin = 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f15947l.getLayoutParams();
        if (!m17339a((View) this.f15947l) || (!m17339a((View) this.f15945j) && !m17339a((View) this.f15946k))) {
            marginLayoutParams2.topMargin = 0;
        } else {
            marginLayoutParams2.topMargin = this.f15936a.getResources().getDimensionPixelOffset(R.dimen.intent_chooser_view_checkbox_padding_top);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.f15946k.getLayoutParams();
        if (!m17339a((View) this.f15945j) || !m17339a((View) this.f15946k)) {
            marginLayoutParams3.topMargin = 0;
        } else {
            marginLayoutParams3.topMargin = this.f15936a.getResources().getDimensionPixelOffset(R.dimen.intent_chooser_view_summary_padding_top);
        }
        requestLayout();
    }

    /* renamed from: a */
    private boolean m17339a(View view) {
        return view.getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24102a(int i, int i2, int i3, int i4, int i5) {
        List<View> a;
        this.f15943h.setBackgroundColor(i);
        this.f15945j.setTextColor(i2);
        this.f15946k.setTextColor(i3);
        this.f15947l.setTextColor(i2);
        this.f15950o = i4;
        this.f15951p = i5;
        if (this.f15948m.getAdapter() != null && (a = ((ViewPagerAdapter) this.f15948m.getAdapter()).mo24085a()) != null) {
            Iterator<View> it = a.iterator();
            while (it.hasNext()) {
                GridViewAdapter aVar = (GridViewAdapter) ((GridView) it.next()).getAdapter();
                if (aVar != null) {
                    aVar.mo24086a(i4);
                    aVar.mo24087b(i5);
                    aVar.notifyDataSetChanged();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo24101a() {
        TypedArray obtainStyledAttributes = this.f15936a.obtainStyledAttributes(R.style.Widget_Flyme_ShareView_Night, R.styleable.IntentChooserView);
        int color = obtainStyledAttributes.getColor(R.styleable.IntentChooserView_bgColor, m17332a(R.color.colorNight));
        int color2 = obtainStyledAttributes.getColor(R.styleable.IntentChooserView_titleColor, m17332a(R.color.colorWhite50));
        int color3 = obtainStyledAttributes.getColor(R.styleable.IntentChooserView_summaryColor, m17332a(R.color.colorWhite30));
        int color4 = obtainStyledAttributes.getColor(R.styleable.IntentChooserView_itemTxtColor, m17332a(R.color.colorWhite50));
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.IntentChooserView_itemSelector, R.drawable.gridview_selector_dark);
        obtainStyledAttributes.recycle();
        mo24102a(color, color2, color3, color4, resourceId);
    }

    /* renamed from: b */
    public void mo24106b() {
        TypedArray obtainStyledAttributes = this.f15936a.obtainStyledAttributes(R.style.Widget_Flyme_ShareView_Day, R.styleable.IntentChooserView);
        int color = obtainStyledAttributes.getColor(R.styleable.IntentChooserView_bgColor, m17332a(R.color.colorWhite));
        int color2 = obtainStyledAttributes.getColor(R.styleable.IntentChooserView_titleColor, m17332a(R.color.colorBlack));
        int color3 = obtainStyledAttributes.getColor(R.styleable.IntentChooserView_summaryColor, m17332a(R.color.colorGrey));
        int color4 = obtainStyledAttributes.getColor(R.styleable.IntentChooserView_itemTxtColor, m17332a(R.color.colorBlack80));
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.IntentChooserView_itemSelector, R.drawable.gridview_selector);
        obtainStyledAttributes.recycle();
        mo24102a(color, color2, color3, color4, resourceId);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m17348f();
    }

    @ColorInt
    /* renamed from: a */
    private int m17332a(@ColorRes int i) {
        return this.f15936a.getResources().getColor(i);
    }

    public final void setIntent(Intent intent) {
        if (intent != null) {
            this.f15938c = intent;
            m17342b(intent);
            this.f15960y.mo24049a(this.f15936a);
            mo24103a(this.f15938c);
            return;
        }
        throw new IllegalArgumentException("intent can't be null");
    }

    /* renamed from: b */
    private void m17342b(Intent intent) {
        ComponentName[] componentNameArr = null;
        this.f15959x = null;
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.intent.extra.EXCLUDE_COMPONENTS");
        if (parcelableArrayExtra != null) {
            ComponentName[] componentNameArr2 = new ComponentName[parcelableArrayExtra.length];
            int i = 0;
            while (true) {
                if (i >= parcelableArrayExtra.length) {
                    componentNameArr = componentNameArr2;
                    break;
                } else if (!(parcelableArrayExtra[i] instanceof ComponentName)) {
                    Log.w("IntentChooserView", "Filtered component #" + i + " not a ComponentName: " + parcelableArrayExtra[i]);
                    break;
                } else {
                    componentNameArr2[i] = (ComponentName) parcelableArrayExtra[i];
                    i++;
                }
            }
            this.f15959x = componentNameArr;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24103a(Intent intent) {
        try {
            this.f15952q = this.f15939d.mo24094a(this.f15936a, intent);
            m17338a(this.f15952q);
            if (this.f15952q == null || this.f15952q.size() <= 0) {
                Log.d("IntentChooserView", "share list is empty, return");
                this.f15937b.finish();
            } else if (this.f15952q.size() == 1) {
                Log.d("IntentChooserView", "share list size == 1");
                this.f15940e.mo24052a(this.f15937b, intent, this.f15952q.get(0), this.f15954s, this.f15955t, false);
            } else {
                m17348f();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.f15937b.finish();
        }
    }

    /* renamed from: e */
    private void m17347e() {
        if (Build.VERSION.SDK_INT >= 18) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            builder.detectFileUriExposure();
            StrictMode.setVmPolicy(builder.build());
        }
    }

    /* renamed from: f */
    private void m17348f() {
        post(new Runnable() {
            public void run() {
                if (IntentChooserView.this.f15952q == null) {
                    Log.d("IntentChooserView", "mList == null, return direct");
                    return;
                }
                int dimensionPixelSize = IntentChooserView.this.f15936a.getResources().getDimensionPixelSize(R.dimen.share_item_width);
                int b = IntentChooserView.this.f15952q.size() > IntentChooserView.this.f15956u ? IntentChooserView.this.f15956u : IntentChooserView.this.f15952q.size();
                int a = IntentChooserView.this.m17340b(b);
                int measuredWidth = ((IntentChooserView.this.getMeasuredWidth() - (dimensionPixelSize * b)) - ((b - 1) * a)) / 2;
                ArrayList arrayList = new ArrayList();
                int size = (IntentChooserView.this.f15952q.size() / (IntentChooserView.this.f15956u * IntentChooserView.this.f15957v)) + (IntentChooserView.this.f15952q.size() % (IntentChooserView.this.f15956u * IntentChooserView.this.f15957v) > 0 ? 1 : 0);
                for (int i = 0; i < size; i++) {
                    int b2 = IntentChooserView.this.f15956u * i * IntentChooserView.this.f15957v;
                    arrayList.add(IntentChooserView.this.m17335a(IntentChooserView.this.f15952q.subList(b2, (IntentChooserView.this.f15956u * IntentChooserView.this.f15957v) + b2 > IntentChooserView.this.f15952q.size() ? IntentChooserView.this.f15952q.size() : (IntentChooserView.this.f15956u * IntentChooserView.this.f15957v) + b2), b, measuredWidth, a));
                }
                if (IntentChooserView.this.f15952q.size() > IntentChooserView.this.f15956u) {
                    IntentChooserView.this.f15948m.getLayoutParams().height = IntentChooserView.this.f15936a.getResources().getDimensionPixelOffset(R.dimen.intent_chooser_view_item_height) * 2;
                } else {
                    IntentChooserView.this.f15948m.getLayoutParams().height = IntentChooserView.this.f15936a.getResources().getDimensionPixelOffset(R.dimen.intent_chooser_view_item_height);
                }
                IntentChooserView.this.f15948m.setAdapter(new ViewPagerAdapter(IntentChooserView.this.f15936a, arrayList));
                IntentChooserView.this.f15949n.mo24127a(IntentChooserView.this.f15948m);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public GridView m17335a(List<C2858a> list, int i, int i2, int i3) {
        GridView gridView = new GridView(this.f15936a);
        final GridViewAdapter aVar = new GridViewAdapter(this.f15936a, list, this.f15953r, this.f15950o, this.f15951p);
        gridView.setAdapter(aVar);
        gridView.setNumColumns(i);
        gridView.setBackgroundColor(0);
        gridView.setPadding(i2, 0, i2, 0);
        gridView.setVerticalSpacing(0);
        gridView.setHorizontalSpacing(i3);
        gridView.setGravity(1);
        gridView.setStretchMode(2);
        gridView.setSelector(new ColorDrawable(0));
        gridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                IntentChooserView.this.f15940e.mo24052a(IntentChooserView.this.f15937b, IntentChooserView.this.f15938c, aVar.getItem(i), IntentChooserView.this.f15954s, IntentChooserView.this.f15955t, IntentChooserView.this.f15947l.isChecked());
            }
        });
        return gridView;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m17340b(int i) {
        switch (i) {
            case 2:
                return this.f15936a.getResources().getDimensionPixelOffset(R.dimen.icon_gap_two);
            case 3:
                return this.f15936a.getResources().getDimensionPixelOffset(R.dimen.icon_gap_three);
            case 4:
                return this.f15936a.getResources().getDimensionPixelOffset(R.dimen.icon_gap_four);
            default:
                return this.f15936a.getResources().getDimensionPixelOffset(R.dimen.icon_gap_five);
        }
    }

    /* renamed from: a */
    private void m17338a(List<C2858a> list) {
        if (list != null && list.size() > 0) {
            if (this.f15958w != null || this.f15959x != null) {
                Iterator<C2858a> it = list.iterator();
                while (it.hasNext()) {
                    C2858a next = it.next();
                    if (this.f15958w != null && !this.f15958w.mo24078a(next.f15833a)) {
                        it.remove();
                    }
                    if (mo24104a(next.f15833a.activityInfo.packageName, next.f15833a.activityInfo.name)) {
                        it.remove();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo24104a(String str, String str2) {
        if (this.f15959x == null) {
            return false;
        }
        for (ComponentName componentName : this.f15959x) {
            if (componentName.getPackageName().equals(str) && componentName.getClassName().equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void setResolveFilter(ResolveFilter bVar) {
        if (bVar != null) {
            this.f15958w = bVar;
            m17338a(this.f15952q);
            if (this.f15952q != null && this.f15952q.size() > 0) {
                m17348f();
            }
        }
    }

    public void setForwardResult(boolean z) {
        this.f15954s = z;
    }

    public void setShouldFinish(boolean z) {
        this.f15955t = z;
    }

    public void setGridColumn(int i) {
        this.f15956u = i;
        m17348f();
    }

    public void setGridRow(int i) {
        this.f15957v = i;
        m17348f();
    }

    public void setTitle(String str) {
        this.f15945j.setText(str);
        if (TextUtils.isEmpty(str)) {
            this.f15945j.setVisibility(8);
        } else {
            this.f15945j.setVisibility(0);
        }
        m17345d();
    }

    public void setTitleVisibility(boolean z) {
        this.f15945j.setVisibility(z ? 0 : 8);
        m17345d();
    }

    public void setSummary(String str) {
        this.f15946k.setText(str);
        if (TextUtils.isEmpty(str)) {
            this.f15946k.setVisibility(8);
        } else {
            this.f15946k.setVisibility(0);
        }
        m17345d();
    }

    public void setSummaryVisibility(boolean z) {
        this.f15946k.setVisibility(z ? 0 : 8);
        m17345d();
    }

    public void setCheckBoxText(String str) {
        this.f15947l.setText(str);
        if (TextUtils.isEmpty(str)) {
            this.f15947l.setVisibility(8);
        } else {
            this.f15947l.setVisibility(0);
        }
        m17345d();
    }

    public void setCheckBoxVisibility(boolean z) {
        this.f15947l.setVisibility(z ? 0 : 8);
        m17345d();
    }

    public CheckBox getCheckBoxView() {
        return this.f15947l;
    }

    /* renamed from: c */
    public void mo24107c() {
        this.f15960y.mo24048a();
        if (this.f15953r != null) {
            this.f15953r.shutdownNow();
            this.f15953r = null;
        }
    }
}
