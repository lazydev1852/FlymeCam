package com.meizu.media.camera.modemove.p076e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.R;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.modemove.adapter.holder.BaseViewHolder;
import com.meizu.media.camera.modemove.adapter.holder.ViewHolderManager;
import com.meizu.media.camera.modemove.p072a.ImageTextBean;
import com.meizu.media.camera.p077ui.MzAmazingARUI;
import com.meizu.media.camera.views.ModeItemView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0007\u001a\u00020\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo27294d2 = {"Lcom/meizu/media/camera/modemove/viewholder/ImageAndTextManager;", "Lcom/meizu/media/camera/modemove/adapter/holder/ViewHolderManager;", "mActivity", "Lcom/meizu/media/camera/CameraActivity;", "mSpanCount", "", "(Lcom/meizu/media/camera/CameraActivity;I)V", "itemLayoutId", "getItemLayoutId", "()I", "getMActivity", "()Lcom/meizu/media/camera/CameraActivity;", "setMActivity", "(Lcom/meizu/media/camera/CameraActivity;)V", "onBindViewHolder", "", "holder", "Lcom/meizu/media/camera/modemove/adapter/holder/BaseViewHolder;", "data", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.modemove.e.a */
public final class ImageAndTextManager extends ViewHolderManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f11358a;
    @NotNull

    /* renamed from: b */
    private CameraActivity f11359b;

    /* renamed from: d */
    private final int f11360d;

    /* renamed from: a */
    public int mo20695a() {
        return R.layout.move_item_image_text;
    }

    public ImageAndTextManager(@NotNull CameraActivity cameraActivity, int i) {
        C3443i.m21155b(cameraActivity, "mActivity");
        this.f11359b = cameraActivity;
        this.f11360d = i;
    }

    @NotNull
    /* renamed from: a */
    public BaseViewHolder mo20696a(@NotNull ViewGroup viewGroup) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup}, this, f11358a, false, 5338, new Class[]{ViewGroup.class}, BaseViewHolder.class);
        if (proxy.isSupported) {
            return (BaseViewHolder) proxy.result;
        }
        C3443i.m21155b(viewGroup, "parent");
        Context f = this.f11359b.mo17639f();
        C3443i.m21152a((Object) f, "mActivity.resourcesContext");
        return new BaseViewHolder(mo20732a(viewGroup, f));
    }

    /* renamed from: a */
    public void mo20697a(@NotNull BaseViewHolder baseViewHolder, @NotNull Object obj, int i) {
        if (!PatchProxy.proxy(new Object[]{baseViewHolder, obj, new Integer(i)}, this, f11358a, false, 5339, new Class[]{BaseViewHolder.class, Object.class, Integer.TYPE}, Void.TYPE).isSupported) {
            C3443i.m21155b(baseViewHolder, "holder");
            C3443i.m21155b(obj, "data");
            if (this.f11360d == 4) {
                View view = baseViewHolder.itemView;
                C3443i.m21152a((Object) view, "holder.itemView");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) layoutParams;
                    Context f = this.f11359b.mo17639f();
                    C3443i.m21152a((Object) f, "mActivity.resourcesContext");
                    layoutParams2.width = f.getResources().getDimensionPixelOffset(R.dimen.mz_mode_move_item_width);
                    Context f2 = this.f11359b.mo17639f();
                    C3443i.m21152a((Object) f2, "mActivity.resourcesContext");
                    layoutParams2.height = f2.getResources().getDimensionPixelOffset(R.dimen.mz_mode_move_item_height);
                    view.setLayoutParams(layoutParams2);
                    View b = mo20736b(view, R.id.mz_mode_menu_item_shadow_inside);
                    if (b != null) {
                        ModeItemView modeItemView = (ModeItemView) b;
                        ViewGroup.LayoutParams layoutParams3 = modeItemView.getLayoutParams();
                        if (layoutParams3 != null) {
                            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                            layoutParams4.topMargin = 0;
                            layoutParams4.bottomMargin = 0;
                            modeItemView.setLayoutParams(layoutParams4);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.views.ModeItemView");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
                }
            }
            if (obj instanceof ImageTextBean) {
                RecyclerView.ViewHolder viewHolder = baseViewHolder;
                View a = mo20733a(viewHolder, (int) R.id.mode_move_name);
                if (a != null) {
                    TextView textView = (TextView) a;
                    ImageTextBean aVar = (ImageTextBean) obj;
                    CameraModeType.ModeType a2 = aVar.mo20699a();
                    if (a2 == null) {
                        C3443i.m21151a();
                    }
                    textView.setText(a2.getTxtId());
                    View a3 = mo20733a(viewHolder, (int) R.id.mode_move_icon);
                    if (a3 != null) {
                        ImageView imageView = (ImageView) a3;
                        if (aVar.mo20710f()) {
                            CameraModeType.ModeType a4 = aVar.mo20699a();
                            if (a4 == null) {
                                C3443i.m21151a();
                            }
                            if (a4.getTxtId() == R.string.mz_cam_mode_amazing) {
                                MzAmazingARUI.C2462a aVar2 = MzAmazingARUI.f12889b;
                                Context applicationContext = this.f11359b.getApplicationContext();
                                C3443i.m21152a((Object) applicationContext, "mActivity.applicationContext");
                                if (!aVar2.mo21987a(applicationContext, MzAmazingARUI.f12889b.mo21986a())) {
                                    CameraModeType.ModeType a5 = aVar.mo20699a();
                                    if (a5 == null) {
                                        C3443i.m21151a();
                                    }
                                    imageView.setImageResource(a5.getIconDisableDownloadId());
                                    textView.setTextColor(this.f11359b.getResources().getColor(R.color.mz_mode_move_disable_text_color));
                                    return;
                                }
                            }
                            CameraModeType.ModeType a6 = aVar.mo20699a();
                            if (a6 == null) {
                                C3443i.m21151a();
                            }
                            imageView.setImageResource(a6.getIconDisableId());
                            textView.setTextColor(this.f11359b.getResources().getColor(R.color.mz_mode_move_disable_text_color));
                            return;
                        }
                        CameraModeType.ModeType a7 = aVar.mo20699a();
                        if (a7 == null) {
                            C3443i.m21151a();
                        }
                        if (a7.getTxtId() == R.string.mz_cam_mode_amazing) {
                            MzAmazingARUI.C2462a aVar3 = MzAmazingARUI.f12889b;
                            Context applicationContext2 = this.f11359b.getApplicationContext();
                            C3443i.m21152a((Object) applicationContext2, "mActivity.applicationContext");
                            if (!aVar3.mo21987a(applicationContext2, MzAmazingARUI.f12889b.mo21986a())) {
                                CameraModeType.ModeType a8 = aVar.mo20699a();
                                if (a8 == null) {
                                    C3443i.m21151a();
                                }
                                imageView.setImageResource(a8.getIconDownloadId());
                                textView.setTextColor(this.f11359b.getResources().getColor(R.color.mz_more_mode_item_unselected_color));
                                return;
                            }
                        }
                        CameraModeType.ModeType a9 = aVar.mo20699a();
                        if (a9 == null) {
                            C3443i.m21151a();
                        }
                        imageView.setImageResource(a9.getIconNormalId());
                        textView.setTextColor(this.f11359b.getResources().getColor(R.color.mz_more_mode_item_unselected_color));
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
        }
    }
}
