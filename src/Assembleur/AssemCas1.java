package Assembleur;

public class AssemCas1 extends Assemblage {
	
	public AssemCas1(Bibliothèque bibli) {
		super(bibli);
		this.setNbMaxEssais((this.getJeu1().getNbMaxEssais() > this.getJeu2().getNbMaxEssais()) ? this.getJeu1().getNbMaxEssais() : this.getJeu2().getNbMaxEssais());
		bibli.ajouterJeu(this);
		System.out.println("L'assemblage a été ajouté à la bibliothèque pour cette session.");
	}

	@Override
	public boolean jouer() {
		boolean j = false;
		while(j == false) {
			j = this.lancerJeu1();
		}
		j = false;
		while (j == false) {
			j = this.lancerJeu2();
		}
		return true;
	}

}
