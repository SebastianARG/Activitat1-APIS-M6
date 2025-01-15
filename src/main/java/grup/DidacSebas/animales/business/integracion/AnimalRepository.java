package grup.DidacSebas.animales.business.integracion;

import grup.DidacSebas.animales.business.model.jpa.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Override
    List<Animal> findAll();

    @Override
    Optional<Animal> findById(Long id);

    @Override
    Animal save(Animal animal);

    @Override
    void delete(Animal animal);


}
