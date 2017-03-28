package model;

public abstract class Primitive extends Atome implements _Reducer {
//		if(!sExpr.cdr().isNil()){
//			return new Fsubr(sExpr) ;
//		}
//	}
	@Override
	public SExpr reduction(SExpr foncteur, SExpr parametre) {
		return apply(foncteur,evalArgs(parametre));
		
	}
	protected abstract SExpr evalArgs(SExpr largs); // TODO QUESTION AU PROF : Pourquoi on définit pas evalargs ici ?
}
