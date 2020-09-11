package com.mediatek.search;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mediatek.common.search.SearchEngine;
import java.util.List;

public interface ISearchEngineManagerService extends IInterface {
    List<SearchEngine> getAvailables() throws RemoteException;

    SearchEngine getBestMatch(String str, String str2) throws RemoteException;

    SearchEngine getDefault() throws RemoteException;

    SearchEngine getSearchEngine(int i, String str) throws RemoteException;

    boolean setDefault(SearchEngine searchEngine) throws RemoteException;

    public static abstract class Stub extends Binder implements ISearchEngineManagerService {
        private static final String DESCRIPTOR = "com.mediatek.search.ISearchEngineManagerService";
        static final int TRANSACTION_getAvailables = 1;
        static final int TRANSACTION_getBestMatch = 3;
        static final int TRANSACTION_getDefault = 2;
        static final int TRANSACTION_getSearchEngine = 4;
        static final int TRANSACTION_setDefault = 5;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISearchEngineManagerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISearchEngineManagerService)) {
                return new Proxy(iBinder);
            }
            return (ISearchEngineManagerService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        List<SearchEngine> availables = getAvailables();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(availables);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        SearchEngine searchEngine = getDefault();
                        parcel2.writeNoException();
                        if (searchEngine != null) {
                            parcel2.writeInt(1);
                            searchEngine.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        SearchEngine bestMatch = getBestMatch(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (bestMatch != null) {
                            parcel2.writeInt(1);
                            bestMatch.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        SearchEngine searchEngine2 = getSearchEngine(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        if (searchEngine2 != null) {
                            parcel2.writeInt(1);
                            searchEngine2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean z = setDefault(parcel.readInt() != 0 ? (SearchEngine) SearchEngine.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(z ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements ISearchEngineManagerService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public List<SearchEngine> getAvailables() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(SearchEngine.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public SearchEngine getDefault() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (SearchEngine) SearchEngine.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public SearchEngine getBestMatch(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (SearchEngine) SearchEngine.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public SearchEngine getSearchEngine(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (SearchEngine) SearchEngine.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setDefault(SearchEngine searchEngine) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (searchEngine != null) {
                        obtain.writeInt(1);
                        searchEngine.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
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
