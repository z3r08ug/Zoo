package dev.uublabs.zoo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/14/2017.
 */

public class AnimalRecyclerAdapter extends RecyclerView.Adapter<AnimalRecyclerAdapter.ViewHolder>
{
    List<Animal> animalList = new ArrayList<>();

    static String TAG = "AnimalAdapter";
    public AnimalRecyclerAdapter(List<Animal> list)
    {
        Log.d(TAG, "AnimalRecyclerAdapter: constructor"+list.size());
        animalList = list;
    }


    @Override
    public AnimalRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.animal_recycle_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimalRecyclerAdapter.ViewHolder holder, int position)
    {
        Animal animal = animalList.get(position);
        Log.d(TAG, "onBindViewHolder: "+animal.getName());
        if(animal != null)
        {
            holder.tvAnimalName.setText(animal.getName());
            holder.tvAnimalType.setText(animal.getType());
        }
    }

    @Override
    public int getItemCount()
    {
        return animalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView tvAnimalName;
        private final TextView tvAnimalType;
        public ViewHolder(View itemView)
        {
            super(itemView);
            tvAnimalName = itemView.findViewById(R.id.tvAnimalName);
            tvAnimalType = itemView.findViewById(R.id.tvAnimalType);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    String animal = animalList.get(getAdapterPosition()).getName();
                    Intent intent = new Intent(v.getContext(), DisplayAnimalInfoActivity.class);
                    intent.putExtra("animal", animal);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}