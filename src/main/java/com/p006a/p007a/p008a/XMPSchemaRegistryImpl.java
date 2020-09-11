package com.p006a.p007a.p008a;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.p020ar.util.SystemInfoUtil;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.p006a.p007a.XMPException;
import com.p006a.p007a.XMPSchemaRegistry;
import com.p006a.p007a.p010b.AliasOptions;
import com.p006a.p007a.p011c.XMPAliasInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.a.a.a.r */
public final class XMPSchemaRegistryImpl implements XMPSchemaRegistry {

    /* renamed from: a */
    private Map f93a = new HashMap();

    /* renamed from: b */
    private Map f94b = new HashMap();

    /* renamed from: c */
    private Map f95c = new HashMap();

    /* renamed from: d */
    private Pattern f96d = Pattern.compile("[/*?\\[\\]]");

    public XMPSchemaRegistryImpl() {
        try {
            m243a();
            m244b();
        } catch (XMPException unused) {
            throw new RuntimeException("The XMPSchemaRegistry cannot be initialized!");
        }
    }

    /* renamed from: a */
    public synchronized String mo7596a(String str, String str2) throws XMPException {
        ParameterAsserts.m67c(str);
        ParameterAsserts.m68d(str2);
        if (str2.charAt(str2.length() - 1) != ':') {
            str2 = str2 + ':';
        }
        if (Utils.m111e(str2.substring(0, str2.length() - 1))) {
            String str3 = (String) this.f93a.get(str);
            String str4 = (String) this.f94b.get(str2);
            if (str3 != null) {
                return str3;
            }
            if (str4 != null) {
                String str5 = str2;
                int i = 1;
                while (this.f94b.containsKey(str5)) {
                    str5 = str2.substring(0, str2.length() - 1) + "_" + i + "_:";
                    i++;
                }
                str2 = str5;
            }
            this.f94b.put(str2, str);
            this.f93a.put(str, str2);
            return str2;
        }
        throw new XMPException("The prefix is a bad XML name", 201);
    }

    /* renamed from: a */
    public synchronized String mo7595a(String str) {
        return (String) this.f93a.get(str);
    }

    /* renamed from: b */
    public synchronized String mo7598b(String str) {
        if (str != null) {
            try {
                if (!str.endsWith(SystemInfoUtil.COLON)) {
                    str = str + SystemInfoUtil.COLON;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return (String) this.f94b.get(str);
    }

    /* renamed from: a */
    private void m243a() throws XMPException {
        mo7596a("http://www.w3.org/XML/1998/namespace", "xml");
        mo7596a("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
        mo7596a("http://purl.org/dc/elements/1.1/", "dc");
        mo7596a("http://iptc.org/std/Iptc4xmpCore/1.0/xmlns/", "Iptc4xmpCore");
        mo7596a("adobe:ns:meta/", "x");
        mo7596a("http://ns.adobe.com/iX/1.0/", "iX");
        mo7596a("http://ns.adobe.com/xap/1.0/", "xmp");
        mo7596a("http://ns.adobe.com/xap/1.0/rights/", "xmpRights");
        mo7596a("http://ns.adobe.com/xap/1.0/mm/", "xmpMM");
        mo7596a("http://ns.adobe.com/xap/1.0/bj/", "xmpBJ");
        mo7596a("http://ns.adobe.com/xmp/note/", "xmpNote");
        mo7596a("http://ns.adobe.com/pdf/1.3/", "pdf");
        mo7596a("http://ns.adobe.com/pdfx/1.3/", "pdfx");
        mo7596a("http://www.npes.org/pdfx/ns/id/", "pdfxid");
        mo7596a("http://www.aiim.org/pdfa/ns/schema#", "pdfaSchema");
        mo7596a("http://www.aiim.org/pdfa/ns/property#", "pdfaProperty");
        mo7596a("http://www.aiim.org/pdfa/ns/type#", "pdfaType");
        mo7596a("http://www.aiim.org/pdfa/ns/field#", "pdfaField");
        mo7596a("http://www.aiim.org/pdfa/ns/id/", "pdfaid");
        mo7596a("http://www.aiim.org/pdfa/ns/extension/", "pdfaExtension");
        mo7596a("http://ns.adobe.com/photoshop/1.0/", "photoshop");
        mo7596a("http://ns.adobe.com/album/1.0/", "album");
        mo7596a("http://ns.adobe.com/exif/1.0/", PackUtils.TYPE_EXIF);
        mo7596a("http://ns.adobe.com/exif/1.0/aux/", "aux");
        mo7596a("http://ns.adobe.com/tiff/1.0/", "tiff");
        mo7596a("http://ns.adobe.com/png/1.0/", "png");
        mo7596a("http://ns.adobe.com/jpeg/1.0/", "jpeg");
        mo7596a("http://ns.adobe.com/jp2k/1.0/", "jp2k");
        mo7596a("http://ns.adobe.com/camera-raw-settings/1.0/", "crs");
        mo7596a("http://ns.adobe.com/StockPhoto/1.0/", "bmsp");
        mo7596a("http://ns.adobe.com/creatorAtom/1.0/", "creatorAtom");
        mo7596a("http://ns.adobe.com/asf/1.0/", "asf");
        mo7596a("http://ns.adobe.com/xmp/wav/1.0/", "wav");
        mo7596a("http://ns.adobe.com/xmp/1.0/DynamicMedia/", "xmpDM");
        mo7596a("http://ns.adobe.com/xmp/transient/1.0/", "xmpx");
        mo7596a("http://ns.adobe.com/xap/1.0/t/", "xmpT");
        mo7596a("http://ns.adobe.com/xap/1.0/t/pg/", "xmpTPg");
        mo7596a("http://ns.adobe.com/xap/1.0/g/", "xmpG");
        mo7596a("http://ns.adobe.com/xap/1.0/g/img/", "xmpGImg");
        mo7596a("http://ns.adobe.com/xap/1.0/sType/Font#", "stFNT");
        mo7596a("http://ns.adobe.com/xap/1.0/sType/Dimensions#", "stDim");
        mo7596a("http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "stEvt");
        mo7596a("http://ns.adobe.com/xap/1.0/sType/ResourceRef#", "stRef");
        mo7596a("http://ns.adobe.com/xap/1.0/sType/Version#", "stVer");
        mo7596a("http://ns.adobe.com/xap/1.0/sType/Job#", "stJob");
        mo7596a("http://ns.adobe.com/xap/1.0/sType/ManifestItem#", "stMfs");
        mo7596a("http://ns.adobe.com/xmp/Identifier/qual/1.0/", "xmpidq");
    }

    /* renamed from: c */
    public synchronized XMPAliasInfo mo7599c(String str) {
        return (XMPAliasInfo) this.f95c.get(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo7597a(String str, String str2, String str3, String str4, AliasOptions aVar) throws XMPException {
        ParameterAsserts.m67c(str);
        ParameterAsserts.m66b(str2);
        ParameterAsserts.m67c(str3);
        ParameterAsserts.m66b(str4);
        final AliasOptions aVar2 = aVar != null ? new AliasOptions(XMPNodeUtils.m219a(aVar.mo7612d(), (Object) null).mo7619f()) : new AliasOptions();
        if (this.f96d.matcher(str2).find() || this.f96d.matcher(str4).find()) {
            throw new XMPException("Alias and actual property names must be simple", 102);
        }
        String a = mo7595a(str);
        final String a2 = mo7595a(str3);
        if (a == null) {
            throw new XMPException("Alias namespace is not registered", 101);
        } else if (a2 != null) {
            String str5 = a + str2;
            if (!this.f95c.containsKey(str5)) {
                if (!this.f95c.containsKey(a2 + str4)) {
                    final String str6 = str3;
                    final String str7 = str4;
                    this.f95c.put(str5, new XMPAliasInfo() {
                        /* renamed from: a */
                        public String mo7600a() {
                            return str6;
                        }

                        /* renamed from: b */
                        public String mo7601b() {
                            return a2;
                        }

                        /* renamed from: c */
                        public String mo7602c() {
                            return str7;
                        }

                        /* renamed from: d */
                        public AliasOptions mo7603d() {
                            return aVar2;
                        }

                        public String toString() {
                            return a2 + str7 + " NS(" + str6 + "), FORM (" + mo7603d() + ")";
                        }
                    });
                } else {
                    throw new XMPException("Actual property is already an alias, use the base property", 4);
                }
            } else {
                throw new XMPException("Alias is already existing", 4);
            }
        } else {
            throw new XMPException("Actual namespace is not registered", 101);
        }
    }

    /* renamed from: b */
    private void m244b() throws XMPException {
        AliasOptions a = new AliasOptions().mo7607a(true);
        AliasOptions b = new AliasOptions().mo7609b(true);
        mo7597a("http://ns.adobe.com/xap/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", a);
        mo7597a("http://ns.adobe.com/xap/1.0/", "Authors", "http://purl.org/dc/elements/1.1/", "creator", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/xap/1.0/", "Description", "http://purl.org/dc/elements/1.1/", "description", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/xap/1.0/", "Format", "http://purl.org/dc/elements/1.1/", "format", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/xap/1.0/", "Keywords", "http://purl.org/dc/elements/1.1/", "subject", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/xap/1.0/", "Locale", "http://purl.org/dc/elements/1.1/", "language", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/xap/1.0/", "Title", "http://purl.org/dc/elements/1.1/", PushConstants.TITLE, (AliasOptions) null);
        mo7597a("http://ns.adobe.com/xap/1.0/rights/", ExifInterface.TAG_COPYRIGHT, "http://purl.org/dc/elements/1.1/", "rights", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/pdf/1.3/", "Author", "http://purl.org/dc/elements/1.1/", "creator", a);
        mo7597a("http://ns.adobe.com/pdf/1.3/", "BaseURL", "http://ns.adobe.com/xap/1.0/", "BaseURL", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/pdf/1.3/", "CreationDate", "http://ns.adobe.com/xap/1.0/", "CreateDate", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/pdf/1.3/", "Creator", "http://ns.adobe.com/xap/1.0/", "CreatorTool", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/pdf/1.3/", "ModDate", "http://ns.adobe.com/xap/1.0/", "ModifyDate", (AliasOptions) null);
        AliasOptions aVar = b;
        mo7597a("http://ns.adobe.com/pdf/1.3/", "Subject", "http://purl.org/dc/elements/1.1/", "description", aVar);
        mo7597a("http://ns.adobe.com/pdf/1.3/", "Title", "http://purl.org/dc/elements/1.1/", PushConstants.TITLE, aVar);
        mo7597a("http://ns.adobe.com/photoshop/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", a);
        mo7597a("http://ns.adobe.com/photoshop/1.0/", "Caption", "http://purl.org/dc/elements/1.1/", "description", aVar);
        mo7597a("http://ns.adobe.com/photoshop/1.0/", ExifInterface.TAG_COPYRIGHT, "http://purl.org/dc/elements/1.1/", "rights", aVar);
        mo7597a("http://ns.adobe.com/photoshop/1.0/", "Keywords", "http://purl.org/dc/elements/1.1/", "subject", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/photoshop/1.0/", "Marked", "http://ns.adobe.com/xap/1.0/rights/", "Marked", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/photoshop/1.0/", "Title", "http://purl.org/dc/elements/1.1/", PushConstants.TITLE, b);
        mo7597a("http://ns.adobe.com/photoshop/1.0/", "WebStatement", "http://ns.adobe.com/xap/1.0/rights/", "WebStatement", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/tiff/1.0/", ExifInterface.TAG_ARTIST, "http://purl.org/dc/elements/1.1/", "creator", a);
        mo7597a("http://ns.adobe.com/tiff/1.0/", ExifInterface.TAG_COPYRIGHT, "http://purl.org/dc/elements/1.1/", "rights", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/tiff/1.0/", ExifInterface.TAG_DATETIME, "http://ns.adobe.com/xap/1.0/", "ModifyDate", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/tiff/1.0/", ExifInterface.TAG_IMAGE_DESCRIPTION, "http://purl.org/dc/elements/1.1/", "description", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/tiff/1.0/", ExifInterface.TAG_SOFTWARE, "http://ns.adobe.com/xap/1.0/", "CreatorTool", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/png/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", a);
        mo7597a("http://ns.adobe.com/png/1.0/", ExifInterface.TAG_COPYRIGHT, "http://purl.org/dc/elements/1.1/", "rights", b);
        mo7597a("http://ns.adobe.com/png/1.0/", "CreationTime", "http://ns.adobe.com/xap/1.0/", "CreateDate", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/png/1.0/", "Description", "http://purl.org/dc/elements/1.1/", "description", b);
        mo7597a("http://ns.adobe.com/png/1.0/", "ModificationTime", "http://ns.adobe.com/xap/1.0/", "ModifyDate", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/png/1.0/", ExifInterface.TAG_SOFTWARE, "http://ns.adobe.com/xap/1.0/", "CreatorTool", (AliasOptions) null);
        mo7597a("http://ns.adobe.com/png/1.0/", "Title", "http://purl.org/dc/elements/1.1/", PushConstants.TITLE, b);
    }
}
