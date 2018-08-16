package com.atrix.crypto.socket.socket.androidasync;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Evgeniy Solovev
 * Date: 15.08.2018
 * Email: solevur@gmail.com
 *
 * https://github.com/koush/AndroidAsync
 */
public class AndroidAsyncSample {

    /*private final WebSocketConnection mConnection = new WebSocketConnection();

    private void start() {

        final String wsuri = "ws://localhost:9000";

        try {
            mConnection.connect(wsuri, new WebSocketHandler() {

                @Override
                public void onOpen() {
                    Log.d(TAG, "Status: Connected to " + wsuri);
                    mConnection.sendTextMessage("Hello, world!");
                }

                @Override
                public void onTextMessage(String payload) {
                    Log.d(TAG, "Got echo: " + payload);
                }

                @Override
                public void onClose(int code, String reason) {
                    Log.d(TAG, "Connection lost.");
                }
            });
        } catch (WebSocketException e) {

            Log.d(TAG, e.toString());
        }
    }*/
}
