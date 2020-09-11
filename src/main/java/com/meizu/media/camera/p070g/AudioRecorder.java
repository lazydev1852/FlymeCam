package com.meizu.media.camera.p070g;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Process;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006!"}, mo27294d2 = {"Lcom/meizu/media/camera/mediacodec/AudioRecorder;", "", "()V", "channels", "", "getChannels", "()I", "setChannels", "(I)V", "mAudioRecord", "Landroid/media/AudioRecord;", "mBufferSize", "mExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "mHandler", "Landroid/os/Handler;", "mIsRecording", "", "mRecordCallback", "Lcom/meizu/media/camera/mediacodec/AudioRecorder$AudioRecordCallback;", "sampleRate", "getSampleRate", "setSampleRate", "record", "", "release", "setRecordCallback", "recordCallback", "start", "stop", "AudioRecordCallback", "Companion", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.g.a */
public final class AudioRecorder {

    /* renamed from: a */
    public static ChangeQuickRedirect f10117a = null;

    /* renamed from: b */
    public static final C2078b f10118b = new C2078b((DefaultConstructorMarker) null);

    /* renamed from: k */
    private static final LogUtil.C2630a f10119k = new LogUtil.C2630a("AudioRecorder");

    /* renamed from: l */
    private static final int f10120l = f10120l;

    /* renamed from: m */
    private static final int f10121m = 2;

    /* renamed from: c */
    private final ExecutorService f10122c = Executors.newCachedThreadPool();

    /* renamed from: d */
    private AudioRecord f10123d;

    /* renamed from: e */
    private int f10124e;

    /* renamed from: f */
    private int f10125f = f10120l;

    /* renamed from: g */
    private int f10126g = f10121m;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C2077a f10127h;

    /* renamed from: i */
    private Handler f10128i;

    /* renamed from: j */
    private boolean f10129j;

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo27294d2 = {"Lcom/meizu/media/camera/mediacodec/AudioRecorder$AudioRecordCallback;", "", "onRecordSample", "", "data", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.a$a */
    /* compiled from: AudioRecorder.kt */
    public interface C2077a {
        /* renamed from: a */
        void mo20118a(@Nullable byte[] bArr);
    }

    /* renamed from: a */
    public final int mo20112a() {
        return this.f10125f;
    }

    /* renamed from: b */
    public final int mo20114b() {
        return this.f10126g;
    }

    /* renamed from: a */
    public final void mo20113a(@Nullable C2077a aVar) {
        this.f10127h = aVar;
    }

    /* renamed from: c */
    public final boolean mo20115c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f10117a, false, 4463, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        try {
            int i = this.f10126g == 1 ? 16 : 12;
            this.f10124e = 4096;
            this.f10123d = new AudioRecord(5, this.f10125f, i, 2, this.f10124e);
            AudioRecord audioRecord = this.f10123d;
            if (audioRecord == null) {
                C3443i.m21151a();
            }
            if (audioRecord.getState() != 1) {
                LogUtil.m15949b(f10119k, "cannot init AudioRecord");
                return false;
            }
            this.f10129j = true;
            this.f10122c.execute(new C2080d(this));
            this.f10128i = new Handler();
            return true;
        } catch (Exception e) {
            LogUtil.C2630a aVar = f10119k;
            StringBuilder sb = new StringBuilder();
            sb.append("init AudioRecord exception: ");
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                C3443i.m21151a();
            }
            sb.append(localizedMessage);
            LogUtil.m15949b(aVar, sb.toString());
            return false;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.a$d */
    /* compiled from: AudioRecorder.kt */
    static final class C2080d implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10133a;

        /* renamed from: b */
        final /* synthetic */ AudioRecorder f10134b;

        C2080d(AudioRecorder aVar) {
            this.f10134b = aVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f10133a, false, 4467, new Class[0], Void.TYPE).isSupported) {
                this.f10134b.m10400f();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m10400f() {
        if (!PatchProxy.proxy(new Object[0], this, f10117a, false, 4464, new Class[0], Void.TYPE).isSupported) {
            Process.setThreadPriority(-19);
            if (this.f10123d != null) {
                AudioRecord audioRecord = this.f10123d;
                if (audioRecord == null) {
                    C3443i.m21151a();
                }
                if (audioRecord.getState() == 1) {
                    ByteBuffer allocate = ByteBuffer.allocate(this.f10124e);
                    AudioRecord audioRecord2 = this.f10123d;
                    if (audioRecord2 == null) {
                        C3443i.m21151a();
                    }
                    audioRecord2.startRecording();
                    LogUtil.m15942a(f10119k, "AudioRecorder started");
                    while (this.f10129j) {
                        AudioRecord audioRecord3 = this.f10123d;
                        if (audioRecord3 == null) {
                            C3443i.m21151a();
                        }
                        int read = audioRecord3.read(allocate.array(), 0, this.f10124e);
                        if (read > 0 && this.f10127h != null) {
                            byte[] bArr = new byte[read];
                            allocate.position(0);
                            allocate.limit(read);
                            allocate.get(bArr, 0, read);
                            Handler handler = this.f10128i;
                            if (handler != null) {
                                handler.post(new C2079c(this, bArr));
                            }
                        }
                    }
                    mo20117e();
                    LogUtil.m15942a(f10119k, "AudioRecorder finished");
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.a$c */
    /* compiled from: AudioRecorder.kt */
    static final class C2079c implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f10130a;

        /* renamed from: b */
        final /* synthetic */ AudioRecorder f10131b;

        /* renamed from: c */
        final /* synthetic */ byte[] f10132c;

        C2079c(AudioRecorder aVar, byte[] bArr) {
            this.f10131b = aVar;
            this.f10132c = bArr;
        }

        public final void run() {
            C2077a b;
            if (!PatchProxy.proxy(new Object[0], this, f10130a, false, 4466, new Class[0], Void.TYPE).isSupported && (b = this.f10131b.f10127h) != null) {
                b.mo20118a(this.f10132c);
            }
        }
    }

    /* renamed from: d */
    public final void mo20116d() {
        this.f10129j = false;
    }

    /* renamed from: e */
    public final void mo20117e() {
        if (!PatchProxy.proxy(new Object[0], this, f10117a, false, 4465, new Class[0], Void.TYPE).isSupported) {
            if (this.f10129j) {
                this.f10129j = false;
            } else if (this.f10123d != null) {
                AudioRecord audioRecord = this.f10123d;
                if (audioRecord == null) {
                    C3443i.m21151a();
                }
                audioRecord.stop();
                AudioRecord audioRecord2 = this.f10123d;
                if (audioRecord2 == null) {
                    C3443i.m21151a();
                }
                audioRecord2.release();
                this.f10123d = null;
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, mo27294d2 = {"Lcom/meizu/media/camera/mediacodec/AudioRecorder$Companion;", "", "()V", "DEFAULT_CHANNELS", "", "DEFAULT_SAMPLE_RATE", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.g.a$b */
    /* compiled from: AudioRecorder.kt */
    public static final class C2078b {
        private C2078b() {
        }

        public /* synthetic */ C2078b(DefaultConstructorMarker gVar) {
            this();
        }
    }
}
