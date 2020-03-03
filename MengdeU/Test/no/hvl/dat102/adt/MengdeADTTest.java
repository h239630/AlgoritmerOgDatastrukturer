package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;


public abstract class MengdeADTTest {

	// Mengde referanser
	private MengdeADT<String> mengde1;
	private MengdeADT<String> mengde2;
	private MengdeADT<String> mengde3;
	private MengdeADT<String> fasitUnion;
	private MengdeADT<String> fasitSnitt;
	private MengdeADT<String> fasitDiff;

	// Testdata
	private String[] m1 = { "Elle", "melle", "deg", "fortelle" };
	private String[] m2 = { "melle", "g�r", "fortelle", "�r" };
	private String[] m3 = { "skipet", "g�r", "ut", "i", "�r" };
	private String[] fU = { "Elle", "melle", "deg", "fortelle", "skipet", "g�r", "ut", "i", "�r" };
	private String[] fS = { "melle", "fortelle" };
	private String[] fD = { "Elle", "deg" };

	protected abstract MengdeADT<String> nyMengde();

	/*
	 * Oppretter testmengder samt fasitmengder
	 * 
	 * @return
	 */
	@Before
	public final void setup() {
		mengde1 = nyMengde();
		for (String s : m1) {
			mengde1.leggTil(s);
		}
		mengde2 = nyMengde();
		for (String s : m2) {
			mengde2.leggTil(s);
		}
		mengde3 = nyMengde();
		for (String s : m3) {
			mengde3.leggTil(s);
		}
		fasitUnion = nyMengde();
		for (String s : fU) {
			fasitUnion.leggTil(s);
		}
		fasitSnitt = nyMengde();
		for (String s : fS) {
			fasitSnitt.leggTil(s);
		}
		fasitDiff = nyMengde();
		for (String s : fD) {
			fasitDiff.leggTil(s);
		}
	}
	
	/*
	 * Tester operasjonen union p� to mengder
	 */
	@Test
	public final void union() {
		MengdeADT<String> begge = mengde1.union(mengde3);
		assertEquals(begge, fasitUnion);
	}

	/*
	 * Tester operasjonen snitt p� to mengder som ikke er disjunkt
	 */
	@Test
	public final void snitt() {
		MengdeADT<String> snitt = mengde1.snitt(mengde2);
		assertEquals(snitt, fasitSnitt);
	}

	/*
	 * Tester operasjonen snitt p� to disjunkte mengder
	 */
	@Test
	public final void snittDisjunkt() {
		MengdeADT<String> snitt = mengde1.snitt(mengde3);
		assertTrue(snitt.erTom());
	}

	/*
	 * Tester operasjonen differens p� mengder som ikke er disjunkt
	 */
	@Test
	public final void differens() {
		MengdeADT<String> diff = mengde1.differens(mengde2);
		assertEquals(diff, fasitDiff);
	}

	/*
	 * Tester operasjonen differens p� to disjunkte mengder
	 */
	@Test
	public final void differenseDisjunkt() {
		MengdeADT<String> diff = mengde1.differens(mengde3);
		assertEquals(diff, mengde1);
	}

}
