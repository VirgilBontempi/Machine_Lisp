package primitives;

import model.Fsubr;
import model.LispException;
import model.Liste;
import model.SCons;
import model.SExpr;

public class Cons extends Fsubr {

	@Override
	public SExpr apply(SExpr foncteur, SExpr parametre) {
		if (!(parametre.isCons() && ((Liste) parametre).size() == 2))
			throw new LispException("Paramètes CONS violés");
		return new SCons(parametre.cdr().car(), parametre.cdr().cdr());
	}
	
	public static final Cons CONS = new Cons();
}
