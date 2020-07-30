package com.example.learnsoftware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ProgressDialog;
import android.os.Bundle;

import android.widget.ListView;

import com.example.learnsoftware.Adapters.PostAdapterR;
import com.example.learnsoftware.Model.Posts;
import com.example.learnsoftware.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Posts> list;
    ListView listView;

    //--------------------------
    ArrayList<Posts> postsArrayList = new ArrayList<>();
    PostAdapterR postAdapterR;
    RecyclerView recycler_view_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view_home = findViewById(R.id.recycler_view_home);
        recycler_view_home.setLayoutManager(new LinearLayoutManager(this));

        request();
    }

    public void request() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Yükleniyor...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        list = new ArrayList<>();
        Call<List<Posts>> posts = ManagerAll.getOurInstance().getPostList();
        posts.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful()) {
                    postsArrayList = new ArrayList<>(response.body());
                    postAdapterR = new PostAdapterR(postsArrayList, MainActivity.this);
                    recycler_view_home.setAdapter(postAdapterR);
                    progressDialog.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
    }


}