package com.example.mysqlite2.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mysqlite2.Database.DbHelper;
import com.example.mysqlite2.Models.CategoryModel;
import com.example.mysqlite2.R;
import com.example.mysqlite2.ui.dashboard.DashboardFragment;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ImageButton moreBtnCategory;
    private TextView category_name_item;
    private DbHelper dbHelper;

    private ArrayList<CategoryModel> categoryArrayList;
    private Context context;

    public CategoryAdapter(ArrayList<CategoryModel> categoryArrayList, Context context) {
        this.categoryArrayList = categoryArrayList;
        this.context = context;

        dbHelper = new DbHelper(context);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryModel categoryModel = categoryArrayList.get(position);
        final String cat_id = categoryModel.getCategory_id();
        final String cat_name = categoryModel.getCategory_title();

        category_name_item.setText(cat_name);

        // delete
        moreBtnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoreDialog("" + cat_id, "" + cat_name);
            }
        });

    }

    // alert dialogs
    private void showMoreDialog(final String cat_id, final String cat_title) {
        String[] options = {"Sil"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {

                    Bundle bundle = new Bundle();
                    bundle.putString("category_id", cat_id);
                    DashboardFragment dashboardFragment = new DashboardFragment();
                    dashboardFragment.setArguments(bundle);

                    dbHelper.deleteCategory(cat_id);
                    Toast.makeText(context, "Silme Başarılı. Sayfayı yenileyiniz.", Toast.LENGTH_SHORT).show();

                }
            }
        });
        builder.create().show();
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            moreBtnCategory = itemView.findViewById(R.id.moreBtnCategory);
            category_name_item = itemView.findViewById(R.id.category_name_item);
        }
    }

}
