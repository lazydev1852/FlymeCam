package com.meizu.common.app;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.meizu.common.p060a.PathInterpolatorCompat;

public class SlideNotice {

    /* renamed from: a */
    private static final Interpolator f4137a = new PathInterpolatorCompat(0.2f, 0.46f, 0.1f, 1.0f);

    /* renamed from: b */
    private static final Interpolator f4138b = new PathInterpolatorCompat(0.33f, 0.061f, 0.24f, 1.0f);

    private static final class SlideContainerView extends FrameLayout {
        public SlideContainerView(Context context) {
            super(context);
        }
    }
}
