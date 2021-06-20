package com.example.i_p_averyanov_d_o.adapter.Instance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.i_p_averyanov_d_o.AppData;
import com.example.i_p_averyanov_d_o.adapter.Product.ProductListener;
import com.example.i_p_averyanov_d_o.data.Instance;
import com.example.i_p_averyanov_d_o.data.ProductItem;
import com.example.i_p_averyanov_d_o.databinding.ItemBasketProductBinding;
import com.example.i_p_averyanov_d_o.databinding.ItemProductBinding;

import java.util.ArrayList;
import java.util.List;

public class InstanceAdapter extends RecyclerView.Adapter<InstanceAdapter.ViewHolder> {

    List<Instance> items = new ArrayList<>();
    AppData appData;
    InstanceListener listener;
    LayoutInflater inflater;

    public void setListener(InstanceListener listener) {
        this.listener = listener;
    }

    public InstanceAdapter(AppData appData, LayoutInflater inflater)
    {
        this.appData = appData;
        this.inflater = inflater;
    }

    public void setItems(List<Instance> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBasketProductBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Instance item = items.get(position);
        holder.binding.setInstance(item);
        if(item.productItem!=null)
            appData.loadedImage(holder.binding.product.imageView,item.productItem.getImageurl());
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
        ItemBasketProductBinding binding;
        public ViewHolder(@NonNull ItemBasketProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
