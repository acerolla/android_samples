package com.atrix.crypto.socket.socket.rxwebsocket.converter;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.navin.flintstones.rxwebsocket.WebSocketConverter;

import java.io.StringReader;


/**
 * Created by Evgeniy Solovev
 * Date: 16.08.2018
 * Email: solevur@gmail.com
 */
class GsonResponseConverter<T> implements WebSocketConverter<String, T> {

    private final Gson mGson;
    private final TypeAdapter<T> mAdapter;

    GsonResponseConverter(Gson gson, TypeAdapter<T> adapter) {
        mGson = gson;
        mAdapter = adapter;
    }

    @Override
    public T convert(String value) throws Throwable {
        try (JsonReader jsonReader = mGson.newJsonReader(new StringReader(value))) {
            return mAdapter.read(jsonReader);
        }
    }
}
