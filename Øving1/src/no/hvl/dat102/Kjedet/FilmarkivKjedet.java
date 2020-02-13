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
		int i = 0; 
		while (node.getElement() != null) {
			tabell[i] = node.getElement();
			node = node.getNext();
			i++;
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
			while (current.getElement() != null && !deleted) {
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
		while (current.getElement() != null) {
			if (current.getElement().getTittel().contains(delstreng)) {
				tempTable[count] = current.getElement();
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
		while (current.getElement() != null) {
			if (current.getElement().getProdusent().contains(delstreng)) {
				tempTable[count] = current.getElement();
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
}
