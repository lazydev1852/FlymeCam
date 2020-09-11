package org.apaches.commons.codec.digest;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apaches.commons.codec.Charsets;

public class Sha2Crypt {
    private static final int ROUNDS_DEFAULT = 5000;
    private static final int ROUNDS_MAX = 999999999;
    private static final int ROUNDS_MIN = 1000;
    private static final String ROUNDS_PREFIX = "rounds=";
    private static final Pattern SALT_PATTERN = Pattern.compile("^\\$([56])\\$(rounds=(\\d+)\\$)?([\\.\\/a-zA-Z0-9]{1,16}).*");
    private static final int SHA256_BLOCKSIZE = 32;
    static final String SHA256_PREFIX = "$5$";
    private static final int SHA512_BLOCKSIZE = 64;
    static final String SHA512_PREFIX = "$6$";

    public static String sha256Crypt(byte[] bArr) {
        return sha256Crypt(bArr, (String) null);
    }

    public static String sha256Crypt(byte[] bArr, String str) {
        if (str == null) {
            str = SHA256_PREFIX + B64.getRandomSalt(8);
        }
        return sha2Crypt(bArr, str, SHA256_PREFIX, 32, MessageDigestAlgorithms.SHA_256);
    }

    private static String sha2Crypt(byte[] bArr, String str, String str2, int i, String str3) {
        boolean z;
        int i2;
        byte b;
        byte[] bArr2 = bArr;
        String str4 = str;
        int i3 = i;
        int length = bArr2.length;
        if (str4 != null) {
            Matcher matcher = SALT_PATTERN.matcher(str4);
            if (matcher == null || !matcher.find()) {
                throw new IllegalArgumentException("Invalid salt value: " + str4);
            }
            if (matcher.group(3) != null) {
                i2 = Math.max(1000, Math.min(ROUNDS_MAX, Integer.parseInt(matcher.group(3))));
                z = true;
            } else {
                i2 = ROUNDS_DEFAULT;
                z = false;
            }
            String group = matcher.group(4);
            byte[] bytes = group.getBytes(Charsets.UTF_8);
            int length2 = bytes.length;
            MessageDigest digest = DigestUtils.getDigest(str3);
            digest.update(bArr2);
            digest.update(bytes);
            MessageDigest digest2 = DigestUtils.getDigest(str3);
            digest2.update(bArr2);
            digest2.update(bytes);
            digest2.update(bArr2);
            byte[] digest3 = digest2.digest();
            int length3 = bArr2.length;
            while (length3 > i3) {
                String str5 = str2;
                digest.update(digest3, 0, i3);
                length3 -= i3;
            }
            digest.update(digest3, 0, length3);
            for (int length4 = bArr2.length; length4 > 0; length4 >>= 1) {
                String str6 = str2;
                if ((length4 & 1) != 0) {
                    digest.update(digest3, 0, i3);
                } else {
                    digest.update(bArr2);
                }
            }
            byte[] digest4 = digest.digest();
            MessageDigest digest5 = DigestUtils.getDigest(str3);
            int i4 = 1;
            while (i4 <= length) {
                byte[] bArr3 = digest4;
                String str7 = str2;
                digest5.update(bArr2);
                i4++;
                digest4 = bArr3;
            }
            byte[] digest6 = digest5.digest();
            byte[] bArr4 = new byte[length];
            int i5 = 0;
            while (i5 < length - i3) {
                byte[] bArr5 = digest4;
                String str8 = str2;
                System.arraycopy(digest6, 0, bArr4, i5, i3);
                i5 += i3;
                digest4 = bArr5;
            }
            System.arraycopy(digest6, 0, bArr4, i5, length - i5);
            MessageDigest digest7 = DigestUtils.getDigest(str3);
            int i6 = 1;
            while (i6 <= (digest4[0] & 255) + 16) {
                byte[] bArr6 = digest4;
                String str9 = str2;
                digest7.update(bytes);
                i6++;
                digest4 = bArr6;
            }
            byte[] digest8 = digest7.digest();
            byte[] bArr7 = new byte[length2];
            int i7 = 0;
            while (i7 < length2 - i3) {
                byte[] bArr8 = digest4;
                String str10 = str2;
                System.arraycopy(digest8, 0, bArr7, i7, i3);
                i7 += i3;
                digest4 = bArr8;
            }
            System.arraycopy(digest8, 0, bArr7, i7, length2 - i7);
            byte[] bArr9 = digest4;
            int i8 = 0;
            while (i8 <= i2 - 1) {
                String str11 = str2;
                int i9 = i8;
                MessageDigest digest9 = DigestUtils.getDigest(str3);
                int i10 = i9 & 1;
                if (i10 != 0) {
                    digest9.update(bArr4, 0, length);
                } else {
                    digest9.update(bArr9, 0, i3);
                }
                if (i9 % 3 != 0) {
                    digest9.update(bArr7, 0, length2);
                }
                if (i9 % 7 != 0) {
                    digest9.update(bArr4, 0, length);
                }
                if (i10 != 0) {
                    digest9.update(bArr9, 0, i3);
                } else {
                    digest9.update(bArr4, 0, length);
                }
                bArr9 = digest9.digest();
                digest = digest9;
                i8 = i9 + 1;
            }
            StringBuilder sb = new StringBuilder(str2);
            if (z) {
                sb.append(ROUNDS_PREFIX);
                sb.append(i2);
                sb.append("$");
            }
            sb.append(group);
            sb.append("$");
            if (i3 == 32) {
                B64.b64from24bit(bArr9[0], bArr9[10], bArr9[20], 4, sb);
                B64.b64from24bit(bArr9[21], bArr9[1], bArr9[11], 4, sb);
                B64.b64from24bit(bArr9[12], bArr9[22], bArr9[2], 4, sb);
                B64.b64from24bit(bArr9[3], bArr9[13], bArr9[23], 4, sb);
                B64.b64from24bit(bArr9[24], bArr9[4], bArr9[14], 4, sb);
                B64.b64from24bit(bArr9[15], bArr9[25], bArr9[5], 4, sb);
                B64.b64from24bit(bArr9[6], bArr9[16], bArr9[26], 4, sb);
                B64.b64from24bit(bArr9[27], bArr9[7], bArr9[17], 4, sb);
                B64.b64from24bit(bArr9[18], bArr9[28], bArr9[8], 4, sb);
                B64.b64from24bit(bArr9[9], bArr9[19], bArr9[29], 4, sb);
                B64.b64from24bit((byte) 0, bArr9[31], bArr9[30], 3, sb);
                b = 0;
            } else {
                B64.b64from24bit(bArr9[0], bArr9[21], bArr9[42], 4, sb);
                B64.b64from24bit(bArr9[22], bArr9[43], bArr9[1], 4, sb);
                B64.b64from24bit(bArr9[44], bArr9[2], bArr9[23], 4, sb);
                B64.b64from24bit(bArr9[3], bArr9[24], bArr9[45], 4, sb);
                B64.b64from24bit(bArr9[25], bArr9[46], bArr9[4], 4, sb);
                B64.b64from24bit(bArr9[47], bArr9[5], bArr9[26], 4, sb);
                B64.b64from24bit(bArr9[6], bArr9[27], bArr9[48], 4, sb);
                B64.b64from24bit(bArr9[28], bArr9[49], bArr9[7], 4, sb);
                B64.b64from24bit(bArr9[50], bArr9[8], bArr9[29], 4, sb);
                B64.b64from24bit(bArr9[9], bArr9[30], bArr9[51], 4, sb);
                B64.b64from24bit(bArr9[31], bArr9[52], bArr9[10], 4, sb);
                B64.b64from24bit(bArr9[53], bArr9[11], bArr9[32], 4, sb);
                B64.b64from24bit(bArr9[12], bArr9[33], bArr9[54], 4, sb);
                B64.b64from24bit(bArr9[34], bArr9[55], bArr9[13], 4, sb);
                B64.b64from24bit(bArr9[56], bArr9[14], bArr9[35], 4, sb);
                B64.b64from24bit(bArr9[15], bArr9[36], bArr9[57], 4, sb);
                B64.b64from24bit(bArr9[37], bArr9[58], bArr9[16], 4, sb);
                B64.b64from24bit(bArr9[59], bArr9[17], bArr9[38], 4, sb);
                B64.b64from24bit(bArr9[18], bArr9[39], bArr9[60], 4, sb);
                B64.b64from24bit(bArr9[40], bArr9[61], bArr9[19], 4, sb);
                B64.b64from24bit(bArr9[62], bArr9[20], bArr9[41], 4, sb);
                b = 0;
                B64.b64from24bit((byte) 0, (byte) 0, bArr9[63], 2, sb);
            }
            Arrays.fill(digest8, b);
            Arrays.fill(bArr4, b);
            Arrays.fill(bArr7, b);
            digest.reset();
            digest7.reset();
            Arrays.fill(bArr2, b);
            Arrays.fill(bytes, b);
            return sb.toString();
        }
        throw new IllegalArgumentException("Salt must not be null");
    }

    public static String sha512Crypt(byte[] bArr) {
        return sha512Crypt(bArr, (String) null);
    }

    public static String sha512Crypt(byte[] bArr, String str) {
        if (str == null) {
            str = SHA512_PREFIX + B64.getRandomSalt(8);
        }
        return sha2Crypt(bArr, str, SHA512_PREFIX, 64, MessageDigestAlgorithms.SHA_512);
    }
}
