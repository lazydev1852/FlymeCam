package com.meizu.media.camera.modemove;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo27294d2 = {"com/meizu/media/camera/modemove/ModeMoveController$RecyclerViewManager$onBindViewHolder$gridLayoutManager$1", "Landroidx/recyclerview/widget/GridLayoutManager;", "canScrollHorizontally", "", "canScrollVertically", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.modemove.ModeMoveController$RecyclerViewManager$onBindViewHolder$gridLayoutManager$1 */
public final class ModeMoveController extends GridLayoutManager {

    /* renamed from: a */
    final /* synthetic */ View f11260a;

    /* renamed from: b */
    final /* synthetic */ int f11261b;

    public boolean canScrollHorizontally() {
        return false;
    }

    public boolean canScrollVertically() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModeMoveController(View view, int i, Context context, int i2) {
        super(context, i2);
        this.f11260a = view;
        this.f11261b = i;
    }
}
