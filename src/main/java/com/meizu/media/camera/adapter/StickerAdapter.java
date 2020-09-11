package com.meizu.media.camera.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.media.camera.R;
import com.meizu.media.camera.Storage;
import com.meizu.media.camera.bean.Sticker;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.Iterator;

public class StickerAdapter extends RecyclerView.Adapter<StickerItemHolder> {

    /* renamed from: a */
    public static ChangeQuickRedirect f7530a;

    /* renamed from: b */
    private static final LogUtil.C2630a f7531b = new LogUtil.C2630a("StickerAdapter");

    /* renamed from: c */
    private ArrayList<Sticker> f7532c = new ArrayList<>();

    /* renamed from: d */
    private Context f7533d;

    /* renamed from: e */
    private View.OnClickListener f7534e;

    /* renamed from: f */
    private C1792a f7535f;

    /* renamed from: com.meizu.media.camera.adapter.StickerAdapter$a */
    public interface C1792a {
        /* renamed from: a */
        String mo18773a();
    }

    public StickerAdapter(Context context, View.OnClickListener onClickListener, C1792a aVar) {
        this.f7533d = context;
        this.f7534e = onClickListener;
        this.f7535f = aVar;
    }

    /* renamed from: a */
    public StickerItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{viewGroup, new Integer(i)}, this, f7530a, false, 2253, new Class[]{ViewGroup.class, Integer.TYPE}, StickerItemHolder.class);
        if (proxy.isSupported) {
            return (StickerItemHolder) proxy.result;
        }
        return new StickerItemHolder(LayoutInflater.from(this.f7533d).inflate(R.layout.mz_funnysnap_item, viewGroup, false), this.f7534e);
    }

    /* renamed from: a */
    public void onBindViewHolder(StickerItemHolder stickerItemHolder, int i) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{stickerItemHolder, new Integer(i)}, this, f7530a, false, 2254, new Class[]{StickerItemHolder.class, Integer.TYPE}, Void.TYPE).isSupported) {
            Sticker sticker = this.f7532c.get(i);
            if (sticker.mo19358h() != null) {
                stickerItemHolder.f7537b.setImageBitmap(sticker.mo19358h());
            } else if ("youtu".equals(sticker.mo19356f())) {
                stickerItemHolder.f7537b.setImageResource(R.drawable.mz_funnysnap_faceu_default);
            } else {
                stickerItemHolder.f7537b.setImageResource(R.drawable.mz_funnysnap_sticker_default);
            }
            stickerItemHolder.itemView.setTag(Integer.valueOf(i));
            String a = Storage.m7750a().mo18621a(this.f7533d, String.valueOf(sticker.mo19342a()));
            if (a == null || TextUtils.isEmpty(a) || !a.equals(this.f7535f.mo18773a())) {
                z = false;
            }
            stickerItemHolder.mo18774a(z);
            LogUtil.C2630a aVar = f7531b;
            LogUtil.m15942a(aVar, "StickerId: " + sticker.mo19342a());
            LogUtil.C2630a aVar2 = f7531b;
            LogUtil.m15942a(aVar2, "sticker: " + sticker);
            LogUtil.C2630a aVar3 = f7531b;
            LogUtil.m15942a(aVar3, "DownloadState: " + sticker.mo19359i());
            int i2 = 8;
            if (Sticker.DownloadState.DOWNLOAD_FAILED.equals(sticker.mo19359i())) {
                stickerItemHolder.f7539d.setVisibility(0);
                stickerItemHolder.f7539d.setImageResource(R.drawable.mz_funnysnap_refresh);
            } else {
                stickerItemHolder.f7539d.setImageResource(R.drawable.mz_funnysnap_download);
                stickerItemHolder.f7539d.setVisibility(Sticker.DownloadState.NOT_DOWNLOAD.equals(sticker.mo19359i()) ? 0 : 8);
            }
            stickerItemHolder.f7538c.setVisibility(sticker.mo19355e() ? 0 : 8);
            ProgressBar progressBar = stickerItemHolder.f7541f;
            if (Sticker.DownloadState.DOWNLOADING.equals(sticker.mo19359i())) {
                i2 = 0;
            }
            progressBar.setVisibility(i2);
            stickerItemHolder.f7537b.setImageAlpha(Sticker.DownloadState.DOWNLOADING.equals(sticker.mo19359i()) ? 102 : 255);
        }
    }

    public int getItemCount() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7530a, false, 2255, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f7532c.size();
    }

    /* renamed from: a */
    public void mo18771a(ArrayList<Sticker> arrayList) {
        if (!PatchProxy.proxy(new Object[]{arrayList}, this, f7530a, false, 2256, new Class[]{ArrayList.class}, Void.TYPE).isSupported) {
            this.f7532c.clear();
            this.f7532c.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public Sticker mo18768a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f7530a, false, 2257, new Class[]{Integer.TYPE}, Sticker.class);
        return proxy.isSupported ? (Sticker) proxy.result : this.f7532c.get(i);
    }

    public long getItemId(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f7530a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2258, new Class[]{Integer.TYPE}, Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        Sticker a = mo18768a(i);
        if (a == null) {
            return -1;
        }
        return (long) a.mo19342a();
    }

    /* renamed from: a */
    public ArrayList<Sticker> mo18769a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f7530a, false, 2259, new Class[]{String.class}, ArrayList.class);
        if (proxy.isSupported) {
            return (ArrayList) proxy.result;
        }
        ArrayList<Sticker> arrayList = new ArrayList<>();
        Iterator<Sticker> it = this.f7532c.iterator();
        while (it.hasNext()) {
            Sticker next = it.next();
            if (str.equals(String.valueOf(next.mo19342a()))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo18772b(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f7530a, false, 2260, new Class[]{String.class}, Void.TYPE).isSupported) {
            Iterator<Sticker> it = this.f7532c.iterator();
            while (it.hasNext()) {
                if (str.equals(String.valueOf(it.next().mo19342a()))) {
                    it.remove();
                }
            }
        }
    }
}
