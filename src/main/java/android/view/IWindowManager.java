package android.view;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.IRemoteKeyEventListener;

public interface IWindowManager extends IInterface {
    boolean hasNavigationBar() throws RemoteException;

    void registerRemoteKeyEventListener(IRemoteKeyEventListener iRemoteKeyEventListener) throws RemoteException;

    void unregisterRemoteKeyEventListener(IRemoteKeyEventListener iRemoteKeyEventListener) throws RemoteException;

    public static abstract class Stub extends Binder implements IWindowManager {
        private static final String DESCRIPTOR = "android.view.IWindowManager";
        static final int TRANSACTION_hasNavigationBar = 3;
        static final int TRANSACTION_registerRemoteKeyEventListener = 1;
        static final int TRANSACTION_unregisterRemoteKeyEventListener = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IWindowManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWindowManager)) {
                return new C0009a(iBinder);
            }
            return (IWindowManager) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        registerRemoteKeyEventListener(IRemoteKeyEventListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisterRemoteKeyEventListener(IRemoteKeyEventListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean hasNavigationBar = hasNavigationBar();
                        parcel2.writeNoException();
                        parcel2.writeInt(hasNavigationBar ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        /* renamed from: android.view.IWindowManager$Stub$a */
        private static class C0009a implements IWindowManager {

            /* renamed from: a */
            private IBinder f3a;

            C0009a(IBinder iBinder) {
                this.f3a = iBinder;
            }

            public IBinder asBinder() {
                return this.f3a;
            }

            public void registerRemoteKeyEventListener(IRemoteKeyEventListener iRemoteKeyEventListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteKeyEventListener != null ? iRemoteKeyEventListener.asBinder() : null);
                    this.f3a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterRemoteKeyEventListener(IRemoteKeyEventListener iRemoteKeyEventListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteKeyEventListener != null ? iRemoteKeyEventListener.asBinder() : null);
                    this.f3a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasNavigationBar() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.f3a.transact(3, obtain, obtain2, 0);
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
        }
    }
}
