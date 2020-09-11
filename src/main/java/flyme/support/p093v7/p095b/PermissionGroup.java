package flyme.support.p093v7.p095b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: flyme.support.v7.b.d */
public class PermissionGroup implements Comparable<PermissionGroup> {

    /* renamed from: a */
    private PackageManagerProxy f17052a;

    /* renamed from: b */
    private String f17053b;

    /* renamed from: c */
    private Localization f17054c;

    /* renamed from: d */
    private String f17055d;
    @DrawableRes

    /* renamed from: e */
    private int f17056e;

    /* renamed from: f */
    private List<Permission> f17057f = new ArrayList();

    public PermissionGroup(String str, Localization aVar, PackageManagerProxy bVar) {
        this.f17053b = str;
        this.f17054c = aVar;
        this.f17052a = bVar;
    }

    /* renamed from: a */
    public void mo25377a(Permission cVar) {
        this.f17057f.add(cVar);
    }

    /* renamed from: a */
    public Permission mo25373a(String str) {
        for (Permission next : this.f17057f) {
            if (next.mo25368a().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<Permission> mo25375a() {
        return this.f17057f;
    }

    /* renamed from: b */
    public String mo25378b() {
        return this.f17053b;
    }

    /* renamed from: a */
    public void mo25376a(int i) {
        this.f17056e = i;
    }

    /* renamed from: b */
    public void mo25379b(String str) {
        this.f17055d = str;
    }

    /* renamed from: a */
    public String mo25374a(Context context) {
        if (!TextUtils.isEmpty(this.f17055d)) {
            return this.f17055d;
        }
        if (!"zh_CN".equals(Locale.getDefault().toString()) || this.f17054c == null || TextUtils.isEmpty(this.f17054c.mo25362a(context))) {
            return this.f17052a.mo25363a(context, this.f17053b);
        }
        return this.f17054c.mo25362a(context);
    }

    /* renamed from: a */
    public int compareTo(@NonNull PermissionGroup dVar) {
        if (this.f17054c != null && dVar.f17054c != null) {
            return this.f17054c.mo25361a() - dVar.f17054c.mo25361a();
        }
        if (this.f17054c != null) {
            return -1;
        }
        return dVar.f17054c != null ? 1 : 0;
    }
}
