package no.hvl.dat102.klient;

import java.util.Random;

import no.hvl.dat102.KjedetBSTre;

public class TilfeldigeBSTre {
	
	
	
	public static void main(String[] args) {
		KjedetBSTre<Integer> bstre;
		
		Random tall = new Random(); 
		
		int noder = 8192; 
		
		int teoretiskMaks = noder - 1; 
		
		double teoretiskMin = Math.log(noder);
		
		int  min = teoretiskMaks, maks = 0, snitt = 0, h; 
		
		//L�kke for � lage 100 tilfeldige tr�r
		for (int j = 0; j <= 100; j++) {
			bstre = new KjedetBSTre<Integer>();
			
			//L�kke for � fylle treet med 1024 tilfeldige verdier
			for (int i = 0; i <= noder; i++) {
				bstre.leggTil(tall.nextInt(10000)); 
			}
			
			h = bstre.hoyde();
			
			//Tester for st�rte og minste h�yde
			if (h < min) {
				min = h; 
			} else if (h > maks) {
				maks = h; 
			}
			//Legger til i gjennomsnittet
			snitt += h;
		}
		snitt = snitt / 100; 
		
		System.out.println("Antall noder i tr�rene: " + noder);
		System.out.println("\nTeoretiske h�yder\nMin: " + teoretiskMin + "\nMaks: " + teoretiskMaks);
		System.out.println("\nReelle h�yder etter kj�ring av 100 tilfeldige tr�r \nMinste: " + min + "\nSt�rste: " + maks + "\nGjennomsnitt: " + snitt);
		
	}

}
