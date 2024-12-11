package grup.DidacSebas.animales.presentation.controllers;


import grup.DidacSebas.animales.business.model.Animal;
import grup.DidacSebas.animales.business.services.interfaces.AnimalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalServices animalServices;


    @GetMapping
    public ResponseEntity<?> getAll(){

        //Ejecutamos el código que llama a gettAll de services
        return ResponseEntity.ok(animalServices.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Animal> opt = animalServices.read(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>("No hay animal",HttpStatus.NOT_FOUND);
        }
        //Ejecutamos el código que llama a read de services
        //return animalServices.read(id);
        return ResponseEntity.ok(opt.get());
    }

    /*
{
    "id": 1,
    "name": "Lion",
    "age": 8,
    "gender": "male",
    "weight": 190,
    "species": "panthera"
},
{
    "id": 2,
    "name": "Elephant",
    "age": 25,
    "gender": "female",
    "weight": 5400,
    "species": "loxodonta"
},
{
    "id": 3,
    "name": "Giraffe",
    "age": 15,
    "gender": "female",
    "weight": 1200,
    "species": "camelopardalis"
},
{
    "id": 4,
    "name": "Kangaroo",
    "age": 7,
    "gender": "male",
    "weight": 85,
    "species": "macropus"
},
{
    "id": 5,
    "name": "Penguin",
    "age": 3,
    "gender": "female",
    "weight": 23,
    "species": "spheniscidae"
}

     */
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Animal animal){
            Long id = animalServices.create(animal);
            if(id!=-1){
                URI uri = UriComponentsBuilder
                        .fromPath("/products/{id}")
                        .buildAndExpand(id)
                        .toUri();
                return ResponseEntity.created(uri).build();
            }
            else{
                return new ResponseEntity<>("No se pudo crear el producto",HttpStatus.CREATED);
            }
        //Ejecutamos el código que llama a create de services
        //return ((animalServices.create(animal) == -1)?false:true);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Animal updatedAnimal) {
        Optional<Animal> opt = animalServices.read(id);
        if (opt.isPresent()) {
            animalServices.update(updatedAnimal);
            return ResponseEntity.ok("Animal actualizado con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal no encontrado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Animal> opt = animalServices.read(id);
        if (opt.isPresent()) {
            animalServices.delete(id);
            return ResponseEntity.ok("Animal eliminado con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal no encontrado.");
        }
    }



}
