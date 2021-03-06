package com.example.android.inventoryapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.inventoryapp.data.ProductContract.ProductEntry;

/**
 * Created by Maks on 27/07/2017.
 */

public class ProductDbHelper extends SQLiteOpenHelper {
    // Log tag
    public static final String LOG_TAG = ProductDbHelper.class.getSimpleName();

    // Name of the database file
    private static final String DATABASE_NAME = "inventory.db";

    // Database version
    private static final int DATABASE_VERSION = 1;

    //Constructs a new instance of ProductDbHelper
    public ProductDbHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the products table
        String SQL_CREATE_PRODUCTS_TABLE =  "CREATE TABLE " + ProductEntry.TABLE_NAME + " ("
                + ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProductEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + ProductEntry.COLUMN_PRODUCT_PRICE + " INTEGER NOT NULL, "
                + ProductEntry.COLUMN_PRODUCT_QUANTITY + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Nothing to be done.
    }
}
