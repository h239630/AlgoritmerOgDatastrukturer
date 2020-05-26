package no.hvl.dat102;

import java.util.Scanner;

public class Vare {
	private int varenummer; 
	private String varenavn; 
	private double pris; 
	private int antall; 
	
	public Vare() {
		
	}
	
	public Vare(int varenr) {
		this.varenummer = varenr;
	}
	
	public Vare(int varenr, String navn, double pris, int antall) { 
		this.varenummer = varenr; 
		this.varenavn = navn; 
		this.pris = pris; 
		this.antall = antall; 
	}
	
	public int getVarenummer() {
		return this.varenummer;
	}
	public String getVarenavn() {
		return this.varenavn;
	}
	public double getPris() {
		return this.pris;
	}
	public int getAntall() {
		return this.antall; 
	}
	public void setVarenummer(int varenummer) {
		this.varenummer = varenummer; 
	}
	public void setVarenavn(String navn) {
		this.varenavn = navn; 
	}
	public void setPris(double pris) {
		this.pris = pris; 
	}
	public void setAntall(int antall) {
		this.antall = antall; 
	}
	
	public void lesVare() {
		System.out.println("Oppgi navn på vare:");
		Scanner leser = new Scanner(System.in); 
		this.varenavn = leser.nextLine();
		System.out.println("Oppgi pris på vare:");
		double pris = leser.nextDouble();
		while (pris < 0) {
			System.out.println("Ikke tillat med negativ verdi, legg inn på nytt:");
			pris = leser.nextDouble();
		}
		this.pris = pris;
		leser.close();
	}
	public String toString() {
	
		return "Varenummer: " + varenummer + "\nVarenavn: " + varenavn + "\nPris: " + pris + "\nAntall: " + antall; 
	}
}
