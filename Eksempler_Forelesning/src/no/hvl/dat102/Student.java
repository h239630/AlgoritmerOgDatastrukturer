package no.hvl.dat102;

public class Student {
	private int snr;
	private String navn;

	public Student(int snr, String navn) {
		this.snr = snr;
		this.navn = navn;
	}


	public static void main(String[] args){
		Student a = new Student(10, "Ole");
		Student b = new Student(10, "Ole");
		a.equals(b);
		System.out.println(a.hashCode());
		System.out.println(a.hashCode());
	}
}