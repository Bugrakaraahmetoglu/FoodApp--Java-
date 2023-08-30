package com.bkstudios.foodappjava.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bkstudios.foodappjava.response.CategoryResponse;
import com.bkstudios.foodappjava.service.ApiClient;
import com.bkstudios.foodappjava.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesRepository {

    private ApiService apiService;

    public CategoriesRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<CategoryResponse> getCategoires(){
        MutableLiveData<CategoryResponse> data = new MutableLiveData<>();
        apiService.getCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
