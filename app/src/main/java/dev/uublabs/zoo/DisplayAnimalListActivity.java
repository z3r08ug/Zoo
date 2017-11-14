package dev.uublabs.zoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class DisplayAnimalListActivity extends AppCompatActivity {

    private static final String TAG = "DisplayAnimalListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_animal_list);

        String category = getIntent().getStringExtra("category");

        DatabaseHelper helper = new DatabaseHelper(this);

        List<Animal> animalList = helper.getCategoryAnimals(category);

        RecyclerView recyclerView = findViewById(R.id.rvAnimalList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        AnimalRecyclerAdapter animalRecyclerAdapter = new AnimalRecyclerAdapter(animalList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(animalRecyclerAdapter);
    }
}
