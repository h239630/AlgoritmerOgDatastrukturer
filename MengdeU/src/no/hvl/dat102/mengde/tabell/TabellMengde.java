package no.hvl.dat102.mengde.tabell;

import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {
		// S�ker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;
		int i = 0; 
		while (!funnet && i < antall) {
			if (tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall - 1];
				funnet = true;
				antall--;
			} else {
				i++;
			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(Object m2) {
		boolean likeMengder = true;
		T element; 
		
		if(m2 == this) {
			return true; 
		}
		if(!(m2 instanceof MengdeADT)) {
			return false;
		}
		MengdeADT<T> mengde2 = (MengdeADT<T>)(m2);
		Iterator<T> teller = mengde2.oppramser();
		if(antall != mengde2.antall()) {
			likeMengder = false;
		} else {
			while (teller.hasNext() && likeMengder) {
				element = teller.next();
				if (this.inneholder(element)) {
					likeMengder = true;
				} else {
					likeMengder = false;
				}
			}
		}
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	/*
	 * Denne versjonen av unionen er lite effekktiv
	 * 
	 * @Override 
	 * public MengdeADT<T> union(MengdeADT<T> m2) { 
	 * TabellMengde<T> begge = new TabellMengde<T>(); 
	 * for (int i = 0; i < antall; i++) {
	 * 		begge.leggTil(tab[i]); 
	 * } 
	 * Iterator<T> teller = m2.oppramser();
	 * while (teller.hasNext()) { 
	 * 		begge.leggTil(teller.next()); 
	 * } 
	 * return (MengdeADT<T>)begge; 
	 * }
	 */
	@Override

	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();
		T element = null;
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);	
		}
		Iterator<T> teller = m2.oppramser();
		while(teller.hasNext()) {
			element = teller.next();
			if(!begge.inneholder(element)) {
				begge.leggTil(element);
			}
		}
		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element = null;
		Iterator<T> teller = m2.oppramser();
		int i = 0; 
		
		while (teller.hasNext()){
			element = teller.next();
			i = 0; 
			while(i < antall) {
				if(element.equals(tab[i])) {
					((TabellMengde<T>) snittM).settInn(element);
				}
				i++;
			}
		}
		return snittM;
	}
	/*
	 * Differens finner de elementer i mengde 1 
	 * som ikke finnes i mengde 2 
	 * og legger til i en ny mengde
	 */

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>(); 
		for(int i = 0; i < antall; i++) {
			if (!m2.inneholder(tab[i])) {
				((TabellMengde<T>) differensM).settInn(tab[i]);
			}
		}
		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		Iterator<T> teller = m2.oppramser();
		while(teller.hasNext()) {
			if(!inneholder(teller.next())) {
				erUnderMengde = false;
			}
		}		
		return erUnderMengde;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}
	@Override
	public String toString() {
		String resultat = "<" + tab[0].toString(); 
		int i = 1;
		while (i < antall) {
			resultat += ", " + tab[i].toString();
			i++;
		}
		resultat+= ">";
		return resultat;
	}

}// class
