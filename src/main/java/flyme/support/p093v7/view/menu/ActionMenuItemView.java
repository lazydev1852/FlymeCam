package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.ViewCompat;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.view.menu.MenuView;
import flyme.support.p093v7.widget.ActionMenuView;

/* renamed from: flyme.support.v7.view.menu.ActionMenuItemView */
public class ActionMenuItemView extends AppCompatTextView implements View.OnClickListener, View.OnLongClickListener, MenuView.C3168a, ActionMenuView.C3190a {

    /* renamed from: s */
    private static final int[] f17200s = {16842919};
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MenuItemImpl f17201a;

    /* renamed from: b */
    private CharSequence f17202b;

    /* renamed from: c */
    private Drawable f17203c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MenuBuilder.C3160b f17204d;

    /* renamed from: e */
    private ForwardingListener f17205e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C3158a f17206f;

    /* renamed from: g */
    private boolean f17207g;

    /* renamed from: h */
    private boolean f17208h;

    /* renamed from: i */
    private int f17209i;

    /* renamed from: j */
    private int f17210j;

    /* renamed from: k */
    private int f17211k;

    /* renamed from: l */
    private boolean f17212l;

    /* renamed from: m */
    private float f17213m;

    /* renamed from: n */
    private float f17214n;

    /* renamed from: o */
    private int f17215o;

    /* renamed from: p */
    private boolean f17216p;

    /* renamed from: q */
    private Drawable f17217q;

    /* renamed from: r */
    private boolean f17218r;

    /* renamed from: flyme.support.v7.view.menu.ActionMenuItemView$a */
    public static abstract class C3158a {
        /* renamed from: a */
        public abstract ListPopupWindow mo25521a();
    }

    /* renamed from: a */
    public boolean mo25498a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setShortcut(boolean z, char c) {
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17215o = 255;
        Resources resources = context.getResources();
        this.f17207g = resources.getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i, 0);
        this.f17209i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        this.f17214n = obtainStyledAttributes.getFloat(R.styleable.ActionMenuItemView_mzItemIconPressedAlpha, 1.0f);
        this.f17217q = obtainStyledAttributes.getDrawable(R.styleable.ActionMenuItemView_mzItemBackgroundSplit);
        obtainStyledAttributes.recycle();
        this.f17211k = (int) ((resources.getDisplayMetrics().density * 24.0f) + 0.5f);
        setOnClickListener(this);
        this.f17210j = -1;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.MenuView, i, 0);
        this.f17213m = obtainStyledAttributes2.getFloat(R.styleable.MenuView_android_itemIconDisabledAlpha, 1.0f);
        obtainStyledAttributes2.recycle();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f17207g = getContext().getResources().getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        m18870f();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f17210j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public MenuItemImpl getItemData() {
        return this.f17201a;
    }

    /* renamed from: a */
    public void mo25497a(MenuItemImpl menuItemImpl, int i) {
        this.f17201a = menuItemImpl;
        boolean z = true;
        this.f17218r = true;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.mo25608a((MenuView.C3168a) this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        setSelected(menuItemImpl.mo25649p());
        if (menuItemImpl.hasSubMenu() && this.f17205e == null) {
            this.f17205e = new ActionMenuItemForwardingListener();
        }
        setIsOverflowActor(menuItemImpl.mo25648o());
        if (this.f17203c != null) {
            if (this.f17201a.isEnabled() || (!isPressed() && isFocused())) {
                z = false;
            }
            this.f17203c.mutate();
            this.f17203c.setAlpha(z ? (int) (this.f17213m * ((float) this.f17215o)) : this.f17215o);
        }
        this.f17218r = false;
        m18870f();
        if (menuItemImpl.mo25647n() != null) {
            setTextColor(menuItemImpl.mo25647n());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f17201a.hasSubMenu() || this.f17205e == null || !this.f17205e.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onClick(View view) {
        if (this.f17204d != null) {
            this.f17204d.mo25523a(this.f17201a);
        }
    }

    public void setItemInvoker(MenuBuilder.C3160b bVar) {
        this.f17204d = bVar;
    }

    public void setPopupCallback(C3158a aVar) {
        this.f17206f = aVar;
    }

    public void setExpandedFormat(boolean z) {
        if (this.f17208h != z) {
            this.f17208h = z;
            if (this.f17201a != null) {
                this.f17201a.mo25623g();
            }
        }
    }

    /* renamed from: f */
    private void m18870f() {
        if (!this.f17218r) {
            boolean z = true;
            boolean z2 = !TextUtils.isEmpty(this.f17202b);
            if (this.f17203c != null && (!this.f17201a.mo25645l() || (!this.f17207g && !this.f17208h))) {
                z = false;
            }
            boolean z3 = z2 & z;
            setText(z3 ? this.f17202b : null);
            m18867a(z3);
            setCompoundDrawables(z3);
            if (!z3 || this.f17203c == null || !this.f17212l) {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
                setGravity(17);
                return;
            }
            setPadding(getPaddingLeft(), getResources().getDimensionPixelSize(R.dimen.mz_action_menu_item_padding_top_icon_with_text), getPaddingRight(), getResources().getDimensionPixelSize(R.dimen.mz_action_menu_item_padding_bottom_icon_with_text));
            setGravity(49);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f17203c = drawable;
        if (drawable != null) {
            ActionMenuItemIconDrawable actionMenuItemIconDrawable = new ActionMenuItemIconDrawable(getContext(), drawable);
            actionMenuItemIconDrawable.mo25496a(this.f17201a.mo25650q());
            this.f17203c = actionMenuItemIconDrawable;
            int intrinsicWidth = actionMenuItemIconDrawable.getIntrinsicWidth();
            int intrinsicHeight = actionMenuItemIconDrawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f17211k) {
                float f = ((float) this.f17211k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f17211k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f17211k) {
                float f2 = ((float) this.f17211k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f17211k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f2);
            }
            actionMenuItemIconDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        m18870f();
    }

    /* renamed from: b */
    public boolean mo25499b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f17202b = charSequence;
        setContentDescription(this.f17202b);
        m18870f();
    }

    /* renamed from: c */
    public boolean mo25500c() {
        return mo25499b() && this.f17201a.getIcon() == null;
    }

    /* renamed from: d */
    public boolean mo25501d() {
        return mo25499b();
    }

    public boolean onLongClick(View view) {
        if (mo25499b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = iArr[0] + (width / 2);
        if (ViewCompat.getLayoutDirection(view) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        Toast makeText = Toast.makeText(context, this.f17201a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, i2, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean b = mo25499b();
        if (b && this.f17210j >= 0) {
            super.setPadding(this.f17210j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f17209i) : this.f17209i;
        if (mode != 1073741824 && this.f17209i > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!b && this.f17203c != null) {
            super.setPadding((getMeasuredWidth() - this.f17203c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    /* renamed from: flyme.support.v7.view.menu.ActionMenuItemView$ActionMenuItemForwardingListener */
    private class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        /* renamed from: a */
        public ListPopupWindow getPopup() {
            if (ActionMenuItemView.this.f17206f != null) {
                return ActionMenuItemView.this.f17206f.mo25521a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStarted() {
            ListPopupWindow a;
            if (ActionMenuItemView.this.f17204d == null || !ActionMenuItemView.this.f17204d.mo25523a(ActionMenuItemView.this.f17201a) || (a = getPopup()) == null || !a.isShowing()) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: a */
    private void m18867a(boolean z) {
        int[] iArr;
        setBackground(getBackground());
        if (this.f17203c != null && z) {
            iArr = this.f17212l ? new int[]{R.attr.mzActionMenuTextAppearanceWithIconSplit} : new int[]{R.attr.mzActionMenuTextAppearanceWithIcon};
        } else if (this.f17212l) {
            iArr = new int[]{R.attr.mzActionMenuTextAppearanceSplit};
            setBackground(this.f17217q);
        } else {
            iArr = new int[]{R.attr.actionMenuTextAppearance};
        }
        int resourceId = getContext().getTheme().obtainStyledAttributes(iArr).getResourceId(0, -1);
        if (resourceId > 0) {
            setTextAppearance(getContext(), resourceId);
        }
    }

    private void setCompoundDrawables(boolean z) {
        setCompoundDrawables(z ? null : this.f17203c, z ? this.f17203c : null, (Drawable) null, (Drawable) null);
    }

    public void setIsInSplit(boolean z) {
        this.f17212l = z;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        float f;
        float f2;
        super.drawableStateChanged();
        if (this.f17201a != null && this.f17203c != null) {
            boolean z = true;
            boolean z2 = !this.f17201a.isEnabled() && (isPressed() || !isFocused());
            this.f17203c.mutate();
            if (!isPressed() || (this.f17203c instanceof DrawableContainer)) {
                z = false;
            }
            Drawable drawable = this.f17203c;
            if (z2) {
                f2 = this.f17213m;
            } else if (z) {
                f2 = this.f17214n;
            } else {
                f = (float) this.f17215o;
                drawable.setAlpha((int) f);
            }
            f = f2 * ((float) this.f17215o);
            drawable.setAlpha((int) f);
        }
    }

    /* renamed from: e */
    public boolean mo25502e() {
        return this.f17216p;
    }

    public void setIsOverflowActor(boolean z) {
        this.f17216p = z;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (getRight() - getLeft() != 0 || getMeasuredWidth() <= 0) {
            super.onDraw(canvas);
        } else {
            getParent().requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }
}
