package jeux.suites;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jeux.AJeux;

public class AppliSuite extends AJeux{
	public static boolean main(String[] args) {
		List<Suite> suites = Arrays.asList(
				  new SuiteMystère()
					, new SuiteArithmétique(1, 10)
					, new SuiteArithmétique(7, 25)
					, new SuiteGéométrique(1, 10)
					, new SuiteGéométrique(7, 25)
				);
		Random r = new Random();
		Suite suite = suites.get(r.nextInt(suites.size()));
		final int NB = args.length > 0 && args[0].equals("-hard") ? 3 : 4;
		List<BigInteger> termes = suite.premiersTermes(NB + 1);
		BigInteger aTrouver = termes.remove(NB);
		System.out.println("Trouvez l'entier qui suit logiquement la suite suivante : " + termes);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BigInteger valeur = new BigInteger(sc.next()); // peut lever NumberFormatException
		if (valeur.equals(aTrouver)) {
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
