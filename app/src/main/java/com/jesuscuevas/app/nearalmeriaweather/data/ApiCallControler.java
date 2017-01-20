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
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jesús Cuevas on 19/01/2017.
 */

public class ApiCallControler implements Callback<CitiesWeather> {

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
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<CitiesWeather> call, Response<CitiesWeather> response) {
        if(response.isSuccessful()) {
            Log.d(Constans.DEBUG+"calling",response.raw().toString()+"->"+getClass().getName());
            Log.d(Constans.DEBUG+"success",new Gson().toJson(response)+"->"+getClass().getName());

        } else {
        }
    }

    @Override
    public void onFailure(Call<CitiesWeather> call, Throwable t) {
         Log.d(Constans.DEBUG+"error", t.getMessage());
    }
}

