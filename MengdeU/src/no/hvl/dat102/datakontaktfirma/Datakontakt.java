package no.hvl.dat102.datakontaktfirma;

public class Datakontakt {

	private Medlem[] medlemsTab;
	private int antallMedlem;

	public Datakontakt(int antall) {
		medlemsTab = new Medlem[antall];
		antallMedlem = 0;
	}

	public void leggTilMedlem(Medlem person) {
		medlemsTab[antallMedlem] = person;
		antallMedlem++;
	}
	public Medlem getMedlem(int i) {
		return medlemsTab[i];
	}
	public int getAntall() {
		return antallMedlem;
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
		// Finner indeks til medlem og -1 dersom ikke
		int indeks = -1;
		int pos = 0;
		while (pos < antallMedlem && indeks == -1) {
			if (medlemsTab[pos].getNavn().equalsIgnoreCase(medlemsnavn)) {
				indeks = pos;
			}
			pos++;
		}
		return indeks;
	}

	public int finnPartnerFor(String medlemsnavn) {
		// finner en partner for medlem og oppdaterer tabellen samt returnerer indeks for partner
		int partnerIndeks = -1; //Evt. partner sin indeks, -1 dersom ingen finnes
		int medlemsIndeks = finnMedlemsIndeks(medlemsnavn); //Indeks til medlemmet som søker partner
		Medlem medlem = medlemsTab[medlemsIndeks];
		int pos = 0;

		while (pos < antallMedlem && partnerIndeks == -1) {
			if (medlem.passerTil(medlemsTab[pos])) {
				partnerIndeks = pos;
			}
			pos++;
		}
		//Kobler sammen paret
		medlemsTab[medlemsIndeks].setStatusIndeks(partnerIndeks);
		medlemsTab[partnerIndeks].setStatusIndeks(medlemsIndeks);

		return partnerIndeks;

	}

	public void tilbakestilStatusIndeks(String medlemsnavn) {
		// Setter status til -1 på valgt medlem og en eventuell partner
		int medlemsIndeks = finnMedlemsIndeks(medlemsnavn);
		int partnerIndeks = medlemsTab[medlemsIndeks].getStatusIndeks();
		if(partnerIndeks >= 0) {
			medlemsTab[partnerIndeks].setStatusIndeks(-1);
		}
		
		medlemsTab[medlemsIndeks].setStatusIndeks(-1);
	}

	
	
}
