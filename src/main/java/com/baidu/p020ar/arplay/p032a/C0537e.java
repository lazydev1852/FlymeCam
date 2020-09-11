package com.baidu.p020ar.arplay.p032a;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.arplay.p032a.p033a.C0530b;
import com.baidu.p020ar.arplay.p032a.p033a.C0533e;
import com.baidu.p020ar.arplay.util.C0584a;
import com.baidu.p020ar.arplay.util.NetStateReceiver;
import com.baidu.p020ar.arplay.util.NetUtils;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.baidu.ar.arplay.a.e */
public class C0537e {

    /* renamed from: a */
    private static C0537e f704a;

    /* renamed from: b */
    private int f705b = 0;

    /* renamed from: c */
    private boolean f706c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ConcurrentHashMap<String, C0550b> f707d = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map<String, Integer> f708e = new Hashtable();

    /* renamed from: f */
    private Timer f709f;

    /* renamed from: g */
    private TimerTask f710g;

    /* renamed from: h */
    private C0584a f711h = new C0584a() {
        /* renamed from: a */
        public void mo9075a() {
            C0537e.this.mo9064a((C0549a) null, true);
        }

        /* renamed from: a */
        public void mo9076a(NetUtils.NetType netType) {
            C0537e.this.mo9070b((C0549a) null, true);
        }
    };

    /* renamed from: com.baidu.ar.arplay.a.e$a */
    public interface C0549a {
    }

    /* renamed from: com.baidu.ar.arplay.a.e$b */
    static class C0550b {

        /* renamed from: a */
        String f734a;

        /* renamed from: b */
        MediaPlayer f735b;

        /* renamed from: c */
        SurfaceTexture f736c;

        /* renamed from: d */
        int f737d;

        /* renamed from: e */
        boolean f738e = false;

        /* renamed from: f */
        C0530b f739f = new C0530b();

        C0550b() {
        }
    }

    private C0537e() {
        NetStateReceiver.m1157a(this.f711h);
    }

    /* renamed from: a */
    public static synchronized C0537e m1013a() {
        C0537e eVar;
        synchronized (C0537e.class) {
            if (f704a == null) {
                f704a = new C0537e();
            }
            eVar = f704a;
        }
        return eVar;
    }

    /* renamed from: a */
    private static void m1014a(C0530b bVar) {
        if (bVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", String.valueOf(bVar.f670a));
            hashMap.put("target", bVar.f671b);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("play_status", bVar.f676g);
            hashMap2.put("buffer_status", bVar.f677h);
            hashMap2.put("duration", String.valueOf(bVar.f672c));
            hashMap2.put("buffer_progress", String.valueOf(bVar.f678i));
            hashMap2.put("play_progress", String.valueOf((int) (bVar.f679j * 100.0f)));
            hashMap.put("msg_data", hashMap2);
            ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, hashMap);
        }
    }

    /* renamed from: a */
    private void m1015a(C0549a aVar, String str, String str2, int i, MediaPlayer.OnCompletionListener onCompletionListener, boolean z, String str3, final long j) {
        if (this.f707d.containsKey(str)) {
            C0550b bVar = this.f707d.get(str);
            if (bVar != null) {
                try {
                    if (bVar.f735b != null) {
                        bVar.f735b.reset();
                        bVar.f735b.setDataSource(str2);
                        bVar.f735b.setLooping(z);
                        bVar.f735b.setOnCompletionListener(onCompletionListener);
                        bVar.f735b.prepareAsync();
                        bVar.f734a = str2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            final C0550b bVar2 = new C0550b();
            bVar2.f734a = str2;
            bVar2.f735b = new MediaPlayer();
            bVar2.f735b.setDataSource(str2);
            bVar2.f737d = i;
            bVar2.f736c = new SurfaceTexture(i);
            bVar2.f739f.f670a = Long.valueOf(str).longValue();
            bVar2.f739f.f671b = str3;
            bVar2.f735b.setSurface(new Surface(bVar2.f736c));
            bVar2.f735b.setOnCompletionListener(onCompletionListener);
            bVar2.f735b.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    bVar2.f739f.f674e = "ERROR";
                    bVar2.f739f.f675f = i;
                    C0537e.m1019b(bVar2);
                    return true;
                }
            });
            bVar2.f735b.setLooping(z);
            bVar2.f735b.prepareAsync();
            bVar2.f735b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    C0537e.this.m1023d();
                    bVar2.f739f.f674e = "STATUS";
                    bVar2.f739f.f676g = "prepared";
                    C0537e.m1019b(bVar2);
                    try {
                        if (bVar2.f735b.getDuration() >= 0) {
                            if (((long) bVar2.f735b.getDuration()) > j) {
                                if (j >= 0) {
                                    bVar2.f735b.seekTo((int) j);
                                }
                            }
                            bVar2.f735b.seekTo(0);
                        }
                        bVar2.f735b.start();
                        bVar2.f739f.f676g = "playing";
                    } catch (Exception e) {
                        e.fillInStackTrace();
                    }
                }
            });
            bVar2.f735b.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                    bVar2.f739f.f674e = "INFO";
                    bVar2.f739f.f678i = i;
                    C0537e.m1019b(bVar2);
                }
            });
            bVar2.f735b.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                    String str;
                    C0530b bVar;
                    bVar2.f739f.f674e = "INFO";
                    switch (i) {
                        case 701:
                            bVar = bVar2.f739f;
                            str = "buffer_start";
                            break;
                        case 702:
                            bVar = bVar2.f739f;
                            str = "buffer_end";
                            break;
                        default:
                            return false;
                    }
                    bVar.f677h = str;
                    C0537e.m1019b(bVar2);
                    return false;
                }
            });
            if (this.f707d != null && str != null) {
                this.f707d.put(str, bVar2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m1019b(C0550b bVar) {
        if (bVar != null) {
            m1021c(bVar);
            m1014a(bVar.f739f);
            C0530b bVar2 = bVar.f739f;
            HashMap hashMap = new HashMap();
            hashMap.put("id", Integer.valueOf(ARPMessageType.MSG_TYPE_VIDEO));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("action_id", String.valueOf(bVar2.f670a));
            hashMap2.put("platform", "android");
            hashMap2.put("type", bVar2.f674e);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("error_code", Integer.valueOf(bVar2.f675f));
            hashMap3.put("buffer_status", bVar2.f677h);
            hashMap3.put("buffer_progress", Integer.valueOf(bVar2.f678i));
            hashMap3.put("play_status", bVar2.f676g);
            hashMap3.put("play_progress", Integer.valueOf((int) (bVar2.f679j * 100.0f)));
            hashMap2.put("data", hashMap3);
            hashMap.put("msg_data", hashMap2);
            ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    /* renamed from: c */
    private static void m1021c(C0550b bVar) {
        if (bVar != null && bVar.f735b != null) {
            C0530b bVar2 = bVar.f739f;
            if (bVar2.f676g == "playing" || bVar2.f676g == "paused") {
                try {
                    bVar2.f672c = bVar.f735b.getDuration();
                    if (bVar2.f672c <= 0) {
                        bVar2.f679j = 0.0f;
                    } else {
                        bVar2.f679j = (((float) bVar.f735b.getCurrentPosition()) * 1.0f) / ((float) bVar2.f672c);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (bVar2.f676g == "finished") {
                bVar2.f679j = 1.0f;
            }
            if (bVar2.f679j > 1.0f) {
                bVar2.f679j = 1.0f;
            }
            if (bVar2.f679j < 0.0f) {
                bVar2.f679j = 0.0f;
            }
        }
    }

    /* renamed from: d */
    private MediaPlayer m1022d(String str) {
        if (this.f707d == null || this.f707d.get(str) == null) {
            return null;
        }
        return this.f707d.get(str).f735b;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m1023d() {
        if (this.f709f == null) {
            this.f709f = new Timer();
            this.f710g = new TimerTask() {
                public void run() {
                    C0550b bVar;
                    if (C0537e.this.f707d != null) {
                        for (Map.Entry entry : C0537e.this.f707d.entrySet()) {
                            if (!(entry == null || (bVar = (C0550b) entry.getValue()) == null || bVar.f739f == null || bVar.f739f.f676g != "playing")) {
                                C0537e.m1019b((C0550b) entry.getValue());
                            }
                        }
                    }
                }
            };
            this.f709f.scheduleAtFixedRate(this.f710g, 0, 200);
        }
    }

    /* renamed from: e */
    private static void m1024e() {
        f704a = null;
    }

    /* renamed from: e */
    private void m1025e(String str) {
        if (this.f707d != null && this.f707d.get(str) != null) {
            this.f707d.remove(str);
        }
    }

    /* renamed from: a */
    public int mo9057a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: a */
    public C0550b mo9058a(String str) {
        if (this.f707d != null) {
            return this.f707d.get(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo9059a(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    /* renamed from: a */
    public void mo9060a(final C0533e eVar, final HashMap<String, Object> hashMap) {
        if (eVar.mo9043d() > 1) {
            this.f708e.put(eVar.mo9033a(), Integer.valueOf(eVar.mo9043d()));
        }
        mo9059a((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_RES, hashMap);
        mo9062a((C0549a) new C0549a() {
        }, eVar.mo9033a(), eVar.mo9041c(), (MediaPlayer.OnCompletionListener) new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                int a;
                if (C0537e.this.f708e != null && eVar != null) {
                    C0550b a2 = C0537e.this.mo9058a(eVar.mo9033a());
                    if (a2 != null) {
                        a2.f739f.f674e = "STATUS";
                        a2.f739f.f676g = "finished";
                        C0537e.m1019b(a2);
                        if (eVar.mo9044e()) {
                            C0537e.this.mo9060a(eVar, (HashMap<String, Object>) hashMap);
                            return;
                        }
                    }
                    if (C0537e.this.f708e.size() <= 0 || (a = C0537e.this.mo9057a((Map<String, Integer>) C0537e.this.f708e, eVar.mo9033a())) <= 1) {
                        C0537e.this.mo9059a((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_FINISH, (HashMap<String, Object>) hashMap);
                        return;
                    }
                    int i = a - 1;
                    C0537e.this.f708e.put(eVar.mo9033a(), Integer.valueOf(i));
                    eVar.mo9039b(i);
                    C0537e.this.mo9060a(eVar, (HashMap<String, Object>) hashMap);
                }
            }
        }, eVar.mo9038b(), eVar.mo9043d(), eVar.mo9046g(), eVar.mo9045f());
    }

    /* renamed from: a */
    public void mo9061a(C0549a aVar, String str) {
        C0550b a = mo9058a(str);
        if (a != null) {
            a.f739f.f674e = "STATUS";
            a.f739f.f676g = "unstarted";
            m1019b(a);
        }
        MediaPlayer d = m1022d(str);
        if (d != null) {
            C0509a.m920a(d);
            m1025e(str);
        }
    }

    /* renamed from: a */
    public void mo9062a(C0549a aVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, int i2, String str3, long j) {
        m1015a(aVar, str, str2, i, onCompletionListener, false, str3, j);
    }

    /* renamed from: a */
    public void mo9063a(C0549a aVar, String str, boolean z) {
        MediaPlayer d = m1022d(str);
        if (d != null) {
            try {
                if (d.isPlaying()) {
                    C0550b a = mo9058a(str);
                    if (a != null) {
                        a.f739f.f674e = "STATUS";
                        a.f739f.f676g = "paused";
                        a.f738e = z;
                        m1019b(a);
                    }
                    d.pause();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo9064a(C0549a aVar, boolean z) {
        if (this.f707d != null) {
            for (Map.Entry<String, C0550b> key : this.f707d.entrySet()) {
                mo9063a(aVar, (String) key.getKey(), z);
            }
        }
    }

    /* renamed from: a */
    public void mo9065a(String str, int i) {
        C0550b bVar = this.f707d.get(str);
        if (bVar != null) {
            bVar.f736c = new SurfaceTexture(i);
            try {
                bVar.f735b.setSurface(new Surface(bVar.f736c));
            } catch (Exception unused) {
                Log.i("VideoPlayerManager", "MediaPlayer setSurface failed.");
            }
            bVar.f737d = i;
        }
    }

    /* renamed from: b */
    public int mo9066b(String str) {
        C0550b a = mo9058a(str);
        if (a != null) {
            return a.f737d;
        }
        return 0;
    }

    /* renamed from: b */
    public void mo9067b() {
        if (this.f707d != null) {
            for (Map.Entry next : this.f707d.entrySet()) {
                if (next != null) {
                    mo9061a((C0549a) null, (String) next.getKey());
                    ((C0550b) next.getValue()).f736c = null;
                    ((C0550b) next.getValue()).f739f.f674e = "STATUS";
                    ((C0550b) next.getValue()).f739f.f676g = "unstarted";
                    ((C0550b) next.getValue()).f738e = false;
                    m1019b((C0550b) next.getValue());
                    MediaPlayer mediaPlayer = ((C0550b) next.getValue()).f735b;
                    if (mediaPlayer != null) {
                        try {
                            mediaPlayer.release();
                        } catch (Exception unused) {
                            System.out.println("player release Exception");
                        }
                    }
                }
            }
            this.f707d.clear();
        }
    }

    /* renamed from: b */
    public void mo9068b(C0533e eVar, final HashMap<String, Object> hashMap) {
        mo9059a(1024, hashMap);
        mo9063a(new C0549a() {
        }, eVar.mo9033a(), false);
    }

    /* renamed from: b */
    public void mo9069b(C0549a aVar, String str) {
        MediaPlayer d = m1022d(str);
        C0550b a = mo9058a(str);
        if (d != null && a != null && a.f739f.f676g == "paused") {
            d.start();
            a.f739f.f674e = "STATUS";
            a.f739f.f676g = "playing";
            m1019b(a);
        }
    }

    /* renamed from: b */
    public void mo9070b(C0549a aVar, boolean z) {
        if (this.f707d != null) {
            for (Map.Entry next : this.f707d.entrySet()) {
                if (!z || !(next == null || next.getValue() == null || !((C0550b) next.getValue()).f738e)) {
                    mo9069b(aVar, (String) next.getKey());
                }
            }
        }
    }

    /* renamed from: c */
    public SurfaceTexture mo9071c(String str) {
        C0550b bVar;
        if (this.f707d == null || (bVar = this.f707d.get(str)) == null) {
            return null;
        }
        return bVar.f736c;
    }

    /* renamed from: c */
    public void mo9072c() {
        if (this.f709f != null) {
            this.f709f.cancel();
            this.f709f.purge();
            this.f709f = null;
            if (this.f710g != null) {
                this.f710g.cancel();
                this.f710g = null;
            }
        }
        NetStateReceiver.m1161b(this.f711h);
        mo9067b();
        m1024e();
    }

    /* renamed from: c */
    public void mo9073c(C0533e eVar, final HashMap<String, Object> hashMap) {
        mo9059a((int) ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, hashMap);
        mo9069b((C0549a) new C0549a() {
        }, eVar.mo9033a());
    }

    /* renamed from: d */
    public void mo9074d(C0533e eVar, final HashMap<String, Object> hashMap) {
        mo9059a((int) ARPMessageType.MSG_TYPE_VIDEO_STOP_RES, hashMap);
        mo9061a((C0549a) new C0549a() {
        }, eVar.mo9033a());
    }
}
