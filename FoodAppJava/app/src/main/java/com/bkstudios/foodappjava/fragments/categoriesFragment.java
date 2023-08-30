package com.bkstudios.foodappjava.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bkstudios.foodappjava.R;
import com.bkstudios.foodappjava.adapter.CategoriesAdapter;
import com.bkstudios.foodappjava.adapter.CategoriesPageAdapter;
import com.bkstudios.foodappjava.databinding.FragmentCategoriesBinding;
import com.bkstudios.foodappjava.databinding.FragmentHomeBinding;
import com.bkstudios.foodappjava.model.CategoriesModel;
import com.bkstudios.foodappjava.viewModel.CategoriesViewModel;

import java.util.ArrayList;
import java.util.List;


public class categoriesFragment extends Fragment {

    private CategoriesViewModel viewModel;
    private FragmentCategoriesBinding fragmentCategoriesBinding;
    private List<CategoriesModel> categoriesModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private CategoriesPageAdapter categoriesPageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = fragmentCategoriesBinding.recView;
        categoriesPageAdapter = new CategoriesPageAdapter(categoriesModels);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(categoriesPageAdapter);
        categoriesModels.clear();
        doInitialization();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCategoriesBinding = FragmentCategoriesBinding.inflate(inflater,container,false);
        return fragmentCategoriesBinding.getRoot();
    }

    private void doInitialization(){
        fragmentCategoriesBinding.recView.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        //categoriesAdapter = new CategoriesAdapter(categoriesModels);
        fragmentCategoriesBinding.recView.setAdapter(categoriesPageAdapter);
        getCategories();
    }

    private void getCategories(){
        fragmentCategoriesBinding.setIsLoading(true);
        viewModel.getCategories().observe(this,categoriesResponse->{
            fragmentCategoriesBinding.setIsLoading(false);
            if (categoriesResponse != null){
                if (categoriesResponse.getCategories()!= null){
                    categoriesModels.addAll(categoriesResponse.getCategories());
                    categoriesPageAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}