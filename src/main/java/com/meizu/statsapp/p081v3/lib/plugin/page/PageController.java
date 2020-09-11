package com.meizu.statsapp.p081v3.lib.plugin.page;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.savior.Constants;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.page.PageController */
public class PageController {
    private static final String TAG = "PageController";
    private final int MAX_PAGE_COUNT = 100;
    private final long PAGE_TIME_OUT = 43200000;
    private Context mContext;
    private LinkedList<Page> pages = new LinkedList<>();

    public PageController(Context context) {
        this.mContext = context;
        Logger.m17378d(TAG, "PageController init");
    }

    public synchronized void startPage(String str) {
        Logger.m17378d(TAG, "startPage: " + str);
        this.pages.addFirst(new Page(str, System.currentTimeMillis(), SystemClock.elapsedRealtime()));
        int size = this.pages.size() + -100;
        if (size > 0) {
            Logger.m17378d(TAG, "ON_PAGE_STOP, too many pages in stack, delete pages " + size);
            for (int i = 0; i < size; i++) {
                this.pages.removeLast();
            }
        }
    }

    public synchronized Page stopPage(String str) {
        Page page;
        Logger.m17378d(TAG, "stopPage: " + str);
        Iterator it = this.pages.iterator();
        while (it.hasNext()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Page page2 = (Page) it.next();
            if (Math.abs(elapsedRealtime - page2.elapse) > 43200000) {
                it.remove();
                Logger.m17378d(TAG, "#2_remove invalid page who's duration > 12 hours:" + page2);
            }
        }
        Iterator it2 = this.pages.iterator();
        page = null;
        while (it2.hasNext()) {
            Page page3 = (Page) it2.next();
            if (str.equals(page3.name)) {
                if (page == null) {
                    Logger.m17378d(TAG, "stopPage, first found page: " + page3);
                    page = page3;
                } else {
                    Logger.m17378d(TAG, "stopPage, found repeated page: " + page3);
                }
                it2.remove();
            }
        }
        return page;
    }

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.page.PageController$Page */
    public class Page {
        public long elapse;
        public String name;
        public long time;

        Page(String str, long j, long j2) {
            this.name = str;
            this.time = j;
            this.elapse = j2;
        }

        public String toString() {
            return Constants.ARRAY_TYPE + this.name + SystemInfoUtil.COMMA + this.time + SystemInfoUtil.COMMA + this.elapse + "]";
        }
    }

    public long getPageDuration(String str) {
        Iterator it = this.pages.iterator();
        System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (it.hasNext()) {
            Page page = (Page) it.next();
            if (str.equals(page.name)) {
                long j = elapsedRealtime - page.elapse;
                if (j > 0) {
                    return j;
                }
                return 0;
            }
        }
        return 0;
    }
}
