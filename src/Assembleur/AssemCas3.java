package Assembleur;

public class AssemCas3 extends Assemblage {
	
	public AssemCas3(Bibliothèque bibli) {
		super(bibli);
		this.setJeu2(null);
		this.setNbMaxEssais(this.getJeu1().getNbMaxEssais());
		
	}

	@Override
	public boolean jouer() {
		System.out.println("");
		System.out.println("Vous avez un total de " + this.getJeu1().getNbMaxEssais() + " essais pour remporter cet assemblage");
		System.out.println("");
		boolean j = false;
		for (int cpt = 0; cpt < this.getJeu1().getNbMaxEssais(); cpt++) {
			j = this.lancerJeu1();
			if (j == true) {
				return true;
			}
		}
		return false;
	}
	
}
