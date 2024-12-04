package grup.DidacSebas.animales.business.services.impl;

import grup.DidacSebas.animales.business.model.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalServices {
    Optional<Animal> read(Long id);
    Long create(Animal animal);
    void update(Animal animal);
    void delete(Long id);
    List<Animal> readAll();
}
