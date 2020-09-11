package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;
import java.util.Arrays;

public class EnumDeserializer implements ObjectDeserializer {
    private final Class<?> enumClass;
    protected long[] enumNameHashCodes = new long[this.ordinalEnums.length];
    protected final Enum[] enums;
    protected final Enum[] ordinalEnums;

    public int getFastMatchToken() {
        return 2;
    }

    public EnumDeserializer(Class<?> cls) {
        this.enumClass = cls;
        this.ordinalEnums = (Enum[]) cls.getEnumConstants();
        long[] jArr = new long[this.ordinalEnums.length];
        for (int i = 0; i < this.ordinalEnums.length; i++) {
            String name = this.ordinalEnums[i].name();
            long j = -2128831035;
            for (int i2 = 0; i2 < name.length(); i2++) {
                j = (j ^ ((long) name.charAt(i2))) * 16777619;
            }
            jArr[i] = j;
            this.enumNameHashCodes[i] = j;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.ordinalEnums.length];
        for (int i3 = 0; i3 < this.enumNameHashCodes.length; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= jArr.length) {
                    break;
                } else if (this.enumNameHashCodes[i3] == jArr[i4]) {
                    this.enums[i3] = this.ordinalEnums[i4];
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    public Enum getEnumByHashCode(long j) {
        int binarySearch;
        if (this.enums != null && (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j)) >= 0) {
            return this.enums[binarySearch];
        }
        return null;
    }

    public Enum<?> valueOf(int i) {
        return this.ordinalEnums[i];
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i = jSONLexer.token();
            if (i == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue >= 0 && intValue <= this.ordinalEnums.length) {
                    return this.ordinalEnums[intValue];
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
            } else if (i == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (stringVal.length() == 0) {
                    return null;
                }
                return Enum.valueOf(this.enumClass, stringVal);
            } else if (i == 8) {
                jSONLexer.nextToken(16);
                return null;
            } else {
                Object parse = defaultJSONParser.parse();
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + parse);
            }
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }
}
