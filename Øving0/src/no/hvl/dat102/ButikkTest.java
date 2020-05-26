package no.hvl.dat102;

public class ButikkTest {

	public static void main(String[] args) {
		
		Butikk testButikk = new Butikk("Mikkes", 100); 
		testButikk.leggInnNyVare(1);
		testButikk.leggInnNyVare(3);
		testButikk.leggInnNyVare(6);
		testButikk.leggInnNyVare(9);
		testButikk.leggInnNyVare(2);
		testButikk.leggInnNyVare(4);
		
		testButikk.skrivUtVarer();
		System.out.println("-------------------");
		testButikk.slettVare(3);
		testButikk.skrivUtVarer();
	}
}
