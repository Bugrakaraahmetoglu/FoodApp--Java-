package com.bkstudios.foodappjava.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bkstudios.foodappjava.R;
import com.bkstudios.foodappjava.databinding.CategoriesItemBinding;
import com.bkstudios.foodappjava.databinding.CategoriesPageItemBinding;
import com.bkstudios.foodappjava.model.CategoriesModel;

import java.util.List;

public class CategoriesPageAdapter extends RecyclerView.Adapter<CategoriesPageAdapter.CategoriesPageViewHolder>{

    private List<CategoriesModel> categoriesModels;
    private LayoutInflater layoutInflater;

    public CategoriesPageAdapter(List<CategoriesModel> categoriesModels){
        this.categoriesModels = categoriesModels;

    }

    @NonNull
    @Override
    public CategoriesPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CategoriesPageItemBinding categoriesPageItemBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.categories_page_item,parent,false
        );
        return new CategoriesPageAdapter.CategoriesPageViewHolder(categoriesPageItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesPageViewHolder holder, int position) {
        holder.bindCategories(categoriesModels.get(position));
    }

    @Override
    public int getItemCount() {
        return  categoriesModels.size();
    }


    static class CategoriesPageViewHolder extends RecyclerView.ViewHolder{

        private CategoriesPageItemBinding categoriesPageItemBinding;

        public CategoriesPageViewHolder( CategoriesPageItemBinding categoriesPageItemBinding) {
            super(categoriesPageItemBinding.getRoot());
            this.categoriesPageItemBinding = categoriesPageItemBinding;
        }

        public void bindCategories(CategoriesModel categoriesModel){
            categoriesPageItemBinding.setCategories(categoriesModel);
            categoriesPageItemBinding.executePendingBindings();
        }
    }

}
