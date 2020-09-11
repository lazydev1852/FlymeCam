package org.apaches.commons.codec.net;

import org.apaches.commons.codec.DecoderException;

/* renamed from: org.apaches.commons.codec.net.Utils */
public class C3587Utils {
    C3587Utils() {
    }

    static int digit16(byte b) throws DecoderException {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + b);
    }
}
