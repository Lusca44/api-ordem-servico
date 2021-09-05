package com.lucas.orderService.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente updateObj = findById(id);
		if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegritiViolationException("CPF Já cadastrado!!");
		}
		fromDTO(updateObj, objDTO);
		return repo.save(updateObj);
	}

	public void deleteById(Integer id) {
		Cliente obj = findById(id);
		if(obj.getOrdemServico().size() > 0) {
			throw new DataIntegritiViolationException("O cliente não pode ser excluido enquanto estiver ligado a ordens de serviço");
		}
		repo.deleteById(id);
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
