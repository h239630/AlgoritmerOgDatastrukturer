package no.hvl.dat102.adt;

import java.util.*;

public interface BSTreADT<T extends Comparable<T>> {
	// Burde hatt javadoc her
	// Anbefaler at du fyller ut med javadoc her som kan vaere en del av 
	// øvingen. Flere metoder må fylles ut i implementasjonsfilen.
	//Legg merke til at i denne imlementasjonen er det ikke brukt exceptions som
	// vi kunne hatt og som vi har brukt for i flere av de andre samlingene.

	/*****************************************************************
	 * Returnerer sann hvis dette binaere treet er tomt og usann ellers.
	 *****************************************************************/
	/**
	 * @param Finner antallet i treet
	 * @return antall elementer i treet. 
	 */
	public int antall();

	/*****************************************************************
	 * Returnerer sann hvis dette binære treet er tom og usann ellers.
	 *****************************************************************/
	
	/**
	 * @param Returnerer sann hvis dette binære treet er tom og usann ellers.
	 * @return en boolsk verdi
	 */
	public boolean erTom();

	/******************************************************************
	 * Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 ******************************************************************/
	
	/** 
	 * 
	 * @param Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 */
	public void leggTil(T element);

	/**********************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * binære treet ellers returneres null./
	 ************************************************************************/
	/**
	 * 
	 * @param Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * binære treet ellers returneres null
	 * @return funnet element.
	 */
	public T finn(T element);
	
	/*****************************************************************
	 * Returnerer en referanse til minste elementet, null viss tre er tomt.
	 *****************************************************************/
	/**
	 * @param Returnerer en referanse til minste elementet, null viss tre er tomt.
	 * @return minste element
	 */
	public T finnMin();
	
	/*****************************************************************
	 * Returnerer en referanse til største elementet, null viss tre er tomt.
	 *****************************************************************/
	/**
	 * @param Returnerer en referanse til største elementet, null viss tre er tomt.
	 * @return største element
	 */
	public T finnMaks();

	/************************************************************************
	 * Fjerner et element fra dette treet hvis det fins, ellers returneres null
	 ************************************************************************/
	
	// public T fjern( T element);
	// Ikke impelmentert
	
	/************************************************************************
	 * Fjerner minste elementet fra dette treet hvis det fins, ellers returneres null
	 ************************************************************************/
	/**
	 * @param Fjerner minste elementet fra dette treet hvis det fins, ellers returneres null
	 * @return elementet som skal fjernes
	 */
	public T fjernMin();
	
	/************************************************************************
	 * Fjerner største elementet fra dette treet hvis det fins, ellers returneres null
	 ************************************************************************/
	/**
	 * @param Fjerner største elementet fra dette treet hvis det fins, ellers returneres null
	 * @return elementet som skal fjernes
	 */
	public T fjernMaks();
}
