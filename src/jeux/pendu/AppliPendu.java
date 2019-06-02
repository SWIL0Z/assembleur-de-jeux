package jeux.pendu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import jeux.AJeux;

public class AppliPendu extends AJeux{
	public static boolean main(String[] args) {
		final int MAX = args.length > 0 && args[0].equals("-hard") ? 10 : 8;
		final int MIN = args.length > 0 && args[0].equals("-hard") ? 6 : 4;
		String zipName = "ressources/pendu/francais.zip";
		String entryName = "francais.txt";
		List<String> mots = new ArrayList<>();

		try (ZipFile zipFile = new ZipFile(zipName)) {
			ZipEntry entry = zipFile.getEntry(entryName);
			Stream<String> lines = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry), StandardCharsets.ISO_8859_1)).lines();
			mots = lines
					.filter(mot -> MIN <= mot.length() && mot.length() <= MAX)
					.collect(Collectors.toList());
		}
		catch (IOException | NullPointerException e) {
			System.out.println("le fichier des mots français " + zipName + " est inaccessible");
			return true;
		}
		Random r = new Random();
		Pendu p = new Pendu(mots.get(r.nextInt(mots.size())));
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Découvrez le mot en moins de " + Pendu.NB_MAX_ERREURS + " erreurs");
		System.out.println(p);
		while (!p.fini()) {
			System.out.print("Entrez une lettre : ");
			char c = sc.next().toUpperCase().charAt(0);
			p.jouer(c);
			System.out.println(p);
		}
		if (p.gagné()) {
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
