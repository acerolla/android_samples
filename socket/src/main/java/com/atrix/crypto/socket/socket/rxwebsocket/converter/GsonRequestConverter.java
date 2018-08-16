package com.atrix.crypto.socket.socket.rxwebsocket.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.navin.flintstones.rxwebsocket.WebSocketConverter;

import java.nio.charset.Charset;

/**
 * Created by Evgeniy Solovev
 * Date: 16.08.2018
 * Email: solevur@gmail.com
 */
class GsonRequestConverter<T> implements WebSocketConverter<T, String> {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final Gson mGson;
    private final TypeAdapter<T> mAdapter;

    GsonRequestConverter(Gson gson, TypeAdapter<T> adapter) {
        mGson = gson;
        mAdapter = adapter;
    }


    @Override
    public String convert(T value) throws Throwable {
        return mAdapter.toJson(value);
    }
}
