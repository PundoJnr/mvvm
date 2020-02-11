package com.pundo.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pundo.mvvm.models.NewPlace;
import com.pundo.mvvm.repositories.NewPlacesRepository;

import java.util.List;

public class MainActivityviewModel extends ViewModel {

    private MutableLiveData<List<NewPlace>> mNewPlace;
    private NewPlacesRepository mRepo;
    public void init(){
        if (mNewPlace != null){
            return;
        }
        mRepo = NewPlacesRepository.getInstance();
        mNewPlace = mRepo.getNewPlace();
    }

    public LiveData<List<NewPlace>> getNewPlace(){
        return mNewPlace;
    }
}
