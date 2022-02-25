package lesschtroumpfs;

import java.util.ArrayList;

public class Village {
	private String nom;
	private ArrayList<Schtroumpf> schtroumpfs;
	private int stock;
	
	public Village(String pfNomV, int pfStockSalsepareille, String[] pfNomsDesSchtroumpfs) {
		this.nom = pfNomV;
		this.stock = pfStockSalsepareille;
		this.schtroumpfs = new ArrayList<Schtroumpf>();
		for (String nom : pfNomsDesSchtroumpfs) {
			this.schtroumpfs.add(new Schtroumpf(nom, (int) (Math.random()*150), this));
		}
	}
	
	/**
	 * Renvoie le nom du Village
	 * @return nom du Village
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Renvoie le nombre de Schtroumpfs qui vivent dans le Village
	 * @return nombre de Schtroumpfs vivant dans le Village
	 */
	public int getNbSchtroumpf() {
		return this.schtroumpfs.size();
	}
	
	/**
	 * Renvoie le nombre de feuilles de salsepareille dans le stock du Village
	 * @return nombre de feuilles de salsepareille dans le stock du Village
	 */
	public int getStockSalsepareille() {
		return this.stock;
	}
	
	/**
	 * Fait fêter le solstice d'été au Village !
	 */
	public void solstice_d_ete() {
		int nbContents = 0;
		System.out.println("Solstice d'été de " + this.nom + " !");
		for (Schtroumpf sch : this.schtroumpfs) {
			sch.sePresenter();
			sch.chanter();
			if (sch.estContent()) {
				nbContents++;
			}
		}
		System.out.println(this.schtroumpfs.size() + " Schtroumpfs étaient présents");
		System.out.println(nbContents + " Schtroumpfs étaient contents\n");
	}
	
	/**
	 * Permet d'obtenir le Schtroumpf le plus âgé du Village
	 * @return Schtroumpf le plus âgé du Village
	 */
	public Schtroumpf chefDuVillage() {
		Schtroumpf plusVieux = this.schtroumpfs.get(0);
		for (Schtroumpf sch : this.schtroumpfs) {
			if (sch.getAge() > plusVieux.getAge()) {
				plusVieux = sch;
			}
		}
		return plusVieux;
	}
	
	/**
	 * Envoie au travail la moitié des Schtroumpfs du village
	 */
	public void envoyerAuTravail() {
		boolean dernierEnvoye = false;
		for (Schtroumpf sch : this.schtroumpfs) {
			if (sch.estContent()) {
				if (!dernierEnvoye) {
					sch.allerTravailler();
					dernierEnvoye = true;
				} else {
					dernierEnvoye = false;
				}
			}
		}
	}
	
	/**
	 * Fait se présenter et chanter les Schtroumpfs heureux du Village
	 */
	public void schtroumpsfHeureux() { 
		for (Schtroumpf sch : this.schtroumpfs) {
			if (sch.estContent()) {				
				sch.sePresenter();
				sch.chanter();
			}
		}
	}
	
	// 5.2 Gérer la salsepareille
	/**
	 * Ajoute une quantité de feuilles de salsepareille au stock du Village
	 * Précondition:
	 * Quantité positive
	 * @param pfQte quantité de feuilles de salsepareille à ajouter
	 */
	public void ajouterStock(int pfQte) {
		if (pfQte > 0) {			
			this.stock += pfQte;
		}
	}
	
	/**
	 * Retire une quantité de feuilles de salsepareille au stock du Village
	 * Précondition:
	 * Quantité positive
	 * @param pfQte quantité de feuilles de salsepareille à retirer
	 */
	public void retirerStock(int pfQte) {
		if (pfQte > 0) {			
			this.stock -= pfQte;
		}
	}
	
	/**
	 * Fait diner tous les Schtroumpfs du Village (dans la limite du stock)
	 */
	public void dinerTousEnsemble() {
		for (Schtroumpf sch : this.schtroumpfs) {
			sch.dinerAuVillage();
		}
	}
	
	/**
	 * Envoie cueillir un Schtroumpf sur deux du Village
	 */
	public void envoyerCueillirSalsepareille() {
		boolean dernierEnvoye = false;
		for (Schtroumpf sch : this.schtroumpfs) {
			if (sch.estContent()) {
				if (!dernierEnvoye) {
					sch.recolterSalsepareille();
					dernierEnvoye = true;
				} else {
					dernierEnvoye = false;
				}
			}
		}
	}
}
