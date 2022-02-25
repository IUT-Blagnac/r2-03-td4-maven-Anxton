package test;

import lesschtroumpfs.Village;

public class MainVillage {

	public static void main (String[] argv) {
		// 4.3.1.
		// 5.
		String[] nomsSchtroumpfs = {
		        "Grand Schtroumpf", "Schtroumpf courant (et pas ordinaire)", "Schtroumpf ordinaire (et pas courant)", "Schtroumpf moralisateur à lunettes",
		        "Schtroumpf boudeur", "Schtroumpf volant", "Schtroumpf étonné", "Schtroumpf acrobate", "Schtroumpf paresseux"
		};
		
		Village vil;
		vil = new Village("Agopidoras", 30, nomsSchtroumpfs);
		vil.solstice_d_ete();
		
		// 4.3.2.
		// 4.
		System.out.println("\nChef du village :");
		vil.chefDuVillage().sePresenter();
		vil.envoyerAuTravail();
		vil.schtroumpsfHeureux();
		
		// 5.2
		System.out.println("\n5.2\n");
		vil.solstice_d_ete();
		vil.envoyerCueillirSalsepareille();
		vil.solstice_d_ete();
		vil.dinerTousEnsemble();
		vil.solstice_d_ete();		
	}

}
