package com.meizu.media.gallery;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IThumbnailCallback extends IInterface {
    void onThumbnailAnimationEnd(boolean z, ThumbnailResult thumbnailResult) throws RemoteException;

    void onThumbnailAnimationStart(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IThumbnailCallback {
        private static final String DESCRIPTOR = "com.meizu.media.gallery.IThumbnailCallback";
        static final int TRANSACTION_onThumbnailAnimationEnd = 2;
        static final int TRANSACTION_onThumbnailAnimationStart = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IThumbnailCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IThumbnailCallback)) {
                return new C2758a(iBinder);
            }
            return (IThumbnailCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                boolean z = false;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onThumbnailAnimationStart(z);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onThumbnailAnimationEnd(z, parcel.readInt() != 0 ? ThumbnailResult.CREATOR.createFromParcel(parcel) : null);
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

        /* renamed from: com.meizu.media.gallery.IThumbnailCallback$Stub$a */
        private static class C2758a implements IThumbnailCallback {

            /* renamed from: a */
            private IBinder f15591a;

            C2758a(IBinder iBinder) {
                this.f15591a = iBinder;
            }

            public IBinder asBinder() {
                return this.f15591a;
            }

            public void onThumbnailAnimationStart(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.f15591a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onThumbnailAnimationEnd(boolean z, ThumbnailResult thumbnailResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (thumbnailResult != null) {
                        obtain.writeInt(1);
                        thumbnailResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f15591a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
