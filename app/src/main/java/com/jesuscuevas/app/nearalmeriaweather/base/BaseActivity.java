package com.jesuscuevas.app.nearalmeriaweather.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        getPresenter();
        init();
    }


    protected abstract int getLayout();
    protected abstract void init();
    protected abstract void getPresenter();

}
