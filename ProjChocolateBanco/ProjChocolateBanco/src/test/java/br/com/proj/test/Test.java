package br.com.proj.test;

import br.com.proj.controller.ChocoDB;
import br.com.proj.model.Choco;
import junit.framework.TestCase;

public class Test extends TestCase {

	public void testInsert() {
		Choco choco = new Choco();
		choco.setNome("Teste");
		choco.setTipo("2345");
		choco.setPorcentcacau(2345);
		
		assertEquals(new ChocoDB().insert(choco), true);
	}

	public void testUpdate() {
		Choco choco = new Choco();
		choco.setCodigo(2);
		choco.setNome("Luiz Gonzaga");
		choco.setTipo("9633");
		assertEquals(new ChocoDB().update(choco), true);
	}

	public void testDelete() {
		Choco choco = new Choco();
		choco.setCodigo(2);
		assertEquals(new ChocoDB().delete(choco), true);
	}

	public void testSelectTo() {
		assertNotNull(new ChocoDB().selectTo(1));
	}
	
	public void testSelectAll() {
		assertNotNull(new ChocoDB().selectAll());
	}

}
