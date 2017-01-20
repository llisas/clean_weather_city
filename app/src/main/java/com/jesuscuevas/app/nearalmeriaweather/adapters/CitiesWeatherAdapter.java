package com.jesuscuevas.app.nearalmeriaweather.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jesuscuevas.app.nearalmeriaweather.R;
import com.jesuscuevas.app.nearalmeriaweather.models.citiesWeatherJsonModel.CitiesWeather;
import com.jesuscuevas.app.nearalmeriaweather.util.Constans;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesús Cuevas on 19/01/2017.
 */

public class CitiesWeatherAdapter extends
        RecyclerView.Adapter<CitiesWeatherAdapter.WeatherHolder>  {

    private CitiesWeather mCitiesData;

    public CitiesWeatherAdapter(CitiesWeather citiesWeather){
        mCitiesData = citiesWeather;
    }

    @Override
    public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather_city, parent, false);
        return new WeatherHolder(v);
    }

    @Override
    public void onBindViewHolder(WeatherHolder holder, int position) {
        holder.cityName.setText(mCitiesData
                .getList().get(position).getName());
        holder.tempMax.setText(String.valueOf(mCitiesData.getList().
                get(position).getMain().getTempMax()));
        holder.tempMin.setText(String.valueOf(mCitiesData.getList().
                get(position).getMain().getTempMin()));
        holder.description.setText(mCitiesData.getList()
                .get(position).getWeather().get(0).getDescription());
    }

    @Override
    public int getItemCount() {
        Log.d(Constans.DEBUG,""+mCitiesData.getList().size()+" "+getClass().getName());
        return mCitiesData.getList().size();
    }

    public static class WeatherHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.city_name)
        TextView cityName;
        @BindView(R.id.temperature_max)
        TextView tempMax;
        @BindView(R.id.temperatura_min)
        TextView tempMin;
        @BindView(R.id.item_weather_city_description)
        TextView description;

        public WeatherHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
