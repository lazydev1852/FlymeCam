package com.p006a.p007a;

import com.p006a.p007a.p010b.PropertyOptions;
import com.p006a.p007a.p011c.XMPProperty;

/* renamed from: com.a.a.d */
public interface XMPMeta extends Cloneable {
    /* renamed from: a */
    XMPProperty mo7523a(String str, String str2, int i) throws XMPException;

    /* renamed from: a */
    XMPProperty mo7524a(String str, String str2, String str3, String str4) throws XMPException;

    /* renamed from: a */
    void mo7528a(String str, String str2, int i, String str3) throws XMPException;

    /* renamed from: a */
    void mo7530a(String str, String str2, Object obj) throws XMPException;

    /* renamed from: a */
    void mo7532a(String str, String str2, String str3, String str4, String str5) throws XMPException;

    /* renamed from: a */
    void mo7533a(String str, String str2, String str3, String str4, String str5, PropertyOptions dVar) throws XMPException;

    /* renamed from: a */
    void mo7534a(String str, String str2, boolean z) throws XMPException;

    /* renamed from: a */
    void mo7535a(String str, String str2, byte[] bArr) throws XMPException;

    /* renamed from: a */
    byte[] mo7536a(String str, String str2) throws XMPException;

    /* renamed from: b */
    String mo7538b(String str, String str2) throws XMPException;

    /* renamed from: b */
    void mo7539b(String str, String str2, int i) throws XMPException;

    Object clone();
}
