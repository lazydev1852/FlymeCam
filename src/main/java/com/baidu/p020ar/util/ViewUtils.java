package com.baidu.p020ar.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* renamed from: com.baidu.ar.util.ViewUtils */
public class ViewUtils {
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static void removeFromParent(final View view) {
        if (view != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                }
            });
        }
    }

    public static void setRelativeMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.rightMargin = i3;
        marginLayoutParams.bottomMargin = i4;
        view.requestLayout();
    }

    public static void setViewEnabled(final View view, final boolean z) {
        if (view != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    view.setEnabled(z);
                }
            });
        }
    }

    public static void setViewText(final TextView textView, final String str) {
        if (textView != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    textView.setText(str);
                }
            });
        }
    }

    public static void setViewVisibility(final View view, final int i) {
        if (view != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    view.setVisibility(i);
                }
            });
        }
    }
}
