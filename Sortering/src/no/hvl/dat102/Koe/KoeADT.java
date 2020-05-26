package no.hvl.dat102.Koe;

import no.hvl.dat102.Koe.EmptyCollectionException;
/**
 * 
 * @author Gruppe 4
 *
 * @param <T> Element
 */

public interface KoeADT<T> {
	
	/**
	 * Legger inn et element bakerst i køen. 
	 */

	public void innKoe (T element);
	
	/**
	 * Tar ut et element som ligger først i køen og fjerner det fra køen. 
	 * @return <T> element
	 * @exception EmptyCollectionException
	 */
	
	public T utKoe() throws EmptyCollectionException; 
	
	/**
	 * Finner det første elementet i køen
	 * @return <T> element
	 * @exception EmptyCollectionException
	 */
	
	public T foerste() throws EmptyCollectionException; 
	
	/**
	 * Sjekker om en kø er tom
	 * @return boolean
	 */
	
	public boolean erTom(); 
	
	/**
	 * Finner antall elementer i kø.
	 * @return Antall i kø
	 */
	
	public int antall(); 
	
}
