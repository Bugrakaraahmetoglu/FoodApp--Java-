package com.bkstudios.foodappjava.service;

import com.bkstudios.foodappjava.response.CategoryResponse;
import com.bkstudios.foodappjava.response.ListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("categories.php")
    Call<CategoryResponse> getCategories();

    @GET("list.php")
    Call<ListResponse> getList(@Query("i") String list);
}
