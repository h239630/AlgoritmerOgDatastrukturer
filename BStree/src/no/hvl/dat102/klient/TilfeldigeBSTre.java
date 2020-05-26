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
		
		//Løkke for å lage 100 tilfeldige trær
		for (int j = 0; j <= 100; j++) {
			bstre = new KjedetBSTre<Integer>();
			
			//Løkke for å fylle treet med 1024 tilfeldige verdier
			for (int i = 0; i <= noder; i++) {
				bstre.leggTil(tall.nextInt(10000)); 
			}
			
			h = bstre.hoyde();
			
			//Tester for størte og minste høyde
			if (h < min) {
				min = h; 
			} else if (h > maks) {
				maks = h; 
			}
			//Legger til i gjennomsnittet
			snitt += h;
		}
		snitt = snitt / 100; 
		
		System.out.println("Antall noder i trærene: " + noder);
		System.out.println("\nTeoretiske høyder\nMin: " + teoretiskMin + "\nMaks: " + teoretiskMaks);
		System.out.println("\nReelle høyder etter kjøring av 100 tilfeldige trær \nMinste: " + min + "\nStørste: " + maks + "\nGjennomsnitt: " + snitt);
		
	}

}
