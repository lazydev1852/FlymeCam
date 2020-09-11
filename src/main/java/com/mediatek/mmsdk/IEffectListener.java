package com.mediatek.mmsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mediatek.mmsdk.IEffectHalClient;

public interface IEffectListener extends IInterface {
    void onAborted(IEffectHalClient iEffectHalClient, BaseParameters baseParameters) throws RemoteException;

    void onCompleted(IEffectHalClient iEffectHalClient, BaseParameters baseParameters, long j) throws RemoteException;

    void onFailed(IEffectHalClient iEffectHalClient, BaseParameters baseParameters) throws RemoteException;

    void onInputFrameProcessed(IEffectHalClient iEffectHalClient, BaseParameters baseParameters, BaseParameters baseParameters2) throws RemoteException;

    void onOutputFrameProcessed(IEffectHalClient iEffectHalClient, BaseParameters baseParameters, BaseParameters baseParameters2) throws RemoteException;

    void onPrepared(IEffectHalClient iEffectHalClient, BaseParameters baseParameters) throws RemoteException;

    public static abstract class Stub extends Binder implements IEffectListener {
        private static final String DESCRIPTOR = "com.mediatek.mmsdk.IEffectListener";
        static final int TRANSACTION_onAborted = 5;
        static final int TRANSACTION_onCompleted = 4;
        static final int TRANSACTION_onFailed = 6;
        static final int TRANSACTION_onInputFrameProcessed = 2;
        static final int TRANSACTION_onOutputFrameProcessed = 3;
        static final int TRANSACTION_onPrepared = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IEffectListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IEffectListener)) {
                return new Proxy(iBinder);
            }
            return (IEffectListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                BaseParameters baseParameters = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        IEffectHalClient asInterface = IEffectHalClient.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        onPrepared(asInterface, baseParameters);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        IEffectHalClient asInterface2 = IEffectHalClient.Stub.asInterface(parcel.readStrongBinder());
                        BaseParameters createFromParcel = parcel.readInt() != 0 ? BaseParameters.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        onInputFrameProcessed(asInterface2, createFromParcel, baseParameters);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        IEffectHalClient asInterface3 = IEffectHalClient.Stub.asInterface(parcel.readStrongBinder());
                        BaseParameters createFromParcel2 = parcel.readInt() != 0 ? BaseParameters.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        onOutputFrameProcessed(asInterface3, createFromParcel2, baseParameters);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        IEffectHalClient asInterface4 = IEffectHalClient.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        onCompleted(asInterface4, baseParameters, parcel.readLong());
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        IEffectHalClient asInterface5 = IEffectHalClient.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        onAborted(asInterface5, baseParameters);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        IEffectHalClient asInterface6 = IEffectHalClient.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        onFailed(asInterface6, baseParameters);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IEffectListener {
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

            public void onPrepared(IEffectHalClient iEffectHalClient, BaseParameters baseParameters) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEffectHalClient != null ? iEffectHalClient.asBinder() : null);
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onInputFrameProcessed(IEffectHalClient iEffectHalClient, BaseParameters baseParameters, BaseParameters baseParameters2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEffectHalClient != null ? iEffectHalClient.asBinder() : null);
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseParameters2 != null) {
                        obtain.writeInt(1);
                        baseParameters2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onOutputFrameProcessed(IEffectHalClient iEffectHalClient, BaseParameters baseParameters, BaseParameters baseParameters2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEffectHalClient != null ? iEffectHalClient.asBinder() : null);
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseParameters2 != null) {
                        obtain.writeInt(1);
                        baseParameters2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onCompleted(IEffectHalClient iEffectHalClient, BaseParameters baseParameters, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEffectHalClient != null ? iEffectHalClient.asBinder() : null);
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onAborted(IEffectHalClient iEffectHalClient, BaseParameters baseParameters) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEffectHalClient != null ? iEffectHalClient.asBinder() : null);
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onFailed(IEffectHalClient iEffectHalClient, BaseParameters baseParameters) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEffectHalClient != null ? iEffectHalClient.asBinder() : null);
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
