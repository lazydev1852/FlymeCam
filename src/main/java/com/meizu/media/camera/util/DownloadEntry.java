package com.meizu.media.camera.util;

import com.meizu.media.camera.util.Entry;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

@Entry.Table("download_cache")
/* renamed from: com.meizu.media.camera.util.q */
public class DownloadEntry extends Entry {

    /* renamed from: a */
    public static ChangeQuickRedirect f14313a;

    /* renamed from: b */
    public static final EntrySchema f14314b = new EntrySchema(DownloadEntry.class);
    @Entry.Column(indexed = true, value = "hash_code")

    /* renamed from: c */
    public long f14315c;
    @Entry.Column("content_url")

    /* renamed from: d */
    public String f14316d;
    @Entry.Column("_size")

    /* renamed from: e */
    public long f14317e;
    @Entry.Column("etag")

    /* renamed from: f */
    public String f14318f;
    @Entry.Column(indexed = true, value = "last_access")

    /* renamed from: g */
    public long f14319g;
    @Entry.Column("last_updated")

    /* renamed from: h */
    public long f14320h;
    @Entry.Column("_data")

    /* renamed from: i */
    public String f14321i;

    public String toString() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14313a, false, 8047, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return "hash_code: " + this.f14315c + ", content_url" + this.f14316d + ", _size" + this.f14317e + ", etag" + this.f14318f + ", last_access" + this.f14319g + ", last_updated" + this.f14320h + ",_data" + this.f14321i;
    }
}
