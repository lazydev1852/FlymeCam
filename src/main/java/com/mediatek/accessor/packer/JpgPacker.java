package com.mediatek.accessor.packer;

import com.mediatek.accessor.data.Section;
import com.mediatek.accessor.util.ByteArrayInputStreamExt;
import com.mediatek.accessor.util.ByteArrayOutputStreamExt;
import com.mediatek.accessor.util.C1123Utils;
import com.mediatek.accessor.util.Log;
import com.mediatek.accessor.util.TraceHelper;
import java.io.IOException;
import java.util.ArrayList;

public class JpgPacker implements IPacker {
    private static final String TAG = Log.Tag(JpgPacker.class.getSimpleName());
    private PackInfo mPackInfo;

    public JpgPacker(PackInfo packInfo) throws NullPointerException {
        this.mPackInfo = packInfo;
        if (this.mPackInfo == null) {
            throw new NullPointerException("mPackInfo is null!");
        }
    }

    public void pack() {
        TraceHelper.beginSection(">>>>JpgPacker-pack");
        Log.m3993d(TAG, "<pack> begin");
        if (this.mPackInfo == null) {
            Log.m3993d(TAG, "<pack> mPackInfo is null!");
            TraceHelper.endSection();
        } else if (this.mPackInfo.unpackedJpgBuf == null) {
            Log.m3993d(TAG, "<pack> unpackedJpgBuf is null!");
        } else {
            Section section = null;
            ArrayList<Section> arrayList = new ArrayList<>();
            ArrayList<Section> arrayList2 = new ArrayList<>();
            if (this.mPackInfo.packedStandardXmpBuf != null) {
                section = new Section(PackUtils.APP1, 0, this.mPackInfo.packedStandardXmpBuf.length + 2);
                section.buffer = this.mPackInfo.packedStandardXmpBuf;
                section.type = PackUtils.TYPE_STANDARD_XMP;
            }
            Section section2 = section;
            if (this.mPackInfo.packedExtendedXmpBufArray != null) {
                arrayList = makeJpgSections(PackUtils.APP1, this.mPackInfo.packedExtendedXmpBufArray);
            }
            ArrayList<Section> arrayList3 = arrayList;
            if (this.mPackInfo.packedCustomizedBufArray != null) {
                arrayList2 = makeJpgSections(PackUtils.APP15, this.mPackInfo.packedCustomizedBufArray);
            }
            ByteArrayInputStreamExt byteArrayInputStreamExt = new ByteArrayInputStreamExt(this.mPackInfo.unpackedJpgBuf);
            ByteArrayOutputStreamExt byteArrayOutputStreamExt = new ByteArrayOutputStreamExt();
            pack(byteArrayInputStreamExt, byteArrayOutputStreamExt, section2, arrayList3, arrayList2);
            this.mPackInfo.packedJpgBuf = byteArrayOutputStreamExt.toByteArray();
            try {
                byteArrayInputStreamExt.close();
                byteArrayOutputStreamExt.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.m3993d(TAG, "<pack> end");
            TraceHelper.endSection();
        }
    }

    public void unpack() {
        TraceHelper.beginSection(">>>>JpgPacker-unpack");
        Log.m3993d(TAG, "<unpack> begin");
        if (this.mPackInfo == null) {
            Log.m3993d(TAG, "<unpack> mPackInfo is null!");
            TraceHelper.endSection();
        } else if (this.mPackInfo.packedJpgBuf == null) {
            Log.m3993d(TAG, "<unpack> packedJpgBuf is null!");
        } else {
            ByteArrayInputStreamExt byteArrayInputStreamExt = new ByteArrayInputStreamExt(this.mPackInfo.packedJpgBuf);
            ArrayList<Section> parseAppInfoFromStream = PackUtils.parseAppInfoFromStream(byteArrayInputStreamExt);
            byte[] bArr = null;
            ArrayList<byte[]> arrayList = new ArrayList<>();
            ArrayList<byte[]> arrayList2 = new ArrayList<>();
            int size = parseAppInfoFromStream.size();
            int i = 0;
            while (i < size) {
                try {
                    Section section = parseAppInfoFromStream.get(i);
                    if (PackUtils.TYPE_STANDARD_XMP.equals(section.type)) {
                        byteArrayInputStreamExt.seek(section.offset + 4);
                        byte[] bArr2 = new byte[(section.length - 2)];
                        try {
                            byteArrayInputStreamExt.read(bArr2);
                            bArr = bArr2;
                        } catch (IOException e) {
                            e = e;
                            bArr = bArr2;
                            e.printStackTrace();
                            this.mPackInfo.packedStandardXmpBuf = bArr;
                            this.mPackInfo.packedExtendedXmpBufArray = arrayList;
                            this.mPackInfo.packedCustomizedBufArray = arrayList2;
                            Log.m3993d(TAG, "<unpack> end");
                            TraceHelper.endSection();
                        }
                    }
                    if (PackUtils.TYPE_EXTENDED_XMP.equals(section.type)) {
                        byteArrayInputStreamExt.seek(section.offset + 4);
                        byte[] bArr3 = new byte[(section.length - 2)];
                        byteArrayInputStreamExt.read(bArr3);
                        arrayList.add(bArr3);
                    }
                    if (PackUtils.TYPE_DEPTH_DATA.equals(section.type) || PackUtils.TYPE_JPS_DATA.equals(section.type) || PackUtils.TYPE_JPS_MASK.equals(section.type) || PackUtils.TYPE_SEGMENT_MASK.equals(section.type) || PackUtils.TYPE_CLEAR_IMAGE.equals(section.type) || PackUtils.TYPE_LDC_DATA.equals(section.type) || PackUtils.TYPE_DEBUG_BUFFER.equals(section.type)) {
                        byteArrayInputStreamExt.seek(section.offset + 4);
                        byte[] bArr4 = new byte[(section.length - 2)];
                        byteArrayInputStreamExt.read(bArr4);
                        arrayList2.add(bArr4);
                    }
                    i++;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    this.mPackInfo.packedStandardXmpBuf = bArr;
                    this.mPackInfo.packedExtendedXmpBufArray = arrayList;
                    this.mPackInfo.packedCustomizedBufArray = arrayList2;
                    Log.m3993d(TAG, "<unpack> end");
                    TraceHelper.endSection();
                }
            }
            this.mPackInfo.packedStandardXmpBuf = bArr;
            this.mPackInfo.packedExtendedXmpBufArray = arrayList;
            this.mPackInfo.packedCustomizedBufArray = arrayList2;
            Log.m3993d(TAG, "<unpack> end");
            TraceHelper.endSection();
        }
    }

    private ArrayList<Section> makeJpgSections(int i, ArrayList<byte[]> arrayList) {
        Log.m3993d(TAG, "<makeJpgSections>");
        ArrayList<Section> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            byte[] bArr = arrayList.get(i2);
            if (bArr != null) {
                Section section = new Section(i, 0, bArr.length + 2);
                if (i == 65505) {
                    C1123Utils.logD(TAG, "<makeJpgSections> type is TYPE_EXTENDED_XMP");
                    section.type = PackUtils.TYPE_EXTENDED_XMP;
                } else {
                    String customTypeName = PackUtils.getCustomTypeName(bArr);
                    String str = TAG;
                    C1123Utils.logD(str, "<makeJpgSections> type is " + customTypeName);
                    section.type = customTypeName;
                }
                section.buffer = bArr;
                arrayList2.add(section);
            }
        }
        return arrayList2;
    }

    private void pack(ByteArrayInputStreamExt byteArrayInputStreamExt, ByteArrayOutputStreamExt byteArrayOutputStreamExt, Section section, ArrayList<Section> arrayList, ArrayList<Section> arrayList2) {
        boolean z;
        Log.m3993d(TAG, "<pack> write begin!!!");
        ArrayList<Section> parseAppInfoFromStream = PackUtils.parseAppInfoFromStream(byteArrayInputStreamExt);
        byteArrayOutputStreamExt.writeShort(PackUtils.SOI);
        int findProperLocationForXmp = PackUtils.findProperLocationForXmp(parseAppInfoFromStream);
        boolean z2 = this.mPackInfo.unpackedBlurImageBuf != null;
        if (findProperLocationForXmp == 0) {
            Log.m3993d(TAG, "<pack> No APP1 information!");
            writeXmp(byteArrayOutputStreamExt, section, arrayList);
            z = true;
        } else {
            z = false;
        }
        boolean z3 = z;
        boolean z4 = false;
        for (int i = 0; i < parseAppInfoFromStream.size(); i++) {
            Section section2 = parseAppInfoFromStream.get(i);
            if (PackUtils.TYPE_EXIF.equals(section2.type)) {
                String str = TAG;
                Log.m3993d(str, "<pack> write exif, " + PackUtils.getSectionTag(section2));
                PackUtils.writeSectionToStream(byteArrayInputStreamExt, byteArrayOutputStreamExt, section2);
                if (!z3) {
                    writeXmp(byteArrayOutputStreamExt, section, arrayList);
                    z3 = true;
                }
            } else {
                if (!z3) {
                    String str2 = TAG;
                    Log.m3993d(str2, "<pack> write xmp, " + PackUtils.getSectionTag(section2));
                    writeXmp(byteArrayOutputStreamExt, section, arrayList);
                    z3 = true;
                }
                if (!z4 && (section2.marker == 65499 || section2.marker == 65476)) {
                    String str3 = TAG;
                    Log.m3993d(str3, "<pack> write custom, " + PackUtils.getSectionTag(section2));
                    writeCust(byteArrayOutputStreamExt, arrayList2);
                    z4 = true;
                }
                if (z2 && section2.marker == 65499) {
                    Log.m3993d(TAG, "<pack> copy blur image to output stream");
                    String str4 = TAG;
                    Log.m3993d(str4, "<pack> write blur, " + PackUtils.getSectionTag(section2));
                    PackUtils.writeImageBuffer(new ByteArrayInputStreamExt(this.mPackInfo.unpackedBlurImageBuf), byteArrayOutputStreamExt);
                    Log.m3993d(TAG, "<pack> write end!!!");
                    return;
                } else if (PackUtils.TYPE_DEPTH_DATA.equals(section2.type) || PackUtils.TYPE_JPS_DATA.equals(section2.type) || PackUtils.TYPE_JPS_MASK.equals(section2.type) || PackUtils.TYPE_SEGMENT_MASK.equals(section2.type) || PackUtils.TYPE_STANDARD_XMP.equals(section2.type) || PackUtils.TYPE_EXTENDED_XMP.equals(section2.type) || PackUtils.TYPE_CLEAR_IMAGE.equals(section2.type) || PackUtils.TYPE_LDC_DATA.equals(section2.type) || PackUtils.TYPE_DEBUG_BUFFER.equals(section2.type)) {
                    byteArrayInputStreamExt.skip((long) (section2.length + 2));
                    String str5 = TAG;
                    C1123Utils.logD(str5, "<pack> skip old data, type: " + section2.type);
                } else {
                    String str6 = TAG;
                    C1123Utils.logD(str6, "<pack> write other info, " + PackUtils.getSectionTag(section2));
                    PackUtils.writeSectionToStream(byteArrayInputStreamExt, byteArrayOutputStreamExt, section2);
                }
            }
        }
        if (!z4) {
            writeCust(byteArrayOutputStreamExt, arrayList2);
        }
        Log.m3993d(TAG, "<pack> write remain whole file (from SOS)");
        PackUtils.copyToStreamWithFixBuffer(byteArrayInputStreamExt, byteArrayOutputStreamExt);
        Log.m3993d(TAG, "<pack> write end!!!");
    }

    private void writeCust(ByteArrayOutputStreamExt byteArrayOutputStreamExt, ArrayList<Section> arrayList) {
        int size = arrayList.size();
        String str = TAG;
        Log.m3993d(str, "<writeCust> customizedSections size " + size);
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                PackUtils.writeSectionToStream(byteArrayOutputStreamExt, arrayList.get(i));
            }
        }
    }

    private void writeXmp(ByteArrayOutputStreamExt byteArrayOutputStreamExt, Section section, ArrayList<Section> arrayList) {
        if (section != null) {
            Log.m3993d(TAG, "<writeXmp> standardxmp");
            PackUtils.writeSectionToStream(byteArrayOutputStreamExt, section);
        }
        int size = arrayList.size();
        String str = TAG;
        Log.m3993d(str, "<writeXmp> extendedSectionsSize size " + size);
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                PackUtils.writeSectionToStream(byteArrayOutputStreamExt, arrayList.get(i));
            }
        }
    }
}
