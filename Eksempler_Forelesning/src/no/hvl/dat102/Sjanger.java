package no.hvl.dat102;

public enum Sjanger {
	ACTION, DRAMA, HISTORY, SCIFI;

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;
		for (Sjanger s : Sjanger.values()) {
			if (s.toString().equals(navn.toUpperCase())) {
				sjang = s;
				break;
			}
		}
		return sjang;
	}
}
