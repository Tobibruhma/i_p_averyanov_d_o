package com.example.i_p_averyanov_d_o.adapter.Order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.i_p_averyanov_d_o.AppData;
import com.example.i_p_averyanov_d_o.adapter.Product.ProductListener;
import com.example.i_p_averyanov_d_o.data.OrderItem;
import com.example.i_p_averyanov_d_o.data.ProductItem;
import com.example.i_p_averyanov_d_o.databinding.ItemOrderBinding;
import com.example.i_p_averyanov_d_o.databinding.ItemProductBinding;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<OrderItem> items = new ArrayList<>();
    AppData appData;
    OrderListener listener;
    LayoutInflater inflater;

    public void setListener(OrderListener listener) {
        this.listener = listener;
    }

    public OrderAdapter(AppData appData, LayoutInflater inflater)
    {
        this.appData = appData;
        this.inflater = inflater;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemOrderBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderItem item = items.get(position);
        holder.binding.setOrder(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null)
                    listener.SelectElement(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemOrderBinding binding;
        public ViewHolder(@NonNull ItemOrderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
