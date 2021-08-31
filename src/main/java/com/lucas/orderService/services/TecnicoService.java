package com.lucas.orderService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.orderService.domain.Tecnico;
import com.lucas.orderService.dtos.TecnicoDTO;
import com.lucas.orderService.repository.TecnicoRepository;
import com.lucas.orderService.services.exceptions.DataIntegritiViolationException;
import com.lucas.orderService.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	TecnicoRepository repo;
	
	public Tecnico findById(Integer id) {
		 Optional<Tecnico> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!"));
	}
	
	public List<Tecnico> findAll() {
		List<Tecnico> list = repo.findAll();
		return list;
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new DataIntegritiViolationException("CPF já cadastrado!");
		}
		return repo.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}
	
	
	private Tecnico findByCPF(TecnicoDTO objDTO) {
		Tecnico obj = repo.findByCPF(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}
}
