package vendor.mediatek.hardware.power.V1_1;

import android.hardware.power.V1_0.IPower;
import android.hardware.power.V1_0.PowerStatePlatformSleepState;
import android.hidl.base.V1_0.DebugInfo;
import android.hidl.base.V1_0.IBase;
import android.os.HwBinder;
import android.os.HwBlob;
import android.os.HwParcel;
import android.os.IHwBinder;
import android.os.IHwInterface;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public interface IPower extends android.hardware.power.V1_0.IPower {
    public static final String kInterfaceName = "vendor.mediatek.hardware.power@1.1::IPower";

    IHwBinder asBinder();

    DebugInfo getDebugInfo() throws RemoteException;

    ArrayList<byte[]> getHashChain() throws RemoteException;

    ArrayList<String> interfaceChain() throws RemoteException;

    String interfaceDescriptor() throws RemoteException;

    boolean linkToDeath(IHwBinder.DeathRecipient deathRecipient, long j) throws RemoteException;

    void mtkCusPowerHint(int i, int i2) throws RemoteException;

    void mtkPowerHint(int i, int i2) throws RemoteException;

    void notifyAppState(String str, String str2, int i, int i2) throws RemoteException;

    void notifySyspropsChanged() throws RemoteException;

    void ping() throws RemoteException;

    int querySysInfo(int i, int i2) throws RemoteException;

    void scnConfig(int i, int i2, int i3, int i4, int i5, int i6) throws RemoteException;

    void scnDisable(int i) throws RemoteException;

    void scnEnable(int i, int i2) throws RemoteException;

    int scnReg() throws RemoteException;

    void scnUnreg(int i) throws RemoteException;

    void setHALInstrumentation() throws RemoteException;

    boolean unlinkToDeath(IHwBinder.DeathRecipient deathRecipient) throws RemoteException;

    /* renamed from: vendor.mediatek.hardware.power.V1_1.IPower$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static IPower asInterface(IHwBinder iHwBinder) {
            if (iHwBinder == null) {
                return null;
            }
            IPower queryLocalInterface = iHwBinder.queryLocalInterface(IPower.kInterfaceName);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPower)) {
                return queryLocalInterface;
            }
            Proxy proxy = new Proxy(iHwBinder);
            try {
                Iterator<String> it = proxy.interfaceChain().iterator();
                while (it.hasNext()) {
                    if (it.next().equals(IPower.kInterfaceName)) {
                        return proxy;
                    }
                }
            } catch (RemoteException unused) {
            }
            return null;
        }

        public static IPower castFrom(IHwInterface iHwInterface) {
            if (iHwInterface == null) {
                return null;
            }
            return asInterface(iHwInterface.asBinder());
        }

        public static IPower getService(String str) throws RemoteException {
            return asInterface(HwBinder.getService(IPower.kInterfaceName, str));
        }

        public static IPower getService() throws RemoteException {
            return asInterface(HwBinder.getService(IPower.kInterfaceName, "default"));
        }
    }

    public static final class Proxy implements IPower {
        private IHwBinder mRemote;

        public Proxy(IHwBinder iHwBinder) {
            this.mRemote = (IHwBinder) Objects.requireNonNull(iHwBinder);
        }

        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            try {
                return interfaceDescriptor() + "@Proxy";
            } catch (RemoteException unused) {
                return "[class or subclass of vendor.mediatek.hardware.power@1.1::IPower]@Proxy";
            }
        }

        public void setInteractive(boolean z) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(android.hardware.power.V1_0.IPower.kInterfaceName);
            hwParcel.writeBool(z);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(1, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public void powerHint(int i, int i2) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(android.hardware.power.V1_0.IPower.kInterfaceName);
            hwParcel.writeInt32(i);
            hwParcel.writeInt32(i2);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(2, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public void setFeature(int i, boolean z) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(android.hardware.power.V1_0.IPower.kInterfaceName);
            hwParcel.writeInt32(i);
            hwParcel.writeBool(z);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(3, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public void getPlatformLowPowerStats(IPower.getPlatformLowPowerStatsCallback getplatformlowpowerstatscallback) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(android.hardware.power.V1_0.IPower.kInterfaceName);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(4, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
                getplatformlowpowerstatscallback.onValues(PowerStatePlatformSleepState.readVectorFromParcel(hwParcel2), hwParcel2.readInt32());
            } finally {
                hwParcel2.release();
            }
        }

        public void mtkPowerHint(int i, int i2) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IPower.kInterfaceName);
            hwParcel.writeInt32(i);
            hwParcel.writeInt32(i2);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(5, hwParcel, hwParcel2, 1);
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public void mtkCusPowerHint(int i, int i2) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IPower.kInterfaceName);
            hwParcel.writeInt32(i);
            hwParcel.writeInt32(i2);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(6, hwParcel, hwParcel2, 1);
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public void notifyAppState(String str, String str2, int i, int i2) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IPower.kInterfaceName);
            hwParcel.writeString(str);
            hwParcel.writeString(str2);
            hwParcel.writeInt32(i);
            hwParcel.writeInt32(i2);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(7, hwParcel, hwParcel2, 1);
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public int querySysInfo(int i, int i2) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IPower.kInterfaceName);
            hwParcel.writeInt32(i);
            hwParcel.writeInt32(i2);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(8, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
                return hwParcel2.readInt32();
            } finally {
                hwParcel2.release();
            }
        }

        public int scnReg() throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IPower.kInterfaceName);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(9, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
                return hwParcel2.readInt32();
            } finally {
                hwParcel2.release();
            }
        }

        public void scnConfig(int i, int i2, int i3, int i4, int i5, int i6) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IPower.kInterfaceName);
            hwParcel.writeInt32(i);
            hwParcel.writeInt32(i2);
            hwParcel.writeInt32(i3);
            hwParcel.writeInt32(i4);
            hwParcel.writeInt32(i5);
            hwParcel.writeInt32(i6);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(10, hwParcel, hwParcel2, 1);
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public void scnUnreg(int i) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IPower.kInterfaceName);
            hwParcel.writeInt32(i);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(11, hwParcel, hwParcel2, 1);
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public void scnEnable(int i, int i2) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IPower.kInterfaceName);
            hwParcel.writeInt32(i);
            hwParcel.writeInt32(i2);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(12, hwParcel, hwParcel2, 1);
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public void scnDisable(int i) throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IPower.kInterfaceName);
            hwParcel.writeInt32(i);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(13, hwParcel, hwParcel2, 1);
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public ArrayList<String> interfaceChain() throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(256067662, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
                return hwParcel2.readStringVector();
            } finally {
                hwParcel2.release();
            }
        }

        public String interfaceDescriptor() throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(256136003, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
                return hwParcel2.readString();
            } finally {
                hwParcel2.release();
            }
        }

        public ArrayList<byte[]> getHashChain() throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(256398152, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
                ArrayList<byte[]> arrayList = new ArrayList<>();
                HwBlob readBuffer = hwParcel2.readBuffer(16);
                int int32 = readBuffer.getInt32(8);
                long handle = readBuffer.handle();
                HwBlob readEmbeddedBuffer = hwParcel2.readEmbeddedBuffer((long) (int32 * 32), handle, 0, true);
                arrayList.clear();
                for (int i = 0; i < int32; i++) {
                    byte[] bArr = new byte[32];
                    long j = (long) (i * 32);
                    for (int i2 = 0; i2 < 32; i2++) {
                        bArr[i2] = readEmbeddedBuffer.getInt8(j);
                        j++;
                    }
                    arrayList.add(bArr);
                }
                return arrayList;
            } finally {
                hwParcel2.release();
            }
        }

        public void setHALInstrumentation() throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(256462420, hwParcel, hwParcel2, 1);
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public boolean linkToDeath(IHwBinder.DeathRecipient deathRecipient, long j) throws RemoteException {
            return this.mRemote.linkToDeath(deathRecipient, j);
        }

        public void ping() throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(256921159, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public DebugInfo getDebugInfo() throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(257049926, hwParcel, hwParcel2, 0);
                hwParcel2.verifySuccess();
                hwParcel.releaseTemporaryStorage();
                DebugInfo debugInfo = new DebugInfo();
                debugInfo.readFromParcel(hwParcel2);
                return debugInfo;
            } finally {
                hwParcel2.release();
            }
        }

        public void notifySyspropsChanged() throws RemoteException {
            HwParcel hwParcel = new HwParcel();
            hwParcel.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel hwParcel2 = new HwParcel();
            try {
                this.mRemote.transact(257120595, hwParcel, hwParcel2, 1);
                hwParcel.releaseTemporaryStorage();
            } finally {
                hwParcel2.release();
            }
        }

        public boolean unlinkToDeath(IHwBinder.DeathRecipient deathRecipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(deathRecipient);
        }
    }

    public static abstract class Stub extends HwBinder implements IPower {
        public IHwBinder asBinder() {
            return this;
        }

        public final String interfaceDescriptor() {
            return IPower.kInterfaceName;
        }

        public final boolean linkToDeath(IHwBinder.DeathRecipient deathRecipient, long j) {
            return true;
        }

        public final void ping() {
        }

        public final void setHALInstrumentation() {
        }

        public final boolean unlinkToDeath(IHwBinder.DeathRecipient deathRecipient) {
            return true;
        }

        public final ArrayList<String> interfaceChain() {
            return new ArrayList<>(Arrays.asList(new String[]{IPower.kInterfaceName, android.hardware.power.V1_0.IPower.kInterfaceName, IBase.kInterfaceName}));
        }

        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList<>(Arrays.asList(new byte[][]{new byte[]{44, -29, -89, 125, 63, -50, -14, 66, 48, -8, -19, 27, -70, 120, 74, -58, -26, -126, 32, 49, 62, 122, -89, 97, 73, 81, -70, -99, -65, 105, 29, -120}, new byte[]{-34, -18, 29, -60, -108, -113, 51, -81, 32, 126, 16, 8, -85, -96, -10, -52, 7, -81, -73, -112, 14, -85, 83, -13, 49, -110, -56, -54, -63, 55, -18, -4}, new byte[]{-67, -38, -74, 24, 77, 122, 52, 109, -90, -96, 125, -64, -126, -116, -15, -102, 105, 111, 76, -86, 54, 17, -59, 31, 46, 20, 86, 90, 20, -76, 15, -39}}));
        }

        public final DebugInfo getDebugInfo() {
            DebugInfo debugInfo = new DebugInfo();
            debugInfo.pid = -1;
            debugInfo.ptr = 0;
            debugInfo.arch = 0;
            return debugInfo;
        }

        public final void notifySyspropsChanged() {
            HwBinder.reportSyspropChanged();
        }

        public IHwInterface queryLocalInterface(String str) {
            if (IPower.kInterfaceName.equals(str)) {
                return this;
            }
            return null;
        }

        public void registerAsService(String str) throws RemoteException {
            registerService(str);
        }

        public String toString() {
            return interfaceDescriptor() + "@Stub";
        }

        public void onTransact(int i, HwParcel hwParcel, final HwParcel hwParcel2, int i2) throws RemoteException {
            if (i == 256067662) {
                hwParcel.enforceInterface(IBase.kInterfaceName);
                ArrayList<String> interfaceChain = interfaceChain();
                hwParcel2.writeStatus(0);
                hwParcel2.writeStringVector(interfaceChain);
                hwParcel2.send();
            } else if (i == 256131655) {
                hwParcel.enforceInterface(IBase.kInterfaceName);
                hwParcel2.writeStatus(0);
                hwParcel2.send();
            } else if (i == 256136003) {
                hwParcel.enforceInterface(IBase.kInterfaceName);
                String interfaceDescriptor = interfaceDescriptor();
                hwParcel2.writeStatus(0);
                hwParcel2.writeString(interfaceDescriptor);
                hwParcel2.send();
            } else if (i == 256398152) {
                hwParcel.enforceInterface(IBase.kInterfaceName);
                ArrayList<byte[]> hashChain = getHashChain();
                hwParcel2.writeStatus(0);
                HwBlob hwBlob = new HwBlob(16);
                int size = hashChain.size();
                hwBlob.putInt32(8, size);
                hwBlob.putBool(12, false);
                HwBlob hwBlob2 = new HwBlob(size * 32);
                for (int i3 = 0; i3 < size; i3++) {
                    long j = (long) (i3 * 32);
                    for (int i4 = 0; i4 < 32; i4++) {
                        hwBlob2.putInt8(j, hashChain.get(i3)[i4]);
                        j++;
                    }
                }
                hwBlob.putBlob(0, hwBlob2);
                hwParcel2.writeBuffer(hwBlob);
                hwParcel2.send();
            } else if (i == 256462420) {
                hwParcel.enforceInterface(IBase.kInterfaceName);
                setHALInstrumentation();
            } else if (i != 256660548 && i != 256921159) {
                if (i == 257049926) {
                    hwParcel.enforceInterface(IBase.kInterfaceName);
                    DebugInfo debugInfo = getDebugInfo();
                    hwParcel2.writeStatus(0);
                    debugInfo.writeToParcel(hwParcel2);
                    hwParcel2.send();
                } else if (i != 257120595) {
                    switch (i) {
                        case 1:
                            hwParcel.enforceInterface(android.hardware.power.V1_0.IPower.kInterfaceName);
                            setInteractive(hwParcel.readBool());
                            hwParcel2.writeStatus(0);
                            hwParcel2.send();
                            return;
                        case 2:
                            hwParcel.enforceInterface(android.hardware.power.V1_0.IPower.kInterfaceName);
                            powerHint(hwParcel.readInt32(), hwParcel.readInt32());
                            hwParcel2.writeStatus(0);
                            hwParcel2.send();
                            return;
                        case 3:
                            hwParcel.enforceInterface(android.hardware.power.V1_0.IPower.kInterfaceName);
                            setFeature(hwParcel.readInt32(), hwParcel.readBool());
                            hwParcel2.writeStatus(0);
                            hwParcel2.send();
                            return;
                        case 4:
                            hwParcel.enforceInterface(android.hardware.power.V1_0.IPower.kInterfaceName);
                            getPlatformLowPowerStats(new IPower.getPlatformLowPowerStatsCallback() {
                                public void onValues(ArrayList<PowerStatePlatformSleepState> arrayList, int i) {
                                    hwParcel2.writeStatus(0);
                                    PowerStatePlatformSleepState.writeVectorToParcel(hwParcel2, arrayList);
                                    hwParcel2.writeInt32(i);
                                    hwParcel2.send();
                                }
                            });
                            return;
                        case 5:
                            hwParcel.enforceInterface(IPower.kInterfaceName);
                            mtkPowerHint(hwParcel.readInt32(), hwParcel.readInt32());
                            return;
                        case 6:
                            hwParcel.enforceInterface(IPower.kInterfaceName);
                            mtkCusPowerHint(hwParcel.readInt32(), hwParcel.readInt32());
                            return;
                        case 7:
                            hwParcel.enforceInterface(IPower.kInterfaceName);
                            notifyAppState(hwParcel.readString(), hwParcel.readString(), hwParcel.readInt32(), hwParcel.readInt32());
                            return;
                        case 8:
                            hwParcel.enforceInterface(IPower.kInterfaceName);
                            int querySysInfo = querySysInfo(hwParcel.readInt32(), hwParcel.readInt32());
                            hwParcel2.writeStatus(0);
                            hwParcel2.writeInt32(querySysInfo);
                            hwParcel2.send();
                            return;
                        case 9:
                            hwParcel.enforceInterface(IPower.kInterfaceName);
                            int scnReg = scnReg();
                            hwParcel2.writeStatus(0);
                            hwParcel2.writeInt32(scnReg);
                            hwParcel2.send();
                            return;
                        case 10:
                            hwParcel.enforceInterface(IPower.kInterfaceName);
                            scnConfig(hwParcel.readInt32(), hwParcel.readInt32(), hwParcel.readInt32(), hwParcel.readInt32(), hwParcel.readInt32(), hwParcel.readInt32());
                            return;
                        case 11:
                            hwParcel.enforceInterface(IPower.kInterfaceName);
                            scnUnreg(hwParcel.readInt32());
                            return;
                        case 12:
                            hwParcel.enforceInterface(IPower.kInterfaceName);
                            scnEnable(hwParcel.readInt32(), hwParcel.readInt32());
                            return;
                        case 13:
                            hwParcel.enforceInterface(IPower.kInterfaceName);
                            scnDisable(hwParcel.readInt32());
                            return;
                        default:
                            return;
                    }
                } else {
                    hwParcel.enforceInterface(IBase.kInterfaceName);
                    notifySyspropsChanged();
                }
            }
        }
    }
}
