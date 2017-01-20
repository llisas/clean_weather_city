
package com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Sys {

    @SerializedName("country")
    private String mCountry;

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

}
