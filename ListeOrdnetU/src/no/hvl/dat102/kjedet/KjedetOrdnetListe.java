package no.hvl.dat102.kjedet;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.adt.OrdnetListeADT;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
//		if (erTom())
//			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste.getElement();
		foerste = foerste.getNeste();
		antall--;
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();
		LinearNode<T> aktuell = foerste, forrige = foerste;
		while (aktuell != siste) {
			forrige = aktuell;
			aktuell = aktuell.getNeste();
		}
		siste = forrige;
		antall--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		boolean tom = true;
		if (antall > 0) {
			tom = false;
		}
		return tom;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		LinearNode<T> forrige = new LinearNode<T>();
		LinearNode<T> aktuell = new LinearNode<T>();

		if (foerste == null) { // Hvis kjeden er tom så legger den inn på første
			foerste = nyNode;
			siste = foerste;
		} else {
			aktuell = foerste;
			forrige = foerste;
			// Finner stedet den nye noden må inn 
			while (aktuell.getNeste() != null && element.compareTo(aktuell.getElement()) > 0) {
				forrige = aktuell;
				aktuell = aktuell.getNeste();
			}
			//Sjekker om noden skal før eller etter aktuell node
			if (element.compareTo(aktuell.getElement()) <= 0) { 
				if (foerste == aktuell) { //Sjekker om node skal inn helt først
					foerste = nyNode;
					foerste.setNeste(aktuell);
				} else { //Hvis ikke legges noden inn i mellom
					forrige.setNeste(nyNode);
					nyNode.setNeste(aktuell);
				}
			} else { //Eller helt til slutt
				aktuell.setNeste(nyNode);
				siste = nyNode;
			}

		}
		antall++;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
