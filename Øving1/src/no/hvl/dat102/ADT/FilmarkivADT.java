package no.hvl.dat102.ADT;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FilmarkivADT {
	
	public Film[] hentFilmTabell();
	
	public void leggTil(Film nyFilm);
	
	public boolean slettFilm(int nr);
	
	public Film[] sokTittel(String delstreng);
	
	public Film[] sokProdusent(String delstreng);
	
	public int antallsjanger(Sjanger sjanger);
	
	public int antallFilmer();
	
	public Film finnFilmMedNr(int nr); 
 
}