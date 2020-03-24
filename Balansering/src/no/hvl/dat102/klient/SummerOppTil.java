package no.hvl.dat102.klient;

public class SummerOppTil {
	
	public static int summerOppTil(int tall) {
		int sum; 
		if (tall == 1) {
			sum = 1; 
		} else {
			sum = tall + summerOppTil(tall - 1); 
		}
		return sum;	
	}
	
	public static void main(String [] args) {
		int resultat = summerOppTil(100);
		System.out.println("Summen av 1 til 100: " + resultat);
	}

}
