package android.nonvccUsageStats;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

public interface INonVccStatsInterfaces extends IInterface {
    void onAppEvent(String str, String str2, Map map, String str3) throws RemoteException;

    void onAppEventRealtime(String str, String str2, Map map, String str3) throws RemoteException;

    void onOsEvent(String str, String str2, Map map) throws RemoteException;

    void onOsEventRealtime(String str, String str2, Map map) throws RemoteException;

    public static abstract class Stub extends Binder implements INonVccStatsInterfaces {
        private static final String DESCRIPTOR = "android.nonvccUsageStats.INonVccStatsInterfaces";
        static final int TRANSACTION_onAppEvent = 3;
        static final int TRANSACTION_onAppEventRealtime = 4;
        static final int TRANSACTION_onOsEvent = 1;
        static final int TRANSACTION_onOsEventRealtime = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INonVccStatsInterfaces asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof INonVccStatsInterfaces)) {
                return new Proxy(iBinder);
            }
            return (INonVccStatsInterfaces) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        onOsEvent(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onOsEventRealtime(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onAppEvent(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), parcel.readString());
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        onAppEventRealtime(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), parcel.readString());
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements INonVccStatsInterfaces {
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

            public void onOsEvent(String str, String str2, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onOsEventRealtime(String str, String str2, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onAppEvent(String str, String str2, Map map, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    obtain.writeString(str3);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onAppEventRealtime(String str, String str2, Map map, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    obtain.writeString(str3);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
