package jeux.intrus;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jeux.AJeux;

public class AppliIntrus extends AJeux{
	private static class Question {
		public final List<String> mots;
		public final int intrus;

		public Question(List<String> mots, int intrus) {
			if (mots == null || intrus < 1 || intrus > mots.size())
				throw new IllegalArgumentException();
			this.mots = mots;
			this.intrus = intrus;
		}
	}
	
	public static boolean main(String[] args) {
		List<Question> questions = Arrays.asList(
				new Question(Arrays.asList("pomme", "ananas", "poisson", "citron"), 3)
				, new Question(Arrays.asList("fer", "igloo", "acier", "brique"), 2)
				, new Question(Arrays.asList("eau", "lait", "jus", "fruit"), 4)
				, new Question(Arrays.asList("chien", "table", "porte", "mur"), 1)
				, new Question(Arrays.asList("chat", "girafe", "baleine", "histoire", "�l�phant"), 4)
				, new Question(Arrays.asList("stylo", "�tiquette", "pinceau", "crayon"), 2)
				, new Question(Arrays.asList("beau", "belle", "gentil", "lit", "agr�able"), 4)
				, new Question(Arrays.asList("dormir", "manger", "particulier", "r�ver"), 3)
				, new Question(Arrays.asList("photo", "image", "poster", "carton"), 4)
				, new Question(Arrays.asList("plume", "dune", "poil", "duvet"), 2)
				);
		Random r = new Random();
		Question q = questions.get(r.nextInt(questions.size()));
		System.out.println("Donnez le num�ro de l'intrus parmi les mots qui suivent");
		int i = 0;
		for (String m : q.mots)	
			System.out.println((++i) + " : " + m);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		try {
			int intrus = sc.nextInt();
			if (intrus == q.intrus) {
				System.out.println("Bravo");
				return true;
			}
			else {
				System.out.println("Dommage");
			return false;
			}
		}
		catch (Exception e) {
			System.out.println("Rat�");
		}
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
