package no.hvl.dat102.datakontaktfirma;

import java.util.Scanner;

public class Tekstgrensesnitt {
	// Hvis du vil lage meny kan du også legge det inn i Tekstgrensesnitt
	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem() {
		Scanner leser = new Scanner(System.in);
		System.out.println("Navn på medlem: ");
		String navn = leser.nextLine();
		Medlem nyttMedlem = new Medlem(navn);
		String fortsett = "ja";
		while (fortsett.equals("ja")) {
			System.out.println("Oppgi hobby:");
			Hobby hob = new Hobby(leser.nextLine());
			nyttMedlem.setHobby(hob);
			System.out.print("Ønsker du å legge til flere hobbyer?");
			fortsett = leser.nextLine();
		}
		return nyttMedlem;
	}

	// skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println(medlem.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {
		
		//Denne her er feil, hvordan holder jeg styr på hvem som har blitt printet ut? 
		Datakontakt parArkiv = new Datakontakt(arkiv.getAntall());
		Medlem medlem;
		int antallPar = 0;
		Medlem partner;
		for (int i = 0; i < arkiv.getAntall(); i++) {
			medlem = arkiv.getMedlem(i);
			
			if (medlem.getStatusIndeks() >= 0) {
				parArkiv.leggTilMedlem(medlem);
				partner = arkiv.getMedlem(medlem.getStatusIndeks());
				parArkiv.leggTilMedlem(partner);
				antallPar++;
			}
		}
		System.out.print("PARNAVN\t");
		System.out.println("HOBBY");
		for(int j = 0; j < antallPar; j += 2) {
			
		}
		System.out.println("Antall par: " + antallPar);
	}
	/*
	 * skriver ut på skjermen en oversikt over medlemmer som er koblet til hverandre
	 * i medlemstabellen til enhver tid. Et slikt par skal kun vises én gang på
	 * utskriftlisten. Metoden skriver også ut antall par som er funnet. Eksempel på
	 * utskrift: PARNAVN HOBBYER Erna og Jonas <ski, musikk, politikk> Eva og Adam
	 * <epleplukking, paradishopping> ……………………. Antall par funnet: 12
	 */
}//
