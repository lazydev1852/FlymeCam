package com.meizu.update.util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.meizu.update.component.R;

/* renamed from: com.meizu.update.util.k */
public class WidgetHelper {
    /* renamed from: a */
    public static ProgressDialog m18007a(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(0);
        progressDialog.setMessage(context.getResources().getString(R.string.mzuc_wait_tip));
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    /* renamed from: a */
    public static AlertDialog m18006a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (str != null && str.length() > 0) {
            builder.setTitle(str);
        }
        if (str2 != null) {
            builder.setMessage(str2);
        }
        if (i > 0) {
            builder.setIcon(i);
        }
        builder.setPositiveButton(context.getResources().getString(17039370), onClickListener);
        builder.setCancelable(false);
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return builder.show();
    }

    /* renamed from: a */
    public static AlertDialog m18005a(Context context, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        return m18006a(context, (String) null, str, onClickListener, onCancelListener, -1);
    }
}
