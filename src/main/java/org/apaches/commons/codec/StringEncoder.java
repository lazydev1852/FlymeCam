package org.apaches.commons.codec;

public interface StringEncoder extends Encoder {
    String encode(String str) throws EncoderException;
}
