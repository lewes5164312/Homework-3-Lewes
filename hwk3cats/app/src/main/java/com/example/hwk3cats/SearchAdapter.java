package com.example.hwk3cats;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ItemViewHolder> {
    private ArrayList<Cat> catsToAdapt;

    public void setData(ArrayList<Cat> catsToAdapt) {
        this.catsToAdapt = catsToAdapt;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cat, parent, false);
        ItemViewHolder catViewHolder = new ItemViewHolder(view);
        return catViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Cat catAtPosition = catsToAdapt.get(position);

        holder.nameTV.setText(catAtPosition.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, CatDetailActivity.class);
                intent.putExtra("CatID", catAtPosition.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return catsToAdapt.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView nameTV;

        public ItemViewHolder(View v) {
            super(v);
            nameTV = v.findViewById(R.id.item_text);
            view = v.findViewById(R.id.view);
        }


    }
}
