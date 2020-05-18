package com.algaworks.algafood.di.notificacao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("notificador.email")
public class NotificadorProperties {
	
	/**
	 * application.properties >> notificador.email.host-servidor (o - é substituido pelo CammelCase)
	 * 
	 * Em substituição ao: 
	 *		@Value("${notificador.email.host-servidor}")
			private String host;
			
			@Value("${notificador.email.porta-servidor}")
			private Integer porta;
	 * */
	private String hostServidor;     
	private Integer portaServidor = 25; //(se nada for configurado, 25 é a porta padrão)
	
	
	public String getHostServidor() {
		return hostServidor;
	}
	public void setHostServidor(String hostServidor) {
		this.hostServidor = hostServidor;
	}
	public Integer getPortaServidor() {
		return portaServidor;
	}
	public void setPortaServidor(Integer portaServidor) {
		this.portaServidor = portaServidor;
	}

	
	
}
