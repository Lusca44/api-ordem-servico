package com.lucas.orderService.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.orderService.domain.Cliente;
import com.lucas.orderService.domain.OrdemServico;
import com.lucas.orderService.domain.Tecnico;
import com.lucas.orderService.domain.enums.Prioridade;
import com.lucas.orderService.domain.enums.Status;
import com.lucas.orderService.dtos.OrdemServicoDTO;
import com.lucas.orderService.repository.OrdemServicoRepository;
import com.lucas.orderService.services.exceptions.ObjectNotFoundException;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository repo;
	
	@Autowired
	private TecnicoService tecnicoService;

	@Autowired
	private ClienteService clienteService;
	
	public OrdemServico findById(Integer id) {
		Optional<OrdemServico> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!"));
	}
	
	public List<OrdemServico> findAll(){
		return repo.findAll();
	}

	public OrdemServico create(@Valid OrdemServicoDTO objDTO) {
		return repo.save(fromDTO(new OrdemServico(), objDTO));
	}
	
	public OrdemServico update(@Valid OrdemServicoDTO objDTO) {
		OrdemServico obj = findById(objDTO.getId());
		OrdemServico newObj = fromDTO(obj, objDTO);
		newObj.setDataAbertura(obj.getDataAbertura());
		
		return repo.save(newObj);
	}
	
	
	private OrdemServico fromDTO(OrdemServico obj, OrdemServicoDTO objDTO) {
		obj.setId(objDTO.getId());
		obj.setObservacoes(objDTO.getObservacoes());
		obj.setPrioridade(Prioridade.toEnum(objDTO.getPrioridade()));
		obj.setStatus(Status.toEnum(objDTO.getStatus()));
		
		Tecnico tecnico = tecnicoService.findById(objDTO.getTecnico());
		Cliente cliente = clienteService.findById(objDTO.getCliente());
		
		obj.setTecnico(tecnico);
		obj.setCliente(cliente);
		
		if(obj.getStatus().getCode().equals(2)) {
			obj.setDataFechamento(LocalDateTime.now());
		}
		return obj;
	}
	
}
