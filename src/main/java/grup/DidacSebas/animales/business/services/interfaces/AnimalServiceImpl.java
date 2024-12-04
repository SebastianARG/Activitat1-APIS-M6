package grup.DidacSebas.animales.business.services.interfaces;

import grup.DidacSebas.animales.business.model.Animal;
import grup.DidacSebas.animales.business.services.impl.AnimalServices;

import java.util.List;
import java.util.Optional;

public class AnimalServiceImpl implements AnimalServices {
    @Override
    public Optional<Animal> read(Long id) {
        return Optional.empty();
    }

    @Override
    public Long create(Animal animal) {
        return 0L;
    }

    @Override
    public void update(Animal animal) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Animal> readAll() {
        return List.of();
    }
}
