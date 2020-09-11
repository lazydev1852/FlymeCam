package com.mediatek.mmsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IFeatureManager extends IInterface {
    int getEffectFactory(BinderHolder binderHolder) throws RemoteException;

    String getParameter(String str) throws RemoteException;

    int setParameter(String str, String str2) throws RemoteException;

    int setUp(EffectHalVersion effectHalVersion) throws RemoteException;

    int tearDown(EffectHalVersion effectHalVersion) throws RemoteException;

    public static abstract class Stub extends Binder implements IFeatureManager {
        private static final String DESCRIPTOR = "com.mediatek.mmsdk.IFeatureManager";
        static final int TRANSACTION_getEffectFactory = 5;
        static final int TRANSACTION_getParameter = 2;
        static final int TRANSACTION_setParameter = 1;
        static final int TRANSACTION_setUp = 3;
        static final int TRANSACTION_tearDown = 4;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFeatureManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IFeatureManager)) {
                return new Proxy(iBinder);
            }
            return (IFeatureManager) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                EffectHalVersion effectHalVersion = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int parameter = setParameter(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(parameter);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        String parameter2 = getParameter(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(parameter2);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            effectHalVersion = EffectHalVersion.CREATOR.createFromParcel(parcel);
                        }
                        int up = setUp(effectHalVersion);
                        parcel2.writeNoException();
                        parcel2.writeInt(up);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            effectHalVersion = EffectHalVersion.CREATOR.createFromParcel(parcel);
                        }
                        int tearDown = tearDown(effectHalVersion);
                        parcel2.writeNoException();
                        parcel2.writeInt(tearDown);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        BinderHolder binderHolder = new BinderHolder();
                        int effectFactory = getEffectFactory(binderHolder);
                        parcel2.writeNoException();
                        parcel2.writeInt(effectFactory);
                        parcel2.writeInt(1);
                        binderHolder.writeToParcel(parcel2, 1);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IFeatureManager {
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

            public int setParameter(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getParameter(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setUp(EffectHalVersion effectHalVersion) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (effectHalVersion != null) {
                        obtain.writeInt(1);
                        effectHalVersion.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int tearDown(EffectHalVersion effectHalVersion) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (effectHalVersion != null) {
                        obtain.writeInt(1);
                        effectHalVersion.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getEffectFactory(BinderHolder binderHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
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
        }
    }
}
