package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.model.CozinhasXmlWrapper;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("cozinha")
@RestController
@RequestMapping(value = "/cozinhas", produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
public class CozinhaController {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cozinha> listar() {
		return cadastroCozinha.listar();
	}
	
	@GetMapping(produces =  MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml() {
		return new CozinhasXmlWrapper(cadastroCozinha.listar());
	}
	
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long cozinhaId) {
		Optional<Cozinha> cozinha = cadastroCozinha.buscar(cozinhaId);
		
		
		if(cozinha.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(cozinha.get());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cadastroCozinha.salvar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,	@RequestBody Cozinha cozinha) {
		Optional<Cozinha> cozinhaAtual = cadastroCozinha.buscar(cozinhaId);
		
		if (cozinhaAtual.isPresent()) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id"); //ignora a copia da prop id
			
			Cozinha cozinhaSalva = cadastroCozinha.salvar(cozinhaAtual.get());
			return ResponseEntity.ok(cozinhaSalva);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<?> remover(@PathVariable Long cozinhaId) {
		try {
			cadastroCozinha.excluir(cozinhaId);
			return ResponseEntity.noContent().build();
				
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}				
	}
}


