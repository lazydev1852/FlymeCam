package com.iflytek.business.speech;

import android.os.Bundle;

/* renamed from: com.iflytek.business.speech.a */
public class AIUIEvent {

    /* renamed from: a */
    public int f2462a;

    /* renamed from: b */
    public int f2463b;

    /* renamed from: c */
    public int f2464c;

    /* renamed from: d */
    public Bundle f2465d;

    public AIUIEvent() {
    }

    public AIUIEvent(int i, int i2, int i3, Bundle bundle) {
        this.f2462a = i;
        this.f2463b = i2;
        this.f2464c = i3;
        this.f2465d = bundle;
    }

    public Object clone() throws CloneNotSupportedException {
        AIUIEvent aVar = (AIUIEvent) super.clone();
        if (this.f2465d != null) {
            aVar.f2465d = (Bundle) this.f2465d.clone();
        }
        return aVar;
    }

    public String toString() {
        return "AIUIEvent {eventType = " + this.f2462a + ", arg1 = " + this.f2463b + ", arg2 = " + this.f2464c + ", bundle = " + this.f2465d + "}";
    }
}
