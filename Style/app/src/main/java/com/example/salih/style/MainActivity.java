package com.example.salih.style;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onLoginButtonClick(View v) {
    System.out.println("onLogin");
  }

  public void onCancelButtonClick(View v) {
    System.out.println("onCancel");
  }
}
