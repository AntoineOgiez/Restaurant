package projet;

import java.util.ArrayList;


public class Restaurant{
	
	private String nom;
	private ArrayList<Depense> depenses = new ArrayList<Depense>();
	private ArrayList<Depense> revenus = new ArrayList<Depense>();
	
	public Restaurant(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	public ArrayList<Depense> getDepenses() {
		return depenses;
	}

	public void setDepenses(ArrayList<Depense> depenses) {
		this.depenses = depenses;
	}

	public ArrayList<Depense> getRevenus() {
		return revenus;
	}

	public void setRevenus(ArrayList<Depense> revenus) {
		this.revenus = revenus;
	}
}
