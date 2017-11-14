package dev.uublabs.zoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayAnimalInfoActivity extends AppCompatActivity
{

    private TextView tvAnimalName;
    private TextView tvAnimalType;
    private Animal animal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_animal_info);

        String animalName = getIntent().getStringExtra("animal");

        DatabaseHelper helper = new DatabaseHelper(this);

        animal = helper.getAnimal(animalName);

        tvAnimalName = findViewById(R.id.tvAnimalInfoName);
        tvAnimalType = findViewById(R.id.tvAnimalInfoType);

        tvAnimalName.setText(animal.getName());
        tvAnimalType.setText(animal.getType());
    }
}
