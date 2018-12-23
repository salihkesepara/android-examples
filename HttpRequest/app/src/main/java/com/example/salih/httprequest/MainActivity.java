package com.example.salih.httprequest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import com.example.salih.httprequest.utilities.NetworkUtils;
import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_message = (TextView) findViewById(R.id.tv_message);

        loadWeatherData();
    }

    private void loadWeatherData() {
        new FetchWeatherTask().execute("paramsHERE!");
    }

    public class FetchWeatherTask extends AsyncTask<String, Void, String[]> {
        @Override
        protected String[] doInBackground(String... params) {
            Log.v("param", params[0]);

            URL weatherRequestUrl = NetworkUtils.buildUrl();
            String jsonWeatherResponse;

            try {
                jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

                String[] simpleJsonWeatherData = new String[1];
                simpleJsonWeatherData[0] = jsonWeatherResponse;

                return simpleJsonWeatherData;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String[] weatherData) {
            String city = "city";
            String name = "name";
            tv_message.setText(weatherData[0]);

            try {
                /* Simple JSON parse */
                JSONObject json = new JSONObject(weatherData[0]);

                if (json.has(city)) {
                    JSONObject cityObj = json.getJSONObject(city);
                    String cityName = cityObj.getString(name);
                    Log.v("CityName", cityName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            super.onPostExecute(weatherData);
        }
    }
}
