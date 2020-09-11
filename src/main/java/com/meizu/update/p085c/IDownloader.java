package com.meizu.update.p085c;

import android.util.Pair;
import com.meizu.update.p085c.p088c.IFileChecker;
import java.util.List;

/* renamed from: com.meizu.update.c.d */
public interface IDownloader {
    /* renamed from: a */
    void mo24711a();

    /* renamed from: a */
    void mo24713a(IFileChecker dVar);

    /* renamed from: a */
    void mo24714a(String str);

    /* renamed from: a */
    void mo24715a(List<Pair<String, String>> list);

    /* renamed from: a */
    boolean mo24716a(boolean z) throws CancelException, LoadException, RelocationException, FileIllegalException, LocalHttpException;
}
