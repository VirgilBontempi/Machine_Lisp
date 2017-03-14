package model;

public abstract class Atome implements SExpr {
	
	@Override
	public SExpr car() throws LispException {
		throw new LispException("Un Atome n'a pas de car.");
	}

	@Override
	public SExpr cdr() throws LispException {
		throw new LispException("Un Atome n'a pas de cdr.");
	}

	@Override
	public boolean eq(SExpr sExpr) { return this == sExpr; }

	@Override
	public boolean atom() { return true; }

	@Override
	public boolean isNil() { return false; }

	@Override
	public boolean isSymbole() { return false; }

	@Override
	public boolean isCons() { return false; }
}
