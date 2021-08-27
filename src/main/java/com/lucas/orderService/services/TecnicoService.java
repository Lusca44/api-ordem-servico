package com.lucas.orderService.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.orderService.domain.Tecnico;
import com.lucas.orderService.repository.TecnicoRepository;

import com.lucas.orderService.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	TecnicoRepository repo;
	
	public Tecnico findById(Integer id) {
		 Optional<Tecnico> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!"));
	}
	
}
