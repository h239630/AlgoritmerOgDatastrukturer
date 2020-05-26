package no.hvl.dat102;

public class TowersOfHanoi {
	 private int totalDisks;
	 private long antallFlytt;
	 
	 public TowersOfHanoi(int disks) {
		 totalDisks = disks; 
	 }
	 
	 public void solve() {
		 moveTower(totalDisks, 1, 3, 2);
	 }
	 
	 private void moveTower(int numDisks, int start, int end, int temp) {
		 if (numDisks == 1) {
			 moveOneDisk(start, end); 
		 } else {
			 moveTower(numDisks-1, start, temp, end);
			 moveOneDisk(start, end);
			 moveTower(numDisks-1, temp, end, start);
		 }
		 
	 }
	 private void moveOneDisk(int start, int end) {
		 //System.out.println("Move one disk from " + start + " to " + end);
		 antallFlytt++;
	 }
	 public long getAntallFlytt() {
		 return antallFlytt; 
	 }
	 public void setDisks(int d) {
		 totalDisks = d; 
	 }
}
