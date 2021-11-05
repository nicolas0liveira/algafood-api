package com.algaworks.algafood.api.model.mixin;

import java.util.ArrayList;
import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A Classe Mixin serve para separar regras de representação do model do projeto. 
 * Como o uso do jackson para representação da saída, por exemplo.
 * Nesta classe premanecem apenas as anotações das representações
 * */
public class CozinhaMixin {

	@JsonIgnore
	private List<Restaurante> restaurantes = new ArrayList<>();


}
