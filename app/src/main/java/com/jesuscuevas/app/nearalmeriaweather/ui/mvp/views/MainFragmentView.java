package com.jesuscuevas.app.nearalmeriaweather.ui.mvp.views;

import com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel.CitiesWeather;

/**
 * Created by Jesús Cuevas on 19/01/2017.
 */

public interface MainFragmentView {
    void showRecycleView(CitiesWeather citiesWeather);
    void showProgressDialog();
    void hideProgressDialog();
}
