package com.jesuscuevas.app.nearalmeriaweather.ui.mvp.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jesuscuevas.app.nearalmeriaweather.adapters.CitiesWeatherAdapter;
import com.jesuscuevas.app.nearalmeriaweather.data.ApiCallControler;
import com.jesuscuevas.app.nearalmeriaweather.data.GetApiWeather;
import com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel.CitiesWeather;
import com.jesuscuevas.app.nearalmeriaweather.ui.mvp.views.MainFragmentView;
import com.jesuscuevas.app.nearalmeriaweather.util.Constans;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jesús Cuevas on 19/01/2017.
 */

public class MainFragmentePresenterImpl implements MainFragmentPresenter {

    private MainFragmentView mView;
    private Context mContext;
    private Subscription mSubscription;

    public MainFragmentePresenterImpl(MainFragmentView view, Context context){
        mView = view;
        mContext = context;
    }


    @Override
    public void getApiService() {

        ApiCallControler myApiCallControler = new ApiCallControler();
        myApiCallControler.getCitiesWeather(Constans.LAT,
                Constans.LONG,
                Constans.CITIES_NUMBER);
    }

    @Override
    public Observer<CitiesWeather> getRxObject() {
        Observer<CitiesWeather> myObserver = new Observer<CitiesWeather>() {

            @Override
            public void onCompleted() {
                mView.hideProgressDialog();
                mSubscription.unsubscribe();
            }

            @Override
            public void onError(Throwable e) {
                // Called when the observable encounters an error
                Log.d(Constans.DEBUG, ">>>> onError gets called : " + e.getMessage());
                mView.hideProgressDialog();
            }

            @Override
            public void onNext(CitiesWeather citiesWeather) {
                Log.d(Constans.DEBUG, ">>>> SUCCESS)");
                mView.showRecycleView(citiesWeather);
            }};

    return  myObserver;
    }

    @Override
    public Subscription geRxApiSubscription(Observer<CitiesWeather> observer) {

        GetApiWeather service = ApiCallControler.getCitiesWeatherRxClient();
        mSubscription = service.getCitiesWeatherRx(Constans.LAT,
                Constans.LONG,Constans.CITIES_NUMBER,Constans.API_KEY,
                Constans.API_UNITS_FORMAT,Constans.API_LANGUAGE)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return mSubscription;

    }

    @Override
    public void setRecycleView(RecyclerView mReView, CitiesWeather citiesWeather) {
        mReView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(mContext);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mReView.setLayoutManager(llm);

        CitiesWeatherAdapter adapter = new CitiesWeatherAdapter(citiesWeather);
        mReView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
