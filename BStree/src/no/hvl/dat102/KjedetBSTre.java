package no.hvl.dat102;

import java.util.Iterator;

import no.hvl.dat102.adt.BSTreADT;

//********************************************************************
// KjedetBinærSøkeTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {

	private int antall;
	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt binært søketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et binært søketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer antall elementer i treet
	 *****************************************************************/
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære treet er tom og usann ellers.
	 *****************************************************************/
	public boolean erTom() {
		return (antall == 0);
	}

	/**********************************************************************
	 * Legger det spesifiserte elementet på passende plass i BS-treet. Like
	 * elementer blir lagt til høyre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	public void leggTil(T element) {
		
		if (erTom()) {
			rot = new BinaerTreNode<T> (element);
		} else {
			leggTilRek(rot, element);
		}
		antall++;
	}

	private void leggTilRek(BinaerTreNode<T> p, T element) {
		
		int sml = element.compareTo(p.getElement());
		
		if (sml < 0) {
			if (p.getVenstre() == null) {
				p.setVenstre( new BinaerTreNode<T> (element));
			} else {
				leggTilRek(p.getVenstre(), element);
			}
		} else {
			if (p.getHoyre() == null) {
				p.setHoyre( new BinaerTreNode<T> (element));
			} else {
				leggTilRek(p.getHoyre(), element);
			}
		}
	}

	/******************************************************************
	 * Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 ******************************************************************/

	public void leggTil2(T element) {
		//
	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette binære søketreet.
	 *********************************************************************/
	public T fjernMin() {
		T resultat = null;
		
		if (rot.getVenstre() == null) {
			resultat = rot.getElement();
			rot = rot.getHoyre();
		} else {
			BinaerTreNode<T> forelder = rot; 
			BinaerTreNode<T> aktuell = rot.getVenstre();
			while (aktuell.getVenstre() != null) {
				forelder = aktuell; 
				aktuell = aktuell.getVenstre();
			}
			resultat = aktuell.getElement();
			forelder.setVenstre(aktuell.getHoyre());
		}
		antall--;
		
		return resultat;
	}//

	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 ******************************************************************/
	public T fjernMaks() {
		T resultat = null;
		
		if (rot.getHoyre() == null) {
			resultat = rot.getElement();
			rot = rot.getVenstre();
		} else {
			BinaerTreNode<T> forelder = rot; 
			BinaerTreNode<T> aktuell = rot.getHoyre();
			while (aktuell.getHoyre() != null) {
				forelder = aktuell; 
				aktuell = aktuell.getHoyre();
			}
			resultat = aktuell.getElement();
			forelder.setHoyre(aktuell.getVenstre());
		}
		antall--;
		
		return resultat;
	}//

	/******************************************************************
	 * Returnerer det minste elementet i dette binære søketreet.
	 ******************************************************************/
	public T finnMin() {
		if (erTom()) {
			return null; 
		} else { 
			BinaerTreNode<T> p = rot; 
			while (p.getVenstre() != null ) {
				p = p.getVenstre();
			}
			return p.getElement();
		}
	}//	

	/******************************************************************
	 * Returnerer det største elementet i dette binære søketreet.
	 ******************************************************************/
	public T finnMaks() {
		if (erTom()) {
			return null; 
		} else {
			BinaerTreNode<T> p = rot; 
			while (p.getHoyre() != null) {
				p = p.getHoyre();
			}
			return p.getElement();
		}
	}

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	public T finn(T element) {
		return finnRek(element, rot);
	}

	private T finnRek(T element, BinaerTreNode<T> p) {
		T svar = null; 
		if (p != null) {
			int sml = element.compareTo(p.getElement());
			
			if (sml == 0) {
				svar = p.getElement();
			} else if (sml < 0) {
				svar = finnRek(element, p.getVenstre());
			} else {
				svar = finnRek(element, p.getHoyre());
			}
		}
		return svar; 
	}

	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		// TODO
		return null;
	}
	
	public int hoyde() {
		
		return hoydeRek(rot);
	
	}
	
	private int hoydeRek(BinaerTreNode<T> p) {
		
		if (p == null) { //Basis
			 return 0;
		 } else { 
			 return 1 + Math.max(hoydeRek(p.getVenstre()), hoydeRek(p.getHoyre()));
		 }
 
	}
	
	
	
	/*
	 * Alt under her er diverse ekstra metoder. 
	 */
	
	
	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		}
	}
	@SuppressWarnings("unchecked")
	public void balanser() {
		T[] tab = (T[]) new Comparable[antall];
		sortertTab(tab);
		lagBalansertTre(tab);
	}

	public void lagBalansertTre(T[] tab) {
		rot = lagBalansertTre(tab, 0, tab.length - 1);
		antall = tab.length;
	}

	private BinaerTreNode<T> lagBalansertTre(T[] tab, int start, int slutt) {

		if (start > slutt) {
			// Basis
			return null;
		} else {
			int midten = (start + slutt) / 2;
			BinaerTreNode<T> venstreUndertre = lagBalansertTre(tab, start, midten - 1);
			BinaerTreNode<T> hoeyreUndertre = lagBalansertTre(tab, midten + 1, slutt);
			BinaerTreNode<T> rot = new BinaerTreNode<T>(tab[midten]);
			rot.setVenstre(venstreUndertre);
			rot.setHoyre(hoeyreUndertre);
			return rot;
		}
	}

	public void sortertTab(T[] tab) {
		sortertTab(rot, tab, 0);
	}

	private int sortertTab(BinaerTreNode<T> p, T[] tab, int neste) {
		if (p == null) {
			// basis
			return neste;
		} else {
			int nyNeste = sortertTab(p.getVenstre(), tab, neste);
			tab[nyNeste] = p.getElement();
			nyNeste = sortertTab(p.getHoyre(), tab, nyNeste + 1);
			return nyNeste;
		}
	}
	public KjedetBSTre<T> kopierTre() {
		KjedetBSTre<T> ny = new KjedetBSTre<T>(); 
		ny.rot = kopierTreRek(rot); 
		ny.antall = antall; 
		return ny; 
	}
	private BinaerTreNode<T> kopierTreRek(BinaerTreNode<T> t) {
		if (t == null) {
			return null; 
		} else {
			BinaerTreNode<T> venstreRot = kopierTreRek(t.getVenstre());
			BinaerTreNode<T> hoyreRot = kopierTreRek(t.getHoyre());
			BinaerTreNode<T> ny = new BinaerTreNode<T>(t.getElement());
			ny.setVenstre(venstreRot);
			ny.setHoyre(hoyreRot);
			return ny; 
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);
	}
}// class
