package com.example.james.mycustomrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by James on 9/14/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.AndroidViewHolder>{

    ArrayList<AndroidVersion> androidVersionArrayList;

    public CustomAdapter(ArrayList<AndroidVersion> androidVersionArrayList) {
        this.androidVersionArrayList = androidVersionArrayList;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        AndroidViewHolder androidViewHolder = new AndroidViewHolder(v);
        return androidViewHolder;
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int i) {
        AndroidVersion version = androidVersionArrayList.get(i);
        holder.logo.setImageResource(version.getLogo());
        holder.codename.setText(version.getCodename());
        holder.version.setText(version.getVersion());
        holder.api.setText(version.getApi());
        holder.date.setText(version.getDate());
    }

    @Override
    public int getItemCount() {
        return androidVersionArrayList.size();
    }

    public static class AndroidViewHolder extends RecyclerView.ViewHolder{
        ImageView logo;
        TextView codename, version, api, date;

        public AndroidViewHolder(View v) {
            super(v);
            logo = v.findViewById(R.id.iv_logo);
            codename = v.findViewById(R.id.tv_codename);
            version = v.findViewById(R.id.tv_version);
            api = v.findViewById(R.id.tv_api);
            date = v.findViewById(R.id.tv_date);
        }
    }
}
