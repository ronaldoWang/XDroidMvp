package cn.droidlover.xdroidmvp.converter;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by haoxi on 2017/5/8.
 */

public class FileRequestBodyConverterFactory extends Converter.Factory {
    public static FileRequestBodyConverterFactory create() {
        return new FileRequestBodyConverterFactory();
    }

    @Override
    public Converter<File, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new FileRequestBodyConverter();
    }

    static class FileRequestBodyConverter implements Converter<File, RequestBody> {

        @Override
        public RequestBody convert(File file) throws IOException {
            return RequestBody.create(MediaType.parse("application/otcet-stream"), file);
        }
    }
}


