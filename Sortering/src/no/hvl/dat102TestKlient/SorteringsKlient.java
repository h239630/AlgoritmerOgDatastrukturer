package no.hvl.dat102TestKlient;

import no.hvl.dat102.Sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class SorteringsKlient {

	// Metode for å fylle en tabell med tilfeldige tall som kan sorteres.
	public static void fyllTabell(Integer[] tabell) {
		Random ran = new Random(10000);
		for (int i = 0; i < tabell.length; i++) {
			tabell[i] = ran.nextInt(1000);
		}
	}

	public static void skrivUt(Integer[] tabell) {
		for (int i = 0; i < tabell.length; i++) {
			System.out.print(tabell[i] + " ");
		}
		System.out.println("\n------------------------");
	}
	
	public static void fellesTest(Integer[] data) {
		Instant start;
		Instant finish;
		long timeMillis;
		int i = 0;
		boolean ferdig = false;
		while (i <= 5 && !ferdig){
			System.out.println("Sortering ved " + data.length + " verdier");
			switch (i) {
			case 0:
				start = Instant.now();
				fyllTabell(data);
				Sort.byInsertion(data);
				finish = Instant.now();
				timeMillis = Duration.between(start, finish).toMillis();
				System.out.println("Innsetning bruker " + timeMillis + " millisekund");
				i++;
			case 1:
				start = Instant.now();
				fyllTabell(data);
				Sort.bySelection(data);
				finish = Instant.now();
				timeMillis = Duration.between(start, finish).toMillis();
				System.out.println("Utvalg bruker " + timeMillis + " millisekund");
				i++;
			case 2:
				start = Instant.now();
				fyllTabell(data);
				Sort.byBubble(data);
				finish = Instant.now();
				timeMillis = Duration.between(start, finish).toMillis();
				System.out.println("Boblesortering bruker " + timeMillis + " millisekund");
				i++;
			case 3:
				start = Instant.now();
				fyllTabell(data);
				Sort.byQuick(data);
				finish = Instant.now();
				timeMillis = Duration.between(start, finish).toMillis();
				System.out.println("Kvikksortering bruker " + timeMillis + " millisekund");
				i++;
			case 4:
				start = Instant.now();
				fyllTabell(data);
				Sort.byMerge(data);
				finish = Instant.now();
				timeMillis = Duration.between(start, finish).toMillis();
				System.out.println("Flettesortering bruker " + timeMillis + " millisekund");
				i++;
			//Radix fungerer ikke med tilfeldig antall verdier
//			case 5:
//				start = Instant.now();
//				fyllTabell(data);
//				Sort.byRadix(data);
//				finish = Instant.now();
//				timeMillis = Duration.between(start, finish).toMillis();
//				System.out.println("Radix sortering bruker " + timeMillis + " millisekund");
			default: 
				ferdig = true; 
				System.out.println("Sortering ferdig");

			}
		}
	}

	public static void main(String[] args) {
		// Oppretter og fyller tabellen som skal sorteres
//		int a1 = 32000;
//		Integer[] data = new Integer[a1];
//		fyllTabell(data);
//		fellesTest(data);
//		
//		int a2 = 64000;
//		Integer[] data2 = new Integer[a2];
//		fyllTabell(data2); 
//		fellesTest(data2);
//		
//		int a3 = 128000; 
//		Integer[] data3 = new Integer[a3];
//		fyllTabell(data3);
//		fellesTest(data3);
		
		
		//Setup
		Random tilfeldig = new Random(); 
		int n = 128000;
		int antall = 10; 
		Instant start;
		Instant finish;
		long timeMillis = 0;
		long total = 0;
		Integer[][] data = new Integer[antall][n];
		
		//Filling the data set
		for (int i = 0; i < antall; i ++) {
			for (int j = 0; j < n; j++) {
				data[i][j] = tilfeldig.nextInt();
			}
		}
		
		//Running the sorting and measuring time taken
		for (int i = 0; i < antall; i++) {
			start = Instant.now();
			Sort.byMerge(data[i]);
			finish = Instant.now();
			timeMillis = Duration.between(start, finish).toMillis();
			System.out.println(timeMillis);
			total += timeMillis; 
		}
		
		long snittTid = total / antall;
		System.out.println("SnittTid = "+snittTid);
		
		

//		System.out.println("Usortert: ");
//		skrivUt(data);
	
//		Instant start = Instant.now();
//		
//		//Sort.byInsertion(data);
//		
//		//Sort.bySelection(data);
//		
//		//Sort.byBubble(data);
//		
//		//Sort.byQuick(data);
//		
//		//Sort.byMerge(data);
//		
//		//Sort.byRadix(data);
//		
//		Instant finish = Instant.now();
//		long timeMillis = Duration.between(start, finish).toMillis(); 
//		double timeSeconds = timeMillis / 1000.0;
//		
//		System.out.println("En tabell med " + antall + " verdier");
//		System.out.println("Bruker " + timeMillis + " millisekund");
//		System.out.println("og " + timeSeconds + " sekund\nPå å sorteres.");
//		
//		System.out.println("Sortert: ");
//		skrivUt(data);

	}
}
