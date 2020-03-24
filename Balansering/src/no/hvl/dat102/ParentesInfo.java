package no.hvl.dat102;

public class ParentesInfo {

	private int linjenr;
	private int posisjon;
	private char venstreparentes;

	public ParentesInfo() {
		linjenr = -1;
		posisjon = -1;
		venstreparentes = ')';
	}

	public void setLinjenr(int nyttLinjenr) {
		linjenr = nyttLinjenr;
	}

	public void setPosisjon(int nyPosisjon) {
		posisjon = nyPosisjon;

	}

	public void setVenstreparentes(char nyVenstreparentes) {
		venstreparentes = nyVenstreparentes;
	}

	public int getLinjenr() {
		return linjenr;
	}

	public int getPosisjon() {
		return posisjon;
	}

	public char getVenstreparentes() {
		return venstreparentes;
	}

}// class
