package com.jesuscuevas.app.nearalmeriaweather.ui.fragments;

import com.jesuscuevas.app.nearalmeriaweather.R;
import com.jesuscuevas.app.nearalmeriaweather.base.BaseFragment;
import com.jesuscuevas.app.nearalmeriaweather.data.ApiCallControler;
import com.jesuscuevas.app.nearalmeriaweather.ui.mvp.MainActivityView;
import com.jesuscuevas.app.nearalmeriaweather.ui.mvp.presenter.MainFragmentPresenter;
import com.jesuscuevas.app.nearalmeriaweather.ui.mvp.presenter.MainFragmentePresenterImpl;
import com.jesuscuevas.app.nearalmeriaweather.ui.mvp.views.MainFragmentView;
import com.jesuscuevas.app.nearalmeriaweather.util.Constans;

/**
 * Created by Jesús Cuevas on 19/01/2017.
 */

public class MainFragment extends BaseFragment implements MainFragmentView{

    private MainFragmentPresenter mPresenter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void init() {
        callApiServece();
    }

    @Override
    protected void getPresenter() {
        mPresenter = new MainFragmentePresenterImpl(this);
    }


    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    private void callApiServece() {
      mPresenter.getApiService();
    }
}
