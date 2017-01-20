package com.jesuscuevas.app.nearalmeriaweather.ui.mvp.presenter;

import com.jesuscuevas.app.nearalmeriaweather.data.ApiCallControler;
import com.jesuscuevas.app.nearalmeriaweather.ui.mvp.views.MainFragmentView;
import com.jesuscuevas.app.nearalmeriaweather.util.Constans;

/**
 * Created by Jesús Cuevas on 19/01/2017.
 */

public class MainFragmentePresenterImpl implements  MainFragmentPresenter {

    MainFragmentView mView;

    public MainFragmentePresenterImpl(MainFragmentView view){
        mView = view;
    }


    @Override
    public void getApiService() {
        ApiCallControler myApiCallControler = new ApiCallControler();
        myApiCallControler.getCitiesWeather(Constans.LAT,
                Constans.LONG,
                Constans.CITIES_NUMBER);
    }
}
