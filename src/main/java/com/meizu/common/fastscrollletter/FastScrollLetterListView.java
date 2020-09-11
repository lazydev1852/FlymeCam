package com.meizu.common.fastscrollletter;

import android.content.Context;
import android.util.AttributeSet;
import com.meizu.common.widget.PinnedHeaderIndexerListAdapter;
import com.meizu.common.widget.PinnedHeaderListView;

public class FastScrollLetterListView extends PinnedHeaderListView implements IFastScrollLetterListView {
    public FastScrollLetterListView(Context context) {
        super(context);
    }

    public FastScrollLetterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FastScrollLetterListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setNeedSectionHeader(boolean z) {
        ((FastScrollLetterListViewAdapter) getAdapter()).mo15861a(z);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 > 0 && getAdapter() != null && (getAdapter() instanceof PinnedHeaderIndexerListAdapter)) {
            setTranslateHeader(((PinnedHeaderIndexerListAdapter) getAdapter()).mo17048f() - 1, i2);
        }
    }
}
