package no.hvl.dat102.KlientKjedet;

import javax.swing.JOptionPane;
import no.hvl.dat102.Film;
import no.hvl.dat102.ADT.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filma;

	public Meny(FilmarkivADT filma) {
		tekstgr = new Tekstgrensesnitt();
		this.filma = filma;
	}

	public void start() {
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*\nVelkommen til filmarkivet!\n-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
		boolean avslutt = false;

		while (!avslutt) {

			int valgt = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Hva vil du gjøre?" + "\n1. Legge til en film" + "\n2. Slette en film" + "\n3. Søke etter filmer"
							+ "\n4. Søke etter produsenter" + "\n5. Vise statistikk for arkivet"
							+ "\n6. Liste opp alle film tittler" + "\n7. Liste opp alle produsenter"
							+ "\n0. Lukke arkivet",
					"Meny", JOptionPane.INFORMATION_MESSAGE));

			switch (valgt) {
			case 1:
				Film film = tekstgr.lesFilm();
				filma.leggTil(film);
				System.out.println("Filmen er lagt til i arkivet");
				System.out.println("-----------------------------");
				break;
			case 2:
				int nr = Integer.parseInt(JOptionPane.showInputDialog("Nummer på film du ønsker å slette:"));
				if (filma.finnFilmMedNr(nr) == null) {
					System.out.println("Filmen finnes ikke i arkivet.");
					System.out.println("-----------------------------");
				} else {
					System.out.println("Du sletter nå:");
					tekstgr.visFilm(filma.finnFilmMedNr(nr));
					String bekreftelse = JOptionPane.showInputDialog("Bekreft med OK");
					if (bekreftelse.equals("OK")) {
						filma.slettFilm(nr);
						System.out.println("Filmen er slettet");
						System.out.println("-----------------------------");
					} else {
						System.out.println("Sletting av film avbrutt.");
						System.out.println("-----------------------------");
					}
				}
				break;
			case 3:
				String delstreng = JOptionPane.showInputDialog("Tittel på film?");
				tekstgr.skrivUtFilmDelstrengITittel(filma, delstreng);
				break;
			case 4:
				System.out.println("Navn på produsent?");
				String produsent = JOptionPane.showInputDialog("Navn på produsent?");
				tekstgr.skrivUtFilmProdusent(filma, produsent);
				break;
			case 5:
				System.out.println("Statistikk:");
				tekstgr.skrivUtStatistikk(filma);
				break;
			case 6:
				tekstgr.tittelListe(filma);
				break;
			case 7:
				tekstgr.produsentListe(filma);
				break;
			case 0:
				avslutt = true;
				System.out.println("Arkivet er lukket");
				break;
			}

		}
	}
}
