package com.bkstudios.foodappjava.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bkstudios.foodappjava.response.ListResponse;
import com.bkstudios.foodappjava.service.ApiClient;
import com.bkstudios.foodappjava.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListRepository {

    private ApiService apiService;

    public ListRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<ListResponse> getList(String list){
        MutableLiveData<ListResponse> data = new MutableLiveData<>();
        apiService.getList(list).enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
