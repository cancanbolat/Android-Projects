package com.example.learnsoftware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.learnsoftware.Model.post_detail;
import com.example.learnsoftware.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetail extends AppCompatActivity {

    TextView detail_text, detail_title;
    String post_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // gelen id'yi almak ->
        Bundle bundle = getIntent().getExtras();
        post_id = bundle.getString("blog_id");
        // gelen id'yi almak <-


        detail_text = findViewById(R.id.detail_text);
        detail_title = findViewById(R.id.detail_title);
        //webView = findViewById(R.id.detail_text);

        getDetail();

    }

    public void getDetail() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Yükleniyor...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Call<post_detail> request = ManagerAll.getOurInstance().details(post_id);
        request.enqueue(new Callback<post_detail>() {
            @Override
            public void onResponse(Call<post_detail> call, Response<post_detail> response) {

                detail_title.setText(response.body().getTitle());

                String detail_html = String.valueOf(Html.fromHtml("" + response.body().getDetail()));
                detail_text.setText(detail_html);
                progressDialog.cancel();

            }

            @Override
            public void onFailure(Call<post_detail> call, Throwable t) {

            }
        });

    }


}