package com.jesuscuevas.app.nearalmeriaweather.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(),container,false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getPresenter();
        init();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract int getLayout();
    protected abstract void init();
    protected abstract void getPresenter();
}
