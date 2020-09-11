package com.meizu.media.camera;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.p020ar.base.MsgField;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.common.util.ListViewProxy;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.app.AndroidServices;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.utils.reflect.SystemProperties;
import flyme.support.p093v7.app.AlertDialog;

public class SizeChoiceDialogActivity extends Activity {

    /* renamed from: a */
    public static ChangeQuickRedirect f7363a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f7364b = new LogUtil.C2630a("SizeChoiceDialogActivity");

    /* renamed from: c */
    private AlertDialog f7365c;

    /* renamed from: d */
    private View f7366d;

    /* renamed from: e */
    private boolean f7367e;

    /* renamed from: f */
    private BroadcastReceiver f7368f = new BroadcastReceiver() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7375a;

        public void onReceive(Context context, Intent intent) {
            if (!PatchProxy.proxy(new Object[]{context, intent}, this, f7375a, false, 2111, new Class[]{Context.class, Intent.class}, Void.TYPE).isSupported) {
                LogUtil.m15952c(SizeChoiceDialogActivity.f7364b, intent.getAction());
                SizeChoiceDialogActivity.this.finish();
            }
        }
    };

    public int mzNightModeUseOf() {
        return 0;
    }

    public void onCreate(@Nullable Bundle bundle) {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[]{bundle}, this, f7363a, false, 2102, new Class[]{Bundle.class}, Void.TYPE).isSupported) {
            Resources resources = getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.fontScale = 1.0f;
            configuration.densityDpi = SystemProperties.getInt("persist.sys.density", SystemProperties.getInt("ro.sf.lcd_density", 480).intValue()).intValue();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            super.onCreate(bundle);
            this.f7367e = AndroidServices.m8287a().mo19005d().isKeyguardLocked();
            setFinishOnTouchOutside(true);
            boolean booleanExtra = getIntent().getBooleanExtra("isVideoSize", false);
            String[] stringArrayExtra = getIntent().getStringArrayExtra("proportion");
            int intExtra = getIntent().getIntExtra("defaultItemId", 0);
            if (booleanExtra) {
                int length = stringArrayExtra.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = stringArrayExtra[i];
                    if (str.contains("4K") && str.contains("60fps")) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            if (z) {
                m7738a(this, stringArrayExtra, intExtra);
                this.f7365c = new AlertDialog.Builder(this, R.style.mzAlterDialogTheme).mo25138b(this.f7366d).mo25146e(17).mo25141b();
            } else {
                this.f7365c = new AlertDialog.Builder(this, R.style.mzAlterDialogTheme).mo25124a(booleanExtra ? R.string.mz_setting_recordsize_title : R.string.mz_setting_picture_size_proportion).mo25134a(stringArrayExtra, intExtra, new DialogInterface.OnClickListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f7369a;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!PatchProxy.proxy(new Object[]{dialogInterface, new Integer(i)}, this, f7369a, false, 2109, new Class[]{DialogInterface.class, Integer.TYPE}, Void.TYPE).isSupported) {
                            SizeChoiceDialogActivity.this.getIntent().putExtra("whichSize", i);
                            SizeChoiceDialogActivity.this.setResult(-1, SizeChoiceDialogActivity.this.getIntent());
                            dialogInterface.dismiss();
                        }
                    }
                }).mo25141b();
            }
            if (this.f7367e) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.flags |= 524288;
                getWindow().setAttributes(attributes);
                WindowManager.LayoutParams attributes2 = this.f7365c.getWindow().getAttributes();
                if (Build.VERSION.SDK_INT >= 26) {
                    attributes2.type = 2038;
                } else {
                    attributes2.type = PushConstants.NOTIFICATIONSERVICE_SEND_MESSAGE;
                }
                attributes2.flags |= 524288;
                this.f7365c.getWindow().setAttributes(attributes2);
            }
            this.f7365c.setOnDismissListener(new DialogInterface.OnDismissListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f7371a;

                public void onDismiss(DialogInterface dialogInterface) {
                    if (!PatchProxy.proxy(new Object[]{dialogInterface}, this, f7371a, false, 2110, new Class[]{DialogInterface.class}, Void.TYPE).isSupported) {
                        SizeChoiceDialogActivity.this.finish();
                    }
                }
            });
            this.f7365c.setCanceledOnTouchOutside(true);
            this.f7365c.setCancelable(true);
            this.f7365c.show();
        }
    }

    /* renamed from: a */
    private void m7738a(Context context, String[] strArr, int i) {
        if (!PatchProxy.proxy(new Object[]{context, strArr, new Integer(i)}, this, f7363a, false, 2103, new Class[]{Context.class, String[].class, Integer.TYPE}, Void.TYPE).isSupported && this.f7366d == null) {
            Context a = ContextBuilder.m6349a(context, true, true);
            this.f7366d = LayoutInflater.from(context).inflate(R.layout.mz_video_size_choice_layout, (ViewGroup) null);
            ListView listView = (ListView) this.f7366d.findViewById(R.id.video_size_view);
            listView.setChoiceMode(1);
            final int dimensionPixelSize = a.getResources().getDimensionPixelSize(R.dimen.mz_setting_line_margin);
            new ListViewProxy(listView) {
                /* renamed from: b */
                public int[] mo16000b(int i) {
                    return new int[]{dimensionPixelSize, dimensionPixelSize};
                }
            }.mo15995a();
            listView.setAdapter(new C1770a(context, strArr, i));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    SizeChoiceDialogActivity.this.m7739a(adapterView, view, i, j);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7739a(AdapterView adapterView, View view, int i, long j) {
        Object[] objArr = {adapterView, view, new Integer(i), new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f7363a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2108, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE}, Void.TYPE).isSupported) {
            getIntent().putExtra("whichSize", i);
            setResult(-1, getIntent());
            this.f7365c.dismiss();
        }
    }

    public void onStart() {
        if (!PatchProxy.proxy(new Object[0], this, f7363a, false, MsgField.MSG_ID_TRACK_MODEL_CAN_DISAPPEARING, new Class[0], Void.TYPE).isSupported) {
            super.onStart();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            registerReceiver(this.f7368f, intentFilter);
        }
    }

    /* renamed from: a */
    public static void m7737a(Activity activity, boolean z, String[] strArr, int i) {
        Object[] objArr = {activity, new Byte(z ? (byte) 1 : 0), strArr, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f7363a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, MsgField.MSG_ID_TRACK_MSG_ID_TRACK_LOST, new Class[]{Activity.class, Boolean.TYPE, String[].class, Integer.TYPE}, Void.TYPE).isSupported) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(activity, SizeChoiceDialogActivity.class));
            intent.putExtra("isVideoSize", z);
            intent.putExtra("proportion", strArr);
            intent.putExtra("defaultItemId", i);
            activity.startActivityForResult(intent, 100001);
            activity.overridePendingTransition(0, 0);
        }
    }

    public void onPause() {
        if (!PatchProxy.proxy(new Object[0], this, f7363a, false, MsgField.IMSG_CLOUDAR_RECG_RESULT, new Class[0], Void.TYPE).isSupported) {
            super.onPause();
            unregisterReceiver(this.f7368f);
            if (this.f7365c != null) {
                this.f7365c.dismiss();
            }
            finish();
        }
    }

    public void finish() {
        if (!PatchProxy.proxy(new Object[0], this, f7363a, false, 2107, new Class[0], Void.TYPE).isSupported) {
            super.finish();
            overridePendingTransition(0, 0);
        }
    }

    /* renamed from: com.meizu.media.camera.SizeChoiceDialogActivity$a */
    private class C1770a extends BaseAdapter {

        /* renamed from: a */
        public static ChangeQuickRedirect f7377a;

        /* renamed from: c */
        private Context f7379c;

        /* renamed from: d */
        private String[] f7380d;

        /* renamed from: e */
        private int f7381e;

        public long getItemId(int i) {
            return (long) i;
        }

        public C1770a(Context context, String[] strArr, int i) {
            this.f7379c = context;
            this.f7380d = strArr;
            this.f7381e = i;
        }

        public int getCount() {
            return this.f7380d.length;
        }

        public Object getItem(int i) {
            return this.f7380d[i];
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1771a aVar;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), view, viewGroup}, this, f7377a, false, 2112, new Class[]{Integer.TYPE, View.class, ViewGroup.class}, View.class);
            if (proxy.isSupported) {
                return (View) proxy.result;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f7379c).inflate(R.layout.mz_video_size_choice_item, (ViewGroup) null, true);
                aVar = new C1771a(view);
                view.setTag(aVar);
            } else {
                aVar = (C1771a) view.getTag();
            }
            if (!this.f7380d[i].contains("4K") || !this.f7380d[i].contains("60fps")) {
                aVar.f7383b.setVisibility(8);
            } else {
                aVar.f7383b.setText(this.f7379c.getResources().getText(R.string.mz_setting_video_4k_60fps_limit));
                aVar.f7383b.setVisibility(0);
            }
            aVar.f7382a.setText(this.f7380d[i]);
            if (i == this.f7381e) {
                aVar.f7384c.setVisibility(0);
            } else {
                aVar.f7384c.setVisibility(4);
            }
            return view;
        }

        /* renamed from: com.meizu.media.camera.SizeChoiceDialogActivity$a$a */
        class C1771a {

            /* renamed from: a */
            TextView f7382a;

            /* renamed from: b */
            TextView f7383b;

            /* renamed from: c */
            ImageView f7384c;

            public C1771a(View view) {
                this.f7382a = (TextView) view.findViewById(R.id.mz_video_size_title);
                this.f7383b = (TextView) view.findViewById(R.id.mz_video_size_desc);
                this.f7384c = (ImageView) view.findViewById(R.id.mz_video_size_checked_view);
            }
        }
    }
}
