package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Pet;
import com.example.demo.services.PetService;

@RestController
@RequestMapping("/Pet")
public class PetController {

	private final PetService petService;

	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}

	@PostMapping
	public Pet criarPet(@RequestBody Pet pet) {
		return petService.salvarPet(pet);
	}

	@GetMapping
	public List<Pet> buscarTodos() {
		return petService.buscarTodosPets();
	}

	@GetMapping("/{id}")
	public Pet buscarPorId(@PathVariable Long id) {
		return petService.buscarPetPorId(id);
	}

	@DeleteMapping("/{id}")
	public void deletarpet(@PathVariable Long id) {
		PetService.deletarPet(id);
	}

	@PutMapping
	public ResponseEntity<Pet> atualizarpet(@PathVariable Long id, @RequestBody Pet usuario) {
		Pet petAtualizado = petService.atualizarPet(id, usuario);
		if (petAtualizado != null) {
			return ResponseEntity.ok(petAtualizado);
		} else {
			return null;
		}

	}
}
