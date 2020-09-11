package com.baidu.p020ar.msghandler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.arplay.util.MsgParamsUtil;
import com.baidu.p020ar.bean.DialogBean;
import com.baidu.p020ar.bean.ToastBean;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;

/* renamed from: com.baidu.ar.msghandler.b */
public class C0804b implements C0811d {

    /* renamed from: a */
    private Context f1886a;

    /* renamed from: b */
    private Handler f1887b = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            Bundle data;
            if (message != null && (message.obj instanceof Context) && (data = message.getData()) != null) {
                switch (message.what) {
                    case 1:
                        C0804b.this.mo10281a((Context) message.obj, (DialogBean) data.get("bean"));
                        return;
                    case 2:
                        C0804b.this.mo10282a((Context) message.obj, (ToastBean) data.get("bean"));
                        return;
                    default:
                        return;
                }
            }
        }
    };

    public C0804b(Context context) {
        this.f1886a = context;
    }

    /* renamed from: a */
    private void m2113a(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            DialogBean dialogBean = new DialogBean();
            if (hashMap.get(NotificationCompat.CATEGORY_MESSAGE) != null) {
                dialogBean.mo9608a(MsgParamsUtil.obj2String(hashMap.get(NotificationCompat.CATEGORY_MESSAGE), (String) null));
            }
            if (hashMap.get(PushConstants.TITLE) != null) {
                dialogBean.mo9610b(MsgParamsUtil.obj2String(hashMap.get(PushConstants.TITLE), (String) null));
            }
            if (hashMap.get("confirm_text") != null) {
                dialogBean.mo9612c(MsgParamsUtil.obj2String(hashMap.get("confirm_text"), (String) null));
            }
            if (hashMap.get("cancel_text") != null) {
                dialogBean.mo9614d(MsgParamsUtil.obj2String(hashMap.get("cancel_text"), (String) null));
            }
            if (hashMap.get("key") != null) {
                dialogBean.mo9616e(MsgParamsUtil.obj2String(hashMap.get("key"), (String) null));
            }
            mo10281a(this.f1886a, dialogBean);
        }
    }

    /* renamed from: b */
    private void m2114b(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            ToastBean toastBean = new ToastBean();
            if (hashMap.get(NotificationCompat.CATEGORY_MESSAGE) != null) {
                toastBean.mo9656a(MsgParamsUtil.obj2String(hashMap.get(NotificationCompat.CATEGORY_MESSAGE), (String) null));
            }
            if (hashMap.get("key") != null) {
                toastBean.mo9657b(MsgParamsUtil.obj2String(hashMap.get("key"), (String) null));
            }
            mo10282a(this.f1886a, toastBean);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10281a(Context context, final DialogBean dialogBean) {
        if (dialogBean != null && context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(dialogBean.mo9609b());
            builder.setMessage(dialogBean.mo9607a());
            builder.setPositiveButton(dialogBean.mo9611c(), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("id", Integer.valueOf(ComponentMessageType.MSG_TYPE_DIALOG_RESULT));
                    hashMap.put("result", "confirm");
                    hashMap.put("key", dialogBean.mo9615e());
                    ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
                }
            });
            builder.setNegativeButton(dialogBean.mo9613d(), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("id", Integer.valueOf(ComponentMessageType.MSG_TYPE_DIALOG_RESULT));
                    hashMap.put("result", "cancel");
                    hashMap.put("key", dialogBean.mo9615e());
                    ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
                }
            });
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            try {
                create.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10282a(Context context, ToastBean toastBean) {
        if (toastBean != null && context != null) {
            try {
                Toast makeText = Toast.makeText(context, toastBean.mo9655a(), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void parseComponentData(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            int obj2Int = MsgParamsUtil.obj2Int(hashMap.get("id"), 0);
            if (obj2Int == 21111) {
                m2113a(hashMap);
            } else if (obj2Int == 21113) {
                m2114b(hashMap);
            }
        }
    }

    public void release() {
        this.f1886a = null;
        this.f1887b.removeCallbacksAndMessages((Object) null);
    }
}
