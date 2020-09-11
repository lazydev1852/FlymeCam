package com.meizu.perf.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.meizu.perf.sdk.b */
public interface IBoostAffinity extends IInterface {
    /* renamed from: a */
    void mo23816a(String str, long j, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo23817a(String str, int[] iArr) throws RemoteException;

    /* renamed from: com.meizu.perf.sdk.b$a */
    /* compiled from: IBoostAffinity */
    public static abstract class C2783a extends Binder implements IBoostAffinity {
        /* renamed from: a */
        public static IBoostAffinity m16928a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.meizu.perf.sdk.IBoostAffinity");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBoostAffinity)) {
                return new C2784a(iBinder);
            }
            return (IBoostAffinity) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.meizu.perf.sdk.IBoostAffinity");
                        mo23816a(parcel.readString(), parcel.readLong(), parcel.createIntArray());
                        return true;
                    case 2:
                        parcel.enforceInterface("com.meizu.perf.sdk.IBoostAffinity");
                        mo23817a(parcel.readString(), parcel.createIntArray());
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.meizu.perf.sdk.IBoostAffinity");
                return true;
            }
        }

        /* renamed from: com.meizu.perf.sdk.b$a$a */
        /* compiled from: IBoostAffinity */
        private static class C2784a implements IBoostAffinity {

            /* renamed from: a */
            private IBinder f15622a;

            C2784a(IBinder iBinder) {
                this.f15622a = iBinder;
            }

            public IBinder asBinder() {
                return this.f15622a;
            }

            /* renamed from: a */
            public void mo23816a(String str, long j, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.perf.sdk.IBoostAffinity");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeIntArray(iArr);
                    this.f15622a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo23817a(String str, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.perf.sdk.IBoostAffinity");
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    this.f15622a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
