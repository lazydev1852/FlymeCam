package android.view;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IRemoteKeyEventListener extends IInterface {
    void onKeyEvent(int i, KeyEvent keyEvent) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteKeyEventListener {
        private static final String DESCRIPTOR = "android.view.IRemoteKeyEventListener";
        static final int TRANSACTION_onKeyEvent = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteKeyEventListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteKeyEventListener)) {
                return new C0008a(iBinder);
            }
            return (IRemoteKeyEventListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onKeyEvent(parcel.readInt(), parcel.readInt() != 0 ? (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        /* renamed from: android.view.IRemoteKeyEventListener$Stub$a */
        private static class C0008a implements IRemoteKeyEventListener {

            /* renamed from: a */
            private IBinder f2a;

            C0008a(IBinder iBinder) {
                this.f2a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2a;
            }

            public void onKeyEvent(int i, KeyEvent keyEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
