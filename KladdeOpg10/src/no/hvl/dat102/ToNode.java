package no.hvl.dat102;

public class ToNode extends Node {
	
	private Integer element; 
	private Node venstre;
	private Node hoyre; 
	
	public ToNode(Integer el) {
		this.element = el; 
		venstre = null; 
		hoyre = null;
	}

	public ToNode(Integer element, Node venstre, Node hoyre) {
		super();
		this.element = element;
		this.venstre = venstre;
		this.hoyre = hoyre;
	}

	public Integer getElement() {
		return element;
	}

	public void setElement(Integer element) {
		this.element = element;
	}

	public Node getVenstre() {
		return venstre;
	}

	public void setVenstre(Node venstre) {
		this.venstre = venstre;
	}

	public Node getHoyre() {
		return hoyre;
	}

	public void setHoyre(Node hoyre) {
		this.hoyre = hoyre;
	}

	@Override
	public String toString() {
		return "ToNode [element = " + element + "]";
	}


}
