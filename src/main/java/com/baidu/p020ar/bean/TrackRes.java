package com.baidu.p020ar.bean;

import java.util.List;

/* renamed from: com.baidu.ar.bean.TrackRes */
public class TrackRes {

    /* renamed from: a */
    private List<C0629f> f1120a;

    /* renamed from: b */
    private TipBean f1121b;

    /* renamed from: c */
    private C0627d f1122c;

    /* renamed from: d */
    private C0628e f1123d;

    /* renamed from: e */
    private List<C0624b> f1124e;

    public TrackRes() {
    }

    public TrackRes(TrackRes trackRes) {
        if (!(trackRes.getTargetBeanList() == null || trackRes.getTargetBeanList().size() == 0)) {
            this.f1120a = trackRes.getTargetBeanList();
        }
        if (trackRes.getTipBean() != null) {
            this.f1121b = this.f1121b == null ? trackRes.getTipBean() : this.f1121b.clone(trackRes.getTipBean());
        }
    }

    public List<C0624b> getPaddle() {
        return this.f1124e;
    }

    public C0627d getService() {
        return this.f1122c;
    }

    public C0628e getSlamModel() {
        return this.f1123d;
    }

    public List<C0629f> getTargetBeanList() {
        return this.f1120a;
    }

    public TipBean getTipBean() {
        return this.f1121b;
    }

    public void setPaddle(List<C0624b> list) {
        this.f1124e = list;
    }

    public void setService(C0627d dVar) {
        this.f1122c = dVar;
    }

    public void setSlamModel(C0628e eVar) {
        this.f1123d = eVar;
    }

    public void setTargetBeanList(List<C0629f> list) {
        this.f1120a = list;
    }

    public void setTipBean(TipBean tipBean) {
        this.f1121b = tipBean;
    }
}
