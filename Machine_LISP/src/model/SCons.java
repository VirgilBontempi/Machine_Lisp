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
	public String toString() { return "(" + this.toString((SExpr)this) + ")"; }

	/**
	 * TODO FAIRE LA JDOC
	 * @param sExpr
	 * @return
	 */
	private String toString(SExpr sExpr) {
		if(sExpr.cdr().isNil()) return sExpr.car().toString();
		if(sExpr.cdr().atom()) return sExpr.car().toString()+ " . " + sExpr.cdr().toString();
		return sExpr.car().toString() +" "+ toString(sExpr.cdr())	;
	}

	@Override
	public SExpr eval() throws LispException {
		// TODO Auto-generated method stub
		SExpr retourEval = car.eval();
		
		if(retourEval instanceof Primitive) {
			return ((Primitive) retourEval).reduction(retourEval, this.cdr());
		}
		else {
			if(retourEval.car().eq(Symbole.newSymbole("lambda"))) {
				return Expr.expr.reduction(retourEval, retourEval.cdr());
			}
			else if (retourEval.car().eq(Symbole.newSymbole("flambda"))) {
				return Fexpr.fexpr.reduction(retourEval, retourEval.cdr());
			}
			else {
				throw new LispException("Exception eval CONS");
			}
		}
	}

	@Override
	public int size() {
		SExpr cur = this;
		int cpt=0;
		while(!cur.isNil()){
			cpt++;
			cur=cur.cdr();
		}
		return cpt;
	}

}
