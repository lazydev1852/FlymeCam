package com.meizu.media.camera;

import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Size;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.meizu.media.camera.m */
public class MzCamcorderProfileManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f10504a;

    /* renamed from: b */
    private static final LogUtil.C2630a f10505b = new LogUtil.C2630a("CamcorderProfileManager");

    /* renamed from: c */
    private CamcorderProfile f10506c;

    /* renamed from: d */
    private C2139a f10507d;

    /* renamed from: e */
    private boolean f10508e;

    /* renamed from: a */
    public void mo20361a(int i, int i2) {
        Size size;
        int i3 = i;
        int i4 = i2;
        if (!PatchProxy.proxy(new Object[]{new Integer(i3), new Integer(i4)}, this, f10504a, false, 1650, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            try {
                LogUtil.C2630a aVar = f10505b;
                LogUtil.m15942a(aVar, "cameraId = " + i3 + ", quality = " + i4);
                this.f10506c = CamcorderProfile.get(i, i2);
                this.f10508e = false;
            } catch (Exception e) {
                LogUtil.C2630a aVar2 = f10505b;
                LogUtil.m15942a(aVar2, "getCamProfile failed : " + e);
                if (i4 == DeviceHelper.f14004cy || i4 == DeviceHelper.f14005cz) {
                    int i5 = i4;
                    this.f10508e = true;
                    this.f10507d = new C2139a(DeviceHelper.f13981cb, DeviceHelper.f14004cy, DeviceHelper.f13982cc, DeviceHelper.f13983cd, DeviceHelper.f13984ce, i5 == DeviceHelper.f14004cy ? DeviceHelper.f13985cf : 60, DeviceHelper.f13986cg, DeviceHelper.f13987ch, DeviceHelper.f13988ci, DeviceHelper.f13989cj, DeviceHelper.f13990ck, DeviceHelper.f13991cl);
                } else if (i4 == DeviceHelper.f13954cA || i4 == DeviceHelper.f13955cB || i4 == DeviceHelper.f13956cC) {
                    this.f10508e = true;
                    this.f10507d = new C2139a(DeviceHelper.f13992cm, DeviceHelper.f13954cA, DeviceHelper.f13993cn, DeviceHelper.f13994co, DeviceHelper.f13995cp, DeviceHelper.f13996cq, DeviceHelper.f13997cr, DeviceHelper.f13998cs, DeviceHelper.f13999ct, DeviceHelper.f14000cu, DeviceHelper.f14001cv, DeviceHelper.f14002cw);
                    int i6 = i2;
                    if (i6 == DeviceHelper.f13955cB || i6 == DeviceHelper.f13956cC) {
                        List<HashMap<Integer, Size>> G = CameraController.m8868g().mo19443G();
                        if (G == null) {
                            this.f10508e = false;
                            this.f10507d = null;
                            return;
                        }
                        for (HashMap next : G) {
                            if (next.containsKey(240) && i6 == DeviceHelper.f13955cB) {
                                Size size2 = (Size) next.get(240);
                                if (size2 != null) {
                                    this.f10507d.f10515g = size2.getWidth();
                                    this.f10507d.f10516h = size2.getHeight();
                                }
                            } else if (next.containsKey(480) && i6 == DeviceHelper.f13956cC && (size = (Size) next.get(480)) != null) {
                                this.f10507d.f10515g = size.getWidth();
                                this.f10507d.f10516h = size.getHeight();
                                this.f10507d.f10513e = 5760000;
                            }
                        }
                    }
                } else if (i4 == DeviceHelper.f14003cx) {
                    this.f10508e = true;
                    CamcorderProfile camcorderProfile = CamcorderProfile.get(i3, 6);
                    C2139a aVar3 = r1;
                    C2139a aVar4 = new C2139a(camcorderProfile.duration, i2, camcorderProfile.fileFormat, camcorderProfile.videoCodec, camcorderProfile.videoBitRate, 60, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, camcorderProfile.audioCodec, camcorderProfile.audioBitRate, camcorderProfile.audioSampleRate, camcorderProfile.audioChannels);
                    this.f10507d = aVar3;
                } else {
                    this.f10508e = false;
                }
            }
        }
    }

    /* renamed from: a */
    public CamcorderProfile mo20360a() {
        return this.f10506c;
    }

    /* renamed from: b */
    public int mo20363b() {
        if (this.f10508e) {
            return this.f10507d.f10515g;
        }
        if (this.f10506c == null) {
            return -1;
        }
        return this.f10506c.videoFrameWidth;
    }

    /* renamed from: c */
    public int mo20364c() {
        if (this.f10508e) {
            return this.f10507d.f10516h;
        }
        if (this.f10506c == null) {
            return -1;
        }
        return this.f10506c.videoFrameHeight;
    }

    /* renamed from: d */
    public int mo20365d() {
        if (this.f10508e) {
            return this.f10507d.f10514f;
        }
        return this.f10506c.videoFrameRate;
    }

    /* renamed from: e */
    public int mo20366e() {
        if (this.f10508e) {
            return this.f10507d.f10511c;
        }
        return this.f10506c.fileFormat;
    }

    /* renamed from: f */
    public int mo20367f() {
        if (this.f10508e) {
            return this.f10507d.f10513e;
        }
        return this.f10506c.videoBitRate;
    }

    /* renamed from: g */
    public int mo20368g() {
        if (this.f10508e) {
            return this.f10507d.f10512d;
        }
        return this.f10506c.videoCodec;
    }

    /* renamed from: h */
    public int mo20369h() {
        if (this.f10508e) {
            return this.f10507d.f10510b;
        }
        return this.f10506c.quality;
    }

    /* renamed from: i */
    public int mo20370i() {
        if (this.f10508e) {
            return this.f10507d.f10518j;
        }
        return this.f10506c.audioBitRate;
    }

    /* renamed from: j */
    public int mo20371j() {
        if (this.f10508e) {
            return this.f10507d.f10519k;
        }
        return this.f10506c.audioSampleRate;
    }

    /* renamed from: k */
    public int mo20372k() {
        if (this.f10508e) {
            return this.f10507d.f10520l;
        }
        return this.f10506c.audioChannels;
    }

    /* renamed from: a */
    public void mo20362a(MediaRecorder mediaRecorder) {
        if (!PatchProxy.proxy(new Object[]{mediaRecorder}, this, f10504a, false, 1651, new Class[]{MediaRecorder.class}, Void.TYPE).isSupported && mediaRecorder != null) {
            mediaRecorder.setAudioSource(5);
            mediaRecorder.setOutputFormat(this.f10507d.f10511c);
            mediaRecorder.setVideoFrameRate(this.f10507d.f10514f);
            mediaRecorder.setVideoSize(this.f10507d.f10515g, this.f10507d.f10516h);
            mediaRecorder.setVideoEncodingBitRate(this.f10507d.f10513e);
            mediaRecorder.setVideoEncoder(this.f10507d.f10512d);
            mediaRecorder.setAudioEncodingBitRate(this.f10507d.f10518j);
            mediaRecorder.setAudioChannels(this.f10507d.f10520l);
            mediaRecorder.setAudioSamplingRate(this.f10507d.f10519k);
            mediaRecorder.setAudioEncoder(this.f10507d.f10517i);
        }
    }

    /* renamed from: com.meizu.media.camera.m$a */
    /* compiled from: MzCamcorderProfileManager */
    private class C2139a {

        /* renamed from: a */
        public int f10509a;

        /* renamed from: b */
        public int f10510b;

        /* renamed from: c */
        public int f10511c;

        /* renamed from: d */
        public int f10512d;

        /* renamed from: e */
        public int f10513e;

        /* renamed from: f */
        public int f10514f;

        /* renamed from: g */
        public int f10515g;

        /* renamed from: h */
        public int f10516h;

        /* renamed from: i */
        public int f10517i;

        /* renamed from: j */
        public int f10518j;

        /* renamed from: k */
        public int f10519k;

        /* renamed from: l */
        public int f10520l;

        public C2139a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f10509a = i;
            this.f10510b = i2;
            this.f10511c = i3;
            this.f10512d = i4;
            this.f10513e = i5;
            this.f10514f = i6;
            this.f10515g = i7;
            this.f10516h = i8;
            this.f10517i = i9;
            this.f10518j = i10;
            this.f10519k = i11;
            this.f10520l = i12;
        }
    }

    /* renamed from: b */
    public static boolean m10857b(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f10504a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 1652, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (i == 0) {
            if (i2 != -1 && (i2 == DeviceHelper.f14004cy || ((i2 == DeviceHelper.f14003cx || i2 == DeviceHelper.f14005cz) && CameraController.m8868g().mo19442F()))) {
                return true;
            }
        } else if (i == 1 && DeviceHelper.f13863aP && i2 != -1 && i2 == DeviceHelper.f14003cx) {
            return true;
        }
        LogUtil.C2630a aVar = f10505b;
        LogUtil.m15944a(aVar, "hasProfile cameraId = " + i + ", quality = " + i2 + ", is have this profile: " + CamcorderProfile.hasProfile(i, i2), true);
        return CamcorderProfile.hasProfile(i, i2);
    }
}
