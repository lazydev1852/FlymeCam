package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import com.meizu.common.util.ReflectUtils;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.menu.MenuBuilder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: flyme.support.v7.widget.OptionPopupWindow */
public class OptionPopupWindow extends PopupWindow implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    static Object f17814a = null;

    /* renamed from: b */
    static Class f17815b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final int[][] f17816c = new int[2][];

    /* renamed from: h */
    private static Method f17817h = null;

    /* renamed from: i */
    private static Method f17818i = null;

    /* renamed from: l */
    private static Bitmap[] f17819l;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C3236a f17820d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f17821e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<ArrayList<C3237b>> f17822f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f17823g;

    /* renamed from: j */
    private PopupWindow.OnDismissListener f17824j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f17825k;

    static {
        f17816c[0] = new int[]{16842921};
        f17816c[1] = new int[]{16842919};
    }

    /* renamed from: flyme.support.v7.widget.OptionPopupWindow$HandleView */
    private class HandleView extends View {

        /* renamed from: A */
        private int f17826A;

        /* renamed from: B */
        private int f17827B;

        /* renamed from: C */
        private final int f17828C;

        /* renamed from: D */
        private final int f17829D;

        /* renamed from: E */
        private int f17830E;

        /* renamed from: F */
        private float f17831F;

        /* renamed from: G */
        private final Runnable f17832G;

        /* renamed from: a */
        boolean f17833a;

        /* renamed from: b */
        int f17834b;

        /* renamed from: c */
        int f17835c;

        /* renamed from: d */
        final /* synthetic */ OptionPopupWindow f17836d;

        /* renamed from: e */
        private final int f17837e;

        /* renamed from: f */
        private final int f17838f;

        /* renamed from: g */
        private final int f17839g;

        /* renamed from: h */
        private Drawable f17840h;

        /* renamed from: i */
        private Drawable f17841i;

        /* renamed from: j */
        private Drawable f17842j;

        /* renamed from: k */
        private Drawable f17843k;

        /* renamed from: l */
        private Drawable f17844l;

        /* renamed from: m */
        private Drawable f17845m;

        /* renamed from: n */
        private int f17846n;

        /* renamed from: o */
        private int f17847o;

        /* renamed from: p */
        private int f17848p;

        /* renamed from: q */
        private boolean f17849q;

        /* renamed from: r */
        private final int f17850r;

        /* renamed from: s */
        private TextPaint f17851s;

        /* renamed from: t */
        private Paint.FontMetricsInt f17852t;

        /* renamed from: u */
        private Paint f17853u;

        /* renamed from: v */
        private final int f17854v;

        /* renamed from: w */
        private final int f17855w;

        /* renamed from: x */
        private Rect f17856x;

        /* renamed from: y */
        private int[] f17857y;

        /* renamed from: z */
        private int f17858z;

        private int getMaxWidth() {
            Resources resources = getResources();
            if (resources == null) {
                return 0;
            }
            return resources.getDisplayMetrics().widthPixels;
        }

        public void setArrowUp(boolean z) {
            if (this.f17849q != z) {
                this.f17849q = z;
                if (this.f17836d.isShowing()) {
                    postInvalidate();
                }
            }
        }

        public int getContentWidth() {
            return this.f17858z;
        }

        public void setOffsetX(int i) {
            if (this.f17826A != i) {
                this.f17826A = i;
                onMeasure(0, 0);
            }
        }

        /* renamed from: a */
        private int m19506a(MenuItem menuItem) {
            if (TextUtils.isEmpty(menuItem.getTitle())) {
                Drawable icon = menuItem.getIcon();
                if (icon != null) {
                    return icon.getIntrinsicWidth();
                }
                return 0;
            }
            CharSequence title = menuItem.getTitle();
            return (int) this.f17851s.measureText(title, 0, title.length());
        }

        public void onMeasure(int i, int i2) {
            if (this.f17836d.f17820d == null) {
                setMeasuredDimension(0, 0);
                return;
            }
            int i3 = this.f17856x.left;
            int i4 = this.f17856x.left + this.f17856x.right;
            Menu menu = this.f17836d.f17820d.getMenu();
            int size = menu.size();
            int i5 = 1;
            boolean z = Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1;
            if (this.f17836d.f17822f.size() == 0) {
                ArrayList arrayList = new ArrayList();
                int i6 = i3;
                int i7 = 0;
                while (i7 < size) {
                    int i8 = z ? (size - i7) - i5 : i7;
                    int a = m19506a(menu.getItem(i8)) + (this.f17839g * 2);
                    int i9 = this.f17834b != 0 ? this.f17834b : this.f17838f;
                    int i10 = this.f17835c != 0 ? this.f17835c : this.f17837e;
                    if (a >= i10) {
                        i10 = a;
                    }
                    if (i10 > i9) {
                        i10 = i9;
                    }
                    int i11 = i6 + i10;
                    arrayList.add(new C3237b(new Rect(i6, 0, i11, this.f17855w), menu.getItem(i8), i10));
                    i7++;
                    i6 = i11;
                    i5 = 1;
                }
                if (arrayList.size() > 0) {
                    m19509a((ArrayList<C3237b>) arrayList);
                }
            }
            if (this.f17836d.f17822f.size() > 0 && this.f17836d.f17823g < this.f17836d.f17822f.size()) {
                Iterator it = ((ArrayList) this.f17836d.f17822f.get(this.f17836d.f17823g)).iterator();
                while (it.hasNext()) {
                    i4 += ((C3237b) it.next()).f17864c;
                }
            }
            this.f17858z = Math.max(i4, this.f17854v);
            setMeasuredDimension(this.f17858z, this.f17855w);
        }

        /* renamed from: a */
        private void m19509a(ArrayList<C3237b> arrayList) {
            int i;
            int i2;
            ArrayList<C3237b> arrayList2 = arrayList;
            if (arrayList2 != null) {
                int maxWidth = getMaxWidth();
                int i3 = this.f17827B + this.f17856x.left + this.f17856x.right;
                ArrayList arrayList3 = new ArrayList();
                int i4 = 0;
                int i5 = i3;
                int i6 = 0;
                boolean z = false;
                int i7 = 0;
                while (i6 < arrayList.size()) {
                    C3237b bVar = arrayList2.get(i6);
                    if (z) {
                        i5 += this.f17827B;
                    }
                    if (bVar.f17864c + i5 <= maxWidth || ((i5 - this.f17827B) + bVar.f17864c < maxWidth && i6 == arrayList.size() - 1)) {
                        i5 += bVar.f17864c;
                        i7++;
                        z = false;
                    } else {
                        i6--;
                        int i8 = this.f17827B + this.f17856x.left + this.f17856x.right;
                        arrayList3.add(new C3238c(i7));
                        i5 = i8;
                        z = true;
                        i7 = 0;
                    }
                    i6++;
                }
                arrayList3.add(new C3238c(i7));
                int i9 = ((C3238c) arrayList3.get(0)).f17870a;
                int i10 = this.f17856x.left;
                ArrayList arrayList4 = new ArrayList();
                int i11 = i9;
                int i12 = i10;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                while (i13 < arrayList.size()) {
                    C3237b bVar2 = arrayList2.get(i13);
                    if (i14 != 0) {
                        if (i15 == 0) {
                            C3237b bVar3 = new C3237b(new Rect(i12, i4, this.f17827B + i12, this.f17855w), (MenuItem) null, this.f17827B);
                            bVar3.f17865d = true;
                            bVar3.f17868g = this.f17829D;
                            arrayList4.add(bVar3);
                            i12 += this.f17827B;
                        }
                        Rect rect = bVar2.f17862a;
                        rect.left = i12;
                        rect.right = i12 + bVar2.f17864c;
                        i = rect.right;
                        arrayList4.add(bVar2);
                        i15++;
                    } else {
                        arrayList4.add(bVar2);
                        i = bVar2.f17864c + i12;
                        i15++;
                    }
                    if (i15 == i11 && arrayList3.size() > 1 && (i2 = i14 + 1) < arrayList3.size()) {
                        C3237b bVar4 = new C3237b(new Rect(i, 0, this.f17827B + i, this.f17855w), (MenuItem) null, this.f17827B);
                        bVar4.f17866e = true;
                        bVar4.f17868g = this.f17828C;
                        arrayList4.add(bVar4);
                        this.f17836d.f17822f.add(arrayList4);
                        ArrayList arrayList5 = new ArrayList();
                        i = this.f17856x.left;
                        i11 = ((C3238c) arrayList3.get(i2)).f17870a;
                        i15 = 0;
                        arrayList4 = arrayList5;
                        i14 = i2;
                    }
                    i12 = i;
                    i13++;
                    i4 = 0;
                }
                this.f17836d.f17822f.add(arrayList4);
            }
        }

        private Bitmap[] getBackgrounds() {
            Canvas canvas = new Canvas();
            try {
                ReflectUtils.m5142a((Object) canvas).mo16008a("setNightModeUseOf", Integer.TYPE).mo16011a(canvas, 2);
            } catch (Exception unused) {
            }
            int measuredHeight = getMeasuredHeight();
            int i = this.f17846n;
            int intrinsicWidth = this.f17846n + this.f17842j.getIntrinsicWidth();
            Bitmap[] a = OptionPopupWindow.m19501b(2, this.f17858z, this.f17855w);
            int i2 = 0;
            for (int i3 = 2; i2 < i3; i3 = 2) {
                int[] iArr = OptionPopupWindow.f17816c[i2];
                Bitmap bitmap = a[i2];
                bitmap.eraseColor(0);
                canvas.setBitmap(bitmap);
                this.f17840h.setState(iArr);
                this.f17840h.setBounds(0, 0, i, measuredHeight);
                this.f17840h.draw(canvas);
                this.f17842j.setState(iArr);
                this.f17842j.setBounds(i, 0, intrinsicWidth, measuredHeight);
                this.f17842j.draw(canvas);
                this.f17841i.setState(iArr);
                this.f17841i.setBounds(intrinsicWidth, 0, this.f17858z, measuredHeight);
                this.f17841i.draw(canvas);
                if (this.f17849q) {
                    if (this.f17857y == null || this.f17857y.length < this.f17858z * 2) {
                        this.f17857y = new int[(this.f17858z * 2)];
                    }
                    int i4 = measuredHeight >> 1;
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = (measuredHeight - i5) - 1;
                        int i7 = i5;
                        Bitmap bitmap2 = bitmap;
                        bitmap.getPixels(this.f17857y, 0, this.f17858z, 0, i7, this.f17858z, 1);
                        Bitmap bitmap3 = bitmap2;
                        bitmap3.getPixels(this.f17857y, this.f17858z, this.f17858z, 0, i6, this.f17858z, 1);
                        bitmap3.setPixels(this.f17857y, this.f17858z, this.f17858z, 0, i7, this.f17858z, 1);
                        bitmap3.setPixels(this.f17857y, 0, this.f17858z, 0, i6, this.f17858z, 1);
                        i5 = i7 + 1;
                        bitmap = bitmap2;
                    }
                }
                i2++;
            }
            return a;
        }

        /* renamed from: a */
        private boolean m19510a(ArrayList<C3237b> arrayList, int i) {
            if (this.f17836d.f17825k) {
                return i > 0;
            }
            if (i <= 0 || i >= arrayList.size()) {
                return false;
            }
            C3237b bVar = arrayList.get(i - 1);
            C3237b bVar2 = arrayList.get(i);
            if (bVar.f17865d || bVar2.f17866e) {
                return true;
            }
            if (bVar.f17863b.getGroupId() != bVar2.f17863b.getGroupId()) {
                return true;
            }
            return false;
        }

        public void onDraw(Canvas canvas) {
            int i;
            Canvas canvas2 = canvas;
            if (this.f17836d.f17820d != null) {
                int i2 = 0;
                try {
                    ReflectUtils.C1342f a = ReflectUtils.m5142a((Object) canvas);
                    i = ((Integer) a.mo16008a("getNightModeUseOf", new Class[0]).mo16011a(canvas2, new Object[0])).intValue();
                    try {
                        a.mo16008a("setNightModeUseOf", Integer.TYPE).mo16011a(canvas2, 3);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i = -1;
                }
                int i3 = i;
                this.f17836d.f17820d.getMenu();
                Bitmap[] backgrounds = getBackgrounds();
                if (this.f17836d.f17823g >= this.f17836d.f17822f.size()) {
                    try {
                        ReflectUtils.m5142a((Object) canvas).mo16008a("setNightModeUseOf", Integer.TYPE).mo16011a(canvas2, Integer.valueOf(i3));
                    } catch (Exception unused3) {
                    }
                } else {
                    ArrayList arrayList = (ArrayList) this.f17836d.f17822f.get(this.f17836d.f17823g);
                    int size = arrayList.size();
                    new Rect();
                    if (this.f17826A != 0) {
                        canvas2.translate((float) this.f17826A, 0.0f);
                    }
                    int i4 = 0;
                    while (i4 < size) {
                        C3237b bVar = (C3237b) arrayList.get(i4);
                        Rect rect = bVar.f17862a;
                        if (i4 == 0) {
                            rect.left = i2;
                        }
                        int i5 = size - 1;
                        if (i4 == i5) {
                            rect.right = this.f17858z;
                        }
                        char c = (this.f17847o == i4 && this.f17848p == i4) ? (char) 1 : 0;
                        canvas2.drawBitmap(backgrounds[c], rect, rect, this.f17853u);
                        if (!(c == 0 || bVar.f17863b == null || Build.VERSION.SDK_INT <= 16)) {
                            announceForAccessibility(bVar.f17863b.getTitle());
                        }
                        if (m19510a((ArrayList<C3237b>) arrayList, i4)) {
                            int intrinsicWidth = this.f17843k.getIntrinsicWidth();
                            int intrinsicHeight = this.f17843k.getIntrinsicHeight();
                            int i6 = rect.left - (intrinsicWidth / 2);
                            int height = ((((rect.height() - this.f17856x.top) - this.f17856x.bottom) - intrinsicHeight) / 2) + (this.f17849q ? this.f17856x.bottom : this.f17856x.top);
                            this.f17843k.setBounds(i6, height, intrinsicWidth + i6, intrinsicHeight + height);
                            this.f17843k.draw(canvas2);
                        }
                        m19508a(canvas, bVar, i4 == 0 ? rect.left + this.f17856x.left : rect.left, this.f17849q ? this.f17856x.bottom : this.f17856x.top, i4 == i5 ? rect.right - this.f17856x.right : rect.right, getHeight() - (this.f17849q ? this.f17856x.top : this.f17856x.bottom));
                        i4++;
                        i2 = 0;
                    }
                    if (this.f17826A != 0) {
                        canvas2.translate((float) (-this.f17826A), 0.0f);
                    }
                    try {
                        ReflectUtils.m5142a((Object) canvas).mo16008a("setNightModeUseOf", Integer.TYPE).mo16011a(canvas2, Integer.valueOf(i3));
                    } catch (Exception unused4) {
                    }
                }
            }
        }

        /* renamed from: a */
        private void m19508a(Canvas canvas, C3237b bVar, int i, int i2, int i3, int i4) {
            Drawable drawable;
            if (bVar.f17866e || bVar.f17865d) {
                if (bVar.f17866e) {
                    drawable = this.f17845m;
                } else {
                    drawable = this.f17844l;
                }
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int dimensionPixelSize = i + this.f17836d.f17821e.getResources().getDimensionPixelSize(R.dimen.option_popup_navigation_menu_padding);
                int i5 = ((i2 + i4) - intrinsicHeight) / 2;
                drawable.setBounds(dimensionPixelSize, i5, intrinsicWidth + dimensionPixelSize, intrinsicHeight + i5);
                drawable.draw(canvas);
                return;
            }
            MenuItem menuItem = bVar.f17863b;
            CharSequence title = menuItem.getTitle();
            if (TextUtils.isEmpty(title)) {
                Drawable icon = menuItem.getIcon();
                if (icon != null) {
                    int i6 = this.f17830E;
                    int i7 = this.f17830E;
                    int i8 = ((i + i3) - i6) / 2;
                    int i9 = ((i2 + i4) - i7) / 2;
                    icon.setBounds(i8, i9, i6 + i8, i7 + i9);
                    icon.draw(canvas);
                    return;
                }
                return;
            }
            String charSequence = title.toString();
            float f = (float) ((i3 - i) - (this.f17839g * 2));
            float measureText = this.f17851s.measureText(charSequence);
            if (measureText > f) {
                charSequence = m19507a(charSequence, f);
                measureText = this.f17851s.measureText(charSequence);
            }
            canvas.drawText(charSequence, (((float) (i + i3)) - measureText) / 2.0f, (((float) ((i4 + i2) - (this.f17852t.bottom - this.f17852t.top))) / 2.0f) - ((float) this.f17852t.top), this.f17851s);
        }

        /* renamed from: a */
        private int m19505a(float f, float f2) {
            int i = this.f17847o;
            if (this.f17836d.f17823g > this.f17836d.f17822f.size() - 1) {
                return -1;
            }
            ArrayList arrayList = (ArrayList) this.f17836d.f17822f.get(this.f17836d.f17823g);
            int size = arrayList.size();
            if (i >= 0 && i < size) {
                Rect rect = ((C3237b) arrayList.get(i)).f17862a;
                if (f >= ((float) (rect.left - this.f17850r)) && f < ((float) (rect.right + this.f17850r)) && f2 >= ((float) ((rect.top - this.f17850r) + this.f17856x.top)) && f2 < ((float) ((rect.bottom + this.f17850r) - this.f17856x.bottom))) {
                    return i;
                }
            }
            int i2 = 0;
            while (i2 < size) {
                Rect rect2 = ((C3237b) arrayList.get(i2)).f17862a;
                int i3 = i2 == 0 ? rect2.left + this.f17856x.left : rect2.left;
                int i4 = size + -1 == i2 ? rect2.right - this.f17856x.right : rect2.right;
                if (f >= ((float) i3) && f < ((float) i4) && f2 >= ((float) (rect2.top + this.f17856x.top)) && f2 < ((float) (rect2.bottom - this.f17856x.bottom))) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
                int action = motionEvent.getAction();
                if (action != 7) {
                    switch (action) {
                        case 9:
                            motionEvent.setAction(0);
                            break;
                        case 10:
                            motionEvent.setAction(1);
                            break;
                    }
                } else {
                    motionEvent.setAction(2);
                }
                onTouchEvent(motionEvent);
                motionEvent.setAction(action);
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!this.f17833a) {
                return true;
            }
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.f17847o = m19505a(motionEvent.getX(), motionEvent.getY());
                    this.f17848p = this.f17847o;
                    if (this.f17847o >= 0) {
                        invalidate();
                        break;
                    }
                    break;
                case 1:
                    if (this.f17847o >= 0) {
                        post(this.f17832G);
                        invalidate();
                    }
                    this.f17847o = -1;
                    break;
                case 2:
                    int a = m19505a(motionEvent.getX(), motionEvent.getY());
                    if (this.f17847o != a) {
                        if (this.f17847o >= 0 || a >= 0) {
                            invalidate();
                        }
                        this.f17847o = a;
                        this.f17848p = this.f17847o;
                        break;
                    }
                    break;
                case 3:
                    this.f17847o = -1;
                    break;
            }
            return true;
        }

        /* renamed from: a */
        private String m19507a(String str, float f) {
            int length = str.length();
            if (length <= 1) {
                return str;
            }
            do {
                length--;
                if (this.f17851s.measureText(str, 0, length) + this.f17831F <= f) {
                    break;
                }
            } while (1 < length);
            return str.substring(0, length) + "‥";
        }
    }

    /* renamed from: flyme.support.v7.widget.OptionPopupWindow$a */
    private class C3236a extends ActionMode implements MenuBuilder.C3159a {

        /* renamed from: a */
        final /* synthetic */ OptionPopupWindow f17859a;

        /* renamed from: b */
        private ActionMode.Callback f17860b;

        /* renamed from: c */
        private MenuBuilder f17861c;

        /* renamed from: a */
        public void mo25219a(MenuBuilder menuBuilder) {
        }

        public View getCustomView() {
            return null;
        }

        public CharSequence getSubtitle() {
            return null;
        }

        public CharSequence getTitle() {
            return null;
        }

        public void setCustomView(View view) {
        }

        public void setSubtitle(int i) {
        }

        public void setSubtitle(CharSequence charSequence) {
        }

        public void setTitle(int i) {
        }

        public void setTitle(CharSequence charSequence) {
        }

        public void invalidate() {
            this.f17861c.mo25581g();
            try {
                this.f17860b.onPrepareActionMode(this, this.f17861c);
            } finally {
                this.f17861c.mo25583h();
            }
        }

        public void finish() {
            if (this.f17859a.f17820d == this) {
                this.f17859a.dismiss();
                this.f17860b.onDestroyActionMode(this);
                this.f17860b = null;
                C3236a unused = this.f17859a.f17820d = null;
            }
        }

        public Menu getMenu() {
            return this.f17861c;
        }

        public MenuInflater getMenuInflater() {
            return new MenuInflater(this.f17859a.f17821e);
        }

        /* renamed from: a */
        public boolean mo25220a(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.f17860b != null) {
                return this.f17860b.onActionItemClicked(this, menuItem);
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Bitmap[] m19501b(int i, int i2, int i3) {
        if (f17819l == null) {
            f17819l = new Bitmap[i];
        } else if (f17819l.length < i) {
            f17819l = (Bitmap[]) Arrays.copyOf(f17819l, i);
        }
        for (int i4 = 0; i4 < i; i4++) {
            Bitmap bitmap = f17819l[i4];
            if (bitmap == null || bitmap.getWidth() < i2 || bitmap.getHeight() < i3) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            }
            f17819l[i4] = bitmap;
        }
        return f17819l;
    }

    /* renamed from: b */
    private void m19500b() {
        if (f17819l != null) {
            for (int i = 0; i < f17819l.length; i++) {
                Bitmap bitmap = f17819l[i];
                if (bitmap != null) {
                    bitmap.recycle();
                }
                f17819l[i] = null;
            }
            f17819l = null;
        }
    }

    /* renamed from: flyme.support.v7.widget.OptionPopupWindow$b */
    private class C3237b {

        /* renamed from: a */
        public Rect f17862a;

        /* renamed from: b */
        public MenuItem f17863b;

        /* renamed from: c */
        public int f17864c;

        /* renamed from: d */
        public boolean f17865d = false;

        /* renamed from: e */
        public boolean f17866e = false;

        /* renamed from: f */
        public int f17867f = 0;
        @Deprecated

        /* renamed from: g */
        public int f17868g;

        public C3237b(Rect rect, MenuItem menuItem, int i) {
            this.f17862a = rect;
            this.f17863b = menuItem;
            this.f17864c = i;
        }
    }

    /* renamed from: flyme.support.v7.widget.OptionPopupWindow$c */
    private class C3238c {

        /* renamed from: a */
        int f17870a;

        C3238c(int i) {
            this.f17870a = i;
        }
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f17824j = onDismissListener;
    }

    public void onDismiss() {
        this.f17823g = 0;
        m19500b();
        if (this.f17824j != null) {
            this.f17824j.onDismiss();
        }
    }
}
