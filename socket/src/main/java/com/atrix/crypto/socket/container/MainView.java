package com.atrix.crypto.socket.container;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Evgeniy Solovev
 * Date: 16.08.2018
 * Email: solevur@gmail.com
 */
public class MainView extends RelativeLayout {

    private AppCompatButton mConnectButton;
    private AppCompatButton mDisconnectButton;
    private AppCompatButton mSendButton;

    public MainView(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        setBackgroundColor(Color.WHITE);
        setClickable(true);

        mSendButton = new AppCompatButton(getContext());
        mSendButton.setText("send");

        LayoutParams sendParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        sendParams.addRule(CENTER_IN_PARENT);
        mSendButton.setLayoutParams(sendParams);
        addView(mSendButton);

        mConnectButton = new AppCompatButton(getContext());
        mConnectButton.setText("connect");

        LayoutParams connectParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mConnectButton.setLayoutParams(connectParams);
        addView(mConnectButton);

        mDisconnectButton = new AppCompatButton(getContext());
        mDisconnectButton.setText("disconnect");

        LayoutParams disconnectParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        disconnectParams.addRule(ALIGN_PARENT_END);
        mDisconnectButton.setLayoutParams(disconnectParams);
        addView(mDisconnectButton);
    }

    public void setOnSendButtonClickListener(OnClickListener listener) {
        mSendButton.setOnClickListener(listener);
    }

    public void setOnConnectButtonClickListener(OnClickListener listener) {
        mConnectButton.setOnClickListener(listener);
    }

    public void setOnDisconnectButtonClickListener(OnClickListener listener) {
        mDisconnectButton.setOnClickListener(listener);
    }
}
