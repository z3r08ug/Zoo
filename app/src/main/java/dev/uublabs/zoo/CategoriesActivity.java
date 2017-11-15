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
        String elephant = "Elephants";
        animals.add(new Animal("Moluccan Cockatoo", bird, "The Salmon-crested cockatoo (Cacatua moluccensis), " +
                "also known as the Moluccan cockatoo, is a cockatoo endemic to the Seram archipelago in eastern Indonesia. At a " +
                "height of up to 46–52 cm and weight of up to 850 g, it is among the largest of the white cockatoos. The female is " +
                "larger than the male on average. It has white-pink feathers with a definite peachy glow, a slight yellow on the" +
                " underwing and underside of the tail feathers and a large retractable recumbent" +
                " crest which it raises when threatened, revealing hitherto concealed bright red-orange plumes to " +
                "frighten potential attackers."));

        animals.add(new Animal("Scarlet Macaw", bird, "The scarlet macaw (Ara macao) is a large red, yellow," +
                " and blue South American parrot, a member of a large group of Neotropical parrots called macaws. It is native " +
                "to humid evergreen forests of tropical South America.It is about 81 centimetres (32 in) long, of which more than " +
                "half is the pointed, graduated tail typical of all macaws, though the scarlet macaw has a larger percentage" +
                " of tail than the other large macaws. The average weight is about 1 kilogram (2.2 lb). The plumage is mostly " +
                "scarlet, but the rump and tail-covert feathers are light blue, the greater upper wing coverts are yellow, the " +
                "upper sides of the flight feathers of the wings are dark blue as are the ends of the tail feathers, and the" +
                " undersides of the wing and tail flight feathers are dark red with metallic gold iridescence."));

        animals.add(new Animal("Eagle", bird, "Eagles are large, powerfully built birds of prey, with heavy" +
                " heads and beaks.The smallest species of eagle is the South Nicobar serpent eagle (Spilornis klossi), at 450 g " +
                "(0.99 lb) and 40 cm (16 in).Eagles' eyes are extremely powerful, having up to 3.6 times human acuity for the " +
                "martial eagle, which enables them to spot potential prey from a very long distance. Eagles normally build" +
                " their nests, called eyries, in tall trees or on high cliffs. Many species lay two eggs, but the older, " +
                "larger chick frequently kills its younger sibling once it has hatched."));

        animals.add(new Animal("American Black Bear", bear, "The American Black Bear (Ursus americanus)" +
                " is a medium-sized bear native to North America.Black bears are omnivores, with their diets varying greatly" +
                " depending on season and location. They typically live in largely forested areas, but do leave forests in " +
                "search of food. Sometimes they become attracted to human communities because of the immediate availability " +
                "of food. The American black bear is the world's most common bear species."));

        animals.add(new Animal("Brown Bear", bear, "The brown bear (Ursus arctos) is a large bear with " +
                "the widest distribution of any living ursid. The species is distributed across much of northern Eurasia " +
                "and North America.The brown bear's principal range includes parts of Russia, Central Asia, China, Canada," +
                " the United States (mostly Alaska), Scandinavia, and the Carpathian region (especially Romania), Anatolia," +
                " and Caucasus. The brown bear is recognized as a national and state animal in several European countries."));

        animals.add(new Animal("Bengal Tiger", tiger, "The Bengal tiger (Panthera tigris tigris) is the" +
                " most numerous of the tiger subspecies. By 2011, the total population was estimated at fewer than 2,500" +
                " individuals with a decreasing trend. None of the Tiger Conservation Landscapes within the Bengal tiger's" +
                " range is considered large enough to support an effective population size of 250 adult individuals.The Bengal" +
                " tiger's coat is yellow to light orange, with stripes ranging from dark brown to black; the belly and the " +
                "interior parts of the limbs are white, and the tail is orange with black rings."));

        animals.add(new Animal("White Tiger", tiger, "The white tiger or bleached tiger is a pigmentation" +
                " variant of the Bengal tiger, which is reported in the wild from time to time in the Indian states of Assam," +
                " West Bengal and Bihar in the Sunderbans region and especially in the former State of Rewa. Such a tiger has " +
                "the black stripes typical of the Bengal tiger, but carries a white or near-white coat.The white fur caused by " +
                "a lack of the pigment pheomelanin, which is found in Bengal tigers with orange color fur. When compared to " +
                "Bengal tigers, the white Bengal tigers tend to grow faster and heavier than the orange Bengal tiger."));

        animals.add(new Animal("West African Giraffe", giraffe, "The West African giraffe, Niger giraffe" +
                " or Nigerian giraffe (Giraffa camelopardalis peralta) is a subspecies of the giraffe distinguished by its " +
                "light colored spots, which is found in the Sahel regions of West Africa.The West African giraffe survive" +
                " primarily on a diet of leaves from Acacia albida and Hyphaene thebaica as well as Annona senegalensis," +
                " Parinari macrophylla, Piliostigma reticulatum, and Balanites aegyptiaca. It stands between 16 and 19 ft. " +
                "tall, and can weigh up to 2,800 lbs."));

        animals.add(new Animal("African Elephant", elephant, "One species of African elephant, the " +
                "bush elephant, is the largest living terrestrial animal, while the forest elephant is the third-largest. " +
                "Their thickset bodies rest on stocky legs, and they have concave backs. Their large ears enable heat loss." +
                " The upper lip and nose form a trunk. The trunk acts as a fifth limb, a sound amplifier, and an " +
                "important method of touch.males stand 3.2–4.0 m (10–13 ft) tall at the shoulder and weigh 4,700–6,048 kg" +
                " (10,360–13,330 lb), while females stand 2.2–2.6 m (7–9 ft) tall and weigh 2,160–3,232 kg (4,762–7,125 lb)."));
    }
}
