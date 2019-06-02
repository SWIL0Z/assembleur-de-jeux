package Application;

import java.util.Scanner;

import Assembleur.AssemCas1;
import Assembleur.AssemCas2;
import Assembleur.AssemCas3;
import Assembleur.AssemCas4;
import Assembleur.Assemblage;
import Assembleur.Bibliothèque;

public class appli {

	public static void main(String[] args) {
		Bibliothèque bibliothèque = new Bibliothèque();
		int cas;
		Assemblage assem;
		boolean jeu;
		while (true) {
			instructions();
			cas = choixCas();
			assem = lancerAssemblage(bibliothèque, cas);
			System.out.println("Maintenant, jouons ! Bonne chance.");
			System.out.println("");
			jeu = assem.jouer();
			if (jeu == true) {
				System.out.println("Félicitations, vous avez réussi à remporter l'assemblage !");
			}
			else {
				System.out.println("Oups... Vous n'avez pas réussi à remporter l'assemblage. Dommage.");
			}
			if (testReplay() == false) {
				System.out.println("");
				System.out.println("Merci d'avoir joué avec nous, à bientôt !");
				break;
			}
			System.out.println("");
		}
		
	}

	public static void instructions() {
		System.out.println("Bienvenue dans l'assembleur de jeux de société !");
		System.out.println("Vous avez quatre types d'assemblage possibles :");
		System.out.println("  - Cas 1 : j1 puis j2 doivent être gagnés");
		System.out.println("  - Cas 2 : j1 doit être remporté sinon j2 doit l'être");
		System.out.println("  - Cas 3 : j1 doit être remporté en au plus n essais");
		System.out.println("  - Cas 4 : j1 doit être joué jusqu'à être gagné");
		System.out.println("");
	}
	public static int choixCas() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int cas = 0;
		System.out.print("Choisissez un cas : ");
		cas = sc.nextInt();
		while (cas < 1 || cas > 4) {
			System.out.print("Veuillez rentrer un cas correct : ");
			cas = sc.nextInt();
		}
		System.out.println("");
		return cas;
	}
	public static Assemblage lancerAssemblage(Bibliothèque bibli, int cas) {
		switch(cas) {
			case 1 :
				AssemCas1 assem1 = new AssemCas1(bibli);
				return assem1;
			case 2 :
				AssemCas2 assem2 = new AssemCas2(bibli);
				return assem2;
			case 3 :
				AssemCas3 assem3 = new AssemCas3(bibli);
				return assem3;
			case 4 :
				AssemCas4 assem4 = new AssemCas4(bibli);
				return assem4;
			default :
				return null;
		}
	}
	public static boolean testReplay() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String entry = "";

		while(!entry.equalsIgnoreCase("oui") && !entry.equalsIgnoreCase("non")) {
			System.out.println("Voulez vous rejouer ? [oui / non]");
			entry = sc.next().trim();
		}
		if (entry.equalsIgnoreCase("oui"))
			return true;
		else
			return false;
	}
}
