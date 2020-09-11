package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

public class NumberDeserializer implements ObjectDeserializer {
    public static final NumberDeserializer instance = new NumberDeserializer();

    public int getFastMatchToken() {
        return 2;
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return Double.valueOf(Double.parseDouble(numberString));
            }
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            if (type == Short.TYPE || type == Short.class) {
                if (longValue <= 32767 && longValue >= -32768) {
                    return Short.valueOf((short) ((int) longValue));
                }
                throw new JSONException("short overflow : " + longValue);
            } else if (type == Byte.TYPE || type == Byte.class) {
                if (longValue <= 127 && longValue >= -128) {
                    return Byte.valueOf((byte) ((int) longValue));
                }
                throw new JSONException("short overflow : " + longValue);
            } else if (longValue < -2147483648L || longValue > 2147483647L) {
                return Long.valueOf(longValue);
            } else {
                return Integer.valueOf((int) longValue);
            }
        } else if (jSONLexer.token() != 3) {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            if (type == Double.TYPE || type == Double.class) {
                return TypeUtils.castToDouble(parse);
            }
            if (type == Short.TYPE || type == Short.class) {
                return TypeUtils.castToShort(parse);
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return TypeUtils.castToByte(parse);
            }
            return TypeUtils.castToBigDecimal(parse);
        } else if (type == Double.TYPE || type == Double.class) {
            String numberString2 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return Double.valueOf(Double.parseDouble(numberString2));
        } else {
            T decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            if (type == Short.TYPE || type == Short.class) {
                return Short.valueOf(decimalValue.shortValue());
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return Byte.valueOf(decimalValue.byteValue());
            }
            return decimalValue;
        }
    }
}
