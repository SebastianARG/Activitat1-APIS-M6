package grup.DidacSebas.animales.presentation.controllers;

import grup.DidacSebas.animales.business.model.AnimalMapper;
import grup.DidacSebas.animales.business.model.dtos.AnimalDTO;
import grup.DidacSebas.animales.business.model.jpa.Animal;
import grup.DidacSebas.animales.business.services.interfaces.AnimalServices;
import grup.DidacSebas.animales.presentation.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Animales API", description = "Operaciones para gestionar animales")
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalServices animalServices;

    @Operation(summary = "Obtener todos los animales", description = "Este endpoint retorna la información de todos los animales")
    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAll() {
        List<Animal> all = animalServices.getAll();
        List<AnimalDTO> dtoList = all.stream().map(AnimalMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @Operation(summary = "Obtener información de un animal por ID", description = "Este endpoint retorna la información de un animal específico mediante su ID")
    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> getById(
            @Parameter(description = "ID del animal", required = true) @PathVariable Long id) {
        Animal animal = animalServices.read(id).orElseThrow(() ->
                new ResourceNotFoundException("Animal con ID " + id + " no encontrado."));
        return ResponseEntity.ok(AnimalMapper.toDTO(animal));
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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo crear el animal");
        }
    }

    @Operation(summary = "Actualizar un animal existente", description = "Este endpoint actualiza la información de un animal específico")
    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @Parameter(description = "ID del animal a actualizar", required = true) @PathVariable Long id,
            @Parameter(description = "Datos actualizados del animal", required = true) @RequestBody Animal updatedAnimal) {
        animalServices.read(id).orElseThrow(() ->
                new ResourceNotFoundException("Animal con ID " + id + " no encontrado."));
        animalServices.update(updatedAnimal);
        return ResponseEntity.ok("Animal actualizado con éxito.");
    }

    @Operation(summary = "Eliminar un animal", description = "Este endpoint elimina un animal específico mediante su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @Parameter(description = "ID del animal a eliminar", required = true) @PathVariable Long id) {
        animalServices.read(id).orElseThrow(() ->
                new ResourceNotFoundException("Animal con ID " + id + " no encontrado."));
        animalServices.delete(id);
        return ResponseEntity.ok("Animal eliminado con éxito.");
    }
}
