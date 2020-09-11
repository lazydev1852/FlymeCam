package com.iflytek.business.speech;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.iflytek.business.speech.i */
public interface RecognitionListener extends IInterface {
    /* renamed from: a */
    void mo12915a() throws RemoteException;

    /* renamed from: a */
    void mo12916a(int i) throws RemoteException;

    /* renamed from: a */
    void mo12917a(int i, int i2, int i3, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo12918a(int i, String str, int i2) throws RemoteException;

    /* renamed from: a */
    void mo12919a(Intent intent) throws RemoteException;

    /* renamed from: a */
    void mo12920a(RecognizerResult recognizerResult) throws RemoteException;

    /* renamed from: a */
    void mo12921a(byte[] bArr) throws RemoteException;

    /* renamed from: b */
    void mo12922b() throws RemoteException;

    /* renamed from: b */
    void mo12923b(int i) throws RemoteException;

    /* renamed from: b */
    void mo12924b(RecognizerResult recognizerResult) throws RemoteException;

    /* renamed from: c */
    void mo12925c() throws RemoteException;

    /* renamed from: c */
    void mo12926c(int i) throws RemoteException;

    /* renamed from: d */
    void mo12927d() throws RemoteException;

    /* renamed from: com.iflytek.business.speech.i$a */
    /* compiled from: RecognitionListener */
    public static abstract class C1030a extends Binder implements RecognitionListener {
        public IBinder asBinder() {
            return this;
        }

        public C1030a() {
            attachInterface(this, "com.iflytek.business.speech.RecognitionListener");
        }

        /* renamed from: a */
        public static RecognitionListener m2858a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.iflytek.business.speech.RecognitionListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof RecognitionListener)) {
                return new C1031a(iBinder);
            }
            return (RecognitionListener) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.iflytek.business.speech.RecognizerResult} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.iflytek.business.speech.RecognizerResult} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r1v1 */
        /* JADX WARNING: type inference failed for: r1v8, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r1v14 */
        /* JADX WARNING: type inference failed for: r1v15 */
        /* JADX WARNING: type inference failed for: r1v16 */
        /* JADX WARNING: type inference failed for: r1v17 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                java.lang.String r0 = "com.iflytek.business.speech.RecognitionListener"
                r1 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r2 = 1
                if (r4 == r1) goto L_0x00d0
                r1 = 0
                switch(r4) {
                    case 1: goto L_0x00bd;
                    case 2: goto L_0x00b2;
                    case 3: goto L_0x00ab;
                    case 4: goto L_0x00a4;
                    case 5: goto L_0x009d;
                    case 6: goto L_0x0096;
                    case 7: goto L_0x008b;
                    case 8: goto L_0x0080;
                    case 9: goto L_0x006a;
                    case 10: goto L_0x0054;
                    case 11: goto L_0x003e;
                    case 12: goto L_0x0033;
                    case 13: goto L_0x0011;
                    default: goto L_0x000c;
                }
            L_0x000c:
                boolean r4 = super.onTransact(r4, r5, r6, r7)
                return r4
            L_0x0011:
                r5.enforceInterface(r0)
                int r4 = r5.readInt()
                int r6 = r5.readInt()
                int r7 = r5.readInt()
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x002f
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r0.createFromParcel(r5)
                r1 = r5
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x002f:
                r3.mo12917a(r4, r6, r7, r1)
                return r2
            L_0x0033:
                r5.enforceInterface(r0)
                byte[] r4 = r5.createByteArray()
                r3.mo12921a((byte[]) r4)
                return r2
            L_0x003e:
                r5.enforceInterface(r0)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0050
                android.os.Parcelable$Creator r4 = android.content.Intent.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r1 = r4
                android.content.Intent r1 = (android.content.Intent) r1
            L_0x0050:
                r3.mo12919a((android.content.Intent) r1)
                return r2
            L_0x0054:
                r5.enforceInterface(r0)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0066
                android.os.Parcelable$Creator<com.iflytek.business.speech.RecognizerResult> r4 = com.iflytek.business.speech.RecognizerResult.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r1 = r4
                com.iflytek.business.speech.RecognizerResult r1 = (com.iflytek.business.speech.RecognizerResult) r1
            L_0x0066:
                r3.mo12924b((com.iflytek.business.speech.RecognizerResult) r1)
                return r2
            L_0x006a:
                r5.enforceInterface(r0)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x007c
                android.os.Parcelable$Creator<com.iflytek.business.speech.RecognizerResult> r4 = com.iflytek.business.speech.RecognizerResult.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r1 = r4
                com.iflytek.business.speech.RecognizerResult r1 = (com.iflytek.business.speech.RecognizerResult) r1
            L_0x007c:
                r3.mo12920a((com.iflytek.business.speech.RecognizerResult) r1)
                return r2
            L_0x0080:
                r5.enforceInterface(r0)
                int r4 = r5.readInt()
                r3.mo12926c(r4)
                return r2
            L_0x008b:
                r5.enforceInterface(r0)
                int r4 = r5.readInt()
                r3.mo12923b((int) r4)
                return r2
            L_0x0096:
                r5.enforceInterface(r0)
                r3.mo12927d()
                return r2
            L_0x009d:
                r5.enforceInterface(r0)
                r3.mo12925c()
                return r2
            L_0x00a4:
                r5.enforceInterface(r0)
                r3.mo12922b()
                return r2
            L_0x00ab:
                r5.enforceInterface(r0)
                r3.mo12915a()
                return r2
            L_0x00b2:
                r5.enforceInterface(r0)
                int r4 = r5.readInt()
                r3.mo12916a((int) r4)
                return r2
            L_0x00bd:
                r5.enforceInterface(r0)
                int r4 = r5.readInt()
                java.lang.String r6 = r5.readString()
                int r5 = r5.readInt()
                r3.mo12918a(r4, r6, r5)
                return r2
            L_0x00d0:
                r6.writeString(r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.business.speech.RecognitionListener.C1030a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: com.iflytek.business.speech.i$a$a */
        /* compiled from: RecognitionListener */
        private static class C1031a implements RecognitionListener {

            /* renamed from: a */
            private IBinder f2481a;

            C1031a(IBinder iBinder) {
                this.f2481a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2481a;
            }

            /* renamed from: a */
            public void mo12918a(int i, String str, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    this.f2481a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12916a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    obtain.writeInt(i);
                    this.f2481a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12915a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    this.f2481a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo12922b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    this.f2481a.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo12925c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    this.f2481a.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo12927d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    this.f2481a.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo12923b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    obtain.writeInt(i);
                    this.f2481a.transact(7, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo12926c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    obtain.writeInt(i);
                    this.f2481a.transact(8, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12920a(RecognizerResult recognizerResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    if (recognizerResult != null) {
                        obtain.writeInt(1);
                        recognizerResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2481a.transact(9, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo12924b(RecognizerResult recognizerResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    if (recognizerResult != null) {
                        obtain.writeInt(1);
                        recognizerResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2481a.transact(10, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12919a(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2481a.transact(11, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12921a(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    obtain.writeByteArray(bArr);
                    this.f2481a.transact(12, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12917a(int i, int i2, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.RecognitionListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2481a.transact(13, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
