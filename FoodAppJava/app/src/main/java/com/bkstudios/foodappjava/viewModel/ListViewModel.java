package com.bkstudios.foodappjava.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.bkstudios.foodappjava.repository.ListRepository;
import com.bkstudios.foodappjava.response.ListResponse;

public class ListViewModel extends ViewModel {

    private ListRepository listRepository;

    public ListViewModel(){
        listRepository = new ListRepository();
    }

    public LiveData<ListResponse> getList(String list){
        return listRepository.getList(list);
    }
}
