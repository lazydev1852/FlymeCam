package com.baidu.p020ar;

import com.baidu.p020ar.bean.ARResource;
import java.util.HashMap;

/* renamed from: com.baidu.ar.DuMixCallback */
public interface DuMixCallback {
    void onCaseChange(boolean z);

    void onCaseCreated(ARResource aRResource);

    void onLuaMessage(HashMap<String, Object> hashMap);

    void onPause(boolean z);

    void onRelease(boolean z);

    void onReset(boolean z);

    void onResume(boolean z);

    void onSetup(boolean z);

    void onStateChange(int i, Object obj);

    void onStateError(int i, String str);
}
