package com.iflytek.business.speech;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.iflytek.business.speech.IAIUIListener;

/* renamed from: com.iflytek.business.speech.c */
public interface IAIUIAgent extends IInterface {
    /* renamed from: a */
    void mo12871a(IAIUIListener dVar) throws RemoteException;

    /* renamed from: a */
    void mo12872a(IAIUIListener dVar, AIUIMessageParcel aIUIMessageParcel) throws RemoteException;

    /* renamed from: com.iflytek.business.speech.c$a */
    /* compiled from: IAIUIAgent */
    public static abstract class C1022a extends Binder implements IAIUIAgent {
        /* renamed from: a */
        public static IAIUIAgent m2769a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.iflytek.business.speech.IAIUIAgent");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAIUIAgent)) {
                return new C1023a(iBinder);
            }
            return (IAIUIAgent) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.iflytek.business.speech.IAIUIAgent");
                        mo12871a(IAIUIListener.C1024a.m2773a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.iflytek.business.speech.IAIUIAgent");
                        mo12872a(IAIUIListener.C1024a.m2773a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AIUIMessageParcel.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.iflytek.business.speech.IAIUIAgent");
                return true;
            }
        }

        /* renamed from: com.iflytek.business.speech.c$a$a */
        /* compiled from: IAIUIAgent */
        private static class C1023a implements IAIUIAgent {

            /* renamed from: a */
            private IBinder f2470a;

            C1023a(IBinder iBinder) {
                this.f2470a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2470a;
            }

            /* renamed from: a */
            public void mo12871a(IAIUIListener dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.IAIUIAgent");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f2470a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12872a(IAIUIListener dVar, AIUIMessageParcel aIUIMessageParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.iflytek.business.speech.IAIUIAgent");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (aIUIMessageParcel != null) {
                        obtain.writeInt(1);
                        aIUIMessageParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2470a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
