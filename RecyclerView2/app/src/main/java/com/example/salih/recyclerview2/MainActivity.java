package com.example.salih.recyclerview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Product> productList = new ArrayList<Product>();
        productList.add(new Product("Family daughter", "Doughter", R.drawable.family_daughter));
        productList.add(new Product("Family father ", "Father", R.drawable.family_father));
        productList.add(new Product("Family Grandfather", "Grandfather", R.drawable.family_grandfather));
        productList.add(new Product("Family Grandmother", "Grandmother", R.drawable.family_grandmother));
        productList.add(new Product("Family Mother", "Mother", R.drawable.family_mother));
        productList.add(new Product("Family older brother", "Older brother", R.drawable.family_older_brother));
        productList.add(new Product("Family Older Sister", "Older sister", R.drawable.family_older_sister));

        recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        ProductAdapter productAdapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(productAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
