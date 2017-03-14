package model;

public class SCons implements Liste {

	private SExpr car;
	private SExpr cdr;
	
	/**
	 * Constructeur de SCons à partir d'un car et d'un cdr
	 * @param car
	 * @param cdr
	 */
	public SCons(SExpr car, SExpr cdr) {
		this.car = car;
		this.cdr = cdr;
	}
	
	/**
	 * Constructeur de SConsà partir d'un SCons
	 * @param sCons
	 */
	public SCons(SCons sCons) {
		this.car = sCons.car();
		this.cdr = sCons.cdr(); 
	}
	
	@Override
	public SExpr car() throws LispException {
		return car;
	}
	@Override
	public SExpr cdr() throws LispException {
		return cdr;
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
