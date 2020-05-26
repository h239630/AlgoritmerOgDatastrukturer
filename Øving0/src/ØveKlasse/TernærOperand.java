package ØveKlasse;

public class TernærOperand {
	public static int Maks(int x, int y) {
		return x > y ? x : y; 
	}
	public static void main(String[] args) {
		int H = 9; 
		int V = 6; 
		
		System.out.println(Maks(H, V));
	
	}

}
