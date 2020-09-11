package com.meizu.statsapp.p081v3.lib.plugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterConfig;
import com.meizu.statsapp.p081v3.lib.plugin.net.NetResponse;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import java.util.List;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface */
public interface IVccOfflineStatsInterface extends IInterface {
    void emitterAddEvent(String str, long j, TrackerPayload trackerPayload) throws RemoteException;

    void emitterAddEventRealtime(String str, long j, TrackerPayload trackerPayload) throws RemoteException;

    void emitterBulkAddEvents(String str, List list, List list2) throws RemoteException;

    void emitterFlush(String str) throws RemoteException;

    String emitterGetUmid(String str) throws RemoteException;

    void emitterInit(String str, EmitterConfig emitterConfig) throws RemoteException;

    void emitterUpdateConfig(String str, EmitterConfig emitterConfig) throws RemoteException;

    void emitterUpdateEventSource(String str, String str2) throws RemoteException;

    NetResponse netRequest(String str, Map map, String str2) throws RemoteException;

    void setCallback(String str, IVccOfflineStatsCallback iVccOfflineStatsCallback) throws RemoteException;

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface$Stub */
    public static abstract class Stub extends Binder implements IVccOfflineStatsInterface {
        private static final String DESCRIPTOR = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface";
        static final int TRANSACTION_emitterAddEvent = 2;
        static final int TRANSACTION_emitterAddEventRealtime = 3;
        static final int TRANSACTION_emitterBulkAddEvents = 4;
        static final int TRANSACTION_emitterFlush = 5;
        static final int TRANSACTION_emitterGetUmid = 7;
        static final int TRANSACTION_emitterInit = 1;
        static final int TRANSACTION_emitterUpdateConfig = 6;
        static final int TRANSACTION_emitterUpdateEventSource = 8;
        static final int TRANSACTION_netRequest = 9;
        static final int TRANSACTION_setCallback = 10;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVccOfflineStatsInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IVccOfflineStatsInterface)) {
                return new Proxy(iBinder);
            }
            return (IVccOfflineStatsInterface) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.meizu.statsapp.v3.lib.plugin.emitter.EmitterConfig} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: com.meizu.statsapp.v3.lib.plugin.emitter.EmitterConfig} */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v15 */
        /* JADX WARNING: type inference failed for: r0v16 */
        /* JADX WARNING: type inference failed for: r0v17 */
        /* JADX WARNING: type inference failed for: r0v18 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                if (r5 == r0) goto L_0x0131
                r0 = 0
                switch(r5) {
                    case 1: goto L_0x0112;
                    case 2: goto L_0x00ef;
                    case 3: goto L_0x00cc;
                    case 4: goto L_0x00ac;
                    case 5: goto L_0x009c;
                    case 6: goto L_0x007d;
                    case 7: goto L_0x0069;
                    case 8: goto L_0x0055;
                    case 9: goto L_0x0027;
                    case 10: goto L_0x000f;
                    default: goto L_0x000a;
                }
            L_0x000a:
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x000f:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r6.enforceInterface(r5)
                java.lang.String r5 = r6.readString()
                android.os.IBinder r6 = r6.readStrongBinder()
                com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsCallback r6 = com.meizu.statsapp.p081v3.lib.plugin.IVccOfflineStatsCallback.Stub.asInterface(r6)
                r4.setCallback(r5, r6)
                r7.writeNoException()
                return r1
            L_0x0027:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r6.enforceInterface(r5)
                java.lang.String r5 = r6.readString()
                java.lang.Class r8 = r4.getClass()
                java.lang.ClassLoader r8 = r8.getClassLoader()
                java.util.HashMap r8 = r6.readHashMap(r8)
                java.lang.String r6 = r6.readString()
                com.meizu.statsapp.v3.lib.plugin.net.NetResponse r5 = r4.netRequest(r5, r8, r6)
                r7.writeNoException()
                if (r5 == 0) goto L_0x0050
                r7.writeInt(r1)
                r5.writeToParcel(r7, r1)
                goto L_0x0054
            L_0x0050:
                r5 = 0
                r7.writeInt(r5)
            L_0x0054:
                return r1
            L_0x0055:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r6.enforceInterface(r5)
                java.lang.String r5 = r6.readString()
                java.lang.String r6 = r6.readString()
                r4.emitterUpdateEventSource(r5, r6)
                r7.writeNoException()
                return r1
            L_0x0069:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r6.enforceInterface(r5)
                java.lang.String r5 = r6.readString()
                java.lang.String r5 = r4.emitterGetUmid(r5)
                r7.writeNoException()
                r7.writeString(r5)
                return r1
            L_0x007d:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r6.enforceInterface(r5)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x0095
                android.os.Parcelable$Creator<com.meizu.statsapp.v3.lib.plugin.emitter.EmitterConfig> r8 = com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterConfig.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r0 = r6
                com.meizu.statsapp.v3.lib.plugin.emitter.EmitterConfig r0 = (com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterConfig) r0
            L_0x0095:
                r4.emitterUpdateConfig(r5, r0)
                r7.writeNoException()
                return r1
            L_0x009c:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r6.enforceInterface(r5)
                java.lang.String r5 = r6.readString()
                r4.emitterFlush(r5)
                r7.writeNoException()
                return r1
            L_0x00ac:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r6.enforceInterface(r5)
                java.lang.String r5 = r6.readString()
                java.lang.Class r8 = r4.getClass()
                java.lang.ClassLoader r8 = r8.getClassLoader()
                java.util.ArrayList r0 = r6.readArrayList(r8)
                java.util.ArrayList r6 = r6.readArrayList(r8)
                r4.emitterBulkAddEvents(r5, r0, r6)
                r7.writeNoException()
                return r1
            L_0x00cc:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r6.enforceInterface(r5)
                java.lang.String r5 = r6.readString()
                long r2 = r6.readLong()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x00e8
                android.os.Parcelable$Creator<com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload> r8 = com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r0 = r6
                com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload r0 = (com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload) r0
            L_0x00e8:
                r4.emitterAddEventRealtime(r5, r2, r0)
                r7.writeNoException()
                return r1
            L_0x00ef:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r6.enforceInterface(r5)
                java.lang.String r5 = r6.readString()
                long r2 = r6.readLong()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x010b
                android.os.Parcelable$Creator<com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload> r8 = com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r0 = r6
                com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload r0 = (com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload) r0
            L_0x010b:
                r4.emitterAddEvent(r5, r2, r0)
                r7.writeNoException()
                return r1
            L_0x0112:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r6.enforceInterface(r5)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x012a
                android.os.Parcelable$Creator<com.meizu.statsapp.v3.lib.plugin.emitter.EmitterConfig> r8 = com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterConfig.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r0 = r6
                com.meizu.statsapp.v3.lib.plugin.emitter.EmitterConfig r0 = (com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterConfig) r0
            L_0x012a:
                r4.emitterInit(r5, r0)
                r7.writeNoException()
                return r1
            L_0x0131:
                java.lang.String r5 = "com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface"
                r7.writeString(r5)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.IVccOfflineStatsInterface.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: com.meizu.statsapp.v3.lib.plugin.IVccOfflineStatsInterface$Stub$Proxy */
        private static class Proxy implements IVccOfflineStatsInterface {
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

            public void emitterInit(String str, EmitterConfig emitterConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (emitterConfig != null) {
                        obtain.writeInt(1);
                        emitterConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void emitterAddEvent(String str, long j, TrackerPayload trackerPayload) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    if (trackerPayload != null) {
                        obtain.writeInt(1);
                        trackerPayload.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void emitterAddEventRealtime(String str, long j, TrackerPayload trackerPayload) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    if (trackerPayload != null) {
                        obtain.writeInt(1);
                        trackerPayload.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void emitterBulkAddEvents(String str, List list, List list2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeList(list);
                    obtain.writeList(list2);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void emitterFlush(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void emitterUpdateConfig(String str, EmitterConfig emitterConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (emitterConfig != null) {
                        obtain.writeInt(1);
                        emitterConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String emitterGetUmid(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void emitterUpdateEventSource(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public NetResponse netRequest(String str, Map map, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    obtain.writeString(str2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? NetResponse.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCallback(String str, IVccOfflineStatsCallback iVccOfflineStatsCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iVccOfflineStatsCallback != null ? iVccOfflineStatsCallback.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
