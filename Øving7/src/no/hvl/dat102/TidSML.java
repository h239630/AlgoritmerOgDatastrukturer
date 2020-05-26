package no.hvl.dat102;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class TidSML {
	
	public static void main(String[] args) {
		
		
		Integer[] s�k = new Integer[10000];
		Integer[] tab = new Integer[100000];
		HashSet<Integer> hash = new HashSet<Integer>();
		Instant start; 
		Instant finish; 
		long timeMillisT; 
		long timeMillisH; 
		int tellerTab = 0;
		int tellerHash = 0; 
		int tall = 376; 
		
		
		
		//Fyller tabellen og hashset
		for (int i = 0; i < tab.length; i++){
			tab[i] = tall;
			hash.add(tall);
			tall = (tall + 45713) % 1000000; 
		}
		
		Arrays.sort(tab); 
		Random verdi = new Random();
		
		//Fyller en tabell med s�keverdier
		for (int i = 0; i < 10000; i++) {
			s�k[i] = verdi.nextInt(1000000);
		}	
		
		
		//M�ler tiden og finner antall treff p� hashsettet
		start = Instant.now();
		for (int i = 0; i < s�k.length; i++) {
			if (hash.contains(s�k[i])) {
				tellerHash++;
			}
		}
		finish = Instant.now();
		timeMillisH = Duration.between(start, finish).toMillis();
		
		
		 
		//M�ler tiden og finner antall treff p� tabellen med bin�rs�k 
		start = Instant.now();
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < s�k.length; j++) {
				if (s�k[j].equals(tab[i])) {
					tellerTab++;
				}
			}
		}
		finish = Instant.now();
		timeMillisT = Duration.between(start, finish).toMillis(); 
	
		System.out.println("Hash: ");
		System.out.println("Tid i millisekund: " + timeMillisH + "\nAntall treff: " + tellerHash);
		System.out.println("Tabell: ");
		System.out.println("Tid i millisekund: " + timeMillisT + "\nAntall treff: " + tellerTab);
		
	}
}
