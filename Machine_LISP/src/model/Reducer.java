package model;

public abstract class Reducer implements _Reducer {

	@Override
	public SExpr reduction(SExpr foncteur, SExpr parametre) {
		return apply(foncteur, evalArgs(parametre));

	}

	protected abstract SExpr evalArgs(SExpr largs);

	@Override
	public SExpr apply(SExpr foncteur, SExpr parametre) {
		try {
			Context.bind(foncteur.cdr().car(), parametre);
			return foncteur.cdr().cdr().car().eval();
		} finally {
			Context.unbind();
		}
	}
}
