package com.baidu.p020ar.bean;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.Constants;
import com.baidu.p020ar.util.FileUtils;
import java.util.List;
import java.util.Map;

/* renamed from: com.baidu.ar.bean.ARResource */
public class ARResource {
    public static final int DOWNLOAD_STATUS_DOWNLOADED = -2;
    public static final int DOWNLOAD_STATUS_FAILED = -3;
    public static final int DOWNLOAD_STATUS_NONE = -1;
    public static final int DOWNLOAD_STATUS_WAIT = -4;

    /* renamed from: a */
    private int f1065a = Integer.MIN_VALUE;

    /* renamed from: b */
    private String f1066b;

    /* renamed from: c */
    private String f1067c;

    /* renamed from: d */
    private String f1068d;

    /* renamed from: e */
    private String[] f1069e;

    /* renamed from: f */
    private String f1070f;

    /* renamed from: g */
    private String f1071g;

    /* renamed from: h */
    private int f1072h;

    /* renamed from: i */
    private String f1073i;

    /* renamed from: j */
    private String f1074j;

    /* renamed from: k */
    private String f1075k;

    /* renamed from: l */
    private int f1076l;

    /* renamed from: m */
    private boolean f1077m = false;

    /* renamed from: n */
    private boolean f1078n = true;

    /* renamed from: o */
    private String f1079o;

    /* renamed from: p */
    private boolean f1080p;

    /* renamed from: q */
    private String f1081q;

    /* renamed from: r */
    private String f1082r;

    /* renamed from: s */
    private List<ARResource> f1083s;

    /* renamed from: t */
    private String f1084t;

    /* renamed from: u */
    private int f1085u = -1;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public ValueAnimator f1086v;

    /* renamed from: w */
    private Map<FunctionType, Boolean> f1087w;

    public static boolean isDownloading(int i) {
        return i >= 0 && i <= 100;
    }

    public void createAnimator() {
        this.f1086v = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f1086v.setDuration(200);
        this.f1086v.setInterpolator(new LinearInterpolator());
        this.f1086v.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
                ValueAnimator unused = ARResource.this.f1086v = null;
            }

            public void onAnimationEnd(Animator animator) {
                ValueAnimator unused = ARResource.this.f1086v = null;
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        });
        this.f1086v.start();
    }

    public String getAcId() {
        return this.f1079o;
    }

    public ValueAnimator getAnimator() {
        return this.f1086v;
    }

    public String getCaseConfigJsonInfo() {
        return this.f1084t;
    }

    public String getCodeDownloadUrl() {
        return this.f1081q;
    }

    public int getDownloadStatus() {
        if (this.f1085u == -2 && !FileUtils.existsFile(this.f1074j)) {
            this.f1085u = -1;
        }
        return this.f1085u;
    }

    public int getErrCode() {
        return this.f1065a;
    }

    public String getErrMsg() {
        return this.f1066b;
    }

    public Map<FunctionType, Boolean> getFunctionMap() {
        return this.f1087w;
    }

    public String getKey() {
        return this.f1067c;
    }

    public String[] getMultiResourceUrl() {
        return this.f1069e;
    }

    public String getRedirectUrl() {
        return this.f1070f;
    }

    public List<ARResource> getRelativeList() {
        return this.f1083s;
    }

    public String getResFilePath() {
        return this.f1075k;
    }

    public String getResourceUrl() {
        return this.f1068d;
    }

    public int getSize() {
        return this.f1076l;
    }

    public String getThumbnailUrl() {
        return this.f1082r;
    }

    public int getType() {
        return this.f1072h;
    }

    public String getVersionCode() {
        return this.f1071g;
    }

    public String getZipFilePath() {
        return this.f1074j;
    }

    public String getZipMD5() {
        return this.f1073i;
    }

    public boolean isHardwareSatisfied() {
        return this.f1078n;
    }

    public boolean isRefused() {
        return this.f1077m;
    }

    public boolean isShowAudioDialog() {
        return this.f1080p;
    }

    public void setAcId(String str) {
        this.f1079o = str;
    }

    public void setCaseConfigJsonInfo(String str) {
        this.f1084t = str;
    }

    public void setCodeDownloadUrl(String str) {
        this.f1081q = str;
    }

    public void setDownloadStatus(int i) {
        this.f1085u = i;
    }

    public void setErrCode(int i) {
        this.f1065a = i;
    }

    public void setErrMsg(String str) {
        this.f1066b = str;
    }

    public void setFunctionMap(Map<FunctionType, Boolean> map) {
        this.f1087w = map;
        if (Constants.DEBUG) {
            for (FunctionType next : map.keySet()) {
                ARLog.m2696e("bdar: function = " + next.getValue() + ", value = " + map.get(next));
            }
        }
    }

    public void setHardwareSatisfied(boolean z) {
        this.f1078n = z;
    }

    public void setKey(String str) {
        this.f1067c = str;
    }

    public void setMultiResourceUrl(String[] strArr) {
        this.f1069e = strArr;
    }

    public void setRedirectUrl(String str) {
        this.f1070f = str;
    }

    public void setRefused(boolean z) {
        this.f1077m = z;
    }

    public void setRelativeList(List<ARResource> list) {
        this.f1083s = list;
    }

    public void setResFilePath(String str) {
        this.f1075k = str;
    }

    public void setResourceUrl(String str) {
        this.f1068d = str;
    }

    public void setShowAudioDialog(boolean z) {
        this.f1080p = z;
    }

    public void setSize(int i) {
        this.f1076l = i;
    }

    public void setThumbnailUrl(String str) {
        this.f1082r = str;
    }

    public void setType(int i) {
        this.f1072h = i;
    }

    public void setVersionCode(String str) {
        this.f1071g = str;
    }

    public void setZipFilePath(String str) {
        this.f1074j = str;
    }

    public void setZipMD5(String str) {
        this.f1073i = str;
    }
}
