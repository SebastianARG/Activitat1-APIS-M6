package grup.DidacSebas.animales.business.model;

import grup.DidacSebas.animales.business.model.dtos.AnimalDTO;
import grup.DidacSebas.animales.business.model.jpa.Animal;

public class AnimalMapper {
        public static AnimalDTO toDTO(Animal animal) {
            return new AnimalDTO(animal.getId(), animal.getName(), animal.getAge());
        }
}
