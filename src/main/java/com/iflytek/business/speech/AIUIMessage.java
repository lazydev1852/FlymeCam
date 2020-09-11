package com.iflytek.business.speech;

import android.os.Bundle;

/* renamed from: com.iflytek.business.speech.b */
public class AIUIMessage implements Cloneable {

    /* renamed from: a */
    public int f2466a;

    /* renamed from: b */
    public int f2467b;

    /* renamed from: c */
    public int f2468c;

    /* renamed from: d */
    public Bundle f2469d;

    public AIUIMessage() {
    }

    public AIUIMessage(int i, int i2, int i3, Bundle bundle) {
        this.f2466a = i;
        this.f2467b = i2;
        this.f2468c = i3;
        this.f2469d = bundle;
    }

    public Object clone() throws CloneNotSupportedException {
        AIUIMessage bVar = (AIUIMessage) super.clone();
        if (this.f2469d != null) {
            bVar.f2469d = (Bundle) this.f2469d.clone();
        }
        return bVar;
    }

    public String toString() {
        return "AIUIMessage {msgType = " + this.f2466a + ", arg1 = " + this.f2467b + ", arg2 = " + this.f2468c + ", bundle = " + this.f2469d + "}";
    }
}
