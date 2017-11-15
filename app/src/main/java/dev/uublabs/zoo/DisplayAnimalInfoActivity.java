package dev.uublabs.zoo;

import android.media.MediaPlayer;
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
    private MediaPlayer mp;

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
                mp = MediaPlayer.create(this, R.raw.cockatoo);
                break;
            }
            case "Scarlet Macaw":
            {
                ivAnimal.setImageResource(R.drawable.scarletmacaw);
                mp = MediaPlayer.create(this, R.raw.parrot);
                break;
            }
            case "Eagle":
            {
                ivAnimal.setImageResource(R.drawable.eagle);
                mp = MediaPlayer.create(this, R.raw.eagle);
                break;
            }
            case "American Black Bear":
            {
                ivAnimal.setImageResource(R.drawable.blackbear);
                mp = MediaPlayer.create(this, R.raw.bear1);
                break;
            }
            case "Brown Bear":
            {
                ivAnimal.setImageResource(R.drawable.brownbear);
                mp = MediaPlayer.create(this, R.raw.bear2);
                break;
            }
            case "Bengal Tiger":
            {
                ivAnimal.setImageResource(R.drawable.bengaltiger);
                mp = MediaPlayer.create(this, R.raw.tiger);
                break;
            }
            case "White Tiger":
            {
                ivAnimal.setImageResource(R.drawable.whitetiger);
                mp = MediaPlayer.create(this, R.raw.tiger);
                break;
            }
            case "West African Giraffe":
            {
                ivAnimal.setImageResource(R.drawable.giraffe);
                mp = MediaPlayer.create(this, R.raw.giraffe);
                break;
            }
            case "African Elephant":
            {
                ivAnimal.setImageResource(R.drawable.elephant);
                mp = MediaPlayer.create(this, R.raw.elephant);
                break;
            }
        }
        if (mp != null)
            mp.start();
    }
}
