package com.mediatek.mmsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IEffectFactory extends IInterface {
    int createCallbackClient(EffectHalVersion effectHalVersion, BinderHolder binderHolder) throws RemoteException;

    int createEffectHal(EffectHalVersion effectHalVersion, BinderHolder binderHolder) throws RemoteException;

    int createEffectHalClient(EffectHalVersion effectHalVersion, BinderHolder binderHolder) throws RemoteException;

    int getAllSupportedEffectHal(List<String> list) throws RemoteException;

    int getSupportedVersion(String str, List<EffectHalVersion> list) throws RemoteException;

    public static abstract class Stub extends Binder implements IEffectFactory {
        private static final String DESCRIPTOR = "com.mediatek.mmsdk.IEffectFactory";
        static final int TRANSACTION_createCallbackClient = 1;
        static final int TRANSACTION_createEffectHal = 2;
        static final int TRANSACTION_createEffectHalClient = 3;
        static final int TRANSACTION_getAllSupportedEffectHal = 5;
        static final int TRANSACTION_getSupportedVersion = 4;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IEffectFactory asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IEffectFactory)) {
                return new Proxy(iBinder);
            }
            return (IEffectFactory) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                EffectHalVersion effectHalVersion = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            effectHalVersion = EffectHalVersion.CREATOR.createFromParcel(parcel);
                        }
                        BinderHolder binderHolder = new BinderHolder();
                        int createCallbackClient = createCallbackClient(effectHalVersion, binderHolder);
                        parcel2.writeNoException();
                        parcel2.writeInt(createCallbackClient);
                        parcel2.writeInt(1);
                        binderHolder.writeToParcel(parcel2, 1);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            effectHalVersion = EffectHalVersion.CREATOR.createFromParcel(parcel);
                        }
                        BinderHolder binderHolder2 = new BinderHolder();
                        int createEffectHal = createEffectHal(effectHalVersion, binderHolder2);
                        parcel2.writeNoException();
                        parcel2.writeInt(createEffectHal);
                        parcel2.writeInt(1);
                        binderHolder2.writeToParcel(parcel2, 1);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            effectHalVersion = EffectHalVersion.CREATOR.createFromParcel(parcel);
                        }
                        BinderHolder binderHolder3 = new BinderHolder();
                        int createEffectHalClient = createEffectHalClient(effectHalVersion, binderHolder3);
                        parcel2.writeNoException();
                        parcel2.writeInt(createEffectHalClient);
                        parcel2.writeInt(1);
                        binderHolder3.writeToParcel(parcel2, 1);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        ArrayList arrayList = new ArrayList();
                        int supportedVersion = getSupportedVersion(readString, arrayList);
                        parcel2.writeNoException();
                        parcel2.writeInt(supportedVersion);
                        parcel2.writeTypedList(arrayList);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        ArrayList arrayList2 = new ArrayList();
                        int allSupportedEffectHal = getAllSupportedEffectHal(arrayList2);
                        parcel2.writeNoException();
                        parcel2.writeInt(allSupportedEffectHal);
                        parcel2.writeStringList(arrayList2);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IEffectFactory {
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

            public int createCallbackClient(EffectHalVersion effectHalVersion, BinderHolder binderHolder) throws RemoteException {
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

            public int createEffectHal(EffectHalVersion effectHalVersion, BinderHolder binderHolder) throws RemoteException {
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
                    this.mRemote.transact(2, obtain, obtain2, 0);
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

            public int createEffectHalClient(EffectHalVersion effectHalVersion, BinderHolder binderHolder) throws RemoteException {
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

            public int getSupportedVersion(String str, List<EffectHalVersion> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readTypedList(list, EffectHalVersion.CREATOR);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getAllSupportedEffectHal(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readStringList(list);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
