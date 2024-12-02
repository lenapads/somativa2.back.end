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

import com.example.demo.entities.Cliente;

import com.example.demo.services.ClienteService;


@RestController
@RequestMapping("/Cliente")
public class ClienteController {

	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public Cliente criarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}

	@GetMapping
	public List<Cliente> buscarTodos() {
		return clienteService.buscarTodosClientes();
	}

	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable Long id) {
		return clienteService.buscarClientePorId(id);
	}

	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
	}

	@PutMapping
	public ResponseEntity<Cliente> atualizarcliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
		if (clienteAtualizado != null) {
			return ResponseEntity.ok(clienteAtualizado);
		} else {
			return null;
		}

	}
}
