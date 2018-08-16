package com.atrix.crypto.socket.container;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.atrix.crypto.socket.socket.rxwebsocket.RxWebSocketSample;

/**
 * Created by Evgeniy Solovev
 * Date: 15.08.2018
 * Email: solevur@gmail.com
 */
public class RxWebSocketActivity extends AppCompatActivity {

    private MainView mView;
    private RxWebSocketSample mSocket;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new MainView(this);
        setContentView(mView);
        mSocket = new RxWebSocketSample();
        setListeners();
    }

    private void setListeners() {
        mView.setOnSendButtonClickListener(v -> mSocket.sendMessage());
        mView.setOnConnectButtonClickListener(v -> mSocket.connect());
        mView.setOnDisconnectButtonClickListener(v -> mSocket.disconnect());
    }

    @Override
    protected void onStart() {
        super.onStart();
        //mSocket.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mView = null;
    }
}
