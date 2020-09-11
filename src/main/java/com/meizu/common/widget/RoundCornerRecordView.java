package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import com.meizu.common.R;

public class RoundCornerRecordView extends ImageView {

    /* renamed from: P */
    private static boolean f5962P = false;

    /* renamed from: Q */
    private static final Object f5963Q = new Object();

    /* renamed from: R */
    private static final BorderType[] f5964R = {BorderType.BORDER_NULL, BorderType.BORDER_LIST_CONTACT, BorderType.BORDER_EDIT_CONTACT, BorderType.BORDER_VIEW_CONTACT, BorderType.BORDER_SMS_CONTACT, BorderType.BORDER_SMALL_CONTACT};

    /* renamed from: S */
    private static final IconType[] f5965S = {IconType.IC_NULL, IconType.IC_CALL_LOG_CALLOUT, IconType.IC_CALL_LOG_CALLIN, IconType.IC_CALL_LOG_MISSED, IconType.IC_CALL_LOG_REFUSED, IconType.IC_CALL_LOG_RINGONCE, IconType.IC_CALL_LOG_RECORD, IconType.IC_CALL_LOG_RECORD_FAIL, IconType.IC_CALL_LOG_VOICEMAIL, IconType.IC_SMS_HAS_UNREAD, IconType.IC_SMS_HAS_NOTDELIVERED};

    /* renamed from: A */
    private Paint f5966A;

    /* renamed from: B */
    private int f5967B;

    /* renamed from: C */
    private CharSequence f5968C;

    /* renamed from: D */
    private CharSequence f5969D;

    /* renamed from: E */
    private Drawable f5970E;

    /* renamed from: F */
    private String f5971F;

    /* renamed from: G */
    private int f5972G;

    /* renamed from: H */
    private int f5973H;

    /* renamed from: I */
    private int f5974I;

    /* renamed from: J */
    private Paint f5975J;

    /* renamed from: K */
    private int f5976K;

    /* renamed from: L */
    private int f5977L;

    /* renamed from: M */
    private boolean f5978M;

    /* renamed from: N */
    private boolean f5979N;

    /* renamed from: O */
    private boolean f5980O;

    /* renamed from: a */
    private BorderType f5981a;

    /* renamed from: b */
    private IconType f5982b;

    /* renamed from: c */
    private Rect f5983c;

    /* renamed from: d */
    private Bitmap f5984d;

    /* renamed from: e */
    private Drawable f5985e;

    /* renamed from: f */
    private Drawable f5986f;

    /* renamed from: g */
    private int f5987g;

    /* renamed from: h */
    private int f5988h;

    /* renamed from: i */
    private int f5989i;

    /* renamed from: j */
    private int f5990j;

    /* renamed from: k */
    private boolean f5991k;

    /* renamed from: l */
    private String f5992l;

    /* renamed from: m */
    private boolean f5993m;

    /* renamed from: n */
    private boolean f5994n;

    /* renamed from: o */
    private boolean f5995o;

    /* renamed from: p */
    private CharSequence f5996p;

    /* renamed from: q */
    private long f5997q;

    /* renamed from: r */
    private Bundle f5998r;

    /* renamed from: s */
    private String f5999s;

    /* renamed from: t */
    private long f6000t;

    /* renamed from: u */
    private Bundle f6001u;

    /* renamed from: v */
    private Drawable f6002v;

    /* renamed from: w */
    private Drawable f6003w;

    /* renamed from: x */
    private Drawable f6004x;

    /* renamed from: y */
    private Drawable f6005y;

    /* renamed from: z */
    private Drawable f6006z;

    public void setRecordClickListener(View.OnClickListener onClickListener) {
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    public enum BorderType {
        BORDER_NULL(0),
        BORDER_LIST_CONTACT(1),
        BORDER_EDIT_CONTACT(2),
        BORDER_VIEW_CONTACT(3),
        BORDER_SMS_CONTACT(4),
        BORDER_SMALL_CONTACT(5);
        
        final int borderTypeInt;

        private BorderType(int i) {
            this.borderTypeInt = i;
        }
    }

    public enum IconType {
        IC_NULL(0),
        IC_CALL_LOG_CALLOUT(1),
        IC_CALL_LOG_CALLIN(2),
        IC_CALL_LOG_MISSED(3),
        IC_CALL_LOG_REFUSED(4),
        IC_CALL_LOG_RINGONCE(5),
        IC_CALL_LOG_RECORD(6),
        IC_CALL_LOG_RECORD_FAIL(7),
        IC_CALL_LOG_VOICEMAIL(8),
        IC_SMS_HAS_UNREAD(9),
        IC_SMS_HAS_NOTDELIVERED(10);
        
        final int iconTypeInt;

        private IconType(int i) {
            this.iconTypeInt = i;
        }
    }

    public RoundCornerRecordView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundCornerRecordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5981a = null;
        this.f5982b = null;
        this.f5984d = null;
        this.f5985e = null;
        this.f5986f = null;
        this.f5987g = 0;
        this.f5988h = 0;
        this.f5989i = 0;
        this.f5990j = 0;
        this.f5991k = false;
        this.f5993m = false;
        this.f5994n = false;
        this.f5995o = false;
        this.f5976K = -1;
        this.f5978M = true;
        this.f5980O = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerContactBadge, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.RoundCornerContactBadge_mcBorderType, BorderType.BORDER_NULL.borderTypeInt);
        int i3 = obtainStyledAttributes.getInt(R.styleable.RoundCornerContactBadge_mcIconType, IconType.IC_CALL_LOG_RECORD.iconTypeInt);
        this.f5977L = getResources().getColor(R.color.mc_round_colorfulbg_color);
        obtainStyledAttributes.recycle();
        setBorderType(f5964R[i2]);
        setIconType(f5965S[i3]);
        m6004a();
    }

    /* renamed from: a */
    private void m6004a() {
        super.setScaleType(ImageView.ScaleType.FIT_CENTER);
        setDuplicateParentStateEnabled(false);
        this.f5983c = new Rect();
        this.f6005y = getResources().getDrawable(R.drawable.mc_contact_list_picture_shadow);
    }

    public void setBackgroundColorId(String str) {
        TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.mc_colorful_round);
        int abs = Math.abs(str.hashCode()) % obtainTypedArray.length();
        if (abs < obtainTypedArray.length()) {
            this.f5976K = obtainTypedArray.getColor(abs, this.f5977L);
        }
        obtainTypedArray.recycle();
    }

    public void setImageResource(int i) {
        if (i == 0) {
            setImageDrawable((Drawable) null);
            return;
        }
        Drawable drawable = getDrawable();
        super.setImageResource(i);
        Drawable drawable2 = getDrawable();
        Bitmap bitmap = (drawable2 == null || !(drawable2 instanceof BitmapDrawable)) ? null : ((BitmapDrawable) drawable2).getBitmap();
        if (!(this.f5984d == null || this.f5984d == bitmap)) {
            this.f5984d.recycle();
            this.f5984d = null;
        }
        if (this.f5979N && (drawable instanceof BitmapDrawable)) {
            ((BitmapDrawable) drawable).getBitmap().recycle();
        }
        this.f5979N = false;
    }

    public void setImageURI(Uri uri) {
        if (uri == null) {
            setImageDrawable((Drawable) null);
            return;
        }
        Drawable drawable = getDrawable();
        super.setImageURI(uri);
        Drawable drawable2 = getDrawable();
        Bitmap bitmap = (drawable2 == null || !(drawable2 instanceof BitmapDrawable)) ? null : ((BitmapDrawable) drawable2).getBitmap();
        if (!(this.f5984d == null || this.f5984d == bitmap)) {
            this.f5984d.recycle();
            this.f5984d = null;
        }
        if (this.f5979N && (drawable instanceof BitmapDrawable)) {
            ((BitmapDrawable) drawable).getBitmap().recycle();
        }
        this.f5979N = false;
    }

    public void setImageBitmap(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            setImageDrawable((Drawable) null);
            return;
        }
        super.setImageBitmap(bitmap);
        this.f5979N = z;
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            setImageDrawable((Drawable) null);
        } else {
            super.setImageBitmap(bitmap);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        if (drawable == null) {
            drawable = this.f6006z;
        }
        super.setImageDrawable(drawable);
        Bitmap bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
        if (!(this.f5984d == null || this.f5984d == bitmap)) {
            this.f5984d.recycle();
            this.f5984d = null;
        }
        if (this.f5979N && (drawable2 instanceof BitmapDrawable)) {
            ((BitmapDrawable) drawable2).getBitmap().recycle();
        }
        this.f5979N = false;
    }

    private Drawable getDefaultDrawable() {
        if (C14941.f6007a[this.f5981a.ordinal()] != 1) {
            return getResources().getDrawable(R.drawable.mc_contact_list_picture);
        }
        return getResources().getDrawable(R.drawable.mc_contact_small_picture);
    }

    /* renamed from: a */
    private boolean m6006a(Drawable drawable) {
        return ((BitmapDrawable) drawable).getBitmap().equals(((BitmapDrawable) this.f6006z).getBitmap());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f5991k) {
            int i3 = this.f5987g;
            int i4 = this.f5988h;
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5983c.set(0, 0, super.getMeasuredWidth(), super.getMeasuredHeight());
    }

    public void setIconText(CharSequence charSequence) {
        if (!TextUtils.equals(this.f5996p, charSequence)) {
            this.f5996p = charSequence;
            invalidate();
        }
    }

    public void setIconType(IconType iconType) {
        if (iconType == null) {
            throw new NullPointerException();
        } else if (this.f5982b != iconType) {
            this.f5982b = iconType;
            switch (this.f5982b) {
                case IC_CALL_LOG_CALLOUT:
                    this.f5985e = getResources().getDrawable(R.drawable.mc_sym_call_list_outgoing);
                    break;
                case IC_CALL_LOG_CALLIN:
                    this.f5985e = getResources().getDrawable(R.drawable.mc_sym_call_list_incoming);
                    break;
                case IC_CALL_LOG_MISSED:
                    this.f5985e = getResources().getDrawable(R.drawable.mc_sym_call_list_missed);
                    break;
                case IC_CALL_LOG_REFUSED:
                    this.f5985e = getResources().getDrawable(R.drawable.mc_sym_call_list_reject);
                    break;
                case IC_CALL_LOG_RINGONCE:
                    this.f5985e = getResources().getDrawable(R.drawable.mc_sym_call_list_ringing);
                    break;
                case IC_CALL_LOG_RECORD:
                    this.f5985e = getResources().getDrawable(R.drawable.mc_sym_call_list_record);
                    break;
                case IC_CALL_LOG_RECORD_FAIL:
                    this.f5985e = getResources().getDrawable(R.drawable.mc_sym_call_list_record_fail);
                    break;
                case IC_CALL_LOG_VOICEMAIL:
                    this.f5985e = getResources().getDrawable(R.drawable.mc_sym_call_list_voicemail);
                    break;
                default:
                    this.f5985e = null;
                    break;
            }
            invalidate();
        }
    }

    public IconType getIconType() {
        return this.f5982b;
    }

    public void setBorderType(BorderType borderType) {
        if (borderType == null) {
            throw new NullPointerException();
        } else if (this.f5981a != borderType) {
            this.f5991k = true;
            this.f5981a = borderType;
            Drawable drawable = this.f6006z;
            this.f6006z = getDefaultDrawable();
            if (getDrawable() == drawable) {
                setImageDrawable(this.f6006z);
            }
            this.f5986f = getResources().getDrawable(R.drawable.mc_contact_list_picture_box);
            this.f5973H = getResources().getDimensionPixelSize(R.dimen.mc_badge_text_shadow_radius);
            this.f5974I = getResources().getColor(R.color.mc_badge_text_shadow_color);
            switch (this.f5981a) {
                case BORDER_SMALL_CONTACT:
                    this.f5987g = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_small_width);
                    this.f5988h = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_small_height);
                    this.f5989i = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_small_picture_width);
                    this.f5990j = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_small_picture_height);
                    this.f6003w = getResources().getDrawable(R.drawable.mc_contact_list_call);
                    this.f6002v = getResources().getDrawable(R.drawable.mc_contact_list_picture_call_pressed);
                    this.f5972G = getResources().getDimensionPixelSize(R.dimen.mc_badge_small_textsize);
                    return;
                case BORDER_LIST_CONTACT:
                    this.f5987g = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_list_width);
                    this.f5988h = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_list_height);
                    this.f5989i = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_list_picture_width);
                    this.f5990j = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_list_picture_height);
                    this.f6003w = getResources().getDrawable(R.drawable.mc_contact_list_call);
                    this.f6002v = getResources().getDrawable(R.drawable.mc_contact_list_picture_call_pressed);
                    this.f5972G = getResources().getDimensionPixelSize(R.dimen.mc_badge_list_textsize);
                    return;
                case BORDER_SMS_CONTACT:
                    this.f5987g = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_sms_width);
                    this.f5988h = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_sms_height);
                    this.f5989i = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_list_picture_width);
                    this.f5990j = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_list_picture_height);
                    this.f6003w = getResources().getDrawable(R.drawable.mc_contact_list_call);
                    this.f6002v = getResources().getDrawable(R.drawable.mc_contact_list_picture_call_pressed);
                    this.f5972G = getResources().getDimensionPixelSize(R.dimen.mc_badge_list_textsize);
                    return;
                case BORDER_EDIT_CONTACT:
                case BORDER_VIEW_CONTACT:
                    this.f5987g = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_contact_width);
                    this.f5988h = getResources().getDimensionPixelSize(R.dimen.mc_badge_border_contact_height);
                    this.f5989i = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_picture_width);
                    this.f5990j = getResources().getDimensionPixelSize(R.dimen.mc_badge_contact_picture_height);
                    this.f6003w = null;
                    this.f6002v = null;
                    this.f5972G = getResources().getDimensionPixelSize(R.dimen.mc_badge_list_textsize);
                    return;
                default:
                    this.f6003w = null;
                    this.f6002v = null;
                    this.f5991k = false;
                    this.f5972G = getResources().getDimensionPixelSize(R.dimen.mc_badge_small_textsize);
                    return;
            }
        }
    }

    public BorderType getBorderType() {
        return this.f5981a;
    }

    public void setClickToCall(boolean z) {
        if (this.f5993m != z) {
            this.f5993m = z;
            invalidate();
        }
    }

    public void setTilte(CharSequence charSequence) {
        this.f5968C = charSequence;
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f5969D = charSequence;
    }

    public void setHasShadow(boolean z) {
        if (this.f5978M != z) {
            this.f5978M = z;
            invalidate();
        }
    }

    public void setContactBadgeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f5971F = "";
        } else {
            String trim = str.trim();
            if (TextUtils.isEmpty(trim)) {
                this.f5971F = "";
            } else {
                String substring = trim.substring(0, 1);
                char charAt = substring.charAt(0);
                if ('a' <= charAt && charAt <= 'z') {
                    substring = substring.toUpperCase();
                }
                this.f5971F = substring;
            }
        }
        invalidate();
    }

    /* renamed from: b */
    private void m6007b() {
        int i;
        int i2;
        int i3;
        int i4;
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if ((drawable instanceof BitmapDrawable) && !m6006a(drawable)) {
            int width = this.f5983c.width();
            int height = this.f5983c.height();
            if (this.f5991k) {
                width = this.f5989i;
                height = this.f5990j;
            }
            Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
            int width2 = bitmap2.getWidth();
            int height2 = bitmap2.getHeight();
            if (width2 == height2) {
                i2 = width2;
                i = height2;
                i4 = 0;
                i3 = 0;
            } else if (height2 > width2) {
                i2 = width2;
                i = i2;
                i3 = (height2 - width2) / 2;
                i4 = 0;
            } else {
                i2 = height2;
                i = i2;
                i3 = 0;
                i4 = (width2 - height2) / 2;
            }
            float f = ((float) width) / ((float) i2);
            float f2 = ((float) height) / ((float) i);
            if (f == 1.0f && f2 == 1.0f && i4 == 0 && i3 == 0) {
                bitmap = bitmap2;
            } else {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f2);
                bitmap = Bitmap.createBitmap(bitmap2, i4, i3, i2, i, matrix, true);
            }
            this.f5984d = m6003a(bitmap);
            super.setImageDrawable(new BitmapDrawable(getResources(), this.f5984d));
            if (bitmap != bitmap2) {
                bitmap.recycle();
            }
            if (this.f5979N) {
                bitmap2.recycle();
                this.f5979N = false;
            }
        }
    }

    /* renamed from: a */
    private Bitmap m6003a(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        new RectF(rect);
        if (this.f6004x == null) {
            this.f6004x = getResources().getDrawable(R.drawable.mc_contact_list_picture_cover);
            if (this.f6004x instanceof NinePatchDrawable) {
                ((NinePatchDrawable) this.f6004x).getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            }
        }
        if (this.f5966A == null) {
            this.f5966A = new Paint();
        }
        this.f5966A.setXfermode((Xfermode) null);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f5966A);
        this.f6004x.setBounds(rect);
        this.f6004x.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    private void m6005a(Canvas canvas, Rect rect) {
        if (this.f5970E == null) {
            this.f5970E = getResources().getDrawable(R.drawable.mc_contact_list_picture_default);
        }
        this.f5970E.setBounds(rect);
        this.f5970E.draw(canvas);
        if (this.f5975J == null) {
            this.f5975J = new Paint();
            this.f5975J.setAntiAlias(true);
            this.f5975J.setTextAlign(Paint.Align.CENTER);
            this.f5975J.setColor(-1);
            this.f5975J.setShadowLayer((float) this.f5973H, 0.0f, 0.0f, this.f5974I);
        }
        this.f5975J.setTextSize((float) this.f5972G);
        float f = (float) ((rect.top + rect.bottom) / 2);
        Paint.FontMetrics fontMetrics = this.f5975J.getFontMetrics();
        canvas.drawText(this.f5971F, (float) ((rect.left + rect.right) / 2), (f + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom)) - 2.0f, this.f5975J);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!(getDrawable() instanceof BitmapDrawable) || this.f5984d != ((BitmapDrawable) getDrawable()).getBitmap()) {
            Bitmap bitmap = this.f5984d;
            this.f5984d = null;
            m6007b();
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        Paint paint = new Paint();
        paint.setColor(this.f5976K);
        Rect rect = new Rect();
        if (this.f5981a == BorderType.BORDER_LIST_CONTACT) {
            rect.set(this.f5983c.left + this.f5967B, this.f5983c.top + this.f5967B, this.f5983c.right - this.f5967B, this.f5983c.bottom - this.f5967B);
        } else {
            rect.set(this.f5983c);
        }
        canvas.drawRect(rect, paint);
        int save = canvas.save();
        if (!this.f5994n || this.f6002v == null) {
            if (this.f5984d != null || TextUtils.isEmpty(this.f5971F)) {
                Drawable drawable = getDrawable();
                drawable.setBounds(rect);
                drawable.draw(canvas);
            } else {
                m6005a(canvas, rect);
            }
            if (this.f5978M) {
                this.f6005y.setBounds(rect);
                this.f6005y.draw(canvas);
            }
            if (this.f5993m && this.f6003w != null) {
                this.f6003w.setBounds(rect.left, rect.bottom - this.f6003w.getIntrinsicHeight(), rect.right, rect.bottom);
                this.f6003w.draw(canvas);
            }
            if (this.f5986f != null) {
                this.f5986f.setBounds(rect);
                this.f5986f.draw(canvas);
            }
        } else {
            this.f6002v.setBounds(rect);
            this.f6002v.draw(canvas);
        }
        canvas.restoreToCount(save);
        this.f5994n = false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f5986f;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(drawableState);
            invalidate();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            synchronized (f5963Q) {
                f5962P = false;
            }
        }
        super.onWindowFocusChanged(z);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f5980O) {
            setImageDrawable((Drawable) null);
        } else {
            this.f5980O = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f5993m) {
            return super.onTouchEvent(motionEvent);
        }
        if (!hasWindowFocus() || f5962P) {
            return true;
        }
        this.f5999s = this.f5992l;
        this.f6000t = this.f5997q;
        this.f6001u = this.f5998r;
        return super.onTouchEvent(motionEvent);
    }

    public void setPressed(boolean z) {
        if (!(getParent() instanceof View) || !((View) getParent()).isPressed()) {
            super.setPressed(z);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(RoundCornerRecordView.class.getName());
    }
}
