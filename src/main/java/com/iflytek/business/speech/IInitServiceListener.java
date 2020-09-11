package com.iflytek.business.speech;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.iflytek.business.speech.e */
public interface IInitServiceListener extends IInterface {
    /* renamed from: a */
    void mo12879a(int i) throws RemoteException;

    /* renamed from: com.iflytek.business.speech.e$a */
    /* compiled from: IInitServiceListener */
    public static abstract class C1026a extends Binder implements IInitServiceListener {
        public IBinder asBinder() {
            return this;
        }

        public C1026a() {
            attachInterface(this, "com.iflytek.business.speech.IInitServiceListener");
        }

        /* renamed from: a */
        public static IInitServiceListener m2776a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.iflytek.business.speech.IInitServiceListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IInitServiceListener)) {
                return new C1027a(iBinder);
            }
            return (IInitServiceListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.iflytek.business.speech.IInitServiceListener");
                mo12879a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.iflytek.business.speech.IInitServiceListener");
                return true;
            }
        }

        /* renamed from: com.iflytek.business.speech.e$a$a */
        /* compiled from: IInitServiceListener */
        private static class C1027a implements IInitServiceListener {

            /* renamed from: a */
            private IBinder f2472a;

            C1027a(IBinder iBinder) {
                this.f2472a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2472a;
            }

            /* renamed from: a */
            public void mo12879a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.IInitServiceListener");
                    obtain.writeInt(i);
                    this.f2472a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
