package com.iflytek.business.speech;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.iflytek.business.speech.IAIUIAgent;

/* renamed from: com.iflytek.business.speech.f */
public interface ISpeechService extends IInterface {
    /* renamed from: a */
    IAIUIAgent mo12883a(Bundle bundle, IAIUIListener dVar) throws RemoteException;

    /* renamed from: a */
    void mo12884a(Intent intent, IInitServiceListener eVar) throws RemoteException;

    /* renamed from: a */
    void mo12885a(RecognitionListener iVar, Intent intent) throws RemoteException;

    /* renamed from: a */
    void mo12886a(SynthesizerListener kVar, Intent intent) throws RemoteException;

    /* renamed from: a */
    void mo12887a(VerifierListener lVar, Intent intent) throws RemoteException;

    /* renamed from: a */
    void mo12888a(String str, Intent intent) throws RemoteException;

    /* renamed from: a */
    void mo12889a(byte[] bArr, int i, int i2, Intent intent) throws RemoteException;

    /* renamed from: a */
    boolean mo12890a(Intent intent) throws RemoteException;

    /* renamed from: a */
    boolean mo12891a(String[] strArr, Intent intent) throws RemoteException;

    /* renamed from: b */
    int mo12892b(Intent intent) throws RemoteException;

    /* renamed from: b */
    String mo12893b(String str, Intent intent) throws RemoteException;

    /* renamed from: c */
    void mo12894c(Intent intent) throws RemoteException;

    /* renamed from: d */
    void mo12895d(Intent intent) throws RemoteException;

    /* renamed from: e */
    void mo12896e(Intent intent) throws RemoteException;

    /* renamed from: f */
    void mo12897f(Intent intent) throws RemoteException;

    /* renamed from: g */
    void mo12898g(Intent intent) throws RemoteException;

    /* renamed from: h */
    void mo12899h(Intent intent) throws RemoteException;

    /* renamed from: i */
    void mo12900i(Intent intent) throws RemoteException;

    /* renamed from: j */
    void mo12901j(Intent intent) throws RemoteException;

    /* renamed from: k */
    String[] mo12902k(Intent intent) throws RemoteException;

    /* renamed from: l */
    void mo12903l(Intent intent) throws RemoteException;

    /* renamed from: m */
    boolean mo12904m(Intent intent) throws RemoteException;

    /* renamed from: n */
    String[] mo12905n(Intent intent) throws RemoteException;

    /* renamed from: o */
    void mo12906o(Intent intent) throws RemoteException;

    /* renamed from: p */
    int mo12907p(Intent intent) throws RemoteException;

    /* renamed from: q */
    int mo12908q(Intent intent) throws RemoteException;

    /* renamed from: com.iflytek.business.speech.f$a */
    /* compiled from: ISpeechService */
    public static abstract class C1028a extends Binder implements ISpeechService {
        /* renamed from: a */
        public static ISpeechService m2804a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.iflytek.business.speech.ISpeechService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISpeechService)) {
                return new C1029a(iBinder);
            }
            return (ISpeechService) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r1v1 */
        /* JADX WARNING: type inference failed for: r1v2, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v5, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v8, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v11, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v14, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v17, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v20, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v23, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v27, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v30, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v33, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v36, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v39, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v42, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v45, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v48, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v51, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v54, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v57, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v60, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v63, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v66, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v69, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v72, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v75, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v78, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r1v80 */
        /* JADX WARNING: type inference failed for: r1v81 */
        /* JADX WARNING: type inference failed for: r1v82 */
        /* JADX WARNING: type inference failed for: r1v83 */
        /* JADX WARNING: type inference failed for: r1v84 */
        /* JADX WARNING: type inference failed for: r1v85 */
        /* JADX WARNING: type inference failed for: r1v86 */
        /* JADX WARNING: type inference failed for: r1v87 */
        /* JADX WARNING: type inference failed for: r1v88 */
        /* JADX WARNING: type inference failed for: r1v89 */
        /* JADX WARNING: type inference failed for: r1v90 */
        /* JADX WARNING: type inference failed for: r1v91 */
        /* JADX WARNING: type inference failed for: r1v92 */
        /* JADX WARNING: type inference failed for: r1v93 */
        /* JADX WARNING: type inference failed for: r1v94 */
        /* JADX WARNING: type inference failed for: r1v95 */
        /* JADX WARNING: type inference failed for: r1v96 */
        /* JADX WARNING: type inference failed for: r1v97 */
        /* JADX WARNING: type inference failed for: r1v98 */
        /* JADX WARNING: type inference failed for: r1v99 */
        /* JADX WARNING: type inference failed for: r1v100 */
        /* JADX WARNING: type inference failed for: r1v101 */
        /* JADX WARNING: type inference failed for: r1v102 */
        /* JADX WARNING: type inference failed for: r1v103 */
        /* JADX WARNING: type inference failed for: r1v104 */
        /* JADX WARNING: type inference failed for: r1v105 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                java.lang.String r0 = "com.iflytek.business.speech.ISpeechService"
                r1 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r2 = 1
                if (r5 == r1) goto L_0x030a
                r1 = 0
                switch(r5) {
                    case 1: goto L_0x02e9;
                    case 2: goto L_0x02cc;
                    case 3: goto L_0x02af;
                    case 4: goto L_0x0292;
                    case 5: goto L_0x0279;
                    case 6: goto L_0x0260;
                    case 7: goto L_0x0247;
                    case 8: goto L_0x0222;
                    case 9: goto L_0x0201;
                    case 10: goto L_0x01e0;
                    case 11: goto L_0x01bf;
                    case 12: goto L_0x01a6;
                    case 13: goto L_0x018d;
                    case 14: goto L_0x0174;
                    case 15: goto L_0x015b;
                    case 16: goto L_0x0142;
                    case 17: goto L_0x0125;
                    case 18: goto L_0x0104;
                    case 19: goto L_0x00eb;
                    case 20: goto L_0x00ce;
                    case 21: goto L_0x00b1;
                    case 22: goto L_0x0090;
                    case 23: goto L_0x0077;
                    case 24: goto L_0x005a;
                    case 25: goto L_0x003d;
                    case 26: goto L_0x0011;
                    default: goto L_0x000c;
                }
            L_0x000c:
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x0011:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0023
                android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                android.os.Bundle r5 = (android.os.Bundle) r5
                goto L_0x0024
            L_0x0023:
                r5 = r1
            L_0x0024:
                android.os.IBinder r6 = r6.readStrongBinder()
                com.iflytek.business.speech.d r6 = com.iflytek.business.speech.IAIUIListener.C1024a.m2773a(r6)
                com.iflytek.business.speech.c r5 = r4.mo12883a((android.os.Bundle) r5, (com.iflytek.business.speech.IAIUIListener) r6)
                r7.writeNoException()
                if (r5 == 0) goto L_0x0039
                android.os.IBinder r1 = r5.asBinder()
            L_0x0039:
                r7.writeStrongBinder(r1)
                return r2
            L_0x003d:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x004f
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x004f:
                int r5 = r4.mo12908q(r1)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x005a:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x006c
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x006c:
                int r5 = r4.mo12907p(r1)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0077:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0089
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x0089:
                r4.mo12906o(r1)
                r7.writeNoException()
                return r2
            L_0x0090:
                r6.enforceInterface(r0)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x00a6
                android.os.Parcelable$Creator r8 = android.content.Intent.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r1 = r6
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x00a6:
                java.lang.String r5 = r4.mo12893b(r5, r1)
                r7.writeNoException()
                r7.writeString(r5)
                return r2
            L_0x00b1:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x00c3
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x00c3:
                java.lang.String[] r5 = r4.mo12905n(r1)
                r7.writeNoException()
                r7.writeStringArray(r5)
                return r2
            L_0x00ce:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x00e0
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x00e0:
                boolean r5 = r4.mo12904m(r1)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x00eb:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x00fd
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x00fd:
                r4.mo12903l(r1)
                r7.writeNoException()
                return r2
            L_0x0104:
                r6.enforceInterface(r0)
                java.lang.String[] r5 = r6.createStringArray()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x011a
                android.os.Parcelable$Creator r8 = android.content.Intent.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r1 = r6
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x011a:
                boolean r5 = r4.mo12891a((java.lang.String[]) r5, (android.content.Intent) r1)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0125:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0137
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x0137:
                java.lang.String[] r5 = r4.mo12902k(r1)
                r7.writeNoException()
                r7.writeStringArray(r5)
                return r2
            L_0x0142:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0154
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x0154:
                r4.mo12901j(r1)
                r7.writeNoException()
                return r2
            L_0x015b:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x016d
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x016d:
                r4.mo12900i(r1)
                r7.writeNoException()
                return r2
            L_0x0174:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0186
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x0186:
                r4.mo12899h(r1)
                r7.writeNoException()
                return r2
            L_0x018d:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x019f
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x019f:
                r4.mo12898g(r1)
                r7.writeNoException()
                return r2
            L_0x01a6:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x01b8
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x01b8:
                r4.mo12897f(r1)
                r7.writeNoException()
                return r2
            L_0x01bf:
                r6.enforceInterface(r0)
                android.os.IBinder r5 = r6.readStrongBinder()
                com.iflytek.business.speech.l r5 = com.iflytek.business.speech.VerifierListener.C1038a.m2918a(r5)
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x01d9
                android.os.Parcelable$Creator r8 = android.content.Intent.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r1 = r6
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x01d9:
                r4.mo12887a((com.iflytek.business.speech.VerifierListener) r5, (android.content.Intent) r1)
                r7.writeNoException()
                return r2
            L_0x01e0:
                r6.enforceInterface(r0)
                android.os.IBinder r5 = r6.readStrongBinder()
                com.iflytek.business.speech.i r5 = com.iflytek.business.speech.RecognitionListener.C1030a.m2858a(r5)
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x01fa
                android.os.Parcelable$Creator r8 = android.content.Intent.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r1 = r6
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x01fa:
                r4.mo12885a((com.iflytek.business.speech.RecognitionListener) r5, (android.content.Intent) r1)
                r7.writeNoException()
                return r2
            L_0x0201:
                r6.enforceInterface(r0)
                android.os.IBinder r5 = r6.readStrongBinder()
                com.iflytek.business.speech.k r5 = com.iflytek.business.speech.SynthesizerListener.C1036a.m2901a(r5)
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x021b
                android.os.Parcelable$Creator r8 = android.content.Intent.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r1 = r6
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x021b:
                r4.mo12886a((com.iflytek.business.speech.SynthesizerListener) r5, (android.content.Intent) r1)
                r7.writeNoException()
                return r2
            L_0x0222:
                r6.enforceInterface(r0)
                byte[] r5 = r6.createByteArray()
                int r8 = r6.readInt()
                int r0 = r6.readInt()
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x0240
                android.os.Parcelable$Creator r1 = android.content.Intent.CREATOR
                java.lang.Object r6 = r1.createFromParcel(r6)
                r1 = r6
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x0240:
                r4.mo12889a(r5, r8, r0, r1)
                r7.writeNoException()
                return r2
            L_0x0247:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0259
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x0259:
                r4.mo12896e(r1)
                r7.writeNoException()
                return r2
            L_0x0260:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0272
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x0272:
                r4.mo12895d(r1)
                r7.writeNoException()
                return r2
            L_0x0279:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x028b
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x028b:
                r4.mo12894c(r1)
                r7.writeNoException()
                return r2
            L_0x0292:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x02a4
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x02a4:
                int r5 = r4.mo12892b(r1)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x02af:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x02c1
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x02c1:
                boolean r5 = r4.mo12890a(r1)
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x02cc:
                r6.enforceInterface(r0)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x02e2
                android.os.Parcelable$Creator r8 = android.content.Intent.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r1 = r6
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x02e2:
                r4.mo12888a((java.lang.String) r5, (android.content.Intent) r1)
                r7.writeNoException()
                return r2
            L_0x02e9:
                r6.enforceInterface(r0)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x02fb
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r1 = r5
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x02fb:
                android.os.IBinder r5 = r6.readStrongBinder()
                com.iflytek.business.speech.e r5 = com.iflytek.business.speech.IInitServiceListener.C1026a.m2776a(r5)
                r4.mo12884a((android.content.Intent) r1, (com.iflytek.business.speech.IInitServiceListener) r5)
                r7.writeNoException()
                return r2
            L_0x030a:
                r7.writeString(r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.business.speech.ISpeechService.C1028a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: com.iflytek.business.speech.f$a$a */
        /* compiled from: ISpeechService */
        private static class C1029a implements ISpeechService {

            /* renamed from: a */
            private IBinder f2473a;

            C1029a(IBinder iBinder) {
                this.f2473a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2473a;
            }

            /* renamed from: a */
            public void mo12884a(Intent intent, IInitServiceListener eVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(eVar != null ? eVar.asBinder() : null);
                    this.f2473a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12888a(String str, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    obtain.writeString(str);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo12890a(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    boolean z = true;
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public int mo12892b(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo12894c(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo12895d(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo12896e(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12889a(byte[] bArr, int i, int i2, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12886a(SynthesizerListener kVar, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    obtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12885a(RecognitionListener iVar, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12887a(VerifierListener lVar, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo12897f(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo12898g(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo12899h(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo12900i(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo12901j(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public String[] mo12902k(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo12891a(String[] strArr, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    obtain.writeStringArray(strArr);
                    boolean z = true;
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo12903l(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public boolean mo12904m(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    boolean z = true;
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public String[] mo12905n(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public String mo12893b(String str, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    obtain.writeString(str);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo12906o(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public int mo12907p(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public int mo12908q(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2473a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public IAIUIAgent mo12883a(Bundle bundle, IAIUIListener dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.ISpeechService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f2473a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return IAIUIAgent.C1022a.m2769a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
