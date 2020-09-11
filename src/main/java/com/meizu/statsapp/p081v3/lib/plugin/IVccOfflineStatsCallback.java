package com.meizu.statsapp.p081v3.lib.plugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsCallback */
public interface IVccOfflineStatsCallback extends IInterface {
    void onRealBulkInsertEvents(String str, List list) throws RemoteException;

    void onRealInsertEvent(String str, long j) throws RemoteException;

    void onRealInsertH5Event(String str, long j) throws RemoteException;

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsCallback$Stub */
    public static abstract class Stub extends Binder implements IVccOfflineStatsCallback {
        private static final String DESCRIPTOR = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsCallback";
        static final int TRANSACTION_onRealBulkInsertEvents = 2;
        static final int TRANSACTION_onRealInsertEvent = 1;
        static final int TRANSACTION_onRealInsertH5Event = 3;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVccOfflineStatsCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IVccOfflineStatsCallback)) {
                return new Proxy(iBinder);
            }
            return (IVccOfflineStatsCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        onRealInsertEvent(parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onRealBulkInsertEvents(parcel.readString(), parcel.readArrayList(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onRealInsertH5Event(parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        /* renamed from: com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsCallback$Stub$Proxy */
        private static class Proxy implements IVccOfflineStatsCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onRealInsertEvent(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRealBulkInsertEvents(String str, List list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeList(list);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRealInsertH5Event(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
