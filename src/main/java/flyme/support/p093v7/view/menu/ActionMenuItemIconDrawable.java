package flyme.support.p093v7.view.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.internal.view.SupportMenu;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.view.menu.ActionMenuItemIconDrawable */
public class ActionMenuItemIconDrawable extends DrawableWrapper {

    /* renamed from: a */
    private final float f17196a;

    /* renamed from: b */
    private final int f17197b = SupportMenu.CATEGORY_MASK;

    /* renamed from: c */
    private final Paint f17198c;

    /* renamed from: d */
    private boolean f17199d;

    public ActionMenuItemIconDrawable(Context context, Drawable drawable) {
        super(drawable);
        this.f17196a = context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
        this.f17198c = new Paint();
        this.f17198c.setAntiAlias(true);
        this.f17198c.setColor(SupportMenu.CATEGORY_MASK);
        this.f17198c.setStyle(Paint.Style.FILL);
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.f17199d) {
            Rect bounds = super.getBounds();
            canvas.drawCircle(((float) bounds.right) - this.f17196a, ((float) bounds.top) + this.f17196a, this.f17196a, this.f17198c);
        }
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f17198c.setAlpha(i);
    }

    /* renamed from: a */
    public void mo25496a(boolean z) {
        this.f17199d = z;
    }
}
