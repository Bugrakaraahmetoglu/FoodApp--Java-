package com.bkstudios.foodappjava.response;

import com.bkstudios.foodappjava.model.ListModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListResponse {

    @SerializedName("meals")
    private List<ListModel> meals;

    public List<ListModel> getMeals() {
        return meals;
    }
}
