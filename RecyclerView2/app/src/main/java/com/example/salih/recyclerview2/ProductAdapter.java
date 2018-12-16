package com.example.salih.recyclerview2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.CardViewHolder> {

    private static final String TAG = ProductAdapter.class.getSimpleName();

    ArrayList<Product> mProductList;
    LayoutInflater inflater;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        inflater = LayoutInflater.from(context);
        this.mProductList = products;
    }

    /**
     * Bu method adaptör oluşturulduğunda oluşturduğumuz ViewHolder'ın başlatılması için çağrılır.
     */
    @Override
    public ProductAdapter.CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_product_card, viewGroup, false);
        CardViewHolder holder = new CardViewHolder(view);
        return holder;
    }

    /**
     * onCreateViewHolder’dan dönen verileri bağlama işlemini gerçekleştirildiği metotdur.
     */
    @Override
    public void onBindViewHolder(CardViewHolder viewHolder, int position) {
        Product selectedProduct = mProductList.get(position);
        viewHolder.setData(selectedProduct, position);
    }

    /**
     * Listemizin eleman sayısını döndüren metottur.
     */
    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    /**
     * Her bir satırımızın içinde bulunan bileşenleri tanımlama işleminin yapıldığı metottur.
     */
    class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_product_name, tv_product_description;
        ImageView iv_user, iv_trash;

        public CardViewHolder(View itemView) {
            super(itemView);
            tv_product_name = itemView.findViewById(R.id.tv_productName);
            tv_product_description = itemView.findViewById(R.id.tv_productDescription);
            iv_user = itemView.findViewById(R.id.iv_user);
            iv_trash = itemView.findViewById(R.id.iv_trash);

            iv_trash.setOnClickListener(this);
        }

        public void setData(Product selectedProduct, int position) {
            this.tv_product_name.setText(selectedProduct.getmProductName());
            this.tv_product_description.setText(selectedProduct.getmProductDescription());
            this.iv_user.setImageResource(selectedProduct.getmImageId());
        }


        @Override
        public void onClick(View v) {
            Log.v(TAG, "#: onClick");
        }
    }
}
