package com.example.salih.httprequest.utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public final class NetworkUtils {

    /* Class name for log messages */
    private static final String TAG = NetworkUtils.class.getSimpleName();

    /* The url of weather app */
    private static final String URL = "https://andfun-weather.udacity.com/staticweather";

    /* The format of weather app return type */
    private static final String format = "json";
    /* The units of weather app */
    private static final String units = "metric";
    /* The number of days*/
    private static final int numDays = 14;

    private static final String QUERY_PARAM = "q";
    private static final String LAT_PARAM = "lat";
    private static final String LON_PARAM = "lon";
    private static final String FORMAT_PARAM = "mode";
    private static final String UNITS_PARAM = "units";
    private static final String DAYS_PARAM = "cnt";

    /**
     * Build the URL
     * @return The URL to use to query the weather server.
     */
    public static URL buildUrl() {
        Uri buildUri = Uri.parse(URL).buildUpon()
                .appendQueryParameter(FORMAT_PARAM, format)
                .appendQueryParameter(UNITS_PARAM, units)
                .appendQueryParameter(DAYS_PARAM, String.valueOf(numDays))
                .build();

        URL url = null;

        try {
            url = new URL(buildUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }

        } finally {
            urlConnection.disconnect();
        }
    }
}
