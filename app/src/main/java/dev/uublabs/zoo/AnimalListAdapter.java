package dev.uublabs.zoo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/14/2017.
 */

public class AnimalListAdapter extends ArrayAdapter<Animal>
{
    List<Animal> celebrityList = new ArrayList<>();

    public AnimalListAdapter(@NonNull Context context, int resource, @NonNull List<Animal> objects)
    {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.animal_list_item, null);
        }
        //bind the views
        TextView tvCelebrityName = convertView.findViewById(R.id.tvAnimalName);
        TextView tvCelebrityAge = convertView.findViewById(R.id.tvAnimalType);

        //set data to the views
        Animal animal = getItem(position);
        if(animal != null)
        {
            tvCelebrityName.setText(animal.getName());
            tvCelebrityAge.setText("" + animal.getType());

        }
        return convertView;
    }
}
