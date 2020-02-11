package com.pundo.mvvm.repositories;

import androidx.lifecycle.MutableLiveData;

import com.pundo.mvvm.models.NewPlace;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 */
public class NewPlacesRepository {

    private static NewPlacesRepository instance;
    private ArrayList<NewPlace> dataset = new ArrayList<>();

    public static NewPlacesRepository getInstance(){
        if (instance== null){
            instance = new NewPlacesRepository();

        }
        return instance;
    }

    //pretend to get data from an online source
    public MutableLiveData<List<NewPlace>> getNewPlace(){
        setNewPlaces();

        MutableLiveData<List<NewPlace>> data = new MutableLiveData<>();
        data.setValue(dataset);
        return data;

    }
    private void setNewPlaces(){
        dataset.add(
                new NewPlace("Arthur",
                        "")
        );
    }
}
