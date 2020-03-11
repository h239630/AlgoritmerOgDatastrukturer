package no.hvl.dat102.listeklient;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class KlientPerson {

	public static void main(String[] args) {

		Person anne = new Person("Anne", "Iversen", 1997);
		Person ole = new Person("Ole", "Vik", 1995);
		Person bendik = new Person("Bendik", "Ness", 1997);
		Person per = new Person("Per", "Iversen", 2000);
		
		OrdnetListeADT<Person> liste = new TabellOrdnetListe<Person>();
		OrdnetListeADT<Person> liste2 = new KjedetOrdnetListe<Person>();
		
		liste.leggTil(anne);
		liste.leggTil(ole);
		liste.leggTil(bendik);
		liste.leggTil(per);
		
		liste2.leggTil(anne);
		liste2.leggTil(ole);
		liste2.leggTil(bendik);
		liste2.leggTil(per);
		
		Person person = null;
		
		while(!liste.erTom()) {
			person = liste.fjernFoerste();
			System.out.println(person);
		}
		System.out.println("------------------------");
		
		while(!liste2.erTom()) {
			person = liste2.fjernFoerste();
			System.out.println(person);
		}
		

	}

}
