package no.hvl.dat102.datakontaktfirma;



public class DatakontaktKlient {
	
	public static void main(String[] args) {
		Tekstgrensesnitt tg = new Tekstgrensesnitt(); 
		Datakontakt arkiv = new Datakontakt(4);
		
		//Testdata
		Medlem m1 = new Medlem("Ingelin");
		Medlem m2 = new Medlem("Mikael");
		Medlem m3 = new Medlem("Paal");
		Medlem m4 = new Medlem("Melly");
		
		Hobby male = new Hobby("Male");
		Hobby klatre = new Hobby("Klatre");
		Hobby trene = new Hobby("Trene");
		Hobby film = new Hobby("Film");
		
		m4.setHobby(male);
		m4.setHobby(film);
		m2.setHobby(male);
		m2.setHobby(film);
		m3.setHobby(klatre);
		m3.setHobby(film);
		m1.setHobby(trene);
		m1.setHobby(klatre);
		
		arkiv.leggTilMedlem(m1);
		arkiv.leggTilMedlem(m2);
		arkiv.leggTilMedlem(m3);
		arkiv.leggTilMedlem(m4);
		
		//Tester metodene
		int indeks = arkiv.finnMedlemsIndeks("Melly");
//		System.out.println("Melly har indeks: " + indeks);
//		Medlem melly = arkiv.getMedlem(indeks);
//		System.out.println(melly.toString()); 
		
		int partner = arkiv.finnPartnerFor("Melly");
//		System.out.println("Melly har en partner på indeks: " + partner);
//		Medlem part = arkiv.getMedlem(partner);
//		System.out.println(part.toString());
//		
		
		Tekstgrensesnitt.skrivParListe(arkiv);

	}

}
