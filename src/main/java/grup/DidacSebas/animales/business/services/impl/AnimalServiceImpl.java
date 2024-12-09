package grup.DidacSebas.animales.business.services.impl;

import grup.DidacSebas.animales.business.model.Animal;
import grup.DidacSebas.animales.business.services.interfaces.AnimalServices;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.TreeMap;

@Service
public class AnimalServiceImpl implements AnimalServices {
    private TreeMap<Long,Animal> animals = new TreeMap<>();
    private Long currentId = 1L; // Para generar IDs

    @Override
    public TreeMap<Long, Animal> getAll() {
        return animals;
    }

    @Override
    public Optional<Animal> read(Long id) {
        return Optional.empty();
    }


    //SI NO LO CREA DEVUELVE -1
    @Override
    public Long create(Animal animal) {
        if (animal == null) return -1L;
        animal.setId(currentId++);
        animals.put(animal.getId(), animal);
        return animal.getId();
        //LO CREAMOS Y DEVOLVEMOS EL "ID" DE LA SOLICITUD, SI NO SE CREA ES -1

        //return 0L;
    }

    @Override
    public void update(Animal animal) {
        //SE ACTUALIZA CON LA NUEVA INFO A PARTIR DEL NUEVO ANIMAL
        if (animal == null || !animals.containsKey(animal.getId())) return;
        animals.put(animal.getId(), animal);
    }

    @Override
    public void delete(Long id) {
        //SE BORRA EL ANIMAL
        if (id <= 0 || !animals.containsKey(id)) return;
        animals.remove(id);
    }

}
