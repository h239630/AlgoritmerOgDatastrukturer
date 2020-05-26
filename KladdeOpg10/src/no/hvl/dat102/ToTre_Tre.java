package no.hvl.dat102;

public class ToTre_Tre  {
	
	private int antall; 
	private Node rot; 
	
	public ToTre_Tre() {
		antall = 0; 
		rot = null; 
	}
	
	public void setRot(Node r) {
		this.rot = r; 
	}

	public void visInOrden() {
		visInOrden(rot);
		System.out.println(" ");
	}
	
	private void visInOrden(Node node) {
		if (node == null) {
			//Gjør ingenting - basis
		} else { 
			if (node instanceof TreNode) {
				TreNode treN = (TreNode) node;
				visInOrden(treN.getVenstre());
				System.out.println(treN.getMinste());
				visInOrden(treN.getMidten());
				System.out.println(treN.getStoerste());
				visInOrden(treN.getHoyre());
			} else {
				ToNode toN = (ToNode) node; 
				visInOrden(toN.getVenstre());
				System.out.println(toN.getElement());
				visInOrden(toN.getHoyre());
			}
		}
	}
}
