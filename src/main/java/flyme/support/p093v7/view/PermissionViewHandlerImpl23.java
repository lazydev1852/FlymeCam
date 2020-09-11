package flyme.support.p093v7.view;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.p095b.Permission;
import flyme.support.p093v7.p095b.PermissionGroup;
import flyme.support.p093v7.p095b.PermissionManager;
import flyme.support.p093v7.util.DensityUtils;
import flyme.support.p093v7.view.PermissionDialogView;
import flyme.support.p093v7.widget.PermissionScrollView;
import java.util.List;

/* renamed from: flyme.support.v7.view.e */
public class PermissionViewHandlerImpl23 implements PermissionViewHandler {

    /* renamed from: a */
    private Context f17109a;

    /* renamed from: b */
    private TextView f17110b;

    /* renamed from: c */
    private Space f17111c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f17112d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PermissionScrollView f17113e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f17114f;

    /* renamed from: g */
    private LinearLayout f17115g;

    /* renamed from: h */
    private CheckBox f17116h;

    /* renamed from: i */
    private CheckBox f17117i;

    /* renamed from: j */
    private List<PermissionGroup> f17118j;

    /* renamed from: k */
    private PermissionManager f17119k;

    /* renamed from: l */
    private LayoutInflater f17120l;

    /* renamed from: m */
    private int f17121m = this.f17109a.getResources().getColor(R.color.mz_alert_dialog_title_color_dark);

    /* renamed from: n */
    private int f17122n = this.f17109a.getResources().getColor(R.color.mz_permission_dialog_item_title_dark);

    /* renamed from: o */
    private int f17123o = this.f17109a.getResources().getColor(R.color.mz_permission_dialog_item_summary_dark);

    public PermissionViewHandlerImpl23(Context context) {
        this.f17109a = context;
        this.f17119k = PermissionManager.m18704a(context);
        this.f17120l = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public View mo25427a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f17109a).inflate(R.layout.mz_permission_dialog, viewGroup, false);
        this.f17110b = (TextView) inflate.findViewById(R.id.mz_permission_dialog_title);
        this.f17111c = (Space) inflate.findViewById(R.id.mz_permission_dialog_space);
        this.f17111c.getLayoutParams().height = DensityUtils.m18712a(24.0f);
        this.f17112d = inflate.findViewById(R.id.mz_permission_dialog_scroll_indicator_up);
        this.f17113e = (PermissionScrollView) inflate.findViewById(R.id.mz_permission_dialog_scroll_view);
        this.f17114f = inflate.findViewById(R.id.mz_permission_dialog_scroll_indicator_down);
        this.f17115g = (LinearLayout) inflate.findViewById(R.id.mz_permission_dialog_content_layout);
        this.f17116h = (CheckBox) inflate.findViewById(R.id.mz_permission_dialog_checkbox);
        this.f17117i = (CheckBox) inflate.findViewById(R.id.mz_permission_dialog_terms);
        return inflate;
    }

    /* renamed from: a */
    public void mo25429a(PermissionDialogView.C3150a aVar) {
        this.f17118j = this.f17119k.mo25382a(aVar.f17092c, aVar.f17093d, aVar.f17094e);
        if (aVar.f17097h) {
            this.f17110b.setText(aVar.f17090a);
            if (aVar.f17096g) {
                this.f17110b.setTextColor(this.f17121m);
            }
            if (m18811a(this.f17110b)) {
                this.f17110b.setGravity(17);
            }
        } else {
            this.f17110b.setVisibility(8);
        }
        this.f17115g.removeAllViews();
        for (int i = 0; i < this.f17118j.size(); i++) {
            PermissionGroup dVar = this.f17118j.get(i);
            String a = dVar.mo25374a(this.f17109a);
            StringBuilder sb = new StringBuilder();
            for (Permission a2 : dVar.mo25375a()) {
                String a3 = a2.mo25369a(this.f17109a);
                if (!TextUtils.isEmpty(a3)) {
                    sb.append(a3);
                    sb.append(",  ");
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - ",  ".length());
            }
            m18809a((ViewGroup) this.f17115g, a, sb.toString(), aVar.f17096g);
        }
        if (aVar.f17098i != null) {
            for (Pair next : aVar.f17098i) {
                m18809a((ViewGroup) this.f17115g, (String) next.first, (String) next.second, aVar.f17096g);
            }
        }
        this.f17113e.setOnScrollChangeListener(new PermissionScrollView.C3245a() {
            /* renamed from: a */
            public void mo25432a(View view, int i, int i2, int i3, int i4) {
                PermissionViewHandlerImpl23.this.m18808a(view, PermissionViewHandlerImpl23.this.f17112d, PermissionViewHandlerImpl23.this.f17114f);
            }
        });
        this.f17113e.post(new Runnable() {
            public void run() {
                PermissionViewHandlerImpl23.this.m18808a(PermissionViewHandlerImpl23.this.f17113e, PermissionViewHandlerImpl23.this.f17112d, PermissionViewHandlerImpl23.this.f17114f);
            }
        });
        if (aVar.f17091b) {
            this.f17116h.setVisibility(0);
        } else {
            this.f17116h.setVisibility(8);
        }
        if (aVar.f17099j) {
            this.f17117i.setVisibility(0);
        } else {
            this.f17117i.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m18809a(ViewGroup viewGroup, String str, String str2, boolean z) {
        if (viewGroup.getChildCount() != 0) {
            viewGroup.addView(new Space(this.f17109a), new LinearLayout.LayoutParams(-1, DensityUtils.m18713a(this.f17109a, 20.0d)));
        }
        View inflate = this.f17120l.inflate(R.layout.mz_permission_dialog_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.mz_permission_dialog_item_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mz_permission_dialog_item_summary);
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        if (z) {
            textView.setTextColor(this.f17122n);
            textView2.setTextColor(this.f17123o);
        }
        viewGroup.addView(inflate);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18808a(View view, View view2, View view3) {
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

    /* renamed from: a */
    public CheckBox mo25428a() {
        return this.f17116h;
    }

    /* renamed from: b */
    public CheckBox mo25430b() {
        return this.f17117i;
    }

    /* renamed from: c */
    public List<PermissionGroup> mo25431c() {
        return this.f17118j;
    }

    /* renamed from: a */
    private boolean m18811a(TextView textView) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        return (m18806a(textView, textView.getText().toString()) + (textView.getPaddingLeft() + textView.getPaddingRight())) + (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) <= this.f17109a.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_width);
    }

    /* renamed from: a */
    private int m18806a(TextView textView, String str) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, textView).toString();
        }
        return (int) textView.getPaint().measureText(str);
    }
}
