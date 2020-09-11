package com.loc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.loc.cw */
public interface ILocationProviderService extends IInterface {

    /* renamed from: com.loc.cw$a */
    /* compiled from: ILocationProviderService */
    public static abstract class C1089a extends Binder implements ILocationProviderService {

        /* renamed from: com.loc.cw$a$a */
        /* compiled from: ILocationProviderService */
        private static class C1090a implements ILocationProviderService {

            /* renamed from: a */
            private IBinder f3171a;

            C1090a(IBinder iBinder) {
                this.f3171a = iBinder;
            }

            /* renamed from: a */
            public final int mo13245a(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.service.locationprovider.ILocationProviderService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3171a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f3171a;
            }
        }

        /* renamed from: a */
        public static ILocationProviderService m3649a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.amap.api.service.locationprovider.ILocationProviderService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ILocationProviderService)) ? new C1090a(iBinder) : (ILocationProviderService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.amap.api.service.locationprovider.ILocationProviderService");
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                int a = mo13245a(bundle);
                parcel2.writeNoException();
                parcel2.writeInt(a);
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.amap.api.service.locationprovider.ILocationProviderService");
                return true;
            }
        }
    }

    /* renamed from: a */
    int mo13245a(Bundle bundle) throws RemoteException;
}
