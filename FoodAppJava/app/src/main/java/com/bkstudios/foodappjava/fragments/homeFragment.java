package com.bkstudios.foodappjava.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bkstudios.foodappjava.R;
import com.bkstudios.foodappjava.adapter.CategoriesAdapter;
import com.bkstudios.foodappjava.adapter.ListAdapter;
import com.bkstudios.foodappjava.databinding.FragmentHomeBinding;
import com.bkstudios.foodappjava.model.CategoriesModel;
import com.bkstudios.foodappjava.model.ListModel;
import com.bkstudios.foodappjava.viewModel.CategoriesViewModel;
import com.bkstudios.foodappjava.viewModel.ListViewModel;

import java.util.ArrayList;
import java.util.List;

public class homeFragment extends Fragment {

    private CategoriesViewModel viewModel;
    private ListViewModel listViewModel;
    private FragmentHomeBinding fragmentHomeBinding;
    private List<CategoriesModel> categoriesModels = new ArrayList<>();
    private List<ListModel> listModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewTwo;
    private CategoriesAdapter categoriesAdapter;
    private ListAdapter listAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = fragmentHomeBinding.recView;
        recyclerViewTwo = fragmentHomeBinding.recViewTwo;
        categoriesAdapter = new CategoriesAdapter(categoriesModels);
        listAdapter = new ListAdapter(listModels);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManagerTwo = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(categoriesAdapter);
        recyclerViewTwo.setLayoutManager(layoutManagerTwo);
        recyclerViewTwo.setAdapter(listAdapter);
        categoriesModels.clear();
        listModels.clear();

        doInitialization();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       fragmentHomeBinding = FragmentHomeBinding.inflate(inflater,container,false);
       return fragmentHomeBinding.getRoot();



    }

    private void doInitialization(){
        fragmentHomeBinding.recView.setHasFixedSize(true);
        fragmentHomeBinding.recViewTwo.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);
        //categoriesAdapter = new CategoriesAdapter(categoriesModels);
        fragmentHomeBinding.recView.setAdapter(categoriesAdapter);
        fragmentHomeBinding.recViewTwo.setAdapter(listAdapter);
        getList();
        getCategories();

    }

    private void getCategories(){
        fragmentHomeBinding.setIsLoading(true);
        viewModel.getCategories().observe(this,categoriesResponse->{
            fragmentHomeBinding.setIsLoading(false);
            if (categoriesResponse != null){
                if (categoriesResponse.getCategories()!= null){
                    categoriesModels.addAll(categoriesResponse.getCategories());
                    categoriesAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void getList(){
        fragmentHomeBinding.setIsLoading(true);
        listViewModel.getList("list").observe(this,listResponse -> {
            fragmentHomeBinding.setIsLoading(false);
            if (listResponse != null){
                if (listResponse.getMeals() != null){
                    listModels.addAll(listResponse.getMeals());
                    listAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}