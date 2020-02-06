package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.ADT.FilmarkivADT;

public class Fil {

	private static final String SKILLE = "#";

	/**
	 * @param filnavn
	 * @return Referansen til Film-arkivet
	 * @throws java.io.IOException
	 */
	public static void lesFraFil(FilmarkivADT filma, String filnavn) {
		
		try {

			FileReader ansFil = new FileReader(filnavn);

			BufferedReader innfil = new BufferedReader(ansFil);

			//  Leser den første posten som er antall info-poster

			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);
			

			//  Les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				String selskap = felt[4];
				String sjStr = felt[5];
				Sjanger sj = Sjanger.finnSjanger(sjStr);
				
				Film film = new Film(nr, produsent, tittel, aar, selskap, sj);

				filma.leggTil(film);
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (FileNotFoundException unntak) {// arver fra IOE.. må stå først
												// hvis ikke vil unntaket for IOException skygge
			System.out.println("Finner ikke filen " + filnavn);

		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);

		}

	}// metode

	public static void skrivTilFil(FilmarkivADT filma, String filnavn) {
		try {
			/*
			 * 1 - FileWriter Definerer et FileWriter-objekt som åpner filen. Byte-strøm
			 * blir opprettet for skriving av bytes til filen. Tegn blir lagret i standard
			 * tegnkodingsformat for plattformen. Hvis utvid er true, vil filen utvides ved
			 * skriving på slutten av filen. Hvis utvid er false, vil skrivingen starte i
			 * begynnnelsen av filen. * Dersom filen ikke eksisterer, vil den bli opprettet.
			 * Dersom filen ikke kan åpnes, vil metoden kaste et unntak av typen
			 * IOException.
			 * 
			 */
			FileWriter ansFil = new FileWriter(filnavn, false);

			/*
			 * 2 - PrintWriter Definerer et PrintWriter-objekt som kobles til
			 * FileWriter-objektet. PrintWriter-objektet leverer tegn til
			 * FileWriter-objektet. FileWriter vil gi riktig koding av tegn i bytes og
			 * lagring på fil.
			 * 
			 * 
			 */
			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = filma.antallFilmer();
			// 3 - Skriver foerst ut antall ansatt-info-er på første linje
			utfil.println(antall);
			Film[] tabell = filma.hentFilmTabell();
			for (int i = 0; i < antall; i++) {
				// 3 - Skriver postene, felt for felt
				utfil.print(tabell[i].getNr());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getProdusent());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getAar());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getSelskap());
				utfil.print(SKILLE);
				utfil.println(tabell[i].getSjanger());
			} // for
				// 4 - Lukk filen
			utfil.close();
		} // try
		catch (IOException e) {
			System.out.println("Feil på skriving til fil : " + e);

		}

	}// metode

}// class
