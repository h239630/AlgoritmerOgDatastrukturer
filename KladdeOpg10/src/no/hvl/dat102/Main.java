package no.hvl.dat102;

public class Main {
	
	
	
	public static void main(String[] args) {
		ToTre_Tre t = new ToTre_Tre();
		TreNode a = new TreNode(10, 50);
		TreNode b = new TreNode(20, 30);
		ToNode c = new ToNode(5);
		ToNode d = new ToNode(100);
		a.setVenstre(c);
		a.setMidten(b);
		a.setHoyre(d);
		t.setRot(a);
		t.visInOrden();
		
		System.out.println(a.toString());
	}

}
