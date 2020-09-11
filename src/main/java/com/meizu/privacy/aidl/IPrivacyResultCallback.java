package com.meizu.privacy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.meizu.privacy.aidl.b */
public interface IPrivacyResultCallback extends IInterface {
    /* renamed from: a */
    void mo19028a() throws RemoteException;

    /* renamed from: a */
    void mo19029a(List<UpdatePrivateResult> list) throws RemoteException;

    /* renamed from: b */
    void mo19030b() throws RemoteException;

    /* renamed from: b */
    void mo19031b(List<UpdatePrivateResult> list) throws RemoteException;

    /* renamed from: c */
    void mo19032c(List<PrivateItem> list) throws RemoteException;

    /* renamed from: com.meizu.privacy.aidl.b$a */
    /* compiled from: IPrivacyResultCallback */
    public static abstract class C2792a extends Binder implements IPrivacyResultCallback {
        public IBinder asBinder() {
            return this;
        }

        public C2792a() {
            attachInterface(this, "com.meizu.privacy.aidl.IPrivacyResultCallback");
        }

        /* renamed from: a */
        public static IPrivacyResultCallback m16961a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.meizu.privacy.aidl.IPrivacyResultCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPrivacyResultCallback)) {
                return new C2793a(iBinder);
            }
            return (IPrivacyResultCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.meizu.privacy.aidl.IPrivacyResultCallback");
                        mo19029a(parcel.createTypedArrayList(UpdatePrivateResult.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.meizu.privacy.aidl.IPrivacyResultCallback");
                        mo19031b(parcel.createTypedArrayList(UpdatePrivateResult.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.meizu.privacy.aidl.IPrivacyResultCallback");
                        mo19032c(parcel.createTypedArrayList(PrivateItem.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.meizu.privacy.aidl.IPrivacyResultCallback");
                        mo19028a();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.meizu.privacy.aidl.IPrivacyResultCallback");
                        mo19030b();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.meizu.privacy.aidl.IPrivacyResultCallback");
                return true;
            }
        }

        /* renamed from: com.meizu.privacy.aidl.b$a$a */
        /* compiled from: IPrivacyResultCallback */
        private static class C2793a implements IPrivacyResultCallback {

            /* renamed from: a */
            private IBinder f15639a;

            C2793a(IBinder iBinder) {
                this.f15639a = iBinder;
            }

            public IBinder asBinder() {
                return this.f15639a;
            }

            /* renamed from: a */
            public void mo19029a(List<UpdatePrivateResult> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.privacy.aidl.IPrivacyResultCallback");
                    obtain.writeTypedList(list);
                    this.f15639a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo19031b(List<UpdatePrivateResult> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.privacy.aidl.IPrivacyResultCallback");
                    obtain.writeTypedList(list);
                    this.f15639a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo19032c(List<PrivateItem> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.privacy.aidl.IPrivacyResultCallback");
                    obtain.writeTypedList(list);
                    this.f15639a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo19028a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.privacy.aidl.IPrivacyResultCallback");
                    this.f15639a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo19030b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.privacy.aidl.IPrivacyResultCallback");
                    this.f15639a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
