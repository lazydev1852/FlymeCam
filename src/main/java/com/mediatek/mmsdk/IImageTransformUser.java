package com.mediatek.mmsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mediatek.mmsdk.IMemory;

public interface IImageTransformUser extends IInterface {
    boolean applyTransform(ImageInfo imageInfo, IMemory iMemory, ImageInfo imageInfo2, IMemory iMemory2) throws RemoteException;

    String getName() throws RemoteException;

    public static abstract class Stub extends Binder implements IImageTransformUser {
        private static final String DESCRIPTOR = "com.mediatek.mmsdk.IImageTransformUser";
        static final int TRANSACTION_applyTransform = 2;
        static final int TRANSACTION_getName = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IImageTransformUser asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IImageTransformUser)) {
                return new Proxy(iBinder);
            }
            return (IImageTransformUser) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        String name = getName();
                        parcel2.writeNoException();
                        parcel2.writeString(name);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        ImageInfo imageInfo = null;
                        ImageInfo createFromParcel = parcel.readInt() != 0 ? ImageInfo.CREATOR.createFromParcel(parcel) : null;
                        IMemory asInterface = IMemory.Stub.asInterface(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            imageInfo = ImageInfo.CREATOR.createFromParcel(parcel);
                        }
                        boolean applyTransform = applyTransform(createFromParcel, asInterface, imageInfo, IMemory.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(applyTransform ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IImageTransformUser {
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

            public String getName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean applyTransform(ImageInfo imageInfo, IMemory iMemory, ImageInfo imageInfo2, IMemory iMemory2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (imageInfo != null) {
                        obtain.writeInt(1);
                        imageInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iMemory != null ? iMemory.asBinder() : null);
                    if (imageInfo2 != null) {
                        obtain.writeInt(1);
                        imageInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iMemory2 != null) {
                        iBinder = iMemory2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
