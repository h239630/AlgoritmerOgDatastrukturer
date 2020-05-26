package no.hvl.dat102;

import java.time.Duration;
import java.time.Instant;

public class SolveTowers {
	
	public static void main(String[] args) {
		Instant start = Instant.now();
		for (int disks = 31; disks <= 31; disks++) {
			TowersOfHanoi towers = new TowersOfHanoi(disks);
			towers.solve();
			System.out.println("Antall flytt med " + disks + " ringer er " + towers.getAntallFlytt());
		}
		Instant finish = Instant.now();
		long timeMillis = Duration.between(start, finish).toMillis(); 
		double timeSeconds = timeMillis / 1000.0;
		
		System.out.println(timeMillis + " millisekund");
		System.out.println(timeSeconds + " sekund");
		
	}
	

}
