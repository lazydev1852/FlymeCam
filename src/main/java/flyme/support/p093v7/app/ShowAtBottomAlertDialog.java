package flyme.support.p093v7.app;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import flyme.support.p093v7.app.AlertDialog;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.app.ShowAtBottomAlertDialog */
public class ShowAtBottomAlertDialog extends AlertDialog {
    public ShowAtBottomAlertDialog(Context context) {
        super(context);
    }

    public ShowAtBottomAlertDialog(Context context, int i) {
        super(context, i);
    }

    /* renamed from: flyme.support.v7.app.ShowAtBottomAlertDialog$Builder */
    public static class Builder extends AlertDialog.Builder {
        public Builder(Context context) {
            super(context, R.style.Theme_Flyme_AppCompat_Light_Dialog_Alert_ShowAtBottom);
        }

        public Builder(@NonNull Context context, int i) {
            super(context, i);
        }

        /* renamed from: f */
        public Builder mo25124a(int i) {
            super.mo25124a(i);
            return this;
        }

        /* renamed from: c */
        public Builder mo25131a(@Nullable CharSequence charSequence) {
            super.mo25131a(charSequence);
            return this;
        }

        /* renamed from: c */
        public ShowAtBottomAlertDialog mo25141b() {
            mo25137b(R.string.mc_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            return (ShowAtBottomAlertDialog) mo25135a(new AlertDialog.Builder.C3092a<ShowAtBottomAlertDialog>() {
                /* renamed from: b */
                public ShowAtBottomAlertDialog mo25147a(@NonNull Context context, int i) {
                    return new ShowAtBottomAlertDialog(context, i);
                }
            });
        }
    }
}
