package com.acerolla.samples.fragments.first;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Evgeniy Solovev
 * Date: 09.08.2018
 * Email: solevur@gmail.com
 */
public class FirstFragment extends Fragment {

    FirstView mFirstView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mFirstView =  new FirstView(getContext());
        return mFirstView;
    }
}
