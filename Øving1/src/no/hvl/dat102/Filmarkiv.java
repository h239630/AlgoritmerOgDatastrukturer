package no.hvl.dat102;

import no.hvl.dat102.ADT.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private Film[] filmTabell; 
	private int antall; 
	
	public Filmarkiv() {
		//Tom konstruktør
	}
	public Filmarkiv(int antall) {
		filmTabell = new Film[antall];
		this.antall = 0; 
	}
	@Override
	public Film[] hentFilmTabell() {
		return filmTabell;
	}
	@Override
	public void leggTil(Film nyFilm) {
		if (antall == filmTabell.length) {
			utvid();
		}
		filmTabell[antall] = nyFilm;
		antall++;
	}
	@Override
	public boolean slettFilm(int filmNr) {
		boolean slettet = false; 
		int pos = 0; 
		int i = 0;
		while (pos == 0 && i < antall) {
			if (filmTabell[i].getNr() == filmNr) {
				pos = i;  
				for (int j = pos; j < antall; j++) {
					filmTabell[j] = filmTabell[j+1];
				}
				slettet = true; 
				antall--;
			} 
			i++;
		}	
		return slettet;
	}
	@Override
	public Film[] sokTittel(String delstreng) {
		Film[] funnetFilmer = new Film[antall];  
		//Alle treff basert på sammenligningen legges inn i den nye tabellen. 
		int indeks = 0; 
		for (int i = 0; i < antall; i++) {
			if(filmTabell[i].getTittel().contains(delstreng)) {
				funnetFilmer[indeks] = filmTabell[i];
				indeks++;
			}
		}
		return funnetFilmer; 
	}
	@Override
	public Film[] sokProdusent(String delstreng) {
		Film[] funnetFilmer = new Film[antall];
		int indeks = 0; 
		for (int i = 0; i < antall; i++) {
			if(filmTabell[i].getProdusent().contains(delstreng)) {
				funnetFilmer[indeks] = filmTabell[i]; 
			}
		}
		return funnetFilmer;
	}
	@Override
	public int antallsjanger(Sjanger sjanger) {
		int antallFilmer = 0; 
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getSjanger().equals(sjanger)) {
				antallFilmer++;
			}
		}
		return antallFilmer;
	}
	@Override
	public int antallFilmer() {
		return antall;
	}
	
	@Override
	public Film finnFilmMedNr(int nr) {
		Film funnet = null; 
		int i = 0; 
		while (funnet == null && i < antall) {
			if (filmTabell[i].getNr() == nr) {
				funnet = filmTabell[i];
			}
			i++;
		}
		return funnet; 
	}
	//Hjelpemetoder
		public void utvid() {
			Film[] hTabell = new Film[filmTabell.length * 2];
			for (int i = 0; i < filmTabell.length; i++) {
				hTabell[i] = filmTabell[i]; 
			}
			filmTabell = hTabell;
		}
	
}
