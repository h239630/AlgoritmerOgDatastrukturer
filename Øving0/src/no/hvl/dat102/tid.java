package no.hvl.dat102;

public class tid {
	public static void tidTest(long n) {
		long time1 = System.currentTimeMillis(); 
		long k = 0;
		for (int i = 1; i < n; i++) {
			k = k + 5; 
		}
		long time2 = System.currentTimeMillis();
		long total = time2 - time1;
		System.out.println("Total tid på kjøring: " + total);
	}

	public static void main(String[] args) {
		tidTest(100000000L);
		tidTest(1000000000L);
		tidTest(10000000000L);
	}
}
