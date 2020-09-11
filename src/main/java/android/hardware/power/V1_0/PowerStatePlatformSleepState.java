package android.hardware.power.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

public final class PowerStatePlatformSleepState {
    public String name = new String();
    public long residencyInMsecSinceBoot;
    public boolean supportedOnlyInSuspend;
    public long totalTransitions;
    public final ArrayList<PowerStateVoter> voters = new ArrayList<>();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != PowerStatePlatformSleepState.class) {
            return false;
        }
        PowerStatePlatformSleepState powerStatePlatformSleepState = (PowerStatePlatformSleepState) obj;
        return HidlSupport.deepEquals(this.name, powerStatePlatformSleepState.name) && this.residencyInMsecSinceBoot == powerStatePlatformSleepState.residencyInMsecSinceBoot && this.totalTransitions == powerStatePlatformSleepState.totalTransitions && this.supportedOnlyInSuspend == powerStatePlatformSleepState.supportedOnlyInSuspend && HidlSupport.deepEquals(this.voters, powerStatePlatformSleepState.voters);
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.name)), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.residencyInMsecSinceBoot))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.totalTransitions))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.supportedOnlyInSuspend))), Integer.valueOf(HidlSupport.deepHashCode(this.voters))});
    }

    public final String toString() {
        return "{" + ".name = " + this.name + ", .residencyInMsecSinceBoot = " + this.residencyInMsecSinceBoot + ", .totalTransitions = " + this.totalTransitions + ", .supportedOnlyInSuspend = " + this.supportedOnlyInSuspend + ", .voters = " + this.voters + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(56), 0);
    }

    public static final ArrayList<PowerStatePlatformSleepState> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<PowerStatePlatformSleepState> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16);
        int int32 = readBuffer.getInt32(8);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer((long) (int32 * 56), readBuffer.handle(), 0, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            PowerStatePlatformSleepState powerStatePlatformSleepState = new PowerStatePlatformSleepState();
            powerStatePlatformSleepState.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, (long) (i * 56));
            arrayList.add(powerStatePlatformSleepState);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        HwBlob hwBlob2 = hwBlob;
        long j2 = j + 0;
        this.name = hwBlob2.getString(j2);
        hwParcel.readEmbeddedBuffer((long) (this.name.getBytes().length + 1), hwBlob.handle(), j2 + 0, false);
        this.residencyInMsecSinceBoot = hwBlob2.getInt64(j + 16);
        this.totalTransitions = hwBlob2.getInt64(j + 24);
        this.supportedOnlyInSuspend = hwBlob2.getBool(j + 32);
        long j3 = j + 40;
        int int32 = hwBlob2.getInt32(8 + j3);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer((long) (int32 * 32), hwBlob.handle(), j3 + 0, true);
        this.voters.clear();
        for (int i = 0; i < int32; i++) {
            PowerStateVoter powerStateVoter = new PowerStateVoter();
            powerStateVoter.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, (long) (i * 32));
            this.voters.add(powerStateVoter);
        }
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(56);
        writeEmbeddedToBlob(hwBlob, 0);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<PowerStatePlatformSleepState> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8, size);
        hwBlob.putBool(12, false);
        HwBlob hwBlob2 = new HwBlob(size * 56);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, (long) (i * 56));
        }
        hwBlob.putBlob(0, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putString(j + 0, this.name);
        hwBlob.putInt64(16 + j, this.residencyInMsecSinceBoot);
        hwBlob.putInt64(24 + j, this.totalTransitions);
        hwBlob.putBool(32 + j, this.supportedOnlyInSuspend);
        int size = this.voters.size();
        long j2 = j + 40;
        hwBlob.putInt32(8 + j2, size);
        hwBlob.putBool(12 + j2, false);
        HwBlob hwBlob2 = new HwBlob(size * 32);
        for (int i = 0; i < size; i++) {
            this.voters.get(i).writeEmbeddedToBlob(hwBlob2, (long) (i * 32));
        }
        hwBlob.putBlob(j2 + 0, hwBlob2);
    }
}
