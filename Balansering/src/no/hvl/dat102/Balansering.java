package no.hvl.dat102;

import java.io.*;


public class Balansering {

	TabellStabel<ParentesInfo> stabel = new TabellStabel<ParentesInfo>();

	
	private boolean passer(char �pent, char lukket) {
		switch (�pent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	/*
	 * 	Balansering av uttrykk med parenteser {},(),[]
	 * 	{ [ ( kalles for �pne symboler (venstre)
	 *	} ] ) kalles lukkete symboler (h�yre)
	 *	...{... [...(...)...]...}... lovlig (balansert) utrykk
	 *	...{...(...[...)...]...}...  ulovlig (ikke balansert) uttrykk
	 * 	algoritme balansering
	 *  Lag en tom stabel
	 *  s� lenge( ikke-slutt p� strengen og fortsatt balansert){
	 *    hvis symbolet er �pent 
	 *           stable det p�
	 *    ellers hvis  symbolet er lukket 
	 *         hvis stabelen er tom 
	 *            sett fortsatt = usann, feilmelding
	 *         ellers
	 *              stable av symbol (�pent symbol)
	 *              hvis det �pne symbolet ikke svarer til det sist leste
	 *              lukkete symbolet
	 *                  sett fortsatt = usann, feilmelding
	 *	}
	 *   hvis stabelen er ikke-tom s� feilmelding
	 */
	public void foretaBalansering(String innDataStreng, int linjenr) {
        
		int lengde = innDataStreng.length();
		boolean balansert = true;
		int i = 0;

		
		while (i < lengde && balansert) {
			char tegn = innDataStreng.charAt(i);
			if (tegn == '(' || tegn == '{' || tegn == '[') {
				ParentesInfo pI = new ParentesInfo();
				pI.setLinjenr(linjenr);
				pI.setPosisjon(i);
				pI.setVenstreparentes(tegn);
				stabel.push(pI); 
				
			} else if ( tegn ==')' || tegn == '}' || tegn == ']') {
				if (stabel.erTom()) {
					balansert = false; 
					//Feilmelding
					//Mangler �pne parentes
					System.out.println("P� linje " + linjenr + 
							"\nFant lukke symbolet " + tegn + " uten tilh�rende �pne symbol");
					
				} else {
					ParentesInfo vP = stabel.pop();
					if (!passer(vP.getVenstreparentes(), tegn)) {
						balansert = false;
						//Feilmelding
						//Feil �pne parentes i forhold til lukke parentes
						System.out.println("P� linje " + linjenr + 
								"\nLukke symbolet " + tegn + " er ikke samme type som " + vP.getVenstreparentes());
					}
					
				}
				// { ( [ ) ] ) }
			}
			i++;
		}//while l�kken
		// Feimelding 1 og feilmelding 2 
	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}
		
		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 1;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				foretaBalansering(linje, linjenr);
				linje = tekstLeser.readLine();
				linjenr++;
			} // while
			// Feilmelding 3
			//Et �pent symbol uten at det er lukke symbol
			
			if(!stabel.erTom()) {
				System.out.println("Ett eller flere �pne-symbol har ikke tilsvarende lukke-symbol.");
			}
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// metode

}// class
