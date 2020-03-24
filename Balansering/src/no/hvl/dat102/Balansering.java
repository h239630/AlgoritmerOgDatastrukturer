package no.hvl.dat102;

import java.io.*;


public class Balansering {

	TabellStabel<ParentesInfo> stabel = new TabellStabel<ParentesInfo>();

	
	private boolean passer(char åpent, char lukket) {
		switch (åpent) {
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
	 * 	{ [ ( kalles for åpne symboler (venstre)
	 *	} ] ) kalles lukkete symboler (høyre)
	 *	...{... [...(...)...]...}... lovlig (balansert) utrykk
	 *	...{...(...[...)...]...}...  ulovlig (ikke balansert) uttrykk
	 * 	algoritme balansering
	 *  Lag en tom stabel
	 *  så lenge( ikke-slutt på strengen og fortsatt balansert){
	 *    hvis symbolet er åpent 
	 *           stable det på
	 *    ellers hvis  symbolet er lukket 
	 *         hvis stabelen er tom 
	 *            sett fortsatt = usann, feilmelding
	 *         ellers
	 *              stable av symbol (åpent symbol)
	 *              hvis det åpne symbolet ikke svarer til det sist leste
	 *              lukkete symbolet
	 *                  sett fortsatt = usann, feilmelding
	 *	}
	 *   hvis stabelen er ikke-tom så feilmelding
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
					//Mangler åpne parentes
					System.out.println("På linje " + linjenr + 
							"\nFant lukke symbolet " + tegn + " uten tilhørende åpne symbol");
					
				} else {
					ParentesInfo vP = stabel.pop();
					if (!passer(vP.getVenstreparentes(), tegn)) {
						balansert = false;
						//Feilmelding
						//Feil åpne parentes i forhold til lukke parentes
						System.out.println("På linje " + linjenr + 
								"\nLukke symbolet " + tegn + " er ikke samme type som " + vP.getVenstreparentes());
					}
					
				}
				// { ( [ ) ] ) }
			}
			i++;
		}//while løkken
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
			//Et åpent symbol uten at det er lukke symbol
			
			if(!stabel.erTom()) {
				System.out.println("Ett eller flere Åpne-symbol har ikke tilsvarende lukke-symbol.");
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
