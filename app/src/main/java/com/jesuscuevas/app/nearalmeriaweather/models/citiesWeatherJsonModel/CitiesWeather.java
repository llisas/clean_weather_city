
package com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CitiesWeather {

    @SerializedName("cod")
    private String mCod;
    @SerializedName("count")
    private Long mCount;
    @SerializedName("list")
    private java.util.List<List> mList;
    @SerializedName("message")
    private String mMessage;

    public String getCod() {
        return mCod;
    }

    public void setCod(String cod) {
        mCod = cod;
    }

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public java.util.List<List> getList() {
        return mList;
    }

    public void setList(java.util.List<List> list) {
        mList = list;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

}
