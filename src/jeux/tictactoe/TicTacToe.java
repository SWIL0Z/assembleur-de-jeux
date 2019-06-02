package jeux.tictactoe;

import java.util.Arrays;
import java.util.List;

public class TicTacToe {
	public enum Pi�ce {
		ROND, CROIX;

		@Override
		public String toString() {
			if (this == ROND)
				return "O";
			return "X";
		}
	}

	public static final int NB = 3;
	private Pi�ce[][] plateau;

	public TicTacToe() {
		plateau = new Pi�ce[NB][NB];
		for (Pi�ce[] ligne : plateau)
			Arrays.fill(ligne, null);
	}

	public boolean estVide(Coord c) {
		return plateau[c.ligne][c.col] == null;
	}

	public void poser(Coord c, Pi�ce p) {
		if (!estVide(c) || p == null)
			throw new IllegalArgumentException();
		plateau[c.ligne][c.col] = p;
	}

	public boolean fini() {
		if (gagnant() != null)
			return true;
		for (Pi�ce[] ligne : plateau)
			for (Pi�ce p : ligne)
				if (p == null)
					return false;
		return true;
	}
	
	private Pi�ce alignement(Coord origine, Coord direction) {
		if (estVide(origine))
			return null;
		Pi�ce p = plateau[origine.ligne][origine.col];
		Coord c = origine.plus(direction);
		for (int i = 1; i < NB; ++i, c = c.plus(direction)) 
			if (plateau[c.ligne][c.col] != p)
				return null;
		return p;
	}

	public Pi�ce gagnant() {
		List<List<Coord>> dirs = Arrays.asList(
				//              origine          direction
				  Arrays.asList(new Coord(0, 0), new Coord(0, 1))
				, Arrays.asList(new Coord(1, 0), new Coord(0, 1))
				, Arrays.asList(new Coord(2, 0), new Coord(0, 1))
				, Arrays.asList(new Coord(0, 0), new Coord(1, 0))
				, Arrays.asList(new Coord(0, 1), new Coord(1, 0))
				, Arrays.asList(new Coord(0, 2), new Coord(1, 0))
				, Arrays.asList(new Coord(0, 0), new Coord(1, 1))
				, Arrays.asList(new Coord(NB - 1, 0), new Coord(-1, 1))
				);
		for (List<Coord> d : dirs) {
			Pi�ce p = alignement(d.get(0), d.get(1));
			if (p != null)
				return p;
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Pi�ce[] ligne : plateau) {
			for (Pi�ce p : ligne)
				s.append((p == null ? "." : p) + " ");
			s.append(System.lineSeparator());
		}
		return s.toString();
	}
}
