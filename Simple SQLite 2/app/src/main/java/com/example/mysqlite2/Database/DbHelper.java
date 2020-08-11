package com.example.mysqlite2.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mysqlite2.Models.CategoryModel;

import java.util.ArrayList;


public class DbHelper extends SQLiteOpenHelper {


    public DbHelper(Context context) {
        super(context, Contants.DB_NAME, null, Contants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Contants.CREATE_TABLE_C); // Category table
        db.execSQL(Contants.CREATE_TABLE_P); // Post table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contants.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Contants.TABLE_NAME1);
        onCreate(db);
    }

    // add category
    public long addCategory(String cat_title) {

        SQLiteDatabase cat_db = this.getWritableDatabase();

        ContentValues cat_values = new ContentValues();

        cat_values.put(Contants.CAT_TITLE, cat_title);

        long cat_id = cat_db.insert(Contants.TABLE_NAME1, null, cat_values);

        cat_db.close();

        return cat_id;

    }

    // update category
    public void updateCategory(String cat_id, String cat_title) {

        SQLiteDatabase cat_db = this.getWritableDatabase();

        ContentValues cat_values = new ContentValues();
        cat_values.put(Contants.CAT_TITLE, cat_title);

        cat_db.update(Contants.TABLE_NAME1, cat_values, Contants.CAT_ID + " =?", new String[]{cat_id});

        cat_db.close();

    }

    // delete category
    public void deleteCategory(String cat_id) {
        SQLiteDatabase cat_db = getWritableDatabase();
        cat_db.delete(Contants.TABLE_NAME1, Contants.CAT_ID + " =?", new String[]{cat_id});
        cat_db.close();
    }

    // delete all category
    public void deleteAllCategory() {
        SQLiteDatabase cat_db = getWritableDatabase();
        cat_db.execSQL("DELETE FROM " + Contants.TABLE_NAME1);
        cat_db.close();
    }

    // categories count
    public int getCategoryCount() {
        String catCountQuery = "SELECT * FROM " + Contants.TABLE_NAME1;
        SQLiteDatabase cat_db = this.getReadableDatabase();
        Cursor cat_cursor = cat_db.rawQuery(catCountQuery, null);

        int cat_count = cat_cursor.getCount();

        cat_cursor.close();

        return cat_count;
    }

    // list categories
    public ArrayList<CategoryModel> getCategoryList(String orderByCat) {
        ArrayList<CategoryModel> categoryModelArrayList = new ArrayList<>();

        String selectCatQuery = "SELECT * FROM " + Contants.TABLE_NAME1 + " ORDER BY " + orderByCat;

        SQLiteDatabase cat_db = this.getWritableDatabase();
        Cursor cat_cursor = cat_db.rawQuery(selectCatQuery, null);

        if (cat_cursor.moveToFirst()) {
            do {
                CategoryModel categoryModel = new CategoryModel(
                        "" + cat_cursor.getString(cat_cursor.getColumnIndex(Contants.CAT_ID)),
                        "" + cat_cursor.getString(cat_cursor.getColumnIndex(Contants.CAT_TITLE))
                );
                categoryModelArrayList.add(categoryModel);
            } while (cat_cursor.moveToNext());
        }
        cat_db.close();

        return categoryModelArrayList;

    }

    // search categories
    public ArrayList<CategoryModel> getCategorySearch(String cat_searchQuery) {
        ArrayList<CategoryModel> categoryModelArrayList = new ArrayList<>();

        String selectCatQuery = "SELECT * FROM " + Contants.TABLE_NAME1 +
                " WHERE " + Contants.CAT_TITLE + " LIKE '%" + cat_searchQuery + "%'";

        SQLiteDatabase cat_db = this.getWritableDatabase();
        Cursor cat_cursor = cat_db.rawQuery(selectCatQuery, null);

        if (cat_cursor.moveToFirst()) {
            do {
                CategoryModel categoryModel = new CategoryModel(
                        "" + cat_cursor.getString(cat_cursor.getColumnIndex(Contants.CAT_ID)),
                        "" + cat_cursor.getString(cat_cursor.getColumnIndex(Contants.CAT_TITLE))
                );
                categoryModelArrayList.add(categoryModel);
            } while (cat_cursor.moveToNext());
        }
        cat_db.close();

        return categoryModelArrayList;

    }

    /********************************************************************************/

    // add post
    public long addPost(String post_title, String post_image, String post_detail,
                        String post_added_time, String post_up_time) {

        SQLiteDatabase post_db = this.getWritableDatabase();

        ContentValues post_values = new ContentValues();

        post_values.put(Contants.POST_TITLE, post_title);
        post_values.put(Contants.POST_IMAGE, post_image);
        post_values.put(Contants.POST_DETAIL, post_detail);
        post_values.put(Contants.POST_ADD_TIME, post_added_time);
        post_values.put(Contants.POST_UPDATE_TIME, post_up_time);

        long post_id = post_db.insert(Contants.TABLE_NAME, null, post_values);

        post_db.close();

        return post_id;

    }

}
