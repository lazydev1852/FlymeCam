package com.meizu.savior;

import android.content.Context;

public abstract class PatchManipulate {

    public interface PatchFetchCallback {
        void onPatchFetched(Patch patch);
    }

    /* access modifiers changed from: protected */
    public abstract void fetchPatch(Context context, PatchFetchCallback patchFetchCallback);
}
