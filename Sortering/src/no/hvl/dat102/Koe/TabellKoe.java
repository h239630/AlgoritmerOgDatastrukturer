package no.hvl.dat102.Koe;

import no.hvl.dat102.Koe.KoeADT;
import no.hvl.dat102.Koe.EmptyCollectionException;

public class TabellKoe<T> implements KoeADT<T> {
	private final static int STDK = 100; 
	private int bak;
	private T[] koe; 
	
	public TabellKoe() {
		this(STDK);
	}

	@SuppressWarnings("unchecked")
	public TabellKoe(int startKap) {
		bak = 0; 
		koe = (T[])(new Object[startKap]);
	}
	/*
	 * Legger inn et element bakerst i køen
	 * Dersom køen er full utvider den køen via en hjelemetode som dobler kølengden
	 */
	@Override
	public void innKoe(T element) {
		if (bak == koe.length) {
			utvid(); 
		}
		koe[bak] = element; 
		bak++;
	}
	/* 
	 * Kopierer første element til resultat 
	 * Returner resultat som er referanse til første element i kø
	 * Hvis køen er tom kastes et unntak 
	 */ 
	@Override
	public T foerste() throws EmptyCollectionException {
		if (erTom()) {
			throw new EmptyCollectionException("Køen er tom");
		}
		T resultat = koe[0];
		return resultat;
	}
	/*
	 * Tar ut første element i køen og minker kø lengden med 1
	 * Hvis køen er tom kastes et unntak 
	 */
	@Override
	public T utKoe() throws EmptyCollectionException {
		if (erTom()) {
			throw new EmptyCollectionException("Koen er tom");
		}
		T resultat = koe[0]; 
		bak--;
		for (int i = 0; i < bak; i++) {
			koe[i] = koe[i + 1];
		}
		return resultat;
	}
	/*
	 * Sjekker om køen er tom.
	 * Bak er antall som er i kø. Dersom denne er 0 er køen tom. 
	 */
	@Override
	public boolean erTom() {
		boolean tom = false; 
		if (bak == 0) {
			tom = true;
		}
		return tom;
	}
	/*
	 * Returnere antall i kø representert med bak. 
	 */
	@Override
	public int antall() {
		return bak;
	}
	
	//Hjelpemetoder
	@SuppressWarnings("unchecked")
	private void utvid() {
		T[] utvidet = (T[])(new Object[koe.length * 2]);
		for (int i = 0; i < koe.length; i++) {
			utvidet[i] = koe[i];
		}
		koe = utvidet;  
	}

}
