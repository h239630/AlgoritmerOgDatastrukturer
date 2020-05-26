package no.hvl.dat102;

public class Butikk {
	private String navn;
	private Vare[] varer;
	private int antallTyper;
	private int maksAntall;

	public Butikk(String navn, int antall) {
		this.navn = navn;
		this.varer = new Vare[antall];
		this.maksAntall = antall;
		this.antallTyper = 0;
	}
	public String getNavn() {
		return this.navn;
	}
	public int getMaksAntall() {
		return this.maksAntall;
	}
	public void setNavn(String navn) { 
		this.navn = navn;
	}
	public void setMaksAntall(int antall) { 
		this.maksAntall = antall; 
	}

	public int finnVare(int varenr) {
		int pos = -1;
		for (int i = 0; i < varer.length; i++) {
			if (varer[i] != null && varer[i].getVarenummer() == varenr) {
				pos = i;
			}
		}
		return pos;
	}

	public boolean erLedigPlass() {
		return antallTyper < varer.length;
	}

	public void leggInnNyVare(int varenr) {
		Vare vare = new Vare(varenr);
		int finnesVare = finnVare(vare.getVarenummer());
		if (finnesVare != -1) {
			System.out.println("Vare finnes fra før");
		}
		int i = 0;
		while (varer[i] != null && varer[i].getVarenummer() < varenr && i < antallTyper) {
			i++;
		}
		int j = antallTyper; 
		while (j > i) {
			varer[j] = varer[j-1];
			j--; 
		}
		varer[i] = vare;
		antallTyper++;
		
	}
	
	public void slettVare(int varenr) { 
		int pos = finnVare(varenr);
		if (pos == -1) {
			System.out.println("Varen finnes ikke i butikken"); 
		}
		 
		while (pos < antallTyper) {
			varer[pos] = varer[pos+1];
			pos++; 
		}
		antallTyper--;
		
	}
	
	public void detaljSalg(int varenr) {
		int pos = finnVare(varenr);
		if(pos == -1) {
			System.out.println("Varen finnes ikke i registreret"); 
		} else {
			int antall = varer[pos].getAntall();
			if (antall > 0) {
				antall--; 
				varer[pos].setAntall(antall);
			} else {
				System.out.println("Varen er ikke på lager"); 
			}
		}
	}
	public void grossInnkjøp(int varenr, int ant) { 
		int pos = finnVare(varenr);
		if(pos == -1) {
			System.out.println("Varen finnes ikke i registreret"); 
		} else { 
			if(ant < 0) {
				System.out.println("Antall innkjøpte varer kan ikke være negativ");
			} else {
				int antall = varer[pos].getAntall();
				antall = antall + ant; 
				varer[pos].setAntall(antall);
			}
		}
	}
	
	public double salgsVerdi() {
		double total = 0; 
		for (Vare v : varer) {
			total += v.getPris();
		}
		return total; 
	}
	public void skrivUtVarer() {
		for (int i = 0; i < antallTyper; i++) {
			System.out.println(varer[i].toString());
		}
	}
}
