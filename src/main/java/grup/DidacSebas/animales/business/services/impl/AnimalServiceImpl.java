package grup.DidacSebas.animales.business.services.impl;

import grup.DidacSebas.animales.business.exceptions.AnimalException;
import grup.DidacSebas.animales.business.model.dtos.AnimalDTO;
import grup.DidacSebas.animales.business.model.jpa.Animal;
import grup.DidacSebas.animales.business.services.interfaces.AnimalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grup.DidacSebas.animales.business.integracion.AnimalRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalServices {

    @Autowired
    private AnimalRepository _animalRepository;

    @Override
    public List<Animal> getAll() {return _animalRepository.findAll();}

    @Override
    public Optional<Animal> read(Long id) {
        return _animalRepository.findById(id);
    }

    @Override
    public Long create(Animal animal) {
        if (animal == null) return -1L;
        Animal savedAnimal = _animalRepository.save(animal);
        return savedAnimal.getId();
    }

    @Override
    public void update(Animal animal) {
        if (animal == null || animal.getId() == null || !_animalRepository.existsById(animal.getId())) {
            return; // Validar que exista el animal para actualizar
        }
        _animalRepository.save(animal);
    }

    @Override
    public void delete(Long id) {
        if (id == null || id <= 0) {
            throw new AnimalException("El id no es valido");
        }
        _animalRepository.deleteById(id);
    }
}
