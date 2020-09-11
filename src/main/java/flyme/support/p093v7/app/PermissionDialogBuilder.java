package flyme.support.p093v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import com.meizu.common.util.ReflectUtils;
import flyme.support.p093v7.app.AlertDialog;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.PermissionDialogView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: flyme.support.v7.app.PermissionDialogBuilder */
public class PermissionDialogBuilder {

    /* renamed from: n */
    private static ArrayList<String> f16922n = new ArrayList<>();

    /* renamed from: a */
    private Context f16923a;

    /* renamed from: b */
    private int f16924b;

    /* renamed from: c */
    private String f16925c;

    /* renamed from: d */
    private String[] f16926d;

    /* renamed from: e */
    private String[] f16927e;

    /* renamed from: f */
    private int[] f16928f;

    /* renamed from: g */
    private String f16929g;

    /* renamed from: h */
    private boolean f16930h;

    /* renamed from: i */
    private boolean f16931i;

    /* renamed from: j */
    private boolean f16932j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C3129a f16933k;

    /* renamed from: l */
    private List<Pair<String, String>> f16934l;

    /* renamed from: m */
    private CharSequence f16935m;

    /* renamed from: flyme.support.v7.app.PermissionDialogBuilder$a */
    public interface C3129a {
        /* renamed from: a */
        void mo17717a(DialogInterface dialogInterface, boolean z, boolean z2);
    }

    static {
        f16922n.add("android.permission.CALL_PHONE");
        f16922n.add("android.permission.READ_CONTACTS");
        f16922n.add("android.permission.READ_SMS");
        f16922n.add("android.permission.WRITE_CONTACTS");
        f16922n.add("android.permission.SEND_SMS");
        f16922n.add("android.permission.RECEIVE_SMS");
        f16922n.add("android.permission.READ_CALL_LOG");
        f16922n.add("android.permission.RECORD_AUDIO");
    }

    public PermissionDialogBuilder(Context context) {
        this(context, AlertDialog.m18238a(context, 0));
    }

    public PermissionDialogBuilder(Context context, int i) {
        this.f16923a = context;
        this.f16924b = i;
        this.f16932j = mo25304a(context);
    }

    /* renamed from: a */
    public PermissionDialogBuilder mo25302a(String str, String[] strArr, String[] strArr2) {
        return mo25303a(str, strArr, strArr2, (int[]) null);
    }

    /* renamed from: a */
    public PermissionDialogBuilder mo25303a(String str, String[] strArr, String[] strArr2, int[] iArr) {
        this.f16925c = str;
        this.f16926d = strArr;
        this.f16927e = strArr2;
        this.f16928f = iArr;
        return this;
    }

    /* renamed from: c */
    private void m18525c() {
        if (this.f16932j) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < this.f16926d.length; i++) {
                String str = this.f16926d[i];
                if (!f16922n.contains(str)) {
                    arrayList.add(str);
                    if (this.f16927e != null) {
                        arrayList2.add(this.f16927e[i]);
                    }
                    if (this.f16928f != null) {
                        arrayList3.add(Integer.valueOf(this.f16928f[i]));
                    }
                }
            }
            this.f16926d = (String[]) arrayList.toArray(new String[0]);
            if (this.f16927e != null) {
                this.f16927e = (String[]) arrayList2.toArray(new String[0]);
            }
            if (this.f16928f != null) {
                this.f16928f = new int[arrayList3.size()];
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    this.f16928f[i2] = ((Integer) arrayList3.get(i2)).intValue();
                }
            }
        }
    }

    /* renamed from: a */
    public PermissionDialogBuilder mo25301a(C3129a aVar) {
        this.f16933k = aVar;
        return this;
    }

    /* renamed from: a */
    public boolean mo25304a(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }

    /* renamed from: d */
    private boolean m18526d() {
        return (Parameters.EVENT_NAME.equals(Locale.getDefault().getLanguage()) || "zh".equals(Locale.getDefault().getLanguage())) && !TextUtils.isEmpty(this.f16935m);
    }

    /* renamed from: a */
    public AlertDialog mo25300a() {
        if (TextUtils.isEmpty(this.f16925c)) {
            throw new IllegalArgumentException("appName can't be null");
        } else if ((this.f16926d == null || this.f16926d.length <= 0) && (this.f16934l == null || this.f16934l.size() <= 0)) {
            throw new IllegalArgumentException("permissions or additional groups can't be null");
        } else {
            if (this.f16926d != null) {
                if (this.f16927e != null && this.f16927e.length != this.f16926d.length) {
                    throw new IllegalArgumentException("permissionSummary.length must equal permissions.length");
                } else if (this.f16928f == null || this.f16928f.length == this.f16926d.length) {
                    m18525c();
                } else {
                    throw new IllegalArgumentException("permissionResIds.length must equal permissions.length");
                }
            }
            boolean z = Build.VERSION.SDK_INT >= 23;
            final PermissionDialogView permissionDialogView = new PermissionDialogView(this.f16923a);
            new PermissionDialogView.C3150a().mo25403a(this.f16925c).mo25405a(this.f16930h).mo25406a(this.f16926d, this.f16927e, this.f16928f).mo25404a(this.f16934l).mo25408b(this.f16929g).mo25409b(this.f16931i).mo25410c(!z).mo25411d(m18526d()).mo25407a(permissionDialogView);
            AlertDialog.Builder b = new AlertDialog.Builder(this.f16923a, this.f16924b).mo25138b((View) permissionDialogView).mo25133a(false).mo25126a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    if (PermissionDialogBuilder.this.f16933k != null) {
                        PermissionDialogBuilder.this.f16933k.mo17717a(dialogInterface, permissionDialogView.getCheckBox().isChecked(), false);
                    }
                }
            }).mo25125a(R.string.mz_permission_agree, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (PermissionDialogBuilder.this.f16933k != null) {
                        PermissionDialogBuilder.this.f16933k.mo17717a(dialogInterface, permissionDialogView.getCheckBox().isChecked(), true);
                    }
                }
            }).mo25137b(R.string.mz_permission_disagree, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (PermissionDialogBuilder.this.f16933k != null) {
                        PermissionDialogBuilder.this.f16933k.mo17717a(dialogInterface, permissionDialogView.getCheckBox().isChecked(), false);
                    }
                }
            });
            if (z) {
                b.mo25131a((CharSequence) this.f16925c);
            }
            final C3130b bVar = (C3130b) b.mo25135a(new AlertDialog.Builder.C3092a<C3130b>() {
                /* renamed from: b */
                public C3130b mo25147a(@NonNull Context context, int i) {
                    return new C3130b(context, i, PermissionDialogBuilder.this.f16933k);
                }
            });
            permissionDialogView.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    bVar.mo25117a(-1).setEnabled(!z);
                }
            });
            CheckBox termsCheckBox = permissionDialogView.getTermsCheckBox();
            termsCheckBox.setChecked(true);
            termsCheckBox.setText(this.f16935m);
            termsCheckBox.setMovementMethod(LinkMovementMethod.getInstance());
            termsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    bVar.mo25117a(-1).setEnabled(z);
                }
            });
            termsCheckBox.setHighlightColor(0);
            bVar.mo25118a(24, 4, 12, 10);
            return bVar;
        }
    }

    /* renamed from: b */
    public AlertDialog mo25305b() {
        AlertDialog a = mo25300a();
        a.show();
        return a;
    }

    /* renamed from: flyme.support.v7.app.PermissionDialogBuilder$b */
    private static class C3130b extends AlertDialog {

        /* renamed from: b */
        private C3129a f16947b;

        private C3130b(@NonNull Context context, int i, C3129a aVar) {
            super(context, i);
            this.f16947b = aVar;
        }

        public void show() {
            if (!m18536b() && !m18538d() && !m18537c()) {
                super.show();
            } else if (this.f16947b != null) {
                this.f16947b.mo17717a(this, false, true);
            }
        }

        /* renamed from: b */
        private boolean m18536b() {
            try {
                return ((Boolean) ReflectUtils.m5143a("android.os.BuildExt").mo16008a("isProductInternational", new Class[0]).mo16011a((Object) null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: c */
        private boolean m18537c() {
            try {
                return ((Boolean) ReflectUtils.m5143a("android.os.BuildExt").mo16008a("isShopDemoVersion", new Class[0]).mo16011a((Object) null, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: d */
        private boolean m18538d() {
            try {
                return ((Boolean) ReflectUtils.m5143a("android.os.SystemProperties").mo16008a("getBoolean", String.class, Boolean.TYPE).mo16011a((Object) null, "debug.perf.applunch", false)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
