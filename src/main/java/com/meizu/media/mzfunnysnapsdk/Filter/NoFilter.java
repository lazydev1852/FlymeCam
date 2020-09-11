package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class NoFilter extends BaseFilter {
    public static ChangeQuickRedirect changeQuickRedirect;

    public void onSizeChanged(int i, int i2) {
    }

    public NoFilter(Resources resources) {
        super(resources);
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9117, new Class[0], Void.TYPE).isSupported) {
            createProgramByAssetsFile("shader/base_vertex.sh", "shader/base_fragment.sh");
        }
    }
}
