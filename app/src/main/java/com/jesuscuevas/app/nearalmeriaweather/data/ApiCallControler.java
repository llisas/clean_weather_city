package com.jesuscuevas.app.nearalmeriaweather.data;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel.CitiesWeather;
import com.jesuscuevas.app.nearalmeriaweather.util.Constans;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jesús Cuevas on 19/01/2017.
 */

public class ApiCallControler {

    // Retrofit no RxAndroid used

    public void getCitiesWeather(double lat, double longt, int numberCities) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GetApiWeather getAPI = retrofit.create(GetApiWeather.class);
        Call<CitiesWeather> call = getAPI.getCitiesWather(lat, longt,
                numberCities, Constans.API_KEY,
                Constans.API_UNITS_FORMAT,
                Constans.API_LANGUAGE);
        call.enqueue(new Callback<CitiesWeather>() {
            @Override
            public void onResponse(Call<CitiesWeather> call, Response<CitiesWeather> response) {

            }

            @Override
            public void onFailure(Call<CitiesWeather> call, Throwable t) {

            }
        });
    }

    //Using  Retrofit with Rx
    public static GetApiWeather getCitiesWeatherRxClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(GetApiWeather.class);
    }

}

