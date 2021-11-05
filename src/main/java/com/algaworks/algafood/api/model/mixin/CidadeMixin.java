package com.algaworks.algafood.api.model.mixin;

import com.algaworks.algafood.domain.model.Estado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Classe Mixin serve para separar regras de representação do model do projeto. 
 * Como o uso do jackson para representação da saída, por exemplo.
 * Nesta classe premanecem apenas as anotações das representações
 * */
public class CidadeMixin {

	@JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Estado estado;

}
