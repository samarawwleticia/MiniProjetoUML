package testes;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Espaço de testes do sistema.
 * @author João e Samara
 * @since 2023
 * @version 1.1
 *
 */
 class ExemploJUnit {
	 
	 /**
	  * Verifica se o sistema permite cadastrar/editar uma filial com 2 caracteres.	 
	  */
	 @Test
	 void testCheckFilial() {
		 
		 
		String nomeErradoFilial = "xx";
		String nomeCertoFilial = "xxx";
		assertTrue(controle.ControleFilial.checkNome(nomeCertoFilial));
		assertFalse(controle.ControleFilial.checkNome(nomeErradoFilial));
	 }
	 /**
	  * Verifica se o sistema permite cadastrar/editar uma filial sem caracteres.
	  */
	 void testCheckFilial2() {
		 
		 String nomeErradoFilial = "";
		 String nomeCertoFilial = "xxx";
		 assertTrue(controle.ControleFilial.checkNome(nomeCertoFilial));
		 assertFalse(controle.ControleFilial.checkNome(nomeErradoFilial));
	 }
	 
	 /**
	  * Verifica se o sistema permite cadastrar/editar uma filial com espaço em branco como 
	  * caractere.
	  */
	 void testCheckFilial3() {
		 
		 String nomeErradoFilial = " ";
		 String nomeCertoFilial = "xxx";
		 
		 assertTrue(controle.ControleFilial.checkNome(nomeCertoFilial));
		 assertFalse(controle.ControleFilial.checkNome(nomeErradoFilial));
		 
	 }
	 /**
	  * Verifica se o sistema permite cadastrar/editar uma filial com apenas numeros
	  * como caracteres.
	  */
	 void testCheckFilial4() {
		 String nomeErradoFilial = "000";
		 String nomeCertoFilial = "xx0";
		 
		 assertTrue(controle.ControleFilial.checkNome(nomeCertoFilial));
		 assertFalse(controle.ControleFilial.checkNome(nomeErradoFilial));
	 }
	 
}