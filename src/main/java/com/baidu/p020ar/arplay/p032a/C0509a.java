package com.baidu.p020ar.arplay.p032a;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.arplay.p032a.p033a.C0529a;
import com.baidu.p020ar.arplay.p032a.p033a.C0530b;
import com.baidu.p020ar.arplay.util.MsgParamsUtil;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.baidu.ar.arplay.a.a */
public final class C0509a {

    /* renamed from: a */
    private static C0509a f619a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static ConcurrentHashMap<String, C0524a> f620d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static HandlerThread f621e;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static Handler f622g = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static C0525b f623h;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static Map<String, Integer> f624j;

    /* renamed from: k */
    private static Timer f625k;

    /* renamed from: l */
    private static TimerTask f626l;

    /* renamed from: m */
    private static Runnable f627m = new Runnable() {
        public void run() {
            if (C0509a.f621e != null) {
                C0509a.f621e.quit();
                HandlerThread unused = C0509a.f621e = null;
            }
        }
    };

    /* renamed from: b */
    private int f628b = 0;

    /* renamed from: c */
    private boolean f629c = false;

    /* renamed from: f */
    private Handler f630f;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Map<String, Integer> f631i;

    /* renamed from: n */
    private Handler.Callback f632n = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (!ARPEngine.getInstance().isCaseCreated()) {
                return false;
            }
            switch (message.what) {
                case 3004:
                    C0509a.this.mo8982a(message);
                    break;
                case ComponentMessageType.MSG_TYPE_LOGO_START /*3005*/:
                    C0509a.this.mo8989b(message);
                    break;
                case ComponentMessageType.MSG_TYPE_LOGO_STOP /*3006*/:
                    C0509a.this.mo8993c(message);
                    break;
                case ComponentMessageType.MSG_TYPE_LOGO_HIT /*3007*/:
                    C0509a.this.mo8995d(message);
                    break;
                case 3008:
                    C0509a.this.mo8997e(message);
                    break;
            }
            return false;
        }
    };

    /* renamed from: com.baidu.ar.arplay.a.a$a */
    static class C0524a {

        /* renamed from: a */
        MediaPlayer f656a;

        /* renamed from: b */
        C0530b f657b = new C0530b();

        C0524a() {
        }
    }

    /* renamed from: com.baidu.ar.arplay.a.a$b */
    public interface C0525b {
        /* renamed from: a */
        void mo9003a(Exception exc);

        /* renamed from: a */
        void mo9004a(boolean z);
    }

    /* renamed from: com.baidu.ar.arplay.a.a$c */
    class C0526c implements C0525b {
        C0526c(C0525b bVar) {
            C0525b unused = C0509a.f623h = bVar;
        }

        /* renamed from: a */
        public void mo9003a(final Exception exc) {
            if (C0509a.f623h != null) {
                C0509a.f622g.post(new Runnable() {
                    public void run() {
                        if (C0509a.f623h != null) {
                            C0509a.f623h.mo9003a(exc);
                        }
                    }
                });
            }
        }

        /* renamed from: a */
        public void mo9004a(final boolean z) {
            if (C0509a.f623h != null) {
                C0509a.f622g.post(new Runnable() {
                    public void run() {
                        if (C0509a.f623h != null) {
                            C0509a.f623h.mo9004a(z);
                        }
                    }
                });
            }
        }
    }

    private C0509a() {
        synchronized (C0509a.class) {
            if (f621e == null) {
                f621e = new HandlerThread("MediaPlayerThread");
                f621e.start();
            } else {
                f622g.removeCallbacks(f627m);
            }
        }
        this.f630f = new Handler(f621e.getLooper(), this.f632n);
        this.f631i = new Hashtable();
        f624j = new Hashtable();
    }

    /* renamed from: a */
    public static int m914a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: a */
    private C0524a m916a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        try {
            final C0524a aVar = new C0524a();
            MediaPlayer mediaPlayer = new MediaPlayer();
            aVar.f656a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            if (onCompletionListener == null) {
                onCompletionListener = new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                    }
                };
            }
            mediaPlayer.setOnCompletionListener(onCompletionListener);
            if (onErrorListener == null) {
                onErrorListener = new MediaPlayer.OnErrorListener() {
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        aVar.f657b.f674e = "ERROR";
                        aVar.f657b.f675f = i;
                        C0509a.m925b(aVar);
                        return false;
                    }
                };
            }
            mediaPlayer.setOnErrorListener(onErrorListener);
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static C0524a m917a(final C0524a aVar, final String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, final long j) {
        if ((TextUtils.isEmpty(str2) && assetFileDescriptor == null) || aVar == null) {
            return aVar;
        }
        aVar.f657b.f670a = MsgParamsUtil.obj2Long(str, 0);
        aVar.f657b.f673d = str;
        aVar.f657b.f671b = str3;
        MediaPlayer mediaPlayer = aVar.f656a;
        if (onCompletionListener != null) {
            mediaPlayer.setOnCompletionListener(onCompletionListener);
        }
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.seekTo(0);
                mediaPlayer.stop();
            }
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.reset();
            if (!TextUtils.isEmpty(str2)) {
                mediaPlayer.setDataSource(str2);
            } else if (assetFileDescriptor != null) {
                mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            }
            mediaPlayer.prepareAsync();
            mediaPlayer.setLooping(false);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    MediaPlayer mediaPlayer2;
                    int i;
                    aVar.f657b.f674e = "STATUS";
                    aVar.f657b.f676g = "prepared";
                    C0509a.m925b(aVar);
                    if (!ARPEngine.getInstance().isAppBackground() && C0509a.f624j != null && C0509a.f624j.get(str) != null) {
                        if (((Integer) C0509a.f624j.get(str)).intValue() == 3004 || ((Integer) C0509a.f624j.get(str)).intValue() == 3007) {
                            C0509a.m935j();
                            if (aVar.f656a.getDuration() >= 0) {
                                if (((long) aVar.f656a.getDuration()) <= j || j < 0) {
                                    mediaPlayer2 = aVar.f656a;
                                    i = 0;
                                } else {
                                    mediaPlayer2 = aVar.f656a;
                                    i = (int) j;
                                }
                                mediaPlayer2.seekTo(i);
                            }
                            aVar.f656a.start();
                            aVar.f657b.f676g = "playing";
                        }
                    }
                }
            });
            aVar.f656a.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                    aVar.f657b.f674e = "INFO";
                    aVar.f657b.f678i = i;
                    C0509a.m925b(aVar);
                }
            });
            aVar.f656a.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                    String str;
                    C0530b bVar;
                    aVar.f657b.f674e = "INFO";
                    switch (i) {
                        case 701:
                            bVar = aVar.f657b;
                            str = "buffer_start";
                            break;
                        case 702:
                            bVar = aVar.f657b;
                            str = "buffer_end";
                            break;
                        default:
                            return false;
                    }
                    bVar.f677h = str;
                    C0509a.m925b(aVar);
                    return false;
                }
            });
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return aVar;
    }

    /* renamed from: a */
    public static synchronized C0509a m918a() {
        C0509a aVar;
        synchronized (C0509a.class) {
            if (f619a == null) {
                f619a = new C0509a();
            }
            aVar = f619a;
        }
        return aVar;
    }

    /* renamed from: a */
    public static void m920a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m922a(C0525b bVar, String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener, int i, String str3, long j) {
        C0525b bVar2 = bVar;
        String str4 = str;
        MediaPlayer.OnCompletionListener onCompletionListener2 = onCompletionListener;
        MediaPlayer.OnErrorListener onErrorListener2 = onErrorListener;
        try {
            C0524a a = mo8980a(str4, onCompletionListener2, onErrorListener2);
            if (a != null) {
                m917a(a, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
            }
            if (bVar2 != null) {
                bVar2.mo9004a(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C0524a a2 = mo8979a(str4);
            mo8992b(str4);
            try {
                if (a2.f656a != null) {
                    a2.f656a.release();
                }
                try {
                    C0524a a3 = m918a().mo8980a(str4, onCompletionListener2, onErrorListener2);
                    if (a3 != null) {
                        m917a(a3, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
                    }
                    if (bVar2 != null) {
                        bVar2.mo9004a(true);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (bVar2 != null) {
                        bVar2.mo9003a(e2);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (bVar2 != null) {
                    bVar2.mo9003a(e3);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m923a(C0530b bVar) {
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
            ARPMessage.getInstance().sendMessage(1011, hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m925b(C0524a aVar) {
        if (aVar != null) {
            m928c(aVar);
            m923a(aVar.f657b);
            C0530b bVar = aVar.f657b;
            HashMap hashMap = new HashMap();
            hashMap.put("id", Integer.valueOf(ARPMessageType.MSG_TYPE_AUDIO));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("action_id", String.valueOf(bVar.f670a));
            hashMap2.put("platform", "android");
            hashMap2.put("type", bVar.f674e);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("error_code", Integer.valueOf(bVar.f675f));
            hashMap3.put("buffer_status", bVar.f677h);
            hashMap3.put("buffer_progress", Integer.valueOf(bVar.f678i));
            hashMap3.put("play_status", bVar.f676g);
            hashMap3.put("play_progress", Integer.valueOf((int) (bVar.f679j * 100.0f)));
            hashMap2.put("data", hashMap3);
            hashMap.put("msg_data", hashMap2);
            ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    /* renamed from: b */
    private void m926b(C0525b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        C0525b bVar2 = bVar;
        String str4 = str;
        C0524a a = mo8979a(str);
        mo8992b(str);
        if (a != null) {
            try {
                if (a.f656a != null) {
                    a.f656a.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (bVar2 != null) {
                    bVar.mo9003a(e);
                    return;
                }
                return;
            }
        }
        try {
            C0524a a2 = mo8980a(str, onCompletionListener, (MediaPlayer.OnErrorListener) null);
            if (a2 != null) {
                m917a(a2, str, str2, (AssetFileDescriptor) null, onCompletionListener, i, str3, j);
            }
            if (bVar2 != null) {
                bVar.mo9004a(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (bVar2 != null) {
                bVar.mo9003a(e2);
            }
        }
    }

    /* renamed from: c */
    public static synchronized void m927c() {
        synchronized (C0509a.class) {
            if (f619a != null) {
                f619a.mo8988b();
            }
            f619a = null;
            f622g.postDelayed(f627m, 10000);
            if (f623h != null) {
                f623h = null;
            }
        }
    }

    /* renamed from: c */
    private static void m928c(C0524a aVar) {
        if (aVar != null && aVar.f656a != null) {
            C0530b bVar = aVar.f657b;
            if (bVar.f676g == "playing" || bVar.f676g == "paused") {
                try {
                    bVar.f672c = aVar.f656a.getDuration();
                    if (bVar.f672c <= 0) {
                        bVar.f679j = 0.0f;
                    } else {
                        bVar.f679j = (((float) aVar.f656a.getCurrentPosition()) * 1.0f) / ((float) bVar.f672c);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (bVar.f676g == "finished") {
                bVar.f679j = 1.0f;
            }
            if (bVar.f679j > 1.0f) {
                bVar.f679j = 1.0f;
            }
            if (bVar.f679j < 0.0f) {
                bVar.f679j = 0.0f;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static synchronized void m935j() {
        synchronized (C0509a.class) {
            if (f625k == null) {
                f625k = new Timer();
                f626l = new TimerTask() {
                    public void run() {
                        C0524a aVar;
                        if (C0509a.f620d != null) {
                            for (Map.Entry entry : C0509a.f620d.entrySet()) {
                                if (!(entry == null || (aVar = (C0524a) entry.getValue()) == null || aVar.f657b == null || aVar.f657b.f676g != "playing")) {
                                    C0509a.m925b((C0524a) entry.getValue());
                                }
                            }
                        }
                    }
                };
                f625k.scheduleAtFixedRate(f626l, 0, 200);
            }
        }
    }

    /* renamed from: a */
    public C0524a mo8979a(String str) {
        if (f620d == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return f620d.get(str);
    }

    /* renamed from: a */
    public C0524a mo8980a(String str, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f620d != null && f620d.containsKey(str)) {
            return f620d.get(str);
        }
        C0524a a = m916a(onCompletionListener, onErrorListener);
        if (a == null) {
            return null;
        }
        if (f620d == null) {
            f620d = new ConcurrentHashMap<>();
        }
        f620d.put(str, a);
        return a;
    }

    /* renamed from: a */
    public void mo8981a(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    /* renamed from: a */
    public void mo8982a(Message message) {
        Object[] objArr = (Object[]) message.obj;
        String str = (String) objArr[1];
        long longValue = ((Long) objArr[6]).longValue();
        f624j.put(str, 3004);
        m922a((C0525b) objArr[0], str, (String) objArr[2], (AssetFileDescriptor) null, (MediaPlayer.OnCompletionListener) objArr[3], (MediaPlayer.OnErrorListener) null, ((Integer) objArr[4]).intValue(), (String) objArr[5], longValue);
    }

    /* renamed from: a */
    public void mo8983a(C0525b bVar) {
        Message obtainMessage = this.f630f.obtainMessage(3008);
        obtainMessage.obj = new Object[]{new C0526c(bVar)};
        obtainMessage.sendToTarget();
    }

    /* renamed from: a */
    public void mo8984a(C0525b bVar, String str) {
        Message obtainMessage = this.f630f.obtainMessage(ComponentMessageType.MSG_TYPE_LOGO_STOP);
        obtainMessage.obj = new Object[]{new C0526c(bVar), str};
        obtainMessage.sendToTarget();
    }

    /* renamed from: a */
    public void mo8985a(C0525b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i) {
        Message obtainMessage = this.f630f.obtainMessage(ComponentMessageType.MSG_TYPE_LOGO_HIT);
        obtainMessage.obj = new Object[]{new C0526c(bVar), str, str2, onCompletionListener, Integer.valueOf(i)};
        obtainMessage.sendToTarget();
    }

    /* renamed from: a */
    public void mo8986a(C0525b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        Message obtainMessage = this.f630f.obtainMessage(3004);
        obtainMessage.obj = new Object[]{new C0526c(bVar), str, str2, onCompletionListener, Integer.valueOf(i), str3, Long.valueOf(j)};
        obtainMessage.sendToTarget();
    }

    /* renamed from: a */
    public void mo8987a(final C0529a aVar, final HashMap<String, Object> hashMap) {
        if (aVar.mo9018b() > 1) {
            this.f631i.put(aVar.mo9012a(), Integer.valueOf(aVar.mo9018b()));
        }
        mo8981a(1002, hashMap);
        mo8986a(new C0525b() {
            /* renamed from: a */
            public void mo9003a(Exception exc) {
                C0509a.this.mo8981a(1010, (HashMap<String, Object>) hashMap);
            }

            /* renamed from: a */
            public void mo9004a(boolean z) {
            }
        }, aVar.mo9012a(), aVar.mo9020c(), new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                int a;
                if (C0509a.this.f631i != null) {
                    C0524a a2 = C0509a.this.mo8979a(aVar.mo9012a());
                    if (a2 == null || a2.f657b.f676g != "paused") {
                        if (a2 != null) {
                            a2.f657b.f674e = "STATUS";
                            a2.f657b.f676g = "finished";
                            C0509a.m925b(a2);
                            if (aVar.mo9024f()) {
                                C0509a.this.mo8987a(aVar, (HashMap<String, Object>) hashMap);
                                return;
                            }
                        }
                        if (C0509a.this.f631i.size() <= 0 || (a = C0509a.m914a((Map<String, Integer>) C0509a.this.f631i, aVar.mo9012a())) <= 1) {
                            C0509a.this.mo8981a(1009, (HashMap<String, Object>) hashMap);
                            return;
                        }
                        C0509a.this.mo8987a(aVar, (HashMap<String, Object>) hashMap);
                        int i = a - 1;
                        C0509a.this.f631i.put(aVar.mo9012a(), Integer.valueOf(i));
                        aVar.mo9014a(i);
                    }
                }
            }
        }, aVar.mo9018b(), aVar.mo9023e(), aVar.mo9022d());
    }

    /* renamed from: b */
    public void mo8988b() {
        if (f625k != null) {
            f625k.cancel();
            f625k.purge();
            f625k = null;
            f626l.cancel();
            f626l = null;
        }
        if (f624j != null) {
            f624j.clear();
        }
        if (f620d != null) {
            try {
                for (C0524a next : f620d.values()) {
                    next.f657b.f674e = "STATUS";
                    next.f657b.f676g = "unstarted";
                    m920a(next.f656a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (f620d != null) {
                f620d.clear();
            }
        }
        if (this.f631i != null) {
            this.f631i.clear();
        }
    }

    /* renamed from: b */
    public void mo8989b(Message message) {
        Object[] objArr = (Object[]) message.obj;
        C0525b bVar = (C0525b) objArr[0];
        String str = (String) objArr[1];
        f624j.put(str, Integer.valueOf(ComponentMessageType.MSG_TYPE_LOGO_START));
        C0524a a = mo8979a(str);
        if (a != null) {
            try {
                a.f657b.f674e = "STATUS";
                a.f657b.f676g = "unstarted";
                m925b(a);
                m920a(a.f656a);
                a.f656a = null;
                mo8992b(str);
            } catch (Exception e) {
                e.printStackTrace();
                if (bVar != null) {
                    bVar.mo9003a(e);
                    return;
                }
                return;
            }
        }
        if (bVar != null) {
            bVar.mo9004a(true);
        }
    }

    /* renamed from: b */
    public void mo8990b(C0525b bVar, String str) {
        Message obtainMessage = this.f630f.obtainMessage(ComponentMessageType.MSG_TYPE_LOGO_START);
        obtainMessage.obj = new Object[]{new C0526c(bVar), str};
        obtainMessage.sendToTarget();
    }

    /* renamed from: b */
    public void mo8991b(C0529a aVar, final HashMap<String, Object> hashMap) {
        mo8981a(1004, hashMap);
        mo8984a((C0525b) new C0525b() {
            /* renamed from: a */
            public void mo9003a(Exception exc) {
                C0509a.this.mo8981a(1010, (HashMap<String, Object>) hashMap);
            }

            /* renamed from: a */
            public void mo9004a(boolean z) {
            }
        }, aVar.mo9012a());
    }

    /* renamed from: b */
    public void mo8992b(String str) {
        if (f620d != null && !TextUtils.isEmpty(str) && f620d.containsKey(str)) {
            f620d.remove(str);
        }
    }

    /* renamed from: c */
    public void mo8993c(Message message) {
        Object[] objArr = (Object[]) message.obj;
        C0525b bVar = (C0525b) objArr[0];
        String str = (String) objArr[1];
        f624j.put(str, Integer.valueOf(ComponentMessageType.MSG_TYPE_LOGO_STOP));
        try {
            C0524a a = mo8979a(str);
            if (!(a.f656a == null || a.f657b.f676g == "unstarted" || !a.f656a.isPlaying())) {
                a.f657b.f674e = "STATUS";
                a.f657b.f676g = "paused";
                m925b(a);
                a.f656a.pause();
            }
            if (bVar != null) {
                bVar.mo9004a(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (bVar != null) {
                bVar.mo9003a(e);
            }
        }
    }

    /* renamed from: c */
    public void mo8994c(final C0529a aVar, final HashMap<String, Object> hashMap) {
        mo8981a(1006, hashMap);
        mo8985a(new C0525b() {
            /* renamed from: a */
            public void mo9003a(Exception exc) {
                C0509a.this.mo8981a(1010, (HashMap<String, Object>) hashMap);
            }

            /* renamed from: a */
            public void mo9004a(boolean z) {
            }
        }, aVar.mo9012a(), aVar.mo9020c(), new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                int a;
                if (C0509a.this.f631i != null) {
                    C0524a a2 = C0509a.this.mo8979a(aVar.mo9012a());
                    if (a2 != null) {
                        a2.f657b.f674e = "STATUS";
                        a2.f657b.f676g = "finished";
                        C0509a.m925b(a2);
                        if (aVar.mo9024f()) {
                            C0509a.this.mo8987a(aVar, (HashMap<String, Object>) hashMap);
                            return;
                        }
                    }
                    if (C0509a.this.f631i.size() <= 0 || (a = C0509a.m914a((Map<String, Integer>) C0509a.this.f631i, aVar.mo9012a())) <= 1) {
                        C0509a.this.mo8981a(1009, (HashMap<String, Object>) hashMap);
                        return;
                    }
                    C0509a.this.mo8987a(aVar, (HashMap<String, Object>) hashMap);
                    int i = a - 1;
                    C0509a.this.f631i.put(aVar.mo9012a(), Integer.valueOf(i));
                    aVar.mo9014a(i);
                }
            }
        }, aVar.mo9018b());
    }

    /* renamed from: d */
    public void mo8995d(Message message) {
        long j;
        String str;
        Object[] objArr = (Object[]) message.obj;
        if (objArr.length >= 5) {
            C0525b bVar = (C0525b) objArr[0];
            String str2 = (String) objArr[1];
            String str3 = (String) objArr[2];
            MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) objArr[3];
            int intValue = ((Integer) objArr[4]).intValue();
            if (objArr.length > 6) {
                j = ((Long) objArr[6]).longValue();
                str = (String) objArr[5];
            } else {
                j = 0;
                str = null;
            }
            f624j.put(str2, Integer.valueOf(ComponentMessageType.MSG_TYPE_LOGO_HIT));
            try {
                C0524a a = mo8979a(str2);
                if (!(a == null || a.f656a.isPlaying() || a.f657b.f676g == "unstarted")) {
                    a.f657b.f674e = "STATUS";
                    a.f657b.f676g = "playing";
                    m925b(a);
                    a.f656a.start();
                }
                if (bVar != null) {
                    bVar.mo9004a(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                m926b(bVar, str2, str3, onCompletionListener, intValue, str, j);
            }
        }
    }

    /* renamed from: d */
    public void mo8996d(C0529a aVar, final HashMap<String, Object> hashMap) {
        mo8981a(1008, hashMap);
        mo8990b((C0525b) new C0525b() {
            /* renamed from: a */
            public void mo9003a(Exception exc) {
                C0509a.this.mo8981a(1010, (HashMap<String, Object>) hashMap);
            }

            /* renamed from: a */
            public void mo9004a(boolean z) {
            }
        }, aVar.mo9012a());
    }

    /* renamed from: e */
    public void mo8997e(Message message) {
        C0525b bVar = (C0525b) ((Object[]) message.obj)[0];
        this.f629c = false;
        this.f628b = 0;
        if (f620d != null) {
            try {
                for (C0524a next : f620d.values()) {
                    if (next != null) {
                        next.f656a.release();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            f620d.clear();
        }
        if (bVar != null) {
            bVar.mo9004a(true);
        }
    }
}
