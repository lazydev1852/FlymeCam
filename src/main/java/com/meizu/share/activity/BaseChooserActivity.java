package com.meizu.share.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.meizu.share.IntentModifier;
import com.meizu.share.IntentParser;
import com.meizu.share.LogUtils;
import com.meizu.share.OnTargetClickHandler;
import com.meizu.share.OnViewClickListener;
import com.meizu.share.PackageMonitor;
import com.meizu.share.activity.ChooserContract;
import com.meizu.share.p078a.GridItemDecoration;
import com.meizu.share.p078a.HeaderAndFooterAdapter;
import com.meizu.share.p078a.ListAdapter;
import com.meizu.share.p079b.ChooserTargets;
import com.meizu.share.p079b.DisplayResolveInfo;
import com.meizu.share.utils.C2834c;
import com.meizu.share.utils.C2849h;
import com.meizu.share.widget.NestedScrollingLayout;
import com.meizu.share.widget.RectClipView;
import com.meizu.sharewidget.R;
import flyme.support.p093v7.widget.GridLayoutManager;
import flyme.support.p093v7.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
public abstract class BaseChooserActivity extends Activity implements ChooserContract.C2821b {

    /* renamed from: A */
    private NestedScrollingLayout.C2851b f15687A = new NestedScrollingLayout.C2851b() {
        /* renamed from: a */
        public void mo23967a(boolean z) {
            BaseChooserActivity.this.m17042a(z);
        }
    };

    /* renamed from: B */
    private OnViewClickListener f15688B = new OnViewClickListener() {
        /* renamed from: a */
        public void mo23968a(DisplayResolveInfo bVar) {
            Intent a = BaseChooserActivity.this.f15710u.mo23977a(new Intent(bVar.f15737d != null ? bVar.f15737d : BaseChooserActivity.this.f15711v), bVar.f15734a);
            boolean z = BaseChooserActivity.this.f15695f.getVisibility() == 0 && BaseChooserActivity.this.f15695f.isChecked();
            LogUtils.m17128a("onClick intent=" + a + ", isChecked=" + z);
            IntentSender o = BaseChooserActivity.this.f15690a.mo24001o();
            if (o != null) {
                try {
                    Intent intent = new Intent();
                    intent.putExtra("android.intent.extra.INTENT", a);
                    intent.putExtra("KEY_IS_CHECK_BOX_CHECKED", z);
                    a.addFlags(268435456);
                    o.sendIntent(BaseChooserActivity.this, -1, intent, new C2819a(), new Handler(Looper.getMainLooper()));
                    LogUtils.m17128a("handleBy " + o);
                } catch (IntentSender.SendIntentException e) {
                    LogUtils.m17130b(e.toString());
                }
            } else {
                LogUtils.m17128a("handleBy " + BaseChooserActivity.this);
                BaseChooserActivity.this.f15709t.mo24002a(BaseChooserActivity.this, a, bVar.f15734a, BaseChooserActivity.this.f15705p.mo23946b(), z);
                BaseChooserActivity.this.m17042a(false);
            }
            BaseChooserActivity.this.mo23951a(a, bVar.f15734a, z);
        }
    };

    /* renamed from: C */
    private PackageMonitor f15689C = new PackageMonitor() {
        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo23916b() {
            BaseChooserActivity.this.f15707r.mo23971a(BaseChooserActivity.this, BaseChooserActivity.this.f15711v, BaseChooserActivity.this.f15690a.mo23999m());
        }
    };

    /* renamed from: a */
    protected IntentParser f15690a;

    /* renamed from: b */
    private NestedScrollingLayout f15691b;

    /* renamed from: c */
    private LinearLayout f15692c;

    /* renamed from: d */
    private TextView f15693d;

    /* renamed from: e */
    private TextView f15694e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CheckBox f15695f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public RecyclerView f15696g;

    /* renamed from: h */
    private View f15697h;

    /* renamed from: i */
    private View f15698i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f15699j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f15700k;

    /* renamed from: l */
    private Button f15701l;

    /* renamed from: m */
    private View f15702m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f15703n;

    /* renamed from: o */
    private HeaderAndFooterAdapter f15704o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ListAdapter f15705p;

    /* renamed from: q */
    private ListAdapter f15706q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ChooserContract.C2820a f15707r;

    /* renamed from: s */
    private NightModeChangeReceiver f15708s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public OnTargetClickHandler f15709t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public IntentModifier f15710u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Intent f15711v;

    /* renamed from: w */
    private RecyclerView.C3265f f15712w;

    /* renamed from: x */
    private int f15713x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f15714y = false;

    /* renamed from: z */
    private NestedScrollingLayout.C2852c f15715z = new NestedScrollingLayout.C2852c() {
        /* renamed from: a */
        public void mo23966a(int i) {
            BaseChooserActivity.this.m17038a(i > 0 ? i + BaseChooserActivity.this.f15703n : BaseChooserActivity.this.f15703n);
        }
    };

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: a */
    public abstract ChooserContract.C2820a mo23950a();

    /* renamed from: a */
    public void mo23951a(Intent intent, ResolveInfo resolveInfo, boolean z) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo23952a(CheckBox checkBox);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo23953a(TextView textView);

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: b */
    public abstract OnTargetClickHandler mo23955b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo23956b(TextView textView);

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: c */
    public abstract IntentModifier mo23957c();

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: d */
    public abstract Intent mo23958d();

    /* renamed from: e */
    public void mo23959e() {
    }

    @Keep
    public int mzNightModeUseOf() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        LogUtils.m17125a();
        LogUtils.m17128a("onCreate: " + toString());
        LogUtils.m17126a(getIntent());
        overridePendingTransition(R.anim.mz_share_alpha_enter, 0);
        this.f15690a = new IntentParser(getIntent());
        m17063j();
        m17064k();
        super.onCreate(bundle);
        setContentView(R.layout.mz_activity_chooser);
        m17055f();
        if (this.f15690a.mo23998l()) {
            getWindow().addFlags(4194304);
        }
        if (this.f15690a.mo23997k()) {
            getWindow().addFlags(524288);
        }
        if (bundle != null && bundle.containsKey("KEY_IS_NIGHT_MODE")) {
            this.f15714y = bundle.getBoolean("KEY_IS_NIGHT_MODE");
        } else if (this.f15690a.mo23989c()) {
            this.f15714y = this.f15690a.mo23990d();
        } else {
            this.f15714y = C2849h.m17216a(this);
        }
        m17047b(this.f15714y);
        this.f15707r = mo23950a();
        this.f15709t = mo23955b();
        this.f15710u = mo23957c();
        m17059h();
        this.f15689C.mo23915a(this);
        this.f15711v = this.f15710u.mo23976a(mo23958d());
        this.f15707r.mo23971a(this, this.f15711v, this.f15690a.mo23999m());
        mo23959e();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("KEY_IS_NIGHT_MODE", this.f15714y);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m17061i();
        this.f15689C.mo23914a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17042a(boolean z) {
        super.finish();
        overridePendingTransition(0, z ? R.anim.mz_share_alpha_exit : 0);
    }

    /* renamed from: f */
    private void m17055f() {
        this.f15691b = (NestedScrollingLayout) findViewById(R.id.chooser_nested_scrolling_layout);
        this.f15691b.setScrollListener(this.f15715z);
        this.f15691b.setOnDismissedListener(this.f15687A);
        this.f15691b.setMaxHeight(m17056g() - (getResources().getDimensionPixelOffset(R.dimen.chooser_dialog_margin_bottom) * 2));
        this.f15692c = (LinearLayout) findViewById(R.id.chooser_header_container);
        this.f15693d = (TextView) findViewById(R.id.chooser_title);
        mo23953a(this.f15693d);
        this.f15694e = (TextView) findViewById(R.id.chooser_sub_title);
        mo23956b(this.f15694e);
        this.f15695f = (CheckBox) findViewById(R.id.chooser_check_box);
        mo23952a(this.f15695f);
        this.f15701l = (Button) findViewById(R.id.chooser_btn_cancel);
        this.f15701l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseChooserActivity.this.m17042a(true);
            }
        });
        this.f15702m = findViewById(R.id.chooser_btn_placeholder);
        this.f15702m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseChooserActivity.this.m17042a(true);
            }
        });
        this.f15696g = (RecyclerView) findViewById(R.id.chooser_list);
        this.f15705p = new ListAdapter(this, this.f15688B);
        this.f15706q = new ListAdapter(this, this.f15688B);
        this.f15704o = new HeaderAndFooterAdapter(this.f15705p);
        this.f15696g.setAdapter(this.f15704o);
        this.f15697h = findViewById(R.id.chooser_scrollIndicatorUpContainer);
        this.f15698i = findViewById(R.id.chooser_scrollIndicatorDownContainer);
        this.f15699j = findViewById(R.id.chooser_scrollIndicatorUp);
        this.f15700k = findViewById(R.id.chooser_scrollIndicatorDown);
        this.f15696g.mo26374a((RecyclerView.C3274l) new RecyclerView.C3274l() {
            /* renamed from: a */
            public void mo20072a(RecyclerView recyclerView, int i, int i2) {
                if (i2 != 0) {
                    BaseChooserActivity.m17039a((View) BaseChooserActivity.this.f15696g, BaseChooserActivity.this.f15699j, BaseChooserActivity.this.f15700k);
                }
            }
        });
    }

    /* renamed from: g */
    private int m17056g() {
        WindowManager windowManager = (WindowManager) getSystemService("window");
        if (windowManager == null) {
            return getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* renamed from: a */
    static void m17039a(View view, View view2, View view3) {
        int i = 4;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1)) {
                i = 0;
            }
            view3.setVisibility(i);
        }
    }

    /* renamed from: com.meizu.share.activity.BaseChooserActivity$a */
    private static class C2819a implements IntentSender.OnFinished {

        /* renamed from: a */
        private WeakReference<BaseChooserActivity> f15724a;

        private C2819a(BaseChooserActivity baseChooserActivity) {
            this.f15724a = new WeakReference<>(baseChooserActivity);
        }

        public void onSendFinished(IntentSender intentSender, Intent intent, int i, String str, Bundle bundle) {
            BaseChooserActivity baseChooserActivity = (BaseChooserActivity) this.f15724a.get();
            if (baseChooserActivity == null) {
                LogUtils.m17130b("onSendFinished, but activity == null");
            } else {
                baseChooserActivity.m17042a(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17038a(int i) {
        if (this.f15700k != null) {
            this.f15700k.setVisibility(i < this.f15713x ? 0 : 4);
        }
        ((RectClipView) this.f15696g.getParent()).setClipRect(0, 0, getResources().getDimensionPixelOffset(R.dimen.chooser_dialog_width), i + 50);
    }

    /* renamed from: a */
    public void mo23954a(ChooserTargets aVar, boolean z, boolean z2) {
        if (aVar != null) {
            List<DisplayResolveInfo> c = aVar.mo23980c();
            LogUtils.m17131b("all target before filter", c);
            List<DisplayResolveInfo> b = m17046b(c);
            LogUtils.m17131b("all target after filter", b);
            int i = 0;
            if (b.size() == 0) {
                m17042a(false);
            } else if (b.size() == 1) {
                this.f15688B.mo23968a(b.get(0));
            } else if (!z) {
                int a = m17036a((List) b);
                this.f15713x = getResources().getDimensionPixelOffset(R.dimen.chooser_dialog_item_height) * a;
                this.f15691b.setUncollapsibleHeight(m17044b(a));
                int i2 = this.f15703n;
                if (this.f15691b.getCurrentScrollY() > 0) {
                    i = this.f15691b.getCurrentScrollY();
                }
                m17038a(i2 + i);
                this.f15707r.mo23972a(this, aVar);
            } else {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.chooser_dialog_item_gap);
                int min = Math.min(b.size(), 4);
                int dimensionPixelOffset2 = ((getResources().getDimensionPixelOffset(R.dimen.chooser_dialog_width) - (getResources().getDimensionPixelOffset(R.dimen.chooser_dialog_item_width) * min)) - ((min - 1) * dimensionPixelOffset)) / 2;
                this.f15696g.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset2, 0);
                this.f15696g.setLayoutManager(new GridLayoutManager(this, min));
                this.f15704o.mo23928b(this.f15696g);
                if (this.f15712w != null) {
                    this.f15696g.mo26382b(this.f15712w);
                }
                this.f15712w = new GridItemDecoration(min, dimensionPixelOffset);
                this.f15696g.mo26371a(this.f15712w);
                this.f15705p.mo23945a(b);
                this.f15707r.mo23973a(b);
            }
        }
    }

    /* renamed from: a */
    public static int m17036a(List list) {
        int min = Math.min(list.size(), 4);
        return (list.size() / min) + (list.size() % min > 0 ? 1 : 0);
    }

    /* renamed from: b */
    private int m17044b(int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, 0);
        this.f15692c.measure(makeMeasureSpec, makeMeasureSpec);
        this.f15701l.measure(makeMeasureSpec, makeMeasureSpec);
        if (i > 2) {
            this.f15703n = (getResources().getDimensionPixelOffset(R.dimen.chooser_dialog_item_height) * 2) + 130;
        } else {
            this.f15703n = getResources().getDimensionPixelOffset(R.dimen.chooser_dialog_item_height) * i;
        }
        return this.f15692c.getMeasuredHeight() + this.f15696g.getPaddingTop() + this.f15703n + this.f15701l.getMeasuredHeight() + this.f15691b.getPaddingBottom();
    }

    /* renamed from: h */
    private void m17059h() {
        if (this.f15708s == null && !this.f15690a.mo23991e()) {
            this.f15708s = new NightModeChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flymelab.nightmode.action.flymelab.SETTINGS_CHANGED");
            registerReceiver(this.f15708s, intentFilter);
        }
    }

    /* renamed from: i */
    private void m17061i() {
        if (this.f15708s != null) {
            unregisterReceiver(this.f15708s);
            this.f15708s = null;
        }
    }

    private class NightModeChangeReceiver extends BroadcastReceiver {
        private NightModeChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.meizu.flymelab.nightmode.action.flymelab.SETTINGS_CHANGED".equals(intent.getAction())) {
                boolean unused = BaseChooserActivity.this.f15714y = intent.getBooleanExtra("flymelab_flyme_night_mode", false);
                BaseChooserActivity.this.m17047b(BaseChooserActivity.this.f15714y);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17047b(boolean z) {
        m17051c(z);
        if (z) {
            this.f15693d.setTextColor(getResources().getColor(R.color.colorWhite50));
            this.f15695f.setTextColor(getResources().getColor(R.color.colorWhite50));
            this.f15701l.setTextColor(getResources().getColor(R.color.colorWhite50));
            this.f15692c.setBackgroundResource(R.drawable.mz_chooser_dialog_bg_top_dark);
            this.f15697h.setBackgroundResource(R.color.colorNight);
            this.f15696g.setBackgroundResource(R.color.colorNight);
            this.f15698i.setBackgroundResource(R.color.colorNight);
            this.f15701l.setBackgroundResource(R.drawable.mz_chooser_dialog_bg_bottom_dark);
            this.f15705p.mo23943a(getResources().getColor(R.color.colorWhite50));
            this.f15705p.mo23947b(R.drawable.gridview_selector_dark);
            this.f15705p.mo26541f();
            this.f15706q.mo23943a(getResources().getColor(R.color.colorWhite50));
            this.f15706q.mo23947b(R.drawable.gridview_selector_dark);
            this.f15706q.mo26541f();
            return;
        }
        this.f15693d.setTextColor(getResources().getColor(R.color.colorBlack));
        this.f15695f.setTextColor(getResources().getColor(R.color.checkBoxTextColor));
        this.f15701l.setTextColor(getResources().getColor(R.color.mz_system_function));
        this.f15692c.setBackgroundResource(R.drawable.mz_chooser_dialog_bg_top);
        this.f15697h.setBackgroundResource(R.color.colorWhite);
        this.f15696g.setBackgroundResource(R.color.colorWhite);
        this.f15698i.setBackgroundResource(R.color.colorWhite);
        this.f15701l.setBackgroundResource(R.drawable.mz_chooser_dialog_bg_bottom);
        this.f15705p.mo23943a(getResources().getColor(R.color.colorBlack80));
        this.f15705p.mo23947b(R.drawable.gridview_selector);
        this.f15705p.mo26541f();
        this.f15706q.mo23943a(getResources().getColor(R.color.colorBlack80));
        this.f15706q.mo23947b(R.drawable.gridview_selector);
        this.f15706q.mo26541f();
    }

    /* renamed from: j */
    private void m17063j() {
        if ((getResources().getConfiguration().orientation == 2 && this.f15690a.mo23995i()) || (getResources().getConfiguration().orientation == 1 && this.f15690a.mo23996j())) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        }
    }

    /* renamed from: k */
    private void m17064k() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.getDecorView().setSystemUiVisibility(1792);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
        }
    }

    /* renamed from: c */
    private void m17051c(boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 8192);
            try {
                C2834c.C2842g a = C2834c.m17187a((Class<?>) WindowManager.LayoutParams.class).mo24023a("statusBarColor");
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                a.mo24025a(attributes, Integer.valueOf(z ? -1 : ViewCompat.MEASURED_STATE_MASK));
                getWindow().setAttributes(attributes);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    private List<DisplayResolveInfo> m17046b(List<DisplayResolveInfo> list) {
        if (list == null || list.size() <= 0) {
            return list;
        }
        Iterator<DisplayResolveInfo> it = list.iterator();
        while (it.hasNext()) {
            DisplayResolveInfo next = it.next();
            if (m17043a(next.f15734a.activityInfo.packageName, next.f15734a.activityInfo.name)) {
                it.remove();
            }
        }
        return list;
    }

    /* renamed from: a */
    private boolean m17043a(String str, String str2) {
        ComponentName[] n = this.f15690a.mo24000n();
        if (n == null) {
            return false;
        }
        for (ComponentName componentName : n) {
            if (componentName.getPackageName().equals(str) && componentName.getClassName().equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
