package com.meizu.media.gallery;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.meizu.media.gallery.IThumbnailCallback;

public interface IThumbnailController extends IInterface {
    void registerCallback(IThumbnailCallback iThumbnailCallback) throws RemoteException;

    void unregisterCallback(IThumbnailCallback iThumbnailCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IThumbnailController {
        private static final String DESCRIPTOR = "com.meizu.media.gallery.IThumbnailController";
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IThumbnailController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IThumbnailController)) {
                return new C2759a(iBinder);
            }
            return (IThumbnailController) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        registerCallback(IThumbnailCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisterCallback(IThumbnailCallback.Stub.asInterface(parcel.readStrongBinder()));
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

        /* renamed from: com.meizu.media.gallery.IThumbnailController$Stub$a */
        private static class C2759a implements IThumbnailController {

            /* renamed from: a */
            private IBinder f15592a;

            C2759a(IBinder iBinder) {
                this.f15592a = iBinder;
            }

            public IBinder asBinder() {
                return this.f15592a;
            }

            public void registerCallback(IThumbnailCallback iThumbnailCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iThumbnailCallback != null ? iThumbnailCallback.asBinder() : null);
                    this.f15592a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterCallback(IThumbnailCallback iThumbnailCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iThumbnailCallback != null ? iThumbnailCallback.asBinder() : null);
                    this.f15592a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
