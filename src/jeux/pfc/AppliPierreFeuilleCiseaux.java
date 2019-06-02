package jeux.pfc;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import jeux.AJeux;

public class AppliPierreFeuilleCiseaux extends AJeux{
	enum Choix {
		Pierre, Feuille, Ciseaux;
				
		public boolean estPlusFortQue(Choix c) {
			switch (this) {
			case Pierre : return c == Choix.Ciseaux;
			case Feuille : return c == Choix.Pierre;
			case Ciseaux : return c == Choix.Feuille;
			}
			return false;
		}
	}
	
	public static boolean main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		final int MAX = 3;
		int moi = 0; 
		int vous = 0;
		System.out.println("On joue � " + Arrays.toString(Choix.values()));
		System.out.println("Le premier de nous deux qui remporte " + MAX + " manches gagne la partie");
		while (vous < MAX && moi < MAX) {
			Choix mien = Choix.values()[r.nextInt(Choix.values().length)];
			System.out.println("Donnez votre choix et je vous montrerais celui que j'ai d�j� fait : ");
			try {
				Choix sien = Choix.valueOf(s.next());
				System.out.println("j'ai jou� " + mien);
				if (sien.estPlusFortQue(mien))
					++vous;
				else if (mien.estPlusFortQue(sien))
					++moi;
			}
			catch (IllegalArgumentException e) { // lev�e par Choix.valueOf(..) ci-dessus.
				System.out.println("ce n'est pas un coup l�gal, vous devez choisir parmi " + Arrays.toString(Choix.values()));
			}
			System.out.println("vous avez " + vous + " point(s) et moi " + moi + " point(s)");
		}
		if (vous > moi) {
			System.out.println("Bravo");
			return true;
		}
		else {
			System.out.println("Dommage");
			return false;
		}
	}
	
	@Override
	public boolean jouer() {
		try{
			boolean play = main(null);
			return play;
		}
		catch(Exception e) {
			return true;
		}
	}
	
}
