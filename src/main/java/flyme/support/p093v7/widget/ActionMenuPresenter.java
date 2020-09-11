package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.GravityCompat;
import com.meizu.common.util.ReflectUtils;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.p094a.RippleDrawableComp;
import flyme.support.p093v7.view.ActionBarPolicy;
import flyme.support.p093v7.view.menu.ActionMenuItemView;
import flyme.support.p093v7.view.menu.BaseMenuPresenter;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.view.menu.MenuItemImpl;
import flyme.support.p093v7.view.menu.MenuPopupHelper;
import flyme.support.p093v7.view.menu.MenuPresenter;
import flyme.support.p093v7.view.menu.MenuView;
import flyme.support.p093v7.view.menu.SubMenuBuilder;
import flyme.support.p093v7.widget.ActionMenuView;
import java.util.ArrayList;

/* renamed from: flyme.support.v7.widget.ActionMenuPresenter */
public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public C3183a f17483A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public C3186d f17484B;

    /* renamed from: C */
    private C3184b f17485C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f17486D;

    /* renamed from: g */
    final C3188f f17487g = new C3188f();

    /* renamed from: h */
    int f17488h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OverflowMenuButton f17489i;

    /* renamed from: j */
    private Drawable f17490j;

    /* renamed from: k */
    private boolean f17491k;

    /* renamed from: l */
    private boolean f17492l;

    /* renamed from: m */
    private boolean f17493m;

    /* renamed from: n */
    private int f17494n;

    /* renamed from: o */
    private int f17495o;

    /* renamed from: p */
    private int f17496p;

    /* renamed from: q */
    private boolean f17497q;

    /* renamed from: r */
    private boolean f17498r;

    /* renamed from: s */
    private boolean f17499s;

    /* renamed from: t */
    private boolean f17500t;

    /* renamed from: u */
    private int f17501u;

    /* renamed from: v */
    private int f17502v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public Drawable f17503w;

    /* renamed from: x */
    private final SparseBooleanArray f17504x = new SparseBooleanArray();

    /* renamed from: y */
    private View f17505y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public C3187e f17506z;

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.mz_abc_action_menu_layout, R.layout.mz_action_menu_item_layout);
    }

    /* renamed from: a */
    public void mo25729a(Context context, MenuBuilder menuBuilder) {
        super.mo25729a(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy a = ActionBarPolicy.m18758a(context);
        if (!this.f17493m) {
            this.f17492l = a.mo25413b();
        }
        if (!this.f17499s) {
            this.f17494n = a.mo25414c();
        }
        if (!this.f17497q) {
            this.f17496p = a.mo25412a();
        }
        int i = this.f17494n;
        if (this.f17492l) {
            if (this.f17489i == null) {
                this.f17489i = new OverflowMenuButton(this.f17313a);
                if (this.f17491k) {
                    this.f17489i.setImageDrawable(this.f17490j);
                    this.f17490j = null;
                    this.f17491k = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f17489i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f17489i.getMeasuredWidth();
        } else {
            this.f17489i = null;
        }
        this.f17495o = i;
        this.f17501u = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.f17505y = null;
        this.f17502v = (int) (resources.getDisplayMetrics().density * 60.0f);
    }

    /* renamed from: a */
    public void mo25941a(Configuration configuration) {
        if (!this.f17497q) {
            this.f17496p = this.f17314b.getResources().getInteger(R.integer.abc_max_action_buttons);
        }
        if (this.f17315c != null) {
            this.f17315c.mo25567b(true);
        }
    }

    /* renamed from: a */
    public void mo25940a(int i, boolean z) {
        this.f17494n = i;
        this.f17498r = z;
        this.f17499s = true;
    }

    /* renamed from: b */
    public void mo25945b(boolean z) {
        this.f17492l = z;
        this.f17493m = true;
    }

    /* renamed from: c */
    public void mo25947c(int i) {
        this.f17496p = i;
        this.f17497q = true;
    }

    /* renamed from: c */
    public void mo25948c(boolean z) {
        this.f17500t = z;
    }

    /* renamed from: a */
    public void mo25942a(Drawable drawable) {
        if (this.f17489i != null) {
            this.f17489i.setImageDrawable(drawable);
            return;
        }
        this.f17491k = true;
        this.f17490j = drawable;
    }

    /* renamed from: c */
    public Drawable mo25946c() {
        if (this.f17489i != null) {
            return this.f17489i.getDrawable();
        }
        if (this.f17491k) {
            return this.f17490j;
        }
        return null;
    }

    /* renamed from: a */
    public MenuView mo25727a(ViewGroup viewGroup) {
        MenuView a = super.mo25727a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    /* renamed from: a */
    public View mo25725a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.mo25646m()) {
            actionView = super.mo25725a(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        } else if ((layoutParams instanceof ActionMenuView.LayoutParams) && (actionView instanceof ActionMenuItemView)) {
            ((ActionMenuView.LayoutParams) layoutParams).f17537a = ((ActionMenuItemView) actionView).mo25502e();
        }
        return actionView;
    }

    /* renamed from: a */
    public void mo25732a(MenuItemImpl menuItemImpl, MenuView.C3168a aVar) {
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setIsInSplit(this.f17486D);
        aVar.mo25497a(menuItemImpl, 0);
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f17318f);
        if (this.f17485C == null) {
            this.f17485C = new C3184b();
        }
        actionMenuItemView.setPopupCallback(this.f17485C);
    }

    /* renamed from: a */
    public boolean mo25735a(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.mo25638i();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c2  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo25734a(boolean r8) {
        /*
            r7 = this;
            super.mo25734a((boolean) r8)
            flyme.support.v7.view.menu.i r8 = r7.f17318f
            android.view.View r8 = (android.view.View) r8
            r8.requestLayout()
            flyme.support.v7.view.menu.MenuBuilder r8 = r7.f17315c
            r0 = 0
            if (r8 == 0) goto L_0x002e
            flyme.support.v7.view.menu.MenuBuilder r8 = r7.f17315c
            java.util.ArrayList r8 = r8.mo25588k()
            int r1 = r8.size()
            r2 = 0
        L_0x001a:
            if (r2 >= r1) goto L_0x002e
            java.lang.Object r3 = r8.get(r2)
            flyme.support.v7.view.menu.MenuItemImpl r3 = (flyme.support.p093v7.view.menu.MenuItemImpl) r3
            androidx.core.view.ActionProvider r3 = r3.getSupportActionProvider()
            if (r3 == 0) goto L_0x002b
            r3.setSubUiVisibilityListener(r7)
        L_0x002b:
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002e:
            flyme.support.v7.view.menu.MenuBuilder r8 = r7.f17315c
            r1 = 0
            if (r8 == 0) goto L_0x003a
            flyme.support.v7.view.menu.MenuBuilder r8 = r7.f17315c
            java.util.ArrayList r8 = r8.mo25589l()
            goto L_0x003b
        L_0x003a:
            r8 = r1
        L_0x003b:
            boolean r2 = r7.f17492l
            r3 = 1
            if (r2 == 0) goto L_0x0058
            if (r8 == 0) goto L_0x0058
            int r2 = r8.size()
            if (r2 != r3) goto L_0x0054
            java.lang.Object r2 = r8.get(r0)
            flyme.support.v7.view.menu.MenuItemImpl r2 = (flyme.support.p093v7.view.menu.MenuItemImpl) r2
            boolean r2 = r2.isActionViewExpanded()
            r2 = r2 ^ r3
            goto L_0x0059
        L_0x0054:
            if (r2 <= 0) goto L_0x0058
            r2 = 1
            goto L_0x0059
        L_0x0058:
            r2 = 0
        L_0x0059:
            if (r2 == 0) goto L_0x00a9
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r4 = r7.f17489i
            if (r4 != 0) goto L_0x0068
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r4 = new flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton
            android.content.Context r5 = r7.f17313a
            r4.<init>(r5)
            r7.f17489i = r4
        L_0x0068:
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r4 = r7.f17489i
            android.view.ViewParent r4 = r4.getParent()
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            flyme.support.v7.view.menu.i r5 = r7.f17318f
            if (r4 == r5) goto L_0x0088
            if (r4 == 0) goto L_0x007b
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r5 = r7.f17489i
            r4.removeView(r5)
        L_0x007b:
            flyme.support.v7.view.menu.i r4 = r7.f17318f
            flyme.support.v7.widget.ActionMenuView r4 = (flyme.support.p093v7.widget.ActionMenuView) r4
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r5 = r7.f17489i
            flyme.support.v7.widget.ActionMenuView$LayoutParams r6 = r4.mo25977c()
            r4.addView(r5, r6)
        L_0x0088:
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r4 = r7.f17489i
            r4.setSpotVisible(r0)
            java.util.Iterator r8 = r8.iterator()
        L_0x0091:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00c0
            java.lang.Object r0 = r8.next()
            flyme.support.v7.view.menu.MenuItemImpl r0 = (flyme.support.p093v7.view.menu.MenuItemImpl) r0
            boolean r0 = r0.mo25650q()
            if (r0 == 0) goto L_0x0091
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r8 = r7.f17489i
            r8.setSpotVisible(r3)
            goto L_0x00c0
        L_0x00a9:
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r8 = r7.f17489i
            if (r8 == 0) goto L_0x00c0
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r8 = r7.f17489i
            android.view.ViewParent r8 = r8.getParent()
            flyme.support.v7.view.menu.i r0 = r7.f17318f
            if (r8 != r0) goto L_0x00c0
            flyme.support.v7.view.menu.i r8 = r7.f17318f
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton r0 = r7.f17489i
            r8.removeView(r0)
        L_0x00c0:
            if (r2 != 0) goto L_0x00e9
            flyme.support.v7.view.menu.MenuBuilder r8 = r7.f17315c
            if (r8 == 0) goto L_0x00cc
            flyme.support.v7.view.menu.MenuBuilder r8 = r7.f17315c
            java.util.ArrayList r1 = r8.mo25585i()
        L_0x00cc:
            if (r1 == 0) goto L_0x00e9
            int r8 = r1.size()
            if (r8 <= 0) goto L_0x00e9
            java.util.Iterator r8 = r1.iterator()
        L_0x00d8:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00e9
            java.lang.Object r0 = r8.next()
            flyme.support.v7.view.menu.MenuItemImpl r0 = (flyme.support.p093v7.view.menu.MenuItemImpl) r0
            boolean r2 = r0.mo25648o()
            goto L_0x00d8
        L_0x00e9:
            flyme.support.v7.view.menu.i r8 = r7.f17318f
            flyme.support.v7.widget.ActionMenuView r8 = (flyme.support.p093v7.widget.ActionMenuView) r8
            boolean r0 = r7.f17492l
            r8.setOverflowReserved(r0)
            flyme.support.v7.view.menu.i r8 = r7.f17318f
            flyme.support.v7.widget.ActionMenuView r8 = (flyme.support.p093v7.widget.ActionMenuView) r8
            r8.setHasOverflow(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.ActionMenuPresenter.mo25734a(boolean):void");
    }

    /* renamed from: a */
    public boolean mo25736a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f17489i) {
            return false;
        }
        return super.mo25736a(viewGroup, i);
    }

    /* renamed from: a */
    public boolean mo25738a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.mo25717s() != this.f17315c) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.mo25717s();
        }
        View a = m19134a(subMenuBuilder2.getItem());
        if (a == null) {
            if (this.f17489i == null) {
                return false;
            }
            a = this.f17489i;
        }
        this.f17488h = subMenuBuilder.getItem().getItemId();
        this.f17483A = new C3183a(this.f17314b, subMenuBuilder);
        this.f17483A.mo25765a((int) GravityCompat.END);
        this.f17483A.mo25766a(a);
        this.f17483A.mo25764a();
        super.mo25738a(subMenuBuilder);
        return true;
    }

    /* renamed from: a */
    private View m19134a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f17318f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MenuView.C3168a) && ((MenuView.C3168a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: d */
    public boolean mo25950d() {
        if (!this.f17492l || mo25954h() || this.f17315c == null || this.f17318f == null || this.f17484B != null || this.f17315c.mo25589l().isEmpty()) {
            return false;
        }
        this.f17484B = new C3186d(new C3187e(this.f17314b, this.f17315c, this.f17489i, true));
        ((View) this.f17318f).post(this.f17484B);
        super.mo25738a((SubMenuBuilder) null);
        return true;
    }

    /* renamed from: e */
    public boolean mo25951e() {
        if (this.f17484B == null || this.f17318f == null) {
            C3187e eVar = this.f17506z;
            if (eVar == null) {
                return false;
            }
            eVar.mo25771e();
            return true;
        }
        ((View) this.f17318f).removeCallbacks(this.f17484B);
        this.f17484B = null;
        return true;
    }

    /* renamed from: f */
    public boolean mo25952f() {
        return mo25951e() | mo25953g();
    }

    /* renamed from: g */
    public boolean mo25953g() {
        if (this.f17483A == null) {
            return false;
        }
        this.f17483A.mo25771e();
        return true;
    }

    /* renamed from: h */
    public boolean mo25954h() {
        return this.f17506z != null && this.f17506z.mo25772f();
    }

    /* renamed from: i */
    public boolean mo25955i() {
        return this.f17484B != null || mo25954h();
    }

    /* renamed from: b */
    public boolean mo25741b() {
        int i;
        int i2;
        int i3;
        boolean z;
        ActionMenuPresenter actionMenuPresenter = this;
        if (actionMenuPresenter.f17486D) {
            return m19149k();
        }
        ArrayList<MenuItemImpl> i4 = actionMenuPresenter.f17315c.mo25585i();
        int size = i4.size();
        int i5 = actionMenuPresenter.f17496p;
        int i6 = actionMenuPresenter.f17495o;
        int i7 = 0;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f17318f;
        int i8 = i5;
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            MenuItemImpl menuItemImpl = i4.get(i11);
            if (menuItemImpl.mo25644k()) {
                i9++;
            } else if (menuItemImpl.mo25643j()) {
                i10++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.f17500t && menuItemImpl.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (actionMenuPresenter.f17492l && (z2 || i10 + i9 > i8)) {
            i8--;
        }
        int i12 = i8 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f17504x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f17498r) {
            i2 = i6 / actionMenuPresenter.f17501u;
            i = ((i6 % actionMenuPresenter.f17501u) / i2) + actionMenuPresenter.f17501u;
        } else {
            i2 = 0;
            i = 0;
        }
        int i13 = i6;
        int i14 = 0;
        int i15 = 0;
        while (i14 < size) {
            MenuItemImpl menuItemImpl2 = i4.get(i14);
            if (menuItemImpl2.mo25644k()) {
                View a = actionMenuPresenter.mo25725a(menuItemImpl2, actionMenuPresenter.f17505y, viewGroup);
                if (actionMenuPresenter.f17505y == null) {
                    actionMenuPresenter.f17505y = a;
                }
                if (actionMenuPresenter.f17498r) {
                    i2 -= ActionMenuView.m19189a(a, i, i2, makeMeasureSpec, i7);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a.getMeasuredWidth();
                i13 -= measuredWidth;
                if (i15 != 0) {
                    measuredWidth = i15;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                menuItemImpl2.mo25619d(z);
                i3 = size;
                i15 = measuredWidth;
            } else if (menuItemImpl2.mo25643j()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i13 > 0 && (!actionMenuPresenter.f17498r || i2 > 0);
                if (z4) {
                    i3 = size;
                    View a2 = actionMenuPresenter.mo25725a(menuItemImpl2, actionMenuPresenter.f17505y, viewGroup);
                    boolean z5 = z4;
                    if (actionMenuPresenter.f17505y == null) {
                        actionMenuPresenter.f17505y = a2;
                    }
                    if (actionMenuPresenter.f17498r) {
                        int a3 = ActionMenuView.m19189a(a2, i, i2, makeMeasureSpec, 0);
                        i2 -= a3;
                        z5 = a3 == 0 ? false : z5;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a2.getMeasuredWidth();
                    i13 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    if (actionMenuPresenter.f17498r) {
                        z4 = z5 & (i13 >= 0);
                    } else if (i14 == 0) {
                        z4 = z5 & (i13 + i15 > 0);
                    } else {
                        z4 = z5 & (i13 >= 0);
                    }
                } else {
                    i3 = size;
                    boolean z6 = z4;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    int i16 = 0;
                    while (i16 < i14) {
                        MenuItemImpl menuItemImpl3 = i4.get(i16);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.mo25638i()) {
                                i12++;
                            }
                            menuItemImpl3.mo25619d(false);
                        }
                        i16++;
                    }
                }
                if (z4) {
                    i12--;
                }
                menuItemImpl2.mo25619d(z4);
            } else {
                i3 = size;
                menuItemImpl2.mo25619d(false);
                i14++;
                size = i3;
                actionMenuPresenter = this;
                i7 = 0;
            }
            i14++;
            size = i3;
            actionMenuPresenter = this;
            i7 = 0;
        }
        return true;
    }

    /* renamed from: a */
    public void mo25731a(MenuBuilder menuBuilder, boolean z) {
        mo25952f();
        super.mo25731a(menuBuilder, z);
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.mo25738a((SubMenuBuilder) null);
        } else {
            this.f17315c.mo25550a(false);
        }
    }

    /* renamed from: a */
    public void mo25943a(ActionMenuView actionMenuView) {
        this.f17318f = actionMenuView;
        actionMenuView.mo25522a(this.f17315c);
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuPresenter$SavedState */
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        public int f17515a;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f17515a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f17515a);
        }
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuPresenter$OverflowMenuButton */
    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.C3190a {

        /* renamed from: b */
        private final float[] f17508b;

        /* renamed from: c */
        private final int f17509c;

        /* renamed from: d */
        private final Paint f17510d;

        /* renamed from: e */
        private final float f17511e;

        /* renamed from: f */
        private boolean f17512f;

        /* renamed from: c */
        public boolean mo25500c() {
            return false;
        }

        /* renamed from: d */
        public boolean mo25501d() {
            return false;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OverflowMenuButton(Context context) {
            super(context, (AttributeSet) null, ActionMenuPresenter.this.f17486D ? R.attr.mzActionOverflowButtonSplitStyle : R.attr.actionOverflowButtonStyle);
            this.f17508b = new float[2];
            this.f17509c = SupportMenu.CATEGORY_MASK;
            setId(R.id.mz_action_overflow_button);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ForwardingListener(this, ActionMenuPresenter.this) {
                /* renamed from: a */
                public ListPopupWindow getPopup() {
                    if (ActionMenuPresenter.this.f17506z == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.f17506z.mo25769c();
                }

                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.mo25950d();
                    return true;
                }

                public boolean onForwardingStopped() {
                    if (ActionMenuPresenter.this.f17484B != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.mo25951e();
                    return true;
                }
            });
            setOnTouchListener((View.OnTouchListener) null);
            if (ActionMenuPresenter.this.mo25956j() || Build.VERSION.SDK_INT < 21) {
                setBackgroundDrawable(new C3185c(this));
            }
            if (ActionMenuPresenter.this.f17503w != null) {
                setImageDrawable(ActionMenuPresenter.this.f17503w);
            }
            setContentDescription(getResources().getString(R.string.abc_action_menu_overflow_description));
            this.f17511e = context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
            this.f17510d = new Paint();
            this.f17510d.setAntiAlias(true);
            this.f17510d.setColor(SupportMenu.CATEGORY_MASK);
            this.f17510d.setStyle(Paint.Style.FILL);
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.mo25950d();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            int paddingLeft = getPaddingLeft() - getPaddingRight();
            int paddingTop = getPaddingTop() - getPaddingBottom();
            if (!(drawable == null || background == null || (paddingLeft == 0 && paddingTop == 0))) {
                int width = getWidth();
                int height = getHeight();
                int i5 = width / 2;
                int i6 = height / 2;
                int i7 = (width + paddingLeft) / 2;
                int i8 = (height + paddingTop) / 2;
                DrawableCompat.setHotspotBounds(background, i7 - i5, i8 - i6, i7 + i5, i8 + i6);
            }
            return frame;
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            int i5 = (int) (getResources().getDisplayMetrics().density * 52.0f);
            int i6 = i3 - i;
            if (i6 < i5) {
                int i7 = (i5 - i6) / 2;
                ((View) getParent()).setTouchDelegate(new TouchDelegate(new Rect(i - i7, i2, i3 + i7, i4), this));
            }
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.f17512f) {
                try {
                    Matrix matrix = (Matrix) ReflectUtils.m5142a((Object) this).mo16007a("mDrawMatrix").mo16009a(this);
                    canvas.save();
                    canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
                    if (matrix != null) {
                        canvas.concat(matrix);
                    }
                    Rect bounds = getDrawable().getBounds();
                    canvas.drawCircle(((float) bounds.right) + this.f17511e, ((float) bounds.top) + this.f17511e, this.f17511e, this.f17510d);
                    canvas.restore();
                } catch (Exception unused) {
                }
            }
        }

        public void setSpotVisible(boolean z) {
            if (this.f17512f != z) {
                this.f17512f = z;
                invalidate();
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuPresenter$e */
    private class C3187e extends MenuPopupHelper {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3187e(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, ActionMenuPresenter.this.mo25956j() ? R.attr.mzActionOverflowMenuSplitStyle : R.attr.actionOverflowMenuStyle);
            mo25765a((int) GravityCompat.END);
            mo25767a((MenuPresenter.C3167a) ActionMenuPresenter.this.f17487g);
        }

        public void onDismiss() {
            super.onDismiss();
            if (ActionMenuPresenter.this.f17315c != null) {
                ActionMenuPresenter.this.f17315c.close();
            }
            C3187e unused = ActionMenuPresenter.this.f17506z = null;
        }
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuPresenter$a */
    private class C3183a extends MenuPopupHelper {

        /* renamed from: d */
        private SubMenuBuilder f17517d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C3183a(Context context, SubMenuBuilder subMenuBuilder) {
            super(context, subMenuBuilder, (View) null, false, ActionMenuPresenter.this.mo25956j() ? R.attr.mzActionOverflowMenuSplitStyle : R.attr.actionOverflowMenuStyle);
            this.f17517d = subMenuBuilder;
            if (!((MenuItemImpl) subMenuBuilder.getItem()).mo25638i()) {
                mo25766a(ActionMenuPresenter.this.f17489i == null ? (View) ActionMenuPresenter.this.f17318f : ActionMenuPresenter.this.f17489i);
            }
            mo25767a((MenuPresenter.C3167a) ActionMenuPresenter.this.f17487g);
            int size = subMenuBuilder.size();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            mo25768b(z);
        }

        public void onDismiss() {
            super.onDismiss();
            C3183a unused = ActionMenuPresenter.this.f17483A = null;
            ActionMenuPresenter.this.f17488h = 0;
        }
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuPresenter$f */
    private class C3188f implements MenuPresenter.C3167a {
        private C3188f() {
        }

        /* renamed from: a_ */
        public boolean mo25243a_(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            ActionMenuPresenter.this.f17488h = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.C3167a a = ActionMenuPresenter.this.mo25726a();
            if (a == null || !a.mo25243a_(menuBuilder)) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public void mo25242a(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.mo25593p().mo25550a(false);
            }
            MenuPresenter.C3167a a = ActionMenuPresenter.this.mo25726a();
            if (a != null) {
                a.mo25242a(menuBuilder, z);
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuPresenter$d */
    private class C3186d implements Runnable {

        /* renamed from: b */
        private C3187e f17521b;

        public C3186d(C3187e eVar) {
            this.f17521b = eVar;
        }

        public void run() {
            ActionMenuPresenter.this.f17315c.mo25579f();
            View view = (View) ActionMenuPresenter.this.f17318f;
            if (!(view == null || view.getWindowToken() == null || !this.f17521b.mo25770d())) {
                C3187e unused = ActionMenuPresenter.this.f17506z = this.f17521b;
            }
            C3186d unused2 = ActionMenuPresenter.this.f17484B = null;
        }
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuPresenter$b */
    private class C3184b extends ActionMenuItemView.C3158a {
        private C3184b() {
        }

        /* renamed from: b */
        public ListPopupWindow mo25521a() {
            if (ActionMenuPresenter.this.f17483A != null) {
                return ActionMenuPresenter.this.f17483A.mo25769c();
            }
            return null;
        }
    }

    /* renamed from: d */
    public void mo25949d(boolean z) {
        if (this.f17486D != z) {
            this.f17486D = z;
            mo25740b(this.f17486D ? R.layout.mz_action_menu_item_split_layout : R.layout.mz_action_menu_item_layout);
            if (this.f17318f != null) {
                ((ViewGroup) this.f17318f).removeAllViews();
            }
            if (!z) {
                this.f17493m = false;
                this.f17499s = false;
                this.f17497q = false;
                mo25729a(this.f17314b, this.f17315c);
            }
        }
    }

    /* renamed from: j */
    public boolean mo25956j() {
        return this.f17486D;
    }

    /* renamed from: k */
    private boolean m19149k() {
        ArrayList<MenuItemImpl> i = this.f17315c.mo25585i();
        int size = i.size();
        int i2 = this.f17494n;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            MenuItemImpl menuItemImpl = i.get(i5);
            if (menuItemImpl.mo25644k()) {
                i3++;
            } else if (menuItemImpl.mo25643j()) {
                i4++;
            } else {
                z = true;
            }
        }
        boolean z2 = this.f17492l && z;
        SparseBooleanArray sparseBooleanArray = this.f17504x;
        sparseBooleanArray.clear();
        int i6 = this.f17498r ? i2 / this.f17502v : 0;
        int i7 = i3 + i4;
        if (z2 || (i7 > i6)) {
            i6--;
        }
        if (i7 < i6) {
            i6 = i7;
        }
        int i8 = i6;
        int i9 = 0;
        while (i9 < size && i8 > 0) {
            MenuItemImpl menuItemImpl2 = i.get(i9);
            if (menuItemImpl2.mo25644k() || menuItemImpl2.mo25643j()) {
                i8--;
                menuItemImpl2.mo25619d(true);
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
            } else {
                menuItemImpl2.mo25619d(false);
            }
            i9++;
        }
        for (int i10 = i9; i10 < size; i10++) {
            i.get(i9).mo25619d(false);
        }
        return true;
    }

    /* renamed from: b */
    public MenuView.C3168a mo25739b(ViewGroup viewGroup) {
        MenuView.C3168a b = super.mo25739b(viewGroup);
        if (b instanceof View) {
            View view = (View) b;
            if (Build.VERSION.SDK_INT < 21) {
                ((ActionMenuView) this.f17318f).setClipChildren(false);
                view.setBackgroundDrawable(new C3185c(view));
            }
        }
        return b;
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuPresenter$c */
    private class C3185c extends RippleDrawableComp {
        public C3185c(View view) {
            super(view, R.attr.mzActionButtonRippleSplitStyle);
        }
    }

    /* renamed from: b */
    public void mo25944b(Drawable drawable) {
        this.f17503w = drawable;
        if (this.f17489i != null) {
            this.f17489i.setImageDrawable(this.f17503w);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25730a(View view, int i) {
        super.mo25730a(view, i);
        if ((this.f17318f instanceof ActionMenuView) && (view instanceof ActionMenuItemView)) {
            ((ActionMenuView.LayoutParams) view.getLayoutParams()).f17537a = ((ActionMenuItemView) view).mo25502e();
        }
    }
}
