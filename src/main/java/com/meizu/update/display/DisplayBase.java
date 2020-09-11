package com.meizu.update.display;

import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.update.UcDisplayDialog;
import com.meizu.update.UpdateInfo;
import com.meizu.update.component.R;
import com.meizu.update.util.Loger;
import com.meizu.update.util.MinSdkChecker;
import flyme.support.p093v7.app.AlertDialog;

public abstract class DisplayBase {

    /* renamed from: a */
    protected Context f16219a;

    /* renamed from: b */
    protected UpdateInfo f16220b;

    /* renamed from: c */
    protected boolean f16221c;

    /* renamed from: d */
    protected Dialog f16222d;

    /* renamed from: e */
    private String f16223e;

    /* renamed from: f */
    private String f16224f;

    /* renamed from: g */
    private TextView f16225g;

    /* renamed from: h */
    private TextView f16226h;

    /* renamed from: i */
    private TextView f16227i;

    /* renamed from: j */
    private C2999a f16228j;

    /* renamed from: k */
    private BroadcastReceiver f16229k = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Loger.m17942c("Receive dialog show broadcast.");
            if (DisplayBase.this.f16222d != null && DisplayBase.this.f16222d.isShowing()) {
                try {
                    DisplayBase.this.f16222d.dismiss();
                } catch (Exception e) {
                    Loger.m17943d("dismiss dialog exception:" + e.getMessage());
                    DisplayBase.this.f16222d.hide();
                    DisplayBase.this.mo24766c();
                }
            }
        }
    };

    /* renamed from: com.meizu.update.display.DisplayBase$a */
    public interface C2999a {
        /* renamed from: a */
        void mo24778a();
    }

    /* renamed from: a */
    public abstract DisplayInfo mo24760a();

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo24770g() {
        return true;
    }

    protected static class DisplayInfo {

        /* renamed from: a */
        String f16240a;

        /* renamed from: b */
        String f16241b;

        /* renamed from: c */
        String f16242c;

        /* renamed from: d */
        String f16243d;

        /* renamed from: e */
        String f16244e;

        /* renamed from: f */
        String f16245f;

        /* renamed from: g */
        SelectedListener f16246g;

        public interface SelectedListener {

            public enum SelectedCode {
                POSITIVE,
                NEGATIVE,
                NEUTRAL,
                CANCELED
            }

            /* renamed from: a */
            void mo24777a(SelectedCode selectedCode);
        }

        public DisplayInfo(String str, String str2, String str3, String str4, String str5, String str6, SelectedListener selectedListener) {
            this.f16240a = str;
            this.f16241b = str2;
            this.f16242c = str3;
            this.f16243d = str4;
            this.f16244e = str5;
            this.f16245f = str6;
            this.f16246g = selectedListener;
        }
    }

    protected DisplayBase(Context context, UpdateInfo updateInfo) {
        if (context == null || updateInfo == null) {
            throw new IllegalArgumentException("params cant be null!");
        }
        this.f16219a = context;
        this.f16220b = updateInfo;
    }

    /* renamed from: a */
    public void mo24763a(boolean z) {
        this.f16221c = z;
    }

    /* renamed from: b */
    public UcDisplayDialog mo24764b() {
        try {
            return mo24783h();
        } catch (Exception e) {
            Loger.m17943d("display dialog exception!");
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    private UcDisplayDialog mo24783h() {
        View findViewById;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        final DisplayInfo a = mo24760a();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f16219a, R.style.Theme_Flyme_AppCompat_Light_Dialog_Alert);
        View inflate = LayoutInflater.from(this.f16219a).inflate(R.layout.dialog_update, (ViewGroup) null);
        this.f16225g = (TextView) inflate.findViewById(R.id.title);
        this.f16226h = (TextView) inflate.findViewById(R.id.summary);
        this.f16227i = (TextView) inflate.findViewById(R.id.msg);
        this.f16225g.setText(a.f16240a);
        if (!TextUtils.isEmpty(a.f16241b)) {
            this.f16226h.setVisibility(0);
            this.f16226h.setText(a.f16241b);
        }
        if (TextUtils.isEmpty(a.f16242c)) {
            this.f16227i.setVisibility(8);
        } else {
            this.f16227i.setVisibility(0);
            this.f16227i.setText(a.f16242c);
        }
        if (!mo24770g()) {
            inflate.findViewById(R.id.msg_indicator).setVisibility(8);
        }
        builder.mo25138b(inflate);
        builder.mo25132a((CharSequence) a.f16243d, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                a.f16246g.mo24777a(DisplayInfo.SelectedListener.SelectedCode.POSITIVE);
            }
        });
        if (!TextUtils.isEmpty(a.f16244e)) {
            builder.mo25140b((CharSequence) a.f16244e, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.f16246g.mo24777a(DisplayInfo.SelectedListener.SelectedCode.NEGATIVE);
                }
            });
        } else {
            builder.mo25133a(false);
        }
        if (!TextUtils.isEmpty(a.f16245f)) {
            builder.mo25144c((CharSequence) a.f16245f, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.f16246g.mo24777a(DisplayInfo.SelectedListener.SelectedCode.NEUTRAL);
                }
            });
        }
        builder.mo25126a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                a.f16246g.mo24777a(DisplayInfo.SelectedListener.SelectedCode.CANCELED);
            }
        });
        AlertDialog b = builder.mo25141b();
        this.f16222d = b;
        if (this.f16221c) {
            if (Build.VERSION.SDK_INT >= 26) {
                b.getWindow().setType(2038);
            } else {
                b.getWindow().setType(PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE);
            }
            m17703k();
        }
        b.setCanceledOnTouchOutside(false);
        b.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                DisplayBase.this.mo24766c();
                DisplayBase.this.mo24769f();
            }
        });
        m17702j();
        mo24793i();
        b.show();
        Window window = b.getWindow();
        if (!(window == null || (findViewById = window.findViewById(Resources.getSystem().getIdentifier("extractArea", "id", "android"))) == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()) == null)) {
            marginLayoutParams.bottomMargin = 0;
        }
        Button a2 = b.mo25117a(-1);
        Button a3 = b.mo25117a(-2);
        Button a4 = b.mo25117a(-3);
        if (!(a2 == null || a3 == null || a4 == null || TextUtils.isEmpty(a.f16245f) || TextUtils.isEmpty(a.f16244e))) {
            float dimensionPixelSize = (float) this.f16219a.getResources().getDimensionPixelSize(R.dimen.mzuc_dialog_btn_text_size_small);
            a2.setTextSize(0, dimensionPixelSize);
            a3.setTextSize(0, dimensionPixelSize);
            a4.setTextSize(0, dimensionPixelSize);
        }
        return new UcDisplayDialogImpl(b, false, this.f16221c);
    }

    /* renamed from: i */
    private void mo24793i() {
        Loger.m17941b("register broadcast:" + this.f16222d);
        this.f16219a.getApplicationContext().registerReceiver(this.f16229k, new IntentFilter("com.meizu.update.component.dialog_show"));
    }

    /* renamed from: c */
    public void mo24766c() {
        try {
            Loger.m17941b("unregister broadcast:" + this.f16222d);
            this.f16219a.getApplicationContext().unregisterReceiver(this.f16229k);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    private void m17702j() {
        Intent intent = new Intent("com.meizu.update.component.dialog_show");
        intent.setPackage(this.f16219a.getPackageName());
        this.f16219a.sendBroadcast(intent);
    }

    /* renamed from: k */
    private void m17703k() {
        try {
            Loger.m17941b("check keyguard state");
            boolean z = false;
            if (MinSdkChecker.m17950c()) {
                KeyguardManager keyguardManager = (KeyguardManager) this.f16219a.getSystemService("keyguard");
                if (!keyguardManager.isKeyguardLocked() || keyguardManager.isKeyguardSecure()) {
                    Loger.m17943d("need not unlock keyguard");
                } else {
                    Loger.m17943d("need unlock keyguard");
                    z = true;
                }
            }
            if (z) {
                Intent intent = new Intent(this.f16219a, KeyguardHelperActivity.class);
                intent.addFlags(268435456);
                this.f16219a.startActivity(intent);
            }
        } catch (Exception e) {
            Loger.m17943d("unlock keyguard exception");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo24762a(String str) {
        this.f16223e = str;
    }

    /* renamed from: b */
    public void mo24765b(String str) {
        this.f16224f = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo24767d() {
        return this.f16223e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo24768e() {
        return this.f16224f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo24769f() {
        if (this.f16228j != null) {
            this.f16228j.mo24778a();
        }
    }

    /* renamed from: a */
    public void mo24761a(C2999a aVar) {
        this.f16228j = aVar;
    }
}
