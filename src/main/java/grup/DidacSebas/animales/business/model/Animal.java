package grup.DidacSebas.animales.business.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class Animal implements Serializable {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private int weight;
    private String species;

    public Animal() {
    }

    public Animal(String name, int age, String gender, int weight, String species, Long id) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.species = species;
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString(){
        return String.format("name=%s, age=%d, gender=%s, weight=%d, species=%s"
                , name, age, gender, weight, species);
    }
}
