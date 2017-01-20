package com.jesuscuevas.app.nearalmeriaweather.ui.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.jesuscuevas.app.nearalmeriaweather.R;
import com.jesuscuevas.app.nearalmeriaweather.adapters.CitiesWeatherAdapter;
import com.jesuscuevas.app.nearalmeriaweather.base.BaseFragment;
import com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel.CitiesWeather;
import com.jesuscuevas.app.nearalmeriaweather.ui.mvp.presenter.MainFragmentPresenter;
import com.jesuscuevas.app.nearalmeriaweather.ui.mvp.presenter.MainFragmentePresenterImpl;
import com.jesuscuevas.app.nearalmeriaweather.ui.mvp.views.MainFragmentView;
import butterknife.BindView;
import rx.Subscription;

/**
 * Created by Jesús Cuevas on 19/01/2017.
 */

public class MainFragment extends BaseFragment implements MainFragmentView {

    private MainFragmentPresenter mPresenter;
    private Subscription mSubscription;
    @BindView(R.id.my_cities_weather_list)
    RecyclerView mRecyclerView;


    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void init() {
        getObserverRx();
    }

    @Override
    protected void getPresenter() {
        mPresenter = new MainFragmentePresenterImpl(this,getContext());
    }


    @Override
    public void showRecycleView(CitiesWeather citiesWeather) {
      mPresenter.setRecycleView(mRecyclerView,citiesWeather);
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    private void getObserverRx() {
        getSubscription(mPresenter.getRxObject());
    }

    private void getSubscription(rx.Observer<CitiesWeather> observer) {
        mSubscription = mPresenter.geRxApiSubscription(observer);
    }

    //[FRAGMENT LIFE CYCLE]
    @Override
    public void onDestroy() {
        super.onDestroy();
        mSubscription.unsubscribe();
    }
}
