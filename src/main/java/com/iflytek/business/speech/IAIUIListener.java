package com.iflytek.business.speech;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.iflytek.business.speech.d */
public interface IAIUIListener extends IInterface {
    /* renamed from: a */
    void mo12875a(AIUIEventParcel aIUIEventParcel) throws RemoteException;

    /* renamed from: com.iflytek.business.speech.d$a */
    /* compiled from: IAIUIListener */
    public static abstract class C1024a extends Binder implements IAIUIListener {
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: a */
        public static IAIUIListener m2773a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.iflytek.business.speech.IAIUIListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAIUIListener)) {
                return new C1025a(iBinder);
            }
            return (IAIUIListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.iflytek.business.speech.IAIUIListener");
                mo12875a(parcel.readInt() != 0 ? AIUIEventParcel.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.iflytek.business.speech.IAIUIListener");
                return true;
            }
        }

        /* renamed from: com.iflytek.business.speech.d$a$a */
        /* compiled from: IAIUIListener */
        private static class C1025a implements IAIUIListener {

            /* renamed from: a */
            private IBinder f2471a;

            C1025a(IBinder iBinder) {
                this.f2471a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2471a;
            }

            /* renamed from: a */
            public void mo12875a(AIUIEventParcel aIUIEventParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.IAIUIListener");
                    if (aIUIEventParcel != null) {
                        obtain.writeInt(1);
                        aIUIEventParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2471a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
