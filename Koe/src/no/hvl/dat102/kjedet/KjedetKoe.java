package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class KjedetKoe<T> implements KoeADT<T> {
	private int antall;
	private LinearNode<T> front, bak;

	public KjedetKoe() {
		// Tom konstrukt�r
	}

	public KjedetKoe(int ant) {
		this.antall = ant;
		front = new LinearNode<T>();
		bak = front;
	}
	/*
	 * Sjekker om k�en er tom, hvis den er det legges elementet f�rst i k�en. Dersom
	 * k�en ikke er tom legges inn et element bakerst i k�en.
	 */

	@Override
	public void innKoe(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		if (erTom()) {
			front = nyNode;
			bak = nyNode;
		} else {
			bak.setNeste(nyNode);
			bak = nyNode;
		}
		antall++;
	}
	/* 
	 * Tar ut f�rste element i k�en.
	 * Dersom k�en er tom kastes et unntak
	 */
	@Override
	public T utKoe() throws EmptyCollectionException {
		if (erTom()) {
			throw new EmptyCollectionException("K�en er tom");
		}
		T element = front.getElement();
		front = front.getNeste();
		antall--;
		return element;
	}
	
	// Returnerer elementet som er f�rst i rekken
	@Override
	public T foerste() {
		return front.getElement();
	}
	
	//Sjekker om k�en er tom
	@Override
	public boolean erTom() {
		boolean tom = false; 
		if (antall() == 0) {
			tom = true; 
		}
		return tom;
	}
	//Returnere antall i k�
	@Override
	public int antall() {
		return antall;
	}

}
