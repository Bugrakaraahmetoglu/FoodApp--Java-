package com.bkstudios.foodappjava.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.bkstudios.foodappjava.repository.CategoriesRepository;
import com.bkstudios.foodappjava.response.CategoryResponse;

public class CategoriesViewModel extends ViewModel {

    private CategoriesRepository categoriesRepository;

    public CategoriesViewModel(){
        categoriesRepository = new CategoriesRepository();
    }
    public LiveData<CategoryResponse> getCategories(){
        return categoriesRepository.getCategoires();
    }
}
