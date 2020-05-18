package com.algaworks.algafood.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.service.ClienteAtivadoEvent;

@Component
public class NotificacaoService {
	
	@Autowired
	private List<Notificador> notificadores;
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		Cliente cliente = event.getCliente();
		
		System.out.println("[notificação]: Cliente "+cliente.getNome() + " está ativo!");
		
		for(Notificador notificador : notificadores) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		}
	}

}
