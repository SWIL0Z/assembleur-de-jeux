package jeux.suites;

import java.math.BigInteger;

public class SuiteG�om�trique extends SuiteArithm�tique {

	public SuiteG�om�trique(int min, int max) {
		super(min, max);
	}

	@Override
	protected BigInteger suivant(BigInteger courant) {
		return courant.multiply(raison());
	}
}
