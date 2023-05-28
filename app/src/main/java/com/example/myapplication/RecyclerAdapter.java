package com.example.myapplication;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final OnPriceChangeListener onPriceChangeListener;
    private final OnAdapterClickListener onAdapterClickListener;

    private List<Order> items;

    public RecyclerAdapter(final OnPriceChangeListener onPriceChangeListener,
            OnAdapterClickListener onAdapterClickListener) {
        this.onPriceChangeListener = onPriceChangeListener;
        this.onAdapterClickListener = onAdapterClickListener;
    }

    public void update(List<Order> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.input_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        TextView text = holder.itemView.findViewById(R.id.text);
        EditText input = holder.itemView.findViewById(R.id.input);

        text.setText(items.get(position).getName());
        input.setText(items.get(position).getPrice());

        // обработка изменений в EditText
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {

            }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
                listener.onPriceChanged(s.toString(), holder.getAdapterPosition());
            }

            @Override
            public void afterTextChanged(final Editable s) {

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                onAdapterClickListener.onClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
        }
    }
}
