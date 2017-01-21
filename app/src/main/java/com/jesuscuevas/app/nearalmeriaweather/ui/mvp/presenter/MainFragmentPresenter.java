package com.jesuscuevas.app.nearalmeriaweather.ui.mvp.presenter;


import android.support.v7.widget.RecyclerView;

import com.jesuscuevas.app.nearalmeriaweather.adapters.CitiesWeatherAdapter;
import com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel.CitiesWeather;

import rx.Observer;
import rx.Subscription;

public interface MainFragmentPresenter {
    void getApiService();//no rx is this call
    Observer<CitiesWeather> getRxObject();//whit rx
    Subscription geRxApiSubscription(Observer<CitiesWeather> observer);
    void setRecycleView(RecyclerView view, CitiesWeather citiesWeather);

}
