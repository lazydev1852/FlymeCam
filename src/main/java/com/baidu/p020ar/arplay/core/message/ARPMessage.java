package com.baidu.p020ar.arplay.core.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.p020ar.arplay.core.ARPCamera;
import com.baidu.p020ar.arplay.core.C0577a;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.baidu.ar.arplay.core.message.ARPMessage */
public class ARPMessage {
    private static final int INVALID_MESSAGE_ID = -1;
    private static final int MSG_MESSAGE_FROM_ENGINE = 1;
    private static ARPMessage mARPMessage;
    private C0577a mArGLEngineCtl;
    private Handler mHandler;
    private boolean mIsInitNative = false;
    /* access modifiers changed from: private */
    public List<ArCallback> mMsgHandlers;
    private HandlerThread mThread = new HandlerThread("msg_callback_thread");

    /* renamed from: com.baidu.ar.arplay.core.message.ARPMessage$ArCallback */
    private static class ArCallback {
        public MessageHandler mHandler;
        public int mMessageId;
        public int mMessageType;

        public ArCallback(int i, int i2, MessageHandler messageHandler) {
            this.mMessageType = i;
            this.mMessageId = i2;
            this.mHandler = messageHandler;
        }
    }

    /* renamed from: com.baidu.ar.arplay.core.message.ARPMessage$ArMessage */
    private static class ArMessage {
        public HashMap<String, Object> mData;
        public int mMessageID;
        public int mMessageType;
        public int mResMessageID;

        public ArMessage(int i, int i2, HashMap<String, Object> hashMap, int i3) {
            this.mMessageType = i;
            this.mMessageID = i2;
            this.mData = hashMap;
            this.mResMessageID = i3;
        }
    }

    /* renamed from: com.baidu.ar.arplay.core.message.ARPMessage$MessageHandler */
    public interface MessageHandler {
        void handleMessage(int i, int i2, HashMap<String, Object> hashMap);
    }

    public ARPMessage() {
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what != 1) {
                    return false;
                }
                ARPMessage.this.processIncomingMessage((ArMessage) message.obj);
                return false;
            }
        });
        this.mMsgHandlers = new LinkedList();
    }

    public static ARPMessage getInstance() {
        ARPMessage aRPMessage;
        if (mARPMessage != null) {
            return mARPMessage;
        }
        synchronized (ARPCamera.class) {
            if (mARPMessage == null) {
                mARPMessage = new ARPMessage();
            }
            aRPMessage = mARPMessage;
        }
        return aRPMessage;
    }

    /* access modifiers changed from: private */
    public void processIncomingMessage(ArMessage arMessage) {
        for (ArCallback next : this.mMsgHandlers) {
            if ((next.mMessageType == 0 || arMessage.mMessageType == next.mMessageType) && (-1 == next.mMessageId || arMessage.mResMessageID == next.mMessageId)) {
                next.mHandler.handleMessage(arMessage.mMessageType, arMessage.mMessageID, arMessage.mData);
            }
        }
    }

    private static void receiveMsgFromEngine(Object obj, int i, int i2, HashMap<String, Object> hashMap, int i3) {
        ARPMessage aRPMessage = (ARPMessage) ((WeakReference) obj).get();
        if (aRPMessage != null) {
            aRPMessage.receiveMsgFromEngine(i, i2, hashMap, i3);
        }
    }

    private void sendMessageImpl(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        if (this.mArGLEngineCtl != null) {
            final int i4 = i2;
            final int i5 = i;
            final HashMap<String, Object> hashMap2 = hashMap;
            final int i6 = i3;
            this.mArGLEngineCtl.mo9236b(new Runnable() {
                public void run() {
                    ARPMessage aRPMessage;
                    int i;
                    int i2;
                    if (-1 == i4) {
                        aRPMessage = ARPMessage.this;
                        i = i5;
                        i2 = ARPMessage.this.getMessageID();
                    } else {
                        aRPMessage = ARPMessage.this;
                        i = i5;
                        i2 = i4;
                    }
                    aRPMessage.sendMessageToEngine(i, i2, hashMap2, i6);
                }
            });
        }
    }

    private void sendMessageImpl(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, -1, hashMap, i2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:5|6)|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finalize() {
        /*
            r1 = this;
            super.finalize()
            monitor-enter(r1)
            boolean r0 = r1.mIsInitNative     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000b
            r1.nativeFinalize()     // Catch:{ Throwable -> 0x000b }
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x000d }
            return
        L_0x000d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.arplay.core.message.ARPMessage.finalize():void");
    }

    /* access modifiers changed from: package-private */
    public native int getMessageID();

    /* access modifiers changed from: package-private */
    public native void nativeFinalize();

    /* access modifiers changed from: package-private */
    public native void nativeSetup(Object obj);

    public void receiveMsgFromEngine(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        this.mHandler.obtainMessage(1, new ArMessage(i, i2, hashMap, i3)).sendToTarget();
    }

    public synchronized void registerMessageHandler(final int i, final MessageHandler messageHandler) {
        this.mHandler.post(new Runnable() {
            public void run() {
                ARPMessage.this.mMsgHandlers.add(new ArCallback(i, -1, messageHandler));
            }
        });
    }

    public void release() {
        this.mHandler.post(new Runnable() {
            public void run() {
                if (ARPMessage.this.mMsgHandlers != null) {
                    ARPMessage.this.mMsgHandlers.clear();
                }
            }
        });
    }

    public synchronized void removeMessageHandeler(final MessageHandler messageHandler) {
        this.mHandler.post(new Runnable() {
            public void run() {
                if (ARPMessage.this.mMsgHandlers != null) {
                    Iterator it = ARPMessage.this.mMsgHandlers.iterator();
                    while (it.hasNext()) {
                        if (((ArCallback) it.next()).mHandler == messageHandler) {
                            it.remove();
                        }
                    }
                }
            }
        });
    }

    public void sendLuaScriptToEngine(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(ARPMessageType.ARPMessageParamKeys.MAP_NPC_KEY_NAME, str);
            sendMessage(2001, hashMap);
        }
    }

    public void sendMessage(int i, HashMap<String, Object> hashMap) {
        sendMessageImpl(i, hashMap, -1);
    }

    /* access modifiers changed from: package-private */
    public native void sendMessageToEngine(int i, int i2, HashMap<String, Object> hashMap, int i3);

    public void sendResponseMessage(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, hashMap, i2);
    }

    public void setArEngineCtl(C0577a aVar) {
        this.mArGLEngineCtl = aVar;
        synchronized (this) {
            if (this.mArGLEngineCtl != null && !this.mIsInitNative) {
                nativeSetup(new WeakReference(this));
                this.mIsInitNative = true;
            }
        }
    }

    public void setModelVirtualColor(int i, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(ARPMessageType.ARPMessageParamKeys.MODEL_COLOR_KEY, Integer.valueOf(i));
        if (!z) {
            hashMap.put(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, 1);
        }
        sendMessage(ARPMessageType.MSG_TYPE_SDK_SET_MODEL_COLOR, hashMap);
    }
}
