package com.iflytek.business.speech;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.iflytek.business.speech.l */
public interface VerifierListener extends IInterface {
    /* renamed from: a */
    void mo12951a() throws RemoteException;

    /* renamed from: a */
    void mo12952a(int i) throws RemoteException;

    /* renamed from: a */
    void mo12953a(VerifierResult verifierResult) throws RemoteException;

    /* renamed from: a */
    void mo12954a(VerifierResult verifierResult, int i) throws RemoteException;

    /* renamed from: b */
    void mo12955b() throws RemoteException;

    /* renamed from: b */
    void mo12956b(int i) throws RemoteException;

    /* renamed from: c */
    void mo12957c() throws RemoteException;

    /* renamed from: c */
    void mo12958c(int i) throws RemoteException;

    /* renamed from: com.iflytek.business.speech.l$a */
    /* compiled from: VerifierListener */
    public static abstract class C1038a extends Binder implements VerifierListener {
        /* renamed from: a */
        public static VerifierListener m2918a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.iflytek.business.speech.VerifierListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof VerifierListener)) {
                return new C1039a(iBinder);
            }
            return (VerifierListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                VerifierResult verifierResult = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.iflytek.business.speech.VerifierListener");
                        mo12952a(parcel.readInt());
                        return true;
                    case 2:
                        parcel.enforceInterface("com.iflytek.business.speech.VerifierListener");
                        mo12956b(parcel.readInt());
                        return true;
                    case 3:
                        parcel.enforceInterface("com.iflytek.business.speech.VerifierListener");
                        mo12951a();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.iflytek.business.speech.VerifierListener");
                        mo12955b();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.iflytek.business.speech.VerifierListener");
                        if (parcel.readInt() != 0) {
                            verifierResult = VerifierResult.CREATOR.createFromParcel(parcel);
                        }
                        mo12953a(verifierResult);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.iflytek.business.speech.VerifierListener");
                        if (parcel.readInt() != 0) {
                            verifierResult = VerifierResult.CREATOR.createFromParcel(parcel);
                        }
                        mo12954a(verifierResult, parcel.readInt());
                        return true;
                    case 7:
                        parcel.enforceInterface("com.iflytek.business.speech.VerifierListener");
                        mo12957c();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.iflytek.business.speech.VerifierListener");
                        mo12958c(parcel.readInt());
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.iflytek.business.speech.VerifierListener");
                return true;
            }
        }

        /* renamed from: com.iflytek.business.speech.l$a$a */
        /* compiled from: VerifierListener */
        private static class C1039a implements VerifierListener {

            /* renamed from: a */
            private IBinder f2498a;

            C1039a(IBinder iBinder) {
                this.f2498a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2498a;
            }

            /* renamed from: a */
            public void mo12952a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.VerifierListener");
                    obtain.writeInt(i);
                    this.f2498a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo12956b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.VerifierListener");
                    obtain.writeInt(i);
                    this.f2498a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12951a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.VerifierListener");
                    this.f2498a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo12955b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.VerifierListener");
                    this.f2498a.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12953a(VerifierResult verifierResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.VerifierListener");
                    if (verifierResult != null) {
                        obtain.writeInt(1);
                        verifierResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2498a.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12954a(VerifierResult verifierResult, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.VerifierListener");
                    if (verifierResult != null) {
                        obtain.writeInt(1);
                        verifierResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f2498a.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo12957c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.VerifierListener");
                    this.f2498a.transact(7, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo12958c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.VerifierListener");
                    obtain.writeInt(i);
                    this.f2498a.transact(8, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
