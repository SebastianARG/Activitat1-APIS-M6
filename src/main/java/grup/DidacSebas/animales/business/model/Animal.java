package grup.DidacSebas.animales.business.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class Animal implements Serializable {
    @Setter(AccessLevel.NONE)//No tiene setter
    private Long id;
    private String name;
    private int age;
    private String gender;
    private int weight;
    private String species;

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
