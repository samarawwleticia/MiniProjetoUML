package testes;

import controle.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

 class TestesJUnit {
	 
	 @Test
	 void testeCadastroItem() {
		 int produtosAdicionadosAceitaveis = 99;
		 int produtosAdicionadosInaceitaveis = 101;
		 
		assertTrue(ControleProdutos.cadastrarProduto(produtosAdicionadosAceitaveis));
		assertFalse(ControleProdutos.cadastrarProduto(produtosAdicionadosInaceitaveis));
	 }
	 
	 @Test
	 void testeExclusaoItem() {
		 int produtosAdicionadosAceitaveis = 99;
		 int produtosAdicionadosInaceitaveis = 101;
		 
		assertTrue(ControleProdutos.cadastrarProduto(produtosAdicionadosAceitaveis));
		assertFalse(ControleProdutos.cadastrarProduto(produtosAdicionadosInaceitaveis));
	 }
	 
	 
} 