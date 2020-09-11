package com.mediatek.mmsdk;

import android.graphics.GraphicBuffer;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mediatek.mmsdk.IEffectListener;

public interface IEffectHal extends IInterface {
    int abort(BaseParameters baseParameters) throws RemoteException;

    int addInputFrame(GraphicBuffer graphicBuffer, BaseParameters baseParameters) throws RemoteException;

    int addOutputFrame(GraphicBuffer graphicBuffer, BaseParameters baseParameters) throws RemoteException;

    int configure() throws RemoteException;

    int getCaptureRequirement(BaseParameters baseParameters) throws RemoteException;

    int getNameVersion(EffectHalVersion effectHalVersion) throws RemoteException;

    int init() throws RemoteException;

    int prepare() throws RemoteException;

    int release() throws RemoteException;

    int setEffectListener(IEffectListener iEffectListener) throws RemoteException;

    int setParameter(String str, String str2) throws RemoteException;

    long start() throws RemoteException;

    int unconfigure() throws RemoteException;

    int uninit() throws RemoteException;

    public static abstract class Stub extends Binder implements IEffectHal {
        private static final String DESCRIPTOR = "com.mediatek.mmsdk.IEffectHal";
        static final int TRANSACTION_abort = 6;
        static final int TRANSACTION_addInputFrame = 13;
        static final int TRANSACTION_addOutputFrame = 14;
        static final int TRANSACTION_configure = 3;
        static final int TRANSACTION_getCaptureRequirement = 10;
        static final int TRANSACTION_getNameVersion = 7;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_prepare = 11;
        static final int TRANSACTION_release = 12;
        static final int TRANSACTION_setEffectListener = 8;
        static final int TRANSACTION_setParameter = 9;
        static final int TRANSACTION_start = 5;
        static final int TRANSACTION_unconfigure = 4;
        static final int TRANSACTION_uninit = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IEffectHal asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IEffectHal)) {
                return new Proxy(iBinder);
            }
            return (IEffectHal) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                BaseParameters baseParameters = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int init = init();
                        parcel2.writeNoException();
                        parcel2.writeInt(init);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        int uninit = uninit();
                        parcel2.writeNoException();
                        parcel2.writeInt(uninit);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        int configure = configure();
                        parcel2.writeNoException();
                        parcel2.writeInt(configure);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int unconfigure = unconfigure();
                        parcel2.writeNoException();
                        parcel2.writeInt(unconfigure);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        long start = start();
                        parcel2.writeNoException();
                        parcel2.writeLong(start);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        int abort = abort(baseParameters);
                        parcel2.writeNoException();
                        parcel2.writeInt(abort);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        EffectHalVersion effectHalVersion = new EffectHalVersion();
                        int nameVersion = getNameVersion(effectHalVersion);
                        parcel2.writeNoException();
                        parcel2.writeInt(nameVersion);
                        parcel2.writeInt(1);
                        effectHalVersion.writeToParcel(parcel2, 1);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        int effectListener = setEffectListener(IEffectListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(effectListener);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        int parameter = setParameter(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(parameter);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        BaseParameters baseParameters2 = new BaseParameters();
                        int captureRequirement = getCaptureRequirement(baseParameters2);
                        parcel2.writeNoException();
                        parcel2.writeInt(captureRequirement);
                        parcel2.writeInt(1);
                        baseParameters2.writeToParcel(parcel2, 1);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        int prepare = prepare();
                        parcel2.writeNoException();
                        parcel2.writeInt(prepare);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        int release = release();
                        parcel2.writeNoException();
                        parcel2.writeInt(release);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        GraphicBuffer graphicBuffer = parcel.readInt() != 0 ? (GraphicBuffer) GraphicBuffer.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        int addInputFrame = addInputFrame(graphicBuffer, baseParameters);
                        parcel2.writeNoException();
                        parcel2.writeInt(addInputFrame);
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        GraphicBuffer graphicBuffer2 = parcel.readInt() != 0 ? (GraphicBuffer) GraphicBuffer.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        int addOutputFrame = addOutputFrame(graphicBuffer2, baseParameters);
                        parcel2.writeNoException();
                        parcel2.writeInt(addOutputFrame);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IEffectHal {
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

            public int init() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int uninit() throws RemoteException {
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

            public int configure() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int unconfigure() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long start() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int abort(BaseParameters baseParameters) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getNameVersion(EffectHalVersion effectHalVersion) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        effectHalVersion.readFromParcel(obtain2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setEffectListener(IEffectListener iEffectListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEffectListener != null ? iEffectListener.asBinder() : null);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setParameter(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getCaptureRequirement(BaseParameters baseParameters) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        baseParameters.readFromParcel(obtain2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int prepare() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int release() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int addInputFrame(GraphicBuffer graphicBuffer, BaseParameters baseParameters) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (graphicBuffer != null) {
                        obtain.writeInt(1);
                        graphicBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int addOutputFrame(GraphicBuffer graphicBuffer, BaseParameters baseParameters) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (graphicBuffer != null) {
                        obtain.writeInt(1);
                        graphicBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(14, obtain, obtain2, 0);
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
