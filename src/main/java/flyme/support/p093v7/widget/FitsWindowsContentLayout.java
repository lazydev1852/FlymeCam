package flyme.support.p093v7.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import androidx.appcompat.widget.ContentFrameLayout;

/* renamed from: flyme.support.v7.widget.FitsWindowsContentLayout */
public class FitsWindowsContentLayout extends ContentFrameLayout {
    private C3206a mOnStartActionModeListener;

    /* renamed from: flyme.support.v7.widget.FitsWindowsContentLayout$a */
    public interface C3206a {
        /* renamed from: a */
        ActionMode mo25216a(ActionMode.Callback callback);

        /* renamed from: a */
        ActionMode mo25217a(ActionMode.Callback callback, int i);
    }

    public void makeOptionalFitsSystemWindows() {
    }

    public FitsWindowsContentLayout(Context context) {
        super(context);
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnStartActionModeListener(C3206a aVar) {
        this.mOnStartActionModeListener = aVar;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        ActionMode actionMode;
        if (this.mOnStartActionModeListener != null) {
            actionMode = Build.VERSION.SDK_INT >= 23 ? this.mOnStartActionModeListener.mo25217a(callback, 0) : this.mOnStartActionModeListener.mo25216a(callback);
        } else {
            actionMode = null;
        }
        return actionMode == null ? super.startActionModeForChild(view, callback) : actionMode;
    }
}
