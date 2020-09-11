package com.meizu.media.mzfunnysnapsdk.AssetsZip;

import com.baidu.p020ar.util.SystemInfoUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.Constants;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class StickerFileUtils {
    public static ChangeQuickRedirect changeQuickRedirect;

    public static String getStringFromStream(InputStream inputStream) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{inputStream}, (Object) null, changeQuickRedirect, true, 9050, new Class[]{InputStream.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append("\n");
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ByteArrayOutputStream cloneInputStream(InputStream inputStream) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{inputStream}, (Object) null, changeQuickRedirect, true, 9051, new Class[]{InputStream.class}, ByteArrayOutputStream.class);
        if (proxy.isSupported) {
            return (ByteArrayOutputStream) proxy.result;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Vector<BitmapFileDescription> getBitmapFileDescription(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, changeQuickRedirect, true, 9052, new Class[]{String.class}, Vector.class);
        if (proxy.isSupported) {
            return (Vector) proxy.result;
        }
        Vector<BitmapFileDescription> vector = new Vector<>();
        String[] split = str.split(Constants.PACKNAME_END);
        for (String split2 : split) {
            String[] split3 = split2.split(SystemInfoUtil.COLON);
            if (split3.length == 3) {
                vector.add(new BitmapFileDescription(split3[0], Integer.parseInt(split3[1]), Integer.parseInt(split3[2])));
            }
        }
        return vector;
    }
}
