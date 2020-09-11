package androidx.databinding.adapters;

import android.widget.AbsListView;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods({@BindingMethod(attribute = "android:listSelector", method = "setSelector", type = AbsListView.class), @BindingMethod(attribute = "android:scrollingCache", method = "setScrollingCacheEnabled", type = AbsListView.class), @BindingMethod(attribute = "android:smoothScrollbar", method = "setSmoothScrollbarEnabled", type = AbsListView.class), @BindingMethod(attribute = "android:onMovedToScrapHeap", method = "setRecyclerListener", type = AbsListView.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AbsListViewBindingAdapter {

    public interface OnScroll {
        void onScroll(AbsListView absListView, int i, int i2, int i3);
    }

    public interface OnScrollStateChanged {
        void onScrollStateChanged(AbsListView absListView, int i);
    }

    @BindingAdapter(requireAll = false, value = {"android:onScroll", "android:onScrollStateChanged"})
    public static void setOnScroll(AbsListView absListView, final OnScroll onScroll, final OnScrollStateChanged onScrollStateChanged) {
        absListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (onScrollStateChanged != null) {
                    onScrollStateChanged.onScrollStateChanged(absListView, i);
                }
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (onScroll != null) {
                    onScroll.onScroll(absListView, i, i2, i3);
                }
            }
        });
    }
}
