package com.baidu.p020ar.paddle;

import android.content.Context;
import com.baidu.p020ar.p021a.p022a.p023a.C0487a;
import com.baidu.p020ar.paddle.PaddleController;
import com.baidu.p020ar.rotate.Orientation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.baidu.ar.paddle.PaddleManager */
public class PaddleManager {

    /* renamed from: a */
    private static PaddleManager f1952a;

    /* renamed from: b */
    private Context f1953b;

    /* renamed from: c */
    private PaddleController f1954c;

    /* renamed from: d */
    private boolean f1955d = false;

    private PaddleManager() {
    }

    /* renamed from: a */
    private static void m2162a() {
        f1952a = null;
    }

    public static synchronized PaddleManager getInstance() {
        PaddleManager paddleManager;
        synchronized (PaddleManager.class) {
            if (f1952a == null) {
                f1952a = new PaddleManager();
            }
            paddleManager = f1952a;
        }
        return paddleManager;
    }

    public void destroy() {
        m2162a();
    }

    public void enablePaddle(boolean z, String str) {
        if (this.f1954c != null && this.f1954c.setEnabled(z, str)) {
            this.f1955d = z;
        }
    }

    public void initPaddle(Context context, ArrayList<String> arrayList, String str, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3, ArrayList<Integer> arrayList4, ArrayList<Float> arrayList5, ArrayList<Float> arrayList6, ArrayList<String> arrayList7, ArrayList<Float> arrayList8, ArrayList<Float> arrayList9, ArrayList<Float> arrayList10, ArrayList<Float> arrayList11, ArrayList<Float> arrayList12, ArrayList<Float> arrayList13, C0487a aVar, PaddleController.ActionListener actionListener) {
        if (this.f1953b == null) {
            this.f1953b = (Context) new WeakReference(context).get();
        }
        if (this.f1954c == null) {
            this.f1954c = new PaddleController(this.f1953b, arrayList, str, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, arrayList7, arrayList8, arrayList9, arrayList10, arrayList11, arrayList12, arrayList13, aVar, actionListener);
        }
    }

    public boolean isValid() {
        return this.f1955d;
    }

    public void notifyFrontCamera(boolean z) {
        PaddleController paddleController;
        int i;
        if (this.f1954c != null) {
            if (z) {
                paddleController = this.f1954c;
                i = 1;
            } else {
                paddleController = this.f1954c;
                i = 0;
            }
            paddleController.setCameraType(i);
        }
    }

    public void notifyIsSharing(boolean z) {
        this.f1955d = !z;
    }

    public void notifyOrientationChange(Orientation orientation) {
        if (this.f1954c != null) {
            this.f1954c.onOrientationChange(orientation);
        }
    }

    public void release() {
        if (this.f1954c != null) {
            this.f1954c.release();
            this.f1954c = null;
        }
        if (this.f1953b != null) {
            this.f1953b = null;
        }
    }

    public void runPaddle(byte[] bArr, int i, int i2) {
        if (this.f1954c != null) {
            this.f1954c.runPaddle(bArr, i, i2);
        }
    }
}
