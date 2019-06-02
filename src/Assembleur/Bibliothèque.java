package Assembleur;

import java.util.ArrayList;
import java.util.List;
import jeux.IJeux;
import jeux.crazy.AppliCrazy;
import jeux.devinettes.AppliDevinettes;
import jeux.intrus.AppliIntrus;
import jeux.pendu.AppliPendu;
import jeux.pfc.AppliPierreFeuilleCiseaux;
import jeux.pppg.AppliPlusPetitPlusGrand;
import jeux.suites.AppliSuite;
import jeux.tictactoe.AppliTicTacToe;

public class Bibliothèque {
	private List<IJeux> jeux;
	
	public Bibliothèque() {
		this.jeux = new ArrayList<IJeux>();
		this.jeux.add(new AppliPierreFeuilleCiseaux());
		this.jeux.add(new AppliPlusPetitPlusGrand());
		this.jeux.add(new AppliCrazy());
		this.jeux.add(new AppliDevinettes());
		this.jeux.add(new AppliIntrus());
		this.jeux.add(new AppliPendu());
		this.jeux.add(new AppliSuite());
		this.jeux.add(new AppliTicTacToe());
	}
	
	public List<IJeux> getJeux(){
		return this.jeux;
	}
	public int getNombreDeJeux() {
		return this.jeux.size();
	}
	
	public void ajouterJeu(IJeux jeu) {
		this.jeux.add(jeu);
	}
}
