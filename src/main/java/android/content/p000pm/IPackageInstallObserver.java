package android.content.p000pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: android.content.pm.IPackageInstallObserver */
public interface IPackageInstallObserver extends IInterface {
    void packageInstalled(String str, int i) throws RemoteException;

    /* renamed from: android.content.pm.IPackageInstallObserver$a */
    public static abstract class C0000a extends Binder implements IPackageInstallObserver {
        public IBinder asBinder() {
            return this;
        }

        public C0000a() {
            attachInterface(this, "android.content.pm.IPackageInstallObserver");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.content.pm.IPackageInstallObserver");
                packageInstalled(parcel.readString(), parcel.readInt());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.content.pm.IPackageInstallObserver");
                return true;
            }
        }
    }
}
