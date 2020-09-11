package com.meizu.media.camera.simplify;

import com.meizu.media.camera.views.ShutterButton;
import com.meizu.savior.ChangeQuickRedirect;

public interface MzSimplifyCamController extends ShutterButton.C2727a {

    public enum ModuleState {
        IDLE,
        SWITCHING_MODE,
        SWITCHING_CAMERA;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    /* renamed from: a */
    void mo18401a(boolean... zArr);

    /* renamed from: aN */
    int mo18418aN();

    /* renamed from: o */
    void mo18491o(boolean z);
}
