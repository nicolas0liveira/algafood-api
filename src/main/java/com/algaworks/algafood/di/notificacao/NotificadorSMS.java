package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;


@Qualifier("notificador_sms")
@Component
public class NotificadorSMS implements Notificador {
	
	private boolean caixaAlta;
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		if(caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		System.out.printf("Notificando %s por SMS ao numero %s: %s\n", 
				cliente.getNome(), cliente.getTelefone(), mensagem);
	}


	public boolean isCaixaAlta() {
		return caixaAlta;
	}


	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
	
}
