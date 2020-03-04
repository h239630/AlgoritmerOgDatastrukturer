package no.hvl.dat102.datakontaktfirma;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks; 
	
	//Konstruktør for kjedet mengde
//	public Medlem(String navn, int indeks) {
//		this.navn = navn;
//		hobbyer = new KjedetMengde<Hobby>();
//		this.statusIndeks = indeks;
//	}
	
	//Konstruktør for tabell mengde
	public Medlem(String navn) {
		this.navn = navn; 
		hobbyer = new TabellMengde<Hobby>();
		this.statusIndeks = -1; 
	}
	
	public String getNavn() {
		return this.navn;
	}
	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}
	public int getStatusIndeks() {
		return statusIndeks;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public void setHobby(Hobby hob) {
		hobbyer.leggTil(hob);
	}	
	public void setStatusIndeks(int indeks) {
		this.statusIndeks = indeks; 
	}
	public boolean passerTil(Medlem m2) {
		return hobbyer.equals(m2.getHobbyer());
	}
		
	public String toString() {
		//KjedetMengde<Hobby> h = (KjedetMengde<Hobby>)(hobbyer);
		TabellMengde<Hobby> h = (TabellMengde<Hobby>)(hobbyer);
		String status;
		if (statusIndeks == -1) {
			status = "Ikke koblet";
		} else {
			status = "Koblet";
		}
		return "Medlemsnavn: " + navn + "\n" +"Hobbyer: " + h.toString() + "\n" + "Status: " + status;
	}
}
