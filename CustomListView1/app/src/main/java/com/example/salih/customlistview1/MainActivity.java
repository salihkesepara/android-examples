package com.example.salih.customlistview1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  Context context = this;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ListView list = findViewById(R.id.list);

    List<MobileOS> mobile = new ArrayList<>();
    mobile.add(new MobileOS("Donut", "1.6", R.drawable.donut));
    mobile.add(new MobileOS("Eclair", "2.0-2.1", R.drawable.eclair));
    mobile.add(new MobileOS("Froyo", "2.2-2.2.3", R.drawable.froyo));
    mobile.add(new MobileOS("GingerBread", "2.3-2.3.7", R.drawable.gingerbread));
    mobile.add(new MobileOS("Honeycomb", "3.0-3.2.6", R.drawable.honeycomb));
    mobile.add(new MobileOS("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.icecream));
    mobile.add(new MobileOS("Jelly Bean", "4.1-4.3.1", R.drawable.jellybean));
    mobile.add(new MobileOS("KitKat", "4.4-4.4.4", R.drawable.kitkat));
    mobile.add(new MobileOS("Lollipop", "5.0-5.1.1", R.drawable.lollipop));
    mobile.add(new MobileOS("Marshmallow", "6.0-6.0.1", R.drawable.marshmallow));

    CustomAdaptor adaptor = new CustomAdaptor(context, mobile);
    list.setAdapter(adaptor);
  }
}
