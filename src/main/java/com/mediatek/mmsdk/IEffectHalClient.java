package com.mediatek.mmsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.mediatek.mmsdk.IEffectListener;
import java.util.ArrayList;
import java.util.List;

public interface IEffectHalClient extends IInterface {
    int abort(BaseParameters baseParameters) throws RemoteException;

    int addInputParameter(int i, BaseParameters baseParameters, long j, boolean z) throws RemoteException;

    int addOutputParameter(int i, BaseParameters baseParameters, long j, boolean z) throws RemoteException;

    int configure() throws RemoteException;

    int dequeueAndQueueBuf(long j) throws RemoteException;

    int getCaptureRequirement(BaseParameters baseParameters, List<BaseParameters> list) throws RemoteException;

    int getInputSurfaces(List<Surface> list) throws RemoteException;

    boolean getInputsyncMode(int i) throws RemoteException;

    int getNameVersion(EffectHalVersion effectHalVersion) throws RemoteException;

    boolean getOutputsyncMode(int i) throws RemoteException;

    int init() throws RemoteException;

    int prepare() throws RemoteException;

    int release() throws RemoteException;

    int setBaseParameter(BaseParameters baseParameters) throws RemoteException;

    int setEffectListener(IEffectListener iEffectListener) throws RemoteException;

    int setInputsyncMode(int i, boolean z) throws RemoteException;

    int setOutputSurfaces(List<Surface> list, List<BaseParameters> list2) throws RemoteException;

    int setOutputsyncMode(int i, boolean z) throws RemoteException;

    int setParameter(String str, String str2) throws RemoteException;

    int setParameters(BaseParameters baseParameters) throws RemoteException;

    long start() throws RemoteException;

    int unconfigure() throws RemoteException;

    int uninit() throws RemoteException;

    public static abstract class Stub extends Binder implements IEffectHalClient {
        private static final String DESCRIPTOR = "com.mediatek.mmsdk.IEffectHalClient";
        static final int TRANSACTION_abort = 6;
        static final int TRANSACTION_addInputParameter = 16;
        static final int TRANSACTION_addOutputParameter = 17;
        static final int TRANSACTION_configure = 3;
        static final int TRANSACTION_dequeueAndQueueBuf = 23;
        static final int TRANSACTION_getCaptureRequirement = 11;
        static final int TRANSACTION_getInputSurfaces = 14;
        static final int TRANSACTION_getInputsyncMode = 19;
        static final int TRANSACTION_getNameVersion = 7;
        static final int TRANSACTION_getOutputsyncMode = 21;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_prepare = 12;
        static final int TRANSACTION_release = 13;
        static final int TRANSACTION_setBaseParameter = 22;
        static final int TRANSACTION_setEffectListener = 8;
        static final int TRANSACTION_setInputsyncMode = 18;
        static final int TRANSACTION_setOutputSurfaces = 15;
        static final int TRANSACTION_setOutputsyncMode = 20;
        static final int TRANSACTION_setParameter = 9;
        static final int TRANSACTION_setParameters = 10;
        static final int TRANSACTION_start = 5;
        static final int TRANSACTION_unconfigure = 4;
        static final int TRANSACTION_uninit = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IEffectHalClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IEffectHalClient)) {
                return new Proxy(iBinder);
            }
            return (IEffectHalClient) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                boolean z = false;
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
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        int parameters = setParameters(baseParameters);
                        parcel2.writeNoException();
                        parcel2.writeInt(parameters);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        ArrayList arrayList = new ArrayList();
                        int captureRequirement = getCaptureRequirement(baseParameters, arrayList);
                        parcel2.writeNoException();
                        parcel2.writeInt(captureRequirement);
                        parcel2.writeTypedList(arrayList);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        int prepare = prepare();
                        parcel2.writeNoException();
                        parcel2.writeInt(prepare);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        int release = release();
                        parcel2.writeNoException();
                        parcel2.writeInt(release);
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        ArrayList arrayList2 = new ArrayList();
                        int inputSurfaces = getInputSurfaces(arrayList2);
                        parcel2.writeNoException();
                        parcel2.writeInt(inputSurfaces);
                        parcel2.writeTypedList(arrayList2);
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        int outputSurfaces = setOutputSurfaces(parcel.createTypedArrayList(Surface.CREATOR), parcel.createTypedArrayList(BaseParameters.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(outputSurfaces);
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        int addInputParameter = addInputParameter(readInt, baseParameters, parcel.readLong(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        parcel2.writeInt(addInputParameter);
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        int addOutputParameter = addOutputParameter(readInt2, baseParameters, parcel.readLong(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        parcel2.writeInt(addOutputParameter);
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt3 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        int inputsyncMode = setInputsyncMode(readInt3, z);
                        parcel2.writeNoException();
                        parcel2.writeInt(inputsyncMode);
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean inputsyncMode2 = getInputsyncMode(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(inputsyncMode2 ? 1 : 0);
                        return true;
                    case 20:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt4 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        int outputsyncMode = setOutputsyncMode(readInt4, z);
                        parcel2.writeNoException();
                        parcel2.writeInt(outputsyncMode);
                        return true;
                    case 21:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean outputsyncMode2 = getOutputsyncMode(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(outputsyncMode2 ? 1 : 0);
                        return true;
                    case 22:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            baseParameters = BaseParameters.CREATOR.createFromParcel(parcel);
                        }
                        int baseParameter = setBaseParameter(baseParameters);
                        parcel2.writeNoException();
                        parcel2.writeInt(baseParameter);
                        return true;
                    case 23:
                        parcel.enforceInterface(DESCRIPTOR);
                        int dequeueAndQueueBuf = dequeueAndQueueBuf(parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(dequeueAndQueueBuf);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IEffectHalClient {
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

            public int setParameters(BaseParameters baseParameters) throws RemoteException {
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
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getCaptureRequirement(BaseParameters baseParameters, List<BaseParameters> list) throws RemoteException {
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
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readTypedList(list, BaseParameters.CREATOR);
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
                    this.mRemote.transact(12, obtain, obtain2, 0);
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
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getInputSurfaces(List<Surface> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readTypedList(list, Surface.CREATOR);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setOutputSurfaces(List<Surface> list, List<BaseParameters> list2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    obtain.writeTypedList(list2);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int addInputParameter(int i, BaseParameters baseParameters, long j, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int addOutputParameter(int i, BaseParameters baseParameters, long j, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (baseParameters != null) {
                        obtain.writeInt(1);
                        baseParameters.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setInputsyncMode(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getInputsyncMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setOutputsyncMode(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getOutputsyncMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setBaseParameter(BaseParameters baseParameters) throws RemoteException {
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
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int dequeueAndQueueBuf(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(23, obtain, obtain2, 0);
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
