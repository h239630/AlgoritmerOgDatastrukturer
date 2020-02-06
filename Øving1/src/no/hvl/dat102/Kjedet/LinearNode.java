package no.hvl.dat102.Kjedet;

//  Representerer en node.
public class LinearNode<T> {
	private LinearNode<T> next;
	private T element;

	 // Oppretter en tom node
	public LinearNode() {
		next = null;
		element = null;
	}

	// Oppretter en node med et element.
	public LinearNode(T elem) {
		next = null;
		element = elem;
	}

	// Returnerer etterfølger
	public LinearNode<T> getNext() {
		return next;
	}

	//Setter neste til node
	 public void setNext(LinearNode<T> node) {
		next = node;
	}

	//Returnerer elementet til denne noden
	public T getElement() {
		return element;
	}

	//Setter nytt element i denne noden.
	public void setElement(T elem) {
		element = elem;
	}
}
