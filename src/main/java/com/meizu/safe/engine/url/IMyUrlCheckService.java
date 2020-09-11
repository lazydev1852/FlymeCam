package com.meizu.safe.engine.url;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.meizu.safe.engine.url.OnCheckUrlListener;

/* renamed from: com.meizu.safe.engine.url.a */
public interface IMyUrlCheckService extends IInterface {
    /* renamed from: a */
    void mo23857a(String str) throws RemoteException;

    /* renamed from: a */
    void mo23858a(String str, OnCheckUrlListener cVar) throws RemoteException;

    /* renamed from: com.meizu.safe.engine.url.a$a */
    /* compiled from: IMyUrlCheckService */
    public static abstract class C2795a extends Binder implements IMyUrlCheckService {
        /* renamed from: a */
        public static IMyUrlCheckService m16971a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.meizu.safe.engine.url.IMyUrlCheckService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMyUrlCheckService)) {
                return new C2796a(iBinder);
            }
            return (IMyUrlCheckService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.meizu.safe.engine.url.IMyUrlCheckService");
                        mo23858a(parcel.readString(), OnCheckUrlListener.C2797a.m16976a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.meizu.safe.engine.url.IMyUrlCheckService");
                        mo23857a(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.meizu.safe.engine.url.IMyUrlCheckService");
                return true;
            }
        }

        /* renamed from: com.meizu.safe.engine.url.a$a$a */
        /* compiled from: IMyUrlCheckService */
        private static class C2796a implements IMyUrlCheckService {

            /* renamed from: a */
            private IBinder f15647a;

            C2796a(IBinder iBinder) {
                this.f15647a = iBinder;
            }

            public IBinder asBinder() {
                return this.f15647a;
            }

            /* renamed from: a */
            public void mo23858a(String str, OnCheckUrlListener cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.safe.engine.url.IMyUrlCheckService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.f15647a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo23857a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.safe.engine.url.IMyUrlCheckService");
                    obtain.writeString(str);
                    this.f15647a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
