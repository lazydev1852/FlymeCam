package com.meizu.common.fastscrollletter;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.widget.PinnedHeaderIndexerListAdapter;

/* renamed from: com.meizu.common.fastscrollletter.a */
public class FastScrollLetterListViewAdapter extends PinnedHeaderIndexerListAdapter {

    /* renamed from: h */
    private Context f4271h;

    /* renamed from: i */
    private String[] f4272i;

    /* renamed from: j */
    private boolean f4273j;

    /* renamed from: k */
    private LayoutInflater f4274k;

    /* renamed from: l */
    private NavigationLayout f4275l;

    /* renamed from: m */
    private int f4276m;

    /* renamed from: n */
    private boolean f4277n;

    /* renamed from: o */
    private C1307a f4278o;

    /* renamed from: com.meizu.common.fastscrollletter.a$a */
    /* compiled from: FastScrollLetterListViewAdapter */
    public interface C1307a {
        /* renamed from: a */
        View mo15863a(Context context, int i, int i2, Cursor cursor, int i3, int i4, ViewGroup viewGroup);

        /* renamed from: a */
        View mo15864a(Context context, int i, int i2, ViewGroup viewGroup);

        /* renamed from: a */
        View mo15865a(Context context, ViewGroup viewGroup);

        /* renamed from: a */
        void mo15866a(View view, int i, String str);

        /* renamed from: a */
        void mo15867a(View view, Context context, int i, int i2, Cursor cursor, int i3, int i4);

        /* renamed from: a */
        void mo15868a(View view, Context context, int i, int i2, String str);

        /* renamed from: a */
        void mo15869a(ListView listView, int i, int i2, boolean z);
    }

    /* renamed from: a */
    public void mo15861a(boolean z) {
        this.f4273j = z;
        if (z) {
            mo17577c(true);
            mo17578d(true);
            mo17047e(true);
            return;
        }
        mo17577c(false);
        mo17578d(false);
        mo17047e(false);
    }

    /* renamed from: b */
    public void mo15862b(boolean z) {
        this.f4277n = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo15854a(Context context, int i, int i2, ViewGroup viewGroup) {
        View a = this.f4278o.mo15864a(context, i, i2, viewGroup);
        if (a != null) {
            return a;
        }
        this.f4274k = LayoutInflater.from(context);
        return this.f4274k.inflate(R.layout.mc_list_category_contact_partition_header, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15857a(View view, Context context, int i, int i2) {
        m4947b(view, i2);
        this.f4278o.mo15868a(view, context, i, i2, this.f4272i[i2]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo15855a(Context context, ViewGroup viewGroup) {
        View a = this.f4278o.mo15865a(context, viewGroup);
        return a == null ? this.f4274k.inflate(R.layout.mc_list_category_contact_partition_header, viewGroup, false) : a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15856a(View view, int i) {
        m4947b(view, i);
        this.f4278o.mo15866a(view, i, this.f4272i[i]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo15853a(Context context, int i, int i2, Cursor cursor, int i3, int i4, ViewGroup viewGroup) {
        return this.f4278o.mo15863a(context, i, i2, cursor, i3, i4, viewGroup);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15858a(View view, Context context, int i, int i2, Cursor cursor, int i3, int i4) {
        if (this.f4277n) {
            View view2 = view;
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), this.f4276m, view.getPaddingBottom());
        } else {
            View view3 = view;
        }
        this.f4278o.mo15867a(view, context, i, i2, cursor, i3, i4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15859a(ListView listView, int i, int i2, boolean z) {
        this.f4278o.mo15869a(listView, i, i2, z);
    }

    @TargetApi(16)
    /* renamed from: b */
    private void m4947b(View view, int i) {
        TextView textView = (TextView) view.findViewById(R.id.mc_list_category_partition_contact_text1);
        if (textView != null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(this.f4271h.getResources().getColor(this.f4275l.getOverlayLetterColors().get(this.f4272i[i]).intValue()));
            textView.setBackground(shapeDrawable);
            textView.setText(this.f4272i[i]);
        }
    }

    /* renamed from: a */
    public void mo15860a(C1307a aVar) {
        this.f4278o = aVar;
    }
}
