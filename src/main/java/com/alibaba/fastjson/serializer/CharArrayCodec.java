package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public class CharArrayCodec implements ObjectDeserializer {
    public int getFastMatchToken() {
        return 4;
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser);
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        boolean z;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            return stringVal.toCharArray();
        } else if (jSONLexer.token() == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken(16);
            return integerValue.toString().toCharArray();
        } else {
            Object parse = defaultJSONParser.parse();
            if (parse instanceof String) {
                return ((String) parse).toCharArray();
            }
            if (parse instanceof Collection) {
                Iterator it = ((Collection) parse).iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if ((next instanceof String) && ((String) next).length() != 1) {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    throw new JSONException("can not cast to char[]");
                }
            }
            if (parse == null) {
                return null;
            }
            return JSON.toJSONString(parse).toCharArray();
        }
    }
}
