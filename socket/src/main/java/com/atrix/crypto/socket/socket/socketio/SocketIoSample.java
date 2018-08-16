package com.atrix.crypto.socket.socket.socketio;

import android.util.Log;

import java.net.URISyntaxException;

import io.socket.emitter.Emitter;
import io.socket.engineio.client.Socket;

/**
 * Created by Evgeniy Solovev
 * Date: 16.08.2018
 * Email: solevur@gmail.com
 */
public class SocketIoSample {

    private Socket mSocket;

    public void connect() {
        try {
            //mSocket = new Socket("ws://88.99.73.100:1234/ws");
            mSocket = new Socket("wss://echo.websocket.org");
            mSocket.on(Socket.EVENT_OPEN, args -> Log.e("CONNECT", "SOCKET CONNECTED"))
                    .on(Socket.EVENT_MESSAGE, args -> {
                        String data = (String) args[0];
                        Log.e("NEW MESSAGE", "GOTTEN VALUE = " + data);
                    }).on(Socket.EVENT_ERROR, args -> {
                Exception err = (Exception) args[0];
                Log.e("ERROR", "CAUSED BY " + err);
            }).on(Socket.EVENT_CLOSE, args -> Log.e("DISCONNECT", "DISCONNECTING"));
            mSocket.open();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() {
        Log.e("SENDING", "{\"type\":\"subscribe\",\"symbol\":\"BTCUSD\",\"source\":1}");
        mSocket.send("{\"type\":\"subscribe\",\"symbol\":\"BTCUSD\",\"source\":1}");
    }

    public void disconnect() {
        mSocket.close();
        mSocket = null;
        Log.e("DISCONNECT", "DISCONNECTED");
    }


}
