package no.hvl.dat102.Klient;

import no.hvl.dat102.Fil;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.ADT.FilmarkivADT;

public class KlientFilmarkiv {
	
	public static void main(String[] args) {
		FilmarkivADT filma = new Filmarkiv(10);
		//Legg inn korrekt filbane her for at skriving til fil skal fungere
		String fil = "C:\\DAT102\\AlgoritmerOgDatastrukturer\\Øving1\\src\\no\\hvl\\dat102\\Klient\\filmarkiv.txt";
		Fil.lesFraFil(filma, fil);
		Meny meny = new Meny(filma);
		meny.start(); 
		Fil.skrivTilFil(filma, fil);
	}

}
