
package com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Main {

    @SerializedName("humidity")
    private Long mHumidity;
    @SerializedName("pressure")
    private float mPressure;
    @SerializedName("temp")
    private Double mTemp;
    @SerializedName("temp_max")
    private Double mTempMax;
    @SerializedName("temp_min")
    private Double mTempMin;

    public Long getHumidity() {
        return mHumidity;
    }

    public void setHumidity(Long humidity) {
        mHumidity = humidity;
    }

    public float getPressure() {
        return mPressure;
    }

    public void setPressure(float pressure) {
        mPressure = pressure;
    }

    public Double getTemp() {
        return mTemp;
    }

    public void setTemp(Double temp) {
        mTemp = temp;
    }

    public Double getTempMax() {
        return mTempMax;
    }

    public void setTempMax(Double temp_max) {
        mTempMax = temp_max;
    }

    public Double getTempMin() {
        return mTempMin;
    }

    public void setTempMin(Double temp_min) {
        mTempMin = temp_min;
    }

}
