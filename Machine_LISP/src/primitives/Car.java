package primitives;

import model.LispException;
import model.Liste;
import model.SExpr;
import model.Subr;

public class Car extends Subr {

	@Override
	public SExpr apply(SExpr foncteur, SExpr parametre) {
		if (!(parametre.isCons() && ((Liste) parametre).size() == 1))
			throw new LispException("Paramètes CAR violés");
		return parametre.car().car();
	}
}
