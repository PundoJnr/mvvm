package com.pundo.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.pundo.mvvm.adapters.RecyclerAdapter;
import com.pundo.mvvm.models.NewPlace;
import com.pundo.mvvm.viewmodels.MainActivityviewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter mAdapter;
    MainActivityviewModel mainActivityviewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        mainActivityviewModel = ViewModelProviders.of(this).get(MainActivityviewModel.class);
        mainActivityviewModel.init();
        mainActivityviewModel.getNewPlace().observe(this, new Observer<List<NewPlace>>() {
            @Override
            public void onChanged(List<NewPlace> newPlaces) {
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecycler();
    }

    private void initRecycler() {
        mAdapter = new RecyclerAdapter(this, (ArrayList<NewPlace>) mainActivityviewModel.getNewPlace().getValue());
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(mAdapter);
    }
}
