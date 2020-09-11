package com.baidu.p020ar.task;

import android.os.AsyncTask;
import com.baidu.p020ar.util.C0919Utils;
import java.io.File;

/* renamed from: com.baidu.ar.task.CopyFileTask */
public class CopyFileTask extends AsyncTask<String, Integer, Boolean> {

    /* renamed from: a */
    OnCopyFileListener f2284a;

    /* renamed from: com.baidu.ar.task.CopyFileTask$OnCopyFileListener */
    public interface OnCopyFileListener {
        void onFail();

        void onSuccess();
    }

    public CopyFileTask(OnCopyFileListener onCopyFileListener) {
        this.f2284a = onCopyFileListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        return Boolean.valueOf(C0919Utils.copyfile(new File(strArr[0]), new File(strArr[1]), new Boolean(true)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            if (this.f2284a != null) {
                this.f2284a.onSuccess();
            }
        } else if (this.f2284a != null) {
            this.f2284a.onFail();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
    }
}
