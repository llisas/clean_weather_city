
package com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Wind {

    @SerializedName("deg")
    private float mDeg;
    @SerializedName("speed")
    private float mSpeed;

    public float getDeg() {
        return mDeg;
    }

    public void setDeg(float deg) {
        mDeg = deg;
    }

    public float getSpeed() {
        return mSpeed;
    }

    public void setSpeed(float speed) {
        mSpeed = speed;
    }

}
