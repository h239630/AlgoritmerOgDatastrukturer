package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.exception.*;

public abstract class MengdeADTTest {

	// Mengde referanse
	private MengdeADT<String> mengde1;
	private MengdeADT<String> mengde2;
	private MengdeADT<String> fasitUnion;
	private MengdeADT<String> fasitSnitt;
	private MengdeADT<String> fasitDiff;

	// Testdata
	private String[] m1 = { "Elle", "melle", "deg", "fortelle" };
	private String[] m2 = { "melle", "går", "fortelle", "år" };
	private String[] fU = { "Elle", "melle", "deg", "fortelle", "melle", "går", "fortelle", "år" };
	private String[] fS = { "melle", "fortelle" };
	private String[] fD = { "Elle", "deg"};

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

	@Test
	public final void fjernElement() {
		for (String s : m1) {
			mengde1.leggTil(s);
		}
		mengde1.fjern("melle");
		assertFalse(mengde1.inneholder("melle"));
	}

	@Test
	public final void union() {
		MengdeADT<String> begge = mengde1.union(mengde2);

		assertTrue(begge.equals(fasitUnion));
	}

	@Test
	public final void snitt() {
		MengdeADT<String> snitt = mengde1.snitt(mengde2);

		assertTrue(snitt.equals(fasitSnitt));
	}

	@Test
	public final void diff() {
		MengdeADT<String> diff = mengde1.differens(mengde2);

		assertTrue(diff.equals(fasitDiff));

	}
}
