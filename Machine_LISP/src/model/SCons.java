package model;

public class SCons implements Liste {

	private SExpr car;
	private SExpr cdr;

	/**
	 * Constructeur de SCons à partir d'un car et d'un cdr
	 * 
	 * @param car
	 * @param cdr
	 */
	public SCons(SExpr car, SExpr cdr) {
		this.car = car;
		this.cdr = cdr;
	}

	/**
	 * Constructeur de SConsà partir d'un SCons
	 * 
	 * @param sCons
	 */
	public SCons(SCons sCons) {
		this.car = sCons.car();
		this.cdr = sCons.cdr();
	}

	@Override
	public SExpr car() throws LispException { return car; }

	@Override
	public SExpr cdr() throws LispException { return cdr; }

	@Override
	public boolean eq(SExpr sExpr) { return this == sExpr; }

	@Override
	public boolean atom() { return false; }

	@Override
	public boolean isNil() { return false; }

	@Override
	public boolean isSymbole() { return false; }

	@Override
	public boolean isCons() { return true; }

	@Override
	public String toString() { return "(" + this.toString(this) + ")"; }

	/**
	 * TODO FAIRE LA JDOC
	 * @param sExpr
	 * @return
	 */
	private String toString(SExpr sExpr) {
		String chaine = sExpr.car().toString() + " ";
		
		while(!sExpr.atom()) {
			if(sExpr.cdr().atom()) {
				chaine += ". " + sExpr.cdr().toString() + " ";
			}
			else {
			chaine += sExpr.car().toString() + " ";
			}
			sExpr = sExpr.cdr();
		}
		return chaine.substring(0,chaine.length()-1);
	}
}
