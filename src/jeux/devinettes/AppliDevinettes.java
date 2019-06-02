package jeux.devinettes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jeux.AJeux;

public class AppliDevinettes extends AJeux{
	public static boolean main(String[] args) {
		List<List<String>> devinettes = Arrays.asList( 
				  Arrays.asList("Je suis entre 188 et 190, mais je ne suis pas 189. Qui suis-je ?", "et")
				, Arrays.asList("J'ai une serrure mais pas de porte. Qui suis-je ?", "cadenas")
				, Arrays.asList("Qu'est-ce qui t'appartient mais que les autres utilisent plus que toi ?", "pr�nom", "prenom")
				, Arrays.asList("Je rentre toujours la premi�re et sors toujours la derni�re, qui suis-je ?", "cl�", "clef")
				, Arrays.asList("Appr�ci�s en amour, les gros, eux, sont � �viter. Les auteurs en ont de fameux, et certains servent pour des jeux. Qui sont-ils ?", "mots")
				, Arrays.asList("Lorsque l'on me nomme, je n�existe plus. Qui suis-je ?", "silence")
				, Arrays.asList("Combien de gouttes d'eau peut-on mettre dans un verre vide ?", "une")
				);
		Random r = new Random();
		List<String> q = devinettes.get(r.nextInt(devinettes.size()));
		System.out.println(q.get(0));
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String r�ponse = sc.nextLine().toLowerCase();
		for (int i = 1; i < q.size(); ++i)
			if (r�ponse.contains(q.get(i))) {
				System.out.println("Bravo");
				return true;
			}
		System.out.println("Dommage");
		return false;
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
