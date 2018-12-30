package com.example.salih.customlistview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdaptor extends BaseAdapter {
  List<MobileOS> mobile = new ArrayList<>();
  Context context;

  public CustomAdaptor(Context context, List<MobileOS> mobile) {
    this.context = context;
    this.mobile = mobile;
  }

  /** Listview de gösterilecek satır sayısı */
  @Override
  public int getCount() {
    return mobile.size();
  }

  /** Position ile sırası gelen eleman */
  @Override
  public Object getItem(int position) {
    return null;
  }

  /** Varsa niteleyici id bilgisi */
  @Override
  public long getItemId(int position) {
    return 0;
  }

  /** Position ile sırası gelen satır için view döndürür */
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View row = LayoutInflater.from(context).inflate(R.layout.row, null);
    TextView textView = row.findViewById(R.id.txtlogo);
    TextView txtVersion = row.findViewById(R.id.txtVersion);
    ImageView imageView = row.findViewById(R.id.logo);

    MobileOS mobileOS = mobile.get(position);
    textView.setText(mobileOS.getName());
    txtVersion.setText(mobileOS.getVersion());
    imageView.setImageResource(mobileOS.getImg());

    return row;
  }
}
