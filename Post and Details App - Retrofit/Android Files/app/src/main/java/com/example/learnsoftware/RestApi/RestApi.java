package com.example.learnsoftware.RestApi;

import com.example.learnsoftware.Model.Posts;
import com.example.learnsoftware.Model.post_detail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    @GET("list.php")
    Call<List<Posts>> home_list();

    // detail.php?blog_id=x
    @GET("detail.php")
    Call<post_detail> details(@Query("blog_id") String blog_id);

}
