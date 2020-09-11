package com.meizu.cloud.pushsdk.networking.internal;

import com.meizu.cloud.pushsdk.networking.common.ANLog;
import com.meizu.cloud.pushsdk.networking.common.ANRequest;
import com.meizu.cloud.pushsdk.networking.common.Priority;
import com.meizu.cloud.pushsdk.networking.core.Core;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ANRequestQueue {
    private static final String TAG = "ANRequestQueue";
    private static ANRequestQueue sInstance;
    private final Set<ANRequest> mCurrentRequests = new HashSet();
    private AtomicInteger mSequenceGenerator = new AtomicInteger();

    public interface RequestFilter {
        boolean apply(ANRequest aNRequest);
    }

    public static void initialize() {
        getInstance();
    }

    public static ANRequestQueue getInstance() {
        if (sInstance == null) {
            synchronized (ANRequestQueue.class) {
                if (sInstance == null) {
                    sInstance = new ANRequestQueue();
                }
            }
        }
        return sInstance;
    }

    private void cancel(RequestFilter requestFilter, boolean z) {
        synchronized (this.mCurrentRequests) {
            try {
                Iterator<ANRequest> it = this.mCurrentRequests.iterator();
                while (it.hasNext()) {
                    ANRequest next = it.next();
                    if (requestFilter.apply(next)) {
                        next.cancel(z);
                        if (next.isCanceled()) {
                            next.destroy();
                            it.remove();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cancelAll(boolean z) {
        synchronized (this.mCurrentRequests) {
            try {
                Iterator<ANRequest> it = this.mCurrentRequests.iterator();
                while (it.hasNext()) {
                    ANRequest next = it.next();
                    next.cancel(z);
                    if (next.isCanceled()) {
                        next.destroy();
                        it.remove();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cancelRequestWithGivenTag(final Object obj, boolean z) {
        if (obj != null) {
            try {
                cancel(new RequestFilter() {
                    public boolean apply(ANRequest aNRequest) {
                        if (!(aNRequest.getTag() instanceof String) || !(obj instanceof String)) {
                            return aNRequest.getTag().equals(obj);
                        }
                        return ((String) aNRequest.getTag()).equals((String) obj);
                    }
                }, z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getSequenceNumber() {
        return this.mSequenceGenerator.incrementAndGet();
    }

    public ANRequest addRequest(ANRequest aNRequest) {
        synchronized (this.mCurrentRequests) {
            try {
                this.mCurrentRequests.add(aNRequest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            aNRequest.setSequenceNumber(getSequenceNumber());
            if (aNRequest.getPriority() == Priority.IMMEDIATE) {
                aNRequest.setFuture(Core.getInstance().getExecutorSupplier().forImmediateNetworkTasks().submit(new InternalRunnable(aNRequest)));
            } else {
                aNRequest.setFuture(Core.getInstance().getExecutorSupplier().forNetworkTasks().submit(new InternalRunnable(aNRequest)));
            }
            ANLog.m4846d("addRequest: after addition - mCurrentRequests size: " + this.mCurrentRequests.size());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aNRequest;
    }

    public void finish(ANRequest aNRequest) {
        synchronized (this.mCurrentRequests) {
            try {
                this.mCurrentRequests.remove(aNRequest);
                ANLog.m4846d("finish: after removal - mCurrentRequests size: " + this.mCurrentRequests.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
