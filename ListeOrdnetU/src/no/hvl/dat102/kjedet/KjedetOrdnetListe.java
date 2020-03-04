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
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat =  foerste.getElement();
		foerste.setNeste(foerste.getNeste());
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();
		LinearNode<T> aktuell = foerste;
		while(aktuell.getNeste() != siste) {
			aktuell = aktuell.getNeste();
		}
		siste = aktuell;
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
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> funnetPlassering = new LinearNode<T>(element);
		
		if(foerste == null) { //Hvis kjeden er tom s� legger den inn p� f�rste
			foerste = funnetPlassering;
			siste = foerste;
		} else {
			LinearNode<T> aktuell = foerste;
			LinearNode<T> forrige = foerste;
			//Finner stedet noden m� inn p� 
			while(aktuell.getNeste() != null && element.compareTo(aktuell.getElement()) >= 0) {
				forrige = aktuell;
				aktuell = aktuell.getNeste();
			}
//			if(aktuell.getNeste() != null) { 
//				forrige.setNeste(funnetPlassering);
//				funnetPlassering.setNeste(aktuell);
//			} else { 
//				aktuell.setNeste(funnetPlassering);
//				siste = funnetPlassering;
//			}
			
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
			if (forrige == null) { // F�rste element
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
