package com.meizu.update.iresponse;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.meizu.update.iresponse.a */
public interface IMzUpdateResponse extends IInterface {
    /* renamed from: a */
    void mo24784a(int i, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo24785b(int i, Bundle bundle) throws RemoteException;

    /* renamed from: com.meizu.update.iresponse.a$a */
    /* compiled from: IMzUpdateResponse */
    public static abstract class C3024a extends Binder implements IMzUpdateResponse {
        public IBinder asBinder() {
            return this;
        }

        public C3024a() {
            attachInterface(this, "com.meizu.update.iresponse.IMzUpdateResponse");
        }

        /* renamed from: a */
        public static IMzUpdateResponse m17800a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.meizu.update.iresponse.IMzUpdateResponse");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMzUpdateResponse)) {
                return new C3025a(iBinder);
            }
            return (IMzUpdateResponse) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
            /*
                r2 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                if (r3 == r0) goto L_0x004d
                r0 = 0
                switch(r3) {
                    case 1: goto L_0x002e;
                    case 2: goto L_0x000f;
                    default: goto L_0x000a;
                }
            L_0x000a:
                boolean r3 = super.onTransact(r3, r4, r5, r6)
                return r3
            L_0x000f:
                java.lang.String r3 = "com.meizu.update.iresponse.IMzUpdateResponse"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                int r6 = r4.readInt()
                if (r6 == 0) goto L_0x0027
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r6.createFromParcel(r4)
                r0 = r4
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0027:
                r2.mo24784a(r3, r0)
                r5.writeNoException()
                return r1
            L_0x002e:
                java.lang.String r3 = "com.meizu.update.iresponse.IMzUpdateResponse"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                int r6 = r4.readInt()
                if (r6 == 0) goto L_0x0046
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r6.createFromParcel(r4)
                r0 = r4
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0046:
                r2.mo24785b(r3, r0)
                r5.writeNoException()
                return r1
            L_0x004d:
                java.lang.String r3 = "com.meizu.update.iresponse.IMzUpdateResponse"
                r5.writeString(r3)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.iresponse.IMzUpdateResponse.C3024a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: com.meizu.update.iresponse.a$a$a */
        /* compiled from: IMzUpdateResponse */
        private static class C3025a implements IMzUpdateResponse {

            /* renamed from: a */
            private IBinder f16302a;

            C3025a(IBinder iBinder) {
                this.f16302a = iBinder;
            }

            public IBinder asBinder() {
                return this.f16302a;
            }

            /* renamed from: b */
            public void mo24785b(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.update.iresponse.IMzUpdateResponse");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f16302a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo24784a(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.meizu.update.iresponse.IMzUpdateResponse");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f16302a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
