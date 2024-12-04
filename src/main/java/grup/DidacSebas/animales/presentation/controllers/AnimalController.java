package grup.DidacSebas.animales.presentation.controllers;


import grup.DidacSebas.animales.business.model.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController
@RequestMapping("/animals")
public class AnimalController {


    @GetMapping
    public TreeMap<String, Animal> getAll(){
        //Ejecutamos el código que llama a gettAll de services
        return null;
    }
    @GetMapping("/{id}")
    public Animal getById(@PathVariable Long id){
        return null;
    }
    @PostMapping
    public boolean add(@RequestBody Animal animal){
        return false;
    }
    @PutMapping("/{id}")
    public boolean update(@RequestBody Animal animal){
        return false;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return false;
    }


}
