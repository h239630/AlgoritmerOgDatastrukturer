package no.hvl.dat102.adt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.*;

/* 
 * Test for KoeADT
 * 
 * @author Mikael Lindebrekke
 */
public abstract class KoeADTTest {
	
	// K� referanse
	private KoeADT<Integer> koe; 
	
	// Testdata
	private Integer td0 = 1;
	private Integer td1 = 2;
	private Integer td2 = 3;
	private Integer td3 = 4;
	private Integer td4 = 5;

	protected abstract KoeADT<Integer> reset(); 
	/*
	 * Hent en ny k� for hver test.
	 * @return
	 */
	@Before
	public final void setup() {
		koe = reset(); 
	}
	
	//Test p� at en koe er tom
	@Test
	public final void nyKoeErTom() {
		assertTrue(koe.erTom());
	}
	
	//Test p� � legge til element i k�
	@Test
	public final void leggTilElementIKoe() {
		koe.innKoe(td0);
		try {
			assertEquals(td0, koe.foerste());
		} catch (EmptyCollectionException e) {
			fail("Fikk ikke lagt til element" + e.getMessage());
		}
	}
	
	// Test p� at man kan fjerne fra k�en
	@Test
	public final void taUtAvKoe() {
		koe.innKoe(td0);
		koe.innKoe(td1);
		koe.innKoe(td2);
		try {
			assertEquals(td0, koe.utKoe());
			assertEquals(td1, koe.utKoe());
			assertEquals(td2, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("Fikk ikke tatt ut element" + e.getMessage());
		}
	}
	
	//Test p� at man kan ta ut f�rste element
	@Test
	public final void foerste() {
		koe.innKoe(td0);
		assertEquals(td0, koe.foerste());
	}
	
	//Teste at en k� ikke er tom
	@Test
	public final void erIkkeTom() {
		koe.innKoe(td0);
		koe.innKoe(td1);
		koe.innKoe(td2);
		assertFalse(koe.erTom()); 	
	}
	//Test av antall i k�
	@Test
	public final void antallIKoe() {
		koe.innKoe(td0);
		koe.innKoe(td1);
		koe.innKoe(td2);
		assertEquals(3, koe.antall());
	}
	
	
	
	
	
}
