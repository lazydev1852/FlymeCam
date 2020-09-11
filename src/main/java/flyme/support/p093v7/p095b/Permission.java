package flyme.support.p093v7.p095b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Locale;

/* renamed from: flyme.support.v7.b.c */
public class Permission implements Comparable<Permission> {

    /* renamed from: a */
    private PackageManagerProxy f17048a;

    /* renamed from: b */
    private String f17049b;

    /* renamed from: c */
    private Localization f17050c;

    /* renamed from: d */
    private String f17051d;

    public Permission(String str, Localization aVar, PackageManagerProxy bVar) {
        this.f17049b = str;
        this.f17050c = aVar;
        this.f17048a = bVar;
    }

    /* renamed from: a */
    public String mo25368a() {
        return this.f17049b;
    }

    /* renamed from: a */
    public void mo25370a(String str) {
        this.f17051d = str;
    }

    /* renamed from: a */
    public String mo25369a(Context context) {
        if (!TextUtils.isEmpty(this.f17051d)) {
            return this.f17051d;
        }
        if (!"zh_CN".equals(Locale.getDefault().toString()) || this.f17050c == null || TextUtils.isEmpty(this.f17050c.mo25362a(context))) {
            return this.f17048a.mo25366b(this.f17049b);
        }
        return this.f17050c.mo25362a(context);
    }

    /* renamed from: a */
    public int compareTo(@NonNull Permission cVar) {
        if (this.f17050c != null && cVar.f17050c != null) {
            return this.f17050c.mo25361a() - cVar.f17050c.mo25361a();
        }
        if (this.f17050c != null) {
            return -1;
        }
        return cVar.f17050c != null ? 1 : 0;
    }
}
