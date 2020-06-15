package com.example.mydatabaseapp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class adapter extends BaseAdapter {

    List<personInfo> list;
    Context context;

    public adapter(List<personInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);

        TextView name     = convertView.findViewById(R.id.nameTxt);
        TextView username = convertView.findViewById(R.id.usernameTxt);
        TextView password = convertView.findViewById(R.id.passwordTxt);
        TextView gender   = convertView.findViewById(R.id.genderTxt);

        name.setText(list.get(position).getName());
        username.setText(list.get(position).getUsername());
        password.setText(list.get(position).getPassword());
        gender.setText(list.get(position).getMalefemale());

        return convertView;
    }
}
