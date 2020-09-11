package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class FastJsonpHttpMessageConverter4 extends AbstractGenericHttpMessageConverter<Object> {
    private static final byte[] JSONP_FUNCTION_PREFIX_BYTES = "/**/".getBytes(IOUtils.UTF8);
    private static final byte[] JSONP_FUNCTION_SUFFIX_BYTES = ");".getBytes(IOUtils.UTF8);
    private FastJsonConfig fastJsonConfig = new FastJsonConfig();

    /* access modifiers changed from: protected */
    public boolean supports(Class<?> cls) {
        return true;
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig2) {
        this.fastJsonConfig = fastJsonConfig2;
    }

    public FastJsonpHttpMessageConverter4() {
        super(MediaType.ALL);
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getFeatures());
    }

    /* access modifiers changed from: protected */
    public Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), (Type) cls, this.fastJsonConfig.getFeatures());
    }

    /* access modifiers changed from: protected */
    public void writeInternal(Object obj, Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        HttpHeaders headers = httpOutputMessage.getHeaders();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        headers.setContentLength((long) (writePrefix(byteArrayOutputStream, obj) + JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), obj instanceof MappingFastJsonValue ? ((MappingFastJsonValue) obj).getValue() : obj, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures()) + writeSuffix(byteArrayOutputStream, obj)));
        byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
        byteArrayOutputStream.close();
    }

    /* access modifiers changed from: protected */
    public int writePrefix(ByteArrayOutputStream byteArrayOutputStream, Object obj) throws IOException {
        String jsonpFunction = obj instanceof MappingFastJsonValue ? ((MappingFastJsonValue) obj).getJsonpFunction() : null;
        if (jsonpFunction == null) {
            return 0;
        }
        byteArrayOutputStream.write(JSONP_FUNCTION_PREFIX_BYTES);
        byte[] bytes = (jsonpFunction + "(").getBytes(IOUtils.UTF8);
        byteArrayOutputStream.write(bytes);
        return 0 + JSONP_FUNCTION_PREFIX_BYTES.length + bytes.length;
    }

    /* access modifiers changed from: protected */
    public int writeSuffix(ByteArrayOutputStream byteArrayOutputStream, Object obj) throws IOException {
        if ((obj instanceof MappingFastJsonValue ? ((MappingFastJsonValue) obj).getJsonpFunction() : null) == null) {
            return 0;
        }
        byteArrayOutputStream.write(JSONP_FUNCTION_SUFFIX_BYTES);
        return 0 + JSONP_FUNCTION_SUFFIX_BYTES.length;
    }
}
