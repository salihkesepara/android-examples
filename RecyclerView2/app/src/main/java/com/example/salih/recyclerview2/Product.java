package com.example.salih.recyclerview2;

import java.util.ArrayList;

public class Product {

    /** The product name of item **/
    private String mProductName;

    /** The product description  of item **/
    private String mProductDescription;

    /** The ImageID of item **/
    private int mImageId;

    /** Product constructor with different params **/
    public Product(String productName, String productDescription, int imageId) {
        mProductName = productName;
        mProductDescription = productDescription;
        mImageId = imageId;
    }

    public String getmProductName() {
        return mProductName;
    }

    public String getmProductDescription() {
        return mProductDescription;
    }

    public int getmImageId() {
        return mImageId;
    }

}
