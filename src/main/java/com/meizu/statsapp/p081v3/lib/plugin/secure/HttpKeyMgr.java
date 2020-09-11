package com.meizu.statsapp.p081v3.lib.plugin.secure;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.meizu.statsapp.p081v3.utils.CommonUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.secure.HttpKeyMgr */
public class HttpKeyMgr {
    private static final String TAG = "HttpKeyMgr";
    private static HttpKeyMgr instance;
    private static final Object lock = new Object();
    private final String PREFERENCE_HTTPCERT_FILE = "com.meizu.statsapp.v3.httpcert";
    private final String PREFERENCE_HTTPKEY_FILE = "com.meizu.statsapp.v3.httpkey";
    private byte[] aKey;
    private byte[] aKey64;
    private X509Certificate cert;
    private long lastResetKeysTime = 0;
    private Context mContext;
    private byte[] rKey;
    private byte[] rKey64;
    private byte[] sKey64;
    private SharedPreferences spCert;
    private SharedPreferences spKey;

    private HttpKeyMgr(Context context) {
        this.mContext = context;
        this.spKey = context.getSharedPreferences("com.meizu.statsapp.v3.httpkey", 0);
        this.spCert = context.getSharedPreferences("com.meizu.statsapp.v3.httpcert", 0);
        loadKeys();
        if (this.rKey == null || (this.rKey != null && this.rKey.length == 0)) {
            initCert(this.mContext);
            if (this.cert != null) {
                generateKeys();
                return;
            }
            this.spKey.edit().clear().apply();
            this.spCert.edit().clear().apply();
        } else if (this.aKey == null || (this.aKey != null && this.aKey.length == 0)) {
            initCert(this.mContext);
            if (this.cert != null) {
                generateAkey();
            }
        }
    }

    public static void init(Context context) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new HttpKeyMgr(context);
                }
            }
        }
    }

    public static HttpKeyMgr get() {
        if (instance != null) {
            return instance;
        }
        throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    private void initCert(Context context) {
        Logger.m17378d(TAG, "load certs from preference");
        String string = this.spCert.getString("certificates", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                loadAvailableCertWithoutVerify(new ByteArrayInputStream(string.getBytes()));
            } catch (CertificateException e) {
                sLogE("load Certificates from preference Exception, " + e.getMessage());
            } catch (NoSuchAlgorithmException e2) {
                sLogE("load Certificates from preference Exception, " + e2.getMessage());
            } catch (SignatureException e3) {
                sLogE("load Certificates from preference Exception, " + e3.getMessage());
            } catch (NoSuchProviderException e4) {
                sLogE("load Certificates from preference Exception, " + e4.getMessage());
            } catch (InvalidKeyException e5) {
                sLogE("load Certificates from preference Exception, " + e5.getMessage());
            }
        }
        if (this.cert == null) {
            try {
                Logger.m17378d(TAG, "load certs from uxipcerts.java");
                loadAvailableCertWithoutVerify(new ByteArrayInputStream(UxipCerts.raw.getBytes()));
            } catch (CertificateException e6) {
                sLogE("load Certificates from asset Exception, " + e6.getMessage());
            } catch (NoSuchAlgorithmException e7) {
                sLogE("load Certificates from asset Exception, " + e7.getMessage());
            } catch (SignatureException e8) {
                sLogE("load Certificates from asset Exception, " + e8.getMessage());
            } catch (NoSuchProviderException e9) {
                sLogE("load Certificates from asset Exception, " + e9.getMessage());
            } catch (InvalidKeyException e10) {
                sLogE("load Certificates from asset Exception, " + e10.getMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00eb, code lost:
        r0[0].checkValidity();
        r6.cert = r0[0];
        com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(TAG, "***** AVAILABLE CERTIFICATE:");
        com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(TAG, "***** --------------------");
        com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(TAG, "***** Subject DN: " + r6.cert.getSubjectDN());
        com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(TAG, "***** Signature Algorithm: " + r6.cert.getSigAlgName());
        com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(TAG, "***** Valid from: " + r6.cert.getNotBefore());
        com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(TAG, "***** Valid until: " + r6.cert.getNotAfter());
        com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(TAG, "***** Issuer: " + r6.cert.getIssuerDN());
        com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(TAG, "***** PublicKey: " + r6.cert.getPublicKey());
        r0 = java.util.Calendar.getInstance();
        r0.add(5, 30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x01c2, code lost:
        if (r0.getTime().after(r6.cert.getNotAfter()) == false) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        downloadAndInitCert();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAvailableCert(java.io.InputStream r7) throws java.security.cert.CertificateException, java.security.NoSuchProviderException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.SignatureException {
        /*
            r6 = this;
            java.lang.String r0 = "HttpKeyMgr"
            java.lang.String r1 = "loadAvailableCert"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r1)
            java.lang.String r0 = "X509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch:{ all -> 0x01d4 }
            java.util.Collection r0 = r0.generateCertificates(r7)     // Catch:{ all -> 0x01d4 }
            int r1 = r0.size()     // Catch:{ all -> 0x01d4 }
            java.security.cert.X509Certificate[] r1 = new java.security.cert.X509Certificate[r1]     // Catch:{ all -> 0x01d4 }
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch:{ all -> 0x01d4 }
            java.security.cert.X509Certificate[] r0 = (java.security.cert.X509Certificate[]) r0     // Catch:{ all -> 0x01d4 }
            r1 = 0
            r2 = 0
        L_0x001f:
            int r3 = r0.length     // Catch:{ all -> 0x01d4 }
            if (r2 >= r3) goto L_0x01d0
            java.lang.String r3 = "HttpKeyMgr"
            java.lang.String r4 = "* --------------------"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = "HttpKeyMgr"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r4.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "* Subject DN: "
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            r5 = r0[r2]     // Catch:{ all -> 0x01d4 }
            java.security.Principal r5 = r5.getSubjectDN()     // Catch:{ all -> 0x01d4 }
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = "HttpKeyMgr"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r4.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "* Signature Algorithm: "
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            r5 = r0[r2]     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = r5.getSigAlgName()     // Catch:{ all -> 0x01d4 }
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = "HttpKeyMgr"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r4.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "* Valid from: "
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            r5 = r0[r2]     // Catch:{ all -> 0x01d4 }
            java.util.Date r5 = r5.getNotBefore()     // Catch:{ all -> 0x01d4 }
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = "HttpKeyMgr"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r4.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "* Valid until: "
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            r5 = r0[r2]     // Catch:{ all -> 0x01d4 }
            java.util.Date r5 = r5.getNotAfter()     // Catch:{ all -> 0x01d4 }
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = "HttpKeyMgr"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r4.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "* Issuer: "
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            r5 = r0[r2]     // Catch:{ all -> 0x01d4 }
            java.security.Principal r5 = r5.getIssuerDN()     // Catch:{ all -> 0x01d4 }
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = "HttpKeyMgr"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r4.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "* PublicKey: "
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            r5 = r0[r2]     // Catch:{ all -> 0x01d4 }
            java.security.PublicKey r5 = r5.getPublicKey()     // Catch:{ all -> 0x01d4 }
            r4.append(r5)     // Catch:{ all -> 0x01d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ all -> 0x01d4 }
            int r3 = r2 + 1
            int r4 = r0.length     // Catch:{ all -> 0x01d4 }
            if (r3 >= r4) goto L_0x00e3
            r2 = r0[r2]     // Catch:{ all -> 0x01d4 }
            r4 = r0[r3]     // Catch:{ all -> 0x01d4 }
            java.security.PublicKey r4 = r4.getPublicKey()     // Catch:{ all -> 0x01d4 }
            r2.verify(r4)     // Catch:{ all -> 0x01d4 }
            goto L_0x01cd
        L_0x00e3:
            r2 = r0[r2]     // Catch:{ all -> 0x01d4 }
            boolean r2 = r6.verify(r2)     // Catch:{ all -> 0x01d4 }
            if (r2 == 0) goto L_0x01cd
            r2 = r0[r1]     // Catch:{ all -> 0x01d4 }
            r2.checkValidity()     // Catch:{ all -> 0x01d4 }
            r0 = r0[r1]     // Catch:{ all -> 0x01d4 }
            r6.cert = r0     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = "HttpKeyMgr"
            java.lang.String r1 = "***** AVAILABLE CERTIFICATE:"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = "HttpKeyMgr"
            java.lang.String r1 = "***** --------------------"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = "HttpKeyMgr"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r1.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = "***** Subject DN: "
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.security.cert.X509Certificate r2 = r6.cert     // Catch:{ all -> 0x01d4 }
            java.security.Principal r2 = r2.getSubjectDN()     // Catch:{ all -> 0x01d4 }
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = "HttpKeyMgr"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r1.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = "***** Signature Algorithm: "
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.security.cert.X509Certificate r2 = r6.cert     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = r2.getSigAlgName()     // Catch:{ all -> 0x01d4 }
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = "HttpKeyMgr"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r1.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = "***** Valid from: "
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.security.cert.X509Certificate r2 = r6.cert     // Catch:{ all -> 0x01d4 }
            java.util.Date r2 = r2.getNotBefore()     // Catch:{ all -> 0x01d4 }
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = "HttpKeyMgr"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r1.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = "***** Valid until: "
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.security.cert.X509Certificate r2 = r6.cert     // Catch:{ all -> 0x01d4 }
            java.util.Date r2 = r2.getNotAfter()     // Catch:{ all -> 0x01d4 }
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = "HttpKeyMgr"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r1.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = "***** Issuer: "
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.security.cert.X509Certificate r2 = r6.cert     // Catch:{ all -> 0x01d4 }
            java.security.Principal r2 = r2.getIssuerDN()     // Catch:{ all -> 0x01d4 }
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = "HttpKeyMgr"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r1.<init>()     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = "***** PublicKey: "
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.security.cert.X509Certificate r2 = r6.cert     // Catch:{ all -> 0x01d4 }
            java.security.PublicKey r2 = r2.getPublicKey()     // Catch:{ all -> 0x01d4 }
            r1.append(r2)     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r0, r1)     // Catch:{ all -> 0x01d4 }
            java.util.Calendar r0 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x01d4 }
            r1 = 5
            r2 = 30
            r0.add(r1, r2)     // Catch:{ all -> 0x01d4 }
            java.util.Date r0 = r0.getTime()     // Catch:{ all -> 0x01d4 }
            java.security.cert.X509Certificate r1 = r6.cert     // Catch:{ all -> 0x01d4 }
            java.util.Date r1 = r1.getNotAfter()     // Catch:{ all -> 0x01d4 }
            boolean r0 = r0.after(r1)     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x01d0
            r6.downloadAndInitCert()     // Catch:{ IOException -> 0x01c8 }
            goto L_0x01d0
        L_0x01c8:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x01d4 }
            goto L_0x01d0
        L_0x01cd:
            r2 = r3
            goto L_0x001f
        L_0x01d0:
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r7)
            return
        L_0x01d4:
            r0 = move-exception
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.secure.HttpKeyMgr.loadAvailableCert(java.io.InputStream):void");
    }

    private void loadAvailableCertWithoutVerify(InputStream inputStream) throws CertificateException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Logger.m17378d(TAG, "loadAvailableCertWithoutVerify");
        try {
            Collection<? extends Certificate> generateCertificates = CertificateFactory.getInstance("X509").generateCertificates(inputStream);
            this.cert = ((X509Certificate[]) generateCertificates.toArray(new X509Certificate[generateCertificates.size()]))[0];
            Logger.m17378d(TAG, "***** AVAILABLE CERTIFICATE:");
            Logger.m17378d(TAG, "***** --------------------");
            Logger.m17378d(TAG, "***** Subject DN: " + this.cert.getSubjectDN());
            Logger.m17378d(TAG, "***** Signature Algorithm: " + this.cert.getSigAlgName());
            Logger.m17378d(TAG, "***** Valid from: " + this.cert.getNotBefore());
            Logger.m17378d(TAG, "***** Valid until: " + this.cert.getNotAfter());
            Logger.m17378d(TAG, "***** Issuer: " + this.cert.getIssuerDN());
            Logger.m17378d(TAG, "***** PublicKey: " + this.cert.getPublicKey());
        } finally {
            CommonUtils.closeQuietly(inputStream);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean verify(java.security.cert.X509Certificate r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.String r3 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x0046, KeyStoreException -> 0x003e }
            javax.net.ssl.TrustManagerFactory r3 = javax.net.ssl.TrustManagerFactory.getInstance(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0046, KeyStoreException -> 0x003e }
            r4 = r0
            java.security.KeyStore r4 = (java.security.KeyStore) r4     // Catch:{ NoSuchAlgorithmException -> 0x0046, KeyStoreException -> 0x003e }
            r3.init(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0046, KeyStoreException -> 0x003e }
            javax.net.ssl.TrustManager[] r3 = r3.getTrustManagers()     // Catch:{ NoSuchAlgorithmException -> 0x0046, KeyStoreException -> 0x003e }
            int r0 = r3.length     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            if (r0 != r1) goto L_0x001f
            r0 = r3[r2]     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            boolean r0 = r0 instanceof javax.net.ssl.X509TrustManager     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            if (r0 == 0) goto L_0x001f
            goto L_0x004d
        L_0x001f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            r4.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            java.lang.String r5 = "Unexpected default trust managers:"
            r4.append(r5)     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            java.lang.String r5 = java.util.Arrays.toString(r3)     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            r4.append(r5)     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            java.lang.String r4 = r4.toString()     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            r0.<init>(r4)     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
            throw r0     // Catch:{ NoSuchAlgorithmException -> 0x003c, KeyStoreException -> 0x003a }
        L_0x003a:
            r0 = move-exception
            goto L_0x0042
        L_0x003c:
            r0 = move-exception
            goto L_0x004a
        L_0x003e:
            r3 = move-exception
            r9 = r3
            r3 = r0
            r0 = r9
        L_0x0042:
            r0.printStackTrace()
            goto L_0x004d
        L_0x0046:
            r3 = move-exception
            r9 = r3
            r3 = r0
            r0 = r9
        L_0x004a:
            r0.printStackTrace()
        L_0x004d:
            r0 = r3[r2]
            javax.net.ssl.X509TrustManager r0 = (javax.net.ssl.X509TrustManager) r0
            java.security.cert.X509Certificate[] r0 = r0.getAcceptedIssuers()
            int r3 = r0.length
            r4 = 0
        L_0x0057:
            if (r4 >= r3) goto L_0x00d1
            r5 = r0[r4]
            java.security.PublicKey r6 = r5.getPublicKey()     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            r11.verify(r6)     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            r6.<init>()     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.lang.String r7 = "S:"
            r6.append(r7)     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.security.Principal r7 = r5.getSubjectDN()     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.lang.String r7 = r7.getName()     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            r6.append(r7)     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.lang.String r7 = "\nI:"
            r6.append(r7)     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.security.Principal r5 = r5.getIssuerDN()     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.lang.String r5 = r5.getName()     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            r6.append(r5)     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.lang.String r5 = r6.toString()     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.lang.String r6 = "HttpKeyMgr"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            r7.<init>()     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.lang.String r8 = "### root CA: "
            r7.append(r8)     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            r7.append(r5)     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            java.lang.String r5 = r7.toString()     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r6, r5)     // Catch:{ CertificateException -> 0x00c6, NoSuchAlgorithmException -> 0x00bd, InvalidKeyException -> 0x00b4, NoSuchProviderException -> 0x00ab, SignatureException -> 0x00a2 }
            return r1
        L_0x00a2:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            r10.sLogE(r5)
            goto L_0x00ce
        L_0x00ab:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            r10.sLogE(r5)
            goto L_0x00ce
        L_0x00b4:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            r10.sLogE(r5)
            goto L_0x00ce
        L_0x00bd:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            r10.sLogE(r5)
            goto L_0x00ce
        L_0x00c6:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            r10.sLogE(r5)
        L_0x00ce:
            int r4 = r4 + 1
            goto L_0x0057
        L_0x00d1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.secure.HttpKeyMgr.verify(java.security.cert.X509Certificate):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void downloadAndInitCert() throws java.io.IOException {
        /*
            r7 = this;
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00d3 }
            java.lang.String r1 = "https://uxip.meizu.com/api/v3/certificate"
            r0.<init>(r1)     // Catch:{ MalformedURLException -> 0x00d3 }
            java.net.URLConnection r0 = r0.openConnection()
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0
            r1 = 1
            r0.setDoInput(r1)
            r1 = 0
            r0.setUseCaches(r1)
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch:{ ProtocolException -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r1 = move-exception
            r1.printStackTrace()
        L_0x001f:
            java.lang.String r1 = "Charset"
            java.lang.String r2 = "UTF-8"
            r0.setRequestProperty(r1, r2)     // Catch:{ Throwable -> 0x0027 }
            goto L_0x002b
        L_0x0027:
            r1 = move-exception
            r1.printStackTrace()
        L_0x002b:
            r1 = 0
            int r2 = r0.getResponseCode()     // Catch:{ IllegalStateException -> 0x00b9, all -> 0x00b4 }
            java.lang.String r3 = "HttpKeyMgr"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x00b9, all -> 0x00b4 }
            r4.<init>()     // Catch:{ IllegalStateException -> 0x00b9, all -> 0x00b4 }
            java.lang.String r5 = "code = "
            r4.append(r5)     // Catch:{ IllegalStateException -> 0x00b9, all -> 0x00b4 }
            r4.append(r2)     // Catch:{ IllegalStateException -> 0x00b9, all -> 0x00b4 }
            java.lang.String r2 = r4.toString()     // Catch:{ IllegalStateException -> 0x00b9, all -> 0x00b4 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r2)     // Catch:{ IllegalStateException -> 0x00b9, all -> 0x00b4 }
            java.io.InputStream r2 = r0.getInputStream()     // Catch:{ IllegalStateException -> 0x00b9, all -> 0x00b4 }
            if (r2 == 0) goto L_0x00ae
            java.lang.String r1 = r7.getStringByInputStream(r2)     // Catch:{ IllegalStateException -> 0x00ac }
            java.lang.String r3 = "HttpKeyMgr"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x00ac }
            r4.<init>()     // Catch:{ IllegalStateException -> 0x00ac }
            java.lang.String r5 = "body = "
            r4.append(r5)     // Catch:{ IllegalStateException -> 0x00ac }
            r4.append(r1)     // Catch:{ IllegalStateException -> 0x00ac }
            java.lang.String r4 = r4.toString()     // Catch:{ IllegalStateException -> 0x00ac }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ IllegalStateException -> 0x00ac }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a7 }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r1 = "code"
            int r1 = r3.getInt(r1)     // Catch:{ JSONException -> 0x00a7 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r1 != r4) goto L_0x00ae
            java.lang.String r1 = "value"
            org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r3 = "certificate"
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x00a7 }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ JSONException -> 0x00a7 }
            byte[] r5 = r3.getBytes()     // Catch:{ JSONException -> 0x00a7 }
            r4.<init>(r5)     // Catch:{ JSONException -> 0x00a7 }
            r7.loadAvailableCertWithoutVerify(r4)     // Catch:{ InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException -> 0x00ae }
            java.lang.String r4 = "version"
            java.lang.String r1 = r1.getString(r4)     // Catch:{ InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException -> 0x00ae }
            android.content.SharedPreferences r4 = r7.spCert     // Catch:{ InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException -> 0x00ae }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException -> 0x00ae }
            java.lang.String r5 = "certificates"
            r4.putString(r5, r3)     // Catch:{ InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException -> 0x00ae }
            java.lang.String r3 = "version"
            r4.putString(r3, r1)     // Catch:{ InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException -> 0x00ae }
            r4.apply()     // Catch:{ InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException -> 0x00ae }
            goto L_0x00ae
        L_0x00a7:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ IllegalStateException -> 0x00ac }
            goto L_0x00ae
        L_0x00ac:
            r1 = move-exception
            goto L_0x00bd
        L_0x00ae:
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r2)
            if (r0 == 0) goto L_0x00c8
            goto L_0x00c5
        L_0x00b4:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x00ca
        L_0x00b9:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L_0x00bd:
            r1.printStackTrace()     // Catch:{ all -> 0x00c9 }
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r2)
            if (r0 == 0) goto L_0x00c8
        L_0x00c5:
            r0.disconnect()
        L_0x00c8:
            return
        L_0x00c9:
            r1 = move-exception
        L_0x00ca:
            com.meizu.statsapp.p081v3.utils.CommonUtils.closeQuietly(r2)
            if (r0 == 0) goto L_0x00d2
            r0.disconnect()
        L_0x00d2:
            throw r1
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.secure.HttpKeyMgr.downloadAndInitCert():void");
    }

    private void loadKeys() {
        Logger.m17378d(TAG, "loadKeys");
        String string = this.spKey.getString("sKey64", "");
        Logger.m17378d(TAG, "saved sKey64: " + string);
        if (!TextUtils.isEmpty(string)) {
            this.sKey64 = string.getBytes();
        }
        String string2 = this.spKey.getString("aKey64", "");
        Logger.m17378d(TAG, "saved aKey64: " + string2);
        if (!TextUtils.isEmpty(string2)) {
            this.aKey64 = string2.getBytes();
            this.aKey = Base64.decode(this.aKey64, 2);
        }
        String string3 = this.spKey.getString("rKey64", "");
        Logger.m17378d(TAG, "saved rKey64: " + string3);
        if (!TextUtils.isEmpty(string3)) {
            this.rKey64 = string3.getBytes();
            this.rKey = Base64.decode(this.rKey64, 2);
        }
    }

    private void generateKeys() {
        generateRkey();
        generateAkey();
    }

    private void generateRkey() {
        this.rKey = UUID.randomUUID().toString().substring(0, 16).getBytes();
        this.rKey64 = Base64.encode(this.rKey, 2);
        Logger.m17378d(TAG, "***** rKey64: " + new String(this.rKey64));
        SharedPreferences.Editor edit = this.spKey.edit();
        edit.putString("rKey64", new String(this.rKey64));
        edit.apply();
    }

    private void generateAkey() {
        try {
            Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance2.init(1, this.cert.getPublicKey());
            this.aKey = instance2.doFinal(this.rKey);
            this.aKey64 = Base64.encode(this.aKey, 2);
            Logger.m17378d(TAG, "***** aKey64: " + new String(this.aKey64));
            SharedPreferences.Editor edit = this.spKey.edit();
            edit.putString("aKey64", new String(this.aKey64));
            edit.apply();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (InvalidKeyException e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: finally extract failed */
    private String getStringByInputStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    CommonUtils.closeQuietly(byteArrayOutputStream);
                    return byteArrayOutputStream2;
                }
            } catch (IOException unused) {
                CommonUtils.closeQuietly(byteArrayOutputStream);
                return null;
            } catch (Throwable th) {
                CommonUtils.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public byte[] encrypt(byte[] bArr) {
        if (this.rKey == null || (this.rKey != null && this.rKey.length == 0)) {
            sLogE("rKey null!");
            return null;
        } else if (bArr == null || (bArr != null && bArr.length == 0)) {
            sLogE("input null!");
            return null;
        } else {
            Logger.m17378d(TAG, ">>>>>>>>>> encrypt input >>>>>>>>>>\n" + getBase64(bArr));
            Logger.m17378d(TAG, "<<<<<<<<<< encrypt input <<<<<<<<<<");
            try {
                Cipher instance2 = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance2.init(1, new SecretKeySpec(this.rKey, "AES"));
                byte[] doFinal = instance2.doFinal(bArr);
                Logger.m17378d(TAG, ">>>>>>>>>> encrypt output >>>>>>>>>>\n" + getBase64(doFinal));
                Logger.m17378d(TAG, "<<<<<<<<<< encrypt output <<<<<<<<<<");
                return doFinal;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
                return null;
            } catch (BadPaddingException e4) {
                e4.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e5) {
                e5.printStackTrace();
                return null;
            }
        }
    }

    public byte[] decrypt(byte[] bArr) {
        if (this.rKey == null || (this.rKey != null && this.rKey.length == 0)) {
            sLogE("rKey null!");
            return null;
        } else if (bArr == null || (bArr != null && bArr.length == 0)) {
            sLogE("input null!");
            return null;
        } else {
            Logger.m17378d(TAG, ">>>>>>>>>> decrypt input >>>>>>>>>>\n" + getBase64(bArr));
            Logger.m17378d(TAG, "<<<<<<<<<< decrypt input <<<<<<<<<<");
            try {
                Cipher instance2 = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance2.init(2, new SecretKeySpec(this.rKey, "AES"));
                byte[] doFinal = instance2.doFinal(bArr);
                Logger.m17378d(TAG, ">>>>>>>>>> decrypt output >>>>>>>>>>\n" + getBase64(doFinal));
                Logger.m17378d(TAG, "<<<<<<<<<< decrypt output <<<<<<<<<<");
                return doFinal;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
                return null;
            } catch (BadPaddingException e4) {
                e4.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e5) {
                e5.printStackTrace();
                return null;
            }
        }
    }

    private String getBase64(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : new String(Base64.encode(bArr, 0));
    }

    public void saveSKey(String str) {
        this.sKey64 = str.getBytes();
        SharedPreferences.Editor edit = this.spKey.edit();
        edit.putString("sKey64", new String(this.sKey64));
        edit.apply();
    }

    public synchronized void reInitKeys() {
        Logger.m17378d(TAG, "reInitKeys");
        if (this.lastResetKeysTime == 0 || System.currentTimeMillis() - this.lastResetKeysTime > 180000) {
            SharedPreferences.Editor edit = this.spKey.edit();
            edit.clear();
            edit.apply();
            this.lastResetKeysTime = System.currentTimeMillis();
            if (this.cert != null) {
                generateKeys();
            }
        }
    }

    public byte[] getaKey64() {
        return this.aKey64;
    }

    public byte[] getsKey64() {
        return this.sKey64;
    }

    private void sLogE(String str) {
        Logger.m17379e(TAG, str);
    }
}
