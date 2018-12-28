package com.example.salih.menu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
  Context context = this;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    JSONObject obj = createFullJSON();

    Log.d("objectPrinc", obj.toString());

    try {
      JSONObject temp = obj.getJSONObject("temp");
      Toast.makeText(context, temp.getString("min"), Toast.LENGTH_SHORT).show();
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /**
   * Create full json object
   * @return JSONObejct
   */
  JSONObject createFullJSON() {
    JSONObject obj = new JSONObject();
    try {
      obj.put("temp", createTempObject());
      obj.put("weather", createWeatherObject());
      obj.put("pressure", "1023.51");
      obj.put("humidity", "87");
    } catch(JSONException e) {
      e.printStackTrace();
    }

    return obj;
  }

  /**
   * Create a temp object
   * @return JSONObject
   */
  JSONObject createTempObject() {
    JSONObject temp = new JSONObject();
    try {
      temp.put("min", "11.34");
      temp.put("max", "19.01");
    } catch (JSONException e) {
      e.printStackTrace();
    }

    return temp;
  }

  /**
   * Create a weather object
   * @return JSONObject
   */
  JSONObject createWeatherObject() {
    JSONObject weather = new JSONObject();
    try {
      weather.put("id", "801");
      weather.put("condition", "Clouds");
      weather.put("description", "few clouds");
    } catch (JSONException e) {
      e.printStackTrace();
    }

    return weather;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int menuItemWasSelected = item.getItemId();
    if (menuItemWasSelected == R.id.action_search) {
      Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
    }

    return super.onOptionsItemSelected(item);
  }
}
