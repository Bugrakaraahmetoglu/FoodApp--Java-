package com.bkstudios.foodappjava.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bkstudios.foodappjava.R;
import com.bkstudios.foodappjava.databinding.CategoriesPageItemBinding;
import com.bkstudios.foodappjava.databinding.ListItemBinding;

import com.bkstudios.foodappjava.model.ListModel;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<ListModel> listModels;
    private LayoutInflater layoutInflater;

    public ListAdapter(List<ListModel> listModels){
        this.listModels = listModels;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ListItemBinding listItemBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.list_item,parent,false
        );
        return new ListAdapter.ListViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.bindList(listModels.get(position));
    }

    @Override
    public int getItemCount() {
        return listModels.size()/30;
    }


    static class ListViewHolder extends RecyclerView.ViewHolder{

        private ListItemBinding listItemBinding;

        public ListViewHolder( ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;
        }

        public void bindList(ListModel listModel){
            listItemBinding.setList(listModel);
            listItemBinding.executePendingBindings();
        }
    }
}
