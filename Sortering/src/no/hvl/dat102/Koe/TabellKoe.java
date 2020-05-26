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
	 * Legger inn et element bakerst i k�en
	 * Dersom k�en er full utvider den k�en via en hjelemetode som dobler k�lengden
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
	 * Kopierer f�rste element til resultat 
	 * Returner resultat som er referanse til f�rste element i k�
	 * Hvis k�en er tom kastes et unntak 
	 */ 
	@Override
	public T foerste() throws EmptyCollectionException {
		if (erTom()) {
			throw new EmptyCollectionException("K�en er tom");
		}
		T resultat = koe[0];
		return resultat;
	}
	/*
	 * Tar ut f�rste element i k�en og minker k� lengden med 1
	 * Hvis k�en er tom kastes et unntak 
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
	 * Sjekker om k�en er tom.
	 * Bak er antall som er i k�. Dersom denne er 0 er k�en tom. 
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
	 * Returnere antall i k� representert med bak. 
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
