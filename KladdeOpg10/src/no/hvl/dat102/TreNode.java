package no.hvl.dat102;

public class TreNode extends Node {

	private Integer minste;
	private Integer stoerste;
	private Node venstre;
	private Node midten;
	private Node hoyre;
	
	public TreNode(Integer min, Integer maks) {
		this.minste = min;
		this.stoerste = maks; 
		venstre = null;
		midten = null; 
		hoyre = null; 
	}

	public TreNode(Integer minste, Integer stoerste, Node venstre, Node midten, Node hoyre) {
		super();
		this.minste = minste;
		this.stoerste = stoerste;
		this.venstre = venstre;
		this.midten = midten;
		this.hoyre = hoyre;
	}


	public Integer getMinste() {
		return minste;
	}

	public void setMinste(Integer minste) {
		this.minste = minste;
	}

	public Integer getStoerste() {
		return stoerste;
	}

	public void setStoerste(Integer stoerste) {
		this.stoerste = stoerste;
	}

	public Node getVenstre() {
		return venstre;
	}

	public void setVenstre(Node venstre) {
		this.venstre = venstre;
	}

	public Node getMidten() {
		return midten;
	}

	public void setMidten(Node midten) {
		this.midten = midten;
	}

	public Node getHoyre() {
		return hoyre;
	}

	public void setHoyre(Node hoyre) {
		this.hoyre = hoyre;
	}

	@Override
	public String toString() {
		return "TreNode [minste=" + minste + ", stoerste=" + stoerste + "]";
	}

}
