package com.meizu.statsrpk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.meizu.statsrpk.a */
public interface IRpkStatsInterface extends IInterface {
    /* renamed from: a */
    void mo24586a(RpkEvent rpkEvent, RpkInfo rpkInfo) throws RemoteException;

    /* renamed from: com.meizu.statsrpk.a$a */
    /* compiled from: IRpkStatsInterface */
    public static abstract class C2947a extends Binder implements IRpkStatsInterface {
        public IBinder asBinder() {
            return this;
        }

        public C2947a() {
            attachInterface(this, "com.meizu.statsrpk.IRpkStatsInterface");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.meizu.statsrpk.IRpkStatsInterface");
                RpkInfo rpkInfo = null;
                RpkEvent createFromParcel = parcel.readInt() != 0 ? RpkEvent.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    rpkInfo = RpkInfo.CREATOR.createFromParcel(parcel);
                }
                mo24586a(createFromParcel, rpkInfo);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.meizu.statsrpk.IRpkStatsInterface");
                return true;
            }
        }
    }
}
