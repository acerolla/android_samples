package com.atrix.crypto.socket.container;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.atrix.crypto.socket.socket.socketio.SocketIoSample;

/**
 * Created by Evgeniy Solovev
 * Date: 16.08.2018
 * Email: solevur@gmail.com
 */
public class SocketIoActivity extends AppCompatActivity {

    private MainView mView;
    private SocketIoSample mSocket;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new MainView(this);
        setContentView(mView);
        mSocket = new SocketIoSample();
        setListeners();
    }

    private void setListeners() {
        mView.setOnSendButtonClickListener(v -> mSocket.sendMessage());
        mView.setOnConnectButtonClickListener(v -> mSocket.connect());
        mView.setOnDisconnectButtonClickListener(v -> mSocket.disconnect());
    }

}
