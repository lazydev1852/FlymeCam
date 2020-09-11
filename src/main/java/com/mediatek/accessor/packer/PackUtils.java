package com.mediatek.accessor.packer;

import com.mediatek.accessor.data.Section;
import com.mediatek.accessor.util.ByteArrayInputStreamExt;
import com.mediatek.accessor.util.ByteArrayOutputStreamExt;
import com.mediatek.accessor.util.C1123Utils;
import com.mediatek.accessor.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.apaches.commons.codec.digest.MessageDigestAlgorithms;

public class PackUtils {
    public static final int APP1 = 65505;
    public static final int APP15 = 65519;
    public static final int APP15_LENGTHTAG_BYTE_COUNT = 4;
    public static final int APPXTAG_PLUS_LENGTHTAG_BYTE_COUNT = 4;
    public static final String APP_SECTION_MAX_LENGTH = "0xffb2";
    private static final int BYTE_COUNT_4 = 4;
    private static final int BYTE_MASK = 255;
    public static final int CUSTOMIZED_SERIAL_NUMBER_LENGTH = 1;
    public static final int CUSTOMIZED_TOTAL_FORMAT_LENGTH = 12;
    public static final int CUSTOMIZED_TOTAL_LENGTH = 4;
    public static final int DHT = 65476;
    public static final int DQT = 65499;
    public static final String EXIF_HEADER = "Exif";
    public static final int FIXED_BUFFER_SIZE = 10240;
    private static final int HIGH_HALF_BYTE_MASK = 240;
    private static final int LOW_HALF_BYTE_MASK = 15;
    public static final int MAX_BYTE_PER_APP1 = 65458;
    public static final int MAX_LEN_FOR_REAL_XMP_DATA_PER_APP1 = (MAX_BYTE_PER_APP1 - XMP_COMMON_HEADER_LEN);
    public static final int MD5_BYTE_COUNT = 32;
    public static final int PARTITION_OFFSET_BYTE_COUNT = 4;
    private static final int SHIFT_BIT_COUNT_4 = 4;
    private static final int SHIFT_BIT_COUNT_8 = 8;
    public static final int SOI = 65496;
    public static final int SOS = 65498;
    private static final String TAG = Log.Tag(PackUtils.class.getSimpleName());
    public static final int TOTAL_LENGTH_BYTE_COUNT = 4;
    public static final int TYPE_BUFFER_COUNT = 7;
    public static final String TYPE_CLEAR_IMAGE = "CLRIMAG";
    public static final String TYPE_DEBUG_BUFFER = "DEBUGBF";
    public static final String TYPE_DEPTH_DATA = "DEPTHBF";
    public static final String TYPE_EXIF = "exif";
    public static final String TYPE_EXTENDED_XMP = "extendedXmp";
    public static final String TYPE_JPS_DATA = "JPSDATA";
    public static final String TYPE_JPS_MASK = "JPSMASK";
    public static final String TYPE_LDC_DATA = "LDCDATA";
    public static final String TYPE_SEGMENT_MASK = "SEGMASK";
    public static final String TYPE_STANDARD_XMP = "standardXmp";
    public static final String TYPE_UNKNOW_APP15 = "unknownApp15";
    public static final String TYPE_XMP_DEPTH = "XMPDEPT";
    public static final int WRITE_XMP_AFTER_FIRST_APP1 = 2;
    public static final int WRITE_XMP_AFTER_SOI = 0;
    public static final int WRITE_XMP_BEFORE_FIRST_APP1 = 1;
    public static final int XMP_COMMON_HEADER_LEN = ((((XMP_EXT_HEADER.getBytes().length + 1) + 32) + 4) + 4);
    public static final String XMP_EXT_HEADER = "http://ns.adobe.com/xmp/extension/";
    public static final String XMP_HEADER_START = "http://ns.adobe.com/xap/1.0/\u0000";
    private static final int XMP_HEADER_TAIL_BYTE = 0;

    public static ArrayList<Section> parseAppInfoFromStream(ByteArrayInputStreamExt byteArrayInputStreamExt) {
        if (byteArrayInputStreamExt == null) {
            Log.m3993d(TAG, "<parseAppInfoFromStream> input stream is null!!!");
            return new ArrayList<>();
        }
        try {
            byteArrayInputStreamExt.seek(0);
            if (byteArrayInputStreamExt.readUnsignedShort() != 65496) {
                Log.m3993d(TAG, "<parseAppInfoFromStream> error, find no SOI");
                return new ArrayList<>();
            }
            Log.m3993d(TAG, "<parseAppInfoFromStream> parse begin!!!");
            ArrayList<Section> arrayList = new ArrayList<>();
            while (true) {
                int readUnsignedShort = byteArrayInputStreamExt.readUnsignedShort();
                if (readUnsignedShort == -1 || readUnsignedShort == 65498) {
                } else {
                    int readUnsignedShort2 = byteArrayInputStreamExt.readUnsignedShort();
                    arrayList.add(new Section(readUnsignedShort, byteArrayInputStreamExt.getFilePointer() - 2, readUnsignedShort2));
                    byteArrayInputStreamExt.skip((long) (readUnsignedShort2 - 2));
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                checkAppSectionTypeInStream(byteArrayInputStreamExt, arrayList.get(i));
                String str = TAG;
                C1123Utils.logD(str, "<parseAppInfoFromStream> " + getSectionTag(arrayList.get(i)));
            }
            byteArrayInputStreamExt.seek(0);
            Log.m3993d(TAG, "<parseAppInfoFromStream> parse end!!!");
            return arrayList;
        } catch (IOException e) {
            Log.m3996e(TAG, "<parseAppInfoFromStream> IOException ", e);
            return new ArrayList<>();
        }
    }

    public static int findProperLocationForXmp(ArrayList<Section> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            Section section = arrayList.get(i);
            if (section.marker == 65505) {
                return TYPE_EXIF.equals(section.type) ? 2 : 1;
            }
        }
        return 0;
    }

    public static void writeSectionToStream(ByteArrayInputStreamExt byteArrayInputStreamExt, ByteArrayOutputStreamExt byteArrayOutputStreamExt, Section section) {
        String str = TAG;
        C1123Utils.logD(str, "<writeSectionToStream> sec.type " + section.type);
        try {
            byteArrayOutputStreamExt.writeShort(section.marker);
            byteArrayOutputStreamExt.writeShort(section.length);
            byteArrayInputStreamExt.seek(section.offset + 4);
            byte[] bArr = new byte[(section.length - 2)];
            byteArrayInputStreamExt.read(bArr, 0, bArr.length);
            byteArrayOutputStreamExt.write(bArr);
        } catch (IOException e) {
            Log.m3996e(TAG, "<writeSectionToStream> IOException", e);
        }
    }

    public static void writeSectionToStream(ByteArrayOutputStreamExt byteArrayOutputStreamExt, Section section) {
        String str = TAG;
        C1123Utils.logD(str, "<writeSectionToStream> sec.type " + section.type);
        try {
            byteArrayOutputStreamExt.writeShort(section.marker);
            byteArrayOutputStreamExt.writeShort(section.length);
            byteArrayOutputStreamExt.write(section.buffer);
        } catch (IOException e) {
            Log.m3996e(TAG, "<writeSectionToStream> IOException", e);
        }
    }

    public static void copyToStreamWithFixBuffer(ByteArrayInputStreamExt byteArrayInputStreamExt, ByteArrayOutputStreamExt byteArrayOutputStreamExt) {
        byte[] bArr = new byte[FIXED_BUFFER_SIZE];
        while (true) {
            try {
                int read = byteArrayInputStreamExt.read(bArr);
                if (read == -1) {
                    return;
                }
                if (read == 10240) {
                    byteArrayOutputStreamExt.write(bArr);
                } else {
                    byteArrayOutputStreamExt.write(bArr, 0, read);
                }
            } catch (IOException e) {
                Log.m3996e(TAG, "<copyToStreamWithFixBuffer> Exception", e);
                return;
            }
        }
    }

    public static void writeImageBuffer(ByteArrayInputStreamExt byteArrayInputStreamExt, ByteArrayOutputStreamExt byteArrayOutputStreamExt) {
        if (byteArrayInputStreamExt == null) {
            Log.m3993d(TAG, "<writeImageBuffer> input stream is null!!!");
            return;
        }
        try {
            byteArrayInputStreamExt.seek(0);
            byteArrayInputStreamExt.readUnsignedShort();
            while (true) {
                int readUnsignedShort = byteArrayInputStreamExt.readUnsignedShort();
                if (readUnsignedShort == -1 || readUnsignedShort == 65499) {
                    byteArrayInputStreamExt.seek(byteArrayInputStreamExt.getFilePointer() - 2);
                    byte[] bArr = new byte[FIXED_BUFFER_SIZE];
                } else {
                    byteArrayInputStreamExt.skip((long) (byteArrayInputStreamExt.readUnsignedShort() - 2));
                }
            }
            byteArrayInputStreamExt.seek(byteArrayInputStreamExt.getFilePointer() - 2);
            byte[] bArr2 = new byte[FIXED_BUFFER_SIZE];
            while (true) {
                int read = byteArrayInputStreamExt.read(bArr2);
                if (read == -1) {
                    return;
                }
                if (read == 10240) {
                    byteArrayOutputStreamExt.write(bArr2);
                } else {
                    byteArrayOutputStreamExt.write(bArr2, 0, read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        } catch (IndexOutOfBoundsException e3) {
            e3.printStackTrace();
        }
    }

    public static String getMd5(byte[] bArr) {
        byte[] createMd5 = createMd5(bArr);
        if (createMd5 == null || createMd5.length <= 0) {
            Log.m3993d(TAG, "<getMd5> error!!");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = createMd5.length;
        for (int i = 0; i < length; i++) {
            sb.append(Integer.toHexString((createMd5[i] & 240) >> 4));
            sb.append(Integer.toHexString(createMd5[i] & 15));
        }
        return sb.toString().toUpperCase();
    }

    public static byte[] getXmpCommonHeader(String str, int i, int i2) {
        int i3 = MAX_LEN_FOR_REAL_XMP_DATA_PER_APP1 * i2;
        byte[] bArr = new byte[XMP_COMMON_HEADER_LEN];
        System.arraycopy(XMP_EXT_HEADER.getBytes(), 0, bArr, 0, XMP_EXT_HEADER.length());
        int length = XMP_EXT_HEADER.length();
        bArr[length] = 0;
        int i4 = length + 1;
        byte[] bytes = str.getBytes();
        System.arraycopy(bytes, 0, bArr, i4, bytes.length);
        int length2 = i4 + bytes.length;
        byte[] intToByteBuffer = intToByteBuffer(i, 4);
        System.arraycopy(intToByteBuffer, 0, bArr, length2, intToByteBuffer.length);
        byte[] intToByteBuffer2 = intToByteBuffer(i3, 4);
        System.arraycopy(intToByteBuffer2, 0, bArr, length2 + intToByteBuffer.length, intToByteBuffer2.length);
        return bArr;
    }

    public static byte[] intToByteBuffer(int i, int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            bArr[i3] = (byte) (i & 255);
            i >>= 8;
        }
        return bArr;
    }

    public static int byteToInt(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i += (bArr[i2] & 255) << (((bArr.length - 1) - i2) * 8);
        }
        return i;
    }

    public static String getCustomTypeName(byte[] bArr) {
        byte[] bArr2 = new byte[7];
        System.arraycopy(bArr, 4, bArr2, 0, 7);
        return new String(bArr2);
    }

    public static String getSectionTag(Section section) {
        return "marker 0x" + Integer.toHexString(section.marker) + ", offset 0x" + Long.toHexString(section.offset) + ", length 0x" + Integer.toHexString(section.length) + ", type " + section.type;
    }

    private static void checkAppSectionTypeInStream(ByteArrayInputStreamExt byteArrayInputStreamExt, Section section) {
        if (byteArrayInputStreamExt == null || section == null) {
            Log.m3993d(TAG, "<checkAppSectionTypeInStream> input stream or section is null!!!");
            return;
        }
        try {
            if (section.marker == 65519) {
                byteArrayInputStreamExt.seek(section.offset + 4 + 4);
                byte[] bArr = new byte[7];
                byteArrayInputStreamExt.read(bArr, 0, bArr.length);
                String str = new String(bArr);
                if (!TYPE_JPS_DATA.equals(str) && !TYPE_JPS_MASK.equals(str) && !TYPE_DEPTH_DATA.equals(str) && !TYPE_SEGMENT_MASK.equals(str) && !TYPE_CLEAR_IMAGE.equals(str) && !TYPE_LDC_DATA.equals(str)) {
                    if (!TYPE_DEBUG_BUFFER.equals(str)) {
                        section.type = TYPE_UNKNOW_APP15;
                        return;
                    }
                }
                section.type = str;
            } else if (section.marker == 65505) {
                byteArrayInputStreamExt.seek(section.offset + 4);
                byte[] bArr2 = new byte[XMP_EXT_HEADER.length()];
                byteArrayInputStreamExt.read(bArr2, 0, bArr2.length);
                if (XMP_EXT_HEADER.equals(new String(bArr2))) {
                    section.type = TYPE_EXTENDED_XMP;
                } else if (XMP_HEADER_START.equals(new String(bArr2, 0, XMP_HEADER_START.length()))) {
                    section.type = TYPE_STANDARD_XMP;
                } else if (EXIF_HEADER.equals(new String(bArr2, 0, EXIF_HEADER.length()))) {
                    section.type = TYPE_EXIF;
                }
            }
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            Log.m3995e(str2, "<checkAppSectionTypeInStream> UnsupportedEncodingException" + e);
        } catch (IOException e2) {
            String str3 = TAG;
            Log.m3995e(str3, "<checkAppSectionTypeInStream> IOException" + e2);
        }
    }

    private static byte[] createMd5(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            Log.m3993d(TAG, "<createMd5> input error!!");
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            Log.m3996e(TAG, "<createMd5> NoSuchAlgorithmException ", e);
            return null;
        }
    }
}
