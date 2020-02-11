package com.pundo.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pundo.mvvm.models.NewPlace;

import java.util.List;

public class MainActivityviewModel extends ViewModel {

    private MutableLiveData<List<NewPlace>> mNewPlace;

    public LiveData<List<NewPlace>> getNewPlace(){
        return mNewPlace;
    }
}
