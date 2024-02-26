 package lesschtroumpfs;

public class Schtroumpf {
	private String nom;
	private int age;
	private boolean content;

	// 5.
	private Village village;
	
	public Schtroumpf(String pfNom, int pfAge) {
		this.nom = pfNom;
		this.age = pfAge;
		this.setContent(true);
		this.setVillage(null);
	}
	
	public Schtroumpf(String pfNom, int pfAge, Village pfVillage) {
		this.nom = pfNom;
		this.age = pfAge;
		this.setContent(true);
		this.setVillage(pfVillage);
	}
	
	/**
	 * Renvoie le nom du Schtroumpf
	 * @return nom du Schtroumpf
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Renvoie l'age du Schtroumpf
	 * @return age du Schtroumpf
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Renvoie si le Schtroumpf est content ou non
	 * @return true si le Schtroumpf est content, false sinon
	 */
	public boolean estContent() {
		return this.content;
	}
	
	public String toString() {
		String s;
		s = "Je suis " + this.getNom();
		s += ", j'ai " + this.getAge();
		s += this.getAge() > 1 ? " ans " : " an ";
		s += "et je suis ";
		if (!this.estContent()) s += "PAS ";
		s += "content, ";
		s += this.getVillage() != null ? "j'habite " + this.getVillage().getNom() : "je suis ermite";
		return s;
	}
	
	/**
	 * Fait se présenter un Schtroumpf 
	 */
	public void sePresenter() {
		System.out.println(this.toString());
	}
	
	/**
	 * Renvoie le chant du Schtroumpf
	 * @return "la, la, la Schtroumpf la, la" si le Schtroumpf est content, "gloups" sinon
	 */
	public String leChant() {
		return this.estContent() ? "la, la, la Schtroumpf la, la" : "gloups";
	}
	
	/**
	 * Affiche le chant du Schtroumpf à l'écran
	 */
	public void chanter() {
		System.out.println(this.leChant());
	}
	
	/**
	 * Donne un an de plus au Schtroumpf
	 */
	public void anniversaire() {
		this.age++;
	}
	
	/**
	 * Fait manger un Schtroumpf :)
	 * @param pfQte nombre de feuilles de salsepareille
	 */
	public void manger(int pfQte) {
		if (pfQte > 0) {			
			this.setContent(true);
		}
	}
	
	/**
	 * Fait aller travailler un Schtroumpf :(
	 */
	public void allerTravailler() {
		this.setContent(false);
	}

	/**
	 * Renvoie le Village auquel appartient le Schtroumpf
	 * @return Village auquel appartient le Schtroumpf, null sinon
	 */
	public Village getVillage() {
		return this.village;
	}

	/**
	 * Modifie le Village auquel appartient le Schtroumpf
	 * @param pfV nouveau Village d'appartenance du Schtroumpf
	 */
	public void setVillage(Village pfV) {
		this.village = pfV;
	}
	
	// 5.2 Gérer la salsepareille
	/**
	 * Modifie l'état du Schtroumpf
	 * @param pfEtat état du Schtroumpf
	 */
	public void setContent(boolean pfEtat) {
		this.content = pfEtat;
	}
	
	/**
	 * Fait récolter de la salsepareille au Schtroumpf
	 * - pour le Village dans lequel il habite
	 * - pour soi-même s'il est ermite
	 */
	public void recolterSalsepareille() {
		if (this.getVillage() != null) {
			this.allerTravailler();
			this.getVillage().ajouterStock(5);
		} else {
			this.allerTravailler();
			this.manger(5);
		}
	}
	
	/**
	 * Fait diner au Village le Schtroumpf
	 * S'il n'a pas de Village, il fait une dépression
	 */
	public void dinerAuVillage() {
		if (this.getVillage() != null) {
			if (this.getVillage().getStockSalsepareille() >= 3) {
				this.getVillage().retirerStock(3);
				this.manger(3);
			}
		} else {
			this.setContent(false);
		}
	}
	
	
}
