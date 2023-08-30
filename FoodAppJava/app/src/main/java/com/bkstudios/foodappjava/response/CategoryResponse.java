package com.bkstudios.foodappjava.response;

import com.bkstudios.foodappjava.model.CategoriesModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {

    @SerializedName("categories")
    private List<CategoriesModel> categories;

    public List<CategoriesModel> getCategories() {
        return categories;
    }
}
