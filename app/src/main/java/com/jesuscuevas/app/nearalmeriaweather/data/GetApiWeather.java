package com.jesuscuevas.app.nearalmeriaweather.data;

import com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel.CitiesWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface GetApiWeather {
        @GET("find")
        Call<CitiesWeather> getCitiesWather(
                @Query("lat") double lat,
                @Query("lon") double log,
                @Query("cnt") int cities,
                @Query("apikey")String apiKey,
                @Query("units") String format,
                @Query("lang") String language);



        @GET("find")
        Observable<CitiesWeather> getCitiesWeatherRx(
                @Query("lat") double lat,
                @Query("lon") double log,
                @Query("cnt") int cities,
                @Query("apikey") String apiKey,
                @Query("units") String format,
                @Query("lang") String language);
    }


