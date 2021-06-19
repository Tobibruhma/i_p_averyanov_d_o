package com.example.i_p_averyanov_d_o.adapter.Product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.i_p_averyanov_d_o.AppData;
import com.example.i_p_averyanov_d_o.ProductItem;
import com.example.i_p_averyanov_d_o.databinding.ItemProductBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    List<ProductItem> items = new ArrayList<>();
    AppData appData;
    ProductListener listener;
    LayoutInflater inflater;

    public void setListener(ProductListener listener) {
        this.listener = listener;
    }

    public  ProductAdapter(AppData appData, LayoutInflater inflater)
    {
        this.appData = appData;
        this.inflater = inflater;
    }

    public void setItems(List<ProductItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemProductBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductItem item = items.get(position);
        holder.binding.setProduct(item);
        appData.loadedImage(holder.binding.imageView,item.getImageurl());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemProductBinding binding;
        public ViewHolder(@NonNull ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
