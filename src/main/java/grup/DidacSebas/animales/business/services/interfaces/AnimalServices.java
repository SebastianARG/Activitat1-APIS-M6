package grup.DidacSebas.animales.business.services.interfaces;

import grup.DidacSebas.animales.business.model.Animal;

import java.util.Optional;
import java.util.TreeMap;
public interface AnimalServices {
    Optional<Animal> read(Long id);
    Long create(Animal animal);
    void update(Animal animal);
    void delete(Long id);
    TreeMap<Long,Animal> getAll();
}
