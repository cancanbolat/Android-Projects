package com.example.learnsoftware.RestApi;

import com.example.learnsoftware.Model.Posts;
import com.example.learnsoftware.Model.post_detail;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getOurInstance() {
        return ourInstance;
    }

    public Call<List<Posts>> getPostList() {
        Call<List<Posts>> x = getRestApi().home_list();
        return x;
    }

    public Call<post_detail> details(String blog_id){
        Call<post_detail> xx = getRestApi().details(blog_id);
        return xx;
    }

}
