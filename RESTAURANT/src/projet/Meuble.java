package projet;

public class Meuble extends Depense{
	
	private int surface;
	
	public Meuble(int surface) {
		this.surface = surface;
	}
	
	public int getSurface() {
		return surface;
	}
	
	public void setSurface(int newSurface) {
		surface = newSurface;
}
}
