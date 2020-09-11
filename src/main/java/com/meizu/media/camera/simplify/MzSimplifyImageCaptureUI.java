package com.meizu.media.camera.simplify;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.meizu.media.camera.MzSimplifyCamModule;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.views.GlowImageView;
import com.meizu.media.camera.views.MzTextDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.WeakReference;

/* renamed from: com.meizu.media.camera.simplify.h */
public class MzSimplifyImageCaptureUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f11971a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f11972b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f11973c;

    /* renamed from: d */
    private ImageView f11974d;

    /* renamed from: e */
    private View f11975e;

    /* renamed from: f */
    private View f11976f;

    /* renamed from: g */
    private View f11977g;

    /* renamed from: h */
    private C2340a f11978h = null;

    /* renamed from: i */
    private ImageView f11979i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f11980j;

    /* renamed from: k */
    private boolean f11981k;

    /* renamed from: l */
    private boolean f11982l;

    /* renamed from: m */
    private boolean f11983m;

    /* renamed from: n */
    private boolean f11984n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public MzSimplifyUIController f11985o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public MzSimplifyCamModule f11986p;

    /* renamed from: q */
    private int f11987q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View f11988r;

    /* renamed from: s */
    private View.OnClickListener f11989s = new View.OnClickListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f11996a;

        public void onClick(View view) {
            if (!PatchProxy.proxy(new Object[]{view}, this, f11996a, false, 6032, new Class[]{View.class}, Void.TYPE).isSupported) {
                if (MzSimplifyImageCaptureUI.this.f11973c.getVisibility() == 0) {
                    MzSimplifyImageCaptureUI.this.f11973c.setVisibility(4);
                    MzSimplifyImageCaptureUI.this.f11980j.setVisibility(4);
                    MzSimplifyImageCaptureUI.this.m13157a(MzSimplifyImageCaptureUI.this.f11988r, true);
                    return;
                }
                MzSimplifyImageCaptureUI.this.f11973c.setVisibility(0);
                if (NavigationBarUtils.m15973a(MzSimplifyImageCaptureUI.this.f11980j.getContext().getResources())) {
                    MzSimplifyImageCaptureUI.this.f11980j.setVisibility(0);
                }
                MzSimplifyImageCaptureUI.this.m13157a(MzSimplifyImageCaptureUI.this.f11988r, false);
            }
        }
    };

    public MzSimplifyImageCaptureUI(View view, MzSimplifyCamModule mzSimplifyCamModule, MzSimplifyUIController jVar) {
        this.f11988r = view;
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.mz_image_capture_stub);
        if (viewStub != null) {
            viewStub.inflate();
            this.f11972b = view.findViewById(R.id.mz_image_capture_control);
            this.f11976f = this.f11972b.findViewById(R.id.done_button);
            this.f11977g = this.f11972b.findViewById(R.id.btn_retake);
            this.f11974d = (ImageView) this.f11972b.findViewById(R.id.review_image);
            this.f11974d.setOnClickListener(this.f11989s);
            this.f11975e = this.f11972b.findViewById(R.id.review_image_bg);
            this.f11973c = this.f11972b.findViewById(R.id.mz_camera_image_capture_control);
            this.f11980j = this.f11972b.findViewById(R.id.navigation_bar_image_bg);
            this.f11986p = mzSimplifyCamModule;
            this.f11981k = this.f11986p.mo18350A();
            this.f11983m = this.f11986p.mo18351B();
            this.f11982l = this.f11986p.mo18352C();
            this.f11985o = jVar;
            if (this.f11982l) {
                this.f11979i = (ImageView) this.f11972b.findViewById(R.id.record_play);
                this.f11979i.setOnClickListener(new View.OnClickListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f11990a;

                    public void onClick(View view) {
                        if (!PatchProxy.proxy(new Object[]{view}, this, f11990a, false, 6029, new Class[]{View.class}, Void.TYPE).isSupported) {
                            MzSimplifyImageCaptureUI.this.f11986p.mo18371V();
                        }
                    }
                });
            }
            this.f11976f.setOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11992a;

                public void onClick(View view) {
                    if (!PatchProxy.proxy(new Object[]{view}, this, f11992a, false, 6030, new Class[]{View.class}, Void.TYPE).isSupported) {
                        MzSimplifyImageCaptureUI.this.m13170i();
                    }
                }
            });
            this.f11977g.setOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11994a;

                public void onClick(View view) {
                    if (!PatchProxy.proxy(new Object[]{view}, this, f11994a, false, 6031, new Class[]{View.class}, Void.TYPE).isSupported) {
                        MzSimplifyImageCaptureUI.this.m13169h();
                    }
                }
            });
            if (NavigationBarUtils.m15973a(this.f11980j.getContext().getResources())) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f11973c.getLayoutParams());
                layoutParams.height = CameraUtil.m15912r();
                layoutParams.addRule(12, -1);
                this.f11980j.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f11973c.getLayoutParams());
                layoutParams2.bottomMargin = CameraUtil.m15912r();
                layoutParams2.addRule(12, -1);
                this.f11973c.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: a */
    public void mo21283a() {
        if (!PatchProxy.proxy(new Object[0], this, f11971a, false, 6011, new Class[0], Void.TYPE).isSupported) {
            if (this.f11981k && !this.f11983m) {
                this.f11985o.mo20960n(0);
            } else if (this.f11983m) {
                this.f11985o.mo20960n(1);
            } else {
                this.f11985o.mo20960n(2);
            }
        }
    }

    /* renamed from: a */
    public void mo21284a(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, f11971a, false, 6012, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            m13156a(width, Math.abs(width - 0.75f) > 0.1f);
            Animation a = m13154a(this.f11987q, width);
            if (a != null) {
                this.f11974d.startAnimation(a);
            }
            this.f11975e.startAnimation(m13159b(true));
            this.f11973c.startAnimation(m13161c(true));
            this.f11974d.setImageBitmap(bitmap);
            this.f11975e.setVisibility(0);
            this.f11974d.setVisibility(0);
            this.f11978h = null;
            this.f11972b.setVisibility(0);
            this.f11973c.setVisibility(0);
            if (NavigationBarUtils.m15973a(this.f11980j.getContext().getResources())) {
                this.f11980j.setVisibility(0);
            }
        }
    }

    /* renamed from: com.meizu.media.camera.simplify.h$b */
    /* compiled from: MzSimplifyImageCaptureUI */
    private static abstract class C2341b extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: c */
        public static ChangeQuickRedirect f12006c;

        /* renamed from: a */
        private final byte[] f12007a;

        /* renamed from: b */
        private int f12008b;

        /* renamed from: d */
        private boolean f12009d;

        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
        }

        public C2341b(byte[] bArr, int i, boolean z) {
            this.f12007a = bArr;
            this.f12008b = i;
            this.f12009d = z;
        }

        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f12006c, false, 6036, new Class[]{Void[].class}, Bitmap.class);
            if (proxy.isSupported) {
                return (Bitmap) proxy.result;
            }
            Bitmap a = CameraUtil.m15824a(this.f12007a);
            if (this.f12008b == 90) {
                return a;
            }
            Matrix matrix = new Matrix();
            int i = 180;
            if (this.f12008b == 0 || this.f12008b == 180) {
                i = this.f12008b + 90;
            }
            matrix.preRotate((float) i);
            return CameraUtil.m15821a(a, matrix);
        }
    }

    /* renamed from: com.meizu.media.camera.simplify.h$a */
    /* compiled from: MzSimplifyImageCaptureUI */
    private class C2340a extends C2341b {

        /* renamed from: a */
        public static ChangeQuickRedirect f12003a;

        /* renamed from: d */
        private WeakReference<MzSimplifyImageCaptureUI> f12005d;

        public C2340a(MzSimplifyImageCaptureUI hVar, byte[] bArr, int i, boolean z) {
            super(bArr, i, z);
            this.f12005d = new WeakReference<>(hVar);
        }

        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            if (!PatchProxy.proxy(new Object[]{bitmap}, this, f12003a, false, 6035, new Class[]{Bitmap.class}, Void.TYPE).isSupported && !isCancelled()) {
                MzSimplifyImageCaptureUI hVar = (MzSimplifyImageCaptureUI) this.f12005d.get();
                if (!(hVar == null || bitmap == null)) {
                    hVar.mo21284a(bitmap);
                }
                MzSimplifyImageCaptureUI.this.f11985o.mo20882ad();
                MzSimplifyImageCaptureUI.this.f11985o.mo20960n(3);
            }
        }
    }

    /* renamed from: a */
    public void mo21286a(byte[] bArr, int i, boolean z) {
        int i2;
        Object[] objArr = {bArr, new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11971a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6013, new Class[]{byte[].class, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                if (i == 90) {
                    i2 = 270;
                } else if (i == 270) {
                    i2 = 90;
                }
                this.f11987q = i2;
                m13167g();
                this.f11978h = new C2340a(this, bArr, i2, z);
                this.f11978h.execute(new Void[0]);
            }
            i2 = i;
            this.f11987q = i2;
            m13167g();
            this.f11978h = new C2340a(this, bArr, i2, z);
            this.f11978h.execute(new Void[0]);
        }
    }

    /* renamed from: b */
    public void mo21287b() {
        if (!PatchProxy.proxy(new Object[0], this, f11971a, false, 6014, new Class[0], Void.TYPE).isSupported) {
            if (this.f11978h != null) {
                this.f11978h.cancel(true);
            }
            this.f11973c.startAnimation(m13161c(false));
            this.f11974d.setVisibility(8);
            this.f11974d.clearAnimation();
            this.f11975e.setVisibility(8);
            this.f11985o.mo20863a(m13159b(false));
            this.f11985o.mo20960n(4);
            if (this.f11979i != null) {
                this.f11979i.setVisibility(8);
            }
        }
    }

    /* renamed from: b */
    public void mo21288b(Bitmap bitmap) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, f11971a, false, 6015, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
            m13167g();
            if (bitmap.getWidth() > bitmap.getHeight()) {
                this.f11974d.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
                if (Math.abs(width - 0.75f) <= 0.1f) {
                    z = false;
                }
                m13156a(width, z);
                this.f11974d.setScaleType(DeviceHelper.f13874aa ? ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_CENTER);
            }
            this.f11974d.setImageBitmap(bitmap);
            this.f11975e.setVisibility(0);
            this.f11974d.setVisibility(0);
            this.f11985o.mo20960n(3);
            this.f11985o.mo20921d(1025, false);
            this.f11972b.setVisibility(0);
            this.f11973c.setVisibility(0);
            if (NavigationBarUtils.m15973a(this.f11980j.getContext().getResources())) {
                this.f11980j.setVisibility(0);
            }
            if (this.f11979i != null) {
                this.f11979i.setVisibility(0);
            }
        }
    }

    /* renamed from: g */
    private void m13167g() {
        if (!PatchProxy.proxy(new Object[0], this, f11971a, false, 6016, new Class[0], Void.TYPE).isSupported && !this.f11984n) {
            this.f11984n = true;
            MzTextDrawable kVar = new MzTextDrawable(this.f11976f.getContext(), this.f11976f.getContext().getResources().getString(R.string.accessibility_review_ok));
            kVar.mo23383a(this.f11976f.getContext().getResources().getColor(R.color.mz_button_text_color_coral));
            kVar.mo23385a(this.f11976f);
            ((GlowImageView) this.f11976f).setImageDrawable(kVar);
            MzTextDrawable kVar2 = new MzTextDrawable(this.f11977g.getContext(), this.f11977g.getContext().getResources().getString(R.string.accessibility_review_retake));
            kVar2.mo23383a(this.f11977g.getContext().getResources().getColor(17170443));
            kVar2.mo23385a(this.f11977g);
            ((GlowImageView) this.f11977g).setImageDrawable(kVar2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m13169h() {
        if (!PatchProxy.proxy(new Object[0], this, f11971a, false, 6017, new Class[0], Void.TYPE).isSupported) {
            if (this.f11979i == null || this.f11979i.getVisibility() != 0) {
                this.f11986p.mo18369T();
            } else {
                this.f11986p.mo18370U();
            }
            mo21290d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m13170i() {
        if (!PatchProxy.proxy(new Object[0], this, f11971a, false, 6018, new Class[0], Void.TYPE).isSupported) {
            if (this.f11979i == null || this.f11979i.getVisibility() != 0) {
                this.f11986p.mo18366Q();
            } else {
                this.f11986p.mo18367R();
            }
        }
    }

    /* renamed from: c */
    public boolean mo21289c() {
        boolean z = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11971a, false, 6019, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f11974d.getVisibility() == 0) {
            z = true;
        }
        if (z) {
            m13169h();
        }
        return z;
    }

    /* renamed from: d */
    public void mo21290d() {
        Bitmap bitmap;
        if (!PatchProxy.proxy(new Object[0], this, f11971a, false, 6020, new Class[0], Void.TYPE).isSupported && this.f11974d != null) {
            Drawable drawable = this.f11974d.getDrawable();
            if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
                this.f11974d.setImageBitmap((Bitmap) null);
                bitmap.recycle();
            }
        }
    }

    /* renamed from: e */
    public boolean mo21291e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11971a, false, 6021, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f11974d.getVisibility() == 0;
    }

    /* renamed from: a */
    private void m13156a(float f, boolean z) {
        int i;
        int i2 = 0;
        Object[] objArr = {new Float(f), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11971a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6022, new Class[]{Float.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            int a = CameraUtil.m15809a();
            int i3 = (int) (((float) a) / f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a, i3);
            if (z) {
                i = 0;
            } else {
                i = CameraUtil.m15901h();
            }
            layoutParams.topMargin = i;
            if (DeviceHelper.f13874aa) {
                if (!z) {
                    i2 = (((CameraUtil.m15865b() - this.f11973c.getHeight()) - i3) - CameraUtil.m15912r()) / 2;
                }
                layoutParams.topMargin = i2;
            }
            this.f11974d.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    private Animation m13154a(int i, float f) {
        int i2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Float(f)}, this, f11971a, false, 6023, new Class[]{Integer.TYPE, Float.TYPE}, Animation.class);
        if (proxy.isSupported) {
            return (Animation) proxy.result;
        }
        if (i == 90) {
            return null;
        }
        if (i == 0) {
            i2 = ((double) Math.abs(f - 0.75f)) < 0.03d ? R.anim.mz_image_capture_0_4_3 : ((double) Math.abs(f - 0.5625f)) < 0.03d ? R.anim.mz_image_capture_0_16_9 : R.anim.mz_image_capture_0_18_9;
        } else if (i == 180) {
            i2 = ((double) Math.abs(f - 0.75f)) < 0.03d ? R.anim.mz_image_capture_180_4_3 : ((double) Math.abs(f - 0.5625f)) < 0.03d ? R.anim.mz_image_capture_180_16_9 : R.anim.mz_image_capture_180_18_9;
        } else {
            i2 = R.anim.mz_image_capture_270;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11974d.getContext(), i2);
        loadAnimation.setFillAfter(true);
        return loadAnimation;
    }

    /* renamed from: b */
    private Animation m13159b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11971a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 6024, new Class[]{Boolean.TYPE}, Animation.class);
        if (proxy.isSupported) {
            return (Animation) proxy.result;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11974d.getContext(), R.anim.mz_image_capture_in);
        if (!z) {
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11998a;

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (!PatchProxy.proxy(new Object[]{animation}, this, f11998a, false, 6033, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                        MzSimplifyImageCaptureUI.this.f11985o.mo20921d(1025, true);
                    }
                }
            });
        }
        return loadAnimation;
    }

    /* renamed from: c */
    private Animation m13161c(final boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11971a, false, 6025, new Class[]{Boolean.TYPE}, Animation.class);
        if (proxy.isSupported) {
            return (Animation) proxy.result;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11974d.getContext(), z ? R.anim.mz_image_capture_translate_show : R.anim.mz_image_capture_translate_hide);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f12000a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f12000a, false, 6034, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                    if (!z) {
                        MzSimplifyImageCaptureUI.this.f11980j.setVisibility(4);
                        MzSimplifyImageCaptureUI.this.f11972b.setVisibility(4);
                        MzSimplifyImageCaptureUI.this.f11973c.setVisibility(4);
                        return;
                    }
                    MzSimplifyImageCaptureUI.this.f11985o.mo20921d(1025, false);
                    if (MzSimplifyImageCaptureUI.this.f11985o instanceof MzSimplifyCommonUI) {
                        ((MzSimplifyCommonUI) MzSimplifyImageCaptureUI.this.f11985o).mo20959n();
                    }
                }
            }
        });
        return loadAnimation;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13157a(View view, boolean z) {
        if (!PatchProxy.proxy(new Object[]{view, new Byte(z ? (byte) 1 : 0)}, this, f11971a, false, 6026, new Class[]{View.class, Boolean.TYPE}, Void.TYPE).isSupported && view != null && NavigationBarUtils.m15972a()) {
            int i = z ? 3590 : 1024;
            if (CameraUtil.m15916v()) {
                i = i | 128 | 64;
            }
            view.setSystemUiVisibility(i);
        }
    }

    /* renamed from: a */
    public void mo21285a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f11971a, false, 6027, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f11988r != null && this.f11973c != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f11973c.getLayoutParams());
            if (z) {
                layoutParams.height = this.f11988r.getResources().getDimensionPixelSize(R.dimen.mz_image_capture_bar_height);
                layoutParams.bottomMargin = CameraUtil.m15912r();
            } else {
                layoutParams.height = this.f11988r.getResources().getDimensionPixelSize(R.dimen.mz_image_capture_bar_height);
                layoutParams.bottomMargin = 0;
            }
            layoutParams.addRule(12, -1);
            this.f11973c.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: f */
    public void mo21292f() {
        if (!PatchProxy.proxy(new Object[0], this, f11971a, false, 6028, new Class[0], Void.TYPE).isSupported && this.f11978h != null) {
            this.f11978h.cancel(true);
        }
    }
}
