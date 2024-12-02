package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepository;
@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente buscarClientePorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public List<Cliente> buscarTodosClientes() {
		return clienteRepository.findAll();
	}

	public void excluirCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
		Optional<Cliente> clienteExistente = clienteRepository.findById(id);
		if (clienteExistente.isPresent()) {
			Cliente Cliente = clienteExistente.get();
			Cliente.setNome(clienteAtualizado.getNome());
			Cliente.setFone(clienteAtualizado.getFone());
			Cliente.setEmail(clienteAtualizado.getEmail());
			return clienteRepository.save(Cliente);
		} else {
			return null;
		}
	}

	public void deletarCliente(Long id) {
		// TODO Auto-generated method stub
		
	}


		
	}