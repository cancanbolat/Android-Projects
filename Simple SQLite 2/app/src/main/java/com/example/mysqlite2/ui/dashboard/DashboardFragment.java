package com.example.mysqlite2.ui.dashboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysqlite2.Adapters.CategoryAdapter;
import com.example.mysqlite2.Database.Contants;
import com.example.mysqlite2.Database.DbHelper;
import com.example.mysqlite2.R;

public class DashboardFragment extends Fragment {

    private EditText category_nameEditTex;
    private Button add_category;
    private DbHelper dbHelper;
    private String cat_titleString;
    private View root;
    private RecyclerView cat_recyclerView;
    private CategoryAdapter categoryAdapter;
    private Button resetBtn, sortBtn;

    String DESC = Contants.CAT_ID + " DESC";
    String ASC = Contants.CAT_ID + " ASC";

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // views
        category_nameEditTex = root.findViewById(R.id.category_name);
        add_category = root.findViewById(R.id.add_category);
        cat_recyclerView = root.findViewById(R.id.cat_recyclerView);
        resetBtn = root.findViewById(R.id.resetBtn);
        sortBtn = root.findViewById(R.id.sortBtn);

        // database
        dbHelper = new DbHelper(root.getContext());

        // add button click
        add_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryAdd();
                categoryList(DESC);
                category_nameEditTex.setText("");
            }
        });

        categoryList(DESC);

        // reset and sort button click ->
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAll();
            }
        });

        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSortBtn();
            }
        });
        // reset and sort button click <-

        return root;
    }

    // category add
    private void categoryAdd() {
        cat_titleString = category_nameEditTex.getText().toString().trim();

        long cat_id = dbHelper.addCategory("" + cat_titleString);

        Toast.makeText(root.getContext(), "Kategori Ekleme Başarılı (" + cat_id + ")", Toast.LENGTH_SHORT).show();
    }

    // category list
    private void categoryList(String orderBy) {
        categoryAdapter = new CategoryAdapter(dbHelper.getCategoryList(orderBy),
                root.getContext());
        cat_recyclerView.setAdapter(categoryAdapter);
    }

    // sort
    private void setSortBtn() {
        String[] options = {"Yeniden Eskiye", "Eskiden Yeniye"};
        AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
        builder.setTitle("Sıralama seç")
                .setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            categoryList(DESC);
                        } else if (which == 1) {
                            categoryList(ASC);
                        }
                    }
                })
                .create().show();
    }

    // reset
    private void deleteAll() {
        dbHelper.deleteAllCategory();
        categoryList(DESC);
    }


}