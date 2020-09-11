package com.meizu.privacy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.meizu.privacy.aidl.IPrivacyResultCallback;
import java.util.List;

/* renamed from: com.meizu.privacy.aidl.a */
public interface IPrivacyController extends IInterface {
    /* renamed from: a */
    void mo23840a(int i, IPrivacyResultCallback bVar) throws RemoteException;

    /* renamed from: a */
    void mo23841a(IPrivacyResultCallback bVar) throws RemoteException;

    /* renamed from: a */
    void mo23842a(List<String> list, int i, IPrivacyResultCallback bVar) throws RemoteException;

    /* renamed from: b */
    void mo23843b(IPrivacyResultCallback bVar) throws RemoteException;

    /* renamed from: b */
    void mo23844b(List<String> list, int i, IPrivacyResultCallback bVar) throws RemoteException;

    /* renamed from: com.meizu.privacy.aidl.a$a */
    /* compiled from: IPrivacyController */
    public static abstract class C2790a extends Binder implements IPrivacyController {
        /* renamed from: a */
        public static IPrivacyController m16950a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.meizu.privacy.aidl.IPrivacyController");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPrivacyController)) {
                return new C2791a(iBinder);
            }
            return (IPrivacyController) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.meizu.privacy.aidl.IPrivacyController");
                        mo23842a(parcel.createStringArrayList(), parcel.readInt(), IPrivacyResultCallback.C2792a.m16961a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.meizu.privacy.aidl.IPrivacyController");
                        mo23844b(parcel.createStringArrayList(), parcel.readInt(), IPrivacyResultCallback.C2792a.m16961a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.meizu.privacy.aidl.IPrivacyController");
                        mo23840a(parcel.readInt(), IPrivacyResultCallback.C2792a.m16961a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.meizu.privacy.aidl.IPrivacyController");
                        mo23841a(IPrivacyResultCallback.C2792a.m16961a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.meizu.privacy.aidl.IPrivacyController");
                        mo23843b(IPrivacyResultCallback.C2792a.m16961a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.meizu.privacy.aidl.IPrivacyController");
                return true;
            }
        }

        /* renamed from: com.meizu.privacy.aidl.a$a$a */
        /* compiled from: IPrivacyController */
        private static class C2791a implements IPrivacyController {

            /* renamed from: a */
            private IBinder f15638a;

            C2791a(IBinder iBinder) {
                this.f15638a = iBinder;
            }

            public IBinder asBinder() {
                return this.f15638a;
            }

            /* renamed from: a */
            public void mo23842a(List<String> list, int i, IPrivacyResultCallback bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.privacy.aidl.IPrivacyController");
                    obtain.writeStringList(list);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f15638a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo23844b(List<String> list, int i, IPrivacyResultCallback bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.privacy.aidl.IPrivacyController");
                    obtain.writeStringList(list);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f15638a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo23840a(int i, IPrivacyResultCallback bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.privacy.aidl.IPrivacyController");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f15638a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo23841a(IPrivacyResultCallback bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.privacy.aidl.IPrivacyController");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f15638a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo23843b(IPrivacyResultCallback bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.privacy.aidl.IPrivacyController");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f15638a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
