package android.hardware.power.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

public final class PowerStateVoter {
    public String name = new String();
    public long totalNumberOfTimesVotedSinceBoot;
    public long totalTimeInMsecVotedForSinceBoot;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != PowerStateVoter.class) {
            return false;
        }
        PowerStateVoter powerStateVoter = (PowerStateVoter) obj;
        return HidlSupport.deepEquals(this.name, powerStateVoter.name) && this.totalTimeInMsecVotedForSinceBoot == powerStateVoter.totalTimeInMsecVotedForSinceBoot && this.totalNumberOfTimesVotedSinceBoot == powerStateVoter.totalNumberOfTimesVotedSinceBoot;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.name)), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.totalTimeInMsecVotedForSinceBoot))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.totalNumberOfTimesVotedSinceBoot)))});
    }

    public final String toString() {
        return "{" + ".name = " + this.name + ", .totalTimeInMsecVotedForSinceBoot = " + this.totalTimeInMsecVotedForSinceBoot + ", .totalNumberOfTimesVotedSinceBoot = " + this.totalNumberOfTimesVotedSinceBoot + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(32), 0);
    }

    public static final ArrayList<PowerStateVoter> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<PowerStateVoter> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16);
        int int32 = readBuffer.getInt32(8);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer((long) (int32 * 32), readBuffer.handle(), 0, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            PowerStateVoter powerStateVoter = new PowerStateVoter();
            powerStateVoter.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, (long) (i * 32));
            arrayList.add(powerStateVoter);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        HwBlob hwBlob2 = hwBlob;
        long j2 = j + 0;
        this.name = hwBlob2.getString(j2);
        hwParcel.readEmbeddedBuffer((long) (this.name.getBytes().length + 1), hwBlob.handle(), j2 + 0, false);
        this.totalTimeInMsecVotedForSinceBoot = hwBlob2.getInt64(j + 16);
        this.totalNumberOfTimesVotedSinceBoot = hwBlob2.getInt64(j + 24);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(32);
        writeEmbeddedToBlob(hwBlob, 0);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<PowerStateVoter> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8, size);
        hwBlob.putBool(12, false);
        HwBlob hwBlob2 = new HwBlob(size * 32);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, (long) (i * 32));
        }
        hwBlob.putBlob(0, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putString(0 + j, this.name);
        hwBlob.putInt64(16 + j, this.totalTimeInMsecVotedForSinceBoot);
        hwBlob.putInt64(j + 24, this.totalNumberOfTimesVotedSinceBoot);
    }
}
