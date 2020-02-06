package no.hvl.dat102.Klient;

import no.hvl.dat102.Fil;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.ADT.FilmarkivADT;

public class KlientFilmarkiv {
	
	public static void main(String[] args) {
		FilmarkivADT filma = new Filmarkiv(1);
		String fil = "C:\\DAT102\\Øving1\\src\\no\\hvl\\dat102\\filmarkiv.txt";
		Fil.lesFraFil(filma, fil);
		Meny meny = new Meny(filma);
		meny.start(); 
		Fil.skrivTilFil(filma, fil);
	}

}
