package oppgaver;

public class RekursiveOppgaver {
	
	/* Oppgave 1
	 * 
	 * Lag en rekursiv metode public static void snuTall (int tall) 
	 * som skriver ut et positivt heltall baklengs. 
	 * Tips: For å finne siste siffer i et tall, kan du bruke %. 
	 * For å kutte siste siffer i et tall kan du bruke heltalsdivisjon.
	 */ 
	public static void snuTall(int tall) {
		if (tall < 10) {
			System.out.print(tall);
		} else {
			System.out.print(tall % 10);
			snuTall(tall / 10);
		} 
	}
	
	/* Oppgave 2
	 * 
	 * Lag en metode public static void snuTabell(int[] tab)
	 * som ved hjelp av en rekursiv metode snur en fylt tabell
	 * slik at det første elementet kommer sist, det andre nest sist osv.
	 */
	private static void snuTabell(int[] tab, int min, int maks) {
		if (min < maks) {
			int temp = tab[min];
			tab[min] = tab[maks];
			tab[maks] = temp;
			snuTabell(tab, min + 1, maks -1);
		} 
	}
	public static void snuTabell(int[] tab) {
		snuTabell(tab, 0, tab.length - 1); 
		
	}
	
	
	
	public static void main(String[] args) {
		snuTall(13478);
		System.out.println("");
		int[] tab = {4, 6, 2, 1, 9};
		for (int i : tab)
			System.out.print(i);
	
		snuTabell(tab);
		System.out.println("");
		for (int i : tab)
			System.out.print(i);
	}

}
