package com.meizu.savior;

import android.util.Log;
import java.util.List;

public class SaviorCallBackSample implements SaviorCallBack {
    public void exceptionNotify(Throwable th, String str) {
        Log.e("SaviorCallBack", "exceptionNotify where: " + str, th);
    }

    public void logNotify(String str, String str2) {
        Log.d("SaviorCallBack", "logNotify log: " + str);
        Log.d("SaviorCallBack", "logNotify where: " + str2);
    }

    public void onPatchApplied(boolean z, Patch patch) {
        Log.d("SaviorCallBack", "onPatchApplied result: " + z);
        Log.d("SaviorCallBack", "onPatchApplied patch: " + patch.getName());
    }

    public void onPatchFetched(boolean z, boolean z2, Patch patch) {
        Log.d("SaviorCallBack", "onPatchFetched result: " + z);
        Log.d("SaviorCallBack", "onPatchFetched isNet: " + z2);
        Log.d("SaviorCallBack", "onPatchFetched patch: " + patch.getName());
    }

    public void onPatchListFetched(boolean z, boolean z2, List<Patch> list) {
        Log.d("SaviorCallBack", "onPatchListFetched result: " + z);
        Log.d("SaviorCallBack", "onPatchListFetched isNet: " + z2);
        for (Patch name : list) {
            Log.d("SaviorCallBack", "onPatchListFetched patch: " + name.getName());
        }
    }
}
