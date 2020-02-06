package no.hvl.dat102.koeklient;

public class Kunde {

	private int ankTid, ferdigTid;

	public Kunde(int tid) {
		ankTid = tid;
		ferdigTid = 0;
	}

	public int getAnkTid() {
		return ankTid;
	}

	public void settFerdigTid(int nytid) {
		ferdigTid = nytid;
	}

	public int getFerdigTid() {
		return ferdigTid;
	}

	public int totalTid() {
		return ferdigTid - ankTid;
	}
}