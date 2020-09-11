package com.baidu.p020ar.load.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.p020ar.load.DownloadTask;
import com.baidu.p020ar.load.FileManageTask;
import com.baidu.p020ar.load.QueryTask;
import com.baidu.p020ar.load.downloader.IDownloadParamsParser;
import com.baidu.p020ar.load.util.DownloadConstants;
import com.baidu.p020ar.load.util.ResponseUtil;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.statistic.StatisticHelper;
import com.baidu.p020ar.task.ActionResponseListener;
import com.baidu.p020ar.util.ARLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.load.downloader.DownloadController */
public class DownloadController {

    /* renamed from: A */
    private String f1774A;

    /* renamed from: B */
    private int f1775B;

    /* renamed from: C */
    private boolean f1776C = false;

    /* renamed from: a */
    private Object f1777a = new Object();

    /* renamed from: b */
    private STATE f1778b = STATE.INITIAL;

    /* renamed from: c */
    private C0786a f1779c;

    /* renamed from: d */
    private C0788c f1780d;

    /* renamed from: e */
    private C0787b f1781e;

    /* renamed from: f */
    private List<ActionResponseListener<String>> f1782f = new ArrayList();

    /* renamed from: g */
    private List<ActionResponseListener<String>> f1783g = new ArrayList();

    /* renamed from: h */
    private QueryTask.ExtraOperateListener f1784h;

    /* renamed from: i */
    private List<ActionResponseListener<String>> f1785i = new ArrayList();

    /* renamed from: j */
    private FileManageTask.ExtraOperateListener f1786j;

    /* renamed from: k */
    private QueryTask f1787k;

    /* renamed from: l */
    private DownloadTask f1788l;

    /* renamed from: m */
    private FileManageTask f1789m;

    /* renamed from: n */
    private String f1790n;

    /* renamed from: o */
    private String f1791o;

    /* renamed from: p */
    private int f1792p;

    /* renamed from: q */
    private String f1793q;

    /* renamed from: r */
    private IDownloadParamsParser f1794r;

    /* renamed from: s */
    private String f1795s;

    /* renamed from: t */
    private String f1796t;

    /* renamed from: u */
    private DownloadTask.FileStoreStrategy f1797u;

    /* renamed from: v */
    private String f1798v;

    /* renamed from: w */
    private int f1799w;

    /* renamed from: x */
    private String f1800x;

    /* renamed from: y */
    private boolean f1801y;

    /* renamed from: z */
    private FileManageTask.FileMergeStrategy f1802z;

    /* renamed from: com.baidu.ar.load.downloader.DownloadController$EVENT */
    public enum EVENT {
        START_QUERY,
        START_DOWNLOAD,
        START_FILE_MANAGE
    }

    /* renamed from: com.baidu.ar.load.downloader.DownloadController$STATE */
    public enum STATE {
        INITIAL,
        QUERYING,
        QUERY_FINISH,
        QUERY_ERROR,
        DOWNLOADING,
        DOWNLOAD_FINISH,
        DOWNLOAD_ERROR,
        FILE_MANAGING,
        FILE_MANAGE_FINISH,
        FILE_MANAGE_ERROR,
        DONE
    }

    /* renamed from: a */
    private void m2048a(List<ActionResponseListener<String>> list, int i) {
        for (ActionResponseListener<String> onProgress : list) {
            onProgress.onProgress(i);
        }
    }

    /* renamed from: a */
    private void m2049a(List<ActionResponseListener<String>> list, String str) {
        for (ActionResponseListener<String> onResponse : list) {
            onResponse.onResponse(str);
        }
    }

    /* renamed from: d */
    private void m2050d(String str) {
        STATE state;
        m2049a(this.f1783g, str);
        try {
            if (ResponseUtil.getIdFromResponse(str) != 0) {
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_QUERY_FAILURE);
                state = STATE.QUERY_ERROR;
            } else if (this.f1794r == null) {
                this.f1778b = STATE.DONE;
                return;
            } else {
                IDownloadParamsParser.DownloadParam parser = this.f1794r.parser(new JSONObject(ResponseUtil.getHttpResultFromResponse(str)).toString());
                if (parser.mErrorCode == 0) {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_QUERY_SUCCESS);
                    if (!TextUtils.isEmpty(parser.mDownloadPath)) {
                        this.f1796t = parser.mDownloadPath;
                    }
                    if (!TextUtils.isEmpty(parser.mFileManagePath)) {
                        this.f1800x = parser.mFileManagePath;
                    }
                    m2051e(parser.mDownloadUrl);
                    return;
                }
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_QUERY_FAILURE);
                state = STATE.QUERY_ERROR;
            }
            this.f1778b = state;
        } catch (JSONException e) {
            e.printStackTrace();
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_QUERY_FAILURE);
            this.f1778b = STATE.QUERY_ERROR;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_QUERY_FAILURE);
            this.f1778b = STATE.QUERY_ERROR;
        }
    }

    /* renamed from: e */
    private void m2051e(String str) {
        m2054g();
        this.f1788l = new DownloadTask(str, this.f1796t, this.f1797u, this.f1779c);
        this.f1788l.setParallel();
        this.f1788l.start();
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_START_DOWNLOAD);
        this.f1778b = STATE.DOWNLOADING;
    }

    /* renamed from: f */
    private void m2052f() {
        if (this.f1780d == null) {
            this.f1780d = new C0788c(this);
        }
    }

    /* renamed from: f */
    private void m2053f(String str) {
        m2049a(this.f1782f, str);
        if (ResponseUtil.getIdFromResponse(str) == 0) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_DOWNLOAD_SUCCESS);
            m2058j();
            return;
        }
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_DOWNLOAD_FAILURE);
        this.f1778b = STATE.DOWNLOAD_ERROR;
    }

    /* renamed from: g */
    private void m2054g() {
        if (this.f1779c == null) {
            this.f1779c = new C0786a(this);
        }
    }

    /* renamed from: g */
    private void m2055g(String str) {
        STATE state;
        m2049a(this.f1785i, str);
        if (ResponseUtil.getIdFromResponse(str) == 0) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_FILE_MANAGE_SUCCESS);
            state = STATE.DONE;
        } else {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_FILE_MANAGE_FAILURE);
            state = STATE.FILE_MANAGE_ERROR;
        }
        this.f1778b = state;
    }

    /* renamed from: h */
    private void m2056h() {
        if (this.f1781e == null) {
            this.f1781e = new C0787b(this);
        }
    }

    /* renamed from: i */
    private void m2057i() {
        m2052f();
        this.f1787k = new QueryTask(this.f1790n, this.f1791o, this.f1792p, this.f1780d, this.f1784h);
        this.f1787k.setParallel();
        this.f1787k.start();
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_START_QUERY);
        this.f1778b = STATE.QUERYING;
    }

    /* renamed from: j */
    private void m2058j() {
        m2056h();
        this.f1789m = new FileManageTask(this.f1796t, this.f1800x, this.f1802z, this.f1781e, this.f1786j);
        if (this.f1801y) {
            this.f1789m.setParallel();
        }
        this.f1789m.start();
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_START_FILE_MANAGE);
        this.f1778b = STATE.FILE_MANAGING;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10197a(int i) {
        ARLog.m2696e("bdar: onDownloadUpdateProgress = " + i);
        this.f1799w = i;
        if (this.f1776C) {
            m2048a(this.f1782f, this.f1799w);
        }
    }

    /* renamed from: a */
    public void mo10198a(EVENT event, Map<String, Object> map) {
        synchronized (this.f1777a) {
            Bundle bundle = (Bundle) map.get(DownloadConstants.QUERY_INFO);
            if (bundle != null) {
                this.f1790n = bundle.getString(DownloadConstants.QUERY_URL);
                this.f1791o = bundle.getString(DownloadConstants.QUERY_PARAMS);
                this.f1792p = bundle.getInt(DownloadConstants.QUERY_REQUEST_MODE);
            }
            this.f1794r = (IDownloadParamsParser) map.get(DownloadConstants.DOWNLOAD_PARAMS_PARSER);
            this.f1795s = (String) map.get(DownloadConstants.DOWNLOAD_URL);
            this.f1796t = (String) map.get(DownloadConstants.DOWNLOAD_SAVE_PATH);
            this.f1797u = (DownloadTask.FileStoreStrategy) map.get(DownloadConstants.FILE_STORE_STRATEGY);
            this.f1800x = (String) map.get(DownloadConstants.TARGET_PATH);
            this.f1801y = ((Boolean) map.get(DownloadConstants.USE_PARALLEL)).booleanValue();
            this.f1802z = (FileManageTask.FileMergeStrategy) map.get(DownloadConstants.FILE_MERGE_STRATEGY);
            this.f1783g.add(new WeakReference((ActionResponseListener) map.get(DownloadConstants.QUERY_CALLBACK)).get());
            this.f1784h = (QueryTask.ExtraOperateListener) new WeakReference((QueryTask.ExtraOperateListener) map.get(DownloadConstants.QUERY_EXTRA_OPERATOR)).get();
            this.f1782f.add(new WeakReference((ActionResponseListener) map.get(DownloadConstants.DOWNLOAD_CALLBACK)).get());
            this.f1785i.add(new WeakReference((ActionResponseListener) map.get(DownloadConstants.FILE_MANAGE_CALLBACK)).get());
            this.f1786j = (FileManageTask.ExtraOperateListener) new WeakReference((FileManageTask.ExtraOperateListener) map.get(DownloadConstants.FILE_MANAGE_EXTRA_OPERATOR)).get();
            switch (event) {
                case START_QUERY:
                    m2057i();
                    break;
                case START_DOWNLOAD:
                    m2051e(this.f1795s);
                    break;
            }
        }
    }

    /* renamed from: a */
    public void mo10199a(ActionResponseListener<String> actionResponseListener, ActionResponseListener<String> actionResponseListener2, ActionResponseListener<String> actionResponseListener3) {
        synchronized (this.f1777a) {
            this.f1783g.remove(actionResponseListener);
            this.f1782f.remove(actionResponseListener2);
            this.f1785i.remove(actionResponseListener3);
            this.f1786j = null;
            if (this.f1783g.size() == 0 && this.f1782f.size() == 0 && this.f1785i.size() == 0) {
                mo10210e();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10200a(String str) {
        synchronized (this.f1777a) {
            this.f1793q = str;
            this.f1778b = STATE.QUERY_FINISH;
            if (this.f1776C) {
                m2050d(this.f1793q);
            }
        }
    }

    /* renamed from: a */
    public void mo10201a(boolean z) {
        this.f1776C = z;
    }

    /* renamed from: a */
    public boolean mo10202a() {
        boolean z;
        synchronized (this.f1777a) {
            z = (this.f1778b == STATE.DONE || this.f1778b == STATE.QUERY_ERROR || this.f1778b == STATE.DOWNLOAD_ERROR || this.f1778b == STATE.FILE_MANAGE_ERROR) ? false : true;
        }
        return z;
    }

    /* renamed from: b */
    public void mo10203b() {
        ARLog.m2696e("bdar:DownloadController: when resume params = " + this.f1791o);
        ARLog.m2696e("bdar:DownloadController: when resume mCurrentState = " + this.f1778b);
        synchronized (this.f1777a) {
            switch (this.f1778b) {
                case INITIAL:
                case QUERY_ERROR:
                case DOWNLOAD_ERROR:
                case FILE_MANAGE_ERROR:
                    break;
                case QUERYING:
                    if (this.f1787k != null) {
                        this.f1787k.resume();
                        break;
                    }
                    break;
                case QUERY_FINISH:
                    m2050d(this.f1793q);
                    break;
                case DOWNLOADING:
                    if (this.f1788l != null) {
                        this.f1788l.resume();
                        break;
                    }
                    break;
                case DOWNLOAD_FINISH:
                    m2053f(this.f1798v);
                    break;
                case FILE_MANAGING:
                    if (this.f1789m != null) {
                        this.f1789m.resume();
                        break;
                    }
                    break;
                case FILE_MANAGE_FINISH:
                    m2055g(this.f1774A);
                    break;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10204b(int i) {
        ARLog.m2696e("bdar: onFileManageUpdateProgress = " + i);
        this.f1775B = i;
        if (this.f1776C) {
            m2048a(this.f1785i, this.f1775B);
        }
    }

    /* renamed from: b */
    public void mo10205b(ActionResponseListener<String> actionResponseListener, ActionResponseListener<String> actionResponseListener2, ActionResponseListener<String> actionResponseListener3) {
        synchronized (this.f1777a) {
            if (actionResponseListener != null) {
                try {
                    this.f1783g.add(new WeakReference(actionResponseListener).get());
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (actionResponseListener2 != null) {
                this.f1782f.add(new WeakReference(actionResponseListener2).get());
            }
            if (actionResponseListener3 != null) {
                this.f1785i.add(new WeakReference(actionResponseListener3).get());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10206b(String str) {
        synchronized (this.f1777a) {
            this.f1798v = str;
            this.f1778b = STATE.DOWNLOAD_FINISH;
            if (this.f1776C) {
                m2053f(this.f1798v);
            }
        }
    }

    /* renamed from: c */
    public void mo10207c() {
        ARLog.m2696e("bdar:DownloadController: when pause queryParams = " + this.f1791o);
        ARLog.m2696e("bdar:DownloadController: when pause mCurrentState = " + this.f1778b);
        synchronized (this.f1777a) {
            switch (this.f1778b) {
                case INITIAL:
                case QUERY_FINISH:
                case QUERY_ERROR:
                case DOWNLOAD_FINISH:
                case DOWNLOAD_ERROR:
                case FILE_MANAGE_FINISH:
                case FILE_MANAGE_ERROR:
                case DONE:
                    break;
                case QUERYING:
                    if (this.f1787k != null) {
                        this.f1787k.pause();
                        break;
                    }
                    break;
                case DOWNLOADING:
                    if (this.f1788l != null) {
                        this.f1788l.pause();
                        break;
                    }
                    break;
                case FILE_MANAGING:
                    if (this.f1789m != null) {
                        this.f1789m.pause();
                        break;
                    }
                    break;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10208c(String str) {
        synchronized (this.f1777a) {
            this.f1774A = str;
            this.f1778b = STATE.FILE_MANAGE_FINISH;
            if (this.f1776C) {
                m2055g(this.f1774A);
            }
        }
    }

    /* renamed from: d */
    public void mo10209d() {
        synchronized (this.f1777a) {
            this.f1783g.clear();
            this.f1782f.clear();
            this.f1785i.clear();
            this.f1786j = null;
            mo10210e();
        }
    }

    /* renamed from: e */
    public void mo10210e() {
        ARLog.m2696e("bdar:DownloadController: when cancel queryUrl = " + this.f1790n);
        ARLog.m2696e("bdar:DownloadController: when cancel queryParams = " + this.f1791o);
        ARLog.m2696e("bdar:DownloadController: when cancel mCurrentState = " + this.f1778b);
        int i = C07851.f1804b[this.f1778b.ordinal()];
        if (i != 2) {
            if (i != 5) {
                if (i != 8) {
                    this.f1778b = STATE.DONE;
                } else if (this.f1789m != null) {
                    this.f1789m.cancel();
                }
            } else if (this.f1788l != null) {
                this.f1788l.cancel();
            }
        } else if (this.f1787k != null) {
            this.f1787k.cancel();
        }
    }
}
