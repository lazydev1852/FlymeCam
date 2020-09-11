package com.meizu.cloud.pushsdk.handler.impl.fileupload;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractAppLogicListener;
import com.meizu.cloud.pushsdk.handler.impl.AbstractMessageHandler;
import com.meizu.cloud.pushsdk.handler.impl.model.UploadLogMessage;
import com.meizu.cloud.pushsdk.networking.common.ANResponse;
import com.meizu.cloud.pushsdk.notification.PushNotification;
import com.meizu.cloud.pushsdk.platform.api.PushPlatformManager;
import com.meizu.cloud.pushsdk.util.Connectivity;
import com.meizu.cloud.pushsdk.util.UxIPUtils;
import java.io.File;

public class LogUploadMessageHandler extends AbstractMessageHandler<UploadLogMessage> {
    public int getProcessorType() {
        return 65536;
    }

    public LogUploadMessageHandler(Context context, AbstractAppLogicListener abstractAppLogicListener) {
        super(context, abstractAppLogicListener);
    }

    /* access modifiers changed from: protected */
    public UploadLogMessage getMessage(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new UploadLogMessage(intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE), stringExtra, intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }

    /* access modifiers changed from: protected */
    public void unsafeSend(UploadLogMessage uploadLogMessage, PushNotification pushNotification) {
        String str;
        File file;
        DebugLogger.flush();
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdktmp/" + uploadLogMessage.getControlMessage().getStatics().getTaskId() + "_" + uploadLogMessage.getControlMessage().getStatics().getDeviceId() + ".zip";
        try {
            new ZipTask(str2).zip(uploadLogMessage.getFileList());
            file = new File(str2);
            str = null;
        } catch (Exception e) {
            str = e.getMessage();
            DebugLogger.m4828e("AbstractMessageHandler", "zip error message " + str);
            file = null;
        }
        if (file != null && file.length() / 1024 > ((long) uploadLogMessage.getMaxSize())) {
            str = "the upload file exceeds the max size";
        } else if (uploadLogMessage.isWifiUpload() && !Connectivity.isConnectedWifi(context())) {
            str = "current network not allowed upload log file";
        }
        ANResponse<String> uploadLogFile = PushPlatformManager.getInstance(context()).uploadLogFile(uploadLogMessage.getControlMessage().getStatics().getTaskId(), uploadLogMessage.getControlMessage().getStatics().getDeviceId(), str, file);
        if (uploadLogFile == null || !uploadLogFile.isSuccess()) {
            DebugLogger.m4829i("AbstractMessageHandler", "upload error code " + uploadLogFile.getError() + uploadLogFile.getResult());
            return;
        }
        if (file != null) {
            file.delete();
        }
        DebugLogger.m4828e("AbstractMessageHandler", "upload success " + uploadLogFile.getResult());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean messageMatch(android.content.Intent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "AbstractMessageHandler"
            java.lang.String r1 = "start LogUploadMessageHandler match"
            com.meizu.cloud.pushinternal.DebugLogger.m4829i(r0, r1)
            java.lang.String r0 = "mz_push_control_message"
            java.lang.String r0 = r4.getStringExtra(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 != 0) goto L_0x0027
            com.meizu.cloud.pushsdk.handler.impl.model.ControlMessage r0 = com.meizu.cloud.pushsdk.handler.impl.model.ControlMessage.parse(r0)
            com.meizu.cloud.pushsdk.handler.impl.model.Control r1 = r0.getControl()
            if (r1 == 0) goto L_0x0027
            com.meizu.cloud.pushsdk.handler.impl.model.Control r0 = r0.getControl()
            int r0 = r0.getPushType()
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            java.lang.String r1 = "com.meizu.flyme.push.intent.MESSAGE"
            java.lang.String r4 = r4.getAction()
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0041
            java.lang.String r4 = "2"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0041
            r2 = 1
        L_0x0041:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.handler.impl.fileupload.LogUploadMessageHandler.messageMatch(android.content.Intent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onBeforeEvent(UploadLogMessage uploadLogMessage) {
        UxIPUtils.onReceivePushMessageEvent(context(), context().getPackageName(), uploadLogMessage.getControlMessage().getStatics().getDeviceId(), uploadLogMessage.getControlMessage().getStatics().getTaskId(), uploadLogMessage.getControlMessage().getStatics().getSeqId(), uploadLogMessage.getControlMessage().getStatics().getTime());
    }
}
