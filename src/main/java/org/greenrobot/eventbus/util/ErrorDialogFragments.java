package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public class ErrorDialogFragments {

    /* renamed from: a */
    public static int f19100a;

    /* renamed from: b */
    public static Class<?> f19101b;

    /* renamed from: a */
    public static Dialog m21825a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        if (f19100a != 0) {
            builder.setIcon(f19100a);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    /* renamed from: a */
    public static void m21826a(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) {
        if (f19101b != null) {
            try {
                ErrorDialogManager.f19102a.f19107a.mo28003a().mo27980d(f19101b.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Event cannot be constructed", e);
            }
        }
        if (bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) && activity != null) {
            activity.finish();
        }
    }

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.m21825a(getActivity(), getArguments(), this);
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.m21826a(dialogInterface, i, getActivity(), getArguments());
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.m21825a(getActivity(), getArguments(), this);
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.m21826a(dialogInterface, i, getActivity(), getArguments());
        }
    }
}
