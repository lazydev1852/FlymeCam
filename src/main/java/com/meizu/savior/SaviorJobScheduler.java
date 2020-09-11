package com.meizu.savior;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.meizu.savior.utils.SaviorUtil;

public class SaviorJobScheduler {
    private static final String TAG = "savior_scheduler";
    private static boolean mServiceBound = false;
    private Context mContext;
    private Intent mSaviorJobIntent;
    private ComponentName mServiceComponent;

    public SaviorJobScheduler(Context context) {
        this.mContext = context;
    }

    private void cancelJob(JobScheduler jobScheduler, int i) {
        Log.i(TAG, "cancel job " + i);
        jobScheduler.cancel(i);
    }

    private boolean isJobPollServiceOn(JobScheduler jobScheduler) {
        for (JobInfo id : jobScheduler.getAllPendingJobs()) {
            if (id.getId() == Constants.JOB_SCHEDULER_ID.intValue()) {
                return true;
            }
        }
        return false;
    }

    public void bindService() {
        Log.i(TAG, "bind job service " + mServiceBound);
        if (!mServiceBound) {
            this.mSaviorJobIntent = new Intent(this.mContext, SaviorJobService.class);
            this.mContext.startService(this.mSaviorJobIntent);
            mServiceBound = true;
        }
    }

    public void scheduleJob() {
        JobScheduler jobScheduler = (JobScheduler) this.mContext.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            Log.i(TAG, "JobScheduler is null");
            return;
        }
        if (isJobPollServiceOn(jobScheduler)) {
            if (SaviorUtil.isPackageVersionUpdate(this.mContext, this.mContext.getPackageName())) {
                cancelJob(jobScheduler, Constants.JOB_SCHEDULER_ID.intValue());
            } else {
                Log.i(TAG, "scheduleJob has been poll");
                return;
            }
        }
        if (this.mServiceComponent == null) {
            this.mServiceComponent = new ComponentName(this.mContext, SaviorJobService.class);
        }
        JobInfo.Builder builder = new JobInfo.Builder(Constants.JOB_SCHEDULER_ID.intValue(), this.mServiceComponent);
        builder.setRequiredNetworkType(1);
        builder.setPeriodic(86400000);
        builder.setPersisted(true);
        Log.d(TAG, "Scheduling job");
        jobScheduler.schedule(builder.build());
    }

    public void unBindService() {
        Log.i(TAG, "unBind job service " + mServiceBound);
        if (mServiceBound && this.mSaviorJobIntent != null) {
            this.mContext.stopService(this.mSaviorJobIntent);
            mServiceBound = false;
        }
    }
}
