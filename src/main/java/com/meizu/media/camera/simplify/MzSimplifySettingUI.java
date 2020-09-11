package com.meizu.media.camera.simplify;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.meizu.media.camera.CameraSimplifyActivity;
import com.meizu.media.camera.MzVideoSizeManager;
import com.meizu.media.camera.R;
import com.meizu.media.camera.SizeChoiceDialogActivity;
import com.meizu.media.camera.adapter.MyTypeAdapter;
import com.meizu.media.camera.adapter.TypeItem;
import com.meizu.media.camera.adapter.ViewHolder;
import com.meizu.media.camera.animation.SettingAnimManager;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.databinding.CameraSimplifyBinding;
import com.meizu.media.camera.p077ui.SettingController;
import com.meizu.media.camera.util.C2644av;
import com.meizu.media.camera.util.CameraSizeUtil;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceSizeTable;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.PreferenceUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.textinputlayout.TextInputLayout;
import flyme.support.p093v7.app.AlertDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.meizu.media.camera.simplify.i */
public class MzSimplifySettingUI extends SettingController implements AdapterView.OnItemClickListener, SettingAnimManager.C1808a {

    /* renamed from: a */
    public static ChangeQuickRedirect f12010a;

    /* renamed from: d */
    private static final LogUtil.C2630a f12011d = new LogUtil.C2630a("MzSettingUI");

    /* renamed from: A */
    private InputFilter f12012A = new InputFilter() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12039a;

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            Object[] objArr = {charSequence, new Integer(i), new Integer(i2), spanned, new Integer(i3), new Integer(i4)};
            ChangeQuickRedirect changeQuickRedirect = f12039a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 6081, new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, Spanned.class, Integer.TYPE, Integer.TYPE}, CharSequence.class);
            if (proxy.isSupported) {
                return (CharSequence) proxy.result;
            }
            if (charSequence.length() > 1) {
                return MzSimplifySettingUI.this.m13186a(charSequence);
            }
            if (!charSequence.equals(" ") || i3 != 0) {
                return null;
            }
            return "";
        }
    };

    /* renamed from: e */
    private int f12013e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CameraSimplifyActivity f12014f;

    /* renamed from: g */
    private LinearLayout f12015g;

    /* renamed from: h */
    private CameraSimplifyBinding f12016h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ListView f12017i;

    /* renamed from: j */
    private C2350c f12018j;

    /* renamed from: k */
    private int f12019k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C2349b f12020l;

    /* renamed from: m */
    private boolean f12021m = false;

    /* renamed from: n */
    private int f12022n;

    /* renamed from: o */
    private SettingAnimManager f12023o;

    /* renamed from: p */
    private MzVideoSizeManager f12024p;

    /* renamed from: q */
    private List<C2348a> f12025q = new ArrayList();

    /* renamed from: r */
    private List<C2348a> f12026r = new ArrayList();

    /* renamed from: s */
    private AlertDialog f12027s;

    /* renamed from: t */
    private AlertDialog f12028t;

    /* renamed from: u */
    private View f12029u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public TextInputLayout f12030v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public EditText f12031w;

    /* renamed from: x */
    private String[] f12032x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public String[] f12033y;

    /* renamed from: z */
    private String f12034z;

    /* renamed from: com.meizu.media.camera.simplify.i$b */
    /* compiled from: MzSimplifySettingUI */
    public interface C2349b {
        /* renamed from: a */
        void mo21331a();

        /* renamed from: b */
        void mo21332b();

        /* renamed from: c */
        void mo21333c();
    }

    /* renamed from: c */
    public void mo21312c() {
    }

    /* renamed from: com.meizu.media.camera.simplify.i$a */
    /* compiled from: MzSimplifySettingUI */
    private class C2348a extends TypeItem {

        /* renamed from: b */
        public String f12049b;

        /* renamed from: c */
        public Integer f12050c;

        /* renamed from: d */
        public Integer f12051d;

        /* renamed from: e */
        public String f12052e;

        /* renamed from: f */
        public String f12053f;

        /* renamed from: g */
        public boolean f12054g;

        /* renamed from: h */
        public boolean f12055h;

        private C2348a() {
            this.f12055h = true;
        }

        /* synthetic */ C2348a(MzSimplifySettingUI iVar, C23421 r2) {
            this();
        }
    }

    public MzSimplifySettingUI(CameraSimplifyActivity cameraSimplifyActivity, CameraSimplifyBinding cameraSimplifyBinding) {
        super(cameraSimplifyActivity, R.xml.mz_setting_preferences);
        this.f12014f = cameraSimplifyActivity;
        this.f12016h = cameraSimplifyBinding;
        this.f12022n = cameraSimplifyActivity.mo17639f().getResources().getDimensionPixelSize(R.dimen.mz_setting_line_margin);
        this.f12024p = new MzVideoSizeManager();
        this.f12018j = new C2350c(this.f12014f.mo17639f(), this.f12026r);
        m13202k();
        if (DeviceHelper.f13881ah) {
            m13203l();
        }
    }

    /* renamed from: com.meizu.media.camera.simplify.i$1 */
    /* compiled from: MzSimplifySettingUI */
    class C23421 implements View.OnClickListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f12035a;

        /* renamed from: b */
        final /* synthetic */ MzSimplifySettingUI f12036b;

        public void onClick(View view) {
            if (!PatchProxy.proxy(new Object[]{view}, this, f12035a, false, 6078, new Class[]{View.class}, Void.TYPE).isSupported && this.f12036b.f12020l != null) {
                this.f12036b.f12020l.mo21332b();
            }
        }
    }

    /* renamed from: k */
    private void m13202k() {
        if (!PatchProxy.proxy(new Object[0], this, f12010a, false, 6038, new Class[0], Void.TYPE).isSupported) {
            this.f12025q.clear();
            if (DeviceHelper.f13854aG) {
                C2348a aVar = new C2348a(this, (C23421) null);
                aVar.f7564a = 2;
                aVar.f12049b = "mz_pref_mfll_key";
                aVar.f12050c = Integer.valueOf(R.string.mz_setting_mfll_title);
                aVar.f12051d = Integer.valueOf(R.string.mz_setting_mfll_lable);
                this.f12025q.add(aVar);
            }
            C2348a aVar2 = new C2348a(this, (C23421) null);
            aVar2.f7564a = 2;
            aVar2.f12049b = "mz_pref_mirror";
            aVar2.f12050c = Integer.valueOf(R.string.mz_setting_mirror_title);
            aVar2.f12051d = Integer.valueOf(R.string.mz_setting_mirror_label);
            this.f12025q.add(aVar2);
            if (DeviceHelper.f13865aR) {
                C2348a aVar3 = new C2348a(this, (C23421) null);
                aVar3.f7564a = 2;
                aVar3.f12049b = "mz_pref_voice_action_key";
                aVar3.f12050c = Integer.valueOf(R.string.mz_setting_voice_action_title);
                aVar3.f12051d = Integer.valueOf(R.string.mz_setting_voice_action_label);
                this.f12025q.add(aVar3);
            }
            C2348a aVar4 = new C2348a(this, (C23421) null);
            aVar4.f7564a = 0;
            aVar4.f12049b = "mz_pref_meshline_key";
            aVar4.f12050c = Integer.valueOf(R.string.mz_setting_meshline_title);
            this.f12025q.add(aVar4);
            C2348a aVar5 = new C2348a(this, (C23421) null);
            aVar5.f7564a = 0;
            aVar5.f12049b = "mz_pref_level_key";
            aVar5.f12050c = Integer.valueOf(R.string.mz_setting_level_title);
            this.f12025q.add(aVar5);
            if (DeviceHelper.f13838R) {
                C2348a aVar6 = new C2348a(this, (C23421) null);
                aVar6.f7564a = 0;
                aVar6.f12049b = "mz_pref_meter_separate_key";
                aVar6.f12050c = Integer.valueOf(R.string.mz_meter_separate_title);
                this.f12025q.add(aVar6);
            }
            if (DeviceHelper.f13838R) {
                C2348a aVar7 = new C2348a(this, (C23421) null);
                aVar7.f7564a = 0;
                aVar7.f12049b = "mz_pref_time_mark_key";
                aVar7.f12050c = Integer.valueOf(R.string.mz_setting_timemark_title);
                this.f12025q.add(aVar7);
            }
            if (DeviceHelper.f13879af || DeviceHelper.f13882ai) {
                C2348a aVar8 = new C2348a(this, (C23421) null);
                if (DeviceHelper.f13881ah) {
                    aVar8.f7564a = 1;
                } else {
                    aVar8.f7564a = 0;
                }
                aVar8.f12049b = "mz_pref_device_mark_key";
                aVar8.f12050c = Integer.valueOf(R.string.mz_setting_devicemark_title);
                this.f12025q.add(aVar8);
            }
            C2348a aVar9 = new C2348a(this, (C23421) null);
            aVar9.f7564a = 0;
            aVar9.f12049b = "mz_pref_meizu_mark_key";
            aVar9.f12050c = Integer.valueOf(R.string.mz_setting_funnycam_mark_title);
            this.f12025q.add(aVar9);
            if (DeviceHelper.f13941bo) {
                C2348a aVar10 = new C2348a(this, (C23421) null);
                aVar10.f7564a = 0;
                aVar10.f12049b = "mz_pref_funny_hd_key";
                aVar10.f12050c = Integer.valueOf(R.string.mz_setting_funnycam_hd);
                this.f12025q.add(aVar10);
            }
            if (DeviceHelper.f13936bj) {
                C2348a aVar11 = new C2348a(this, (C23421) null);
                aVar11.f7564a = 0;
                aVar11.f12049b = "mz_pref_storage_key";
                aVar11.f12050c = Integer.valueOf(R.string.mz_setting_storage_title);
                this.f12025q.add(aVar11);
            }
            C2348a aVar12 = new C2348a(this, (C23421) null);
            aVar12.f7564a = 1;
            aVar12.f12049b = "pref_camera_picturesize_key";
            aVar12.f12050c = Integer.valueOf(R.string.mz_setting_picture_size_proportion);
            this.f12025q.add(aVar12);
            C2348a aVar13 = new C2348a(this, (C23421) null);
            aVar13.f7564a = 1;
            aVar13.f12049b = "pref_camera_videosize_key";
            aVar13.f12050c = Integer.valueOf(R.string.mz_setting_recordsize_title);
            this.f12025q.add(aVar13);
            C2348a aVar14 = new C2348a(this, (C23421) null);
            aVar14.f7564a = 2;
            aVar14.f12049b = "mz_pref_fb_high_picturesize_key";
            aVar14.f12050c = Integer.valueOf(R.string.mz_setting_fb_high_picturesize_title);
            aVar14.f12051d = Integer.valueOf(R.string.mz_setting_fb_high_picturesize_label);
            this.f12025q.add(aVar14);
            if (DeviceHelper.f13877ad) {
                C2348a aVar15 = new C2348a(this, (C23421) null);
                aVar15.f7564a = 2;
                aVar15.f12049b = "mz_pref_asd_enable_key";
                aVar15.f12050c = Integer.valueOf(R.string.mz_setting_asd_switch_title);
                aVar15.f12051d = Integer.valueOf(R.string.mz_setting_asd_switch_label);
                this.f12025q.add(aVar15);
            }
        }
    }

    /* renamed from: l */
    private void m13203l() {
        if (!PatchProxy.proxy(new Object[0], this, f12010a, false, 6039, new Class[0], Void.TYPE).isSupported) {
            this.f12032x = this.f12014f.getResources().getStringArray(R.array.mz_custom_device_mark_desc_options);
            this.f12033y = this.f12014f.getResources().getStringArray(R.array.mz_custom_device_mark_options_without_trans);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m13204m() {
        if (!PatchProxy.proxy(new Object[0], this, f12010a, false, 6041, new Class[0], Void.TYPE).isSupported && mo21316e()) {
            this.f12018j.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    private void m13192a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12010a, false, 6044, new Class[]{String.class}, Void.TYPE).isSupported) {
            for (int i = 0; i < this.f12026r.size(); i++) {
                C2348a aVar = this.f12026r.get(i);
                if (aVar.f12049b.equals(str)) {
                    this.f12017i.setItemChecked(i, aVar.f12054g);
                    return;
                }
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{adapterView, view, new Integer(i), new Long(j)}, this, f12010a, false, 6046, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported && this.f12014f != null && !this.f12014f.mo17752n() && CameraController.m8868g().mo19522k() != null) {
            C2348a aVar = (C2348a) this.f12018j.getItem(i);
            if (aVar.f7564a == 1) {
                if (aVar.f12055h) {
                    if (aVar.f12049b.equals("mz_pref_device_mark_key")) {
                        m13205m(PreferenceUtil.m15983c(this.f12014f, "mz_pref_device_mark_key", this.f12014f.getString(R.string.setting_on_value)));
                        return;
                    }
                    if (2 != this.f12019k) {
                        z = false;
                    }
                    m13198d(z);
                }
            } else if ((aVar.f7564a == 0 || aVar.f7564a == 2) && aVar.f12055h && (view instanceof Checkable)) {
                boolean isChecked = ((Checkable) view).isChecked();
                aVar.f12054g = isChecked;
                mo21881d(aVar.f12049b, isChecked);
            }
        }
    }

    /* renamed from: m */
    private void m13205m(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12010a, false, 6047, new Class[]{String.class}, Void.TYPE).isSupported) {
            int n = m13206n(str);
            CameraUtil.m15895e((Activity) this.f12014f);
            if (this.f12027s != null) {
                this.f12027s.dismiss();
            }
            this.f12027s = new AlertDialog.Builder(this.f12014f, R.style.CustomDeviceMarkStyle).mo25131a((CharSequence) this.f12014f.getResources().getString(R.string.mz_setting_devicemark_title)).mo25134a(this.f12032x, n, new DialogInterface.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f12037a;

                public void onClick(DialogInterface dialogInterface, int i) {
                    Object[] objArr = {dialogInterface, new Integer(i)};
                    ChangeQuickRedirect changeQuickRedirect = f12037a;
                    if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6080, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                        MzSimplifySettingUI.this.m13187a(i);
                    }
                }
            }).mo25141b();
            this.f12027s.show();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0025, code lost:
        r1 = m13207o("mz_pref_device_mark_key");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m13187a(int r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r10)
            r3 = 0
            r1[r3] = r2
            com.meizu.savior.ChangeQuickRedirect r4 = f12010a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Integer.TYPE
            r6[r3] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r5 = 0
            r8 = 6048(0x17a0, float:8.475E-42)
            r2 = r9
            r3 = r4
            r4 = r5
            r5 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0025
            return
        L_0x0025:
            java.lang.String r1 = "mz_pref_device_mark_key"
            com.meizu.media.camera.simplify.i$a r1 = r9.m13207o(r1)
            if (r1 == 0) goto L_0x010e
            boolean r2 = r1.f12055h
            if (r2 == 0) goto L_0x010e
            flyme.support.v7.app.AlertDialog r2 = r9.f12027s
            if (r2 != 0) goto L_0x0037
            goto L_0x010e
        L_0x0037:
            java.lang.String r2 = "mz_pref_device_mark_key"
            java.lang.String r3 = java.lang.String.valueOf(r10)
            r9.m13195b((java.lang.String) r2, (java.lang.String) r3)
            java.lang.String[] r2 = r9.f12033y
            int r2 = r2.length
            int r2 = r2 - r0
            if (r10 >= r2) goto L_0x0061
            com.meizu.media.camera.CameraSimplifyActivity r0 = r9.f12014f
            java.lang.String r2 = "mz_pref_device_mark_key"
            java.lang.String[] r3 = r9.f12033y
            r3 = r3[r10]
            com.meizu.media.camera.util.PreferenceUtil.m15982b(r0, r2, r3)
            java.lang.String[] r0 = r9.f12032x
            r10 = r0[r10]
            r1.f12053f = r10
            flyme.support.v7.app.AlertDialog r10 = r9.f12027s
            r10.dismiss()
            r9.m13204m()
            goto L_0x010d
        L_0x0061:
            java.lang.String[] r2 = r9.f12033y
            int r2 = r2.length
            int r2 = r2 - r0
            if (r10 != r2) goto L_0x010d
            flyme.support.v7.app.AlertDialog r10 = r9.f12027s
            r10.dismiss()
            flyme.support.v7.app.AlertDialog r10 = r9.f12028t
            if (r10 != 0) goto L_0x00ae
            com.meizu.media.camera.CameraSimplifyActivity r10 = r9.f12014f
            com.meizu.media.camera.util.CameraUtil.m15895e((android.app.Activity) r10)
            flyme.support.v7.app.AlertDialog$Builder r10 = new flyme.support.v7.app.AlertDialog$Builder
            com.meizu.media.camera.CameraSimplifyActivity r0 = r9.f12014f
            r10.<init>(r0)
            r0 = 16843605(0x1010355, float:2.369595E-38)
            flyme.support.v7.app.AlertDialog$Builder r10 = r10.mo25145d(r0)
            r0 = 2131755609(0x7f100259, float:1.9142102E38)
            flyme.support.v7.app.AlertDialog$Builder r10 = r10.mo25124a((int) r0)
            android.view.View r0 = r9.f12029u
            flyme.support.v7.app.AlertDialog$Builder r10 = r10.mo25138b((android.view.View) r0)
            r0 = 2131755372(0x7f10016c, float:1.9141621E38)
            com.meizu.media.camera.simplify.i$5 r2 = new com.meizu.media.camera.simplify.i$5
            r2.<init>(r1)
            flyme.support.v7.app.AlertDialog$Builder r10 = r10.mo25125a((int) r0, (android.content.DialogInterface.OnClickListener) r2)
            r0 = 2131755371(0x7f10016b, float:1.914162E38)
            com.meizu.media.camera.simplify.i$4 r1 = new com.meizu.media.camera.simplify.i$4
            r1.<init>()
            flyme.support.v7.app.AlertDialog$Builder r10 = r10.mo25137b((int) r0, (android.content.DialogInterface.OnClickListener) r1)
            flyme.support.v7.app.AlertDialog r10 = r10.mo25141b()
            r9.f12028t = r10
        L_0x00ae:
            com.meizu.media.camera.CameraSimplifyActivity r10 = r9.f12014f
            boolean r10 = r10.mo17636c()
            if (r10 == 0) goto L_0x00c3
            flyme.support.v7.app.AlertDialog r10 = r9.f12028t
            android.view.Window r10 = r10.getWindow()
            if (r10 == 0) goto L_0x00c3
            r0 = 524288(0x80000, float:7.34684E-40)
            r10.addFlags(r0)
        L_0x00c3:
            com.meizu.media.camera.CameraSimplifyActivity r10 = r9.f12014f
            java.lang.String r0 = "mz_pref_custom_device_mark_key"
            com.meizu.media.camera.CameraSimplifyActivity r1 = r9.f12014f
            r2 = 2131755368(0x7f100168, float:1.9141613E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r10 = com.meizu.media.camera.util.PreferenceUtil.m15983c(r10, r0, r1)
            com.meizu.media.camera.CameraSimplifyActivity r0 = r9.f12014f
            java.lang.String r0 = r0.getString(r2)
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00e6
            android.widget.EditText r10 = r9.f12031w
            r10.setText(r2)
            goto L_0x00eb
        L_0x00e6:
            android.widget.EditText r0 = r9.f12031w
            r0.setText(r10)
        L_0x00eb:
            android.widget.EditText r10 = r9.f12031w
            r9.m13188a((android.widget.EditText) r10)
            flyme.support.v7.app.AlertDialog r10 = r9.f12028t
            r10.show()
            flyme.support.v7.app.AlertDialog r10 = r9.f12028t
            r0 = -1
            android.widget.Button r10 = r10.mo25117a(r0)
            com.meizu.textinputlayout.TextInputLayout r0 = r9.f12030v
            android.widget.EditText r1 = r9.f12031w
            r9.m13191a(r0, r1, r10)
            android.widget.EditText r0 = r9.f12031w
            com.meizu.media.camera.simplify.i$6 r1 = new com.meizu.media.camera.simplify.i$6
            r1.<init>(r10)
            r0.addTextChangedListener(r1)
        L_0x010d:
            return
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.simplify.MzSimplifySettingUI.m13187a(int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m13186a(CharSequence charSequence) {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{charSequence}, this, f12010a, false, 6049, new Class[]{CharSequence.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        int length = charSequence.length();
        while (i < length && charSequence.charAt(i) <= ' ') {
            i++;
        }
        if (i != 0) {
            return TextUtils.substring(charSequence, i, length);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13191a(TextInputLayout textInputLayout, EditText editText, Button button) {
        if (!PatchProxy.proxy(new Object[]{textInputLayout, editText, button}, this, f12010a, false, 6050, new Class[]{TextInputLayout.class, EditText.class, Button.class}, Void.TYPE).isSupported) {
            String obj = editText.getText().toString();
            if (C2644av.m16112c(obj) > 20 && ((this.f12034z == null || !this.f12014f.getString(R.string.mz_custom_device_mark_dialog_error_hint_length).equals(this.f12034z)) && !C2644av.m16111b(obj))) {
                this.f12034z = this.f12014f.getString(R.string.mz_custom_device_mark_dialog_error_hint_length);
                textInputLayout.setError(this.f12034z);
            }
            if (C2644av.m16111b(obj) && (this.f12034z == null || !this.f12014f.getString(R.string.mz_custom_device_mark_dialog_error_hint_emoji).equals(this.f12034z))) {
                this.f12034z = this.f12014f.getString(R.string.mz_custom_device_mark_dialog_error_hint_emoji);
                textInputLayout.setError(this.f12034z);
            }
            if (TextUtils.isEmpty(obj) || C2644av.m16111b(obj) || C2644av.m16112c(obj) > 20 || obj.charAt(0) <= ' ') {
                button.setEnabled(false);
                if (TextUtils.isEmpty(obj) || obj.charAt(0) <= ' ') {
                    this.f12034z = null;
                    return;
                }
                return;
            }
            textInputLayout.setError((CharSequence) null);
            textInputLayout.setErrorEnabled(false);
            editText.setBackgroundTintList((ColorStateList) null);
            this.f12034z = null;
            button.setEnabled(true);
        }
    }

    /* renamed from: a */
    private void m13188a(EditText editText) {
        if (!PatchProxy.proxy(new Object[]{editText}, this, f12010a, false, 6051, new Class[]{EditText.class}, Void.TYPE).isSupported) {
            String obj = editText.getText().toString();
            if (obj.length() <= 3) {
                editText.selectAll();
            } else if (TextUtils.equals(TextUtils.substring(obj, 0, 3), "By ")) {
                editText.setSelection(3, obj.length());
            } else {
                editText.selectAll();
            }
        }
    }

    /* renamed from: n */
    private int m13206n(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12010a, false, 6052, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (str == null) {
            return 1;
        }
        for (int i = 0; i < this.f12033y.length; i++) {
            if (str.equals(this.f12033y[i])) {
                return i;
            }
        }
        return 1;
    }

    /* renamed from: d */
    private void m13198d(boolean z) {
        String[] strArr;
        String[] strArr2;
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12010a, false, 6053, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                String str = m13207o("pref_camera_videosize_key").f12052e;
                if (this.f12013e == 0) {
                    strArr2 = this.f12024p.mo22761b();
                    strArr = this.f12024p.mo22762c();
                } else {
                    strArr2 = this.f12024p.mo22760a();
                    strArr = this.f12024p.mo22763d();
                }
                String[] strArr3 = new String[strArr.length];
                int i2 = 0;
                while (i < strArr.length) {
                    String b = DeviceSizeTable.m16188b(strArr2[i]);
                    String str2 = null;
                    if (this.f12013e == 0 && DeviceHelper.f13862aO && (b.equals("1080P") || b.equals("720P"))) {
                        str2 = this.f12014f.getResources().getString(R.string.mz_setting_des_antishake);
                    }
                    if (str.equals(strArr2[i])) {
                        i2 = i;
                    }
                    strArr3[i] = DeviceSizeTable.m16187a(b, strArr2[i], str2);
                    i++;
                }
                SizeChoiceDialogActivity.m7737a((Activity) this.f12014f, z, strArr3, i2);
            } else {
                String str3 = m13207o("pref_camera_picturesize_key").f12052e;
                String[] a = CameraSizeUtil.m16179a();
                String[] strArr4 = new String[a.length];
                int i3 = 0;
                while (i < a.length) {
                    if (str3.equals(a[i])) {
                        i3 = i;
                    }
                    strArr4[i] = DeviceSizeTable.m16186a(a[i]);
                    i++;
                }
                SizeChoiceDialogActivity.m7737a((Activity) this.f12014f, z, strArr4, i3);
            }
            if (this.f12014f != null) {
                this.f12014f.mo17753o();
            }
        }
    }

    /* renamed from: a */
    public void mo21307a(Intent intent) {
        String[] strArr;
        String[] strArr2;
        if (!PatchProxy.proxy(new Object[]{intent}, this, f12010a, false, 6054, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            boolean booleanExtra = intent.getBooleanExtra("isVideoSize", false);
            int intExtra = intent.getIntExtra("whichSize", 0);
            int intExtra2 = intent.getIntExtra("defaultItemId", 0);
            String[] stringArrayExtra = intent.getStringArrayExtra("proportion");
            if (booleanExtra) {
                if (intExtra2 != intExtra) {
                    if (this.f12013e == 0) {
                        strArr2 = this.f12024p.mo22761b();
                        strArr = this.f12024p.mo22762c();
                    } else {
                        strArr2 = this.f12024p.mo22760a();
                        strArr = this.f12024p.mo22763d();
                    }
                    C2348a o = m13207o("pref_camera_videosize_key");
                    if (o != null) {
                        o.f12052e = strArr2[intExtra];
                        o.f12053f = stringArrayExtra[intExtra];
                    }
                    PreferenceUtil.m15981a(this.f12014f, "pref_camera_videosize_key", strArr2[intExtra]);
                    PreferenceUtil.m15981a(this.f12014f, "pref_video_quality_key", strArr[intExtra]);
                    m13193a("click_video_size", DeviceSizeTable.m16188b(strArr2[intExtra]));
                    m13204m();
                }
            } else if (intExtra != intExtra2) {
                C2348a o2 = m13207o("pref_camera_picturesize_key");
                if (o2 != null) {
                    o2.f12053f = stringArrayExtra[intExtra];
                    o2.f12052e = CameraSizeUtil.m16179a()[intExtra];
                }
                PreferenceUtil.m15981a(this.f12014f, "pref_camera_picturesize_key", CameraSizeUtil.m16179a()[intExtra]);
                m13193a("click_picture_size", stringArrayExtra[intExtra]);
                m13204m();
            }
        }
    }

    /* renamed from: o */
    private C2348a m13207o(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f12010a, false, 6055, new Class[]{String.class}, C2348a.class);
        if (proxy.isSupported) {
            return (C2348a) proxy.result;
        }
        for (C2348a next : this.f12025q) {
            if (next != null && str.equals(next.f12049b)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo21308a(String str, boolean z) {
        C2348a o;
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f12010a, false, 6056, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported && (o = m13207o(str)) != null) {
            o.f12054g = z;
            m13192a(str);
        }
    }

    /* renamed from: b */
    public void mo21310b(String str, boolean z) {
        C2348a o;
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f12010a, false, 6057, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported && (o = m13207o(str)) != null) {
            o.f12055h = z;
            m13204m();
        }
    }

    /* renamed from: a */
    public void mo21309a(boolean z) {
        C2348a o;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12010a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6059, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && (o = m13207o("mz_pref_storage_key")) != null) {
            o.f12055h = z;
            m13204m();
        }
    }

    /* renamed from: d */
    public void mo21315d() {
        C2348a o;
        if (!PatchProxy.proxy(new Object[0], this, f12010a, false, 6060, new Class[0], Void.TYPE).isSupported && (o = m13207o("mz_pref_storage_key")) != null) {
            o.f12054g = mo21320i();
            mo21308a(o.f12049b, o.f12054g);
        }
    }

    /* renamed from: b */
    public void mo21311b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12010a, false, 6061, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            for (C2348a next : this.f12025q) {
                mo21891l(next.f12049b);
                if (next.f7564a == 0 || next.f7564a == 2) {
                    next.f12054g = mo21879b(next.f12049b);
                } else if (next.f7564a == 1 && !next.f12049b.equals("mz_pref_device_mark_key")) {
                    next.f12052e = PreferenceUtil.m15980a(this.f12014f, next.f12049b);
                }
            }
            m13204m();
        }
    }

    /* renamed from: com.meizu.media.camera.simplify.i$c */
    /* compiled from: MzSimplifySettingUI */
    private class C2350c extends MyTypeAdapter<C2348a> {

        /* renamed from: g */
        public static ChangeQuickRedirect f12057g;

        public C2350c(Context context, List<C2348a> list) {
            super(context, new int[]{1, 0, 2}, new int[]{R.layout.mz_camera_setting_label, R.layout.mz_camera_setting_switch, R.layout.mz_camera_setting_switchlabel}, list);
        }

        /* renamed from: a */
        public void mo18787a(ViewHolder dVar, final int i, int i2, final C2348a aVar) {
            Object[] objArr = {dVar, new Integer(i), new Integer(i2), aVar};
            ChangeQuickRedirect changeQuickRedirect = f12057g;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6085, new Class[]{ViewHolder.class, Integer.TYPE, Integer.TYPE, C2348a.class}, Void.TYPE).isSupported) {
                if (i2 == 0) {
                    dVar.mo18800a(aVar.f12055h);
                    dVar.mo18797a((int) R.id.mz_item_title, aVar.f12050c.intValue());
                    dVar.mo18798a((int) R.id.mz_item_switcher, (CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f12059a;

                        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            if (!PatchProxy.proxy(new Object[]{compoundButton, new Byte(z ? (byte) 1 : 0)}, this, f12059a, false, 6086, new Class[]{CompoundButton.class, Boolean.TYPE}, Void.TYPE).isSupported && compoundButton.isPressed()) {
                                aVar.f12054g = z;
                                MzSimplifySettingUI.this.mo21881d(aVar.f12049b, z);
                                MzSimplifySettingUI.this.f12017i.setItemChecked(i, z);
                            }
                        }
                    });
                } else if (i2 == 1) {
                    dVar.mo18800a(true);
                    dVar.mo18797a((int) R.id.mz_item_title, aVar.f12050c.intValue());
                    dVar.mo18799a((int) R.id.mz_item_detail, aVar.f12053f);
                } else if (i2 == 2) {
                    dVar.mo18800a(aVar.f12055h);
                    dVar.mo18797a((int) R.id.mz_item_title, aVar.f12050c.intValue());
                    dVar.mo18797a((int) R.id.mz_item_detail, aVar.f12051d.intValue());
                    dVar.mo18798a((int) R.id.mz_item_switcher, (CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f12063a;

                        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            if (!PatchProxy.proxy(new Object[]{compoundButton, new Byte(z ? (byte) 1 : 0)}, this, f12063a, false, 6087, new Class[]{CompoundButton.class, Boolean.TYPE}, Void.TYPE).isSupported && compoundButton.isPressed()) {
                                aVar.f12054g = z;
                                MzSimplifySettingUI.this.mo21881d(aVar.f12049b, z);
                                MzSimplifySettingUI.this.f12017i.setItemChecked(i, z);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    public void mo18915a() {
        if (!PatchProxy.proxy(new Object[0], this, f12010a, false, 6062, new Class[0], Void.TYPE).isSupported && this.f12020l != null) {
            this.f12020l.mo21331a();
        }
    }

    /* renamed from: b */
    public void mo18916b() {
        if (!PatchProxy.proxy(new Object[0], this, f12010a, false, 6063, new Class[0], Void.TYPE).isSupported && this.f12020l != null) {
            this.f12020l.mo21333c();
        }
    }

    /* renamed from: e */
    public boolean mo21316e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12010a, false, 6064, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f12023o == null || this.f12015g == null) {
            return false;
        }
        if (this.f12023o.mo18902c() || this.f12015g.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo21317f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12010a, false, 6065, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f12023o != null) {
            return this.f12023o.mo18902c();
        }
        return false;
    }

    /* renamed from: c */
    public void mo21314c(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12010a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6066, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                this.f12023o.mo18901b();
            } else {
                this.f12015g.setVisibility(4);
            }
        }
    }

    /* renamed from: g */
    public boolean mo21318g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12010a, false, 6068, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21879b("mz_pref_meter_separate_key");
    }

    /* renamed from: h */
    public boolean mo21319h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12010a, false, 6069, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21879b("mz_pref_mirror");
    }

    /* renamed from: i */
    public boolean mo21320i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12010a, false, 6071, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21882d("mz_pref_storage_key");
    }

    /* renamed from: c */
    public void mo21313c(String str, boolean z) {
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f12010a, false, 6073, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            mo21881d(str, z);
        }
    }

    /* renamed from: a */
    private void m13193a(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f12010a, false, 6074, clsArr, Void.TYPE).isSupported) {
            Map<String, String> a = UsageStatsHelper.m16042a(this.f12014f.getApplicationContext()).mo22688a(UsageStatsHelper.m16057z(str));
            a.put("value", str2);
            UsageStatsHelper.m16042a(this.f12014f.getApplicationContext()).mo22693a(str, a);
        }
    }

    /* renamed from: b */
    private void m13195b(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f12010a, false, 6075, clsArr, Void.TYPE).isSupported) {
            UsageStatsHelper.m16042a(this.f12014f.getApplicationContext()).mo22690a(str, String.valueOf(str2));
            String y = UsageStatsHelper.m16056y(str);
            Map<String, String> a = UsageStatsHelper.m16042a(this.f12014f.getApplicationContext()).mo22688a(UsageStatsHelper.m16057z(y));
            a.put("value", str2);
            UsageStatsHelper.m16042a(this.f12014f.getApplicationContext()).mo22693a(y, a);
        }
    }

    /* renamed from: j */
    public void mo21321j() {
        if (!PatchProxy.proxy(new Object[0], this, f12010a, false, 6077, new Class[0], Void.TYPE).isSupported) {
            if (this.f12028t != null) {
                this.f12028t.dismiss();
            }
            if (this.f12027s != null) {
                this.f12027s.dismiss();
            }
        }
    }
}
