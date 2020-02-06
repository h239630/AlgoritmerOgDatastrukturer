package no.hvl.dat102.Kjedet;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.ADT.FilmarkivADT;

public class FilmarkivKjedet implements FilmarkivADT {
	private int antall; 
	private LinearNode<Film> start; 
	
	public FilmarkivKjedet() {
		//Tom konstruktør
	}
	public FilmarkivKjedet(int antall) {
		//Konstruktør med antall
		this.start = new LinearNode<Film>();
		this.antall = antall; 
	}
	

	@Override
	public Film[] hentFilmTabell() {
		Film[] tabell = new Film[antall];
		LinearNode<Film> node = start;
		for (int i = 0; i < antall; i++) {
			if (node.getElement() != null) { 
				tabell[i] = node.getElement();
				node = node.getNext();
			} else { 
				node = node.getNext();
			}
		}
		return tabell;
	}

	@Override
	public void leggTil(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm);
		nyNode.setNext(start);
		start = nyNode;
		antall++;
	}

	@Override
	public boolean slettFilm(int nr) {
		boolean deleted = false; 
		LinearNode<Film> current = start;
		LinearNode<Film> last;
		if(current.getElement().getNr() == nr) {
			start = current.getNext();
			antall--;
			deleted = true;
		} else {
			last = current; 
			current = current.getNext();
			while (current.getElement() != null) {
				if (current.getElement().getNr() == nr) {
					last.setNext(current.getNext());
					antall--;
					deleted = true;
				} else {
					last = current; 
					current = current.getNext();
				}
			}
		}
		return deleted;
	}

	@Override
	public Film[] sokTittel(String delstreng) {
		Film[] tempTable = new Film[antall]; 
		LinearNode<Film> current = start;
		int count = 0; 
		for (int i = 0; i < antall; i++) {
			if (current.getElement().getTittel().contains(delstreng)) {
				tempTable[i] = current.getElement();
				count++;
			}
			current = current.getNext();
		}
		Film[] found; 
		if (count != 0) {
			found = new Film[count];
			for (int j = 0; j < tempTable.length; j++) {
				if (tempTable[j] != null) {
					found[count - 1] = tempTable[j];
					count--;
				}
			}
		} else {
			found = tempTable;		
		}
		return found;
	}

	@Override
	public Film[] sokProdusent(String delstreng) {
		Film[] tempTable = new Film[antall];
		LinearNode<Film> current = start;
		int count = 0; 
		for (int i = 0; i < antall; i++) {
			if (current.getElement().getProdusent().contains(delstreng)) {
				tempTable[i] = current.getElement();
				count++;
			}
			current = current.getNext();
		}
		Film[] found; 
		if (count != 0) {
			found = new Film[count];
			for(int j = 0; j < tempTable.length; j++) {
				if (tempTable[j] != null) {
					found[count - 1] = tempTable[j];
					count--;
				}
			}
		} else { 
			found = tempTable;
		}
		return found;
	}

	@Override
	public int antallsjanger(Sjanger sjanger) {
		int quantity = 0; 
		LinearNode<Film> current = start; 
		for (int i = 0; i < antall; i++) {
			if (current.getElement().getSjanger().equals(sjanger)) {
				quantity++;
			}
			current = current.getNext();
		}
		return quantity;
	}

	@Override
	public int antallFilmer() {
		return antall;
	}

	@Override
	public Film finnFilmMedNr(int nr) {
		boolean found = false;
		LinearNode<Film> current = start; 
		while(current != null && !found) {
			if(current.getElement().getNr() == nr) {
				found = true; 
			} else {
				current = current.getNext();
			} 
		}
		return current.getElement();
	}
	
	public static void main(String[] args) {
		FilmarkivADT test = new FilmarkivKjedet();
		Film film = new Film(323, "Prins", "Troy", 1990, "S", Sjanger.finnSjanger("Action"));
		Film f2 = new Film(2, "Per", "Tarzan", 1999, "Seik", Sjanger.finnSjanger("Action"));
		Film f3 = new Film(33, "Paal", "Yas", 1991, "Knut", Sjanger.finnSjanger("Drama"));
		test.leggTil(film);
		test.leggTil(f2);
		test.leggTil(f3);
		System.out.println("Antall filmer " + test.antallFilmer());
		Film film2 = new Film(45);
		test.leggTil(film2);
		System.out.println("Etter " + test.antallFilmer());
		System.out.print("Funnet "); 
		Film funnet = new Film();
		funnet = test.finnFilmMedNr(2);
		System.out.println(funnet.getNr()); 
		Film[] tab2 = test.sokProdusent("P");
		for(int i = 0; i < tab2.length; i++) {
			System.out.println("Film " + tab2[i].getNr());
		}
		int antAc = test.antallsjanger(Sjanger.ACTION);
		int antDr = test.antallsjanger(Sjanger.DRAMA);
		System.out.println("Action: " + antAc + " og Drama: " + antDr);
	}

}
