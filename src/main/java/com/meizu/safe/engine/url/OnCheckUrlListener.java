package com.meizu.safe.engine.url;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.meizu.safe.engine.url.c */
public interface OnCheckUrlListener extends IInterface {
    /* renamed from: a */
    void mo19187a(MzUrlCheckResult mzUrlCheckResult) throws RemoteException;

    /* renamed from: com.meizu.safe.engine.url.c$a */
    /* compiled from: OnCheckUrlListener */
    public static abstract class C2797a extends Binder implements OnCheckUrlListener {
        public IBinder asBinder() {
            return this;
        }

        public C2797a() {
            attachInterface(this, "com.meizu.safe.engine.url.OnCheckUrlListener");
        }

        /* renamed from: a */
        public static OnCheckUrlListener m16976a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.meizu.safe.engine.url.OnCheckUrlListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof OnCheckUrlListener)) {
                return new C2798a(iBinder);
            }
            return (OnCheckUrlListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.meizu.safe.engine.url.OnCheckUrlListener");
                mo19187a(parcel.readInt() != 0 ? MzUrlCheckResult.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.meizu.safe.engine.url.OnCheckUrlListener");
                return true;
            }
        }

        /* renamed from: com.meizu.safe.engine.url.c$a$a */
        /* compiled from: OnCheckUrlListener */
        private static class C2798a implements OnCheckUrlListener {

            /* renamed from: a */
            private IBinder f15656a;

            C2798a(IBinder iBinder) {
                this.f15656a = iBinder;
            }

            public IBinder asBinder() {
                return this.f15656a;
            }

            /* renamed from: a */
            public void mo19187a(MzUrlCheckResult mzUrlCheckResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.safe.engine.url.OnCheckUrlListener");
                    if (mzUrlCheckResult != null) {
                        obtain.writeInt(1);
                        mzUrlCheckResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f15656a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
