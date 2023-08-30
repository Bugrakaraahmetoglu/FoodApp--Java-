package com.bkstudios.foodappjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bkstudios.foodappjava.R;
import com.bkstudios.foodappjava.databinding.CategoriesItemBinding;
import com.bkstudios.foodappjava.listener.CategoriesListener;
import com.bkstudios.foodappjava.model.CategoriesModel;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private List<CategoriesModel> categoriesModels;
    private LayoutInflater layoutInflater;
    private static CategoriesListener categoriesListener;

    public CategoriesAdapter(List<CategoriesModel> categoriesModels){
        this.categoriesModels = categoriesModels;

    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CategoriesItemBinding categoriesItemBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.categories_item,parent,false
        );
        return new CategoriesViewHolder(categoriesItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        holder.bindCategories(categoriesModels.get(position));
    }

    @Override
    public int getItemCount() {
        return categoriesModels.size()/3;
    }

    static class CategoriesViewHolder extends RecyclerView.ViewHolder{

        private CategoriesItemBinding categoriesItemBinding;

        public CategoriesViewHolder(CategoriesItemBinding categoriesItemBinding) {
            super(categoriesItemBinding.getRoot());
            this.categoriesItemBinding = categoriesItemBinding;
        }

        public void bindCategories(CategoriesModel categoriesModel){
            categoriesItemBinding.setCategories(categoriesModel);
            categoriesItemBinding.executePendingBindings();
        }
    }
}
