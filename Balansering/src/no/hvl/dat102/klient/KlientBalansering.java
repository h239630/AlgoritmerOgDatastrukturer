package no.hvl.dat102.klient;

import no.hvl.dat102.Balansering;

public class KlientBalansering{
     public static void main(String[] args){
        final String filnavn = "C:\\DAT102\\AlgoritmerOgDatastrukturer\\Balansering\\src\\no\\hvl\\dat102\\Klient\\SummerOppTil.java";
        //Leser inn en tekst fra fil
        Balansering balansering = new Balansering();
        balansering.lesFraFil(filnavn);
 }//main
}//class
