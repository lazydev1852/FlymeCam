package com.mediatek.accessor.parser;

public interface IParser {
    void read();

    SerializedInfo serialize();

    void write();
}
