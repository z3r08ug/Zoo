package dev.uublabs.zoo;

/**
 * Created by Admin on 11/14/2017.
 */

public class Animal
{
    String name;
    String type;

    public Animal(String name)
    {
        this.name = name;
    }

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
