package com.meizu.savior;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import com.meizu.savior.utils.NetworkUtil;
import com.meizu.savior.utils.SaviorUtil;

public class SaviorJobService extends JobService {
    public static final String CTA_PERMISSION = "cta_permisson";
    public static final int CTA_PERMISSION_FORBID = 0;
    private static final String TAG = "savior_service";
    public static final long sIntervalMillis = 86400000;

    /* access modifiers changed from: private */
    public void handleSaviorCheck() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getPackageName(), 0);
        int i = sharedPreferences.getInt(CTA_PERMISSION, 0);
        Log.i(TAG, "handleSaviorCheck, cta = " + i);
        if (i == 0 && !SaviorUtil.isInternational()) {
            Log.i(TAG, "cta is not check, can't start net work!");
        } else if (NetworkUtil.isNetworkAvailable(this)) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = sharedPreferences.getLong(Constants.PARAM_PATCH_DOWNLOAD_DATE, currentTimeMillis);
            if (currentTimeMillis - j >= 86400000 || currentTimeMillis == j) {
                Log.d(TAG, "start fetch patch");
                new PatchExecutor(getApplicationContext(), new PatchManipulateImp(), new SaviorCallBackSample()).start();
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service created");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroyed");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public boolean onStartJob(final JobParameters jobParameters) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Log.i(SaviorJobService.TAG, "onStartJob");
                SaviorJobService.this.handleSaviorCheck();
                SaviorJobService.this.jobFinished(jobParameters, false);
            }
        }, 1000);
        Log.i(TAG, "on start job: " + jobParameters.getJobId());
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        Log.i(TAG, "on stop job: " + jobParameters.getJobId());
        return false;
    }
}
