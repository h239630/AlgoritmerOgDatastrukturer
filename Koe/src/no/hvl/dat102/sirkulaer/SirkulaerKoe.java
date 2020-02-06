package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T> {
	// Objektparametere
	private final static int STDK = 100;
	private int front, bak, antall;
	private T[] koe;

	// Konstruktører
	public SirkulaerKoe() {
		this(STDK);
	}

	@SuppressWarnings("unchecked")
	public SirkulaerKoe(int startKap) {
		koe = (T[]) (new Object[startKap]);
		front = 0;
		bak = 0;
		antall = 0;
	}
	/*
	 * Legger til et element i kø. Utvider køen dersom dette er nødvendig.
	 */

	@Override
	public void innKoe(T element) {
		if (antall() == koe.length) {
			utvid();
		}
		koe[bak] = element;
		bak = (bak + 1) % koe.length;
		antall++;
	}

	/*
	 * Tar ut første element av køen Hvis køen er tom kaster den et unntak
	 */
	@Override
	public T utKoe() throws EmptyCollectionException {
		if (erTom()) {
			throw new EmptyCollectionException("Køen er tom");
		}
		T resultat = koe[front];
		koe[front] = null;
		front = (front + 1) % koe.length;
		antall--;
		return resultat;
	}

	@Override
	public T foerste() throws EmptyCollectionException {
		if (erTom()) {
			throw new EmptyCollectionException("Køen er tom");
		}
		T resultat = koe[front];
		return resultat;
	}

	@Override
	public boolean erTom() {
		boolean tom = false;
		if (antall() == 0) {
			tom = true;
		}
		return tom;
	}

	@Override
	public int antall() {
		return antall;
	}

	// Hjelpemetoder
	@SuppressWarnings("unchecked")
	private void utvid() {
		T[] utvidet = (T[]) (new Object[koe.length * 2]);
		for (int i = 0; i < koe.length; i++) {
			utvidet[i] = koe[i];
			front = (front + 1) % koe.length;
		}
		front = 0;
		bak = antall;
		koe = utvidet;
	}

}
