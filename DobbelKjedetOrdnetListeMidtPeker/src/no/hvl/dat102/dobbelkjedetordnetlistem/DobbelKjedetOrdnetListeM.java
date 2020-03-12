package no.hvl.dat102.dobbelkjedetordnetlistem;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeMADT;

//********************************************************************
//  
//  Representerer en dobbeltkjedet ordnet liste med midtpeker.
//********************************************************************
;

public class DobbelKjedetOrdnetListeM<T extends Comparable<T>> implements DobbelKjedetOrdnetListeMADT<T> {
//M for midtpeker
	private DobbelNode<T> foerste;
	private DobbelNode<T> midten;
	private DobbelNode<T> siste;
	private int antall;

	/******************************************************************
	 * Oppretter en tom liste.
	 ******************************************************************/
	// Konstruktør

	public DobbelKjedetOrdnetListeM(T minVerdi, T maksVerdi) {

		// Første node
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minVerdi);
		foerste = nyNode1;
		midten = foerste;

		// Siste node
		DobbelNode<T> nyNode2 = new DobbelNode<T>();
		nyNode2.setElement(maksVerdi);
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;

		antall = 0;
	}

	@Override
	public void leggTil(T nyttElement) {
		// Setter inn ordnet før den noden aktuell peker på
		DobbelNode<T> aktuell;

		if ((nyttElement.compareTo(foerste.getElement()) <= 0) || (nyttElement.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier

			if (nyttElement.compareTo(midten.getElement()) >= 0) {// Finn plass i siste halvdel
				aktuell = midten.getNeste();
			} else { // Finn plass i første halvdel
				aktuell = foerste.getNeste();
			}

			while (nyttElement.compareTo(aktuell.getElement()) >= 0) {
				aktuell = aktuell.getNeste();
			} // while

			// Setter inn foran noden som aktuell peker på
			DobbelNode<T> nyNode = new DobbelNode<T>(nyttElement);

			aktuell.getForrige().setNeste(nyNode);
			nyNode.setForrige(aktuell.getForrige());
			aktuell.setForrige(nyNode);
			nyNode.setNeste(aktuell);

			// Oppdaterer ny midten
			nyMidten();
			antall++;
		} // else lovlige

	}//

	// **********************************************************************************
	// Hjelpemetode til å finne ny midten.
	// Mindre effektiv fordi vi må gjennomgå ca halve listen, men greit nok,
	// ellers kan en teste på om antall er partall er oddetall ved oppdatering
	// av midtpeker
	// *********************************************************************************
	private void nyMidten() {
		int midtNR = antall / 2;
		DobbelNode<T> p = foerste.getNeste();
		for (int i = 1; i <= midtNR; i++) {
			p = p.getNeste();
		}
		midten = p;
	}//

	@Override
	public boolean fins(T nyttElement) {
		boolean funnet = false;
		DobbelNode<T> aktuell = null;
		if ((nyttElement.compareTo(foerste.getElement()) <= 0) || (nyttElement.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier
			if (nyttElement.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
				aktuell = midten; // Midten defineres å tilhøre siste del
			} else { // Let i første halvdel
				aktuell = foerste.getNeste();
			}

			while (nyttElement.compareTo(aktuell.getElement()) > 0) {
				aktuell = aktuell.getNeste();
			} // while

			// Test på funnet
			if (nyttElement.compareTo(aktuell.getElement()) == 0) {
				funnet = true;
			}
		} // else
		return funnet;
	}//
	
//	@Override
//	public T fjern(T el) {
//		T resultat = null;
//		DobbelNode<T> aktuell = null;
//		boolean funnet = false;
//
//		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
//			// Ugyldig. Alternativt kan vi ha det som et forkrav!
//			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());
//
//		} else { // Kun lovlige verdier
//
//			if (el.compareTo(midten.getElement()) >= 0) {
//				aktuell = midten;
//			} else {
//				aktuell = foerste.getNeste();
//			}
//
//			while (el.compareTo(aktuell.getElement()) > 0) {
//				aktuell = aktuell.getNeste();
//			} // while
//
//			if (el.compareTo(aktuell.getElement()) == 0) {
//				funnet = true;
//			}
//           
//			if (funnet) {
//				// Tar ut 
//				antall = antall - 1;
//				// Fyll ut med noen få setninger.
//				aktuell.getForrige().setNeste(aktuell.getNeste());
//				aktuell.getNeste().setForrige(aktuell.getForrige());
//				// Oppadtere midten
//				nyMidten();
//
//				resultat = aktuell.getElement();
//
//			} // funnet
//
//		} // lovlige
//		return resultat;
//	}//

	
	// Bruker finn metoden for å finne elementet som skal fjernes
	@Override
	public T fjern(T element) {
		T resultat = null;
		DobbelNode<T> aktuell = null;
		
		aktuell = finn(element);
		if (aktuell != null) {
			aktuell.getForrige().setNeste(aktuell.getNeste());
			aktuell.getNeste().setForrige(aktuell.getForrige());
			antall--;

			// Oppdaterer midten
			nyMidten();
		}
		return resultat;
	}//

	private DobbelNode<T> finn(T element) {
		DobbelNode<T> node = null;
		DobbelNode<T> aktuell = null;

		// Kun lovlige verdier
		if (element.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
			aktuell = midten; // Midten defineres å tilhøre siste del
		} else { // Let i første halvdel
			aktuell = foerste.getNeste();
		}
		while (element.compareTo(aktuell.getElement()) > 0) {
			aktuell = aktuell.getNeste();
		} // while

		// Test på funnet
		if (element.compareTo(aktuell.getElement()) == 0) {
			node = aktuell;
		}
		return node;
	}

	public void skrivListe() {
		DobbelNode<T> p = foerste;

		while (p != null) {
			System.out.print(p.getElement() + " ");
			p = p.getNeste();
		}

		System.out.println("\nFoerste: " + foerste.getElement() 
						+ " \nMidten: " + midten.getElement() 
						+ " \nSiste: " + siste.getElement());
	}

}// class
