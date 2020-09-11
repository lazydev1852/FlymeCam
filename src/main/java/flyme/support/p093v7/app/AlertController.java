package flyme.support.p093v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import flyme.support.p093v7.app.FlymeAlertController;
import flyme.support.p093v7.appcompat.R;
import java.lang.ref.WeakReference;

/* renamed from: flyme.support.v7.app.AlertController */
public class AlertController {

    /* renamed from: A */
    private int f16597A;

    /* renamed from: B */
    private boolean f16598B = false;

    /* renamed from: C */
    private CharSequence f16599C;

    /* renamed from: D */
    private Drawable f16600D;

    /* renamed from: E */
    private CharSequence f16601E;

    /* renamed from: F */
    private Drawable f16602F;

    /* renamed from: G */
    private CharSequence f16603G;

    /* renamed from: H */
    private Drawable f16604H;

    /* renamed from: I */
    private int f16605I = 0;

    /* renamed from: J */
    private Drawable f16606J;

    /* renamed from: K */
    private ImageView f16607K;

    /* renamed from: L */
    private TextView f16608L;

    /* renamed from: M */
    private TextView f16609M;

    /* renamed from: N */
    private View f16610N;

    /* renamed from: O */
    private int f16611O;

    /* renamed from: P */
    private int f16612P;

    /* renamed from: Q */
    private boolean f16613Q;

    /* renamed from: R */
    private int f16614R = 0;

    /* renamed from: S */
    private final View.OnClickListener f16615S = new View.OnClickListener() {
        public void onClick(View view) {
            Message message;
            if (view == AlertController.this.f16618c && AlertController.this.f16619d != null) {
                message = Message.obtain(AlertController.this.f16619d);
            } else if (view != AlertController.this.f16620e || AlertController.this.f16621f == null) {
                message = (view != AlertController.this.f16622g || AlertController.this.f16623h == null) ? null : Message.obtain(AlertController.this.f16623h);
            } else {
                message = Message.obtain(AlertController.this.f16621f);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController.this.f16631p.obtainMessage(1, AlertController.this.f16616a).sendToTarget();
        }
    };

    /* renamed from: a */
    final AppCompatDialog f16616a;

    /* renamed from: b */
    ListView f16617b;

    /* renamed from: c */
    Button f16618c;

    /* renamed from: d */
    Message f16619d;

    /* renamed from: e */
    Button f16620e;

    /* renamed from: f */
    Message f16621f;

    /* renamed from: g */
    Button f16622g;

    /* renamed from: h */
    Message f16623h;

    /* renamed from: i */
    NestedScrollView f16624i;

    /* renamed from: j */
    ListAdapter f16625j;

    /* renamed from: k */
    int f16626k = -1;

    /* renamed from: l */
    int f16627l;

    /* renamed from: m */
    int f16628m;

    /* renamed from: n */
    int f16629n;

    /* renamed from: o */
    int f16630o;

    /* renamed from: p */
    Handler f16631p;

    /* renamed from: q */
    private final Context f16632q;

    /* renamed from: r */
    private final Window f16633r;

    /* renamed from: s */
    private final int f16634s;

    /* renamed from: t */
    private CharSequence f16635t;

    /* renamed from: u */
    private CharSequence f16636u;

    /* renamed from: v */
    private View f16637v;

    /* renamed from: w */
    private int f16638w;

    /* renamed from: x */
    private int f16639x;

    /* renamed from: y */
    private int f16640y;

    /* renamed from: z */
    private int f16641z;

    /* renamed from: a */
    public void mo25086a(int i, int i2, int i3, int i4) {
    }

    /* renamed from: e */
    public void mo25099e(int i) {
    }

    /* renamed from: f */
    public void mo25100f(int i) {
    }

    /* renamed from: flyme.support.v7.app.AlertController$b */
    private static final class C3089b extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f16716a;

        public C3089b(DialogInterface dialogInterface) {
            this.f16716a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                switch (i) {
                    case -3:
                    case -2:
                    case -1:
                        ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f16716a.get(), message.what);
                        return;
                    default:
                        return;
                }
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* renamed from: a */
    private static boolean m18211a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f16632q = context;
        this.f16616a = appCompatDialog;
        this.f16633r = window;
        this.f16631p = new C3089b(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.f16611O = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.f16612P = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f16627l = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.f16628m = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f16629n = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f16630o = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.f16613Q = true;
        this.f16634s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzButtonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.mo25250b(1);
    }

    /* renamed from: a */
    static boolean m18212a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m18212a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo25084a() {
        this.f16616a.setContentView(mo25281b());
        m18215c();
    }

    /* renamed from: b */
    private int mo25281b() {
        if (this.f16612P == 0) {
            return this.f16611O;
        }
        if (this.f16614R == 1) {
            return this.f16612P;
        }
        return this.f16611O;
    }

    /* renamed from: a */
    public void mo25090a(CharSequence charSequence) {
        this.f16635t = charSequence;
        if (this.f16608L != null) {
            this.f16608L.setText(charSequence);
        }
    }

    /* renamed from: b */
    public void mo25093b(View view) {
        this.f16610N = view;
    }

    /* renamed from: b */
    public void mo25094b(CharSequence charSequence) {
        this.f16636u = charSequence;
        if (this.f16609M != null) {
            this.f16609M.setText(charSequence);
        }
    }

    /* renamed from: a */
    public void mo25085a(int i) {
        this.f16637v = null;
        this.f16638w = i;
        this.f16598B = false;
    }

    /* renamed from: c */
    public void mo25097c(View view) {
        this.f16637v = view;
        this.f16638w = 0;
        this.f16598B = false;
    }

    /* renamed from: a */
    public void mo25089a(View view, int i, int i2, int i3, int i4) {
        this.f16637v = view;
        this.f16638w = 0;
        this.f16598B = true;
        this.f16639x = i;
        this.f16640y = i2;
        this.f16641z = i3;
        this.f16597A = i4;
    }

    /* renamed from: a */
    public void mo25087a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f16631p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f16603G = charSequence;
                this.f16623h = message;
                this.f16604H = drawable;
                return;
            case -2:
                this.f16601E = charSequence;
                this.f16621f = message;
                this.f16602F = drawable;
                return;
            case -1:
                this.f16599C = charSequence;
                this.f16619d = message;
                this.f16600D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: b */
    public void mo25092b(int i) {
        this.f16606J = null;
        this.f16605I = i;
        if (this.f16607K == null) {
            return;
        }
        if (i != 0) {
            this.f16607K.setVisibility(0);
            this.f16607K.setImageResource(this.f16605I);
            return;
        }
        this.f16607K.setVisibility(8);
    }

    /* renamed from: a */
    public void mo25088a(Drawable drawable) {
        this.f16606J = drawable;
        this.f16605I = 0;
        if (this.f16607K == null) {
            return;
        }
        if (drawable != null) {
            this.f16607K.setVisibility(0);
            this.f16607K.setImageDrawable(drawable);
            return;
        }
        this.f16607K.setVisibility(8);
    }

    /* renamed from: c */
    public int mo25096c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f16632q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: d */
    public Button mo25098d(int i) {
        switch (i) {
            case -3:
                return this.f16622g;
            case -2:
                return this.f16620e;
            case -1:
                return this.f16618c;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public boolean mo25091a(int i, KeyEvent keyEvent) {
        return this.f16624i != null && this.f16624i.executeKeyEvent(keyEvent);
    }

    /* renamed from: b */
    public boolean mo25095b(int i, KeyEvent keyEvent) {
        return this.f16624i != null && this.f16624i.executeKeyEvent(keyEvent);
    }

    @Nullable
    /* renamed from: a */
    private ViewGroup m18206a(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* renamed from: c */
    private void m18215c() {
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f16633r.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        m18208a(viewGroup);
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup a = m18206a(findViewById7, findViewById4);
        ViewGroup a2 = m18206a(findViewById8, findViewById5);
        ViewGroup a3 = m18206a(findViewById9, findViewById6);
        m18216c(a2);
        m18217d(a3);
        m18214b(a);
        char c = 0;
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null || (findViewById2 = a2.findViewById(R.id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            if (this.f16624i != null) {
                this.f16624i.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f16636u == null && this.f16617b == null)) {
                view = a.findViewById(R.id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(a2 == null || (findViewById = a2.findViewById(R.id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        if (this.f16617b instanceof RecycleListView) {
            ((RecycleListView) this.f16617b).setHasDecor(z2, z3);
        }
        if (!z) {
            View view2 = this.f16617b != null ? this.f16617b : this.f16624i;
            if (view2 != null) {
                if (z3) {
                    c = 2;
                }
                m18209a(a2, view2, z2 | c ? 1 : 0, 3);
            }
        }
        ListView listView = this.f16617b;
        if (listView != null && this.f16625j != null) {
            listView.setAdapter(this.f16625j);
            int i = this.f16626k;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    /* renamed from: a */
    private void m18209a(ViewGroup viewGroup, View view, int i, int i2) {
        final View findViewById = this.f16633r.findViewById(R.id.scrollIndicatorUp);
        View findViewById2 = this.f16633r.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        final View view2 = null;
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f16636u != null) {
                this.f16624i.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.m18207a(nestedScrollView, findViewById, view2);
                    }
                });
                this.f16624i.post(new Runnable() {
                    public void run() {
                        AlertController.m18207a(AlertController.this.f16624i, findViewById, view2);
                    }
                });
            } else if (this.f16617b != null) {
                this.f16617b.setOnScrollListener(new AbsListView.OnScrollListener() {
                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.m18207a(absListView, findViewById, view2);
                    }
                });
                this.f16617b.post(new Runnable() {
                    public void run() {
                        AlertController.m18207a(AlertController.this.f16617b, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m18208a(ViewGroup viewGroup) {
        View view;
        boolean z = false;
        if (this.f16637v != null) {
            view = this.f16637v;
        } else {
            view = this.f16638w != 0 ? LayoutInflater.from(this.f16632q).inflate(this.f16638w, viewGroup, false) : null;
        }
        if (view != null) {
            z = true;
        }
        if (!z || !m18212a(view)) {
            this.f16633r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f16633r.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f16598B) {
                frameLayout.setPadding(this.f16639x, this.f16640y, this.f16641z, this.f16597A);
            }
            if (this.f16617b != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: b */
    private void m18214b(ViewGroup viewGroup) {
        if (this.f16610N != null) {
            viewGroup.addView(this.f16610N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f16633r.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.f16607K = (ImageView) this.f16633r.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f16635t)) || !this.f16613Q) {
            this.f16633r.findViewById(R.id.title_template).setVisibility(8);
            this.f16607K.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.f16608L = (TextView) this.f16633r.findViewById(R.id.alertTitle);
        this.f16608L.setText(this.f16635t);
        if (this.f16605I != 0) {
            this.f16607K.setImageResource(this.f16605I);
        } else if (this.f16606J != null) {
            this.f16607K.setImageDrawable(this.f16606J);
        } else {
            this.f16608L.setPadding(this.f16607K.getPaddingLeft(), this.f16607K.getPaddingTop(), this.f16607K.getPaddingRight(), this.f16607K.getPaddingBottom());
            this.f16607K.setVisibility(8);
        }
    }

    /* renamed from: c */
    private void m18216c(ViewGroup viewGroup) {
        this.f16624i = (NestedScrollView) this.f16633r.findViewById(R.id.scrollView);
        this.f16624i.setFocusable(false);
        this.f16624i.setNestedScrollingEnabled(false);
        this.f16609M = (TextView) viewGroup.findViewById(16908299);
        if (this.f16609M != null) {
            if (this.f16636u != null) {
                this.f16609M.setText(this.f16636u);
                return;
            }
            this.f16609M.setVisibility(8);
            this.f16624i.removeView(this.f16609M);
            if (this.f16617b != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f16624i.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f16624i);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f16617b, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    static void m18207a(View view, View view2, View view3) {
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

    /* renamed from: d */
    private void m18217d(ViewGroup viewGroup) {
        boolean z;
        this.f16618c = (Button) viewGroup.findViewById(16908313);
        this.f16618c.setOnClickListener(this.f16615S);
        boolean z2 = true;
        if (!TextUtils.isEmpty(this.f16599C) || this.f16600D != null) {
            this.f16618c.setText(this.f16599C);
            if (this.f16600D != null) {
                this.f16600D.setBounds(0, 0, this.f16634s, this.f16634s);
                this.f16618c.setCompoundDrawables(this.f16600D, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f16618c.setVisibility(0);
            z = true;
        } else {
            this.f16618c.setVisibility(8);
            z = false;
        }
        this.f16620e = (Button) viewGroup.findViewById(16908314);
        this.f16620e.setOnClickListener(this.f16615S);
        if (!TextUtils.isEmpty(this.f16601E) || this.f16602F != null) {
            this.f16620e.setText(this.f16601E);
            if (this.f16602F != null) {
                this.f16602F.setBounds(0, 0, this.f16634s, this.f16634s);
                this.f16620e.setCompoundDrawables(this.f16602F, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f16620e.setVisibility(0);
            z |= true;
        } else {
            this.f16620e.setVisibility(8);
        }
        this.f16622g = (Button) viewGroup.findViewById(16908315);
        this.f16622g.setOnClickListener(this.f16615S);
        if (!TextUtils.isEmpty(this.f16603G) || this.f16604H != null) {
            this.f16622g.setText(this.f16603G);
            if (this.f16600D != null) {
                this.f16600D.setBounds(0, 0, this.f16634s, this.f16634s);
                this.f16618c.setCompoundDrawables(this.f16600D, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f16622g.setVisibility(0);
            z |= true;
        } else {
            this.f16622g.setVisibility(8);
        }
        if (m18211a(this.f16632q)) {
            if (z) {
                m18210a(this.f16618c);
            } else if (z) {
                m18210a(this.f16620e);
            } else if (z) {
                m18210a(this.f16622g);
            }
        }
        if (!z) {
            z2 = false;
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m18210a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* renamed from: flyme.support.v7.app.AlertController$RecycleListView */
    public static class RecycleListView extends ListView {

        /* renamed from: a */
        private final int f16655a;

        /* renamed from: b */
        private final int f16656b;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f16655a = 0;
            this.f16656b = 0;
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f16655a, getPaddingRight(), z2 ? getPaddingBottom() : this.f16656b);
            }
        }
    }

    /* renamed from: flyme.support.v7.app.AlertController$a */
    public static class C3083a {

        /* renamed from: A */
        public int f16657A;

        /* renamed from: B */
        public int f16658B;

        /* renamed from: C */
        public int f16659C;

        /* renamed from: D */
        public int f16660D;

        /* renamed from: E */
        public boolean f16661E = false;

        /* renamed from: F */
        public boolean[] f16662F;

        /* renamed from: G */
        public boolean f16663G;

        /* renamed from: H */
        public boolean f16664H;

        /* renamed from: I */
        public int f16665I = -1;

        /* renamed from: J */
        public DialogInterface.OnMultiChoiceClickListener f16666J;

        /* renamed from: K */
        public Cursor f16667K;

        /* renamed from: L */
        public String f16668L;

        /* renamed from: M */
        public String f16669M;

        /* renamed from: N */
        public AdapterView.OnItemSelectedListener f16670N;

        /* renamed from: O */
        public C3088a f16671O;

        /* renamed from: P */
        public boolean f16672P = true;

        /* renamed from: Q */
        public boolean f16673Q;

        /* renamed from: R */
        public ColorStateList[] f16674R;

        /* renamed from: S */
        public ColorStateList f16675S;

        /* renamed from: T */
        public int f16676T;

        /* renamed from: U */
        public int f16677U;

        /* renamed from: a */
        public final Context f16678a;

        /* renamed from: b */
        public final LayoutInflater f16679b;

        /* renamed from: c */
        public int f16680c = 0;

        /* renamed from: d */
        public Drawable f16681d;

        /* renamed from: e */
        public int f16682e = 0;

        /* renamed from: f */
        public CharSequence f16683f;

        /* renamed from: g */
        public View f16684g;

        /* renamed from: h */
        public CharSequence f16685h;

        /* renamed from: i */
        public CharSequence f16686i;

        /* renamed from: j */
        public Drawable f16687j;

        /* renamed from: k */
        public DialogInterface.OnClickListener f16688k;

        /* renamed from: l */
        public CharSequence f16689l;

        /* renamed from: m */
        public Drawable f16690m;

        /* renamed from: n */
        public DialogInterface.OnClickListener f16691n;

        /* renamed from: o */
        public CharSequence f16692o;

        /* renamed from: p */
        public Drawable f16693p;

        /* renamed from: q */
        public DialogInterface.OnClickListener f16694q;

        /* renamed from: r */
        public boolean f16695r;

        /* renamed from: s */
        public DialogInterface.OnCancelListener f16696s;

        /* renamed from: t */
        public DialogInterface.OnDismissListener f16697t;

        /* renamed from: u */
        public DialogInterface.OnKeyListener f16698u;

        /* renamed from: v */
        public CharSequence[] f16699v;

        /* renamed from: w */
        public ListAdapter f16700w;

        /* renamed from: x */
        public DialogInterface.OnClickListener f16701x;

        /* renamed from: y */
        public int f16702y;

        /* renamed from: z */
        public View f16703z;

        /* renamed from: flyme.support.v7.app.AlertController$a$a */
        public interface C3088a {
            /* renamed from: a */
            void mo25113a(ListView listView);
        }

        public C3083a(Context context) {
            this.f16678a = context;
            this.f16695r = true;
            this.f16679b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* renamed from: a */
        public void mo25107a(AlertController alertController) {
            if (alertController instanceof FlymeAlertController) {
                new FlymeAlertController.C3113a(this).mo25288a((FlymeAlertController) alertController);
                return;
            }
            if (this.f16684g != null) {
                alertController.mo25093b(this.f16684g);
            } else {
                if (this.f16683f != null) {
                    alertController.mo25090a(this.f16683f);
                }
                if (this.f16681d != null) {
                    alertController.mo25088a(this.f16681d);
                }
                if (this.f16680c != 0) {
                    alertController.mo25092b(this.f16680c);
                }
                if (this.f16682e != 0) {
                    alertController.mo25092b(alertController.mo25096c(this.f16682e));
                }
            }
            if (this.f16685h != null) {
                alertController.mo25094b(this.f16685h);
            }
            if (!(this.f16686i == null && this.f16687j == null)) {
                alertController.mo25087a(-1, this.f16686i, this.f16688k, (Message) null, this.f16687j);
            }
            if (!(this.f16689l == null && this.f16690m == null)) {
                alertController.mo25087a(-2, this.f16689l, this.f16691n, (Message) null, this.f16690m);
            }
            if (!(this.f16692o == null && this.f16693p == null)) {
                alertController.mo25087a(-3, this.f16692o, this.f16694q, (Message) null, this.f16693p);
            }
            if (!(this.f16699v == null && this.f16667K == null && this.f16700w == null)) {
                m18235b(alertController);
            }
            if (this.f16703z != null) {
                if (this.f16661E) {
                    alertController.mo25089a(this.f16703z, this.f16657A, this.f16658B, this.f16659C, this.f16660D);
                    return;
                }
                alertController.mo25097c(this.f16703z);
            } else if (this.f16702y != 0) {
                alertController.mo25085a(this.f16702y);
            }
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r9v5 */
        /* JADX WARNING: type inference failed for: r9v6 */
        /* JADX WARNING: type inference failed for: r1v25, types: [flyme.support.v7.app.AlertController$a$2] */
        /* JADX WARNING: type inference failed for: r1v26, types: [flyme.support.v7.app.AlertController$a$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m18235b(final flyme.support.p093v7.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f16679b
                int r1 = r11.f16627l
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                flyme.support.v7.app.AlertController$RecycleListView r0 = (flyme.support.p093v7.app.AlertController.RecycleListView) r0
                boolean r1 = r10.f16663G
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.f16667K
                if (r1 != 0) goto L_0x0026
                flyme.support.v7.app.AlertController$a$1 r9 = new flyme.support.v7.app.AlertController$a$1
                android.content.Context r3 = r10.f16678a
                int r4 = r11.f16628m
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f16699v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006e
            L_0x0026:
                flyme.support.v7.app.AlertController$a$2 r9 = new flyme.support.v7.app.AlertController$a$2
                android.content.Context r3 = r10.f16678a
                android.database.Cursor r4 = r10.f16667K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006e
            L_0x0035:
                boolean r1 = r10.f16664H
                if (r1 == 0) goto L_0x003d
                int r1 = r11.f16629n
            L_0x003b:
                r4 = r1
                goto L_0x0040
            L_0x003d:
                int r1 = r11.f16630o
                goto L_0x003b
            L_0x0040:
                android.database.Cursor r1 = r10.f16667K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005e
                android.widget.SimpleCursorAdapter r1 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f16678a
                android.database.Cursor r5 = r10.f16667K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r7 = r10.f16668L
                r9 = 0
                r6[r9] = r7
                int[] r7 = new int[r8]
                r7[r9] = r2
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                r9 = r1
                goto L_0x006e
            L_0x005e:
                android.widget.ListAdapter r1 = r10.f16700w
                if (r1 == 0) goto L_0x0065
                android.widget.ListAdapter r9 = r10.f16700w
                goto L_0x006e
            L_0x0065:
                flyme.support.v7.app.AlertController$c r9 = new flyme.support.v7.app.AlertController$c
                android.content.Context r1 = r10.f16678a
                java.lang.CharSequence[] r3 = r10.f16699v
                r9.<init>(r1, r4, r2, r3)
            L_0x006e:
                flyme.support.v7.app.AlertController$a$a r1 = r10.f16671O
                if (r1 == 0) goto L_0x0077
                flyme.support.v7.app.AlertController$a$a r1 = r10.f16671O
                r1.mo25113a(r0)
            L_0x0077:
                r11.f16625j = r9
                int r1 = r10.f16665I
                r11.f16626k = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f16701x
                if (r1 == 0) goto L_0x008a
                flyme.support.v7.app.AlertController$a$3 r1 = new flyme.support.v7.app.AlertController$a$3
                r1.<init>(r11)
                r0.setOnItemClickListener(r1)
                goto L_0x0096
            L_0x008a:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.f16666J
                if (r1 == 0) goto L_0x0096
                flyme.support.v7.app.AlertController$a$4 r1 = new flyme.support.v7.app.AlertController$a$4
                r1.<init>(r0, r11)
                r0.setOnItemClickListener(r1)
            L_0x0096:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.f16670N
                if (r1 == 0) goto L_0x009f
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.f16670N
                r0.setOnItemSelectedListener(r1)
            L_0x009f:
                boolean r1 = r10.f16664H
                if (r1 == 0) goto L_0x00a7
                r0.setChoiceMode(r8)
                goto L_0x00af
            L_0x00a7:
                boolean r1 = r10.f16663G
                if (r1 == 0) goto L_0x00af
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00af:
                r11.f16617b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.app.AlertController.C3083a.m18235b(flyme.support.v7.app.AlertController):void");
        }
    }

    /* renamed from: flyme.support.v7.app.AlertController$c */
    private static class C3090c extends ArrayAdapter<CharSequence> {
        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public C3090c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }
}
