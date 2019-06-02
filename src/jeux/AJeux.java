package jeux;

public abstract class AJeux implements IJeux {

	private int nbMaxEssais = 3;

	@Override
	public int getNbMaxEssais() {
		return this.nbMaxEssais;
	}

	@Override
	public void setNbMaxEssais(int nvNb) {
		this.nbMaxEssais = nvNb;
	}

}
