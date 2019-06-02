package jeux.tictactoe;

import jeux.AJeux;
import jeux.tictactoe.TicTacToe.Pi�ce;
import static jeux.tictactoe.TicTacToe.Pi�ce.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AppliTicTacToe extends AJeux{
	public static boolean main(String[] args) {
		TicTacToe tic = new TicTacToe();
		Pi�ce j = ROND;
		System.out.println(tic);
		while (!tic.fini()) {
			Coord c;
			if (j == ROND)
				c = saisie(tic);
			else
				c = choixAl�atoire(tic);
			tic.poser(c, j);
			System.out.println(tic);
			j = j == ROND ? CROIX : ROND;
		}
		j = tic.gagnant();
		if (j == null) {
			System.out.println("Match nul");
			return false;
		}
		else if (j == ROND) {
			System.out.println("Bravo");
			return true;
		}
		else {
			System.out.println("Dommage");
			return false;
		}
			
	}

	private static Coord choixAl�atoire(TicTacToe tic) {
		ArrayList<Coord> coords = new ArrayList<>();
		for (int li = 0; li < TicTacToe.NB; ++li)
			for (int co = 0; co < TicTacToe.NB; ++co) {
				Coord c = new Coord(li, co);
				if (tic.estVide(c))
					coords.add(c);
			}
		Random r = new Random();
		return coords.get(r.nextInt(coords.size()));
	}

	private static Coord saisie(TicTacToe tic) {
		System.out.println("Entrez le num�ro (compris entre 0 et " + (TicTacToe.NB - 1) + ") de ligne suivi du num�ro de colonne o� placer votre pi�ce.");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				int li, co;
				li = sc.nextInt();
				co = sc.nextInt();
				if (li >= 0 && li < TicTacToe.NB && co >= 0 && co < TicTacToe.NB)
					return new Coord(li, co);
			} catch (Exception e) {
			}
			System.out.println("Rat�, veuillez essayer � nouveau");
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
