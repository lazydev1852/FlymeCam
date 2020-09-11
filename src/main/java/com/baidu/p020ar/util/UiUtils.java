package com.baidu.p020ar.util;

import android.app.Dialog;

/* renamed from: com.baidu.ar.util.UiUtils */
public class UiUtils {
    public static void dismissDialog(Dialog dialog) {
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showDialogSafely(Dialog dialog) {
        if (dialog != null) {
            try {
                dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
