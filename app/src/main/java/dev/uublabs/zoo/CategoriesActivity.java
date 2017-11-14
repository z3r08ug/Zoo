package dev.uublabs.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity
{

    private List<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        animals = new ArrayList<>();
        DatabaseHelper helper = new DatabaseHelper(this);
        ListView lvCategories = findViewById(R.id.lvCategory);
        animals = helper.getAnimals();
        if (animals.size() == 0)
        {
            bindData();
            long row;
            for(Animal animal : animals)
            {
                row = helper.saveAnimal(animal);
            }
        }

        final List<String> categories = new ArrayList<>();
        for (Animal a : animals)
        {
            if(!categories.contains(a.getType()))
            {
                categories.add(a.getType());
            }
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, categories);
        lvCategories.setAdapter(arrayAdapter);
        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(getBaseContext(), DisplayAnimalListActivity.class);
                intent.putExtra("category", categories.get(position));
                startActivity(intent);
            }
        });

    }
    private void bindData()
    {
        String bird = "Birds";
        String bear = "Bears";
        String tiger = "Tigers";
        String giraffe = "Giraffes";
        animals.add(new Animal("Moluccan Cockatoo", bird));
        animals.add(new Animal("Parrot", bird));
        animals.add(new Animal("Eagle", bird));
        animals.add(new Animal("Black Bear", bear));
        animals.add(new Animal("Brown Bear", bear));
        animals.add(new Animal("Bengal Tiger", tiger));
        animals.add(new Animal("White Tiger", tiger));
        animals.add(new Animal("Masal Giraffe", giraffe));
        animals.add(new Animal("West African Giraffe", giraffe));
    }
}
