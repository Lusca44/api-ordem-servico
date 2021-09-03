package com.lucas.orderService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.orderService.domain.Cliente;
import com.lucas.orderService.domain.Pessoa;
import com.lucas.orderService.dtos.ClienteDTO;
import com.lucas.orderService.repository.ClienteRepository;
import com.lucas.orderService.repository.PessoaRepository;
import com.lucas.orderService.services.exceptions.DataIntegritiViolationException;
import com.lucas.orderService.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	@Autowired
	private PessoaRepository pessoaRepo;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!"));
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente create(ClienteDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new DataIntegritiViolationException("CPF já cadastrado!!");
		}
		return repo.save(fromDTO(new Cliente(), objDTO));
	}

	private Pessoa findByCPF(ClienteDTO objDTO) {
		Pessoa obj = pessoaRepo.findByCPF(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}
	
	private Cliente fromDTO(Cliente obj, ClienteDTO objDTO) {
		obj.setNome(objDTO.getNome());
		obj.setCpf(objDTO.getCpf());
		obj.setTelefone(objDTO.getTelefone());
		return obj;
	}
	
}
