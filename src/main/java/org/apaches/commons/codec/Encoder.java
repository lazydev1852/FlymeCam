package org.apaches.commons.codec;

public interface Encoder {
    Object encode(Object obj) throws EncoderException;
}
