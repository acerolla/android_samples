package com.atrix.crypto.socket.socket.rxwebsocket.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.navin.flintstones.rxwebsocket.WebSocketConverter;

import java.lang.reflect.Type;

/**
 * Created by Evgeniy Solovev
 * Date: 16.08.2018
 * Email: solevur@gmail.com
 */
public class WebSocketConverterFactory extends WebSocketConverter.Factory {

    public static WebSocketConverterFactory create() {
        return create(new Gson());
    }

    private static WebSocketConverterFactory create(Gson gson) {
        return new WebSocketConverterFactory(gson);
    }

    private Gson mGson;

    private WebSocketConverterFactory(Gson gson) {
        mGson = gson;
    }

    @Override
    public WebSocketConverter<String, ?> responseBodyConverter(Type type) {
        TypeAdapter<?> adapter = mGson.getAdapter(TypeToken.get(type));
        return new GsonResponseConverter<>(mGson, adapter);
    }

    @Override
    public WebSocketConverter<?, String> requestBodyConverter(Type type) {
        TypeAdapter<?> adapter = mGson.getAdapter(TypeToken.get(type));
        return new GsonRequestConverter<>(mGson, adapter);
    }
}
