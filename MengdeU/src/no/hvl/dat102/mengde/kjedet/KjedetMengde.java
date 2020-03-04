package no.hvl.dat102.mengde.kjedet;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		int valg = rand.nextInt(antall) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		antall--;

		return resultat;

	}//

	@Override
	public T fjern(T element) {

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (start.getElement() == element) {
			resultat = start.getElement();
			start.setNeste(start.getNeste());
		} else {
			forgjenger = start;
			aktuell = start.getNeste();
			while (aktuell != null && !funnet) {
				if (aktuell.getElement().equals(element)) {
					funnet = true;
					resultat = aktuell.getElement();
					forgjenger.setNeste(aktuell.getNeste());
					antall--;
				} else {
					forgjenger = aktuell;
					aktuell = aktuell.getNeste();
				}
			}
		}
		return resultat;
	}//

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(Object m2) {
		boolean likeMengder = true;
		T element = null;
		if (m2 == this) {
			return true;
		}
		if (!(m2 instanceof MengdeADT)) {
			return false;
		}
		MengdeADT<T> mengde2 = (MengdeADT<T>) (m2);
		Iterator<T> teller = mengde2.oppramser();
		if (antall != mengde2.antall()) {
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
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element = null;
		Iterator<T> teller = m2.oppramser();
		int i = 0;
		while (i < antall) {
			((KjedetMengde<T>) begge).settInn(aktuell.getElement());
			aktuell = aktuell.getNeste();
			i++;
		}
		while (teller.hasNext()) {
			element = teller.next();
			if (!begge.inneholder(element)) {
				((KjedetMengde<T>) begge).settInn(element);
			}
		}
		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element;
		Iterator<T> teller = m2.oppramser();
		int i = 0;
		while (teller.hasNext()) {
			element = teller.next();
			i = 0;
			aktuell = start;
			while (i < antall && aktuell != null) {
				if (element.equals(aktuell.getElement())) {
					((KjedetMengde<T>) snittM).settInn(aktuell.getElement());
				}
				aktuell = aktuell.getNeste();
				i++;
			}
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
		T element;
		Iterator<T> teller = this.oppramser();
		while (teller.hasNext()) {
			element = teller.next();
			if (!m2.inneholder(element)) {
				differensM.leggTil(element);
			}
		}
		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			if (!inneholder(teller.next())) {
				erUnderMengde = false;
			}
		}
		return erUnderMengde;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}
	//Lager en string representasjon av mengden
	@Override
	public String toString() {
		String resultat = "<" + start.getElement().toString();
		LinearNode<T> aktuell = start.getNeste();
		while (aktuell != null) {
			resultat += ", " + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}
		resultat += ">";
		return resultat;
	}

}// class
