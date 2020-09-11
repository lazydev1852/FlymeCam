package com.meizu.sharewidget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.meizu.sharewidget.p080a.C2858a;
import com.meizu.sharewidget.p080a.C2866d;
import com.meizu.sharewidget.p080a.C2876e;
import com.meizu.sharewidget.p080a.ShareWidgetInstallTimeComparator;
import com.meizu.sharewidget.p080a.ShareWidgetPositionProtect;
import com.meizu.sharewidget.p080a.ShareWidgetUsageComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.meizu.sharewidget.e */
public class ShareResolveFinder implements ResolveFinder {

    /* renamed from: a */
    private Context f15931a;

    /* renamed from: b */
    private PackageManager f15932b;

    public ShareResolveFinder(@NonNull Context context) {
        this.f15931a = context;
        this.f15932b = context.getPackageManager();
    }

    /* renamed from: a */
    public List<C2858a> mo24094a(Context context, Intent intent) throws Exception {
        ArrayList arrayList = new ArrayList(m17322a(m17327a(intent)));
        Intent intent2 = new Intent();
        intent2.setAction(intent.getAction());
        intent2.setType(intent.getType());
        List<ResolveInfo> queryIntentActivities = this.f15932b.queryIntentActivities(intent2, 65536);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            return arrayList;
        }
        m17323a(queryIntentActivities);
        m17328b(queryIntentActivities);
        m17330d(queryIntentActivities);
        m17329c(queryIntentActivities);
        m17325a(queryIntentActivities, (List<C2858a>) arrayList);
        return arrayList;
    }

    @Nullable
    /* renamed from: a */
    private Intent[] m17327a(Intent intent) throws Exception {
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.intent.extra.INITIAL_INTENTS");
        if (parcelableArrayExtra == null) {
            return null;
        }
        Intent[] intentArr = new Intent[parcelableArrayExtra.length];
        int i = 0;
        while (i < parcelableArrayExtra.length) {
            if (parcelableArrayExtra[i] instanceof Intent) {
                intentArr[i] = (Intent) parcelableArrayExtra[i];
                i++;
            } else {
                throw new Exception("parcelable object must instance of intent");
            }
        }
        return intentArr;
    }

    @NonNull
    /* renamed from: a */
    private List<C2858a> m17322a(Intent[] intentArr) {
        ActivityInfo resolveActivityInfo;
        if (intentArr == null || intentArr.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (LabeledIntent labeledIntent : intentArr) {
            if (!(labeledIntent == null || (resolveActivityInfo = labeledIntent.resolveActivityInfo(this.f15932b, 0)) == null || (!resolveActivityInfo.exported && resolveActivityInfo.packageName != null && !resolveActivityInfo.packageName.equals(this.f15931a.getPackageName())))) {
                ResolveInfo resolveInfo = new ResolveInfo();
                resolveInfo.activityInfo = resolveActivityInfo;
                if (labeledIntent instanceof LabeledIntent) {
                    LabeledIntent labeledIntent2 = labeledIntent;
                    resolveInfo.resolvePackageName = labeledIntent2.getSourcePackage();
                    resolveInfo.labelRes = labeledIntent2.getLabelResource();
                    resolveInfo.nonLocalizedLabel = labeledIntent2.getNonLocalizedLabel();
                    resolveInfo.icon = labeledIntent2.getIconResource();
                    try {
                        C2866d.m17251a((Object) resolveInfo).mo24064a("iconResourceId").mo24066a(resolveInfo, Integer.valueOf(labeledIntent2.getIconResource()));
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
                    }
                }
                arrayList.add(new C2858a(this.f15931a, resolveInfo, resolveInfo.loadLabel(this.f15932b), (CharSequence) null, labeledIntent));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m17323a(@NonNull List<ResolveInfo> list) {
        int size = list.size();
        if (size >= 2) {
            ResolveInfo resolveInfo = list.get(0);
            for (int i = 1; i < size; i++) {
                ResolveInfo resolveInfo2 = list.get(i);
                if (resolveInfo.priority != resolveInfo2.priority || resolveInfo.isDefault != resolveInfo2.isDefault) {
                    while (i < size) {
                        list.remove(i);
                        size--;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m17328b(List<ResolveInfo> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                if (C2876e.m17268a(list.get(i)) != C2876e.f15874b) {
                    list.remove(i);
                    size--;
                    i--;
                }
                i++;
            }
        }
    }

    /* renamed from: c */
    private void m17329c(List<ResolveInfo> list) {
        if (list.size() >= 2) {
            try {
                ShareWidgetInstallTimeComparator fVar = new ShareWidgetInstallTimeComparator(this.f15932b);
                Collections.sort(list, fVar);
                fVar.mo24069a(list);
                Collections.sort(list, new ShareWidgetUsageComparator(this.f15931a, list));
                ShareWidgetPositionProtect.m17274a(list);
            } catch (Exception e) {
                Log.i("ShareFinder", "exception: " + e.toString());
            }
        }
    }

    /* renamed from: d */
    private void m17330d(List<ResolveInfo> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (!list.get(size).activityInfo.exported) {
                list.remove(size);
            }
        }
    }

    /* renamed from: a */
    private void m17325a(List<ResolveInfo> list, List<C2858a> list2) {
        List<ResolveInfo> list3 = list;
        if (list.size() >= 2) {
            ResolveInfo resolveInfo = list.get(0);
            int size = list.size();
            ResolveInfo resolveInfo2 = resolveInfo;
            String loadLabel = resolveInfo.loadLabel(this.f15932b);
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                if (loadLabel == null) {
                    loadLabel = resolveInfo2.activityInfo.packageName;
                }
                ResolveInfo resolveInfo3 = list.get(i2);
                CharSequence loadLabel2 = resolveInfo3.loadLabel(this.f15932b);
                if (loadLabel2 == null) {
                    loadLabel2 = resolveInfo3.activityInfo.packageName;
                }
                CharSequence charSequence = loadLabel2;
                if (!charSequence.equals(loadLabel)) {
                    m17324a(list, i, i2 - 1, resolveInfo2, loadLabel, list2);
                    i = i2;
                    resolveInfo2 = resolveInfo3;
                    loadLabel = charSequence;
                }
            }
            m17324a(list, i, size - 1, resolveInfo2, loadLabel, list2);
        }
    }

    /* renamed from: a */
    private void m17324a(List<ResolveInfo> list, int i, int i2, ResolveInfo resolveInfo, CharSequence charSequence, List<C2858a> list2) {
        if ((i2 - i) + 1 != 1) {
            boolean z = false;
            CharSequence loadLabel = resolveInfo.activityInfo.applicationInfo.loadLabel(this.f15932b);
            if (loadLabel == null) {
                z = true;
            }
            if (!z) {
                HashSet hashSet = new HashSet();
                hashSet.add(loadLabel);
                int i3 = i + 1;
                while (true) {
                    if (i3 > i2) {
                        break;
                    }
                    CharSequence loadLabel2 = list.get(i3).activityInfo.applicationInfo.loadLabel(this.f15932b);
                    if (loadLabel2 == null || hashSet.contains(loadLabel2)) {
                        z = true;
                    } else {
                        hashSet.add(loadLabel2);
                        i3++;
                    }
                }
                z = true;
                hashSet.clear();
            }
            while (i <= i2) {
                ResolveInfo resolveInfo2 = list.get(i);
                if (z) {
                    if (!m17326a(list2, resolveInfo2)) {
                        list2.add(new C2858a(this.f15931a, resolveInfo2, charSequence, resolveInfo2.activityInfo.packageName, (Intent) null));
                    }
                } else if (!m17326a(list2, resolveInfo2)) {
                    list2.add(new C2858a(this.f15931a, resolveInfo2, charSequence, resolveInfo2.activityInfo.applicationInfo.loadLabel(this.f15932b), (Intent) null));
                }
                i++;
            }
        } else if (!m17326a(list2, resolveInfo)) {
            list2.add(new C2858a(this.f15931a, resolveInfo, charSequence, (CharSequence) null, (Intent) null));
        }
    }

    /* renamed from: a */
    private boolean m17326a(List<C2858a> list, ResolveInfo resolveInfo) {
        if (!(list == null || resolveInfo == null)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).f15833a.activityInfo.name.equals(resolveInfo.activityInfo.name) && list.get(i).f15833a.activityInfo.packageName.equals(resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
