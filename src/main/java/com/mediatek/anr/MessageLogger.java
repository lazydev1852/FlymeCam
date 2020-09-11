package com.mediatek.anr;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import com.baidu.p020ar.audio.AudioParams;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageLogger implements Printer {
    static final int LONGER_TIME = 200;
    static final int LONGER_TIME_MESSAGE_COUNT = 20;
    static final int MESSAGE_COUNT = 20;
    private static final int MESSAGE_DUMP_SIZE_MAX = 20;
    private static final String TAG = "MessageLogger";
    public static boolean mEnableLooperLog = false;
    private static Method sGetCurrentTimeMicro = getSystemClockMethod("currentTimeMicro");
    private String MSL_Warn = "MSL Waraning:";
    private Method mGetMessageQueue = getLooperMethod("getQueue");
    private String mLastRecord = null;
    private long mLastRecordDateTime;
    private long mLastRecordKernelTime;
    private CircularMessageInfoArray mLongTimeMessageHistory;
    private Field mMessageField = getMessageField("next");
    private CircularMessageInfoArray mMessageHistory;
    private Field mMessageQueueField = getMessageQueueField("mMessages");
    private long mMsgCnt = 0;
    private String mName = null;
    private long mNonSleepLastRecordKernelTime;
    private long mProcessId;
    private int mState = 0;
    private StringBuilder messageInfo;
    public long nonSleepWallStart;
    public long nonSleepWallTime;
    private String sInstNotCreated = (this.MSL_Warn + "!!! MessageLoggerInstance might not be created !!!\n");
    public long wallStart;
    public long wallTime;

    private static Method getSystemClockMethod(String str) {
        try {
            return Class.forName("android.os.SystemClock").getDeclaredMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private Method getLooperMethod(String str) {
        try {
            return Class.forName("android.os.Looper").getDeclaredMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private Field getMessageQueueField(String str) {
        try {
            Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Exception unused) {
            return null;
        }
    }

    private Field getMessageField(String str) {
        try {
            Field declaredField = Class.forName("android.os.Message").getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Exception unused) {
            return null;
        }
    }

    public MessageLogger() {
        init();
    }

    public MessageLogger(boolean z) {
        mEnableLooperLog = z;
        init();
    }

    public MessageLogger(boolean z, String str) {
        this.mName = str;
        mEnableLooperLog = z;
        init();
    }

    private void init() {
        this.mMessageHistory = new CircularMessageInfoArray(20);
        this.mLongTimeMessageHistory = new CircularMessageInfoArray(20);
        this.messageInfo = new StringBuilder(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
        this.mProcessId = (long) Process.myPid();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:1|2|3|4|5|(1:7)|8|9|(1:11)(2:12|(1:14))|15|(2:17|(1:19)(1:20))|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0030 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void println(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.mState     // Catch:{ all -> 0x00ce }
            r1 = 1
            int r0 = r0 + r1
            r7.mState = r0     // Catch:{ all -> 0x00ce }
            long r2 = r7.mMsgCnt     // Catch:{ all -> 0x00ce }
            r4 = 1
            long r2 = r2 + r4
            r7.mMsgCnt = r2     // Catch:{ all -> 0x00ce }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00ce }
            r7.mLastRecordKernelTime = r2     // Catch:{ all -> 0x00ce }
            long r2 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00ce }
            r7.mNonSleepLastRecordKernelTime = r2     // Catch:{ all -> 0x00ce }
            r0 = 0
            java.lang.reflect.Method r2 = sGetCurrentTimeMicro     // Catch:{ Exception -> 0x0030 }
            if (r2 == 0) goto L_0x0030
            java.lang.reflect.Method r2 = sGetCurrentTimeMicro     // Catch:{ Exception -> 0x0030 }
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0030 }
            java.lang.Object r2 = r2.invoke(r3, r4)     // Catch:{ Exception -> 0x0030 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ Exception -> 0x0030 }
            long r2 = r2.longValue()     // Catch:{ Exception -> 0x0030 }
            r7.mLastRecordDateTime = r2     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            int r2 = r7.mState     // Catch:{ all -> 0x00ce }
            if (r2 != r1) goto L_0x004c
            com.mediatek.anr.MessageLogger$CircularMessageInfoArray r0 = r7.mMessageHistory     // Catch:{ all -> 0x00ce }
            com.mediatek.anr.MessageLogger$MessageInfo r0 = r0.add()     // Catch:{ all -> 0x00ce }
            r0.init()     // Catch:{ all -> 0x00ce }
            r0.startDispatch = r8     // Catch:{ all -> 0x00ce }
            long r2 = r7.mMsgCnt     // Catch:{ all -> 0x00ce }
            r0.msgIdStart = r2     // Catch:{ all -> 0x00ce }
            long r2 = r7.mLastRecordDateTime     // Catch:{ all -> 0x00ce }
            r0.startTimeElapsed = r2     // Catch:{ all -> 0x00ce }
            long r2 = r7.mNonSleepLastRecordKernelTime     // Catch:{ all -> 0x00ce }
            r0.startTimeUp = r2     // Catch:{ all -> 0x00ce }
            goto L_0x0080
        L_0x004c:
            r7.mState = r0     // Catch:{ all -> 0x00ce }
            com.mediatek.anr.MessageLogger$CircularMessageInfoArray r0 = r7.mMessageHistory     // Catch:{ all -> 0x00ce }
            com.mediatek.anr.MessageLogger$MessageInfo r0 = r0.getLast()     // Catch:{ all -> 0x00ce }
            r0.finishDispatch = r8     // Catch:{ all -> 0x00ce }
            long r2 = r7.mMsgCnt     // Catch:{ all -> 0x00ce }
            r0.msgIdFinish = r2     // Catch:{ all -> 0x00ce }
            long r2 = r7.mLastRecordDateTime     // Catch:{ all -> 0x00ce }
            long r4 = r0.startTimeElapsed     // Catch:{ all -> 0x00ce }
            r6 = 0
            long r2 = r2 - r4
            r0.durationElapsed = r2     // Catch:{ all -> 0x00ce }
            long r2 = r7.mNonSleepLastRecordKernelTime     // Catch:{ all -> 0x00ce }
            long r4 = r0.startTimeUp     // Catch:{ all -> 0x00ce }
            r6 = 0
            long r2 = r2 - r4
            r0.durationUp = r2     // Catch:{ all -> 0x00ce }
            long r2 = r0.durationElapsed     // Catch:{ all -> 0x00ce }
            r7.wallTime = r2     // Catch:{ all -> 0x00ce }
            long r2 = r0.durationElapsed     // Catch:{ all -> 0x00ce }
            r4 = 200000(0x30d40, double:9.8813E-319)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0080
            com.mediatek.anr.MessageLogger$CircularMessageInfoArray r2 = r7.mLongTimeMessageHistory     // Catch:{ all -> 0x00ce }
            com.mediatek.anr.MessageLogger$MessageInfo r2 = r2.add()     // Catch:{ all -> 0x00ce }
            r2.copy(r0)     // Catch:{ all -> 0x00ce }
        L_0x0080:
            boolean r0 = mEnableLooperLog     // Catch:{ all -> 0x00ce }
            if (r0 == 0) goto L_0x00cc
            int r0 = r7.mState     // Catch:{ all -> 0x00ce }
            if (r0 != r1) goto L_0x00a4
            java.lang.String r0 = "MessageLogger"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ce }
            r1.<init>()     // Catch:{ all -> 0x00ce }
            java.lang.String r2 = "Debugging_MessageLogger: "
            r1.append(r2)     // Catch:{ all -> 0x00ce }
            r1.append(r8)     // Catch:{ all -> 0x00ce }
            java.lang.String r8 = " start"
            r1.append(r8)     // Catch:{ all -> 0x00ce }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x00ce }
            android.util.Log.d(r0, r8)     // Catch:{ all -> 0x00ce }
            goto L_0x00cc
        L_0x00a4:
            java.lang.String r0 = "MessageLogger"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ce }
            r1.<init>()     // Catch:{ all -> 0x00ce }
            java.lang.String r2 = "Debugging_MessageLogger: "
            r1.append(r2)     // Catch:{ all -> 0x00ce }
            r1.append(r8)     // Catch:{ all -> 0x00ce }
            java.lang.String r8 = " spent "
            r1.append(r8)     // Catch:{ all -> 0x00ce }
            long r2 = r7.wallTime     // Catch:{ all -> 0x00ce }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r1.append(r2)     // Catch:{ all -> 0x00ce }
            java.lang.String r8 = "ms"
            r1.append(r8)     // Catch:{ all -> 0x00ce }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x00ce }
            android.util.Log.d(r0, r8)     // Catch:{ all -> 0x00ce }
        L_0x00cc:
            monitor-exit(r7)     // Catch:{ all -> 0x00ce }
            return
        L_0x00ce:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00ce }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.anr.MessageLogger.println(java.lang.String):void");
    }

    public void setInitStr(String str) {
        this.messageInfo.delete(0, this.messageInfo.length());
        this.messageInfo.append(str);
    }

    private void log(String str) {
        StringBuilder sb = this.messageInfo;
        sb.append(str);
        sb.append("\n");
    }

    public void dumpMessageQueue() {
        try {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                log(this.MSL_Warn + "!!! Current MainLooper is Null !!!");
            } else {
                MessageQueue messageQueue = (MessageQueue) this.mGetMessageQueue.invoke(mainLooper, new Object[0]);
                if (messageQueue == null) {
                    log(this.MSL_Warn + "!!! Current MainLooper's MsgQueue is Null !!!");
                } else {
                    dumpMessageQueueImpl(messageQueue);
                }
            }
        } catch (Exception unused) {
        }
        log(String.format(this.MSL_Warn + "!!! Calling thread from PID:%d's TID:%d(%s),Thread's type is %s!!!", new Object[]{Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), Thread.currentThread().getClass().getName()}));
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        log(String.format(this.MSL_Warn + "!!! get StackTrace: !!!", new Object[0]));
        for (int i = 0; i < stackTrace.length; i++) {
            log(String.format(this.MSL_Warn + "File:%s's Linenumber:%d, Class:%s, Method:%s", new Object[]{stackTrace[i].getFileName(), Integer.valueOf(stackTrace[i].getLineNumber()), stackTrace[i].getClassName(), stackTrace[i].getMethodName()}));
        }
    }

    public void dumpMessageQueueImpl(MessageQueue messageQueue) throws Exception {
        synchronized (messageQueue) {
            Message message = null;
            if (this.mMessageQueueField != null) {
                message = (Message) this.mMessageQueueField.get(messageQueue);
            }
            if (message != null) {
                log("Dump first 20 messages in Queue: ");
                int i = 0;
                while (message != null) {
                    i++;
                    if (i <= 20) {
                        log("Dump Message in Queue (" + i + "): " + message);
                    }
                    message = (Message) this.mMessageField.get(message);
                }
                log("Total Message Count: " + i);
            } else {
                log("mMessages is null");
            }
        }
    }

    public void dumpMessageHistory() {
        synchronized (this) {
            log(">>> Entering MessageLogger.dump. to Dump MSG HISTORY <<<");
            if (this.mMessageHistory != null) {
                if (this.mMessageHistory.size() != 0) {
                    log("MSG HISTORY IN MAIN THREAD:");
                    log("Current kernel time : " + SystemClock.uptimeMillis() + "ms PID=" + this.mProcessId);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    int size = this.mMessageHistory.size() - 1;
                    if (this.mState == 1) {
                        Date date = new Date(this.mLastRecordDateTime / 1000);
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mLastRecordKernelTime;
                        long uptimeMillis = SystemClock.uptimeMillis() - this.mNonSleepLastRecordKernelTime;
                        MessageInfo last = this.mMessageHistory.getLast();
                        log("Last record : Msg#:" + last.msgIdStart + " " + last.startDispatch);
                        log("Last record dispatching elapsedTime:" + elapsedRealtime + " ms/upTime:" + uptimeMillis + " ms");
                        StringBuilder sb = new StringBuilder();
                        sb.append("Last record dispatching time : ");
                        sb.append(simpleDateFormat.format(date));
                        log(sb.toString());
                        size += -1;
                    }
                    while (size >= 0) {
                        MessageInfo messageInfo2 = this.mMessageHistory.get(size);
                        Date date2 = new Date(messageInfo2.startTimeElapsed / 1000);
                        log("Msg#:" + messageInfo2.msgIdFinish + " " + messageInfo2.finishDispatch + " elapsedTime:" + (messageInfo2.durationElapsed / 1000) + " ms/upTime:" + messageInfo2.durationUp + " ms");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Msg#:");
                        sb2.append(messageInfo2.msgIdStart);
                        sb2.append(" ");
                        sb2.append(messageInfo2.startDispatch);
                        sb2.append(" from ");
                        sb2.append(simpleDateFormat.format(date2));
                        log(sb2.toString());
                        size += -1;
                    }
                    log("=== Finish Dumping MSG HISTORY===");
                    log("=== LONGER MSG HISTORY IN MAIN THREAD ===");
                    for (int size2 = this.mLongTimeMessageHistory.size() - 1; size2 >= 0; size2 += -1) {
                        MessageInfo messageInfo3 = this.mLongTimeMessageHistory.get(size2);
                        Date date3 = new Date(messageInfo3.startTimeElapsed / 1000);
                        log("Msg#:" + messageInfo3.msgIdStart + " " + messageInfo3.startDispatch + " from " + simpleDateFormat.format(date3) + " elapsedTime:" + (messageInfo3.durationElapsed / 1000) + " ms/upTime:" + messageInfo3.durationUp + Parameters.MESSAGE_SEQ);
                    }
                    log("=== Finish Dumping LONGER MSG HISTORY===");
                    try {
                        dumpMessageQueue();
                        AnrManagerNative.getDefault().informMessageDump(new String(this.messageInfo.toString()), Process.myPid());
                        this.messageInfo.delete(0, this.messageInfo.length());
                    } catch (RemoteException e) {
                        Log.d(TAG, "informMessageDump exception " + e);
                    }
                }
            }
            log(this.sInstNotCreated);
            dumpMessageQueue();
            try {
                AnrManagerNative.getDefault().informMessageDump(this.messageInfo.toString(), Process.myPid());
            } catch (RemoteException e2) {
                Log.d(TAG, "informMessageDump exception " + e2);
            }
        }
    }

    public class MessageInfo {
        public long durationElapsed;
        public long durationUp;
        public String finishDispatch;
        public long msgIdFinish;
        public long msgIdStart;
        public String startDispatch;
        public long startTimeElapsed;
        public long startTimeUp;

        public MessageInfo() {
            init();
        }

        public void init() {
            this.startDispatch = null;
            this.finishDispatch = null;
            this.msgIdStart = -1;
            this.msgIdFinish = -1;
            this.startTimeUp = 0;
            this.durationUp = -1;
            this.startTimeElapsed = 0;
            this.durationElapsed = -1;
        }

        public void copy(MessageInfo messageInfo) {
            this.startDispatch = messageInfo.startDispatch;
            this.finishDispatch = messageInfo.finishDispatch;
            this.msgIdStart = messageInfo.msgIdStart;
            this.msgIdFinish = messageInfo.msgIdFinish;
            this.startTimeUp = messageInfo.startTimeUp;
            this.durationUp = messageInfo.durationUp;
            this.startTimeElapsed = messageInfo.startTimeElapsed;
            this.durationElapsed = messageInfo.durationElapsed;
        }
    }

    public class CircularMessageInfoArray {
        private MessageInfo[] mElem;
        private int mHead;
        private MessageInfo mLastElem;
        private int mSize;
        private int mTail;

        public CircularMessageInfoArray(int i) {
            int i2 = i + 1;
            this.mElem = new MessageInfo[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.mElem[i3] = new MessageInfo();
            }
            this.mHead = 0;
            this.mTail = 0;
            this.mLastElem = null;
            this.mSize = i2;
        }

        public boolean empty() {
            return this.mHead == this.mTail || this.mElem == null;
        }

        public boolean full() {
            return this.mTail == this.mHead - 1 || this.mTail - this.mHead == this.mSize - 1;
        }

        public int size() {
            if (this.mTail - this.mHead >= 0) {
                return this.mTail - this.mHead;
            }
            return (this.mSize + this.mTail) - this.mHead;
        }

        private MessageInfo getLocked(int i) {
            if (this.mHead + i <= this.mSize - 1) {
                return this.mElem[this.mHead + i];
            }
            return this.mElem[(this.mHead + i) - this.mSize];
        }

        public synchronized MessageInfo get(int i) {
            if (i >= 0) {
                if (i < size()) {
                    return getLocked(i);
                }
            }
            return null;
        }

        public MessageInfo getLast() {
            return this.mLastElem;
        }

        public synchronized MessageInfo add() {
            if (full()) {
                this.mHead++;
                if (this.mHead == this.mSize) {
                    this.mHead = 0;
                }
            }
            this.mLastElem = this.mElem[this.mTail];
            this.mTail++;
            if (this.mTail == this.mSize) {
                this.mTail = 0;
            }
            return this.mLastElem;
        }
    }
}
