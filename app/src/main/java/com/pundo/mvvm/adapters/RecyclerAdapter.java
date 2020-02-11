package com.pundo.mvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pundo.mvvm.MainActivity;
import com.pundo.mvvm.R;
import com.pundo.mvvm.models.NewPlace;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<NewPlace> mnewPlaces = new ArrayList<>();
    Context context;

    public RecyclerAdapter(MainActivity mainActivity, ArrayList<NewPlace> newPlaces) {
        context = mainActivity;
        mnewPlaces = newPlaces;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(mnewPlaces.get(position).getName());
        Picasso.get().load(mnewPlaces.get(position).getImgURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mnewPlaces.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.placeName);
            imageView = itemView.findViewById(R.id.placeImage);
        }
    }
}
