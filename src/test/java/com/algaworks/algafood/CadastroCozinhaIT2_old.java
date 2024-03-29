package com.algaworks.algafood;
//package com.algaworks.algafood;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import javax.validation.ConstraintViolationException;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
//import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
//import com.algaworks.algafood.domain.model.Cozinha;
//import com.algaworks.algafood.domain.service.CadastroCozinhaService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CadastroCozinhaIT { 
////IT significa integration Test. Essas classes representam testes de intergação e devem ser executados pelo plugin Maven FailSafe
////para executar: ./mvnw verify (não mais o ./mvnw test)
//	@Autowired
//	private CadastroCozinhaService cadastroCozinha;
//	
//	@Test
//	public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
//		// cenário
//		Cozinha novaCozinha = new Cozinha();
//		novaCozinha.setNome("Chinesa");
//		
//		// ação
//		novaCozinha = cadastroCozinha.salvar(novaCozinha);
//		
//		// validação
//		assertThat(novaCozinha).isNotNull();
//		assertThat(novaCozinha.getId()).isNotNull();
//	}
//	
//	@Test(expected = ConstraintViolationException.class)
//	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
//		Cozinha novaCozinha = new Cozinha();
//		novaCozinha.setNome(null);
//		
//		novaCozinha = cadastroCozinha.salvar(novaCozinha);
//	}
//	
//	@Test(expected = EntidadeEmUsoException.class)
//	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
//		cadastroCozinha.excluir(1L);
//	}
//
//	@Test(expected = CozinhaNaoEncontradaException.class)
//	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
//		cadastroCozinha.excluir(100L);
//	}
//
//}