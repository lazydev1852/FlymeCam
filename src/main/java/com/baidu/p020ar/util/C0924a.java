package com.baidu.p020ar.util;

import com.baidu.p020ar.audio.AudioParams;
import com.baidu.p020ar.recorder.p046d.C0852d;

/* renamed from: com.baidu.ar.util.a */
public class C0924a {
    /* renamed from: a */
    public static boolean m2751a(C0852d dVar, AudioParams audioParams) {
        if (dVar == null || audioParams == null) {
            return false;
        }
        dVar.mo10485c(audioParams.getSampleRate());
        dVar.mo10486d(audioParams.getFrameSize());
        return true;
    }
}
