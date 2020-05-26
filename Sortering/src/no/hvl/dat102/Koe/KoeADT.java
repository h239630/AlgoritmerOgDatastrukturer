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
	 * Legger inn et element bakerst i k�en. 
	 */

	public void innKoe (T element);
	
	/**
	 * Tar ut et element som ligger f�rst i k�en og fjerner det fra k�en. 
	 * @return <T> element
	 * @exception EmptyCollectionException
	 */
	
	public T utKoe() throws EmptyCollectionException; 
	
	/**
	 * Finner det f�rste elementet i k�en
	 * @return <T> element
	 * @exception EmptyCollectionException
	 */
	
	public T foerste() throws EmptyCollectionException; 
	
	/**
	 * Sjekker om en k� er tom
	 * @return boolean
	 */
	
	public boolean erTom(); 
	
	/**
	 * Finner antall elementer i k�.
	 * @return Antall i k�
	 */
	
	public int antall(); 
	
}
