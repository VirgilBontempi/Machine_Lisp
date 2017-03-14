package model;

import java.util.HashMap;

public class Symbole extends Atome {

	private String caractere;
	
	private static HashMap<String, Symbole> table = new HashMap<>();
	
	/**
	 * Constructeur de Symbole, à partir d'une chaine.
	 * @param chaine
	 */
	private Symbole(String chaine) {
		// TODO Auto-generated constructor stub
		this.caractere = chaine;
	}
	
	/**
	 * Si le symbole existe dans la table, retourne ce Symbole.
	 * Sinon, insère un nouveau Symbole associé à la chaine dans la table et le retourne.
	 * @param chaine
	 * @return le symbole créé ou trouvé
	 */
	public static Symbole newSymbole(String chaine) {
		if(!table.containsKey(chaine)) {
			table.put(chaine, new Symbole(chaine));
		}
		return table.get(chaine);
	}
	
	
	
	@Override
	public SExpr car() throws LispException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SExpr cdr() throws LispException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eq(SExpr sExpr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNil() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSymbole() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCons() {
		// TODO Auto-generated method stub
		return false;
	}

}
