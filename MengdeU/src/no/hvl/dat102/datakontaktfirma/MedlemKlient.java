package no.hvl.dat102.datakontaktfirma;

public class MedlemKlient {
	
	public static void skrivUt(Medlem m) {
		System.out.println(m.toString());
	}
	
	public static void main(String[] args) {
		 
		Medlem nr2 = new Medlem("Per");
		Hobby maling = new Hobby("Maling");
		Hobby pusle = new Hobby("Pussling");
		nr2.setHobby(maling);
		nr2.setHobby(pusle);
		skrivUt(nr2);
	}

}
