package no.hvl.dat102.KlientKjedet;

import no.hvl.dat102.Fil;
import no.hvl.dat102.Kjedet.FilmarkivKjedet;
import no.hvl.dat102.ADT.FilmarkivADT;

public class KlientFilmarkivKjedet {
	
	public static void main(String[] args) {
		
		//Legg inn korrekt filbane her for at skriving til fil skal fungere
		String fil = "C:\\DAT102\\AlgoritmerOgDatastrukturer\\Øving1\\src\\no\\hvl\\dat102\\KlientKjedet\\filmarkiv.txt";
		FilmarkivADT filma = new FilmarkivKjedet(0);
		Fil.lesFraFil(filma, fil);
		Meny meny = new Meny(filma);
		meny.start(); 
		Fil.skrivTilFil(filma, fil);
	}

}
