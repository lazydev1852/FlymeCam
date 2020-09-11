package com.meizu.statsapp.p081v3.utils.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.statsapp.p081v3.utils.CommonUtils;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.meizu.statsapp.v3.utils.log.EncryptLogger */
public class EncryptLogger implements ILog {
    private static final String TAG = "EncryptLogger";
    private final String FILE_NAME = "usage_logs_v2.txt";
    private final long MAX_FILE_SIZE = 10485760;
    private final String OLD_FILE_NAME = "usage_logs_v2_old.txt";
    private SimpleDateFormat mDateformat;
    private EncryptBase64 mEncryptor;
    private File mLogFile;
    private int mMyPid;
    private String mPath;

    public EncryptLogger(String str) {
        this.mPath = str;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        this.mLogFile = new File(str, "usage_logs_v2.txt");
        this.mEncryptor = new EncryptBase64("lo");
        this.mDateformat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        this.mMyPid = Process.myPid();
    }

    public void print(LogLevel logLevel, String str, String str2, long j) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mDateformat.format(new Date()));
            sb.append("\t");
            sb.append(this.mMyPid);
            sb.append("-");
            sb.append(j);
            sb.append("\t");
            sb.append(logLevel == LogLevel.DEBUG ? "D" : logLevel == LogLevel.INFO ? "I" : logLevel == LogLevel.WARN ? ExifInterface.LONGITUDE_WEST : ExifInterface.LONGITUDE_EAST);
            sb.append("/");
            sb.append(str);
            sb.append(": ");
            sb.append(str2);
            String encode = this.mEncryptor.encode(sb.toString().getBytes(Charset.forName("UTF-8")));
            if (this.mLogFile.exists() && this.mLogFile.length() + ((long) encode.getBytes().length) > 10485760) {
                String parent = this.mLogFile.getParent();
                File file = new File(parent, "usage_logs_v2_old.txt");
                if (file.exists()) {
                    file.delete();
                }
                this.mLogFile.renameTo(new File(parent, "usage_logs_v2_old.txt"));
                this.mLogFile = new File(this.mPath, "usage_logs_v2.txt");
            }
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(this.mLogFile, true);
                try {
                    fileWriter2.write(encode);
                    fileWriter2.write(SystemInfoUtil.LINE_END);
                    CommonUtils.closeQuietly(fileWriter2);
                } catch (Exception unused) {
                    fileWriter = fileWriter2;
                    CommonUtils.closeQuietly(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    CommonUtils.closeQuietly(fileWriter);
                    throw th;
                }
            } catch (Exception unused2) {
                CommonUtils.closeQuietly(fileWriter);
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.closeQuietly(fileWriter);
                throw th;
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.toString() + " - Cause: " + e.getCause());
        }
    }
}
