package com.meizu.media.camera.p077ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.databinding.DataBindingUtil;
import com.meizu.common.util.ListViewProxy;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MzVideoSizeManager;
import com.meizu.media.camera.R;
import com.meizu.media.camera.SizeChoiceDialogActivity;
import com.meizu.media.camera.adapter.MyTypeAdapter;
import com.meizu.media.camera.adapter.TypeItem;
import com.meizu.media.camera.adapter.ViewHolder;
import com.meizu.media.camera.animation.SettingAnimManager;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.databinding.CameraBinding;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzSettingControlBinding;
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
import flyme.support.p093v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.meizu.media.camera.ui.x */
public class MzSettingUI extends SettingController implements AdapterView.OnItemClickListener, SettingAnimManager.C1808a {

    /* renamed from: a */
    public static ChangeQuickRedirect f13639a;

    /* renamed from: d */
    private static final LogUtil.C2630a f13640d = new LogUtil.C2630a("MzSettingUI");

    /* renamed from: A */
    private String[] f13641A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public String[] f13642B;

    /* renamed from: C */
    private String f13643C;

    /* renamed from: D */
    private int f13644D;

    /* renamed from: E */
    private InputFilter f13645E = new InputFilter() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13675a;

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            Object[] objArr = {charSequence, new Integer(i), new Integer(i2), spanned, new Integer(i3), new Integer(i4)};
            ChangeQuickRedirect changeQuickRedirect = f13675a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 7563, new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, Spanned.class, Integer.TYPE, Integer.TYPE}, CharSequence.class);
            if (proxy.isSupported) {
                return (CharSequence) proxy.result;
            }
            if (charSequence.length() > 1) {
                return MzSettingUI.this.m15682a(charSequence);
            }
            if (!charSequence.equals(" ") || i3 != 0) {
                return null;
            }
            return "";
        }
    };

    /* renamed from: e */
    private int f13646e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CameraActivity f13647f;

    /* renamed from: g */
    private LinearLayout f13648g;

    /* renamed from: h */
    private CameraBinding f13649h;

    /* renamed from: i */
    private DelayInflateTwoBinding f13650i;

    /* renamed from: j */
    private MzSettingControlBinding f13651j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ListView f13652k;

    /* renamed from: l */
    private ListViewProxy f13653l;

    /* renamed from: m */
    private C2603c f13654m;

    /* renamed from: n */
    private int f13655n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C2602b f13656o;

    /* renamed from: p */
    private boolean f13657p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f13658q;

    /* renamed from: r */
    private SettingAnimManager f13659r;

    /* renamed from: s */
    private MzVideoSizeManager f13660s;

    /* renamed from: t */
    private List<C2601a> f13661t = new ArrayList();

    /* renamed from: u */
    private List<C2601a> f13662u = new ArrayList();

    /* renamed from: v */
    private AlertDialog f13663v;

    /* renamed from: w */
    private AlertDialog f13664w;

    /* renamed from: x */
    private View f13665x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public TextInputLayout f13666y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public EditText f13667z;

    /* renamed from: com.meizu.media.camera.ui.x$b */
    /* compiled from: MzSettingUI */
    public interface C2602b {
        /* renamed from: a */
        void mo21761a();

        /* renamed from: b */
        void mo21762b();

        /* renamed from: c */
        void mo21763c();
    }

    /* renamed from: e */
    public void mo22569e() {
    }

    /* renamed from: com.meizu.media.camera.ui.x$a */
    /* compiled from: MzSettingUI */
    private class C2601a extends TypeItem {

        /* renamed from: b */
        public String f13685b;

        /* renamed from: c */
        public Integer f13686c;

        /* renamed from: d */
        public Integer f13687d;

        /* renamed from: e */
        public String f13688e;

        /* renamed from: f */
        public String f13689f;

        /* renamed from: g */
        public boolean f13690g;

        /* renamed from: h */
        public boolean f13691h;

        private C2601a() {
            this.f13691h = true;
        }
    }

    public MzSettingUI(CameraActivity cameraActivity, CameraBinding cameraBinding) {
        super(cameraActivity, R.xml.mz_setting_preferences);
        this.f13647f = cameraActivity;
        this.f13649h = cameraBinding;
        this.f13658q = cameraActivity.mo17639f().getResources().getDimensionPixelSize(R.dimen.mz_setting_line_margin);
        this.f13644D = cameraActivity.getResources().getColor(R.color.mz_settting_item_select_color);
        this.f13660s = new MzVideoSizeManager();
        this.f13654m = new C2603c(this.f13647f.mo17639f(), this.f13662u);
        m15703r();
        if (DeviceHelper.f13881ah) {
            m15704s();
        }
    }

    /* renamed from: c */
    public void mo22565c() {
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7514, new Class[0], Void.TYPE).isSupported && !this.f13657p) {
            if (this.f13649h.f9509h.getViewStub() != null) {
                this.f13650i = (DelayInflateTwoBinding) DataBindingUtil.bind(this.f13649h.f9509h.getViewStub().inflate());
            } else {
                this.f13650i = (DelayInflateTwoBinding) this.f13649h.f9509h.getBinding();
            }
            if (this.f13650i.f9588s.getViewStub() != null) {
                this.f13651j = (MzSettingControlBinding) DataBindingUtil.bind(this.f13650i.f9588s.getViewStub().inflate());
            } else {
                this.f13651j = (MzSettingControlBinding) this.f13650i.f9588s.getBinding();
            }
            this.f13648g = this.f13651j.f9813a;
            this.f13648g.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            this.f13652k = (ListView) this.f13648g.findViewById(R.id.mz_setting_listview);
            Toolbar toolbar = (Toolbar) this.f13648g.findViewById(R.id.mz_setting_toolbar);
            toolbar.setNavigationIcon((int) R.drawable.mz_titlebar_ic_back_light);
            toolbar.setNavigationContentDescription((int) R.string.descp_setting_back);
            toolbar.setTitle((int) R.string.mz_setting_title);
            toolbar.setTitleTextColor(-1);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13669a;

                public void onClick(View view) {
                    if (!PatchProxy.proxy(new Object[]{view}, this, f13669a, false, 7560, new Class[]{View.class}, Void.TYPE).isSupported && MzSettingUI.this.f13656o != null) {
                        MzSettingUI.this.f13656o.mo21762b();
                    }
                }
            });
            this.f13653l = new ListViewProxy(this.f13652k) {

                /* renamed from: b */
                public static ChangeQuickRedirect f13671b;

                /* renamed from: b */
                public int[] mo16000b(int i) {
                    PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13671b, false, 7561, new Class[]{Integer.TYPE}, int[].class);
                    if (proxy.isSupported) {
                        return (int[]) proxy.result;
                    }
                    return new int[]{MzSettingUI.this.f13658q, MzSettingUI.this.f13658q};
                }
            };
            this.f13659r = new SettingAnimManager(this.f13647f, this.f13648g, this.f13652k);
            this.f13659r.mo18900a((SettingAnimManager.C1808a) this);
            this.f13653l.mo15995a();
            this.f13652k.setChoiceMode(2);
            this.f13652k.setOnItemClickListener(this);
            this.f13652k.setAdapter(this.f13654m);
            if (DeviceHelper.f13881ah) {
                this.f13665x = LayoutInflater.from(this.f13647f).inflate(R.layout.mz_custom_device_mark_layout, (ViewGroup) null);
                this.f13667z = (EditText) this.f13665x.findViewById(R.id.error_edit);
                this.f13666y = (TextInputLayout) this.f13665x.findViewById(R.id.edit_layout);
                this.f13666y.setLabelEnable(false);
                this.f13667z.setFilters(new InputFilter[]{this.f13645E});
            }
            this.f13657p = true;
        }
    }

    /* renamed from: a */
    public void mo22559a(C2602b bVar) {
        this.f13656o = bVar;
    }

    /* renamed from: r */
    private void m15703r() {
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7515, new Class[0], Void.TYPE).isSupported) {
            this.f13661t.clear();
            if (DeviceHelper.f13854aG) {
                C2601a aVar = new C2601a();
                aVar.f7564a = 2;
                aVar.f13685b = "mz_pref_mfll_key";
                aVar.f13686c = Integer.valueOf(R.string.mz_setting_mfll_title);
                aVar.f13687d = Integer.valueOf(R.string.mz_setting_mfll_lable);
                this.f13661t.add(aVar);
            }
            C2601a aVar2 = new C2601a();
            aVar2.f7564a = 2;
            aVar2.f13685b = "mz_pref_mirror";
            aVar2.f13686c = Integer.valueOf(R.string.mz_setting_mirror_title);
            aVar2.f13687d = Integer.valueOf(R.string.mz_setting_mirror_label);
            this.f13661t.add(aVar2);
            if (DeviceHelper.f13865aR) {
                C2601a aVar3 = new C2601a();
                aVar3.f7564a = 2;
                aVar3.f13685b = "mz_pref_voice_action_key";
                aVar3.f13686c = Integer.valueOf(R.string.mz_setting_voice_action_title);
                aVar3.f13687d = Integer.valueOf(R.string.mz_setting_voice_action_label);
                this.f13661t.add(aVar3);
            }
            C2601a aVar4 = new C2601a();
            aVar4.f7564a = 0;
            aVar4.f13685b = "mz_pref_meshline_key";
            aVar4.f13686c = Integer.valueOf(R.string.mz_setting_meshline_title);
            this.f13661t.add(aVar4);
            C2601a aVar5 = new C2601a();
            aVar5.f7564a = 0;
            aVar5.f13685b = "mz_pref_level_key";
            aVar5.f13686c = Integer.valueOf(R.string.mz_setting_level_title);
            this.f13661t.add(aVar5);
            if (DeviceHelper.f13838R) {
                C2601a aVar6 = new C2601a();
                aVar6.f7564a = 0;
                aVar6.f13685b = "mz_pref_meter_separate_key";
                aVar6.f13686c = Integer.valueOf(R.string.mz_meter_separate_title);
                this.f13661t.add(aVar6);
            }
            if (DeviceHelper.f13838R) {
                C2601a aVar7 = new C2601a();
                aVar7.f7564a = 0;
                aVar7.f13685b = "mz_pref_time_mark_key";
                aVar7.f13686c = Integer.valueOf(R.string.mz_setting_timemark_title);
                this.f13661t.add(aVar7);
            }
            if (DeviceHelper.f13879af || DeviceHelper.f13882ai) {
                C2601a aVar8 = new C2601a();
                if (DeviceHelper.f13881ah) {
                    aVar8.f7564a = 1;
                } else {
                    aVar8.f7564a = 0;
                }
                aVar8.f13685b = "mz_pref_device_mark_key";
                aVar8.f13686c = Integer.valueOf(R.string.mz_setting_devicemark_title);
                this.f13661t.add(aVar8);
            }
            C2601a aVar9 = new C2601a();
            aVar9.f7564a = 0;
            aVar9.f13685b = "mz_pref_meizu_mark_key";
            aVar9.f13686c = Integer.valueOf(R.string.mz_setting_funnycam_mark_title);
            this.f13661t.add(aVar9);
            if (DeviceHelper.f13941bo) {
                C2601a aVar10 = new C2601a();
                aVar10.f7564a = 0;
                aVar10.f13685b = "mz_pref_funny_hd_key";
                aVar10.f13686c = Integer.valueOf(R.string.mz_setting_funnycam_hd);
                this.f13661t.add(aVar10);
            }
            if (DeviceHelper.f13936bj) {
                C2601a aVar11 = new C2601a();
                aVar11.f7564a = 0;
                aVar11.f13685b = "mz_pref_storage_key";
                aVar11.f13686c = Integer.valueOf(R.string.mz_setting_storage_title);
                this.f13661t.add(aVar11);
            }
            C2601a aVar12 = new C2601a();
            aVar12.f7564a = 1;
            aVar12.f13685b = "pref_camera_picturesize_key";
            aVar12.f13686c = Integer.valueOf(R.string.mz_setting_picture_size_proportion);
            this.f13661t.add(aVar12);
            C2601a aVar13 = new C2601a();
            aVar13.f7564a = 1;
            aVar13.f13685b = "pref_camera_videosize_key";
            aVar13.f13686c = Integer.valueOf(R.string.mz_setting_recordsize_title);
            this.f13661t.add(aVar13);
            C2601a aVar14 = new C2601a();
            aVar14.f7564a = 2;
            aVar14.f13685b = "mz_pref_fb_high_picturesize_key";
            aVar14.f13686c = Integer.valueOf(R.string.mz_setting_fb_high_picturesize_title);
            aVar14.f13687d = Integer.valueOf(R.string.mz_setting_fb_high_picturesize_label);
            this.f13661t.add(aVar14);
            if (DeviceHelper.f13877ad) {
                C2601a aVar15 = new C2601a();
                aVar15.f7564a = 2;
                aVar15.f13685b = "mz_pref_asd_enable_key";
                aVar15.f13686c = Integer.valueOf(R.string.mz_setting_asd_switch_title);
                aVar15.f13687d = Integer.valueOf(R.string.mz_setting_asd_switch_label);
                this.f13661t.add(aVar15);
            }
            if (DeviceHelper.f13880ag) {
                C2601a aVar16 = new C2601a();
                aVar16.f7564a = 2;
                aVar16.f13685b = "mz_pref_barcode_in_auto_enable_key";
                aVar16.f13686c = Integer.valueOf(R.string.mz_setting_barcode_auto_switch_title);
                aVar16.f13687d = Integer.valueOf(R.string.mz_setting_barcode_auto_label);
                this.f13661t.add(aVar16);
            }
            if (DeviceHelper.f14034dz) {
                C2601a aVar17 = new C2601a();
                aVar17.f7564a = 2;
                aVar17.f13685b = "mz_pref_wide_angle_undistort_enable_key";
                aVar17.f13686c = Integer.valueOf(R.string.mz_setting_wide_angle_undistort_switch_title);
                aVar17.f13687d = Integer.valueOf(R.string.mz_setting_wide_angle_undistort_switch_label);
                this.f13661t.add(aVar17);
            }
        }
    }

    /* renamed from: s */
    private void m15704s() {
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7516, new Class[0], Void.TYPE).isSupported) {
            this.f13641A = this.f13647f.getResources().getStringArray(R.array.mz_custom_device_mark_desc_options);
            this.f13642B = this.f13647f.getResources().getStringArray(R.array.mz_custom_device_mark_options_without_trans);
        }
    }

    /* renamed from: t */
    private void m15705t() {
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7517, new Class[0], Void.TYPE).isSupported && this.f13652k != null) {
            this.f13652k.setAdapter(this.f13654m);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m15706u() {
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7518, new Class[0], Void.TYPE).isSupported && mo22571g()) {
            this.f13654m.notifyDataSetChanged();
        }
    }

    /* renamed from: d */
    public void mo22568d() {
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7519, new Class[0], Void.TYPE).isSupported) {
            this.f13662u.clear();
            for (C2601a next : this.f13661t) {
                if ((next.f13691h || "mz_pref_storage_key".equals(next.f13685b)) && (!"mz_pref_mfll_key".equals(next.f13685b) || !DeviceHelper.f14041k)) {
                    this.f13662u.add(next);
                }
            }
        }
    }

    /* renamed from: v */
    private void m15707v() {
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7520, new Class[0], Void.TYPE).isSupported) {
            for (int i = 0; i < this.f13662u.size(); i++) {
                this.f13652k.setItemChecked(i, this.f13662u.get(i).f13690g);
            }
        }
    }

    /* renamed from: m */
    private void m15698m(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13639a, false, 7521, new Class[]{String.class}, Void.TYPE).isSupported) {
            for (int i = 0; i < this.f13662u.size(); i++) {
                C2601a aVar = this.f13662u.get(i);
                if (aVar.f13685b.equals(str)) {
                    this.f13652k.setItemChecked(i, aVar.f13690g);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo22557a(int i, boolean z) {
        C2601a p;
        String str;
        int parseInt;
        Byte b = new Byte(z ? (byte) 1 : 0);
        boolean z2 = true;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), b}, this, f13639a, false, 7522, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && this.f13647f != null && CameraController.m8868g().mo19522k() != null) {
            this.f13655n = i;
            mo22568d();
            if (2 == this.f13655n) {
                C2601a p2 = m15701p("pref_camera_videosize_key");
                if (p2 != null && p2.f13691h) {
                    p2.f13688e = mo21880c(p2.f13685b);
                    String b2 = DeviceSizeTable.m16188b(p2.f13688e);
                    String str2 = "";
                    int b3 = CameraController.m8868g().mo19522k().mo19733b();
                    String a = PreferenceUtil.m15980a(this.f13647f, "pref_video_quality_key");
                    if (DeviceHelper.f13863aP && !((b3 != DeviceHelper.f13949bw && (DeviceHelper.f14019dk != DeviceHelper.EIS_SUPPORT_SCENE.WITHOUT_TELE || b3 != DeviceHelper.f14029du)) || (parseInt = Integer.parseInt(a)) == 5 || parseInt == 6)) {
                        a = String.valueOf(6);
                        b2 = DeviceSizeTable.m16188b("1920x1080");
                        LogUtil.m15952c(f13640d, "setType, reset quality 1080P");
                    }
                    if (DeviceHelper.f14019dk != DeviceHelper.EIS_SUPPORT_SCENE.ALL && ((DeviceHelper.f14019dk != DeviceHelper.EIS_SUPPORT_SCENE.WITHOUT_TELE || b3 == DeviceHelper.f13949bw) && !((DeviceHelper.f14019dk == DeviceHelper.EIS_SUPPORT_SCENE.BACK_FRONT && (b3 == 0 || b3 == 1)) || (DeviceHelper.f14019dk == DeviceHelper.EIS_SUPPORT_SCENE.BACK && b3 == 0)))) {
                        z2 = false;
                    }
                    if (CameraController.m8868g().mo19442F() && z2) {
                        str2 = this.f13647f.getResources().getString(R.string.mz_setting_des_fps_30);
                    }
                    if (z2 && (String.valueOf(DeviceHelper.f14003cx).equals(a) || String.valueOf(DeviceHelper.f14005cz).equals(a))) {
                        str2 = this.f13647f.getResources().getString(R.string.mz_setting_des_fps_60);
                    }
                    if (DeviceHelper.f13863aP) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(b2);
                        if ("".equals(str2)) {
                            str = "";
                        } else {
                            str = " ( " + str2.replace("、", "") + " ) ";
                        }
                        sb.append(str);
                        p2.f13689f = sb.toString();
                    } else {
                        if (b3 == 0 && DeviceHelper.f13862aO && (String.valueOf(5).equals(a) || String.valueOf(6).equals(a) || (String.valueOf(DeviceHelper.f14004cy).equals(a) && DeviceHelper.f13859aL))) {
                            str2 = str2 + this.f13647f.getResources().getString(R.string.mz_setting_des_antishake);
                        }
                        p2.f13689f = DeviceSizeTable.m16187a(b2, p2.f13688e, str2);
                    }
                }
            } else {
                C2601a p3 = m15701p("pref_camera_picturesize_key");
                if (p3 != null && p3.f13691h) {
                    p3.f13688e = mo21880c(p3.f13685b);
                    p3.f13689f = DeviceSizeTable.m16186a(p3.f13688e);
                }
            }
            if (DeviceHelper.f13881ah && (p = m15701p("mz_pref_device_mark_key")) != null && p.f13691h) {
                String c = PreferenceUtil.m15983c(this.f13647f, p.f13685b, this.f13647f.getString(R.string.setting_on_value));
                LogUtil.m15952c(f13640d, "setDeviceMark: currentOption = " + c);
                if (c != null) {
                    if (c.equals(this.f13647f.getString(R.string.setting_custom_value))) {
                        String c2 = PreferenceUtil.m15983c(this.f13647f, "mz_pref_custom_device_mark_key", this.f13647f.getString(R.string.mz_custom_device_mark_defalut_hint));
                        if (DeviceHelper.f14036f == DeviceHelper.CUSTOM_DEVICE_MARK.PROCESS_AFTER_DEVICE_NAME) {
                            c2 = c2.replace("© ", "");
                        }
                        p.f13689f = c2;
                    } else {
                        p.f13689f = this.f13641A[m15700o(c)];
                    }
                }
            }
            m15705t();
            m15707v();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{adapterView, view, new Integer(i), new Long(j)}, this, f13639a, false, 7523, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported && this.f13647f != null && !this.f13647f.mo17677n() && CameraController.m8868g().mo19522k() != null) {
            C2601a aVar = (C2601a) this.f13654m.getItem(i);
            if (aVar.f7564a == 1) {
                if (aVar.f13691h) {
                    if (aVar.f13685b.equals("mz_pref_device_mark_key")) {
                        m15699n(PreferenceUtil.m15983c(this.f13647f, "mz_pref_device_mark_key", this.f13647f.getString(R.string.setting_on_value)));
                        return;
                    }
                    if (2 != this.f13655n) {
                        z = false;
                    }
                    m15692d(z);
                }
            } else if ((aVar.f7564a == 0 || aVar.f7564a == 2) && aVar.f13691h && (view instanceof Checkable)) {
                boolean isChecked = ((Checkable) view).isChecked();
                aVar.f13690g = isChecked;
                mo21881d(aVar.f13685b, isChecked);
            }
        }
    }

    /* renamed from: n */
    private void m15699n(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13639a, false, 7524, new Class[]{String.class}, Void.TYPE).isSupported) {
            int o = m15700o(str);
            CameraUtil.m15895e((Activity) this.f13647f);
            if (this.f13663v != null) {
                this.f13663v.dismiss();
            }
            this.f13663v = new AlertDialog.Builder(this.f13647f, R.style.CustomDeviceMarkStyle).mo25131a((CharSequence) this.f13647f.getResources().getString(R.string.mz_setting_devicemark_title)).mo25134a(this.f13641A, o, new DialogInterface.OnClickListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f13673a;

                public void onClick(DialogInterface dialogInterface, int i) {
                    Object[] objArr = {dialogInterface, new Integer(i)};
                    ChangeQuickRedirect changeQuickRedirect = f13673a;
                    if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7562, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                        MzSettingUI.this.m15683a(i);
                    }
                }
            }).mo25141b();
            this.f13663v.show();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0025, code lost:
        r1 = m15701p("mz_pref_device_mark_key");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15683a(int r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r10)
            r3 = 0
            r1[r3] = r2
            com.meizu.savior.ChangeQuickRedirect r4 = f13639a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r2 = java.lang.Integer.TYPE
            r6[r3] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r5 = 0
            r8 = 7525(0x1d65, float:1.0545E-41)
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
            com.meizu.media.camera.ui.x$a r1 = r9.m15701p(r1)
            if (r1 == 0) goto L_0x0133
            boolean r2 = r1.f13691h
            if (r2 == 0) goto L_0x0133
            flyme.support.v7.app.AlertDialog r2 = r9.f13663v
            if (r2 != 0) goto L_0x0037
            goto L_0x0133
        L_0x0037:
            java.lang.String r2 = "mz_pref_device_mark_key"
            java.lang.String r3 = java.lang.String.valueOf(r10)
            r9.m15690b((java.lang.String) r2, (java.lang.String) r3)
            java.lang.String[] r2 = r9.f13642B
            int r2 = r2.length
            int r2 = r2 - r0
            if (r10 >= r2) goto L_0x0061
            com.meizu.media.camera.CameraActivity r0 = r9.f13647f
            java.lang.String r2 = "mz_pref_device_mark_key"
            java.lang.String[] r3 = r9.f13642B
            r3 = r3[r10]
            com.meizu.media.camera.util.PreferenceUtil.m15982b(r0, r2, r3)
            java.lang.String[] r0 = r9.f13641A
            r10 = r0[r10]
            r1.f13689f = r10
            flyme.support.v7.app.AlertDialog r10 = r9.f13663v
            r10.dismiss()
            r9.m15706u()
            goto L_0x0132
        L_0x0061:
            java.lang.String[] r2 = r9.f13642B
            int r2 = r2.length
            int r2 = r2 - r0
            if (r10 != r2) goto L_0x0132
            flyme.support.v7.app.AlertDialog r10 = r9.f13663v
            r10.dismiss()
            flyme.support.v7.app.AlertDialog r10 = r9.f13664w
            if (r10 != 0) goto L_0x00a7
            com.meizu.media.camera.CameraActivity r10 = r9.f13647f
            com.meizu.media.camera.util.CameraUtil.m15895e((android.app.Activity) r10)
            flyme.support.v7.app.AlertDialog$Builder r10 = new flyme.support.v7.app.AlertDialog$Builder
            com.meizu.media.camera.CameraActivity r0 = r9.f13647f
            r10.<init>(r0)
            r0 = 2131755609(0x7f100259, float:1.9142102E38)
            flyme.support.v7.app.AlertDialog$Builder r10 = r10.mo25124a((int) r0)
            android.view.View r0 = r9.f13665x
            flyme.support.v7.app.AlertDialog$Builder r10 = r10.mo25138b((android.view.View) r0)
            r0 = 2131755372(0x7f10016c, float:1.9141621E38)
            com.meizu.media.camera.ui.x$7 r2 = new com.meizu.media.camera.ui.x$7
            r2.<init>(r1)
            flyme.support.v7.app.AlertDialog$Builder r10 = r10.mo25125a((int) r0, (android.content.DialogInterface.OnClickListener) r2)
            r0 = 2131755371(0x7f10016b, float:1.914162E38)
            com.meizu.media.camera.ui.x$6 r1 = new com.meizu.media.camera.ui.x$6
            r1.<init>()
            flyme.support.v7.app.AlertDialog$Builder r10 = r10.mo25137b((int) r0, (android.content.DialogInterface.OnClickListener) r1)
            flyme.support.v7.app.AlertDialog r10 = r10.mo25141b()
            r9.f13664w = r10
        L_0x00a7:
            com.meizu.media.camera.CameraActivity r10 = r9.f13647f
            boolean r10 = r10.mo17636c()
            if (r10 == 0) goto L_0x00bc
            flyme.support.v7.app.AlertDialog r10 = r9.f13664w
            android.view.Window r10 = r10.getWindow()
            if (r10 == 0) goto L_0x00bc
            r0 = 524288(0x80000, float:7.34684E-40)
            r10.addFlags(r0)
        L_0x00bc:
            com.meizu.media.camera.CameraActivity r10 = r9.f13647f
            r0 = 2131755368(0x7f100168, float:1.9141613E38)
            java.lang.String r10 = r10.getString(r0)
            com.meizu.media.camera.CameraActivity r0 = r9.f13647f
            java.lang.String r1 = "mz_pref_custom_device_mark_key"
            java.lang.String r0 = com.meizu.media.camera.util.PreferenceUtil.m15983c(r0, r1, r10)
            boolean r1 = r10.equals(r0)
            if (r1 == 0) goto L_0x00e7
            android.widget.EditText r0 = r9.f13667z
            com.meizu.media.camera.util.DeviceHelper$CUSTOM_DEVICE_MARK r1 = com.meizu.media.camera.util.DeviceHelper.f14036f
            com.meizu.media.camera.util.DeviceHelper$CUSTOM_DEVICE_MARK r2 = com.meizu.media.camera.util.DeviceHelper.CUSTOM_DEVICE_MARK.PROCESS_AFTER_DEVICE_NAME
            if (r1 != r2) goto L_0x00e3
            java.lang.String r1 = "By "
            java.lang.String r2 = ""
            java.lang.String r10 = r10.replace(r1, r2)
        L_0x00e3:
            r0.setText(r10)
            goto L_0x00fa
        L_0x00e7:
            android.widget.EditText r10 = r9.f13667z
            com.meizu.media.camera.util.DeviceHelper$CUSTOM_DEVICE_MARK r1 = com.meizu.media.camera.util.DeviceHelper.f14036f
            com.meizu.media.camera.util.DeviceHelper$CUSTOM_DEVICE_MARK r2 = com.meizu.media.camera.util.DeviceHelper.CUSTOM_DEVICE_MARK.PROCESS_AFTER_DEVICE_NAME
            if (r1 != r2) goto L_0x00f7
            java.lang.String r1 = "© "
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)
        L_0x00f7:
            r10.setText(r0)
        L_0x00fa:
            android.widget.EditText r10 = r9.f13667z
            r9.m15684a((android.widget.EditText) r10)
            android.widget.EditText r10 = r9.f13667z
            r10.requestFocus()
            flyme.support.v7.app.AlertDialog r10 = r9.f13664w
            r10.show()
            flyme.support.v7.app.AlertDialog r10 = r9.f13664w
            r0 = -1
            android.widget.Button r10 = r10.mo25117a(r0)
            flyme.support.v7.app.AlertDialog r0 = r9.f13664w
            r1 = -2
            android.widget.Button r0 = r0.mo25117a(r1)
            int r1 = r9.f13644D
            r10.setTextColor(r1)
            int r1 = r9.f13644D
            r0.setTextColor(r1)
            com.meizu.textinputlayout.TextInputLayout r0 = r9.f13666y
            android.widget.EditText r1 = r9.f13667z
            r9.m15687a(r0, r1, r10)
            android.widget.EditText r0 = r9.f13667z
            com.meizu.media.camera.ui.x$8 r1 = new com.meizu.media.camera.ui.x$8
            r1.<init>(r10)
            r0.addTextChangedListener(r1)
        L_0x0132:
            return
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p077ui.MzSettingUI.m15683a(int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m15682a(CharSequence charSequence) {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{charSequence}, this, f13639a, false, 7526, new Class[]{CharSequence.class}, String.class);
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
    public void m15687a(TextInputLayout textInputLayout, EditText editText, Button button) {
        if (!PatchProxy.proxy(new Object[]{textInputLayout, editText, button}, this, f13639a, false, 7527, new Class[]{TextInputLayout.class, EditText.class, Button.class}, Void.TYPE).isSupported) {
            String obj = editText.getText().toString();
            if (C2644av.m16112c(obj) > 20 && ((this.f13643C == null || !this.f13647f.getString(R.string.mz_custom_device_mark_dialog_error_hint_length).equals(this.f13643C)) && !C2644av.m16111b(obj))) {
                this.f13643C = this.f13647f.getString(R.string.mz_custom_device_mark_dialog_error_hint_length);
                textInputLayout.setError(this.f13643C);
            }
            if (C2644av.m16111b(obj) && (this.f13643C == null || !this.f13647f.getString(R.string.mz_custom_device_mark_dialog_error_hint_emoji).equals(this.f13643C))) {
                this.f13643C = this.f13647f.getString(R.string.mz_custom_device_mark_dialog_error_hint_emoji);
                textInputLayout.setError(this.f13643C);
            }
            if (TextUtils.isEmpty(obj) || C2644av.m16111b(obj) || C2644av.m16112c(obj) > 20 || obj.charAt(0) <= ' ') {
                button.setEnabled(false);
                button.setAlpha(0.25f);
                if (TextUtils.isEmpty(obj) || obj.charAt(0) <= ' ') {
                    this.f13643C = null;
                    return;
                }
                return;
            }
            textInputLayout.setError((CharSequence) null);
            textInputLayout.setErrorEnabled(false);
            editText.setBackgroundTintList((ColorStateList) null);
            this.f13643C = null;
            button.setEnabled(true);
            button.setAlpha(1.0f);
        }
    }

    /* renamed from: a */
    private void m15684a(EditText editText) {
        if (!PatchProxy.proxy(new Object[]{editText}, this, f13639a, false, 7528, new Class[]{EditText.class}, Void.TYPE).isSupported) {
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

    /* renamed from: o */
    private int m15700o(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f13639a, false, 7529, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (str == null) {
            return 1;
        }
        for (int i = 0; i < this.f13642B.length; i++) {
            if (str.equals(this.f13642B[i])) {
                return i;
            }
        }
        return 1;
    }

    /* renamed from: d */
    private void m15692d(boolean z) {
        Point a;
        String[] strArr;
        String[] strArr2;
        String str;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13639a, false, 7530, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                m15701p("pref_camera_videosize_key");
                String a2 = PreferenceUtil.m15980a(this.f13647f, "pref_video_quality_key");
                if (DeviceHelper.f13863aP) {
                    if (this.f13646e == 1) {
                        strArr2 = this.f13660s.mo22760a();
                        strArr = this.f13660s.mo22763d();
                    } else {
                        strArr2 = this.f13660s.mo22761b();
                        strArr = this.f13660s.mo22762c();
                    }
                    if (this.f13646e == DeviceHelper.f13949bw || (this.f13646e == DeviceHelper.f14029du && DeviceHelper.f14019dk == DeviceHelper.EIS_SUPPORT_SCENE.WITHOUT_TELE)) {
                        String[] strArr3 = {strArr[0], strArr[1]};
                        strArr2 = new String[]{strArr2[0], strArr2[1]};
                        strArr = strArr3;
                    }
                } else if (this.f13646e == 0) {
                    strArr2 = this.f13660s.mo22761b();
                    strArr = this.f13660s.mo22762c();
                } else {
                    strArr2 = this.f13660s.mo22760a();
                    strArr = this.f13660s.mo22763d();
                }
                String[] strArr4 = new String[strArr.length];
                int i = -1;
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    String b = DeviceSizeTable.m16188b(strArr2[i2]);
                    String str2 = "";
                    int b2 = CameraController.m8868g().mo19522k().mo19733b();
                    boolean z2 = DeviceHelper.f14019dk == DeviceHelper.EIS_SUPPORT_SCENE.ALL || (DeviceHelper.f14019dk == DeviceHelper.EIS_SUPPORT_SCENE.WITHOUT_TELE && b2 != DeviceHelper.f13949bw) || ((DeviceHelper.f14019dk == DeviceHelper.EIS_SUPPORT_SCENE.BACK_FRONT && (b2 == 0 || b2 == 1)) || (DeviceHelper.f14019dk == DeviceHelper.EIS_SUPPORT_SCENE.BACK && b2 == 0));
                    if (CameraController.m8868g().mo19442F() && z2) {
                        str2 = this.f13647f.getResources().getString(R.string.mz_setting_des_fps_30);
                    }
                    if (z2 && (String.valueOf(DeviceHelper.f14003cx).equals(strArr[i2]) || String.valueOf(DeviceHelper.f14005cz).equals(strArr[i2]))) {
                        str2 = this.f13647f.getResources().getString(R.string.mz_setting_des_fps_60);
                    }
                    if (DeviceHelper.f13863aP) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(b);
                        if ("".equals(str2)) {
                            str = "";
                        } else {
                            str = " ( " + str2.replace("、", "") + " ) ";
                        }
                        sb.append(str);
                        strArr4[i2] = sb.toString();
                    } else {
                        if (b2 == 0 && DeviceHelper.f13862aO && (String.valueOf(5).equals(strArr[i2]) || String.valueOf(6).equals(strArr[i2]) || (String.valueOf(DeviceHelper.f14004cy).equals(strArr[i2]) && DeviceHelper.f13859aL))) {
                            str2 = str2 + this.f13647f.getResources().getString(R.string.mz_setting_des_antishake);
                        }
                        strArr4[i2] = DeviceSizeTable.m16187a(b, strArr2[i2], str2);
                    }
                    if (a2.equals(strArr[i2])) {
                        i = i2;
                    }
                }
                if (i == -1) {
                    i = strArr.length - 1;
                }
                SizeChoiceDialogActivity.m7737a((Activity) this.f13647f, z, strArr4, i);
            } else {
                String str3 = m15701p("pref_camera_picturesize_key").f13688e;
                String[] a3 = CameraSizeUtil.m16179a();
                String[] strArr5 = new String[a3.length];
                int i3 = -1;
                for (int i4 = 0; i4 < a3.length; i4++) {
                    if (str3.equals(a3[i4])) {
                        i3 = i4;
                    }
                    strArr5[i4] = DeviceSizeTable.m16186a(a3[i4]);
                }
                if (i3 == -1 && (a = CameraSizeUtil.m16173a(str3)) != null) {
                    for (int i5 = 0; i5 < a3.length; i5++) {
                        Point a4 = CameraSizeUtil.m16173a(a3[i5]);
                        if (a4 != null) {
                            if (CameraUtil.m15829a(((float) a.x) / ((float) a.y)) == CameraUtil.m15829a(((float) a4.x) / ((float) a4.y))) {
                                i3 = i5;
                            }
                            strArr5[i5] = DeviceSizeTable.m16186a(a3[i5]);
                        }
                    }
                }
                if (i3 == -1) {
                    i3 = 0;
                }
                SizeChoiceDialogActivity.m7737a((Activity) this.f13647f, z, strArr5, i3);
            }
            if (this.f13647f != null) {
                this.f13647f.mo17678o();
            }
        }
    }

    /* renamed from: a */
    public void mo22558a(Intent intent) {
        String[] strArr;
        String[] strArr2;
        if (!PatchProxy.proxy(new Object[]{intent}, this, f13639a, false, 7531, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            boolean booleanExtra = intent.getBooleanExtra("isVideoSize", false);
            int intExtra = intent.getIntExtra("whichSize", 0);
            int intExtra2 = intent.getIntExtra("defaultItemId", 0);
            String[] stringArrayExtra = intent.getStringArrayExtra("proportion");
            if (booleanExtra) {
                if (intExtra2 != intExtra) {
                    if (this.f13646e == 1) {
                        strArr2 = this.f13660s.mo22760a();
                        strArr = this.f13660s.mo22763d();
                    } else {
                        strArr2 = this.f13660s.mo22761b();
                        strArr = this.f13660s.mo22762c();
                    }
                    if (DeviceHelper.f13863aP && (this.f13646e == DeviceHelper.f13949bw || (this.f13646e == DeviceHelper.f14029du && DeviceHelper.f14019dk == DeviceHelper.EIS_SUPPORT_SCENE.WITHOUT_TELE))) {
                        String[] strArr3 = {strArr[0], strArr[1]};
                        strArr2 = new String[]{strArr2[0], strArr2[1]};
                        strArr = strArr3;
                    }
                    C2601a p = m15701p("pref_camera_videosize_key");
                    if (p != null) {
                        p.f13688e = strArr2[intExtra];
                        p.f13689f = stringArrayExtra[intExtra];
                    }
                    if (stringArrayExtra[intExtra].contains(this.f13647f.getResources().getString(R.string.mz_setting_des_fps_60).replace("、", ""))) {
                        PreferenceUtil.m15981a(this.f13647f, "pref_camera_video_high_frame_rate_key", Integer.toString(60));
                    } else {
                        PreferenceUtil.m15981a(this.f13647f, "pref_camera_video_high_frame_rate_key", Integer.toString(30));
                    }
                    PreferenceUtil.m15981a(this.f13647f, "pref_camera_videosize_key", strArr2[intExtra]);
                    PreferenceUtil.m15981a(this.f13647f, "pref_video_quality_key", strArr[intExtra]);
                    m15702q(strArr[intExtra]);
                    m15706u();
                }
            } else if (intExtra != intExtra2) {
                C2601a p2 = m15701p("pref_camera_picturesize_key");
                if (p2 != null) {
                    p2.f13689f = stringArrayExtra[intExtra];
                    p2.f13688e = CameraSizeUtil.m16179a()[intExtra];
                }
                PreferenceUtil.m15981a(this.f13647f, "pref_camera_picturesize_key", CameraSizeUtil.m16179a()[intExtra]);
                m15688a("click_picture_size", stringArrayExtra[intExtra]);
                m15706u();
            }
        }
    }

    /* renamed from: p */
    private C2601a m15701p(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f13639a, false, 7532, new Class[]{String.class}, C2601a.class);
        if (proxy.isSupported) {
            return (C2601a) proxy.result;
        }
        for (C2601a next : this.f13661t) {
            if (next != null && str.equals(next.f13685b)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo22560a(String str, boolean z) {
        C2601a p;
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f13639a, false, 7533, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported && (p = m15701p(str)) != null) {
            p.f13690g = z;
            m15698m(str);
        }
    }

    /* renamed from: b */
    public void mo22563b(String str, boolean z) {
        C2601a p;
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f13639a, false, 7534, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported && (p = m15701p(str)) != null) {
            p.f13691h = z;
            m15706u();
        }
    }

    /* renamed from: a */
    public boolean mo22562a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f13639a, false, 7535, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C2601a p = m15701p(str);
        if (p != null) {
            return p.f13691h;
        }
        return false;
    }

    /* renamed from: a */
    public void mo22561a(boolean z) {
        C2601a p;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13639a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7536, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && (p = m15701p("mz_pref_storage_key")) != null) {
            p.f13691h = z;
            m15706u();
        }
    }

    /* renamed from: f */
    public void mo22570f() {
        C2601a p;
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7537, new Class[0], Void.TYPE).isSupported && (p = m15701p("mz_pref_storage_key")) != null) {
            p.f13690g = mo22579o();
            mo22560a(p.f13685b, p.f13690g);
        }
    }

    /* renamed from: b */
    public void mo22564b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13639a, false, 7538, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            for (C2601a next : this.f13661t) {
                mo21891l(next.f13685b);
                if (next.f7564a == 0 || next.f7564a == 2) {
                    next.f13690g = mo21879b(next.f13685b);
                } else if (next.f7564a == 1 && !next.f13685b.equals("mz_pref_device_mark_key")) {
                    next.f13688e = PreferenceUtil.m15980a(this.f13647f, next.f13685b);
                }
            }
            m15706u();
        }
    }

    /* renamed from: com.meizu.media.camera.ui.x$c */
    /* compiled from: MzSettingUI */
    private class C2603c extends MyTypeAdapter<C2601a> {

        /* renamed from: g */
        public static ChangeQuickRedirect f13693g;

        public C2603c(Context context, List<C2601a> list) {
            super(context, new int[]{1, 0, 2}, new int[]{R.layout.mz_camera_setting_label, R.layout.mz_camera_setting_switch, R.layout.mz_camera_setting_switchlabel}, list);
        }

        /* renamed from: a */
        public void mo18787a(ViewHolder dVar, final int i, int i2, final C2601a aVar) {
            Object[] objArr = {dVar, new Integer(i), new Integer(i2), aVar};
            ChangeQuickRedirect changeQuickRedirect = f13693g;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7567, new Class[]{ViewHolder.class, Integer.TYPE, Integer.TYPE, C2601a.class}, Void.TYPE).isSupported) {
                if (i2 == 0) {
                    dVar.mo18800a(aVar.f13691h);
                    dVar.mo18797a((int) R.id.mz_item_title, aVar.f13686c.intValue());
                    dVar.mo18798a((int) R.id.mz_item_switcher, (CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f13695a;

                        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            if (!PatchProxy.proxy(new Object[]{compoundButton, new Byte(z ? (byte) 1 : 0)}, this, f13695a, false, 7568, new Class[]{CompoundButton.class, Boolean.TYPE}, Void.TYPE).isSupported && compoundButton.isPressed()) {
                                aVar.f13690g = z;
                                MzSettingUI.this.mo21881d(aVar.f13685b, z);
                                MzSettingUI.this.f13652k.setItemChecked(i, z);
                            }
                        }
                    });
                } else if (i2 == 1) {
                    dVar.mo18800a(true);
                    dVar.mo18797a((int) R.id.mz_item_title, aVar.f13686c.intValue());
                    dVar.mo18799a((int) R.id.mz_item_detail, aVar.f13689f);
                } else if (i2 == 2) {
                    dVar.mo18800a(aVar.f13691h);
                    dVar.mo18797a((int) R.id.mz_item_title, aVar.f13686c.intValue());
                    dVar.mo18797a((int) R.id.mz_item_detail, aVar.f13687d.intValue());
                    dVar.mo18798a((int) R.id.mz_item_switcher, (CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f13699a;

                        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            if (!PatchProxy.proxy(new Object[]{compoundButton, new Byte(z ? (byte) 1 : 0)}, this, f13699a, false, 7569, new Class[]{CompoundButton.class, Boolean.TYPE}, Void.TYPE).isSupported && compoundButton.isPressed()) {
                                aVar.f13690g = z;
                                MzSettingUI.this.mo21881d(aVar.f13685b, z);
                                MzSettingUI.this.f13652k.setItemChecked(i, z);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    public void mo18915a() {
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7539, new Class[0], Void.TYPE).isSupported && this.f13656o != null) {
            this.f13656o.mo21761a();
        }
    }

    /* renamed from: b */
    public void mo18916b() {
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7540, new Class[0], Void.TYPE).isSupported && this.f13656o != null) {
            this.f13656o.mo21763c();
        }
    }

    /* renamed from: g */
    public boolean mo22571g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13639a, false, 7541, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f13659r == null || this.f13648g == null) {
            return false;
        }
        if (this.f13659r.mo18902c() || this.f13648g.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public boolean mo22572h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13639a, false, 7542, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f13659r != null) {
            return this.f13659r.mo18902c();
        }
        return false;
    }

    /* renamed from: c */
    public void mo22567c(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13639a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7543, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                this.f13659r.mo18901b();
            } else {
                this.f13648g.setVisibility(4);
            }
            mo22582q();
        }
    }

    /* renamed from: i */
    public void mo22573i() {
        CameraProxy k;
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7544, new Class[0], Void.TYPE).isSupported && (k = CameraController.m8868g().mo19522k()) != null) {
            this.f13646e = k.mo19733b();
            this.f13659r.mo18899a();
        }
    }

    /* renamed from: j */
    public boolean mo22574j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13639a, false, 7545, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21879b("mz_pref_meter_separate_key");
    }

    /* renamed from: k */
    public boolean mo22575k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13639a, false, 7546, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21879b("mz_pref_mirror");
    }

    /* renamed from: l */
    public boolean mo22576l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13639a, false, 7548, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21879b("mz_pref_mfll_key");
    }

    /* renamed from: m */
    public boolean mo22577m() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13639a, false, 7549, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21879b("mz_pref_meshline_key");
    }

    /* renamed from: n */
    public boolean mo22578n() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13639a, false, 7550, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21879b("mz_pref_level_key");
    }

    /* renamed from: o */
    public boolean mo22579o() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13639a, false, 7551, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21882d("mz_pref_storage_key");
    }

    /* renamed from: p */
    public boolean mo22581p() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13639a, false, 7552, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : mo21879b("mz_pref_voice_action_key");
    }

    /* renamed from: c */
    public void mo22566c(String str, boolean z) {
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0)}, this, f13639a, false, 7554, new Class[]{String.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            mo21881d(str, z);
        }
    }

    /* renamed from: a */
    private void m15688a(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f13639a, false, 7555, clsArr, Void.TYPE).isSupported) {
            Map<String, String> a = UsageStatsHelper.m16042a(this.f13647f.getApplicationContext()).mo22688a(UsageStatsHelper.m16057z(str));
            a.put("value", str2);
            UsageStatsHelper.m16042a(this.f13647f.getApplicationContext()).mo22693a(str, a);
        }
    }

    /* renamed from: q */
    private void m15702q(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13639a, false, 7556, new Class[]{String.class}, Void.TYPE).isSupported) {
            Map<String, String> a = UsageStatsHelper.m16042a(this.f13647f.getApplicationContext()).mo22688a(UsageStatsHelper.m16057z("click_video_size"));
            a.put("value", CameraSizeUtil.m16180b(str));
            UsageStatsHelper.m16042a(this.f13647f.getApplicationContext()).mo22693a("click_video_size", a);
        }
    }

    /* renamed from: b */
    private void m15690b(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f13639a, false, 7557, clsArr, Void.TYPE).isSupported) {
            UsageStatsHelper.m16042a(this.f13647f.getApplicationContext()).mo22690a(str, String.valueOf(str2));
            String y = UsageStatsHelper.m16056y(str);
            Map<String, String> a = UsageStatsHelper.m16042a(this.f13647f.getApplicationContext()).mo22688a(UsageStatsHelper.m16057z(y));
            a.put("value", str2);
            UsageStatsHelper.m16042a(this.f13647f.getApplicationContext()).mo22693a(y, a);
        }
    }

    /* renamed from: q */
    public void mo22582q() {
        if (!PatchProxy.proxy(new Object[0], this, f13639a, false, 7559, new Class[0], Void.TYPE).isSupported) {
            if (this.f13664w != null) {
                this.f13664w.dismiss();
            }
            if (this.f13663v != null) {
                this.f13663v.dismiss();
            }
        }
    }
}
