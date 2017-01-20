package com.jesuscuevas.app.nearalmeriaweather.models.reclycleViewItemModel;

/**
 * Created by Jesús Cuevas on 19/01/2017.
 */

public class CityWheatherModel {

    private String mCity;
    private float mTemperatureMax;
    private float mTemperatureMin;

    public CityWheatherModel(String city,float max, float min) {
        mCity = city;
        mTemperatureMax = max;
        mTemperatureMin = min;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public float getmTemperatureMax() {
        return mTemperatureMax;
    }

    public void setmTemperatureMax(float mTemperatureMax) {
        this.mTemperatureMax = mTemperatureMax;
    }

    public float getmTemperatureMin() {
        return mTemperatureMin;
    }

    public void setmTemperatureMin(float mTemperatureMin) {
        this.mTemperatureMin = mTemperatureMin;
    }
}
