package grup.DidacSebas.animales.business.model.dtos;

import java.io.Serializable;

public class AnimalDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private int age;

    public AnimalDTO() {
    }

    public AnimalDTO(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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


    @Override
    public String toString() {
        return String.format("AnimalDTO [id=%d, name=%s, age=%d]",
                id, name, age);
    }
}