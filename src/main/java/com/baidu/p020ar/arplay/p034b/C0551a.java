package com.baidu.p020ar.arplay.p034b;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.util.Log;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.arplay.p032a.C0509a;
import com.baidu.p020ar.arplay.p032a.C0536d;
import com.baidu.p020ar.arplay.p032a.C0537e;
import com.baidu.p020ar.arplay.p032a.p033a.C0529a;
import com.baidu.p020ar.arplay.p032a.p033a.C0531c;
import com.baidu.p020ar.arplay.p032a.p033a.C0532d;
import com.baidu.p020ar.arplay.p032a.p033a.C0533e;
import com.baidu.p020ar.arplay.util.MsgParamsUtil;
import com.baidu.p020ar.arplay.util.NetStateReceiver;
import com.baidu.p020ar.arplay.webview.GLWebView;
import com.baidu.p020ar.arplay.webview.GLWebViewManager;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.util.HashMap;

/* renamed from: com.baidu.ar.arplay.b.a */
public class C0551a implements ARPMessage.MessageHandler {

    /* renamed from: a */
    private Context f740a;

    /* renamed from: b */
    private ARPEngine.C0572f f741b = new ARPEngine.C0572f() {
        /* renamed from: a */
        public void mo9086a(String str, int i, String str2, String str3) {
            SurfaceTexture c = C0537e.m1013a().mo9071c(str);
            if (c != null) {
                try {
                    if (C0537e.m1013a().mo9066b(str) != i) {
                        C0537e.m1013a().mo9065a(str, i);
                    }
                    c.updateTexImage();
                } catch (RuntimeException unused) {
                    C0537e.m1013a().mo9065a(str, i);
                }
            }
        }
    };

    public C0551a(Context context) {
        this.f740a = context.getApplicationContext();
        NetStateReceiver.m1156a(this.f740a);
        m1053c();
    }

    /* renamed from: a */
    private void m1046a(C0531c cVar) {
        m1048a("phone_call");
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + cVar.mo9025a()));
        if (intent.resolveActivity(this.f740a.getPackageManager()) != null) {
            this.f740a.startActivity(intent);
        }
    }

    /* renamed from: a */
    private void m1047a(C0532d dVar) {
        m1048a("vibrate");
        switch (dVar.mo9027a()) {
            case 0:
                C0536d.m1010a(this.f740a).mo9055a((long) dVar.mo9030b());
                return;
            case 1:
                long[] jArr = null;
                String[] split = dVar.mo9032c() != null ? dVar.mo9032c().split(SystemInfoUtil.COMMA) : null;
                if (split != null && split.length > 0) {
                    int length = split.length;
                    jArr = new long[length];
                    int i = 0;
                    while (i < length) {
                        try {
                            jArr[i] = Long.parseLong(split[i]);
                            i++;
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
                C0536d.m1010a(this.f740a).mo9056a(jArr);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m1048a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        handleMessage(1801, 0, hashMap);
    }

    /* renamed from: a */
    private void m1049a(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            String obj2String = MsgParamsUtil.obj2String(hashMap.get("event_name"), "");
            GLWebView.C0586a aVar = new GLWebView.C0586a();
            boolean z = true;
            if ("load_webview".equals(obj2String)) {
                aVar.f915a = MsgParamsUtil.obj2Int(hashMap.get("texture_id"), 0);
                aVar.f919e = MsgParamsUtil.obj2Int(hashMap.get("width"), 0);
                aVar.f920f = MsgParamsUtil.obj2Int(hashMap.get("height"), 0);
                aVar.f918d = MsgParamsUtil.obj2String(hashMap.get("url"), (String) null);
                if (MsgParamsUtil.obj2Int(hashMap.get("is_remote"), 0) != 1) {
                    z = false;
                }
                aVar.f916b = z;
                GLWebViewManager.getInstance().loadGLWebView(aVar);
            } else if ("update_webview_js".equals(obj2String)) {
                aVar.f915a = MsgParamsUtil.obj2Int(hashMap.get("texture_id"), 0);
                aVar.f917c = MsgParamsUtil.obj2String(hashMap.get("js_code"), (String) null);
                GLWebViewManager.getInstance().updateWebView(aVar);
            } else if ("load_native_webview".equals(obj2String)) {
                aVar.f918d = MsgParamsUtil.obj2String(hashMap.get("url"), (String) null);
                if (MsgParamsUtil.obj2Int(hashMap.get("is_remote"), 0) != 1) {
                    z = false;
                }
                aVar.f916b = z;
                GLWebViewManager.getInstance().loadNativeWebView(aVar);
            }
        }
    }

    /* renamed from: a */
    private void m1050a(HashMap<String, Object> hashMap, int i) {
        if (hashMap != null) {
            C0529a aVar = new C0529a();
            if (hashMap.get("url") != null) {
                aVar.mo9019b(MsgParamsUtil.obj2String(hashMap.get("url"), (String) null));
            }
            if (hashMap.get("delay") != null) {
                aVar.mo9013a(((Float) hashMap.get("delay")).floatValue());
            }
            if (hashMap.get("id") != null) {
                aVar.mo9016a(MsgParamsUtil.obj2String(hashMap.get("id"), (String) null));
            }
            if (hashMap.get("loop") != null) {
                int intValue = ((Integer) hashMap.get("loop")).intValue();
                aVar.mo9014a(intValue);
                if (intValue <= 0) {
                    aVar.mo9017a(true);
                }
            }
            if (hashMap.get("target") != null) {
                aVar.mo9021c(MsgParamsUtil.obj2String(hashMap.get("target"), (String) null));
            }
            if (hashMap.get("from_time") != null) {
                aVar.mo9015a((long) MsgParamsUtil.obj2Int(hashMap.get("from_time"), 0));
            }
            if (i == 1001) {
                C0509a.m918a().mo8987a(aVar, hashMap);
            } else if (i == 1003) {
                C0509a.m918a().mo8991b(aVar, hashMap);
            } else if (i == 1005) {
                C0509a.m918a().mo8994c(aVar, hashMap);
            } else if (i == 1007) {
                C0509a.m918a().mo8996d(aVar, hashMap);
            }
        }
    }

    /* renamed from: b */
    private void m1051b(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            C0532d dVar = new C0532d();
            if (hashMap.get("type") != null) {
                dVar.mo9028a(MsgParamsUtil.obj2Int(hashMap.get("type"), 0));
            }
            if (hashMap.get(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_INTERVAL) != null) {
                dVar.mo9031b(MsgParamsUtil.obj2Int(hashMap.get(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_INTERVAL), 0));
            }
            if (hashMap.get("pattern") != null) {
                dVar.mo9029a(MsgParamsUtil.obj2String(hashMap.get("pattern"), (String) null));
            }
            m1047a(dVar);
        }
    }

    /* renamed from: b */
    private void m1052b(HashMap<String, Object> hashMap, int i) {
        if (hashMap != null) {
            C0533e eVar = new C0533e();
            if (hashMap.get("url") != null) {
                eVar.mo9040b(MsgParamsUtil.obj2String(hashMap.get("url"), (String) null));
            }
            if (hashMap.get("id") != null) {
                eVar.mo9036a(MsgParamsUtil.obj2String(hashMap.get("id"), (String) null));
            }
            if (hashMap.get("texture_id") != null) {
                eVar.mo9034a(MsgParamsUtil.obj2Int(hashMap.get("texture_id"), -1));
            }
            if (hashMap.get("loop") != null) {
                int obj2Int = MsgParamsUtil.obj2Int(hashMap.get("loop"), 0);
                eVar.mo9039b(MsgParamsUtil.obj2Int(hashMap.get("loop"), 0));
                if (obj2Int <= 0) {
                    eVar.mo9037a(true);
                }
            }
            if (hashMap.get("target") != null) {
                eVar.mo9042c(MsgParamsUtil.obj2String(hashMap.get("target"), (String) null));
            }
            if (hashMap.get("from_time") != null) {
                eVar.mo9035a((long) MsgParamsUtil.obj2Int(hashMap.get("from_time"), 0));
                Log.e("VideoTest", "bean fromTime: " + eVar.mo9045f());
            }
            if (i == 1021) {
                C0537e.m1013a().mo9060a(eVar, hashMap);
            } else if (i == 1023) {
                C0537e.m1013a().mo9068b(eVar, hashMap);
            } else if (i == 1025) {
                C0537e.m1013a().mo9073c(eVar, hashMap);
            } else if (i == 1027) {
                C0537e.m1013a().mo9074d(eVar, hashMap);
            }
        }
    }

    /* renamed from: c */
    private void m1053c() {
        ARPEngine.getInstance().setVideoUpdateCallback(this.f741b);
    }

    /* renamed from: c */
    private void m1054c(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            C0531c cVar = new C0531c();
            Object obj = hashMap.get("number");
            if (obj != null) {
                cVar.mo9026a((String) obj);
            }
            m1046a(cVar);
        }
    }

    /* renamed from: a */
    public void mo9083a() {
        ARPMessage.getInstance().registerMessageHandler(0, this);
        ARPEngine.getInstance().initDataStore(this.f740a.getSharedPreferences("baiduar_lua_data_store", 0));
    }

    /* renamed from: b */
    public void mo9084b() {
        this.f741b = null;
        NetStateReceiver.m1160b(this.f740a);
    }

    public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
        switch (i) {
            case 0:
                if (i2 == -2) {
                    C0537e.m1013a().mo9067b();
                    C0509a.m918a().mo8988b();
                    return;
                }
                return;
            case 1001:
            case 1003:
            case ARPMessageType.MSG_TYPE_RESUME_MUSIC /*1005*/:
            case 1007:
                m1050a(hashMap, i);
                return;
            case 1021:
            case ARPMessageType.MSG_TYPE_VIDEO_PAUSE /*1023*/:
            case 1025:
            case ARPMessageType.MSG_TYPE_VIDEO_STOP /*1027*/:
                m1052b(hashMap, i);
                return;
            case 1401:
                m1054c(hashMap);
                return;
            case ARPMessageType.MSG_TYPE_VIBERATOR /*1501*/:
                m1051b(hashMap);
                return;
            case ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE /*1901*/:
                m1049a(hashMap);
                return;
            default:
                return;
        }
    }
}
