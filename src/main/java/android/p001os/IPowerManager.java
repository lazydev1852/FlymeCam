package android.p001os;

/* renamed from: android.os.IPowerManager */
public interface IPowerManager extends IInterface {
    void setTemporaryScreenAutoBrightnessAdjustmentSettingOverride(float f) throws RemoteException;

    /* renamed from: android.os.IPowerManager$Stub */
    public static abstract class Stub extends Binder implements IPowerManager {
        private static final String DESCRIPTOR = "android.os.IPowerManager";

        /* renamed from: TRANSACTION_setTemporaryScreenAutoBrightnessAdjustmentSettingOverride */
        static final int f0x6dae2973 = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPowerManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPowerManager)) {
                return new C0006a(iBinder);
            }
            return (IPowerManager) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                setTemporaryScreenAutoBrightnessAdjustmentSettingOverride(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        /* renamed from: android.os.IPowerManager$Stub$a */
        private static class C0006a implements IPowerManager {

            /* renamed from: a */
            private IBinder f1a;

            C0006a(IBinder iBinder) {
                this.f1a = iBinder;
            }

            public IBinder asBinder() {
                return this.f1a;
            }

            public void setTemporaryScreenAutoBrightnessAdjustmentSettingOverride(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    this.f1a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
