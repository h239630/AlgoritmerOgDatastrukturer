package no.hvl.dat102.datakontaktfirma;

public class Hobby {
	private String hobbyNavn;

	public Hobby(String hobby) {
		this.hobbyNavn = hobby;
	}
	public String getHobbyNavn() {
		return hobbyNavn;
	}
	public void setHobbyNavn(String hobby) {
		this.hobbyNavn = hobby;
	}
	@Override
	public String toString() {
//returnerer hobbynavnet med ”<” foran og ”>” bak som en String (Eksempel: <tegne, male>)
		return hobbyNavn.toString();
	}
	@Override
	public boolean equals(Object hobby2) { //
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
}// end Hobby
