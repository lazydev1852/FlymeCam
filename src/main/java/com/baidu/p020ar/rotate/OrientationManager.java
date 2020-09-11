package com.baidu.p020ar.rotate;

import android.content.Context;
import android.view.OrientationEventListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.ar.rotate.OrientationManager */
public class OrientationManager extends OrientationEventListener {

    /* renamed from: a */
    private static Orientation f2210a = Orientation.UNKNOWN;

    /* renamed from: d */
    private static boolean f2211d = false;

    /* renamed from: b */
    private Orientation f2212b = Orientation.PORTRAIT;

    /* renamed from: c */
    private List<OrientationListener> f2213c = new ArrayList();

    /* renamed from: com.baidu.ar.rotate.OrientationManager$OrientationListener */
    public interface OrientationListener {
        void onRotateOrientation(Orientation orientation);
    }

    public OrientationManager(Context context) {
        super(context);
    }

    /* renamed from: a */
    private static Orientation m2581a(int i) {
        if ((i >= 0 && i <= 10) || (i >= 350 && i <= 359)) {
            return Orientation.PORTRAIT;
        }
        if (i >= 80 && i <= 100) {
            return Orientation.LANDSCAPE;
        }
        if (i >= 170 && i <= 190) {
            return Orientation.PORTRAIT_REVERSE;
        }
        if (i < 260 || i > 280) {
            return null;
        }
        return Orientation.LANDSCAPE_REVERSE;
    }

    /* renamed from: b */
    private static Orientation[] m2582b(int i) {
        if (i > 0 && i < 90) {
            return new Orientation[]{Orientation.PORTRAIT, Orientation.LANDSCAPE};
        } else if (i > 90 && i < 180) {
            return new Orientation[]{Orientation.LANDSCAPE, Orientation.PORTRAIT};
        } else if (i <= 180 || i >= 270) {
            return new Orientation[]{Orientation.LANDSCAPE_REVERSE, Orientation.PORTRAIT};
        } else {
            return new Orientation[]{Orientation.PORTRAIT_REVERSE, Orientation.LANDSCAPE_REVERSE};
        }
    }

    /* renamed from: c */
    private static Orientation m2583c(int i) {
        return ((i < 0 || i > 45) && (i < 315 || i >= 360)) ? (i <= 45 || i >= 135) ? (i < 135 || i > 225) ? (i <= 225 || i >= 315) ? Orientation.PORTRAIT : Orientation.LANDSCAPE_REVERSE : Orientation.PORTRAIT_REVERSE : Orientation.LANDSCAPE : Orientation.PORTRAIT;
    }

    public static Orientation calcOrientation(int i, Orientation orientation) {
        if (f2211d) {
            i = (i + 90) % 360;
        }
        Orientation a = m2581a(i);
        if (a != null) {
            return a;
        }
        Orientation[] b = m2582b(i);
        return (orientation == b[0] || orientation == b[1]) ? orientation : m2583c(i);
    }

    public static Orientation getGlobalOrientation() {
        return f2210a;
    }

    public static void setGlobalOrientation(Orientation orientation) {
        f2210a = orientation;
    }

    public void addOrientationListener(OrientationListener orientationListener) {
        if (orientationListener != null && !this.f2213c.contains(orientationListener)) {
            this.f2213c.add(orientationListener);
        }
    }

    public void destroy() {
        this.f2213c.clear();
    }

    public void notifyOrientationChanged() {
        notifyOrientationChanged(this.f2212b);
    }

    public void notifyOrientationChanged(Orientation orientation) {
        setGlobalOrientation(orientation);
        for (OrientationListener onRotateOrientation : this.f2213c) {
            onRotateOrientation.onRotateOrientation(orientation);
        }
    }

    public void onOrientationChanged(int i) {
        Orientation calcOrientation;
        if (i != -1 && (calcOrientation = calcOrientation(i, this.f2212b)) != null && this.f2212b != calcOrientation) {
            this.f2212b = calcOrientation;
            notifyOrientationChanged(this.f2212b);
        }
    }

    public void removeOrientationListener(OrientationListener orientationListener) {
        if (orientationListener != null && this.f2213c.contains(orientationListener)) {
            this.f2213c.remove(orientationListener);
        }
    }

    public void setScreenOrientationLandscape(boolean z) {
        f2211d = z;
    }
}
