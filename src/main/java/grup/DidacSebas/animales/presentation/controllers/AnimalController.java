package grup.DidacSebas.animales.presentation.controllers;

import grup.DidacSebas.animales.business.model.Animal;
import grup.DidacSebas.animales.business.services.interfaces.AnimalServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Tag(name = "Animales API", description = "Operaciones para gestionar animales")
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalServices animalServices;

    @Operation(summary = "Obtener todos los animales", description = "Este endpoint retorna la información de todos los animales")
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(animalServices.getAll());
    }

    @Operation(summary = "Obtener información de un animal por ID", description = "Este endpoint retorna la información de un animal específico mediante su ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @Parameter(description = "ID del animal", required = true) @PathVariable Long id) {
        Optional<Animal> opt = animalServices.read(id);
        if (!opt.isPresent()) {
            return new ResponseEntity<>("No hay animal", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(opt.get());
    }

    @Operation(summary = "Añadir un nuevo animal", description = "Este endpoint permite añadir un nuevo animal")
    @PostMapping
    public ResponseEntity<?> add(
            @Parameter(description = "Datos del animal a añadir", required = true) @RequestBody Animal animal) {
        Long id = animalServices.create(animal);
        if (id != -1) {
            URI uri = UriComponentsBuilder.fromPath("/animals/{id}")
                    .buildAndExpand(id)
                    .toUri();
            return ResponseEntity.created(uri).build();
        } else {
            return new ResponseEntity<>("No se pudo crear el animal", HttpStatus.CREATED);
        }
    }

    @Operation(summary = "Actualizar un animal existente", description = "Este endpoint actualiza la información de un animal específico")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @Parameter(description = "ID del animal a actualizar", required = true) @PathVariable Long id,
            @Parameter(description = "Datos actualizados del animal", required = true) @RequestBody Animal updatedAnimal) {
        Optional<Animal> opt = animalServices.read(id);
        if (opt.isPresent()) {
            animalServices.update(updatedAnimal);
            return ResponseEntity.ok("Animal actualizado con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal no encontrado.");
        }
    }

    @Operation(summary = "Eliminar un animal", description = "Este endpoint elimina un animal específico mediante su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @Parameter(description = "ID del animal a eliminar", required = true) @PathVariable Long id) {
        Optional<Animal> opt = animalServices.read(id);
        if (opt.isPresent()) {
            animalServices.delete(id);
            return ResponseEntity.ok("Animal eliminado con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal no encontrado.");
        }
    }
}
