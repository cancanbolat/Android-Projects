package com.example.learnsoftware.Adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnsoftware.MainActivity;
import com.example.learnsoftware.Model.Posts;
import com.example.learnsoftware.PostDetail;
import com.example.learnsoftware.R;

import java.util.ArrayList;
import java.util.List;

public class PostAdapterR extends RecyclerView.Adapter<PostAdapterR.ViewHolder> {

    private ArrayList<Posts> posts_list = new ArrayList<>();
    private Context context;
    TextView blog_name1, small_detail;
    ArrayList<Posts> postsArrayList = new ArrayList<>();

    public PostAdapterR(ArrayList<Posts> posts_list, Context context) {
        this.posts_list = posts_list;
        this.context = context;
    }

    @NonNull
    @Override
    public PostAdapterR.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        return new PostAdapterR.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostAdapterR.ViewHolder holder, int position) {
        blog_name1.setText(posts_list.get(position).getBlog_name());
        small_detail.setText(posts_list.get(position).getBlog_small_detail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PostDetail.class);
                intent.putExtra("blog_id", posts_list.get(position).getBlog_id());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            blog_name1 = itemView.findViewById(R.id.blog_name1);
            small_detail = itemView.findViewById(R.id.small_detail);
        }
    }
}
