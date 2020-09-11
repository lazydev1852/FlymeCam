package com.meizu.media.camera.util;

import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Comparator;

/* renamed from: com.meizu.media.camera.util.ao */
public class SlideBarModeComparator implements Comparator {

    /* renamed from: a */
    public static ChangeQuickRedirect f14118a;

    public int compare(Object obj, Object obj2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{obj, obj2}, this, f14118a, false, 8198, new Class[]{Object.class, Object.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int abs = Math.abs(((CameraModeType.ModeType) obj).getSortDeterminer());
        int abs2 = Math.abs(((CameraModeType.ModeType) obj2).getSortDeterminer());
        if (abs > abs2) {
            return 1;
        }
        if (abs < abs2) {
            return -1;
        }
        return 0;
    }
}
