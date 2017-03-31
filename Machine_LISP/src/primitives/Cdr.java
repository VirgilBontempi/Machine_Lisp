package primitives;

import model.LispException;
import model.Liste;
import model.SExpr;
import model.Subr;

public class Cdr extends Subr {

	@Override
	public SExpr apply(SExpr foncteur, SExpr parametre) {
		if (!(parametre.isCons() && ((Liste) parametre).size() == 1))
			throw new LispException("Paramètes CDR violés");
		return parametre.cdr().car();
	}

	public static final Cdr CDR = new Cdr();
}
