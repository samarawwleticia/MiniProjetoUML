package testes;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import controle.ControleProdutos;


/**
 * Espaço de testes do sistema.
 * @author João e Samara
 * @since 2023
 * @version 1.1
 *
 */
 class TestesJUnit {
	 
	 /**
	  * Verifica se o sistema permite cadastrar/editar uma filial com 2 caracteres, 
	  * espaços em branco e apenas números.	 
	  */
	 @Test
	 void testCheckFilial() {
		 
		String nomeErradoFilial1 = "xx";
		String nomeErradoFilial2 = "";
		String nomeErradoFilial3 = " ";
		String nomeErradoFilial4 = "000";
		String nomeCertoFilial = "xxx";
		assertTrue(controle.ControleFilial.checkNome(nomeCertoFilial));
		assertFalse(controle.ControleFilial.checkNome(nomeErradoFilial1));
		assertFalse(controle.ControleFilial.checkNome(nomeErradoFilial2));
		assertFalse(controle.ControleFilial.checkNome(nomeErradoFilial3));
		assertFalse(controle.ControleFilial.checkNome(nomeErradoFilial4));
	 }
	 
	 /**
	  * Testa se é possível cadastrar mais produtos que o limite máximo.
	  */
	 
	 @Test
	 void testeCadastroItem() {
		 int produtosAdicionadosAceitaveis = 100;
		 int produtosAdicionadosInaceitaveis = 101;
		 
		assertTrue(ControleProdutos.cadastrarProduto(produtosAdicionadosAceitaveis));
		assertFalse(ControleProdutos.cadastrarProduto(produtosAdicionadosInaceitaveis));
	 }
	 
	 /**
	  * Testa se é possível excluir os diversos itens de uma filial 
	  * após preencher o número máximo de produtos.
	  */
	 
	 @Test
	 void testeExclusaoItem() {
		 int produtosAdicionadosAceitaveis = 100;
		 int produtosAdicionadosInaceitaveis = 101;
		 
		assertTrue(ControleProdutos.deletarProduto(produtosAdicionadosAceitaveis));
		assertFalse(ControleProdutos.deletarProduto(produtosAdicionadosInaceitaveis));
	 }
	 
	 
}