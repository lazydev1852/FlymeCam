package com.baidu.p020ar.bean;

import android.text.TextUtils;
import com.baidu.p020ar.bean.AttrData;

/* renamed from: com.baidu.ar.bean.TipBean */
public class TipBean {

    /* renamed from: a */
    private String f1102a;

    /* renamed from: b */
    private String f1103b;

    /* renamed from: c */
    private String f1104c;

    /* renamed from: d */
    private String f1105d;

    /* renamed from: e */
    private String f1106e;

    /* renamed from: f */
    private String f1107f;

    /* renamed from: g */
    private float f1108g = Float.NaN;

    /* renamed from: h */
    private float f1109h = Float.NaN;

    /* renamed from: i */
    private AttrData.CaseType f1110i;

    /* renamed from: j */
    private int f1111j;

    /* renamed from: k */
    private String f1112k;

    /* renamed from: l */
    private int f1113l;

    /* renamed from: m */
    private String f1114m;

    /* renamed from: n */
    private String f1115n;

    /* renamed from: o */
    private String f1116o;

    /* renamed from: p */
    private String f1117p;

    /* renamed from: q */
    private int f1118q = 0;

    /* renamed from: r */
    private int f1119r = 0;

    public TipBean clone(TipBean tipBean) {
        if (!TextUtils.isEmpty(tipBean.getDemarcateTip())) {
            setDemarcateTip(tipBean.getDemarcateTip());
        }
        if (!TextUtils.isEmpty(tipBean.getDemarcateFailedTip())) {
            setDemarcateFailedTip(tipBean.getDemarcateFailedTip());
        }
        if (!TextUtils.isEmpty(tipBean.getHint())) {
            setHint(tipBean.getHint());
        }
        if (!TextUtils.isEmpty(tipBean.getTooFarHint())) {
            setTooFarHint(tipBean.getTooFarHint());
        }
        if (!TextUtils.isEmpty(tipBean.getTooNearHint())) {
            setTooNearHint(tipBean.getTooNearHint());
        }
        if (!TextUtils.isEmpty(tipBean.getNotFindHint())) {
            setNotFindHint(tipBean.getNotFindHint());
        }
        if (Float.compare(tipBean.getFarThreshold(), Float.NaN) != 0) {
            setFarThreshold(tipBean.getFarThreshold());
        }
        if (Float.compare(tipBean.getNearThreshold(), Float.NaN) != 0) {
            setNearThreshold(tipBean.getNearThreshold());
        }
        return this;
    }

    public String getAlignPlane() {
        return this.f1116o;
    }

    public AttrData.CaseType getCaseType() {
        return this.f1110i;
    }

    public String getDemarcateFailedTip() {
        return this.f1103b;
    }

    public String getDemarcateTip() {
        return this.f1102a;
    }

    public float getFarThreshold() {
        return this.f1108g;
    }

    public String getFindPerfectPlane() {
        return this.f1114m;
    }

    public String getHelpUrl() {
        return this.f1112k;
    }

    public int getHelpUrlShowOnce() {
        return this.f1113l;
    }

    public int getHideCaptureGroupImmediately() {
        return this.f1118q;
    }

    public String getHint() {
        return this.f1104c;
    }

    public float getNearThreshold() {
        return this.f1109h;
    }

    public String getNotFindHint() {
        return this.f1107f;
    }

    public String getPlayDesUrl() {
        return this.f1115n;
    }

    public int getShowTipsByCase() {
        return this.f1119r;
    }

    public String getTooFarHint() {
        return this.f1105d;
    }

    public String getTooNearHint() {
        return this.f1106e;
    }

    public String getTrackTargePicPath() {
        return this.f1117p;
    }

    public int getUdtMode() {
        return this.f1111j;
    }

    public void setAlignPlane(String str) {
        this.f1116o = str;
    }

    public void setCaseType(AttrData.CaseType caseType) {
        this.f1110i = caseType;
    }

    public void setDemarcateFailedTip(String str) {
        this.f1103b = str;
    }

    public void setDemarcateTip(String str) {
        this.f1102a = str;
    }

    public void setFarThreshold(float f) {
        this.f1108g = f;
    }

    public void setFindPerfectPlane(String str) {
        this.f1114m = str;
    }

    public void setHelpUrl(String str) {
        this.f1112k = str;
    }

    public void setHelpUrlShowOnce(int i) {
        this.f1113l = i;
    }

    public void setHideCaptureGroupImmediately(int i) {
        this.f1118q = i;
    }

    public void setHint(String str) {
        this.f1104c = str;
    }

    public void setNearThreshold(float f) {
        this.f1109h = f;
    }

    public void setNotFindHint(String str) {
        this.f1107f = str;
    }

    public void setPlayDesUrl(String str) {
        this.f1115n = str;
    }

    public void setShowTipsByCase(int i) {
        this.f1119r = i;
    }

    public void setTooFarHint(String str) {
        this.f1105d = str;
    }

    public void setTooNearHint(String str) {
        this.f1106e = str;
    }

    public void setTrackTargePicPath(String str) {
        this.f1117p = str;
    }

    public void setUdtMode(int i) {
        this.f1111j = i;
    }
}
