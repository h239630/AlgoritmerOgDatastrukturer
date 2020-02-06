package no.hvl.dat102;

public class Film {
	private int nr;
	private String produsent;
	private String tittel; 
	private int aar; 
	private String selskap;
	private Sjanger sjanger; 
	
	public Film() {
		//Tom konstruktør
	}
	public Film(int nr) {
		this.nr = nr; 
		//Konstruktør med kun filmnummer
	}

	public Film(int nr, String prod, String tittel, int aar, String selskap, Sjanger sj) {
		this.nr = nr; 
		this.produsent = prod; 
		this.tittel = tittel;
		this.aar = aar; 
		this.selskap = selskap;
		this.sjanger = sj; 
	}
	public void setNr(int nr) {
		this.nr = nr; 
	}
	public void setProdusent(String produsent) {
		this.produsent = produsent; 
	}
	public void setTittel(String tittel) {
		this.tittel = tittel; 
	}
	public void setAar(int aar) {
		this.aar = aar; 
	}
	public void setSelskap(String selskap) {
		this.selskap = selskap; 
	}
	public void setSjanger(Sjanger sj) {
		this.sjanger = sj; 
	}
	public int getNr() {
		return this.nr; 
	}
	public String getProdusent() {
		return this.produsent;
	}
	public String getTittel() {
		return this.tittel;
	}
	public int getAar() {
		return this.aar;
	}
	public String getSelskap() {
		return this.selskap; 
	}
	public Sjanger getSjanger() {
		return sjanger; 
	}

}
