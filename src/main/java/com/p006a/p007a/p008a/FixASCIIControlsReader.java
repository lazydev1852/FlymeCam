package com.p006a.p007a.p008a;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

/* renamed from: com.a.a.a.d */
public class FixASCIIControlsReader extends PushbackReader {

    /* renamed from: a */
    private int f52a = 0;

    /* renamed from: b */
    private int f53b = 0;

    /* renamed from: c */
    private int f54c = 0;

    public FixASCIIControlsReader(Reader reader) {
        super(reader, 8);
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        char[] cArr2 = new char[8];
        int i3 = i;
        boolean z = true;
        int i4 = 0;
        loop0:
        while (true) {
            int i5 = 0;
            while (z && i4 < i2) {
                z = super.read(cArr2, i5, 1) == 1;
                if (z) {
                    char a = m58a(cArr2[i5]);
                    if (this.f52a == 0) {
                        if (Utils.m105a(a)) {
                            a = ' ';
                        }
                        cArr[i3] = a;
                        i4++;
                        i3++;
                    } else if (this.f52a == 5) {
                        unread(cArr2, 0, i5 + 1);
                    } else {
                        i5++;
                    }
                } else if (i5 > 0) {
                    unread(cArr2, 0, i5);
                    this.f52a = 5;
                    z = true;
                }
            }
        }
        if (i4 > 0 || z) {
            return i4;
        }
        return -1;
    }

    /* renamed from: a */
    private char m58a(char c) {
        switch (this.f52a) {
            case 0:
                if (c == '&') {
                    this.f52a = 1;
                }
                return c;
            case 1:
                if (c == '#') {
                    this.f52a = 2;
                } else {
                    this.f52a = 5;
                }
                return c;
            case 2:
                if (c == 'x') {
                    this.f53b = 0;
                    this.f54c = 0;
                    this.f52a = 3;
                } else if ('0' > c || c > '9') {
                    this.f52a = 5;
                } else {
                    this.f53b = Character.digit(c, 10);
                    this.f54c = 1;
                    this.f52a = 4;
                }
                return c;
            case 3:
                if (('0' <= c && c <= '9') || (('a' <= c && c <= 'f') || ('A' <= c && c <= 'F'))) {
                    this.f53b = (this.f53b * 16) + Character.digit(c, 16);
                    this.f54c++;
                    if (this.f54c <= 4) {
                        this.f52a = 3;
                    } else {
                        this.f52a = 5;
                    }
                } else if (c != ';' || !Utils.m105a((char) this.f53b)) {
                    this.f52a = 5;
                } else {
                    this.f52a = 0;
                    return (char) this.f53b;
                }
                return c;
            case 4:
                if ('0' <= c && c <= '9') {
                    this.f53b = (this.f53b * 10) + Character.digit(c, 10);
                    this.f54c++;
                    if (this.f54c <= 5) {
                        this.f52a = 4;
                    } else {
                        this.f52a = 5;
                    }
                } else if (c != ';' || !Utils.m105a((char) this.f53b)) {
                    this.f52a = 5;
                } else {
                    this.f52a = 0;
                    return (char) this.f53b;
                }
                return c;
            case 5:
                this.f52a = 0;
                return c;
            default:
                return c;
        }
    }
}
