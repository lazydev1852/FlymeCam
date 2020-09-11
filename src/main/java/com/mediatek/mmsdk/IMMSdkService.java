package com.mediatek.mmsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMMSdkService extends IInterface {
    int connectFeatureManager(BinderHolder binderHolder) throws RemoteException;

    int existCallbackClient() throws RemoteException;

    public static abstract class Stub extends Binder implements IMMSdkService {
        private static final String DESCRIPTOR = "com.mediatek.mmsdk.IMMSdkService";
        static final int TRANSACTION_connectFeatureManager = 1;
        static final int TRANSACTION_existCallbackClient = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMMSdkService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMMSdkService)) {
                return new Proxy(iBinder);
            }
            return (IMMSdkService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        BinderHolder binderHolder = new BinderHolder();
                        int connectFeatureManager = connectFeatureManager(binderHolder);
                        parcel2.writeNoException();
                        parcel2.writeInt(connectFeatureManager);
                        parcel2.writeInt(1);
                        binderHolder.writeToParcel(parcel2, 1);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        int existCallbackClient = existCallbackClient();
                        parcel2.writeNoException();
                        parcel2.writeInt(existCallbackClient);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IMMSdkService {
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

            public int connectFeatureManager(BinderHolder binderHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        binderHolder.readFromParcel(obtain2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int existCallbackClient() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
