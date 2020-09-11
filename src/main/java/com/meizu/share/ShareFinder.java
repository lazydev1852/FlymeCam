package com.meizu.share;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.meizu.share.p079b.ChooserTargets;
import com.meizu.share.p079b.DisplayResolveInfo;
import com.meizu.share.utils.C2834c;
import com.meizu.share.utils.ReflexActivityAndUserInfo;
import com.meizu.share.utils.ShareItemComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.meizu.share.i */
public class ShareFinder implements ChooserTargetsFinder {

    /* renamed from: a */
    private Context f15756a;

    /* renamed from: b */
    private PackageManager f15757b;

    public ShareFinder(@NonNull Context context) {
        this.f15756a = context;
        this.f15757b = context.getPackageManager();
    }

    /* renamed from: a */
    public ChooserTargets mo23918a(Context context, Intent intent, Intent[] intentArr) {
        List<DisplayResolveInfo> a = m17156a(intentArr);
        ArrayList arrayList = new ArrayList();
        Intent intent2 = new Intent();
        intent2.setAction(intent.getAction());
        intent2.setType(intent.getType());
        List<ResolveInfo> queryIntentActivities = this.f15757b.queryIntentActivities(intent2, 65536);
        LogUtils.m17129a("queryIntentActivities", queryIntentActivities);
        if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
            m17157a(queryIntentActivities);
            for (ResolveInfo bVar : queryIntentActivities) {
                arrayList.add(new DisplayResolveInfo(bVar, (Intent) null));
            }
        }
        return new ChooserTargets(a, arrayList);
    }

    /* renamed from: a */
    public ChooserTargets mo23919a(ChooserTargets aVar) {
        Collections.sort(aVar.mo23979b(), new ShareItemComparator(this.f15756a));
        for (DisplayResolveInfo next : aVar.mo23978a()) {
            CharSequence loadLabel = next.f15734a.loadLabel(this.f15757b);
            if (TextUtils.isEmpty(loadLabel)) {
                loadLabel = next.f15734a.activityInfo.packageName;
            }
            next.mo23981a(this.f15756a, loadLabel);
        }
        for (DisplayResolveInfo next2 : aVar.mo23979b()) {
            CharSequence loadLabel2 = next2.f15734a.loadLabel(this.f15757b);
            if (TextUtils.isEmpty(loadLabel2)) {
                loadLabel2 = next2.f15734a.activityInfo.packageName;
            }
            next2.mo23981a(this.f15756a, loadLabel2);
        }
        LogUtils.m17131b("before name optimize", aVar.mo23979b());
        HashMap hashMap = new HashMap();
        for (DisplayResolveInfo next3 : aVar.mo23979b()) {
            List list = (List) hashMap.get(next3.f15735b);
            if (list == null) {
                list = new ArrayList();
                hashMap.put(next3.f15735b, list);
            }
            list.add(next3);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            boolean z = true;
            if (((List) entry.getValue()).size() > 1) {
                HashSet hashSet = new HashSet();
                Iterator it = ((List) entry.getValue()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CharSequence loadLabel3 = ((DisplayResolveInfo) it.next()).f15734a.activityInfo.applicationInfo.loadLabel(this.f15757b);
                    if (TextUtils.isEmpty(loadLabel3) || hashSet.contains(loadLabel3)) {
                        z = false;
                    } else {
                        hashSet.add(loadLabel3);
                    }
                }
                if (z) {
                    for (DisplayResolveInfo bVar : (List) entry.getValue()) {
                        bVar.mo23981a(this.f15756a, bVar.f15734a.activityInfo.applicationInfo.loadLabel(this.f15757b));
                    }
                }
            }
        }
        LogUtils.m17131b("after name optimize", aVar.mo23979b());
        return aVar;
    }

    @NonNull
    /* renamed from: a */
    private List<DisplayResolveInfo> m17156a(Intent[] intentArr) {
        ActivityInfo resolveActivityInfo;
        if (intentArr == null || intentArr.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (LabeledIntent labeledIntent : intentArr) {
            if (!(labeledIntent == null || (resolveActivityInfo = labeledIntent.resolveActivityInfo(this.f15757b, 0)) == null || (!resolveActivityInfo.exported && resolveActivityInfo.packageName != null && !resolveActivityInfo.packageName.equals(this.f15756a.getPackageName())))) {
                ResolveInfo resolveInfo = new ResolveInfo();
                resolveInfo.activityInfo = resolveActivityInfo;
                if (labeledIntent instanceof LabeledIntent) {
                    LabeledIntent labeledIntent2 = labeledIntent;
                    resolveInfo.resolvePackageName = labeledIntent2.getSourcePackage();
                    resolveInfo.labelRes = labeledIntent2.getLabelResource();
                    resolveInfo.nonLocalizedLabel = labeledIntent2.getNonLocalizedLabel();
                    resolveInfo.icon = labeledIntent2.getIconResource();
                    try {
                        C2834c.m17188a((Object) resolveInfo).mo24023a("iconResourceId").mo24025a(resolveInfo, Integer.valueOf(labeledIntent2.getIconResource()));
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
                    }
                }
                arrayList.add(new DisplayResolveInfo(resolveInfo, labeledIntent));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m17157a(List<ResolveInfo> list) {
        if (list != null) {
            ResolveInfo resolveInfo = null;
            if (list.size() >= 1) {
                resolveInfo = list.get(0);
            }
            Iterator<ResolveInfo> it = list.iterator();
            HashSet hashSet = new HashSet();
            while (it.hasNext()) {
                ResolveInfo next = it.next();
                if (resolveInfo != null && (resolveInfo.priority != next.priority || resolveInfo.isDefault != next.isDefault)) {
                    it.remove();
                    LogUtils.m17128a("removePriority: " + next.toString());
                } else if (ReflexActivityAndUserInfo.m17202a(next) != ReflexActivityAndUserInfo.f15793b) {
                    it.remove();
                    LogUtils.m17128a("removeUserId: " + next.toString());
                } else if (!next.activityInfo.exported) {
                    it.remove();
                    LogUtils.m17128a("removeExport: " + next.toString());
                } else {
                    String str = next.activityInfo.packageName + next.activityInfo.name;
                    if (hashSet.contains(str)) {
                        it.remove();
                        LogUtils.m17128a("removeSame: " + next.toString());
                    } else {
                        hashSet.add(str);
                    }
                }
            }
        }
    }
}
