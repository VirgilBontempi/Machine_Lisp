package model;

public interface SExpr {
	/**
	 * Retourne le car d'une SExpr
	 * @return
	 * @throws LispException
	 */
	public SExpr car() throws LispException;
	
	/**
	 * Retourne le cdr d'une SExpr
	 * @return
	 * @throws LispException
	 */
	public SExpr cdr() throws LispException;
	
	/**
	 * Retourne vrai si les éléments sont identiques (==)
	 * @param sExpr
	 * @return
	 */
	public boolean eq(SExpr sExpr);
	
	/**
	 * Retourne vrai si l'élément est un atome
	 * @return
	 */
	public boolean atom();
	
	/**
	 * Retourne vrai si l'élément est vide
	 * @return
	 */
	public boolean isNil();
	
	/**
	 * Retourne vrai si l'élément est un symbole
	 * @return
	 */
	public boolean isSymbole();
	
	/**
	 * Retourne vrai si l'élément est non vide
	 * @return
	 */
	public boolean isCons();
}
