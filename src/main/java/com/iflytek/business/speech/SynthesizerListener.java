package com.iflytek.business.speech;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.iflytek.business.speech.k */
public interface SynthesizerListener extends IInterface {
    /* renamed from: a */
    void mo12941a() throws RemoteException;

    /* renamed from: a */
    void mo12942a(int i) throws RemoteException;

    /* renamed from: a */
    void mo12943a(int i, int i2, int i3, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo12944b() throws RemoteException;

    /* renamed from: b */
    void mo12945b(int i) throws RemoteException;

    /* renamed from: c */
    void mo12946c() throws RemoteException;

    /* renamed from: c */
    void mo12947c(int i) throws RemoteException;

    /* renamed from: d */
    void mo12948d() throws RemoteException;

    /* renamed from: com.iflytek.business.speech.k$a */
    /* compiled from: SynthesizerListener */
    public static abstract class C1036a extends Binder implements SynthesizerListener {
        /* renamed from: a */
        public static SynthesizerListener m2901a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.iflytek.business.speech.SynthesizerListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof SynthesizerListener)) {
                return new C1037a(iBinder);
            }
            return (SynthesizerListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.iflytek.business.speech.SynthesizerListener");
                        mo12942a(parcel.readInt());
                        return true;
                    case 2:
                        parcel.enforceInterface("com.iflytek.business.speech.SynthesizerListener");
                        mo12941a();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.iflytek.business.speech.SynthesizerListener");
                        mo12945b(parcel.readInt());
                        return true;
                    case 4:
                        parcel.enforceInterface("com.iflytek.business.speech.SynthesizerListener");
                        mo12944b();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.iflytek.business.speech.SynthesizerListener");
                        mo12947c(parcel.readInt());
                        return true;
                    case 6:
                        parcel.enforceInterface("com.iflytek.business.speech.SynthesizerListener");
                        mo12946c();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.iflytek.business.speech.SynthesizerListener");
                        mo12948d();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.iflytek.business.speech.SynthesizerListener");
                        mo12943a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.iflytek.business.speech.SynthesizerListener");
                return true;
            }
        }

        /* renamed from: com.iflytek.business.speech.k$a$a */
        /* compiled from: SynthesizerListener */
        private static class C1037a implements SynthesizerListener {

            /* renamed from: a */
            private IBinder f2497a;

            C1037a(IBinder iBinder) {
                this.f2497a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2497a;
            }

            /* renamed from: a */
            public void mo12942a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.SynthesizerListener");
                    obtain.writeInt(i);
                    this.f2497a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12941a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.SynthesizerListener");
                    this.f2497a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo12945b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.SynthesizerListener");
                    obtain.writeInt(i);
                    this.f2497a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo12944b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.SynthesizerListener");
                    this.f2497a.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo12947c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.SynthesizerListener");
                    obtain.writeInt(i);
                    this.f2497a.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo12946c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.SynthesizerListener");
                    this.f2497a.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo12948d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.SynthesizerListener");
                    this.f2497a.transact(7, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12943a(int i, int i2, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.SynthesizerListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2497a.transact(8, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
