package com.mediatek.mmsdk.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.mediatek.mmsdk.BaseParameters;
import java.util.List;

public interface ICallbackClient extends IInterface {
    int setOutputSurfaces(List<Surface> list, List<BaseParameters> list2) throws RemoteException;

    long start() throws RemoteException;

    long stop() throws RemoteException;

    public static abstract class Stub extends Binder implements ICallbackClient {
        private static final String DESCRIPTOR = "com.mediatek.mmsdk.callback.ICallbackClient";
        static final int TRANSACTION_setOutputSurfaces = 3;
        static final int TRANSACTION_start = 1;
        static final int TRANSACTION_stop = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICallbackClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ICallbackClient)) {
                return new Proxy(iBinder);
            }
            return (ICallbackClient) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        long start = start();
                        parcel2.writeNoException();
                        parcel2.writeLong(start);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        long stop = stop();
                        parcel2.writeNoException();
                        parcel2.writeLong(stop);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        int outputSurfaces = setOutputSurfaces(parcel.createTypedArrayList(Surface.CREATOR), parcel.createTypedArrayList(BaseParameters.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(outputSurfaces);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements ICallbackClient {
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

            public long start() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long stop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
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
                    this.mRemote.transact(3, obtain, obtain2, 0);
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
