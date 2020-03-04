package no.hvl.dat102.tabell;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 6;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		T resultat = null;
		resultat = liste[bak - 1];
		liste[bak - 1] = null;
		bak--;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		resultat = liste[0];
		for (int i = 1; i < bak; i++) {
			liste[i - 1] = liste[i];
		}
		bak--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[bak - 1];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		if (liste.length == bak) {
			utvid();
		}
		if (bak == 0) {
			liste[0] = element;
		} else {
			int i = 0;
			boolean forLangt = false;
			while (i < bak && !forLangt) {
				if (element.compareTo(liste[i]) < 0) {
					forLangt = true;
					i--;
				}
				i++;
			}
			int j = bak;
			while (j > i) {
				liste[j] = liste[j - 1];
				j--;
			}
			liste[i] = element;
		}
		bak++;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		T resultat = null;
		int pos = finn(element);
		if (pos != -1) {
			resultat = liste[pos];
		}
		int j = pos + 1; 
		while(j < bak) {
			liste[j - 1] = liste[j];
			j++;
		}
		bak--;
		return resultat;
	}

	private int finn(T el) {
		int i = 0;
		int resultat = IKKE_FUNNET;
		while (i < bak) {
			if (liste[i].equals(el)) {
				resultat = i;
			}
			i++;
		}
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
