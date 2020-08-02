package com.example.materialdesign.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesign.R;

import java.util.List;

public class MyRecyclerViewAdapters extends RecyclerView.Adapter<MyRecyclerViewAdapters.MyViewHolder>{


    private final List<String> data;
    private final Context con;

    public MyRecyclerViewAdapters(List<String> list, FragmentActivity activity) {
        this.data=list;
        this.con=activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(con).inflate(R.layout.item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
          holder.tv.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size()>0?data.size():0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv_name);
        }
    }
}
