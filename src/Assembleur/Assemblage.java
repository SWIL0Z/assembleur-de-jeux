package Assembleur;

import java.util.Random;

import jeux.AJeux;
import jeux.IJeux;

public abstract class Assemblage extends AJeux {
	private IJeux jeu1;
	private IJeux jeu2;
	
	public Assemblage(Bibliothèque bibli) {
		this.piocherJeux(bibli);
	}
	
	public IJeux getJeu1() {
		return this.jeu1;
	}
	public IJeux getJeu2() {
		return this.jeu2;
	}
	public void setJeu1(IJeux nvJeu) {
		this.jeu1 = nvJeu;
	}
	public void setJeu2(IJeux nvJeu) {
		this.jeu2 = nvJeu;
	}
	
	public void piocherJeux(Bibliothèque bibli) {
		int nb1 = (new Random()).nextInt(bibli.getNombreDeJeux());
		int nb2 = nb1;
		this.jeu1 = bibli.getJeux().get(nb1);
		while (nb1 == nb2) {
			nb2 = (new Random()).nextInt(bibli.getNombreDeJeux());
		}
		this.jeu2 = bibli.getJeux().get(nb2);
	}
	
	public boolean lancerJeu1() {
		return jeu1.jouer();
	}
	public boolean lancerJeu2() {
		return jeu2.jouer();
	}
}
