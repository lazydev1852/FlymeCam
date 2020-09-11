package com.meizu.media.mzfunnysnapsdk.AssetsZip;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.meizu.media.mzfunnysnapsdk.AnimationNew.AnimationPart;
import com.meizu.media.mzfunnysnapsdk.AnimationNew.JSONParser;
import com.meizu.media.mzfunnysnapsdk.AnimationNew.SpriteJSON;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class UnZipClass {
    public static ChangeQuickRedirect changeQuickRedirect;
    public Bitmap[] bitmap;
    private BitmapPart[] bitmapParts;
    private JSONParser jsonStream;

    public UnZipClass() {
        if (this.jsonStream != null) {
            this.jsonStream = null;
        }
        if (this.bitmap != null) {
            this.bitmap = null;
        }
        if (this.bitmapParts != null) {
            this.bitmapParts = null;
        }
        this.jsonStream = new JSONParser();
    }

    public BitmapPart[] getBitmapParts() {
        return this.bitmapParts;
    }

    public BitmapPart getBitmapPart(int i) {
        if (this.bitmapParts == null || this.bitmapParts.length <= i) {
            return null;
        }
        return this.bitmapParts[i];
    }

    public BitmapPart getBitmapPart(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9053, new Class[]{String.class}, BitmapPart.class);
        if (proxy.isSupported) {
            return (BitmapPart) proxy.result;
        }
        if (this.bitmapParts == null) {
            return null;
        }
        for (int i = 0; i < this.bitmapParts.length; i++) {
            if (this.bitmapParts[i].part_name.equals(str)) {
                return this.bitmapParts[i];
            }
        }
        return null;
    }

    public JSONParser getJson() {
        return this.jsonStream;
    }

    public boolean readZipFile(String str) throws Exception {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9054, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            readZipFileJson(str);
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("FunnySnapFlow", "JSON Time : " + (currentTimeMillis2 - currentTimeMillis));
            Log.d("FunnySnapFlow", "jsonStream: " + this.jsonStream);
            if (this.jsonStream == null) {
                Log.d("FunnySnapFlow", "jsonStream: null return");
                return false;
            }
            String jsonVersion = this.jsonStream.getJsonVersion();
            Log.d("FunnySnapFlow", "jsonStream: getJsonVersion:" + jsonVersion);
            if (this.jsonStream.getJsonVersion() == null) {
                Log.d("FunnySnapFlow", "jsonStream: getJsonVersion null return");
                return false;
            }
            if (this.jsonStream.getJsonVersion().equals("1.1")) {
                readZipFilePng(str);
                long currentTimeMillis3 = System.currentTimeMillis();
                Log.d("FunnySnapFlow", "version = 1.1 Time : " + str + " = " + (currentTimeMillis3 - currentTimeMillis));
            } else if (this.jsonStream.getJsonVersion().equals("1.2")) {
                readZipFileIDXDat(str);
                long currentTimeMillis4 = System.currentTimeMillis();
                Log.d("FunnySnapFlow", "version = 1.2 Time : " + str + " = " + (currentTimeMillis4 - currentTimeMillis));
            }
            return true;
        } catch (Exception e) {
            Log.e("FunnySnapFlow", "===readZipFile===" + e.getMessage());
            return false;
        }
    }

    private void readZipFileJson(String str) throws Exception {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9055, new Class[]{String.class}, Void.TYPE).isSupported) {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                String name = zipEntry.getName();
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                if (zipEntry.isDirectory() || zipEntry.getSize() <= 0 || !name.endsWith(".json")) {
                    inputStream.close();
                } else {
                    this.jsonStream.loadJSONStream(inputStream);
                    SpriteJSON jsonInfo = this.jsonStream.getJsonInfo();
                    if (this.bitmapParts != null) {
                        for (int i = 0; i < this.bitmapParts.length; i++) {
                            this.bitmapParts[i].part_array.clear();
                            if (this.bitmapParts[i] != null) {
                                this.bitmapParts[i] = null;
                            }
                        }
                        this.bitmapParts = null;
                    }
                    this.bitmapParts = new BitmapPart[jsonInfo.parts_num];
                    for (int i2 = 0; i2 < jsonInfo.parts_num; i2++) {
                        AnimationPart animationPart = jsonInfo.parts_array.get(i2);
                        this.bitmapParts[i2] = new BitmapPart();
                        this.bitmapParts[i2].part_name = animationPart.f15596id;
                        this.bitmapParts[i2].part_num = animationPart.frameCount;
                        this.bitmapParts[i2].part_array = new ArrayList<>();
                    }
                    return;
                }
            }
        }
    }

    private void readZipFilePng(String str) throws Exception {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9056, new Class[]{String.class}, Void.TYPE).isSupported) {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                zipEntry.getName();
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                String name = zipEntry.getName();
                if (zipEntry.isDirectory()) {
                    String substring = name.substring(0, name.length() - 1);
                    substring.substring(substring.lastIndexOf("/") + 1);
                } else if (zipEntry.getSize() > 0 && name.endsWith(".png")) {
                    String substring2 = name.substring(0, name.lastIndexOf("/"));
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    SpriteJSON jsonInfo = this.jsonStream.getJsonInfo();
                    for (int i = 0; i < jsonInfo.parts_num; i++) {
                        if (substring2.equals(this.bitmapParts[i].part_name)) {
                            this.bitmapParts[i].part_array.add(decodeStream);
                        }
                    }
                }
                inputStream.close();
            }
        }
    }

    private void readZipFileIDXDat(String str) throws Exception {
        String name;
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 9057, new Class[]{String.class}, Void.TYPE).isSupported) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
            Vector<BitmapFileDescription> vector = new Vector<>();
            ByteBuffer byteBuffer = null;
            String str2 = null;
            while (true) {
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        name = nextEntry.getName();
                        if (nextEntry.isDirectory()) {
                            break;
                        } else if (nextEntry.getSize() > 0) {
                            if (name.endsWith(".json")) {
                                z = false;
                                z2 = false;
                            }
                            if (name.endsWith(".dat")) {
                                ByteArrayOutputStream cloneInputStream = StickerFileUtils.cloneInputStream(zipInputStream);
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cloneInputStream.toByteArray());
                                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(cloneInputStream.size());
                                byte[] bArr = new byte[512];
                                while (true) {
                                    try {
                                        int read = byteArrayInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        allocateDirect.put(bArr, 0, read);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                byteBuffer = allocateDirect;
                                z2 = true;
                            }
                            if (name.endsWith(".idx")) {
                                vector = StickerFileUtils.getBitmapFileDescription(StickerFileUtils.getStringFromStream(new ByteArrayInputStream(StickerFileUtils.cloneInputStream(zipInputStream).toByteArray())));
                                z = true;
                            }
                            if (z && z2) {
                                int size = vector.size();
                                for (int i = 0; i < size; i++) {
                                    BitmapFileDescription bitmapFileDescription = vector.get(i);
                                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteBuffer.array(), bitmapFileDescription.startPos, bitmapFileDescription.endPos);
                                    SpriteJSON jsonInfo = this.jsonStream.getJsonInfo();
                                    for (int i2 = 0; i2 < jsonInfo.parts_num; i2++) {
                                        if (str2.equals(this.bitmapParts[i2].part_name)) {
                                            this.bitmapParts[i2].part_array.add(decodeByteArray);
                                        }
                                    }
                                }
                                byteBuffer.clear();
                            }
                        }
                    } else {
                        bufferedInputStream.close();
                        zipInputStream.close();
                        return;
                    }
                }
                String substring = name.substring(0, name.length() - 1);
                str2 = substring.substring(substring.lastIndexOf("/") + 1);
            }
        }
    }
}
