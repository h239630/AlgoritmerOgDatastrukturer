package no.hvl.dat102.KlientKjedet;

import java.util.Scanner;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.ADT.FilmarkivADT;

public class Tekstgrensesnitt {
	Scanner leser = new Scanner(System.in);
	//lese opplysningen om en film fra tastatur
	public Film lesFilm() {
		
		System.out.println("Oppgi informasjon om filmen\nFilmnummer:");
		int nr = leser.nextInt();
		leser.nextLine();
		System.out.println("Produsent:");
		String prod = leser.nextLine();
		System.out.println("Tittel:");
		String tit = leser.nextLine();
		System.out.println("År:");
		int aar = leser.nextInt();
		leser.nextLine();
		System.out.println("Selskap:");
		String sel = leser.nextLine();
		System.out.println("Sjanger:");
		String sjangerString = leser.nextLine();
		Sjanger sj = Sjanger.finnSjanger(sjangerString);
		Film film = new Film(nr, prod, tit, aar, sel, sj);
		return film; 
	}
	
	//vise en film med alle opplysninger på skjerm (husk tekst for sjanger) 
	public void visFilm(Film film) {
		if (film != null) {
			System.out.println("Filmnummer: " + film.getNr() + 
					"\nProdusent: " + film.getProdusent() +
					"\nTittel: " + film.getTittel() + 
					"\nÅr: " + film.getAar() + 
					"\nSelskap: " + film.getSelskap() + 
					"\nSjanger: " + film.getSjanger() + 
					"\n-----------------------------");
		}
	}
	
	//Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] funnetFilmer = filma.sokTittel(delstreng);
		if(funnetFilmer.length == 0) {
			System.out.println("Ingen filmer funnet!");
		} else {
			System.out.println("Filmer med " + delstreng + " i tittel:");
			for(int i = 0; i < funnetFilmer.length; i++) {
				visFilm(funnetFilmer[i]);
			}
		}
		separator();
	}
	
	//skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] funnetFilmer = filma.sokProdusent(delstreng);
		if(funnetFilmer.length == 0) {
			System.out.println("Ingen produsenter funnet!");
		} else {
			System.out.println("Filmer produsert av " + delstreng);
			for(int i = 0; i < funnetFilmer.length; i++) {
				visFilm(funnetFilmer[i]);
			}
		}
		separator();
	}
	
	//Skrive ut en enkel statistikk som inneholder antall Filmer totalt og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		int antallFilmer = filma.antallFilmer();
		int antACTION = filma.antallsjanger(Sjanger.ACTION);
		int antDRAMA = filma.antallsjanger(Sjanger.DRAMA);
		int antHISTORY = filma.antallsjanger(Sjanger.HISTORY);
		int antSCI = filma.antallsjanger(Sjanger.SCIFI);
		int antCom = filma.antallsjanger(Sjanger.COMEDY);
		int antRom = filma.antallsjanger(Sjanger.ROMANTIC);
		
		System.out.println("Antall filmer: " + antallFilmer + " stk\n");
		System.out.println("Antall i hver sjanger:"
				+ 		"\nAction: " + antACTION + " stk" + 
						"\nDrama: " + antDRAMA + " stk" + 
						"\nHistory: " + antHISTORY + " stk" + 
						"\nSci-Fi: " + antSCI + " stk" +
						"\nComedy: " + antCom + " stk" + 
						"\nRomantic: " + antRom + " stk");
		separator();
	}
	public void tittelListe(FilmarkivADT filma) {
		System.out.println("Liste over alle titler: ");
		Film[] filmTabell = filma.hentFilmTabell();
		for (int i = 0; i < filma.antallFilmer(); i++) {
			System.out.println(filmTabell[i].getTittel());
		}
		separator();
	}
	public void produsentListe(FilmarkivADT filma) {
		System.out.println("Liste over alle produsenter: ");
		Film[] filmTabell = filma.hentFilmTabell();
		for (int i = 0; i < filma.antallFilmer(); i++) {
			System.out.println(filmTabell[i].getProdusent());
		}
		separator();
	}
	//Hjelpemetoder
	private void separator() {
		System.out.println("*****************************");
	}
	public void lukk() {
		leser.close();
	}
	
}
