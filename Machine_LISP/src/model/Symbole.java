package model;

import java.util.HashMap;

public class Symbole extends Atome {

	private String caractere;

	private static HashMap<String, Symbole> table = new HashMap<>();

	/**
	 * Constructeur de Symbole, à partir d'une chaine.
	 * 
	 * @param chaine
	 */
	private Symbole(String chaine) {
		this.caractere = chaine;
	}

	/**
	 * Si le symbole existe dans la table, retourne ce Symbole. Sinon, insère
	 * un nouveau Symbole associé à la chaine dans la table et le retourne.
	 * 
	 * @param chaine
	 * @return le symbole créé ou trouvé
	 */
	public static Symbole newSymbole(String chaine) {
		if (!table.containsKey(chaine)) {
			table.put(chaine, new Symbole(chaine));
		}
		return table.get(chaine);
	}

	@Override
	public boolean isSymbole() {
		return true;
	}

	/**
	 * TODO FAIRE LA JDOC
	 */
	public String toString() {
		return this.caractere;
	}

	@Override
	public SExpr eval() throws LispException {
		// TODO Auto-generated method stub
		return null;
	}
}
