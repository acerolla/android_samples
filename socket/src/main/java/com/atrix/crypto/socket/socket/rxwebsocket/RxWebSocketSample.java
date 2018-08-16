package com.atrix.crypto.socket.socket.rxwebsocket;

import android.util.Log;

import com.atrix.crypto.socket.socket.rxwebsocket.converter.WebSocketConverterFactory;
import com.atrix.crypto.socket.socket.rxwebsocket.entity.EntityRequest;
import com.navin.flintstones.rxwebsocket.RxWebsocket;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Evgeniy Solovev
 * Date: 15.08.2018
 * Email: solevur@gmail.com
 *
 * https://android-arsenal.com/details/1/6630
 */
public class RxWebSocketSample {

    private RxWebsocket websocket;
    private CompositeDisposable mDisposables;

    public void connect() {
        mDisposables = new CompositeDisposable();
        websocket = new RxWebsocket.Builder()
                .addConverterFactory(WebSocketConverterFactory.create())
                //.build("ws://88.99.73.100:1234/ws");
                .build("wss://echo.websocket.org");

        Disposable d = websocket.connect()
                .flatMapPublisher(open -> open.client().listen())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        message -> Log.e("SOCKET[onNext()]", "GOTTEN_VALUE = " + message.data()/*message.response().code()*/),
                        throwable -> { throwable.printStackTrace(); Log.e("WTF", "WTF1");},
                        () -> {Log.e("DISCONNECT", "seems like that's invoked after disconnect... idk"); mDisposables.dispose(); mDisposables = null;}
                );
        mDisposables.add(d);
    }

    public void sendMessage() {
        Log.e("SENDING MESSAGE", "MESSAGE = {\"type\":\"subscribe\",\"symbol\":\"BTCUSD\",\"source\":1}");
        //Disposable d = websocket.send("123")
        EntityRequest entity = new EntityRequest();
        entity.type = "subscribe";
        entity.type = "BTCUSD";
        entity.source = 1;
        Disposable d = websocket.send(entity)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        message ->Log.e("GOTTEN MESSAGE", "MESSAGE = " + message.message().toString() + "[" + message.message().getClass() + "]"),
                        throwable -> {throwable.printStackTrace(); Log.e("WTF", "WTF2");});
        mDisposables.add(d);
    }

    public void disconnect() {
        Disposable d = websocket.disconnect(1000, "Disconnect")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        event -> {Log.e("DISCONNECT", "DISCONNECTING[onNext()]");},
                        throwable -> {throwable.printStackTrace(); Log.e("WTF", "WTF3");});
        mDisposables.add(d);
    }

}
