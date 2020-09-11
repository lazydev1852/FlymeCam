package flyme.support.p093v7.view;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.p095b.PermissionGroup;
import flyme.support.p093v7.p095b.PermissionManager;
import flyme.support.p093v7.view.PermissionDialogView;
import java.util.Collections;
import java.util.List;

/* renamed from: flyme.support.v7.view.d */
public class PermissionViewHandlerImpl implements PermissionViewHandler {

    /* renamed from: a */
    private Context f17105a;

    /* renamed from: b */
    private TextView f17106b;

    /* renamed from: c */
    private CheckBox f17107c;

    /* renamed from: d */
    private PermissionManager f17108d;

    public PermissionViewHandlerImpl(Context context) {
        this.f17105a = context;
        this.f17108d = PermissionManager.m18704a(context);
    }

    /* renamed from: a */
    public View mo25427a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f17105a).inflate(R.layout.mz_permission_dialog_simple, viewGroup, false);
        this.f17106b = (TextView) inflate.findViewById(R.id.mz_permission_dialog_message);
        this.f17107c = (CheckBox) inflate.findViewById(R.id.mz_permission_dialog_terms);
        return inflate;
    }

    /* renamed from: a */
    public void mo25429a(PermissionDialogView.C3150a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17095f)) {
            str = aVar.f17095f;
        } else if (aVar.f17092c == null || aVar.f17092c.length == 0) {
            throw new IllegalStateException("message and permissions both null");
        } else {
            try {
                StringBuilder sb = new StringBuilder();
                for (String a : aVar.f17092c) {
                    String a2 = this.f17108d.mo25381a(this.f17105a, a);
                    if (!TextUtils.isEmpty(a2)) {
                        sb.append(a2);
                        sb.append("、");
                    }
                }
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - "、".length());
                }
                str = String.format(this.f17105a.getResources().getString(R.string.mz_permission_message_supplement), new Object[]{aVar.f17090a, sb.toString(), Integer.valueOf(aVar.f17092c.length)});
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
        }
        this.f17106b.setText(str);
        if (m18800a(this.f17106b)) {
            this.f17106b.setGravity(17);
        }
        if (aVar.f17099j) {
            this.f17107c.setVisibility(0);
        } else {
            this.f17107c.setVisibility(8);
        }
    }

    /* renamed from: a */
    public CheckBox mo25428a() {
        return new CheckBox(this.f17105a);
    }

    /* renamed from: b */
    public CheckBox mo25430b() {
        return this.f17107c;
    }

    /* renamed from: c */
    public List<PermissionGroup> mo25431c() {
        return Collections.emptyList();
    }

    /* renamed from: a */
    private boolean m18800a(TextView textView) {
        ViewGroup viewGroup = (ViewGroup) textView.getParent().getParent();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        return (m18799a(textView, textView.getText().toString()) + (((textView.getPaddingLeft() + textView.getPaddingRight()) + viewGroup.getPaddingLeft()) + viewGroup.getPaddingRight())) + (((marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) <= this.f17105a.getResources().getDimensionPixelOffset(R.dimen.mz_alert_dialog_width);
    }

    /* renamed from: a */
    private int m18799a(TextView textView, String str) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, textView).toString();
        }
        return (int) textView.getPaint().measureText(str);
    }
}
