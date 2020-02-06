package no.hvl.dat102.adt;

import no.hvl.dat102.exception.EmptyCollectionException;


public interface KoeADT<T> {

	public void innKoe (T element);
	
	public T utKoe() throws EmptyCollectionException; 
	
	public T foerste() throws EmptyCollectionException; 
	
	public boolean erTom(); 
	
	public int antall(); 
	
}
