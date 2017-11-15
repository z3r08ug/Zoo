package dev.uublabs.zoo;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayAnimalInfoActivity extends AppCompatActivity
{

    private TextView tvAnimalName;
    private TextView tvAnimalType;
    private Animal animal;
    private TextView tvDescription;
    private ImageView ivAnimal;

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
        tvDescription = findViewById(R.id.tvDescription);
        ivAnimal = findViewById(R.id.ivAnimal);

        tvAnimalName.setText(animal.getName());
        tvAnimalType.setText("Category: "+animal.getType());
        tvDescription.setText("Description:\n"+animal.getDescription());

        switch (animal.getName())
        {
            case "Moluccan Cockatoo":
            {
                ivAnimal.setImageResource(R.drawable.cockatoo);
                break;
            }
            case "Scarlet Macaw":
            {
                ivAnimal.setImageResource(R.drawable.scarletmacaw);
                break;
            }
            case "Eagle":
            {
                ivAnimal.setImageResource(R.drawable.eagle);
                break;
            }
            case "American Black Bear":
            {
                ivAnimal.setImageResource(R.drawable.blackbear);
                break;
            }
            case "Brown Bear":
            {
                ivAnimal.setImageResource(R.drawable.brownbear);
                break;
            }
            case "Bengal Tiger":
            {
                ivAnimal.setImageResource(R.drawable.bengaltiger);
                break;
            }
            case "White Tiger":
            {
                ivAnimal.setImageResource(R.drawable.whitetiger);
                break;
            }
            case "West African Giraffe":
            {
                ivAnimal.setImageResource(R.drawable.giraffe);
                break;
            }
            case "African Elephant":
            {
                ivAnimal.setImageResource(R.drawable.elephant);
                break;
            }
        }

    }
}
