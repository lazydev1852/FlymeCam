package flyme.support.p093v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import com.meizu.common.util.CommonUtils;
import com.meizu.common.util.InternalResUtils;
import com.meizu.common.util.ReflectUtils;
import com.meizu.common.util.ScreenUtil;
import flyme.support.p093v7.app.AlertController;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.widget.FlymeAlertDialogLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: flyme.support.v7.app.FlymeAlertController */
public class FlymeAlertController extends AlertController {

    /* renamed from: av */
    private static List<C3121e> f16821av = new ArrayList();

    /* renamed from: aw */
    private static List<C3121e> f16822aw = new ArrayList();

    /* renamed from: ax */
    private static List<C3121e> f16823ax = new ArrayList();

    /* renamed from: ay */
    private static List<C3121e> f16824ay = new ArrayList();

    /* renamed from: az */
    private static List<C3121e> f16825az = new ArrayList();

    /* renamed from: A */
    int f16826A = -1;

    /* renamed from: B */
    int f16827B;

    /* renamed from: C */
    int f16828C;

    /* renamed from: D */
    int f16829D;

    /* renamed from: E */
    int f16830E;

    /* renamed from: F */
    Handler f16831F;

    /* renamed from: G */
    private final Context f16832G;

    /* renamed from: H */
    private final Window f16833H;

    /* renamed from: I */
    private final int f16834I;

    /* renamed from: J */
    private CharSequence f16835J;

    /* renamed from: K */
    private CharSequence f16836K;

    /* renamed from: L */
    private View f16837L;

    /* renamed from: M */
    private int f16838M;

    /* renamed from: N */
    private int f16839N;

    /* renamed from: O */
    private int f16840O;

    /* renamed from: P */
    private int f16841P;

    /* renamed from: Q */
    private int f16842Q;

    /* renamed from: R */
    private boolean f16843R = false;

    /* renamed from: S */
    private CharSequence f16844S;

    /* renamed from: T */
    private Drawable f16845T;

    /* renamed from: U */
    private CharSequence f16846U;

    /* renamed from: V */
    private Drawable f16847V;

    /* renamed from: W */
    private CharSequence f16848W;

    /* renamed from: X */
    private Drawable f16849X;

    /* renamed from: Y */
    private int f16850Y = 0;

    /* renamed from: Z */
    private Drawable f16851Z;

    /* renamed from: aa */
    private ImageView f16852aa;

    /* renamed from: ab */
    private TextView f16853ab;

    /* renamed from: ac */
    private TextView f16854ac;

    /* renamed from: ad */
    private View f16855ad;

    /* renamed from: ae */
    private int f16856ae;

    /* renamed from: af */
    private int f16857af;

    /* renamed from: ag */
    private boolean f16858ag;

    /* renamed from: ah */
    private int f16859ah = 0;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public int f16860ai;

    /* renamed from: aj */
    private boolean f16861aj;

    /* renamed from: ak */
    private int f16862ak;

    /* renamed from: al */
    private boolean f16863al;

    /* renamed from: am */
    private int f16864am;

    /* renamed from: an */
    private int f16865an;

    /* renamed from: ao */
    private int f16866ao;

    /* renamed from: ap */
    private int f16867ap;

    /* renamed from: aq */
    private int f16868aq;

    /* renamed from: ar */
    private int f16869ar;

    /* renamed from: as */
    private boolean f16870as = true;

    /* renamed from: at */
    private float f16871at;

    /* renamed from: au */
    private final View.OnClickListener f16872au = new View.OnClickListener() {
        public void onClick(View view) {
            Message message;
            if (view == FlymeAlertController.this.f16875s && FlymeAlertController.this.f16876t != null) {
                message = Message.obtain(FlymeAlertController.this.f16876t);
            } else if (view != FlymeAlertController.this.f16877u || FlymeAlertController.this.f16878v == null) {
                message = (view != FlymeAlertController.this.f16879w || FlymeAlertController.this.f16880x == null) ? null : Message.obtain(FlymeAlertController.this.f16880x);
            } else {
                message = Message.obtain(FlymeAlertController.this.f16878v);
            }
            if (message != null) {
                message.sendToTarget();
            }
            FlymeAlertController.this.f16831F.obtainMessage(1, FlymeAlertController.this.f16873q).sendToTarget();
        }
    };

    /* renamed from: q */
    final AppCompatDialog f16873q;

    /* renamed from: r */
    ListView f16874r;

    /* renamed from: s */
    Button f16875s;

    /* renamed from: t */
    Message f16876t;

    /* renamed from: u */
    Button f16877u;

    /* renamed from: v */
    Message f16878v;

    /* renamed from: w */
    Button f16879w;

    /* renamed from: x */
    Message f16880x;

    /* renamed from: y */
    NestedScrollView f16881y;

    /* renamed from: z */
    ListAdapter f16882z;

    /* renamed from: flyme.support.v7.app.FlymeAlertController$b */
    private static final class C3118b extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f16909a;

        public C3118b(DialogInterface dialogInterface) {
            this.f16909a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                switch (i) {
                    case -3:
                    case -2:
                    case -1:
                        ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f16909a.get(), message.what);
                        return;
                    default:
                        return;
                }
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public FlymeAlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        super(context, appCompatDialog, window);
        this.f16832G = context;
        this.f16873q = appCompatDialog;
        this.f16833H = window;
        this.f16831F = new C3118b(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.f16856ae = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.f16857af = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f16827B = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.f16828C = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f16829D = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f16830E = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.f16858ag = true;
        this.f16834I = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzButtonIconDimen, m18483b(this.f16832G, 48.0f));
        this.f16860ai = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_centerListItemLayout, 0);
        this.f16861aj = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_mzActionDialog, false);
        this.f16863al = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_mzDialogCustomPadding, false);
        this.f16864am = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzDialogSpace1, 0);
        this.f16865an = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzDialogSpace2, 0);
        this.f16866ao = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzDialogSpace3, 0);
        this.f16867ap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_mzDialogSpace4, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.mo25250b(1);
        int dimensionPixelOffset = this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_width);
        this.f16862ak = Math.min(dimensionPixelOffset, m18497h());
        this.f16871at = ((float) this.f16862ak) / ((float) dimensionPixelOffset);
    }

    /* renamed from: d */
    static boolean m18491d(View view) {
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
            if (m18491d(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo25084a() {
        this.f16873q.setContentView(m18487c());
        m18489d();
        mo25281b();
    }

    /* renamed from: c */
    private int m18487c() {
        if (this.f16857af == 0) {
            return this.f16856ae;
        }
        if (this.f16859ah == 1) {
            return this.f16857af;
        }
        return this.f16856ae;
    }

    /* renamed from: a */
    public void mo25090a(CharSequence charSequence) {
        this.f16835J = charSequence;
        if (this.f16853ab != null) {
            this.f16853ab.setText(charSequence);
        }
    }

    /* renamed from: b */
    public void mo25093b(View view) {
        this.f16855ad = view;
    }

    /* renamed from: b */
    public void mo25094b(CharSequence charSequence) {
        this.f16836K = charSequence;
        if (this.f16854ac != null) {
            this.f16854ac.setText(charSequence);
        }
    }

    /* renamed from: a */
    public void mo25085a(int i) {
        this.f16837L = null;
        this.f16838M = i;
        this.f16843R = false;
    }

    /* renamed from: c */
    public void mo25097c(View view) {
        this.f16837L = view;
        this.f16838M = 0;
        this.f16843R = false;
    }

    /* renamed from: a */
    public void mo25089a(View view, int i, int i2, int i3, int i4) {
        this.f16837L = view;
        this.f16838M = 0;
        this.f16843R = true;
        this.f16839N = i;
        this.f16840O = i2;
        this.f16841P = i3;
        this.f16842Q = i4;
    }

    /* renamed from: a */
    public void mo25087a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f16831F.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f16848W = charSequence;
                this.f16880x = message;
                this.f16849X = drawable;
                return;
            case -2:
                this.f16846U = charSequence;
                this.f16878v = message;
                this.f16847V = drawable;
                return;
            case -1:
                this.f16844S = charSequence;
                this.f16876t = message;
                this.f16845T = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: b */
    public void mo25092b(int i) {
        this.f16851Z = null;
        this.f16850Y = i;
        if (this.f16852aa == null) {
            return;
        }
        if (i != 0) {
            this.f16852aa.setVisibility(0);
            this.f16852aa.setImageResource(this.f16850Y);
            return;
        }
        this.f16852aa.setVisibility(8);
    }

    /* renamed from: a */
    public void mo25088a(Drawable drawable) {
        this.f16851Z = drawable;
        this.f16850Y = 0;
        if (this.f16852aa == null) {
            return;
        }
        if (drawable != null) {
            this.f16852aa.setVisibility(0);
            this.f16852aa.setImageDrawable(drawable);
            return;
        }
        this.f16852aa.setVisibility(8);
    }

    /* renamed from: c */
    public int mo25096c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f16832G.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: d */
    public Button mo25098d(int i) {
        switch (i) {
            case -3:
                return this.f16879w;
            case -2:
                return this.f16877u;
            case -1:
                return this.f16875s;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public boolean mo25091a(int i, KeyEvent keyEvent) {
        return this.f16881y != null && this.f16881y.executeKeyEvent(keyEvent);
    }

    /* renamed from: b */
    public boolean mo25095b(int i, KeyEvent keyEvent) {
        return this.f16881y != null && this.f16881y.executeKeyEvent(keyEvent);
    }

    @Nullable
    /* renamed from: a */
    private ViewGroup m18476a(@Nullable View view, @Nullable View view2) {
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

    /* renamed from: d */
    private void m18489d() {
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f16833H.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        m18478a(viewGroup);
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup a = m18476a(findViewById7, findViewById4);
        ViewGroup a2 = m18476a(findViewById8, findViewById5);
        ViewGroup a3 = m18476a(findViewById9, findViewById6);
        m18488c(a2);
        m18490d(a3);
        m18485b(a);
        char c = 0;
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null || (findViewById2 = a2.findViewById(R.id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            if (this.f16881y != null) {
                this.f16881y.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f16836K == null && this.f16874r == null)) {
                view = a.findViewById(R.id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(a2 == null || (findViewById = a2.findViewById(R.id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        if (this.f16874r instanceof RecycleListView) {
            ((RecycleListView) this.f16874r).setHasDecor(z2, z3);
        }
        if (!z && !this.f16861aj) {
            View view2 = this.f16874r != null ? this.f16874r : this.f16881y;
            if (view2 != null) {
                if (z3) {
                    c = 2;
                }
                m18479a(a2, view2, z2 | c ? 1 : 0, 3);
            }
        }
        ListView listView = this.f16874r;
        if (!(listView == null || this.f16882z == null)) {
            listView.setAdapter(this.f16882z);
            int i = this.f16826A;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
        m18477a((View) a, (View) a2, (View) viewGroup, (View) a3);
    }

    /* renamed from: a */
    private void m18479a(ViewGroup viewGroup, View view, int i, int i2) {
        final View findViewById = this.f16833H.findViewById(R.id.scrollIndicatorUp);
        final View findViewById2 = this.f16833H.findViewById(R.id.scrollIndicatorDown);
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f16836K != null) {
                this.f16881y.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        FlymeAlertController.m18484b(nestedScrollView, findViewById, findViewById2);
                    }
                });
                this.f16881y.postDelayed(new Runnable() {
                    public void run() {
                        FlymeAlertController.m18484b(FlymeAlertController.this.f16881y, findViewById, findViewById2);
                    }
                }, 100);
            } else if (this.f16874r != null) {
                this.f16874r.setOnScrollListener(new AbsListView.OnScrollListener() {
                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        FlymeAlertController.m18484b(absListView, findViewById, findViewById2);
                    }
                });
                this.f16874r.postDelayed(new Runnable() {
                    public void run() {
                        FlymeAlertController.m18484b(FlymeAlertController.this.f16874r, findViewById, findViewById2);
                    }
                }, 100);
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (findViewById2 != null) {
                    viewGroup.removeView(findViewById2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m18478a(ViewGroup viewGroup) {
        View view;
        boolean z = false;
        if (this.f16837L != null) {
            view = this.f16837L;
        } else {
            view = this.f16838M != 0 ? LayoutInflater.from(this.f16832G).inflate(this.f16838M, viewGroup, false) : null;
        }
        if (view != null) {
            z = true;
        }
        if (!z || !m18491d(view)) {
            this.f16833H.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f16833H.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f16843R) {
                frameLayout.setPadding(this.f16839N, this.f16840O, this.f16841P, this.f16842Q);
            }
            if (this.f16874r != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: b */
    private void m18485b(ViewGroup viewGroup) {
        if (this.f16855ad != null) {
            viewGroup.addView(this.f16855ad, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f16833H.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.f16852aa = (ImageView) this.f16833H.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f16835J)) || !this.f16858ag) {
            this.f16833H.findViewById(R.id.title_template).setVisibility(8);
            this.f16852aa.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.f16853ab = (TextView) this.f16833H.findViewById(R.id.alertTitle);
        this.f16853ab.setText(this.f16835J);
        if (this.f16850Y != 0) {
            this.f16852aa.setImageResource(this.f16850Y);
        } else if (this.f16851Z != null) {
            this.f16852aa.setImageDrawable(this.f16851Z);
        } else {
            this.f16853ab.setPadding(this.f16852aa.getPaddingLeft(), this.f16852aa.getPaddingTop(), this.f16852aa.getPaddingRight(), this.f16852aa.getPaddingBottom());
            this.f16852aa.setVisibility(8);
        }
    }

    /* renamed from: c */
    private void m18488c(ViewGroup viewGroup) {
        this.f16881y = (NestedScrollView) this.f16833H.findViewById(R.id.scrollView);
        this.f16881y.setFocusable(false);
        this.f16881y.setNestedScrollingEnabled(false);
        this.f16854ac = (TextView) viewGroup.findViewById(16908299);
        if (this.f16854ac != null) {
            if (this.f16836K != null) {
                this.f16854ac.setText(this.f16836K);
                return;
            }
            this.f16854ac.setVisibility(8);
            this.f16881y.removeView(this.f16854ac);
            if (this.f16874r != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f16881y.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f16881y);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f16874r, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: b */
    static void m18484b(View view, View view2, View view3) {
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
    private void m18490d(ViewGroup viewGroup) {
        boolean z;
        this.f16875s = (Button) viewGroup.findViewById(16908313);
        this.f16875s.setOnClickListener(this.f16872au);
        if (!TextUtils.isEmpty(this.f16844S) || this.f16845T != null) {
            this.f16875s.setText(this.f16844S);
            if (this.f16845T != null) {
                this.f16845T.setBounds(0, 0, this.f16834I, this.f16834I);
                this.f16875s.setCompoundDrawables(this.f16845T, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f16875s.setVisibility(0);
            z = true;
        } else {
            this.f16875s.setVisibility(8);
            z = false;
        }
        this.f16877u = (Button) viewGroup.findViewById(16908314);
        this.f16877u.setOnClickListener(this.f16872au);
        if (!TextUtils.isEmpty(this.f16846U) || this.f16847V != null) {
            this.f16877u.setText(this.f16846U);
            if (this.f16847V != null) {
                this.f16847V.setBounds(0, 0, this.f16834I, this.f16834I);
                this.f16877u.setCompoundDrawables(this.f16847V, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f16877u.setVisibility(0);
            z |= true;
        } else {
            this.f16877u.setVisibility(8);
        }
        this.f16879w = (Button) viewGroup.findViewById(16908315);
        this.f16879w.setOnClickListener(this.f16872au);
        if (!TextUtils.isEmpty(this.f16848W) || this.f16849X != null) {
            this.f16879w.setText(this.f16848W);
            if (this.f16845T != null) {
                this.f16845T.setBounds(0, 0, this.f16834I, this.f16834I);
                this.f16875s.setCompoundDrawables(this.f16845T, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f16879w.setVisibility(0);
            z |= true;
        } else {
            this.f16879w.setVisibility(8);
        }
        if (!(z)) {
            viewGroup.setVisibility(8);
        } else if (this.f16879w.getParent() instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) this.f16879w.getParent();
            if (m18493e()) {
                linearLayout.setOrientation(1);
                if (this.f16861aj) {
                    View view = new View(this.f16832G);
                    view.setBackgroundColor(218103808);
                    linearLayout.addView(view, 0, new LinearLayout.LayoutParams(-1, 2));
                }
                m18480a(this.f16875s);
                m18480a(this.f16877u);
                m18480a(this.f16879w);
                return;
            }
            linearLayout.setOrientation(0);
            linearLayout.setGravity(1);
            int f = m18494f();
            m18481a(this.f16875s, f);
            m18481a(this.f16877u, f);
            m18481a(this.f16879w, f);
        }
    }

    @Keep
    /* renamed from: flyme.support.v7.app.FlymeAlertController$RecycleListView */
    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mPaddingTopNoTitle = 0;
            this.mPaddingBottomNoButtons = 0;
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z2 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
            }
        }
    }

    /* renamed from: flyme.support.v7.app.FlymeAlertController$d */
    private static class C3120d extends ArrayAdapter {

        /* renamed from: a */
        Context f16910a;

        /* renamed from: b */
        CharSequence[] f16911b;

        /* renamed from: c */
        ColorStateList[] f16912c;

        /* renamed from: d */
        ColorStateList f16913d;

        /* renamed from: e */
        private int f16914e;

        /* renamed from: f */
        private int f16915f;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public C3120d(Context context, int i, int i2, CharSequence[] charSequenceArr, ColorStateList colorStateList) {
            super(context, i, i2, charSequenceArr);
            this.f16910a = context;
            this.f16914e = i;
            this.f16915f = i2;
            this.f16911b = charSequenceArr;
            this.f16913d = colorStateList;
        }

        public C3120d(Context context, int i, int i2, CharSequence[] charSequenceArr, ColorStateList[] colorStateListArr) {
            super(context, i, i2, charSequenceArr);
            this.f16910a = context;
            this.f16914e = i;
            this.f16915f = i2;
            this.f16911b = charSequenceArr;
            this.f16912c = colorStateListArr;
        }

        public C3120d(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
            this.f16910a = context;
            this.f16914e = i;
            this.f16915f = i2;
            this.f16911b = charSequenceArr;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C3122f fVar;
            if (view == null) {
                view = ((LayoutInflater) this.f16910a.getSystemService("layout_inflater")).inflate(this.f16914e, (ViewGroup) null);
                fVar = new C3122f();
                fVar.f16921a = (TextView) view.findViewById(this.f16915f);
                view.setTag(fVar);
            } else {
                fVar = (C3122f) view.getTag();
            }
            fVar.f16921a.setText(this.f16911b[i]);
            if (this.f16912c != null) {
                fVar.f16921a.setTextColor(this.f16912c[i]);
            } else if (this.f16913d != null) {
                fVar.f16921a.setTextColor(this.f16913d);
            }
            return view;
        }
    }

    /* renamed from: flyme.support.v7.app.FlymeAlertController$f */
    private static class C3122f {

        /* renamed from: a */
        public TextView f16921a;

        private C3122f() {
        }
    }

    /* renamed from: flyme.support.v7.app.FlymeAlertController$a */
    public static class C3113a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public AlertController.C3083a f16896a;

        public C3113a(AlertController.C3083a aVar) {
            this.f16896a = aVar;
        }

        /* renamed from: a */
        public void mo25288a(FlymeAlertController flymeAlertController) {
            if (this.f16896a.f16684g != null) {
                flymeAlertController.mo25093b(this.f16896a.f16684g);
            } else {
                if (this.f16896a.f16683f != null) {
                    flymeAlertController.mo25090a(this.f16896a.f16683f);
                }
                if (this.f16896a.f16681d != null) {
                    flymeAlertController.mo25088a(this.f16896a.f16681d);
                }
                if (this.f16896a.f16680c != 0) {
                    flymeAlertController.mo25092b(this.f16896a.f16680c);
                }
                if (this.f16896a.f16682e != 0) {
                    flymeAlertController.mo25092b(flymeAlertController.mo25096c(this.f16896a.f16682e));
                }
            }
            if (this.f16896a.f16685h != null) {
                flymeAlertController.mo25094b(this.f16896a.f16685h);
            }
            if (!(this.f16896a.f16686i == null && this.f16896a.f16687j == null)) {
                flymeAlertController.mo25087a(-1, this.f16896a.f16686i, this.f16896a.f16688k, (Message) null, this.f16896a.f16687j);
            }
            if (!(this.f16896a.f16689l == null && this.f16896a.f16690m == null)) {
                flymeAlertController.mo25087a(-2, this.f16896a.f16689l, this.f16896a.f16691n, (Message) null, this.f16896a.f16690m);
            }
            if (!(this.f16896a.f16692o == null && this.f16896a.f16693p == null)) {
                flymeAlertController.mo25087a(-3, this.f16896a.f16692o, this.f16896a.f16694q, (Message) null, this.f16896a.f16693p);
            }
            if (!(this.f16896a.f16699v == null && this.f16896a.f16667K == null && this.f16896a.f16700w == null)) {
                m18519b(flymeAlertController);
            }
            if (this.f16896a.f16703z != null) {
                if (this.f16896a.f16661E) {
                    flymeAlertController.mo25089a(this.f16896a.f16703z, this.f16896a.f16657A, this.f16896a.f16658B, this.f16896a.f16659C, this.f16896a.f16660D);
                } else {
                    flymeAlertController.mo25097c(this.f16896a.f16703z);
                }
            } else if (this.f16896a.f16702y != 0) {
                flymeAlertController.mo25085a(this.f16896a.f16702y);
            }
            flymeAlertController.mo25100f(this.f16896a.f16676T);
            flymeAlertController.mo25099e(this.f16896a.f16677U);
        }

        /* JADX WARNING: type inference failed for: r11v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r11v4 */
        /* JADX WARNING: type inference failed for: r11v9 */
        /* JADX WARNING: type inference failed for: r11v10 */
        /* JADX WARNING: type inference failed for: r11v11 */
        /* JADX WARNING: type inference failed for: r11v12 */
        /* JADX WARNING: type inference failed for: r11v13 */
        /* JADX WARNING: type inference failed for: r11v14 */
        /* JADX WARNING: type inference failed for: r11v15 */
        /* JADX WARNING: type inference failed for: r0v63, types: [flyme.support.v7.app.FlymeAlertController$a$2] */
        /* JADX WARNING: type inference failed for: r0v64, types: [flyme.support.v7.app.FlymeAlertController$a$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m18519b(flyme.support.p093v7.app.FlymeAlertController r19) {
            /*
                r18 = this;
                r7 = r18
                r8 = r19
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.view.LayoutInflater r0 = r0.f16679b
                int r1 = r8.f16827B
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                r9 = r0
                flyme.support.v7.app.FlymeAlertController$RecycleListView r9 = (flyme.support.p093v7.app.FlymeAlertController.RecycleListView) r9
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                boolean r0 = r0.f16663G
                r10 = 1
                if (r0 == 0) goto L_0x004d
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.database.Cursor r0 = r0.f16667K
                if (r0 != 0) goto L_0x0037
                flyme.support.v7.app.FlymeAlertController$a$1 r11 = new flyme.support.v7.app.FlymeAlertController$a$1
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.content.Context r2 = r0.f16678a
                int r3 = r8.f16828C
                r4 = 16908308(0x1020014, float:2.3877285E-38)
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                java.lang.CharSequence[] r5 = r0.f16699v
                r0 = r11
                r1 = r18
                r6 = r9
                r0.<init>(r2, r3, r4, r5, r6)
                goto L_0x012e
            L_0x0037:
                flyme.support.v7.app.FlymeAlertController$a$2 r11 = new flyme.support.v7.app.FlymeAlertController$a$2
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.content.Context r2 = r0.f16678a
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.database.Cursor r3 = r0.f16667K
                r4 = 0
                r0 = r11
                r1 = r18
                r5 = r9
                r6 = r19
                r0.<init>(r2, r3, r4, r5, r6)
                goto L_0x012e
            L_0x004d:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                boolean r0 = r0.f16673Q
                r1 = 16908308(0x1020014, float:2.3877285E-38)
                r2 = 0
                if (r0 == 0) goto L_0x00e6
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.database.Cursor r0 = r0.f16667K
                if (r0 != 0) goto L_0x00c2
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.widget.ListAdapter r0 = r0.f16700w
                if (r0 == 0) goto L_0x0069
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.widget.ListAdapter r11 = r0.f16700w
                goto L_0x012e
            L_0x0069:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.content.res.ColorStateList[] r0 = r0.f16674R
                if (r0 == 0) goto L_0x008c
                flyme.support.v7.app.FlymeAlertController$d r0 = new flyme.support.v7.app.FlymeAlertController$d
                flyme.support.v7.app.AlertController$a r1 = r7.f16896a
                android.content.Context r12 = r1.f16678a
                int r13 = r19.f16860ai
                r14 = 16908308(0x1020014, float:2.3877285E-38)
                flyme.support.v7.app.AlertController$a r1 = r7.f16896a
                java.lang.CharSequence[] r15 = r1.f16699v
                flyme.support.v7.app.AlertController$a r1 = r7.f16896a
                android.content.res.ColorStateList[] r1 = r1.f16674R
                r11 = r0
                r16 = r1
                r11.<init>((android.content.Context) r12, (int) r13, (int) r14, (java.lang.CharSequence[]) r15, (android.content.res.ColorStateList[]) r16)
                goto L_0x012e
            L_0x008c:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.content.res.ColorStateList r0 = r0.f16675S
                if (r0 == 0) goto L_0x00af
                flyme.support.v7.app.FlymeAlertController$d r0 = new flyme.support.v7.app.FlymeAlertController$d
                flyme.support.v7.app.AlertController$a r1 = r7.f16896a
                android.content.Context r12 = r1.f16678a
                int r13 = r19.f16860ai
                r14 = 16908308(0x1020014, float:2.3877285E-38)
                flyme.support.v7.app.AlertController$a r1 = r7.f16896a
                java.lang.CharSequence[] r15 = r1.f16699v
                flyme.support.v7.app.AlertController$a r1 = r7.f16896a
                android.content.res.ColorStateList r1 = r1.f16675S
                r11 = r0
                r16 = r1
                r11.<init>((android.content.Context) r12, (int) r13, (int) r14, (java.lang.CharSequence[]) r15, (android.content.res.ColorStateList) r16)
                goto L_0x012e
            L_0x00af:
                flyme.support.v7.app.FlymeAlertController$d r11 = new flyme.support.v7.app.FlymeAlertController$d
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.content.Context r0 = r0.f16678a
                int r2 = r19.f16860ai
                flyme.support.v7.app.AlertController$a r3 = r7.f16896a
                java.lang.CharSequence[] r3 = r3.f16699v
                r11.<init>(r0, r2, r1, r3)
                goto L_0x012e
            L_0x00c2:
                android.widget.SimpleCursorAdapter r0 = new android.widget.SimpleCursorAdapter
                flyme.support.v7.app.AlertController$a r3 = r7.f16896a
                android.content.Context r13 = r3.f16678a
                int r14 = r19.f16860ai
                flyme.support.v7.app.AlertController$a r3 = r7.f16896a
                android.database.Cursor r15 = r3.f16667K
                java.lang.String[] r3 = new java.lang.String[r10]
                flyme.support.v7.app.AlertController$a r4 = r7.f16896a
                java.lang.String r4 = r4.f16668L
                r3[r2] = r4
                int[] r4 = new int[r10]
                r4[r2] = r1
                r12 = r0
                r16 = r3
                r17 = r4
                r12.<init>(r13, r14, r15, r16, r17)
                r11 = r0
                goto L_0x012e
            L_0x00e6:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                boolean r0 = r0.f16664H
                if (r0 == 0) goto L_0x00f0
                int r0 = r8.f16829D
            L_0x00ee:
                r13 = r0
                goto L_0x00f3
            L_0x00f0:
                int r0 = r8.f16830E
                goto L_0x00ee
            L_0x00f3:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.database.Cursor r0 = r0.f16667K
                if (r0 == 0) goto L_0x0116
                android.widget.SimpleCursorAdapter r0 = new android.widget.SimpleCursorAdapter
                flyme.support.v7.app.AlertController$a r3 = r7.f16896a
                android.content.Context r12 = r3.f16678a
                flyme.support.v7.app.AlertController$a r3 = r7.f16896a
                android.database.Cursor r14 = r3.f16667K
                java.lang.String[] r15 = new java.lang.String[r10]
                flyme.support.v7.app.AlertController$a r3 = r7.f16896a
                java.lang.String r3 = r3.f16668L
                r15[r2] = r3
                int[] r3 = new int[r10]
                r3[r2] = r1
                r11 = r0
                r16 = r3
                r11.<init>(r12, r13, r14, r15, r16)
                goto L_0x012e
            L_0x0116:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.widget.ListAdapter r0 = r0.f16700w
                if (r0 == 0) goto L_0x0121
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.widget.ListAdapter r11 = r0.f16700w
                goto L_0x012e
            L_0x0121:
                flyme.support.v7.app.FlymeAlertController$c r11 = new flyme.support.v7.app.FlymeAlertController$c
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.content.Context r0 = r0.f16678a
                flyme.support.v7.app.AlertController$a r2 = r7.f16896a
                java.lang.CharSequence[] r2 = r2.f16699v
                r11.<init>(r0, r13, r1, r2)
            L_0x012e:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                flyme.support.v7.app.AlertController$a$a r0 = r0.f16671O
                if (r0 == 0) goto L_0x013b
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                flyme.support.v7.app.AlertController$a$a r0 = r0.f16671O
                r0.mo25113a(r9)
            L_0x013b:
                r8.f16882z = r11
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                int r0 = r0.f16665I
                r8.f16826A = r0
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.content.DialogInterface$OnClickListener r0 = r0.f16701x
                if (r0 == 0) goto L_0x0152
                flyme.support.v7.app.FlymeAlertController$a$3 r0 = new flyme.support.v7.app.FlymeAlertController$a$3
                r0.<init>(r8)
                r9.setOnItemClickListener(r0)
                goto L_0x0160
            L_0x0152:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.content.DialogInterface$OnMultiChoiceClickListener r0 = r0.f16666J
                if (r0 == 0) goto L_0x0160
                flyme.support.v7.app.FlymeAlertController$a$4 r0 = new flyme.support.v7.app.FlymeAlertController$a$4
                r0.<init>(r9, r8)
                r9.setOnItemClickListener(r0)
            L_0x0160:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.widget.AdapterView$OnItemSelectedListener r0 = r0.f16670N
                if (r0 == 0) goto L_0x016d
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                android.widget.AdapterView$OnItemSelectedListener r0 = r0.f16670N
                r9.setOnItemSelectedListener(r0)
            L_0x016d:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                boolean r0 = r0.f16664H
                if (r0 == 0) goto L_0x0177
                r9.setChoiceMode(r10)
                goto L_0x0181
            L_0x0177:
                flyme.support.v7.app.AlertController$a r0 = r7.f16896a
                boolean r0 = r0.f16663G
                if (r0 == 0) goto L_0x0181
                r0 = 2
                r9.setChoiceMode(r0)
            L_0x0181:
                r8.f16874r = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.app.FlymeAlertController.C3113a.m18519b(flyme.support.v7.app.FlymeAlertController):void");
        }
    }

    /* renamed from: flyme.support.v7.app.FlymeAlertController$c */
    private static class C3119c extends ArrayAdapter<CharSequence> {
        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public C3119c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }

    /* renamed from: e */
    public void mo25099e(int i) {
        this.f16868aq = (int) (((float) i) * this.f16871at);
        FlymeAlertDialogLayout flymeAlertDialogLayout = (FlymeAlertDialogLayout) this.f16833H.findViewById(R.id.parentPanel);
        if (flymeAlertDialogLayout != null) {
            flymeAlertDialogLayout.setMaxHeight(this.f16868aq);
        }
    }

    /* renamed from: f */
    public void mo25100f(int i) {
        this.f16869ar = i;
    }

    /* renamed from: a */
    public void mo25086a(int i, int i2, int i3, int i4) {
        this.f16863al = true;
        this.f16864am = i;
        this.f16865an = i2;
        this.f16866ao = i3;
        this.f16867ap = i4;
    }

    /* renamed from: a */
    private void m18477a(View view, View view2, View view3, View view4) {
        C3121e eVar;
        List<C3121e> list;
        C3121e eVar2;
        int i = (view == null || view.getVisibility() != 0) ? 0 : 1;
        boolean z = view2 != null && view2.getVisibility() == 0;
        boolean z2 = view3 != null && view3.getVisibility() == 0;
        boolean z3 = view4 != null && view4.getVisibility() == 0;
        Space space = (Space) this.f16833H.findViewById(R.id.dialogSpace1);
        Space space2 = (Space) this.f16833H.findViewById(R.id.dialogSpace2);
        Space space3 = (Space) this.f16833H.findViewById(R.id.dialogSpace3);
        Space space4 = (Space) this.f16833H.findViewById(R.id.dialogSpace4);
        int i2 = (z3 ? 4 : 0) | i | ((z || z2) ? 2 : 0);
        C3121e eVar3 = null;
        if (this.f16863al) {
            eVar2 = new C3121e(0, this.f16864am, this.f16865an, this.f16866ao, this.f16867ap);
        } else {
            if (this.f16874r != null) {
                if (!this.f16861aj) {
                    list = f16825az;
                } else if (this.f16874r.getAdapter() == null || this.f16874r.getAdapter().getCount() != 1) {
                    list = f16823ax;
                } else {
                    list = f16824ay;
                }
            } else if (z2) {
                list = f16822aw;
            } else {
                list = f16821av;
            }
            Iterator<C3121e> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C3121e next = it.next();
                if (i2 == next.f16916a) {
                    eVar3 = next;
                    break;
                }
            }
            if (eVar3 == null) {
                eVar2 = f16821av.get(0);
            } else {
                eVar = eVar3;
                eVar.m18522a(this.f16832G, space, space2, space3, space4);
            }
        }
        eVar = eVar2;
        eVar.m18522a(this.f16832G, space, space2, space3, space4);
    }

    static {
        f16821av.add(new C3121e(7, 24, 14, 12, 10));
        f16821av.add(new C3121e(3, 24, 14, 24, 0));
        f16821av.add(new C3121e(5, 24, 24, 0, 10));
        f16821av.add(new C3121e(1, 24, 24, 0, 0));
        f16821av.add(new C3121e(6, 0, 24, 24, 10));
        f16821av.add(new C3121e(2, 0, 0, 0, 0));
        f16821av.add(new C3121e(4, 0, 0, 10, 10));
        f16821av.add(new C3121e(0, 10, 0, 0, 10));
        f16822aw.add(new C3121e(7, 24, 14, 12, 10));
        f16822aw.add(new C3121e(3, 24, 14, 24, 0));
        f16822aw.add(new C3121e(5, 24, 24, 0, 10));
        f16822aw.add(new C3121e(1, 24, 24, 0, 0));
        f16822aw.add(new C3121e(6, 0, 0, 12, 10));
        f16822aw.add(new C3121e(2, 0, 0, 0, 0));
        f16822aw.add(new C3121e(4, 0, 0, 10, 10));
        f16822aw.add(new C3121e(0, 10, 0, 0, 10));
        f16825az.add(new C3121e(7, 24, 12, 10, 0));
        f16825az.add(new C3121e(3, 24, 12, 0, 0));
        f16825az.add(new C3121e(5, 24, 10, 0, 0));
        f16825az.add(new C3121e(1, 24, 24, 0, 0));
        f16825az.add(new C3121e(6, 0, 0, 10, 0));
        f16825az.add(new C3121e(2, 0, 0, 0, 0));
        f16825az.add(new C3121e(4, 0, 0, 0, 0));
        f16825az.add(new C3121e(0, 10, 0, 0, 10));
        f16823ax.add(new C3121e(7, 24, 12, 10, 0));
        f16823ax.add(new C3121e(3, 24, 12, 0, 0));
        f16823ax.add(new C3121e(5, 24, 10, 0, 0));
        f16823ax.add(new C3121e(1, 24, 24, 0, 0));
        f16823ax.add(new C3121e(6, 0, 10, 10, 0));
        f16823ax.add(new C3121e(2, 0, 10, 0, 0));
        f16823ax.add(new C3121e(4, 0, 0, 10, 0));
        f16823ax.add(new C3121e(0, 10, 0, 0, 10));
        f16824ay.add(new C3121e(7, 24, 12, 0, 0));
        f16824ay.add(new C3121e(3, 24, 12, 0, 0));
        f16824ay.add(new C3121e(5, 24, 10, 0, 0));
        f16824ay.add(new C3121e(1, 24, 24, 0, 0));
        f16824ay.add(new C3121e(6, 0, 0, 0, 0));
        f16824ay.add(new C3121e(2, 0, 10, 0, 0));
        f16824ay.add(new C3121e(4, 0, 0, 10, 0));
        f16824ay.add(new C3121e(0, 10, 0, 0, 10));
    }

    /* renamed from: flyme.support.v7.app.FlymeAlertController$e */
    private static class C3121e {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f16916a;

        /* renamed from: b */
        private int f16917b;

        /* renamed from: c */
        private int f16918c;

        /* renamed from: d */
        private int f16919d;

        /* renamed from: e */
        private int f16920e;

        public C3121e(int i, int i2, int i3, int i4, int i5) {
            this.f16916a = i;
            this.f16917b = i2;
            this.f16918c = i3;
            this.f16919d = i4;
            this.f16920e = i5;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m18522a(Context context, View view, View view2, View view3, View view4) {
            if (view != null) {
                view.getLayoutParams().height = FlymeAlertController.m18483b(context, (float) this.f16917b);
            }
            if (view2 != null) {
                view2.getLayoutParams().height = FlymeAlertController.m18483b(context, (float) this.f16918c);
            }
            if (view3 != null) {
                view3.getLayoutParams().height = FlymeAlertController.m18483b(context, (float) this.f16919d);
            }
            if (view4 != null) {
                view4.getLayoutParams().height = FlymeAlertController.m18483b(context, (float) this.f16920e);
            }
        }
    }

    /* renamed from: e */
    private boolean m18493e() {
        int i;
        int i2;
        int dimensionPixelOffset = this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_button_max_text_length);
        if (this.f16875s == null || this.f16875s.getVisibility() != 0) {
            i2 = 0;
            i = 0;
        } else {
            int a = m18474a((TextView) this.f16875s, this.f16844S);
            if (a > dimensionPixelOffset) {
                return true;
            }
            i2 = a + 0;
            i = 1;
        }
        if (this.f16877u != null && this.f16877u.getVisibility() == 0) {
            int a2 = m18474a((TextView) this.f16877u, this.f16846U);
            if (a2 > dimensionPixelOffset) {
                return true;
            }
            i2 += a2;
            i++;
        }
        if (this.f16879w != null && this.f16879w.getVisibility() == 0) {
            int a3 = m18474a((TextView) this.f16879w, this.f16848W);
            if (a3 > dimensionPixelOffset) {
                return true;
            }
            i2 += a3;
            i++;
        }
        if (this.f16861aj) {
            return true;
        }
        if (i != 1 && i2 + ((i + 1) * this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_button_min_margin)) > this.f16862ak) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m18480a(Button button) {
        if (button != null && button.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_vertical_button_height);
            button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_rectange);
        }
    }

    /* renamed from: a */
    private void m18481a(Button button, int i) {
        if (button != null && button.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_horizontal_button_height);
            button.setPadding(i, button.getPaddingTop(), i, button.getPaddingBottom());
            button.setBackgroundResource(R.drawable.mz_alert_dialog_button_bg_radius);
        }
    }

    /* renamed from: f */
    private int m18494f() {
        int i;
        int i2 = 0;
        if (this.f16875s == null || this.f16875s.getVisibility() != 0) {
            i = 0;
        } else {
            i2 = 0 + m18474a((TextView) this.f16875s, this.f16844S);
            i = 1;
        }
        if (this.f16877u != null && this.f16877u.getVisibility() == 0) {
            i2 += m18474a((TextView) this.f16877u, this.f16846U);
            i++;
        }
        if (this.f16879w != null && this.f16879w.getVisibility() == 0) {
            i2 += m18474a((TextView) this.f16879w, this.f16848W);
            i++;
        }
        return ((this.f16862ak - i2) / (i + 1)) / 2;
    }

    /* renamed from: a */
    private int m18474a(TextView textView, CharSequence charSequence) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, textView);
        }
        int i = 0;
        for (String measureText : charSequence.toString().split("\n")) {
            i = Math.max(i, (int) textView.getPaint().measureText(measureText));
        }
        return i;
    }

    /* renamed from: b */
    public void mo25281b() {
        int i;
        View e;
        boolean z = false;
        boolean z2 = this.f16853ab != null && this.f16853ab.getVisibility() == 0;
        boolean z3 = this.f16852aa != null && this.f16852aa.getVisibility() == 0;
        if (this.f16874r != null && z2) {
            m18486b(this.f16853ab);
        }
        if (z2 && !z3 && m18498i()) {
            this.f16853ab.setGravity(17);
        }
        boolean z4 = this.f16854ac != null && this.f16854ac.getVisibility() == 0;
        if (z4 && m18499j()) {
            this.f16854ac.setGravity(17);
        }
        if (!z2 && z4) {
            m18482a(this.f16854ac);
        }
        if (this.f16874r != null && this.f16861aj) {
            this.f16874r.setDivider((Drawable) null);
        }
        ViewGroup viewGroup = (ViewGroup) this.f16833H.findViewById(R.id.customPanel);
        if (!(viewGroup == null || viewGroup.getVisibility() == 8)) {
            z = true;
        }
        if (z && !this.f16843R && (e = m18492e((View) viewGroup)) != null) {
            if (this.f16832G.getApplicationInfo().targetSdkVersion >= 28) {
                e.requestFocus();
            }
            if (!m18495f(e)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((FrameLayout) this.f16833H.findViewById(R.id.custom)).getLayoutParams();
                layoutParams.leftMargin = this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_edittext_padding_left);
                layoutParams.rightMargin = this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_edittext_padding_right);
            }
        }
        WindowManager.LayoutParams attributes = this.f16833H.getAttributes();
        attributes.width = this.f16862ak;
        if (this.f16868aq == 0) {
            this.f16868aq = m18496g() - (this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_margin_bottom_to_screen) * 2);
        }
        mo25099e(this.f16868aq);
        if (this.f16869ar != 0) {
            attributes.gravity = this.f16869ar;
        } else if (this.f16874r == null || this.f16861aj) {
            attributes.gravity = 80;
        } else {
            attributes.gravity = 17;
        }
        if (attributes.gravity == 80) {
            if (this.f16832G.getResources().getConfiguration().orientation == 2) {
                i = this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_margin_bottom_to_screen);
            } else if (CommonUtils.m5120a(this.f16832G)) {
                i = this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_margin_bottom_to_screen) - ScreenUtil.m5166a(this.f16832G);
            } else {
                i = this.f16832G.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_margin_bottom_to_screen);
            }
            attributes.y = i;
        } else if (attributes.gravity == 17 && this.f16832G.getResources().getConfiguration().orientation == 2) {
            attributes.y = (-this.f16832G.getResources().getDimensionPixelSize(InternalResUtils.m5123a(1, "status_bar_height"))) / 2;
        }
        if (this.f16870as) {
            this.f16833H.setSoftInputMode(37);
        }
        if (Build.VERSION.SDK_INT >= 22) {
            this.f16833H.setElevation(0.0f);
        }
    }

    /* renamed from: a */
    private void m18482a(TextView textView) {
        TypedArray obtainStyledAttributes = this.f16832G.obtainStyledAttributes((AttributeSet) null, new int[]{16842804}, 16842843, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, R.style.DialogWindowTitle_Flyme_Light);
        obtainStyledAttributes.recycle();
        textView.setTextAppearance(this.f16832G, resourceId);
    }

    /* renamed from: b */
    private void m18486b(TextView textView) {
        TypedArray obtainStyledAttributes = this.f16832G.obtainStyledAttributes((AttributeSet) null, new int[]{16842804}, R.attr.mzDialogMessageStyle, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, R.style.DialogWindowContent_Flyme_Light);
        obtainStyledAttributes.recycle();
        textView.setTextAppearance(this.f16832G, resourceId);
    }

    /* renamed from: e */
    private View m18492e(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof EditText) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View e = m18492e(viewGroup.getChildAt(i));
                if (e != null) {
                    return e;
                }
            }
        }
        return null;
    }

    /* renamed from: f */
    private boolean m18495f(@NonNull View view) {
        if (!(view instanceof EditText) && view.getPaddingLeft() != 0) {
            return true;
        }
        if (view.getLayoutParams() != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin != 0) {
            return true;
        }
        if (view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup.getId() != R.id.customPanel) {
            return m18495f((View) viewGroup);
        }
        return false;
    }

    /* renamed from: g */
    private int m18496g() {
        WindowManager windowManager = (WindowManager) this.f16832G.getSystemService("window");
        if (windowManager == null) {
            return this.f16832G.getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* renamed from: h */
    private int m18497h() {
        WindowManager windowManager = (WindowManager) this.f16832G.getSystemService("window");
        if (windowManager == null) {
            return this.f16832G.getResources().getDisplayMetrics().widthPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m18483b(Context context, float f) {
        float f2;
        try {
            ReflectUtils.C1344h a = ReflectUtils.m5143a("android.os.SystemProperties").mo16008a("getInt", String.class, Integer.TYPE);
            f2 = ((float) ((Integer) a.mo16011a((Object) null, "persist.sys.density", Integer.valueOf(((Integer) a.mo16011a((Object) null, "ro.sf.lcd_density", 480)).intValue()))).intValue()) / 160.0f;
        } catch (Exception unused) {
            f2 = 3.0f;
        }
        return (int) (f * f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0093 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m18498i() {
        /*
            r7 = this;
            java.lang.CharSequence r0 = r7.f16835J
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0088
            android.view.Window r0 = r7.f16833H
            int r2 = flyme.support.p093v7.appcompat.R.id.title_template
            android.view.View r0 = r0.findViewById(r2)
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r2 = (android.widget.LinearLayout.LayoutParams) r2
            int r3 = r2.leftMargin
            int r2 = r2.rightMargin
            int r3 = r3 + r2
            android.widget.TextView r2 = r7.f16853ab
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r2 = (android.widget.LinearLayout.LayoutParams) r2
            int r4 = r2.leftMargin
            int r2 = r2.rightMargin
            int r4 = r4 + r2
            int r2 = r3 + r4
            android.widget.TextView r3 = r7.f16853ab
            int r3 = r3.getPaddingLeft()
            android.widget.TextView r4 = r7.f16853ab
            int r4 = r4.getPaddingRight()
            int r3 = r3 + r4
            int r4 = r0.getPaddingLeft()
            int r3 = r3 + r4
            int r0 = r0.getPaddingRight()
            int r0 = r0 + r3
            android.widget.TextView r3 = r7.f16853ab
            java.lang.CharSequence r4 = r7.f16835J
            int r3 = r7.m18474a((android.widget.TextView) r3, (java.lang.CharSequence) r4)
            int r4 = r7.f16850Y
            if (r4 != 0) goto L_0x0052
            android.graphics.drawable.Drawable r4 = r7.f16851Z
            if (r4 == 0) goto L_0x008b
        L_0x0052:
            android.widget.ImageView r4 = r7.f16852aa
            if (r4 == 0) goto L_0x008b
            android.widget.ImageView r4 = r7.f16852aa
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L_0x008b
            android.content.Context r4 = r7.f16832G
            android.content.res.Resources r4 = r4.getResources()
            int r5 = flyme.support.p093v7.appcompat.R.dimen.mz_alert_dialog_title_icon_width
            int r4 = r4.getDimensionPixelSize(r5)
            int r4 = r4 + r1
            android.widget.ImageView r5 = r7.f16852aa
            int r5 = r5.getPaddingLeft()
            android.widget.ImageView r6 = r7.f16852aa
            int r6 = r6.getPaddingRight()
            int r5 = r5 + r6
            int r4 = r4 + r5
            android.widget.ImageView r5 = r7.f16852aa
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r6 = r5.leftMargin
            int r5 = r5.rightMargin
            int r6 = r6 + r5
            int r4 = r4 + r6
            goto L_0x008c
        L_0x0088:
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x008b:
            r4 = 0
        L_0x008c:
            int r3 = r3 + r0
            int r3 = r3 + r2
            int r3 = r3 + r4
            int r0 = r7.f16862ak
            if (r3 > r0) goto L_0x0094
            r1 = 1
        L_0x0094:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.app.FlymeAlertController.m18498i():boolean");
    }

    /* renamed from: j */
    private boolean m18499j() {
        if (this.f16854ac == null || TextUtils.isEmpty(this.f16836K) || m18474a(this.f16854ac, this.f16836K) + this.f16854ac.getPaddingLeft() + this.f16854ac.getPaddingRight() <= this.f16862ak) {
            return true;
        }
        return false;
    }
}
