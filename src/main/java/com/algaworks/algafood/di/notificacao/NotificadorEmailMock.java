package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("dev")
@Qualifier("notificador_email")
@Component 
public class NotificadorEmailMock implements Notificador {
	
	@Autowired
	private NotificadorProperties properties;
	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("[MOCK]: Notificando %s através do e-mail %s, usando SMTP %s:%s : %s\n", 
				cliente.getNome(), cliente.getEmail(),properties.getHostServidor(),properties.getPortaServidor(), mensagem);
	}

	
}
