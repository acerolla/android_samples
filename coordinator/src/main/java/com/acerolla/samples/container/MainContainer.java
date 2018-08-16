package com.acerolla.samples.container;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.acerolla.samples.fragments.first.FirstFragment;

/**
 * Created by Evgeniy Solovev
 * Date: 09.08.2018
 * Email: solevur@gmail.com
 */
public class MainContainer extends AppCompatActivity {

    private MainView mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new MainView(this);
        setContentView(mView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction()
                .add(MainView.ID_CONTENT_FRAME, new FirstFragment())
                .commit();
    }
}
