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
                        "data:image/jpeg;base64,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")
        );
    }
}
