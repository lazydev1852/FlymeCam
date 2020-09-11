package com.meizu.media.camera.p077ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import com.meizu.media.camera.ActivityBase;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.MzCamController;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.adapter.BaseViewHolder;
import com.meizu.media.camera.adapter.StickerAdapter;
import com.meizu.media.camera.adapter.StickerPagerAdapter;
import com.meizu.media.camera.animation.C1825q;
import com.meizu.media.camera.bean.Sticker;
import com.meizu.media.camera.bean.StickerCategory;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.databinding.CameraBinding;
import com.meizu.media.camera.databinding.DelayInflateOneBinding;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzFunnySnapContainerBinding;
import com.meizu.media.camera.databinding.MzFunnySnapNoFaceBinding;
import com.meizu.media.camera.databinding.MzFunnysnapBinding;
import com.meizu.media.camera.filter.CenterLockLayoutManager;
import com.meizu.media.camera.filter.CenterLockListener;
import com.meizu.media.camera.filter.FilterRecyclerView;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p071h.StickerNetworkManager;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.FormatUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.util.NetWorkUtils;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.GuideHintView;
import com.meizu.media.camera.views.SelectAdapter;
import com.meizu.media.camera.views.SlidingTabLayout;
import com.meizu.media.mzfunnysnapsdk.Filter.LookupFilterFactory;
import com.meizu.media.mzfunnysnapsdk.Filter.StaticWaterMarkFilter;
import com.meizu.media.mzfunnysnapsdk.MZUtil.EGLController;
import com.meizu.media.mzfunnysnapsdk.MZUtil.FilterList;
import com.meizu.media.mzfunnysnapsdk.MZUtil.FilterLoader;
import com.meizu.media.mzfunnysnapsdk.MZUtil.FrameCallback;
import com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams;
import com.meizu.media.mzfunnysnapsdk.MZUtil.MzFaceDetectArc;
import com.meizu.media.mzfunnysnapsdk.MZUtil.Renderer;
import com.meizu.media.mzfunnysnapsdk.MZUtil.TextureController;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MzPlayAudioClass;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MzShortVideoController;
import com.meizu.media.mzfunnysnapsdk.Utils.BitmapUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.widget.LinearLayoutManager;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.meizu.media.camera.ui.p */
public class MzFunnySnapUI implements TextureView.SurfaceTextureListener, View.OnClickListener, StickerNetworkManager.C2119c, FrameCallback {

    /* renamed from: a */
    public static ChangeQuickRedirect f13324a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f13325b = new LogUtil.C2630a("FunnySnapUI");

    /* renamed from: A */
    private Button f13326A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public TextView f13327B;

    /* renamed from: C */
    private ImageView f13328C;

    /* renamed from: D */
    private ProgressBar f13329D;

    /* renamed from: E */
    private ImageReader f13330E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public ArrayList<StickerCategory> f13331F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public MzCamUI f13332G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public MzCamController f13333H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public C2563b f13334I;

    /* renamed from: J */
    private CameraBinding f13335J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C2562a f13336K;

    /* renamed from: L */
    private MzUIController f13337L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public Context f13338M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public ActivityBase f13339N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public ArrayList<StickerAdapter> f13340O = new ArrayList<>();

    /* renamed from: P */
    private ViewGroup f13341P;

    /* renamed from: Q */
    private TextureView f13342Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public TextureController f13343R;

    /* renamed from: S */
    private MzPlayAudioClass f13344S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public FilterLoader f13345T;

    /* renamed from: U */
    private MzShortVideoController f13346U;

    /* renamed from: V */
    private String f13347V;

    /* renamed from: W */
    private boolean f13348W = false;

    /* renamed from: X */
    private Bitmap f13349X;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public boolean f13350Y = false;

    /* renamed from: Z */
    private boolean f13351Z = false;
    /* access modifiers changed from: private */

    /* renamed from: aA */
    public boolean f13352aA = true;

    /* renamed from: aB */
    private View.OnClickListener f13353aB = new View.OnClickListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13457a;

        public void onClick(View view) {
            if (!PatchProxy.proxy(new Object[]{view}, this, f13457a, false, 7290, new Class[]{View.class}, Void.TYPE).isSupported && !MzFunnySnapUI.this.f13371ao) {
                int currentItem = MzFunnySnapUI.this.f13402v.getCurrentItem();
                int intValue = ((Integer) view.getTag()).intValue();
                int a = NetWorkUtils.m15976a(MzFunnySnapUI.this.f13338M);
                LogUtil.C2630a F = MzFunnySnapUI.f13325b;
                LogUtil.m15942a(F, "currentPageIndex:" + currentItem);
                LogUtil.C2630a F2 = MzFunnySnapUI.f13325b;
                LogUtil.m15942a(F2, "position:" + intValue);
                StickerAdapter stickerAdapter = (StickerAdapter) MzFunnySnapUI.this.f13340O.get(currentItem);
                if (stickerAdapter.getItemCount() <= intValue) {
                    LogUtil.m15949b(MzFunnySnapUI.f13325b, "position out of Range");
                    return;
                }
                final Sticker a2 = stickerAdapter.mo18768a(intValue);
                if (!a2.mo19357g()) {
                    final String a3 = Storage.m7750a().mo18621a(MzFunnySnapUI.this.f13338M, String.valueOf(a2.mo19342a()));
                    if (a2.mo19359i() == Sticker.DownloadState.DOWNLOADING) {
                        LogUtil.m15942a(MzFunnySnapUI.f13325b, "sticker is downloading");
                        return;
                    }
                    if (a2.mo19358h() == null && a2.mo19348b() != null) {
                        MzFunnySnapUI.this.f13336K.mo20462c(a2.mo19348b());
                    }
                    if (a3 != null) {
                        LogUtil.m15942a(MzFunnySnapUI.f13325b, "mStickerSelectListener, file is download");
                        String currentSticker = GlobalParams.getCurrentSticker();
                        if (TextUtils.isEmpty(currentSticker) || !currentSticker.equals(a3)) {
                            String unused = MzFunnySnapUI.this.f13369am = a3;
                            MzFunnySnapUI.this.m15358d(a3);
                            MzFunnySnapUI.this.m15345a(a2.mo19355e(), String.valueOf(a2.mo19342a()));
                            UsageStatsHelper.m16042a(MzFunnySnapUI.this.f13338M.getApplicationContext()).mo22691a("select_sticker", "id", String.valueOf(a2.mo19342a()));
                            new AsyncTaskEx<Sticker, Void, Void>() {

                                /* renamed from: a */
                                public static ChangeQuickRedirect f13463a;

                                /* renamed from: a */
                                public Void mo17658a(Sticker... stickerArr) {
                                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{stickerArr}, this, f13463a, false, 7292, new Class[]{Sticker[].class}, Void.class);
                                    if (proxy.isSupported) {
                                        return (Void) proxy.result;
                                    }
                                    MzFunnySnapUI.this.f13336K.mo20465d(String.valueOf(stickerArr[0].mo19342a()));
                                    return null;
                                }
                            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Sticker[]{a2});
                        } else {
                            MzFunnySnapUI.this.f13345T.removeStickerFilterGroup();
                            String unused2 = MzFunnySnapUI.this.f13369am = null;
                            MzFunnySnapUI.this.m15345a(false, (String) null);
                            MzFunnySnapUI.this.m15314N();
                            return;
                        }
                    } else if (a != 7) {
                        switch (a) {
                            case -1:
                                MzFunnySnapUI.this.m15316O();
                                break;
                            case 0:
                                if (MzFunnySnapUI.this.f13333H.mo17877Z()) {
                                    LogUtil.m15942a(MzFunnySnapUI.f13325b, "mStickerSelectListener, file is not download, start download!");
                                    MzFunnySnapUI.this.f13336K.mo20455a(String.valueOf(a2.mo19342a()), a2.mo19352c(), a2.mo19354d(), a2.mo19355e());
                                    MzFunnySnapUI.this.m15339a(a2, Sticker.DownloadState.DOWNLOADING);
                                    break;
                                } else {
                                    MzFunnySnapUI.this.m15337a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {

                                        /* renamed from: a */
                                        public static ChangeQuickRedirect f13459a;

                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f13459a, false, 7291, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                                                LogUtil.m15942a(MzFunnySnapUI.f13325b, "TYPE_MOBILE, file is not download, start download!");
                                                MzFunnySnapUI.this.f13336K.mo20455a(String.valueOf(a2.mo19342a()), a2.mo19352c(), a2.mo19354d(), a2.mo19355e());
                                                UsageStatsHelper.m16042a(MzFunnySnapUI.this.f13338M.getApplicationContext()).mo22691a("download_sticker", "type", "mobile");
                                                MzFunnySnapUI.this.m15339a(a2, Sticker.DownloadState.DOWNLOADING);
                                                MzFunnySnapUI.this.f13333H.mo17949l(true);
                                                String unused = MzFunnySnapUI.this.f13369am = a3;
                                                MzFunnySnapUI.this.m15314N();
                                            }
                                        }
                                    });
                                    break;
                                }
                            case 1:
                                LogUtil.m15942a(MzFunnySnapUI.f13325b, "TYPE_WIFI, file is not download, start download!");
                                MzFunnySnapUI.this.f13336K.mo20455a(String.valueOf(a2.mo19342a()), a2.mo19352c(), a2.mo19354d(), a2.mo19355e());
                                MzFunnySnapUI.this.m15339a(a2, Sticker.DownloadState.DOWNLOADING);
                                UsageStatsHelper.m16042a(MzFunnySnapUI.this.f13338M.getApplicationContext()).mo22691a("download_sticker", "type", "wifi");
                                break;
                        }
                    } else {
                        LogUtil.m15942a(MzFunnySnapUI.f13325b, "TYPE_BLUETOOTH, file is not download, start download!");
                        MzFunnySnapUI.this.f13336K.mo20455a(String.valueOf(a2.mo19342a()), a2.mo19352c(), a2.mo19354d(), a2.mo19355e());
                        MzFunnySnapUI.this.m15339a(a2, Sticker.DownloadState.DOWNLOADING);
                        UsageStatsHelper.m16042a(MzFunnySnapUI.this.f13338M.getApplicationContext()).mo22691a("download_sticker", "type", "blue_tooth");
                    }
                    MzFunnySnapUI.this.m15314N();
                } else if (a == -1) {
                    MzFunnySnapUI.this.m15316O();
                } else {
                    StickerCategory a4 = MzFunnySnapUI.this.f13403w.mo18776a(currentItem);
                    MzFunnySnapUI.this.f13336K.mo20460b(String.valueOf(a4.mo19360a()));
                    MzFunnySnapUI.this.f13336K.mo20453a(String.valueOf(a4.mo19360a()));
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: aC */
    public AlertDialog f13354aC;
    /* access modifiers changed from: private */

    /* renamed from: aD */
    public AlertDialog f13355aD;
    /* access modifiers changed from: private */

    /* renamed from: aE */
    public Camera.PreviewCallback f13356aE = new Camera.PreviewCallback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13471a;

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Class[] clsArr = {byte[].class, Camera.class};
            if (!PatchProxy.proxy(new Object[]{bArr, camera}, this, f13471a, false, 7296, clsArr, Void.TYPE).isSupported) {
                if (MzFunnySnapUI.this.f13334I != null) {
                    if (!MzFunnySnapUI.this.f13334I.mo20448M()) {
                        GlobalParams.setScreenAngle(MzFunnySnapUI.this.f13334I.mo20447L());
                    } else {
                        return;
                    }
                }
                if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                    Camera.Size previewSize = camera.getParameters().getPreviewSize();
                    MzFaceDetectArc.getInstance().faceDetection(bArr, previewSize.width, previewSize.height);
                    if (MzFunnySnapUI.this.f13343R != null) {
                        MzFunnySnapUI.this.f13343R.requestRender();
                    }
                }
                MzFunnySnapUI.this.f13378av.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13473a;

                    public void run() {
                        int i = 0;
                        if (!PatchProxy.proxy(new Object[0], this, f13473a, false, 7297, new Class[0], Void.TYPE).isSupported) {
                            if (!MzFunnySnapUI.this.f13374ar && !MzFunnySnapUI.this.f13371ao) {
                                MzFunnySnapUI.this.m15300G();
                            }
                            if (MzFunnySnapUI.this.f13368al < 3 || MzFunnySnapUI.this.f13333H.mo17907ad()) {
                                MzFunnySnapUI.m15319Q(MzFunnySnapUI.this);
                                return;
                            }
                            if (MzFunnySnapUI.this.f13333H.mo17904aa() || MzFunnySnapUI.this.f13372ap) {
                                MzFunnySnapUI.this.f13332G.mo22085a(!MzFunnySnapUI.this.f13333H.mo17908ae());
                                boolean unused = MzFunnySnapUI.this.f13372ap = false;
                                MzFunnySnapUI.this.mo22344a(false, (Bitmap) null);
                            }
                            if (!MzFaceDetectArc.getInstance().getFaceDetectResult()) {
                                MzFunnySnapUI.m15313N(MzFunnySnapUI.this);
                            } else {
                                int unused2 = MzFunnySnapUI.this.f13367ak = 0;
                            }
                            if (MzFunnySnapUI.this.f13384d != null) {
                                LinearLayout O = MzFunnySnapUI.this.f13384d;
                                if (MzFunnySnapUI.this.f13367ak < 10 || MzFunnySnapUI.this.f13371ao) {
                                    i = 8;
                                }
                                O.setVisibility(i);
                            }
                            MzFunnySnapUI.this.f13333H.mo17957w();
                        }
                    }
                });
            }
        }
    };

    /* renamed from: aa */
    private ComboPreferences f13357aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public int f13358ab = 720;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public int f13359ac;

    /* renamed from: ad */
    private CameraUtil.ScreeAspectRatio f13360ad = CameraUtil.ScreeAspectRatio.Ratio_4_3;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public int f13361ae = 70;
    /* access modifiers changed from: private */

    /* renamed from: af */
    public int f13362af = 70;

    /* renamed from: ag */
    private AnimatorSet f13363ag;
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public int f13364ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public boolean f13365ai = true;

    /* renamed from: aj */
    private int f13366aj = 0;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public int f13367ak = 0;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public int f13368al = 0;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public String f13369am;

    /* renamed from: an */
    private String f13370an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public boolean f13371ao = false;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public boolean f13372ap = false;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public boolean f13373aq = true;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public boolean f13374ar = false;

    /* renamed from: as */
    private boolean f13375as = false;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public boolean f13376at = false;

    /* renamed from: au */
    private ObjectAnimator f13377au;
    /* access modifiers changed from: private */

    /* renamed from: av */
    public Handler f13378av = new Handler(Looper.getMainLooper());

    /* renamed from: aw */
    private ViewPager.OnPageChangeListener f13379aw = new MzFunnySnapUI$1(this);

    /* renamed from: ax */
    private StickerAdapter.C1792a f13380ax = new StickerAdapter.C1792a() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13431a;

        /* renamed from: a */
        public String mo18773a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13431a, false, 7309, new Class[0], String.class);
            return proxy.isSupported ? (String) proxy.result : MzFunnySnapUI.this.f13369am;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: ay */
    public Runnable f13381ay = new Runnable() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13441a;

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f13441a, false, 7314, new Class[0], Void.TYPE).isSupported) {
                if (MzFunnySnapUI.this.f13327B != null) {
                    MzFunnySnapUI.this.f13327B.setVisibility(8);
                }
                if (MzFunnySnapUI.this.f13404x != null) {
                    MzFunnySnapUI.this.f13404x.setAlpha(0.7f);
                }
            }
        }
    };

    /* renamed from: az */
    private MzCommonUI.C2403f f13382az = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13445a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f13445a, false, 7316, new Class[0], Void.TYPE).isSupported) {
                MzFunnySnapUI.this.f13383c.setVisibility(8);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f13445a, false, 7317, new Class[0], Void.TYPE).isSupported) {
                MzFunnySnapUI.this.f13383c.setVisibility(0);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f13383c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LinearLayout f13384d;

    /* renamed from: e */
    private Button f13385e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FrameLayout f13386f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FrameLayout f13387g;

    /* renamed from: h */
    private FrameLayout f13388h;

    /* renamed from: i */
    private FrameLayout f13389i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LinearLayout f13390j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public FilterRecyclerView f13391k;

    /* renamed from: l */
    private CenterLockListener f13392l;

    /* renamed from: m */
    private TextView f13393m;

    /* renamed from: n */
    private LinearLayoutManager f13394n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public LookupFilterFactory.C2762Filter[] f13395o = FilterList.sLutFilterTable;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C2564c f13396p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f13397q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f13398r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public LinearLayout f13399s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public LinearLayout f13400t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public SlidingTabLayout f13401u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public ViewPager f13402v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public StickerPagerAdapter f13403w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public SeekBar f13404x;

    /* renamed from: y */
    private Button f13405y;

    /* renamed from: z */
    private Button f13406z;

    /* renamed from: com.meizu.media.camera.ui.p$a */
    /* compiled from: MzFunnySnapUI */
    public interface C2562a {
        /* renamed from: B */
        int mo20445B();

        /* renamed from: K */
        boolean mo20446K();

        /* renamed from: a */
        void mo20453a(String str);

        /* renamed from: a */
        void mo20454a(String str, int i);

        /* renamed from: a */
        void mo20455a(String str, String str2, int i, boolean z);

        /* renamed from: a */
        void mo20456a(String str, boolean z);

        /* renamed from: b */
        void mo20460b(String str);

        /* renamed from: c */
        void mo20462c(String str);

        /* renamed from: d */
        void mo20465d(String str);

        /* renamed from: f */
        void mo20467f(String str);
    }

    /* renamed from: com.meizu.media.camera.ui.p$b */
    /* compiled from: MzFunnySnapUI */
    public interface C2563b {
        /* renamed from: L */
        int mo20447L();

        /* renamed from: M */
        boolean mo20448M();

        /* renamed from: b */
        void mo20459b(Bitmap bitmap);

        /* renamed from: e */
        void mo20466e(String str);
    }

    /* renamed from: d */
    public void mo22351d() {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* renamed from: N */
    static /* synthetic */ int m15313N(MzFunnySnapUI pVar) {
        int i = pVar.f13367ak;
        pVar.f13367ak = i + 1;
        return i;
    }

    /* renamed from: Q */
    static /* synthetic */ int m15319Q(MzFunnySnapUI pVar) {
        int i = pVar.f13368al;
        pVar.f13368al = i + 1;
        return i;
    }

    public void onClick(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f13324a, false, 7207, new Class[]{View.class}, Void.TYPE).isSupported) {
            switch (view.getId()) {
                case R.id.mz_fs_ar_enter_btn:
                    EventBus.m21789a().mo27980d(13);
                    return;
                case R.id.mz_fs_cancel_bt:
                    if (!TextUtils.isEmpty(GlobalParams.getCurrentSticker())) {
                        mo22362n();
                        UsageStatsHelper.m16042a(this.f13338M.getApplicationContext()).mo22695b("clean_sticker");
                        return;
                    }
                    return;
                case R.id.mz_fs_cancel_seekbar_bt:
                    m15365f(false);
                    return;
                case R.id.mz_fs_show_filter_bt:
                    mo22352d(false);
                    mo22350c(true);
                    UsageStatsHelper.m16042a(this.f13338M.getApplicationContext()).mo22695b("open_fs_filter_window");
                    return;
                case R.id.mz_fs_show_sticker_bt:
                    if (this.f13390j.getVisibility() == 4) {
                        this.f13390j.setVisibility(8);
                    }
                    mo22352d(false);
                    mo22347b(true);
                    UsageStatsHelper.m16042a(this.f13338M.getApplicationContext()).mo22695b("open_sticker_window");
                    return;
                case R.id.mz_fs_thin_face_bt:
                    this.f13350Y = true;
                    this.f13404x.setProgress(this.f13362af);
                    m15365f(true);
                    return;
                case R.id.mz_fs_whiten_skin_bt:
                    this.f13350Y = false;
                    this.f13404x.setProgress(this.f13361ae);
                    m15365f(true);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void mo20289a(String str, boolean z, boolean z2) {
        Object[] objArr = {str, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7208, new Class[]{String.class, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && this.f13345T != null) {
            LogUtil.C2630a aVar = f13325b;
            LogUtil.m15942a(aVar, "mFunnyDataManager.isMultiDownload():" + this.f13336K.mo20446K());
            if (z2) {
                if (!this.f13336K.mo20446K()) {
                    this.f13369am = Storage.m7750a().mo18621a(this.f13338M, str);
                    m15358d(Storage.m7750a().mo18621a(this.f13338M, str));
                    m15345a(z, str);
                    UsageStatsHelper.m16042a(this.f13338M.getApplicationContext()).mo22691a("select_sticker", "id", str);
                } else if (TextUtils.isEmpty(GlobalParams.getCurrentSticker()) && this.f13336K.mo20445B() == 0) {
                    this.f13369am = Storage.m7750a().mo18621a(this.f13338M, str);
                    m15358d(Storage.m7750a().mo18621a(this.f13338M, str));
                    m15345a(z, str);
                    UsageStatsHelper.m16042a(this.f13338M.getApplicationContext()).mo22691a("select_sticker", "id", str);
                }
            }
            new AsyncTaskEx<String, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13412a;

                /* renamed from: a */
                public Void mo17658a(String... strArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{strArr}, this, f13412a, false, 7299, new Class[]{String[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    MzFunnySnapUI.this.f13336K.mo20465d(strArr[0]);
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new String[]{str});
        }
    }

    /* renamed from: a */
    public void mo20288a(final String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13324a, false, 7209, new Class[]{String.class}, Void.TYPE).isSupported && this.f13403w != null) {
            LogUtil.C2630a aVar = f13325b;
            LogUtil.m15942a(aVar, "onStickerFileVerifyFailed  stickerId:" + str);
            this.f13336K.mo20467f(str);
            this.f13378av.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13428a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f13428a, false, 7308, new Class[0], Void.TYPE).isSupported) {
                        MzFunnySnapUI.this.f13403w.mo18782c(str);
                        MzFunnySnapUI.this.m15314N();
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public void mo20290b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13324a, false, 7210, new Class[]{String.class}, Void.TYPE).isSupported && this.f13403w != null) {
            LogUtil.C2630a aVar = f13325b;
            LogUtil.m15942a(aVar, "onStickerFileDownloadFailed  stickerId:" + str);
            ArrayList<Sticker> b = this.f13403w.mo18780b(str);
            LogUtil.C2630a aVar2 = f13325b;
            LogUtil.m15942a(aVar2, "stickers size:" + b.size());
            Iterator<Sticker> it = b.iterator();
            while (it.hasNext()) {
                Sticker next = it.next();
                if (next != null) {
                    next.mo19345a(Sticker.DownloadState.DOWNLOAD_FAILED);
                    this.f13336K.mo20454a(str, Sticker.DownloadState.DOWNLOAD_FAILED.ordinal());
                }
            }
            m15314N();
        }
    }

    /* renamed from: a */
    public void mo20287a() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7211, new Class[0], Void.TYPE).isSupported) {
            this.f13378av.post(new Runnable() {
                public final void run() {
                    MzFunnySnapUI.this.m15324S();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public /* synthetic */ void m15324S() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7281, new Class[0], Void.TYPE).isSupported && this.f13402v != null && this.f13403w != null) {
            this.f13336K.mo20453a(String.valueOf(this.f13403w.mo18783d(this.f13402v.getCurrentItem())));
        }
    }

    public MzFunnySnapUI(CameraActivity cameraActivity, CameraBinding cameraBinding, MzCamUI iVar, MzCamController mzCamController) {
        MzFunnySnapContainerBinding mzFunnySnapContainerBinding;
        int indexOf;
        LogUtil.m15942a(f13325b, "MzFunnySnapUI start");
        this.f13339N = cameraActivity;
        this.f13338M = cameraActivity.mo17639f();
        this.f13333H = mzCamController;
        this.f13335J = cameraBinding;
        DelayInflateOneBinding delayInflateOneBinding = (DelayInflateOneBinding) cameraBinding.f9508g.getBinding();
        if (delayInflateOneBinding.f9560e.getViewStub() != null) {
            mzFunnySnapContainerBinding = (MzFunnySnapContainerBinding) DataBindingUtil.bind(delayInflateOneBinding.f9560e.getViewStub().inflate());
        } else {
            mzFunnySnapContainerBinding = (MzFunnySnapContainerBinding) delayInflateOneBinding.f9560e.getBinding();
        }
        if (!EventBus.m21789a().mo27978b(this)) {
            EventBus.m21789a().mo27974a((Object) this);
        }
        this.f13341P = mzFunnySnapContainerBinding.f9730a;
        this.f13341P.removeAllViews();
        LayoutInflater.from(cameraActivity).inflate(R.layout.mz_funny_snap_view, this.f13341P, true);
        this.f13342Q = (TextureView) this.f13341P.findViewById(R.id.funnyTextureView);
        this.f13342Q.setSurfaceTextureListener(this);
        this.f13342Q.setAlpha(0.01f);
        LogUtil.C2630a aVar = f13325b;
        LogUtil.m15942a(aVar, "MzFunnySnapUI mTextureView：" + this.f13342Q);
        m15362e(true);
        this.f13332G = iVar;
        this.f13332G.mo22076a(this.f13341P);
        this.f13357aa = ComboPreferences.m10003a(this.f13338M.getApplicationContext());
        this.f13366aj = this.f13357aa.getInt("funny_mode_launch_time", 0);
        this.f13398r = this.f13357aa.getInt("funny_mode_filter", 1);
        this.f13357aa.edit().putInt("funny_mode_launch_time", this.f13366aj + 1).apply();
        String string = ComboPreferences.m10008b(this.f13338M, 1).getString("pref_camera_picturesize_key", (String) null);
        if (!(string == null || (indexOf = string.indexOf(120)) == -1)) {
            this.f13360ad = CameraUtil.m15829a(Float.parseFloat(string.substring(0, indexOf)) / Float.parseFloat(string.substring(indexOf + 1)));
        }
        if (this.f13357aa != null) {
            LogUtil.C2630a aVar2 = f13325b;
            LogUtil.m15952c(aVar2, "MzFunnySnapUI picture-size: " + this.f13357aa.getString("pref_camera_picturesize_key", "") + " AspectRatio:" + this.f13360ad);
        }
        this.f13359ac = m15331a(this.f13360ad);
        GlobalParams.setRenderSize(this.f13358ab, this.f13359ac);
        this.f13403w = new StickerPagerAdapter(this.f13338M, this.f13340O, this.f13353aB, this.f13380ax);
        m15311M();
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m15300G() {
        MzFunnysnapBinding mzFunnysnapBinding;
        MzFunnySnapNoFaceBinding mzFunnySnapNoFaceBinding;
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7212, new Class[0], Void.TYPE).isSupported && !this.f13374ar) {
            this.f13374ar = true;
            DelayInflateTwoBinding delayInflateTwoBinding = (DelayInflateTwoBinding) this.f13335J.f9509h.getBinding();
            if (delayInflateTwoBinding.f9579j.getViewStub() != null) {
                mzFunnysnapBinding = (MzFunnysnapBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9579j.getViewStub().inflate());
            } else {
                mzFunnysnapBinding = (MzFunnysnapBinding) delayInflateTwoBinding.f9579j.getBinding();
            }
            this.f13383c = mzFunnysnapBinding.f9760u;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13383c.getLayoutParams();
            layoutParams.bottomMargin = CameraUtil.m15897f();
            this.f13383c.setLayoutParams(layoutParams);
            if (delayInflateTwoBinding.f9578i.getViewStub() != null) {
                mzFunnySnapNoFaceBinding = (MzFunnySnapNoFaceBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9578i.getViewStub().inflate());
            } else {
                mzFunnySnapNoFaceBinding = (MzFunnySnapNoFaceBinding) delayInflateTwoBinding.f9578i.getBinding();
            }
            this.f13384d = mzFunnySnapNoFaceBinding.f9735a;
            int i = 8;
            this.f13384d.setVisibility(8);
            this.f13384d.setAlpha(1.0f);
            if (this.f13383c != null) {
                this.f13399s = mzFunnysnapBinding.f9755p;
                this.f13399s.setVisibility(4);
                this.f13399s.setAlpha(0.0f);
                this.f13400t = mzFunnysnapBinding.f9745f;
                this.f13400t.setTranslationY(0.0f);
                this.f13400t.setVisibility(8);
                this.f13385e = mzFunnysnapBinding.f9747h;
                this.f13385e.setOnClickListener(this);
                this.f13386f = mzFunnysnapBinding.f9749j;
                this.f13386f.setVisibility(0);
                this.f13386f.setAlpha(1.0f);
                this.f13388h = mzFunnysnapBinding.f9754o;
                this.f13389i = mzFunnysnapBinding.f9753n;
                this.f13388h.setOnClickListener(this);
                this.f13389i.setOnClickListener(this);
                if (CameraModeType.m10985n(CameraModeType.ModeType.AR)) {
                    this.f13387g = mzFunnysnapBinding.f9741b;
                    this.f13387g.setVisibility(0);
                    this.f13328C = mzFunnysnapBinding.f9742c;
                    this.f13329D = mzFunnysnapBinding.f9743d;
                    this.f13328C.setVisibility(CameraUtil.m15914t() ? 8 : 0);
                    ProgressBar progressBar = this.f13329D;
                    if (CameraUtil.m15914t()) {
                        i = 0;
                    }
                    progressBar.setVisibility(i);
                    this.f13387g.setOnClickListener(this);
                    this.f13387g.setClickable(!CameraUtil.m15914t());
                } else {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f13386f.getLayoutParams();
                    layoutParams2.width = this.f13338M.getResources().getDimensionPixelOffset(R.dimen.mz_funny_snap_control_btn_width_without_ar);
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f13389i.getLayoutParams();
                    layoutParams3.gravity = 5;
                    this.f13386f.setLayoutParams(layoutParams2);
                    this.f13389i.setLayoutParams(layoutParams3);
                }
                this.f13390j = mzFunnysnapBinding.f9750k;
                this.f13391k = mzFunnysnapBinding.f9751l;
                this.f13393m = mzFunnysnapBinding.f9752m;
                this.f13394n = new CenterLockLayoutManager(this.f13339N, this.f13338M.getResources().getDimensionPixelSize(R.dimen.mz_filter_center_point), this.f13338M.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_width), this.f13338M.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_width_selected));
                this.f13394n.mo26076b(0);
                this.f13391k.setLayoutManager(this.f13394n);
                this.f13392l = new CenterLockListener(this.f13338M.getResources().getDimensionPixelSize(R.dimen.mz_filter_center_point), this.f13338M.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_width), this.f13338M.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_width_selected), this.f13338M.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_height), this.f13338M.getResources().getDimensionPixelSize(R.dimen.mz_funny_snap_sticker_item_height_selected));
                this.f13396p = new C2564c(this.f13338M);
                this.f13391k.setAdapter(this.f13396p);
                this.f13391k.setShouldIntercept(false);
                this.f13391k.setOnScrollListener(this.f13392l);
                this.f13391k.setSelectorCanDraw(false);
                this.f13391k.setOnItemClickListener(new MzRecyclerView.C3227j() {
                    public final void onItemClick(RecyclerView recyclerView, View view, int i, long j) {
                        MzFunnySnapUI.this.m15344a(recyclerView, view, i, j);
                    }
                });
                this.f13390j.setVisibility(4);
                this.f13390j.setAlpha(0.0f);
                m15349b(this.f13398r, false);
                this.f13402v = mzFunnysnapBinding.f9758s;
                this.f13401u = mzFunnysnapBinding.f9756q;
                this.f13402v.setAdapter(this.f13403w);
                this.f13402v.addOnPageChangeListener(this.f13379aw);
                if (!this.f13376at && this.f13331F != null) {
                    this.f13403w.mo18778a((List<StickerCategory>) this.f13331F);
                    this.f13403w.notifyDataSetChanged();
                    m15314N();
                }
                this.f13405y = mzFunnysnapBinding.f9759t;
                this.f13406z = mzFunnysnapBinding.f9757r;
                this.f13326A = mzFunnysnapBinding.f9748i;
                this.f13405y.setOnClickListener(this);
                this.f13406z.setOnClickListener(this);
                this.f13326A.setOnClickListener(this);
                this.f13404x = mzFunnysnapBinding.f9746g;
                this.f13327B = mzFunnysnapBinding.f9744e;
                this.f13327B.setTypeface(Typeface.create("Flyme-Medium", 0));
                this.f13404x.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13436a;

                    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                        if (!PatchProxy.proxy(new Object[]{seekBar, new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f13436a, false, 7310, new Class[]{SeekBar.class, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
                            LogUtil.C2630a F = MzFunnySnapUI.f13325b;
                            LogUtil.m15952c(F, "onProgressChanged - update FaceBeautyLevel: " + i);
                            if (MzFunnySnapUI.this.f13350Y) {
                                int unused = MzFunnySnapUI.this.f13362af = i;
                                MzFunnySnapUI.this.f13327B.setText(String.format(MzFunnySnapUI.this.f13338M.getString(R.string.mz_funny_cam_thin_face_hint), new Object[]{Integer.valueOf(i)}));
                            } else {
                                int unused2 = MzFunnySnapUI.this.f13361ae = i;
                                MzFunnySnapUI.this.f13327B.setText(String.format(MzFunnySnapUI.this.f13338M.getString(R.string.mz_funny_cam_whiten_skin_hint), new Object[]{Integer.valueOf(i)}));
                            }
                            MzFunnySnapUI.this.m15336a(i, MzFunnySnapUI.this.f13350Y);
                        }
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                        if (!PatchProxy.proxy(new Object[]{seekBar}, this, f13436a, false, 7311, new Class[]{SeekBar.class}, Void.TYPE).isSupported) {
                            MzFunnySnapUI.this.f13378av.removeCallbacks(MzFunnySnapUI.this.f13381ay);
                            MzFunnySnapUI.this.f13404x.setAlpha(1.0f);
                            MzFunnySnapUI.this.f13327B.setVisibility(0);
                        }
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        if (!PatchProxy.proxy(new Object[]{seekBar}, this, f13436a, false, 7312, new Class[]{SeekBar.class}, Void.TYPE).isSupported) {
                            MzFunnySnapUI.this.f13378av.postDelayed(MzFunnySnapUI.this.f13381ay, 2000);
                        }
                    }
                });
                this.f13361ae = this.f13357aa.getInt("funny_whiten_skin_level", 70);
                this.f13362af = this.f13357aa.getInt("funny_thin_face_level", 70);
                this.f13404x.setMax(100);
                m15336a(this.f13361ae, false);
                m15336a(this.f13362af, true);
                if (this.f13403w != null && this.f13403w.getCount() > 1 && this.f13365ai) {
                    this.f13402v.setCurrentItem(1);
                    this.f13365ai = false;
                    m15306J();
                    final int currentItem = this.f13402v.getCurrentItem();
                    new AsyncTaskEx<Void, Void, Void>() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f13438a;

                        /* renamed from: a */
                        public Void mo17658a(Void... voidArr) {
                            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f13438a, false, 7313, new Class[]{Void[].class}, Void.class);
                            if (proxy.isSupported) {
                                return (Void) proxy.result;
                            }
                            if (MzFunnySnapUI.this.f13371ao) {
                                return null;
                            }
                            StickerCategory a = MzFunnySnapUI.this.f13403w.mo18776a(currentItem);
                            if (a != null && a.mo19369e().booleanValue()) {
                                a.mo19362a((Boolean) false);
                                MzFunnySnapUI.this.f13336K.mo20456a(String.valueOf(a.mo19360a()), false);
                            }
                            if (!MzFunnySnapUI.this.f13365ai && a != null) {
                                MzFunnySnapUI.this.f13336K.mo20453a(String.valueOf(a.mo19360a()));
                            }
                            return null;
                        }
                    }.mo22614c((Params[]) new Void[0]);
                }
                if (!m15304I()) {
                    m15302H();
                }
                m15365f(false);
                m15311M();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15344a(RecyclerView recyclerView, View view, int i, long j) {
        Object[] objArr = {recyclerView, view, new Integer(i), new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7280, new Class[]{RecyclerView.class, View.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported && this.f13345T != null && this.f13398r != i && this.f13395o.length > i) {
            SelectAdapter pVar = (SelectAdapter) recyclerView.getAdapter();
            if (i != pVar.mo23409b()) {
                recyclerView.mo26403g(i);
                pVar.mo20095a(i);
            }
            this.f13398r = i;
            this.f13345T.setFilter(this.f13395o[i].getFilterID());
            UsageStatsHelper.m16042a(this.f13338M.getApplicationContext()).mo22691a("select_fs_filter", "filter_value", this.f13395o[i].getFilterNameEn());
            LogUtil.C2630a aVar = f13325b;
            LogUtil.m15952c(aVar, "set Funny Filter:" + this.f13395o[i].getFilterID());
        }
    }

    /* renamed from: H */
    private void m15302H() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7213, new Class[0], Void.TYPE).isSupported) {
            GuideHintView.f14589a.mo22899a(GuideHintView.HintKind.FUNNY_CAM_HINT, this.f13339N);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: I */
    private boolean m15304I() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7214, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!CameraModeType.m10985n(CameraModeType.ModeType.AR) || !GuideHintView.f14589a.mo22899a(GuideHintView.HintKind.FUNNY_AR_HINT, this.f13339N)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public void m15306J() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7215, new Class[0], Void.TYPE).isSupported && this.f13401u != null) {
            LogUtil.C2630a aVar = f13325b;
            LogUtil.m15942a(aVar, "mStickerTab.getTabCount():" + this.f13401u.getTabCount());
            String[] strArr = new String[this.f13403w.getCount()];
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = this.f13403w.getPageTitle(i);
                if (this.f13403w.mo18776a(i).mo19369e().booleanValue()) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            this.f13401u.setViewPager(this.f13402v, strArr);
            this.f13401u.setCurrentTab(this.f13402v.getCurrentItem());
            this.f13401u.mo23186a();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                this.f13401u.mo23187a(intValue);
                this.f13401u.setMsgMargin(intValue, 2.0f, 2.0f);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public void m15307K() {
        String a;
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7216, new Class[0], Void.TYPE).isSupported && this.f13340O.size() > 1 && this.f13340O.get(1).getItemCount() > 0 && this.f13357aa.mo19978b() != null && (a = Storage.m7750a().mo18621a(this.f13338M, String.valueOf(this.f13340O.get(1).mo18768a(0).mo19342a()))) != null) {
            this.f13369am = a;
            m15358d(a);
            this.f13373aq = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d8, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo22345b() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d9 }
            com.meizu.savior.ChangeQuickRedirect r3 = f13324a     // Catch:{ all -> 0x00d9 }
            r4 = 0
            r5 = 7217(0x1c31, float:1.0113E-41)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x00d9 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x00d9 }
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00d9 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x0018
            monitor-exit(r8)
            return
        L_0x0018:
            com.meizu.media.camera.util.ac$a r0 = f13325b     // Catch:{ all -> 0x00d9 }
            java.lang.String r1 = "prepareTextureController"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)     // Catch:{ all -> 0x00d9 }
            int r0 = com.meizu.media.camera.util.DeviceHelper.f13943bq     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams.FRAME_TYPE = r0     // Catch:{ all -> 0x00d9 }
            int r0 = com.meizu.media.camera.util.DeviceHelper.f13938bl     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.GlobalParams.BEAUTY_LOOKUPTABLE_TYPE = r0     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.MzFaceDetectArc r0 = com.meizu.media.mzfunnysnapsdk.MZUtil.MzFaceDetectArc.getInstance()     // Catch:{ all -> 0x00d9 }
            java.lang.String r1 = "ArcSoft"
            r0.initProcessor(r1)     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.TextureController r0 = new com.meizu.media.mzfunnysnapsdk.MZUtil.TextureController     // Catch:{ all -> 0x00d9 }
            android.content.Context r1 = r8.f13338M     // Catch:{ all -> 0x00d9 }
            r0.<init>(r1)     // Catch:{ all -> 0x00d9 }
            r8.f13343R = r0     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.TextureController r0 = r8.f13343R     // Catch:{ all -> 0x00d9 }
            android.content.Context r1 = r8.f13338M     // Catch:{ all -> 0x00d9 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ all -> 0x00d9 }
            r2 = 2131231378(0x7f080292, float:1.8078835E38)
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeResource(r1, r2)     // Catch:{ all -> 0x00d9 }
            r0.setShortVideoWaterBitmap(r1)     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MzShortVideoController r0 = new com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MzShortVideoController     // Catch:{ all -> 0x00d9 }
            r0.<init>()     // Catch:{ all -> 0x00d9 }
            r8.f13346U = r0     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MzShortVideoController r0 = r8.f13346U     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.TextureController r1 = r8.f13343R     // Catch:{ all -> 0x00d9 }
            r0.setTextureController(r1)     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MzPlayAudioClass r0 = new com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.MzPlayAudioClass     // Catch:{ all -> 0x00d9 }
            android.content.Context r1 = r8.f13338M     // Catch:{ all -> 0x00d9 }
            r0.<init>(r1)     // Catch:{ all -> 0x00d9 }
            r8.f13344S = r0     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.FilterLoader r0 = new com.meizu.media.mzfunnysnapsdk.MZUtil.FilterLoader     // Catch:{ all -> 0x00d9 }
            int r1 = r8.f13358ab     // Catch:{ all -> 0x00d9 }
            int r2 = r8.f13359ac     // Catch:{ all -> 0x00d9 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x00d9 }
            r8.f13345T = r0     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.FilterLoader r0 = r8.f13345T     // Catch:{ all -> 0x00d9 }
            r1 = 1
            if (r0 == 0) goto L_0x00b3
            android.content.Context r0 = r8.f13338M     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00b3
            com.meizu.media.mzfunnysnapsdk.MZUtil.TextureController r0 = r8.f13343R     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00b3
            boolean r0 = r8.f13375as     // Catch:{ all -> 0x00d9 }
            if (r0 != 0) goto L_0x00b3
            r8.f13375as = r1     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.FilterLoader r0 = r8.f13345T     // Catch:{ all -> 0x00d9 }
            android.content.Context r2 = r8.f13338M     // Catch:{ all -> 0x00d9 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.TextureController r3 = r8.f13343R     // Catch:{ all -> 0x00d9 }
            r0.setupFilter(r2, r3)     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.FilterLoader r0 = r8.f13345T     // Catch:{ all -> 0x00d9 }
            int r2 = r8.f13358ab     // Catch:{ all -> 0x00d9 }
            int r3 = r8.f13359ac     // Catch:{ all -> 0x00d9 }
            r0.updataStickerFilterRatio(r2, r3)     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.FilterLoader r0 = r8.f13345T     // Catch:{ all -> 0x00d9 }
            int r2 = r8.f13358ab     // Catch:{ all -> 0x00d9 }
            int r3 = r8.f13359ac     // Catch:{ all -> 0x00d9 }
            r0.updataReshapeFilterRatio(r2, r3)     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.FilterLoader r0 = r8.f13345T     // Catch:{ all -> 0x00d9 }
            r0.removeStickerFilterGroup()     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.MZUtil.FilterLoader r0 = r8.f13345T     // Catch:{ all -> 0x00d9 }
            com.meizu.media.mzfunnysnapsdk.Filter.LookupFilterFactory$Filter[] r2 = r8.f13395o     // Catch:{ all -> 0x00d9 }
            int r3 = r8.f13398r     // Catch:{ all -> 0x00d9 }
            r2 = r2[r3]     // Catch:{ all -> 0x00d9 }
            int r2 = r2.getFilterID()     // Catch:{ all -> 0x00d9 }
            r0.setFilter(r2)     // Catch:{ all -> 0x00d9 }
        L_0x00b3:
            java.lang.String r0 = r8.f13369am     // Catch:{ all -> 0x00d9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00d9 }
            if (r0 != 0) goto L_0x00c0
            java.lang.String r0 = r8.f13369am     // Catch:{ all -> 0x00d9 }
            r8.m15358d((java.lang.String) r0)     // Catch:{ all -> 0x00d9 }
        L_0x00c0:
            java.lang.String r0 = r8.f13370an     // Catch:{ all -> 0x00d9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00d9 }
            if (r0 != 0) goto L_0x00d7
            com.meizu.media.camera.ui.p$b r0 = r8.f13334I     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00d7
            com.meizu.media.camera.ui.p$b r0 = r8.f13334I     // Catch:{ all -> 0x00d9 }
            boolean r0 = r0.mo20448M()     // Catch:{ all -> 0x00d9 }
            if (r0 != 0) goto L_0x00d7
            r8.m15374j((boolean) r1)     // Catch:{ all -> 0x00d9 }
        L_0x00d7:
            monitor-exit(r8)
            return
        L_0x00d9:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p077ui.MzFunnySnapUI.mo22345b():void");
    }

    /* renamed from: c */
    public SurfaceTexture mo22348c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7218, new Class[0], SurfaceTexture.class);
        if (proxy.isSupported) {
            return (SurfaceTexture) proxy.result;
        }
        if (this.f13343R == null) {
            mo22345b();
        }
        LogUtil.C2630a aVar = f13325b;
        LogUtil.m15942a(aVar, "getSurfaceTexture mTextureController:" + this.f13343R);
        if (this.f13343R == null) {
            return null;
        }
        SurfaceTexture texture = this.f13343R.getTexture();
        if (!(texture == null || this.f13333H == null)) {
            this.f13378av.post(new Runnable() {
                public final void run() {
                    MzFunnySnapUI.this.m15322R();
                }
            });
            this.f13333H.mo17957w();
        }
        return texture;
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ void m15322R() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7279, new Class[0], Void.TYPE).isSupported) {
            this.f13332G.mo22066a(this.f13358ab, this.f13359ac);
        }
    }

    /* renamed from: a */
    public void mo22344a(boolean z, Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), bitmap}, this, f13324a, false, 7219, new Class[]{Boolean.TYPE, Bitmap.class}, Void.TYPE).isSupported) {
            if (z && this.f13341P.getChildCount() == 1) {
                this.f13368al = 0;
                ImageView imageView = new ImageView(this.f13338M);
                imageView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                this.f13341P.addView(imageView, 1, new FrameLayout.LayoutParams(-1, -1));
                if (bitmap != null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setImageBitmap(bitmap);
                }
                this.f13372ap = true;
            } else if (!z && this.f13341P.getChildCount() > 1) {
                this.f13341P.removeViewAt(1);
            }
        }
    }

    /* renamed from: a */
    public void mo22336a(float f) {
        if (!PatchProxy.proxy(new Object[]{new Float(f)}, this, f13324a, false, 7220, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f13342Q.setAlpha(1.0f);
            if (this.f13332G != null) {
                this.f13332G.mo22143b(false, true);
            }
            CameraUtil.ScreeAspectRatio a = CameraUtil.m15829a(f);
            if (a != this.f13360ad && this.f13343R != null) {
                this.f13360ad = a;
                m15311M();
                m15310L();
            }
        }
    }

    /* renamed from: L */
    private void m15310L() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7221, new Class[0], Void.TYPE).isSupported && this.f13342Q != null) {
            Point l = CameraController.m8868g().mo19524l();
            if (l != null) {
                this.f13358ab = l.y;
                this.f13359ac = l.x;
            }
            this.f13343R.setDataSize(this.f13358ab, this.f13359ac);
            this.f13343R.surfaceChanged(this.f13342Q.getWidth(), this.f13342Q.getHeight());
            GlobalParams.setRenderSize(this.f13358ab, this.f13359ac);
            if (this.f13345T != null) {
                this.f13345T.updataStickerFilterRatio(this.f13358ab, this.f13359ac);
                this.f13345T.updataReshapeFilterRatio(this.f13358ab, this.f13359ac);
            }
            this.f13343R.setFrameCallback(0, 0, (FrameCallback) null);
            this.f13343R.setFrameCallback(this.f13358ab, this.f13359ac, this);
        }
    }

    /* renamed from: a */
    private int m15331a(CameraUtil.ScreeAspectRatio screeAspectRatio) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{screeAspectRatio}, this, f13324a, false, 7222, new Class[]{CameraUtil.ScreeAspectRatio.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        switch (screeAspectRatio) {
            case Ratio_4_3:
                return 960;
            case Ratio_16_9:
                return 1280;
            case Ratio_18_9:
                return 1440;
            default:
                return 960;
        }
    }

    /* renamed from: M */
    private void m15311M() {
        int i = 0;
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7223, new Class[0], Void.TYPE).isSupported && (this.f13342Q.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13342Q.getLayoutParams();
            if (this.f13360ad == CameraUtil.ScreeAspectRatio.Ratio_4_3) {
                if (!NavigationBarUtils.m15972a() || DeviceHelper.f13874aa) {
                    layoutParams.topMargin = CameraUtil.m15901h() - 1;
                } else {
                    layoutParams.topMargin = 0;
                }
                layoutParams.bottomMargin = CameraUtil.m15897f() - 1;
            } else if (this.f13360ad == CameraUtil.ScreeAspectRatio.Ratio_16_9) {
                layoutParams.topMargin = DeviceHelper.f13874aa ? CameraUtil.m15901h() - 1 : 0;
                if (DeviceHelper.f13874aa) {
                    i = ((CameraUtil.m15865b() - CameraUtil.m15901h()) - ((int) (((float) CameraUtil.m15809a()) * 1.7777778f))) - 1;
                }
                layoutParams.bottomMargin = i;
            } else {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
            }
            this.f13342Q.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    public void mo22338a(MzUIController uVar) {
        this.f13337L = uVar;
    }

    /* renamed from: a */
    public void mo22339a(C2562a aVar) {
        this.f13336K = aVar;
    }

    /* renamed from: e */
    public void mo22353e() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7224, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f13325b, "onEnter");
            if (!this.f13374ar) {
                m15300G();
            }
            this.f13371ao = false;
            this.f13337L.mo21520a(this.f13382az);
            this.f13332G.mo22084a("Mznone");
            if (DeviceHelper.f13886am) {
                this.f13332G.mo22147c("Mznone");
            }
            mo22357i();
        }
    }

    /* renamed from: f */
    public void mo22354f() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7225, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f13325b, "onLeave");
            this.f13371ao = true;
            this.f13367ak = 0;
            this.f13332G.mo22138b(0);
            if (this.f13383c != null) {
                this.f13383c.setVisibility(8);
            }
            if (this.f13384d != null) {
                this.f13384d.setVisibility(8);
            }
        }
    }

    /* renamed from: g */
    public void mo22355g() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7226, new Class[0], Void.TYPE).isSupported && this.f13332G != null) {
            this.f13332G.mo22071a(mo22335a(this.f13358ab / 8, this.f13359ac / 8));
        }
    }

    /* renamed from: a */
    public Bitmap mo22335a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 7227, new Class[]{Integer.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (this.f13342Q == null) {
            return null;
        }
        TextureView textureView = this.f13342Q;
        if (i == 0) {
            i = this.f13358ab;
        }
        if (i2 == 0) {
            i2 = this.f13359ac;
        }
        return textureView.getBitmap(i, i2);
    }

    /* renamed from: a */
    public void mo22343a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13324a, false, 7228, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                if (this.f13383c != null) {
                    this.f13383c.setVisibility(8);
                }
                if (this.f13384d != null) {
                    this.f13384d.setAlpha(0.0f);
                    this.f13384d.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f13383c != null) {
                this.f13383c.setVisibility(0);
            }
            if (this.f13384d != null) {
                this.f13384d.setAlpha(1.0f);
            }
        }
    }

    /* renamed from: h */
    public void mo22356h() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7229, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f13325b, "release start");
            if (this.f13404x != null) {
                this.f13357aa.edit().putInt("funny_whiten_skin_level", this.f13361ae).apply();
                this.f13357aa.edit().putInt("funny_thin_face_level", this.f13362af).apply();
            }
            GuideHintView.f14589a.mo22900b(GuideHintView.HintKind.FUNNY_CAM_HINT, this.f13339N);
            GuideHintView.f14589a.mo22900b(GuideHintView.HintKind.FUNNY_AR_HINT, this.f13339N);
            EventBus.m21789a().mo27979c(this);
            this.f13357aa.edit().putInt("funny_mode_filter", this.f13398r).apply();
            this.f13371ao = true;
            if (CameraController.m8868g().mo19522k() != null) {
                CameraController.m8868g().mo19518i().post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13443a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f13443a, false, 7315, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19516h() == CameraController.CameraApi.API1) {
                            ((Camera) ((CameraProxyV1) CameraController.m8868g().mo19522k()).mo19730a()).setPreviewCallback((Camera.PreviewCallback) null);
                        }
                    }
                });
            }
            if (this.f13383c != null) {
                this.f13383c.setVisibility(8);
            }
            mo22362n();
            this.f13337L.mo21520a((MzCommonUI.C2403f) null);
            if (this.f13332G != null) {
                this.f13332G.mo22084a("Mznone");
                if (DeviceHelper.f13886am) {
                    this.f13332G.mo22147c("Mznone");
                }
            }
            if (this.f13384d != null) {
                this.f13384d.setVisibility(8);
            }
            if (this.f13402v != null) {
                this.f13402v.removeOnPageChangeListener(this.f13379aw);
                this.f13402v = null;
            }
            this.f13403w.mo18777a();
            this.f13403w = null;
            if (this.f13332G != null) {
                this.f13332G.mo22123al();
            }
            this.f13342Q.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            this.f13342Q = null;
            mo22377v();
            this.f13380ax = null;
            this.f13374ar = false;
            this.f13376at = false;
        }
    }

    /* renamed from: e */
    private void m15362e(boolean z) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13324a, false, 7230, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f13325b;
            LogUtil.m15942a(aVar, "setSurfaceViewVisiable showSurface:" + z);
            if (this.f13341P != null) {
                ViewGroup viewGroup = this.f13341P;
                if (!z) {
                    i = 8;
                }
                viewGroup.setVisibility(i);
            }
        }
    }

    /* renamed from: i */
    public void mo22357i() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7231, new Class[0], Void.TYPE).isSupported && !this.f13333H.mo17907ad() && this.f13383c != null && this.f13383c.getVisibility() != 0) {
            this.f13383c.setVisibility(0);
        }
    }

    /* renamed from: j */
    public boolean mo22358j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7232, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13383c != null && this.f13383c.getVisibility() == 0;
    }

    /* renamed from: a */
    public void mo22340a(C2563b bVar) {
        this.f13334I = bVar;
    }

    /* renamed from: b */
    public void mo22347b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7233, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || !this.f13352aA || this.f13399s == null) {
            return;
        }
        if (this.f13399s.getVisibility() != 0 && !z) {
            return;
        }
        if (this.f13399s.getVisibility() != 0 || !z) {
            m15368g(z);
            m15372i(z);
        }
    }

    /* renamed from: c */
    public void mo22350c(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7234, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || !this.f13352aA || this.f13390j == null) {
            return;
        }
        if (this.f13390j.getVisibility() != 0 && !z) {
            return;
        }
        if (this.f13390j.getVisibility() != 0 || !z) {
            m15370h(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m15365f(boolean z) {
        String str;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13324a, false, 7235, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13378av.removeCallbacks(this.f13381ay);
            int i = 8;
            this.f13405y.setVisibility(z ? 8 : 0);
            this.f13406z.setVisibility(z ? 8 : 0);
            this.f13326A.setVisibility(z ? 0 : 8);
            this.f13404x.setAlpha(1.0f);
            this.f13404x.setVisibility(z ? 0 : 8);
            if (z) {
                this.f13378av.postDelayed(this.f13381ay, 2000);
            }
            TextView textView = this.f13327B;
            if (this.f13350Y) {
                str = String.format(this.f13338M.getString(R.string.mz_funny_cam_thin_face_hint), new Object[]{Integer.valueOf(this.f13362af)});
            } else {
                str = String.format(this.f13338M.getString(R.string.mz_funny_cam_whiten_skin_hint), new Object[]{Integer.valueOf(this.f13361ae)});
            }
            textView.setText(str);
            TextView textView2 = this.f13327B;
            if (z) {
                i = 0;
            }
            textView2.setVisibility(i);
        }
    }

    /* renamed from: k */
    public boolean mo22359k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7236, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13404x == null || this.f13404x.getVisibility() == 8;
    }

    /* renamed from: l */
    public boolean mo22360l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7237, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13399s != null && this.f13399s.getVisibility() == 0;
    }

    /* renamed from: m */
    public boolean mo22361m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7238, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13390j != null && this.f13390j.getVisibility() == 0;
    }

    /* renamed from: g */
    private void m15368g(final boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7239, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            AnimatorSet a = m15332a((View) this.f13399s, z);
            a.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13407a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f13407a, false, 7283, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        MzFunnySnapUI.this.f13399s.setVisibility(0);
                        boolean unused = MzFunnySnapUI.this.f13352aA = false;
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    int i = 0;
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f13407a, false, 7284, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        if (!z) {
                            MzFunnySnapUI.this.f13399s.setVisibility(8);
                        }
                        MzCamUI q = MzFunnySnapUI.this.f13332G;
                        if (z) {
                            i = MzFunnySnapUI.this.f13399s.getHeight() + MzFunnySnapUI.this.f13400t.getHeight();
                        }
                        q.mo22138b(i);
                        MzFunnySnapUI.this.f13400t.setTranslationY(0.0f);
                        boolean unused = MzFunnySnapUI.this.f13352aA = true;
                    }
                }
            });
            a.start();
        }
    }

    /* renamed from: h */
    private void m15370h(final boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7240, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            AnimatorSet a = m15332a((View) this.f13390j, z);
            a.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13433a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f13433a, false, 7285, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        if (z && MzFunnySnapUI.this.f13397q) {
                            boolean unused = MzFunnySnapUI.this.f13397q = false;
                            MzFunnySnapUI.this.f13391k.mo26403g(MzFunnySnapUI.this.f13398r);
                            MzFunnySnapUI.this.f13396p.mo20095a(MzFunnySnapUI.this.f13398r);
                        }
                        MzFunnySnapUI.this.f13390j.setAlpha(1.0f);
                        MzFunnySnapUI.this.f13390j.setVisibility(0);
                        boolean unused2 = MzFunnySnapUI.this.f13352aA = false;
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    int i = 0;
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f13433a, false, 7286, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        if (z) {
                            MzFunnySnapUI.this.m15352c(MzFunnySnapUI.this.f13398r);
                        }
                        MzFunnySnapUI.this.f13390j.setVisibility(z ? 0 : 8);
                        MzCamUI q = MzFunnySnapUI.this.f13332G;
                        if (z) {
                            i = MzFunnySnapUI.this.f13390j.getHeight();
                        }
                        q.mo22138b(i);
                        boolean unused = MzFunnySnapUI.this.f13352aA = true;
                    }
                }
            });
            a.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public void m15314N() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7241, new Class[0], Void.TYPE).isSupported && this.f13340O != null && !this.f13340O.isEmpty()) {
            Iterator<StickerAdapter> it = this.f13340O.iterator();
            while (it.hasNext()) {
                it.next().notifyDataSetChanged();
            }
        }
    }

    /* renamed from: n */
    public void mo22362n() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7242, new Class[0], Void.TYPE).isSupported) {
            if (this.f13340O != null && !this.f13340O.isEmpty()) {
                this.f13369am = null;
            }
            m15314N();
            m15345a(false, (String) null);
            if (this.f13345T != null) {
                this.f13345T.removeStickerFilterGroup();
            }
        }
    }

    /* renamed from: a */
    public void mo22342a(final ArrayList<StickerCategory> arrayList) {
        if (!PatchProxy.proxy(new Object[]{arrayList}, this, f13324a, false, 7243, new Class[]{ArrayList.class}, Void.TYPE).isSupported) {
            this.f13378av.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13447a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f13447a, false, 7287, new Class[0], Void.TYPE).isSupported && MzFunnySnapUI.this.f13403w != null) {
                        ArrayList unused = MzFunnySnapUI.this.f13331F = arrayList;
                        if (MzFunnySnapUI.this.f13374ar && MzFunnySnapUI.this.f13401u != null) {
                            MzFunnySnapUI.this.f13403w.mo18778a((List<StickerCategory>) arrayList);
                            MzFunnySnapUI.this.f13403w.notifyDataSetChanged();
                            MzFunnySnapUI.this.m15314N();
                            boolean unused2 = MzFunnySnapUI.this.f13376at = true;
                            if (MzFunnySnapUI.this.f13374ar) {
                                if (arrayList != null && arrayList.size() > 1 && MzFunnySnapUI.this.f13365ai) {
                                    MzFunnySnapUI.this.f13402v.setCurrentItem(1);
                                    boolean unused3 = MzFunnySnapUI.this.f13365ai = false;
                                }
                                MzFunnySnapUI.this.m15306J();
                                final int currentItem = MzFunnySnapUI.this.f13402v.getCurrentItem();
                                new AsyncTaskEx<Void, Void, Void>() {

                                    /* renamed from: a */
                                    public static ChangeQuickRedirect f13450a;

                                    /* renamed from: a */
                                    public Void mo17658a(Void... voidArr) {
                                        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f13450a, false, 7288, new Class[]{Void[].class}, Void.class);
                                        if (proxy.isSupported) {
                                            return (Void) proxy.result;
                                        }
                                        if (MzFunnySnapUI.this.f13371ao) {
                                            return null;
                                        }
                                        StickerCategory a = MzFunnySnapUI.this.f13403w.mo18776a(currentItem);
                                        if (a != null && a.mo19369e().booleanValue()) {
                                            a.mo19362a((Boolean) false);
                                            MzFunnySnapUI.this.f13336K.mo20456a(String.valueOf(a.mo19360a()), false);
                                        }
                                        if (!MzFunnySnapUI.this.f13365ai && a != null) {
                                            MzFunnySnapUI.this.f13336K.mo20453a(String.valueOf(a.mo19360a()));
                                        }
                                        return null;
                                    }
                                }.mo22614c((Params[]) new Void[0]);
                            }
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo22341a(final String str, final ArrayList<Sticker> arrayList) {
        Class[] clsArr = {String.class, ArrayList.class};
        if (!PatchProxy.proxy(new Object[]{str, arrayList}, this, f13324a, false, 7244, clsArr, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f13325b;
            LogUtil.m15942a(aVar, "onStickerLoaded categoryId:" + str + "   size:" + arrayList.size());
            if (this.f13403w != null) {
                this.f13378av.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13453a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f13453a, false, 7289, new Class[0], Void.TYPE).isSupported && MzFunnySnapUI.this.f13403w != null) {
                            int a = MzFunnySnapUI.this.f13403w.mo18775a(str);
                            if (a == -1 || a >= MzFunnySnapUI.this.f13340O.size()) {
                                LogUtil.C2630a F = MzFunnySnapUI.f13325b;
                                LogUtil.m15949b(F, "tabPosition is out of range: " + a);
                                return;
                            }
                            StickerAdapter stickerAdapter = (StickerAdapter) MzFunnySnapUI.this.f13340O.get(a);
                            stickerAdapter.mo18771a((ArrayList<Sticker>) arrayList);
                            stickerAdapter.notifyDataSetChanged();
                            if (MzFunnySnapUI.this.f13373aq) {
                                MzFunnySnapUI.this.m15307K();
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m15316O() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7245, new Class[0], Void.TYPE).isSupported) {
            if (this.f13354aC == null) {
                this.f13354aC = new AlertDialog.Builder(this.f13339N).setMessage(R.string.mz_funny_cam_no_network).setNegativeButton(17039360, new DialogInterface.OnClickListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13467a;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f13467a, false, 7294, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported && MzFunnySnapUI.this.f13354aC != null && MzFunnySnapUI.this.f13354aC.isShowing()) {
                            MzFunnySnapUI.this.f13354aC.dismiss();
                        }
                    }
                }).setPositiveButton(R.string.mz_network_setting, new DialogInterface.OnClickListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13465a;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f13465a, false, 7293, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                            MzFunnySnapUI.this.f13339N.startActivity(new Intent("android.settings.SETTINGS"));
                        }
                    }
                }).create();
            }
            this.f13354aC.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15337a(DialogInterface.OnClickListener onClickListener) {
        if (!PatchProxy.proxy(new Object[]{onClickListener}, this, f13324a, false, 7246, new Class[]{DialogInterface.OnClickListener.class}, Void.TYPE).isSupported) {
            this.f13355aD = new AlertDialog.Builder(this.f13339N).setMessage(R.string.mz_funny_cam_download_with_mobile_network).setNegativeButton(17039360, new DialogInterface.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13469a;

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f13469a, false, 7295, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported && MzFunnySnapUI.this.f13355aD != null && MzFunnySnapUI.this.f13355aD.isShowing()) {
                        MzFunnySnapUI.this.f13355aD.hide();
                    }
                }
            }).setPositiveButton(R.string.mz_download, onClickListener).create();
            this.f13355aD.show();
        }
    }

    /* renamed from: c */
    public void mo22349c(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13324a, false, 7247, new Class[]{String.class}, Void.TYPE).isSupported && !this.f13348W && this.f13346U != null && this.f13345T != null) {
            LogUtil.m15942a(f13325b, "start funny video recording");
            this.f13337L.mo21597h(10);
            this.f13337L.mo21582d(true);
            if (this.f13383c != null) {
                this.f13383c.setVisibility(8);
            }
            this.f13349X = mo22335a(0, 0);
            this.f13347V = str;
            this.f13346U.setWaterMarkEnable(mo22371p());
            this.f13346U.startRecording(str);
            this.f13348W = true;
        }
    }

    /* renamed from: o */
    public void mo22363o() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7248, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f13325b;
            LogUtil.m15942a(aVar, "stop funny video recording " + this.f13348W);
            if (this.f13348W) {
                this.f13337L.mo21597h(11);
                this.f13337L.mo21582d(false);
                if (this.f13383c != null) {
                    this.f13383c.setVisibility(0);
                }
                this.f13346U.stopRecording();
                this.f13348W = false;
                this.f13334I.mo20466e(this.f13347V);
                this.f13349X = null;
            }
        }
    }

    /* renamed from: p */
    public boolean mo22371p() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7249, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f13338M.getString(R.string.setting_on_value).equals(this.f13357aa.getString("mz_pref_meizu_mark_key", this.f13338M.getString(R.string.setting_on_value)));
    }

    /* renamed from: q */
    public boolean mo22372q() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7250, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13338M.getString(R.string.setting_on_value).equals(this.f13357aa.getString("mz_pref_funny_hd_key", this.f13338M.getString(R.string.setting_on_value))) && DeviceHelper.f13941bo;
    }

    /* renamed from: r */
    public Bitmap mo22373r() {
        return this.f13349X;
    }

    /* renamed from: a */
    public void mo22337a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7251, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f13364ah = i;
            if (this.f13343R != null) {
                this.f13343R.takePhoto();
            }
        }
    }

    /* renamed from: b */
    public void mo22346b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13324a, false, 7252, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f13371ao = false;
            if (CameraController.m8868g().mo19522k().mo19733b() == 1) {
                GlobalParams.setCameraID(1);
            } else {
                GlobalParams.setCameraID(0);
            }
            if (CameraController.m8868g().mo19522k() != null) {
                CameraController.m8868g().mo19518i().post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13410a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f13410a, false, 7298, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19522k() != null && CameraController.m8868g().mo19516h() == CameraController.CameraApi.API1) {
                            ((Camera) ((CameraProxyV1) CameraController.m8868g().mo19522k()).mo19730a()).setPreviewCallback(MzFunnySnapUI.this.f13356aE);
                        }
                    }
                });
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{surfaceTexture, new Integer(i), new Integer(i2)}, this, f13324a, false, 7253, new Class[]{SurfaceTexture.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f13325b, "onSurfaceTextureAvailable start");
            if (this.f13343R == null) {
                mo22345b();
            }
            this.f13343R.surfaceCreated(surfaceTexture);
            this.f13343R.setImageDirection(90);
            this.f13343R.setDataSize(this.f13358ab, this.f13359ac);
            this.f13343R.setFrameCallback(this.f13358ab, this.f13359ac, this);
            this.f13343R.surfaceChanged(i, i2);
            this.f13343R.setRenderer(new Renderer() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13414a;

                public void onDestroy() {
                }

                public void onSurfaceChanged(GL10 gl10, int i, int i2) {
                }

                public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                }

                public void onDrawFrame(GL10 gl10) {
                    if (!PatchProxy.proxy(new Object[]{gl10}, this, f13414a, false, 7300, new Class[]{GL10.class}, Void.TYPE).isSupported && MzFunnySnapUI.this.f13343R != null && GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO && MzFunnySnapUI.this.f13334I != null && !MzFunnySnapUI.this.f13334I.mo20448M()) {
                        MzFunnySnapUI.this.f13343R.requestRender();
                    }
                }
            });
            this.f13343R.onResume();
            LogUtil.m15942a(f13325b, "onSurfaceTextureAvailable end");
            if (this.f13332G != null) {
                this.f13332G.mo22160g();
            }
            LogUtil.C2630a aVar = f13325b;
            LogUtil.m15952c(aVar, "mTextureController.getTexture():" + this.f13343R.getTexture());
            LogUtil.m15952c(f13325b, "============onSurfaceTextureAvailable()===========");
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Object[] objArr = {surfaceTexture, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7254, new Class[]{SurfaceTexture.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f13343R.surfaceChanged(i, i2);
            LogUtil.m15952c(f13325b, "============surfaceChanged()===========");
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{surfaceTexture}, this, f13324a, false, 7255, new Class[]{SurfaceTexture.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.m15952c(f13325b, "============onSurfaceTextureDestroyed()===========");
        mo22377v();
        return false;
    }

    public void onFrame(final byte[] bArr, long j) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Long(j)}, this, f13324a, false, 7256, new Class[]{byte[].class, Long.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f13325b, "onFrame");
            new AsyncTaskEx<Void, Void, Void>() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13416a;

                /* renamed from: a */
                public Void mo17658a(Void... voidArr) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f13416a, false, 7301, new Class[]{Void[].class}, Void.class);
                    if (proxy.isSupported) {
                        return (Void) proxy.result;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(MzFunnySnapUI.this.f13358ab, MzFunnySnapUI.this.f13359ac, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
                    if (MzFunnySnapUI.this.f13364ah != 0) {
                        createBitmap = BitmapUtil.rotateBitmap(createBitmap, (float) MzFunnySnapUI.this.f13364ah);
                    }
                    if (MzFunnySnapUI.this.mo22371p()) {
                        StaticWaterMarkFilter staticWaterMarkFilter = new StaticWaterMarkFilter(MzFunnySnapUI.this.f13338M.getResources(), createBitmap.getWidth(), createBitmap.getHeight(), false);
                        staticWaterMarkFilter.setWaterMark(BitmapFactory.decodeResource(MzFunnySnapUI.this.f13338M.getResources(), R.drawable.mz_funny_snap_watermark));
                        EGLController eGLController = new EGLController(createBitmap, staticWaterMarkFilter, Thread.currentThread().getName());
                        createBitmap = eGLController.getBitmap();
                        eGLController.destroy();
                    }
                    MzFunnySnapUI.this.f13334I.mo20459b(createBitmap);
                    return null;
                }
            }.mo22610a(AsyncTaskEx.f13741o, (Params[]) new Void[0]);
        }
    }

    /* renamed from: s */
    public void mo22374s() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7257, new Class[0], Void.TYPE).isSupported) {
            if (this.f13343R == null) {
                mo22345b();
            }
            if (!TextUtils.isEmpty(this.f13370an)) {
                m15374j(true);
            }
            if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_TWO && this.f13342Q != null && this.f13342Q.isAvailable()) {
                this.f13343R.requestRender();
            }
        }
    }

    /* renamed from: t */
    public void mo22375t() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7258, new Class[0], Void.TYPE).isSupported) {
            mo22355g();
        }
    }

    /* renamed from: u */
    public void mo22376u() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7259, new Class[0], Void.TYPE).isSupported) {
            mo22363o();
            if (this.f13332G.mo22126ao() != null) {
                new AsyncTaskEx<Void, Void, Bitmap>() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13419a;

                    /* renamed from: a */
                    public Bitmap mo17658a(Void... voidArr) {
                        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f13419a, false, 7302, new Class[]{Void[].class}, Bitmap.class);
                        return proxy.isSupported ? (Bitmap) proxy.result : C1825q.m8250a(MzFunnySnapUI.this.f13338M.getApplicationContext(), MzFunnySnapUI.this.f13332G.mo22126ao(), 25.0f, false);
                    }

                    /* renamed from: a */
                    public void mo17660a(Bitmap bitmap) {
                        if (!PatchProxy.proxy(new Object[]{bitmap}, this, f13419a, false, 7303, new Class[]{Bitmap.class}, Void.TYPE).isSupported) {
                            MzFunnySnapUI.this.mo22344a(true, bitmap);
                        }
                    }
                }.mo22614c((Params[]) new Void[0]);
            }
            m15374j(false);
        }
    }

    /* renamed from: v */
    public void mo22377v() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7260, new Class[0], Void.TYPE).isSupported) {
            if (this.f13346U != null) {
                this.f13346U.setTextureController((TextureController) null);
                this.f13346U = null;
            }
            if (this.f13343R != null) {
                this.f13343R.destroy();
                this.f13343R.setFrameCallback(0, 0, (FrameCallback) null);
                this.f13343R = null;
            }
            if (this.f13344S != null) {
                this.f13344S.release();
                this.f13344S = null;
                this.f13351Z = false;
            }
            if (this.f13345T != null) {
                this.f13345T.release();
            }
            this.f13378av.removeCallbacks(this.f13381ay);
            this.f13375as = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15339a(Sticker sticker, Sticker.DownloadState downloadState) {
        Class[] clsArr = {Sticker.class, Sticker.DownloadState.class};
        if (!PatchProxy.proxy(new Object[]{sticker, downloadState}, this, f13324a, false, 7261, clsArr, Void.TYPE).isSupported) {
            sticker.mo19345a(downloadState);
            this.f13336K.mo20454a(String.valueOf(sticker.mo19342a()), downloadState.ordinal());
        }
    }

    /* renamed from: w */
    public String mo22378w() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7262, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (this.f13369am == null) {
            return null;
        }
        String[] split = this.f13369am.split("\\/");
        if (split.length <= 0 || split[split.length - 1] == null) {
            return null;
        }
        String[] split2 = split[split.length - 1].split("\\.");
        if (split2.length > 0) {
            return split2[0];
        }
        return null;
    }

    /* renamed from: i */
    private void m15372i(final boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7263, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13363ag = m15332a((View) this.f13400t, z);
            this.f13363ag.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13421a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f13421a, false, 7304, new Class[]{Animator.class}, Void.TYPE).isSupported && z) {
                        MzFunnySnapUI.this.f13400t.setVisibility(0);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f13421a, false, 7305, new Class[]{Animator.class}, Void.TYPE).isSupported && !z) {
                        MzFunnySnapUI.this.m15365f(false);
                        MzFunnySnapUI.this.f13400t.setVisibility(8);
                    }
                }
            });
            this.f13363ag.start();
        }
    }

    /* renamed from: d */
    public void mo22352d(final boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13324a, false, 7264, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f13377au != null && this.f13377au.isRunning()) {
                return;
            }
            if (this.f13386f.getVisibility() == 0 && z) {
                return;
            }
            if ((this.f13386f.getVisibility() != 8 || z) && this.f13352aA) {
                this.f13386f.setClickable(false);
                if (this.f13387g != null) {
                    this.f13387g.setClickable(false);
                }
                FrameLayout frameLayout = this.f13386f;
                float[] fArr = new float[2];
                fArr[0] = z ? 0.0f : 1.0f;
                fArr[1] = z ? 1.0f : 0.0f;
                this.f13377au = ObjectAnimator.ofFloat(frameLayout, "alpha", fArr);
                this.f13377au.setDuration(100);
                this.f13377au.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
                if (z) {
                    this.f13377au.setStartDelay(100);
                }
                this.f13377au.addListener(new Animator.AnimatorListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f13424a;

                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        if (!PatchProxy.proxy(new Object[]{animator}, this, f13424a, false, 7306, new Class[]{Animator.class}, Void.TYPE).isSupported && z) {
                            MzFunnySnapUI.this.f13386f.setVisibility(0);
                            if (MzFunnySnapUI.this.f13387g != null) {
                                MzFunnySnapUI.this.f13387g.setVisibility(0);
                            }
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (!PatchProxy.proxy(new Object[]{animator}, this, f13424a, false, 7307, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                            if (!z) {
                                MzFunnySnapUI.this.f13386f.setVisibility(8);
                                if (MzFunnySnapUI.this.f13387g != null) {
                                    MzFunnySnapUI.this.f13387g.setVisibility(8);
                                }
                            }
                            MzFunnySnapUI.this.f13386f.setClickable(true);
                            if (MzFunnySnapUI.this.f13387g != null) {
                                MzFunnySnapUI.this.f13387g.setClickable(true);
                            }
                        }
                    }
                });
                this.f13377au.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15336a(int i, boolean z) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7265, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || this.f13345T == null) {
            return;
        }
        if (z) {
            this.f13345T.setReshapeFlag(i);
        } else {
            this.f13345T.setSkinSmoothFlag((int) (((float) i) * 0.6f));
        }
    }

    /* renamed from: x */
    public int mo22379x() {
        return this.f13361ae;
    }

    /* renamed from: y */
    public int mo22380y() {
        return this.f13362af;
    }

    /* renamed from: P */
    private void m15318P() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7266, new Class[0], Void.TYPE).isSupported) {
            if (this.f13330E != null) {
                this.f13330E.close();
            }
            m15310L();
            this.f13330E = ImageReader.newInstance(this.f13359ac, this.f13358ab, 35, 2);
            this.f13330E.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                public final void onImageAvailable(ImageReader imageReader) {
                    MzFunnySnapUI.this.m15338a(imageReader);
                }
            }, CameraController.m8868g().mo19518i());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15338a(ImageReader imageReader) {
        Image acquireNextImage;
        if (!PatchProxy.proxy(new Object[]{imageReader}, this, f13324a, false, 7277, new Class[]{ImageReader.class}, Void.TYPE).isSupported) {
            try {
                acquireNextImage = imageReader.acquireNextImage();
                if (!this.f13371ao) {
                    if (this.f13334I != null) {
                        if (!this.f13334I.mo20448M()) {
                            GlobalParams.setScreenAngle(this.f13334I.mo20447L());
                        } else if (acquireNextImage != null) {
                            acquireNextImage.close();
                            return;
                        } else {
                            return;
                        }
                    }
                    if (GlobalParams.FRAME_TYPE == GlobalParams.FRAME_TYPE_ONE) {
                        MzFaceDetectArc.getInstance().faceDetection(FormatUtil.m16270a(acquireNextImage), this.f13359ac, this.f13358ab);
                        if (this.f13343R != null) {
                            this.f13343R.requestRender();
                        }
                    }
                    if (acquireNextImage != null) {
                        acquireNextImage.close();
                    }
                    this.f13378av.post(new Runnable() {
                        public final void run() {
                            MzFunnySnapUI.this.m15320Q();
                        }
                    });
                    return;
                } else if (acquireNextImage != null) {
                    acquireNextImage.close();
                    return;
                } else {
                    return;
                }
            } catch (Exception e) {
                LogUtil.C2630a aVar = f13325b;
                LogUtil.m15956e(aVar, "process image Err: " + e.getMessage());
            } catch (Throwable th) {
                r0.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public /* synthetic */ void m15320Q() {
        int i = 0;
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7278, new Class[0], Void.TYPE).isSupported) {
            if (!this.f13374ar && !this.f13371ao) {
                m15300G();
            }
            if (this.f13368al >= 3) {
                if (this.f13333H.mo17904aa() || this.f13372ap) {
                    this.f13332G.mo22085a(!this.f13333H.mo17908ae());
                    this.f13372ap = false;
                    mo22344a(false, (Bitmap) null);
                }
                if (!MzFaceDetectArc.getInstance().getFaceDetectResult()) {
                    this.f13367ak++;
                } else {
                    this.f13367ak = 0;
                }
                if (this.f13384d != null) {
                    LinearLayout linearLayout = this.f13384d;
                    if (this.f13367ak < 10 || this.f13371ao) {
                        i = 8;
                    }
                    linearLayout.setVisibility(i);
                }
                this.f13333H.mo17957w();
                return;
            }
            this.f13368al++;
        }
    }

    /* renamed from: z */
    public Surface mo22381z() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7267, new Class[0], Surface.class);
        if (proxy.isSupported) {
            return (Surface) proxy.result;
        }
        m15318P();
        return this.f13330E.getSurface();
    }

    /* renamed from: A */
    public void mo22330A() {
        if (!PatchProxy.proxy(new Object[0], this, f13324a, false, 7268, new Class[0], Void.TYPE).isSupported && this.f13330E != null) {
            this.f13330E.close();
            this.f13330E = null;
        }
    }

    /* renamed from: B */
    public int mo22331B() {
        return this.f13358ab;
    }

    /* renamed from: C */
    public int mo22332C() {
        return this.f13359ac;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15345a(boolean z, String str) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), str}, this, f13324a, false, 7269, new Class[]{Boolean.TYPE, String.class}, Void.TYPE).isSupported) {
            if (z) {
                this.f13370an = Storage.m7750a().mo18638b(this.f13338M, str);
                m15374j(true);
                return;
            }
            this.f13370an = null;
            m15374j(false);
        }
    }

    /* renamed from: j */
    private void m15374j(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7270, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f13344S != null) {
            this.f13351Z = z;
            if (z) {
                this.f13344S.startPlayer(this.f13370an);
            } else {
                this.f13344S.stopPlayer();
            }
        }
    }

    /* renamed from: D */
    public boolean mo22333D() {
        return this.f13351Z;
    }

    /* renamed from: com.meizu.media.camera.ui.p$c */
    /* compiled from: MzFunnySnapUI */
    public class C2564c extends SelectAdapter<C2565d> {

        /* renamed from: a */
        public static ChangeQuickRedirect f13475a;

        /* renamed from: f */
        private LayoutInflater f13477f;

        /* renamed from: g */
        private String f13478g;

        public C2564c(Context context) {
            this.f13477f = LayoutInflater.from(context);
            this.f13478g = context.getResources().getConfiguration().locale.getCountry();
        }

        /* renamed from: a */
        public C2565d mo20098b(ViewGroup viewGroup, int i) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, new Integer(i)}, this, f13475a, false, 7318, new Class[]{ViewGroup.class, Integer.TYPE}, C2565d.class);
            return proxy.isSupported ? (C2565d) proxy.result : new C2565d(this.f13477f.inflate(R.layout.mz_fs_filter_item, viewGroup, false));
        }

        /* renamed from: a */
        public void mo20097a(RecyclerView.C3286u uVar, int i) {
            boolean z = true;
            if (!PatchProxy.proxy(new Object[]{uVar, new Integer(i)}, this, f13475a, false, 7319, new Class[]{RecyclerView.C3286u.class, Integer.TYPE}, Void.TYPE).isSupported) {
                C2565d dVar = (C2565d) uVar;
                dVar.f18121j.setTag(Integer.valueOf(i));
                if (MzFunnySnapUI.this.f13398r != i) {
                    z = false;
                }
                dVar.mo18785a(z);
                dVar.f13480c.setBackgroundColor(0);
                dVar.f13480c.setImageDrawable(MzFunnySnapUI.this.f13338M.getDrawable(MzFunnySnapUI.this.f13395o[i].getResourceID()));
            }
        }

        /* renamed from: a */
        public int mo20093a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13475a, false, 7320, new Class[0], Integer.TYPE);
            return proxy.isSupported ? ((Integer) proxy.result).intValue() : MzFunnySnapUI.this.f13395o.length;
        }

        /* renamed from: a */
        public void mo20095a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f13475a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7321, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                super.mo20095a(i);
                if (MzFunnySnapUI.this.f13345T != null && MzFunnySnapUI.this.f13398r != i && MzFunnySnapUI.this.f13395o.length > i) {
                    int unused = MzFunnySnapUI.this.f13398r = i;
                    MzFunnySnapUI.this.f13345T.setFilter(MzFunnySnapUI.this.f13395o[i].getFilterID());
                    MzFunnySnapUI.this.m15352c(i);
                    UsageStatsHelper.m16042a(MzFunnySnapUI.this.f13338M.getApplicationContext()).mo22691a("select_fs_filter", "filter_value", MzFunnySnapUI.this.f13395o[i].getFilterNameEn());
                    LogUtil.C2630a F = MzFunnySnapUI.f13325b;
                    LogUtil.m15952c(F, "set Funny Filter:" + MzFunnySnapUI.this.f13395o[i].getFilterID());
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.ui.p$d */
    /* compiled from: MzFunnySnapUI */
    public class C2565d extends BaseViewHolder {

        /* renamed from: b */
        public static ChangeQuickRedirect f13479b;

        /* renamed from: c */
        ImageView f13480c;

        /* renamed from: d */
        ImageView f13481d;

        /* renamed from: e */
        boolean f13482e;

        public C2565d(View view) {
            super(view);
            this.f7557a = view.findViewById(R.id.mz_fs_filter_item);
            this.f13480c = (ImageView) view.findViewById(R.id.mz_fs_filter_img);
            this.f13481d = (ImageView) view.findViewById(R.id.mz_fs_filter_selected_bg);
        }

        /* renamed from: a */
        public void mo18785a(boolean z) {
            if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13479b, false, 7322, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
                this.f13482e = z;
                if (z) {
                    this.f13481d.setVisibility(0);
                } else {
                    this.f13481d.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: b */
    private void m15349b(int i, boolean z) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7271, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && this.f13394n != null && this.f13391k != null) {
            if (this.f13394n.mo26080c(i) == null) {
                this.f13397q = true;
                this.f13391k.mo26396e(i);
            } else if (z) {
                this.f13391k.mo26403g(this.f13398r);
            } else {
                this.f13391k.mo26396e(this.f13398r);
            }
        }
    }

    /* renamed from: E */
    public String mo22334E() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13324a, false, 7272, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (this.f13395o == null || this.f13395o.length <= this.f13398r) {
            return null;
        }
        return this.f13395o[this.f13398r].getFilterNameEn();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15352c(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13324a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7273, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f13393m != null && this.f13395o[i] != null) {
            String country = this.f13338M.getResources().getConfiguration().locale.getCountry();
            if (Locale.CHINA.getCountry().equals(country)) {
                this.f13393m.setText(this.f13395o[i].getFilterNameCn());
            } else if (Locale.TAIWAN.getCountry().equals(country) || "HK".equals(country)) {
                this.f13393m.setText(this.f13395o[i].getFilterNameCn());
            } else {
                this.f13393m.setText(this.f13395o[i].getFilterNameEn());
            }
        }
    }

    /* renamed from: a */
    private AnimatorSet m15332a(View view, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view, new Byte(z ? (byte) 1 : 0)}, this, f13324a, false, 7274, new Class[]{View.class, Boolean.TYPE}, AnimatorSet.class);
        if (proxy.isSupported) {
            return (AnimatorSet) proxy.result;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        int dimensionPixelOffset = this.f13338M.getResources().getDimensionPixelOffset(R.dimen.mz_funny_snap_anim_translation);
        float[] fArr = new float[2];
        fArr[0] = z ? (float) dimensionPixelOffset : 0.0f;
        fArr[1] = z ? 0.0f : (float) dimensionPixelOffset;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z ? 0.0f : 1.0f;
        fArr2[1] = z ? 1.0f : 0.0f;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", fArr2);
        PathInterpolator pathInterpolator = new PathInterpolator(0.15f, 0.43f, 0.21f, 1.0f);
        PathInterpolator pathInterpolator2 = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        ofFloat2.setInterpolator(pathInterpolator2);
        if (z) {
            ofFloat.setInterpolator(pathInterpolator);
        } else {
            ofFloat.setInterpolator(pathInterpolator2);
        }
        animatorSet.setDuration(z ? 170 : 100);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onARLibDownload(Integer num) {
        if (!PatchProxy.proxy(new Object[]{num}, this, f13324a, false, 7275, new Class[]{Integer.class}, Void.TYPE).isSupported) {
            if (num.intValue() == 14) {
                LogUtil.m15942a(f13325b, "onARLibDownload: AR_LIB_DOWNLOADED");
                if (this.f13387g != null) {
                    this.f13387g.setClickable(true);
                    if (this.f13329D != null) {
                        this.f13329D.setVisibility(8);
                    }
                    if (this.f13328C != null) {
                        this.f13328C.setVisibility(0);
                    }
                }
            } else if (num.intValue() == 15) {
                LogUtil.m15942a(f13325b, "onARLibDownload: AR_LIB_DOWNLOAD_FAILED");
                if (this.f13387g != null) {
                    this.f13387g.setClickable(true);
                    if (this.f13329D != null) {
                        this.f13329D.setVisibility(8);
                    }
                    if (this.f13328C != null) {
                        this.f13328C.setVisibility(0);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m15358d(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13324a, false, 7276, new Class[]{String.class}, Void.TYPE).isSupported && str != null) {
            this.f13345T.changeStickerFilterGroup(str);
        }
    }
}
