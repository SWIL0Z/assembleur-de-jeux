package Assembleur;

public class AssemCas4 extends Assemblage {

	public AssemCas4(Bibliothèque bibli) {
		super(bibli);
		this.setNbMaxEssais(this.getJeu1().getNbMaxEssais());
		this.setJeu2(null);
	}

	@Override
	public boolean jouer() {
		boolean essai = false;
		while (essai == false) {
			essai = this.lancerJeu1();
		}
		return essai;
	}
	
	
}
