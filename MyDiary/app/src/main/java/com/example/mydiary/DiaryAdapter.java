package com.example.mydiary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.NumberViewHolder>{
    public List<String> data;
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diary, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.tvTitle.setText(data.get(position)+ "");
    }

    @Override
    public int getItemCount() {
        if(data==null){
            return 1;
        }
        return data.size();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.text_title);
        }
    }
}
