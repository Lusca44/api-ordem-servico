package com.lucas.orderService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.orderService.domain.OrdemServico;
import com.lucas.orderService.repository.OrdemServicoRepository;
import com.lucas.orderService.services.exceptions.ObjectNotFoundException;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository repo;
	
	public OrdemServico findById(Integer id) {
		Optional<OrdemServico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!"));
	}
	
	public List<OrdemServico> findAll(){
		return repo.findAll();
	}
	
	
}
