package no.hvl.dat102;

public class Oppgave1 {
	

	/* a) 
	 * Summen av de n første naturlige tall er gitt ved: Sn = 1+2+3+…+n
	 * En formel for å finne Sn er gitt ved: Sn = Sn-1 + n, S1 = 1
	 * Lag en rekursiv Java-metode som beregner Sn, og skriv et enkelt hovedprogram 
	 * som bruker denne metoden for å finne S100.
	 * 
	 * Summen av 1 til 100 er summen av 100 + summen av 1 til 99
	 */
	public static int summerOppTil(int tall) {
		int sum; 
		if (tall == 1) {
			sum = 1; 
		} else {
			sum = tall + summerOppTil(tall - 1); 
		}
		return sum; 
	}
	/* b)
	 * Gitt tallfølgen { a_n } der de enkelte ledd kan finnes med formelen:
	 * a_n = 5a_n-1 - 6a_n-2 + 2 for n > 1 og startkrav a_0 = 2, a_1 = 5
	 * Lag en rekursiv Java-metode som beregner a_n, og skriv et enkelt hovedprogram 
	 * som bruker denne metoden til å vise de 10 første leddene i tallfølgen.
	 * 
	 */
	public static int ledd(int n) { //n-variabelen er antall ledd
		int svar; 
		if(n == 1) {
			svar = 5;
		} else if (n == 0) {
			svar = 2; 
		} else {
			svar = (5 * ledd(n-1)) - (6 * ledd(n-2)) + 2;
		}
		return svar; 
	}
	
	public static void main(String[] args) {
		int resultat = summerOppTil(100);
		System.out.println("Summen av 1 til 100: " + resultat);
		int tallfølge;
		for (int i = 0; i < 10; i++) {
			tallfølge = ledd(i);
			System.out.println("Ledd " + i + " gir " + tallfølge);

		}		
	}

}
