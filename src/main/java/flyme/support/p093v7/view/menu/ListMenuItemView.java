package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.meizu.common.widget.NewMessageView;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.menu.MenuView;

/* renamed from: flyme.support.v7.view.menu.ListMenuItemView */
public class ListMenuItemView extends LinearLayout implements MenuView.C3168a {

    /* renamed from: a */
    private MenuItemImpl f17223a;

    /* renamed from: b */
    private ImageView f17224b;

    /* renamed from: c */
    private RadioButton f17225c;

    /* renamed from: d */
    private TextView f17226d;

    /* renamed from: e */
    private CheckBox f17227e;

    /* renamed from: f */
    private TextView f17228f;

    /* renamed from: g */
    private Drawable f17229g;

    /* renamed from: h */
    private int f17230h;

    /* renamed from: i */
    private Context f17231i;

    /* renamed from: j */
    private boolean f17232j;

    /* renamed from: k */
    private int f17233k;

    /* renamed from: l */
    private Context f17234l;

    /* renamed from: m */
    private LayoutInflater f17235m;

    /* renamed from: n */
    private boolean f17236n;

    /* renamed from: o */
    private NewMessageView f17237o;

    /* renamed from: a */
    public boolean mo25498a() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f17234l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MenuView, i, 0);
        this.f17229g = obtainStyledAttributes.getDrawable(R.styleable.MenuView_android_itemBackground);
        this.f17230h = obtainStyledAttributes.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f17232j = obtainStyledAttributes.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.f17231i = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f17229g);
        this.f17226d = (TextView) findViewById(R.id.title);
        if (this.f17230h != -1) {
            this.f17226d.setTextAppearance(this.f17231i, this.f17230h);
        }
        this.f17228f = (TextView) findViewById(R.id.shortcut);
        this.f17237o = (NewMessageView) findViewById(R.id.message_point);
    }

    /* renamed from: a */
    public void mo25497a(MenuItemImpl menuItemImpl, int i) {
        this.f17223a = menuItemImpl;
        this.f17233k = i;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.mo25608a((MenuView.C3168a) this));
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.mo25621e(), menuItemImpl.mo25616c());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setLittleSpotVisibility(menuItemImpl.mo25650q());
    }

    private void setLittleSpotVisibility(boolean z) {
        if (this.f17237o != null) {
            this.f17237o.setVisibility(z ? 0 : 8);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.f17236n = z;
        this.f17232j = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f17226d.setText(charSequence);
            if (this.f17226d.getVisibility() != 0) {
                this.f17226d.setVisibility(0);
            }
        } else if (this.f17226d.getVisibility() != 8) {
            this.f17226d.setVisibility(8);
        }
    }

    public MenuItemImpl getItemData() {
        return this.f17223a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f17225c != null || this.f17227e != null) {
            if (this.f17223a.mo25622f()) {
                if (this.f17225c == null) {
                    m18882c();
                }
                compoundButton2 = this.f17225c;
                compoundButton = this.f17227e;
            } else {
                if (this.f17227e == null) {
                    m18883d();
                }
                compoundButton2 = this.f17227e;
                compoundButton = this.f17225c;
            }
            if (z) {
                compoundButton2.setChecked(this.f17223a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton2.getVisibility() != i) {
                    compoundButton2.setVisibility(i);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f17227e != null) {
                this.f17227e.setVisibility(8);
            }
            if (this.f17225c != null) {
                this.f17225c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f17223a.mo25622f()) {
            if (this.f17225c == null) {
                m18882c();
            }
            compoundButton = this.f17225c;
        } else {
            if (this.f17227e == null) {
                m18883d();
            }
            compoundButton = this.f17227e;
        }
        compoundButton.setChecked(z);
    }

    public void setShortcut(boolean z, char c) {
        int i = (!z || !this.f17223a.mo25621e()) ? 8 : 0;
        if (i == 0) {
            this.f17228f.setText(this.f17223a.mo25618d());
        }
        if (this.f17228f.getVisibility() != i) {
            this.f17228f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f17223a.mo25636h() || this.f17236n;
        if (!z && !this.f17232j) {
            return;
        }
        if (this.f17224b != null || drawable != null || this.f17232j) {
            if (this.f17224b == null) {
                m18881b();
            }
            if (drawable != null || this.f17232j) {
                ImageView imageView = this.f17224b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f17224b.getVisibility() != 0) {
                    this.f17224b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f17224b.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f17224b != null && this.f17232j) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f17224b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: b */
    private void m18881b() {
        this.f17224b = (ImageView) getInflater().inflate(R.layout.mz_list_menu_item_icon, this, false);
        addView(this.f17224b, 0);
    }

    /* renamed from: c */
    private void m18882c() {
        this.f17225c = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        addView(this.f17225c);
    }

    /* renamed from: d */
    private void m18883d() {
        this.f17227e = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        addView(this.f17227e);
    }

    private LayoutInflater getInflater() {
        if (this.f17235m == null) {
            this.f17235m = LayoutInflater.from(this.f17234l);
        }
        return this.f17235m;
    }
}
