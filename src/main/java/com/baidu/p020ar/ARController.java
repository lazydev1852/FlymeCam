package com.baidu.p020ar;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.arplay.core.ARPScriptEnvironment;
import com.baidu.p020ar.arplay.core.ARPTouchInput;
import com.baidu.p020ar.base.C0609a;
import com.baidu.p020ar.base.C0611b;
import com.baidu.p020ar.base.C0618d;
import com.baidu.p020ar.base.C0620e;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.base.RequestController;
import com.baidu.p020ar.bean.ARConfig;
import com.baidu.p020ar.bean.ARPConfig;
import com.baidu.p020ar.bean.ARResource;
import com.baidu.p020ar.bean.C0623a;
import com.baidu.p020ar.blend.blender.C0654c;
import com.baidu.p020ar.blend.blender.TextureParams;
import com.baidu.p020ar.cloud.C0754a;
import com.baidu.p020ar.imu.C0774e;
import com.baidu.p020ar.license.ArsdkLicense;
import com.baidu.p020ar.load.FileManageTask;
import com.baidu.p020ar.load.downloader.DownloadManager;
import com.baidu.p020ar.load.util.C0789a;
import com.baidu.p020ar.load.util.ResponseUtil;
import com.baidu.p020ar.logo.CameraPreViewCallback;
import com.baidu.p020ar.msghandler.C0802a;
import com.baidu.p020ar.p042d.C0765a;
import com.baidu.p020ar.parser.ParserJson;
import com.baidu.p020ar.recg.C0822b;
import com.baidu.p020ar.recorder.MovieRecorderCallback;
import com.baidu.p020ar.recorder.p046d.C0852d;
import com.baidu.p020ar.resloader.ArCaseDownloadListener;
import com.baidu.p020ar.resloader.C0872a;
import com.baidu.p020ar.resloader.C0884e;
import com.baidu.p020ar.resloader.C0888h;
import com.baidu.p020ar.rotate.Orientation;
import com.baidu.p020ar.rotate.OrientationManager;
import com.baidu.p020ar.slam.C0893a;
import com.baidu.p020ar.statistic.StatisticHelper;
import com.baidu.p020ar.task.ActionResponseListener;
import com.baidu.p020ar.task.HttpHandle;
import com.baidu.p020ar.test.PerformanceTest;
import com.baidu.p020ar.track.C0905a;
import com.baidu.p020ar.util.ARFileUtils;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.ARSDKInfo;
import com.baidu.p020ar.util.ArResourceUtils;
import com.baidu.p020ar.util.Constants;
import com.baidu.p020ar.util.FileUtils;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.baidu.p020ar.util.UiThreadUtil;
import java.util.HashMap;

/* renamed from: com.baidu.ar.ARController */
public class ARController {

    /* renamed from: b */
    private static final String f445b = "ARController";

    /* renamed from: A */
    private byte[] f446A;

    /* renamed from: B */
    private Object f447B = new Object();
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f448C = true;

    /* renamed from: D */
    private Runnable f449D = new Runnable() {
        public void run() {
            boolean unused = ARController.this.f448C = true;
        }
    };

    /* renamed from: E */
    private C0872a f450E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public FileManageTask f451F;

    /* renamed from: a */
    boolean f452a = false;

    /* renamed from: c */
    private HttpHandle f453c;

    /* renamed from: d */
    private boolean f454d;

    /* renamed from: e */
    private C0611b f455e;

    /* renamed from: f */
    private C0654c f456f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public RequestController f457g;

    /* renamed from: h */
    private Context f458h;

    /* renamed from: i */
    private Context f459i;

    /* renamed from: j */
    private DuMixSource f460j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public DuMixTarget f461k;

    /* renamed from: l */
    private DuMixCallback f462l;

    /* renamed from: m */
    private float f463m = 1.0f;

    /* renamed from: n */
    private boolean f464n = false;

    /* renamed from: o */
    private TextureParams f465o;

    /* renamed from: p */
    private boolean f466p = true;

    /* renamed from: q */
    private C0765a f467q = null;

    /* renamed from: r */
    private C0609a f468r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ARPTouchInput f469s;

    /* renamed from: t */
    private TextureParams.SourceType f470t = TextureParams.SourceType.NONE;

    /* renamed from: u */
    private AudioManager f471u;

    /* renamed from: v */
    private boolean f472v = false;

    /* renamed from: w */
    private boolean f473w = true;

    /* renamed from: x */
    private int f474x = 0;

    /* renamed from: y */
    private int f475y = -90;

    /* renamed from: z */
    private CameraPreViewCallback f476z;

    public ARController(Context context) {
        ARLog.m2696e("version code: " + ARSDKInfo.getVersionCode());
        this.f458h = context;
        this.f459i = this.f458h.getApplicationContext();
        this.f469s = new ARPTouchInput(Looper.getMainLooper());
        if (this.f459i != null) {
            ARFileUtils.setPackageName(this.f459i.getApplicationContext().getPackageName());
        }
        m792h();
        StatisticHelper.getInstance().initStatistic(context);
    }

    /* renamed from: a */
    private float m765a(DuMixSource duMixSource, DuMixTarget duMixTarget) {
        int sourceWidth = duMixSource.getSourceWidth();
        int sourceHeight = duMixSource.getSourceHeight();
        int targetWidth = duMixTarget.getTargetWidth();
        int targetHeight = duMixTarget.getTargetHeight();
        int min = Math.min(sourceWidth, sourceHeight);
        int max = Math.max(sourceWidth, sourceHeight);
        float min2 = (((float) Math.min(targetWidth, targetHeight)) * 1.0f) / ((float) min);
        float max2 = (((float) Math.max(targetWidth, targetHeight)) * 1.0f) / ((float) max);
        return Float.compare(max2, min2) < 0 ? max2 : min2;
    }

    /* renamed from: a */
    private TextureParams m767a(boolean z, TextureParams.VideoRenderMode videoRenderMode, DuMixSource duMixSource, DuMixTarget duMixTarget, TextureParams textureParams, int i) {
        float f;
        boolean z2;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i2;
        TextureParams textureParams2;
        TextureParams.SourceType sourceType;
        int i3;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        int i4;
        TextureParams textureParams3;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        int i5;
        TextureParams textureParams4;
        TextureParams.VideoRenderMode videoRenderMode2 = videoRenderMode;
        int i6 = i;
        int sourceWidth = duMixSource.getSourceWidth();
        int sourceHeight = duMixSource.getSourceHeight();
        int targetWidth = duMixTarget.getTargetWidth();
        int targetHeight = duMixTarget.getTargetHeight();
        int min = Math.min(sourceWidth, sourceHeight);
        int max = Math.max(sourceWidth, sourceHeight);
        float min2 = (((float) Math.min(targetWidth, targetHeight)) * 1.0f) / ((float) min);
        float max2 = (((float) Math.max(targetWidth, targetHeight)) * 1.0f) / ((float) max);
        if (Float.compare(max2, min2) < 0) {
            f = max2 / min2;
            z2 = true;
        } else {
            f = min2 / max2;
            z2 = false;
        }
        TextureParams textureParams5 = textureParams == null ? new TextureParams() : textureParams;
        textureParams5.mo9773a(videoRenderMode2);
        textureParams5.mo9775a(z2, (1.0f - f) / 2.0f);
        float f18 = 90.0f;
        if (z) {
            if (videoRenderMode2 == TextureParams.VideoRenderMode.FG) {
                if (i6 == 0 || i6 == 180) {
                    f17 = (float) (i6 - 90);
                    f16 = 1.0f;
                    f15 = 1.0f;
                    f14 = 0.0f;
                    f13 = 0.0f;
                    i5 = 1;
                    textureParams4 = textureParams5;
                } else {
                    f17 = (float) (i6 + 90);
                    f16 = 1.0f;
                    f15 = 1.0f;
                    f14 = 0.0f;
                    f13 = 0.0f;
                    textureParams4 = textureParams5;
                    i5 = 1;
                }
                textureParams4.mo9770a(i5, f17, f16, f15, f14, f13);
                i2 = 1;
                f18 = -90.0f;
            } else {
                i2 = 0;
            }
            f6 = SystemInfoUtil.isNexus6P() ? -90.0f : f18;
            f5 = 1.0f;
            f4 = 1.0f;
            sourceType = this.f470t;
            textureParams2 = textureParams5;
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            if (videoRenderMode2 == TextureParams.VideoRenderMode.FG) {
                if (i6 == 0 || i6 == 180) {
                    f12 = (float) (i6 + 90);
                    f11 = 1.0f;
                    f10 = 1.0f;
                    f9 = 0.0f;
                    f8 = 0.0f;
                    i4 = 0;
                    textureParams3 = textureParams5;
                } else {
                    f12 = (float) (i6 - 90);
                    f11 = 1.0f;
                    f10 = 1.0f;
                    f9 = 0.0f;
                    f8 = 0.0f;
                    textureParams3 = textureParams5;
                    i4 = 0;
                }
                textureParams3.mo9770a(i4, f12, f11, f10, f9, f8);
                i3 = 0;
                f7 = 90.0f;
            } else {
                i3 = 1;
                f7 = -90.0f;
            }
            f5 = 1.0f;
            f4 = 1.0f;
            sourceType = this.f470t;
            f3 = 0.0f;
            f2 = 0.0f;
            textureParams2 = textureParams5;
        }
        textureParams2.mo9771a(i2, f6, f5, f4, f3, f2, sourceType);
        if (this.f470t == TextureParams.SourceType.SURFACE_TEXTURE) {
            textureParams5.mo9774a(false);
        }
        textureParams5.mo9769a(this.f463m);
        textureParams5.mo9772a(duMixSource.getSourceWidth(), duMixSource.getSourceHeight());
        return textureParams5;
    }

    /* renamed from: a */
    private static String m769a(String str) {
        return FileUtils.readFileText(ARFileUtils.getDumixResJsonPath(str));
    }

    /* renamed from: a */
    private void m770a() {
        if (this.f473w) {
            m772a(this.f460j);
            if (this.f455e != null) {
                this.f455e.mo9514a(this.f459i.getApplicationContext().getResources().getDisplayMetrics().density);
            }
        } else {
            m790f();
        }
        if (this.f462l != null) {
            this.f462l.onSetup(true);
        }
    }

    /* renamed from: a */
    private void m772a(DuMixSource duMixSource) {
        if (!FileUtils.existsDir(duMixSource.getResFilePath())) {
            C0618d.m1300a((int) MsgField.IMSG_LOCAL_RES_NOT_EXIST, MsgField.SMSG_LOCAL_RES_NOT_EXIST);
        }
        C0888h.m2572a();
        m783c();
        if (this.f469s != null) {
            this.f469s.mo9221a();
        }
        if (PerformanceTest.isTestOpen() && this.f456f != null) {
            String str = f445b;
            Log.e(str, "loadLocalSO PerformanceTest PerformanceTest.getMaxFrameRate = " + PerformanceTest.getMaxFrameRate());
            this.f456f.mo9843a(PerformanceTest.getMaxFrameRate());
        }
        C0618d.m1300a((int) MsgField.IMSG_SO_LOAD_SUCCESS, MsgField.SMSG_SO_LOAD_SUCCESS);
        C0888h.m2575b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m773a(ARResource aRResource) {
        C0611b aVar;
        int type = aRResource.getType();
        ARConfig.setARType(type);
        m789e();
        if (type == 0) {
            aVar = new C0905a(this.f458h);
        } else if (type != 3) {
            switch (type) {
                case 5:
                    aVar = new C0893a(this.f458h);
                    break;
                case 6:
                    aVar = new C0822b(this.f458h);
                    break;
                case 7:
                    aVar = new C0754a(this.f458h);
                    break;
                case 8:
                    aVar = new C0774e(this.f458h);
                    break;
                default:
                    ARLog.m2696e("Resource Type error, not defined!");
                    aVar = new C0905a(this.f458h);
                    break;
            }
        } else {
            return;
        }
        this.f455e = aVar;
        this.f455e.mo9516a(this);
        this.f455e.mo9518a(aRResource);
        this.f455e.mo9541k();
        if (this.f462l != null) {
            this.f462l.onCaseCreated(aRResource);
        }
        this.f455e.mo9517a(this.f462l);
        this.f455e.mo9525b(true);
        if (this.f452a) {
            this.f455e.mo9533d();
        }
    }

    /* renamed from: a */
    private void m774a(String str, int i, String str2) {
        ARConfig.setARKey(str);
        ARConfig.setARType(i);
        ARConfig.setARPath(str2);
        m789e();
    }

    /* renamed from: a */
    private void m775a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            synchronized (this.f447B) {
                if (this.f459i == null) {
                    Log.d("bdar", "bdar:mContext is Destoryed, so release mPreviewData!");
                    this.f446A = null;
                    return;
                }
                if (this.f446A == null || this.f446A.length != bArr.length) {
                    this.f446A = new byte[bArr.length];
                }
                try {
                    System.arraycopy(bArr, 0, this.f446A, 0, bArr.length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private void m776a(byte[] bArr, C0765a aVar) {
        try {
            C0654c.m1579b(bArr, aVar.f1679a, aVar.f1680b);
        } catch (NullPointerException unused) {
            Log.e(f445b, "bdar: ARBlender object is null!");
            C0654c.m1581h();
        }
    }

    /* renamed from: b */
    private void m779b() {
        if (this.f455e != null) {
            this.f455e.mo9536f();
            this.f455e = null;
        }
    }

    /* renamed from: b */
    private void m781b(DuMixSource duMixSource) {
        C0623a parseDuMixRes;
        if (this.f473w && !TextUtils.isEmpty(duMixSource.getResFilePath()) && ProjectParams.isHuaweiProject() && (parseDuMixRes = ParserJson.parseDuMixRes(m769a(duMixSource.getResFilePath()))) != null) {
            duMixSource.setArType(parseDuMixRes.mo9668a());
        }
    }

    /* renamed from: b */
    private void m782b(final ARResource aRResource) {
        C0618d.m1299a(2200, (Object) aRResource);
        this.f451F = new FileManageTask(aRResource.getZipFilePath(), aRResource.getResFilePath(), FileManageTask.FileMergeStrategy.SKIP, new ActionResponseListener<String>() {
            /* renamed from: a */
            public void onResponse(String str) {
                FileManageTask unused = ARController.this.f451F = null;
                if (ResponseUtil.getIdFromResponse(str) == 0) {
                    ARController.this.m785c(aRResource);
                } else {
                    Log.d("unzip", "unzip error!");
                }
            }

            public void onErrorResponse(String str) {
            }

            public void onProgress(int i) {
            }

            public void onUpdate(boolean z, float f) {
            }
        }, new FileManageTask.ExtraOperateListener() {
            public String excuteChangeResult(String str) {
                Log.d("excuteChangeResult", "input:" + str);
                aRResource.setCaseConfigJsonInfo(ArResourceUtils.generateResult(str));
                return null;
            }
        });
        this.f451F.executeOnExecutor(C0789a.m2076a(), new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m783c() {
        if (this.f456f != null) {
            this.f456f.mo9850a(true);
        }
        if (this.f469s != null) {
            this.f469s.mo9226a(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m785c(ARResource aRResource) {
        ARConfig.setARKey(aRResource.getKey());
        if (this.f455e != null) {
            this.f455e.mo9539i();
            this.f455e = null;
        }
        m773a(aRResource);
    }

    /* renamed from: c */
    private boolean m786c(DuMixSource duMixSource) {
        return duMixSource == null;
    }

    /* renamed from: d */
    private boolean m788d() {
        return !TextUtils.isEmpty(ARConfig.getARKey()) || ARConfig.getARType() != -1;
    }

    /* renamed from: e */
    private void m789e() {
        if (isEnginSoLoaded()) {
            ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("userinfo", ARPConfig.getUserInfoData());
        }
    }

    /* renamed from: f */
    private void m790f() {
        this.f457g = new RequestController(this.f459i);
        this.f457g.setOnSoLoadCallback(new C0884e.C0885a() {
            /* renamed from: a */
            public void mo8857a(boolean z) {
                int i;
                String str;
                if (ARController.this.f457g != null) {
                    if (z) {
                        ARController.this.m783c();
                        if (ARController.this.f469s != null) {
                            ARController.this.f469s.mo9221a();
                        }
                        i = MsgField.IMSG_SO_LOAD_SUCCESS;
                        str = MsgField.SMSG_SO_LOAD_SUCCESS;
                    } else {
                        i = MsgField.IMSG_SO_LOAD_FAILED;
                        str = MsgField.SMSG_SO_LOAD_FAILED;
                    }
                    C0618d.m1300a(i, str);
                }
            }
        });
        this.f457g.setOnARResourceRequestListener(new RequestController.C0607b() {
            /* renamed from: a */
            public void mo8858a(ARResource aRResource) {
                if (ARController.this.f457g != null && aRResource != null) {
                    ARController.this.m773a(aRResource);
                }
            }
        });
    }

    /* renamed from: g */
    private void m791g() {
        try {
            this.f456f.mo9856d().mo9884d();
        } catch (NullPointerException unused) {
            Log.e(f445b, "bdar: ARBlender object is null!");
            C0654c.m1581h();
        }
    }

    /* renamed from: h */
    private void m792h() {
        this.f469s.mo9229c(SystemInfoUtil.isScreenOrientationLandscape(this.f459i));
        new DisplayMetrics();
        DisplayMetrics displayMetrics = this.f459i.getResources().getDisplayMetrics();
        this.f469s.mo9222a(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static boolean isContainMisic(String str) {
        C0623a parseDuMixRes;
        if (TextUtils.isEmpty(str) || !ProjectParams.isHuaweiProject() || (parseDuMixRes = ParserJson.parseDuMixRes(m769a(str))) == null) {
            return false;
        }
        return parseDuMixRes.mo9673c();
    }

    public static boolean isSupportFrontCamera(String str) {
        C0623a parseDuMixRes;
        if (TextUtils.isEmpty(str) || (parseDuMixRes = ParserJson.parseDuMixRes(m769a(str))) == null) {
            return false;
        }
        return parseDuMixRes.mo9672b();
    }

    public void cancelDownloadCase(String str) {
        ARResource aRResource = new ARResource();
        if (TextUtils.isEmpty(str)) {
            Log.e("error", "null arKey");
            return;
        }
        aRResource.setKey(str);
        if (this.f450E != null) {
            this.f450E.mo10559a(aRResource);
        }
    }

    public void changeCase(DuMixSource duMixSource) {
        if (this.f459i != null) {
            if (TextUtils.isEmpty(duMixSource.getResFilePath())) {
                if (TextUtils.equals(ARConfig.getARKey(), duMixSource.getArKey()) && !ProjectParams.isHuaweiProject()) {
                    return;
                }
            } else if (TextUtils.equals(this.f460j.getResFilePath(), duMixSource.getResFilePath())) {
                return;
            }
            if (this.f455e != null) {
                if (Constants.DEBUG) {
                    Log.e(f445b, "changeCase releaseForSwitchCase!!!");
                }
                this.f455e.mo9539i();
                this.f455e = null;
            }
            this.f460j = duMixSource;
            m781b(duMixSource);
            m774a(duMixSource.getArKey(), duMixSource.getArType(), duMixSource.getResFilePath());
            if (TextUtils.isEmpty(duMixSource.getResFilePath())) {
                m790f();
            } else {
                m772a(duMixSource);
                if (this.f462l != null) {
                    this.f462l.onCaseChange(true);
                }
            }
            this.f466p = true;
        }
    }

    public void changeCloudArState(int i) {
        if (this.f455e != null && (this.f455e instanceof C0754a)) {
            ((C0754a) this.f455e).mo10091a(i);
        }
    }

    public void closeVolume() {
        if (this.f471u == null && this.f459i != null) {
            this.f471u = (AudioManager) this.f459i.getSystemService("audio");
        }
        if (this.f471u != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f472v = this.f471u.isStreamMute(3);
            }
            if (!this.f472v) {
                this.f471u.adjustStreamVolume(3, -100, 0);
            }
        }
    }

    public void downloadCase(String str, ArCaseDownloadListener arCaseDownloadListener) {
        if (this.f450E == null) {
            this.f450E = new C0872a();
            DownloadManager.getInstance().onActivityResumed();
        }
        ARResource aRResource = new ARResource();
        if (TextUtils.isEmpty(str)) {
            Log.e("error", "null arKey");
            return;
        }
        aRResource.setKey(str);
        this.f450E.mo10560a(arCaseDownloadListener);
        this.f450E.mo10558a(this.f459i, aRResource);
    }

    public C0654c getBlender() {
        return this.f456f;
    }

    public RequestController getRequestController() {
        return this.f457g;
    }

    public boolean isEnginSoLoaded() {
        if (this.f456f != null) {
            return this.f456f.mo9857e();
        }
        return false;
    }

    public void managePreviewFrame(byte[] bArr, int i, int i2) {
        try {
            C0654c.m1579b(bArr, i, i2);
        } catch (Exception e) {
            e.printStackTrace();
            C0654c.m1581h();
        }
    }

    public void onAppear() {
        ARPEngine.getInstance().onResumeByUser();
    }

    public void onCameraPreviewFrame(byte[] bArr, int i, int i2) {
        if (bArr != null && this.f454d && this.f462l != null) {
            if (this.f466p) {
                this.f466p = false;
                if (Constants.DEBUG) {
                    Log.e(f445b, "onCameraPreviewFrame mFirstFrame = true");
                }
                if (this.f460j != null && !TextUtils.isEmpty(this.f460j.getResFilePath()) && FileUtils.existsDir(this.f460j.getResFilePath())) {
                    ARResource aRResource = new ARResource();
                    aRResource.setKey(this.f460j.getArKey());
                    aRResource.setType(this.f460j.getArType());
                    aRResource.setResFilePath(this.f460j.getResFilePath());
                    aRResource.setCaseConfigJsonInfo(ArResourceUtils.generateResult(this.f460j.getResFilePath()));
                    if (Constants.DEBUG) {
                        String str = f445b;
                        Log.e(str, "onCameraPreviewFrame arResource = " + aRResource.getCaseConfigJsonInfo());
                    }
                    m773a(aRResource);
                }
            }
            if (this.f467q == null) {
                this.f467q = new C0765a(i, i2);
            }
            if (this.f470t == TextureParams.SourceType.YUV_DATA) {
                if (this.f465o == null || this.f465o.mo9780e() != TextureParams.VideoRenderMode.FG) {
                    if (this.f448C) {
                        synchronized (this.f447B) {
                            m776a(this.f446A, this.f467q);
                        }
                    } else {
                        m776a(bArr, this.f467q);
                    }
                    m791g();
                    m775a(bArr);
                } else {
                    m791g();
                }
            } else if (this.f470t == TextureParams.SourceType.SURFACE_TEXTURE) {
                try {
                    this.f456f.mo9856d().mo9884d();
                } catch (NullPointerException unused) {
                    C0654c.m1581h();
                }
            }
            if (this.f455e != null) {
                this.f455e.mo9534d(bArr, this.f467q);
            }
            if (this.f476z != null) {
                this.f476z.onPreviewCallback(bArr, i, i2);
            }
        }
    }

    public void onClickCameraButton() {
        this.f448C = false;
    }

    public void onCover() {
        ARPEngine.getInstance().onPauseByUser();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f469s == null) {
            return false;
        }
        this.f469s.mo9224a(motionEvent);
        return true;
    }

    public void openVolume() {
        if (this.f471u == null && this.f459i != null) {
            this.f471u = (AudioManager) this.f459i.getSystemService("audio");
        }
        if (this.f471u != null) {
            this.f471u.adjustStreamVolume(3, 100, 0);
        }
    }

    public void orientationChange(int i) {
        Orientation calcOrientation;
        int degree;
        if (i != -1 && (calcOrientation = OrientationManager.calcOrientation(i, Orientation.valueOf(this.f474x))) != null && this.f474x != (degree = calcOrientation.getDegree())) {
            this.f474x = degree;
            if (isEnginSoLoaded()) {
                C0802a.m2100a(this.f474x);
            }
        }
    }

    public void pause() {
        this.f452a = false;
        ARPEngine.getInstance().setIsAppBackground(true);
        if (this.f455e != null) {
            this.f455e.mo9535e();
        }
        if (this.f469s != null) {
            if (this.f455e == null || !this.f455e.mo9542l()) {
                Log.d(f445b, "mArTouchEvent.onPause is not called");
            } else {
                this.f469s.mo9227b();
            }
        }
        if (this.f457g != null) {
            this.f457g.onPause();
            this.f457g.cancelQueryRes();
            this.f457g.cancelDownloadTask();
        }
        if (this.f456f != null) {
            this.f456f.mo9853b();
            ARPEngine.getInstance().onPauseByUser();
        }
    }

    public void reSetup(SurfaceTexture surfaceTexture, int i, int i2) {
        TextureParams a;
        try {
            if (this.f461k != null) {
                this.f461k.setTargetWidth(i);
                this.f461k.setTargetHeight(i2);
                this.f463m = m765a(this.f460j, this.f461k);
                if (this.f465o == null || !PerformanceTest.isDrawCamera()) {
                    a = m767a(this.f464n, TextureParams.VideoRenderMode.NONE, this.f460j, this.f461k, this.f465o, this.f475y);
                } else {
                    a = m767a(this.f464n, this.f465o.mo9780e(), this.f460j, this.f461k, this.f465o, this.f475y);
                }
                this.f465o = a;
            }
            if (this.f456f != null) {
                this.f456f.mo9846a(this.f465o);
                this.f456f.mo9844a(surfaceTexture, i, i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        this.f471u = null;
        DownloadManager.getInstance().cancelAll();
        if (this.f457g != null) {
            this.f457g.release();
            this.f457g = null;
        }
        if (this.f468r != null) {
            this.f468r.mo9512c();
            this.f468r = null;
        }
        m779b();
        if (this.f456f != null) {
            this.f456f.mo9855c();
            this.f456f = null;
        }
        C0654c.m1581h();
        C0618d.m1297a();
        if (!this.f472v && this.f471u != null) {
            this.f471u.adjustStreamVolume(3, 100, 0);
        }
        if (this.f462l != null) {
            this.f462l.onRelease(true);
            this.f462l = null;
        }
        this.f460j = null;
        this.f461k = null;
        this.f459i = null;
        this.f458h = null;
        synchronized (this.f447B) {
            this.f446A = null;
        }
        this.f449D = null;
        if (this.f453c != null) {
            this.f453c.finish();
            this.f453c = null;
        }
    }

    public void resume() {
        if (!this.f452a && this.f454d) {
            ARPEngine.getInstance().setIsAppBackground(this.f452a);
            DownloadManager.getInstance().onActivityResumed();
            this.f452a = true;
            if (m788d()) {
                if (this.f455e != null) {
                    this.f455e.mo9533d();
                }
                if (this.f469s != null) {
                    this.f469s.mo9221a();
                }
                if (this.f457g != null) {
                    this.f457g.onResume();
                    if (this.f455e == null) {
                        this.f457g.start();
                    }
                }
                if (this.f456f != null) {
                    this.f456f.mo9842a();
                }
            }
        }
    }

    public boolean sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.f455e == null) {
            return true;
        }
        this.f455e.mo9520a(hashMap);
        return true;
    }

    public void setCameraPreViewCallback(CameraPreViewCallback cameraPreViewCallback) {
        this.f476z = cameraPreViewCallback;
    }

    public void setRecgArRetry() {
        if (this.f455e != null && (this.f455e instanceof C0822b)) {
            ((C0822b) this.f455e).mo10345m();
        }
    }

    public void setUserInteractionEnabled(boolean z) {
        if (this.f469s != null) {
            this.f469s.mo9228b(z);
        }
    }

    public void setup(DuMixSource duMixSource, DuMixTarget duMixTarget, DuMixCallback duMixCallback) {
        if (duMixCallback == null) {
            Log.e(f445b, "setup DuMixCallback is NULLLLL!!!");
        }
        if (m786c(duMixSource)) {
            Log.e(f445b, "setup DuMixSource is illegal!!!");
            return;
        }
        duMixSource.setResFilePath(duMixSource.getResFilePath());
        this.f460j = duMixSource;
        this.f461k = duMixTarget;
        this.f462l = duMixCallback;
        C0618d.m1301a(duMixCallback);
        this.f470t = this.f460j.getCameraSource() != null ? TextureParams.SourceType.SURFACE_TEXTURE : TextureParams.SourceType.YUV_DATA;
        this.f463m = m765a(this.f460j, this.f461k);
        this.f464n = this.f460j.isFrontCamera();
        m781b(this.f460j);
        m774a(this.f460j.getArKey(), this.f460j.getArType(), this.f460j.getResFilePath());
        boolean isOpen3DEngine = PerformanceTest.isOpen3DEngine();
        boolean isDrawCamera = PerformanceTest.isDrawCamera();
        this.f456f = new C0654c();
        if (isOpen3DEngine) {
            this.f456f.mo9851a(false, false);
            this.f456f.mo9843a(30);
        }
        this.f456f.mo9856d().mo9879a(0);
        this.f465o = m767a(this.f464n, isDrawCamera ? TextureParams.VideoRenderMode.BG : TextureParams.VideoRenderMode.NONE, this.f460j, this.f461k, this.f465o, this.f475y);
        this.f456f.mo9845a(this.f460j.getCameraSource(), this.f465o);
        this.f456f.mo9844a(this.f461k.getDrawTarget(), this.f461k.getTargetWidth(), this.f461k.getTargetHeight());
        this.f461k.getDrawTarget().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                try {
                    if (1 == ARPEngine.getInstance().getArGLEngineCtl().mo9239e() && !ARPEngine.getInstance().getArGLEngineCtl().mo9238d()) {
                        ARPEngine.getInstance().getArGLEngineCtl().mo9237c();
                    }
                } catch (Exception unused) {
                }
                if (ARController.this.f461k != null && ARController.this.f461k.getTargetFrameAvailableListener() != null) {
                    ARController.this.f461k.getTargetFrameAvailableListener().onFrameAvailable(surfaceTexture);
                }
            }
        });
        if (!TextUtils.isEmpty(this.f460j.getResFilePath())) {
            this.f473w = true;
        }
        if (ArsdkLicense.checkLocalAuth(this.f459i)) {
            this.f454d = true;
            m770a();
            resume();
        } else if (duMixCallback != null) {
            duMixCallback.onStateChange(MsgField.MSG_AUTH_FAIL, "");
        }
    }

    public void startRecord(String str, long j, MovieRecorderCallback movieRecorderCallback) {
        if (TextUtils.isEmpty(str) || j <= 0) {
            Log.e(f445b, "startRecord outputFile or totalTimeMs is error!!!");
            return;
        }
        C0852d dVar = new C0852d();
        dVar.mo10480a(str);
        int i = 0;
        int i2 = 1280;
        int i3 = 720;
        if (this.f474x == 90 || this.f474x == -90) {
            i = this.f474x;
        } else {
            i2 = 720;
            i3 = 1280;
        }
        dVar.mo10478a(i2);
        dVar.mo10483b(i3);
        dVar.mo10479a(j);
        if (this.f468r == null && this.f459i != null) {
            this.f468r = new C0609a(this.f459i);
        }
        if (this.f468r != null) {
            this.f468r.mo9508a(dVar, movieRecorderCallback);
            this.f468r.mo9511b(i);
        }
        if (this.f456f != null) {
            this.f456f.mo9847a((C0654c.C0668c) this.f468r);
        }
    }

    public void stopRecord() {
        if (this.f456f != null && this.f468r != null) {
            this.f456f.mo9854b((C0654c.C0668c) this.f468r);
        }
    }

    public void switchCamera(boolean z) {
        UiThreadUtil.removeCallbacks(this.f449D);
        UiThreadUtil.postDelayed(this.f449D, 3000);
        if (!z || !this.f473w || !ProjectParams.isHuaweiProject() || isSupportFrontCamera(this.f460j.getResFilePath())) {
            this.f464n = z;
            this.f465o = m767a(this.f464n, PerformanceTest.isDrawCamera() ? this.f465o.mo9780e() : TextureParams.VideoRenderMode.NONE, this.f460j, this.f461k, this.f465o, this.f475y);
            this.f456f.mo9846a(this.f465o);
            if (this.f455e != null) {
                this.f455e.mo9531c(z);
                return;
            }
            return;
        }
        Log.e(f445b, "switchCamera not support front camera!!!");
    }

    public void switchCameraInFgAndBg(int i, String str) {
        boolean z;
        TextureParams.VideoRenderMode videoRenderMode;
        if (!(this.f456f == null || this.f460j == null || this.f461k == null || this.f465o == null)) {
            TextureParams.VideoRenderMode a = TextureParams.VideoRenderMode.m1475a(i);
            this.f465o = m767a(this.f464n, a, this.f460j, this.f461k, this.f465o, this.f475y);
            if (a == TextureParams.VideoRenderMode.NONE) {
                if (this.f465o.mo9780e() == TextureParams.VideoRenderMode.BG) {
                    z = this.f464n;
                    videoRenderMode = TextureParams.VideoRenderMode.FG;
                } else if (this.f465o.mo9780e() == TextureParams.VideoRenderMode.FG) {
                    z = this.f464n;
                    videoRenderMode = TextureParams.VideoRenderMode.BG;
                }
                this.f465o = m767a(z, videoRenderMode, this.f460j, this.f461k, this.f465o, this.f475y);
            }
            this.f456f.mo9846a(this.f465o);
        }
        ARPEngine.getInstance().getArGLEngineCtl().mo9234a(str);
    }

    public void switchCase(String str, int i) {
        if (!TextUtils.equals(ARConfig.getARKey(), str) && this.f459i != null) {
            if (this.f455e != null) {
                this.f455e.mo9539i();
                this.f455e = null;
            }
            m774a(str, i, (String) null);
            m790f();
            this.f466p = true;
            this.f457g.start();
        }
    }

    public void switchCase(String str, int i, String str2) {
        if (!TextUtils.equals(ARConfig.getARKey(), str) && !TextUtils.equals(ARConfig.getARPath(), str2) && this.f459i != null) {
            if (this.f455e != null) {
                this.f455e.mo9539i();
                this.f455e = null;
            }
            m774a(str, i, str2);
            m790f();
            this.f466p = true;
            this.f457g.start();
        }
    }

    public boolean switchCaseForRecommend(ARResource aRResource) {
        if (TextUtils.equals(ARConfig.getARKey(), aRResource.getKey())) {
            return true;
        }
        if (this.f451F != null) {
            return false;
        }
        ARConfig.setARKey(aRResource.getKey());
        m782b(aRResource);
        return true;
    }

    public void takePicture(TakePictureCallback2 takePictureCallback2) {
        this.f456f.mo9848a((C0654c.C0669d) new C0620e(this.f474x, takePictureCallback2));
    }

    public void takePicture(String str, TakePictureCallback takePictureCallback) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f445b, "takePicture outputFile is empty!!!");
            return;
        }
        this.f456f.mo9848a((C0654c.C0669d) new C0620e(str, this.f474x, takePictureCallback));
    }

    public void updateSegMaskData(byte[] bArr, int i, int i2, int i3) {
        if (this.f456f != null) {
            this.f456f.mo9852a(bArr, i, i2);
            if (i3 != this.f475y) {
                this.f475y = i3;
                if (this.f465o.mo9780e() == TextureParams.VideoRenderMode.FG) {
                    this.f465o = m767a(this.f464n, TextureParams.VideoRenderMode.FG, this.f460j, this.f461k, this.f465o, this.f475y);
                    this.f456f.mo9846a(this.f465o);
                }
            }
        }
    }
}
